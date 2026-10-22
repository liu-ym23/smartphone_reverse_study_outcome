package ad;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f507a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f508b;

    /* renamed from: c, reason: collision with root package name */
    public Object f509c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f510d;

    public i a() {
        boolean z10 = this.f507a;
        boolean z11 = this.f508b;
        String[] strArr = (String[]) this.f509c;
        String[] strArr2 = (String[]) this.f510d;
        i iVar = new i();
        iVar.f514a = z10;
        iVar.f515b = z11;
        iVar.f516c = strArr;
        iVar.f517d = strArr2;
        VarHandle.storeStoreFence();
        return iVar;
    }

    public void b(g... gVarArr) {
        if (!this.f507a) {
            g5.f.s("no cipher suites for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(gVarArr.length);
        for (g gVar : gVarArr) {
            arrayList.add(gVar.f503a);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        c((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public void c(String... strArr) {
        if (!this.f507a) {
            g5.f.s("no cipher suites for cleartext connections");
        } else if (strArr.length != 0) {
            this.f509c = (String[]) strArr.clone();
        } else {
            g5.f.s("At least one cipher suite is required");
        }
    }

    public void d(j0... j0VarArr) {
        if (!this.f507a) {
            g5.f.s("no TLS versions for cleartext connections");
            return;
        }
        ArrayList arrayList = new ArrayList(j0VarArr.length);
        for (j0 j0Var : j0VarArr) {
            arrayList.add(j0Var.f538c);
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        e((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Serializable, java.lang.String[]] */
    public void e(String... strArr) {
        if (!this.f507a) {
            g5.f.s("no TLS versions for cleartext connections");
        } else if (strArr.length != 0) {
            this.f510d = (String[]) strArr.clone();
        } else {
            g5.f.s("At least one TLS version is required");
        }
    }
}
