package com.bytedance.android.live.saas.middleware;

import android.app.Application;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.dy.saas.utuid.d;
import com.bytedance.android.live.saas.middleware.alog.ILogProtocol;
import com.bytedance.android.live.saas.middleware.applog.IAppLog;
import com.bytedance.android.live.saas.middleware.base.BaseFunction;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.console.Console;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.npth.INpthHelper;
import com.bytedance.android.live.saas.middleware.sec.ISecSdk;
import com.bytedance.android.live.saas.middleware.store.IFileUtils;
import com.bytedance.android.live.saas.middleware.store.IMiddlewareSharedPref;
import com.bytedance.android.live.saas.middleware.store.SPHelper;
import com.bytedance.android.live.saas.middleware.store.StoreManager;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rf2.a;
import ry.e;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b@\u00101J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J/\u0010\u0011\u001a\u00020\n\"\u0004\b\u0000\u0010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0007J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007J\b\u0010!\u001a\u00020 H\u0007J\u0014\u0010%\u001a\u00020$2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\n\u0010'\u001a\u0004\u0018\u00010&H\u0007J\n\u0010)\u001a\u0004\u0018\u00010(H\u0007R\u0014\u0010*\u001a\u00020\"8\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010+R*\u0010\u0007\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00068\u0006@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010-\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R(\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u0003\u00102\u0012\u0004\b7\u00101\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u00108R&\u0010;\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00010:098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?¨\u0006A"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/BDLiveSdk;", "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "sdkConfig", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "appInfo", "", "async", "", "initialize", "doInitTask", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "cls", "inst", "addFeature", "(Ljava/lang/Class;Ljava/lang/Object;)V", "getFeature", "(Ljava/lang/Class;)Ljava/lang/Object;", "getImp", "Lcom/bytedance/android/live/saas/middleware/applog/IAppLog;", "appLog", "Lcom/bytedance/android/live/saas/middleware/alog/ILogProtocol;", "getALog", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "getMonitor", "Lcom/bytedance/android/live/saas/middleware/sec/ISecSdk;", "getSec", "Lcom/bytedance/android/dy/saas/utuid/d;", "getUtUid", "Lcom/bytedance/android/live/saas/middleware/store/IFileUtils;", "fileUtils", "", "tableName", "Lcom/bytedance/android/live/saas/middleware/store/IMiddlewareSharedPref;", CloudControlInf.SP, "Lry/e;", "getHostPermission", "Lcom/bytedance/android/live/saas/middleware/npth/INpthHelper;", "getNpthHelper", "TAG", "Ljava/lang/String;", "<set-?>", "Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "getAppInfo", "()Lcom/bytedance/android/live/saas/middleware/IAppInfo;", "getAppInfo$annotations", "()V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getContext$annotations", "Lcom/bytedance/android/live/saas/middleware/BDLiveSdkConfig;", "", "Lcom/bytedance/android/live/saas/middleware/base/BaseFunction;", "functionList", "Ljava/util/List;", "", "extFeatureMap", "Ljava/util/Map;", "<init>", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class BDLiveSdk {
    public static final BDLiveSdk INSTANCE = null;
    public static final String TAG = "BDLiveSdk";
    private static IAppInfo appInfo;
    public static Context context;
    private static Map<Object, Object> extFeatureMap;
    private static List<BaseFunction<?, Object>> functionList;
    private static BDLiveSdkConfig sdkConfig;

    private BDLiveSdk() {
    }

    @JvmStatic
    public static /* synthetic */ void getAppInfo$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getContext$annotations() {
    }

    @JvmStatic
    public static final IMiddlewareSharedPref sp() {
        return sp$default(null, 1, null);
    }

    static {
        INSTANCE = new BDLiveSdk();
        appInfo = IAppInfo.Companion.getSTUB();
        sdkConfig = BDLiveSdkConfig.Companion.getSTUB();
        functionList = new ArrayList();
        extFeatureMap = new LinkedHashMap();
    }

    @JvmStatic
    public static final IAppLog appLog() {
        return (IAppLog) sdkConfig.getFunctionImp(IAppLog.class);
    }

    @JvmStatic
    public static final void doInitTask() {
        Iterator<T> r100 = functionList.iterator();
    L4:
        if (r100.hasNext() == false) goto L18;
        BaseFunction r101 = (BaseFunction) r100.next();
        ISdkInitTask r102 = r101.getTask();
        if (r102 == null) goto L4;
        r101.getMParams();
        Context r103 = context;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L10:
        if (r103 == null) goto L17;
        Application r104 = (Application) r103;
        Object r105 = r101.getMParams();
        if (r105 == null) goto L15;
        r102.init(r104, r105);
        goto L4
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    @JvmStatic
    public static final ILogProtocol getALog() {
        return (ILogProtocol) sdkConfig.getFunctionImp(ILogProtocol.class);
    }

    public static final Context getContext() {
        Context r100 = context;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    @JvmStatic
    public static final e getHostPermission() {
        return sdkConfig.getHostPermission();
    }

    @JvmStatic
    public static final IMonitorReport getMonitor() {
        return (IMonitorReport) sdkConfig.getFunctionImp(IMonitorReport.class);
    }

    @JvmStatic
    public static final INpthHelper getNpthHelper() {
        return (INpthHelper) sdkConfig.getFunctionImp(INpthHelper.class);
    }

    @JvmStatic
    public static final ISecSdk getSec() {
        return (ISecSdk) sdkConfig.getFunctionImp(ISecSdk.class);
    }

    @JvmStatic
    public static final d getUtUid() {
        return (d) sdkConfig.getFunctionImp(d.class);
    }

    @JvmStatic
    public static final IFileUtils fileUtils() {
        return StoreManager.INSTANCE;
    }

    public static final IAppInfo getAppInfo() {
        return appInfo;
    }

    @JvmStatic
    public static final <T> T getFeature(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        T r101 = (T) extFeatureMap.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101;
    }

    @JvmStatic
    public static final <T> T getImp(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return (T) sdkConfig.getFunctionImp(r100);
    }

    public static final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        context = r100;
    }

    @JvmStatic
    public static final IMiddlewareSharedPref sp(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return SPHelper.Companion.getDefaultSpHelper();
    L12:
        return new SPHelper(r100);
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    @JvmStatic
    public static final <T> void addFeature(Class<T> r100, T r101) {
        if (r101 == null) goto L6;
        if (r100 == null) goto L7;
        extFeatureMap.put(r100, r101);
        return;
    L7:
        return;
    }

    public static /* synthetic */ IMiddlewareSharedPref sp$default(String r100, int r101, Object r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        return sp(r100);
    }

    @JvmStatic
    public static final void initialize(Context r100, BDLiveSdkConfig r101, IAppInfo r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sdkConfig");
        Intrinsics.checkNotNullParameter(r102, "appInfo");
        context = r100;
        appInfo = r102;
        sdkConfig = r101;
        boolean r104 = a.f537610a;
        a.f537610a = r101.getDisableBroadcast();
        Console.init(r102.isDebug());
        Iterator<T> r105 = r101.getMTaskList().iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        BaseFunction<?, Object> r106 = (BaseFunction) r105.next();
        List<BaseFunction<?, Object>> r107 = functionList;
        if (r106 == null) goto L9;
        r107.add(r106);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.saas.middleware.base.BaseFunction<*, kotlin.Any>");
    }

    public static /* synthetic */ void initialize$default(Context r100, BDLiveSdkConfig r101, IAppInfo r102, boolean r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = false;
    L5:
        initialize(r100, r101, r102, r103);
    }
}
