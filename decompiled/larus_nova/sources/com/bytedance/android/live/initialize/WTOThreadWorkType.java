package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOThreadWorkType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CPU_FIXED", "IO", "TIME_CLOCK", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOThreadWorkType extends Enum<WTOThreadWorkType> {
    public static final WTOThreadWorkType CPU_FIXED = null;
    public static final WTOThreadWorkType IO = null;
    public static final WTOThreadWorkType TIME_CLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WTOThreadWorkType[] f69373a = null;
    private final String tag;

    static {
        WTOThreadWorkType r100 = new WTOThreadWorkType("CPU_FIXED", 0, "CPU_FIXED");
        CPU_FIXED = r100;
        WTOThreadWorkType r101 = new WTOThreadWorkType("IO", 1, "IO");
        IO = r101;
        WTOThreadWorkType r102 = new WTOThreadWorkType("TIME_CLOCK", 2, "TIME_CLOCK");
        TIME_CLOCK = r102;
        f69373a = new WTOThreadWorkType[]{r100, r101, r102};
    }

    public static WTOThreadWorkType valueOf(String r100) {
        return (WTOThreadWorkType) r27.a.a(WTOThreadWorkType.class, r100);
    }

    public static WTOThreadWorkType[] values() {
        return (WTOThreadWorkType[]) f69373a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOThreadWorkType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
