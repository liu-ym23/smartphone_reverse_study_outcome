package com.obric.aiagent.product.feature.impl;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.IBuildContext;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.b;
import com.obric.aiagent.product.a.d;
import com.obric.aiagent.product.feature.FeatureConfig;
import com.obric.aiagent.product.feature.FeatureListConfig;
import com.obric.aiagent.product.feature.ProductInfoConfig;
import com.obric.aiagent.product.feature.ProductSpecialConfig;
import com.obric.aiagent.product.feature.api.IFeatureService;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.obric.aiagent.product.feature.bean.FeatureConfigWrap;
import com.obric.aiagent.product.feature.bean.FeatureStateConfigItem;
import com.obric.aiagent.product.platform.api.rom.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.f;
import d.f.c;
import d.f.t;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.n;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: FeatureServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements IFeatureService {
    private static final String TAG = "FeatureServiceImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0396a f18789a = null;
    private static final f<a> j = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, ProductInfoConfig> f18790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FeatureListConfig f18791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FeatureListConfig f18792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FeatureListConfig f18793e;
    private final f f;
    private final f g;
    private final f h;
    private final f i;

    /* JADX INFO: renamed from: com.obric.aiagent.product.feature.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FeatureServiceImpl.kt */
    public static final class C0396a {
        public /* synthetic */ C0396a(h r1) {
            this();
        }

        private C0396a() {
        }

        private final a b() {
            return (a) ZeusTransformUtils.preCheckCast(a.c().b(), a.class, "com.obric.aiagent.plugin");
        }

        public final synchronized IFeatureService a() {
            monitor-enter(this);
            IFeatureService r0 = (IFeatureService) ZeusTransformUtils.preCheckCast(b(), IFeatureService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ boolean lambda$3F5yoOgjyzrg2UuIEIttlmnHQTg() {
        return g();
    }

    public static /* synthetic */ Context lambda$5JWXW7UwdypJbEzAqwxKcFYnmhI() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$CUciy8ZTjvFEIGILDAZP-se1CCY, reason: not valid java name */
    public static /* synthetic */ a m204lambda$CUciy8ZTjvFEIGILDAZPse1CCY() {
        return k();
    }

    public static /* synthetic */ String lambda$QOa7OXOrHYyqa5KHUHj_gMeOeWY() {
        return j();
    }

    public static /* synthetic */ boolean lambda$lbrXuYoWGRU1d5kK0IKHv9Sqihw() {
        return h();
    }

    public a() {
        this.f18790b = ao.b();
        this.f = g.a($$Lambda$a$3F5yoOgjyzrg2UuIEIttlmnHQTg.INSTANCE);
        this.g = g.a($$Lambda$a$lbrXuYoWGRU1d5kK0IKHv9Sqihw.INSTANCE);
        this.h = g.a($$Lambda$a$5JWXW7UwdypJbEzAqwxKcFYnmhI.INSTANCE);
        this.i = g.a($$Lambda$a$QOa7OXOrHYyqa5KHUHj_gMeOeWY.INSTANCE);
    }

    public static final /* synthetic */ f c() {
        return j;
    }

    static {
        f18789a = new C0396a(null);
        j = g.a($$Lambda$a$CUciy8ZTjvFEIGILDAZPse1CCY.INSTANCE);
    }

    private static final a k() {
        return new a();
    }

    private final boolean d() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.f.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean g() {
        String r3 = d.f18776a.a("ro.system_ext.o_product.type", SensitiveType.UNKNOWN);     // Catch: Exception -> L9
        if (o.a(r3, SensitiveType.UNKNOWN) == false) goto L6;
        r3 = d.f18776a.a(PlatformConst.PROP_PRODUCT_TYPE, SensitiveType.UNKNOWN);     // Catch: Exception -> L9
        o.a(r3, SensitiveType.UNKNOWN);     // Catch: Exception -> L9
        boolean r1 = true;
    L7:
        ILogDepend.Companion.i(TAG, "obricOs init: " + r3 + ", obricOS: " + r1);     // Catch: Exception -> L9
        return r1;
    L6:
        r1 = false;
    L9:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "obricOS init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return true;
    }

    private final boolean e() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(this.g.b(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final boolean h() {
        String r3 = d.f18776a.a("ro.system_ext.o_product.type", SensitiveType.UNKNOWN);     // Catch: Exception -> L12
        if (o.a(r3, SensitiveType.UNKNOWN) == false) goto L7;
        r3 = d.f18776a.a(PlatformConst.PROP_PRODUCT_TYPE, SensitiveType.UNKNOWN);     // Catch: Exception -> L12
    L7:
        if (o.a(r3, IFeatureServiceKt.PRODUCT_EMULATOR) == false) goto L9;
        boolean r1 = true;
    L10:
        ILogDepend.Companion.i(TAG, "emulatorOs init: " + r3 + ", isEmulatorOs: " + r1);     // Catch: Exception -> L12
        return r1;
    L9:
        r1 = false;
    L12:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "emulatorOs init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    private final Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(this.h.b(), Context.class, "com.obric.aiagent.plugin");
    }

    private static final Context i() {
        Application r0 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L13;
        Object r1 = IAIAgentPlatform.Companion.getCommonParams("base");
        o.a(r1, "null cannot be cast to non-null type android.content.Context");
        return (Context) ZeusTransformUtils.preCheckCast(r1, Context.class, "com.obric.aiagent.plugin");
    L13:
        return (Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.aiagent.plugin");
    L5:
        r2 = false;
        goto L6
    }

    private final String f() {
        return (String) ZeusTransformUtils.preCheckCast(this.i.b(), String.class, "com.obric.aiagent.plugin");
    }

    private static final String j() {
        String r2 = d.f18776a.a("ro.system_ext.o_product.type", SensitiveType.UNKNOWN);     // Catch: Exception -> L8
        if (o.a(r2, SensitiveType.UNKNOWN) == false) goto L6;
        r2 = d.f18776a.a(PlatformConst.PROP_PRODUCT_TYPE, SensitiveType.UNKNOWN);     // Catch: Exception -> L8
    L6:
        ILogDepend.Companion.i(TAG, "osProductName init: " + r2);     // Catch: Exception -> L8
        return r2;
    L8:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "osProductName init fail, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return SensitiveType.UNKNOWN;
    }

    private final JSONObject a(String r4) {
        InputStream r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getAssets().open(r4);     // Catch: Throwable -> L16
        o.c(r3, "open(...)");     // Catch: Throwable -> L16
        Reader r5 = (Reader) ZeusTransformUtils.preCheckCast(new InputStreamReader(r3, d.o.d.f38623b), Reader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (ZeusTransformUtils.instanceOf(r5, BufferedReader.class) == false) goto L6;
        BufferedReader r6 = (BufferedReader) ZeusTransformUtils.preCheckCast(r5, BufferedReader.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
    L7:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        String r8 = t.a((Reader) ZeusTransformUtils.preCheckCast((BufferedReader) ZeusTransformUtils.preCheckCast(r7, BufferedReader.class, "com.obric.aiagent.plugin"), Reader.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L11
        c.a(r7, null);     // Catch: Throwable -> L16
        return new JSONObject(r8);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        c.a(r7, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L6:
        r6 = new BufferedReader(r5, 8192);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "load settings failed", th);
        return null;
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public void init() {
        b();
        a();
    }

    public final void a() {
        ILogDepend.Companion.i(TAG, "initFeatureInfo");
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "int obric feature info failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L4:
        if (this.f18791c == null) goto L6;
        return;
    L6:
        JSONObject r1 = a("default_feature_config.json");     // Catch: Exception -> L11
        if (r1 != null) goto L9;
        r1 = new JSONObject();     // Catch: Exception -> L11
    L9:
        this.f18791c = (FeatureListConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r1.toString(), FeatureListConfig.class), FeatureListConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        ILogDepend.Companion.d(TAG, "init obric feature info, featureListConfigBoolean: " + this.f18791c + ", json: " + r1);     // Catch: Exception -> L11
    }

    public final void b() {
        Object r0 = "";
        ILogDepend.Companion.i(TAG, "initProductInfo");
        Gson r3 = new Gson();     // Catch: Exception -> L46
        Type r5 = new FeatureServiceImpl$initProductInfo$typeToken$1().getType();     // Catch: Exception -> L46
        JSONObject r6 = a("default_product_info.json");     // Catch: Exception -> L46
        if (r6 == null) goto L7;
        String r7 = r6.toString();     // Catch: Exception -> L46
        if (r7 == null) goto L7;
    L53:
        n.a r8 = n.f38560a;     // Catch: Throwable -> L10
        a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Object r10 = n.f((Map) ZeusTransformUtils.preCheckCast(r3.fromJson(r7, r5), Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
    L12:
        Map r11 = ao.b();     // Catch: Exception -> L46
        if (n.b(r10) == false) goto L15;
        r10 = r11;
    L15:
        Map<String, ProductInfoConfig> r12 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L46
        ILogDepend.Companion.d(TAG, "init obric product info, defaultProductMap: " + r12 + ", json: " + r7);     // Catch: Exception -> L46
        n.a r13 = n.f38560a;     // Catch: Throwable -> L24
        a r14 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        JSONObject r15 = ICloudConfig.Companion.getSettingsConfig("obric_product_info_config");     // Catch: Throwable -> L24
        if (r15 == null) goto L19;
        String r16 = r15.toString();     // Catch: Throwable -> L24
    L20:
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        Object r17 = n.f(r16);     // Catch: Throwable -> L24
    L27:
        if (n.b(r17) == true) goto L30;
        r0 = r17;
    L30:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L46
        ILogDepend.Companion.i(TAG, "init obric product info, cloudJsonStr: " + r1);     // Catch: Exception -> L46
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L33;
        boolean r18 = true;
    L34:
        if (r18 == true) goto L49;
        this.f18790b = r12;     // Catch: Exception -> L46
    L44:
        ILogDepend.Companion.i(TAG, "init obric product info, productMap: " + this.f18790b);     // Catch: Exception -> L46
        return;
    L49:
        n.a r19 = n.f38560a;     // Catch: Throwable -> L37
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Object r4 = n.f((Map) ZeusTransformUtils.preCheckCast(r3.fromJson(r1, r5), Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
    L39:
        Map r20 = ao.b();     // Catch: Exception -> L46
        if (n.b(r4) == false) goto L42;
        r4 = r20;
    L42:
        this.f18790b = ao.a(r12, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L46
        goto L44
    L37:
        th = move-exception;
        n.a r21 = n.f38560a;     // Catch: Exception -> L46
        r4 = n.f(d.o.a(th));     // Catch: Exception -> L46
        goto L39
    L33:
        r18 = false;
        goto L34
    L19:
        r16 = null;
    L24:
        th = move-exception;
        n.a r22 = n.f38560a;     // Catch: Exception -> L46
        r17 = n.f(d.o.a(th));     // Catch: Exception -> L46
        goto L27
    L10:
        th = move-exception;
        n.a r23 = n.f38560a;     // Catch: Exception -> L46
        r10 = n.f(d.o.a(th));     // Catch: Exception -> L46
    L7:
        r7 = "{}";
    L46:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "int obric product info failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public void destroy() {
        ILogDepend.Companion.i(TAG, "destroy");
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public boolean isObricFeatureEnable() {
        String r5 = IBuildContext.Companion.getBuildVariant();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return true;
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L17;
        return false;
    L17:
        if (d.o.o.b(r5, "obric", false, 2, null) == true) goto L19;
        return false;
    L19:
        return true;
    L14:
        r2 = false;
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public boolean isFeatureEnable(String r22) {
        o.e(r22, "featureKey");
        Object r6 = null;
        n.a r0 = n.f38560a;     // Catch: Throwable -> L11
        a r1 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        JSONObject r2 = ICloudConfig.Companion.getSettingsConfig(r22);     // Catch: Throwable -> L11
        if (r2 == null) goto L6;
        String r3 = r2.toString();     // Catch: Throwable -> L11
    L7:
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        Object r4 = n.f(r3);     // Catch: Throwable -> L11
    L13:
        Throwable r8 = n.c(r4);     // Catch: Exception -> L106
        if (r8 == null) goto L18;
        ILogDepend.Companion.e(TAG, "isFeatureEnable, featureKey: " + r22 + ", ICloudConfig.Companion.getSettingsConfig() failed, " + r8.getMessage(), r8);     // Catch: Exception -> L106
    L18:
        if (n.b(r4) == false) goto L20;
        r4 = null;
    L20:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L106
        if (r5 != null) goto L23;
    L28:
        boolean r10 = false;
    L29:
        if (r10 == false) goto L40;
        n.a r11 = n.f38560a;     // Catch: Throwable -> L32
        a r7 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        Object r9 = n.f((FeatureConfig) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r5, FeatureConfig.class), FeatureConfig.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L32
    L35:
        if (n.b(r9) == true) goto L38;
        r6 = r9;
    L38:
        FeatureConfig r12 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r6, FeatureConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L106
    L48:
        ILogDepend.Companion.i(TAG, "isFeatureEnable, featureKey: " + r22 + ", featureConfig: " + r12);     // Catch: Exception -> L106
        if (r12 != 0) goto L54;
        ILogDepend.Companion.i(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", featureConfig is null");     // Catch: Exception -> L106
        return false;
    L54:
        if (r12.getEnabled() == true) goto L57;
        ILogDepend.Companion.i(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", featureConfig.enabled is false");     // Catch: Exception -> L106
        return false;
    L57:
        String r13 = getObricProductName();     // Catch: Exception -> L106
        if (r12.getProductWhiteList().contains(r13) == false) goto L62;
        ILogDepend.Companion.d(TAG, "isFeatureEnable return true, featureKey: " + r22 + ", is in productWhiteList, productName: " + r13);     // Catch: Exception -> L106
        return true;
    L62:
        if (r12.getProductBlackList().contains(r13) == false) goto L67;
        ILogDepend.Companion.d(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", is in productBlackList, productName: " + r13);     // Catch: Exception -> L106
        return false;
    L67:
        if (b.f18770a.a(r12.getDependencyOsFeatureList()) == true) goto L70;
        ILogDepend.Companion.i(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", os is not supported, dependencyOsFeatureList: " + r12.getDependencyOsFeatureList() + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L70:
        Map r14 = (Map) ZeusTransformUtils.preCheckCast(r12.getProductSpecialList().get(r13), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L106
        if (r14 != null) goto L76;
        ILogDepend.Companion.i(TAG, "isFeatureEnable return defaultState, featureKey: " + r22 + ", defaultState: " + r12.getDefaultState() + ", productName: " + r13);     // Catch: Exception -> L106
        if (o.a(r12.getDefaultState(), "enabled") == false) goto L75;
        return true;
    L75:
        return false;
    L76:
        ProductSpecialConfig r15 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r14.get(Build.MODEL), ProductSpecialConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L106
        if (r15 != null) goto L80;
        ILogDepend.Companion.i(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", modelSpecialConfig is null, model: " + Build.MODEL + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L80:
        String r16 = r15.getMinRomVersion();     // Catch: Exception -> L106
        String r17 = r15.getMaxRomVersion();     // Catch: Exception -> L106
        String r18 = RomInfo.INSTANCE.getShortOSVersion();     // Catch: Exception -> L106
        long r19 = com.obric.aiagent.product.a.c.f18771a.d(r18);     // Catch: Exception -> L106
        long r110 = com.obric.aiagent.product.a.c.f18771a.d(r16);     // Catch: Exception -> L106
        long r111 = com.obric.aiagent.product.a.c.f18771a.d(r17);     // Catch: Exception -> L106
        if (r15.getRomVersionBlackList().contains(r18) == false) goto L83;
    L104:
        ILogDepend.Companion.i(TAG, "isFeatureEnable return false, featureKey: " + r22 + ", osVersion: " + r18 + " is in romVersionBlackList, model: " + Build.MODEL + ", productName: " + r13);     // Catch: Exception -> L106
        return false;
    L83:
        if (r110 <= 0) goto L87;
        if (r19 < r110) goto L104;
    L87:
        if (r111 > 0) goto L89;
    L91:
        int r20 = RomInfo.INSTANCE.getOSReleaseDate();     // Catch: Exception -> L106
        long r112 = r15.getMinRomReleaseDate();     // Catch: Exception -> L106
        long r113 = r15.getMaxRomReleaseDate();     // Catch: Exception -> L106
        ILogDepend.Companion.d(TAG, "isFeatureEnable, featureKey: " + r22 + ", osReleaseDate: " + r20 + ", minRomReleaseDate: " + r112 + ", maxRomReleaseDate: " + r113);     // Catch: Exception -> L106
        if (r112 <= 0) goto L96;
        if (r20 >= r112) goto L96;
    L102:
        return false;
    L96:
        if (1 <= r113) goto L98;
    L100:
        boolean r21 = false;
    L101:
        if (r21 == true) goto L102;
        return true;
    L98:
        if (r113 >= r20) goto L100;
        r21 = true;
        goto L101
    L89:
        if (r19 <= r111) goto L91;
    L32:
        th = move-exception;
        n.a r23 = n.f38560a;     // Catch: Exception -> L106
        r9 = n.f(d.o.a(th));     // Catch: Exception -> L106
        goto L35
    L40:
        if (this.f18791c != null) goto L42;
        a();     // Catch: Exception -> L106
    L42:
        FeatureListConfig r24 = this.f18791c;     // Catch: Exception -> L106
        if (r24 == null) goto L47;
        Map<String, FeatureConfig> r25 = r24.getFeatureConfigs();     // Catch: Exception -> L106
        if (r25 == null) goto L47;
        r6 = (FeatureConfig) ZeusTransformUtils.preCheckCast(r25.get(r22), FeatureConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L106
    L47:
        r12 = r6;
        goto L48
    L23:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L25;
        boolean r114 = true;
    L26:
        if (r114 != true) goto L28;
        r10 = true;
        goto L29
    L25:
        r114 = false;
        goto L26
    L6:
        r3 = null;
    L11:
        th = move-exception;
        n.a r26 = n.f38560a;     // Catch: Exception -> L106
        r4 = n.f(d.o.a(th));     // Catch: Exception -> L106
    L106:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isFeatureEnable failed, featureKey: " + r22, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public String getFeatureState(String r8) {
        o.e(r8, "featureKey");
    L27:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isFeatureEnable failed, featureKey: " + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return "";
    L4:
        if (this.f18792d != null) goto L6;
        this.f18792d = a("default_feature_config_single.json", "obric_feature_config_single");     // Catch: Exception -> L27
        ILogDepend.Companion.i(TAG, "init obric feature v2, feature list config single: " + this.f18792d);     // Catch: Exception -> L27
    L6:
        FeatureListConfig r3 = this.f18792d;     // Catch: Exception -> L27
        if (r3 == null) goto L11;
        Map<String, FeatureConfigWrap> r4 = r3.getFeatureConfigWraps();     // Catch: Exception -> L27
        if (r4 == null) goto L11;
        FeatureConfigWrap r5 = (FeatureConfigWrap) ZeusTransformUtils.preCheckCast(r4.get(r8), FeatureConfigWrap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
    L12:
        ILogDepend.Companion.i(TAG, "getFeatureState, featureKey: " + r8 + ", featureConfig: " + r5);     // Catch: Exception -> L27
        if (r5 != null) goto L15;
    L26:
        return "";
    L15:
        if (r5.getEnabled() == false) goto L26;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5.getFeatureStateConfigList(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L27
    L19:
        if (r6.hasNext() == false) goto L25;
        FeatureStateConfigItem r7 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r6.next(), FeatureStateConfigItem.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        if (a(r7) == false) goto L19;
        return r7.getState();
    L25:
        return r5.getDefaultState();
    L11:
        r5 = null;
        goto L12
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public List<String> getFeatureStateList(String r7) {
        o.e(r7, "featureKey");
    L28:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isFeatureEnable failed, featureKey: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return p.b();
    L4:
        if (this.f18793e != null) goto L6;
        this.f18793e = a("default_feature_config_group.json", "obric_feature_config_group");     // Catch: Exception -> L28
        ILogDepend.Companion.i(TAG, "init obric feature v2, feature list config group: " + this.f18793e);     // Catch: Exception -> L28
    L6:
        FeatureListConfig r2 = this.f18793e;     // Catch: Exception -> L28
        if (r2 == null) goto L11;
        Map<String, FeatureConfigWrap> r3 = r2.getFeatureConfigWraps();     // Catch: Exception -> L28
        if (r3 == null) goto L11;
        FeatureConfigWrap r4 = (FeatureConfigWrap) ZeusTransformUtils.preCheckCast(r3.get(r7), FeatureConfigWrap.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
    L12:
        ILogDepend.Companion.i(TAG, "getFeatureStateList, featureKey: " + r7 + ", featureConfig: " + r4);     // Catch: Exception -> L28
        if (r4 == null) goto L27;
        if (r4.getEnabled() == false) goto L27;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.getFeatureStateConfigList(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L28
    L19:
        if (r5.hasNext() == false) goto L25;
        FeatureStateConfigItem r6 = (FeatureStateConfigItem) ZeusTransformUtils.preCheckCast(r5.next(), FeatureStateConfigItem.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (a(r6) == false) goto L19;
        return r6.getStateList();
    L25:
        return r4.getDefaultStateList();
    L27:
        return p.b();
    L11:
        r4 = null;
        goto L12
    }

    private final FeatureListConfig a(String r10, String r11) {
        ILogDepend.Companion.i(TAG, "merge default and cloud config");
        FeatureListConfig r1 = null;
        Gson r3 = new Gson();     // Catch: Exception -> L18
        JSONObject r9 = a(r10);     // Catch: Exception -> L18
        if (r9 != null) goto L6;
        r9 = new JSONObject();     // Catch: Exception -> L18
    L6:
        FeatureListConfig r12 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r3.fromJson(r9.toString(), FeatureListConfig.class), FeatureListConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        ILogDepend.Companion.i(TAG, "merge default and cloud config, defaultJsonStr: " + r9);     // Catch: Exception -> L18
        JSONObject r13 = ICloudConfig.Companion.getSettingsConfig(r11);     // Catch: Exception -> L18
        FeatureListConfig r14 = (FeatureListConfig) ZeusTransformUtils.preCheckCast(r3.fromJson(String.valueOf(r13), FeatureListConfig.class), FeatureListConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        ILogDepend.Companion.i(TAG, "merge default and cloud config, cloudJsonStr: " + r13);     // Catch: Exception -> L18
        boolean r15 = false;
        if (r14 == null) goto L13;
        Map<String, FeatureConfigWrap> r4 = r14.getFeatureConfigWraps();     // Catch: Exception -> L18
        if (r4 == null) goto L13;
        if ((!r4.isEmpty()) != true) goto L13;
        r15 = true;
    L13:
        if (r15 == false) goto L15;
        r1 = new FeatureListConfig(r14.getVersion(), null, ao.a(r12.getFeatureConfigWraps(), r14.getFeatureConfigWraps()), 2, null);     // Catch: Exception -> L18
    L16:
        ILogDepend.Companion.i(TAG, "merge default and cloud config, merge result: " + r1);     // Catch: Exception -> L18
    L20:
        return r1;
    L15:
        r1 = r12;
    L18:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "merge default and cloud config failed, ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L20
    }

    private final boolean a(FeatureStateConfigItem r15) {
        if (r15 != null) goto L43;
        return false;
    L43:
        String r14 = getObricProductName();     // Catch: Exception -> L40
        if (r15.getProductList().contains(r14) == false) goto L8;
        return true;
    L8:
        Map r16 = (Map) ZeusTransformUtils.preCheckCast(r15.getProductSpecialList().get(r14), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40
        if (r16 != null) goto L11;
        return false;
    L11:
        ILogDepend.Companion.i(TAG, "isCurConfigMatch, productSpecialConfig: " + r16);     // Catch: Exception -> L40
        ProductSpecialConfig r17 = (ProductSpecialConfig) ZeusTransformUtils.preCheckCast(r16.get(Build.MODEL), ProductSpecialConfig.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L40
        if (r17 != null) goto L14;
        return false;
    L14:
        ILogDepend.Companion.i(TAG, "isCurConfigMatch, model: " + Build.MODEL + ", modelSpecialConfig: " + r17);     // Catch: Exception -> L40
        String r3 = r17.getMinRomVersion();     // Catch: Exception -> L40
        String r5 = r17.getMaxRomVersion();     // Catch: Exception -> L40
        String r6 = RomInfo.INSTANCE.getShortOSVersion();     // Catch: Exception -> L40
        long r7 = com.obric.aiagent.product.a.c.f18771a.d(r6);     // Catch: Exception -> L40
        long r9 = com.obric.aiagent.product.a.c.f18771a.d(r3);     // Catch: Exception -> L40
        long r11 = com.obric.aiagent.product.a.c.f18771a.d(r5);     // Catch: Exception -> L40
        ILogDepend.Companion.i(TAG, "isCurConfigMatch, osVersion: " + r6 + ", osVersionLong: " + r7 + ", minRomVersionLong: " + r9 + ", maxRomVersionLong: " + r11);     // Catch: Exception -> L40
        if (r17.getRomVersionBlackList().contains(r6) == false) goto L17;
    L39:
        return false;
    L17:
        if (r9 <= 0) goto L21;
        if (r7 < r9) goto L39;
    L21:
        if (r11 > 0) goto L23;
    L25:
        int r4 = RomInfo.INSTANCE.getOSReleaseDate();     // Catch: Exception -> L40
        long r8 = r17.getMinRomReleaseDate();     // Catch: Exception -> L40
        long r10 = r17.getMaxRomReleaseDate();     // Catch: Exception -> L40
        ILogDepend.Companion.i(TAG, "isCurConfigMatch, osReleaseDate: " + r4 + ", minRomReleaseDate: " + r8 + ", maxRomReleaseDate: " + r10);     // Catch: Exception -> L40
        if (r8 <= 0) goto L31;
        if (r4 >= r8) goto L31;
    L37:
        return false;
    L31:
        if (1 <= r10) goto L33;
    L35:
        boolean r18 = false;
    L36:
        if (r18 == true) goto L37;
        return true;
    L33:
        if (r10 >= r4) goto L35;
        r18 = true;
        goto L36
    L23:
        if (r7 <= r11) goto L25;
    L40:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "isCurConfigMatch failed, item = " + r15, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return false;
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public String appVariant() {
        if (isObricFeatureEnable() == false) goto L5;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(IBuildContext.Companion.getBuildVariant(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r2.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        r2 = "obric";
    L13:
        return ((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin")) + '_' + Build.BRAND + '_' + Build.MODEL;
    L9:
        r0 = false;
        goto L10
    L5:
        return IBuildContext.Companion.getBuildVariant();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public String getObricProductName() {
        String r0 = f();
        int r1 = r0.hashCode();
        String r2 = IFeatureServiceKt.PRODUCT_EMULATOR;
        switch(r1) {
            case -2002884280: goto L28;
            case -2002884275: goto L24;
            case -1048984789: goto L20;
            case -807117175: goto L17;
            case -80147032: goto L13;
            case 3440915: goto L9;
            case 1336193813: goto L6;
            default: goto L259;
        };
    L259:
        r2 = SensitiveType.UNKNOWN;
    L32:
        boolean r3 = o.a(r2, IFeatureServiceKt.PRODUCT_NERIDA);
        ?? r4 = r2;
        if (r3 == false) goto L39;
        r4 = r2;
        if (Build.VERSION.SDK_INT < 31) goto L39;
        r4 = r2;
        if (o.a(Build.SOC_MODEL, "SM8845") == false) goto L39;
        r4 = IFeatureServiceKt.PRODUCT_NERIDA_LITE;
    L39:
        ILogDepend.Companion.d(TAG, "getObricProductName, osProductName=" + f() + ", productName=" + r4);
        if (o.a(r4, SensitiveType.UNKNOWN) == true) goto L42;
        return r4;
    L42:
        Iterator<Map.Entry<String, ProductInfoConfig>> r15 = this.f18790b.entrySet().iterator();
    L44:
        if (r15.hasNext() == false) goto L227;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r9 = ILogDepend.Companion;
        StringBuilder r10 = new StringBuilder().append("getObricProductName, key: ").append((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin")).append(", manufacturer: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer()).append(", brand: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand()).append(", model: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel()).append(", device: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice()).append(" , ");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice(), Collection.class, "com.obric.aiagent.plugin");
        boolean r12 = false;
        if (r11 != null) goto L48;
    L51:
        boolean r13 = true;
    L52:
        StringBuilder r14 = r10.append(r13).append(", name:").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName()).append(", ");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName(), Collection.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L55;
    L58:
        boolean r17 = true;
    L59:
        r9.i(TAG, r14.append(r17).append(", policy: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getPolicy()).toString());
        if (o.a(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getPolicy(), "and") == true) goto L61;
        if (o.a(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getPolicy(), "or") == false) goto L44;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer(), Collection.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L154;
    L157:
        boolean r7 = true;
    L158:
        if (r7 == true) goto L166;
        List<String> r8 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer();
        if (r8 != null) goto L162;
    L164:
        boolean r18 = false;
    L165:
        if (r18 == false) goto L166;
    L225:
        ILogDepend.Companion.i(TAG, "getObricProductName or, key: " + ((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin")) + ", manufacturer: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer() + ", brand: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand() + ", model: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel() + ", device: " + ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice());
        Object r19 = r5.getKey();
    L226:
        r4 = r19;
        goto L44
    L162:
        if (r8.contains(Build.MANUFACTURER) != true) goto L164;
        r18 = true;
    L166:
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand(), Collection.class, "com.obric.aiagent.plugin");
        if (r20 != null) goto L169;
    L172:
        boolean r21 = true;
    L173:
        if (r21 == true) goto L181;
        List<String> r22 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand();
        if (r22 != null) goto L177;
    L179:
        boolean r23 = false;
    L180:
        if (r23 == true) goto L225;
    L177:
        if (r22.contains(Build.BRAND) != true) goto L179;
        r23 = true;
    L181:
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel(), Collection.class, "com.obric.aiagent.plugin");
        if (r24 != null) goto L184;
    L187:
        boolean r25 = true;
    L188:
        if (r25 == true) goto L196;
        List<String> r26 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel();
        if (r26 != null) goto L192;
    L194:
        boolean r27 = false;
    L195:
        if (r27 == true) goto L225;
    L192:
        if (r26.contains(Build.MODEL) != true) goto L194;
        r27 = true;
    L196:
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName(), Collection.class, "com.obric.aiagent.plugin");
        if (r28 != null) goto L199;
    L202:
        boolean r29 = true;
    L203:
        if (r29 == true) goto L211;
        List<String> r30 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName();
        if (r30 != null) goto L207;
    L209:
        boolean r31 = false;
    L210:
        if (r31 == true) goto L225;
    L207:
        if (r30.contains(Build.PRODUCT) != true) goto L209;
        r31 = true;
    L211:
        Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice(), Collection.class, "com.obric.aiagent.plugin");
        if (r32 != null) goto L214;
    L217:
        boolean r33 = true;
    L218:
        if (r33 == true) goto L44;
        List<String> r34 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice();
        if (r34 != null) goto L222;
    L224:
        if (r12 == false) goto L44;
    L222:
        if (r34.contains(Build.DEVICE) != true) goto L224;
        r12 = true;
        goto L224
    L214:
        if (r32.isEmpty() == true) goto L217;
        r33 = false;
        goto L218
    L199:
        if (r28.isEmpty() == true) goto L202;
        r29 = false;
        goto L203
    L184:
        if (r24.isEmpty() == true) goto L187;
        r25 = false;
        goto L188
    L169:
        if (r20.isEmpty() == true) goto L172;
        r21 = false;
        goto L173
    L154:
        if (r6.isEmpty() == true) goto L157;
        r7 = false;
        goto L158
    L61:
        Collection r35 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer(), Collection.class, "com.obric.aiagent.plugin");
        if (r35 != null) goto L64;
    L67:
        boolean r36 = true;
    L68:
        if (r36 == true) goto L76;
        List<String> r37 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer();
        if (r37 != null) goto L72;
    L74:
        boolean r38 = false;
    L75:
        if (r38 == false) goto L44;
    L72:
        if (r37.contains(Build.MANUFACTURER) != true) goto L74;
        r38 = true;
    L76:
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand(), Collection.class, "com.obric.aiagent.plugin");
        if (r39 != null) goto L79;
    L82:
        boolean r40 = true;
    L83:
        if (r40 == true) goto L91;
        List<String> r41 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand();
        if (r41 != null) goto L87;
    L89:
        boolean r42 = false;
    L90:
        if (r42 == false) goto L44;
    L87:
        if (r41.contains(Build.BRAND) != true) goto L89;
        r42 = true;
    L91:
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel(), Collection.class, "com.obric.aiagent.plugin");
        if (r43 != null) goto L94;
    L97:
        boolean r44 = true;
    L98:
        if (r44 == true) goto L106;
        List<String> r45 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel();
        if (r45 != null) goto L102;
    L104:
        boolean r46 = false;
    L105:
        if (r46 == false) goto L44;
    L102:
        if (r45.contains(Build.MODEL) != true) goto L104;
        r46 = true;
    L106:
        Collection r47 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName(), Collection.class, "com.obric.aiagent.plugin");
        if (r47 != null) goto L109;
    L112:
        boolean r48 = true;
    L113:
        if (r48 == true) goto L121;
        List<String> r49 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName();
        if (r49 != null) goto L117;
    L119:
        boolean r50 = false;
    L120:
        if (r50 == false) goto L44;
    L117:
        if (r49.contains(Build.PRODUCT) != true) goto L119;
        r50 = true;
    L121:
        Collection r51 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice(), Collection.class, "com.obric.aiagent.plugin");
        if (r51 != null) goto L124;
    L127:
        boolean r52 = true;
    L128:
        if (r52 == true) goto L136;
        List<String> r53 = ((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice();
        if (r53 != null) goto L132;
    L134:
        boolean r54 = false;
    L135:
        if (r54 == false) goto L44;
    L132:
        if (r53.contains(Build.DEVICE) != true) goto L134;
        r54 = true;
    L136:
        ILogDepend.Companion r55 = ILogDepend.Companion;
        StringBuilder r56 = new StringBuilder().append("getObricProductName and, key: ").append((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin")).append(", manufacturer: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getManufacturer()).append(", brand: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getBrand()).append(", model: ").append(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getModel()).append(", device: ");
        Collection r57 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getDevice(), Collection.class, "com.obric.aiagent.plugin");
        if (r57 != null) goto L139;
    L142:
        boolean r58 = true;
    L143:
        StringBuilder r59 = r56.append(r58).append(", name: ");
        Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(((ProductInfoConfig) ZeusTransformUtils.preCheckCast(r5.getValue(), ProductInfoConfig.class, "com.obric.aiagent.plugin")).getName(), Collection.class, "com.obric.aiagent.plugin");
        if (r60 != null) goto L146;
    L147:
        r12 = true;
    L148:
        r55.i(TAG, r59.append(r12).toString());
        r19 = r5.getKey();
        goto L226
    L146:
        if (r60.isEmpty() == false) goto L148;
    L139:
        if (r57.isEmpty() == true) goto L142;
        r58 = false;
        goto L143
    L124:
        if (r51.isEmpty() == true) goto L127;
        r52 = false;
        goto L128
    L109:
        if (r47.isEmpty() == true) goto L112;
        r48 = false;
        goto L113
    L94:
        if (r43.isEmpty() == true) goto L97;
        r44 = false;
        goto L98
    L79:
        if (r39.isEmpty() == true) goto L82;
        r40 = false;
        goto L83
    L64:
        if (r35.isEmpty() == true) goto L67;
        r36 = false;
        goto L68
    L55:
        if (r16.isEmpty() == true) goto L58;
        r17 = false;
        goto L59
    L48:
        if (r11.isEmpty() == true) goto L51;
        r13 = false;
        goto L52
    L227:
        ILogDepend.Companion.i(TAG, "getObricProductName, productName: " + ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin")) + ", manufacturer: " + Build.MANUFACTURER + ", brand: " + Build.BRAND + ", model: " + Build.MODEL + ", device: " + Build.DEVICE + ", name: " + Build.PRODUCT);
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
    L6:
        if (r0.equals(IFeatureServiceKt.PRODUCT_EMULATOR) == true) goto L32;
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L9:
        if (r0.equals(IFeatureServiceKt.PRODUCT_PIKE) == false) goto L261;
        r2 = IFeatureServiceKt.PRODUCT_PIKE;
        goto L32
    L261:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L13:
        if (r0.equals(IFeatureServiceKt.PRODUCT_GENESIS) == false) goto L262;
        r2 = IFeatureServiceKt.PRODUCT_GENESIS;
        goto L32
    L262:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L17:
        if (r0.equals("pacific") == false) goto L31;
        r2 = "pacific";
        goto L32
    L31:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L20:
        if (r0.equals(IFeatureServiceKt.PRODUCT_NERIDA) == false) goto L263;
        r2 = IFeatureServiceKt.PRODUCT_NERIDA;
        goto L32
    L263:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L24:
        if (r0.equals(IFeatureServiceKt.PRODUCT_GENESIS_R) == false) goto L264;
        r2 = IFeatureServiceKt.PRODUCT_GENESIS_R;
        goto L32
    L264:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    L28:
        if (r0.equals(IFeatureServiceKt.PRODUCT_GENESIS_M) == false) goto L265;
        r2 = IFeatureServiceKt.PRODUCT_GENESIS_M;
        goto L32
    L265:
        r2 = SensitiveType.UNKNOWN;
        goto L32
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public boolean isObricOs() {
        return d();
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public boolean isEmulatorOs() {
        return e();
    }

    @Override // com.obric.aiagent.product.feature.api.IFeatureService
    public boolean isGlobalEffectStopLayerEffective() {
        return isFeatureEnable("obric_feature_global_effect_stop_layer_effective");
    }
}
