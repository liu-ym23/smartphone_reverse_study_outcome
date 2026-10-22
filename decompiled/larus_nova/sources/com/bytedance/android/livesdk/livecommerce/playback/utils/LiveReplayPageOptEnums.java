package com.bytedance.android.livesdk.livecommerce.playback.utils;

import com.tencent.open.miniapp.MiniApp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/utils/LiveReplayPageOptEnums;", "", "", MiniApp.MINIAPP_VERSION_TRIAL, "I", "getTrial", "()I", "DEFAULT", "SINGLE_CARD", "MULTI_CARD", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveReplayPageOptEnums extends Enum<LiveReplayPageOptEnums> {
    public static final LiveReplayPageOptEnums DEFAULT = null;
    public static final LiveReplayPageOptEnums MULTI_CARD = null;
    public static final LiveReplayPageOptEnums SINGLE_CARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveReplayPageOptEnums[] f149978a = null;
    private final int trial;

    static {
        LiveReplayPageOptEnums r100 = new LiveReplayPageOptEnums("DEFAULT", 0, 0);
        DEFAULT = r100;
        LiveReplayPageOptEnums r101 = new LiveReplayPageOptEnums("SINGLE_CARD", 1, 1);
        SINGLE_CARD = r101;
        LiveReplayPageOptEnums r102 = new LiveReplayPageOptEnums("MULTI_CARD", 2, 2);
        MULTI_CARD = r102;
        f149978a = new LiveReplayPageOptEnums[]{r100, r101, r102};
    }

    public static LiveReplayPageOptEnums valueOf(String r100) {
        return (LiveReplayPageOptEnums) r27.a.a(LiveReplayPageOptEnums.class, r100);
    }

    public static LiveReplayPageOptEnums[] values() {
        return (LiveReplayPageOptEnums[]) f149978a.clone();
    }

    public final int getTrial() {
        return this.trial;
    }

    public LiveReplayPageOptEnums(String r100, int r101, int r102) {
        super(r100, r101);
        this.trial = r102;
    }
}
