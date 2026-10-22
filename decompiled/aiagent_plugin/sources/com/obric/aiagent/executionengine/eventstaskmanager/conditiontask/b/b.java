package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: ConditionCheckResultExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: compiled from: ConditionCheckResultExt.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16891a = null;

        static {
            int[] r0 = new int[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.values().length];
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17015a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17016b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L39:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17017c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L29:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17018d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f17019e.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L23:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.f.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
        L33:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.g.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
        L35:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.h.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
        L27:
            r0[com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a.i.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
        L12:
            f16891a = r0;
        }
    }

    public static final com.obric.event.task.base.report.e.b a(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.a r1) {
        o.e(r1, "<this>");
        switch(a.f16891a[r1.ordinal()]) {
            case 1: goto L15;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            default: goto L5;
        };
    L5:
        throw new k();
    L16:
        return com.obric.event.task.base.report.e.b.l;
    L17:
        return com.obric.event.task.base.report.e.b.k;
    L18:
        return com.obric.event.task.base.report.e.b.j;
    L19:
        return com.obric.event.task.base.report.e.b.i;
    L20:
        return com.obric.event.task.base.report.e.b.h;
    L21:
        return com.obric.event.task.base.report.e.b.f32768d;
    L22:
        return com.obric.event.task.base.report.e.b.f32767c;
    L23:
        return com.obric.event.task.base.report.e.b.f32766b;
    L15:
        return com.obric.event.task.base.report.e.b.f32765a;
    }
}
