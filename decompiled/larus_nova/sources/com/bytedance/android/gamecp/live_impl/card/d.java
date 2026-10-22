package com.bytedance.android.gamecp.live_impl.card;

import com.bytedance.android.gamecp.host_api.model.introducecard.IntroduceRuleType;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f57876a = null;

    static {
        int[] r100 = new int[IntroduceRuleType.values().length];
        f57876a = r100;
        r100[IntroduceRuleType.DOWNLOADING.ordinal()] = 1;
        r100[IntroduceRuleType.INSTALL_CANCEL.ordinal()] = 2;
        r100[IntroduceRuleType.INSTALL_UNFINISHED.ordinal()] = 3;
    }
}
