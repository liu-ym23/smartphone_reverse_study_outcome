package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import androidx.core.graphics.BitmapCompat;
import androidx.core.view.GravityCompat;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes17.dex */
public final class RoundedBitmapDrawableFactory {
    private static final String TAG = "RoundedBitmapDrawableFa";

    public static class DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public boolean hasMipMap() {
            Bitmap r100 = this.mBitmap;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (BitmapCompat.hasMipMap(r100) == false) goto L7;
            return true;
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void setMipMap(boolean r100) {
            Bitmap r101 = this.mBitmap;
            if (r101 == null) goto L6;
            BitmapCompat.setHasMipMap(r101, r100);
            invalidateSelf();
            return;
        }

        public DefaultRoundedBitmapDrawable(Resources r100, Bitmap r101) {
            super(r100, r101);
        }

        @Override // androidx.core.graphics.drawable.RoundedBitmapDrawable
        public void gravityCompatApply(int r100, int r101, int r102, Rect r110, Rect r111) {
            GravityCompat.apply(r100, r101, r102, r110, r111, 0);
        }
    }

    private RoundedBitmapDrawableFactory() {
    }

    public static RoundedBitmapDrawable create(Resources r100, InputStream r101) {
        RoundedBitmapDrawable r102 = create(r100, BitmapFactory.decodeStream(r101));
        if (r102.getBitmap() != null) goto L5;
        Objects.toString(r101);
    L5:
        return r102;
    }

    public static RoundedBitmapDrawable create(Resources r100, String r101) {
        RoundedBitmapDrawable r102 = create(r100, BitmapFactory.decodeFile(r101));
        if (r102.getBitmap() == null) goto L5;
    L5:
        return r102;
    }

    public static RoundedBitmapDrawable create(Resources r100, Bitmap r101) {
        return new RoundedBitmapDrawable21(r100, r101);
    }
}
