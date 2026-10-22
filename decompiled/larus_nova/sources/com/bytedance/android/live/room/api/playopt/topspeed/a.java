package com.bytedance.android.live.room.api.playopt.topspeed;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99075a;

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f99075a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        TopSpeedModeManager r101 = TopSpeedModeManager.f99061l;
        List<g61.a> r102 = TopSpeedModeManager.f99061l.f99070i.get(this.f99075a);
        StringBuilder r103 = new StringBuilder("the scene listeners size ");
        if (r102 == null) goto L5;
        Integer r104 = Integer.valueOf(r102.size());
    L6:
        r103.append(r104);
        ALogger.w("LiveTopSpeedLog", r103.toString());
        boolean r105 = false;
        if (r100 >= 0) goto L14;
        if (r102 == null) goto L13;
        Iterator<T> r106 = r102.iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        r105 = ((g61.a) r106.next()).b();
        ALogger.w("LiveTopSpeedLog", "the scene " + this.f99075a + " was degrade");
    L13:
        TopSpeedModeManager r107 = TopSpeedModeManager.f99061l;
        TopSpeedModeManager r108 = TopSpeedModeManager.f99061l;
        String r109 = this.f99075a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "scene");
        r108.f99064c.add(r109);
    L20:
        return r105;
    L14:
        if (r102 == null) goto L19;
        Iterator<T> r110 = r102.iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        r105 = ((g61.a) r110.next()).a();
        ALogger.w("LiveTopSpeedLog", "the scene " + this.f99075a + " was origin");
    L19:
        TopSpeedModeManager r111 = TopSpeedModeManager.f99061l;
        TopSpeedModeManager r112 = TopSpeedModeManager.f99061l;
        String r113 = this.f99075a;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "scene");
        r112.f99064c.remove(r113);
        goto L20
    L5:
        r104 = null;
        goto L6
    }
}
