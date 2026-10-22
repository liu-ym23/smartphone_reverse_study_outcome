package kotlin.reflect.jvm.internal.impl.storage;

import W8.i;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;

/* loaded from: classes4.dex */
public class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final i f5138a;
    public final S7.a b;
    public volatile Object c;

    public a(i iVar, S7.a aVar) {
        if (iVar == null) {
            a(0);
            throw null;
        }
        this.c = LockBasedStorageManager$NotValue.f5137a;
        this.f5138a = iVar;
        this.b = aVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i == 2 || i == 3) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[0] = "storageManager";
        }
        if (i == 2) {
            objArr[1] = "recursionDetected";
        } else if (i != 3) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
        } else {
            objArr[1] = "renderDebugInformation";
        }
        if (i != 2 && i != 3) {
            objArr[2] = AppAgent.CONSTRUCT;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final boolean b() {
        return (this.c == LockBasedStorageManager$NotValue.f5137a || this.c == LockBasedStorageManager$NotValue.b) ? false : true;
    }

    public void c(Object obj) {
    }

    public C4.a d(boolean z10) {
        C4.a aVarE = this.f5138a.e(null, "in a lazy value");
        if (aVarE != null) {
            return aVarE;
        }
        a(2);
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004d A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:7:0x0015, B:9:0x001b, B:15:0x002a, B:17:0x0035, B:22:0x0042, B:24:0x004a, B:25:0x004d, B:29:0x005c, B:31:0x0062, B:33:0x0066, B:34:0x006d, B:35:0x0074, B:36:0x0075, B:37:0x007b, B:26:0x004f), top: B:40:0x0015, inners: #1 }] */
    @Override // S7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke() throws java.lang.Throwable {
        /*
            r5 = this;
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue r0 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue.c
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue r1 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue.b
            java.lang.Object r2 = r5.c
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue
            if (r3 != 0) goto Le
            g9.l.l(r2)
            return r2
        Le:
            W8.i r2 = r5.f5138a
            W8.k r2 = r2.f1495a
            r2.lock()
            java.lang.Object r2 = r5.c     // Catch: java.lang.Throwable -> L26
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L28
            g9.l.l(r2)     // Catch: java.lang.Throwable -> L26
            W8.i r5 = r5.f5138a
            W8.k r5 = r5.f1495a
            r5.unlock()
            return r2
        L26:
            r0 = move-exception
            goto L7c
        L28:
            if (r2 != r1) goto L3f
            r5.c = r0     // Catch: java.lang.Throwable -> L26
            r3 = 1
            C4.a r3 = r5.d(r3)     // Catch: java.lang.Throwable -> L26
            boolean r4 = r3.b     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L3f
            java.lang.Object r0 = r3.c     // Catch: java.lang.Throwable -> L26
        L37:
            W8.i r5 = r5.f5138a
            W8.k r5 = r5.f1495a
            r5.unlock()
            return r0
        L3f:
            if (r2 != r0) goto L4d
            r0 = 0
            C4.a r0 = r5.d(r0)     // Catch: java.lang.Throwable -> L26
            boolean r2 = r0.b     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L4d
            java.lang.Object r0 = r0.c     // Catch: java.lang.Throwable -> L26
            goto L37
        L4d:
            r5.c = r1     // Catch: java.lang.Throwable -> L26
            S7.a r0 = r5.b     // Catch: java.lang.Throwable -> L5b
            java.lang.Object r0 = r0.invoke()     // Catch: java.lang.Throwable -> L5b
            r5.c(r0)     // Catch: java.lang.Throwable -> L5b
            r5.c = r0     // Catch: java.lang.Throwable -> L5b
            goto L37
        L5b:
            r0 = move-exception
            boolean r2 = g9.l.j(r0)     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L75
            java.lang.Object r2 = r5.c     // Catch: java.lang.Throwable -> L26
            if (r2 != r1) goto L6d
            g9.k r1 = new g9.k     // Catch: java.lang.Throwable -> L26
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L26
            r5.c = r1     // Catch: java.lang.Throwable -> L26
        L6d:
            W8.i r1 = r5.f5138a     // Catch: java.lang.Throwable -> L26
            W8.a r1 = r1.b     // Catch: java.lang.Throwable -> L26
            r1.getClass()     // Catch: java.lang.Throwable -> L26
            throw r0     // Catch: java.lang.Throwable -> L26
        L75:
            kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue r1 = kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager$NotValue.f5137a     // Catch: java.lang.Throwable -> L26
            r5.c = r1     // Catch: java.lang.Throwable -> L26
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L26
            throw r0     // Catch: java.lang.Throwable -> L26
        L7c:
            W8.i r5 = r5.f5138a
            W8.k r5 = r5.f1495a
            r5.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.a.invoke():java.lang.Object");
    }
}
