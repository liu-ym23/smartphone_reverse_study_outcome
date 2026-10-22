package com.bytedance.android.openlive;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alipay.sdk.m.k.b;
import com.bytedance.android.live.base.api.ActivityType;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.IHostWallet;
import com.bytedance.android.livehostapi.platform.IHostAccountAuth;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.android.livehostapi.platform.LiveHostApp;
import com.bytedance.android.livehostapi.wrap.AbsHostApp;
import com.bytedance.android.livehostapi.wrap.AbsHostShare;
import com.bytedance.android.livehostapi.wrap.AbsHostWebView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ry.a;
import ry.e;
import ry.o;
import ry.p;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001f\b&\u0018\u00002\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\bZ\u0010;J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00152\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0019\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001cR\u001a\u0010*\u001a\u00020)8\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010/\u001a\u00020.8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0014\u00104\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001cR\u0014\u00106\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001cR\u0014\u00108\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001cR\u001a\u0010<\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010;\u001a\u0004\b9\u0010\u001cR\u0014\u0010@\u001a\u00020=8&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u001cR\u0014\u0010D\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u001cR\u0014\u0010G\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010FR\u0014\u0010K\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010FR\u001a\u0010N\u001a\u00020)8&X§\u0004¢\u0006\f\u0012\u0004\bM\u0010;\u001a\u0004\bL\u0010-R\u001a\u0010O\u001a\u00020)8&X§\u0004¢\u0006\f\u0012\u0004\bP\u0010;\u001a\u0004\bO\u0010-R\u001a\u0010S\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\bR\u0010;\u001a\u0004\bQ\u0010\u001cR\u0014\u0010U\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001cR\u0014\u0010W\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u001cR\u0014\u0010Y\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u001c¨\u0006\\"}, d2 = {"Lcom/bytedance/android/openlive/LiveContext;", "", "Lcom/bytedance/android/livehostapi/business/IHostWallet;", "getWallet", "Lcom/bytedance/android/livehostapi/platform/IHostAction;", "getHostAction", "Lcom/bytedance/android/livehostapi/platform/IHostWebView;", "getWebView", "Lcom/bytedance/android/livehostapi/business/IHostShare;", "getShare", "Lcom/bytedance/android/livehostapi/platform/IHostAccountAuth;", "getAccountAuth", "Lcom/bytedance/android/livehostapi/platform/IHostTokenInjectionAuth;", "injectAccount", "Lcom/bytedance/android/livehostapi/wrap/AbsHostApp;", "getHostApp", "", "getUserId", "getNativeLibraryDir", "", "type", "Ljava/lang/Class;", "getHostActivity", "Lry/o;", "provideMethodChannel", "clientKey", "Ljava/lang/String;", "getClientKey", "()Ljava/lang/String;", "Lry/p;", "partnerExtra", "Lry/p;", "getPartnerExtra", "()Lry/p;", "", "feParamsExtra", "Ljava/util/Map;", "getFeParamsExtra", "()Ljava/util/Map;", "ecHostAppId", "getEcHostAppId", "", "needInitNetwork", "Z", "getNeedInitNetwork", "()Z", "Lry/e;", "hostPermission", "Lry/e;", "getHostPermission", "()Lry/e;", "getTtSDKAppId", "ttSDKAppId", "getTtSDKCertAssetsPath", "ttSDKCertAssetsPath", "getMsSDKAppId", "msSDKAppId", "getChannel", "getChannel$annotations", "()V", "channel", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "getVersion", "version", "getAppName", "appName", "getVersionCode", "()I", RuleConditionBean.VERSION_CODE_KEY, "getAid", "aid", "getAppIcon", "appIcon", "getDebug", "getDebug$annotations", "debug", "isBoe", "isBoe$annotations", "getNpthAppId", "getNpthAppId$annotations", "npthAppId", "getGeneralAppId", "generalAppId", "getPartner", b.f25437z0, "getPartnerSecret", "partnerSecret", "<init>", "Builder", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
public abstract class LiveContext {
    private final String clientKey;
    private final String ecHostAppId;
    private final Map<String, String> feParamsExtra;
    private final e hostPermission;
    private final boolean needInitNetwork;
    private final p partnerExtra;

    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\\B\u0007¢\u0006\u0004\b[\u0010JJ\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020,J\u000e\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020/J\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\fJ\u000e\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020\fJ\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u00020\fJ\u000e\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020,J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\fJ\u000e\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\fJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020,J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\fJ\u0006\u0010C\u001a\u00020BR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010DR\u0016\u0010\u0016\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010ER\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010ER\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010FR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010GR\u001c\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b \u0010H\u0012\u0004\bI\u0010JR\u001c\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\"\u0010H\u0012\u0004\bK\u0010JR\u001c\u0010$\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b$\u0010E\u0012\u0004\bL\u0010JR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010NR\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010OR\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010PR\u0016\u00102\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010ER\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010QR$\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010ER\u0016\u00100\u001a\u00020U8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u0010VR\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u0010ER\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u0010ER\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010ER\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010ER\u0018\u00108\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010WR\u0018\u0010:\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010ER\u0018\u0010<\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010ER\u0018\u0010>\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010WR\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010E\u001a\u0004\bX\u0010Y\"\u0004\bA\u0010ZR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010H¨\u0006]"}, d2 = {"Lcom/bytedance/android/openlive/LiveContext$Builder;", "", "Landroid/content/pm/PackageInfo;", "kotlin.jvm.PlatformType", "packageInfo", "", "needInitNetwork", "", "setNeedInitNetwork", "Lry/p;", "partnerExtra", "setPartnerExtra", "", "ecHostAppId", "setECHostAppId", b.f25437z0, "setPartner", "partnerSecret", "setPartnerSecret", "Lcom/bytedance/android/livehostapi/platform/IHostAction;", "action", "setAction", "cjAppId", "setCjAppId", "cjMerchantId", "setCjMerchantId", "Lcom/bytedance/android/livehostapi/platform/IHostWebView;", "webView", "setWebView", "Lcom/bytedance/android/livehostapi/business/IHostShare;", "share", "setShare", "debug", "setDebug", "isBoe", "setIsBoe", "channel", "setChannel", "Lcom/bytedance/android/openlive/LiveContext$Builder$IUserIdGetter;", "userIdGetter", "setUserIdGetter", "Lcom/bytedance/android/livehostapi/platform/IHostTokenInjectionAuth;", "auth", "setAuth", "", "aid", "setAid", "Landroid/app/Application;", PerfLog.PARAM_KEY_CONTEXT_ID, "setContext", "generalAppId", "setGeneralAppId", "ttSDKAppId", "setTtSDKAppId", "ttSDKCertAssetsPath", "setTtSDKCertAssetsPath", RuleConditionBean.VERSION_CODE_KEY, "setVersionCode", "appName", "setAppName", "version", "setVersion", "appIcon", "setAppIcon", "clientKey", "setClientKey", "Lcom/bytedance/android/openlive/LiveContext;", "build", "Lcom/bytedance/android/livehostapi/platform/IHostAction;", "Ljava/lang/String;", "Lcom/bytedance/android/livehostapi/platform/IHostWebView;", "Lcom/bytedance/android/livehostapi/business/IHostShare;", "Z", "getDebug$annotations", "()V", "isBoe$annotations", "getChannel$annotations", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "Lcom/bytedance/android/livehostapi/platform/IHostTokenInjectionAuth;", "I", "Lry/p;", "", "paramsExtra", "Ljava/util/Map;", "Landroid/content/Context;", "Landroid/content/Context;", "Ljava/lang/Integer;", "getClientKey", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "<init>", "IUserIdGetter", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private IHostAction action;
        private int aid;
        private Integer appIcon;
        private String appName;
        private IHostTokenInjectionAuth auth;
        private String channel;
        private String cjAppId;
        private String cjMerchantId;
        private String clientKey;
        private Context context;
        private boolean debug;
        private String ecHostAppId;
        private String generalAppId;
        private boolean isBoe;
        private boolean needInitNetwork;
        private Map<String, String> paramsExtra;
        private String partner;
        private p partnerExtra;
        private String partnerSecret;
        private IHostShare share;
        private String ttSDKAppId;
        private String ttSDKCertAssetsPath;
        private Function0<String> userIdGetter;
        private String version;
        private Integer versionCode;
        private IHostWebView webView;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/openlive/LiveContext$Builder$IUserIdGetter;", "", "getUserId", "", "live-host-integration-default_release"}, k = 1, mv = {1, 4, 3})
        public interface IUserIdGetter {
            String getUserId();
        }

        @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
        private static /* synthetic */ void getChannel$annotations() {
        }

        @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
        private static /* synthetic */ void getDebug$annotations() {
        }

        @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
        private static /* synthetic */ void isBoe$annotations() {
        }

        public final Builder setPartnerExtra(p r100) {
            return this;
        }

        private final PackageInfo packageInfo() {
            Context r100 = this.context;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        L5:
            PackageManager r101 = r100.getPackageManager();
            Context r102 = this.context;
            if (r102 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        L9:
            return r101.getPackageInfo(r102.getPackageName(), 0);
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.openlive.LiveContext$Builder$build$wallet$1] */
        public final LiveContext build() {
            final int r110 = this.aid;
            final Context r100 = this.context;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        L5:
            final String r111 = this.clientKey;
            final String r112 = this.generalAppId;
            final String r101 = this.ttSDKAppId;
            if (r101 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("ttSDKAppId");
        L8:
            final String r102 = this.ttSDKCertAssetsPath;
            if (r102 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("ttSDKCertAssetsPath");
        L11:
            final String r103 = this.cjAppId;
            final String r104 = this.cjMerchantId;
            final boolean r113 = this.debug;
            final boolean r114 = this.isBoe;
            final String r105 = this.channel;
            final Function0<String> r106 = this.userIdGetter;
            final IHostTokenInjectionAuth r107 = this.auth;
            final IHostAction r115 = this.action;
            String r108 = this.appName;
            if (r108 != null) goto L14;
            r108 = packageInfo().applicationInfo.name;
        L14:
            final String r116 = r108;
            Integer r109 = this.appIcon;
            if (r109 == null) goto L17;
            int r117 = r109.intValue();
        L18:
            final int r118 = r117;
            Integer r119 = this.versionCode;
            if (r119 == null) goto L21;
            int r120 = r119.intValue();
        L22:
            final int r121 = r120;
            String r122 = this.version;
            if (r122 != null) goto L25;
            r122 = packageInfo().versionName;
        L25:
            final String r123 = r122;
            final boolean r124 = this.needInitNetwork;
            final p r210 = null;
            final Map<String, String> r125 = this.paramsExtra;
            final String r126 = this.partner;
            if (r126 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException(b.f25437z0);
        L28:
            final String r127 = this.partnerSecret;
            if (r127 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("partnerSecret");
        L31:
            final ?? r128 = new LiveContext$Builder$build$wallet$1(r103, r104);
            return new LiveContext$Builder$build$1(r128, r115, r107, r106, r101, r102, r105, r100, r123, r116, r121, r110, r118, r113, r114, r112, r111, r126, r127, r124, r210, r125);
        L21:
            r120 = packageInfo().versionCode;
            goto L22
        L17:
            r117 = packageInfo().applicationInfo.icon;
            goto L18
        }

        public Builder() {
            this.action = new LiveContext$Builder$action$1();
            this.cjAppId = "";
            this.cjMerchantId = "";
            this.webView = new AbsHostWebView();
            this.share = new AbsHostShare();
            this.channel = "demo_master";
            this.userIdGetter = LiveContext$Builder$userIdGetter$1.INSTANCE;
            this.auth = new LiveContext$Builder$auth$1();
            this.aid = 203317;
            this.generalAppId = String.valueOf(203317);
            this.clientKey = "awownm2327ddx7ls";
            this.needInitNetwork = true;
        }

        public final String getClientKey() {
            return this.clientKey;
        }

        public final Builder setAction(IHostAction r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.action = r100;
            return this;
        }

        public final Builder setAid(int r100) {
            this.aid = r100;
            return this;
        }

        public final Builder setAppIcon(int r100) {
            this.appIcon = Integer.valueOf(r100);
            return this;
        }

        public final Builder setAppName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appName");
            this.appName = r100;
            return this;
        }

        public final Builder setAuth(IHostTokenInjectionAuth r100) {
            Intrinsics.checkNotNullParameter(r100, "auth");
            this.auth = r100;
            return this;
        }

        public final Builder setChannel(String r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            this.channel = r100;
            return this;
        }

        public final Builder setCjAppId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cjAppId");
            this.cjAppId = r100;
            return this;
        }

        public final Builder setCjMerchantId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cjMerchantId");
            this.cjMerchantId = r100;
            return this;
        }

        public final Builder setClientKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "clientKey");
            this.clientKey = r100;
            return this;
        }

        public final Builder setContext(Application r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            return this;
        }

        public final Builder setDebug(boolean r100) {
            this.debug = r100;
            return this;
        }

        public final Builder setECHostAppId(String r100) {
            this.ecHostAppId = r100;
            return this;
        }

        public final Builder setGeneralAppId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "generalAppId");
            this.generalAppId = r100;
            return this;
        }

        public final Builder setIsBoe(boolean r100) {
            this.isBoe = r100;
            return this;
        }

        public final void setNeedInitNetwork(boolean r100) {
            this.needInitNetwork = r100;
        }

        public final Builder setPartner(String r100) {
            Intrinsics.checkNotNullParameter(r100, b.f25437z0);
            this.partner = r100;
            return this;
        }

        public final Builder setPartnerSecret(String r100) {
            Intrinsics.checkNotNullParameter(r100, "partnerSecret");
            this.partnerSecret = r100;
            return this;
        }

        public final Builder setShare(IHostShare r100) {
            Intrinsics.checkNotNullParameter(r100, "share");
            this.share = r100;
            return this;
        }

        public final Builder setTtSDKAppId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "ttSDKAppId");
            this.ttSDKAppId = r100;
            return this;
        }

        public final Builder setTtSDKCertAssetsPath(String r100) {
            Intrinsics.checkNotNullParameter(r100, "ttSDKCertAssetsPath");
            this.ttSDKCertAssetsPath = r100;
            return this;
        }

        public final Builder setUserIdGetter(final IUserIdGetter r100) {
            Intrinsics.checkNotNullParameter(r100, "userIdGetter");
            this.userIdGetter = new LiveContext$Builder$setUserIdGetter$$inlined$apply$lambda$1(r100);
            return this;
        }

        public final Builder setVersion(String r100) {
            Intrinsics.checkNotNullParameter(r100, "version");
            this.version = r100;
            return this;
        }

        public final Builder setVersionCode(int r100) {
            this.versionCode = Integer.valueOf(r100);
            return this;
        }

        public final Builder setWebView(IHostWebView r100) {
            Intrinsics.checkNotNullParameter(r100, "webView");
            this.webView = r100;
            return this;
        }

        /* JADX INFO: renamed from: setClientKey, reason: collision with other method in class */
        public final void m8278setClientKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.clientKey = r100;
        }
    }

    @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
    public static /* synthetic */ void getChannel$annotations() {
    }

    @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
    public static /* synthetic */ void getDebug$annotations() {
    }

    @Deprecated(message = "字段已经废弃，老版本和generalAppId保持一致。新版的接入方无需关注此参数。")
    public static /* synthetic */ void getNpthAppId$annotations() {
    }

    @Deprecated(message = "从1.8.7之后本参数将废弃，外部接入方能够设置该参数，但是不再能生效。控制行为收敛到字节环境。")
    public static /* synthetic */ void isBoe$annotations() {
    }

    public abstract IHostAccountAuth getAccountAuth();

    public abstract int getAid();

    public abstract int getAppIcon();

    public abstract String getAppName();

    public abstract String getChannel();

    public abstract Context getContext();

    public abstract boolean getDebug();

    public abstract String getGeneralAppId();

    public abstract IHostAction getHostAction();

    public Class<?> getHostActivity(@ActivityType int r100) {
        return null;
    }

    public abstract String getMsSDKAppId();

    public String getNativeLibraryDir() {
        return "";
    }

    public abstract String getNpthAppId();

    public abstract String getPartner();

    public p getPartnerExtra() {
        return null;
    }

    public abstract String getPartnerSecret();

    public abstract IHostShare getShare();

    public abstract String getTtSDKAppId();

    public abstract String getTtSDKCertAssetsPath();

    public abstract String getUserId();

    public abstract String getVersion();

    public abstract int getVersionCode();

    public abstract IHostWallet getWallet();

    public abstract IHostWebView getWebView();

    public abstract IHostTokenInjectionAuth injectAccount();

    public abstract boolean isBoe();

    public o provideMethodChannel() {
        return null;
    }

    public final AbsHostApp getHostApp() {
        return new LiveHostApp();
    }

    public LiveContext() {
        this.clientKey = "";
        this.needInitNetwork = true;
        this.hostPermission = new a();
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public String getEcHostAppId() {
        return this.ecHostAppId;
    }

    public Map<String, String> getFeParamsExtra() {
        return this.feParamsExtra;
    }

    public e getHostPermission() {
        return this.hostPermission;
    }

    public boolean getNeedInitNetwork() {
        return this.needInitNetwork;
    }
}
