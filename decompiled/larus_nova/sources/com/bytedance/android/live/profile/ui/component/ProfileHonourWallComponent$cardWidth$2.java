package com.bytedance.android.live.profile.ui.component;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ProfileHonourWallComponent$cardWidth$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ ProfileHonourWallComponent this$0;

    public ProfileHonourWallComponent$cardWidth$2(ProfileHonourWallComponent r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        if (com.bytedance.android.live.profile.j.b() == false) goto L5;
        com.bytedance.android.live.profile.j.a();
    L6:
        this.this$0.getClass();
        throw null;
    L5:
        s1.y();
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_android_live_profile_ui_component_ProfileHonourWallComponent$cardWidth$2_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }
}
