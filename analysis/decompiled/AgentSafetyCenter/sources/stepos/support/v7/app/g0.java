package stepos.support.v7.app;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class g0 extends i {

    /* renamed from: c, reason: collision with root package name */
    public f0 f12316c;

    @Override // android.app.Dialog
    public final void show() {
        boolean zBooleanValue;
        try {
            zBooleanValue = ((Boolean) u9.g.b("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).f14264a.invoke(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
        } catch (Exception unused) {
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            super.show();
            return;
        }
        f0 f0Var = this.f12316c;
        if (f0Var != null) {
            f0Var.onPermissionClick(this, false, true);
        }
    }
}
