package com.stepos.core.common.cloudconfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigResult {
    private static final /* synthetic */ sb.a $ENTRIES;
    private static final /* synthetic */ CloudConfigResult[] $VALUES;
    public static final CloudConfigResult SUCCESS = new CloudConfigResult("SUCCESS", 0);
    public static final CloudConfigResult VALUE_FORMAT_ERROR = new CloudConfigResult("VALUE_FORMAT_ERROR", 1);
    public static final CloudConfigResult FILE_IO_ERROR = new CloudConfigResult("FILE_IO_ERROR", 2);
    public static final CloudConfigResult INNER_ERROR = new CloudConfigResult("INNER_ERROR", 3);

    private static final /* synthetic */ CloudConfigResult[] $values() {
        return new CloudConfigResult[]{SUCCESS, VALUE_FORMAT_ERROR, FILE_IO_ERROR, INNER_ERROR};
    }

    static {
        CloudConfigResult[] cloudConfigResultArr$values = $values();
        $VALUES = cloudConfigResultArr$values;
        $ENTRIES = kotlin.enums.a.a(cloudConfigResultArr$values);
    }

    private CloudConfigResult(String str, int i10) {
    }

    public static sb.a<CloudConfigResult> getEntries() {
        return $ENTRIES;
    }

    public static CloudConfigResult valueOf(String str) {
        return (CloudConfigResult) Enum.valueOf(CloudConfigResult.class, str);
    }

    public static CloudConfigResult[] values() {
        return (CloudConfigResult[]) $VALUES.clone();
    }
}
