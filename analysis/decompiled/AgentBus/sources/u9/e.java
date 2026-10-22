package u9;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class e extends b0.e {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f10196j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(k kVar, ConcurrentHashMap concurrentHashMap, p7.k kVar2, int i2) {
        super(kVar, concurrentHashMap, kVar2, 2);
        this.f10196j = i2;
    }

    public static /* synthetic */ void a(int i2) {
        String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 3 ? 3 : 2];
        if (i2 == 1) {
            objArr[0] = "map";
        } else if (i2 == 2) {
            objArr[0] = "computation";
        } else if (i2 != 3) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        }
        if (i2 != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
        } else {
            objArr[1] = "computeIfAbsent";
        }
        if (i2 == 2) {
            objArr[2] = "computeIfAbsent";
        } else if (i2 != 3) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 3) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // b0.e, p7.k
    public Object invoke(Object obj) throws Throwable {
        switch (this.f10196j) {
            case 1:
                Object objInvoke = super.invoke(obj);
                if (objInvoke != null) {
                    return objInvoke;
                }
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull", "invoke"));
            default:
                return super.invoke(obj);
        }
    }
}
