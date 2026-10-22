package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a3\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\b\u001a9\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0003\u0010\n\u001a\u00020\u00012\b\b\u0003\u0010\u000b\u001a\u00020\u00012\b\b\u0003\u0010\f\u001a\u00020\u00012\b\b\u0003\u0010\r\u001a\u00020\u0001¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "width", "height", "Landroid/graphics/Bitmap$Config;", "config", "Landroid/graphics/Bitmap;", "toBitmap", "(Landroid/graphics/drawable/Drawable;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "toBitmapOrNull", "left", "top", "right", "bottom", "LC7/r;", "updateBounds", "(Landroid/graphics/drawable/Drawable;IIII)V", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i, @Px int i6, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                throw new IllegalArgumentException("bitmap is null");
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i == bitmapDrawable.getBitmap().getWidth() && i6 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i6, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i10 = bounds.left;
        int i11 = bounds.top;
        int i12 = bounds.right;
        int i13 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i6, config);
        drawable.setBounds(0, 0, i, i6);
        drawable.draw(new Canvas(bitmapCreateBitmap));
        drawable.setBounds(i10, i11, i12, i13);
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i, int i6, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i10 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i10 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i6, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i, @Px int i6, Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return toBitmap(drawable, i, i6, config);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i, int i6, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i10 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i10 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i, i6, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        drawable.setBounds(i, i6, i10, i11);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i12 & 2) != 0) {
            i6 = drawable.getBounds().top;
        }
        if ((i12 & 4) != 0) {
            i10 = drawable.getBounds().right;
        }
        if ((i12 & 8) != 0) {
            i11 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i6, i10, i11);
    }
}
