package com.stepos.agentframework.adapter.bff;

import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import r7.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "", "", "sendId", "LV4/k;", "chatReplyInfo", "LC7/r;", "onDataReceived", "(Ljava/lang/String;LV4/k;)V", "", "code", "reason", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "Lr7/k;", SettingsConfig.KEY_DATA, "", "onOriginalDataReceived", "(Ljava/lang/String;Lr7/k;)Z", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IDataCallback {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean onOriginalDataReceived(IDataCallback iDataCallback, String sendId, k kVar) {
            kotlin.jvm.internal.k.f(sendId, "sendId");
            return IDataCallback.super.onOriginalDataReceived(sendId, kVar);
        }
    }

    void onDataReceived(String sendId, V4.k chatReplyInfo);

    void onError(String sendId, int code, String reason);

    default boolean onOriginalDataReceived(String sendId, k data) {
        kotlin.jvm.internal.k.f(sendId, "sendId");
        return false;
    }
}
