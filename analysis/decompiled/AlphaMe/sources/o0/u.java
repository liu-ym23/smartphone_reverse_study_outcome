package o0;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13767b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13768c;

    public u(int i4, Object obj, Object obj2) {
        this.f13766a = i4;
        this.f13768c = obj;
        this.f13767b = obj2;
    }

    @Override // o0.q
    public final void f(s sVar) {
        int i4 = this.f13766a;
        Object obj = this.f13767b;
        switch (i4) {
            case 0:
                ((ArrayList) ((q.f) obj).get(((v) this.f13768c).f13770b)).remove(sVar);
                sVar.y(this);
                break;
            default:
                ((s) obj).B();
                sVar.y(this);
                break;
        }
    }
}
