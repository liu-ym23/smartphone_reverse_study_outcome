package androidx.compose.ui.platform;

import androidx.autofill.HintConstants;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\n\u0010\n\u001a\u00060\u0000j\u0002`\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0081\b¢\u0006\u0004\b\r\u0010\u000e*\f\b\u0000\u0010\u0011\"\u00020\u00102\u00020\u0010¨\u0006\u0012"}, d2 = {"", "obj", "", HintConstants.AUTOFILL_HINT_NAME, "simpleIdentityToString", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "nativeClass", "(Ljava/lang/Object;)Ljava/lang/Object;", "R", "Landroidx/compose/ui/platform/SynchronizedObject;", "lock", "Lkotlin/Function0;", "block", "synchronized", "(Ljava/lang/Object;LS7/a;)Ljava/lang/Object;", "oldSynchronized", "Ljava/util/concurrent/atomic/AtomicInteger;", "AtomicInt", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JvmActuals_jvmKt {
    public static final Object nativeClass(Object obj) {
        return obj.getClass();
    }

    public static final String simpleIdentityToString(Object obj, String str) {
        if (str == null) {
            str = obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName();
        }
        return str + '@' + String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
    }

    @C7.c
    /* renamed from: synchronized, reason: not valid java name */
    public static final /* synthetic */ <R> R m6019synchronized(Object obj, S7.a aVar) {
        R r5;
        synchronized (obj) {
            r5 = (R) aVar.invoke();
        }
        return r5;
    }
}
