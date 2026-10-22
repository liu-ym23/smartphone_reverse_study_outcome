package com.bytedance.android.live.core.tetris.layer.core.element.tetris;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.tetris.Tetris;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k70.c;
import k70.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t70.g;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00012\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/tetris/RecyclableTetrisElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/Tetris;", "Lh70/b;", "Lk70/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RecyclableTetrisElement extends Element<Tetris<? extends b>> implements d {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map<Class<k>, View> f65681t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f65682u = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f65683l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f65684m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<Element<?>> f65685n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final k f65686o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f65687p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f65688q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final p70.b f65689r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.bytedance.android.live.core.tetris.layer.core.data.b f65690s;

    public static final class a {
        public a() {
        }
    }

    public final Tetris<b> l() {
        return (Tetris) this.f65684m.getValue();
    }

    static {
        f65682u = new a();
        f65681t = new HashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Tetris<? extends b> i() {
        return l();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final o70.a j() {
        if ((l() instanceof o70.a) == false) goto L9;
        LifecycleOwnerCompat r100 = l();
        if (r100 == null) goto L8;
        return (o70.a) r100;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.event.ElementEventResolver");
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void k() {
        l().J();
        if (this.f65686o.k() == false) goto L10;
        View r100 = l().L();
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L7;
        r101 = null;
    L7:
        ViewGroup r102 = (ViewGroup) r101;
        if (r102 == null) goto L10;
        r102.removeView(r100);
    L10:
        ((ArrayList) this.f65685n).clear();
        getLifecycle().removeObserver(l());
        com.bytedance.android.live.core.tetris.componentx.component.b r103 = this.f65661c;
        if (r103 == null) goto L14;
        r103.e(this, l());
        return;
    }

    @Override // k70.d
    public final void a(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        ((ArrayList) this.f65685n).remove(r100);
    }

    @Override // k70.d
    public final void b(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (((ArrayList) this.f65685n).contains(r100) == true) goto L6;
        ((ArrayList) this.f65685n).add(r100);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r100) {
        com.bytedance.android.live.core.tetris.componentx.component.b r101 = this.f65661c;
        if (r101 == null) goto L5;
        r101.c(this, l());
    L5:
        getLifecycle().addObserver(l());
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = l().G((g) this.f65683l.getValue());
        Map<Class<k>, View> r103 = f65681t;
        HashMap r104 = (HashMap) r103;
        r104.put(this.f65686o.getClass(), r102);
        Tetris<b> r105 = l();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f65794h = r102;
        return r102;
    }

    public RecyclableTetrisElement(k r100, c r101, b r102, p70.b r103, com.bytedance.android.live.core.tetris.layer.core.data.b r104) {
        Intrinsics.checkNotNullParameter(r100, "tetrisAttribute");
        Intrinsics.checkNotNullParameter(r101, "elementFactory");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "processChains");
        Intrinsics.checkNotNullParameter(r104, "vmProvider");
        super(r102);
        this.f65686o = r100;
        this.f65687p = r101;
        this.f65688q = r102;
        this.f65689r = r103;
        this.f65690s = r104;
        this.f65683l = LazyKt.lazy(new RecyclableTetrisElement$recyclableTetrisLayoutInflater$2(this));
        this.f65684m = LazyKt.lazy(new RecyclableTetrisElement$tetris$2(this));
        this.f65685n = new ArrayList();
    }
}
