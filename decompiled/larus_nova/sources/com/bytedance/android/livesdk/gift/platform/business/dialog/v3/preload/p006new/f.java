package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

/* JADX INFO: loaded from: classes9.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f128222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GiftPreloadResType f128223b;

    public static final class a extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f128224c = null;

        static {
            f128224c = new a();
        }

        public a() {
            super("", GiftPreloadResType.ANNIE_LYNX_MODEL);
        }
    }

    public static final class b extends f {
        public b(int r100) {
            super(Integer.valueOf(r100), GiftPreloadResType.GIFT_PANEL_VIEW);
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f128225c = null;

        static {
            f128225c = new c();
        }

        public c() {
            super("", GiftPreloadResType.ICON_ANIMATOR_URI);
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f128226c = null;

        static {
            f128226c = new d();
        }

        public d() {
            super("", GiftPreloadResType.ITEM_LIST_DATA);
        }
    }

    public f(Object r100, GiftPreloadResType r101) {
        this.f128222a = r100;
        this.f128223b = r101;
    }
}
