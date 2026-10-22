package com.bytedance.agentrobots.identity;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RobotAgentType.java */
/* JADX INFO: loaded from: classes.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4036a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f4037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f4038c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f4039d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b[] f4040e = null;

    private b(String r1, int r2) {
        super(r1, r2);
    }

    private static /* synthetic */ b[] a() {
        return new b[]{f4036a, f4037b, f4038c, f4039d};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f4040e.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    static {
        f4036a = new b("RECORDING", 0);
        f4037b = new b("SUGGESTIVE", 1);
        f4038c = new b("ASSISTIVE", 2);
        f4039d = new b("AUTONOMOUS", 3);
        f4040e = a();
    }
}
