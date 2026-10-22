package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import com.stepos.alphame.utils.Property;
import stepos.support.v7.widget.AbstractC0881a;

/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0189a implements K.f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3048a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3049b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f3050c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3051d;

    public /* synthetic */ C0189a(ViewGroup viewGroup, int i4) {
        this.f3048a = i4;
        this.f3051d = viewGroup;
    }

    @Override // K.f0
    public final void c(View view) {
        switch (this.f3048a) {
            case 0:
                if (!this.f3049b) {
                    ActionBarContextView actionBarContextView = (ActionBarContextView) this.f3051d;
                    actionBarContextView.f2739f = null;
                    super/*android.view.View*/.setVisibility(this.f3050c);
                    break;
                }
                break;
            case 1:
            case 3:
            default:
                if (!this.f3049b) {
                    ((stepos.support.v7.widget.Toolbar) this.f3051d).getClass();
                    stepos.support.v7.widget.ActionMenuView actionMenuView = ((stepos.support.v7.widget.Toolbar) this.f3051d).f15013a;
                    if (actionMenuView != null) {
                        actionMenuView.setVisibility(this.f3050c);
                        break;
                    }
                }
                break;
            case 2:
                if (!this.f3049b) {
                    AbstractC0881a abstractC0881a = (AbstractC0881a) this.f3051d;
                    abstractC0881a.f15060i = null;
                    super/*android.view.View*/.setVisibility(this.f3050c);
                    break;
                }
                break;
            case 4:
                if (!this.f3049b) {
                    stepos.support.v7.widget.ActionBarContextView actionBarContextView2 = (stepos.support.v7.widget.ActionBarContextView) this.f3051d;
                    if (actionBarContextView2.f14725w == 2) {
                        actionBarContextView2.j();
                    }
                    ViewGroup viewGroup = ((stepos.support.v7.widget.ActionBarContextView) this.f3051d).f15056e;
                    if (viewGroup != null) {
                        viewGroup.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                    }
                    stepos.support.v7.widget.ActionBarContextView actionBarContextView3 = (stepos.support.v7.widget.ActionBarContextView) this.f3051d;
                    actionBarContextView3.f14725w = 0;
                    actionBarContextView3.f14728z = null;
                    break;
                }
                break;
        }
    }

    @Override // K.f0
    public final void d(View view) {
        switch (this.f3048a) {
            case 0:
                super/*android.view.View*/.setVisibility(0);
                this.f3049b = false;
                break;
            case 1:
            case 3:
            default:
                stepos.support.v7.widget.ActionMenuView actionMenuView = ((stepos.support.v7.widget.Toolbar) this.f3051d).f15013a;
                if (actionMenuView != null) {
                    actionMenuView.setVisibility(0);
                }
                this.f3049b = false;
                break;
            case 2:
                super/*android.view.View*/.setVisibility(0);
                this.f3049b = false;
                break;
            case 4:
                ViewGroup viewGroup = ((stepos.support.v7.widget.ActionBarContextView) this.f3051d).f15056e;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                this.f3049b = false;
                break;
        }
    }

    @Override // K.f0
    public final void onAnimationCancel() {
        switch (this.f3048a) {
            case 0:
                this.f3049b = true;
                break;
            case 1:
            case 3:
            default:
                this.f3049b = true;
                break;
            case 2:
                this.f3049b = true;
                break;
            case 4:
                this.f3049b = true;
                break;
        }
    }
}
