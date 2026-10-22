package q5;

import androidx.work.impl.WorkDatabase;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ a1.g f10081c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f10082f;

    @Override // java.util.concurrent.Callable
    public final Object call() {
        a1.g gVar = this.f10081c;
        int i = this.f10082f;
        WorkDatabase workDatabase = (WorkDatabase) gVar.f19f;
        Long lI = workDatabase.y().i("next_job_scheduler_id");
        int i3 = 0;
        int iLongValue = lI != null ? (int) lI.longValue() : 0;
        int i10 = iLongValue == Integer.MAX_VALUE ? 0 : iLongValue + 1;
        p5.e eVarY = workDatabase.y();
        Long lValueOf = Long.valueOf(i10);
        p5.d dVar = new p5.d();
        dVar.f9719a = "next_job_scheduler_id";
        dVar.f9720b = lValueOf;
        VarHandle.storeStoreFence();
        eVarY.j(dVar);
        if (iLongValue < 0 || iLongValue > i) {
            p5.e eVarY2 = ((WorkDatabase) gVar.f19f).y();
            Long lValueOf2 = Long.valueOf(1);
            p5.d dVar2 = new p5.d();
            dVar2.f9719a = "next_job_scheduler_id";
            dVar2.f9720b = lValueOf2;
            VarHandle.storeStoreFence();
            eVarY2.j(dVar2);
        } else {
            i3 = iLongValue;
        }
        return Integer.valueOf(i3);
    }
}
