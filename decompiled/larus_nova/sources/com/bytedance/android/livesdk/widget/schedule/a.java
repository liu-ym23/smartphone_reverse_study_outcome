package com.bytedance.android.livesdk.widget.schedule;

import com.bytedance.android.live.core.tetris.task.TaskState;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.StateMachine;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RunnableC2479a f162085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.live.core.tetris.task.c f162086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<y70.a, rv2.e> f162087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<y70.a> f162088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f162089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f162090f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.schedule.a$a, reason: collision with other inner class name */
    public static final class RunnableC2479a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f162091a;

        public RunnableC2479a(a r100) {
            this.f162091a = r100;
        }

        public final void a() {
            com.bytedance.android.live.core.tetris.widgets.d.g("scheduler: " + this.f162091a.f162089e + " timeout");
            HashMap<y70.a, rv2.e> r100 = this.f162091a.f162087c;
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator<Map.Entry<y70.a, rv2.e>> r102 = r100.entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Map.Entry<y70.a, rv2.e> r103 = r102.next();
            if (r103.getKey().isComplete() == false) goto L4;
            r101.put(r103.getKey(), r103.getValue());
            goto L4
        L8:
            Iterator r104 = r101.entrySet().iterator();
        L10:
            if (r104.hasNext() == false) goto L12;
            Map.Entry r105 = (Map.Entry) r104.next();
            this.f162091a.f162088d.add((y70.a) r105.getKey());
            ((rv2.e) r105.getValue()).onDone();
            goto L10
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements y70.b<com.bytedance.android.live.core.tetris.task.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f162092a;

        public b(a r100) {
            this.f162092a = r100;
        }

        @Override // y70.b
        public final void a(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.c) r100, "task");
            MainThreadPostUtils.d(this.f162092a.f162085a);
        }

        @Override // y70.b
        public final void b(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.c) r100, "task");
            MainThreadPostUtils.d(this.f162092a.f162085a);
            Iterator<Map.Entry<y70.a, rv2.e>> r101 = this.f162092a.f162087c.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Map.Entry<y70.a, rv2.e> r102 = r101.next();
            if (this.f162092a.f162088d.contains(r102.getKey()) == true) goto L4;
            this.f162092a.f162088d.add(r102.getKey());
            r102.getValue().onDone();
            goto L4
        L8:
            com.bytedance.android.live.core.tetris.widgets.d.g("scheduler: " + this.f162092a.f162089e + " finished");
            this.f162092a.f162090f.invoke();
        }

        @Override // y70.b
        public final void c(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.c) r100, "task");
            a r101 = this.f162092a;
            System.currentTimeMillis();
            r101.getClass();
            a r102 = this.f162092a;
            MainThreadPostUtils.c(r102.f162085a, Math.max(0, r102.a()));
        }

        @Override // y70.b
        public final void d(y70.a r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.android.live.core.tetris.task.c) r100, "task");
        }
    }

    public abstract long a();

    public final void b() {
        com.bytedance.android.live.core.tetris.task.c r100 = this.f162086b;
        StateMachine<TaskState.d, TaskState.a, TaskState.c> r101 = r100.f65925a.f65902d;
        TaskState.a.b r102 = TaskState.a.b.f65904a;
        StateMachine.a r103 = StateMachine.f66079c;
        r101.d(r102, null);
        if (r100.f65926b.isEmpty() == false) goto L6;
        r100.f65925a.f65902d.d(TaskState.a.c.f65905a, null);
        return;
    }

    public a(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "taskGroupId");
        Intrinsics.checkNotNullParameter(r101, "widgetsLoadDone");
        this.f162089e = r100;
        this.f162090f = r101;
        this.f162085a = new RunnableC2479a(this);
        this.f162086b = new com.bytedance.android.live.core.tetris.task.c(r100, new b(this));
        this.f162087c = new HashMap();
        this.f162088d = new HashSet();
    }
}
