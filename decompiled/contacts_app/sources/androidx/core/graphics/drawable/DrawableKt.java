package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: Drawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a2\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u00042\b\b\u0003\u0010\f\u001a\u00020\u00042\b\b\u0003\u0010\r\u001a\u00020\u00042\b\b\u0003\u0010\u000e\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "config", "Landroid/graphics/Bitmap$Config;", "toBitmapOrNull", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawableKt {
    public static /* synthetic */ Bitmap toBitmap$default(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return toBitmap(r0, r1, r2, r3);
    }

    public static final Bitmap toBitmap(Drawable r6, int r7, int r8, Bitmap.Config r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((r6 instanceof BitmapDrawable) == false) goto L19;
        BitmapDrawable r0 = (BitmapDrawable) r6;
        if (r0.getBitmap() == null) goto L18;
        if (r9 == null) goto L10;
        if (r0.getBitmap().getConfig() != r9) goto L19;
    L10:
        if (r7 == r0.getBitmap().getWidth()) goto L12;
    L15:
        Bitmap r10 = Bitmap.createScaledBitmap(r0.getBitmap(), r7, r8, true);
        Intrinsics.checkNotNullExpressionValue(r10, "createScaledBitmap(bitmap, width, height, true)");
        return r10;
    L12:
        if (r8 != r0.getBitmap().getHeight()) goto L15;
        Bitmap r11 = r0.getBitmap();
        Intrinsics.checkNotNullExpressionValue(r11, "bitmap");
        return r11;
    L18:
        throw new IllegalArgumentException("bitmap is null");
    L19:
        Rect r1 = r6.getBounds();
        Intrinsics.checkNotNullExpressionValue(r1, "bounds");
        int r2 = r1.left;
        int r3 = r1.top;
        int r4 = r1.right;
        int r5 = r1.bottom;
        if (r9 != null) goto L22;
        r9 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r12 = Bitmap.createBitmap(r7, r8, r9);
        r6.setBounds(0, 0, r7, r8);
        r6.draw(new Canvas(r12));
        r6.setBounds(r2, r3, r4, r5);
        Intrinsics.checkNotNullExpressionValue(r12, "bitmap");
        return r12;
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return toBitmapOrNull(r0, r1, r2, r3);
    }

    public static final Bitmap toBitmapOrNull(Drawable r1, int r2, int r3, Bitmap.Config r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof BitmapDrawable) == false) goto L9;
        if (((BitmapDrawable) r1).getBitmap() != null) goto L9;
        return null;
    L9:
        return toBitmap(r1, r2, r3, r4);
    }

    public static /* synthetic */ void updateBounds$default(Drawable r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getBounds().left;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.getBounds().top;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getBounds().right;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.getBounds().bottom;
    L14:
        updateBounds(r0, r1, r2, r3, r4);
    }

    public static final void updateBounds(Drawable r1, int r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setBounds(r2, r3, r4, r5);
    }
}
