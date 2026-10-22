package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.action.ui.SlcUIActionErrorCode;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.bindinfo.SlcBindInfoKt;
import com.bytedance.android.ecom.arch.slice.render.bindinfo.d;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class c extends BaseSlcViewManager<SlcListElementView> {
    public static final /* synthetic */ int V3 = 0;
    public String H3;
    public Object I3;
    public Object J3;
    public Object K3;
    public Object L3;
    public Object M3;
    public Object N3;
    public boolean O3;
    public SlcListItemDecoration P3;
    public IAction Q3;
    public int R3;
    public yq.a S3;
    public SlcListElementViewManager$onScrollListener$1 T3;
    public SlcListElementViewManager$staggeredOnScrollListener$1 U3;

    public static final class a {
        @JvmStatic
        public static int a(int r100, int r101, String r102, int r103, int r104) {
            int r105 = r102.hashCode();
            if (r105 == (-1364013995)) goto L11;
            if (r105 != 100571) goto L14;
            if (r102.equals("end") == false) goto L14;
            r103 = (r100 - r101) - r103;
        L14:
            return r103 + r104;
        L11:
            if (r102.equals("center") == false) goto L14;
            r103 = (r100 - r101) / 2;
            goto L14
        }
    }

    static {
    }

    public final boolean m1() {
        return com.bytedance.android.ecom.arch.slice.render.util.b.a(this.J3);
    }

    public final boolean k1() {
        String r100 = d0();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        nq.a.i(getContext(), this.f50260a.n().concat(":配置了initial-scroll-index，但是没有配置slice-key"));
    L30:
        return false;
    L11:
        String r102 = this.f50260a.f50219g;
        if (r102 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L20;
        nq.a.i(getContext(), this.f50260a.n().concat(":配置了initial-scroll-index，但是没有配置uniqueNodeId"));
        goto L30
    L20:
        Object r104 = this.f50260a.f50235w.g("_SLC_initial_scroll");
        if (TypeIntrinsics.isMutableSet(r104) == true) goto L23;
        r104 = null;
    L23:
        Set r105 = (Set) r104;
        if (r105 != null) goto L26;
        r105 = new HashSet();
        this.f50260a.f50235w.o("_SLC_initial_scroll", r105);
    L26:
        String r106 = Intrinsics.stringPlus(this.f50260a.f50219g, d0());
        if (r105.contains(r106) == true) goto L30;
        r105.add(r106);
        return true;
    L14:
        if (r102.length() == 0) goto L17;
        r103 = false;
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public c(SlcTemplateContext r100) {
        super(r100);
        this.N3 = 0;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public /* bridge */ /* synthetic */ View A0(Context r100) {
        return o1(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r100) {
        if (getView().dispatchHoverEvent(r100) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void G0(Map<String, ? extends Object> r100) {
        IAction r101 = n.a(r100.get("on_scroll"));
        if (Intrinsics.areEqual(r101, this.Q3) == false) goto L6;
    L20:
        this.Q3 = r101;
        return;
    L6:
        if (this.Q3 == null) goto L11;
        SlcListElementView r102 = getView();
        SlcListElementViewManager$onScrollListener$1 r103 = this.T3;
        if (r103 != null) goto L10;
        r103 = new SlcListElementViewManager$onScrollListener$1(this);
        this.T3 = r103;
    L10:
        r102.removeOnScrollListener(r103);
    L11:
        if (r101 == null) goto L20;
        yq.a r104 = this.S3;
        if (r104 != null) goto L16;
        r104 = new yq.a();
        this.S3 = r104;
    L16:
        r104.f568738a = 0;
        SlcListElementView r105 = getView();
        SlcListElementViewManager$onScrollListener$1 r106 = this.T3;
        if (r106 != null) goto L19;
        r106 = new SlcListElementViewManager$onScrollListener$1(this);
        this.T3 = r106;
    L19:
        r105.addOnScrollListener(r106);
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementViewManager$staggeredOnScrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r7v9, types: [androidx.recyclerview.widget.RecyclerView, com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView] */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public void H0(Map<String, ? extends Object> r100) {
        int r101 = 1;
        if (getView().getLayoutManager() != null) goto L5;
        boolean r102 = true;
    L6:
        Iterator<Map.Entry<String, ? extends Object>> r103 = r100.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L56;
        Map.Entry<String, ? extends Object> r104 = r103.next();
        Object r105 = r104.getValue();
        String r106 = r104.getKey();
        switch(r106.hashCode()) {
            case -2083074934: goto L48;
            case -1224062405: goto L39;
            case -765237765: goto L30;
            case -499398312: goto L23;
            case -52544889: goto L18;
            case 1509002202: goto L13;
            default: goto L8;
        };
    L13:
        if (r106.equals("span_count") == false) goto L8;
        if ((!Intrinsics.areEqual(this.I3, r105)) == false) goto L8;
        this.I3 = r105;
    L46:
        r102 = true;
        goto L8
    L18:
        if (r106.equals("vertical_orientation") == false) goto L8;
        if ((!Intrinsics.areEqual(this.J3, r105)) == false) goto L8;
        this.J3 = r105;
        goto L46
    L23:
        if (r106.equals("over_scroll_anim") == false) goto L8;
        SlcListElementView r107 = getView();
        if (com.bytedance.android.ecom.arch.slice.render.util.b.a(r105) == false) goto L27;
        int r108 = 1;
    L28:
        r107.setOverScrollMode(r108);
        goto L8
    L27:
        r108 = 2;
        goto L28
    L30:
        if (r106.equals("initial_scroll_index") == false) goto L8;
        if ((!Intrinsics.areEqual(this.M3, r105)) == false) goto L8;
        this.M3 = r105;
        if (this.O3 == true) goto L8;
        if (k1() == false) goto L8;
        this.O3 = true;
        goto L8
    L39:
        if (r106.equals("list_type") == false) goto L8;
        if ((!Intrinsics.areEqual(this.H3, r105)) == false) goto L8;
        if ((r105 instanceof String) == true) goto L45;
        r105 = null;
    L45:
        this.H3 = (String) r105;
        goto L46
    L48:
        if (r106.equals("initial_scroll_offset") == false) goto L8;
        if ((!Intrinsics.areEqual(this.N3, r105)) == false) goto L8;
        this.N3 = r105;
        if (this.O3 == true) goto L8;
        if (k1() == false) goto L8;
        this.O3 = true;
        goto L8
    L56:
        if (r102 == false) goto L136;
        boolean r109 = com.bytedance.android.ecom.arch.slice.render.util.b.a(this.J3);
        String r110 = this.H3;
        if (r110 == null) goto L82;
        int r111 = r110.hashCode();
        if (r111 == (-213632750)) goto L73;
        if (r111 != 3181382) goto L82;
        if (r110.equals(GXViewKey.VIEW_TYPE_CONTAINER_GRID) == false) goto L82;
        int r112 = com.bytedance.android.ecom.arch.slice.render.util.b.f(this.I3, 1);
        if (r112 < 1) goto L71;
        r101 = r112;
    L71:
        getView().setLayoutManager(new GridLayoutManager(getContext(), r101, r109 ? 1 : 0, false));
    L83:
        SlcListElementViewManager$staggeredOnScrollListener$1 r113 = this.U3;
        if (r113 == null) goto L87;
        getView().removeOnScrollListener(r113);
    L87:
        if (Intrinsics.areEqual(this.H3, "waterfall") == false) goto L137;
        SlcListElementView r114 = getView();
        SlcListElementViewManager$staggeredOnScrollListener$1 r115 = this.U3;
        ?? r116 = r115;
        if (r115 != null) goto L91;
        ?? r117 = new SlcListElementViewManager$staggeredOnScrollListener$1(this);
        this.U3 = r117;
        r116 = r117;
    L91:
        r114.addOnScrollListener(r116);
        return;
    L137:
        return;
    L73:
        if (r110.equals("waterfall") == false) goto L82;
        int r118 = com.bytedance.android.ecom.arch.slice.render.util.b.f(this.I3, 1);
        if (r118 < 1) goto L78;
        r101 = r118;
    L78:
        StaggeredGridLayoutManager r119 = new StaggeredGridLayoutManager(r101, r109 ? 1 : 0);
        if (this.f50260a.f50235w.L == false) goto L81;
        r119.setGapStrategy(0);
    L81:
        getView().setLayoutManager(r119);
    L82:
        getView().setLayoutManager(new SlcLinearLayoutManager(getContext(), r109 ? 1 : 0));
        goto L83
    L136:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void I0(Map<String, ? extends Object> r100) {
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r101.hasNext() == false) goto L21;
        Map.Entry<String, ? extends Object> r104 = r101.next();
        Object r105 = r104.getValue();
        String r106 = r104.getKey();
        int r107 = r106.hashCode();
        if (r107 != (-2105149843)) goto L8;
        if (r106.equals("column_gap") == false) goto L4;
        if ((!Intrinsics.areEqual(this.K3, r105)) == false) goto L4;
        this.K3 = r105;
    L20:
        r103 = true;
        goto L4
    L8:
        if (r107 != 1386871537) goto L4;
        if (r106.equals("row_gap") == false) goto L4;
        if ((!Intrinsics.areEqual(this.L3, r105)) == false) goto L4;
        this.L3 = r105;
        goto L20
    L21:
        if (r103 == false) goto L49;
        int r108 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(this.K3, 0.0f)), this.f50260a.m());
        if (r108 >= 0) goto L25;
        r108 = 0;
    L25:
        int r109 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(this.L3, 0.0f)), this.f50260a.m());
        if (r109 < 0) goto L29;
        r102 = r109;
    L29:
        SlcListItemDecoration r110 = this.P3;
        if (r110 != null) goto L32;
        SlcListItemDecoration r111 = new SlcListItemDecoration(r108, r102, this.f50260a.f50235w.H);
        getView().addItemDecoration(r111);
        this.P3 = r111;
        return;
    L32:
        r110.f50466a = r108;
        r110.f50467b = r102;
        J0();
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final BaseSlcViewManager<?> M(String r100) {
        BaseSlcViewManager<?> r101 = super.M(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        SlcListElementView r102 = getView();
        int r103 = r102.getChildCount();
        int r104 = 0;
    L6:
        BaseSlcViewManager<?> r105 = null;
        if (r104 >= r103) goto L20;
        View r106 = r102.getChildAt(r104);
        if ((r106 instanceof SlcItemView) == true) goto L11;
        r106 = null;
    L11:
        SlcItemView r107 = (SlcItemView) r106;
        if (r107 == null) goto L14;
        BaseSlcViewManager<?> r108 = r107.getRootViewManager();
    L15:
        if (r108 == null) goto L17;
        r105 = r108.M(r100);
    L17:
        if (r105 != null) goto L18;
        r104 = r104 + 1;
        goto L6
    L18:
        return r105;
    L14:
        r108 = null;
        goto L15
    L20:
        return null;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    @SlcUIActionErrorCode
    public final int k0(lq.b r110) {
        String r100 = r110.getType();
        if (r100.hashCode() == (-402165208)) goto L6;
    L190:
        return 3;
    L6:
        if (r100.equals("scrollTo") == false) goto L190;
        RecyclerView.Adapter r101 = getView().getAdapter();
        if ((r101 instanceof SlcListElementAdapter) == true) goto L10;
        r101 = null;
    L10:
        SlcListElementAdapter r102 = (SlcListElementAdapter) r101;
        if (r102 != null) goto L13;
    L189:
        return 4;
    L13:
        if (r102.getItemCount() == 0) goto L188;
        Map<String, Object> r103 = r110.f510283b;
        if (r103 != null) goto L18;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == true) goto L189;
        String r105 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r103.get(SlcElement.KEY_SLICE_KEY));
        if (r105 != null) goto L27;
    L30:
        boolean r106 = true;
    L31:
        int r107 = -1;
        if (r106 == true) goto L99;
        SlcListElementView r108 = getView();
        int r111 = r108.getChildCount();
        int r112 = 0;
    L34:
        if (r112 >= r111) goto L47;
        View r113 = r108.getChildAt(r112);
        if ((r113 instanceof SlcItemView) == true) goto L38;
        View r114 = null;
    L39:
        SlcItemView r115 = (SlcItemView) r114;
        if (r115 == null) goto L46;
        BaseSlcViewManager<?> r116 = r115.getRootViewManager();
        if (r116 == null) goto L46;
        if (Intrinsics.areEqual(r105, r116.d0()) == false) goto L46;
        r107 = r108.getChildAdapterPosition(r113);
    L97:
        if (r107 < 0) goto L189;
    L103:
        String r109 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r103.get("align"));
        if (r109 == null) goto L106;
        String r117 = r109;
    L107:
        int r118 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r103.get("offset"), 0.0f)), this.f50260a.m());
        boolean r119 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r103.get("smooth"));
        if (r107 >= 0) goto L121;
        if (r118 == 0) goto L188;
        if (m1() == false) goto L116;
        SlcListElementView r120 = getView();
        int r121 = -r118;
        if (r119 == false) goto L115;
        r120.smoothScrollBy(0, r121);
        goto L188
    L115:
        r120.scrollBy(0, r121);
        goto L188
    L116:
        SlcListElementView r122 = getView();
        int r123 = -r118;
        if (r119 == false) goto L119;
        r122.smoothScrollBy(r123, 0);
        goto L188
    L119:
        r122.scrollBy(r123, 0);
        goto L188
    L121:
        if (this.f50260a.f50235w.H == true) goto L123;
        p1(r107, r118);
        goto L188
    L123:
        RecyclerView.LayoutManager r124 = getView().getLayoutManager();
        if (r124 == null) goto L189;
        View r125 = r124.findViewByPosition(r107);
        if (r125 == null) goto L143;
        getView().stopScroll();
        boolean r126 = m1();
        if (r126 == false) goto L130;
        int r127 = r125.getTop();
        int r128 = r125.getBottom() - r127;
        int r129 = r124.getHeight();
    L131:
        int r130 = r127 - a.a(r129, r128, r117, this.R3, r118);
        if (r130 == 0) goto L188;
        if (r126 == false) goto L139;
        SlcListElementView r131 = getView();
        if (r119 == false) goto L138;
        r131.smoothScrollBy(0, r130);
        goto L188
    L138:
        r131.scrollBy(0, r130);
        goto L188
    L139:
        SlcListElementView r132 = getView();
        if (r119 == false) goto L142;
        r132.smoothScrollBy(r130, 0);
        goto L188
    L142:
        r132.scrollBy(r130, 0);
        goto L188
    L130:
        r127 = r125.getLeft();
        r128 = r125.getRight() - r127;
        r129 = r124.getWidth();
        goto L131
    L143:
        if (r119 == false) goto L145;
        getView().stopScroll();
        SlcAlignSmoothScroller r133 = new SlcAlignSmoothScroller(getContext(), m1(), this.R3, r117, r118);
        r133.setTargetPosition(r107);
        r124.startSmoothScroll(r133);
        goto L188
    L145:
        getView().stopScroll();
        boolean r134 = m1();
        if (r134 == false) goto L148;
        int r135 = r124.getPaddingTop();
    L149:
        int r136 = l1(r107);
        if (r134 == false) goto L152;
        int r137 = r124.getHeight();
    L154:
        if (Intrinsics.areEqual(r117, "start") == false) goto L156;
        p1(r107, (r118 - r136) - (r135 - this.R3));
        goto L188
    L156:
        RecyclerView.Adapter r138 = getView().getAdapter();
        if ((r138 instanceof SlcListElementAdapter) == true) goto L159;
        r138 = null;
    L159:
        SlcListElementAdapter r139 = (SlcListElementAdapter) r138;
        if (r139 == null) goto L189;
        int r140 = r139.getItemViewType(r107);
        RecyclerView.RecycledViewPool r141 = getView().getRecycledViewPool();
        RecyclerView.ViewHolder r142 = r141.getRecycledView(r140);
        if ((r142 instanceof SlcListElementViewHolder) == true) goto L164;
        RecyclerView.ViewHolder r143 = null;
    L165:
        SlcListElementViewHolder r144 = (SlcListElementViewHolder) r143;
        if (r144 != null) goto L169;
        r144 = r139.createViewHolder(getView(), r140);
    L169:
        SlcListElementViewHolder r145 = r144;
        r139.bindViewHolder(r145, r107);
        View r146 = r145.itemView;
        r146.setLayoutParams(r124.generateDefaultLayoutParams());
        if ((r124 instanceof GridLayoutManager) == false) goto L177;
        GridLayoutManager r147 = (GridLayoutManager) r124;
        int r148 = r147.getSpanCount();
        if (r147.getOrientation() != 1) goto L174;
        r124.measureChild(r146, r147.getWidth() - (r147.getWidth() / r148), 0);
    L183:
        View r149 = r145.itemView;
        if (r134 == false) goto L186;
        int r150 = r149.getMeasuredHeight();
    L187:
        p1(r107, (a.a(r137, r150, r117, this.R3, r118) - r135) - r136);
        r141.putRecycledView(r145);
        goto L188
    L186:
        r150 = r149.getMeasuredWidth();
        goto L187
    L174:
        r124.measureChild(r146, 0, r147.getHeight() - (r147.getHeight() / r148));
        goto L183
    L177:
        if ((r124 instanceof StaggeredGridLayoutManager) == false) goto L182;
        StaggeredGridLayoutManager r151 = (StaggeredGridLayoutManager) r124;
        int r152 = r151.getSpanCount();
        if (r151.getOrientation() != 1) goto L181;
        r124.measureChild(r146, r151.getWidth() - (r151.getWidth() / r152), 0);
        goto L183
    L181:
        r124.measureChild(r146, 0, r151.getHeight() - (r151.getHeight() / r152));
        goto L183
    L182:
        r124.measureChild(r146, 0, 0);
        goto L183
    L164:
        r143 = r142;
        goto L165
    L152:
        r137 = r124.getWidth();
        goto L154
    L148:
        r135 = r124.getPaddingLeft();
        goto L149
    L106:
        r117 = "start";
    L46:
        r112 = r112 + 1;
        goto L34
    L38:
        r114 = r113;
        goto L39
    L47:
        List<com.bytedance.android.ecom.arch.slice.render.elements.list.a> r153 = r102.f50454a;
        Map<String, Object> r154 = r102.f50455b;
        int r155 = r153.size();
        int r156 = 0;
    L48:
        if (r156 >= r155) goto L97;
        SlcElement r157 = ((com.bytedance.android.ecom.arch.slice.render.elements.list.a) ListProtector.get(r153, r156)).f50470b;
        d r158 = r157.bindInfo;
        if (r158 == null) goto L54;
        Map<String, String> r159 = r158.f50130a;
        if (r159 == null) goto L54;
        String r160 = r159.get(SlcElement.KEY_SLICE_KEY);
    L55:
        if (r160 != null) goto L57;
    L60:
        boolean r161 = true;
    L61:
        if (r161 == true) goto L78;
        d r162 = r157.bindInfo;
        if (r162 == null) goto L67;
        com.bytedance.android.ecom.arch.slice.render.bindinfo.c r163 = r162.f50133d;
        if (r163 == null) goto L67;
        Map<String, Object> r164 = SlcBindInfoKt.c(r154, r163, r157.forConfigValue);
    L68:
        Map<String, ? extends Object> r165 = r157.getProps();
        if (r165 != null) goto L71;
    L74:
        boolean r166 = true;
    L75:
        if (r166 == true) goto L77;
        Map<String, Object> r167 = this.f50260a.g(r165, r164);
        r164 = this.f50260a.r(MapsKt.hashMapOf(new Pair[]{TuplesKt.to(SlcElement.KEY_PROPS, r167)}));
    L77:
        SlcTemplateContext r168 = this.f50260a;
        String r169 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r168.f50235w.f50187m0.a(r160, r164, r168.f50230r));
    L92:
        if (r169 == null) goto L96;
        if (Intrinsics.areEqual(r169, r105) == false) goto L96;
        r107 = r156;
    L96:
        r156 = r156 + 1;
        goto L48
    L71:
        if (r165.isEmpty() == true) goto L74;
        r166 = false;
    L67:
        r164 = r154;
        goto L68
    L78:
        Map<String, Object> r170 = r157.getAttr();
        if (r170 == null) goto L81;
        Object r171 = r170.get(SlcElement.KEY_SLICE_KEY);
    L82:
        r169 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r171);
        if (r169 != null) goto L85;
    L88:
        boolean r172 = true;
    L89:
        if (r172 == false) goto L92;
        r169 = null;
        goto L92
    L85:
        if (r169.length() == 0) goto L88;
        r172 = false;
        goto L89
    L81:
        r171 = null;
        goto L82
    L57:
        if (r160.length() == 0) goto L60;
        r161 = false;
    L54:
        r160 = null;
        goto L55
    L99:
        int r173 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r103.get("index"), -1);
        if (r173 < r102.getItemCount()) goto L102;
        r107 = (-1) + r102.getItemCount();
        goto L103
    L102:
        r107 = r173;
        goto L103
    L27:
        if (r105.length() == 0) goto L30;
        r106 = false;
        goto L31
    L18:
        if (r103.isEmpty() == true) goto L21;
        r104 = false;
    L188:
        return 0;
    }

    public final int l1(int r100) {
        if (r100 <= 0) goto L13;
        SlcListItemDecoration r101 = this.P3;
        if (r101 == null) goto L13;
        RecyclerView.LayoutManager r102 = getView().getLayoutManager();
        if ((r102 instanceof GridLayoutManager) == false) goto L10;
        if (r100 < ((GridLayoutManager) r102).getSpanCount()) goto L13;
    L10:
        if (m1() == false) goto L16;
        return r101.f50467b;
    L16:
        return r101.f50466a;
    L13:
        return 0;
    }

    public void n1(SlcListElementView r100) {
        r100.setLayoutManager(new SlcLinearLayoutManager(getContext(), 0));
        r100.setOverScrollMode(1);
        r100.setClipToPadding(false);
        r100.setItemAnimator(null);
    }

    public SlcListElementView o1(Context r100) {
        return new SlcListElementView(r100, null, 6, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void w0(Map<String, ? extends Object> r100) {
        RecyclerView.Adapter r101 = getView().getAdapter();
        if ((r101 instanceof SlcListElementAdapter) == true) goto L5;
        r101 = null;
    L5:
        SlcListElementAdapter r102 = (SlcListElementAdapter) r101;
        if (r102 == null) goto L42;
        r102.y2(r100);
        if (this.O3 == false) goto L22;
        this.O3 = false;
        int r103 = com.bytedance.android.ecom.arch.slice.render.util.b.f(this.M3, -1);
        if (r103 >= r102.getItemCount()) goto L12;
    L14:
        int r104 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(this.N3, 0.0f)), this.f50260a.m());
        if (r103 >= 0) goto L18;
        p1(0, r104);
        goto L22
    L18:
        if (m1() == false) goto L20;
        int r105 = getView().getPaddingTop();
    L21:
        p1(r103, (r104 - r105) - l1(r103));
        goto L22
    L20:
        r105 = getView().getPaddingLeft();
        goto L21
    L12:
        if (r102.getItemCount() <= 0) goto L14;
        r103 = r102.getItemCount() - 1;
    L22:
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == false) goto L25;
        return;
    L25:
        if (nq.a.h() == false) goto L44;
        BaseSlcViewGroupManager<?> r106 = this.f50268d;
        if (r106 == null) goto L45;
        SlcElement r107 = r106.f50270e;
        if (r107 == null) goto L46;
        Map<String, Object> r108 = r107.getStyle();
        if (r108 != null) goto L33;
    L34:
        d r109 = r107.bindInfo;
        if (r109 == null) goto L47;
        Map<String, String> r110 = r109.f50131b;
        if (r110 != null) goto L39;
        return;
    L39:
        if (r110.containsKey("overflow") != true) goto L49;
    L40:
        nq.a.f(null, "List的parent节点不能设置overflow:visible");
        nq.a.i(getContext(), "List的parent节点不能设置overflow:visible");
        return;
    L49:
        return;
    L47:
        return;
    L33:
        if (r108.containsKey("overflow") == true) goto L40;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public /* bridge */ /* synthetic */ void x0(View r100) {
        n1((SlcListElementView) r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void y0(SlcElement r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        List<SlcElement> r101 = r100.getElements();
        getView().setAdapter(new SlcListElementAdapter(this.f50260a, r101));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void T0(String r100, boolean r101) {
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == false) goto L20;
        Object r102 = getView().getParent();
        if (r102 == null) goto L17;
        if (r100 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        boolean r104 = !r103;
        if ((r102 instanceof SlcRootView) == false) goto L15;
        ((View) r102).setTag(Boolean.valueOf(r104));
        goto L17
    L15:
        if ((r102 instanceof SlcItemView) == false) goto L17;
        ((View) r102).setTag(Boolean.valueOf(r104));
        goto L17
    L8:
        if ("visible".equals(r100) == false) goto L10;
        r103 = true;
    L17:
        SlcListElementView r105 = getView();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r105.forceHasOverlappingRendering(!r101);
        return;
    L22:
        return;
    L20:
        super.T0(r100, r101);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void V0(List<?> r100, float r101) {
        super.V0(r100, r101);
        this.R3 = SlcDimensExtensionsKt.a(Float.valueOf(r101), this.f50260a.m());
    }

    public final void p1(int r100, int r101) {
        RecyclerView.LayoutManager r102 = getView().getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L6;
        ((LinearLayoutManager) r102).scrollToPositionWithOffset(r100, r101);
    L8:
        if (r100 != 0) goto L12;
        if (r101 != 0) goto L13;
        SlcListElementView r103 = getView();
        r103.f50459b = 0;
        r103.f50460c = 0;
        return;
    L13:
        return;
    L12:
        return;
    L6:
        if ((r102 instanceof StaggeredGridLayoutManager) == false) goto L8;
        ((StaggeredGridLayoutManager) r102).scrollToPositionWithOffset(r100, r101);
        goto L8
    }
}
