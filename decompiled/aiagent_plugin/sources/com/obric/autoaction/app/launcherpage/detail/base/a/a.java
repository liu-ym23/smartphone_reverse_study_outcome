package com.obric.autoaction.app.launcherpage.detail.base.a;

import com.obric.autoaction.app.launcherpage.detail.shortcut.data.e;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.event.task.base.report.f;
import com.obric.event.task.base.report.l;
import com.obric.event.task.base.report.o;
import com.obric.eventkit.task.model.ConditionTask;
import com.obric.eventkit.task.model.PeriodicPolicy;
import com.obric.eventkit.task.model.ShortcutTask;
import com.obric.eventkit.task.model.TaskKnowledge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: TaskDetailReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "TaskDetailReporter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0506a f23240a = null;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.detail.base.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskDetailReporter.kt */
    public static final class C0506a {
        public /* synthetic */ C0506a(h r1) {
            this();
        }

        private C0506a() {
        }
    }

    static {
        f23240a = new C0506a(null);
    }

    public a() {
    }

    private final f b(ConditionTask r5) {
        PeriodicPolicy r0 = r5.getPeriodicPolicy();
        List r1 = (List) ZeusTransformUtils.preCheckCast(r5.getConditions().getConditions(), List.class, "com.obric.aiagent.plugin");
        TaskKnowledge r6 = r5.getTaskKnowledge();
        if (r6 == null) goto L5;
        String r7 = r6.getContent();
    L6:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L9;
    L12:
        boolean r9 = true;
    L14:
        return new f(r0, r1, !r9);
    L9:
        if (r8.length() == 0) goto L12;
        r9 = false;
        goto L14
    L5:
        r7 = null;
        goto L6
    }

    public final void a(ConditionTask r13, boolean r14, String r15, int r16, String r17, long r18, ConditionTask r20, String r21, String r22) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L32
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        com.obric.event.task.base.report.b r3 = com.obric.event.task.base.report.b.f32757a;     // Catch: Throwable -> L32
        if (r13 == null) goto L7;
        f r4 = b(r13);     // Catch: Throwable -> L32
    L8:
        f r5 = r4;
        String r10 = "create";
        if (r14 == false) goto L11;
        String r6 = "create";
    L13:
        r3.a(r5, r6, null, r15, r16, r17, Long.valueOf(r18));     // Catch: Throwable -> L32
        if (r20 == null) goto L30;
        o r7 = o.f32870a;     // Catch: Throwable -> L32
        if (r14 == true) goto L19;
        r10 = "update";
    L19:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r0 != null) goto L22;
    L25:
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        String r9 = "gui";
    L29:
        r7.a(r20, r10, r9, r21, r22);     // Catch: Throwable -> L32
        goto L30
    L28:
        r9 = "create_from_discover";
        goto L29
    L22:
        if (r0.length() == 0) goto L25;
        r8 = false;
    L30:
        Object r11 = n.f(x.f38692a);     // Catch: Throwable -> L32
    L34:
        Throwable r12 = n.c(r11);
        if (r12 == null) goto L40;
        Loog.INSTANCE.e(TAG, "report failed: " + r12.getMessage(), r12);
        return;
    L40:
        return;
    L11:
        r6 = "update";
        goto L13
    L7:
        r4 = null;
    L32:
        th = move-exception;
        n.a r19 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L34
    }

    public final void a(ShortcutTask r15, ShortcutTask r16, String r17, boolean r18, String r19, int r20, String r21, long r22, String r24, String r25) {
        d.h.b.o.e(r15, "current");
        n.a r2 = n.f38560a;     // Catch: Throwable -> L41
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        com.obric.event.task.base.report.n r4 = com.obric.event.task.base.report.n.f32869a;     // Catch: Throwable -> L41
        if (r16 == null) goto L9;
        String r5 = r16.getId();     // Catch: Throwable -> L41
        if (r5 == null) goto L9;
        String r6 = r5;
    L10:
        if (r16 == null) goto L13;
        String r7 = Integer.valueOf(r16.getTaskMode()).toString();     // Catch: Throwable -> L41
        if (r7 == null) goto L13;
    L14:
        String r8 = r7;
        if (r16 == null) goto L18;
        String r9 = r16.getShortInstruct();     // Catch: Throwable -> L41
        if (r9 == null) goto L18;
    L19:
        String r10 = r9;
        boolean r11 = true;
        String r12 = e.a(r15, null, 1, null);     // Catch: Throwable -> L41
        String r13 = "update";
        if (r18 == false) goto L23;
        String r14 = "create";
    L24:
        r4.a(r6, r8, r10, r12, r14, r19, r20, r21, Long.valueOf(r22));     // Catch: Throwable -> L41
        if (r16 == null) goto L39;
        o r23 = o.f32870a;     // Catch: Throwable -> L41
        if (r18 == false) goto L29;
        r13 = "create";
    L29:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
        if (r0 != null) goto L32;
    L35:
        if (r11 == false) goto L37;
        String r1 = "gui";
    L38:
        r23.a(r16, r13, r1, r24, r25);     // Catch: Throwable -> L41
        goto L39
    L37:
        r1 = "create_from_discover";
        goto L38
    L32:
        if (r0.length() == 0) goto L35;
        r11 = false;
    L39:
        Object r26 = n.f(x.f38692a);     // Catch: Throwable -> L41
    L43:
        Throwable r27 = n.c(r26);
        if (r27 == null) goto L49;
        Loog.INSTANCE.e(TAG, "report failed: " + r27.getMessage(), r27);
        return;
    L49:
        return;
    L23:
        r14 = "update";
    L18:
        r9 = r15.getShortInstruct();     // Catch: Throwable -> L41
    L13:
        r7 = "";
    L9:
        r6 = r17;
    L41:
        th = move-exception;
        n.a r28 = n.f38560a;
        r26 = n.f(d.o.a(th));
        goto L43
    }

    public final void a(String r4, Integer r5) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        l.f32861a.a("condition", r5);     // Catch: Throwable -> L5
        com.obric.event.task.base.report.n.f32869a.a("condition", r5);     // Catch: Throwable -> L5
        o.f32870a.a(r4);     // Catch: Throwable -> L5
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L13;
        Loog.INSTANCE.e(TAG, "report failed: " + r7.getMessage(), r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    public final void b(String r4, Integer r5) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        l.f32861a.a("shortcut", r5);     // Catch: Throwable -> L5
        com.obric.event.task.base.report.n.f32869a.a("shortcut", r5);     // Catch: Throwable -> L5
        o.f32870a.a(r4);     // Catch: Throwable -> L5
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L13;
        Loog.INSTANCE.e(TAG, "report failed: " + r7.getMessage(), r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L7
    }

    public final void a(ConditionTask r3) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        com.obric.event.task.base.report.b r2 = com.obric.event.task.base.report.b.f32757a;     // Catch: Throwable -> L8
        if (r3 == null) goto L5;
        f r4 = b(r3);     // Catch: Throwable -> L8
    L6:
        r2.a(r4);     // Catch: Throwable -> L8
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = n.c(r5);
        if (r6 == null) goto L16;
        Loog.INSTANCE.e(TAG, "report failed: " + r6.getMessage(), r6);
        return;
    L16:
        return;
    L5:
        r4 = null;
    L8:
        th = move-exception;
        n.a r7 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L10
    }
}
