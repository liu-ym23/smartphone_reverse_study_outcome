package r2;

import androidx.work.impl.WorkDatabase;
import h2.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static final void a(WorkDatabase workDatabase, androidx.work.a configuration, i2.n nVar) {
        int i10;
        kotlin.jvm.internal.g.f(workDatabase, "workDatabase");
        kotlin.jvm.internal.g.f(configuration, "configuration");
        ArrayList arrayListC0 = mb.m.c0(nVar);
        int i11 = 0;
        while (!arrayListC0.isEmpty()) {
            List<? extends s> list = ((i2.n) mb.q.j0(arrayListC0)).f9479d;
            kotlin.jvm.internal.g.e(list, "current.work");
            if (list.isEmpty()) {
                i10 = 0;
            } else {
                Iterator<T> it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    if (((s) it.next()).f9284b.f11513j.b() && (i10 = i10 + 1) < 0) {
                        mb.m.e0();
                        throw null;
                    }
                }
            }
            i11 += i10;
        }
        if (i11 == 0) {
            return;
        }
        int iZ = workDatabase.w().z();
        int i12 = configuration.f2822j;
        if (iZ + i11 > i12) {
            throw new IllegalArgumentException(ai.onnxruntime.a.j(".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.", i11, h0.e.d(i12, "Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", iZ, ";\nalready enqueued count: ", ";\ncurrent enqueue operation count: ")));
        }
    }
}
