package com.obric.aiagent.skill.manager.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillManagerContracts.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum am extends Enum<am> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final am f19201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final am f19202b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final am f19203c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final am f19204d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final am f19205e = null;
    public static final am f = null;
    public static final am g = null;
    private static final /* synthetic */ am[] h = null;
    private static final /* synthetic */ d.d.a i = null;

    private static final /* synthetic */ am[] a() {
        return new am[]{f19201a, f19202b, f19203c, f19204d, f19205e, f, g};
    }

    private am(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f19201a = new am("SKIPPED_STORE", 0);
        f19202b = new am("SKIPPED_UP_TO_DATE", 1);
        f19203c = new am("POLLED_TASK", 2);
        f19204d = new am("FETCHED_MANIFEST", 3);
        f19205e = new am("SUBMITTED_SCAN", 4);
        f = new am("NOT_FOUND", 5);
        g = new am("FAILED", 6);
        am[] r0 = a();
        h = r0;
        i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static am valueOf(String r2) {
        return (am) ZeusTransformUtils.preCheckCast(Enum.valueOf(am.class, r2), am.class, "com.obric.aiagent.plugin");
    }

    public static am[] values() {
        return (am[]) ZeusTransformUtils.preCheckCast(h.clone(), am[].class, "com.obric.aiagent.plugin");
    }
}
