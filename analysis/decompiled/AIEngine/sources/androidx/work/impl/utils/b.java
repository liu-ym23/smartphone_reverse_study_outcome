package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.c;
import h2.j;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorsKt;
import lb.n;
import q2.p;
import s2.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2985a;

    static {
        String strF = j.f("WorkForegroundRunnable");
        g.e(strF, "tagWithPrefix(\"WorkForegroundRunnable\")");
        f2985a = strF;
    }

    public static final Object a(Context context, p pVar, c cVar, r2.p pVar2, s2.c cVar2, qb.b bVar) {
        if (!pVar.f11520q || Build.VERSION.SDK_INT >= 31) {
            return n.f10413a;
        }
        c.a aVar = cVar2.f11881d;
        g.e(aVar, "taskExecutor.mainThreadExecutor");
        Object objWithContext = BuildersKt.withContext(ExecutorsKt.from(aVar), new WorkForegroundKt$workForeground$2(cVar, pVar, pVar2, context, null), bVar);
        return objWithContext == CoroutineSingletons.f10059a ? objWithContext : n.f10413a;
    }
}
