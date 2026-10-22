package com.bytedance.android.ec.core.imagex.opt;

import com.bytedance.android.ec.slice.SliceInitService;

/* JADX INFO: loaded from: classes43.dex */
public abstract class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44882a;

    public static abstract class a extends p0 {

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.imagex.opt.p0$a$a, reason: collision with other inner class name */
        public static final class C0803a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C0803a f44883b = null;

            static {
                f44883b = new C0803a();
            }

            public C0803a() {
                super(SliceInitService.DEFAULT_SWITCH);
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f44884b = null;

            static {
                f44884b = new b();
            }

            public b() {
                super("str");
            }
        }

        public a(String r100) {
            super(r100);
        }
    }

    public static final class b extends p0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f44885b = null;

        static {
            f44885b = new b();
        }

        public b() {
            super(SliceInitService.DEFAULT_SWITCH);
        }
    }

    public static final class c extends p0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f44886b = null;

        static {
            f44886b = new c();
        }

        public c() {
            super("str");
        }
    }

    public static final class d extends p0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f44887b = null;

        static {
            f44887b = new d();
        }

        public d() {
            super("");
        }
    }

    public p0(String r100) {
        this.f44882a = r100;
    }
}
