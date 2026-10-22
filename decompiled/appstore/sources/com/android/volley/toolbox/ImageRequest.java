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

/* JADX INFO: loaded from: classes.dex */
public class ImageRequest extends Request<Bitmap> {
    public static final float DEFAULT_IMAGE_BACKOFF_MULT = 2.0f;
    public static final int DEFAULT_IMAGE_MAX_RETRIES = 2;
    public static final int DEFAULT_IMAGE_TIMEOUT_MS = 1000;
    private static final Object sDecodeLock = null;
    private final Bitmap.Config mDecodeConfig;
    private final Response.Listener<Bitmap> mListener;
    private final int mMaxHeight;
    private final int mMaxWidth;
    private ImageView.ScaleType mScaleType;

    static {
        sDecodeLock = new Object();
    }

    public ImageRequest(String r10, Response.Listener<Bitmap> r11, int r12, int r13, ImageView.ScaleType r14, Bitmap.Config r15, Response.ErrorListener r16) {
        super(0, r10, r16);
        setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0f));
        this.mListener = r11;
        this.mDecodeConfig = r15;
        this.mMaxWidth = r12;
        this.mMaxHeight = r13;
        this.mScaleType = r14;
    }

    private Response<Bitmap> doParse(NetworkResponse r10) {
        byte[] r11 = r10.data;
        BitmapFactory.Options r12 = new BitmapFactory.Options();
        if (this.mMaxWidth == 0) goto L5;
    L7:
        r12.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(r11, 0, r11.length, r12);
        int r13 = r12.outWidth;
        int r14 = r12.outHeight;
        int r15 = getResizedDimension(this.mMaxWidth, this.mMaxHeight, r13, r14, this.mScaleType);
        int r16 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, r14, r13, this.mScaleType);
        r12.inJustDecodeBounds = false;
        r12.inSampleSize = findBestSampleSize(r13, r14, r15, r16);
        Bitmap r17 = BitmapFactory.decodeByteArray(r11, 0, r11.length, r12);
        if (r17 != null) goto L10;
    L14:
        Bitmap r18 = r17;
    L15:
        if (r18 != null) goto L19;
        return Response.error(new ParseError(r10));
    L19:
        return Response.success(r18, HttpHeaderParser.parseCacheHeaders(r10));
    L10:
        if (r17.getWidth() <= r15) goto L12;
    L13:
        r18 = Bitmap.createScaledBitmap(r17, r15, r16, true);
        r17.recycle();
        goto L15
    L12:
        if (r17.getHeight() <= r16) goto L14;
    L5:
        if (this.mMaxHeight != 0) goto L7;
        r12.inPreferredConfig = this.mDecodeConfig;
        r18 = BitmapFactory.decodeByteArray(r11, 0, r11.length, r12);
        goto L15
    }

    public static int findBestSampleSize(int r10, int r11, int r12, int r13) {
        double r14 = Math.min(((double) r10) / ((double) r12), ((double) r11) / ((double) r13));
        float r15 = 1.0f;
    L3:
        float r16 = 2.0f * r15;
        if (r16 > r14) goto L7;
        r15 = r16;
        goto L3
    L7:
        return (int) r15;
    }

    private static int getResizedDimension(int r10, int r11, int r12, int r13, ImageView.ScaleType r14) {
        if (r10 != 0) goto L6;
        if (r11 != 0) goto L6;
        return r12;
    L6:
        if (r14 != ImageView.ScaleType.FIT_XY) goto L10;
        if (r10 != 0) goto L9;
        return r12;
    L9:
        return r10;
    L10:
        if (r10 == 0) goto L12;
        if (r11 != 0) goto L15;
        return r10;
    L15:
        double r15 = ((double) r13) / ((double) r12);
        if (r14 != ImageView.ScaleType.CENTER_CROP) goto L21;
        double r16 = r11;
        if ((((double) r10) * r15) < r16) goto L20;
        return r10;
    L20:
        return (int) (r16 / r15);
    L21:
        double r17 = r11;
        if ((((double) r10) * r15) > r17) goto L24;
        return r10;
    L24:
        return (int) (r17 / r15);
    L12:
        return (int) (r12 * (((double) r11) / ((double) r13)));
    }

    @Override // com.android.volley.Request
    public /* bridge */ /* synthetic */ void deliverResponse(Bitmap r10) {
        deliverResponse2(r10);
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    @Override // com.android.volley.Request
    public Response<Bitmap> parseNetworkResponse(NetworkResponse r10) {
        Object r11 = sDecodeLock;
        monitor-enter(r11);
        Response<Bitmap> r12 = doParse(r10);     // Catch: Throwable -> L7 OutOfMemoryError -> L9
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L9:
        e = move-exception;
        VolleyLog.e("Caught OOM for %d byte image, url=%s", new Object[]{Integer.valueOf(r10.data.length), getUrl()});     // Catch: Throwable -> L7
        return Response.error(new ParseError(e));
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: deliverResponse, reason: avoid collision after fix types in other method */
    public void deliverResponse2(Bitmap r10) {
        this.mListener.onResponse(r10);
    }

    @Deprecated
    public ImageRequest(String r10, Response.Listener<Bitmap> r11, int r12, int r13, Bitmap.Config r14, Response.ErrorListener r15) {
        this(r10, r11, r12, r13, ImageView.ScaleType.CENTER_INSIDE, r14, r15);
    }
}
