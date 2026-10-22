package y1;

import m0.C1670d;

/* loaded from: classes2.dex */
public final class b extends w1.b implements w1.a {
    public static final String[] f = {"_id", "version_code", "version_name", "manifest_version_code", "update_version_code", "app_version"};

    @Override // w1.a
    public final Object a(O2.a aVar) {
        aVar.j("_id");
        String strK = aVar.k("version_code");
        String strK2 = aVar.k("version_name");
        String strK3 = aVar.k("manifest_version_code");
        String strK4 = aVar.k("update_version_code");
        String strK5 = aVar.k("app_version");
        C1670d c1670d = new C1670d();
        c1670d.f5295a = strK;
        c1670d.b = strK2;
        c1670d.c = strK3;
        c1670d.d = strK4;
        c1670d.e = strK5;
        return c1670d;
    }

    @Override // w1.b
    public final String[] h() {
        return f;
    }

    @Override // w1.b
    public final String i() {
        return "local_monitor_version";
    }
}
