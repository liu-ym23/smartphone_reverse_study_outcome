package com.obric.aiagent.skill.virt.impl.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f21903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f21904b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ c[] f21905d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f21906e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21907c;

    private static final /* synthetic */ c[] b() {
        return new c[]{f21903a, f21904b};
    }

    private c(String r1, int r2, String r3) {
        super(r1, r2);
        this.f21907c = r3;
    }

    public final String a() {
        return this.f21907c;
    }

    static {
        f21903a = new c("IMPORT", 0, ".imports");
        f21904b = new c("EXPORT", 1, ".exports");
        c[] r0 = b();
        f21905d = r0;
        f21906e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static c valueOf(String r2) {
        return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
    }

    public static c[] values() {
        return (c[]) ZeusTransformUtils.preCheckCast(f21905d.clone(), c[].class, "com.obric.aiagent.plugin");
    }
}
