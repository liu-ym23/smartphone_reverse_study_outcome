package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/c;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeVH extends AbsFullSpanVH<c> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f170040m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ViewGroup f170041n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d f170042o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f170043p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e f170044q;

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final int M0() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r100, Object r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onScan() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r100) {
        return null;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final View t() {
        return this.itemView;
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public final void a4(Object r210) {
        c r110 = (c) r210;
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        View r100 = this.itemView;
        if ((r100 instanceof AnchorV4ReceivingNoticeView) == true) goto L5;
        r100 = null;
    L5:
        AnchorV4ReceivingNoticeView r111 = (AnchorV4ReceivingNoticeView) r100;
        if (r111 == null) goto L62;
        AnchorV4ReceivingNoticeDisplay r101 = r110.f170052b;
        AnchorV4ReceivingNoticeMeta r112 = r110.f170053c;
        b r113 = this.f170040m;
        CommonMeta r102 = this.f170044q.a();
        if (r102 == null) goto L10;
        Boolean r103 = Boolean.valueOf(r102.getEnablePDPOptimize());
    L11:
        boolean r114 = k.i(r103);
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(this, "actionHub");
        Intrinsics.checkNotNullParameter(r113, "logAction");
        if (r101 == null) goto L61;
        List<AnchorV4Tab> r104 = r101.getTabs();
        int r105 = 0;
        if (r104 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        if (r106 == true) goto L61;
        r111.getClass();
        r111.setVisibility(0);
        ((LongContentLabelComponentView) r111.a(R.id.receiving_notice_label)).bind(r101.getTitle());
        ((LinearLayout) r111.a(R.id.pick_up_tag_layout)).removeAllViews();
        Iterator<T> r115 = r101.getTabs().iterator();
        int r107 = 0;
    L24:
        if (r115.hasNext() == false) goto L56;
        Object r108 = r115.next();
        int r116 = r107 + 1;
        if (r107 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        AnchorV4Tab r109 = (AnchorV4Tab) r108;
        TextWithOneIconElementView r117 = new TextWithOneIconElementView(r111.getContext(), null, 0, null, 30);
        c r118 = r110;
        b r211 = r113;
        r117.setOnClickListener(new d(r107, r109, r117, r111, this, r114, r113, r112));
        ViewGroup.LayoutParams r119 = null;
        r111.c(r117, r109, null);
        TextWithOneIconElement r120 = r109.getTabName();
        if (r120 == null) goto L31;
        String r121 = r120.getStatusId();
    L33:
        if (Intrinsics.areEqual(r121, TabSelection.SELECTED.getValue()) == false) goto L35;
        r111.b(r109.getGroups(), this, r114);
    L35:
        ((LinearLayout) r111.a(R.id.pick_up_tag_layout)).addView(r117, new LinearLayout.LayoutParams(0, com.bytedance.android.shopping.extensions.b.b(28), 1.0f));
        if (r211 == null) goto L39;
        r211.b();
    L39:
        if (r114 == false) goto L54;
        View r122 = r111.a(R.id.pick_up_tag_layout);
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        if ((r123 instanceof ViewGroup.MarginLayoutParams) == true) goto L43;
        r123 = null;
    L43:
        ViewGroup.MarginLayoutParams r124 = (ViewGroup.MarginLayoutParams) r123;
        if (r124 == null) goto L46;
        r124.topMargin = com.bytedance.android.shopping.extensions.b.b(16);
        r122.setLayoutParams(r124);
    L46:
        View r125 = r111.a(R.id.receive_groups_layout);
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if ((r126 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r119 = r126;
    L50:
        ViewGroup.MarginLayoutParams r127 = (ViewGroup.MarginLayoutParams) r119;
        if (r127 == null) goto L53;
        r127.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r125.setLayoutParams(r127);
    L53:
        ((LinearLayout) r111.a(R.id.receive_groups_layout)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV4ReceivingNoticeView$bind$1$4.INSTANCE));
        r111.f170048d.f(new Radius(12, 12, 12, 12));
        r111.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), 0);
    L55:
        r107 = r116;
        r110 = r118;
        r113 = r211;
        r105 = 0;
        goto L24
    L54:
        ((LinearLayout) r111.a(R.id.receive_groups_layout)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV4ReceivingNoticeView$bind$1$5.INSTANCE));
        r111.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(16));
        goto L55
    L31:
        r121 = null;
        goto L33
    L56:
        c r128 = r110;
        if (r114 == false) goto L59;
        Integer[] r129 = new Integer[4];
        r129[r105] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r129[1] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r129[2] = Integer.valueOf(r105);
        r129[3] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        List r130 = CollectionsKt.listOf(r129);
        int r131 = 12;
    L60:
        int r132 = q.f166972a;
        c r133 = r128;
        q.a(r111, r133.f170055e, r111.f170048d, r131, -1, r130);
    L63:
        this.f170042o.b(this, r133);
        View r134 = this.itemView;
        if (r134 == null) goto L68;
        ExtensionsKt.e((ViewGroup) r134, this);
        return;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L59:
        Integer[] r135 = new Integer[4];
        r135[r105] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r135[1] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r135[2] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(16));
        r135[3] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r130 = CollectionsKt.listOf(r135);
        r131 = 8;
        goto L60
    L16:
        if (r104.isEmpty() == true) goto L19;
        r106 = false;
    L61:
        r133 = r110;
        r111.setVisibility(8);
        goto L63
    L10:
        r103 = null;
        goto L11
    L62:
        r133 = r110;
        goto L63
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r100, Action r110, Object r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "action");
        String r101 = r110.getId();
        AnchorV4ReceivingNoticeDisplay r112 = getItem().f170052b;
        if (r112 == null) goto L35;
        List<AnchorV4Tab> r113 = r112.getTabs();
        if (r113 == null) goto L46;
        Iterator<T> r114 = r113.iterator();
        int r102 = 0;
    L8:
        if (r114.hasNext() == false) goto L47;
        Object r103 = r114.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        List<Group> r105 = ((AnchorV4Tab) r103).getGroups();
        if (r105 == null) goto L34;
        Iterator<T> r106 = r105.iterator();
        int r107 = 0;
    L16:
        if (r106.hasNext() == false) goto L34;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        Group r115 = (Group) r108;
        if (Intrinsics.areEqual("receiving_notices_tab_" + r102 + "_group_" + r107, r101) == false) goto L33;
        AnchorV4ReceivingNoticeMeta r116 = getItem().f170053c;
        if (r116 == null) goto L33;
        AnchorV4ReceivingNoticeBusinessMeta r117 = r116.getBusinessMeta();
        if (r117 == null) goto L33;
        Map<String, String> r118 = r117.getJumpUrls();
        if (r118 == null) goto L33;
        String r119 = r118.get(r101);
        if (r119 == null) goto L33;
        String r120 = a2.d(r119);
        if (r120 == null) goto L33;
        JSONObject r121 = new JSONObject();
        r121.put("selectedIndex", r102);
        Context r122 = this.f170043p;
        this.f170044q.j();
        com.bytedance.android.shopping.anchorv4.containers.b.b(r122, r120, r121, this.f170044q.d());
    L33:
        r107 = r109;
    L34:
        r102 = r104;
        goto L8
    L47:
        return;
    L46:
        return;
    }

    public AnchorV4ReceivingNoticeVH(ViewGroup r100, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r101, FragmentActivity r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        Intrinsics.checkNotNullParameter(r101, "logManager");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        AttributeSet r104 = null;
        super(new AnchorV4ReceivingNoticeView(r100.getContext(), r104, 6, 0), true);
        this.f170041n = r100;
        this.f170042o = r101;
        this.f170043p = r102;
        this.f170044q = r103;
        this.f170040m = new b(this);
    }
}
