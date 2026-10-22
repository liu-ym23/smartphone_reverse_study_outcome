package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<s> f66748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f66749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f66750c = false;

    static {
        LinkedList r100 = new LinkedList();
        f66748a = r100;
        LinkedList r101 = new LinkedList();
        f66749b = r101;
        boolean r102 = LiveEffectSettings.LIVE_EFFECT_DIGITAL_AVATAR_REPEL_COMPATIBLE.getValue().booleanValue();
        f66750c = r102;
        if (r102 == false) goto L5;
        r100.add(new s("livedigitavatar", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
    L6:
        r100.add(new s("guestfight", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r100.add(new s("teamfight", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r100.add(new s("theme_event", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r100.add(new s("multi_seat_widget", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        r100.add(new s("livegame", Collections.singletonList(3)));
        r100.add(new s(d0.f66757g, Collections.singletonList(5)));
        r100.add(new s("beauty", Arrays.asList(new Integer[]{1, 2, 3})));
        r100.add(new s("magicGestureActivity", Arrays.asList(new Integer[]{1, 2, 3, 4, 5})));
        String r103 = d0.f66759i;
        r100.add(new s(r103, Arrays.asList(new Integer[]{1, 2, 3, 6})));
        String r104 = d0.f66761k;
        r100.add(new s(r104, Arrays.asList(new Integer[]{1, 2, 3, 6})));
        r100.add(new s("effect_gift", Arrays.asList(new Integer[]{1, 3, 5, 6})));
        r100.add(new s("effect_gift_special", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_gift_top_effect", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_interact_gift", Arrays.asList(new Integer[]{1, 3, 5, 6})));
        r100.add(new s("livetakepagegame", Collections.singletonList(3)));
        r100.add(new s("livemoneygame", Collections.singletonList(3)));
        r100.add(new s(d0.f66752b, Arrays.asList(new Integer[]{2, 4})));
        r100.add(new s(d0.f66753c, Collections.singletonList(2)));
        r100.add(new s(d0.f66758h, Collections.singletonList(2)));
        r100.add(new s("livebody", Arrays.asList(new Integer[]{1, 2, 3})));
        String r105 = d0.f66751a;
        r100.add(new s(r105, Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s(d0.f66754d, Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_interact_gift_special", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_interact_gift_pk_env", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_atmosphere", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("live_adjustment", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("live_camera_move", Collections.singletonList(2)));
        r100.add(new s("zongyiyouxi", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r100.add(new s("effect_pk_interact_play", Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6})));
        r101.add(r103);
        r101.add(r104);
        r101.add("live_adjustment");
        r101.add("live_camera_move");
        r101.add(r105);
        return;
    L5:
        r100.add(new s("livedigitavatar", Arrays.asList(new Integer[]{4, 6})));
        goto L6
    }
}
