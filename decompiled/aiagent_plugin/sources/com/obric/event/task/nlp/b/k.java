package com.obric.event.task.nlp.b;

import com.obric.capabilitykit.common.ErrorCode;
import com.obric.event.task.nlp.api.o;
import com.obric.event.task.nlp.api.p;
import com.obric.eventkit.task.model.TimeCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TimeConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f33005a = null;

    private k() {
    }

    static {
        f33005a = new k();
        TAG = "TimeConditionConvertor";
    }

    public final com.obric.event.task.nlp.api.d<TimeCondition> a(o r23) {
        d.h.b.o.e(r23, "timeDto");
        String r2 = r23.a();
        p r0 = r23.b();
        String r7 = r23.c();
        if (r2 == null) goto L7;
        if (r0 == null) goto L7;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "parseTimeCondition time condition error, both timePoint and timeFrame exist");
        return new com.obric.event.task.nlp.api.d(null, "time condition error, both timePoint and timeFrame exist", ErrorCode.EventTask.TIME_CONDITION_PARAMS_ERROR, null, 8, null);
    L7:
        if (r2 != null) goto L11;
        if (r0 != null) goto L11;
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "parseTimeCondition time condition error, both timePoint and timeFrame empty");
        return new com.obric.event.task.nlp.api.d(null, "time condition error, both timePoint and timeFrame empty", ErrorCode.EventTask.TIME_CONDITION_PARAMS_ERROR, null, 8, null);
    L11:
        TimeCondition r1 = null;
        if (r2 != null) goto L14;
    L18:
        if (r0 == null) goto L27;
        String r10 = r0.a();
        String r11 = r0.b();
        boolean r3 = l.f33006a.b(r10);
        boolean r4 = l.f33006a.b(r11);
        if (r3 == false) goto L25;
        if (r4 == false) goto L25;
        if (r10 == null) goto L25;
        if (r11 == null) goto L25;
        r1 = new TimeCondition(r10, r11, 0, 4, null);
    L25:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "parseTimeCondition timeFrame error");
        return new com.obric.event.task.nlp.api.d(null, "parseTimeCondition timeFrame error", ErrorCode.EventTask.TIME_CONDITION_TIME_FRAME_ERROR, null, 8, null);
    L27:
        TimeCondition r5 = r1;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L30;
    L33:
        boolean r8 = true;
    L34:
        if (r8 == true) goto L45;
        int r9 = l.f33006a.a(r7);
        if (r9 >= l.f33006a.a()) goto L38;
    L42:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "parseTimeCondition time condition interval error, less than 30 minutes or more than 23 hours and 59 minutes ");
        return new com.obric.event.task.nlp.api.d(null, "time condition interval error, less than 30 minutes or more than 23 hours and 59 minutes ", ErrorCode.EventTask.TIME_CONDITION_INTERVAL_ERROR, null, 8, null);
    L38:
        if (r9 > l.f33006a.b()) goto L42;
        if (r5 == null) goto L45;
        r5.setInterval(r9);
    L45:
        return new com.obric.event.task.nlp.api.d(r5, null, 0, null, 10, null);
    L30:
        if (r6.length() == 0) goto L33;
        r8 = false;
        goto L34
    L14:
        if (l.f33006a.b(r2) == false) goto L16;
        r1 = new TimeCondition(r2, null, 0, 6, null);
        goto L18
    L16:
        com.obric.event.task.nlp.a.a.f32889a.d(TAG, "parseTimeCondition time condition timePoint error");
        return new com.obric.event.task.nlp.api.d(null, "time condition timePoint error", ErrorCode.EventTask.TIME_CONDITION_TIME_POINT_ERROR, null, 8, null);
    }
}
