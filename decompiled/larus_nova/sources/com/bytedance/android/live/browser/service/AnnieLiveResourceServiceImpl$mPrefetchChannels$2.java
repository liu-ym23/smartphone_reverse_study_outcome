package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdk.w6;
import com.bytedance.android.livesdkapi.config.TTLiveWebOfflineConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnnieLiveResourceServiceImpl$mPrefetchChannels$2 extends Lambda implements Function0<List<String>> {
    public static final AnnieLiveResourceServiceImpl$mPrefetchChannels$2 INSTANCE = null;

    static {
        INSTANCE = new AnnieLiveResourceServiceImpl$mPrefetchChannels$2();
    }

    public AnnieLiveResourceServiceImpl$mPrefetchChannels$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2() {
        ArrayList r100 = new ArrayList();
        r100.addAll(TTLiveWebOfflineConfig.DOUYIN_CHANNEL_LIST);
        r100.addAll(w6.f160655a.getValue());
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<String> invoke() {
        return invoke2();
    }
}
