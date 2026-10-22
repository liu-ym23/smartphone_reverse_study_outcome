package androidx.compose.runtime.platform;

import S7.a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0080\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a=\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n*\f\b\u0000\u0010\u000b\"\u00020\u00002\u00020\u0000¨\u0006\f"}, d2 = {"", "ref", "makeSynchronizedObject", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Lkotlin/Function0;", "block", "synchronized", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "SynchronizedObject", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Synchronization_androidKt {
    public static final Object makeSynchronizedObject(Object obj) {
        return obj == null ? new Object() : obj;
    }

    public static /* synthetic */ Object makeSynchronizedObject$default(Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return obj == null ? new Object() : obj;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m3589synchronized(Object obj, a aVar) {
        R r5;
        synchronized (obj) {
            r5 = (R) aVar.invoke();
        }
        return r5;
    }
}
