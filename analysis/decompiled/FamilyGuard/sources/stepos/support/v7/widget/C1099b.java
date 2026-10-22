package stepos.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: stepos.support.v7.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1099b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    final ActionBarContainer f21917a;

    public C1099b(ActionBarContainer actionBarContainer) {
        this.f21917a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f21917a;
        if (actionBarContainer.f21415h) {
            Drawable drawable = actionBarContainer.f21414g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f21413f;
        if (drawable2 != null && actionBarContainer.f21416i) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = this.f21917a.f21412e;
        if (drawable3 != null) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
