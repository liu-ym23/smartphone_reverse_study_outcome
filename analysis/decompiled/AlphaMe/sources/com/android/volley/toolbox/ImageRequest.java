package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;

/* loaded from: classes.dex */
public class ImageRequest extends Request<Bitmap> {
    private static final float IMAGE_BACKOFF_MULT = 2.0f;
    private static final int IMAGE_MAX_RETRIES = 2;
    private static final int IMAGE_TIMEOUT_MS = 1000;
    private static final Object sDecodeLock = new Object();
    private final Bitmap.Config mDecodeConfig;
    private final Response.Listener<Bitmap> mListener;
    private final int mMaxHeight;
    private final int mMaxWidth;
    private ImageView.ScaleType mScaleType;

    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i4, int i5, ImageView.ScaleType scaleType, Bitmap.Config config, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, IMAGE_BACKOFF_MULT));
        this.mListener = listener;
        this.mDecodeConfig = config;
        this.mMaxWidth = i4;
        this.mMaxHeight = i5;
        this.mScaleType = scaleType;
    }

    private Response<Bitmap> doParse(NetworkResponse networkResponse) {
        Bitmap bitmapCreateScaledBitmap;
        byte[] bArr = networkResponse.data;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.mMaxWidth == 0 && this.mMaxHeight == 0) {
            options.inPreferredConfig = this.mDecodeConfig;
            bitmapCreateScaledBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            int resizedDimension = getResizedDimension(this.mMaxWidth, this.mMaxHeight, i4, i5, this.mScaleType);
            int resizedDimension2 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, i5, i4, this.mScaleType);
            options.inJustDecodeBounds = false;
            options.inSampleSize = findBestSampleSize(i4, i5, resizedDimension, resizedDimension2);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray == null || (bitmapDecodeByteArray.getWidth() <= resizedDimension && bitmapDecodeByteArray.getHeight() <= resizedDimension2)) {
                bitmapCreateScaledBitmap = bitmapDecodeByteArray;
            } else {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, resizedDimension, resizedDimension2, true);
                bitmapDecodeByteArray.recycle();
            }
        }
        return bitmapCreateScaledBitmap == null ? Response.error(new ParseError(networkResponse)) : Response.success(bitmapCreateScaledBitmap, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }

    public static int findBestSampleSize(int i4, int i5, int i6, int i7) {
        double dMin = Math.min(i4 / i6, i5 / i7);
        float f4 = 1.0f;
        while (true) {
            float f5 = IMAGE_BACKOFF_MULT * f4;
            if (f5 > dMin) {
                return (int) f4;
            }
            f4 = f5;
        }
    }

    private static int getResizedDimension(int i4, int i5, int i6, int i7, ImageView.ScaleType scaleType) {
        if (i4 == 0 && i5 == 0) {
            return i6;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i4 == 0 ? i6 : i4;
        }
        if (i4 == 0) {
            return (int) (i6 * (i5 / i7));
        }
        if (i5 == 0) {
            return i4;
        }
        double d4 = i7 / i6;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d5 = i5;
            return ((double) i4) * d4 < d5 ? (int) (d5 / d4) : i4;
        }
        double d6 = i5;
        return ((double) i4) * d4 > d6 ? (int) (d6 / d4) : i4;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // com.android.volley.Request
    public Response<Bitmap> parseNetworkResponse(NetworkResponse networkResponse) {
        Response<Bitmap> responseDoParse;
        synchronized (sDecodeLock) {
            try {
                try {
                    responseDoParse = doParse(networkResponse);
                } catch (OutOfMemoryError e4) {
                    VolleyLog.e("Caught OOM for %d byte image, url=%s", Integer.valueOf(networkResponse.data.length), this.getUrl());
                    return Response.error(new ParseError(e4));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return responseDoParse;
    }

    @Override // com.android.volley.Request
    public void deliverResponse(Bitmap bitmap) {
        this.mListener.onResponse(bitmap);
    }

    @Deprecated
    public ImageRequest(String str, Response.Listener<Bitmap> listener, int i4, int i5, Bitmap.Config config, Response.ErrorListener errorListener) {
        this(str, listener, i4, i5, ImageView.ScaleType.CENTER_INSIDE, config, errorListener);
    }
}
