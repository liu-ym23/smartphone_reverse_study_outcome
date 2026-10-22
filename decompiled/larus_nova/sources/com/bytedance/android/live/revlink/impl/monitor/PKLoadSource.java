package com.bytedance.android.live.revlink.impl.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/monitor/PKLoadSource;", "", "UnKnown", "RoomEnter", "LinkerEnter", "SeiBackUp", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PKLoadSource extends Enum<PKLoadSource> {
    public static final PKLoadSource LinkerEnter = null;
    public static final PKLoadSource RoomEnter = null;
    public static final PKLoadSource SeiBackUp = null;
    public static final PKLoadSource UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PKLoadSource[] f93042a = null;

    static {
        PKLoadSource r100 = new PKLoadSource("UnKnown", 0);
        UnKnown = r100;
        PKLoadSource r101 = new PKLoadSource("RoomEnter", 1);
        RoomEnter = r101;
        PKLoadSource r102 = new PKLoadSource("LinkerEnter", 2);
        LinkerEnter = r102;
        PKLoadSource r103 = new PKLoadSource("SeiBackUp", 3);
        SeiBackUp = r103;
        f93042a = new PKLoadSource[]{r100, r101, r102, r103};
    }

    public static PKLoadSource valueOf(String r100) {
        return (PKLoadSource) r27.a.a(PKLoadSource.class, r100);
    }

    public static PKLoadSource[] values() {
        return (PKLoadSource[]) f93042a.clone();
    }

    public PKLoadSource(String r100, int r101) {
        super(r100, r101);
    }
}
