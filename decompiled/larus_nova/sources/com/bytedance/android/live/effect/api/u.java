package com.bytedance.android.live.effect.api;

import com.bytedance.android.live.effect.composer.LiveComposerManagerB;
import java.util.EnumMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<LiveEffectContextFactoryDelegate$Type, e> f66774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<LiveEffectContextFactoryDelegate$Type, ILiveEffectComposerManager> f66775b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<LiveEffectContextFactoryDelegate$Type, g> f66776c = null;

    static {
        f66774a = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f66775b = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
        f66776c = new EnumMap(LiveEffectContextFactoryDelegate$Type.class);
    }

    public static e a(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        EnumMap r101 = (EnumMap) f66774a;
        if (r101.containsKey(r100) == true) goto L5;
    L6:
        r101.put(r100, new LiveEffectBaseContext(r100));
    L7:
        Object r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102);
        return (e) r102;
    L5:
        if (r101.get(r100) != null) goto L7;
        goto L6
    }

    public static g b(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        EnumMap r101 = (EnumMap) f66776c;
        if (r101.containsKey(r100) == true) goto L5;
    L6:
        r101.put(r100, new LiveEffectBaseService(r100));
    L7:
        Object r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102);
        return (g) r102;
    L5:
        if (r101.get(r100) != null) goto L7;
        goto L6
    }

    public static ILiveEffectComposerManager c(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        EnumMap r101 = (EnumMap) f66775b;
        if (r101.containsKey(r100) == true) goto L5;
    L6:
        r101.put(r100, new LiveComposerManagerB(r100));
    L7:
        Object r102 = r101.get(r100);
        Intrinsics.checkNotNull(r102);
        return (ILiveEffectComposerManager) r102;
    L5:
        if (r101.get(r100) != null) goto L7;
        goto L6
    }
}
