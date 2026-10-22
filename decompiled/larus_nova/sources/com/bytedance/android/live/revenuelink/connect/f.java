package com.bytedance.android.live.revenuelink.connect;

import androidx.lifecycle.LiveData;
import com.bytedance.android.livesdk.link.model.bridge.r1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public interface f {
    void addLinkInListener(int r100, i r101);

    void addLinkOutListener(int r100, m r101);

    LiveData<ey.f> connectState();

    void fetchMultiChannelInfo(int r100, boolean r101, String r102, String r103, Function1<? super r1, Unit> r104, Function1<? super Throwable, Unit> r105);

    l linkInManager();

    n linkOutManager();

    void registerRefuseStrategy(int r100, q r101);

    void removeLinkInListener(int r100, i r101);

    void removeLinkOutListener(int r100, m r101);
}
