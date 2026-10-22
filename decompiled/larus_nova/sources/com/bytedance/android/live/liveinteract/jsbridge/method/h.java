package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveUpdateConcertStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.interfaces.IConcertUpdateStatusCallback$Code;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.jb;
import w20.p3;

/* JADX INFO: loaded from: classes46.dex */
public final class h extends p3<jb, LiveUpdateConcertStatusResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f74220a;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f74221a;

        public b(h r100) {
            this.f74221a = r100;
        }

        public final void a(IConcertUpdateStatusCallback$Code r100, String r110, JsonObject r111) {
            Intrinsics.checkNotNullParameter(r100, "errCode");
            Intrinsics.checkNotNullParameter(r110, "errMsg");
            LiveUpdateConcertStatusResultModel r101 = new LiveUpdateConcertStatusResultModel();
            LiveUpdateConcertStatusResultModel.Code[] r102 = LiveUpdateConcertStatusResultModel.Code.values();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L11;
            LiveUpdateConcertStatusResultModel.Code r105 = r102[r104];
            if (r105.getValue() != r100.getValue()) goto L7;
            boolean r106 = true;
        L8:
            if (r106 == true) goto L12;
            r104 = r104 + 1;
        L12:
            if (r105 != null) goto L14;
            r105 = LiveUpdateConcertStatusResultModel.Code.Failed;
        L14:
            r101.a(r105);
            r101.c(r110);
            r101.b(r111);
            this.f74221a.finishWithResult(r101);
            return;
        L7:
            r106 = false;
            goto L8
        L11:
            r105 = null;
            goto L12
        }
    }

    static {
    }

    public h() {
        this.f74220a = new b(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        jb r102 = (jb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        JsonObject r106 = r102.b();
        ALogger.i("DynamicUpdateConcertStatusMethod", "DynamicUpdateConcertStatusMethod#invoke: type=" + r103 + ", bizId=" + r104 + ", extra=" + r106);
        IKtvService r107 = (IKtvService) jc1.k.f(IKtvService.class);
        if (r107 == null) goto L15;
        gd2.f r108 = r107.getConcertStageService();
        if (r108 == null) goto L16;
        r108.h(new hd2.c(r104, r103, r106), this.f74220a);
        return;
    L16:
        return;
    }
}
