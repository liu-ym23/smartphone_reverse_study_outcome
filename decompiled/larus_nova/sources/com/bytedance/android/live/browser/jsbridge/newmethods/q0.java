package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "authorization")
public final class q0 extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f63610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f63611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TokenCert f63612c;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/newmethods/q0$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "args", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "token", "b", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("args")
        private final Map<String, String> args;

        @SerializedName("token")
        private final String token;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.args, r101.args) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<String, String> r104 = this.args;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.token;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", args=" + this.args + ", token=" + this.token + ")";
        }

        public final Map<String, String> a() {
            return this.args;
        }

        public final String b() {
            return this.token;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public q0() {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        List<String> r100 = CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
    L6:
        this.f63610a = r100;
        this.f63611b = MapsKt.mapOf(new Pair[]{TuplesKt.to("location", CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})), TuplesKt.to("writeStorage", r100)});
        this.f63612c = TokenCert.Companion.with("bpea-live_authPermissionMethod_jsb_get_location_or_write_storage_permission");
        return;
    L5:
        r100 = CollectionsKt.emptyList();
        goto L6
    }

    public static JSONObject j(boolean r100) {
        return new JSONObject(MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("isAuthorization", Integer.valueOf(r100 ? 1 : 0))}));
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r103 = this.f63611b.get(r102.getType());
        if (r103 == null) goto L30;
        String r104 = r102.a().get(com.alipay.sdk.m.p.e.f25671s);
        String r105 = r102.a().get("value");
        String r106 = r102.b();
        if (r106 != null) goto L7;
    L9:
        if (r104 == null) goto L28;
        int r107 = r104.hashCode();
        if (r107 == 102230) goto L24;
        if (r107 != 113762) goto L28;
        if (r104.equals("set") == false) goto L28;
        if (Intrinsics.areEqual(r105, "open") == false) goto L31;
        TokenCert r108 = this.f63612c;
        Context r109 = r101.getContext();
        if (r109 == null) goto L22;
        SettingKey<Boolean> r110 = m60.i.f512260a;
        new m60.i.b((Activity) r109).a(new r0(this, r101, r103), r108, r103);
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L31:
        return;
    L24:
        if (r104.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L28;
        finishWithResult(j(m60.c.c(r101.getContext(), r103)));
        return;
    L28:
        throw new IllegalArgumentException("Unsupported permission operation");
    L7:
        if (StringsKt.isBlank(r106) == true) goto L9;
        this.f63612c = TokenCert.Companion.with(r106);
        goto L9
    L30:
        throw new IllegalArgumentException("Unsupported permission type");
    }
}
