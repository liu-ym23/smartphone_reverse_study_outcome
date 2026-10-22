package com.bytedance.android.livesdk.widget;

/* JADX INFO: loaded from: classes11.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f161744a;

    public static final class a extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f161745b = null;

        static {
            f161745b = new a();
        }

        public a() {
            super("用于刚进房时处理单击屏幕触发的清屏手势，此时AbsInteractionFragment的mGestureDetector还没注册监听");
        }
    }

    public static final class b extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f161746b = null;

        static {
            f161746b = new b();
        }

        public b() {
            super("公屏未消费的点击手势转为清屏手势");
        }
    }

    public static final class c extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f161747b = null;

        static {
            f161747b = new c();
        }

        public c() {
            super("pinch手势（松手复原）");
        }
    }

    public static final class d extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f161748b = null;

        static {
            f161748b = new d();
        }

        public d() {
            super("右滑退出直播间手势");
        }
    }

    public static final class e extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f161749b = null;

        static {
            f161749b = new e();
        }

        public e() {
            super("清屏模式下的vr手势");
        }
    }

    public static final class f extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f161750b = null;

        static {
            f161750b = new f();
        }

        public f() {
            super("vr模式下的方向指示器手势");
        }
    }

    public static final class g extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f161751b = null;

        static {
            f161751b = new g();
        }

        public g() {
            super("vr模式下的播放器手势");
        }
    }

    public static final class h extends i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f161752b = null;

        static {
            f161752b = new h();
        }

        public h() {
            super("优化后的pinch手势");
        }
    }

    public i0(String r100) {
        this.f161744a = r100;
    }
}
