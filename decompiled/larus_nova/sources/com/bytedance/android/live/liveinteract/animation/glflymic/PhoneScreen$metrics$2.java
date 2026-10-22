package com.bytedance.android.live.liveinteract.animation.glflymic;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/util/DisplayMetrics;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class PhoneScreen$metrics$2 extends Lambda implements Function0<DisplayMetrics> {
    final /* synthetic */ Resources $resource;

    public PhoneScreen$metrics$2(Resources r100) {
        this.$resource = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DisplayMetrics invoke() {
        return INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_animation_glflymic_PhoneScreen$metrics$2_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.$resource);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DisplayMetrics invoke() {
        return invoke();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_liveinteract_animation_glflymic_PhoneScreen$metrics$2_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
