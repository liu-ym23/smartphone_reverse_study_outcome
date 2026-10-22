package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EdgeGradientFrameLayout f169393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f169394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f169395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f169396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f169397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Integer, Unit> f169398f;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f169399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f169400b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f169400b == true) goto L8;
            RecyclerView r101 = this.f169399a.f169394b;
            if (r101 == null) goto L9;
            r101.setVisibility(4);
            return;
        L9:
            return;
        }

        public b(t r100, boolean r101) {
            this.f169399a = r100;
            this.f169400b = r101;
        }
    }

    static {
    }

    public static final void a(t r100) {
        RecyclerView r101 = r100.f169394b;
        if (r101 != null) goto L5;
    L7:
        int r102 = 0;
    L8:
        RecyclerView r103 = r100.f169394b;
        if (r103 != null) goto L11;
    L13:
        int r104 = 0;
    L14:
        EdgeGradientFrameLayout r105 = r100.f169393a;
        if (r105 == null) goto L18;
        r105.b(r102, 0, r104, 0);
        return;
    L18:
        return;
    L11:
        if (r103.canScrollHorizontally(1) != true) goto L13;
        r104 = com.bytedance.android.shopping.extensions.b.a(30);
        goto L14
    L5:
        if (r101.canScrollHorizontally(-1) != true) goto L7;
        r102 = com.bytedance.android.shopping.extensions.b.a(30);
        goto L8
    }

    public final float e(int r100) {
        List<s> r101 = this.f169396d.f169328f.getFullThumbList().getValue();
        if (r101 == null) goto L23;
        s r102 = (s) CollectionsKt.getOrNull(r101, r100);
        if (r102 == null) goto L23;
        if (this.f169396d.b() == false) goto L11;
        boolean r103 = Intrinsics.areEqual(this.f169396d.f169328f.isMoreVideoExpanded().getValue(), Boolean.TRUE);
    L17:
        if (r103 == true) goto L28;
        EdgeGradientFrameLayout r104 = this.f169393a;
        if (r104 != null) goto L22;
        return 0.0f;
    L22:
        return r104.getHeight();
    L28:
        return 0.0f;
    L11:
        if (r102.f169389d == true) goto L13;
    L16:
        r103 = true;
        goto L17
    L13:
        if (Intrinsics.areEqual(this.f169396d.f169328f.isMoreVideoExpanded().getValue(), Boolean.TRUE) == true) goto L16;
        r103 = false;
    L23:
        EdgeGradientFrameLayout r105 = this.f169393a;
        if (r105 != null) goto L26;
        return 0.0f;
    L26:
        return r105.getHeight();
    }

    public final List<s> f(List<s> r110) {
        List<s> r111 = r110;
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
    L4:
        if (r112.hasNext() == false) goto L13;
        s r101 = (s) r112.next();
        Integer r102 = this.f169396d.f169328f.getSelectedPosition().getValue();
        int r103 = r101.f169388c;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        String r105 = r101.f169386a;
        String r106 = r101.f169387b;
        int r107 = r101.f169388c;
        boolean r108 = r101.f169389d;
        String r109 = r101.f169390e;
        Intrinsics.checkNotNullParameter(r105, "label");
        Intrinsics.checkNotNullParameter(r109, "originLabel");
        r100.add(new s(r105, r106, r107, r108, r109, r104));
        goto L4
    L9:
        if (r102.intValue() != r103) goto L11;
        r104 = true;
        goto L12
    L13:
        return r100;
    }

    public final boolean g(int r100) {
        List<s> r101 = this.f169396d.f169328f.getFullThumbList().getValue();
        if (r101 == null) goto L5;
        s r102 = (s) CollectionsKt.getOrNull(r101, r100);
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final void h(boolean r100) {
        Integer r101 = this.f169396d.f169328f.getSelectedPosition().getValue();
        if (r101 != null) goto L5;
        r101 = -1;
    L5:
        int r102 = r101.intValue();
        if (g(r102) == true) goto L8;
        return;
    L8:
        float r103 = e(r102);
        if (r103 != 0.0f) goto L11;
        boolean r104 = true;
    L12:
        d(r103, r100, r104);
        return;
    L11:
        r104 = false;
        goto L12
    }

    public static final void c(t r100, List r101) {
        final List<s> r102 = r100.f(r101);
        EdgeGradientFrameLayout r103 = r100.f169393a;
        boolean r104 = false;
        if (r103 != null) goto L5;
    L8:
        RecyclerView r105 = r100.f169394b;
        Integer r106 = null;
        if (r105 == null) goto L11;
        RecyclerView.Adapter r107 = r105.getAdapter();
    L13:
        if ((r107 instanceof p0) == true) goto L15;
        r107 = null;
    L15:
        p0 r108 = (p0) r107;
        if (r108 == null) goto L18;
        Intrinsics.checkNotNullParameter(r102, "newItems");
        final List r109 = CollectionsKt.toList(r108.f169360a);
        DiffUtil.DiffResult r110 = DiffUtil.calculateDiff(new MoreVideoAdapter$updateItems$diffResult$1(r109, r102));
        r108.f169360a.clear();
        r108.f169360a.addAll(r102);
        r110.dispatchUpdatesTo(r108);
    L18:
        Iterator r111 = ((ArrayList) r102).iterator();
        int r112 = 0;
    L20:
        if (r111.hasNext() == false) goto L25;
        if (((s) r111.next()).f169391f == true) goto L26;
        r112 = r112 + 1;
    L26:
        Integer r113 = Integer.valueOf(r112);
        if (r113.intValue() < 0) goto L29;
        r104 = true;
    L29:
        if (r104 == false) goto L31;
        r106 = r113;
    L31:
        if (r106 == null) goto L36;
        int r114 = r106.intValue();
        RecyclerView r115 = r100.f169394b;
        if (r115 == null) goto L36;
        r115.post(new b0(r114, r100));
    L36:
        if (r100.f169395c == true) goto L41;
        r100.h(true);
        return;
    L41:
        return;
    L25:
        r112 = -1;
        goto L26
    L11:
        r107 = null;
        goto L13
    L5:
        if ((!((ArrayList) r102).isEmpty()) == false) goto L7;
        r103.setVisibility(0);
        goto L8
    L7:
        r103.setVisibility(8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(l r100, FrameLayout r101, Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "galleryCtx");
        Intrinsics.checkNotNullParameter(r101, "galleryContainer");
        Intrinsics.checkNotNullParameter(r102, "trySelectPosition");
        this.f169396d = r100;
        this.f169397e = r101;
        this.f169398f = r102;
    }

    public static final void b(t r100, int r101, RecyclerView r102) {
        r100.getClass();
        RecyclerView.ViewHolder r103 = r102.findViewHolderForLayoutPosition(r101);
        if (r103 == null) goto L8;
        View r104 = r103.itemView;
        if (r104 == null) goto L9;
        r102.smoothScrollBy(((int) r104.getX()) - ((r102.getWidth() / 2) - (r104.getWidth() / 2)), 0);
        return;
    L9:
        return;
    }

    public final void d(float r110, boolean r111, boolean r112) {
        float r100 = 0.0f;
        if (r110 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        m r102 = this.f169396d.f169329g;
        r102.getClass();
        m.d(r102, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, null, "more_video_show", "a1.b34986.c503191.d927636", 6);
    L8:
        EdgeGradientFrameLayout r103 = this.f169393a;
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.isLaidOut() == true) goto L13;
        return;
    L13:
        if (r103.getHeight() <= 0) goto L44;
        float r104 = 1.0f;
        if (r111 == false) goto L23;
        if (r112 == false) goto L20;
        RecyclerView r113 = this.f169394b;
        if (r113 == null) goto L20;
        r113.setVisibility(0);
    L20:
        if (r112 == false) goto L22;
        r100 = 1.0f;
    L22:
        r103.animate().translationY(r110).alpha(r100).setDuration(300).setListener(new b(this, r112)).start();
        return;
    L23:
        EdgeGradientFrameLayout r114 = this.f169393a;
        if (r114 == null) goto L26;
        float r115 = r114.getHeight();
    L28:
        if (r115 <= 0) goto L33;
        float r116 = 1;
        EdgeGradientFrameLayout r105 = this.f169393a;
        if (r105 == null) goto L32;
        r100 = r105.getHeight();
    L32:
        r104 = r116 - (r110 / r100);
    L33:
        r103.animate().setListener(null).cancel();
        r103.setTranslationY(r110);
        r103.setAlpha(r104);
        if (r112 == false) goto L38;
        RecyclerView r117 = this.f169394b;
        if (r117 == null) goto L46;
        r117.setVisibility(0);
        return;
    L46:
        return;
    L38:
        RecyclerView r118 = this.f169394b;
        if (r118 == null) goto L48;
        r118.setVisibility(4);
        return;
    L48:
        return;
    L26:
        r115 = 0.0f;
        goto L28
    L44:
        return;
    L5:
        r101 = false;
        goto L6
    }
}
