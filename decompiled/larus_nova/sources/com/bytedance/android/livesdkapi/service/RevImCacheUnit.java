package com.bytedance.android.livesdkapi.service;

import kotlin.Metadata;
import yh6.c;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/RevImCacheUnit;", "", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "doHandle", "", "getTag", "()Ljava/lang/String;", "tag", "getMessageMethod", "messageMethod", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface RevImCacheUnit {
    void doHandle(c r100);

    String getMessageMethod();

    String getTag();
}
