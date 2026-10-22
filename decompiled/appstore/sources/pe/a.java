package pe;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final Bitmap a(Drawable r10) {
        q.g(r10, "<this>");
        if ((r10 instanceof BitmapDrawable) == false) goto L5;
        Bitmap r11 = ((BitmapDrawable) r10).getBitmap();
        q.d(r11);
        return r11;
    L5:
        int r12 = 1;
        if (r10.getIntrinsicWidth() <= 0) goto L8;
        int r13 = r10.getIntrinsicWidth();
    L10:
        if (r10.getIntrinsicHeight() <= 0) goto L12;
        r12 = r10.getIntrinsicHeight();
    L12:
        Bitmap r14 = Bitmap.createBitmap(r13, r12, Bitmap.Config.ARGB_8888);
        q.f(r14, "createBitmap(width, height, config)");
        Canvas r15 = new Canvas(r14);
        r10.setBounds(0, 0, r15.getWidth(), r15.getHeight());
        r10.draw(r15);
        return r14;
    L8:
        r13 = 1;
        goto L10
    }
}
