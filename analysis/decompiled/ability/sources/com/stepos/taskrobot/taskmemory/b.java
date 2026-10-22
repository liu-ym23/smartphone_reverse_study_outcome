package com.stepos.taskrobot.taskmemory;

import C7.f;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import m9.AbstractC1683A;
import m9.C1704W;
import n5.C1741a;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4062a = kotlin.a.a(new C1741a(6));

    public static void a(b bVar, String str, String str2, String str3, long j5, long j6, int i) {
        String str4 = (i & 4) != 0 ? null : str3;
        long j10 = (i & 64) != 0 ? 0L : j6;
        bVar.getClass();
        TaskStepEntity taskStepEntity = new TaskStepEntity(-1L, "", "", "", null, null, null, null, null, null, 0, System.currentTimeMillis(), null, null, 0L, 0L, null);
        taskStepEntity.c = str;
        taskStepEntity.e = str2;
        taskStepEntity.f = str4;
        taskStepEntity.d = "";
        taskStepEntity.n = null;
        taskStepEntity.h = "美团";
        taskStepEntity.i = null;
        taskStepEntity.l = j5;
        taskStepEntity.m = Long.valueOf(j10);
        taskStepEntity.o = 0L;
        taskStepEntity.p = 0L;
        taskStepEntity.f4069q = null;
        s6.f.b().getClass();
        s6.f.a(str, taskStepEntity);
    }

    public static void b(String str, String str2) {
        s6.f.b().getClass();
        TaskStepEntity taskStepEntityC = s6.f.c(str);
        if (taskStepEntityC != null) {
            taskStepEntityC.d = str2;
        }
        if (taskStepEntityC != null) {
            taskStepEntityC.m = Long.valueOf(System.currentTimeMillis());
        }
        if (taskStepEntityC != null) {
            taskStepEntityC.n = "SUCCESS";
        }
        if (taskStepEntityC != null) {
            AbstractC1683A.n(C1704W.f5321a, null, new TaskStepMemoryManager$stepExecuteAction$1(taskStepEntityC, null), 3);
        }
    }
}
