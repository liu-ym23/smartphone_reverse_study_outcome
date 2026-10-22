package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class ErrorEntity {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorEntity[] f5147a;

    static {
        ErrorEntity[] errorEntityArr = {new ErrorEntity("ERROR_CLASS", 0), new ErrorEntity("ERROR_FUNCTION", 1), new ErrorEntity("ERROR_SCOPE", 2), new ErrorEntity("ERROR_MODULE", 3), new ErrorEntity("ERROR_PROPERTY", 4), new ErrorEntity("ERROR_TYPE", 5), new ErrorEntity("PARENT_OF_ERROR_SCOPE", 6)};
        f5147a = errorEntityArr;
        a.a(errorEntityArr);
    }

    public static ErrorEntity valueOf(String str) {
        return (ErrorEntity) Enum.valueOf(ErrorEntity.class, str);
    }

    public static ErrorEntity[] values() {
        return (ErrorEntity[]) f5147a.clone();
    }
}
