package com.bytedance.android.livesdkapi.room.error;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/room/error/IRoomError;", "", "errMsgV2", "", "getErrMsgV2", "()Ljava/lang/String;", "setErrMsgV2", "(Ljava/lang/String;)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "roomErrorCodeV2", "getRoomErrorCodeV2", "setRoomErrorCodeV2", "getReasonV2Ext", "Lcom/bytedance/android/livesdkapi/room/error/IEndReason;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomError {
    String getErrMsgV2();

    int getErrorCode();

    IEndReason getReasonV2Ext();

    int getRoomErrorCodeV2();

    void setErrMsgV2(String r100);

    void setErrorCode(int r100);

    void setRoomErrorCodeV2(int r100);
}
