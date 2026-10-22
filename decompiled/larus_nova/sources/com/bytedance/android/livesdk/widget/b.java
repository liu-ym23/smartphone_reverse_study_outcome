package com.bytedance.android.livesdk.widget;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f161414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Priority f161415b;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f161416c = null;

        static {
            f161416c = new a();
        }

        public a() {
            super(i0.a.f161745b, Priority.AdvanceCSGesture);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widget.b$b, reason: collision with other inner class name */
    public static final class C2469b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C2469b f161417c = null;

        static {
            f161417c = new C2469b();
        }

        public C2469b() {
            super(i0.b.f161746b, Priority.ClickPS2CS);
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f161418c = null;

        static {
            f161418c = new c();
        }

        public c() {
            super(i0.c.f161747b, Priority.NormalPinchZoom);
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f161419c = null;

        static {
            f161419c = new d();
        }

        public d() {
            super(i0.d.f161748b, Priority.RightScroll2Leave);
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f161420c = null;

        static {
            f161420c = new e();
        }

        public e() {
            super(i0.e.f161749b, Priority.VrClearMode);
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f161421c = null;

        static {
            f161421c = new f();
        }

        public f() {
            super(i0.f.f161750b, Priority.VrDirectionIndicator);
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f161422c = null;

        static {
            f161422c = new g();
        }

        public g() {
            super(i0.g.f161751b, Priority.VrPlayer);
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f161423c = null;

        static {
            f161423c = new h();
        }

        public h() {
            super(i0.h.f161752b, Priority.ZoomAndLock);
        }
    }

    @Override // com.bytedance.android.livesdk.widget.f0
    public final i0 getId() {
        return this.f161414a;
    }

    @Override // com.bytedance.android.livesdk.widget.f0
    public final Priority getPriority() {
        return this.f161415b;
    }

    public b(i0 r100, Priority r101) {
        this.f161414a = r100;
        this.f161415b = r101;
    }
}
