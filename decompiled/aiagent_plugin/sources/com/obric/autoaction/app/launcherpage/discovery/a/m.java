package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f23619b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f23620c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ m[] f23621e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23622d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ m[] b() {
        return new m[]{f23619b, f23620c};
    }

    private m(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23622d = r3;
    }

    public final int a() {
        return this.f23622d;
    }

    static {
        f23619b = new m("GEO_RADIUS", 0, 1);
        f23620c = new m("PLACE_ALIAS", 1, 2);
        m[] r0 = b();
        f23621e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23618a = new a(null);
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(f23621e.clone(), m[].class, "com.obric.aiagent.plugin");
    }
}
