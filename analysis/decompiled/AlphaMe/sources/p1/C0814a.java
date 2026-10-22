package p1;

import L3.k;
import L3.v;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import stepos.support.v7.app.b0;
import stepos.support.v7.app.c0;

/* renamed from: p1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0814a implements v {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13923a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13924b;

    public C0814a(c0 c0Var) {
        this.f13924b = c0Var;
    }

    @Override // L3.v
    public final void d(k kVar, boolean z4) {
        if (this.f13923a) {
            return;
        }
        this.f13923a = true;
        c0 c0Var = (c0) this.f13924b;
        c0Var.f14438a.i();
        b0 b0Var = c0Var.f14440c;
        if (b0Var != null) {
            b0Var.onPanelClosed(108, kVar);
        }
        this.f13923a = false;
    }

    @Override // L3.v
    public final boolean g(k kVar) {
        b0 b0Var = ((c0) this.f13924b).f14440c;
        if (b0Var == null) {
            return false;
        }
        b0Var.onMenuOpened(108, kVar);
        return true;
    }

    public C0814a(BottomSheetBehavior bottomSheetBehavior, boolean z4) {
        this.f13924b = bottomSheetBehavior;
        this.f13923a = z4;
    }
}
