package com.ttnet.org.chromium.base.compat;

import android.telephony.CellInfo;
import android.telephony.TelephonyManager;
import com.ttnet.org.chromium.base.Callback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class ApiHelperForQ$1 extends TelephonyManager.CellInfoCallback {
    final /* synthetic */ Callback val$callback;

    ApiHelperForQ$1(Callback r3) {
        this.val$callback = (Callback) ZeusTransformUtils.wrapperContextForParams(r3, Callback.class, "com.obric.aiagent.plugin");
    }

    @Override // android.telephony.TelephonyManager.CellInfoCallback
    public void onCellInfo(List<CellInfo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.val$callback.a(r4);
    }
}
