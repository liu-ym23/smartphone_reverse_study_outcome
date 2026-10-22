package com.bytedance.android.live.effect.api;

import com.ss.android.ugc.effectmanager.EffectManager;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveEffectContext {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<String> f66734h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f66735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f66736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f66737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f66738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f66739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f66740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66741g;

    public static final class a {
        @JvmStatic
        public static LiveEffectContext a(LiveEffectContextFactoryDelegate$Type r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Map<LiveEffectContextFactoryDelegate$Type, LiveEffectContext> r101 = b0.f66746a;
            Intrinsics.checkNotNullParameter(r100, "type");
            EnumMap r102 = (EnumMap) b0.f66746a;
            if (r102.containsKey(r100) == true) goto L5;
        L6:
            r102.put(r100, new LiveEffectContext(r100));
        L7:
            Object r103 = r102.get(r100);
            Intrinsics.checkNotNull(r103);
            return (LiveEffectContext) r103;
        L5:
            if (r102.get(r100) != null) goto L7;
            goto L6
        }
    }

    @JvmStatic
    public static final LiveEffectContext f(LiveEffectContextFactoryDelegate$Type r100) {
        return a.a(r100);
    }

    public final e c() {
        return (e) this.f66738d.getValue();
    }

    public final EffectManager d() {
        return (EffectManager) this.f66737c.getValue();
    }

    static {
        f66734h = CollectionsKt.listOf(new String[]{d0.f66759i, "beauty", d0.f66751a, d0.f66761k, "livebody", d0.f66753c});
    }

    public final j b() {
        Map<LiveEffectContextFactoryDelegate$Type, LiveEffectContext> r100 = b0.f66746a;
        LiveEffectContextFactoryDelegate$Type r101 = this.f66741g;
        Intrinsics.checkNotNullParameter(r101, "type");
        EnumMap r102 = (EnumMap) b0.f66747b;
        if (r102.containsKey(r101) == true) goto L5;
    L6:
        r102.put(r101, new com.bytedance.android.live.effect.j(r101));
    L7:
        Object r103 = r102.get(r101);
        Intrinsics.checkNotNull(r103);
        return (j) r103;
    L5:
        if (r102.get(r101) != null) goto L7;
        goto L6
    }

    public final ILiveEffectComposerManager a() {
        return c().c();
    }

    public final c e() {
        return c().hostService();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f66741g;
    }

    public LiveEffectContext(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f66741g = r100;
        this.f66736b = true;
        this.f66737c = LazyKt.lazy(new LiveEffectContext$effectManager$2(this));
        this.f66738d = LazyKt.lazy(new LiveEffectContext$baseEffectContext$2(this));
        this.f66739e = LazyKt.lazy(new LiveEffectContext$baseEffectService$2(this));
        this.f66740f = LazyKt.lazy(LiveEffectContext$baseProxy$2.INSTANCE);
    }
}
