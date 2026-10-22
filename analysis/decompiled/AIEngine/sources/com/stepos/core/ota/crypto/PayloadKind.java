package com.stepos.core.ota.crypto;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PayloadKind {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ PayloadKind[] $VALUES;
    public static final PayloadKind ENCRYPTED = new PayloadKind("ENCRYPTED", 0);
    public static final PayloadKind PLAIN_ZIP = new PayloadKind("PLAIN_ZIP", 1);

    private static final /* synthetic */ PayloadKind[] $values() {
        return new PayloadKind[]{ENCRYPTED, PLAIN_ZIP};
    }

    static {
        PayloadKind[] payloadKindArr$values = $values();
        $VALUES = payloadKindArr$values;
        $ENTRIES = kotlin.enums.a.a(payloadKindArr$values);
    }

    private PayloadKind(String str, int i10) {
    }

    public static a<PayloadKind> getEntries() {
        return $ENTRIES;
    }

    public static PayloadKind valueOf(String str) {
        return (PayloadKind) Enum.valueOf(PayloadKind.class, str);
    }

    public static PayloadKind[] values() {
        return (PayloadKind[]) $VALUES.clone();
    }
}
