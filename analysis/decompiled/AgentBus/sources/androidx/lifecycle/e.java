package androidx.lifecycle;

import android.os.Bundle;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e implements t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f991f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f992g;

    public /* synthetic */ e(int i2, Object obj) {
        this.f991f = i2;
        this.f992g = obj;
    }

    @Override // androidx.lifecycle.t
    public final void b(v vVar, p pVar) {
        switch (this.f991f) {
            case 0:
                new HashMap();
                j[] jVarArr = (j[]) this.f992g;
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
                if (pVar != p.ON_CREATE) {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + pVar).toString());
                }
                vVar.a().f(this);
                l0 l0Var = (l0) this.f992g;
                if (l0Var.f1008b) {
                    return;
                }
                Bundle bundleY0 = l0Var.f1007a.y0("androidx.lifecycle.internal.SavedStateHandlesProvider");
                Bundle bundleK = ib.k.k((c7.j[]) Arrays.copyOf(new c7.j[0], 0));
                Bundle bundle = l0Var.f1009c;
                if (bundle != null) {
                    bundleK.putAll(bundle);
                }
                if (bundleY0 != null) {
                    bundleK.putAll(bundleY0);
                }
                l0Var.f1009c = bundleK;
                l0Var.f1008b = true;
                return;
        }
    }
}
