package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v7 extends n<w7, LiveUpdateDiggAnimStyleResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f63690a;

    public static final class a {
    }

    static {
    }

    public v7(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f63690a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w7 r102 = (w7) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.d("LiveUpdateDiggAnimStyleMethod", "invoke : enableDiggAnimStyle:" + r102.a());
        DiggContext.a r103 = DiggContext.Companion;
        DataCenter r104 = this.f63690a;
        r103.getClass();
        DiggContext r105 = DiggContext.a.a(r104);
        if (r105 == null) goto L7;
        com.bytedance.live.datacontext.m<Boolean> r106 = r105.getVsLiveRoomDiggCountAnim();
        if (r106 == null) goto L7;
        r106.setValue(Boolean.valueOf(Intrinsics.areEqual(r102.a(), Boolean.TRUE)));
    L7:
        finishWithSuccess();
    }
}
