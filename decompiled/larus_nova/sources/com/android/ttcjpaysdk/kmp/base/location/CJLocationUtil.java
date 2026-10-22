package com.android.ttcjpaysdk.kmp.base.location;

import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/location/CJLocationUtil;", "", "<init>", "()V", "TAG", "", "startLocationSubscription", "", "getLatestLocationInfoJson", "registerLocationCallback", "callback", "Lcom/android/ttcjpaysdk/kmp/base/location/IKmpCJLocationServiceCallback;", "unregisterLocationCallback", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJLocationUtil {
    public static final int $stable = 0;
    public static final CJLocationUtil INSTANCE = null;
    private static final String TAG = "CJLocationUtil";

    static {
        INSTANCE = new CJLocationUtil();
    }

    private CJLocationUtil() {
    }

    public final String getLatestLocationInfoJson() {
        b r100 = c.f528682a;
        IKmpCJLocationService r101 = (IKmpCJLocationService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLocationService.class));
        if (r101 != null) goto L6;
        CJLogger.INSTANCE.i(TAG, "getLatestLocationInfoJson fallback: IKmpCJLocationService is null");
        return "";
    L6:
        String r102 = r101.getLatestLocationInfoJson();
        CJLogger.INSTANCE.i(TAG, "getLatestLocationInfoJson success: serviceHash=" + r101.hashCode() + ", infoLength=" + r102.length());
        return r102;
    }

    public final void startLocationSubscription() {
        b r100 = c.f528682a;
        IKmpCJLocationService r101 = (IKmpCJLocationService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLocationService.class));
        if (r101 != null) goto L6;
        CJLogger.INSTANCE.i(TAG, "startLocationSubscription skip: IKmpCJLocationService is null");
        return;
    L6:
        CJLogger r102 = CJLogger.INSTANCE;
        r102.i(TAG, "startLocationSubscription invoke: serviceHash=" + r101.hashCode());
        r101.startLocationSubscription();
        r102.i(TAG, "startLocationSubscription invoked");
    }

    public final void registerLocationCallback(IKmpCJLocationServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJLocationService r102 = (IKmpCJLocationService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLocationService.class));
        if (r102 != null) goto L6;
        CJLogger.INSTANCE.i(TAG, "registerLocationCallback skip: IKmpCJLocationService is null, callbackHash=" + r100.hashCode());
        return;
    L6:
        CJLogger r103 = CJLogger.INSTANCE;
        r103.i(TAG, "registerLocationCallback invoke: serviceHash=" + r102.hashCode() + ", callbackHash=" + r100.hashCode());
        r102.registerLocationCallback(r100, String.valueOf(r100.hashCode()));
        StringBuilder r104 = new StringBuilder("registerLocationCallback invoked: callbackHash=");
        r104.append(r100.hashCode());
        r103.i(TAG, r104.toString());
    }

    public final void unregisterLocationCallback(IKmpCJLocationServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        b r101 = c.f528682a;
        IKmpCJLocationService r102 = (IKmpCJLocationService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJLocationService.class));
        if (r102 != null) goto L6;
        CJLogger.INSTANCE.i(TAG, "unregisterLocationCallback skip: IKmpCJLocationService is null, callbackHash=" + r100.hashCode());
        return;
    L6:
        CJLogger r103 = CJLogger.INSTANCE;
        r103.i(TAG, "unregisterLocationCallback invoke: serviceHash=" + r102.hashCode() + ", callbackHash=" + r100.hashCode());
        r102.unregisterLocationCallback(r100, String.valueOf(r100.hashCode()));
        StringBuilder r104 = new StringBuilder("unregisterLocationCallback invoked: callbackHash=");
        r104.append(r100.hashCode());
        r103.i(TAG, r104.toString());
    }
}
