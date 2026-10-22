package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import android.app.Application;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTaskExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final e a(PeriodicPolicy r7) {
        o.e(r7, "<this>");
        if (r7.getDaily() == true) goto L54;
        int[] r0 = r7.getWeekly();
        boolean r1 = false;
        if (r0 != null) goto L8;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L36;
        int[] r3 = r7.getWeekly();
        if (r3 == null) goto L33;
        int r4 = r3.length;
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L30;
        int r6 = r3[r5];
        if (1 <= r6) goto L23;
    L25:
        boolean r8 = false;
    L27:
        if ((!r8) == true) goto L28;
        r5 = r5 + 1;
        goto L19
    L28:
        boolean r9 = true;
    L31:
        if (r9 == true) goto L33;
        r1 = true;
        goto L33
    L23:
        if (r6 >= 8) goto L25;
        r8 = true;
        goto L27
    L30:
        r9 = false;
    L33:
        if (r1 == false) goto L36;
        return e.f16893b;
    L36:
        if (r7.getMonthly() <= 0) goto L39;
        return e.f16894c;
    L39:
        if (r7.getYearly() == null) goto L42;
        return e.f16895d;
    L42:
        if (r7.getEveryOffDay() == false) goto L45;
        return e.f16896e;
    L45:
        if (r7.getEveryWorkDay() == false) goto L48;
        return e.f;
    L48:
        if (r7.isSingleTask() == false) goto L51;
        return e.g;
    L51:
        return e.i;
    L8:
        if (r0.length != 0) goto L10;
        boolean r10 = true;
    L12:
        if ((!r10) != true) goto L14;
        r2 = true;
        goto L15
    L10:
        r10 = false;
        goto L12
    L54:
        return e.f16892a;
    }

    public static final boolean a() {
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().checkPermission("android.permission.ACCESS_FINE_LOCATION", "com.larus.nova") != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
