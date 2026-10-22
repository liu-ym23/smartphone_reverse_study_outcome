package com.obric.event.task.nlp.b;

import android.content.Context;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.eventkit.task.model.Condition;
import com.obric.eventkit.task.model.WifiCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: WifiConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f33011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f33012b = 0;

    private m() {
    }

    static {
        f33011a = new m();
        TAG = "WifiConditionConvertor";
        f33012b = 1000;
    }

    public final com.obric.event.task.nlp.api.d<com.obric.event.task.nlp.api.a> a(String r17, com.obric.event.task.nlp.api.a r18, Context r19) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.aiagent.plugin");
        o.e(r17, DBDefinition.TASK_ID);
        o.e(r18, "dto");
        o.e(r1, "context");
        com.obric.event.task.nlp.api.b r3 = r18.a();
        if (r3 == null) goto L6;
        String r4 = r3.b();
        if (r4 == null) goto L6;
    L7:
        com.obric.event.task.nlp.a.a r5 = com.obric.event.task.nlp.a.a.f32889a;
        String r6 = TAG;
        r5.b(r6, "handleConditionCandidate taskId = " + r17 + ", name = " + r4);
        int r7 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == false) goto L15;
        return new com.obric.event.task.nlp.api.d(null, "wifi selected name is empty", ErrorCode.EventTask.WIFI_SELECTED_NAME_EMPTY, null, 8, null);
    L15:
        if (com.obric.autoaction.app.launcherpage.api.b.b.f22886a.c(r1) == true) goto L18;
        com.obric.event.task.nlp.a.a.f32889a.d(r6, "handleConditionCandidate wifi no permission");
        return new com.obric.event.task.nlp.api.d(null, "wifi no permission", ErrorCode.EventTask.WIFI_NO_PERMISSION, null, 8, null);
    L18:
        List<com.obric.autoaction.app.launcherpage.api.b.b.C0492b> r2 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.b(r1);
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "handleConditionCandidate wifiList size = " + r2.size());
        ArrayList r9 = new ArrayList();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        int r10 = n.d(f33012b, r2.size());
    L21:
        if (r7 >= r10) goto L24;
        com.obric.autoaction.app.launcherpage.api.b.b.C0492b r11 = (com.obric.autoaction.app.launcherpage.api.b.b.C0492b) ZeusTransformUtils.preCheckCast(r2.get(r7), com.obric.autoaction.app.launcherpage.api.b.b.C0492b.class, "com.obric.aiagent.plugin");
        String r12 = r11.a();
        String r13 = r11.b();
        String r14 = c.f32953a.a("wifi", r12, r7);
        c.f32953a.a(r17, r14, (Condition) ZeusTransformUtils.preCheckCast(new WifiCondition(r12, r13), Condition.class, "com.obric.aiagent.plugin"));
        r9.add(new com.obric.event.task.nlp.api.b(r14, r12));
        r7 = r7 + 1;
        goto L21
    L24:
        return new com.obric.event.task.nlp.api.d(new com.obric.event.task.nlp.api.a(new com.obric.event.task.nlp.api.b(null, r4, 1, null), (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin")), null, 0, null, 10, null);
    L25:
        com.obric.event.task.nlp.a.a.f32889a.d(r6, "handleConditionCandidate wifi info empty");
        return new com.obric.event.task.nlp.api.d(null, "wifi info empty", ErrorCode.EventTask.WIFI_CANDIDATE_INFO_EMPTY, null, 8, null);
    L10:
        r8 = false;
    L6:
        r4 = "";
        goto L7
    }

    public final com.obric.event.task.nlp.api.d<WifiCondition> a(String r20, com.obric.event.task.nlp.api.a r21) {
        o.e(r20, "key");
        o.e(r21, "dto");
        com.obric.event.task.nlp.a.a r1 = com.obric.event.task.nlp.a.a.f32889a;
        String r3 = TAG;
        r1.b(r3, "getWifiCondition key = " + r20);
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
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getWifiCondition wifi condition selected id is empty");
        return new com.obric.event.task.nlp.api.d(null, "wifi condition selected id is empty", ErrorCode.EventTask.WIFI_SELECTED_ID_EMPTY, null, 8, null);
    L17:
        Condition r7 = c.f32953a.a(r20, r4);
        if (r7 != null) goto L20;
    L24:
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getWifiCondition wifi selectedId condition is empty");
        return new com.obric.event.task.nlp.api.d(null, "wifi selectedId condition is empty", ErrorCode.EventTask.WIFI_SELECTED_ID_CONDITION_EMPTY, null, 8, null);
    L20:
        if (ZeusTransformUtils.instanceOf(r7, WifiCondition.class) == false) goto L24;
        com.obric.event.task.nlp.a.a.f32889a.b(r3, "getWifiCondition success ,key = " + r20);
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
