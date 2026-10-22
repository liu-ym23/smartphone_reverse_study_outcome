package androidx.compose.runtime.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.kmp.performance.platform.b0;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import md6.p1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"trace", ExifInterface.GPS_DIRECTION_TRUE, "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TraceKt {
    public static Object INVOKEVIRTUAL_androidx_compose_runtime_internal_TraceKt_com_bytedance_kmp_performance_platform_LancetTrace_beginSection(Trace r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        com.bytedance.kmp.performance.b r102 = com.bytedance.kmp.performance.b.f252707a;
        if (com.bytedance.kmp.performance.b.a().f252839a == false) goto L5;
        b0.f252773a.addLast(new p1(r101, System.nanoTime(), -1));
        return r100.beginSection(r101);
    L5:
        return r100.beginSection(r101);
    }

    public static void INVOKEVIRTUAL_androidx_compose_runtime_internal_TraceKt_com_bytedance_kmp_performance_platform_LancetTrace_endSection(Trace r100, Object r101) {
        com.bytedance.kmp.performance.b r102 = com.bytedance.kmp.performance.b.f252707a;
        if (com.bytedance.kmp.performance.b.a().f252839a == true) goto L6;
        r100.endSection(r101);
        return;
    L6:
        ArrayDeque<p1> r103 = b0.f252773a;
        if ((!r103.isEmpty()) == false) goto L9;
        p1 r104 = r103.removeLast();
        r104.f513418c = System.nanoTime() - r104.f513417b;
        com.bytedance.kmp.performance.platform.g.f252785b.a(r104);
    L9:
        r100.endSection(r101);
    }

    public static final <T> T trace(String r100, Function0<? extends T> r101) {
        Trace r102 = Trace.INSTANCE;
        Object r103 = INVOKEVIRTUAL_androidx_compose_runtime_internal_TraceKt_com_bytedance_kmp_performance_platform_LancetTrace_beginSection(r102, r100);
        T r104 = r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        INVOKEVIRTUAL_androidx_compose_runtime_internal_TraceKt_com_bytedance_kmp_performance_platform_LancetTrace_endSection(r102, r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        INVOKEVIRTUAL_androidx_compose_runtime_internal_TraceKt_com_bytedance_kmp_performance_platform_LancetTrace_endSection(Trace.INSTANCE, r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
