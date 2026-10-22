package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u000e\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR<\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11;", "", "", "openExempt", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "", "", "Lcom/bytedance/android/livesdk/config/n11$b;", "config", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "c", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f120800a = 0;

    @SerializedName("config")
    private Map<String, ? extends Map<String, b>> config;

    @SerializedName("openExempt")
    private Boolean openExempt;

    public static final class a {
        @JvmStatic
        public static n11 a() {
            n11 r100 = new n11();
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            Boolean r102 = Boolean.TRUE;     // Catch: Throwable -> L9
            r100.d(r102);     // Catch: Throwable -> L9
            LinkedHashMap r103 = new LinkedHashMap();     // Catch: Throwable -> L9
            LinkedHashMap r104 = new LinkedHashMap();     // Catch: Throwable -> L9
            b.a r105 = new b.a();     // Catch: Throwable -> L9
            r105.n(r102);     // Catch: Throwable -> L9
            r105.j(Boolean.FALSE);     // Catch: Throwable -> L9
            r105.l(r102);     // Catch: Throwable -> L9
            Iterator r106 = CollectionsKt.listOf(new String[]{"audioChatRoom", "audioKtv", "videoKtv"}).iterator();     // Catch: Throwable -> L9
        L5:
            if (r106.hasNext() == false) goto L7;
            String r107 = (String) r106.next();     // Catch: Throwable -> L9
            b r110 = new b();     // Catch: Throwable -> L9
            r110.c(r105);     // Catch: Throwable -> L9
            r110.d(r105);     // Catch: Throwable -> L9
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r104.put(r107, r110);     // Catch: Throwable -> L9
            goto L5
        L7:
            b r108 = new b();     // Catch: Throwable -> L9
            r108.d(r105);     // Catch: Throwable -> L9
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r104.put("videoChatRoom", r108);     // Catch: Throwable -> L9
            b r112 = new b();     // Catch: Throwable -> L9
            b.a r113 = new b.a();     // Catch: Throwable -> L9
            Boolean r114 = Boolean.TRUE;     // Catch: Throwable -> L9
            r113.n(r114);     // Catch: Throwable -> L9
            r113.j(r114);     // Catch: Throwable -> L9
            r113.m(r114);     // Catch: Throwable -> L9
            r113.i(r114);     // Catch: Throwable -> L9
            r112.d(r113);     // Catch: Throwable -> L9
            r112.c(r113);     // Catch: Throwable -> L9
            r104.put("game", r112);     // Catch: Throwable -> L9
            r103.put("enterBackground", r104);     // Catch: Throwable -> L9
            LinkedHashMap r115 = new LinkedHashMap();     // Catch: Throwable -> L9
            b r116 = new b();     // Catch: Throwable -> L9
            b.a r117 = new b.a();     // Catch: Throwable -> L9
            r117.n(r114);     // Catch: Throwable -> L9
            Boolean r118 = Boolean.FALSE;     // Catch: Throwable -> L9
            r117.j(r118);     // Catch: Throwable -> L9
            b.a.C1768a r119 = new b.a.C1768a();     // Catch: Throwable -> L9
            r119.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r117.k(r119);     // Catch: Throwable -> L9
            r116.d(r117);     // Catch: Throwable -> L9
            b.a r120 = new b.a();     // Catch: Throwable -> L9
            r120.n(r114);     // Catch: Throwable -> L9
            r120.j(r118);     // Catch: Throwable -> L9
            b.a.C1768a r121 = new b.a.C1768a();     // Catch: Throwable -> L9
            r121.f(CollectionsKt.listOf(new String[]{"CameraActivity", "AlbumActivity"}));     // Catch: Throwable -> L9
            r120.k(r121);     // Catch: Throwable -> L9
            r116.c(r120);     // Catch: Throwable -> L9
            r115.put("audioKtv", r116);     // Catch: Throwable -> L9
            b r122 = new b();     // Catch: Throwable -> L9
            b.a r123 = new b.a();     // Catch: Throwable -> L9
            r123.n(r114);     // Catch: Throwable -> L9
            r123.j(r118);     // Catch: Throwable -> L9
            b.a.C1768a r124 = new b.a.C1768a();     // Catch: Throwable -> L9
            r124.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r123.k(r124);     // Catch: Throwable -> L9
            r122.d(r123);     // Catch: Throwable -> L9
            r115.put("videoKtv", r122);     // Catch: Throwable -> L9
            b r125 = new b();     // Catch: Throwable -> L9
            b.a r126 = new b.a();     // Catch: Throwable -> L9
            r126.n(r114);     // Catch: Throwable -> L9
            r126.j(r114);     // Catch: Throwable -> L9
            r126.m(r114);     // Catch: Throwable -> L9
            r126.i(r114);     // Catch: Throwable -> L9
            r125.d(r126);     // Catch: Throwable -> L9
            r125.c(r126);     // Catch: Throwable -> L9
            r115.put("game", r125);     // Catch: Throwable -> L9
            b r127 = new b();     // Catch: Throwable -> L9
            b.a r128 = new b.a();     // Catch: Throwable -> L9
            r128.n(r114);     // Catch: Throwable -> L9
            r128.j(r118);     // Catch: Throwable -> L9
            r128.m(r114);     // Catch: Throwable -> L9
            r128.i(r118);     // Catch: Throwable -> L9
            b.a.C1768a r129 = new b.a.C1768a();     // Catch: Throwable -> L9
            r129.f(CollectionsKt.listOf("RelationSelectActivity"));     // Catch: Throwable -> L9
            r129.g(CollectionsKt.listOf("AnchorV3FullScreenFragment"));     // Catch: Throwable -> L9
            r128.k(r129);     // Catch: Throwable -> L9
            r127.d(r128);     // Catch: Throwable -> L9
            r127.c(r128);     // Catch: Throwable -> L9
            r115.put("global", r127);     // Catch: Throwable -> L9
            r103.put("coverByPage", r115);     // Catch: Throwable -> L9
            r100.c(r103);     // Catch: Throwable -> L9
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        L11:
            return r100;
        L9:
            th = move-exception;
            Result.Companion r130 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b;", "", "Lcom/bytedance/android/livesdk/config/n11$b$a;", "anchorConfig", "Lcom/bytedance/android/livesdk/config/n11$b$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/config/n11$b$a;", "c", "(Lcom/bytedance/android/livesdk/config/n11$b$a;)V", "audienceConfig", "b", "d", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("anchorConfig")
        private a anchorConfig;

        @SerializedName("audienceConfig")
        private a audienceConfig;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b-\u0010.R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R4\u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010&\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b$a;", "", "", "needExemptCameraCheck", "Ljava/lang/Boolean;", com.amap.api.col.s.ce.f26391f, "()Ljava/lang/Boolean;", "m", "(Ljava/lang/Boolean;)V", "needExemptMicCheck", "h", OfficeSDKRequestTag.KEY_NEW_USER, "exemptAllCameraCheck", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, RXScreenCaptureService.KEY_INDEX, "exemptAllMicCheck", "b", com.amap.api.col.s.ce.f26395j, "needCheckCameraNotification", "getNeedCheckCameraNotification", "setNeedCheckCameraNotification", "needCheckMicNotification", "f", "l", "needCheckIsFloatMode", "e", "setNeedCheckIsFloatMode", "Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "exemptCameraCheckPageConfig", "Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "c", "()Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "setExemptCameraCheckPageConfig", "(Lcom/bytedance/android/livesdk/config/n11$b$a$a;)V", "exemptMicCheckPageConfig", "d", com.amap.api.col.s.ce.f26396k, "", "", "extraConfig", "Ljava/util/Map;", "getExtraConfig", "()Ljava/util/Map;", "setExtraConfig", "(Ljava/util/Map;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("exemptAllCameraCheck")
            private Boolean exemptAllCameraCheck;

            @SerializedName("exemptAllMicCheck")
            private Boolean exemptAllMicCheck;

            @SerializedName("exemptCameraCheckPageConfig")
            private C1768a exemptCameraCheckPageConfig;

            @SerializedName("exemptMicCheckPageConfig")
            private C1768a exemptMicCheckPageConfig;

            @SerializedName("extraConfig")
            private Map<String, ? extends Object> extraConfig;

            @SerializedName("needCheckCameraNotification")
            private Boolean needCheckCameraNotification;

            @SerializedName("needCheckIsFloatMode")
            private Boolean needCheckIsFloatMode;

            @SerializedName("needCheckMicNotification")
            private Boolean needCheckMicNotification;

            @SerializedName("needExemptCameraCheck")
            private Boolean needExemptCameraCheck;

            @SerializedName("needExemptMicCheck")
            private Boolean needExemptMicCheck;

            /* JADX INFO: renamed from: com.bytedance.android.livesdk.config.n11$b$a$a, reason: collision with other inner class name */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/config/n11$b$a$a;", "", "", "", "activityList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "fragmentList", "b", com.amap.api.col.s.ce.f26391f, "needCheckUrlPageList", "d", "setNeedCheckUrlPageList", "urlList", "e", "setUrlList", "ignoreStates", "c", "setIgnoreStates", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
            public static final class C1768a {

                @SerializedName("activityList")
                private List<String> activityList;

                @SerializedName("fragmentList")
                private List<String> fragmentList;

                @SerializedName("ignoreStates")
                private List<String> ignoreStates;

                @SerializedName("needCheckUrlPageList")
                private List<String> needCheckUrlPageList;

                @SerializedName("urlList")
                private List<String> urlList;

                public C1768a() {
                }

                public final List<String> a() {
                    return this.activityList;
                }

                public final List<String> b() {
                    return this.fragmentList;
                }

                public final List<String> c() {
                    return this.ignoreStates;
                }

                public final List<String> d() {
                    return this.needCheckUrlPageList;
                }

                public final List<String> e() {
                    return this.urlList;
                }

                public final void f(List<String> r100) {
                    this.activityList = r100;
                }

                public final void g(List<String> r100) {
                    this.fragmentList = r100;
                }
            }

            public a() {
                Boolean r100 = Boolean.FALSE;
                this.needExemptCameraCheck = r100;
                this.needExemptMicCheck = r100;
                this.exemptAllCameraCheck = r100;
                this.exemptAllMicCheck = r100;
                this.needCheckCameraNotification = r100;
                this.needCheckMicNotification = r100;
                this.needCheckIsFloatMode = r100;
            }

            public final Boolean a() {
                return this.exemptAllCameraCheck;
            }

            public final Boolean b() {
                return this.exemptAllMicCheck;
            }

            public final C1768a c() {
                return this.exemptCameraCheckPageConfig;
            }

            public final C1768a d() {
                return this.exemptMicCheckPageConfig;
            }

            public final Boolean e() {
                return this.needCheckIsFloatMode;
            }

            public final Boolean f() {
                return this.needCheckMicNotification;
            }

            public final Boolean g() {
                return this.needExemptCameraCheck;
            }

            public final Boolean h() {
                return this.needExemptMicCheck;
            }

            public final void i(Boolean r100) {
                this.exemptAllCameraCheck = r100;
            }

            public final void j(Boolean r100) {
                this.exemptAllMicCheck = r100;
            }

            public final void k(C1768a r100) {
                this.exemptMicCheckPageConfig = r100;
            }

            public final void l(Boolean r100) {
                this.needCheckMicNotification = r100;
            }

            public final void m(Boolean r100) {
                this.needExemptCameraCheck = r100;
            }

            public final void n(Boolean r100) {
                this.needExemptMicCheck = r100;
            }
        }

        public b() {
        }

        public final a a() {
            return this.anchorConfig;
        }

        public final a b() {
            return this.audienceConfig;
        }

        public final void c(a r100) {
            this.anchorConfig = r100;
        }

        public final void d(a r100) {
            this.audienceConfig = r100;
        }
    }

    static {
    }

    public n11() {
        this.openExempt = Boolean.TRUE;
        this.config = MapsKt.emptyMap();
    }

    public final Map<String, Map<String, b>> a() {
        return this.config;
    }

    public final Boolean b() {
        return this.openExempt;
    }

    public final void c(Map<String, ? extends Map<String, b>> r100) {
        this.config = r100;
    }

    public final void d(Boolean r100) {
        this.openExempt = r100;
    }
}
