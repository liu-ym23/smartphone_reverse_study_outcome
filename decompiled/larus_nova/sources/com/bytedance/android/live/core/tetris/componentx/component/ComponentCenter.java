package com.bytedance.android.live.core.tetris.componentx.component;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.tetris.ComponentManagerFactory$config$1;
import com.bytedance.android.live.core.tetris.componentx.schedule.InnerComponentListener;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import j70.f;
import j70.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class ComponentCenter implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h70.b f65519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f65520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, WeakReference<h<h70.b>>> f65521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, WeakReference<d70.a<h70.b>>> f65522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, a<g70.h>> f65523e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.core.tetris.componentx.component.a f65524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.core.tetris.componentx.a f65525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f65526h;

    public static final class a<T> extends WeakReference<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f65527a;

        public a(g70.h r100) {
            super(r100);
        }
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void c(Element<?> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r101, "originComponent");
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void f(Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
    }

    public final void h() {
        g(ComponentCenter$onDestroy$1.INSTANCE);
        Iterator r100 = ((LinkedHashMap) this.f65523e).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        g70.h r101 = (g70.h) ((a) ((Map.Entry) r100.next()).getValue()).get();
        if (r101 == null) goto L4;
        r101.a(this.f65524f);
        goto L4
    L8:
        ((LinkedHashMap) this.f65523e).clear();
        Iterator r102 = ((LinkedHashMap) this.f65522d).entrySet().iterator();
    L10:
        if (r102.hasNext() == false) goto L16;
        d70.a r103 = (d70.a) ((WeakReference) ((Map.Entry) r102.next()).getValue()).get();
        if (r103 == null) goto L10;
        if (Intrinsics.areEqual(r103.getComponentContext(), this.f65519a) == false) goto L10;
        r103.setComponentContext(null);
        r103.setElementType(null);
        goto L10
    L16:
        ((LinkedHashMap) this.f65521c).clear();
        ((LinkedHashMap) this.f65522d).clear();
        ((ArrayList) this.f65520b).clear();
    }

    public final void i() {
        c r100 = this.f65526h;
        if (r100 == null) goto L5;
        ((ArrayList) this.f65520b).add(r100);
    L5:
        List r101 = this.f65525g.a().f65490a.f65487n;
        if (r101 == null) goto L8;
        ArrayList r102 = (ArrayList) this.f65520b;
        r102.addAll(r101);
    L8:
        g(new ComponentCenter$onInit$3(this));
    }

    public static d70.a l(Object r100) {
        if ((r100 instanceof d70.a) == true) goto L6;
        r100 = null;
    L6:
        return (d70.a) r100;
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void a(final Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        r100.f65661c = this;
        g(new ComponentCenter$onCreateElement$1(r100));
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void b(final Element<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        r100.f65661c = null;
        g(new ComponentCenter$onRemoveElement$1(r100));
    }

    public final void g(Function1<? super c, Unit> r100) {
        Iterator r101 = ((ArrayList) this.f65520b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke((c) r101.next());
        goto L4
    }

    public final void j(final LayerDescriptorList r100) {
        Intrinsics.checkNotNullParameter(r100, "descriptors");
        Iterator<h<? extends h70.b>> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        h<? extends h70.b> r102 = r101.next();
        this.f65521c.put(r102.toString(), new WeakReference(r102));
        goto L4
    L6:
        g(new ComponentCenter$onLoadDescriptor$2(this, r100));
    }

    public final void k(final f r100) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Iterator r101 = ((LinkedHashMap) this.f65521c).entrySet().iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r101.next();
        h r104 = (h) ((WeakReference) r103.getValue()).get();
        if (r104 == null) goto L9;
        r102 = r104.C(this.f65519a);
    L9:
        if (Intrinsics.areEqual(r102, r100) == false) goto L3;
        r102 = (h) ((WeakReference) r103.getValue()).get();
    L11:
        if (r102 == null) goto L13;
        WeakReference<h<h70.b>> r105 = this.f65521c.remove(r102.toString());
    L13:
        g(new ComponentCenter$onRemoveDescriptor$2(r100));
    }

    public ComponentCenter(ComponentManagerFactory$config$1 r100, InnerComponentListener r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f65525g = r100;
        this.f65526h = r101;
        this.f65519a = r100.f65475b;
        this.f65520b = new ArrayList();
        this.f65521c = new LinkedHashMap();
        this.f65522d = new LinkedHashMap();
        this.f65523e = new LinkedHashMap();
        this.f65524f = new com.bytedance.android.live.core.tetris.componentx.component.a(this);
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void d(final Element<?> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r101, "originComponent");
        final d70.a r102 = l(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setElementType(r100.f65662d);
        r102.setComponentContext(this.f65519a);
        Object r103 = r100.g();
        if ((r103 instanceof g70.h) == true) goto L8;
        r103 = null;
    L8:
        g70.h r104 = (g70.h) r103;
        if (r104 == null) goto L19;
        String r105 = r104.toString();
        if (this.f65523e.containsKey(r105) == true) goto L16;
        r104.c(this.f65524f);
        this.f65523e.put(r105, new a(r104));
        a r106 = (a) ((LinkedHashMap) this.f65523e).get(r105);
        if (r106 == null) goto L19;
        r106.f65527a++;
        goto L19
    L16:
        a r107 = (a) ((LinkedHashMap) this.f65523e).get(r105);
        if (r107 == null) goto L19;
        r107.f65527a++;
    L19:
        this.f65522d.put(r102.toString(), new WeakReference(r102));
        g(new ComponentCenter$onCreateComponent$1(r100, r102));
    }

    @Override // com.bytedance.android.live.core.tetris.componentx.component.b
    public final void e(final Element<?> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "element");
        Intrinsics.checkNotNullParameter(r101, "originComponent");
        final d70.a r102 = l(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        g(new ComponentCenter$onRemoveComponent$1(r100, r102));
        Object r103 = null;
        if (Intrinsics.areEqual(r102.getComponentContext(), this.f65519a) == false) goto L8;
        r102.setComponentContext(null);
        r102.setElementType(null);
    L8:
        Lifecycle r104 = r100.g();
        if ((r104 instanceof g70.h) == false) goto L12;
        r103 = r104;
    L12:
        g70.h r105 = (g70.h) r103;
        if (r105 == null) goto L24;
        String r106 = r105.toString();
        a r107 = (a) ((LinkedHashMap) this.f65523e).get(r106);
        if (r107 == null) goto L24;
        int r108 = r107.f65527a - 1;
        r107.f65527a = r108;
        if (r108 > 0) goto L24;
        a<g70.h> r109 = this.f65523e.remove(r106);
        if (r109 == null) goto L24;
        g70.h r110 = r109.get();
        if (r110 == null) goto L24;
        r110.a(this.f65524f);
    L24:
        this.f65522d.remove(r102.toString());
    }
}
