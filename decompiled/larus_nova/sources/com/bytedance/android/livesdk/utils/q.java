package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f159122a = null;

    public q() {
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
    }

    static {
        f159122a = new q();
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        Event r101 = new Event("live_room_level_change", System.currentTimeMillis(), null, 4, null);
        r101.setMapParams(MapsKt.mapOf(TuplesKt.to("level", Integer.valueOf(r100))));
        EventCenter.enqueueEvent(r101);
        return true;
    }
}
