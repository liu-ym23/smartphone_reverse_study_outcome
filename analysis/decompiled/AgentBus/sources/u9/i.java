package u9;

/* loaded from: classes.dex */
public class i extends h implements l {
    @Override // u9.h, p7.a
    public final Object c() throws Throwable {
        Object objC = super.c();
        if (objC != null) {
            return objC;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "invoke"));
    }
}
