package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.performance.TimeCostUtil;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ILivePlayerClient f124293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveFeedPreview f124294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LifecycleOwner f124295c;

    public c(ILivePlayerClient r100, LiveFeedPreview r101, LifecycleOwner r102) {
        this.f124293a = r100;
        this.f124294b = r101;
        this.f124295c = r102;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if ((!Intrinsics.areEqual((Boolean) r100, Boolean.TRUE)) == true) goto L10;
        mw1.f r101 = this.f124294b.f124286c;
        if (r101 == null) goto L8;
        r101.b(true);
    L8:
        Pair<Integer, Integer> r102 = this.f124293a.getVideoSize();
        LiveFeedPreview.d(this.f124294b, r102.getFirst().intValue(), r102.getSecond().intValue());
        com.bytedance.android.live.core.performance.a r103 = com.bytedance.android.live.core.performance.a.f65108a;
        TimeCostUtil.Tag.LiveFeedPreview.name();
        r103.getClass();
        int r104 = TimeCostUtil.f65106a;
        return;
    }
}
