package com.bytedance.android.live.core.verify.utils;

import am2.x;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.v1;
import com.bytedance.android.live.core.verify.api.ZhimaVerifyApi;
import com.bytedance.android.live.core.verify.monitor.RealNameFullMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livehostapi.business.IHostAliYunVerifyProxy;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostOCRPreloadApiProxy;
import com.bytedance.android.livehostapi.business.depend.IHostReady;
import com.bytedance.android.livehostapi.business.depend.OnVerifyPluginPreloadListener;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.model.n;
import com.bytedance.android.livesdk.widget.e1;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.JsonObject;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.Observable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.live.core.verify.utils.a$a, reason: collision with other inner class name */
    public class C1099a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f66499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w80.a f66500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f66501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f66502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f66503e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g f66504f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ f f66505g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f66506h;

        public C1099a(Activity r100, w80.a r101, String r102, Bundle r103, String r104, g r105, f r106, boolean r107) {
            this.f66499a = r100;
            this.f66500b = r101;
            this.f66501c = r102;
            this.f66502d = r103;
            this.f66503e = r104;
            this.f66504f = r105;
            this.f66505g = r106;
            this.f66506h = r107;
        }
    }

    public class b implements OnVerifyPluginPreloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f66507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w80.a f66508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f66509c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f66510d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f66511e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f66512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f66513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ g f66514h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ f f66515i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ boolean f66516j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ boolean f66517k;

        @Override // com.bytedance.android.livehostapi.business.depend.OnVerifyPluginPreloadListener
        public final void finish(boolean r110) {
            a.q(this.f66507a, this.f66508b, this.f66509c, this.f66510d, this.f66511e, this.f66512f, this.f66513g, this.f66514h, this.f66515i, this.f66516j, this.f66517k);
        }

        public b(Activity r100, w80.a r101, String r102, Bundle r103, int r104, String r105, boolean r106, g r107, f r108, boolean r110, boolean r111) {
            this.f66507a = r100;
            this.f66508b = r101;
            this.f66509c = r102;
            this.f66510d = r103;
            this.f66511e = r104;
            this.f66512f = r105;
            this.f66513g = r106;
            this.f66514h = r107;
            this.f66515i = r108;
            this.f66516j = r110;
            this.f66517k = r111;
        }
    }

    public class c implements OnVerifyPluginPreloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f66518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f66519b;

        @Override // com.bytedance.android.livehostapi.business.depend.OnVerifyPluginPreloadListener
        public final void finish(boolean r100) {
            if (r100 == false) goto L4;
            this.f66518a.a(this.f66519b);
            return;
        L4:
            this.f66518a.a("zhima_app");
        }

        public c(d r100, String r101) {
            this.f66518a = r100;
            this.f66519b = r101;
        }
    }

    public interface d {
        void a(String r100);
    }

    public interface e {
    }

    public interface f {
        Observable<Response<w80.a>> a(Map<String, String> r100);
    }

    public interface g {
        void onVerify(boolean r100, Map<String, Object> r101);
    }

    public static String h(int r100) {
        if (r100 != 0) goto L5;
        return EventConstant.Value.ZHIFUBAO;
    L5:
        if (r100 != 3) goto L8;
        return EventConstant.Value.ALIYUN;
    L8:
        if (r100 != 2) goto L10;
        return "self";
    L10:
        return "";
    }

    public static String d() {
        ClientABTestKey<String> r100 = com.bytedance.android.live.base.abtest.a.f58806a;
        com.bytedance.android.live.base.abtest.b.f58812b.getClass();
        String r101 = (String) com.bytedance.android.live.base.abtest.b.a.a(r100);
        IHostReady r102 = f();
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L12;
        return "zhima_app";
    L12:
        return r101;
    L5:
        if (r102.isSDKReady() == false) goto L7;
        r103 = true;
        goto L8
    }

    public static IHostReady f() {
        ClientABTestKey<String> r100 = com.bytedance.android.live.base.abtest.a.f58806a;
        com.bytedance.android.live.base.abtest.b.f58812b.getClass();
        String r101 = (String) com.bytedance.android.live.base.abtest.b.a.a(r100);
        if (TextUtils.equals(r101, "self") == false) goto L6;
        return (IHostReady) k.f(IHostOCRApiProxy.class);
    L6:
        if (TextUtils.equals(r101, "ali_cloud") == false) goto L9;
        return (IHostReady) k.f(IHostAliYunVerifyProxy.class);
    L9:
        if (TextUtils.equals(r101, "zhima") == false) goto L11;
        HashMap r102 = new HashMap();
        r102.put("face_identify", r101);
        u.l().sendLog("livesdk_zhima_sdk_wrong", r102, new Object[0]);
    L11:
        return null;
    }

    public static boolean j() {
        IHostAliYunVerifyProxy r100 = (IHostAliYunVerifyProxy) k.f(IHostAliYunVerifyProxy.class);
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isSDKReady() == false) goto L8;
        return false;
    }

    public static int g() {
        String r100 = d();
        r100.getClass();
        if (r100.equals("self") == false) goto L5;
        return 2;
    L5:
        if (r100.equals("ali_cloud") == true) goto L7;
        return 0;
    L7:
        return 3;
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static boolean i(Activity r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        PackageManager r101 = r100.getPackageManager();
        Intent r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse("alipays://"));
        List<ResolveInfo> r103 = r101.queryIntentActivities(r102, 64);
        if (r103 != null) goto L8;
        return true;
    L8:
        if (r103.size() == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public static Map<String, String> c(Context r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("certify_type", "0");
        r102.put(CJDyPayResult.EXT_K_RETURN_URL, AppConstants.SCHEME_SNSSDK + ((IHostContext) k.f(IHostContext.class)).appId() + "://");
        if (r101 == 2) goto L7;
        if (r101 == 3) goto L6;
        String r103 = "alipay";
    L8:
        r102.put(BytedCertConstant.CertKey.VERIFY_CHANNEL, r103);
        if (r100 == null) goto L16;
        if (r101 != 3) goto L16;
        if (j() == true) goto L16;
        String r104 = ((IHostAliYunVerifyProxy) k.f(IHostAliYunVerifyProxy.class)).getMetaInfos(r100);
        if (r104 == null) goto L16;
    L17:
        r102.put("meta_info", r104);
        if (r101 != 0) goto L20;
    L21:
        r102.put("zhima_type", String.valueOf(r101));
    L22:
        return r102;
    L20:
        if (r101 != 1) goto L22;
    L16:
        r104 = "";
        goto L17
    L6:
        r103 = "alicloud";
        goto L8
    L7:
        r103 = "byte";
        goto L8
    }

    public static void e(Context r100, boolean r101, d r102) {
        ClientABTestKey<String> r103 = com.bytedance.android.live.base.abtest.a.f58806a;
        com.bytedance.android.live.base.abtest.b.f58812b.getClass();
        String r104 = (String) com.bytedance.android.live.base.abtest.b.a.a(r103);
        IHostReady r105 = f();
        if (r105 != null) goto L7;
        r102.a("zhima_app");
        return;
    L7:
        if (r105.isSDKReady() == false) goto L10;
        r102.a(r104);
        return;
    L10:
        r105.tryPreload(r100, r101, new c(r102, r104));
    }

    public static void l(String r100, Bundle r101, int r102, int r103) {
        String r104 = String.valueOf(r103);
        HashMap r105 = new HashMap();
        if (r101 == null) goto L8;
        Iterator<String> r106 = r101.keySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        String r107 = r106.next();
        r105.put(r107, r101.getString(r107, ""));
    L8:
        r105.put("enter_from", r100);
        if (TextUtils.isEmpty((CharSequence) r105.get("verify_type")) == false) goto L11;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForVerifiedSdkStart verify_type is null ");
        r105.put("verify_type", "realname");
    L11:
        r105.put("verified_confirm_page_source", h(r102));
        r105.put("cert_type", r104);
        u.l().sendLog("livesdk_verified_sdk_start", r105, new Object[0]);
    }

    public static void m(String r100, Bundle r101, String r102, int r103, int r104) {
        HashMap r105 = new HashMap();
        String r106 = "";
        if (r101 == null) goto L8;
        Iterator<String> r107 = r101.keySet().iterator();
    L6:
        if (r107.hasNext() == false) goto L8;
        String r108 = r107.next();
        r105.put(r108, r101.getString(r108, ""));
    L8:
        r105.put("result", r102);
        r105.put("enter_from", r100);
        if (TextUtils.isEmpty((CharSequence) r105.get("verify_type")) == false) goto L11;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logQueryResult verify_type is null ");
        r105.put("verify_type", "realname");
    L11:
        if (r103 != 0) goto L13;
        r106 = "app";
    L13:
        r105.put("zhifubao_type", r106);
        r105.put("verified_confirm_page_source", h(r103));
        r105.put("cert_type", String.valueOf(r104));
        if (PbRequest.SwitchType.RECHARGE.equals(r100) == false) goto L16;
        u.l().sendLog("livesdk_user_identification_result", r105, new Object[]{x.class, Room.class});
    L16:
        u.l().sendLog("livesdk_zhima_page_confirm", r105, new Object[]{x.class, Room.class});
    }

    public static void k(String r100, Bundle r101, int r102, boolean r103, int r104, String r105) {
        String r106 = String.valueOf(r102);
        HashMap r107 = new HashMap();
        if (r101 == null) goto L8;
        Iterator<String> r108 = r101.keySet().iterator();
    L6:
        if (r108.hasNext() == false) goto L8;
        String r109 = r108.next();
        r107.put(r109, r101.getString(r109, ""));
    L8:
        r107.put("enter_from", r100);
        if (TextUtils.isEmpty((CharSequence) r107.get("verify_type")) == false) goto L12;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForVerifiedSdkStart verify_type is null ");
        r107.put("verify_type", "realname");
    L12:
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r107.put("fail_reason", r105);
    L14:
        if (r103 == false) goto L16;
        String r110 = "success";
    L17:
        r107.put("result", r110);
        r107.put("error_code", String.valueOf(r104));
        r107.put("verified_confirm_page_source", h(3));
        r107.put("cert_type", r106);
        u.l().sendLog("livesdk_verified_sdk_result", r107, new Object[0]);
        return;
    L16:
        r110 = "fail";
        goto L17
    }

    public static void n(final Activity r110, final w80.a r111, final String r112, final Bundle r113, boolean r114, int r210, final g r211, final boolean r212) {
        if (r111 == null) goto L48;
        if (r110 == null) goto L52;
        if (r210 == 0) goto L8;
    L11:
        int r100 = r111.certType;
        HashMap r101 = new HashMap();
        String r115 = "";
        if (r113 == null) goto L17;
        Iterator<String> r102 = r113.keySet().iterator();
    L15:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        r101.put(r103, r113.getString(r103, ""));
    L17:
        r101.put("enter_from", r112);
        if (TextUtils.isEmpty((CharSequence) r101.get("verify_type")) == false) goto L21;
        b0.o().getClass();
        com.bytedance.android.live.core.log.g.c("VerifyUtils", "logForStartVerify verify_type is null ");
        r101.put("verify_type", "realname");
    L21:
        if (r210 == 0) goto L25;
        if (r210 != 3) goto L26;
        r101.put("verified_confirm_page_source", EventConstant.Value.ALIYUN);
    L26:
        r101.put("cert_type", String.valueOf(r100));
        u.l().sendLog("livesdk_zhima_page_start_verified", r101, new Object[]{x.class, Room.class});
        if (r210 == 3) goto L29;
        l(r112, r113, 0, r111.certType);
        QueryResultForAliPayApp r116 = new QueryResultForAliPayApp(r110, r111, r112, r113, r114, r211, r212);
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r115 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(r111.url, "UTF-8");     // Catch: UnsupportedEncodingException -> L37
    L38:
        r104.setData(UriProtector.parse(r115));
        Activity r105 = r116.f66490a;
        if (r105 == null) goto L41;
        r105.startActivity(r104);
    L41:
        r116.f66495f = true;
        com.bytedance.android.tools.superkv.e r106 = r116.f66496g;
        if (r106 == null) goto L51;
        r106.putString("is_verify_processed", GsonProtectorUtils.toJson(GsonHelper.getDefault(), r116.f66493d));
        return;
    L51:
        return;
    L29:
        if (TextUtils.isEmpty(r111.certToken) == false) goto L31;
        return;
    L31:
        if (j() == true) goto L53;
        l(r112, r113, 3, r111.certType);
        ((IHostAliYunVerifyProxy) k.f(IHostAliYunVerifyProxy.class)).verify(r110, r111.certToken, false, new a90.f(r110, r111, r112, r113, r211, r212));
        return;
    L53:
        return;
    L25:
        r101.put("zhifubao_type", "app");
        goto L26
    L8:
        if (i(r110) == false) goto L11;
        HashMap r117 = new HashMap();
        r117.put("status", -1);
        r117.put("msg", "未安装支付宝");
        RealNameFullMonitor.b(r112, false, r114, -1, "未安装支付宝", 0, r111);
        b(r110, r111, r112, r113, r114, r210, r117, r211, r212);
        return;
    L52:
        return;
    }

    public static void p(Activity r110, w80.a r111, String r112, String r113, Bundle r114, g r115, f r210, boolean r211) {
        IHostOCRPreloadApiProxy r100 = (IHostOCRPreloadApiProxy) k.f(IHostOCRPreloadApiProxy.class);
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        e(r110, false, new com.bytedance.android.live.core.verify.utils.b(new C1099a(r110, r111, r112, r114, r113, r115, r210, r211)));
        return;
    L10:
        o(r110, r111, r112, r114, g(), r113, true, r115, r210, false, r211);
        return;
    L5:
        if (r100.supportTryPreload() == false) goto L7;
        r101 = true;
        goto L8
    }

    public static void b(final Activity r110, final w80.a r210, final String r211, final Bundle r212, final boolean r213, final int r214, final Map<String, Object> r215, final g r216, final boolean r217) {
        if (r210 == null) goto L40;
        if (r110 == null) goto L41;
        HashMap r100 = new HashMap();
        r100.put("zhima_token", r210.zhimaToken);
        if (PbRequest.SwitchType.RECHARGE.equals(r211) == false) goto L9;
        r100.put("scene", "1");
    L9:
        r100.put("enter_from", r211);
        r100.put(LocationMonitorConst.CERT_TOKEN, r210.certToken);
        if (r214 != 2) goto L12;
        String r101 = "byte";
    L16:
        r100.put(BytedCertConstant.CertKey.VERIFY_CHANNEL, r101);
        r100.put("cert_type", String.valueOf(r210.certType));
        r100.put("children_cert_token", r210.childrenCertToken);
        r100.put("youth_cert_scene", String.valueOf(r210.youthCertScene));
        Map<String, String> r102 = r210.apiRequestParams;
        if (r102 == null) goto L20;
        r100.putAll(r102);
    L20:
        if (PbRequest.SwitchType.RECHARGE.equals(r211) == false) goto L22;
    L25:
        Observable<Response<JsonObject>> r103 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationCommonResultForString(r100);
        boolean r111 = false;
    L26:
        final com.bytedance.android.tools.superkv.e r112 = v1.a("webcast_jsb_local_data");
        if (r110.isFinishing() == false) goto L30;
        e1 r104 = null;
    L29:
        final e1 r113 = r104;
        final boolean r114 = r111;
        final boolean r105 = r111;
        r103.compose(RxUtil.rxSchedulerHelper()).subscribe(new a90.d(r215, r215, r112, r113, r211, r216, r212, r214, r210, r114, r217, r110, r213), new a90.e(r112, r211, r212, r214, r210, r213, r105, r217, r110, r113, r216, r215));
        return;
    L30:
        r104 = new e1(r110);
        r104.setCancelable(false);
        r104.setCanceledOnTouchOutside(false);
        if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r104);
        goto L29
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L34:
        DialogLancet.beforeDialogShow(r104);
        r104.show();
        DialogLancet.afterDialogShow(r104);
        goto L29
    L22:
        if ("first_withdraw".equals(r211) == true) goto L25;
        r100.put("skip_record_verify", String.valueOf(r217));
        r100.put(CommonCode.MapKey.TRANSACTION_ID, r210.transactionId);
        r103 = ((ZhimaVerifyApi) com.bytedance.android.live.network.c.b().e(ZhimaVerifyApi.class)).queryCertificationResultForString(r100);
        r111 = true;
        goto L26
    L12:
        if (r214 == 3) goto L14;
        r101 = "alipay";
        goto L16
    L14:
        r101 = "alicloud";
        goto L16
    L41:
        return;
    }

    public static void o(Activity r110, w80.a r111, String r112, Bundle r113, int r114, String r115, boolean r210, g r211, f r212, boolean r213, boolean r214) {
        IHostReady r100 = f();
        if (r100 == null) goto L5;
        r100.tryPreload(r110, false, new b(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214));
        return;
    L5:
        q(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public static void q(final Activity r110, w80.a r111, final String r112, final Bundle r113, int r114, String r210, boolean r211, final g r212, f r213, final boolean r214, boolean r215) {
        w80.a r100 = r111;
        if (r110 != null) goto L5;
    L58:
        r212.onVerify(false, new HashMap());
        return;
    L5:
        if (r110.isFinishing() == true) goto L58;
        Map<String, String> r101 = null;
        int r102 = r114;
        if (r102 != 2) goto L25;
        IHostOCRApiProxy r103 = (IHostOCRApiProxy) k.f(IHostOCRApiProxy.class);
        if (r103 != null) goto L12;
    L17:
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        r100 = null;
        boolean r105 = true;
        r102 = 0;
    L27:
        if (r102 != 3) goto L39;
        if (r215 == false) goto L39;
        if (j() == true) goto L36;
        if (r100 == null) goto L36;
        if (TextUtils.isEmpty(r100.certToken) == true) goto L36;
        boolean r106 = false;
    L37:
        if (r106 == false) goto L39;
        IHostAliYunVerifyProxy r107 = (IHostAliYunVerifyProxy) k.f(IHostAliYunVerifyProxy.class);
        w80.a r108 = null;
        final boolean r109 = true;
        final int r115 = 0;
    L40:
        if (r115 != 0) goto L54;
        if (r211 == false) goto L54;
        if (i(r110) == false) goto L54;
        AlertDialog r116 = new AlertDialog.Builder(r110).setTitle(R.string.ttlive_verify_label).setMessage(R.string.ttlive_zhima_no_alipay).setPositiveButton("确定", null).create();
        if (DialogLancet.shouldBlockDialogShow(r116) == false) goto L61;
        DialogLancet.handleBlockedDialogShow(r116);
    L49:
        if (r212 == null) goto L52;
        HashMap r117 = new HashMap();
        r117.put("status", -1);
        r117.put("msg", "未安装支付宝");
        r212.onVerify(false, r117);
    L52:
        RealNameFullMonitor.b(r112, false, r109, -1, "AliPayAppUnInstalled", 0, r108);
        return;
    L61:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L60
    L48:
        DialogLancet.beforeDialogShow(r116);
        r116.show();
        DialogLancet.afterDialogShow(r116);
    L54:
        if (r108 != null) goto L56;
        final e1 r118 = new e1(r110);
        r118.setCancelable(false);
        r118.setCanceledOnTouchOutside(false);
        r213.a(c(r110, r115)).compose(RxUtil.rxSchedulerHelper()).subscribe(new a90.b(r118, r110, r112, r113, r109, r115, r212, r214), new a90.c(r118, r110, r112, r212));
        return;
    L56:
        n(r110, r108, r112, r113, r109, r115, r212, r214);
        return;
    L36:
        r106 = true;
    L39:
        r108 = r100;
        r115 = r102;
        r109 = r105;
        goto L40
    L20:
        boolean r119 = PbRequest.SwitchType.RECHARGE.equals(r112);
        if (r100 == null) goto L23;
        r101 = r100.apiRequestParams;
    L23:
        n r120 = tj.f121303a.getValue();
        v80.d.a r121 = new v80.d.a();
        r121.f553620b = "live_cert_normal";
        r121.f553622d = "1";
        r121.f553621c = "";
        r121.f553619a = r110;
        r121.f553625g = r119;
        r121.f553626h = r112;
        r121.f553627i = true;
        r121.f553629k = r212;
        r120.getClass();
        r121.f553632n = r101;
        x80.c.a(1).f562883a.a(new v80.d(r121));
        return;
    L12:
        if (r103.isSDKReady() == false) goto L17;
        if (TextUtils.isEmpty(r210) == true) goto L17;
        r104 = false;
        goto L18
    L25:
        r105 = false;
        goto L27
    }
}
