package com.obric.aiagent.skill.ovirt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f20993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f20994b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f20995c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f20996d = null;
    private static final /* synthetic */ f[] f = null;
    private static final /* synthetic */ d.d.a g = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f20997e;

    private static final /* synthetic */ f[] b() {
        return new f[]{f20993a, f20994b, f20995c, f20996d};
    }

    private f(String r1, int r2, String r3) {
        super(r1, r2);
        this.f20997e = r3;
    }

    public final String a() {
        return this.f20997e;
    }

    static {
        f20993a = new f("INVALID_UNIQUE_ID", 0, "invalid_unique_id");
        f20994b = new f("SHELL_UNSUPPORTED", 1, "shell_unsupported");
        f20995c = new f("VIRT_UNAVAILABLE", 2, "virt_unavailable");
        f20996d = new f("OPEN_FAILED", 3, "open_failed");
        f[] r0 = b();
        f = r0;
        g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
