package com.bytedance.android.livesdk.pannel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/CloseType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SystemBack", "PullDown", "MaskClick", "UnKnown", "panel_release"}, k = 1, mv = {1, 4, 0})
public final enum CloseType extends Enum<CloseType> {
    public static final CloseType MaskClick = null;
    public static final CloseType PullDown = null;
    public static final CloseType SystemBack = null;
    public static final CloseType UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloseType[] f154301a = null;
    private final String tag;

    static {
        CloseType r100 = new CloseType("SystemBack", 0, "systemBack");
        SystemBack = r100;
        CloseType r101 = new CloseType("PullDown", 1, "pullDown");
        PullDown = r101;
        CloseType r102 = new CloseType("MaskClick", 2, "maskClick");
        MaskClick = r102;
        CloseType r103 = new CloseType("UnKnown", 3, "unKnown");
        UnKnown = r103;
        f154301a = new CloseType[]{r100, r101, r102, r103};
    }

    public static CloseType valueOf(String r100) {
        return (CloseType) r27.a.a(CloseType.class, r100);
    }

    public static CloseType[] values() {
        return (CloseType[]) f154301a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public CloseType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
