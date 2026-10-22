package com.obric.aiagent.skill.virt.impl.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellExecutionState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f22056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f22057b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f22058c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f22059d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f22060e = null;
    public static final j f = null;
    public static final j g = null;
    private static final /* synthetic */ j[] i = null;
    private static final /* synthetic */ d.d.a j = null;
    private final String h;

    private static final /* synthetic */ j[] c() {
        return new j[]{f22056a, f22057b, f22058c, f22059d, f22060e, f, g};
    }

    private j(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public final String a() {
        return this.h;
    }

    static {
        f22056a = new j("STARTING", 0, "PENDING");
        f22057b = new j("RUNNING", 1, "RUNNING");
        f22058c = new j("SUCCEEDED", 2, "SUCCESS");
        f22059d = new j("FAILED", 3, "ERROR");
        f22060e = new j("CANCELLED", 4, "CANCELLED");
        f = new j("KILLED", 5, "KILLED");
        g = new j("TIMED_OUT", 6, "TIMED_OUT");
        j[] r0 = c();
        i = r0;
        j = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public final boolean b() {
        if (this != f22056a) goto L5;
    L7:
        return false;
    L5:
        if (this == f22057b) goto L7;
        return true;
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(i.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
