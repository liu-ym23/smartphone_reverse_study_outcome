package androidx.compose.ui.platform;

import com.baidu.platform.comapi.map.MapBundleKey;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0005H\u0000\u001a0\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\n\u0010\n\u001a\u00060\u0005j\u0002`\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\t0\rH\u0081\b¢\u0006\u0004\b\u000e\u0010\u000f*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0010"}, d2 = {"AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "simpleIdentityToString", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "name", "nativeClass", "oldSynchronized", "R", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "block", "Lkotlin/Function0;", "synchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class JvmActuals_jvmKt {
    public static final Object nativeClass(Object r100) {
        return r100.getClass();
    }

    public static final String simpleIdentityToString(Object r100, String r101) {
        if (r101 == null) goto L4;
    L7:
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        r102.append('@');
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        r102.append(String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(r100))}, 1)));
        return r102.toString();
    L4:
        if (r100.getClass().isAnonymousClass() == false) goto L6;
        r101 = r100.getClass().getName();
        goto L7
    L6:
        r101 = r100.getClass().getSimpleName();
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "not expected to be referenced directly as the old version had to be inlined")
    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final /* synthetic */ <R> R m6709synchronized(Object r100, Function0<? extends R> r101) {
        monitor-enter(r100);
        R r102 = r101.invoke();     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        monitor-exit(r100);
        InlineMarker.finallyEnd(1);
        return r102;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
