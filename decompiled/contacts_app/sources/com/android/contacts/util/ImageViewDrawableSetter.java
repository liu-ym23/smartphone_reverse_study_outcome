package com.android.contacts.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView;
import com.android.contacts.common.ContactPhotoManager;
import com.android.contacts.common.model.Contact;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ImageViewDrawableSetter {
    private static final String TAG = "ImageViewDrawableSetter";
    private byte[] mCompressed;
    private int mDurationInMillis;
    private Drawable mPreviousDrawable;
    private ImageView mTarget;

    public ImageViewDrawableSetter() {
        this.mDurationInMillis = 0;
    }

    public ImageViewDrawableSetter(ImageView r2) {
        this.mDurationInMillis = 0;
        this.mTarget = r2;
    }

    public void setupContactPhoto(Contact r1, ImageView r2) {
        setTarget(r2);
        setCompressedImage(r1.getPhotoBinaryData());
    }

    public void setTransitionDuration(int r1) {
        this.mDurationInMillis = r1;
    }

    public ImageView getTarget() {
        return this.mTarget;
    }

    protected void setTarget(ImageView r2) {
        if (this.mTarget == r2) goto L6;
        this.mTarget = r2;
        this.mCompressed = null;
        this.mPreviousDrawable = null;
        return;
    }

    protected byte[] getCompressedImage() {
        return this.mCompressed;
    }

    protected Bitmap setCompressedImage(byte[] r4) {
        Drawable r0 = this.mPreviousDrawable;
        if (r0 == null) goto L10;
        if (r0 == null) goto L10;
        if (Arrays.equals(this.mCompressed, r4) == false) goto L10;
        return previousBitmap();
    L10:
        if (r4 != null) goto L12;
        Drawable r1 = defaultDrawable();
    L13:
        this.mCompressed = r4;
        if (r1 == null) goto L16;
        Drawable r5 = this.mPreviousDrawable;
        if (r5 != null) goto L20;
    L23:
        this.mTarget.setImageDrawable(r1);
    L24:
        this.mPreviousDrawable = r1;
        return previousBitmap();
    L20:
        if (this.mDurationInMillis == 0) goto L23;
        TransitionDrawable r6 = new TransitionDrawable(new Drawable[]{r5, r1});
        this.mTarget.setImageDrawable(r6);
        r6.startTransition(this.mDurationInMillis);
        goto L24
    L16:
        return previousBitmap();
    L12:
        r1 = decodedBitmapDrawable(r4);
        goto L13
    }

    private Bitmap previousBitmap() {
        Drawable r0 = this.mPreviousDrawable;
        if (r0 != null) goto L6;
        return null;
    L6:
        return ((BitmapDrawable) r0).getBitmap();
    }

    private Drawable defaultDrawable() {
        return this.mTarget.getResources().getDrawable(ContactPhotoManager.getDefaultAvatarResId(true, false));
    L5:
        Log.wtf(TAG, "Cannot load default avatar resource.");
        return null;
    }

    private BitmapDrawable decodedBitmapDrawable(byte[] r3) {
        return new BitmapDrawable(this.mTarget.getResources(), BitmapFactory.decodeByteArray(r3, 0, r3.length));
    }
}
