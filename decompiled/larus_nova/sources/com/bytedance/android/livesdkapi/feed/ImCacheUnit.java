package com.bytedance.android.livesdkapi.feed;

import kotlin.Metadata;
import tlc.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ImCacheUnit;", "", "Ltlc/d;", "message", "", "doHandle", "", "getTag", "()Ljava/lang/String;", "tag", "getMessageMethod", "messageMethod", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ImCacheUnit {
    void doHandle(d r100);

    String getMessageMethod();

    String getTag();
}
