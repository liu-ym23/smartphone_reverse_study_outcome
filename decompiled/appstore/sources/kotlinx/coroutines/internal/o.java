package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f21614a = null;

    static {
        f21614a = new b0("CONDITION_FALSE");
    }

    public static final Object a() {
        return f21614a;
    }

    public static final LockFreeLinkedListNode b(Object r10) {
        if ((r10 instanceof v) == false) goto L5;
        v r11 = (v) r10;
    L6:
        if (r11 == null) goto L9;
        LockFreeLinkedListNode r12 = r11.f21627a;
        if (r12 == null) goto L9;
        return r12;
    L9:
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (LockFreeLinkedListNode) r10;
    L5:
        r11 = null;
        goto L6
    }
}
