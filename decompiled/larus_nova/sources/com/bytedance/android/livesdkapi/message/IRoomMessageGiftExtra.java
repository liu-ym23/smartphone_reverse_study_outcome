package com.bytedance.android.livesdkapi.message;

import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\bH&J\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H&J\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/IRoomMessageGiftExtra;", "", "", "getGiftId", "()Ljava/lang/Long;", "", "getGiftName", "getGiftCount", "Lpy/k;", "getImage", "getWebpImage", "getGroupId", "getToUserIdString", "", "getClientGiftSource", "()Ljava/lang/Integer;", "getDescribe", "getDiamondCount", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomMessageGiftExtra {
    Integer getClientGiftSource();

    String getDescribe();

    Integer getDiamondCount();

    String getGiftCount();

    Long getGiftId();

    String getGiftName();

    Long getGroupId();

    k getImage();

    String getToUserIdString();

    k getWebpImage();
}
