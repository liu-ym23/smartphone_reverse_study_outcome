package com.bytedance.android.gamecp.common.permission;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements uu.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment.b f56732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment f56733b;

    @Override // uu.b
    public final void cancel() {
        this.f56732a.b();
    }

    @Override // uu.b
    public final void execute() {
        PermissionFragment r100 = this.f56733b;
        PermissionFragment.b r101 = this.f56732a;
        int r102 = PermissionFragment.f56712c;
        r100.getClass();
        String[] r103 = r101.f56718b;
        int r104 = 0;
        if (r103 == null) goto L13;
        int r105 = r103.length;
        int r106 = 1;
        int r107 = 0;
    L6:
        if (r107 >= r105) goto L12;
        String r108 = r103[r107];
        if (r108 != null) goto L10;
        int r109 = 0;
    L11:
        r106 = ((r106 << 5) - r106) ^ r109;
        r107 = r107 + 1;
        goto L6
    L10:
        r109 = r108.hashCode();
        goto L11
    L12:
        r104 = r106;
    L13:
        int r110 = 65535 & r104;
        r100.f56713a.put(r110, r101);
        r100.requestPermissions(r101.f56719c, r110);
    }

    public c(PermissionFragment r100, PermissionFragment.b r101) {
        this.f56733b = r100;
        this.f56732a = r101;
    }
}
