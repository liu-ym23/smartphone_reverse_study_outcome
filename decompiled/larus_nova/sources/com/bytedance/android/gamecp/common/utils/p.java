package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.gamecp.base.network.NetWorkStatusCode;
import com.bytedance.android.gamecp.base.network.exception.CustomApiServerException;
import com.bytedance.android.gamecp.base.network.response.RequestError;
import com.bytedance.android.gamecp.host_api.model.network.Extra;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes44.dex */
public final class p {
    public static void a(int r100, RequestError r101, Extra r102, String r103) throws Exception {
        b(r100, r101, GsonProtectorUtils.toJson(GsonHelper.get(), r102), r103);
        throw null;
    }

    public static void b(int r100, RequestError r101, String r102, String r103) throws Exception {
        if (r101 != null) goto L5;
        r101 = new RequestError();
        r101.prompts = y0.i(R.string.gamecp_core_ss_error_unknown);
    L5:
        if (r100 != NetWorkStatusCode.NOT_SUPPORT_FORIGNER.getValue()) goto L8;
        r101.prompts = "";
    L8:
        throw new CustomApiServerException(r100, r101.url, r103).setErrorMsg(r101.message).setPrompt(r101.prompts).setAlert(r101.alert).setBlockNotice(r101.isBlockNotice()).setExtra(r102);
    }
}
