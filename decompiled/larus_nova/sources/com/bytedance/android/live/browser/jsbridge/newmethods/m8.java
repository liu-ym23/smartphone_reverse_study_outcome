package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorShowAddDialogResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openAnchorShowAddDialog")
public final class m8 extends w20.e4<w20.dc, OpenAnchorShowAddDialogResultModel> {

    public static final class a {
    }

    static {
    }

    public m8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.dc r102 = (w20.dc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IBroadcastService r103 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        Context r104 = r101.getContext();
        Integer r105 = r102.b();
        if (r105 == null) goto L5;
        int r106 = r105.intValue();
    L6:
        Integer r107 = r102.a();
        if (r107 == null) goto L9;
        int r108 = r107.intValue();
    L10:
        r103.showAddAnchorShowDialog(r104, r106, r108, new n8());
        return;
    L9:
        r108 = 10;
        goto L10
    L5:
        r106 = 20;
        goto L6
    }
}
