package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public interface i {

    public static abstract class a<T> implements c {
        public a() {
        }

        public abstract T b();

        public abstract g<T> c();

        @Override // com.bytedance.android.live.browser.jsbridge.i.c
        public final String getKey() {
            return c().f63210a;
        }
    }

    public interface b extends c {
        Observable<JsonElement> a(String r100);
    }

    public interface c {
        String getKey();
    }

    public interface d {
        JsonObject a();

        void b(String r100, JSONArray r101, Function2<? super String, ? super com.bytedance.ies.web.jsbridge2.g<JsonObject, JsonObject>, Unit> r102, Function1<? super String, Unit> r103);

        void release();
    }

    public static abstract class e<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63202a;

        public static final class a extends e<Episode> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int f63203b = 0;

            static {
            }
        }

        public static final class b extends e<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final b f63204b = null;

            static {
                f63204b = new b();
            }

            public b() {
                super("current_live_multitab_info");
            }
        }

        public static final class c extends e<IRoom> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f63205b = null;

            static {
                f63205b = new c();
            }

            public c() {
                super("current_room");
            }
        }

        public static final class d extends e<IBaseUser> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f63206b = null;

            static {
                f63206b = new d();
            }

            public d() {
                super("current_user");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e, reason: collision with other inner class name */
        public static abstract class AbstractC1036e<T> extends e<T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f63207b;

            /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e$a */
            public static final class a extends AbstractC1036e<JsonObject> {

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public static final a f63208c = null;

                static {
                    f63208c = new a();
                }

                public a() {
                    super("broadcast_game");
                }
            }

            /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$e$e$b */
            public static final class b extends AbstractC1036e<JsonObject> {
                public b(String r100) {
                    Intrinsics.checkNotNullParameter(r100, "key");
                    super(r100);
                }
            }

            @Override // com.bytedance.android.live.browser.jsbridge.i.e, com.bytedance.android.live.browser.jsbridge.i.f
            public final String a() {
                return this.f63207b;
            }

            public AbstractC1036e(String r100) {
                super(r100);
                this.f63207b = r100;
            }
        }

        public static final class f extends e<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final f f63209b = null;

            static {
                f63209b = new f();
            }

            public f() {
                super("room_message");
            }
        }

        @Override // com.bytedance.android.live.browser.jsbridge.i.f
        public String a() {
            return this.f63202a;
        }

        public e(String r100) {
            this.f63202a = r100;
        }
    }

    public interface f<T> {
        String a();
    }

    public static abstract class g<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f63210a;

        public static final class a extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f63211b = null;

            static {
                f63211b = new a();
            }

            public a() {
                super("adlog");
            }
        }

        public static final class b extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int f63212b = 0;

            static {
            }
        }

        public static final class c extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final c f63213b = null;

            static {
                f63213b = new c();
            }

            public c() {
                super(IPerformanceManager.SCENE_CLICK_DOU_PLUS);
            }
        }

        public static final class d extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final d f63214b = null;

            static {
                f63214b = new d();
            }

            public d() {
                super("game");
            }
        }

        public static final class e extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int f63215b = 0;

            static {
            }
        }

        public static final class f extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final f f63216b = null;

            static {
                f63216b = new f();
            }

            public f() {
                super("linkmic");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$g$g, reason: collision with other inner class name */
        public static final class C1037g extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1037g f63217b = null;

            static {
                f63217b = new C1037g();
            }

            public C1037g() {
                super("log");
            }
        }

        public static final class h extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final h f63218b = null;

            static {
                f63218b = new h();
            }

            public h() {
                super(ErrorType.PREFETCH);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.i$g$i, reason: collision with other inner class name */
        public static final class C1038i extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C1038i f63219b = null;

            static {
                f63219b = new C1038i();
            }

            public C1038i() {
                super("setting");
            }
        }

        public static final class j extends g<JsonObject> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final j f63220b = null;

            static {
                f63220b = new j();
            }

            public j() {
                super("storage");
            }
        }

        @Override // com.bytedance.android.live.browser.jsbridge.i.f
        public final String a() {
            return this.f63210a;
        }

        public g(String r100) {
            this.f63210a = r100;
        }
    }

    Map<String, c> a();

    <T> void b(e<T> r100, T r101);

    <T> void registerStaticState(Function1<? super DataCenter, ? extends a<? extends T>> r100);
}
