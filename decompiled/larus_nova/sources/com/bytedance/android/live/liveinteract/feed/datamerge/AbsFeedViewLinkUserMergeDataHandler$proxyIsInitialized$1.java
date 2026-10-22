package com.bytedance.android.live.liveinteract.feed.datamerge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class AbsFeedViewLinkUserMergeDataHandler$proxyIsInitialized$1 extends MutablePropertyReference0Impl {
    public AbsFeedViewLinkUserMergeDataHandler$proxyIsInitialized$1(a r100) {
        super(r100, a.class, "proxy", "getProxy()Lcom/bytedance/android/live/liveinteract/feed/datamerge/IFeedViewLinkUserMergeDataCenterProxy;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        return ((a) this.receiver).c();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        a r101 = (a) this.receiver;
        k r102 = (k) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f72943a = r102;
    }
}
