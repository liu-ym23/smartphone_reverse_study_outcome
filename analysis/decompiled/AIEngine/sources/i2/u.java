package i2;

import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9489a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9490b;

    public /* synthetic */ u(Object obj, int i10) {
        this.f9489a = i10;
        this.f9490b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i10 = this.f9489a;
        Object obj = this.f9490b;
        switch (i10) {
            case 0:
                androidx.work.impl.d dVar = (androidx.work.impl.d) obj;
                q2.p pVar = dVar.f2941a;
                WorkInfo$State workInfo$State = pVar.f11506b;
                String str = pVar.f11507c;
                WorkInfo$State workInfo$State2 = WorkInfo$State.f2792a;
                if (workInfo$State != workInfo$State2) {
                    String str2 = androidx.work.impl.e.f2965a;
                    h2.j.d().a(str2, str + " is not in ENQUEUED state. Nothing more to do");
                    return Boolean.TRUE;
                }
                if (pVar.c() || (pVar.f11506b == workInfo$State2 && pVar.f11514k > 0)) {
                    dVar.f2947g.getClass();
                    if (System.currentTimeMillis() < pVar.a()) {
                        h2.j.d().a(androidx.work.impl.e.f2965a, "Delaying execution for " + str + " because it is being executed before schedule.");
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            default:
                WorkDatabase workDatabase = (WorkDatabase) ((androidx.lifecycle.b) obj).h;
                Long lI = workDatabase.s().i("next_alarm_manager_id");
                int iLongValue = lI != null ? (int) lI.longValue() : 0;
                workDatabase.s().b(new q2.d("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
        }
    }
}
