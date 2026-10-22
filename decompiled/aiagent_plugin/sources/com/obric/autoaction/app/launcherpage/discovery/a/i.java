package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23605a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f23606b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f23607c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ i[] f23608e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23609d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    private static final /* synthetic */ i[] b() {
        return new i[]{f23606b, f23607c};
    }

    private i(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23609d = r3;
    }

    public final int a() {
        return this.f23609d;
    }

    static {
        f23606b = new i("AND", 0, 1);
        f23607c = new i("OR", 1, 2);
        i[] r0 = b();
        f23608e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23605a = new a(null);
    }

    public static i valueOf(String r2) {
        return (i) ZeusTransformUtils.preCheckCast(Enum.valueOf(i.class, r2), i.class, "com.obric.aiagent.plugin");
    }

    public static i[] values() {
        return (i[]) ZeusTransformUtils.preCheckCast(f23608e.clone(), i[].class, "com.obric.aiagent.plugin");
    }
}
