package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum n extends Enum<n> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23623a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f23624b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f23625c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ n[] f23626e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23627d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ n[] b() {
        return new n[]{f23624b, f23625c};
    }

    private n(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23627d = r3;
    }

    public final int a() {
        return this.f23627d;
    }

    static {
        f23624b = new n("INSIDE", 0, 1);
        f23625c = new n("OUTSIDE", 1, 2);
        n[] r0 = b();
        f23626e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23623a = new a(null);
    }

    public static n valueOf(String r2) {
        return (n) ZeusTransformUtils.preCheckCast(Enum.valueOf(n.class, r2), n.class, "com.obric.aiagent.plugin");
    }

    public static n[] values() {
        return (n[]) ZeusTransformUtils.preCheckCast(f23626e.clone(), n[].class, "com.obric.aiagent.plugin");
    }
}
