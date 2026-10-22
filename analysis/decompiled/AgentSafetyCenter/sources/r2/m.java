package r2;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import u1.n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10424c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ xb.l f10425f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0.p f10426g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t0.g f10427h;
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ View f10428j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, xb.l lVar, k0.p pVar, t0.g gVar, int i, View view) {
        super(0);
        this.f10424c = context;
        this.f10425f = lVar;
        this.f10426g = pVar;
        this.f10427h = gVar;
        this.i = i;
        this.f10428j = view;
    }

    @Override // xb.a
    public final Object invoke() {
        KeyEvent.Callback callback = this.f10428j;
        callback.getClass();
        return new q(this.f10424c, this.f10425f, this.f10426g, this.f10427h, this.i, (n1) callback).getLayoutNode();
    }
}
