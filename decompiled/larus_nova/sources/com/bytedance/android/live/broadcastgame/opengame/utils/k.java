package com.bytedance.android.live.broadcastgame.opengame.utils;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public abstract class k<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f61162b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61163a;

    public static final class a extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f61164c = null;

        static {
            f61164c = new a();
        }

        public a() {
            super("app_id");
        }
    }

    public static final class b {
    }

    public static final class c extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f61165c = null;

        static {
            f61165c = new c();
        }

        public c() {
            super("extra");
        }
    }

    public static final class d extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f61166c = null;

        static {
            f61166c = new d();
        }

        public d() {
            super("game_id");
        }
    }

    public static final class e extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final e f61167c = null;

        static {
            f61167c = new e();
        }

        public e() {
            super(EventConstants.ExtraJson.GAME_NAME);
        }
    }

    public static final class f extends k<Integer> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final f f61168c = null;

        static {
            f61168c = new f();
        }

        public f() {
            super(BdpAppEventConstant.PARAMS_GAME_TYPE);
        }
    }

    public static final class g extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final g f61169c = null;

        static {
            f61169c = new g();
        }

        public g() {
            super("icon");
        }
    }

    public static final class h extends k<Boolean> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f61170c = 0;

        static {
        }
    }

    public static final class i extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f61171c = null;

        static {
            f61171c = new i();
        }

        public i() {
            super("launch_from");
        }
    }

    public static final class j extends k<List<? extends Integer>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final j f61172c = null;

        static {
            f61172c = new j();
        }

        public j() {
            super("support_live_scene");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.utils.k$k, reason: collision with other inner class name */
    public static final class C1014k extends k<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C1014k f61173c = null;

        static {
            f61173c = new C1014k();
        }

        public C1014k() {
            super("version");
        }
    }

    static {
    }

    public k(String r100) {
        this.f61163a = r100;
    }
}
