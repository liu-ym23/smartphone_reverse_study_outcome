package com.android.ttcjpaysdk.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.env.CJEnv;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u0004\u0018\u00010\bJ\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010%J\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'J\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u00100\u001a\u00020\u0012J\u0010\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\bJ\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020,J\u001e\u00106\u001a\u0002022\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010%J\u001e\u00108\u001a\u0002022\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "Ljava/io/Serializable;", "()V", "appId", "", "avatarUrl", "contextRef", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "customUa", "enableBioSource", "extraHeaderMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "fromFastPayType", "", "Ljava/lang/Integer;", "fromImRedPacket", "", "invokeType", "isCaijingSaas", "isContinuePay", "isFromScan", "isGameNewCounterStyle", "isGameNewStyle", "isTransCheckoutCounterActivityWhenLoading", "isUnifyHideLoading", "isUnionPayBindEnable", "()I", "setUnionPayBindEnable", "(I)V", "mScreenOrientationType", "merchantId", "needLoading", "nickName", "papiID", "payRequestParams", "", "riskInfoParams", "", "titleStr", "unifyFromService", "getContext", "getFontScale", "", "getRequestParams", "getRiskInfoParams", "getRiskInfoParamsCache", "isUnionPayEnable", "setContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "setFontScale", "scale", "setRequestParams", "requestParams", "setRiskInfoParams", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayHostInfo implements Serializable {
    public static final Companion Companion = null;
    public static final String FOLLOW_SDK_SAAS_ENV = "-1";
    public static final String HOST_INFO = "hostInfo";
    public static final String NO_SAAS = "0";
    public static final String SAAS = "1";
    public static String aid;
    public static Map<String, Integer> animationResourceMap;
    public static String appUpdateVersion;
    public static Context applicationContext;
    public static boolean backEnableAfterResultBack;
    public static String boeEnv;
    public static String channel;
    public static String did;
    public static String envChannel;
    private static final ConcurrentHashMap<String, Long> fixAssetsMap = null;
    public static float fontScale;
    public static String inheritTheme;
    public static String integratedHostDomain;
    public static boolean isFollowSystemTheme;
    public static boolean isUsingGecko;
    public static boolean isUsingTTNet;
    public static String languageTypeStr;
    private static Map<String, String> loginTokenMap;
    public static boolean needJSBridgeAuth;
    public static Integer screenOrientationType;
    public static int serverType;
    public static Bitmap titleBitmap;
    public static String uid;
    public String appId;
    public String avatarUrl;
    private transient WeakReference<Context> contextRef;
    public String customUa;
    public String enableBioSource;
    public HashMap<String, String> extraHeaderMap;
    public Integer fromFastPayType;
    public boolean fromImRedPacket;
    public String invokeType;
    public String isCaijingSaas;
    public boolean isContinuePay;
    public boolean isFromScan;
    public boolean isGameNewCounterStyle;
    public boolean isGameNewStyle;
    public boolean isTransCheckoutCounterActivityWhenLoading;
    public boolean isUnifyHideLoading;
    private int isUnionPayBindEnable;
    public Integer mScreenOrientationType;
    public String merchantId;
    public boolean needLoading;
    public String nickName;
    public String papiID;
    private Map<String, String> payRequestParams;
    private Map<String, String> riskInfoParams;
    public String titleStr;
    public String unifyFromService;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007J\b\u0010+\u001a\u00020\u0010H\u0007J\b\u0010,\u001a\u00020\u0010H\u0007J\b\u0010-\u001a\u00020\u0010H\u0007J\u0016\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0007J\b\u0010/\u001a\u00020\u0010H\u0007J\b\u00100\u001a\u00020\u0010H\u0007J \u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u000103H\u0002J \u00104\u001a\u0002032\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\nH\u0002J\u0006\u00106\u001a\u000207J\u001e\u00108\u001a\u0002072\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u0007J\u0012\u00109\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u000103H\u0007J.\u0010:\u001a\u0004\u0018\u0001032\b\u0010;\u001a\u0004\u0018\u00010)2\u0018\b\u0002\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010=H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010$\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/android/ttcjpaysdk/base/CJPayHostInfo$Companion;", "", "()V", "FOLLOW_SDK_SAAS_ENV", "", "HOST_INFO", "NO_SAAS", "SAAS", "aid", "animationResourceMap", "", "", "appUpdateVersion", "applicationContext", "Landroid/content/Context;", "backEnableAfterResultBack", "", "boeEnv", "channel", com.bytedance.android.ec.core.event.a.KEY_DID, "envChannel", "fixAssetsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "fontScale", "", "inheritTheme", "integratedHostDomain", "isFollowSystemTheme", "isUsingGecko", "isUsingTTNet", "languageTypeStr", "loginTokenMap", "needJSBridgeAuth", "screenOrientationType", "Ljava/lang/Integer;", "serverType", "titleBitmap", "Landroid/graphics/Bitmap;", "uid", "copy", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "bean", "curAppAsDouMall", "curAppAsDouYin", "curAppAsDouhuo", "getLoginToken", "isBoe", "isPPE", "jsonToMap", "json", "Lorg/json/JSONObject;", "mapToJson", "map", "release", "", "setLoginToken", "toBean", "toJson", "hostInfo", "riskInfoParams", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void release() {
            CJPayHostInfo.titleBitmap = null;
        }

        @JvmStatic
        public final JSONObject toJson(CJPayHostInfo r100) {
            return toJson$default(this, r100, null, 2, null);
        }

        @JvmStatic
        public final boolean curAppAsDouMall() {
            return Intrinsics.areEqual("561124", CJEnv.e());
        }

        @JvmStatic
        public final boolean curAppAsDouYin() {
            return Intrinsics.areEqual("1128", CJEnv.e());
        }

        @JvmStatic
        public final boolean curAppAsDouhuo() {
            return Intrinsics.areEqual("8663", CJEnv.e());
        }

        @JvmStatic
        public final boolean isBoe() {
            if (CJPayHostInfo.serverType != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public final boolean isPPE() {
            return Intrinsics.areEqual(CJPayHostInfo.envChannel, "local_test");
        }

        @JvmStatic
        public final Map<String, String> getLoginToken() {
            return CJPayHostInfo.access$getLoginTokenMap$cp();
        }

        private final Map<String, String> jsonToMap(JSONObject r100) {
            HashMap r101 = new HashMap();
            if (r100 == null) goto L11;
            Iterator<String> r102 = r100.keys();
        L6:
            if (r102.hasNext() == false) goto L11;
            String r103 = r102.next();
            String r104 = r100.optString(r103);
            if (r104 != null) goto L10;
            r104 = "";
        L10:
            r101.put(r103, r104);
        L11:
            return r101;
        }

        private final JSONObject mapToJson(Map<String, String> r100) {
            if (r100 != null) goto L6;
            return new JSONObject();
        L6:
            return new JSONObject(r100);
        }

        @JvmStatic
        public final CJPayHostInfo copy(CJPayHostInfo r100) {
            CJPayHostInfo r101 = new CJPayHostInfo();
            Map r102 = null;
            if (r100 == null) goto L5;
            String r103 = r100.merchantId;
        L6:
            r101.merchantId = r103;
            if (r100 == null) goto L9;
            String r104 = r100.appId;
        L10:
            r101.appId = r104;
            if (r100 == null) goto L13;
            String r105 = r100.customUa;
        L14:
            r101.customUa = r105;
            if (r100 == null) goto L17;
            boolean r106 = r100.needLoading;
        L18:
            r101.needLoading = r106;
            if (r100 == null) goto L21;
            String r107 = r100.titleStr;
        L22:
            r101.titleStr = r107;
            boolean r108 = false;
            if (r100 == null) goto L25;
            boolean r109 = r100.isTransCheckoutCounterActivityWhenLoading;
        L26:
            r101.isTransCheckoutCounterActivityWhenLoading = r109;
            if (r100 == null) goto L30;
            int r110 = r100.mScreenOrientationType;
            if (r110 == null) goto L30;
        L31:
            r101.mScreenOrientationType = r110;
            if (r100 == null) goto L34;
            boolean r111 = r100.isGameNewStyle;
        L35:
            r101.isGameNewStyle = r111;
            if (r100 == null) goto L38;
            boolean r112 = r100.isGameNewCounterStyle;
        L39:
            r101.isGameNewCounterStyle = r112;
            if (r100 == null) goto L42;
            boolean r113 = r100.fromImRedPacket;
        L43:
            r101.fromImRedPacket = r113;
            if (r100 == null) goto L47;
            String r114 = r100.isCaijingSaas;
            if (r114 == null) goto L47;
        L48:
            r101.isCaijingSaas = r114;
            HashMap r115 = new HashMap();
            if (r100 == null) goto L51;
            Map<String, String> r116 = r100.getRequestParams();
        L53:
            if ((r116 instanceof HashMap) == false) goto L55;
            Map r117 = (HashMap) r116;
        L56:
            if (r117 != null) goto L59;
            r117 = MapsKt.emptyMap();
        L59:
            r115.putAll(r117);
            CJPayHostInfo.access$setPayRequestParams$p(r101, r115);
            HashMap r118 = new HashMap();
            if (r100 == null) goto L62;
            Map<String, String> r119 = r100.getRiskInfoParams();
        L64:
            if ((r119 instanceof HashMap) == false) goto L66;
            r102 = (HashMap) r119;
        L66:
            if (r102 != null) goto L69;
            r102 = MapsKt.emptyMap();
        L69:
            r118.putAll(r102);
            CJPayHostInfo.access$setRiskInfoParams$p(r101, r118);
            HashMap<String, String> r120 = new HashMap();
            if (r100 == null) goto L74;
            Map<? extends String, ? extends String> r121 = r100.extraHeaderMap;
            if (r121 == null) goto L74;
        L75:
            r120.putAll(r121);
            r101.extraHeaderMap = r120;
            if (r100 == null) goto L78;
            r108 = r100.isUnifyHideLoading;
        L78:
            r101.isUnifyHideLoading = r108;
            String r122 = "";
            if (r100 == null) goto L82;
            String r123 = r100.invokeType;
            if (r123 == null) goto L82;
        L83:
            r101.invokeType = r123;
            if (r100 == null) goto L89;
            String r124 = r100.enableBioSource;
            if (r124 == null) goto L89;
            r122 = r124;
        L89:
            r101.enableBioSource = r122;
            return r101;
        L82:
            r123 = "";
        L74:
            r121 = MapsKt.emptyMap();
            goto L75
        L62:
            r119 = null;
            goto L64
        L55:
            r117 = null;
            goto L56
        L51:
            r116 = null;
        L47:
            r114 = "-1";
            goto L48
        L42:
            r113 = false;
            goto L43
        L38:
            r112 = false;
            goto L39
        L34:
            r111 = false;
        L30:
            r110 = 3;
            goto L31
        L25:
            r109 = false;
            goto L26
        L21:
            r107 = null;
            goto L22
        L17:
            r106 = true;
            goto L18
        L13:
            r105 = null;
            goto L14
        L9:
            r104 = null;
            goto L10
        L5:
            r103 = null;
            goto L6
        }

        @JvmStatic
        public final void setLoginToken(Map<String, String> r100) {
            if (r100 == null) goto L18;
            Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
            String r102 = "";
            int r103 = 0;
        L5:
            if (r101.hasNext() == false) goto L10;
            Map.Entry<String, String> r104 = r101.next();
            String r105 = r104.getKey();
            String r106 = r104.getValue();
            r103 = r103 + 1;
            if (r103 == r100.size()) goto L8;
            r102 = r102 + r105 + com.alipay.sdk.m.n.a.f25612h + r106 + ';';
            goto L5
        L8:
            r102 = r102 + r105 + com.alipay.sdk.m.n.a.f25612h + r106;
            goto L5
        L10:
            CJPayHostInfo.access$setLoginTokenMap$cp(r100);
            return;
        }

        @JvmStatic
        public final CJPayHostInfo toBean(JSONObject r100) {
            CJPayHostInfo r101 = new CJPayHostInfo();
            String r102 = null;
            if (r100 != null) goto L130;
            String r103 = null;
        L8:
            r101.merchantId = r103;     // Catch: Exception -> L5
            if (r100 == null) goto L11;
            String r104 = r100.optString("appId");     // Catch: Exception -> L5
        L12:
            r101.appId = r104;     // Catch: Exception -> L5
            if (r100 == null) goto L15;
            String r105 = r100.optString("customUa");     // Catch: Exception -> L5
        L16:
            r101.customUa = r105;     // Catch: Exception -> L5
            boolean r106 = false;
            if (r100 == null) goto L19;
            boolean r107 = r100.optBoolean("needLoading");     // Catch: Exception -> L5
        L20:
            r101.needLoading = r107;     // Catch: Exception -> L5
            if (r100 == null) goto L23;
            String r108 = r100.optString("titleStr");     // Catch: Exception -> L5
        L24:
            r101.titleStr = r108;     // Catch: Exception -> L5
            if (r100 == null) goto L27;
            boolean r109 = r100.optBoolean("isTransCheckoutCounterActivityWhenLoading");     // Catch: Exception -> L5
        L28:
            r101.isTransCheckoutCounterActivityWhenLoading = r109;     // Catch: Exception -> L5
            if (r100 == null) goto L31;
            Integer r110 = Integer.valueOf(r100.optInt("mScreenOrientationType"));     // Catch: Exception -> L5
        L32:
            r101.mScreenOrientationType = r110;     // Catch: Exception -> L5
            if (r100 == null) goto L35;
            boolean r111 = r100.optBoolean("isGameNewStyle");     // Catch: Exception -> L5
        L36:
            r101.isGameNewStyle = r111;     // Catch: Exception -> L5
            if (r100 == null) goto L39;
            boolean r112 = r100.optBoolean("isGameNewCounterStyle");     // Catch: Exception -> L5
        L40:
            r101.isGameNewCounterStyle = r112;     // Catch: Exception -> L5
            if (r100 == null) goto L43;
            JSONObject r113 = r100.optJSONObject("payRequestParams");     // Catch: Exception -> L5
        L44:
            CJPayHostInfo.access$setPayRequestParams$p(r101, jsonToMap(r113));     // Catch: Exception -> L5
            if (r100 == null) goto L47;
            JSONObject r114 = r100.optJSONObject("riskInfoParams");     // Catch: Exception -> L5
        L48:
            Map<String, String> r115 = jsonToMap(r114);     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String?>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String?> }");     // Catch: Exception -> L5
            CJPayHostInfo.access$setRiskInfoParams$p(r101, (HashMap) r115);     // Catch: Exception -> L5
            if (r100 == null) goto L51;
            JSONObject r116 = r100.optJSONObject("extraHeaderMap");     // Catch: Exception -> L5
        L52:
            Map<String, String> r117 = jsonToMap(r116);     // Catch: Exception -> L5
            Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");     // Catch: Exception -> L5
            r101.extraHeaderMap = (HashMap) r117;     // Catch: Exception -> L5
            if (r100 == null) goto L55;
            Integer r118 = Integer.valueOf(r100.optInt("fromFastPayType", 0));     // Catch: Exception -> L5
        L56:
            r101.fromFastPayType = r118;     // Catch: Exception -> L5
            int r119 = 1;
            if (r100 == null) goto L59;
            r119 = r100.optInt("isUnionPayBindEnable", 1);     // Catch: Exception -> L5
        L59:
            r101.setUnionPayBindEnable(r119);     // Catch: Exception -> L5
            if (r100 == null) goto L62;
            boolean r120 = r100.optBoolean("fromImRedPacket");     // Catch: Exception -> L5
        L63:
            r101.fromImRedPacket = r120;     // Catch: Exception -> L5
            String r121 = "-1";
            if (r100 == null) goto L67;
            String r122 = r100.optString("isCaijingSaas", "-1");     // Catch: Exception -> L5
        L68:
            if (r122 == null) goto L71;
            r121 = r122;
        L71:
            r101.isCaijingSaas = r121;     // Catch: Exception -> L5
            String r123 = "";
            if (r100 == null) goto L75;
            String r124 = r100.optString("papi_id", "");     // Catch: Exception -> L5
        L76:
            if (r124 != null) goto L78;
            r124 = "";
        L78:
            r101.papiID = r124;     // Catch: Exception -> L5
            if (r100 == null) goto L82;
            String r125 = r100.optString(InstantPlayContext.NICKNAME, "");     // Catch: Exception -> L5
            if (r125 == null) goto L82;
        L83:
            r101.nickName = r125;     // Catch: Exception -> L5
            if (r100 == null) goto L87;
            String r126 = r100.optString("avatarUrl", "");     // Catch: Exception -> L5
            if (r126 == null) goto L87;
        L88:
            r101.avatarUrl = r126;     // Catch: Exception -> L5
            if (r100 == null) goto L91;
            Boolean r127 = Boolean.valueOf(r100.optBoolean("isFromScan", false));     // Catch: Exception -> L5
        L92:
            if (r127 == null) goto L94;
            boolean r128 = r127.booleanValue();     // Catch: Exception -> L5
        L95:
            r101.isFromScan = r128;     // Catch: Exception -> L5
            if (r100 == null) goto L98;
            Boolean r129 = Boolean.valueOf(r100.optBoolean("isContinuePay", false));     // Catch: Exception -> L5
        L99:
            if (r129 == null) goto L101;
            boolean r130 = r129.booleanValue();     // Catch: Exception -> L5
        L102:
            r101.isContinuePay = r130;     // Catch: Exception -> L5
            if (r100 == null) goto L105;
            String r131 = r100.optString("unifyFromService", "");     // Catch: Exception -> L5
        L106:
            if (r131 != null) goto L108;
            r131 = "";
        L108:
            r101.unifyFromService = r131;     // Catch: Exception -> L5
            if (r100 == null) goto L111;
            Boolean r132 = Boolean.valueOf(r100.optBoolean("isUnifyHideLoading", false));     // Catch: Exception -> L5
        L112:
            if (r132 == null) goto L114;
            r106 = r132.booleanValue();     // Catch: Exception -> L5
        L114:
            r101.isUnifyHideLoading = r106;     // Catch: Exception -> L5
            if (r100 == null) goto L117;
            String r133 = r100.optString("invokeType", "");     // Catch: Exception -> L5
        L118:
            if (r133 != null) goto L120;
            r133 = "";
        L120:
            r101.invokeType = r133;     // Catch: Exception -> L5
            if (r100 == null) goto L123;
            r102 = r100.optString("source", "");     // Catch: Exception -> L5
        L123:
            if (r102 == null) goto L126;
            r123 = r102;
        L126:
            r101.enableBioSource = r123;     // Catch: Exception -> L5
        L129:
            return r101;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayHostInfo#toBean", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayHostInfo#toBean", e);
            goto L129
        L117:
            r133 = null;
            goto L118
        L111:
            r132 = null;
            goto L112
        L105:
            r131 = null;
            goto L106
        L101:
            r130 = false;
            goto L102
        L98:
            r129 = null;
            goto L99
        L94:
            r128 = false;
            goto L95
        L91:
            r127 = null;
        L87:
            r126 = "";
        L82:
            r125 = "";
            goto L83
        L75:
            r124 = null;
            goto L76
        L67:
            r122 = null;
            goto L68
        L62:
            r120 = false;
            goto L63
        L55:
            r118 = null;
            goto L56
        L51:
            r116 = null;
            goto L52
        L47:
            r114 = null;
            goto L48
        L43:
            r113 = null;
            goto L44
        L39:
            r112 = false;
            goto L40
        L35:
            r111 = false;
            goto L36
        L31:
            r110 = null;
            goto L32
        L27:
            r109 = false;
            goto L28
        L23:
            r108 = null;
            goto L24
        L19:
            r107 = false;
            goto L20
        L15:
            r105 = null;
            goto L16
        L11:
            r104 = null;
            goto L12
        L130:
            r103 = r100.optString("merchantId");     // Catch: Exception -> L5
            goto L8
        }

        @JvmStatic
        public final JSONObject toJson(CJPayHostInfo r100, Map<String, String> r101) {
            JSONObject r102 = new JSONObject();
            String r103 = null;
            if (r100 != null) goto L127;
            String r104 = null;
        L7:
            r102.put("merchantId", r104);     // Catch: Exception -> L124
            if (r100 == null) goto L10;
            String r105 = r100.appId;     // Catch: Exception -> L124
        L11:
            r102.put("appId", r105);     // Catch: Exception -> L124
            if (r100 == null) goto L14;
            String r106 = r100.customUa;     // Catch: Exception -> L124
        L15:
            r102.put("customUa", r106);     // Catch: Exception -> L124
            if (r100 == null) goto L18;
            Boolean r107 = Boolean.valueOf(r100.needLoading);     // Catch: Exception -> L124
        L19:
            r102.put("needLoading", r107);     // Catch: Exception -> L124
            if (r100 == null) goto L22;
            String r108 = r100.titleStr;     // Catch: Exception -> L124
        L23:
            r102.put("titleStr", r108);     // Catch: Exception -> L124
            if (r100 == null) goto L26;
            Boolean r109 = Boolean.valueOf(r100.isTransCheckoutCounterActivityWhenLoading);     // Catch: Exception -> L124
        L27:
            r102.put("isTransCheckoutCounterActivityWhenLoading", r109);     // Catch: Exception -> L124
            if (r100 == null) goto L30;
            Integer r110 = r100.mScreenOrientationType;     // Catch: Exception -> L124
        L31:
            r102.put("mScreenOrientationType", r110);     // Catch: Exception -> L124
            if (r100 == null) goto L34;
            Boolean r111 = Boolean.valueOf(r100.isGameNewStyle);     // Catch: Exception -> L124
        L35:
            r102.put("isGameNewStyle", r111);     // Catch: Exception -> L124
            if (r100 == null) goto L38;
            Boolean r112 = Boolean.valueOf(r100.isGameNewCounterStyle);     // Catch: Exception -> L124
        L39:
            KtSafeMethodExtensionKt.safePut(r102, "isGameNewCounterStyle", r112);     // Catch: Exception -> L124
            if (r100 == null) goto L42;
            Integer r113 = r100.fromFastPayType;     // Catch: Exception -> L124
        L43:
            r102.put("fromFastPayType", r113);     // Catch: Exception -> L124
            if (r100 == null) goto L46;
            Boolean r114 = Boolean.valueOf(r100.fromImRedPacket);     // Catch: Exception -> L124
        L47:
            r102.put("fromImRedPacket", r114);     // Catch: Exception -> L124
            if (r100 == null) goto L50;
            String r115 = r100.isCaijingSaas;     // Catch: Exception -> L124
        L51:
            r102.put("isCaijingSaas", r115);     // Catch: Exception -> L124
            if (r100 == null) goto L54;
            Map<String, String> r116 = CJPayHostInfo.access$getPayRequestParams$p(r100);     // Catch: Exception -> L124
        L55:
            r102.put("payRequestParams", mapToJson(r116));     // Catch: Exception -> L124
            r102.put("riskInfoParams", mapToJson(r101));     // Catch: Exception -> L124
            if (r100 == null) goto L58;
            HashMap<String, String> r117 = r100.extraHeaderMap;     // Catch: Exception -> L124
        L59:
            r102.put("extraHeaderMap", mapToJson(r117));     // Catch: Exception -> L124
            if (r100 == null) goto L62;
            Integer r118 = Integer.valueOf(r100.isUnionPayBindEnable());     // Catch: Exception -> L124
        L63:
            r102.put("isUnionPayBindEnable", r118);     // Catch: Exception -> L124
            if (r100 == null) goto L67;
            String r119 = r100.papiID;     // Catch: Exception -> L124
        L68:
            String r120 = "";
            if (r119 != null) goto L71;
            r119 = "";
        L71:
            r102.put("papi_id", r119);     // Catch: Exception -> L124
            if (r100 == null) goto L74;
            String r121 = r100.nickName;     // Catch: Exception -> L124
        L75:
            if (r121 != null) goto L77;
            r121 = "";
        L77:
            r102.put(InstantPlayContext.NICKNAME, r121);     // Catch: Exception -> L124
            if (r100 == null) goto L80;
            String r122 = r100.avatarUrl;     // Catch: Exception -> L124
        L81:
            if (r122 != null) goto L83;
            r122 = "";
        L83:
            r102.put("avatarUrl", r122);     // Catch: Exception -> L124
            if (r100 == null) goto L86;
            Boolean r123 = Boolean.valueOf(r100.isFromScan);     // Catch: Exception -> L124
        L87:
            boolean r124 = false;
            if (r123 == null) goto L90;
            boolean r125 = r123.booleanValue();     // Catch: Exception -> L124
        L91:
            r102.put("isFromScan", r125);     // Catch: Exception -> L124
            if (r100 == null) goto L94;
            Boolean r126 = Boolean.valueOf(r100.isContinuePay);     // Catch: Exception -> L124
        L95:
            if (r126 == null) goto L97;
            boolean r127 = r126.booleanValue();     // Catch: Exception -> L124
        L98:
            r102.put("isContinuePay", r127);     // Catch: Exception -> L124
            if (r100 == null) goto L101;
            String r128 = r100.unifyFromService;     // Catch: Exception -> L124
        L102:
            if (r128 != null) goto L104;
            r128 = "";
        L104:
            r102.put("unifyFromService", r128);     // Catch: Exception -> L124
            if (r100 == null) goto L107;
            Boolean r129 = Boolean.valueOf(r100.isUnifyHideLoading);     // Catch: Exception -> L124
        L108:
            if (r129 == null) goto L110;
            r124 = r129.booleanValue();     // Catch: Exception -> L124
        L110:
            r102.put("isUnifyHideLoading", r124);     // Catch: Exception -> L124
            if (r100 == null) goto L113;
            String r130 = r100.invokeType;     // Catch: Exception -> L124
        L114:
            if (r130 != null) goto L116;
            r130 = "";
        L116:
            r102.put("invokeType", r130);     // Catch: Exception -> L124
            if (r100 == null) goto L119;
            r103 = r100.enableBioSource;     // Catch: Exception -> L124
        L119:
            if (r103 == null) goto L122;
            r120 = r103;
        L122:
            r102.put("source", r120);     // Catch: Exception -> L124
        L126:
            return r102;
        L124:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayHostInfo#toJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayHostInfo#toJson", e);
            goto L126
        L113:
            r130 = null;
            goto L114
        L107:
            r129 = null;
            goto L108
        L101:
            r128 = null;
            goto L102
        L97:
            r127 = false;
            goto L98
        L94:
            r126 = null;
            goto L95
        L90:
            r125 = false;
            goto L91
        L86:
            r123 = null;
            goto L87
        L80:
            r122 = null;
            goto L81
        L74:
            r121 = null;
            goto L75
        L67:
            r119 = null;
            goto L68
        L62:
            r118 = null;
            goto L63
        L58:
            r117 = null;
            goto L59
        L54:
            r116 = null;
            goto L55
        L50:
            r115 = null;
            goto L51
        L46:
            r114 = null;
            goto L47
        L42:
            r113 = null;
            goto L43
        L38:
            r112 = null;
            goto L39
        L34:
            r111 = null;
            goto L35
        L30:
            r110 = null;
            goto L31
        L26:
            r109 = null;
            goto L27
        L22:
            r108 = null;
            goto L23
        L18:
            r107 = null;
            goto L19
        L14:
            r106 = null;
            goto L15
        L10:
            r105 = null;
            goto L11
        L127:
            r104 = r100.merchantId;     // Catch: Exception -> L124
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ JSONObject toJson$default(Companion r100, CJPayHostInfo r101, Map r102, int r103, Object r104) {
            if ((r103 & 2) == 0) goto L8;
            if (r101 == null) goto L6;
            r102 = r101.getRiskInfoParams();
            goto L8
        L6:
            r102 = null;
        L8:
            return r100.toJson(r101, r102);
        }
    }

    @JvmStatic
    public static final CJPayHostInfo copy(CJPayHostInfo r100) {
        return Companion.copy(r100);
    }

    @JvmStatic
    public static final boolean curAppAsDouMall() {
        return Companion.curAppAsDouMall();
    }

    @JvmStatic
    public static final boolean curAppAsDouYin() {
        return Companion.curAppAsDouYin();
    }

    @JvmStatic
    public static final boolean curAppAsDouhuo() {
        return Companion.curAppAsDouhuo();
    }

    @JvmStatic
    public static final Map<String, String> getLoginToken() {
        return Companion.getLoginToken();
    }

    @JvmStatic
    public static final boolean isBoe() {
        return Companion.isBoe();
    }

    @JvmStatic
    public static final boolean isPPE() {
        return Companion.isPPE();
    }

    @JvmStatic
    public static final void setLoginToken(Map<String, String> r100) {
        Companion.setLoginToken(r100);
    }

    @JvmStatic
    public static final CJPayHostInfo toBean(JSONObject r100) {
        return Companion.toBean(r100);
    }

    @JvmStatic
    public static final JSONObject toJson(CJPayHostInfo r100) {
        return Companion.toJson(r100);
    }

    @JvmStatic
    public static final JSONObject toJson(CJPayHostInfo r100, Map<String, String> r101) {
        return Companion.toJson(r100, r101);
    }

    static {
        Companion = new Companion(null);
        applicationContext = CJEnv.a();
        serverType = 1;
        isUsingTTNet = true;
        isUsingGecko = true;
        languageTypeStr = "cn";
        screenOrientationType = 3;
        fontScale = 1.0f;
        appUpdateVersion = "";
        channel = "";
        envChannel = "online";
        fixAssetsMap = new ConcurrentHashMap();
    }

    public final Context getContext() {
        WeakReference<Context> r100 = this.contextRef;
        if (r100 == null) goto L5;
        Context r101 = r100.get();
    L6:
        if (r101 == null) goto L11;
        WeakReference<Context> r102 = this.contextRef;
        if (r102 == null) goto L10;
        Context r103 = r102.get();
    L13:
        if ((r103 instanceof Activity) == true) goto L24;
    L22:
        return r103;
    L24:
        ConcurrentHashMap<String, Long> r104 = fixAssetsMap;     // Catch: Throwable -> L20
        if (r104.containsKey(r103.getClass().getName()) == false) goto L18;
        CJLogger.d("CJPayHostInfo", "fixed activity asset at " + System.currentTimeMillis());     // Catch: Throwable -> L20
    L23:
        goto L22
    L18:
        CJLogger.d("CJPayHostInfo", "fixing activity asset at " + System.currentTimeMillis());     // Catch: Throwable -> L20
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L20
        ((CJHostService) ve4.a.d(CJHostService.class)).getEnvController();     // Catch: Throwable -> L20
        r104.put(r103.getClass().getName(), Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayHostInfo#getContext", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayHostInfo#getContext", th);
        CJReporter r105 = CJReporter.f202294a;
        CJReporter.m(null, "hookMira", 0, th);
        goto L22
    L10:
        r103 = null;
        goto L13
    L11:
        r103 = CJEnv.a();
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final Map<String, String> getRiskInfoParams() {
        Map<String, String> r100 = CJPayBasicUtils.getBasicRiskInfo(this.merchantId);
        Map<String, String> r101 = this.riskInfoParams;
        if (r101 == null) goto L16;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (r101.containsKey(r104) == false) goto L9;
        if (r101.containsKey(r104) == false) goto L6;
        if (TextUtils.isEmpty(r101.get(r104)) == false) goto L6;
        r101.put(r104, r105);
        goto L6
    L9:
        r101.put(r104, r105);
    L16:
        if (this.riskInfoParams != null) goto L19;
        this.riskInfoParams = r100;
    L19:
        return this.riskInfoParams;
    }

    public final boolean isUnionPayEnable() {
        if (this.isUnionPayBindEnable == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public CJPayHostInfo() {
        this.customUa = "";
        this.needLoading = true;
        this.mScreenOrientationType = 3;
        this.fromFastPayType = 0;
        this.papiID = "";
        this.invokeType = "";
        this.unifyFromService = "";
        this.enableBioSource = "";
        this.isCaijingSaas = "-1";
        this.riskInfoParams = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("channel", CJEnv.b()), TuplesKt.to(WsConstants.KEY_INSTALL_ID, CJEnv.f().getIID())});
        this.isUnionPayBindEnable = 1;
    }

    public static final /* synthetic */ Map access$getLoginTokenMap$cp() {
        return loginTokenMap;
    }

    public final float getFontScale() {
        return fontScale;
    }

    public final Map<String, String> getRequestParams() {
        return this.payRequestParams;
    }

    public final Map<String, String> getRiskInfoParamsCache() {
        return this.riskInfoParams;
    }

    public final boolean isContinuePay() {
        return this.isContinuePay;
    }

    public final int isUnionPayBindEnable() {
        return this.isUnionPayBindEnable;
    }

    public static final /* synthetic */ Map access$getPayRequestParams$p(CJPayHostInfo r100) {
        return r100.payRequestParams;
    }

    public static final /* synthetic */ void access$setLoginTokenMap$cp(Map r100) {
        loginTokenMap = r100;
    }

    public final void setContext(Context r100) {
        this.contextRef = new WeakReference(r100);
        if (r100 == null) goto L5;
        Context r101 = r100.getApplicationContext();
    L6:
        applicationContext = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setFontScale(float r100) {
        fontScale = r100;
    }

    public final void setRequestParams(Map<String, String> r100) {
        if (r100 == null) goto L14;
        this.payRequestParams = r100;
        if (TextUtils.isEmpty(this.merchantId) == false) goto L9;
        if (TextUtils.isEmpty(r100.get("merchant_id")) == true) goto L9;
        this.merchantId = r100.get("merchant_id");
    L9:
        if (TextUtils.isEmpty(this.appId) == true) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r100.get("app_id")) == true) goto L16;
        this.appId = r100.get("app_id");
        return;
    L16:
        return;
    }

    public final void setRiskInfoParams(Map<String, String> r100) {
        this.riskInfoParams = r100;
        if (r100 == null) goto L16;
        String r101 = r100.get("channel");
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L18;
        channel = r101;
        return;
    L18:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public final void setUnionPayBindEnable(int r100) {
        this.isUnionPayBindEnable = r100;
    }

    public static final /* synthetic */ void access$setPayRequestParams$p(CJPayHostInfo r100, Map r101) {
        r100.payRequestParams = r101;
    }

    public static final /* synthetic */ void access$setRiskInfoParams$p(CJPayHostInfo r100, Map r101) {
        r100.riskInfoParams = r101;
    }
}
