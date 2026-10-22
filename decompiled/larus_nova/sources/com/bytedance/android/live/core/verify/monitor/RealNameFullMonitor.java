package com.bytedance.android.live.core.verify.monitor;

import android.app.Activity;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.verify.responbean.CertificationQuery;
import com.bytedance.android.live.user.IUserService;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public final class RealNameFullMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f66487a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/verify/monitor/RealNameFullMonitor$AlipayCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", EffectConstants.NORMAL, "DOWNGRADE", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AlipayCategory extends Enum<AlipayCategory> {
        public static final AlipayCategory DOWNGRADE = null;
        public static final AlipayCategory NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AlipayCategory[] f66488a = null;
        private final String value;

        static {
            AlipayCategory r100 = new AlipayCategory(EffectConstants.NORMAL, 0, "normal");
            NORMAL = r100;
            AlipayCategory r101 = new AlipayCategory("DOWNGRADE", 1, GearStrategyConsts.EV_DOWNGRADE_TYPE);
            DOWNGRADE = r101;
            f66488a = new AlipayCategory[]{r100, r101};
        }

        public static AlipayCategory valueOf(String r100) {
            return (AlipayCategory) a.a(AlipayCategory.class, r100);
        }

        public static AlipayCategory[] values() {
            return (AlipayCategory[]) f66488a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public AlipayCategory(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/verify/monitor/RealNameFullMonitor$CertCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ZIYAN", "ALIPAY", "ALIYUN", FlowDoraWifiScene.OTHER, "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CertCategory extends Enum<CertCategory> {
        public static final CertCategory ALIPAY = null;
        public static final CertCategory ALIYUN = null;
        public static final CertCategory OTHER = null;
        public static final CertCategory ZIYAN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CertCategory[] f66489a = null;
        private final String value;

        static {
            CertCategory r100 = new CertCategory("ZIYAN", 0, "ziyan");
            ZIYAN = r100;
            CertCategory r101 = new CertCategory("ALIPAY", 1, "zhima");
            ALIPAY = r101;
            CertCategory r102 = new CertCategory("ALIYUN", 2, EventConstant.Value.ALIYUN);
            ALIYUN = r102;
            CertCategory r103 = new CertCategory(FlowDoraWifiScene.OTHER, 3, "other");
            OTHER = r103;
            f66489a = new CertCategory[]{r100, r101, r102, r103};
        }

        public static CertCategory valueOf(String r100) {
            return (CertCategory) a.a(CertCategory.class, r100);
        }

        public static CertCategory[] values() {
            return (CertCategory[]) f66489a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public CertCategory(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }

    public static JSONObject a(JSONObject r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        r102.put("request", r100);
        r102.put("response", r101);
        return r102;
    }

    @JvmStatic
    public static final void d(int r100, String r101) {
        e("ttlive_cert_minor_intercept", r100, r101, new JSONObject());
    }

    public static void e(String r100, int r101, String r102, JSONObject r110) {
        if (c.a() == false) goto L16;
        int r103 = e.f64997m;
        e.a r104 = e.b.a(r100, LiveTracingMonitor.EventModule.REAL_NAME.getName());
        r104.f65012c = "webcast_client_community";
        r104.f65017h = Integer.valueOf(r101);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(((IUserService) k.n(IUserService.class)).user().n());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r106) == false) goto L12;
        r106 = "";
    L12:
        r104.f65016g = (String) r106;
        e r107 = r104.a();
        JSONObject r108 = new JSONObject();
        if (r102 == null) goto L15;
        r108.put("category_1", r102);
    L15:
        r108.put("status_code", r101);
        Intrinsics.checkNotNullParameter(r107, "traceMeta");
        TraceMonitor.i(r107, r108, null, r110);
        return;
    L7:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L16:
        r110.put("status_code", String.valueOf(r101));
        LiveTracingMonitor.EventModule r111 = LiveTracingMonitor.EventModule.REAL_NAME;
        JSONObject r112 = new JSONObject();
        r112.put("status_code", r101);     // Catch: JSONException -> L19
    L20:
        if (r102 != null) goto L25;
    L22:
        LiveMonitor r113 = new LiveMonitor();
        r113.mCategory = r112;
        r113.mEventModule = r111;
        r113.mServiceName = r100;
        r113.mExtraLog = r110;
        r113.mMetrics = null;
        LiveMonitor.access$002(r113, false);
        LiveMonitor.access$102(r113, false);
        LiveMonitor.access$202(r113, true);
        LiveMonitor.access$302(r113, false);
        LiveMonitor.access$402(r113, false);
        r113.report();
        return;
    L25:
        r112.put("category_1", r102);     // Catch: JSONException -> L24
        goto L22
    }

    @JvmStatic
    public static final void f(int r100, Activity r101, String r102, w80.a r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.put("activity", r101);
        r105.put("enterFrom", r102);
        JSONObject r106 = new JSONObject();
        if (r103 == null) goto L5;
        r106.put("certType", r103.certType);
        r106.put("message", r103.message);
        r106.put("statusCode", r103.statusCode);
        r106.put("url", r103.url);
        r106.put("transactionId", r103.transactionId);
        r106.put("merchantId", r103.merchantId);
        r106.put("msg", r104);
    L5:
        e("ttlive_cert_server_common_submit", r100, null, a(r105, r106));
    }

    @JvmStatic
    public static final void b(String r100, boolean r101, boolean r102, int r103, String r104, int r105, w80.a r106) {
        JSONObject r107 = new JSONObject();
        r107.put("enterFrom", r100);
        r107.put("alipayType", r105);
        if (r106 == null) goto L5;
        Integer r108 = Integer.valueOf(r106.certType);
    L6:
        r107.put("certType", r108);
        JSONObject r109 = new JSONObject();
        r109.put("statusCode", r103);
        r109.put("msg", r104);
        if (r101 == false) goto L9;
        r103 = 0;
    L9:
        if (r105 != 0) goto L11;
        JSONObject r110 = a(r107, r109);
        if (r102 == false) goto L17;
        String r111 = AlipayCategory.DOWNGRADE.getValue();
    L18:
        e("ttlive_cert_alipay_sdk_app", r103, r111, r110);
        return;
    L17:
        r111 = AlipayCategory.NORMAL.getValue();
        goto L18
    L11:
        if (r105 != 3) goto L21;
        e("ttlive_cert_aliyun_face", r103, null, a(r107, r109));
        return;
    L21:
        return;
    L5:
        r108 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(boolean r100, int r101, int r102, boolean r103, Activity r104, CertificationQuery r105, String r106) {
        if (r102 == 3) goto L5;
        String r107 = CertCategory.OTHER.getValue();
    L6:
        JSONObject r108 = new JSONObject();
        if (r104 == null) goto L9;
        String r109 = r104.toString();
    L10:
        r108.put("activity", r109);
        r108.put("isSkipRecordVerify", r103);
        JSONObject r110 = new JSONObject();
        if (r105 == null) goto L13;
        r110.put("result", r105.toString());
        r110.put("msg", r106);
    L13:
        if (r100 == false) goto L15;
        e("ttlive_cert_server_query", r101, r107, a(r108, r110));
        return;
    L15:
        e("ttlive_cert_server_common_query", r101, null, a(r108, r110));
        return;
    L9:
        r109 = null;
        goto L10
    L5:
        r107 = CertCategory.ALIYUN.getValue();
        goto L6
    }
}
