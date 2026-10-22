package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum j extends Enum<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f23611b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f23612c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ j[] f23613e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23614d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ j[] b() {
        return new j[]{f23611b, f23612c};
    }

    private j(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23614d = r3;
    }

    public final int a() {
        return this.f23614d;
    }

    static {
        f23611b = new j("TIME", 0, 1);
        f23612c = new j("LOCATION", 1, 2);
        j[] r0 = b();
        f23613e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23610a = new a(null);
    }

    public static j valueOf(String r2) {
        return (j) ZeusTransformUtils.preCheckCast(Enum.valueOf(j.class, r2), j.class, "com.obric.aiagent.plugin");
    }

    public static j[] values() {
        return (j[]) ZeusTransformUtils.preCheckCast(f23613e.clone(), j[].class, "com.obric.aiagent.plugin");
    }
}
