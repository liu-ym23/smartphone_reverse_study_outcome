package com.stepos.ame.api;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ame/api/QuantizationType;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "FP16", "INT8", "INT4", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class QuantizationType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ QuantizationType[] $VALUES;
    public static final QuantizationType NONE = new QuantizationType(ModelFlowMeta.PLAN_NONE, 0);
    public static final QuantizationType FP16 = new QuantizationType("FP16", 1);
    public static final QuantizationType INT8 = new QuantizationType("INT8", 2);
    public static final QuantizationType INT4 = new QuantizationType("INT4", 3);

    private static final /* synthetic */ QuantizationType[] $values() {
        return new QuantizationType[]{NONE, FP16, INT8, INT4};
    }

    static {
        QuantizationType[] quantizationTypeArr$values = $values();
        $VALUES = quantizationTypeArr$values;
        $ENTRIES = a.a(quantizationTypeArr$values);
    }

    private QuantizationType(String str, int i10) {
    }

    public static InterfaceC4149a<QuantizationType> getEntries() {
        return $ENTRIES;
    }

    public static QuantizationType valueOf(String str) {
        return (QuantizationType) Enum.valueOf(QuantizationType.class, str);
    }

    public static QuantizationType[] values() {
        return (QuantizationType[]) $VALUES.clone();
    }
}
