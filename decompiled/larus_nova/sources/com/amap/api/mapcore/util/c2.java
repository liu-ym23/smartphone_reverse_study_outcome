package com.amap.api.mapcore.util;

/* JADX INFO: loaded from: classes28.dex */
public interface c2 {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f27104a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f27105b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f27106c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f27107d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f27108e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ a[] f27109f = null;

        static {
            a r100 = new a("amap_exception", 0, -1);
            f27104a = r100;
            a r101 = new a("network_exception", 1, -1);
            f27105b = r101;
            a r102 = new a("file_io_exception", 2, 0);
            f27106c = r102;
            a r103 = new a("success_no_exception", 3, 1);
            f27107d = r103;
            a r104 = new a("cancel_no_exception", 4, 2);
            f27108e = r104;
            f27109f = new a[]{r100, r101, r102, r103, r104};
        }

        public static a[] values() {
            return (a[]) f27109f.clone();
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        private a(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    void a(long r100, long r101);

    void a(a r100);

    void h();

    void onCancel();

    void onFinish();
}
