package com.bytedance.android.live.effect.soundeffect;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Long> f68136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Long> f68137b = null;

    public h() {
    }

    static {
        f68136a = new LinkedHashMap();
        f68137b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(Sticker r100, LiveEffectContextFactoryDelegate$Type r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "type");
        long r102 = System.currentTimeMillis();
        Map<String, Long> r103 = f68136a;
        Long r104 = (Long) ((LinkedHashMap) r103).get(r100.getEffectId());
        if (r104 == null) goto L5;
        long r105 = r104.longValue();
    L6:
        b(r100, "live_voice_resource_download", r101, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("duration_ms", String.valueOf((r102 - r105) * 1.0f))}));
        r103.put(r100.getEffectId(), 0L);
        return;
    L5:
        r105 = 0;
        goto L6
    }

    public static /* synthetic */ void c(Sticker r100, String r101, LiveEffectContextFactoryDelegate$Type r102) {
        b(r100, r101, r102, new HashMap());
    }

    public static void b(Sticker r100, String r101, LiveEffectContextFactoryDelegate$Type r102, HashMap r103) {
        r103.put(MobConstants.EFFECT_ID, r100.getEffectId());
        String r104 = r100.getName();
        if (r104 == null) goto L5;
        r103.put(MobConstants.EFFECT_NAME, r104);
    L5:
        List<String> r105 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(r102).e().sendLog(r101, r103);
    }
}
