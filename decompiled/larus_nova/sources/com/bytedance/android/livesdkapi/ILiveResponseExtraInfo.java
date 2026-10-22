package com.bytedance.android.livesdkapi;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfo;", "", "serverTimestamp", "", "getServerTimestamp", "()J", "statusInfo", "Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfo$IStatusInfo;", "getStatusInfo", "()Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfo$IStatusInfo;", "IStatusInfo", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveResponseExtraInfo {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/ILiveResponseExtraInfo$IStatusInfo;", "", "code", "", "getCode", "()I", "message", "", "getMessage", "()Ljava/lang/String;", "prompts", "getPrompts", "verifyConfig", "getVerifyConfig", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IStatusInfo {
        int getCode();

        String getMessage();

        String getPrompts();

        String getVerifyConfig();
    }

    long getServerTimestamp();

    IStatusInfo getStatusInfo();
}
