package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenFansGroupSettingDirectResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openFansGroupSettingDirect")
public final class x2 extends w20.j4<w20.ic, OpenFansGroupSettingDirectResultModel> {

    public static final class a {
    }

    static {
    }

    public x2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.ic r102 = (w20.ic) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.a();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.b();
        String r106 = r102.c();
        if (r106 == null) goto L9;
        r104 = r106;
    L9:
        xs2.b.a().post(new zg1.b(r105, r104, r103, new WeakReference(r101.getContext())));
        finishWithSuccess();
    }
}
