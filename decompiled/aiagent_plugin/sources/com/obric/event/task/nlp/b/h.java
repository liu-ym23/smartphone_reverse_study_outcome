package com.obric.event.task.nlp.b;

import com.obric.capabilitykit.common.ErrorCode;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.LocationCondition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LocationConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f33002a = null;

    private h() {
    }

    static {
        f33002a = new h();
        TAG = "LocationConditionConvertor";
    }

    public final com.obric.event.task.nlp.api.d<LocationCondition> a(String r19, com.obric.event.task.nlp.api.i r20) {
        o.e(r19, "key");
        o.e(r20, "dto");
        com.obric.event.task.nlp.api.a r1 = r20.c();
        if (r1 == null) goto L7;
        com.obric.event.task.nlp.api.b r2 = r1.a();
        if (r2 == null) goto L7;
        String r3 = r2.a();
    L8:
        com.obric.event.task.nlp.a.a r4 = com.obric.event.task.nlp.a.a.f32889a;
        String r5 = TAG;
        r4.b(r5, "getLocationCondition key = " + r19);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == false) goto L18;
        com.obric.event.task.nlp.a.a.f32889a.d(r5, "getLocationCondition selected id is empty");
        return new com.obric.event.task.nlp.api.d(null, "location selectedId is empty", ErrorCode.EventTask.LOCATION_SELECTED_ID_EMPTY, null, 8, null);
    L18:
        Condition r8 = c.f32953a.a(r19, r3);
        if (r8 != null) goto L21;
    L25:
        com.obric.event.task.nlp.a.a.f32889a.d(r5, "getLocationCondition location selectedId condition is empty");
        return new com.obric.event.task.nlp.api.d(null, "location selectedId condition is empty", ErrorCode.EventTask.LOCATION_SELECTED_ID_CONDITION_EMPTY, null, 8, null);
    L21:
        if (ZeusTransformUtils.instanceOf(r8, LocationCondition.class) == false) goto L25;
        com.obric.event.task.nlp.a.a.f32889a.b(r5, "parseLocationCondition no error, location = " + r8);
        return new com.obric.event.task.nlp.api.d(r8, null, 0, null, 10, null);
    L11:
        if (r6.length() == 0) goto L14;
        r7 = false;
    L7:
        r3 = null;
        goto L8
    }
}
