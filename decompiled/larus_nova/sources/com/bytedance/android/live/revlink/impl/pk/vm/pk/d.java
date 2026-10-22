package com.bytedance.android.live.revlink.impl.pk.vm.pk;

import com.alibaba.gaiax.model.GXAnimation;

/* JADX INFO: loaded from: classes47.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f97280a;

    public static final class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f97281b = null;

        static {
            f97281b = new a();
        }

        public a() {
            super("DISABLED");
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f97282b = null;

        static {
            f97282b = new b();
        }

        public b() {
            super("FINISHED");
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f97283b = null;

        static {
            f97283b = new c();
        }

        public c() {
            super("OVER");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.pk.d$d, reason: collision with other inner class name */
    public static final class C1504d extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C1504d f97284b = null;

        static {
            f97284b = new C1504d();
        }

        public C1504d() {
            super(GXAnimation.STATE_START);
        }
    }

    public d(String r100) {
        this.f97280a = r100;
    }
}
