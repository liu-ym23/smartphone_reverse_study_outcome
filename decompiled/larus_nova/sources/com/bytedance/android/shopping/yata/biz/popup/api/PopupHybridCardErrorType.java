package com.bytedance.android.shopping.yata.biz.popup.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/yata/biz/popup/api/PopupHybridCardErrorType;", "", "FAILED", "TIMEOUT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupHybridCardErrorType extends Enum<PopupHybridCardErrorType> {
    public static final PopupHybridCardErrorType FAILED = null;
    public static final PopupHybridCardErrorType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupHybridCardErrorType[] f187513a = null;

    static {
        PopupHybridCardErrorType r100 = new PopupHybridCardErrorType("FAILED", 0);
        FAILED = r100;
        PopupHybridCardErrorType r101 = new PopupHybridCardErrorType("TIMEOUT", 1);
        TIMEOUT = r101;
        f187513a = new PopupHybridCardErrorType[]{r100, r101};
    }

    public static PopupHybridCardErrorType valueOf(String r100) {
        return (PopupHybridCardErrorType) a.a(PopupHybridCardErrorType.class, r100);
    }

    public static PopupHybridCardErrorType[] values() {
        return (PopupHybridCardErrorType[]) f187513a.clone();
    }

    public PopupHybridCardErrorType(String r100, int r101) {
        super(r100, r101);
    }
}
