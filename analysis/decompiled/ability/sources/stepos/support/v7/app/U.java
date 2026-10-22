package stepos.support.v7.app;

import android.view.View;

/* loaded from: classes4.dex */
public final class U implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6237a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Z d;

    public /* synthetic */ U(Z z10, View view, View view2, int i) {
        this.f6237a = i;
        this.d = z10;
        this.b = view;
        this.c = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6237a) {
            case 0:
                Z.q(this.d.f6249B, this.b, this.c);
                break;
            default:
                Z.q(this.d.i, this.b, this.c);
                break;
        }
    }
}
