package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class GalleryLayerItemStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f169246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f169247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f169248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GalleryViewModel f169249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f169250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ValueAnimator f169251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f169252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f169253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<b> f169254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f169255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f169256k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f169257l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f169258m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f169259n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f169260o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f169261p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f169262q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Function0<RecyclerView> f169263r;

    public static final class a implements TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GalleryLayerItemStateManager f169264a;

        public a(GalleryLayerItemStateManager r100) {
            this.f169264a = r100;
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionBegin(int r100) {
            if (r100 != 2) goto L6;
            GalleryLayerItemStateManager.a(this.f169264a, true);
            return;
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionEnd(int r100) {
            if (r100 != 0) goto L8;
            GalleryViewModel r101 = this.f169264a.f169249d;
            if (r101 == null) goto L6;
            r101.setEnterAnimStatus(3);
        L6:
            GalleryLayerItemStateManager r102 = this.f169264a;
            r102.f169261p = true;
            r102.f(r102.f169254i);
            return;
        }

        @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
        public final void onTransitionChanged(int r100, float r101) {
            boolean r102 = true;
            if (r100 == 3) goto L5;
            if (r100 == 1) goto L5;
            return;
        L5:
            GalleryLayerItemStateManager r103 = this.f169264a;
            if (r100 != 3) goto L8;
        L11:
            GalleryLayerItemStateManager.a(r103, r102);
            return;
        L8:
            if (r101 < 0.99d) goto L11;
            r102 = false;
            goto L11
        }
    }

    public final void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        m0 r101 = r100.f169278b;
        if (r101.f169342a == false) goto L6;
        this.f169255j++;
    L6:
        if (r101.f169343b == false) goto L9;
        this.f169256k++;
    L9:
        if (r101.f169345d == (-1)) goto L12;
        this.f169258m++;
    L12:
        if (r101.f169346e == false) goto L15;
        this.f169259n++;
    L15:
        if (r101.f169344c == false) goto L17;
        this.f169257l++;
    L17:
        ((ArrayList) this.f169254i).add(r100);
        if (r100.f169278b.f169347f == false) goto L21;
        r100.f169277a.setVisibility(8);
    L21:
        if (this.f169261p == false) goto L24;
        f(CollectionsKt.listOf(r100));
        return;
    }

    public final void e(boolean r110) {
        if (this.f169248c != r110) goto L5;
        return;
    L5:
        this.f169248c = r110;
        Iterator r100 = ((ArrayList) this.f169254i).iterator();
    L7:
        if (r100.hasNext() == false) goto L10;
        ((b) r100.next()).c(r110);
        goto L7
    L10:
        if (this.f169257l != 0) goto L12;
        return;
    L12:
        boolean r111 = this.f169248c;
        if (r111 == false) goto L15;
        float r101 = 1.0f;
    L16:
        if (r111 == false) goto L18;
        final float r102 = 0.0f;
    L19:
        if (r111 == true) goto L21;
        j(this.f169254i);
    L21:
        this.f169253h = i(this, this.f169253h, r101, r102, false, new GalleryLayerItemStateManager$handleSwitchAnimation$2(this, r102), 8);
        return;
    L18:
        r102 = 1.0f;
        goto L19
    L15:
        r101 = 0.0f;
        goto L16
    }

    public final void f(final List<? extends b> r100) {
        d(this.f169263r.invoke(), r100);
        j(r100);
        i(this, null, 0.0f, 0.0f, false, new GalleryLayerItemStateManager$initItemsVisibilityState$1(this, r100), 14);
    }

    public final void g(float r110) {
        if (this.f169255j != 0) goto L5;
        return;
    L5:
        if (this.f169247b == true) goto L27;
        double r100 = r110;
        if (r100 <= 1.02d) goto L10;
    L13:
        boolean r111 = true;
    L15:
        if (r111 != this.f169246a) goto L17;
        return;
    L17:
        this.f169246a = r111;
        if (r111 == false) goto L20;
        float r101 = 1.0f;
    L21:
        if (r111 == false) goto L23;
        final float r102 = 0.0f;
    L24:
        this.f169251f = i(this, this.f169251f, r101, r102, false, new GalleryLayerItemStateManager$onZoom$1(this, r102), 8);
        return;
    L23:
        r102 = 1.0f;
        goto L24
    L20:
        r101 = 0.0f;
        goto L21
    L10:
        if (r100 < 0.98d) goto L13;
        r111 = false;
        goto L15
    }

    public final void h(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        m0 r101 = r100.f169278b;
        if (r101.f169342a == false) goto L6;
        this.f169255j--;
    L6:
        if (r101.f169343b == false) goto L9;
        this.f169256k--;
    L9:
        if (r101.f169345d == (-1)) goto L12;
        this.f169258m--;
    L12:
        if (r101.f169346e == false) goto L15;
        this.f169259n--;
    L15:
        if (r101.f169344c == false) goto L17;
        this.f169257l--;
    L17:
        ((ArrayList) this.f169254i).remove(r100);
    }

    public final void j(List<? extends b> r100) {
        RecyclerView.ViewHolder r101 = this.f169263r.invoke().findViewHolderForAdapterPosition(this.f169260o);
        RectF r102 = null;
        if ((r101 instanceof PhotoVH) == true) goto L5;
        r101 = null;
    L5:
        PhotoVH r103 = (PhotoVH) r101;
        if (r103 == null) goto L10;
        TransitionPhotoDraweeView r104 = r103.f176147a;
        if (r104 == null) goto L10;
        r102 = r104.getAvailableImageBounds();
    L10:
        Iterator<T> r105 = r100.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        ((b) r105.next()).b(r102);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryLayerItemStateManager(boolean r100, Function0<? extends RecyclerView> r101) {
        Intrinsics.checkNotNullParameter(r101, "getPager");
        this.f169263r = r101;
        this.f169254i = new ArrayList();
        this.f169260o = -1;
        this.f169261p = !r100;
        this.f169262q = new a(this);
    }

    public static final void a(final GalleryLayerItemStateManager r100, boolean r110) {
        if (r100.f169256k != 0) goto L6;
        return;
    L6:
        if (r110 == r100.f169247b) goto L18;
        r100.f169247b = r110;
        if (r110 == false) goto L11;
        float r101 = 1.0f;
    L12:
        if (r110 == false) goto L14;
        final float r102 = 0.0f;
    L15:
        r100.f169250e = i(r100, r100.f169250e, r101, r102, false, new GalleryLayerItemStateManager$onDrag$1(r100, r102), 8);
        return;
    L14:
        r102 = 1.0f;
        goto L15
    L11:
        r101 = 0.0f;
        goto L12
    }

    public final void d(RecyclerView r110, List<? extends b> r111) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        Intrinsics.checkNotNullParameter(r111, "list");
        if (this.f169261p == true) goto L5;
        return;
    L5:
        int r100 = r110.getWidth();
        int r101 = r110.getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L48;
        View r103 = r110.getChildAt(r102);
        if (r103.getX() >= 0) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        RecyclerView.ViewHolder r104 = r110.findContainingViewHolder(r103);
        if (r104 == null) goto L48;
        Integer r105 = Integer.valueOf(r104.getAdapterPosition());
        if (r103.getX() == 0.0f) goto L39;
        if (r105.intValue() == 0) goto L39;
        if ((r104 instanceof PhotoVH) == true) goto L21;
        r104 = null;
    L21:
        PhotoVH r106 = (PhotoVH) r104;
        if (r106 == null) goto L26;
        TransitionPhotoDraweeView r107 = r106.f176147a;
        if (r107 == null) goto L26;
        RectF r108 = r107.getAvailableImageBounds();
    L27:
        Integer r109 = Integer.valueOf(r105.intValue() - 1);
        View r112 = qc3.a.c(r110, r102 - 1);
        if (r112 == null) goto L37;
        RecyclerView.ViewHolder r113 = r110.findContainingViewHolder(r112);
        if ((r113 instanceof PhotoVH) == true) goto L32;
        r113 = null;
    L32:
        PhotoVH r114 = (PhotoVH) r113;
        if (r114 == null) goto L37;
        TransitionPhotoDraweeView r115 = r114.f176147a;
        if (r115 == null) goto L37;
        r115.getAvailableImageBounds();
    L37:
        float r116 = r100;
        float r117 = (r116 - r103.getX()) / r116;
        Integer r118 = r105;
        r105 = r109;
    L50:
        if (r105 == null) goto L96;
        int r119 = r105.intValue();
        if (r118 == null) goto L59;
        if (r119 < r118.intValue()) goto L59;
        throw new IllegalArgumentException("curPos must be smaller than nextPos, cur=" + r119 + " next=" + r118);
    L59:
        if (this.f169258m <= 0) goto L78;
        Iterator<T> r120 = r111.iterator();
    L62:
        if (r120.hasNext() == false) goto L78;
        b r121 = (b) r120.next();
        if (r121.f169278b.f169345d != 0) goto L62;
        boolean r122 = r121.a(r119);
        if (r118 == null) goto L67;
        if (r122 == r121.a(r118.intValue())) goto L62;
        if (r122 == true) goto L75;
        r121.f169277a.setTranslationX((1 - r117) * r100);
        goto L62
    L75:
        r121.f169277a.setTranslationX(-(r100 * r117));
        goto L62
    L67:
        View r123 = r121.f169277a;
        if (r122 == false) goto L70;
        float r124 = 0.0f;
    L71:
        r123.setTranslationX(r124);
        goto L62
    L70:
        r124 = r100;
    L78:
        if (this.f169259n <= 0) goto L122;
        Iterator<T> r125 = r111.iterator();
    L81:
        if (r125.hasNext() == false) goto L123;
        b r126 = (b) r125.next();
        if (r126.f169278b.f169346e == false) goto L81;
        if (r108 == null) goto L86;
        r108.height();
    L86:
        boolean r127 = r126.a(r119);
        if (r118 == null) goto L89;
        Boolean r128 = Boolean.valueOf(r126.a(r118.intValue()));
    L90:
        if (r127 == true) goto L94;
        if (Intrinsics.areEqual(r128, Boolean.TRUE) == true) goto L81;
    L94:
        if (r127 == false) goto L81;
        Intrinsics.areEqual(r128, Boolean.TRUE);
        goto L81
    L89:
        r128 = null;
        goto L90
    L123:
        return;
    L122:
        return;
    L96:
        return;
    L26:
        r108 = null;
    L39:
        if ((r104 instanceof PhotoVH) == true) goto L41;
        r104 = null;
    L41:
        PhotoVH r129 = (PhotoVH) r104;
        if (r129 == null) goto L46;
        TransitionPhotoDraweeView r130 = r129.f176147a;
        if (r130 == null) goto L46;
        r130.getAvailableImageBounds();
    L46:
        r118 = null;
        r108 = null;
    L49:
        r117 = 0.0f;
    L48:
        r118 = null;
        r108 = null;
        r105 = null;
        goto L49
    }

    public static final void b(GalleryLayerItemStateManager r100, View r101, float r102, float r103, b r104) {
        r100.getClass();
        boolean r105 = true;
        if (r103 != 1.0f) goto L11;
        if (r101.getVisibility() != 8) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L20;
        r101.setVisibility(0);
    L20:
        if (r101.getAlpha() == r103) goto L23;
        r101.setAlpha(r102);
    L23:
        if (r103 != r102) goto L29;
        if (r103 == 1.0f) goto L27;
        r105 = false;
    L27:
        r104.d(r105);
        return;
    L29:
        return;
    L7:
        r106 = false;
        goto L8
    L11:
        if (r101.getVisibility() != 8) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L17;
        return;
    L17:
        if (r103 != r102) goto L20;
        r101.setVisibility(8);
        goto L20
    L13:
        r107 = false;
        goto L14
    }

    public static ValueAnimator i(GalleryLayerItemStateManager r100, Animator r101, float r102, float r103, boolean r104, Function1 r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r102 = 0.0f;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r103 = 1.0f;
    L12:
        if ((r106 & 8) == 0) goto L14;
        r104 = false;
    L14:
        r100.getClass();
        if (r101 == null) goto L17;
        r101.cancel();
    L17:
        if (r104 == false) goto L19;
        r105.invoke(Float.valueOf(r103));
        return null;
    L19:
        ValueAnimator r107 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r107.setDuration(100);
        r107.addUpdateListener(new r(r105));
        r107.start();
        return r107;
    }
}
