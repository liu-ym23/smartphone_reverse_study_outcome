package com.bytedance.android.live.core.viewholder;

import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final enum ViewUnitMessageHandler$ReturnSign extends Enum<ViewUnitMessageHandler$ReturnSign> {
    public static final ViewUnitMessageHandler$ReturnSign RESULT_INTERREPT = null;
    public static final ViewUnitMessageHandler$ReturnSign RESULT_NEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ViewUnitMessageHandler$ReturnSign[] f66557a = null;

    static {
        ViewUnitMessageHandler$ReturnSign r100 = new ViewUnitMessageHandler$ReturnSign("RESULT_NEXT", 0);
        RESULT_NEXT = r100;
        ViewUnitMessageHandler$ReturnSign r101 = new ViewUnitMessageHandler$ReturnSign("RESULT_INTERREPT", 1);
        RESULT_INTERREPT = r101;
        f66557a = new ViewUnitMessageHandler$ReturnSign[]{r100, r101};
    }

    public static ViewUnitMessageHandler$ReturnSign[] values() {
        return (ViewUnitMessageHandler$ReturnSign[]) f66557a.clone();
    }

    public static ViewUnitMessageHandler$ReturnSign valueOf(String r100) {
        return (ViewUnitMessageHandler$ReturnSign) a.a(ViewUnitMessageHandler$ReturnSign.class, r100);
    }

    public ViewUnitMessageHandler$ReturnSign(String r100, int r101) {
        super(r100, r101);
    }
}
