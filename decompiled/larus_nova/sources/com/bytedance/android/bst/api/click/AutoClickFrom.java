package com.bytedance.android.bst.api.click;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/bst/api/click/AutoClickFrom;", "", "(Ljava/lang/String;I)V", "LANCET", "VIEW_EVENT_TRACKER", "api_cnRelease"}, k = 1, mv = {1, 1, 16})
public final enum AutoClickFrom extends Enum<AutoClickFrom> {
    private static final /* synthetic */ AutoClickFrom[] $VALUES = null;
    public static final AutoClickFrom LANCET = null;
    public static final AutoClickFrom VIEW_EVENT_TRACKER = null;

    static {
        AutoClickFrom r100 = new AutoClickFrom("LANCET", 0);
        LANCET = r100;
        AutoClickFrom r101 = new AutoClickFrom("VIEW_EVENT_TRACKER", 1);
        VIEW_EVENT_TRACKER = r101;
        $VALUES = new AutoClickFrom[]{r100, r101};
    }

    public static AutoClickFrom valueOf(String r100) {
        return (AutoClickFrom) a.a(AutoClickFrom.class, r100);
    }

    public static AutoClickFrom[] values() {
        return (AutoClickFrom[]) $VALUES.clone();
    }

    private AutoClickFrom(String r100, int r101) {
        super(r100, r101);
    }
}
