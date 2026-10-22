package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f752a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f753b;

    public /* synthetic */ b(FrameLayout frameLayout, int i10) {
        this.f752a = i10;
        this.f753b = frameLayout;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        switch (this.f752a) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f753b;
                if (!actionBarContainer.f558k) {
                    Drawable drawable = actionBarContainer.f556e;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    Drawable drawable2 = actionBarContainer.h;
                    if (drawable2 != null && actionBarContainer.f559l) {
                        drawable2.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer.f557j;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                        break;
                    }
                }
                break;
            default:
                stepos.support.v7.widget.ActionBarContainer actionBarContainer2 = (stepos.support.v7.widget.ActionBarContainer) this.f753b;
                if (!actionBarContainer2.f12443k) {
                    Drawable drawable4 = actionBarContainer2.h;
                    if (drawable4 != null && actionBarContainer2.f12444l) {
                        drawable4.draw(canvas);
                    }
                    Drawable drawable5 = actionBarContainer2.f12441e;
                    if (drawable5 != null) {
                        drawable5.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable6 = actionBarContainer2.f12442j;
                    if (drawable6 != null) {
                        drawable6.draw(canvas);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        switch (this.f752a) {
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        switch (this.f752a) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f753b;
                if (!actionBarContainer.f558k) {
                    Drawable drawable = actionBarContainer.f556e;
                    if (drawable != null) {
                        drawable.getOutline(outline);
                        break;
                    }
                } else if (actionBarContainer.f557j != null) {
                    actionBarContainer.f556e.getOutline(outline);
                    break;
                }
                break;
            default:
                stepos.support.v7.widget.ActionBarContainer actionBarContainer2 = (stepos.support.v7.widget.ActionBarContainer) this.f753b;
                if (!actionBarContainer2.f12443k) {
                    Drawable drawable2 = actionBarContainer2.f12441e;
                    if (drawable2 != null) {
                        drawable2.getOutline(outline);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer2.f12442j;
                    if (drawable3 != null) {
                        drawable3.getOutline(outline);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        int i11 = this.f752a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        int i10 = this.f752a;
    }

    private final void a(int i10) {
    }

    private final void b(int i10) {
    }

    private final void c(ColorFilter colorFilter) {
    }

    private final void d(ColorFilter colorFilter) {
    }
}
