package com.bytedance.android.livesdk.livecommerce.room.utils;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveRoomRedirectInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f151919e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f151920f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f151921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f151922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveRoomRedirectPriority f151923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f151924d;

    public static final class a {
        public a() {
        }

        public static Map a(String r100) {
            ECLiveABUtils r101 = ECLiveABUtils.INSTANCE;
            if (r101.getECOM_LIVE_ROUTE_NEW() == true) goto L18;
            if (r100 == null) goto L33;
            int r102 = r100.hashCode();
            if (r102 == 939723428) goto L15;
            if (r102 == 1265592045) goto L12;
            return null;
        L12:
            if (r100.equals("ecom_live_route_rule_heat") == true) goto L31;
            return null;
        L31:
            return r101.getECOM_LIVE_ROUTE_RULE_HEAT();
        L15:
            if (r100.equals("ecom_live_route_rule_normal") == true) goto L17;
            return null;
        L17:
            return r101.getECOM_LIVE_ROUTE_RULE_NORMAL();
        L33:
            return null;
        L18:
            if (r100 != null) goto L20;
        L29:
            return null;
        L20:
            if (r100.length() <= 0) goto L22;
            boolean r103 = true;
        L23:
            if (r103 == false) goto L29;
            Lazy r104 = LiveRoomRedirectInfo.f151919e;
            if (((ConcurrentHashMap) r104.getValue()).contains(r100) == true) goto L28;
            ((ConcurrentHashMap) r104.getValue()).put(r100, EComABUtils.getLiveSettingValue(r100, new LinkedHashMap()));
        L28:
            return (Map) ((ConcurrentHashMap) r104.getValue()).get(r100);
        L22:
            r103 = false;
            goto L23
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveRoomRedirectInfo) == false) goto L14;
        LiveRoomRedirectInfo r101 = (LiveRoomRedirectInfo) r100;
        if (Intrinsics.areEqual(this.f151921a, r101.f151921a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151922b, r101.f151922b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f151923c, r101.f151923c) == true) goto L12;
        return false;
    L12:
        if (this.f151924d == r101.f151924d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f151921a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f151922b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        LiveRoomRedirectPriority r107 = this.f151923c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f151924d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRoomRedirectInfo(routeRule=" + this.f151921a + ", route=" + this.f151922b + ", priority=" + this.f151923c + ", logicalClock=" + this.f151924d + ")";
    }

    static {
        f151920f = new a();
        f151919e = LazyKt.lazy(LiveRoomRedirectInfo$Companion$routeRuleMap$2.INSTANCE);
    }

    public LiveRoomRedirectInfo(String r100, Map<String, String> r101, LiveRoomRedirectPriority r102, long r103) {
        Intrinsics.checkNotNullParameter(r101, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r102, "priority");
        this.f151921a = r100;
        this.f151922b = r101;
        this.f151923c = r102;
        this.f151924d = r103;
    }
}
