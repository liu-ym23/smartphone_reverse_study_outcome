package com.android.contacts.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import bytedanceos.util.NameAvatarController;
import com.android.contacts.R;
import com.android.contacts.util.ContactBadgeUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AvatarImageView extends ImageView {
    private static final float STROKE_WIDTH_DP = 0.5f;
    private Bitmap mAvatarBitmap;
    private boolean mIsDisplayingRealPhoto;
    private long mPhotoID;
    private final Rect mRect;
    private final Rect mSRect;
    private boolean mStrokeEnabled;
    private Paint mStrokePaint;
    private float mStrokeWidthPx;

    public AvatarImageView(Context r3) {
        super(r3);
        this.mPhotoID = 0;
        this.mAvatarBitmap = null;
        this.mStrokeEnabled = false;
        this.mIsDisplayingRealPhoto = false;
        this.mRect = new Rect();
        this.mSRect = new Rect();
        init();
    }

    public AvatarImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public AvatarImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mPhotoID = 0;
        this.mAvatarBitmap = null;
        this.mStrokeEnabled = false;
        this.mIsDisplayingRealPhoto = false;
        this.mRect = new Rect();
        this.mSRect = new Rect();
        init();
    }

    private void init() {
        this.mStrokeWidthPx = getResources().getDisplayMetrics().density * 0.5f;
        Paint r0 = new Paint(1);
        this.mStrokePaint = r0;
        r0.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setStrokeWidth(this.mStrokeWidthPx);
        this.mStrokePaint.setColor(ContextCompat.getColor(getContext(), R.color.oui_line_1));
    }

    public void setPhotoID(long r3) {
        this.mPhotoID = r3;
        this.mAvatarBitmap = null;
        markDisplayingPlaceholderPhoto();
        if (r3 <= 0) goto L5;
        boolean r4 = true;
    L6:
        setStrokeEnabled(r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public long getPhotoID() {
        return this.mPhotoID;
    }

    public void setAvatarBitmap(Bitmap r3) {
        boolean r0 = false;
        if (r3 == null) goto L5;
        Bitmap r1 = NameAvatarController.getCircleBitmap(r3, false);
    L6:
        this.mAvatarBitmap = r1;
        if (r3 == null) goto L9;
        r0 = true;
    L9:
        markDisplayingRealPhoto(r0);
        invalidate();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void setStrokeEnabled(boolean r2) {
        if (this.mStrokeEnabled != r2) goto L5;
        return;
    L5:
        this.mStrokeEnabled = r2;
        invalidate();
    }

    public boolean isStrokeEnabled() {
        return this.mStrokeEnabled;
    }

    public void setStrokeVisible(boolean r1) {
        setStrokeEnabled(r1);
    }

    public boolean isStrokeVisible() {
        return isStrokeEnabled();
    }

    private void markDisplayingRealPhoto(boolean r1) {
        this.mIsDisplayingRealPhoto = r1;
    }

    private void markDisplayingPlaceholderPhoto() {
        markDisplayingRealPhoto(false);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap r2) {
        this.mAvatarBitmap = null;
        super.setImageBitmap(r2);
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        markDisplayingRealPhoto(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r2) {
        this.mAvatarBitmap = null;
        super.setImageDrawable(r2);
        markDisplayingPlaceholderPhoto();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int r2) {
        this.mAvatarBitmap = null;
        super.setImageResource(r2);
        markDisplayingPlaceholderPhoto();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas r7) {
        if (this.mAvatarBitmap == null) goto L6;
        this.mRect.right = getWidth();
        this.mRect.bottom = getHeight();
        this.mSRect.right = this.mAvatarBitmap.getWidth();
        this.mSRect.bottom = this.mAvatarBitmap.getHeight();
        r7.drawBitmap(this.mAvatarBitmap, this.mSRect, this.mRect, null);
    L15:
        if (this.mStrokeEnabled == true) goto L17;
        return;
    L17:
        if (this.mIsDisplayingRealPhoto == false) goto L21;
        r7.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, Math.max(0.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - (this.mStrokeWidthPx / 2.0f)), this.mStrokePaint);
        return;
    L21:
        return;
    L6:
        if (this.mPhotoID <= 0) goto L8;
    L13:
        super.onDraw(r7);
        goto L15
    L8:
        if (this.mIsDisplayingRealPhoto == true) goto L10;
    L12:
        Bitmap r0 = ContactBadgeUtil.loadDefaultAvatarPhoto(getContext(), true, false);
        this.mRect.right = getWidth();
        this.mRect.bottom = getHeight();
        this.mSRect.right = r0.getWidth();
        this.mSRect.bottom = r0.getHeight();
        r7.drawBitmap(r0, this.mSRect, this.mRect, null);
        goto L15
    L10:
        if (getDrawable() == null) goto L12;
        goto L12
    }
}
