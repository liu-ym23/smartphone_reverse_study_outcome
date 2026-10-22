package W8;

import H4.o;
import X8.C0274e;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import fa.C1449a;

/* loaded from: classes4.dex */
public final class d extends kotlin.reflect.jvm.internal.impl.storage.a implements j {
    public volatile C1449a d;
    public final /* synthetic */ J4.b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(i iVar, I8.e eVar, J4.b bVar) {
        super(iVar, eVar);
        this.e = bVar;
        if (iVar == null) {
            e(0);
            throw null;
        }
        this.d = null;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 2 ? 2 : 3];
        if (i != 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        } else {
            objArr[0] = "value";
        }
        if (i != 2) {
            objArr[1] = "recursionDetected";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        }
        if (i == 2) {
            objArr[2] = "doPostCompute";
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static /* synthetic */ void e(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        } else {
            objArr[1] = "invoke";
        }
        if (i != 2) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public final void c(Object obj) {
        this.d = new C1449a(obj);
        try {
            if (obj != null) {
                this.e.invoke(obj);
            } else {
                a(2);
                throw null;
            }
        } finally {
            this.d = null;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a
    public final C4.a d(boolean z10) {
        return new C4.a((Object) new C0274e(o.M(Z8.i.d)), false);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.a, S7.a
    public final Object invoke() throws Throwable {
        Object objInvoke;
        C1449a c1449a = this.d;
        if (c1449a == null || ((Thread) c1449a.c) != Thread.currentThread()) {
            objInvoke = super.invoke();
        } else {
            if (((Thread) c1449a.c) != Thread.currentThread()) {
                throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
            }
            objInvoke = c1449a.b;
        }
        if (objInvoke != null) {
            return objInvoke;
        }
        e(2);
        throw null;
    }
}
