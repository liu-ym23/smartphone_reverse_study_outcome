package kotlin.reflect.jvm.internal.impl.types.model;

import h9.InterfaceC4149a;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class CaptureStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ CaptureStatus[] $VALUES;
    public static final CaptureStatus FOR_SUBTYPING = new CaptureStatus("FOR_SUBTYPING", 0);
    public static final CaptureStatus FOR_INCORPORATION = new CaptureStatus("FOR_INCORPORATION", 1);
    public static final CaptureStatus FROM_EXPRESSION = new CaptureStatus("FROM_EXPRESSION", 2);

    private static final /* synthetic */ CaptureStatus[] $values() {
        return new CaptureStatus[]{FOR_SUBTYPING, FOR_INCORPORATION, FROM_EXPRESSION};
    }

    static {
        CaptureStatus[] captureStatusArr$values = $values();
        $VALUES = captureStatusArr$values;
        $ENTRIES = a.a(captureStatusArr$values);
    }

    private CaptureStatus(String str, int i10) {
    }

    public static CaptureStatus valueOf(String str) {
        return (CaptureStatus) Enum.valueOf(CaptureStatus.class, str);
    }

    public static CaptureStatus[] values() {
        return (CaptureStatus[]) $VALUES.clone();
    }
}
