package com.bytedance.android.shopping.anchorv4.nav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/nav/AnchorV4TabArea;", "Landroid/widget/FrameLayout;", "Lcom/google/android/material/tabs/TabLayout$BaseOnTabSelectedListener;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "tab", "", "setTabSelected", "Lcom/bytedance/android/ecom/arch/slice/adapter/b;", MapController.ITEM_LAYER_TAG, "setDockTab", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4TabArea extends FrameLayout implements TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f167088i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f167089j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TabLayout f167090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f167091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function2<? super String, ? super Integer, Unit> f167092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function2<? super Integer, ? super List<ScrollNode>, Unit> f167093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<? super String, Unit> f167094e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ScrollNode> f167095f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f167096g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f167097h;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4TabArea f167098a;

        public a(AnchorV4TabArea r100) {
            this.f167098a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.nav.d
        public final void a(int r100, ScrollNode r101) {
            Intrinsics.checkNotNullParameter(r101, "node");
            AnchorV4TabArea r102 = this.f167098a;
            String r103 = r101.getLogName();
            String r104 = r101.getId();
            int r105 = AnchorV4TabArea.f167088i;
            r102.a(r103, r104, r100);
        }
    }

    public static final class b {
    }

    public AnchorV4TabArea(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV4TabArea(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
    }

    static {
        f167088i = com.bytedance.android.shopping.extensions.b.b(200);
    }

    private final void setTabSelected(TabLayout.Tab r100) {
        Object r101 = r100.getTag();
        if ((r101 instanceof g) == true) goto L5;
        r101 = null;
    L5:
        g r102 = (g) r101;
        if (r102 != null) goto L8;
        return;
    L8:
        a(r102.f167176c, r102.f167175b, r102.f167174a);
        TabLayout r103 = this.f167090a;
        if (r103 == null) goto L12;
        r103.setScrollPosition(r102.f167174a, 0.0f, true);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f167097h == true) goto L5;
        return false;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        setTabSelected(r100);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        Intrinsics.checkNotNullParameter(r100, "tab");
        setTabSelected(r100);
    }

    public final void setDockTab(com.bytedance.android.ecom.arch.slice.adapter.b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Integer r101 = null;
        if ((r100 instanceof VOIdentifier) == false) goto L6;
        Object r102 = ((VOIdentifier) r100).config().f168384a;
    L12:
        List<ScrollNode> r103 = this.f167095f;
        if (r103 == null) goto L40;
        Iterator<ScrollNode> r104 = r103.iterator();
        boolean r105 = false;
        int r106 = 0;
    L16:
        if (r104.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r104.next().getId(), r102) == true) goto L22;
        r106 = r106 + 1;
    L22:
        Integer r107 = Integer.valueOf(r106);
        if (r107.intValue() < 0) goto L25;
        r105 = true;
    L25:
        if (r105 == false) goto L27;
        r101 = r107;
    L27:
        if (r101 == null) goto L41;
        int r108 = r101.intValue();
        Function2<? super Integer, ? super List<ScrollNode>, Unit> r109 = this.f167093d;
        if (r109 == null) goto L31;
        Unit r110 = r109.invoke(Integer.valueOf(r108), this.f167095f);
    L31:
        e r111 = this.f167091b;
        if (r111 == null) goto L34;
        r111.setSelectedIndex(r108);
        return;
    L34:
        TabLayout r112 = this.f167090a;
        if (r112 == null) goto L43;
        r112.setScrollPosition(r108, 0.0f, true);
        return;
    L43:
        return;
    L41:
        return;
    L21:
        r106 = -1;
        goto L22
    L40:
        return;
    L6:
        if ((r100 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == false) goto L11;
        Map<String, Object> r113 = ((com.bytedance.android.ecom.arch.slice.slices.template.d) r100).getConfig();
        if (r113 == null) goto L10;
        r102 = r113.get("scroll_id");
        goto L12
    L10:
        r102 = null;
        goto L12
    L11:
        r102 = "";
        goto L12
    }

    public final void b(List<ScrollNode> r100, boolean r110) {
        if (r110 == false) goto L12;
        if (r100 == null) goto L11;
        ArrayList r111 = new ArrayList();
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (CollectionsKt.contains(c.f167121a, ((ScrollNode) r102).getId()) == false) goto L6;
        r111.add(r102);
        goto L6
    L10:
        r100 = r111;
        goto L12
    L11:
        r100 = null;
    L12:
        this.f167095f = r100;
        List<ScrollNode> r112 = r100;
        int r103 = 0;
        if (r112 != null) goto L15;
    L18:
        boolean r113 = true;
    L19:
        if (r113 == false) goto L22;
        setVisibility(8);
        return;
    L22:
        setVisibility(0);
        e r114 = this.f167091b;
        if (r114 == null) goto L26;
        if (r114 == null) goto L35;
        r114.setupNodes(r100);
        return;
    L35:
        return;
    L26:
        TabLayout r115 = this.f167090a;
        if (r115 == null) goto L45;
        r115.removeAllTabs();
        List<ScrollNode> r104 = r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L30:
        if (r106.hasNext() == false) goto L46;
        Object r107 = r106.next();
        int r108 = r103 + 1;
        if (r103 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        ScrollNode r109 = (ScrollNode) r107;
        TabLayout.Tab r116 = r115.newTab().setText(r109.getName());
        r116.setTag(new g(r103, r109.getId(), r109.getLogName()));
        Unit r117 = Unit.INSTANCE;
        r115.addTab(r116);
        r105.add(r109);
        r103 = r108;
        goto L30
    L46:
        return;
    L45:
        return;
    L15:
        if (r112.isEmpty() == true) goto L18;
        r113 = false;
        goto L19
    }

    public AnchorV4TabArea(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f167096g = true;
        this.f167097h = true;
        setAlpha(0.0f);
        if (PdpPerfOpt.d() == false) goto L5;
        e r103 = new e(r100);
        this.f167091b = r103;
        r103.setCallback(new a(this));
        Unit r104 = Unit.INSTANCE;
        addView(r103, -1, com.bytedance.android.shopping.extensions.b.a(44));
        return;
    L5:
        LayoutInflater.from(th.a.e(r100, false)).inflate(R.layout.ec_commerce_anchor_v4_tabs_area, this, true);
        TabLayout r105 = (TabLayout) findViewById(R.id.anchor_v4_top_tab_layout);
        this.f167090a = r105;
        if (r105 == null) goto L10;
        r105.addOnTabSelectedListener(this);
        return;
    }

    public final void a(String r100, String r101, int r102) {
        Function1<? super String, Unit> r103 = this.f167094e;
        if (r103 != null) goto L5;
    L15:
        this.f167096g = false;
        if (r101 == null) goto L21;
        Function2<? super String, ? super Integer, Unit> r104 = this.f167092c;
        if (r104 == null) goto L22;
        Unit r105 = r104.invoke(r101, Integer.valueOf(r102));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (this.f167097h == true) goto L7;
    L9:
        boolean r106 = false;
    L10:
        if (r106 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        Unit r107 = r103.invoke(r100);
        goto L15
    L7:
        if (this.f167096g == true) goto L9;
        r106 = true;
        goto L10
    }

    public /* synthetic */ AnchorV4TabArea(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
