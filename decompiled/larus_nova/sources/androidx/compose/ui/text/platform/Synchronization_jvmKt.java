package androidx.compose.ui.text.platform;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0080\b\u001a7\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"makeSynchronizedObject", "Landroidx/compose/ui/text/platform/SynchronizedObject;", TemplateNodeType.REF, "", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/text/platform/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Synchronization_jvmKt {
    public static final SynchronizedObject makeSynchronizedObject(Object r100) {
        return new SynchronizedObject();
    }

    /* JADX INFO: renamed from: synchronized, reason: not valid java name */
    public static final <R> R m7269synchronized(SynchronizedObject r100, Function0<? extends R> r101) {
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

    public static /* synthetic */ SynchronizedObject makeSynchronizedObject$default(Object r100, int r101, Object r102) {
        return new SynchronizedObject();
    }
}
