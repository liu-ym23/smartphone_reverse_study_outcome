package com.bytedance.ai.resource.core;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.utils.g;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AIPackageDeployment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AIPackageDeploymentItem> f37309a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<a, FutureTask<AIPackageDeploymentItem>> f37310b = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0007\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u0012\u0010*\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b*\u0010 R\u0012\u0010+\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b+\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageDeployment$AIPackageDeploymentItem;", "Lcom/bytedance/ai/resource/AIPackageManager$AIPackageItem;", "appId", "", "packageName", RuleConditionBean.VERSION_CODE_KEY, "", "resourceUrl", "digest", "resourceUrls", "", "buildInPackage", "", "verifySignature", "versionTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZLjava/lang/Boolean;Ljava/lang/String;)V", "getVersionCode", "()J", "setVersionCode", "(J)V", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "getDigest", "setDigest", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "getBuildInPackage", "()Z", "setBuildInPackage", "(Z)V", "getVerifySignature", "()Ljava/lang/Boolean;", "setVerifySignature", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getVersionTag", "setVersionTag", "isDefaultVersionCode", "isUninstall", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AIPackageDeploymentItem extends AIPackageManager.a {
        private boolean buildInPackage;
        private String digest;
        private String resourceUrl;
        private List<String> resourceUrls;
        private Boolean verifySignature;
        private long versionCode;
        private String versionTag;

        public final boolean isDefaultVersionCode() {
            if (getVersionCode() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isUninstall() {
            if (getVersionCode() != (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean getBuildInPackage() {
            return this.buildInPackage;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final String getResourceUrl() {
            return this.resourceUrl;
        }

        public final List<String> getResourceUrls() {
            return this.resourceUrls;
        }

        public final Boolean getVerifySignature() {
            return this.verifySignature;
        }

        public final long getVersionCode() {
            return this.versionCode;
        }

        public final String getVersionTag() {
            return this.versionTag;
        }

        public final void setBuildInPackage(boolean r100) {
            this.buildInPackage = r100;
        }

        public final void setDigest(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.digest = r100;
        }

        public final void setResourceUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.resourceUrl = r100;
        }

        public final void setResourceUrls(List<String> r100) {
            this.resourceUrls = r100;
        }

        public final void setVerifySignature(Boolean r100) {
            this.verifySignature = r100;
        }

        public final void setVersionCode(long r100) {
            this.versionCode = r100;
        }

        public final void setVersionTag(String r100) {
            this.versionTag = r100;
        }

        public AIPackageDeploymentItem(String r100, String r101, long r102, String r103, String r104, List<String> r105, boolean r106, Boolean r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, "packageName");
            Intrinsics.checkNotNullParameter(r103, "resourceUrl");
            Intrinsics.checkNotNullParameter(r104, "digest");
            super(r100, r101);
            this.versionCode = r102;
            this.resourceUrl = r103;
            this.digest = r104;
            this.resourceUrls = r105;
            this.buildInPackage = r106;
            this.verifySignature = r110;
            this.versionTag = r111;
        }

        public /* synthetic */ AIPackageDeploymentItem(String r110, String r111, long r112, String r113, String r210, List r211, boolean r212, Boolean r213, String r214, int r215, DefaultConstructorMarker r216) {
            if ((r215 & 4) == 0) goto L5;
            long r100 = 0;
        L7:
            if ((r215 & 8) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r215 & 16) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r215 & 32) == 0) goto L17;
            List r114 = null;
        L19:
            if ((r215 & 64) == 0) goto L21;
            boolean r115 = false;
        L23:
            if ((r215 & 128) == 0) goto L25;
            Boolean r116 = Boolean.FALSE;
        L27:
            if ((r215 & 256) == 0) goto L29;
            String r117 = null;
        L30:
            this(r110, r111, r100, r101, r102, r114, r115, r116, r117);
            return;
        L29:
            r117 = r214;
            goto L30
        L25:
            r116 = r213;
            goto L27
        L21:
            r115 = r212;
            goto L23
        L17:
            r114 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f37311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f37312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f37313c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f37311a, r101.f37311a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f37312b, r101.f37312b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f37313c, r101.f37313c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f37311a.hashCode() * 31) + this.f37312b.hashCode()) * 31) + this.f37313c.hashCode();
        }

        public final String toString() {
            return "DeploymentInfoTaskKey(appId=" + this.f37311a + ", packageName=" + this.f37312b + ", versionCode=" + this.f37313c + ')';
        }

        public a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, "packageName");
            Intrinsics.checkNotNullParameter(r102, RuleConditionBean.VERSION_CODE_KEY);
            this.f37311a = r100;
            this.f37312b = r101;
            this.f37313c = r102;
        }
    }

    static {
        f37309a = new ConcurrentHashMap();
        f37310b = new ConcurrentHashMap();
    }

    public static AIPackageDeploymentItem b(AIPackageDeploymentItem r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (r100.getBuildInPackage() == false) goto L5;
        return r100;
    L5:
        List<String> r101 = r100.getResourceUrls();
        boolean r102 = false;
        if (r101 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r100;
    L13:
        if (r100.getResourceUrl().length() <= 0) goto L15;
        r102 = true;
    L15:
        if (r102 == false) goto L18;
        return r100;
    L18:
        if (r100.getVersionCode() > 0) goto L26;
        ConcurrentHashMap<String, AIPackageDeploymentItem> r104 = f37309a;
        String r105 = r100.getAppId();
        String r106 = r100.getPackageName();
        int r107 = AIPackage.f36893J;
        AIPackageDeploymentItem r108 = r104.get(AIPackage.a.a(r106, r105));
        if (r108 == null) goto L24;
        return r108;
    L24:
        return a(r100.getAppId(), r100.getPackageName(), "");
    L26:
        return a(r100.getAppId(), r100.getPackageName(), String.valueOf(r100.getVersionCode()));
    L8:
        if ((!r101.isEmpty()) != true) goto L10;
        r103 = true;
        goto L11
    }

    public static AIPackageDeploymentItem c(AIPackageResponseItem r110) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        return new AIPackageDeploymentItem(r110.getAppId(), r110.getPackageName(), CastLongProtector.parseLong(r110.getVersionCode()), r110.getResourceUrl(), r110.getDigest(), r110.getResourceUrls(), false, r110.getVerifySignature(), null, 320, null);
    L5:
        e = move-exception;
        g.f37637a.e("AIPackageManager", "packageName: " + r110.getPackageName() + ", appId: " + r110.getAppId() + " ===> responseItemBeanToDeploymentItem failed : " + ExceptionsKt.stackTraceToString(e));
        return null;
    }

    public static AIPackageDeploymentItem a(final String r110, final String r111, final String r112) {
        a r100 = new a(r110, r111, r112);
        FutureTask<AIPackageDeploymentItem> r101 = new FutureTask(new b(r111, r110, r112));
        ConcurrentHashMap<a, FutureTask<AIPackageDeploymentItem>> r102 = f37310b;
        FutureTask<AIPackageDeploymentItem> r103 = r102.putIfAbsent(r100, r101);
        if (r103 != null) goto L5;
        r101.run();
    L7:
        if (r103 == null) goto L27;
        g.f37637a.i("AIPackageManager", "packageName: " + r111 + ", appId: " + r110 + ", versionCode: " + r112 + " ===> reuse in-flight deployment information request");
    L27:
        AIPackageDeploymentItem r104 = r101.get();     // Catch: Throwable -> L12 ExecutionException -> L14 InterruptedException -> L18
        if (r103 != null) goto L29;
        r102.remove(r100, r101);
        return r104;
    L29:
        return r104;
    L12:
        th = move-exception;
        if (r103 != null) goto L26;
        f37310b.remove(r100, r101);
    L26:
        throw th;
    L18:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L12
        g.f37637a.e("AIPackageManager", "packageName: " + r111 + ", appId: " + r110 + ", versionCode: " + r112 + " ===> wait deployment information request interrupted: " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L12
        if (r103 != null) goto L22;
    L21:
        f37310b.remove(r100, r101);
    L22:
        return null;
    L14:
        e = move-exception;
        g.f37637a.e("AIPackageManager", "packageName: " + r111 + ", appId: " + r110 + ", versionCode: " + r112 + " ===> request deployment information exception: " + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L12
        if (r103 != null) goto L22;
    L5:
        r101 = r103;
        goto L7
    }
}
