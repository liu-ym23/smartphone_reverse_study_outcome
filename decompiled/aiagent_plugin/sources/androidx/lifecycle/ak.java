package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: ViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ak {
    public static final kotlinx.coroutines.am a(aj r6) {
        d.h.b.o.e(r6, "<this>");
        kotlinx.coroutines.am r1 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r6.b("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY"), kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        Object r7 = r6.a("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new c(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.b().a(), d.c.g.class, "com.obric.aiagent.plugin"))));
        d.h.b.o.c(r7, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
    }
}
