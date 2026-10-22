package com.bytedance.android.ec.window.base.product.lynxcard;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/window/base/product/lynxcard/ECLynxCardEvent;", "", "FAILED", "TIMEOUT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECLynxCardEvent extends Enum<ECLynxCardEvent> {
    public static final ECLynxCardEvent FAILED = null;
    public static final ECLynxCardEvent TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECLynxCardEvent[] f49368a = null;

    static {
        ECLynxCardEvent r100 = new ECLynxCardEvent("FAILED", 0);
        FAILED = r100;
        ECLynxCardEvent r101 = new ECLynxCardEvent("TIMEOUT", 1);
        TIMEOUT = r101;
        f49368a = new ECLynxCardEvent[]{r100, r101};
    }

    public static ECLynxCardEvent valueOf(String r100) {
        return (ECLynxCardEvent) a.a(ECLynxCardEvent.class, r100);
    }

    public static ECLynxCardEvent[] values() {
        return (ECLynxCardEvent[]) f49368a.clone();
    }

    public ECLynxCardEvent(String r100, int r101) {
        super(r100, r101);
    }
}
