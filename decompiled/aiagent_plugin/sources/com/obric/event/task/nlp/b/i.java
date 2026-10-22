package com.obric.event.task.nlp.b;

import com.obric.capabilitykit.common.ErrorCode;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.SmsCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SMSConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f33003a = null;

    private i() {
    }

    static {
        f33003a = new i();
        TAG = "SMSConditionConvertor";
    }

    public final com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.a> a(String r19, com.obric.event.task.nlp.api.a r20) {
        o.e(r19, DBDefinition.TASK_ID);
        o.e(r20, "dto");
        com.obric.event.task.nlp.api.b r1 = r20.a();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.b();
        if (r3 == null) goto L6;
    L7:
        com.obric.event.task.nlp.a.a r4 = com.obric.event.task.nlp.a.a.f32889a;
        String r5 = TAG;
        r4.b(r5, "handleConditionCandidate taskId = " + r19 + ", name = " + r3);
        int r6 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L13;
        List<String> r8 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.a();
        com.obric.event.task.nlp.a.a.f32889a.b(r5, "handleConditionCandidate bluetoothList size = " + r8.size());
        ArrayList r9 = new ArrayList();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L24;
        int r10 = ((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).size();
    L17:
        if (r6 >= r10) goto L24;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r8.get(r6), String.class, "com.obric.aiagent.plugin");
        String r15 = c.f32953a.a("sms", r11, r6);
        String r12 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.a(r11);
        if (r12 != null) goto L21;
        String r13 = r2;
    L22:
        c.f32953a.a(r19, r15, (Condition) ZeusTransformUtils.preCheckCast(new SmsCondition(r13, r11, null, 4, null), Condition.class, "com.obric.aiagent.plugin"));
        r9.add(new com.obric.event.task.nlp.api.b(r15, r11));
        r6 = r6 + 1;
        r2 = r2;
        goto L17
    L21:
        r13 = r12;
    L24:
        return new com.obric.event.task.nlp.api.d(new com.obric.event.task.nlp.api.a(new com.obric.event.task.nlp.api.b(null, r3, 1, null), (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")), null, 0, null, 10, null);
    L13:
        return new com.obric.event.task.nlp.api.d(null, "sms selected name is empty", ErrorCode.EventTask.SMS_SELECTED_NAME_EMPTY, null, 8, null);
    L10:
        r7 = false;
    L6:
        r3 = "";
        goto L7
    }

    public final com.obric.event.task.nlp.api.d<SmsCondition> b(String r20, com.obric.event.task.nlp.api.a r21) {
        o.e(r20, "key");
        o.e(r21, "dto");
        com.obric.event.task.nlp.a.a r1 = com.obric.event.task.nlp.a.a.f32889a;
        String r3 = TAG;
        r1.b(r3, "getSmsCondition key = " + r20);
        com.obric.event.task.nlp.api.b r2 = r21.a();
        if (r2 == null) goto L5;
        String r4 = r2.a();
    L6:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L17;
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getSmsCondition sms condition selected id is empty");
        return new com.obric.event.task.nlp.api.d(null, "sms condition selected id is empty", ErrorCode.EventTask.SMS_SELECTED_ID_EMPTY, null, 8, null);
    L17:
        Condition r7 = c.f32953a.a(r20, r4);
        if (r7 != null) goto L20;
    L24:
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getSmsCondition sms selectedId condition is empty");
        return new com.obric.event.task.nlp.api.d(null, "sms selectedId condition is empty", ErrorCode.EventTask.SMS_SELECTED_ID_CONDITION_EMPTY, null, 8, null);
    L20:
        if (ZeusTransformUtils.instanceOf(r7, SmsCondition.class) == false) goto L24;
        com.obric.event.task.nlp.a.a.f32889a.b(r3, "getSmsCondition success ,key = " + r20);
        return new com.obric.event.task.nlp.api.d(r7, null, 0, null, 10, null);
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L14
    L5:
        r4 = null;
        goto L6
    }
}
