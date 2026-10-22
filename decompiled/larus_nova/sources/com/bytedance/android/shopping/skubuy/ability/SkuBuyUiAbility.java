package com.bytedance.android.shopping.skubuy.ability;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.b;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.shopping.abscontainer.arch.platform.toast.PlatformToast;
import com.bytedance.android.shopping.yata.business.ability.common.ViewCode;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.gyf.barlibrary.ImmersionBar;
import j33.e;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l33.c;
import p33.a;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuBuyUiAbility implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f183103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f183104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AndroidYaTaInstance f183105c;

    @Override // j33.e
    public final View d(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.hashCode() == (-1920148655)) goto L9;
        return null;
    L9:
        if (r100.equals(ViewCode.MAIN_SCROLL_VIEW) == false) goto L14;
        a r101 = this.f183104b;
        if (r101 != null) goto L13;
        return null;
    L13:
        return r101.f527564a;
    L14:
        return null;
    }

    @Override // j33.e
    public final View e(final Map<String, ?> r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        com.bytedance.kmp.ec.yata.store.node.c r103 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(this.f183105c.q(new SkuBuyUiAbility$findSliceView$targetNodeKey$1(r100)));
        if (r103 == null) goto L15;
        String r104 = r103.getKey();
    L16:
        if (r104 != null) goto L18;
    L19:
        r101 = true;
    L20:
        if (r101 == false) goto L23;
        return null;
    L23:
        return this.f183105c.K(r104);
    L18:
        if (r104.length() != 0) goto L20;
    L15:
        r104 = null;
        goto L16
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    @Override // j33.e
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        int r101 = r100.hashCode();
        if (r101 == 3075958) goto L15;
        if (r101 == 102970646) goto L8;
        return;
    L8:
        if (r100.equals("light") == false) goto L22;
        ImmersionBar r102 = ImmersionBar.with(this.f183103a.getContainerContext());
        if (r102 == null) goto L23;
        ImmersionBar r103 = r102.statusBarDarkFont(true);
        if (r103 == null) goto L24;
        r103.init();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L15:
        if (r100.equals("dark") == false) goto L26;
        ImmersionBar r104 = ImmersionBar.with(this.f183103a.getContainerContext());
        if (r104 == null) goto L27;
        ImmersionBar r105 = r104.statusBarDarkFont(false);
        if (r105 == null) goto L28;
        r105.init();
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // j33.e
    public final Pair<Integer, String> h(Map<String, ?> r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        String r101 = null;
        if (r100 == false) goto L12;
        return null;
    L12:
        List<com.bytedance.kmp.ec.yata.store.node.c> r102 = this.f183105c.n(ContainerPosition.BODY);
        int r103 = -1;
        if (r102 == null) goto L34;
        Iterator<com.bytedance.kmp.ec.yata.store.node.c> r104 = r102.iterator();
        int r105 = 0;
    L16:
        if (r104.hasNext() == false) goto L34;
        com.bytedance.kmp.ec.yata.store.node.c r106 = r104.next();
        if (r110.isEmpty() == false) goto L20;
    L19:
        boolean r107 = true;
    L31:
        if (r107 == true) goto L32;
        r105 = r105 + 1;
        goto L16
    L32:
        r103 = r105;
        goto L34
    L20:
        Iterator<Map.Entry<String, ?>> r108 = r110.entrySet().iterator();
    L22:
        if (r108.hasNext() == false) goto L19;
        Map.Entry<String, ?> r109 = r108.next();
        String r111 = r109.getKey();
        p r112 = r106.f251782b.f251788b;
        if (r112 == null) goto L27;
        Object r113 = q.b(r112, Reflection.getOrCreateKotlinClass(Object.class), r111);
        if ((r113 instanceof Object) == false) goto L27;
    L29:
        if (Intrinsics.areEqual(r113, r109.getValue()) == true) goto L22;
        r107 = false;
    L27:
        r113 = null;
    L34:
        if (r102 == null) goto L39;
        com.bytedance.kmp.ec.yata.store.node.c r114 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.getOrNull(r102, r103);
        if (r114 == null) goto L39;
        r101 = r114.getKey();
    L39:
        return TuplesKt.to(Integer.valueOf(r103), r101);
    L5:
        if (r110.isEmpty() == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // j33.e
    public final Map<String, Float> i(View r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ConstraintLayout r101 = this.f183103a.getRootView();
        SlcRenderContext r102 = (SlcRenderContext) this.f183105c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r102 == null) goto L12;
        b r103 = r102.f50172f;
        if (r103 == null) goto L12;
        int r104 = com.bytedance.android.shopping.buynow.utils.q.a(r100, r101);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("width", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r100.getWidth()), r103))), TuplesKt.to("height", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r100.getHeight()), r103))), TuplesKt.to("top", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(com.bytedance.android.shopping.buynow.utils.q.b(r100, r101)), r103))), TuplesKt.to("left", Float.valueOf(SlcDimensExtensionsKt.d(Integer.valueOf(r104), r103)))});
    L12:
        return null;
    }

    @Override // j33.e
    public final void showToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        int r101 = PlatformToast.f164193a;
        PlatformToast.a(this.f183103a.getContainerContext(), r100);
    }

    public SkuBuyUiAbility(c r100, a r101, AndroidYaTaInstance r102) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r102, "yataInstance");
        this.f183103a = r100;
        this.f183104b = r101;
        this.f183105c = r102;
    }

    @Override // j33.e
    public final void g(final View r110, View r210, Integer r211, Map<String, ?> r212, final String r213, final Function0<Unit> r214) {
        if (r110 != null) goto L7;
        Unit r100 = r214.invoke();
        return;
    L7:
        if (r210 == null) goto L97;
        if (r213 != null) goto L11;
    L95:
        Unit r101 = r214.invoke();
        return;
    L11:
        switch(r213.hashCode()) {
            case -1383228885: goto L30;
            case 115029: goto L26;
            case 3317767: goto L23;
            case 108511772: goto L20;
            case 364851518: goto L16;
            case 939658448: goto L14;
            default: goto L95;
        };
    L16:
        char r111 = 1;
        if (r213.equals(ScrollPosition.POSITION_VERTICAL_CENTER) == false) goto L95;
        int[] r112 = {0, r210.getHeight() / 2};
    L33:
        switch(r213.hashCode()) {
            case -1383228885: goto L51;
            case 115029: goto L48;
            case 3317767: goto L45;
            case 108511772: goto L42;
            case 364851518: goto L39;
            case 939658448: goto L36;
            default: goto L93;
        };
    L93:
        Unit r102 = r214.invoke();
        return;
    L36:
        if (r213.equals(ScrollPosition.POSITION_HORIZONTAL_CENTER) == false) goto L93;
        int[] r103 = new int[2];
        r103[0] = r110.getWidth() / 2;
        r103[r111] = 0;
    L53:
        if (r212 == null) goto L55;
        Object r104 = r212.get("x");
    L57:
        if ((r104 instanceof Integer) == true) goto L59;
        r104 = null;
    L59:
        Integer r105 = (Integer) r104;
        if (r105 == null) goto L62;
        int r106 = r105.intValue();
    L63:
        SlcRenderContext r107 = (SlcRenderContext) this.f183105c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r107 == null) goto L68;
        b r108 = r107.f50172f;
        if (r108 == null) goto L68;
        int r109 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r106), r108);
    L69:
        if (r212 == null) goto L71;
        Object r113 = r212.get("y");
    L73:
        if ((r113 instanceof Integer) == true) goto L75;
        r113 = null;
    L75:
        Integer r114 = (Integer) r113;
        if (r114 == null) goto L78;
        int r115 = r114.intValue();
    L79:
        SlcRenderContext r116 = (SlcRenderContext) this.f183105c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r116 == null) goto L84;
        b r117 = r116.f50172f;
        if (r117 == null) goto L84;
        int r118 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r115), r117);
    L85:
        int r119 = r110.getScrollY();
        int r120 = ((com.bytedance.android.shopping.buynow.utils.q.a(r210, r110) + r112[0]) - (r103[0] + r110.getScrollX())) - r109;
        int r121 = ((com.bytedance.android.shopping.buynow.utils.q.b(r210, r110) + r112[1]) - (r103[1] + r119)) - r118;
        if ((r110 instanceof RecyclerView) == true) goto L88;
        View r122 = null;
    L89:
        RecyclerView r123 = (RecyclerView) r122;
        if (r123 == null) goto L92;
        r123.stopScroll();
    L92:
        r110.scrollBy(r120, r121);
        Unit r124 = r214.invoke();
        return;
    L88:
        r122 = r110;
    L84:
        r118 = 0;
        goto L85
    L78:
        r115 = 0;
        goto L79
    L71:
        r113 = null;
    L68:
        r109 = 0;
        goto L69
    L62:
        r106 = 0;
        goto L63
    L55:
        r104 = null;
        goto L57
    L39:
        if (r213.equals(ScrollPosition.POSITION_VERTICAL_CENTER) == false) goto L93;
        r103 = new int[2];
        r103[0] = 0;
        r103[r111] = r110.getHeight() / 2;
        goto L53
    L42:
        if (r213.equals("right") == false) goto L93;
        r103 = new int[2];
        r103[0] = r110.getWidth();
        r103[r111] = 0;
        goto L53
    L45:
        if (r213.equals("left") == false) goto L93;
        r103 = new int[]{0, 0};
        goto L53
    L48:
        if (r213.equals("top") == false) goto L93;
        r103 = new int[]{0, 0};
        goto L53
    L51:
        if (r213.equals("bottom") == false) goto L93;
        r103 = new int[]{0, r110.getHeight()};
        goto L53
    L14:
        if (r213.equals(ScrollPosition.POSITION_HORIZONTAL_CENTER) == false) goto L95;
        r111 = 1;
        r112 = new int[]{r210.getWidth() / 2, 0};
        goto L33
    L20:
        if (r213.equals("right") == false) goto L95;
        r112 = new int[]{r210.getWidth(), 0};
    L28:
        r111 = 1;
        goto L33
    L23:
        if (r213.equals("left") == false) goto L95;
        r112 = new int[]{0, 0};
        goto L28
    L26:
        if (r213.equals("top") == false) goto L95;
        r112 = new int[]{0, 0};
        goto L28
    L30:
        if (r213.equals("bottom") == false) goto L95;
        r111 = 1;
        r112 = new int[]{0, r210.getHeight()};
        goto L33
    L97:
        boolean r125 = true;
        if (r211 != null) goto L100;
        return;
    L100:
        if ((r110 instanceof RecyclerView) == true) goto L103;
        Unit r126 = r214.invoke();
        return;
    L103:
        if (r212 == null) goto L105;
        Object r127 = r212.get("x");
    L107:
        if ((r127 instanceof Integer) == true) goto L109;
        r127 = null;
    L109:
        Integer r128 = (Integer) r127;
        if (r128 == null) goto L112;
        int r129 = r128.intValue();
    L113:
        SlcRenderContext r130 = (SlcRenderContext) this.f183105c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r130 == null) goto L118;
        b r131 = r130.f50172f;
        if (r131 == null) goto L118;
        final int r132 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r129), r131);
    L119:
        if (r212 == null) goto L121;
        Object r133 = r212.get("y");
    L123:
        if ((r133 instanceof Integer) == true) goto L125;
        r133 = null;
    L125:
        Integer r134 = (Integer) r133;
        if (r134 == null) goto L128;
        int r135 = r134.intValue();
    L129:
        SlcRenderContext r136 = (SlcRenderContext) this.f183105c.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        if (r136 == null) goto L134;
        b r137 = r136.f50172f;
        if (r137 == null) goto L134;
        int r138 = (int) SlcDimensExtensionsKt.c(Integer.valueOf(r135), r137);
    L136:
        if (Intrinsics.areEqual(r213, "top") == false) goto L138;
    L143:
        if (r125 == false) goto L145;
        r132 = r138;
    L145:
        RecyclerView r139 = (RecyclerView) r110;
        final Context r140 = r139.getContext();
        LinearSmoothScroller r141 = new SkuBuyUiAbility$scrollToComponent$smoothScroller$1(r213, r132, r110, r140);
        r141.setTargetPosition(r211.intValue());
        RecyclerView.LayoutManager r142 = r139.getLayoutManager();
        if ((r142 instanceof LinearLayoutManager) == true) goto L148;
        RecyclerView.LayoutManager r143 = null;
    L149:
        LinearLayoutManager r144 = (LinearLayoutManager) r143;
        if (r144 == null) goto L152;
        r144.startSmoothScroll(r141);
    L152:
        r139.addOnScrollListener(new SkuBuyUiAbility$scrollToComponent$itemScrollListener$1(r214));
        return;
    L148:
        r143 = r142;
        goto L149
    L138:
        if (Intrinsics.areEqual(r213, "bottom") == true) goto L143;
        if (Intrinsics.areEqual(r213, ScrollPosition.POSITION_VERTICAL_CENTER) == true) goto L143;
        r125 = false;
    L134:
        r138 = 0;
        goto L136
    L128:
        r135 = 0;
        goto L129
    L121:
        r133 = null;
    L118:
        r132 = 0;
        goto L119
    L112:
        r129 = 0;
        goto L113
    L105:
        r127 = null;
        goto L107
    }
}
