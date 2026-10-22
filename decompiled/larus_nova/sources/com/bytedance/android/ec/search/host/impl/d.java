package com.bytedance.android.ec.search.host.impl;

import android.app.Activity;
import android.content.Context;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ITradeSearchHostAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f48171a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48172b = null;

    public d() {
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final long getAppLaunchTime() {
        return 0;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final Long getServerTime() {
        return null;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isAppInBackground() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isAweme() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isGuestMode() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isLargeFontMode() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isLegou() {
        return false;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isSaas() {
        return true;
    }

    static {
        f48171a = new d();
        f48172b = LazyKt.lazy(new c());
    }

    public static vi.a a() {
        return (vi.a) f48172b.getValue();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getGeckoOnlineKey() {
        pg9.g.f529217a.getClass();
        return "a631f961d63a20c50b08b35916af51c3";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getGeckoTestKey() {
        pg9.g.f529217a.getClass();
        return "f7dfc1e8653a5c7d2ba0923e84cd9416";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getAppId() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppId();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getAppVersionName() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppVersionName();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final Context getApplicationContext() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getApplicationContext();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getBussinessVersionName() {
        vi.a r100 = a();
        if (r100 == null) goto L6;
        String r101 = r100.getBussinessVersionName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final Activity getCurrentActivity() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentActivity();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final Float getCurrentFontScale() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentFontScale();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getServerDeviceId() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getServerDeviceId();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final String getUpdateVersionCode() {
        vi.a r100 = a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUpdateVersionCode();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isDebug() {
        vi.a r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDebug() != true) goto L7;
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isInHouse() {
        return isLocalTest();
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isLocalTest() {
        vi.a r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isLocalTest() != true) goto L7;
        return true;
    }

    @Override // com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo
    public final boolean isNightMode() {
        vi.a r100 = a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isNightMode() != true) goto L7;
        return true;
    }
}
