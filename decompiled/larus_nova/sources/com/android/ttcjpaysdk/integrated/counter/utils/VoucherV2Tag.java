package com.android.ttcjpaysdk.integrated.counter.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/utils/VoucherV2Tag;", "", "(Ljava/lang/String;I)V", "TAG12", "TAG34", "TAG56", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum VoucherV2Tag extends Enum<VoucherV2Tag> {
    private static final /* synthetic */ VoucherV2Tag[] $VALUES = null;
    public static final VoucherV2Tag TAG12 = null;
    public static final VoucherV2Tag TAG34 = null;
    public static final VoucherV2Tag TAG56 = null;

    private static final /* synthetic */ VoucherV2Tag[] $values() {
        return new VoucherV2Tag[]{TAG12, TAG34, TAG56};
    }

    public static VoucherV2Tag valueOf(String r100) {
        return (VoucherV2Tag) a.a(VoucherV2Tag.class, r100);
    }

    public static VoucherV2Tag[] values() {
        return (VoucherV2Tag[]) $VALUES.clone();
    }

    static {
        TAG12 = new VoucherV2Tag("TAG12", 0);
        TAG34 = new VoucherV2Tag("TAG34", 1);
        TAG56 = new VoucherV2Tag("TAG56", 2);
        $VALUES = $values();
    }

    private VoucherV2Tag(String r100, int r101) {
        super(r100, r101);
    }
}
