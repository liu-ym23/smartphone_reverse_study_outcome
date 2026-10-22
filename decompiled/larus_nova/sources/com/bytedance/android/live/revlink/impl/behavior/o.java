package com.bytedance.android.live.revlink.impl.behavior;

import android.text.TextUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f92183a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f92184b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f92185c = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(o.class, "ANIM_GAP_MILLS", "getANIM_GAP_MILLS()J", 1)), Reflection.property0(new PropertyReference0Impl(o.class, "TOOLBAR_PK_LEAD_ANIM_FIX", "getTOOLBAR_PK_LEAD_ANIM_FIX()Z", 1))};
        f92183a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("toolbar_pk_entrance_anim_gap_mills", 600L, Long.TYPE, false);
        f92184b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("toolbar_pk_lead_anim_fix", Boolean.TRUE, Boolean.TYPE, false);
        f92185c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }

    public static final b a(LottieAnimationView r100, String r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        final f r103 = new f();
        n r104 = new n(new m0(r102), r103);
        if (TextUtils.isEmpty(r101) == true) goto L9;
        if (ImageUtil.isActivityOK(r100.getContext()) == false) goto L9;
        FrescoLoader.with(r100.getContext()).load(r101).actualScaleType(ImageView.ScaleType.CENTER_CROP).autoPlayAnimations(false).controllerListener(new ImageLoader.e(null, r104, false)).into(r100);
    L9:
        return new b(new ToolbarButtonHelperKt$loadGiftImage$2(r103));
    }
}
