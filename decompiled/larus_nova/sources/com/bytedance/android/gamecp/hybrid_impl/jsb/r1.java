package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "uploadGameCPImage")
public final class r1 extends z0<d6, UploadGameCPImageResultModel> {

    public static final class a {
    }

    static {
    }

    public r1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        d6 r102 = (d6) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("uploadGameCPImage", GsonProtectorUtils.toJson(new Gson(), r102));
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L16
        UploadGameCPImageResultModel.a r104 = new UploadGameCPImageResultModel.a();     // Catch: Exception -> L16
        List<d6.a> r105 = r102.a();     // Catch: Exception -> L16
        if (r105 == null) goto L10;
        Iterator<T> r106 = r105.iterator();     // Catch: Exception -> L16
    L7:
        if (r106.hasNext() == false) goto L10;
        d6.a r107 = (d6.a) r106.next();     // Catch: Exception -> L16
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L16
        r108.put("key", r107.a());     // Catch: Exception -> L16
        r108.put("raw_data_url", r107.b());     // Catch: Exception -> L16
        r103.add(r108);     // Catch: Exception -> L16
    L10:
        if (r103.isEmpty() == false) goto L12;
        UploadGameCPImageResultModel r109 = new UploadGameCPImageResultModel();     // Catch: Exception -> L16
        r109.a(UploadGameCPImageResultModel.Code.Success);     // Catch: Exception -> L16
        r109.b(null);     // Catch: Exception -> L16
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L16
        finishWithResult(r109);     // Catch: Exception -> L16
    L12:
        ArrayList r111 = new ArrayList();     // Catch: Exception -> L16
        xr.f r112 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L16
        if (r112 == null) goto L21;
        r112.u0(r101.getContext(), r103, new s1(this, r111, r104));     // Catch: Exception -> L16
        return;
    L21:
        return;
    L16:
        UploadGameCPImageResultModel r113 = new UploadGameCPImageResultModel();
        r113.a(UploadGameCPImageResultModel.Code.Failed);
        JSONObject r114 = new JSONObject();
        r114.put("error_reason", "client crash");
        Unit r115 = Unit.INSTANCE;
        r113.c(r114.toString());
        finishWithResult(r113);
    }
}
