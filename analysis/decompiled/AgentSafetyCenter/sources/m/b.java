package m;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContainer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7878a;

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f7879b;

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        switch (this.f7878a) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f7879b;
                if (!actionBarContainer.f749k) {
                    Drawable drawable = actionBarContainer.f747h;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    Drawable drawable2 = actionBarContainer.i;
                    if (drawable2 != null && actionBarContainer.f750l) {
                        drawable2.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer.f748j;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                        break;
                    }
                }
                break;
            default:
                stepos.support.v7.widget.ActionBarContainer actionBarContainer2 = (stepos.support.v7.widget.ActionBarContainer) this.f7879b;
                if (!actionBarContainer2.f12562k) {
                    Drawable drawable4 = actionBarContainer2.f12560h;
                    if (drawable4 != null) {
                        drawable4.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable5 = actionBarContainer2.f12561j;
                    if (drawable5 != null) {
                        drawable5.draw(canvas);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        switch (this.f7878a) {
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        switch (this.f7878a) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f7879b;
                if (!actionBarContainer.f749k) {
                    Drawable drawable = actionBarContainer.f747h;
                    if (drawable != null) {
                        drawable.getOutline(outline);
                        break;
                    }
                } else if (actionBarContainer.f748j != null) {
                    actionBarContainer.f747h.getOutline(outline);
                    break;
                }
                break;
            default:
                stepos.support.v7.widget.ActionBarContainer actionBarContainer2 = (stepos.support.v7.widget.ActionBarContainer) this.f7879b;
                if (!actionBarContainer2.f12562k) {
                    Drawable drawable2 = actionBarContainer2.f12560h;
                    if (drawable2 != null) {
                        drawable2.getOutline(outline);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer2.f12561j;
                    if (drawable3 != null) {
                        drawable3.getOutline(outline);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        int i3 = this.f7878a;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        int i = this.f7878a;
    }

    private final void a(int i) {
    }

    private final void b(int i) {
    }

    private final void c(ColorFilter colorFilter) {
    }

    private final void d(ColorFilter colorFilter) {
    }
}
