package com.android.ttcjpaysdk.ttcjpayapi;

import com.android.ttcjpaysdk.bdpay.counter.outer.preload.DyOuterPayPreloadManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/CarrierFetchScene;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PREFETCH", DyOuterPayPreloadManager.VIEW_TAG, "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CarrierFetchScene extends Enum<CarrierFetchScene> {
    private static final /* synthetic */ CarrierFetchScene[] $VALUES = null;
    public static final CarrierFetchScene PREFETCH = null;
    public static final CarrierFetchScene USE = null;
    private final String value;

    private static final /* synthetic */ CarrierFetchScene[] $values() {
        return new CarrierFetchScene[]{PREFETCH, USE};
    }

    public static CarrierFetchScene valueOf(String r100) {
        return (CarrierFetchScene) a.a(CarrierFetchScene.class, r100);
    }

    public static CarrierFetchScene[] values() {
        return (CarrierFetchScene[]) $VALUES.clone();
    }

    static {
        PREFETCH = new CarrierFetchScene("PREFETCH", 0, ErrorType.PREFETCH);
        USE = new CarrierFetchScene(DyOuterPayPreloadManager.VIEW_TAG, 1, NameKeys.LoadStrategy_Use);
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private CarrierFetchScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
