package com.stepos.activeview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UpdaterUtils {
    private static final String LOG_TAG = "UpdaterUtils";
    private static volatile UpdaterUtils updaterUtilsInstance;
    private Context mContext;
    private ImageLoader mImageLoader;
    private RequestQueue mQueue;

    public class BitmapCache implements ImageLoader.ImageCache {
        public BitmapCache(UpdaterUtils updaterUtils) {
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageCache
        public Bitmap getBitmap(String str) {
            return ImageCacheUtils.getInstance().getBitmapFromImageCache(str);
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageCache
        public void putBitmap(String str, Bitmap bitmap) {
            ImageCacheUtils.getInstance().putBitmapToImageCache(str, bitmap);
        }
    }

    public interface OnLoadListener {
        public static final int LOADIMAGE_FAIL = 0;
        public static final int LOADIMAGE_SUCESS = 1;

        void onLoadError(int i4, String str);

        void onLoadFinished(int i4, Bitmap bitmap);
    }

    private UpdaterUtils(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        RequestQueue requestQueueNewRequestQueue = Volley.newRequestQueue(applicationContext);
        this.mQueue = requestQueueNewRequestQueue;
        this.mImageLoader = new ImageLoader(requestQueueNewRequestQueue, new BitmapCache(this));
    }

    public static UpdaterUtils getInstance(Context context) {
        if (updaterUtilsInstance == null) {
            synchronized (UpdaterUtils.class) {
                try {
                    if (updaterUtilsInstance == null) {
                        updaterUtilsInstance = new UpdaterUtils(context);
                    }
                } finally {
                }
            }
        }
        return updaterUtilsInstance;
    }

    public ImageLoader.ImageListener getImageListener(final ImageView imageView, final int i4, final int i5, final OnLoadListener onLoadListener) {
        return new ImageLoader.ImageListener() { // from class: com.stepos.activeview.utils.UpdaterUtils.2
            BitmapDrawable bitmapDrawable = null;
            Resources res;

            {
                this.res = UpdaterUtils.this.mContext.getResources();
            }

            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                LogUtil.e(UpdaterUtils.LOG_TAG, "onErrorResponse error=" + volleyError.toString());
                int i6 = i5;
                if (i6 != 0) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.res, i6);
                    if (bitmapDecodeResource != null) {
                        this.bitmapDrawable = new BitmapDrawable(this.res, bitmapDecodeResource);
                    }
                    BitmapDrawable bitmapDrawable = this.bitmapDrawable;
                    if (bitmapDrawable != null) {
                        imageView.setImageDrawable(bitmapDrawable);
                    }
                }
                OnLoadListener onLoadListener2 = onLoadListener;
                if (onLoadListener2 != null) {
                    onLoadListener2.onLoadError(0, volleyError.toString());
                }
            }

            @Override // com.android.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z4) {
                LogUtil.e(UpdaterUtils.LOG_TAG, "onResponse isImmediate=" + z4);
                if (imageContainer.getBitmap() != null) {
                    Bitmap bitmap = imageContainer.getBitmap();
                    if (bitmap != null) {
                        this.bitmapDrawable = new BitmapDrawable(this.res, bitmap);
                    }
                    BitmapDrawable bitmapDrawable = this.bitmapDrawable;
                    if (bitmapDrawable != null) {
                        imageView.setImageDrawable(bitmapDrawable);
                    }
                    OnLoadListener onLoadListener2 = onLoadListener;
                    if (onLoadListener2 != null) {
                        onLoadListener2.onLoadFinished(1, bitmap);
                    }
                    String requestUrl = imageContainer.getRequestUrl();
                    if (CacheUtils.getInstance(UpdaterUtils.this.mContext).isCached(Md5Helper.MD5Encode(requestUrl))) {
                        return;
                    }
                    HashMap map = new HashMap();
                    map.put(ActiveUsageStatsUtils.FILE_URL, requestUrl);
                    ActiveUsageStatsUtils.getInstance().recordEvent(ActiveUsageStatsUtils.EVENT_DOWNLOAD, "", map);
                    CacheUtils.getInstance(UpdaterUtils.this.mContext).saveToSharedPreferences(Md5Helper.MD5Encode(requestUrl), requestUrl);
                    return;
                }
                if (!z4) {
                    OnLoadListener onLoadListener3 = onLoadListener;
                    if (onLoadListener3 != null) {
                        onLoadListener3.onLoadError(0, "Use Default image defaultImageResId=" + i4);
                        return;
                    }
                    return;
                }
                int i6 = i4;
                if (i6 != 0) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.res, i6);
                    if (bitmapDecodeResource != null) {
                        this.bitmapDrawable = new BitmapDrawable(this.res, bitmapDecodeResource);
                    }
                    BitmapDrawable bitmapDrawable2 = this.bitmapDrawable;
                    if (bitmapDrawable2 != null) {
                        imageView.setImageDrawable(bitmapDrawable2);
                    }
                }
            }
        };
    }

    public void getJsonByUrl(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        if (str.isEmpty()) {
            return;
        }
        this.mQueue.add(new JsonObjectRequest(str, (JSONObject) null, listener, errorListener));
    }

    public void getJsonPost(String str, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener) {
        if (str.isEmpty()) {
            return;
        }
        this.mQueue.add(new JsonObjectRequest(this, 1, str, jSONObject, listener, errorListener) { // from class: com.stepos.activeview.utils.UpdaterUtils.1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap map = new HashMap();
                map.put("Accept", "application/json");
                map.put("Content-Type", "application/json; charset=UTF-8");
                return map;
            }
        });
    }

    public void loadImage(ImageView imageView, String str, int i4, int i5) {
        loadImage(imageView, str, i4, i5, null);
    }

    public void loadImage(ImageView imageView, String str, int i4, int i5, OnLoadListener onLoadListener) {
        this.mImageLoader.get(str, getImageListener(imageView, i4, i5, onLoadListener));
    }
}
