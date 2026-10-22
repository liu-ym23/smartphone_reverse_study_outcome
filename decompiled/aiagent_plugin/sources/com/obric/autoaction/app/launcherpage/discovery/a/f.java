package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum f extends Enum<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f23594b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f23595c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ f[] f23596e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23597d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ f[] b() {
        return new f[]{f23594b, f23595c};
    }

    private f(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23597d = r3;
    }

    public final int a() {
        return this.f23597d;
    }

    static {
        f23594b = new f("HOME", 0, 1);
        f23595c = new f("COMPANY", 1, 2);
        f[] r0 = b();
        f23596e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23593a = new a(null);
    }

    public static f valueOf(String r2) {
        return (f) ZeusTransformUtils.preCheckCast(Enum.valueOf(f.class, r2), f.class, "com.obric.aiagent.plugin");
    }

    public static f[] values() {
        return (f[]) ZeusTransformUtils.preCheckCast(f23596e.clone(), f[].class, "com.obric.aiagent.plugin");
    }
}
