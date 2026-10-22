package com.obric.autogui.session.state.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtualDisplayRecordSetStartupGate.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum q extends Enum<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f31367a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f31368b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f31369c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f31370d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ q[] f31371e = null;
    private static final /* synthetic */ d.d.a f = null;

    private static final /* synthetic */ q[] a() {
        return new q[]{f31367a, f31368b, f31369c, f31370d};
    }

    private q(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f31367a = new q("DISPLAY", 0);
        f31368b = new q("RECORD_SET", 1);
        f31369c = new q("ACTIVATION", 2);
        f31370d = new q("TERMINATED", 3);
        q[] r0 = a();
        f31371e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static q valueOf(String r2) {
        return (q) ZeusTransformUtils.preCheckCast(Enum.valueOf(q.class, r2), q.class, "com.obric.aiagent.plugin");
    }

    public static q[] values() {
        return (q[]) ZeusTransformUtils.preCheckCast(f31371e.clone(), q[].class, "com.obric.aiagent.plugin");
    }
}
