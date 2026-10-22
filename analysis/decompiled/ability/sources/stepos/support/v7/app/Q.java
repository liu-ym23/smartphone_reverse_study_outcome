package stepos.support.v7.app;

/* loaded from: classes4.dex */
public final class Q extends DialogInterfaceC1961j {

    /* renamed from: a, reason: collision with root package name */
    public P f6232a;

    @Override // android.app.Dialog
    public final void show() {
        boolean zBooleanValue;
        try {
            zBooleanValue = ((Boolean) a5.g.b("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).f1642a.invoke(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            super.show();
            return;
        }
        P p = this.f6232a;
        if (p != null) {
            p.onPermissionClick(this, false, true);
        }
    }
}
