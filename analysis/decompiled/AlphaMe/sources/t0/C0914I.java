package t0;

import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import s0.C0844b;

/* renamed from: t0.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0914I extends FunctionReferenceImpl implements Function6 {

    /* renamed from: a, reason: collision with root package name */
    public static final C0914I f15335a = new C0914I();

    public C0914I() {
        super(6, J.class, "createSchedulers", "createSchedulers(Landroid/content/Context;Landroidx/work/Configuration;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Landroidx/work/impl/WorkDatabase;Landroidx/work/impl/constraints/trackers/Trackers;Landroidx/work/impl/Processor;)Ljava/util/List;", 1);
    }

    @Override // kotlin.jvm.functions.Function6
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Context p02 = (Context) obj;
        C0844b p12 = (C0844b) obj2;
        E0.a p22 = (E0.a) obj3;
        WorkDatabase p32 = (WorkDatabase) obj4;
        z0.l p4 = (z0.l) obj5;
        r p5 = (r) obj6;
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        Intrinsics.checkNotNullParameter(p22, "p2");
        Intrinsics.checkNotNullParameter(p32, "p3");
        Intrinsics.checkNotNullParameter(p4, "p4");
        Intrinsics.checkNotNullParameter(p5, "p5");
        String str = w.f15424a;
        w0.b bVar = new w0.b(p02, p32, p12);
        C0.m.a(p02, SystemJobService.class, true);
        s0.t.d().a(w.f15424a, "Created SystemJobScheduler and enabled SystemJobService");
        Intrinsics.checkNotNullExpressionValue(bVar, "createBestAvailableBackg…kDatabase, configuration)");
        return CollectionsKt.listOf((Object[]) new t[]{bVar, new u0.c(p02, p12, p4, p5, new C0911F(p5, p22), p22)});
    }
}
