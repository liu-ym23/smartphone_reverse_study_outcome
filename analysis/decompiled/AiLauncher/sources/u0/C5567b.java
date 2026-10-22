package u0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: u0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5567b extends c {
    public C5567b(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // u0.c
    public void c(int i10, int i11, int i12, Rect rect, Rect rect2) {
        Gravity.apply(i10, i11, i12, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        g();
        outline.setRoundRect(this.f42394h, b());
    }
}
