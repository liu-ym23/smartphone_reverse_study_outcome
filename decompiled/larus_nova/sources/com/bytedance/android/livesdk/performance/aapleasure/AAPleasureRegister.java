package com.bytedance.android.livesdk.performance.aapleasure;

import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdkapi.service.AtomicAbility;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class AAPleasureRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, f> f154408a = null;

    static {
        f154408a = new HashMap();
    }

    public static void c() {
        a(AtomicAbilityLabel.live_resource_brightness_service, AAPleasureRegister$registerStatic$1.INSTANCE);
        a(AtomicAbilityLabel.live_resource_trace_report, AAPleasureRegister$registerStatic$2.INSTANCE);
        a(AtomicAbilityLabel.live_resource_preview_behavior, AAPleasureRegister$registerStatic$3.INSTANCE);
        a(AtomicAbilityLabel.live_resource_report_logger_behavior, AAPleasureRegister$registerStatic$4.INSTANCE);
        a(AtomicAbilityLabel.live_resource_preview_guide_anim, AAPleasureRegister$registerStatic$5.INSTANCE);
        a(AtomicAbilityLabel.live_resource_preview_extend_area_anim, AAPleasureRegister$registerStatic$6.INSTANCE);
        a(AtomicAbilityLabel.live_resource_preview_bottom_extend_anim, AAPleasureRegister$registerStatic$7.INSTANCE);
        a(AtomicAbilityLabel.live_resource_preview_hot_comment_anim, AAPleasureRegister$registerStatic$8.INSTANCE);
        a(AtomicAbilityLabel.live_resource_performance_behavior, AAPleasureRegister$registerStatic$9.INSTANCE);
        a(AtomicAbilityLabel.live_resource_alogger_behavior, AAPleasureRegister$registerStatic$10.INSTANCE);
        a(AtomicAbilityLabel.live_resource_user_behavior_monitor_behavior, AAPleasureRegister$registerStatic$11.INSTANCE);
        a(AtomicAbilityLabel.live_resource_move_sampling_behavior, AAPleasureRegister$registerStatic$12.INSTANCE);
        a(AtomicAbilityLabel.live_resource_hour_rank_anim, AAPleasureRegister$registerStatic$13.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_radio_base_degrade, AAPleasureRegister$registerStatic$14.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_video_link_enable, AAPleasureRegister$registerStatic$15.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_toolbar_degrade, AAPleasureRegister$registerStatic$16.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_sei_consume, AAPleasureRegister$registerStatic$17.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_dynamic_bg, AAPleasureRegister$registerStatic$18.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_video_effect, AAPleasureRegister$registerStatic$19.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_base_degrade, AAPleasureRegister$registerStatic$20.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_extreme_degrade, AAPleasureRegister$registerStatic$21.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_battle_base_degrade, AAPleasureRegister$registerStatic$22.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_ktv_base, AAPleasureRegister$registerStatic$23.INSTANCE);
        a(AtomicAbilityLabel.live_resource_multilink_ktv_preview_song, AAPleasureRegister$registerStatic$24.INSTANCE);
        a(AtomicAbilityLabel.live_resource_anniex_monitor, AAPleasureRegister$registerStatic$25.INSTANCE);
    }

    public static void a(AtomicAbilityLabel r100, Function0 r101) {
        AtomicAbility r102 = (AtomicAbility) r101.invoke();
        if (r102 == null) goto L6;
        f r103 = new f(r100.getLabel());
        r103.f154436a = r102;
        Map r104 = MapsKt.emptyMap();
        i0.c().post(new e(r103, r104));
        f r105 = f154408a.put(r100.getLabel(), r103);
        return;
    }

    public static void b(String r100, AtomicAbility r101) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r101, "ability");
        HashMap<String, f> r102 = f154408a;
        if (r102.containsKey(r100) == false) goto L9;
        f r103 = r102.get(r100);
        if (r103 == null) goto L15;
        if (r101 == null) goto L17;
        r103.f154436a = r101;
        r103.f154437b = 0;
        r103.f154438c = "0";
        r103.a(2);
        return;
    L17:
        return;
    L15:
        return;
    L9:
        f r104 = new f(r100);
        if (r101 == null) goto L13;
        r104.f154436a = r101;
        Map r105 = MapsKt.emptyMap();
        i0.c().post(new e(r104, r105));
    L13:
        r102.put(r100, r104);
    }
}
