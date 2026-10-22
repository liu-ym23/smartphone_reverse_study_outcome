package stepos.support.v7.app;

import android.view.View;

/* loaded from: classes2.dex */
public final class V implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14353a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f14354b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f14355c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Z f14356d;

    public /* synthetic */ V(Z z4, View view, View view2, int i4) {
        this.f14353a = i4;
        this.f14356d = z4;
        this.f14354b = view;
        this.f14355c = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f14353a;
        View view = this.f14355c;
        View view2 = this.f14354b;
        Z z4 = this.f14356d;
        switch (i4) {
            case 0:
                Z.s(z4.f14376D, view2, view);
                break;
            default:
                Z.s(z4.f14413j, view2, view);
                break;
        }
    }
}
