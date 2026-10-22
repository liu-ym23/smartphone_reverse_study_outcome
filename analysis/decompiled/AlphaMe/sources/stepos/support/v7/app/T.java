package stepos.support.v7.app;

/* loaded from: classes2.dex */
public final class T extends DialogInterfaceC0865j {

    /* renamed from: a, reason: collision with root package name */
    public S f14335a;

    @Override // android.app.Dialog
    public final void show() {
        try {
            if (((Boolean) m2.i.b("android.os.SystemProperties").b("getBoolean", String.class, Boolean.TYPE).f13573a.invoke(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue()) {
                S s4 = this.f14335a;
                if (s4 != null) {
                    s4.onPermissionClick(this, false, true);
                    return;
                }
                return;
            }
        } catch (Exception unused) {
        }
        super.show();
    }
}
