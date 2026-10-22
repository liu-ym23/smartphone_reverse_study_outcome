package com.bytedance.android.live.revlink.impl.audience;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/audience/SeiLoadPkSource;", "", "NORMAL_SEI", "ENTER_ROOM", "UNLOAD_LINK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeiLoadPkSource extends Enum<SeiLoadPkSource> {
    public static final SeiLoadPkSource ENTER_ROOM = null;
    public static final SeiLoadPkSource NORMAL_SEI = null;
    public static final SeiLoadPkSource UNLOAD_LINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SeiLoadPkSource[] f92053a = null;

    static {
        SeiLoadPkSource r100 = new SeiLoadPkSource("NORMAL_SEI", 0);
        NORMAL_SEI = r100;
        SeiLoadPkSource r101 = new SeiLoadPkSource("ENTER_ROOM", 1);
        ENTER_ROOM = r101;
        SeiLoadPkSource r102 = new SeiLoadPkSource("UNLOAD_LINK", 2);
        UNLOAD_LINK = r102;
        f92053a = new SeiLoadPkSource[]{r100, r101, r102};
    }

    public static SeiLoadPkSource valueOf(String r100) {
        return (SeiLoadPkSource) r27.a.a(SeiLoadPkSource.class, r100);
    }

    public static SeiLoadPkSource[] values() {
        return (SeiLoadPkSource[]) f92053a.clone();
    }

    public SeiLoadPkSource(String r100, int r101) {
        super(r100, r101);
    }
}
