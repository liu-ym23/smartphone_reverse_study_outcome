package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ITTNetFileTransfer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f22287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f22288b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ m[] f22289c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ d.d.a f22290d = null;

    private static final /* synthetic */ m[] a() {
        return new m[]{f22287a, f22288b};
    }

    private m(String r1, int r2) {
        super(r1, r2);
    }

    static {
        f22287a = new m("STANDARD_HTTP", 0);
        f22288b = new m("PUBLIC_HTTPS", 1);
        m[] r0 = a();
        f22289c = r0;
        f22290d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f22289c.clone(), m[].class, "com.obric.aiagent.plugin");
    }
}
