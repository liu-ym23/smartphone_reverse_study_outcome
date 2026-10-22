package com.bytedance.android.livehostapi.business.depend.xplay;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface;", "", "initGameBizMsgListener", "", "registerReceiveMsgListener", "listener", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface$ReceiveMsgListener;", "sendFrequentCustomMessage", "msg", "", "sendMsgWithListener", "Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface$SendMsgListener;", "ReceiveMsgListener", "SendMsgListener", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXplayMessageInterface {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface$ReceiveMsgListener;", "", "onReceiveCustomMsg", "", "msg", "", "onReceiveExitGameRequest", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ReceiveMsgListener {
        void onReceiveCustomMsg(String r100);

        void onReceiveExitGameRequest();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/xplay/IXplayMessageInterface$SendMsgListener;", "", "onSendResult", "", "success", "", "code", "", "message", "", OnekeyLoginConstants.CU_KEY_SEQ, "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface SendMsgListener {
        void onSendResult(boolean r100, int r101, String r102, String r103);
    }

    void initGameBizMsgListener();

    void registerReceiveMsgListener(ReceiveMsgListener r100);

    void sendFrequentCustomMessage(String r100);

    void sendMsgWithListener(String r100, SendMsgListener r101);
}
