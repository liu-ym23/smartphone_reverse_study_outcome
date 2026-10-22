package com.bytedance.android.ecom.bcm.track.impl.monitor;

import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f51127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f51128b;

    public static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f51129c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f51130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f51131b;

        /* JADX INFO: renamed from: com.bytedance.android.ecom.bcm.track.impl.monitor.n$a$a, reason: collision with other inner class name */
        public static final class C0869a {
        }

        public a() {
            this(3);
        }

        static {
            f51129c = new a(3);
        }

        public /* synthetic */ a(int r100) {
            if ((r100 & 2) == 0) goto L5;
            String r101 = "no_value";
        L6:
            this(false, r101);
            return;
        L5:
            r101 = null;
            goto L6
        }

        public a(boolean r100, String r101) {
            this.f51130a = r100;
            this.f51131b = r101;
        }
    }

    public n(String r100, List<a> r101) {
        this.f51127a = r100;
        this.f51128b = r101;
    }
}
