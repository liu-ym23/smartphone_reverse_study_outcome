package bi7;

/* JADX INFO: loaded from: classes22.dex */
public final class f implements jta.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f19149a;

    public f() {
    }

    @Override // jta.g.a
    public final void onRemoteConfigUpdate(boolean r100, boolean r101) {
    }

    @Override // jta.g.a
    public final void onDidLoadLocally(boolean r100) {
        if (r100 == false) goto L5;
        mi7.e.a("DeviceRegisterListener", "SchemeClipboardChecker doReCheck after did load locally");
        h.g().f(h.f19153a, h.f19154b, true);
        return;
    }

    @Override // jta.g.a
    public final void onDeviceRegistrationInfoChanged(String r100, String r101) {
        mi7.e.a("DeviceRegisterListener", "SchemeClipboardChecker doReCheck onDeviceRegistrationInfoChanged");
        h.g().f(h.f19153a, h.f19154b, true);
    }
}
