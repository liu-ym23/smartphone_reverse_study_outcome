package bm6;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJPayGestureUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ies.bullet.lynx.h;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.experiment.f;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.lynx.element.PoiGoodsDetailScrollForLynx;
import com.bytedance.locallife.lynx.element.PoiLynxRateImage;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.config.IConstValues;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.image.AutoSizeImage;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.tencent.qqmusic.third.api.contract.Keys;
import h16.d;
import h16.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mt6.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public class a implements mt6.b {

    /* JADX INFO: renamed from: bm6.a$a, reason: collision with other inner class name */
    public static final class C0314a extends com.lynx.tasm.behavior.a {
        public C0314a() {
            super("poi-goodsdetail-scroll");
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new PoiGoodsDetailScrollForLynx(r100);
        }
    }

    public static final class b extends com.lynx.tasm.behavior.a {
        public b() {
            super("poi-rate-image", false, true);
        }

        @Override // com.lynx.tasm.behavior.a
        public final ShadowNode createShadowNode() {
            return new AutoSizeImage();
        }

        @Override // com.lynx.tasm.behavior.a
        public final LynxUI<?> createUI(LynxContext r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new PoiLynxRateImage(r100);
        }
    }

    public a() {
    }

    @Override // mt6.b
    public final void b() {
    }

    @Override // mt6.b
    public List<c> d() {
        return null;
    }

    @Override // mt6.b
    public final void g(Application r100, Function1<? super Throwable, Unit> r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "onFailed");
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
    }

    @Override // mt6.b
    public final List<com.lynx.tasm.behavior.a> getBehaviorList() {
        return CollectionsKt.listOf(new com.lynx.tasm.behavior.a[]{new C0314a(), new b()});
    }

    @Override // mt6.b
    public final List<p46.c> a(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        return new ArrayList();
    }

    @Override // mt6.b
    public final Uri e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "oldSchema");
        return UriProtector.parse(r100);
    }

    @Override // mt6.b
    public Map<String, Object> c(m16.b r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r210, "factory");
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(HostServiceUtilsKt.h().a());
        int r101 = cm6.c.f24177a;
        Intrinsics.checkNotNullParameter(r210, "providerFactory");
        ss6.c r102 = HostServiceUtilsKt.E();
        zt6.a r103 = HostServiceUtilsKt.c0();
        Context r104 = (Context) r210.c(Context.class);
        d r105 = (d) r210.c(d.class);
        if (r105 == null) goto L6;
        Activity r106 = r105.getActivity();
        if (r106 == null) goto L6;
    L11:
        e r107 = (e) r210.c(e.class);
        if (r107 == null) goto L14;
        Uri r108 = r107.getProcessingUri();
    L15:
        if (r108 != null) goto L19;
        Uri r109 = (Uri) r210.c(Uri.class);
        if (r109 == null) goto L19;
        r108 = UriProtector.parse(UriProtector.getQueryParameter(r109, "url"));
    L19:
        if (r106 == null) goto L21;
        Context r110 = r106;
    L24:
        i16.c r111 = i16.c.f487996a;
        Resources r112 = r110.getResources();
        i16.c.f487999d = WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density;
        int r113 = i16.c.k(r110, vd7.c.c());
        if (r110.getResources().getConfiguration().orientation != 2) goto L27;
        boolean r114 = true;
    L28:
        Boolean r115 = Boolean.valueOf(r114);
        int r116 = i16.c.k(r110, vd7.c.b(r110));
        int r117 = i16.c.k(r110, vd7.c.a(r110));
        if (Intrinsics.areEqual(r115, Boolean.TRUE) == false) goto L31;
        int r118 = Math.max(r116, r117);
        int r119 = Math.min(r116, r117);
    L33:
        if (r106 == null) goto L50;
        Rect r120 = new Rect();
        cm6.c.a(r106.getWindow()).getWindowVisibleDisplayFrame(r120);
        int r121 = i16.c.k(r110, cm6.c.a(r106.getWindow()).getHeight());
        int r122 = i16.c.k(r110, r120.height());
        int r123 = i16.c.k(r110, r120.top);
        int r124 = i16.c.k(r110, r120.bottom);
        if (r123 >= r113) goto L37;
        r122 = r122 - r113;
    L37:
        if (r121 != 0) goto L40;
        if (r123 != 0) goto L40;
        r124 = r124 + r113;
    L40:
        Resources r125 = cm6.c.a(r106.getWindow()).getResources();
        if ((cm6.c.a(r106.getWindow()).getBottom() - r120.bottom) <= (100 * WindowDisplayMetricsOverride.apply(r125, r125.getDisplayMetrics()).density)) goto L48;
        if (r104 == null) goto L46;
        int r126 = r104.getResources().getIdentifier(CJPayGestureUtils.IMMERSION_NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (r126 <= 0) goto L46;
        int r127 = r104.getResources().getDimensionPixelSize(r126);
    L47:
        int r128 = i16.c.k(r110, r127);
        int r129 = 0;
    L49:
        int r130 = Math.max((r119 - r128) - r113, r129);
    L51:
        s26.d r131 = s26.d.f540305c;
        u26.c r132 = (u26.c) s26.d.f540305c.c(u26.c.class);
        String r133 = "";
        if (r132 == null) goto L54;
        String r134 = r132.getSdkVersion();
    L55:
        i16.c.f487998c = false;
        LinkedHashMap r135 = new LinkedHashMap();
        r135.put("screenWidth", Integer.valueOf(r118));
        r135.put("screenHeight", Integer.valueOf(r119));
        r135.put("statusBarHeight", Integer.valueOf(r113));
        r135.put("topHeight", Integer.valueOf(r113));
        r135.put("contentHeight", Integer.valueOf(r130));
        r135.put("bottomHeight", Integer.valueOf(r128));
        r135.put("safeAreaHeight", Integer.valueOf(r122));
        r135.put("os", "android");
        r135.put("osVersion", Build.VERSION.RELEASE);
        r135.put(IConstValues.DEVICE_TYPE, Build.MODEL);
        r135.put("channel", r102.getChannel());
        r135.put("aid", Integer.valueOf(r102.getAppId()));
        r135.put("appName", r102.getAppName());
        r135.put("appVersion", r102.getBussinessVersionName());
        r135.put("updateVersionCode", String.valueOf(r102.getUpdateVersionCode()));
        String r136 = r102.a(r211);
        r135.put("appTheme", r136);
        r135.put("mode", r136);
        r135.put("prefersColorScheme", r136);
        r135.put(EffectConfiguration.KEY_REGION, "CN");
        if (Build.VERSION.SDK_INT < 24) goto L58;
        Locale r137 = Resources.getSystem().getConfiguration().getLocales().get(0);
    L59:
        r135.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r137.getLanguage());
        Locale r138 = kp6.e.a();
        if (r138 == null) goto L62;
        String r139 = r138.getLanguage();
    L63:
        if (r139 != null) goto L65;
        r139 = "";
    L65:
        r135.put("appLang", r139);
        r135.put("language", String.valueOf(r138));
        r135.put("appLanguage", "zh-Hans");
        r135.put("deviceId", r102.getDeviceId());
        r135.put("isPad", Integer.valueOf(HostServiceUtilsKt.v().isPad() ? 1 : 0));
        r135.put("lynxSdkVersion", r134);
        r135.put("isLandscape", Integer.valueOf(r115.booleanValue() ? 1 : 0));
        if (r108 != null) goto L68;
    L88:
        r135.put("deviceScore", Integer.valueOf(HostServiceUtilsKt.V().h(r110.getApplicationContext())));
        r135.put(Keys.API_RETURN_KEY_IS_LOGIN, Integer.valueOf(HostServiceUtilsKt.i().isLogin() ? 1 : 0));
        if (r103 == null) goto L91;
        r103.e();
    L91:
        r135.put("account", MapsKt.mapOf(TuplesKt.to("passport_enterprise_user_type", 0)));
        et6.a r140 = HostServiceUtilsKt.z();
        r135.put("font_scale", String.valueOf(r140.getCurrentFontScale()));
        r135.put("fontScale", String.valueOf(r140.getCurrentFontScale()));
        if (r103 == null) goto L94;
        r103.a();
    L94:
        r135.put("viewZoom", String.valueOf(1.0f));
        cm6.a r141 = cm6.a.f24173a;
        if (r108 == null) goto L100;
        String r142 = r108.toString();
        if (r142 == null) goto L100;
        r133 = r142;
    L100:
        r141.getClass();
        Intrinsics.checkNotNullParameter(r133, "schema");
        com.bytedance.locallife.biz.experiment.e r143 = f.a();
        if (r143.f256650a == true) goto L103;
    L105:
        boolean r144 = false;
    L107:
        if (r144 == false) goto L248;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L135
        String r146 = UriProtector.getQueryParameter(UriProtector.parse(r133), AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS);     // Catch: Throwable -> L135
        if (r146 == null) goto L132;
        String r147 = Uri.decode(r146);     // Catch: Throwable -> L135
        if (r147 == null) goto L132;
        List r148 = StringsKt.split$default(r147, new char[]{','}, false, 0, 6, null);     // Catch: Throwable -> L135
        if (r148 == null) goto L132;
        List r149 = r148;     // Catch: Throwable -> L135
        ArrayList r150 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r149, 10));     // Catch: Throwable -> L135
        Iterator r151 = r149.iterator();     // Catch: Throwable -> L135
    L116:
        if (r151.hasNext() == false) goto L122;
        String r152 = (String) r151.next();     // Catch: Throwable -> L135
        if (r152 == null) goto L121;
        r150.add(StringsKt.trim(r152).toString());     // Catch: Throwable -> L135
        goto L116
    L121:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");     // Catch: Throwable -> L135
    L122:
        ArrayList r153 = new ArrayList();     // Catch: Throwable -> L135
        Iterator r154 = r150.iterator();     // Catch: Throwable -> L135
    L124:
        if (r154.hasNext() == false) goto L131;
        Object r155 = r154.next();     // Catch: Throwable -> L135
        if (((String) r155).length() <= 0) goto L128;
        boolean r156 = true;
    L129:
        if (r156 == false) goto L124;
        r153.add(r155);     // Catch: Throwable -> L135
        goto L124
    L128:
        r156 = false;
        goto L129
    L131:
        List r157 = CollectionsKt.distinct(r153);     // Catch: Throwable -> L135
    L133:
        Object r158 = Result.m9449constructorimpl(r157);     // Catch: Throwable -> L135
    L137:
        Throwable r159 = Result.m9452exceptionOrNullimpl(r158);
        if (r159 == null) goto L141;
        HostServiceUtilsKt.k().e("ABTestHelper", "parse ab_params failed: " + r159);
        r158 = null;
    L141:
        List r160 = (List) r158;
        List r161 = r160;
        if (r161 != null) goto L144;
    L147:
        boolean r162 = true;
    L148:
        if (r162 == true) goto L183;
        LinkedHashMap r163 = new LinkedHashMap();
        Iterator r164 = r160.iterator();
    L152:
        if (r164.hasNext() == false) goto L166;
        String r165 = (String) r164.next();
        Result.Companion r166 = Result.Companion;     // Catch: Throwable -> L156
        cm6.a.f24173a.getClass();     // Catch: Throwable -> L156
        Object r167 = Result.m9449constructorimpl(cm6.a.b(r165));     // Catch: Throwable -> L156
    L158:
        Throwable r168 = Result.m9452exceptionOrNullimpl(r167);
        if (r168 == null) goto L162;
        HostServiceUtilsKt.k().e("ABTestHelper", "get ab_params value failed, key: " + r165 + ", error: " + r168);
    L162:
        if (Result.m9455isFailureimpl(r167) == false) goto L164;
        r167 = null;
    L164:
        if (r167 == null) goto L152;
        r163.put(r165, r167);
    L156:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        r167 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L158
    L166:
        Map<String, Object> r170 = r163;
    L184:
        if (r170 == null) goto L186;
        r135.put("abParams", r170);
    L186:
        if (r103 == null) goto L188;
        r103.c();
        int r171 = 1;
    L189:
        r135.put("is_saas", Integer.valueOf(r171));
        r135.put("is_new_saas", Integer.valueOf(r171));
        r135.put("lifesdk_isomorphic_saas_version", "39.2.0");
        r135.put("life_saas_sdk_version", "390200");
        r135.put("lifesdk_app_id", "505741");
        if (r103 == null) goto L192;
        r103.j();
        long r172 = 11100;
    L193:
        r135.put("lifesdk_app_version", String.valueOf(r172));
        r135.put("jsbProxyAppId", "1128");
        if (r108 == null) goto L196;
        String r173 = w36.a.a(r108, "storage_keys");
    L197:
        if (r173 == null) goto L199;
        List r174 = StringsKt.split$default(Uri.decode(r173), new String[]{","}, false, 0, 6, null);
    L200:
        com.bytedance.sdk.xbridge.cn.storage.utils.b r175 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(HostServiceUtilsKt.E().getApplicationContext());
        LinkedHashMap r176 = new LinkedHashMap();
        if (r174 == null) goto L208;
        Iterator r177 = r174.iterator();
    L204:
        if (r177.hasNext() == false) goto L208;
        String r178 = (String) r177.next();
        Object r179 = r175.e(r178, null, null);
        if (r179 == null) goto L204;
        r176.put(r178, r179);
    L208:
        r135.put("storageValues", r176);
        ExecutorService r180 = BulletLogger.f247763a;
        if (r108 != null) goto L258;
        String r181 = null;
    L214:
        BulletLogger.k("setAppSettings queryKey = " + r181, null, null, 6);     // Catch: Throwable -> L211
        if (r181 != null) goto L217;
    L244:
        r100.putAll(r135);
        return r100;
    L217:
        if (r181.length() <= 0) goto L219;
        boolean r182 = true;
    L220:
        if (r182 == false) goto L244;
        List r183 = StringsKt.split$default(r181, new String[]{"."}, false, 0, 6, null);     // Catch: Throwable -> L211
        int r184 = rm6.c.f538571a;     // Catch: Throwable -> L211
        String r185 = (String) rm6.c.a((String) ListProtector.get(r183, 0), String.class);     // Catch: Throwable -> L211
        int r186 = r183.size();     // Catch: Throwable -> L211
        int r187 = 1;
    L222:
        if (r187 >= r186) goto L239;
        if (((CharSequence) ListProtector.get(r183, r187)).length() != 0) goto L226;
        boolean r188 = true;
    L227:
        if (r188 == true) goto L239;
        String r189 = (String) ListProtector.get(r183, r187);     // Catch: Throwable -> L211
        if (r185 != null) goto L256;
    L236:
        r185 = null;
    L237:
        r187 = r187 + 1;
        goto L222
    L256:
        r185 = new JSONObject(r185).optString(r189);     // Catch: Throwable -> L234
    L234:
        th = move-exception;
        ExecutorService r190 = BulletLogger.f247763a;     // Catch: Throwable -> L211
        BulletLogger.d("getValueSub onException:" + th.getMessage());     // Catch: Throwable -> L211
    L211:
        th = move-exception;
        BulletLogger.k("setAppSettings onException = " + th.getMessage(), null, null, 6);
        goto L244
    L226:
        r188 = false;
    L239:
        if (r185 == null) goto L241;
        r135.put("appSettingsValue", r185);     // Catch: Throwable -> L211
    L241:
        BulletLogger.k("setAppSettings result = " + r135.get("appSettingsValue"), null, null, 6);     // Catch: Throwable -> L211
        goto L244
    L219:
        r182 = false;
        goto L220
    L258:
        r181 = a36.b.e(r108, "settings_key");     // Catch: Throwable -> L211
        goto L214
    L199:
        r174 = null;
        goto L200
    L196:
        r173 = null;
        goto L197
    L192:
        r172 = 0;
        goto L193
    L188:
        r171 = 0;
    L183:
        r170 = null;
        goto L184
    L144:
        if (r161.isEmpty() == true) goto L147;
        r162 = false;
    L132:
        r157 = null;
    L135:
        th = move-exception;
        Result.Companion r191 = Result.Companion;
        r158 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L137
    L248:
        String r192 = UriProtector.getQueryParameter(UriProtector.parse(r133), AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS);     // Catch: Exception -> L179
        HostServiceUtilsKt.k().w("ABTestHelper", "get ab_params key: " + r192);     // Catch: Exception -> L179
        if (TextUtils.isEmpty(r192) == true) goto L180;
        JSONObject r193 = new JSONObject();     // Catch: Exception -> L179
        Iterator r194 = StringsKt.split$default(Uri.decode(r192), new char[]{','}, false, 0, 6, null).iterator();     // Catch: Exception -> L247
    L174:
        if (r194.hasNext() == false) goto L181;
        String r195 = (String) r194.next();     // Catch: Exception -> L247
        cm6.a.f24173a.getClass();     // Catch: Exception -> L247
        r193.put(r195, cm6.a.a(r195));     // Catch: Exception -> L247
    L181:
        if (r193 == null) goto L183;
        r170 = com.bytedance.locallife.common.utils.f.e(r193);
    L180:
        r193 = null;
        goto L181
    L103:
        if (r143.f256652c == false) goto L105;
        r144 = true;
        goto L107
    L68:
        if (Intrinsics.areEqual(w36.a.a(r108, "need_abi_32"), "1") == false) goto L88;
        if (cm6.b.f24174a != null) goto L82;
        monitor-enter(cm6.b.class);     // Catch: Exception -> L246
    L78:
        th = move-exception;
        throw th;     // Catch: Exception -> L246
    L74:
        if (cm6.b.f24174a != null) goto L76;
        cm6.b.f24174a = cm6.b.d();     // Catch: Throwable -> L78
    L76:
        monitor-exit(cm6.b.class);     // Catch: Throwable -> L78
    L82:
        if (TextUtils.isEmpty(cm6.b.f24174a) == true) goto L86;
        boolean r196 = !"arm64-v8a".equals(cm6.b.c());
    L87:
        r135.put("is32", Boolean.valueOf(r196));
    L86:
        r196 = false;
        goto L87
    L62:
        r139 = null;
        goto L63
    L58:
        r137 = Resources.getSystem().getConfiguration().locale;
        goto L59
    L54:
        r134 = "";
    L46:
        r127 = 0;
        goto L47
    L48:
        r129 = 0;
        r128 = Math.max(r119 - r124, 0);
        goto L49
    L50:
        r128 = 0;
        r130 = 0;
        r122 = 0;
        goto L51
    L31:
        r118 = Math.min(r116, r117);
        r119 = Math.max(r116, r117);
        goto L33
    L27:
        r114 = false;
        goto L28
    L21:
        if (r104 != null) goto L23;
        r110 = r102.getApplicationContext();
        goto L24
    L23:
        r110 = r104;
        goto L24
    L14:
        r108 = null;
    L6:
        if (r104 != null) goto L8;
    L10:
        r106 = null;
        goto L11
    L8:
        if ((r104 instanceof Activity) == false) goto L10;
        r106 = (Activity) r104;
        goto L11
    }

    @Override // mt6.b
    public final h f(CubeConfig r100, h r110) {
        Intrinsics.checkNotNullParameter(r100, "cubeConfig");
        Intrinsics.checkNotNullParameter(r110, "lynxKitInitParams");
        String r101 = r100.getLynxInitConfig().getGroupName();
        if (r101 == null) goto L5;
        h.d(r110, r101, r100.getLynxInitConfig().getShareGroup(), r100.getLynxInitConfig().getEnableCanvas(), r100.getLynxInitConfig().getJsPaths(), r100.getLynxInitConfig().getEnableDynamicV8(), r100.getLynxInitConfig().getEnableCanvasOptimize());
    L5:
        return r110;
    }
}
