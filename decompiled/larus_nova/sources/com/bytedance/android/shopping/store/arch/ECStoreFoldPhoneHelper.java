package com.bytedance.android.shopping.store.arch;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.google.gson.annotations.SerializedName;
import com.lynx.tasm.LynxView;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import nj.d;

/* JADX INFO: loaded from: classes14.dex */
public final class ECStoreFoldPhoneHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f183487a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/arch/ECStoreFoldPhoneHelper$a;", "", "", "", "ignoreList", "[Ljava/lang/String;", "getIgnoreList", "()[Ljava/lang/String;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("ignore_list")
        private final String[] ignoreList;

        public a() {
            this.ignoreList = new String[0];
        }
    }

    public static d e() {
        return (d) f183487a.getValue();
    }

    static {
        f183487a = LazyKt.lazy(ECStoreFoldPhoneHelper$service$2.INSTANCE);
        new AtomicInteger();
    }

    public static boolean d() {
        Lazy r100 = ECAppInfoService.f48110a;
        if (we.a.f559330a == true) goto L10;
        d r101 = e();
        if (r101 == null) goto L8;
        r101.h();
    L8:
        return false;
    L10:
        return g();
    }

    public static boolean g() {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        boolean r101 = false;
        if (we.a.f559330a == false) goto L47;
        com.bytedance.android.shopping.store.arch.a r102 = com.bytedance.android.shopping.store.arch.a.f183498g;
        Context r103 = r100.getApplicationContext();
        r102.getClass();
        if (r103 == null) goto L56;
        Boolean r104 = com.bytedance.android.shopping.store.arch.a.f183492a;
        if (r104 != null) goto L53;
        Context r105 = r103.getApplicationContext();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L41
        String r107 = Build.BRAND;     // Catch: Throwable -> L41
        if (StringsKt.equals(r107, RomUtils.BRAND_HUAWEI, true) == false) goto L21;
        if (r105.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture") == false) goto L16;
    L26:
        r101 = true;
    L39:
        Object r108 = Result.m9449constructorimpl(Boolean.valueOf(r101));     // Catch: Throwable -> L41
    L43:
        Boolean r109 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r108) == false) goto L46;
        r108 = r109;
    L46:
        boolean r110 = ((Boolean) r108).booleanValue();
        com.bytedance.android.shopping.store.arch.a.f183492a = Boolean.valueOf(r110);
        return r110;
    L16:
        if (com.bytedance.android.shopping.store.arch.a.f183493b.contains(Build.DEVICE) == true) goto L26;
        if (com.bytedance.android.shopping.store.arch.a.f183494c.contains(Build.MODEL) == false) goto L39;
    L21:
        if (StringsKt.equals(r107, RomUtils.BRAND_HONOR, true) == false) goto L28;
        if (r105.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == true) goto L26;
        if (com.bytedance.android.shopping.store.arch.a.f183495d.contains(Build.DEVICE) == false) goto L39;
    L28:
        if (StringsKt.equals(r107, AppConstants.CHANNEL_OPPO, true) == false) goto L31;
        r101 = com.bytedance.android.shopping.store.arch.a.b();     // Catch: Throwable -> L41
        goto L39
    L31:
        if (StringsKt.equals(r107, DimLocationCheckUtil.VIVO, true) == false) goto L34;
        Class r111 = com.bytedance.android.shopping.store.arch.a.a("android.util.FtDeviceInfo");     // Catch: Throwable -> L41
        r101 = Intrinsics.areEqual(r111.getMethod("getDeviceType", new Class[0]).invoke(r111, new Object[0]), "foldable");     // Catch: Throwable -> L41
        goto L39
    L34:
        if (StringsKt.equals(r107, DimLocationCheckUtil.XIAOMI, true) == false) goto L37;
        r101 = com.bytedance.android.shopping.store.arch.a.d();     // Catch: Throwable -> L41
        goto L39
    L37:
        if (StringsKt.equals(r107, SmEditTextLeakOpt.SAMSUNG, true) == false) goto L39;
        r101 = com.bytedance.android.shopping.store.arch.a.c();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L53:
        return r104.booleanValue();
    L56:
        return false;
    L47:
        d r113 = e();
        if (r113 == null) goto L55;
        r113.isFold();
        return false;
    L55:
        return false;
    }

    public static void a(Fragment r100) {
        if (r100 == null) goto L7;
        d r101 = e();
        if (r101 == null) goto L8;
        r100.requireActivity();
        r101.m();
        return;
    L8:
        return;
    }

    public static String b(String r100) {
        if (d() == false) goto L7;
        d r101 = e();
        if (r101 == null) goto L7;
        r101.a();
    L7:
        return r100;
    }

    public static void c(Fragment r100) {
        if (r100 == null) goto L7;
        d r101 = e();
        if (r101 == null) goto L8;
        r100.requireActivity();
        r101.n();
        return;
    L8:
        return;
    }

    public static void f(Fragment r100) {
        if (d() == false) goto L23;
        IBinder r101 = null;
        if (r100 == null) goto L7;
        Context r102 = r100.getContext();
    L8:
        if (r100 == null) goto L10;
        View r103 = r100.getView();
    L11:
        if (r102 == null) goto L13;
        Object r104 = r102.getSystemService("input_method");
    L15:
        if ((r104 instanceof InputMethodManager) == true) goto L17;
        r104 = null;
    L17:
        InputMethodManager r105 = (InputMethodManager) r104;
        if (r105 == null) goto L24;
        if (r103 == null) goto L21;
        r101 = r103.getWindowToken();
    L21:
        r105.hideSoftInputFromWindow(r101, 0);
        return;
    L24:
        return;
    L13:
        r104 = null;
        goto L15
    L10:
        r103 = null;
        goto L11
    L7:
        r102 = null;
        goto L8
    }

    public static boolean h(Activity r100) {
        d r101 = e();
        if (r101 == null) goto L7;
        r101.l();
        return false;
    L7:
        return false;
    }

    public static void i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        if (d() == false) goto L24;
        boolean r101 = r100 instanceof LynxView;
        if (r101 == false) goto L25;
        Point r102 = l0.f(((LynxView) r100).getContext());
        if (r102 == null) goto L9;
        Integer r103 = Integer.valueOf(r102.x);
    L10:
        if (r102 == null) goto L12;
        Integer r104 = Integer.valueOf(r102.y);
    L13:
        if (r103 == null) goto L26;
        if (r104 == null) goto L27;
        d r105 = e();
        if (r105 == null) goto L18;
        r105.a();
    L18:
        if (r101 == true) goto L20;
        r100 = null;
    L20:
        LynxView r106 = (LynxView) r100;
        if (r106 == null) goto L28;
        r106.updateScreenMetrics(r103.intValue(), r104.intValue());
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L12:
        r104 = null;
        goto L13
    L9:
        r103 = null;
        goto L10
    L25:
        return;
    }
}
