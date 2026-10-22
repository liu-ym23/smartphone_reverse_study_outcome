package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Drawable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Bitmap a(Drawable r0, int r1, int r2, Bitmap.Config r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.getIntrinsicWidth();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.getIntrinsicHeight();
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return a(r0, r1, r2, r3);
    }

    public static final Bitmap a(Drawable r5, int r6, int r7, Bitmap.Config r8) {
        if (ZeusTransformUtils.instanceOf(r5, BitmapDrawable.class) == true) goto L5;
    L19:
        Rect r0 = r5.getBounds();
        int r1 = r0.left;
        int r2 = r0.top;
        int r3 = r0.right;
        int r4 = r0.bottom;
        if (r8 != null) goto L22;
        r8 = Bitmap.Config.ARGB_8888;
    L22:
        Bitmap r9 = Bitmap.createBitmap(r6, r7, r8);
        r5.setBounds(0, 0, r6, r7);
        r5.draw(new Canvas(r9));
        r5.setBounds(r1, r2, r3, r4);
        return r9;
    L5:
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap() == null) goto L18;
        if (r8 == null) goto L10;
        if (((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap().getConfig() != r8) goto L19;
    L10:
        if (r6 != ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap().getWidth()) goto L16;
        if (r7 != ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap().getHeight()) goto L16;
        return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap();
    L16:
        return Bitmap.createScaledBitmap(((BitmapDrawable) ZeusTransformUtils.preCheckCast(r5, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap(), r6, r7, true);
    L18:
        throw new IllegalArgumentException("bitmap is null");
    }
}
