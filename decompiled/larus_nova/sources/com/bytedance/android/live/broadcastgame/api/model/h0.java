package com.bytedance.android.live.broadcastgame.api.model;

/* JADX INFO: loaded from: classes45.dex */
public abstract class h0 {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f59347a;

        public a() {
            this(null);
        }

        public a(String r100) {
            this.f59347a = r100;
        }
    }

    public static final class b extends h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f59348a;

        public b() {
            this(0);
        }

        public b(int r100) {
            this.f59348a = r100;
        }
    }

    public static class c extends h0 {
        public c() {
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f59349a = null;

        static {
            f59349a = new d();
        }

        public d() {
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f59350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f59351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f59352c;

        public e() {
            boolean r100 = false;
            this(r100, r100, r100, 7);
        }

        public e(boolean r100, boolean r101, boolean r102) {
            this.f59350a = r100;
            this.f59351b = r101;
            this.f59352c = r102;
        }

        public /* synthetic */ e(boolean r100, boolean r101, boolean r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = false;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = false;
        L11:
            this(r100, r101, r102);
        }
    }

    public h0() {
    }
}
