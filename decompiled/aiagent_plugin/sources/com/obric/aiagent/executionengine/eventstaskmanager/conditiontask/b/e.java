package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionTaskExt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum e extends Enum<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16892a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f16893b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f16894c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f16895d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f16896e = null;
    public static final e f = null;
    public static final e g = null;
    public static final e h = null;
    public static final e i = null;
    private static final /* synthetic */ e[] j = null;
    private static final /* synthetic */ d.d.a k = null;

    private static final /* synthetic */ e[] a() {
        return new e[]{f16892a, f16893b, f16894c, f16895d, f16896e, f, g, h, i};
    }

    private e(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f16892a = new e("DAILY", 0);
        f16893b = new e("WEEKLY", 1);
        f16894c = new e("MONTHLY", 2);
        f16895d = new e("YEARLY", 3);
        f16896e = new e("EVERY_OFF_DAY", 4);
        f = new e("EVERY_WORK_DAY", 5);
        g = new e("SINGLE_TASK", 6);
        h = new e("TIMER", 7);
        i = new e("UNKNOWN", 8);
        e[] r0 = a();
        j = r0;
        k = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static e valueOf(String r2) {
        return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
    }

    public static e[] values() {
        return (e[]) ZeusTransformUtils.preCheckCast(j.clone(), e[].class, "com.obric.aiagent.plugin");
    }
}
