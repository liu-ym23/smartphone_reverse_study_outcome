package com.bytedance.android.shopping.anchorv4.ai;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.base.api.ai.MiniAppConfig;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f165676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0 f165677b;

    public static final class a {
    }

    static {
    }

    public final void a(String r110) {
        MiniAppConfig r100 = this.f165676a.getMiniAppConfig();
        if (r100 == null) goto L19;
        String r101 = r100.getAppKey();
        if (r101 == null) goto L20;
        String r102 = this.f165677b.b();
        if (r102 != null) goto L10;
        return;
    L10:
        JSONObject r103 = new JSONObject();
        r103.put("source", "user");
        r103.put("action", r110);
        r103.put("target_type", "product");
        String r111 = this.f165677b.f();
        String r104 = "";
        if (r111 != null) goto L13;
        r111 = "";
    L13:
        r103.put("target_name", r111);
        String r112 = this.f165677b.getProductId();
        if (r112 == null) goto L17;
        r104 = r112;
    L17:
        r103.put("target_id", r104);
        String r105 = r103.toString();
        this.f165676a.reportLog(new AIStateLogRequest(r101, r102, r105, null, ECAIConstants.SCENE_ECOM_PRODUCT, 8, null));
        return;
    L20:
        return;
    }

    public n0(p0 r100, k0 r101) {
        Intrinsics.checkNotNullParameter(r100, "gateway");
        Intrinsics.checkNotNullParameter(r101, "host");
        this.f165676a = r100;
        this.f165677b = r101;
    }
}
