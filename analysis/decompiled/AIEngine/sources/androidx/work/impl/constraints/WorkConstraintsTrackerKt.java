package androidx.work.impl.constraints;

import h2.j;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import m2.c;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkConstraintsTrackerKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2921a;

    static {
        String strF = j.f("WorkConstraintsTracker");
        g.e(strF, "tagWithPrefix(\"WorkConstraintsTracker\")");
        f2921a = strF;
    }

    public static final Job a(WorkConstraintsTracker workConstraintsTracker, p pVar, CoroutineDispatcher dispatcher, c listener) {
        g.f(workConstraintsTracker, "<this>");
        g.f(dispatcher, "dispatcher");
        g.f(listener, "listener");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatcher), null, null, new WorkConstraintsTrackerKt$listen$1(workConstraintsTracker, pVar, listener, null), 3, null);
    }
}
