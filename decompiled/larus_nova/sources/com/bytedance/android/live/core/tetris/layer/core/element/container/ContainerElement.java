package com.bytedance.android.live.core.tetris.layer.core.element.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.template.delegate.BaseTemplateDelegate;
import com.bytedance.android.live.core.tetris.template.loader.TemplateLoader;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import h70.b;
import j70.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k70.c;
import k70.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00020\u00012\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/element/container/ContainerElement;", "Lcom/bytedance/android/live/core/tetris/layer/core/element/Element;", "Lcom/bytedance/android/live/core/tetris/template/loader/TemplateLoader;", "Lh70/b;", "Lk70/d;", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ContainerElement extends Element<TemplateLoader<? extends b>> implements d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f65670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<Element<?>> f65671m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j70.b f65672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f65673o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b80.a f65674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final p70.b f65675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.live.core.tetris.layer.core.data.b f65676r;

    public final TemplateLoader<b> l() {
        return (TemplateLoader) this.f65670l.getValue();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final Lifecycle g() {
        return l().getLifecycle();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final TemplateLoader<? extends b> i() {
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
        TemplateLoader<b> r100 = l();
        Iterator r101 = ((ArrayList) r100.f65934a).iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Element<?> r102 = (Element) r101.next();
        d r103 = r100.f65937d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("elementGroup");
    L8:
        r103.a(r102);
        r100.getLifecycle().removeObserver(r102);
        r102.e();
        com.bytedance.android.live.core.tetris.componentx.component.b r104 = r100.f65941h;
        if (r104 == null) goto L4;
        r104.b(r102);
        goto L4
    L11:
        Lifecycle.State r105 = r100.getLifecycle().getCurrentState();
        int r106 = c80.a.f22702a[r105.ordinal()];
        if (r106 != 3) goto L14;
        r100.onDestroy();
    L21:
        ((ArrayList) r100.f65934a).clear();
        ((ArrayList) this.f65671m).clear();
        LifecycleOwnerCompat.CC.$default$getLifecycle(this).removeObserver(l());
        return;
    L14:
        if (r106 != 4) goto L16;
        r100.onStop();
        r100.onDestroy();
        goto L21
    L16:
        if (r106 != 5) goto L21;
        r100.onPause();
        r100.onStop();
        r100.onDestroy();
        goto L21
    }

    @Override // k70.d
    public final void a(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        ((ArrayList) this.f65671m).remove(r100);
        m(false, r100);
    }

    @Override // k70.d
    public final void b(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if (((ArrayList) this.f65671m).contains(r100) == true) goto L6;
        ((ArrayList) this.f65671m).add(r100);
        m(true, r100);
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final void onViewCreated(View r100) {
        LifecycleOwnerCompat.CC.$default$getLifecycle(this).addObserver(l());
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.element.Element
    public final View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f65672n.n(r100);
        ConstraintLayout r102 = new ConstraintLayout(this.f65669k.getContext());
        if (this.f65672n.y() <= 0) goto L11;
        r102.setId(this.f65672n.y());
    L11:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        View r104 = new View(this.f65669k.getContext());     // Catch: Throwable -> L7
        r104.setVisibility(8);     // Catch: Throwable -> L7
        r104.setId(ViewCompat.generateViewId());     // Catch: Throwable -> L7
        r102.addView(r104, new ConstraintLayout.LayoutParams(1, 1));     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        TemplateLoader<b> r105 = l();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r105.f65939f = r102;
        return r102;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [C extends h70.b, T extends h70.b, java.lang.Object] */
    public final void m(boolean r100, Element<?> r101) {
        b80.a r102 = this.f65674p;
        if (r102 == null) goto L41;
        List<BaseTemplateDelegate<? extends b>> r103 = r102.a();
        if (r103 == null) goto L57;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L58;
        BaseTemplateDelegate r105 = (BaseTemplateDelegate) r104.next();
        if (r100 == true) goto L11;
        f r106 = r101.f65662d;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "elementType");
        if (r105.f65931c.containsKey(r106) == false) goto L37;
        Intrinsics.checkNotNullParameter(r106, "elementType");
        Element<?> r107 = (Element) ((LinkedHashMap) r105.f65931c).get(r106);
        r105.f65931c.remove(r106);
        if (r107 == null) goto L37;
        r105.b(r107);
    L37:
        if (r105.f65932d.containsKey(r106) == false) goto L8;
        l70.a r108 = (l70.a) ((LinkedHashMap) r105.f65932d).get(r106);
        if (r108 == null) goto L8;
        r108.d();
        goto L8
    L11:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "element");
        r105.f65931c.put(r101.f65662d, r101);
        r105.a(r101);
        if (r105.f65932d.containsKey(r101.f65662d) == false) goto L8;
        l70.a r109 = (l70.a) ((LinkedHashMap) r105.f65932d).get(r101.f65662d);
        if (r109 == null) goto L19;
        ?? r110 = r105.f65930b;
        if (r110 != 0) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("layerContext");
    L18:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r109.f507762a = r110;
    L19:
        if (r109 == null) goto L21;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r109.f507765d = r105;
    L21:
        if (r109 == null) goto L23;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r109.f507764c = r105;
    L23:
        if (r109 == null) goto L29;
        v70.c r111 = r101.h();
        if (r111 == null) goto L28;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r109.f507763b = r111;
        goto L29
    L28:
        throw new RuntimeException(r101.f65662d + " is invalid.");
    L29:
        if (r109 == null) goto L8;
        r109.c();
        goto L8
    L58:
        return;
    L57:
        return;
    }

    public ContainerElement(j70.b r100, c r101, b r102, b80.a r103, p70.b r104, com.bytedance.android.live.core.tetris.layer.core.data.b r105) {
        Intrinsics.checkNotNullParameter(r100, "containerAttribute");
        Intrinsics.checkNotNullParameter(r101, "elementFactory");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "processChains");
        Intrinsics.checkNotNullParameter(r105, "vmProvider");
        super(r102);
        this.f65672n = r100;
        this.f65673o = r101;
        this.f65674p = r103;
        this.f65675q = r104;
        this.f65676r = r105;
        this.f65670l = LazyKt.lazy(new ContainerElement$templateLoader$2(this));
        this.f65671m = new ArrayList();
    }
}
