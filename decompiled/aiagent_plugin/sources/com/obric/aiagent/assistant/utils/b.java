package com.obric.aiagent.assistant.utils;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ObricAppStatusConst.kt */
/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f16308a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f16309b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f16310c = null;
    private static final /* synthetic */ b[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f16311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f16312e;

    private static final /* synthetic */ b[] a() {
        return new b[]{f16308a, f16309b, f16310c};
    }

    private b(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.f16311d = r3;
        this.f16312e = r4;
    }

    static {
        f16308a = new b("Unknown", 0, -1, SensitiveType.UNKNOWN);
        f16309b = new b("IsDefaultAssistant", 1, 0, "isDefaultAssistant");
        f16310c = new b("NotDefaultAssistant", 2, 1, "notDefaultAssistant");
        b[] r0 = a();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(f.clone(), b[].class, "com.obric.aiagent.plugin");
    }
}
