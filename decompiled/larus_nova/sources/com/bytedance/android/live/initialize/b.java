package com.bytedance.android.live.initialize;

import com.bytedance.android.live.initialize.model.WTOTaskProxy;
import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import com.bytedance.android.livesdkapi.init.ILiveInitTaskListener;
import com.bytedance.android.livesdkapi.init.LiveInitCostInfo;
import com.bytedance.android.livesdkapi.init.LiveInitTaskInfo;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import wa0.c;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1129b f69387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f69388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WTOSchedulerNotify f69389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ILiveInitTaskListener f69390d;

    public static final class a implements wa0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f69391a;

        public a(b r100) {
            this.f69391a = r100;
        }

        @Override // wa0.b
        public final void a(com.bytedance.android.live.initialize.a r100) {
            if (r100 == null) goto L7;
            ILiveInitTaskListener r101 = this.f69391a.f69390d;
            if (r101 == null) goto L7;
            LiveInitCostInfo r102 = new LiveInitCostInfo(r100.f69375b);
            r102.setDuration(r100.f69374a);
            Unit r103 = Unit.INSTANCE;
            r101.onTaskScheduleEnd(r102);
        L7:
            if (Intrinsics.areEqual(r100, com.bytedance.android.live.initialize.a.i.f69383c) == false) goto L12;
            ILiveInitTaskListener r104 = this.f69391a.f69390d;
            if (r104 == null) goto L13;
            r104.onAllTaskExecuteFinish();
            return;
        L13:
            return;
        }

        @Override // wa0.b
        public final void b(com.bytedance.android.live.initialize.a r100) {
            if (r100 == null) goto L9;
            String r101 = r100.f69375b;
            if (r101 == null) goto L10;
            ILiveInitTaskListener r102 = this.f69391a.f69390d;
            if (r102 == null) goto L11;
            r102.onTaskScheduleStart(new LiveInitCostInfo(r101));
            return;
        L11:
            return;
        L10:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.initialize.b$b, reason: collision with other inner class name */
    public static final class C1129b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f69392a;

        public C1129b(b r100) {
            this.f69392a = r100;
        }

        @Override // wa0.c
        public final void a(WTOTaskProxy r100) {
            Intrinsics.checkNotNullParameter(r100, "taskProxy");
            Intrinsics.checkNotNullParameter(r100, "taskProxy");
        }

        @Override // wa0.c
        public final void b(WTOTaskProxy r100) {
            Intrinsics.checkNotNullParameter(r100, "taskProxy");
            LiveInitTaskInfo r101 = new LiveInitTaskInfo();
            r101.setPeriodName(r100.f69403k.taskExecutePeriod().f69375b);
            r101.setName(r100.f69403k.taskBusinessInfo());
            r101.setThreadId(r100.f69400h);
            ILiveInitTaskListener r102 = this.f69392a.f69390d;
            if (r102 == null) goto L6;
            r102.onTaskStart(r101);
            return;
        }

        @Override // wa0.c
        public final void c(WTOTaskProxy r100) {
            Intrinsics.checkNotNullParameter(r100, "taskProxy");
            LiveInitTaskInfo r101 = new LiveInitTaskInfo();
            r101.setPeriodName(r100.f69403k.taskExecutePeriod().f69375b);
            r101.setName(r100.f69403k.taskBusinessInfo());
            r101.setDuration(r100.f69402j);
            ILiveInitTaskListener r102 = this.f69392a.f69390d;
            if (r102 == null) goto L6;
            r102.onTaskEnd(r101);
            return;
        }
    }

    public b(WTOSchedulerNotify r100, ILiveInitTaskListener r101) {
        Intrinsics.checkNotNullParameter(r100, "notify");
        this.f69389c = r100;
        this.f69390d = r101;
        C1129b r102 = new C1129b(this);
        this.f69387a = r102;
        a r103 = new a(this);
        this.f69388b = r103;
        r100.c(r102);
        r100.b(r103);
    }
}
