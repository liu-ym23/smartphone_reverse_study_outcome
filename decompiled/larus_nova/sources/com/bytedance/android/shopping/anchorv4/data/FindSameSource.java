package com.bytedance.android.shopping.anchorv4.data;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/data/FindSameSource;", "", "DEFAULT", "HEAD_INDICATOR", "HEAD_VH", "DIALOG", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FindSameSource extends Enum<FindSameSource> {
    public static final FindSameSource DEFAULT = null;
    public static final FindSameSource DIALOG = null;
    public static final FindSameSource HEAD_INDICATOR = null;
    public static final FindSameSource HEAD_VH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FindSameSource[] f166375a = null;

    static {
        FindSameSource r100 = new FindSameSource("DEFAULT", 0);
        DEFAULT = r100;
        FindSameSource r101 = new FindSameSource("HEAD_INDICATOR", 1);
        HEAD_INDICATOR = r101;
        FindSameSource r102 = new FindSameSource("HEAD_VH", 2);
        HEAD_VH = r102;
        FindSameSource r103 = new FindSameSource("DIALOG", 3);
        DIALOG = r103;
        f166375a = new FindSameSource[]{r100, r101, r102, r103};
    }

    public static FindSameSource valueOf(String r100) {
        return (FindSameSource) r27.a.a(FindSameSource.class, r100);
    }

    public static FindSameSource[] values() {
        return (FindSameSource[]) f166375a.clone();
    }

    public FindSameSource(String r100, int r101) {
        super(r100, r101);
    }
}
