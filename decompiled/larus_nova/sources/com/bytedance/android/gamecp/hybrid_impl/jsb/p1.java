package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openGameCPPhotoAlbum")
public final class p1 extends m0<y4, OpenGameCPPhotoAlbumResultModel> {

    public static final class a {
    }

    static {
    }

    public p1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        y4 r102 = (y4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openGameCPPhotoAlbum", GsonProtectorUtils.toJson(new Gson(), r102));
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L7
        r103.put("max_image_count", r102.d());     // Catch: Exception -> L7
        r103.put("privacy_cert", r102.f());     // Catch: Exception -> L7
        r103.put("bottom_view_title", r102.a());     // Catch: Exception -> L7
        r103.put("next_button_title", r102.e());     // Catch: Exception -> L7
        r103.put("limit_tips", r102.b());     // Catch: Exception -> L7
        r103.put("selected_image_count", r102.g());     // Catch: Exception -> L7
        r103.put("max_file_size", r102.c());     // Catch: Exception -> L7
        q1 r104 = new q1(this);     // Catch: Exception -> L7
        xr.f r105 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L7
        if (r105 == null) goto L11;
        r105.R1(r101.getContext(), r103, r104);     // Catch: Exception -> L7
        return;
    L11:
        return;
    L7:
        OpenGameCPPhotoAlbumResultModel r106 = new OpenGameCPPhotoAlbumResultModel();
        r106.a(OpenGameCPPhotoAlbumResultModel.Code.Failed);
        JSONObject r107 = new JSONObject();
        r107.put("error_reason", "client crash");
        Unit r108 = Unit.INSTANCE;
        r106.c(r107.toString());
        finishWithResult(r106);
    }
}
