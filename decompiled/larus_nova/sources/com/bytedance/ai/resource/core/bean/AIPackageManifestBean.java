package com.bytedance.ai.resource.core.bean;

import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.model.objects.ChatConfigStringAdapter;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.MainInitData;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PermissionDetail;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.ServiceInfo;
import com.bytedance.ai.utils.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.gson.annotations.JsonAdapter;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 W2\u00020\u0001:\u0005STUVWB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020+\u0018\u00010*j\n\u0012\u0004\u0012\u00020+\u0018\u0001`,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR(\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u000206\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001e\u0010D\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010J\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0010\n\u0002\u0010I\u001a\u0004\bK\u0010F\"\u0004\bL\u0010HR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010R¨\u0006X"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "", "<init>", "()V", "manifestVersion", "", "getManifestVersion", "()Ljava/lang/String;", "setManifestVersion", "(Ljava/lang/String;)V", "packageName", "getPackageName", "setPackageName", RuleConditionBean.VERSION_CODE_KEY, "", "getVersionCode", "()J", "setVersionCode", "(J)V", "versionName", "getVersionName", "setVersionName", "renderType", "getRenderType", "setRenderType", "applet", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "getApplet", "()Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "setApplet", "(Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;)V", "widgets", "", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "getWidgets", "()Ljava/util/List;", "setWidgets", "(Ljava/util/List;)V", "scmVersion", "getScmVersion", "setScmVersion", "pages", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Page;", "Lkotlin/collections/ArrayList;", "getPages", "()Ljava/util/ArrayList;", "setPages", "(Ljava/util/ArrayList;)V", "runtimeVersion", "getRuntimeVersion", "setRuntimeVersion", ComplianceResult.JsonKey.PERMISSIONS, "", "Lcom/bytedance/ai/model/objects/PermissionDetail;", "getPermissions", "()Ljava/util/Map;", "setPermissions", "(Ljava/util/Map;)V", "hasKeyStore", "", "getHasKeyStore", "()I", "setHasKeyStore", "(I)V", "verifySignature", "getVerifySignature", "setVerifySignature", "appType", "getAppType", "()Ljava/lang/Integer;", "setAppType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sourceType", "getSourceType", "setSourceType", "settings", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "getSettings", "()Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "setSettings", "(Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;)V", "SettingsBean", "AppletBean", "AppSettingsBean", "WidgetsBean", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageManifestBean {
    public static final Companion Companion = null;
    private Integer appType;
    private AppletBean applet;
    private int hasKeyStore;
    private String manifestVersion;
    private String packageName;
    private ArrayList<Page> pages;
    private Map<String, PermissionDetail> permissions;
    private String renderType;
    private String runtimeVersion;
    private String scmVersion;
    private SettingsBean settings;
    private Integer sourceType;
    private int verifySignature;
    private long versionCode;
    private String versionName;
    private List<WidgetsBean> widgets;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "", "key", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppSettingsBean {
        private String key;
        private String type;

        /* JADX WARN: Multi-variable type inference failed */
        public AppSettingsBean() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AppSettingsBean copy$default(AppSettingsBean r100, String r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.key;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.type;
        L9:
            return r100.copy(r101, r102);
        }

        public final String component1() {
            return this.key;
        }

        public final String component2() {
            return this.type;
        }

        public final AppSettingsBean copy(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "type");
            return new AppSettingsBean(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AppSettingsBean) == true) goto L8;
            return false;
        L8:
            AppSettingsBean r101 = (AppSettingsBean) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            return "AppSettingsBean(key=" + this.key + ", type=" + this.type + ')';
        }

        public final String getKey() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }

        public final void setKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.key = r100;
        }

        public final void setType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.type = r100;
        }

        public AppSettingsBean(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.key = r100;
            this.type = r101;
        }

        public /* synthetic */ AppSettingsBean(String r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bT\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B«\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b!\u0010\"J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\u0011\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0011\u0010a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u001d\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003J\u001d\u0010c\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u001d\u0010j\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010TJ\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J²\u0002\u0010o\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020\u001f2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020tHÖ\u0001J\t\u0010u\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010$\"\u0004\b,\u0010&R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010:\"\u0004\b>\u0010<R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010$\"\u0004\bF\u0010&R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010$\"\u0004\bH\u0010&R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR.\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010:\"\u0004\bN\u0010<R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010$\"\u0004\bP\u0010&R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010$\"\u0004\bR\u0010&R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010$\"\u0004\bY\u0010&¨\u0006v"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "", IFlowAppIntentIDL.PARAM_APPLET_ID, "", "botId", "name", "description", "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", ComplianceResult.JsonKey.PERMISSIONS, n.KEY_PLUGINS, "Ljava/util/ArrayList;", "Lcom/bytedance/ai/model/objects/Plugin;", "Lkotlin/collections/ArrayList;", "pages", "Lcom/bytedance/ai/model/objects/Page;", "prop", "recommend", "appGroup", "botDevMode", "appletEntry", "mainInit", "Lcom/bytedance/ai/model/objects/MainInitData;", PromotionProductPrivilegesStruct.SERVICES, "Lcom/bytedance/ai/model/objects/ServiceInfo;", "appRuntimeEntry", "toolRuntimeEntry", "darkMode", "", "chat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/MainInitData;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getBotId", "setBotId", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getPlugins", "()Ljava/util/ArrayList;", "setPlugins", "(Ljava/util/ArrayList;)V", "getPages", "setPages", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getBotDevMode", "setBotDevMode", "getAppletEntry", "setAppletEntry", "getMainInit", "()Lcom/bytedance/ai/model/objects/MainInitData;", "setMainInit", "(Lcom/bytedance/ai/model/objects/MainInitData;)V", "getServices", "setServices", "getAppRuntimeEntry", "setAppRuntimeEntry", "getToolRuntimeEntry", "setToolRuntimeEntry", "getDarkMode", "()Ljava/lang/Boolean;", "setDarkMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getChat", "setChat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/MainInitData;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppletBean;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppletBean {
        private String appGroup;
        private String appRuntimeEntry;
        private String appletEntry;
        private String appletId;
        private String botDevMode;
        private String botId;

        @JsonAdapter(ChatConfigStringAdapter.class)
        private String chat;
        private Boolean darkMode;
        private String description;
        private String digest;
        private Icons icons;
        private List<String> keywords;
        private MainInitData mainInit;
        private String name;
        private ArrayList<Page> pages;
        private List<String> permissions;
        private ArrayList<Plugin> plugins;
        private String prop;
        private String recommend;
        private ArrayList<ServiceInfo> services;
        private String toolRuntimeEntry;

        public AppletBean() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AppletBean copy$default(AppletBean r110, String r111, String r112, String r210, String r211, String r212, Icons r213, List r214, List r215, ArrayList r216, ArrayList r217, String r218, String r219, String r310, String r311, String r312, MainInitData r313, ArrayList r314, String r315, String r316, Boolean r317, String r318, int r319, Object r410) {
            if ((r319 & 1) == 0) goto L5;
            String r100 = r110.appletId;
        L7:
            if ((r319 & 2) == 0) goto L9;
            String r101 = r110.botId;
        L11:
            if ((r319 & 4) == 0) goto L13;
            String r102 = r110.name;
        L15:
            if ((r319 & 8) == 0) goto L17;
            String r103 = r110.description;
        L19:
            if ((r319 & 16) == 0) goto L21;
            String r104 = r110.digest;
        L23:
            if ((r319 & 32) == 0) goto L25;
            Icons r105 = r110.icons;
        L27:
            if ((r319 & 64) == 0) goto L29;
            List r106 = r110.keywords;
        L31:
            if ((r319 & 128) == 0) goto L33;
            List r107 = r110.permissions;
        L35:
            if ((r319 & 256) == 0) goto L37;
            ArrayList r113 = r110.plugins;
        L39:
            if ((r319 & 512) == 0) goto L41;
            ArrayList r114 = r110.pages;
        L43:
            if ((r319 & 1024) == 0) goto L45;
            String r115 = r110.prop;
        L47:
            if ((r319 & 2048) == 0) goto L49;
            String r116 = r110.recommend;
        L51:
            if ((r319 & 4096) == 0) goto L53;
            String r117 = r110.appGroup;
        L55:
            if ((r319 & 8192) == 0) goto L57;
            String r118 = r110.botDevMode;
        L58:
            String r320 = r118;
            if ((r319 & 16384) == 0) goto L61;
            String r119 = r110.appletEntry;
        L62:
            String r321 = r119;
            if ((r319 & 32768) == 0) goto L65;
            MainInitData r120 = r110.mainInit;
        L66:
            MainInitData r322 = r120;
            if ((r319 & 65536) == 0) goto L69;
            ArrayList r121 = r110.services;
        L70:
            ArrayList r323 = r121;
            if ((r319 & 131072) == 0) goto L73;
            String r122 = r110.appRuntimeEntry;
        L74:
            String r324 = r122;
            if ((r319 & 262144) == 0) goto L77;
            String r123 = r110.toolRuntimeEntry;
        L78:
            String r325 = r123;
            if ((r319 & 524288) == 0) goto L81;
            Boolean r124 = r110.darkMode;
        L83:
            if ((r319 & 1048576) == 0) goto L85;
            String r108 = r110.chat;
        L87:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r124, r108);
        L85:
            r108 = r318;
            goto L87
        L81:
            r124 = r317;
            goto L83
        L77:
            r123 = r316;
            goto L78
        L73:
            r122 = r315;
            goto L74
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.appletId;
        }

        public final ArrayList<Page> component10() {
            return this.pages;
        }

        public final String component11() {
            return this.prop;
        }

        public final String component12() {
            return this.recommend;
        }

        public final String component13() {
            return this.appGroup;
        }

        public final String component14() {
            return this.botDevMode;
        }

        public final String component15() {
            return this.appletEntry;
        }

        public final MainInitData component16() {
            return this.mainInit;
        }

        public final ArrayList<ServiceInfo> component17() {
            return this.services;
        }

        public final String component18() {
            return this.appRuntimeEntry;
        }

        public final String component19() {
            return this.toolRuntimeEntry;
        }

        public final String component2() {
            return this.botId;
        }

        public final Boolean component20() {
            return this.darkMode;
        }

        public final String component21() {
            return this.chat;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.description;
        }

        public final String component5() {
            return this.digest;
        }

        public final Icons component6() {
            return this.icons;
        }

        public final List<String> component7() {
            return this.keywords;
        }

        public final List<String> component8() {
            return this.permissions;
        }

        public final ArrayList<Plugin> component9() {
            return this.plugins;
        }

        public final AppletBean copy(String r210, String r211, String r212, String r213, String r214, Icons r310, List<String> r311, List<String> r312, ArrayList<Plugin> r313, ArrayList<Page> r314, String r315, String r316, String r317, String r318, String r319, MainInitData r410, ArrayList<ServiceInfo> r411, String r412, String r413, Boolean r414, String r415) {
            Intrinsics.checkNotNullParameter(r210, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r211, "botId");
            Intrinsics.checkNotNullParameter(r212, "name");
            Intrinsics.checkNotNullParameter(r213, "description");
            Intrinsics.checkNotNullParameter(r214, "digest");
            Intrinsics.checkNotNullParameter(r310, "icons");
            Intrinsics.checkNotNullParameter(r315, "prop");
            Intrinsics.checkNotNullParameter(r316, "recommend");
            Intrinsics.checkNotNullParameter(r317, "appGroup");
            Intrinsics.checkNotNullParameter(r318, "botDevMode");
            Intrinsics.checkNotNullParameter(r319, "appletEntry");
            Intrinsics.checkNotNullParameter(r412, "appRuntimeEntry");
            Intrinsics.checkNotNullParameter(r413, "toolRuntimeEntry");
            return new AppletBean(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AppletBean) == true) goto L8;
            return false;
        L8:
            AppletBean r101 = (AppletBean) r100;
            if (Intrinsics.areEqual(this.appletId, r101.appletId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.description, r101.description) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.digest, r101.digest) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.icons, r101.icons) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.keywords, r101.keywords) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.permissions, r101.permissions) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.plugins, r101.plugins) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.pages, r101.pages) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.prop, r101.prop) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.recommend, r101.recommend) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.appGroup, r101.appGroup) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.botDevMode, r101.botDevMode) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.appletEntry, r101.appletEntry) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.mainInit, r101.mainInit) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.services, r101.services) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appRuntimeEntry, r101.appRuntimeEntry) == true) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.toolRuntimeEntry, r101.toolRuntimeEntry) == true) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.darkMode, r101.darkMode) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.chat, r101.chat) == true) goto L71;
            return false;
        L71:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((((((this.appletId.hashCode() * 31) + this.botId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.digest.hashCode()) * 31) + this.icons.hashCode()) * 31;
            List<String> r101 = this.keywords;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.permissions;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            ArrayList<Plugin> r108 = this.plugins;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            ArrayList<Page> r111 = this.pages;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (((((((((((r110 + r112) * 31) + this.prop.hashCode()) * 31) + this.recommend.hashCode()) * 31) + this.appGroup.hashCode()) * 31) + this.botDevMode.hashCode()) * 31) + this.appletEntry.hashCode()) * 31;
            MainInitData r114 = this.mainInit;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            ArrayList<ServiceInfo> r117 = this.services;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (((((r116 + r118) * 31) + this.appRuntimeEntry.hashCode()) * 31) + this.toolRuntimeEntry.hashCode()) * 31;
            Boolean r120 = this.darkMode;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            String r123 = this.chat;
            if (r123 == null) goto L35;
            r102 = r123.hashCode();
        L35:
            return r122 + r102;
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "AppletBean(appletId=" + this.appletId + ", botId=" + this.botId + ", name=" + this.name + ", description=" + this.description + ", digest=" + this.digest + ", icons=" + this.icons + ", keywords=" + this.keywords + ", permissions=" + this.permissions + ", plugins=" + this.plugins + ", pages=" + this.pages + ", prop=" + this.prop + ", recommend=" + this.recommend + ", appGroup=" + this.appGroup + ", botDevMode=" + this.botDevMode + ", appletEntry=" + this.appletEntry + ", mainInit=" + this.mainInit + ", services=" + this.services + ", appRuntimeEntry=" + this.appRuntimeEntry + ", toolRuntimeEntry=" + this.toolRuntimeEntry + ", darkMode=" + this.darkMode + ", chat=" + this.chat + ')';
        }

        public final String getAppGroup() {
            return this.appGroup;
        }

        public final String getAppRuntimeEntry() {
            return this.appRuntimeEntry;
        }

        public final String getAppletEntry() {
            return this.appletEntry;
        }

        public final String getAppletId() {
            return this.appletId;
        }

        public final String getBotDevMode() {
            return this.botDevMode;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getChat() {
            return this.chat;
        }

        public final Boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final Icons getIcons() {
            return this.icons;
        }

        public final List<String> getKeywords() {
            return this.keywords;
        }

        public final MainInitData getMainInit() {
            return this.mainInit;
        }

        public final String getName() {
            return this.name;
        }

        public final ArrayList<Page> getPages() {
            return this.pages;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final ArrayList<Plugin> getPlugins() {
            return this.plugins;
        }

        public final String getProp() {
            return this.prop;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final ArrayList<ServiceInfo> getServices() {
            return this.services;
        }

        public final String getToolRuntimeEntry() {
            return this.toolRuntimeEntry;
        }

        public final void setAppGroup(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appGroup = r100;
        }

        public final void setAppRuntimeEntry(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appRuntimeEntry = r100;
        }

        public final void setAppletEntry(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appletEntry = r100;
        }

        public final void setAppletId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appletId = r100;
        }

        public final void setBotDevMode(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.botDevMode = r100;
        }

        public final void setBotId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.botId = r100;
        }

        public final void setChat(String r100) {
            this.chat = r100;
        }

        public final void setDarkMode(Boolean r100) {
            this.darkMode = r100;
        }

        public final void setDescription(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.description = r100;
        }

        public final void setDigest(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.digest = r100;
        }

        public final void setIcons(Icons r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.icons = r100;
        }

        public final void setKeywords(List<String> r100) {
            this.keywords = r100;
        }

        public final void setMainInit(MainInitData r100) {
            this.mainInit = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setPages(ArrayList<Page> r100) {
            this.pages = r100;
        }

        public final void setPermissions(List<String> r100) {
            this.permissions = r100;
        }

        public final void setPlugins(ArrayList<Plugin> r100) {
            this.plugins = r100;
        }

        public final void setProp(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.prop = r100;
        }

        public final void setRecommend(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.recommend = r100;
        }

        public final void setServices(ArrayList<ServiceInfo> r100) {
            this.services = r100;
        }

        public final void setToolRuntimeEntry(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.toolRuntimeEntry = r100;
        }

        public AppletBean(String r110, String r111, String r112, String r113, String r210, Icons r211, List<String> r212, List<String> r213, ArrayList<Plugin> r214, ArrayList<Page> r215, String r216, String r217, String r218, String r219, String r310, MainInitData r311, ArrayList<ServiceInfo> r312, String r313, String r314, Boolean r315, String r316) {
            Intrinsics.checkNotNullParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);
            Intrinsics.checkNotNullParameter(r111, "botId");
            Intrinsics.checkNotNullParameter(r112, "name");
            Intrinsics.checkNotNullParameter(r113, "description");
            Intrinsics.checkNotNullParameter(r210, "digest");
            Intrinsics.checkNotNullParameter(r211, "icons");
            Intrinsics.checkNotNullParameter(r216, "prop");
            Intrinsics.checkNotNullParameter(r217, "recommend");
            Intrinsics.checkNotNullParameter(r218, "appGroup");
            Intrinsics.checkNotNullParameter(r219, "botDevMode");
            Intrinsics.checkNotNullParameter(r310, "appletEntry");
            Intrinsics.checkNotNullParameter(r313, "appRuntimeEntry");
            Intrinsics.checkNotNullParameter(r314, "toolRuntimeEntry");
            this.appletId = r110;
            this.botId = r111;
            this.name = r112;
            this.description = r113;
            this.digest = r210;
            this.icons = r211;
            this.keywords = r212;
            this.permissions = r213;
            this.plugins = r214;
            this.pages = r215;
            this.prop = r216;
            this.recommend = r217;
            this.appGroup = r218;
            this.botDevMode = r219;
            this.appletEntry = r310;
            this.mainInit = r311;
            this.services = r312;
            this.appRuntimeEntry = r313;
            this.toolRuntimeEntry = r314;
            this.darkMode = r315;
            this.chat = r316;
        }

        public /* synthetic */ AppletBean(String r210, String r211, String r212, String r213, String r214, Icons r215, List r310, List r311, ArrayList r312, ArrayList r313, String r314, String r315, String r316, String r317, String r318, MainInitData r319, ArrayList r410, String r411, String r412, Boolean r413, String r414, int r415, DefaultConstructorMarker r416) {
            if ((r415 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r415 & 2) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r415 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r415 & 8) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r415 & 16) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r415 & 32) == 0) goto L25;
            Icons r105 = new Icons();
        L27:
            if ((r415 & 64) == 0) goto L29;
            List r106 = new ArrayList();
        L31:
            if ((r415 & 128) == 0) goto L33;
            List r107 = new ArrayList();
        L35:
            if ((r415 & 256) == 0) goto L37;
            ArrayList r110 = new ArrayList();
        L39:
            if ((r415 & 512) == 0) goto L41;
            ArrayList r111 = new ArrayList();
        L43:
            if ((r415 & 1024) == 0) goto L45;
            String r112 = "";
        L47:
            if ((r415 & 2048) == 0) goto L49;
            String r113 = "";
        L51:
            if ((r415 & 4096) == 0) goto L53;
            String r114 = "";
        L55:
            if ((r415 & 8192) == 0) goto L57;
            String r115 = "";
        L59:
            if ((r415 & 16384) == 0) goto L61;
            String r108 = "";
        L62:
            String r116 = null;
            if ((r415 & 32768) == 0) goto L65;
            MainInitData r117 = null;
        L67:
            if ((r415 & 65536) == 0) goto L69;
            ArrayList r118 = new ArrayList();
        L71:
            if ((r415 & 131072) == 0) goto L73;
            String r119 = "";
        L75:
            if ((r415 & 262144) == 0) goto L77;
            String r216 = "";
        L79:
            if ((r415 & 524288) == 0) goto L81;
            Boolean r217 = Boolean.TRUE;
        L83:
            if ((r415 & 1048576) != 0) goto L86;
            r116 = r414;
        L86:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r117, r118, r119, r216, r217, r116);
            return;
        L81:
            r217 = r413;
            goto L83
        L77:
            r216 = r412;
            goto L79
        L73:
            r119 = r411;
            goto L75
        L69:
            r118 = r410;
            goto L71
        L65:
            r117 = r319;
            goto L67
        L61:
            r108 = r318;
            goto L62
        L57:
            r115 = r317;
            goto L59
        L53:
            r114 = r316;
            goto L55
        L49:
            r113 = r315;
            goto L51
        L45:
            r112 = r314;
            goto L47
        L41:
            r111 = r313;
            goto L43
        L37:
            r110 = r312;
            goto L39
        L33:
            r107 = r311;
            goto L35
        L29:
            r106 = r310;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = r214;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$Companion;", "", "<init>", "()V", "parseManifestJson", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean;", "json", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public final AIPackageManifestBean parseManifestJson(String r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
        L11:
            e = move-exception;
            g r101 = g.f37637a;
            r101.e("AIPackageManager", "Failed to parse Manifest: " + ExceptionsKt.stackTraceToString(e));
            r101.e("AIPackageManager", "Failed to parse Manifest. content: " + r100);
        L13:
            return null;
        L4:
            if (r100.length() <= 0) goto L6;
            boolean r102 = true;
        L7:
            if (r102 == false) goto L9;
            Lazy r103 = e.f34515a;     // Catch: Exception -> L11
            return (AIPackageManifestBean) e.a(r100, AIPackageManifestBean.class);
        L9:
            g.f37637a.e("AIPackageManager", "Failed to parse Manifest: Read the Manifest as empty");     // Catch: Exception -> L11
            goto L13
        L6:
            r102 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "", "urlCheck", "", "<init>", "(Ljava/lang/Boolean;)V", "getUrlCheck", "()Ljava/lang/Boolean;", "setUrlCheck", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$SettingsBean;", "equals", "other", "hashCode", "", "toString", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SettingsBean {
        private Boolean urlCheck;

        /* JADX WARN: Multi-variable type inference failed */
        public SettingsBean() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SettingsBean copy$default(SettingsBean r100, Boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.urlCheck;
        L6:
            return r100.copy(r101);
        }

        public final Boolean component1() {
            return this.urlCheck;
        }

        public final SettingsBean copy(Boolean r100) {
            return new SettingsBean(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SettingsBean) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.urlCheck, ((SettingsBean) r100).urlCheck) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            Boolean r100 = this.urlCheck;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "SettingsBean(urlCheck=" + this.urlCheck + ')';
        }

        public final Boolean getUrlCheck() {
            return this.urlCheck;
        }

        public SettingsBean(Boolean r100) {
            this.urlCheck = r100;
        }

        public final void setUrlCheck(Boolean r100) {
            this.urlCheck = r100;
        }

        public /* synthetic */ SettingsBean(Boolean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bL\b\u0087\b\u0018\u00002\u00020\u0001BÝ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0011HÆ\u0003J\t\u0010Y\u001a\u00020\u0013HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00190\fHÆ\u0003J\t\u0010_\u001a\u00020\u0013HÆ\u0003Jß\u0001\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010\u001a\u001a\u00020\u0013HÆ\u0001J\u0013\u0010a\u001a\u00020\u00112\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u0013HÖ\u0001J\t\u0010d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001e\"\u0004\bB\u0010 R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u00100\"\u0004\bJ\u00102R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@¨\u0006e"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$WidgetsBean;", "", "widgetId", "", "entry", ThumbGlideUrl.SOURCE_TEMPLATE, "name", "description", "digest", "icons", "Lcom/bytedance/ai/model/objects/Icons;", "keywords", "", ComplianceResult.JsonKey.PERMISSIONS, "input", BdpAppEventConstant.PARAMS_OUTPUT, "border", "", "boxType", "", "renderType", "prop", "recommend", "appGroup", "appSettings", "Lcom/bytedance/ai/resource/core/bean/AIPackageManifestBean$AppSettingsBean;", "titleType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/model/objects/Icons;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "getEntry", "setEntry", "getTemplate", "setTemplate", "getName", "setName", "getDescription", "setDescription", "getDigest", "setDigest", "getIcons", "()Lcom/bytedance/ai/model/objects/Icons;", "setIcons", "(Lcom/bytedance/ai/model/objects/Icons;)V", "getKeywords", "()Ljava/util/List;", "setKeywords", "(Ljava/util/List;)V", "getPermissions", "setPermissions", "getInput", "setInput", "getOutput", "setOutput", "getBorder", "()Z", "setBorder", "(Z)V", "getBoxType", "()I", "setBoxType", "(I)V", "getRenderType", "setRenderType", "getProp", "setProp", "getRecommend", "setRecommend", "getAppGroup", "setAppGroup", "getAppSettings", "setAppSettings", "getTitleType", "setTitleType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WidgetsBean {
        private String appGroup;
        private List<AppSettingsBean> appSettings;
        private boolean border;
        private int boxType;
        private String description;
        private String digest;
        private String entry;
        private Icons icons;
        private String input;
        private List<String> keywords;
        private String name;
        private String output;
        private List<String> permissions;
        private String prop;
        private String recommend;
        private String renderType;
        private String template;
        private int titleType;
        private String widgetId;

        public WidgetsBean() {
            this(null, null, null, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, 0, 524287, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetsBean copy$default(WidgetsBean r110, String r111, String r112, String r210, String r211, String r212, String r213, Icons r214, List r215, List r216, String r217, String r218, boolean r219, int r310, String r311, String r312, String r313, String r314, List r315, int r316, int r317, Object r318) {
            if ((r317 & 1) == 0) goto L5;
            String r100 = r110.widgetId;
        L7:
            if ((r317 & 2) == 0) goto L9;
            String r101 = r110.entry;
        L11:
            if ((r317 & 4) == 0) goto L13;
            String r102 = r110.template;
        L15:
            if ((r317 & 8) == 0) goto L17;
            String r103 = r110.name;
        L19:
            if ((r317 & 16) == 0) goto L21;
            String r104 = r110.description;
        L23:
            if ((r317 & 32) == 0) goto L25;
            String r105 = r110.digest;
        L27:
            if ((r317 & 64) == 0) goto L29;
            Icons r106 = r110.icons;
        L31:
            if ((r317 & 128) == 0) goto L33;
            List r107 = r110.keywords;
        L35:
            if ((r317 & 256) == 0) goto L37;
            List r113 = r110.permissions;
        L39:
            if ((r317 & 512) == 0) goto L41;
            String r114 = r110.input;
        L43:
            if ((r317 & 1024) == 0) goto L45;
            String r115 = r110.output;
        L47:
            if ((r317 & 2048) == 0) goto L49;
            boolean r116 = r110.border;
        L51:
            if ((r317 & 4096) == 0) goto L53;
            int r117 = r110.boxType;
        L55:
            if ((r317 & 8192) == 0) goto L57;
            String r118 = r110.renderType;
        L58:
            String r319 = r118;
            if ((r317 & 16384) == 0) goto L61;
            String r119 = r110.prop;
        L62:
            String r320 = r119;
            if ((r317 & 32768) == 0) goto L65;
            String r120 = r110.recommend;
        L66:
            String r321 = r120;
            if ((r317 & 65536) == 0) goto L69;
            String r121 = r110.appGroup;
        L70:
            String r322 = r121;
            if ((r317 & 131072) == 0) goto L73;
            List r122 = r110.appSettings;
        L75:
            if ((r317 & 262144) == 0) goto L77;
            int r108 = r110.titleType;
        L79:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r319, r320, r321, r322, r122, r108);
        L77:
            r108 = r316;
            goto L79
        L73:
            r122 = r315;
            goto L75
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.widgetId;
        }

        public final String component10() {
            return this.input;
        }

        public final String component11() {
            return this.output;
        }

        public final boolean component12() {
            return this.border;
        }

        public final int component13() {
            return this.boxType;
        }

        public final String component14() {
            return this.renderType;
        }

        public final String component15() {
            return this.prop;
        }

        public final String component16() {
            return this.recommend;
        }

        public final String component17() {
            return this.appGroup;
        }

        public final List<AppSettingsBean> component18() {
            return this.appSettings;
        }

        public final int component19() {
            return this.titleType;
        }

        public final String component2() {
            return this.entry;
        }

        public final String component3() {
            return this.template;
        }

        public final String component4() {
            return this.name;
        }

        public final String component5() {
            return this.description;
        }

        public final String component6() {
            return this.digest;
        }

        public final Icons component7() {
            return this.icons;
        }

        public final List<String> component8() {
            return this.keywords;
        }

        public final List<String> component9() {
            return this.permissions;
        }

        public final WidgetsBean copy(String r210, String r211, String r212, String r213, String r214, String r215, Icons r216, List<String> r310, List<String> r311, String r312, String r313, boolean r314, int r315, String r316, String r317, String r318, String r319, List<AppSettingsBean> r410, int r411) {
            Intrinsics.checkNotNullParameter(r210, "widgetId");
            Intrinsics.checkNotNullParameter(r211, "entry");
            Intrinsics.checkNotNullParameter(r212, ThumbGlideUrl.SOURCE_TEMPLATE);
            Intrinsics.checkNotNullParameter(r213, "name");
            Intrinsics.checkNotNullParameter(r214, "description");
            Intrinsics.checkNotNullParameter(r215, "digest");
            Intrinsics.checkNotNullParameter(r312, "input");
            Intrinsics.checkNotNullParameter(r313, BdpAppEventConstant.PARAMS_OUTPUT);
            Intrinsics.checkNotNullParameter(r316, "renderType");
            Intrinsics.checkNotNullParameter(r317, "prop");
            Intrinsics.checkNotNullParameter(r318, "recommend");
            Intrinsics.checkNotNullParameter(r319, "appGroup");
            Intrinsics.checkNotNullParameter(r410, "appSettings");
            return new WidgetsBean(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof WidgetsBean) == true) goto L8;
            return false;
        L8:
            WidgetsBean r101 = (WidgetsBean) r100;
            if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.entry, r101.entry) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.template, r101.template) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.description, r101.description) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.digest, r101.digest) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.icons, r101.icons) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.keywords, r101.keywords) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.permissions, r101.permissions) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.input, r101.input) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.output, r101.output) == true) goto L42;
            return false;
        L42:
            if (this.border == r101.border) goto L45;
            return false;
        L45:
            if (this.boxType == r101.boxType) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.renderType, r101.renderType) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.prop, r101.prop) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.recommend, r101.recommend) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.appGroup, r101.appGroup) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.appSettings, r101.appSettings) == true) goto L63;
            return false;
        L63:
            if (this.titleType == r101.titleType) goto L65;
            return false;
        L65:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((((((this.widgetId.hashCode() * 31) + this.entry.hashCode()) * 31) + this.template.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.digest.hashCode()) * 31;
            Icons r101 = this.icons;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            List<String> r105 = this.keywords;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            List<String> r108 = this.permissions;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            int r109 = (((((r107 + r102) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31;
            if (this.border == false) goto L17;
            int r110 = 1231;
        L19:
            return ((((((((((((((r109 + r110) * 31) + this.boxType) * 31) + this.renderType.hashCode()) * 31) + this.prop.hashCode()) * 31) + this.recommend.hashCode()) * 31) + this.appGroup.hashCode()) * 31) + this.appSettings.hashCode()) * 31) + this.titleType;
        L17:
            r110 = 1237;
            goto L19
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "WidgetsBean(widgetId=" + this.widgetId + ", entry=" + this.entry + ", template=" + this.template + ", name=" + this.name + ", description=" + this.description + ", digest=" + this.digest + ", icons=" + this.icons + ", keywords=" + this.keywords + ", permissions=" + this.permissions + ", input=" + this.input + ", output=" + this.output + ", border=" + this.border + ", boxType=" + this.boxType + ", renderType=" + this.renderType + ", prop=" + this.prop + ", recommend=" + this.recommend + ", appGroup=" + this.appGroup + ", appSettings=" + this.appSettings + ", titleType=" + this.titleType + ')';
        }

        public final String getAppGroup() {
            return this.appGroup;
        }

        public final List<AppSettingsBean> getAppSettings() {
            return this.appSettings;
        }

        public final boolean getBorder() {
            return this.border;
        }

        public final int getBoxType() {
            return this.boxType;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getDigest() {
            return this.digest;
        }

        public final String getEntry() {
            return this.entry;
        }

        public final Icons getIcons() {
            return this.icons;
        }

        public final String getInput() {
            return this.input;
        }

        public final List<String> getKeywords() {
            return this.keywords;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOutput() {
            return this.output;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public final String getProp() {
            return this.prop;
        }

        public final String getRecommend() {
            return this.recommend;
        }

        public final String getRenderType() {
            return this.renderType;
        }

        public final String getTemplate() {
            return this.template;
        }

        public final int getTitleType() {
            return this.titleType;
        }

        public final String getWidgetId() {
            return this.widgetId;
        }

        public final void setAppGroup(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appGroup = r100;
        }

        public final void setAppSettings(List<AppSettingsBean> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.appSettings = r100;
        }

        public final void setBorder(boolean r100) {
            this.border = r100;
        }

        public final void setBoxType(int r100) {
            this.boxType = r100;
        }

        public final void setDescription(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.description = r100;
        }

        public final void setDigest(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.digest = r100;
        }

        public final void setEntry(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.entry = r100;
        }

        public final void setIcons(Icons r100) {
            this.icons = r100;
        }

        public final void setInput(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.input = r100;
        }

        public final void setKeywords(List<String> r100) {
            this.keywords = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setOutput(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.output = r100;
        }

        public final void setPermissions(List<String> r100) {
            this.permissions = r100;
        }

        public final void setProp(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.prop = r100;
        }

        public final void setRecommend(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.recommend = r100;
        }

        public final void setRenderType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.renderType = r100;
        }

        public final void setTemplate(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.template = r100;
        }

        public final void setTitleType(int r100) {
            this.titleType = r100;
        }

        public final void setWidgetId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.widgetId = r100;
        }

        public WidgetsBean(String r110, String r111, String r112, String r113, String r210, String r211, Icons r212, List<String> r213, List<String> r214, String r215, String r216, boolean r217, int r218, String r219, String r310, String r311, String r312, List<AppSettingsBean> r313, int r314) {
            Intrinsics.checkNotNullParameter(r110, "widgetId");
            Intrinsics.checkNotNullParameter(r111, "entry");
            Intrinsics.checkNotNullParameter(r112, ThumbGlideUrl.SOURCE_TEMPLATE);
            Intrinsics.checkNotNullParameter(r113, "name");
            Intrinsics.checkNotNullParameter(r210, "description");
            Intrinsics.checkNotNullParameter(r211, "digest");
            Intrinsics.checkNotNullParameter(r215, "input");
            Intrinsics.checkNotNullParameter(r216, BdpAppEventConstant.PARAMS_OUTPUT);
            Intrinsics.checkNotNullParameter(r219, "renderType");
            Intrinsics.checkNotNullParameter(r310, "prop");
            Intrinsics.checkNotNullParameter(r311, "recommend");
            Intrinsics.checkNotNullParameter(r312, "appGroup");
            Intrinsics.checkNotNullParameter(r313, "appSettings");
            this.widgetId = r110;
            this.entry = r111;
            this.template = r112;
            this.name = r113;
            this.description = r210;
            this.digest = r211;
            this.icons = r212;
            this.keywords = r213;
            this.permissions = r214;
            this.input = r215;
            this.output = r216;
            this.border = r217;
            this.boxType = r218;
            this.renderType = r219;
            this.prop = r310;
            this.recommend = r311;
            this.appGroup = r312;
            this.appSettings = r313;
            this.titleType = r314;
        }

        public /* synthetic */ WidgetsBean(String r210, String r211, String r212, String r213, String r214, String r215, Icons r216, List r217, List r218, String r310, String r311, boolean r312, int r313, String r314, String r315, String r316, String r317, List r318, int r319, int r410, DefaultConstructorMarker r411) {
            if ((r410 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r410 & 2) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r410 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r410 & 8) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r410 & 16) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r410 & 32) == 0) goto L25;
            String r105 = "";
        L27:
            if ((r410 & 64) == 0) goto L29;
            Icons r106 = new Icons();
        L31:
            if ((r410 & 128) == 0) goto L33;
            List r107 = new ArrayList();
        L35:
            if ((r410 & 256) == 0) goto L37;
            List r110 = new ArrayList();
        L39:
            if ((r410 & 512) == 0) goto L41;
            String r111 = "";
        L43:
            if ((r410 & 1024) == 0) goto L45;
            String r112 = "";
        L46:
            int r113 = 0;
            if ((r410 & 2048) == 0) goto L49;
            boolean r114 = false;
        L51:
            if ((r410 & 4096) != 0) goto L55;
            r113 = r313;
        L55:
            if ((r410 & 8192) == 0) goto L57;
            String r115 = "";
        L59:
            if ((r410 & 16384) == 0) goto L61;
            String r108 = "";
        L63:
            if ((r410 & 32768) == 0) goto L65;
            String r116 = "";
        L67:
            if ((r410 & 65536) == 0) goto L69;
            String r117 = "";
        L71:
            if ((r410 & 131072) == 0) goto L73;
            List r118 = new ArrayList();
        L75:
            if ((r410 & 262144) == 0) goto L77;
            int r109 = -1;
        L78:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r114, r113, r115, r108, r116, r117, r118, r109);
            return;
        L77:
            r109 = r319;
            goto L78
        L73:
            r118 = r318;
            goto L75
        L69:
            r117 = r317;
            goto L71
        L65:
            r116 = r316;
            goto L67
        L61:
            r108 = r315;
            goto L63
        L57:
            r115 = r314;
            goto L59
        L49:
            r114 = r312;
            goto L51
        L45:
            r112 = r311;
            goto L46
        L41:
            r111 = r310;
            goto L43
        L37:
            r110 = r218;
            goto L39
        L33:
            r107 = r217;
            goto L35
        L29:
            r106 = r216;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = r214;
            goto L23
        L17:
            r103 = r213;
            goto L19
        L13:
            r102 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L11
        L5:
            r100 = r210;
            goto L7
        }
    }

    static {
        Companion = new Companion();
    }

    public AIPackageManifestBean() {
        this.manifestVersion = "";
        this.packageName = "";
        this.versionName = "";
        this.renderType = "";
        String r110 = null;
        this.applet = new AppletBean(null, null, null, null, null, null, null, null, null, null, null, null, r110, r110, null, null, null, null, null, null, null, 2097151, null);
        this.widgets = new ArrayList();
        this.scmVersion = "";
        this.pages = new ArrayList();
        this.runtimeVersion = "";
        this.permissions = new LinkedHashMap();
    }

    public final Integer getAppType() {
        return this.appType;
    }

    public final AppletBean getApplet() {
        return this.applet;
    }

    public final int getHasKeyStore() {
        return this.hasKeyStore;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ArrayList<Page> getPages() {
        return this.pages;
    }

    public final Map<String, PermissionDetail> getPermissions() {
        return this.permissions;
    }

    public final String getRenderType() {
        return this.renderType;
    }

    public final String getRuntimeVersion() {
        return this.runtimeVersion;
    }

    public final String getScmVersion() {
        return this.scmVersion;
    }

    public final SettingsBean getSettings() {
        return this.settings;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final int getVerifySignature() {
        return this.verifySignature;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final List<WidgetsBean> getWidgets() {
        return this.widgets;
    }

    public final void setAppType(Integer r100) {
        this.appType = r100;
    }

    public final void setApplet(AppletBean r100) {
        this.applet = r100;
    }

    public final void setHasKeyStore(int r100) {
        this.hasKeyStore = r100;
    }

    public final void setManifestVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.manifestVersion = r100;
    }

    public final void setPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.packageName = r100;
    }

    public final void setPages(ArrayList<Page> r100) {
        this.pages = r100;
    }

    public final void setPermissions(Map<String, PermissionDetail> r100) {
        this.permissions = r100;
    }

    public final void setRenderType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderType = r100;
    }

    public final void setRuntimeVersion(String r100) {
        this.runtimeVersion = r100;
    }

    public final void setScmVersion(String r100) {
        this.scmVersion = r100;
    }

    public final void setSettings(SettingsBean r100) {
        this.settings = r100;
    }

    public final void setSourceType(Integer r100) {
        this.sourceType = r100;
    }

    public final void setVerifySignature(int r100) {
        this.verifySignature = r100;
    }

    public final void setVersionCode(long r100) {
        this.versionCode = r100;
    }

    public final void setVersionName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.versionName = r100;
    }

    public final void setWidgets(List<WidgetsBean> r100) {
        this.widgets = r100;
    }
}
