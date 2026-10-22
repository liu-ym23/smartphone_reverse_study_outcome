package kotlin.reflect.jvm.internal.impl.types.model;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum CaptureStatus extends Enum<CaptureStatus> {
    private static final /* synthetic */ CaptureStatus[] $VALUES = null;
    public static final CaptureStatus FOR_INCORPORATION = null;
    public static final CaptureStatus FOR_SUBTYPING = null;
    public static final CaptureStatus FROM_EXPRESSION = null;

    private static final /* synthetic */ CaptureStatus[] $values() {
        return new CaptureStatus[]{FOR_SUBTYPING, FOR_INCORPORATION, FROM_EXPRESSION};
    }

    public static CaptureStatus valueOf(String r1) {
        return (CaptureStatus) Enum.valueOf(CaptureStatus.class, r1);
    }

    public static CaptureStatus[] values() {
        return (CaptureStatus[]) $VALUES.clone();
    }

    private CaptureStatus(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FOR_SUBTYPING = new CaptureStatus("FOR_SUBTYPING", 0);
        FOR_INCORPORATION = new CaptureStatus("FOR_INCORPORATION", 1);
        FROM_EXPRESSION = new CaptureStatus("FROM_EXPRESSION", 2);
        $VALUES = $values();
    }
}
