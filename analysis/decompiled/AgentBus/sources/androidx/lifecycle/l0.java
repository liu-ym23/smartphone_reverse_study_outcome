package androidx.lifecycle;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class l0 implements i3.d {

    /* renamed from: a, reason: collision with root package name */
    public final q6.b f1007a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1008b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1009c;

    /* renamed from: d, reason: collision with root package name */
    public final c7.o f1010d;

    public l0(q6.b bVar, c.i iVar) {
        q7.k.e(bVar, "savedStateRegistry");
        this.f1007a = bVar;
        this.f1010d = s7.a.H(new k0(iVar, 0));
    }

    @Override // i3.d
    public final Bundle a() {
        Bundle bundleK = ib.k.k((c7.j[]) Arrays.copyOf(new c7.j[0], 0));
        Bundle bundle = this.f1009c;
        if (bundle != null) {
            bundleK.putAll(bundle);
        }
        for (Map.Entry entry : ((m0) this.f1010d.getValue()).f1011b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((a3.a) ((g0) entry.getValue()).f994a.f166j).a();
            if (!bundleA.isEmpty()) {
                q7.k.e(str, "key");
                bundleK.putBundle(str, bundleA);
            }
        }
        this.f1008b = false;
        return bundleK;
    }
}
