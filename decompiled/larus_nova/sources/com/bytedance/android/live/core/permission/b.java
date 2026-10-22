package com.bytedance.android.live.core.permission;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements o60.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment.b f65130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment f65131b;

    @Override // o60.b
    public final void cancel() {
        this.f65130a.c();
    }

    @Override // o60.b
    public final void execute() {
        PermissionFragment r100 = this.f65131b;
        PermissionFragment.b r101 = this.f65130a;
        int r102 = PermissionFragment.f65109c;
        r100.getClass();
        int r103 = m60.a.a(r101.f65115b) & 65535;
        r100.f65110a.put(r103, r101);
        r100.requestPermissions(r101.f65116c, r103);
    }

    public b(PermissionFragment r100, PermissionFragment.b r101) {
        this.f65131b = r100;
        this.f65130a = r101;
    }
}
