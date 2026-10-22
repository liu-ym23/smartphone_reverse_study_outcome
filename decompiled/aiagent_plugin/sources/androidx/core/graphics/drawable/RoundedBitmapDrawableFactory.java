package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    private static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        DefaultRoundedBitmapDrawable(Resources r1, Bitmap r2) {
            super(r1, r2);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean r2) {
            if (this.mBitmap == null) goto L6;
            androidx.core.graphics.a.a(this.mBitmap, r2);
            invalidateSelf();
            return;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            if (this.mBitmap != null) goto L5;
        L7:
            return false;
        L5:
            if (androidx.core.graphics.a.a(this.mBitmap) == false) goto L7;
            return true;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        void gravityCompatApply(int r7, int r8, int r9, Rect r10, Rect r11) {
            androidx.core.view.d.a(r7, r8, r9, r10, r11, 0);
        }
    }
}
