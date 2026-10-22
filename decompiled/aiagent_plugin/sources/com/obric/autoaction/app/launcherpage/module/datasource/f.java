package com.obric.autoaction.app.launcherpage.module.datasource;

import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.EventTask;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TimerTaskV2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TaskWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventTask f24224b;

    /* JADX INFO: compiled from: TaskWrapper.kt */
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConditionTask f24225a;

        public final ConditionTask b() {
            return this.f24225a;
        }

        public a(ConditionTask r4) {
            o.e(r4, "conditionTask");
            int r1 = 2;
            super(r1, (EventTask) ZeusTransformUtils.preCheckCast(r4, EventTask.class, "com.obric.aiagent.plugin"), null);
            this.f24225a = r4;
        }
    }

    /* JADX INFO: compiled from: TaskWrapper.kt */
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ShortcutTask f24226a;

        public final ShortcutTask b() {
            return this.f24226a;
        }

        public b(ShortcutTask r4) {
            o.e(r4, "shortcutTask");
            int r1 = 3;
            super(r1, (EventTask) ZeusTransformUtils.preCheckCast(r4, EventTask.class, "com.obric.aiagent.plugin"), null);
            this.f24226a = r4;
        }
    }

    /* JADX INFO: compiled from: TaskWrapper.kt */
    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TimerTaskV2 f24227a;

        public final TimerTaskV2 b() {
            return this.f24227a;
        }

        public c(TimerTaskV2 r4) {
            o.e(r4, "timerTask");
            int r1 = 1;
            super(r1, (EventTask) ZeusTransformUtils.preCheckCast(r4, EventTask.class, "com.obric.aiagent.plugin"), null);
            this.f24227a = r4;
        }
    }

    public /* synthetic */ f(int r1, EventTask r2, d.h.b.h r3) {
        this(r1, r2);
    }

    private f(int r1, EventTask r2) {
        this.f24223a = r1;
        this.f24224b = r2;
    }

    public final int getType() {
        return this.f24223a;
    }

    public final EventTask a() {
        return this.f24224b;
    }
}
