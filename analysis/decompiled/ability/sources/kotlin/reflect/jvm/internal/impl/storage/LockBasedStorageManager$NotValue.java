package kotlin.reflect.jvm.internal.impl.storage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class LockBasedStorageManager$NotValue {

    /* renamed from: a, reason: collision with root package name */
    public static final LockBasedStorageManager$NotValue f5137a;
    public static final LockBasedStorageManager$NotValue b;
    public static final LockBasedStorageManager$NotValue c;
    public static final /* synthetic */ LockBasedStorageManager$NotValue[] d;

    static {
        LockBasedStorageManager$NotValue lockBasedStorageManager$NotValue = new LockBasedStorageManager$NotValue("NOT_COMPUTED", 0);
        f5137a = lockBasedStorageManager$NotValue;
        LockBasedStorageManager$NotValue lockBasedStorageManager$NotValue2 = new LockBasedStorageManager$NotValue("COMPUTING", 1);
        b = lockBasedStorageManager$NotValue2;
        LockBasedStorageManager$NotValue lockBasedStorageManager$NotValue3 = new LockBasedStorageManager$NotValue("RECURSION_WAS_DETECTED", 2);
        c = lockBasedStorageManager$NotValue3;
        d = new LockBasedStorageManager$NotValue[]{lockBasedStorageManager$NotValue, lockBasedStorageManager$NotValue2, lockBasedStorageManager$NotValue3};
    }

    public static LockBasedStorageManager$NotValue valueOf(String str) {
        return (LockBasedStorageManager$NotValue) Enum.valueOf(LockBasedStorageManager$NotValue.class, str);
    }

    public static LockBasedStorageManager$NotValue[] values() {
        return (LockBasedStorageManager$NotValue[]) d.clone();
    }
}
