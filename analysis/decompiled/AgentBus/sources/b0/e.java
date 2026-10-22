package b0;

/* loaded from: classes.dex */
public class e implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1131f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1132g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1133h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f1134i;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i2) {
        this.f1131f = i2;
        this.f1132g = obj;
        this.f1133h = obj2;
        this.f1134i = obj3;
    }

    public static /* synthetic */ void a(int i2) {
        String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "map";
        } else if (i2 == 2) {
            objArr[0] = "compute";
        } else if (i2 == 3 || i2 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 3) {
            objArr[1] = "recursionDetected";
        } else if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
        } else {
            objArr[1] = "raceCondition";
        }
        if (i2 != 3 && i2 != 4) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public AssertionError d(Object obj, Object obj2) {
        AssertionError assertionError = new AssertionError("Race condition detected on input " + obj + ". Old value is " + obj2 + " under " + ((u9.k) this.f1132g));
        u9.k.e(assertionError);
        return assertionError;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:11:0x0028, B:14:0x0033, B:16:0x0039, B:18:0x003d, B:23:0x0048, B:24:0x004b, B:26:0x004e, B:28:0x0054, B:30:0x0058, B:31:0x005b, B:32:0x005e, B:34:0x0061, B:48:0x0085, B:51:0x008d, B:53:0x0098, B:54:0x009c, B:55:0x009d, B:56:0x00a0, B:57:0x00a1, B:58:0x00a4, B:59:0x00a5, B:60:0x00aa, B:37:0x0068, B:41:0x0077, B:45:0x007f, B:46:0x0083), top: B:74:0x0028, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    @Override // p7.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.e.invoke(java.lang.Object):java.lang.Object");
    }
}
