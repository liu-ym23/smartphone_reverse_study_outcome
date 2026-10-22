package com.bytedance.android.live.core.tetris.layer.core.layout;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.tetris.layer.core.ViewLayer;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.live.core.utils.s1;
import j70.f;
import j70.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements com.bytedance.android.live.core.tetris.layer.core.layout.a, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ViewLayer, HashSet<Element<?>>> f65777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<f, Element<?>> f65778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<ViewLayer, Set<com.bytedance.android.live.core.tetris.layer.core.layout.a.C1085a>> f65779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<View, a> f65780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<f, HashSet<Element<?>>> f65781e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f65783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f65785d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f65782a == r101.f65782a) goto L8;
            return false;
        L8:
            if (this.f65783b == r101.f65783b) goto L10;
            return false;
        L10:
            if (this.f65784c == r101.f65784c) goto L12;
            return false;
        L12:
            if (this.f65785d == r101.f65785d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f65782a * 31) + this.f65783b) * 31) + this.f65784c) * 31) + this.f65785d;
        }

        public final String toString() {
            return "WidgetInfo(left=" + this.f65782a + ", right=" + this.f65783b + ", top=" + this.f65784c + ", bottom=" + this.f65785d + ")";
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f65782a = r100;
            this.f65783b = r101;
            this.f65784c = r102;
            this.f65785d = r103;
        }
    }

    public b() {
        this.f65777a = new LinkedHashMap();
        this.f65778b = new LinkedHashMap();
        this.f65779c = new LinkedHashMap();
        this.f65780d = new LinkedHashMap();
        this.f65781e = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final boolean a(ViewLayer r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        HashSet r101 = (HashSet) ((LinkedHashMap) this.f65777a).get(r100);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.intValue() <= 0) goto L10;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final boolean b(ViewLayer r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        Set r101 = (Set) ((LinkedHashMap) this.f65779c).get(r100);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        if (r102 != null) goto L8;
    L10:
        return false;
    L8:
        if (r102.intValue() <= 0) goto L10;
        return true;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.e
    public final void e(ViewLayer r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        HashSet r101 = (HashSet) ((LinkedHashMap) this.f65777a).get(r100);
        if (r101 == null) goto L43;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L56;
        Element r103 = (Element) r102.next();
        View r104 = r103.f65660b;
        if (r104 == null) goto L6;
        IConstraintWidgetService r105 = (IConstraintWidgetService) k.f(IConstraintWidgetService.class);
        if (r105 == null) goto L12;
        a r106 = r105.getViewWidget(r100, r104);
    L13:
        if (r106 == null) goto L6;
        a r107 = (a) ((LinkedHashMap) this.f65780d).get(r104);
        if (r107 != null) goto L18;
    L42:
        this.f65780d.put(r104, r106);
        goto L6
    L18:
        if (r106.f65782a == r107.f65782a) goto L20;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == false) goto L42;
        Map<f, HashSet<Element<?>>> r109 = this.f65781e;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        HashSet r111 = (HashSet) r110.get(r103.f65662d);
        if (r111 == null) goto L37;
        Iterator r112 = r111.iterator();
    L33:
        if (r112.hasNext() == false) goto L37;
        View r113 = ((Element) r112.next()).f65660b;
        if (r113 == null) goto L33;
        r113.requestLayout();
    L37:
        View r114 = r103.f65660b;
        if (r114 == null) goto L42;
        ViewParent r115 = r114.getParent();
        if (r115 == null) goto L42;
        r115.requestLayout();
        goto L42
    L20:
        if (r106.f65783b != r107.f65783b) goto L27;
        if (r106.f65784c != r107.f65784c) goto L27;
        if (r106.f65785d != r107.f65785d) goto L27;
        r108 = false;
        goto L28
    L12:
        r106 = null;
        goto L13
    L56:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.e
    public final void f(ViewLayer r110) {
        b r100 = this;
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.GAIAX_LAYER);
        Set r101 = (Set) ((LinkedHashMap) r100.f65779c).get(r110);
        if (r101 == null) goto L75;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L100;
        com.bytedance.android.live.core.tetris.layer.core.layout.a.C1085a r103 = (com.bytedance.android.live.core.tetris.layer.core.layout.a.C1085a) r102.next();
        View r104 = r103.f65775a.f65660b;
        if (r104 == null) goto L72;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L74;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        int r107 = ((ViewGroup.MarginLayoutParams) r106).leftMargin;
        int r108 = ((ViewGroup.MarginLayoutParams) r106).rightMargin;
        int r109 = ((ViewGroup.MarginLayoutParams) r106).topMargin;
        int r111 = ((ViewGroup.MarginLayoutParams) r106).bottomMargin;
        Iterator<T> r112 = r103.f65776b.iterator();
    L14:
        if (r112.hasNext() == false) goto L64;
        ElementConstraint.c r113 = (ElementConstraint.c) r112.next();
        f r114 = r113.f65841b.f65839c;
        if ((r114 instanceof g) == false) goto L62;
        Element r115 = (Element) ((LinkedHashMap) r100.f65778b).get(r114);
        if (r115 == null) goto L62;
        View r116 = r115.f65660b;
        if (r116 == null) goto L21;
        ViewParent r117 = r116.getParent();
        if (r117 == null) goto L61;
        ViewLayer r118 = (ViewLayer) r117;
        IConstraintWidgetService r119 = (IConstraintWidgetService) k.f(IConstraintWidgetService.class);
        if (r119 == null) goto L27;
        a r120 = r119.getViewWidget(r118, r116);
    L28:
        if (r120 == null) goto L62;
        int r121 = (int) s1.e(r113.f65843d);
        if (r121 >= 0) goto L33;
        r121 = 0;
    L33:
        int r122 = r113.f65840a;
        if (r122 == 1) goto L55;
        if (r122 != 2) goto L37;
        int r123 = r113.f65842c;
        if (r123 != 1) goto L53;
        int r124 = r118.getMeasuredWidth();
        int r125 = r120.f65783b;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = ((r124 - r125) + (r125 - r120.f65782a)) + r121;
        goto L62
    L53:
        if (r123 != 2) goto L62;
        ((ViewGroup.MarginLayoutParams) r106).rightMargin = (r118.getMeasuredWidth() - r120.f65783b) + r121;
        goto L62
    L37:
        if (r122 == 3) goto L45;
        if (r122 != 4) goto L62;
        int r126 = r113.f65842c;
        if (r126 != 3) goto L43;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = ((r118.getMeasuredHeight() - r120.f65785d) + r116.getHeight()) + r121;
        goto L62
    L43:
        if (r126 != 4) goto L62;
        ((ViewGroup.MarginLayoutParams) r106).bottomMargin = (r118.getMeasuredHeight() - r120.f65785d) + r121;
        goto L62
    L45:
        int r127 = r113.f65842c;
        if (r127 != 3) goto L48;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = r120.f65784c + r121;
        goto L62
    L48:
        if (r127 != 4) goto L62;
        int r128 = r120.f65784c;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = (r128 + (r120.f65785d - r128)) + r121;
        goto L62
    L55:
        int r129 = r113.f65842c;
        if (r129 != 1) goto L58;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = r120.f65782a + r121;
        goto L62
    L58:
        if (r129 != 2) goto L62;
        int r130 = r120.f65782a;
        ((ViewGroup.MarginLayoutParams) r106).leftMargin = (r130 + (r120.f65783b - r130)) + r121;
        goto L62
    L27:
        r120 = null;
        goto L28
    L61:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.ViewLayer");
    L21:
        return;
    L62:
        r100 = this;
        goto L14
    L64:
        if (((ViewGroup.MarginLayoutParams) r106).leftMargin == r107) goto L66;
    L71:
        r104.requestLayout();
        r110.requestLayout();
        goto L72
    L66:
        if (((ViewGroup.MarginLayoutParams) r106).rightMargin != r108) goto L71;
        if (((ViewGroup.MarginLayoutParams) r106).topMargin != r109) goto L71;
        if (((ViewGroup.MarginLayoutParams) r106).bottomMargin == r111) goto L72;
    L74:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L72:
        r100 = this;
        goto L6
    L100:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void c(ViewLayer r100, com.bytedance.android.live.core.tetris.layer.core.layout.a.C1085a r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r101, "dependency");
        if (this.f65779c.containsKey(r100) == false) goto L5;
        Object r102 = ((LinkedHashMap) this.f65779c).get(r100);
        Intrinsics.checkNotNull(r102);
        Set r103 = (Set) r102;
    L6:
        Iterator<T> r104 = r101.f65776b.iterator();
    L8:
        if (r104.hasNext() == false) goto L19;
        f r105 = ((ElementConstraint.c) r104.next()).f65841b.f65839c;
        if ((r105 instanceof g) == false) goto L8;
        if (r105 == null) goto L18;
        g r106 = (g) r105;
        if (this.f65781e.containsKey(r106) == false) goto L15;
        Object r107 = ((LinkedHashMap) this.f65781e).get(r106);
        Intrinsics.checkNotNull(r107);
        HashSet<Element<?>> r108 = (HashSet) r107;
    L16:
        r108.add(r101.f65775a);
        goto L8
    L15:
        HashSet<Element<?>> r109 = new HashSet();
        this.f65781e.put(r106, r109);
        r108 = r109;
        goto L16
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.tetris.layer.core.descriptor.GlobalElementType");
    L19:
        r103.remove(r101);
        r103.add(r101);
        return;
    L5:
        HashSet r110 = new HashSet();
        this.f65779c.put(r100, r110);
        r103 = r110;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void d(ViewLayer r100, Element<?> r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r101, "element");
        f r102 = r101.f65662d;
        if ((r102 instanceof g) == false) goto L10;
        this.f65778b.put(r102, r101);
        if (this.f65777a.containsKey(r100) == false) goto L7;
        Object r103 = ((LinkedHashMap) this.f65777a).get(r100);
        Intrinsics.checkNotNull(r103);
        HashSet<Element<?>> r104 = (HashSet) r103;
    L8:
        r104.add(r101);
        return;
    L7:
        HashSet<Element<?>> r105 = new HashSet();
        this.f65777a.put(r100, r105);
        r104 = r105;
        goto L8
    }

    @Override // com.bytedance.android.live.core.tetris.layer.core.layout.a
    public final void g(Element<?> r100, ViewLayer r101) {
        Intrinsics.checkNotNullParameter(r100, "startElement");
        Intrinsics.checkNotNullParameter(r101, GXTemplateKey.GAIAX_LAYER);
        Set r102 = (Set) ((LinkedHashMap) this.f65779c).get(r101);
        if (r102 == null) goto L11;
        Iterator r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(((com.bytedance.android.live.core.tetris.layer.core.layout.a.C1085a) r103.next()).f65775a, r100) == false) goto L6;
        r103.remove();
    L11:
        if ((r100.f65662d instanceof g) == false) goto L25;
        HashSet r104 = (HashSet) ((LinkedHashMap) this.f65777a).get(r101);
        if (r104 == null) goto L15;
        r104.remove(r100);
    L15:
        this.f65778b.remove(r100.f65662d);
        View r105 = r100.f65660b;
        if (r105 == null) goto L18;
        a r106 = this.f65780d.remove(r105);
    L18:
        this.f65781e.remove(r100.f65662d);
        return;
    }
}
