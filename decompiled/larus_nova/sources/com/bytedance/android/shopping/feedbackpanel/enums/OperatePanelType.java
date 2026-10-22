package com.bytedance.android.shopping.feedbackpanel.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feedbackpanel/enums/OperatePanelType;", "", "SHOW", "CLOSE", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OperatePanelType extends Enum<OperatePanelType> {
    public static final OperatePanelType CLOSE = null;
    public static final OperatePanelType SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperatePanelType[] f176098a = null;

    static {
        OperatePanelType r100 = new OperatePanelType("SHOW", 0);
        SHOW = r100;
        OperatePanelType r101 = new OperatePanelType("CLOSE", 1);
        CLOSE = r101;
        f176098a = new OperatePanelType[]{r100, r101};
    }

    public static OperatePanelType valueOf(String r100) {
        return (OperatePanelType) a.a(OperatePanelType.class, r100);
    }

    public static OperatePanelType[] values() {
        return (OperatePanelType[]) f176098a.clone();
    }

    public OperatePanelType(String r100, int r101) {
        super(r100, r101);
    }
}
