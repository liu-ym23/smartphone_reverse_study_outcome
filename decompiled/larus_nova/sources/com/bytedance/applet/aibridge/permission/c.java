package com.bytedance.applet.aibridge.permission;

import com.larus.platform.api.g1;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.s;
import uv3.l;
import uv3.m;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b f191407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionMethod f191408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f191409c;

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogShow() {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onSettingPageReturn() {
        final boolean r100 = this.f191409c.invoke().booleanValue();
        if (r100 == false) goto L5;
        String r101 = "1";
    L6:
        s.c(r101);
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191407a.getPermission() + " return from setting page, result: " + r100);
        final RequestPermissionMethod r102 = this.f191408b;
        final AbsRequestPermissionMethodIDL.b r103 = this.f191407a;
        Function0 r104 = new m(r102, r103, r100);
        int r105 = RequestPermissionMethod.f191397b;
        r102.getClass();
        RequestPermissionMethod.d(r104);
        return;
    L5:
        r101 = "0";
        goto L6
    }

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogDismiss(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "authorize";
    L5:
        JSONObject r102 = this.f191407a.getTraceInfo();
        if (r102 != null) goto L8;
        r102 = new JSONObject();
    L8:
        s.a("set_up_popup", "system_request_permission_again", r101, r102);
        if (r100 == true) goto L12;
        s.c("0");
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191407a.getPermission() + " onGoSettingsDialogRefused");
        return;
    L12:
        return;
    L4:
        r101 = "next_time";
        goto L5
    }

    public c(AbsRequestPermissionMethodIDL.b r100, RequestPermissionMethod r101, uv3.e r102) {
        this.f191407a = r100;
        this.f191408b = r101;
        this.f191409c = r102;
    }

    @Override // com.larus.platform.api.g1.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        if (r103 == false) goto L9;
        JSONObject r104 = this.f191407a.getTraceInfo();
        if (r104 != null) goto L7;
        r104 = new JSONObject();
    L7:
        s.b("set_up_popup", "system_request_permission_again", r104);
        return;
    L9:
        if (r100 == false) goto L11;
        String r105 = "1";
    L12:
        s.c(r105);
        FLogger.f375446a.i("RequestPermissionMethod", "requestPermission " + this.f191407a.getPermission() + " onResult: " + r100);
        if (r100 == false) goto L16;
        final RequestPermissionMethod r106 = this.f191408b;
        final AbsRequestPermissionMethodIDL.b r107 = this.f191407a;
        Function0 r108 = new l(r106, r107);
        int r109 = RequestPermissionMethod.f191397b;
        r106.getClass();
        RequestPermissionMethod.d(r108);
        return;
    L16:
        return;
    L11:
        r105 = "0";
        goto L12
    }
}
