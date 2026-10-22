package com.byted.mgl.merge.service.api.aweme;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/byted/mgl/merge/service/api/aweme/OnInvitePanelCallback;", "", "onClose", "", "closeType", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errMsg", "", "onInviteClick", "onInviteFail", "onInviteSuccess", "result", "Lorg/json/JSONObject;", SendEventContainerMethodParamModel.EventKinds.onShow, "bdp-service-api_release"}, k = 1, mv = {1, 1, 18})
public interface OnInvitePanelCallback {
    void onClose(int r100);

    void onError(String r100);

    void onInviteClick();

    void onInviteFail(String r100);

    void onInviteSuccess(JSONObject r100);

    void onShow();
}
