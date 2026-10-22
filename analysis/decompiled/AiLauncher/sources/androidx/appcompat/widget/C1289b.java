package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1289b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final ActionBarContainer f9178a;

    /* renamed from: androidx.appcompat.widget.b$a */
    public static class a {
        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public C1289b(ActionBarContainer actionBarContainer) {
        this.f9178a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f9178a;
        if (actionBarContainer.f8723h) {
            Drawable drawable = actionBarContainer.f8722g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f8720e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f9178a;
        Drawable drawable3 = actionBarContainer2.f8721f;
        if (drawable3 == null || !actionBarContainer2.f8724i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f9178a;
        if (actionBarContainer.f8723h) {
            if (actionBarContainer.f8722g != null) {
                a.a(actionBarContainer.f8720e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f8720e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
