package com.bytedance.android.live.broadcastgame.opengame.lynx;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.bouncycastle.crypto.CryptoServicesPermission;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0005+\u0017123B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000b\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\"\u0010%\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$d;", "setting", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$d;", "getSetting", "()Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$d;", "setSetting", "(Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$d;)V", "", "appId", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "projectName", "getProjectName", "setProjectName", "", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$e;", "views", "Ljava/util/List;", "b", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$b;", "compilerOptions", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$b;", "getCompilerOptions", "()Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$b;", "setCompilerOptions", "(Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$b;)V", "appType", "getAppType", "setAppType", "targetSdkVersion", "getTargetSdkVersion", "setTargetSdkVersion", "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$c;", CryptoServicesPermission.GLOBAL_CONFIG, "Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$c;", "setGlobalConfig", "(Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$c;)V", "<init>", "()V", "c", "d", "e", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("appid")
    private String appId;

    @SerializedName("appType")
    private String appType;

    @SerializedName("compilerOptions")
    private b compilerOptions;

    @SerializedName(CryptoServicesPermission.GLOBAL_CONFIG)
    private c globalConfig;

    @SerializedName("projectname")
    private String projectName;

    @SerializedName("setting")
    private d setting;

    @SerializedName("targetSdkVersion")
    private String targetSdkVersion;

    @SerializedName("views")
    private List<e> views;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.lynx.a$a, reason: collision with other inner class name */
    public static final class C0987a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$b;", "", "", "supportNpm", "Ljava/lang/Boolean;", "getSupportNpm", "()Ljava/lang/Boolean;", "", "npmClient", "Ljava/lang/String;", "getNpmClient", "()Ljava/lang/String;", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("npmClient")
        private final String npmClient;

        @SerializedName("supportNpm")
        private final Boolean supportNpm;

        public b() {
            this.npmClient = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$c;", "", "", "panelHeightType", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setPanelHeightType", "(Ljava/lang/String;)V", "", "networkTime", "J", "getNetworkTime", "()J", "setNetworkTime", "(J)V", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("networkTimeout")
        private long networkTime;

        @SerializedName("panelHeightType")
        private String panelHeightType;

        public c() {
            this.panelHeightType = "";
            this.networkTime = 60000;
        }

        public final String a() {
            return this.panelHeightType;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$d;", "", "", "es6", "Z", "getEs6", "()Z", "minified", "getMinified", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        /* JADX INFO: renamed from: es6, reason: collision with root package name */
        @SerializedName("es6")
        private final boolean f60145es6;

        @SerializedName("minified")
        private final boolean minified;

        public d() {
            this.f60145es6 = true;
            this.minified = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/lynx/a$e;", "", "", PickerReporterConstants.KEY.TARGET, "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTarget", "(Ljava/lang/String;)V", "type", "getType", "setType", "alias", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setAlias", "entry", "b", "setEntry", "<init>", "()V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("alias")
        private String alias;

        @SerializedName("entry")
        private String entry;

        @SerializedName(PickerReporterConstants.KEY.TARGET)
        private String target;

        @SerializedName("type")
        private String type;

        public e() {
            this.target = "";
            this.type = "";
            this.alias = "";
            this.entry = "";
        }

        public final String a() {
            return this.alias;
        }

        public final String b() {
            return this.entry;
        }

        public final String c() {
            return this.target;
        }

        public final String getType() {
            return this.type;
        }
    }

    static {
    }

    public a() {
        this.appId = "";
        this.projectName = "";
        this.views = CollectionsKt.emptyList();
        this.appType = "";
        this.targetSdkVersion = "";
    }

    public final c a() {
        return this.globalConfig;
    }

    public final List<e> b() {
        return this.views;
    }
}
