package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f970a;

    public static class a {
        public static void a(Drawable r10, Outline r11) {
            r10.getOutline(r11);
        }
    }

    public b(ActionBarContainer r10) {
        this.f970a = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        ActionBarContainer r11 = this.f970a;
        if (r11.f651h == false) goto L7;
        Drawable r12 = r11.f650g;
        if (r12 == null) goto L16;
        r12.draw(r10);
        return;
    L16:
        return;
    L7:
        Drawable r13 = r11.f648e;
        if (r13 == null) goto L10;
        r13.draw(r10);
    L10:
        ActionBarContainer r14 = this.f970a;
        Drawable r15 = r14.f649f;
        if (r15 != null) goto L13;
        return;
    L13:
        if (r14.f652i == false) goto L19;
        r15.draw(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r10) {
        ActionBarContainer r11 = this.f970a;
        if (r11.f651h == true) goto L5;
        Drawable r12 = r11.f648e;
        if (r12 == null) goto L13;
        a.a(r12, r10);
        return;
    L13:
        return;
    L5:
        if (r11.f650g == null) goto L11;
        a.a(r11.f648e, r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
    }
}
