package com.obric.autoaction.app.launcherpage.discovery.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum p extends Enum<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f23634b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f23635c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ p[] f23636e = null;
    private static final /* synthetic */ d.d.a f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23637d;

    /* JADX INFO: compiled from: DiscoveryModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final p a(Integer r7) {
            p[] r6 = p.values();
            int r0 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L14;
            p r3 = r6[r2];
            int r4 = r3.a();
            if (r7 != null) goto L8;
        L10:
            boolean r5 = false;
        L11:
            if (r5 == true) goto L18;
            r2 = r2 + 1;
            goto L3
        L18:
            return r3;
        L8:
            if (r4 != r7.intValue()) goto L10;
            r5 = true;
            goto L11
        L14:
            return null;
        }
    }

    private static final /* synthetic */ p[] b() {
        return new p[]{f23634b, f23635c};
    }

    private p(String r1, int r2, int r3) {
        super(r1, r2);
        this.f23637d = r3;
    }

    public final int a() {
        return this.f23637d;
    }

    static {
        f23634b = new p("SHORTCUT", 0, 1);
        f23635c = new p("AUTO", 1, 2);
        p[] r0 = b();
        f23636e = r0;
        f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        f23633a = new a(null);
    }

    public static p valueOf(String r2) {
        return (p) ZeusTransformUtils.preCheckCast(Enum.valueOf(p.class, r2), p.class, "com.obric.aiagent.plugin");
    }

    public static p[] values() {
        return (p[]) ZeusTransformUtils.preCheckCast(f23636e.clone(), p[].class, "com.obric.aiagent.plugin");
    }
}
