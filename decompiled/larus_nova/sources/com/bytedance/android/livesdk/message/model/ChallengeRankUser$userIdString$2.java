package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class ChallengeRankUser$userIdString$2 extends MutablePropertyReference0Impl {
    public ChallengeRankUser$userIdString$2(d2 r100) {
        super(r100, d2.class, "openId", "getOpenId()Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((d2) this.receiver).openId;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        String r101 = (String) r100;
        ((d2) this.receiver).openId = r101;
    }
}
