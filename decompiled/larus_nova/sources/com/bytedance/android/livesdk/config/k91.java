package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR0\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R0\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/config/k91;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "sceneFlag", "I", "getSceneFlag", "()I", "setSceneFlag", "(I)V", "anchorSceneFlag", "getAnchorSceneFlag", "setAnchorSceneFlag", "", "timeout", "J", "b", "()J", "setTimeout", "(J)V", "isForceRecover", "c", "setForceRecover", "", "", "Lcom/bytedance/android/livesdk/config/k91$a;", FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "Ljava/util/Map;", "getConfigs", "()Ljava/util/Map;", "setConfigs", "(Ljava/util/Map;)V", "anchorConfigs", "getAnchorConfigs", "setAnchorConfigs", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k91 {

    @SerializedName("anchor_config")
    private Map<String, a> anchorConfigs;

    @SerializedName("anchor_scene_flag")
    private int anchorSceneFlag;

    @SerializedName("config")
    private Map<String, a> configs;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE)
    private boolean isForceRecover;

    @SerializedName("scene_flag")
    private int sceneFlag;

    @SerializedName("timeout")
    private long timeout;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/k91$a;", "", "", "", "hybridPage", "Ljava/util/List;", "getHybridPage", "()Ljava/util/List;", "setHybridPage", "(Ljava/util/List;)V", "nativePage", "getNativePage", "setNativePage", "", "hybridEnable", "Z", "getHybridEnable", "()Z", "setHybridEnable", "(Z)V", "nativeEnable", "getNativeEnable", "setNativeEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("hybrid_enable")
        private boolean hybridEnable;

        @SerializedName("hybrids")
        private List<String> hybridPage;

        @SerializedName("native_enable")
        private boolean nativeEnable;

        @SerializedName("natives")
        private List<String> nativePage;

        public final String toString() {
            return "config{hybrid_enable=" + this.hybridEnable + ",native_enable=" + this.nativeEnable + com.alipay.sdk.m.u.i.f25855d;
        }

        public a() {
            this.hybridPage = CollectionsKt.emptyList();
            this.nativePage = CollectionsKt.emptyList();
            this.hybridEnable = true;
            this.nativeEnable = true;
        }

        public final boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "page");
            if (this.hybridEnable == false) goto L19;
            List<String> r101 = this.hybridPage;
            Object r102 = null;
            if (r101 == null) goto L13;
            Iterator<T> r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L12;
            Object r104 = r103.next();
            if (StringsKt.contains$default(r100, (String) r104, false, 2, null) == false) goto L8;
            r102 = r104;
        L12:
            r102 = (String) r102;
        L13:
            if (r102 == null) goto L20;
            return true;
        L20:
            return false;
        L19:
            return false;
        }

        public final boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "page");
            if (this.nativeEnable == false) goto L9;
            List<String> r101 = this.nativePage;
            if (r101 == null) goto L9;
            if (r101.contains(r100) != true) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public final String toString() {
        return "LinkWindowDegradeStrategy{config=" + this.configs + ",enable=" + this.enable + com.alipay.sdk.m.u.i.f25855d;
    }

    public k91() {
        this.sceneFlag = 127;
        this.anchorSceneFlag = 127;
        this.timeout = 100;
        this.isForceRecover = true;
        this.configs = MapsKt.emptyMap();
        this.anchorConfigs = MapsKt.emptyMap();
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.timeout;
    }

    public final boolean c() {
        return this.isForceRecover;
    }

    public final boolean f(int r100, boolean r101) {
        if (this.enable == false) goto L12;
        if (r101 == false) goto L6;
        Map<String, a> r102 = this.anchorConfigs;
    L7:
        if (r102 == null) goto L9;
        a r103 = r102.get(String.valueOf(r100));
    L10:
        if (r103 == null) goto L12;
        return true;
    L9:
        r103 = null;
        goto L10
    L6:
        r102 = this.configs;
    L12:
        return false;
    }

    public final boolean g(int r100, boolean r101) {
        if (this.enable == true) goto L5;
        return false;
    L5:
        if (r101 == false) goto L10;
        if ((this.anchorSceneFlag & r100) == r100) goto L11;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L17;
        return true;
    L17:
        return false;
    L11:
        r102 = true;
        goto L13
    L10:
        if ((this.sceneFlag & r100) != r100) goto L12;
        goto L11
    }

    public final boolean d(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "page");
        if (f(r100, r102) == false) goto L13;
        if (r102 == false) goto L6;
        Map<String, a> r103 = this.anchorConfigs;
    L7:
        if (r103 == null) goto L13;
        a r104 = r103.get(String.valueOf(r100));
        if (r104 == null) goto L13;
        if (r104.a(r101) != true) goto L13;
        return true;
    L6:
        r103 = this.configs;
    L13:
        return false;
    }

    public final boolean e(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "page");
        if (f(r100, r102) == false) goto L13;
        if (r102 == false) goto L6;
        Map<String, a> r103 = this.anchorConfigs;
    L7:
        if (r103 == null) goto L13;
        a r104 = r103.get(String.valueOf(r100));
        if (r104 == null) goto L13;
        if (r104.b(r101) != true) goto L13;
        return true;
    L6:
        r103 = this.configs;
    L13:
        return false;
    }
}
