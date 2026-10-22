package com.bytedance.applet.aibridge.permission;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.keva.Keva;
import com.larus.common_ui.dialog.p0;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import java.util.List;
import org.json.JSONObject;
import tx9.s;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f191402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsRequestPermissionMethodIDL.b f191403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f191404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<String> f191405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f191406e;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        ((Keva) uv3.b.f551809a.getValue()).storeBoolean("is_first_request_calendar_permission", false);
        String r100 = this.f191402a;
        JSONObject r101 = this.f191403b.getTraceInfo();
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        s.a("business_popup", r100, "authorize", r101);
        i2 r102 = i2.f365748b;
        g1.a.b(this.f191404c, this.f191405d, this.f191406e, null, null, 56);
    }

    public b(String r100, AbsRequestPermissionMethodIDL.b r101, FragmentActivity r102, List<String> r103, c r104) {
        this.f191402a = r100;
        this.f191403b = r101;
        this.f191404c = r102;
        this.f191405d = r103;
        this.f191406e = r104;
    }
}
