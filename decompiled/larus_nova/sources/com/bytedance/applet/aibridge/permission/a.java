package com.bytedance.applet.aibridge.permission;

import com.bytedance.keva.Keva;
import com.larus.common_ui.dialog.u;
import org.json.JSONObject;
import tx9.s;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestPermissionMethod f191399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b f191400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f191401c;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        RequestPermissionMethod r100 = this.f191399a;
        String r101 = this.f191400b.getRequestId();
        String r102 = this.f191400b.getPermission();
        int r103 = RequestPermissionMethod.f191397b;
        r100.getClass();
        RequestPermissionMethod.e(r101, r102, false);
        s.c("0");
        ((Keva) uv3.b.f551809a.getValue()).storeBoolean("is_first_request_calendar_permission", false);
        String r104 = this.f191401c;
        JSONObject r105 = this.f191400b.getTraceInfo();
        if (r105 != null) goto L5;
        r105 = new JSONObject();
    L5:
        s.a("business_popup", r104, "next_time", r105);
    }

    public a(RequestPermissionMethod r100, AbsRequestPermissionMethodIDL.b r101, String r102) {
        this.f191399a = r100;
        this.f191400b = r101;
        this.f191401c = r102;
    }
}
