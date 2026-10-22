package androidx.lifecycle;

import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1378c;

    /* renamed from: f, reason: collision with root package name */
    public Object f1379f;

    public /* synthetic */ e(int i) {
        this.f1378c = i;
    }

    @Override // androidx.lifecycle.v
    public final void e(x xVar, o oVar) {
        switch (this.f1378c) {
            case 0:
                new HashMap();
                j[] jVarArr = (j[]) this.f1379f;
                if (jVarArr.length > 0) {
                    j jVar = jVarArr[0];
                    throw null;
                }
                if (jVarArr.length <= 0) {
                    return;
                }
                j jVar2 = jVarArr[0];
                throw null;
            default:
                if (oVar != o.ON_CREATE) {
                    ad.o.e(oVar, "Next event must be ON_CREATE, it was ");
                    return;
                } else {
                    xVar.getLifecycle().c(this);
                    ((t0) this.f1379f).b();
                    return;
                }
        }
    }
}
