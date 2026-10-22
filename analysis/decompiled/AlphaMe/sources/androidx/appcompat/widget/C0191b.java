package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* renamed from: androidx.appcompat.widget.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0191b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3053a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f3054b;

    public /* synthetic */ C0191b(FrameLayout frameLayout, int i4) {
        this.f3053a = i4;
        this.f3054b = frameLayout;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i4 = this.f3053a;
        FrameLayout frameLayout = this.f3054b;
        switch (i4) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) frameLayout;
                if (!actionBarContainer.f2731g) {
                    Drawable drawable = actionBarContainer.f2728d;
                    if (drawable != null) {
                        drawable.draw(canvas);
                    }
                    Drawable drawable2 = actionBarContainer.f2729e;
                    if (drawable2 != null && actionBarContainer.f2732h) {
                        drawable2.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable3 = actionBarContainer.f2730f;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                        break;
                    }
                }
                break;
            default:
                stepos.support.v7.widget.ActionBarContainer actionBarContainer2 = (stepos.support.v7.widget.ActionBarContainer) frameLayout;
                if (!actionBarContainer2.f14710g) {
                    Drawable drawable4 = actionBarContainer2.f14707d;
                    if (drawable4 != null) {
                        drawable4.draw(canvas);
                        break;
                    }
                } else {
                    Drawable drawable5 = actionBarContainer2.f14709f;
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
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        switch (this.f3053a) {
            case 0:
                ActionBarContainer actionBarContainer = (ActionBarContainer) this.f3054b;
                if (!actionBarContainer.f2731g) {
                    Drawable drawable = actionBarContainer.f2728d;
                    if (drawable != null) {
                        drawable.getOutline(outline);
                        break;
                    }
                } else if (actionBarContainer.f2730f != null) {
                    actionBarContainer.f2728d.getOutline(outline);
                    break;
                }
                break;
            default:
                super.getOutline(outline);
                break;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
