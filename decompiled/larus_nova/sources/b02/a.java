package b02;

import androidx.camera.core.RetryPolicy;
import com.bytedance.android.livesdk.gift.configmodel.o2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.message.model.o7;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f16821a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f16822b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f16823c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_BIG_GIFT_COMBO_CLICK_AREA_OPT", "getLIVE_BIG_GIFT_COMBO_CLICK_AREA_OPT()I", 1)), Reflection.property0(new PropertyReference0Impl(a.class, "LIVE_BIG_GIFT_COMBO_ANIM_LEAK_FIX", "getLIVE_BIG_GIFT_COMBO_ANIM_LEAK_FIX()Z", 1))};
        f16821a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_click_area_opt", 0, Integer.TYPE, false);
        f16822b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_gift_combo_anim_leak_fix", Boolean.FALSE, Boolean.TYPE, false);
        f16823c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }

    public static final long a() {
        if (nz1.a.e() != 0) goto L6;
        return RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
    L6:
        return ((long) nz1.a.e()) * 1000;
    }

    public static final boolean e() {
        if (com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable() == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) nz1.a.T.getValue(null, nz1.a.f521324a[44])).booleanValue() == true) goto L8;
        return false;
    }

    public static final boolean b(NormalGiftMessage r100) {
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L15;
        if (r100 == null) goto L13;
        o7 r101 = r100.r();
        if (r101 == null) goto L13;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L13;
        if (r102.getTrayGroupMode() != 2) goto L13;
        return false;
    L13:
        return true;
    L15:
        return com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable();
    }

    public static final boolean c(o7 r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L12;
        o0 r101 = r100.getTrayInfo();
        if (r101 != null) goto L7;
    L10:
        return true;
    L7:
        if (r101.getTrayGroupMode() != 2) goto L10;
        return false;
    L12:
        return com.bytedance.android.livesdk.gift.platform.business.j.b().getEnable();
    }

    public static final boolean d(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.bytedance.android.livesdk.gift.platform.business.j.a() == false) goto L11;
        o7 r101 = r100.r();
        if (r101 == null) goto L11;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L11;
        if (r102.getTrayGroupMode() != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static final int f(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        o7 r101 = r100.r();
        if (r101 == null) goto L10;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L10;
        Integer r103 = r102.getExpensiveTrayGroupNum();
        if (r103 == null) goto L10;
        return r103.intValue();
    L10:
        return ((Number) com.bytedance.android.livesdk.gift.platform.business.e.D.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.f129015a[28])).intValue();
    }

    public static final int g(NormalGiftMessage r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        o7 r101 = r100.r();
        if (r101 == null) goto L10;
        o0 r102 = r101.getTrayInfo();
        if (r102 == null) goto L10;
        Integer r103 = r102.getRegularTrayGroupNum();
        if (r103 == null) goto L10;
        return r103.intValue();
    L10:
        return ((o2) t02.a.f544122b.getValue(null, t02.a.f544121a[0])).b();
    }
}
