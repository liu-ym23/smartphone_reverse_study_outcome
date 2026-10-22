package com.android.volley.toolbox;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.android.volley.VolleyError;

/* JADX INFO: loaded from: classes.dex */
public class NetworkImageView extends ImageView {
    private int mDefaultImageId;
    private int mErrorImageId;
    private ImageLoader.ImageContainer mImageContainer;
    private ImageLoader mImageLoader;
    private String mUrl;

    /* JADX INFO: renamed from: com.android.volley.toolbox.NetworkImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageLoader.ImageListener {
        final /* synthetic */ NetworkImageView this$0;
        final /* synthetic */ boolean val$isInLayoutPass;

        public AnonymousClass1(NetworkImageView r10, boolean r11) {
            this.this$0 = r10;
            this.val$isInLayoutPass = r11;
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError r10) {
            if (NetworkImageView.access$000(this.this$0) == 0) goto L6;
            NetworkImageView r11 = this.this$0;
            r11.setImageResource(NetworkImageView.access$000(r11));
            return;
        }

        @Override // com.android.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(final ImageLoader.ImageContainer r10, boolean r11) {
            if (r11 == false) goto L8;
            if (this.val$isInLayoutPass == false) goto L8;
            this.this$0.post(new RunnableC00711(this, r10));
            return;
        L8:
            if (r10.getBitmap() == null) goto L11;
            this.this$0.setImageBitmap(r10.getBitmap());
            return;
        L11:
            if (NetworkImageView.access$100(this.this$0) == 0) goto L15;
            NetworkImageView r12 = this.this$0;
            r12.setImageResource(NetworkImageView.access$100(r12));
            return;
        }
    }

    public NetworkImageView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ int access$000(NetworkImageView r10) {
        return r10.mErrorImageId;
    }

    public static /* synthetic */ int access$100(NetworkImageView r10) {
        return r10.mDefaultImageId;
    }

    private void setDefaultImageOrNull() {
        int r10 = this.mDefaultImageId;
        if (r10 == 0) goto L5;
        setImageResource(r10);
        return;
    L5:
        setImageBitmap(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public void loadImageIfNecessary(boolean r10) {
        int r11 = getWidth();
        int r12 = getHeight();
        ImageView.ScaleType r13 = getScaleType();
        boolean r14 = true;
        if (getLayoutParams() != null) goto L5;
        boolean r15 = false;
        boolean r16 = false;
    L13:
        if (r15 == false) goto L16;
        if (r16 == false) goto L16;
    L17:
        if (r11 != 0) goto L22;
        if (r12 != 0) goto L22;
        if (r14 == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(this.mUrl) == false) goto L28;
        ImageLoader.ImageContainer r17 = this.mImageContainer;
        if (r17 == null) goto L26;
        r17.cancelRequest();
        this.mImageContainer = null;
    L26:
        setDefaultImageOrNull();
        return;
    L28:
        ImageLoader.ImageContainer r18 = this.mImageContainer;
        if (r18 != null) goto L31;
    L36:
        if (r15 == false) goto L38;
        r11 = 0;
    L38:
        if (r16 == false) goto L40;
        int r19 = 0;
    L41:
        this.mImageContainer = this.mImageLoader.get(this.mUrl, new AnonymousClass1(this, r10), r11, r19, r13);
        return;
    L40:
        r19 = r12;
        goto L41
    L31:
        if (r18.getRequestUrl() == null) goto L36;
        if (this.mImageContainer.getRequestUrl().equals(this.mUrl) == false) goto L35;
        return;
    L35:
        this.mImageContainer.cancelRequest();
        setDefaultImageOrNull();
    L16:
        r14 = false;
        goto L17
    L5:
        if (getLayoutParams().width != (-2)) goto L7;
        r15 = true;
    L9:
        if (getLayoutParams().height != (-2)) goto L11;
        r16 = true;
        goto L13
    L11:
        r16 = false;
        goto L13
    L7:
        r15 = false;
        goto L9
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        ImageLoader.ImageContainer r10 = this.mImageContainer;
        if (r10 == null) goto L5;
        r10.cancelRequest();
        setImageBitmap(null);
        this.mImageContainer = null;
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        loadImageIfNecessary(true);
    }

    public void setDefaultImageResId(int r10) {
        this.mDefaultImageId = r10;
    }

    public void setErrorImageResId(int r10) {
        this.mErrorImageId = r10;
    }

    public void setImageUrl(String r10, ImageLoader r11) {
        this.mUrl = r10;
        this.mImageLoader = r11;
        loadImageIfNecessary(false);
    }

    public NetworkImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public NetworkImageView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
    }
}
