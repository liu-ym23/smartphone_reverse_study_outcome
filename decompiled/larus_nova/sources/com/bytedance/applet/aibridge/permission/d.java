package com.bytedance.applet.aibridge.permission;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b f191410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionMethod f191411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f191412c;

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogShow() {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onSettingPageReturn() {
        if (this.f191412c == false) goto L5;
        int r100 = uv3.c.f551810a;
        boolean r101 = uv3.c.a(AppHost.f326268a.getApplication());
    L6:
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191410a.getPermission() + " return from setting page, result: " + r101);
        RequestPermissionMethod r102 = this.f191411b;
        AbsRequestPermissionMethodIDL.b r103 = this.f191410a;
        int r104 = RequestPermissionMethod.f191397b;
        r102.getClass();
        RequestPermissionMethod.c(r103, r101);
        return;
    L5:
        int r105 = uv3.c.f551810a;
        r101 = uv3.c.b(AppHost.f326268a.getApplication());
        goto L6
    }

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogDismiss(boolean r100) {
        if (r100 == true) goto L5;
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191410a.getPermission() + " onGoSettingsDialogRefused");
        RequestPermissionMethod r101 = this.f191411b;
        AbsRequestPermissionMethodIDL.b r102 = this.f191410a;
        int r103 = RequestPermissionMethod.f191397b;
        r101.getClass();
        RequestPermissionMethod.c(r102, false);
        return;
    }

    public d(AbsRequestPermissionMethodIDL.b r100, RequestPermissionMethod r101, boolean r102) {
        this.f191410a = r100;
        this.f191411b = r101;
        this.f191412c = r102;
    }

    @Override // com.larus.platform.api.g1.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        if (r103 == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191410a.getPermission() + " onResult: " + r100);
        RequestPermissionMethod r104 = this.f191411b;
        AbsRequestPermissionMethodIDL.b r105 = this.f191410a;
        int r106 = RequestPermissionMethod.f191397b;
        r104.getClass();
        RequestPermissionMethod.c(r105, r100);
    }
}
