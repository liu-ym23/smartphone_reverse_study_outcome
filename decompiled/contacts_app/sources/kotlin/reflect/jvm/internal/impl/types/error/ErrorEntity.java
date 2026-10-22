package kotlin.reflect.jvm.internal.impl.types.error;

/* JADX INFO: compiled from: ErrorEntity.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum ErrorEntity extends Enum<ErrorEntity> {
    private static final /* synthetic */ ErrorEntity[] $VALUES = null;
    public static final ErrorEntity ERROR_CLASS = null;
    public static final ErrorEntity ERROR_FUNCTION = null;
    public static final ErrorEntity ERROR_MODULE = null;
    public static final ErrorEntity ERROR_PROPERTY = null;
    public static final ErrorEntity ERROR_SCOPE = null;
    public static final ErrorEntity ERROR_TYPE = null;
    public static final ErrorEntity PARENT_OF_ERROR_SCOPE = null;
    private final String debugText;

    private static final /* synthetic */ ErrorEntity[] $values() {
        return new ErrorEntity[]{ERROR_CLASS, ERROR_FUNCTION, ERROR_SCOPE, ERROR_MODULE, ERROR_PROPERTY, ERROR_TYPE, PARENT_OF_ERROR_SCOPE};
    }

    public static ErrorEntity valueOf(String r1) {
        return (ErrorEntity) Enum.valueOf(ErrorEntity.class, r1);
    }

    public static ErrorEntity[] values() {
        return (ErrorEntity[]) $VALUES.clone();
    }

    private ErrorEntity(String r1, int r2, String r3) {
        super(r1, r2);
        this.debugText = r3;
    }

    public final String getDebugText() {
        return this.debugText;
    }

    static {
        ERROR_CLASS = new ErrorEntity("ERROR_CLASS", 0, "<Error class: %s>");
        ERROR_FUNCTION = new ErrorEntity("ERROR_FUNCTION", 1, "<Error function>");
        ERROR_SCOPE = new ErrorEntity("ERROR_SCOPE", 2, "<Error scope>");
        ERROR_MODULE = new ErrorEntity("ERROR_MODULE", 3, "<Error module>");
        ERROR_PROPERTY = new ErrorEntity("ERROR_PROPERTY", 4, "<Error property>");
        ERROR_TYPE = new ErrorEntity("ERROR_TYPE", 5, "[Error type: %s]");
        PARENT_OF_ERROR_SCOPE = new ErrorEntity("PARENT_OF_ERROR_SCOPE", 6, "<Fake parent for error lexical scope>");
        $VALUES = $values();
    }
}
