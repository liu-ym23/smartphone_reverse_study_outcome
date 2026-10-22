package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: TTServiceInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f38090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f38091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f38092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CronetFrontierClient.c f38093e;

    /* JADX INFO: compiled from: TTServiceInfo.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38094a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f38095b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f38096c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f38097e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f38098d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f38097e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("Low", 0, 0);
            f38094a = r0;
            a r1 = new a("Medium", 1, 1);
            f38095b = r1;
            a r3 = new a("High", 2, 2);
            f38096c = r3;
            f38097e = new a[]{r0, r1, r3};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f38098d = r3;
        }

        public int a() {
            return this.f38098d;
        }
    }

    public ad(int r3, CronetFrontierClient.c r4) {
        CronetFrontierClient.c r5 = (CronetFrontierClient.c) ZeusTransformUtils.wrapperContextForParams(r4, CronetFrontierClient.c.class, "com.obric.aiagent.plugin");
        this.f38090b = true;
        this.f38092d = a.f38094a;
        if (r3 <= 0) goto L10;
        if (r5 == null) goto L8;
        this.f38089a = r3;
        this.f38093e = r5;
        return;
    L8:
        throw new IllegalArgumentException("Service listener must not be null.");
    L10:
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
