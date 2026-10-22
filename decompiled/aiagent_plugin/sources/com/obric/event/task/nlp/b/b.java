package com.obric.event.task.nlp.b;

import android.content.Context;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.eventkit.task.model.BluetoothCondition;
import com.obric.eventkit.task.model.Condition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: BluetoothConditionConvertor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f32952b = 0;

    private b() {
    }

    static {
        f32951a = new b();
        TAG = "BluetoothConditionConvertor";
        f32952b = 1000;
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
        return new com.obric.event.task.nlp.api.d(null, "bluetooth selected name is empty", ErrorCode.EventTask.BLUETOOTH_SELECTED_NAME_EMPTY, null, 8, null);
    L15:
        if (com.obric.autoaction.app.launcherpage.api.b.b.f22886a.g(r1) == false) goto L17;
        List<com.obric.autoaction.app.launcherpage.api.b.b.a> r9 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.f(r1);
        com.obric.event.task.nlp.a.a.f32889a.b(r6, "handleConditionCandidate bluetoothList size = " + r9.size());
        ArrayList r10 = new ArrayList();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L25;
        int r2 = n.d(f32952b, r9.size());
    L21:
        if (r7 >= r2) goto L24;
        com.obric.autoaction.app.launcherpage.api.b.b.a r11 = (com.obric.autoaction.app.launcherpage.api.b.b.a) ZeusTransformUtils.preCheckCast(r9.get(r7), com.obric.autoaction.app.launcherpage.api.b.b.a.class, "com.obric.aiagent.plugin");
        String r12 = r11.a();
        String r13 = r11.getType();
        String r14 = r11.b();
        String r15 = c.f32953a.a("bluetooth", r13 + '_' + r12, r7);
        c.f32953a.a(r17, r15, (Condition) ZeusTransformUtils.preCheckCast(new BluetoothCondition(r12, r14), Condition.class, "com.obric.aiagent.plugin"));
        r10.add(new com.obric.event.task.nlp.api.b(r15, r12));
        r7 = r7 + 1;
        goto L21
    L24:
        return new com.obric.event.task.nlp.api.d(new com.obric.event.task.nlp.api.a(new com.obric.event.task.nlp.api.b(null, r4, 1, null), (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin")), null, 0, null, 10, null);
    L25:
        boolean r0 = com.obric.autoaction.app.launcherpage.api.b.b.f22886a.e(r1);
        com.obric.event.task.nlp.a.a.f32889a.d(r6, "handleConditionCandidate bluetooth info is empty isBluetoothEnabled = " + r0);
        if (r0 == true) goto L30;
        return new com.obric.event.task.nlp.api.d(null, "bluetooth switch is not enabled", ErrorCode.EventTask.BLUETOOTH_SWITCH_NOT_ENABLED, null, 8, null);
    L30:
        return new com.obric.event.task.nlp.api.d(null, "bluetooth info is empty", ErrorCode.EventTask.BLUETOOTH_CANDIDATE_INFO_EMPTY, null, 8, null);
    L17:
        return new com.obric.event.task.nlp.api.d(null, "bluetooth no permission", ErrorCode.EventTask.BLUETOOTH_NO_PERMISSION, null, 8, null);
    L10:
        r8 = false;
    L6:
        r4 = "";
        goto L7
    }

    public final com.obric.event.task.nlp.api.d<BluetoothCondition> a(String r20, com.obric.event.task.nlp.api.a r21) {
        o.e(r20, "key");
        o.e(r21, "dto");
        com.obric.event.task.nlp.a.a r1 = com.obric.event.task.nlp.a.a.f32889a;
        String r3 = TAG;
        r1.b(r3, "getBluetoothCondition key = " + r20);
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
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getBluetoothCondition bluetooth condition selected id is empty");
        return new com.obric.event.task.nlp.api.d(null, "bluetooth condition selected id is empty", ErrorCode.EventTask.BLUETOOTH_SELECTED_ID_EMPTY, null, 8, null);
    L17:
        Condition r7 = c.f32953a.a(r20, r4);
        if (r7 != null) goto L20;
    L24:
        com.obric.event.task.nlp.a.a.f32889a.d(r3, "getBluetoothCondition bluetooth selectedId condition is empty");
        return new com.obric.event.task.nlp.api.d(null, "bluetooth selectedId condition is empty", ErrorCode.EventTask.BLUETOOTH_SELECTED_ID_CONDITION_EMPTY, null, 8, null);
    L20:
        if (ZeusTransformUtils.instanceOf(r7, BluetoothCondition.class) == false) goto L24;
        com.obric.event.task.nlp.a.a.f32889a.b(r3, "getBluetoothCondition success ,key = " + r20);
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
