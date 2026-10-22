package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameOrderResultCallback;", "", "onFail", "", "errorInfo", "", "onSuccess", OnekeyLoginConstants.CT_KEY_RSP_DATA, "Lorg/json/JSONObject;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameOrderResultCallback {
    void onFail(String r100);

    void onSuccess(JSONObject r100);
}
