package com.bytedance.android.btm.api.provider;

import android.app.Application;
import com.bytedance.android.btm.api.i;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import zc.a;
import zc.b;
import zc.c;
import zc.d;
import zc.e;
import zc.f;
import zc.g;
import zc.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\r\u001a\u0004\u0018\u00010\tH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\tH&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH&J\b\u0010\u001f\u001a\u00020\u0002H&J\b\u0010 \u001a\u00020\u0002H&J\b\u0010!\u001a\u00020\u0002H&J\b\u0010\"\u001a\u00020\u001bH&J\b\u0010#\u001a\u00020\u001bH&J\b\u0010%\u001a\u00020$H&J\b\u0010&\u001a\u00020\u001bH&JO\u0010.\u001aI\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0001\u0018\u00010'H&J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0/H&J\b\u00101\u001a\u00020\u001bH&J\u0010\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102H&J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u000102H&J\b\u00106\u001a\u00020\u0002H&¨\u00067"}, d2 = {"Lcom/bytedance/android/btm/api/provider/IBtmDefaultConfig;", "", "", "isLazyOpt", "Landroid/app/Application;", "getApplication", "getDebug", "Lzc/c;", "getAppLogDepend", "Lzc/h;", "getSettingDepend", "Lzc/d;", "getDefaultSettingDepend", "getSchemaSettingDepend", "getLocalTestSettingDepend", "Lzc/f;", "getLogDepend", "getClientDataTrackerConfig", "Lzc/a;", "getALogDepend", "Lzc/g;", "getMonitorDepend", "Lzc/e;", "getExecutorDepend", "Lzc/b;", "getAppLaunchDepend", "", "", "getAppIds", "()[Ljava/lang/String;", "getDefaultA", "getHasLancet", "getEnableDebugCrash", "getEnableBtmPageAnnotation", "getDeviceId", "getVersionName", "", "getAppId", "getUpdateVersionCode", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "start", "end", "label", "getUploadALog", "", "getShareNodeCD", "getColdStartBPage", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/android/btm/api/i;", "getHybridContainers", "getUnknownWhiteSet", "shouldDowngrade", "btm-api_cnRelease"}, k = 1, mv = {1, 4, 0})
public interface IBtmDefaultConfig {
    a getALogDepend();

    int getAppId();

    String[] getAppIds();

    b getAppLaunchDepend();

    c getAppLogDepend();

    Application getApplication();

    h getClientDataTrackerConfig();

    String getColdStartBPage();

    boolean getDebug();

    String getDefaultA();

    d getDefaultSettingDepend();

    String getDeviceId();

    boolean getEnableBtmPageAnnotation();

    boolean getEnableDebugCrash();

    e getExecutorDepend();

    boolean getHasLancet();

    CopyOnWriteArraySet<i> getHybridContainers();

    h getLocalTestSettingDepend();

    f getLogDepend();

    g getMonitorDepend();

    h getSchemaSettingDepend();

    h getSettingDepend();

    Map<String, String> getShareNodeCD();

    CopyOnWriteArraySet<String> getUnknownWhiteSet();

    String getUpdateVersionCode();

    Function3<Long, Long, String, Object> getUploadALog();

    String getVersionName();

    boolean isLazyOpt();

    boolean shouldDowngrade();
}
