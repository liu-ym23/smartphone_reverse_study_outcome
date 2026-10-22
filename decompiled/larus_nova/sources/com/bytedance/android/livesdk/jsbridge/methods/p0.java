package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "endLiveLocationModule")
public final class p0 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/p0$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.value;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", value=" + this.value + ")";
        }

        public final String a() {
            return this.value;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public p0() {
    }

    public static JSONObject j(Context r100, boolean r101) {
        Integer r102 = com.bytedance.android.live.browser.c0.f62590b.getValue();
        if (r102 != null) goto L6;
    L8:
        String r103 = "close";
    L10:
        if (m60.c.d(r100, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L12;
    L15:
        int r104 = 1;
    L17:
        return new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("show", Integer.valueOf(r101 ? 1 : 0)), TuplesKt.to("isAuthorization", Integer.valueOf(r104)), TuplesKt.to("status", r103)}));
    L12:
        if (m60.c.d(r100, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}) == true) goto L15;
        r104 = 0;
        goto L17
    L6:
        if (r102.intValue() != 1) goto L8;
        r103 = "open";
        goto L10
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        String r104 = r102.a();
        int r105 = r103.hashCode();
        boolean r106 = false;
        if (r105 == 102230) goto L22;
        if (r105 != 113762) goto L55;
        if (r103.equals("set") == false) goto L55;
        Context r107 = r101.getContext();
        com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = com.bytedance.android.live.browser.c0.f62590b;
        int r109 = r104.hashCode();
        if (r109 == 3417674) goto L16;
        if (r109 != 94756344) goto L20;
        if (r104.equals("close") == false) goto L20;
        int r110 = 0;
    L18:
        r108.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r108, r110);
        com.bytedance.android.livesdk.sharedpref.e<Integer> r111 = com.bytedance.android.live.browser.c0.f62589a;
        r111.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r111, 0);
        finishWithResult(j(r107, Intrinsics.areEqual(r104, "open")));
        return;
    L20:
        throw new IllegalArgumentException("Invalid parameter - value");
    L16:
        if (r104.equals("open") == false) goto L20;
        r110 = 1;
    L55:
        throw new IllegalArgumentException("Invalid parameter - type");
    L22:
        if (r103.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L55;
        Context r112 = r101.getContext();
        IMiddlewareUserService r113 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r113 == null) goto L28;
        com.bytedance.android.livesdk.user.e r114 = r113.user();
        if (r114 == null) goto L28;
        IBaseUser r115 = r114.b();
    L29:
        IMiddlewareUserService r116 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r116 == null) goto L40;
        com.bytedance.android.livesdk.user.e r117 = r116.user();
        if (r117 == null) goto L40;
        if (r117.H() != true) goto L40;
        boolean r118 = tb1.c.f545229a;
        if (r115 == null) goto L40;
        if (r115.getSecret() != 1) goto L40;
        boolean r119 = false;
    L41:
        boolean r120 = tb1.c.f545229a;
        Integer r121 = com.bytedance.android.live.browser.c0.f62590b.getValue();
        if (r121 == null) goto L47;
        if (r121.intValue() != 1) goto L47;
    L52:
        finishWithResult(j(r112, r106));
        com.bytedance.android.livesdk.sharedpref.e<Integer> r122 = com.bytedance.android.live.browser.c0.f62589a;
        com.bytedance.android.livesdk.sharedpref.f.d(r122, Integer.valueOf(r122.getValue().intValue() + 1));
        return;
    L47:
        if (com.bytedance.android.live.browser.c0.f62591c.getValue().booleanValue() == true) goto L52;
        if (com.bytedance.android.live.browser.c0.f62589a.getValue().intValue() > 3) goto L52;
        r106 = r119;
    L40:
        r119 = true;
    L28:
        r115 = null;
        goto L29
    }
}
