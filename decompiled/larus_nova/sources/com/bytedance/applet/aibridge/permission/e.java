package com.bytedance.applet.aibridge.permission;

import com.bytedance.applet.utils.t;
import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b f191413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionMethod f191414b;

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogShow() {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onSettingPageReturn() {
        boolean r100 = t.a();
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191413a.getPermission() + " return from setting page, result: " + r100);
        RequestPermissionMethod r101 = this.f191414b;
        String r102 = this.f191413a.getRequestId();
        String r103 = this.f191413a.getPermission();
        int r104 = RequestPermissionMethod.f191397b;
        r101.getClass();
        RequestPermissionMethod.e(r102, r103, r100);
    }

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogDismiss(boolean r100) {
        if (r100 == true) goto L5;
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191413a.getPermission() + " onGoSettingsDialogRefused");
        RequestPermissionMethod r101 = this.f191414b;
        String r102 = this.f191413a.getRequestId();
        String r103 = this.f191413a.getPermission();
        int r104 = RequestPermissionMethod.f191397b;
        r101.getClass();
        RequestPermissionMethod.e(r102, r103, false);
        return;
    }

    public e(AbsRequestPermissionMethodIDL.b r100, RequestPermissionMethod r101) {
        this.f191413a = r100;
        this.f191414b = r101;
    }

    @Override // com.larus.platform.api.g1.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        if (r103 == false) goto L5;
        return;
    L5:
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191413a.getPermission() + " onResult: " + r100);
        RequestPermissionMethod r104 = this.f191414b;
        String r105 = this.f191413a.getRequestId();
        String r106 = this.f191413a.getPermission();
        int r107 = RequestPermissionMethod.f191397b;
        r104.getClass();
        RequestPermissionMethod.e(r105, r106, r100);
    }
}
