package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.ReportALogParamModel;
import com.bytedance.android.annie.bridge.method.abs.ReportALogResultModel;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "reportALog")
public final class r1 extends e7.u<ReportALogParamModel, ReportALogResultModel> {

    public static final class a {
    }

    static {
    }

    public r1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        ReportALogParamModel r112 = (ReportALogParamModel) r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = r112.c();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        ReportALogResultModel r113 = new ReportALogResultModel();
        r113.a(ReportALogResultModel.Code.InvalidParam);
        r113.b("message is null or blank");
        finishWithResult(r113);
        return;
    L12:
        if (r112.b() != null) goto L14;
        ReportALogResultModel r114 = new ReportALogResultModel();
        r114.a(ReportALogResultModel.Code.InvalidParam);
        r114.b("level is not in enum");
        finishWithResult(r114);
        return;
    L14:
        String r102 = r112.c();
        Intrinsics.checkNotNull(r102);
        String r103 = r112.d();
        ReportALogParamModel.Level r104 = r112.b();
        ReportALogParamModel.a r115 = r112.a();
        if (r115 == null) goto L17;
        Integer r105 = r115.c();
        Intrinsics.checkNotNull(r105);
        int r106 = r105.intValue();
        String r107 = r115.b();
        Intrinsics.checkNotNull(r107);
        String r116 = r115.a();
        Intrinsics.checkNotNull(r116);
        String r108 = r116;
        int r109 = r106;
        String r117 = r107;
    L23:
        int r118 = com.bytedance.android.annie.util.a.f40053a;     // Catch: IllegalArgumentException -> L20
        com.bytedance.android.annie.util.a.a(r102, r103, String.valueOf(r104), r108, r117, r109, r111.a());     // Catch: IllegalArgumentException -> L20
        ReportALogResultModel r119 = new ReportALogResultModel();     // Catch: IllegalArgumentException -> L20
        r119.a(ReportALogResultModel.Code.Success);     // Catch: IllegalArgumentException -> L20
        r119.b("Report Success !");     // Catch: IllegalArgumentException -> L20
        finishWithResult(r119);     // Catch: IllegalArgumentException -> L20
        return;
    L20:
        e = move-exception;
        b8.a r120 = b8.a.f17992a;
        b8.a.a(new b8.b("[ReportALogMethod]", LogLevel.ERROR, e, null, 8), true);
        ReportALogResultModel r121 = new ReportALogResultModel();
        r121.a(ReportALogResultModel.Code.Failed);
        r121.b("Level is illegal!");
        finishWithResult(r121);
        return;
    L17:
        r108 = "";
        r117 = r108;
        r109 = 0;
        goto L23
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
