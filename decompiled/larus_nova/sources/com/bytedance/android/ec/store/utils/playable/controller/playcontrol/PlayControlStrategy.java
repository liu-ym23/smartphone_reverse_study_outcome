package com.bytedance.android.ec.store.utils.playable.controller.playcontrol;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/store/utils/playable/controller/playcontrol/PlayControlStrategy;", "", "ORDER_FIRST", "KEEP_LAST", "ORDER_FIRST_IMAGE", "ALL_SAME", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayControlStrategy extends Enum<PlayControlStrategy> {
    public static final PlayControlStrategy ALL_SAME = null;
    public static final PlayControlStrategy KEEP_LAST = null;
    public static final PlayControlStrategy ORDER_FIRST = null;
    public static final PlayControlStrategy ORDER_FIRST_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayControlStrategy[] f48677a = null;

    static {
        PlayControlStrategy r100 = new PlayControlStrategy("ORDER_FIRST", 0);
        ORDER_FIRST = r100;
        PlayControlStrategy r101 = new PlayControlStrategy("KEEP_LAST", 1);
        KEEP_LAST = r101;
        PlayControlStrategy r102 = new PlayControlStrategy("ORDER_FIRST_IMAGE", 2);
        ORDER_FIRST_IMAGE = r102;
        PlayControlStrategy r103 = new PlayControlStrategy("ALL_SAME", 3);
        ALL_SAME = r103;
        f48677a = new PlayControlStrategy[]{r100, r101, r102, r103};
    }

    public static PlayControlStrategy valueOf(String r100) {
        return (PlayControlStrategy) a.a(PlayControlStrategy.class, r100);
    }

    public static PlayControlStrategy[] values() {
        return (PlayControlStrategy[]) f48677a.clone();
    }

    public PlayControlStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
