package com.bytedance.android.btm.impl.setting;

import android.os.MessageQueue;
import com.bytedance.android.btm.api.BtmHostDependManager;
import com.bytedance.android.btm.api.provider.BtmDefaultConfigProvider;
import com.google.gson.Gson;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class BtmSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f42466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd.c f42467b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f42468c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BtmSetting f42469d = null;

    static {
        f42466a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmSetting.class), DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "getModel()Lcom/bytedance/android/btm/impl/setting/BtmSettingModel;"))};
        f42469d = new BtmSetting();
        f42467b = new cd.c(BtmSetting$model$2.INSTANCE);
        f42468c = LazyKt.lazy(BtmSetting$gson$2.INSTANCE);
    }

    public BtmSetting() {
    }

    public static Gson b() {
        return (Gson) f42468c.getValue();
    }

    public final g c() {
        return (g) f42467b.getValue(this, f42466a[0]);
    }

    public static g d() {
        g r100 = new g();
        BtmHostDependManager r101 = BtmHostDependManager.F;
        r101.getClass();
        zc.h r102 = (zc.h) BtmHostDependManager.f41938f.getValue(r101, BtmHostDependManager.f41933a[4]);
        if (r102 == null) goto L5;
        String r103 = r102.getSetting();
    L6:
        if (r103 == null) goto L15;
        return (g) b().fromJson(r103, g.class);
    L9:
        JSONObject r104 = new JSONObject();
        r104.putOpt("error_code", 1005);
        JSONObject r105 = new JSONObject();
        r105.putOpt("error_message", r103);
        zc.g r106 = BtmHostDependManager.F.f();
        if (r106 == null) goto L17;
        r106.a("btmsdk_monitor", r104, r105);
        return r100;
    L17:
        return r100;
    L15:
        return r100;
    L5:
        r103 = null;
        goto L6
    }

    public final void a() {
        BtmHostDependManager r100 = BtmHostDependManager.F;
        r100.getClass();
        zc.d r101 = (zc.d) BtmHostDependManager.f41939g.getValue(r100, BtmHostDependManager.f41933a[5]);
        if (r101 == null) goto L11;
        monitor-enter(this);
        r101.getSetting();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void e() {
        if (BtmDefaultConfigProvider.b() == false) goto L6;
        MessageQueue r100 = com.bytedance.android.btm.impl.util.b.f42496a;
        com.bytedance.android.btm.impl.util.b.a(BtmSetting$updateLazyDataSettings$1.INSTANCE);
        return;
    }
}
