package com.bytedance.android.livehostapi.business.depend.gamecp;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/gamecp/IFlowTipsDialogListener;", "", "onContinue", "", LynxVideoManagerLite.EVENT_ON_ERROR, "error", "", "msg", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "onWaitWifi", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFlowTipsDialogListener {
    void onContinue();

    void onError(Integer r100, String r101);

    void onWaitWifi();
}
