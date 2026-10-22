package com.stepos.agentframework.floatcard.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentframework/floatcard/api/FloatCardStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "Loading", "Success", "Warning", "Error", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FloatCardStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FloatCardStatus[] $VALUES;
    public static final FloatCardStatus Normal = new FloatCardStatus("Normal", 0);
    public static final FloatCardStatus Loading = new FloatCardStatus("Loading", 1);
    public static final FloatCardStatus Success = new FloatCardStatus("Success", 2);
    public static final FloatCardStatus Warning = new FloatCardStatus("Warning", 3);
    public static final FloatCardStatus Error = new FloatCardStatus("Error", 4);

    private static final /* synthetic */ FloatCardStatus[] $values() {
        return new FloatCardStatus[]{Normal, Loading, Success, Warning, Error};
    }

    static {
        FloatCardStatus[] floatCardStatusArr$values = $values();
        $VALUES = floatCardStatusArr$values;
        $ENTRIES = a.a(floatCardStatusArr$values);
    }

    private FloatCardStatus(String str, int i10) {
    }

    public static InterfaceC4149a<FloatCardStatus> getEntries() {
        return $ENTRIES;
    }

    public static FloatCardStatus valueOf(String str) {
        return (FloatCardStatus) Enum.valueOf(FloatCardStatus.class, str);
    }

    public static FloatCardStatus[] values() {
        return (FloatCardStatus[]) $VALUES.clone();
    }
}
