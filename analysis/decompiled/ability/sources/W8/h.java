package W8;

/* loaded from: classes4.dex */
public class h extends kotlin.reflect.jvm.internal.impl.storage.a implements j {
    @Override // kotlin.reflect.jvm.internal.impl.storage.a, S7.a
    public final Object invoke() throws Throwable {
        Object objInvoke = super.invoke();
        if (objInvoke != null) {
            return objInvoke;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue", "invoke"));
    }
}
