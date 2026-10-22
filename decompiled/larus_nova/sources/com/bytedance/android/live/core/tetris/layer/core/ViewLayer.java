package com.bytedance.android.live.core.tetris.layer.core;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.tetris.layer.core.delegate.DefaultViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.LayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.core.layout.CircleDependException;
import com.bytedance.android.live.core.tetris.layer.core.layout.c;
import com.bytedance.android.live.core.tetris.layer.core.layout.e;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import h70.b;
import i70.a;
import j70.d;
import j70.f;
import j70.g;
import j70.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u0012\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00050\u000bH\u0016R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/ViewLayer;", "Lcom/bytedance/android/live/core/tetris/layer/view/staticlayout/StaticFullScreenViewLayer;", "Li70/a;", "", "Lj70/h;", "Lh70/b;", "getDescriptorSet", "Lf70/b;", "getLayerTypeV2", "Lcom/bytedance/android/live/core/tetris/layer/initialization/LayerIndex;", "getLayerIndex", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/LayerDelegate;", "getLayerDelegate", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "d", "Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "getLayerDelegate$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;", "setLayerDelegate$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/delegate/ViewLayerDelegate;)V", "layerDelegate", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "e", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "getLayoutListener$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;", "setLayoutListener$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/layout/e;)V", "layoutListener", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "f", "Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "getGlobalElementCenter$tetris_saasRelease", "()Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;", "setGlobalElementCenter$tetris_saasRelease", "(Lcom/bytedance/android/live/core/tetris/layer/core/layout/a;)V", "globalElementCenter", "", ce.f26391f, "Z", "isInLayout$tetris_saasRelease", "()Z", "setInLayout$tetris_saasRelease", "(Z)V", "isInLayout", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewLayer extends StaticFullScreenViewLayer implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewLayerDelegate<b> f65636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f65637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.core.tetris.layer.core.layout.a f65638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f65639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f70.b f65640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LayerIndex f65641i;

    @Override // i70.a
    public Set<h<b>> getDescriptorSet() {
        Set r100 = this.f65636d.f65647e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptor<com.bytedance.android.live.core.tetris.layer.LayerContext>>");
    }

    public final com.bytedance.android.live.core.tetris.layer.core.layout.a getGlobalElementCenter$tetris_saasRelease() {
        return this.f65638f;
    }

    @Override // i70.a
    public LayerDelegate<? extends a, ? extends b> getLayerDelegate() {
        return this.f65636d;
    }

    public final ViewLayerDelegate<b> getLayerDelegate$tetris_saasRelease() {
        return this.f65636d;
    }

    @Override // i70.a
    public LayerIndex getLayerIndex() {
        return this.f65641i;
    }

    @Override // i70.a
    public f70.b getLayerTypeV2() {
        return this.f65640h;
    }

    public final e getLayoutListener$tetris_saasRelease() {
        return this.f65637e;
    }

    @Override // i70.a
    public final void F(d<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        ViewLayerDelegate<b> r101 = this.f65636d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        r101.f65647e.add(r100);
    }

    public final void R5(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        if ((r100.f65662d instanceof g) == false) goto L7;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r101 = this.f65638f;
        if (r101 == null) goto L7;
        r101.d(this, r100);
    L7:
        ViewLayerDelegate<b> r102 = this.f65636d;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "element");
        r102.f65646d.put(r100.f65662d, r100);
    }

    public final void S5(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        this.f65636d.b(r100);
        int r101 = f90.a.f475948a;
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    public final int T5(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        ViewLayerDelegate<b> r101 = this.f65636d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Element r102 = (Element) ((LinkedHashMap) r101.f65646d).get(r100);
        if (r102 == null) goto L7;
        View r103 = r102.f65660b;
        if (r103 == null) goto L7;
        return r103.getId();
    L7:
        return -1;
    }

    public final List<h<b>> U5(b r110) {
        Intrinsics.checkNotNullParameter(r110, "layerContext");
        int r100 = com.bytedance.android.live.core.tetris.layer.core.layout.d.f65786a;
        Intrinsics.checkNotNullParameter(this, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r110, "layerContext");
        LinkedHashMap r101 = new LinkedHashMap();
        LinkedHashMap r102 = new LinkedHashMap();
        int r103 = 0;
        LocalTestManager.a(new Class[]{wy.a.class});
        Iterator<T> r104 = getDescriptorSet().iterator();
    L4:
        if (r104.hasNext() == false) goto L28;
        h r105 = (h) r104.next();
        com.bytedance.android.live.core.tetris.layer.view.b r106 = r105.K(r110);
        if (r106 == null) goto L4;
        f r107 = r105.C(r110);
        Iterator r108 = ((ArrayList) r106.f65879a).iterator();
    L8:
        boolean r109 = r108.hasNext();
        int r111 = com.bytedance.android.live.core.tetris.layer.core.layout.d.f65786a;
        if (r109 == false) goto L18;
        f r112 = (f) r108.next();
        if (Intrinsics.areEqual(r107, r112) == true) goto L17;
        LocalTestManager.a(new Class[]{wy.a.class});
        com.bytedance.android.live.core.tetris.layer.core.layout.d.b(r101, r102, r107, r112);     // Catch: CircleDependException -> L15
    L15:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L8
    L17:
        throw new RuntimeException(r105.getClass().getSimpleName().concat(" zOrder 中不能对自己作比较"));
    L18:
        Iterator r113 = ((ArrayList) r106.f65880b).iterator();
    L20:
        if (r113.hasNext() == false) goto L4;
        f r114 = (f) r113.next();
        if (Intrinsics.areEqual(r107, r114) == true) goto L27;
        com.bytedance.android.live.core.tetris.layer.core.layout.d.b(r101, r102, r114, r107);     // Catch: CircleDependException -> L25
    L25:
        LocalTestManager.a(new Class[]{wy.a.class});
        goto L20
    L27:
        throw new RuntimeException(r105.getClass().getSimpleName().concat(" zOrder 中不能对自己作比较"));
    L28:
        Set<h<b>> r115 = getDescriptorSet();
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L30:
        if (r117.hasNext() == false) goto L39;
        Object r118 = r117.next();
        com.bytedance.android.live.core.tetris.layer.view.b r119 = ((h) r118).K(r110);
        if (r119 != null) goto L34;
    L36:
        boolean r120 = false;
    L37:
        if (r120 == false) goto L30;
        r116.add(r118);
        goto L30
    L34:
        if (r119.f65881c != true) goto L36;
        r120 = true;
        goto L37
    L39:
        Set<h<b>> r121 = getDescriptorSet();
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L41:
        if (r123.hasNext() == false) goto L50;
        Object r124 = r123.next();
        com.bytedance.android.live.core.tetris.layer.view.b r125 = ((h) r124).K(r110);
        if (r125 != null) goto L45;
    L47:
        boolean r126 = false;
    L48:
        if (r126 == false) goto L41;
        r122.add(r124);
        goto L41
    L45:
        if (r125.f65882d != true) goto L47;
        r126 = true;
        goto L48
    L50:
        ArrayList r127 = new ArrayList();
        Iterator r128 = CollectionsKt.sortedWith(MapsKt.toList(r102), new c()).iterator();
    L52:
        if (r128.hasNext() == false) goto L69;
        Pair r129 = (Pair) r128.next();
        Iterator<T> r130 = getDescriptorSet().iterator();
    L55:
        if (r130.hasNext() == false) goto L59;
        Object r131 = r130.next();
        if (Intrinsics.areEqual(((h) r131).C(r110), (f) r129.getFirst()) == false) goto L55;
    L60:
        h r132 = (h) r131;
        if (r132 == null) goto L52;
        if (r127.contains(r132) == true) goto L52;
        if (r116.contains(r132) == true) goto L52;
        if (r122.contains(r132) == true) goto L52;
        r127.add(r132);
        goto L52
    L59:
        r131 = null;
        goto L60
    L69:
        Iterator<T> r133 = getDescriptorSet().iterator();
    L71:
        if (r133.hasNext() == false) goto L79;
        h r134 = (h) r133.next();
        if (r127.contains(r134) == true) goto L71;
        if (r116.contains(r134) == true) goto L71;
        if (r122.contains(r134) == true) goto L71;
        r127.add(r134);
        goto L71
    L79:
        Iterator r135 = r116.iterator();
    L81:
        if (r135.hasNext() == false) goto L83;
        ListProtector.add(r127, 0, (h) r135.next());
        goto L81
    L83:
        Iterator r136 = r122.iterator();
    L85:
        if (r136.hasNext() == false) goto L87;
        r127.add((h) r136.next());
        goto L85
    L87:
        Iterator r137 = r127.iterator();
    L89:
        if (r137.hasNext() == false) goto L91;
        ((h) r137.next()).f497560a = r103;
        r103 = r103 + 1;
        goto L89
    L91:
        return r127;
    }

    public final void V5(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Element<?> r101 = f2(r100);
        if (r101 == null) goto L7;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r102 = this.f65638f;
        if (r102 == null) goto L7;
        r102.g(r101, this);
    L7:
        if (r101 == null) goto L10;
        this.f65636d.l(r100);
        removeView(r101.f65660b);
        return;
    }

    @Override // i70.a
    public final Element<?> f2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        return this.f65636d.f(r100);
    }

    public final void setGlobalElementCenter$tetris_saasRelease(com.bytedance.android.live.core.tetris.layer.core.layout.a r100) {
        this.f65638f = r100;
    }

    public final void setInLayout$tetris_saasRelease(boolean r100) {
        this.f65639g = r100;
    }

    public final void setLayerDelegate$tetris_saasRelease(ViewLayerDelegate<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f65636d = r100;
    }

    public final void setLayoutListener$tetris_saasRelease(e r100) {
        this.f65637e = r100;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.view.staticlayout.StaticFullScreenViewLayer, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        this.f65639g = true;
        com.bytedance.android.live.core.tetris.layer.core.layout.a r102 = this.f65638f;
        if (r102 != null) goto L5;
    L9:
        super.onMeasure(r100, r101);
        com.bytedance.android.live.core.tetris.layer.core.layout.a r103 = this.f65638f;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r103.a(this) != true) goto L18;
        e r104 = this.f65637e;
        if (r104 == null) goto L19;
        r104.e(this);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r102.b(this) != true) goto L9;
        e r105 = this.f65637e;
        if (r105 == null) goto L9;
        r105.f(this);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ViewLayer(f70.b r100, LayerIndex r101, b r102, Context r103, Class<ViewLayerDelegate<b>> r104) {
        Intrinsics.checkNotNullParameter(r100, "layerType");
        Intrinsics.checkNotNullParameter(r101, "layerIndex");
        Intrinsics.checkNotNullParameter(r102, "layerContext");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r103);
        this.f65640h = r100;
        this.f65641i = r101;
        setClipChildren(false);
        setClipToPadding(false);
        if (r104 == null) goto L9;
        ViewLayerDelegate<b> r105 = r104.newInstance();
        if (r105 == null) goto L8;
        ViewLayerDelegate<b> r106 = r105;
    L10:
        Intrinsics.checkNotNullParameter(this, "<set-?>");
        r106.f65643a = this;
        v70.c r107 = new v70.c(this);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f65652i = r107;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r106.f65645c = r102;
        r106.t();
        this.f65636d = r106;
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.delegate.ViewLayerDelegate<com.bytedance.android.live.core.tetris.layer.LayerContext>");
    L9:
        r106 = new DefaultViewLayerDelegate();
        goto L10
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f65639g = false;
    }
}
