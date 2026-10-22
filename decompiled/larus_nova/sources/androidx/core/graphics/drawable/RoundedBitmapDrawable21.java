package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes17.dex */
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public boolean hasMipMap() {
        Bitmap r100 = this.mBitmap;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.hasMipMap() == false) goto L7;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        updateDstRect();
        r100.setRoundRect(this.mDstRect, getCornerRadius());
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void setMipMap(boolean r100) {
        Bitmap r101 = this.mBitmap;
        if (r101 == null) goto L6;
        r101.setHasMipMap(r100);
        invalidateSelf();
        return;
    }

    public RoundedBitmapDrawable21(Resources r100, Bitmap r101) {
        super(r100, r101);
    }

    @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
    public void gravityCompatApply(int r100, int r101, int r102, Rect r110, Rect r111) {
        Gravity.apply(r100, r101, r102, r110, r111, 0);
    }
}
