package u9;

/* loaded from: classes.dex */
public final class d extends h implements l {

    /* renamed from: i, reason: collision with root package name */
    public volatile nb.f f10194i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r8.c f10195j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(k kVar, t9.h hVar, r8.c cVar) {
        super(kVar, hVar);
        this.f10195j = cVar;
        if (kVar == null) {
            h(0);
            throw null;
        }
        this.f10194i = null;
    }

    public static /* synthetic */ void a(int i2) {
        String str = i2 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i2 != 2 ? 2 : 3];
        if (i2 != 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        } else {
            objArr[0] = "value";
        }
        if (i2 != 2) {
            objArr[1] = "recursionDetected";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        }
        if (i2 == 2) {
            objArr[2] = "doPostCompute";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static /* synthetic */ void h(int i2) {
        String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 2 ? 3 : 2];
        if (i2 == 1) {
            objArr[0] = "computable";
        } else if (i2 != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        }
        if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        } else {
            objArr[1] = "invoke";
        }
        if (i2 != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i2 == 2) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // u9.h, p7.a
    public final Object c() throws Throwable {
        Object objC;
        nb.f fVar = this.f10194i;
        if (fVar == null || ((Thread) fVar.f6948h) != Thread.currentThread()) {
            objC = super.c();
        } else {
            if (((Thread) fVar.f6948h) != Thread.currentThread()) {
                throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
            }
            objC = fVar.f6947g;
        }
        if (objC != null) {
            return objC;
        }
        h(2);
        throw null;
    }

    @Override // u9.h
    public final void d(Object obj) {
        this.f10194i = new nb.f(obj);
        try {
            if (obj != null) {
                this.f10195j.invoke(obj);
            } else {
                a(2);
                throw null;
            }
        } finally {
            this.f10194i = null;
        }
    }

    @Override // u9.h
    public final a7.c f(boolean z4) {
        return new a7.c(new v9.e(a.a.S(x9.i.f11326d)), false, 3);
    }
}
