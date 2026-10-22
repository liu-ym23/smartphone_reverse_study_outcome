package com.bytedance.android.gamecp.common.permission;

import android.app.Activity;
import java.util.Arrays;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends ru.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionFragment.b f56728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f56729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f56730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ uu.a f56731d;

    public final void a(String[] r100) {
        yr.b.b(4, "PermissionFragment", "requestPermissions use ezpermission; onPermissionDenied called,grantedList=" + Arrays.toString(r100));
        this.f56728a.b();
    }

    public b(PermissionFragment.b r100, Activity r101, String[] r102, uu.a r103) {
        this.f56728a = r100;
        this.f56729b = r101;
        this.f56730c = r102;
        this.f56731d = r103;
    }
}
