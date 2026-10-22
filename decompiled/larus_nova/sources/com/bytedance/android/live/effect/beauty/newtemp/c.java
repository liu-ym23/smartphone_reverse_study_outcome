package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.j;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f67389d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<Sticker>> f67390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<Effect>> f67391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67392c;

    public static final class a {
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67392c;
    }

    public c(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f67392c = r100;
        this.f67390a = new LinkedHashMap();
        this.f67391b = new LinkedHashMap();
    }

    public static void a(c r100, LiveEffectContextFactoryDelegate$Type r101, WeakReference r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter("inspiration_beautification", "panel");
        Intrinsics.checkNotNullParameter(r101, "type");
        List<String> r103 = LiveEffectContext.f66734h;
        j r104 = LiveEffectContext.a.a(r101).b();
        List r105 = (List) ((LinkedHashMap) r100.f67390a).get("inspiration_beautification");
        if (r105 != null) goto L5;
    L11:
        r104.d().f("inspiration_beautification", new f(r100, r104, r102));
        return;
    L5:
        if ((!r105.isEmpty()) != true) goto L11;
        List<Sticker> r106 = (List) ((LinkedHashMap) r100.f67390a).get("inspiration_beautification");
        if (r106 == null) goto L13;
        q r107 = (q) r102.get();
        if (r107 == null) goto L14;
        r107.a(r106, null);
        return;
    L14:
        return;
    }
}
