package stepos.support.v7.widget;

import android.view.View;

/* renamed from: stepos.support.v7.widget.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0887g extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f15084e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f15085f;

    public /* synthetic */ C0887g(ActionBarOverlayLayout actionBarOverlayLayout, int i4) {
        this.f15084e = i4;
        this.f15085f = actionBarOverlayLayout;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        int i4 = this.f15084e;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f15085f;
        switch (i4) {
            case 0:
                actionBarOverlayLayout.f14791w = null;
                actionBarOverlayLayout.f14780l = false;
                break;
            default:
                actionBarOverlayLayout.f14792x = null;
                actionBarOverlayLayout.f14780l = false;
                break;
        }
    }

    @Override // C.b, K.f0
    public final void onAnimationCancel() {
        int i4 = this.f15084e;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f15085f;
        switch (i4) {
            case 0:
                actionBarOverlayLayout.f14791w = null;
                actionBarOverlayLayout.f14780l = false;
                break;
            default:
                actionBarOverlayLayout.f14792x = null;
                actionBarOverlayLayout.f14780l = false;
                break;
        }
    }
}
