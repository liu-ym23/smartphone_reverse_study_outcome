package com.obric.oui.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.oui.common.util.g;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.popover.SpringInterpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.l.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WheelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WheelView extends FrameLayout {
    public static final a Companion = null;
    public static final int REPEAT = 1000;
    public static final float TAG_TEXT_SIZE = 14.0f;
    public static final int VISIBLE_ROW_COUNT = 5;
    public static final float WHEEL_TEXT_SIZE = 22.0f;
    private final b adapter;
    private boolean hasSettledSinceDrag;
    private int highlightConorRadiusPx;
    private int horizontalPaddingPx;
    private boolean isCyclic;
    private int itemHeight;
    private int lastCenterIndex;
    private int lastChangedDataIndex;
    private int lastHapticIndex;
    private final com.obric.oui.picker.reels.views.c layoutManager;
    private float maxTextWidth;
    private int normalTextColor;
    private float normalTextSizePx;
    private com.obric.oui.picker.reels.views.a onWheelChangedListener;
    private int pendingInitialIndex;
    private int pendingInitialScrollPosition;
    private int pendingVerifyCenterAdapterPosition;
    private boolean programmaticScrolling;
    private final RecyclerView recyclerView;
    private final d scrollListener;
    private int selectedTextColor;
    private float selectedTextSizePx;
    private boolean showDivider;
    private boolean suppressNextSnapOnce;
    private Integer tagGap;
    private final TextView tvTag;
    private boolean userScrolling;
    private int visibleRowCount;
    private CharSequence wheelTagText;
    private float wheelTextSizePx;

    /* JADX INFO: compiled from: WheelView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: WheelView.kt */
    private final class b extends RecyclerView.a<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f35956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<CharSequence> f35957b;

        public static /* synthetic */ void lambda$B34hneccLVD4DI17Cr_ZXS8_n_I(c r0, WheelView r1, View r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$BSN5KVJCwxO8VZfirmCK_90oi0A(c r0, WheelView r1, View r2) {
            b(r0, r1, r2);
        }

        public b(WheelView r2) {
            o.e(r2, "this$0");
            this.f35956a = r2;
            this.f35957b = new ArrayList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public /* synthetic */ void a(RecyclerView.v r3, int r4) {
            a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
        }

        public final ArrayList<CharSequence> b() {
            return this.f35957b;
        }

        public final void a(List<? extends CharSequence> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r5, "data");
            this.f35957b.clear();
            this.f35957b.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
            g();
        }

        public c a(ViewGroup r4, int r5) {
            o.e(r4, "parent");
            TextView r6 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            WheelView r3 = this.f35956a;
            r6.setId(R.id.text1);
            r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new RecyclerView.LayoutParams(-1, WheelView.access$getItemHeight$p(r3)), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            r6.setGravity(17);
            r6.setTextSize(0, WheelView.access$getWheelTextSizePx$p(r3));
            r6.setIncludeFontPadding(false);
            return new c((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));
        }

        public void a(final c r5, int r6) {
            o.e(r5, "holder");
            int r7 = WheelView.access$adapterToDataIndex(this.f35956a, r6);
            if (this.f35956a.isCyclic() == false) goto L6;
            r5.a().setAlpha(1.0f);
            r5.a().setTextSize(0, WheelView.access$getWheelTextSizePx$p(this.f35956a));
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f35957b.get(r7), CharSequence.class, "com.obric.aiagent.plugin"));
            View r8 = r5.f35660b;
            final WheelView r4 = this.f35956a;
            r8.setOnClickListener(new $$Lambda$WheelView$b$B34hneccLVD4DI17Cr_ZXS8_n_I(r5, r4));
            return;
        L6:
            if (WheelView.access$isValidDataIndex(this.f35956a, r7) == false) goto L8;
            r5.a().setAlpha(1.0f);
            r5.a().setTextSize(0, WheelView.access$getWheelTextSizePx$p(this.f35956a));
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast(this.f35957b.get(r7), CharSequence.class, "com.obric.aiagent.plugin"));
            View r9 = r5.f35660b;
            final WheelView r10 = this.f35956a;
            r9.setOnClickListener(new $$Lambda$WheelView$b$BSN5KVJCwxO8VZfirmCK_90oi0A(r5, r10));
            return;
        L8:
            r5.a().setAlpha(0.0f);
            r5.a().setText((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
            r5.f35660b.setOnClickListener(null);
        }

        private static final void a(c r0, WheelView r1, View r2) {
            o.e(r0, "$holder");
            o.e(r1, "this$0");
            int r3 = r0.i();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.access$adapterToDataIndex(r1, r3);
            if (WheelView.access$isValidDataIndex(r1, r4) == false) goto L9;
            r1.setSelectedIndex(r4, true);
            return;
        L9:
            return;
        }

        private static final void b(c r0, WheelView r1, View r2) {
            o.e(r0, "$holder");
            o.e(r1, "this$0");
            int r3 = r0.i();
            if (r3 == (-1)) goto L8;
            int r4 = WheelView.access$adapterToDataIndex(r1, r3);
            if (WheelView.access$isValidDataIndex(r1, r4) == false) goto L9;
            r1.setSelectedIndex(r4, true);
            return;
        L9:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public int a() {
            int r0 = this.f35957b.size();
            if (r0 != 0) goto L7;
            return 0;
        L7:
            if (this.f35956a.isCyclic() == false) goto L10;
            return r0 * 1000;
        L10:
            return r0 + (WheelView.access$halfRows(this.f35956a) * 2);
        }
    }

    /* JADX INFO: compiled from: WheelView.kt */
    private static final class c extends RecyclerView.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f35958a;

        public c(View r3) {
            o.e(r3, "itemView");
            super(r3);
            View r4 = r3.findViewById(R.id.text1);
            o.c(r4, "itemView.findViewById(android.R.id.text1)");
            this.f35958a = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.aiagent.plugin");
        }

        public final TextView a() {
            return this.f35958a;
        }
    }

    /* JADX INFO: compiled from: WheelView.kt */
    public static final class d extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WheelView f35959a;

        d(WheelView r1) {
            this.f35959a = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r3, int r4, int r5) {
            o.e(r3, "rv");
            int r6 = WheelView.access$findNearestCenterIndex(this.f35959a);
            if (r6 != (-1)) goto L5;
            return;
        L5:
            if (r3.getScrollState() != 0) goto L7;
            return;
        L7:
            if (WheelView.access$getUserScrolling$p(this.f35959a) == true) goto L9;
            return;
        L9:
            if (WheelView.access$getProgrammaticScrolling$p(this.f35959a) == true) goto L33;
            int r7 = WheelView.access$adapterToDataIndex(this.f35959a, r6);
            if (WheelView.access$isValidDataIndex(this.f35959a, r7) == true) goto L13;
            return;
        L13:
            if (r6 == WheelView.access$getLastHapticIndex$p(this.f35959a)) goto L35;
            WheelView.access$setLastHapticIndex$p(this.f35959a, r6);
            com.obric.oui.b.a.f34003a.a((View) ZeusTransformUtils.preCheckCast(this.f35959a, View.class, "com.obric.aiagent.plugin"), 3);
            int r8 = WheelView.access$getLastChangedDataIndex$p(this.f35959a);
            if (r7 == WheelView.access$getLastChangedDataIndex$p(this.f35959a)) goto L36;
            boolean r9 = false;
            if (r8 >= 0) goto L19;
        L21:
            if (r9 == true) goto L24;
            r8 = r7;
        L24:
            com.obric.oui.picker.reels.views.a r10 = this.f35959a.getOnWheelChangedListener();
            if (r10 == null) goto L28;
            r10.a(r8, r7);
        L28:
            WheelView.access$setLastChangedDataIndex$p(this.f35959a, r7);
            return;
        L19:
            if (r8 >= WheelView.access$getAdapter$p(this.f35959a).b().size()) goto L21;
            r9 = true;
            goto L21
        L36:
            return;
        L35:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r6, int r7) {
            o.e(r6, "rv");
            if (r7 == 0) goto L14;
            if (r7 != 1) goto L6;
            WheelView.access$setUserScrolling$p(this.f35959a, true);
            WheelView.access$setHasSettledSinceDrag$p(this.f35959a, false);
            WheelView.access$setProgrammaticScrolling$p(this.f35959a, false);
            int r8 = WheelView.access$findNearestCenterIndex(this.f35959a);
            if (r8 == (-1)) goto L40;
            int r9 = WheelView.access$adapterToDataIndex(this.f35959a, r8);
            if (WheelView.access$isValidDataIndex(this.f35959a, r9) == false) goto L41;
            WheelView.access$setLastHapticIndex$p(this.f35959a, r8);
            WheelView.access$setLastChangedDataIndex$p(this.f35959a, r9);
            return;
        L41:
            return;
        L40:
            return;
        L6:
            if (r7 != 2) goto L47;
            WheelView.access$setHasSettledSinceDrag$p(this.f35959a, true);
            return;
        L47:
            return;
        L14:
            WheelView.access$setUserScrolling$p(this.f35959a, false);
            WheelView.access$setProgrammaticScrolling$p(this.f35959a, false);
            int r10 = WheelView.access$getPendingVerifyCenterAdapterPosition$p(this.f35959a);
            if (r10 == (-1)) goto L24;
            WheelView.access$setPendingVerifyCenterAdapterPosition$p(this.f35959a, -1);
            int r2 = WheelView.access$findNearestCenterIndex(this.f35959a);
            if (r2 == (-1)) goto L24;
            int r3 = WheelView.access$adapterToDataIndex(this.f35959a, r2);
            int r4 = WheelView.access$adapterToDataIndex(this.f35959a, r10);
            if (WheelView.access$isValidDataIndex(this.f35959a, r4) == false) goto L24;
            if (r3 == r4) goto L24;
            WheelView.access$centerToPosition(this.f35959a, r10, true);
            return;
        L24:
            if (WheelView.access$getSuppressNextSnapOnce$p(this.f35959a) == false) goto L26;
            WheelView.access$setSuppressNextSnapOnce$p(this.f35959a, false);
            boolean r11 = false;
        L28:
            if (WheelView.access$getHasSettledSinceDrag$p(this.f35959a) == false) goto L43;
            if (r11 == true) goto L44;
            WheelView.access$setHasSettledSinceDrag$p(this.f35959a, false);
            int r12 = WheelView.access$findNearestCenterIndex(this.f35959a);
            if (r12 == (-1)) goto L45;
            int r13 = WheelView.access$adapterToDataIndex(this.f35959a, r12);
            if (WheelView.access$isValidDataIndex(this.f35959a, r13) == false) goto L46;
            WheelView.access$setLastCenterIndex$p(this.f35959a, r12);
            com.obric.oui.picker.reels.views.a r5 = this.f35959a.getOnWheelChangedListener();
            if (r5 == null) goto L48;
            r5.a(r13);
            return;
        L48:
            return;
        L46:
            return;
        L45:
            return;
        L44:
            return;
        L43:
            return;
        L26:
            r11 = WheelView.access$snapToNearestCenter(this.f35959a);
            goto L28
        }
    }

    static {
        Companion = new a(null);
    }

    public WheelView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public WheelView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$VS3Xi1CyPKGWLO94txn69VTpgHo(WheelView r0) {
        m1118setItems$lambda6(r0);
    }

    public static /* synthetic */ void lambda$toCAjgMsRAXHyeV5CDigBN6ANes(WheelView r0) {
        m1116_init_$lambda0(r0);
    }

    public static /* synthetic */ void lambda$y6wEQn5FkPvsTz7M1m__J20kjNE(WheelView r0, int r1) {
        m1117centerToPosition$lambda7(r0, r1);
    }

    public /* synthetic */ WheelView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ int access$adapterToDataIndex(WheelView r0, int r1) {
        return r0.adapterToDataIndex(r1);
    }

    public static final /* synthetic */ void access$centerToPosition(WheelView r0, int r1, boolean r2) {
        r0.centerToPosition(r1, r2);
    }

    public static final /* synthetic */ int access$findNearestCenterIndex(WheelView r0) {
        return r0.findNearestCenterIndex();
    }

    public static final /* synthetic */ b access$getAdapter$p(WheelView r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ boolean access$getHasSettledSinceDrag$p(WheelView r0) {
        return r0.hasSettledSinceDrag;
    }

    public static final /* synthetic */ int access$getItemHeight$p(WheelView r0) {
        return r0.itemHeight;
    }

    public static final /* synthetic */ int access$getLastChangedDataIndex$p(WheelView r0) {
        return r0.lastChangedDataIndex;
    }

    public static final /* synthetic */ int access$getLastHapticIndex$p(WheelView r0) {
        return r0.lastHapticIndex;
    }

    public static final /* synthetic */ int access$getPendingVerifyCenterAdapterPosition$p(WheelView r0) {
        return r0.pendingVerifyCenterAdapterPosition;
    }

    public static final /* synthetic */ boolean access$getProgrammaticScrolling$p(WheelView r0) {
        return r0.programmaticScrolling;
    }

    public static final /* synthetic */ boolean access$getSuppressNextSnapOnce$p(WheelView r0) {
        return r0.suppressNextSnapOnce;
    }

    public static final /* synthetic */ boolean access$getUserScrolling$p(WheelView r0) {
        return r0.userScrolling;
    }

    public static final /* synthetic */ float access$getWheelTextSizePx$p(WheelView r0) {
        return r0.wheelTextSizePx;
    }

    public static final /* synthetic */ int access$halfRows(WheelView r0) {
        return r0.halfRows();
    }

    public static final /* synthetic */ boolean access$isValidDataIndex(WheelView r0, int r1) {
        return r0.isValidDataIndex(r1);
    }

    public static final /* synthetic */ void access$setHasSettledSinceDrag$p(WheelView r0, boolean r1) {
        r0.hasSettledSinceDrag = r1;
    }

    public static final /* synthetic */ void access$setLastCenterIndex$p(WheelView r0, int r1) {
        r0.lastCenterIndex = r1;
    }

    public static final /* synthetic */ void access$setLastChangedDataIndex$p(WheelView r0, int r1) {
        r0.lastChangedDataIndex = r1;
    }

    public static final /* synthetic */ void access$setLastHapticIndex$p(WheelView r0, int r1) {
        r0.lastHapticIndex = r1;
    }

    public static final /* synthetic */ void access$setPendingVerifyCenterAdapterPosition$p(WheelView r0, int r1) {
        r0.pendingVerifyCenterAdapterPosition = r1;
    }

    public static final /* synthetic */ void access$setProgrammaticScrolling$p(WheelView r0, boolean r1) {
        r0.programmaticScrolling = r1;
    }

    public static final /* synthetic */ void access$setSuppressNextSnapOnce$p(WheelView r0, boolean r1) {
        r0.suppressNextSnapOnce = r1;
    }

    public static final /* synthetic */ void access$setUserScrolling$p(WheelView r0, boolean r1) {
        r0.userScrolling = r1;
    }

    public static final /* synthetic */ boolean access$snapToNearestCenter(WheelView r0) {
        return r0.snapToNearestCenter();
    }

    public WheelView(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11, r9);
        com.obric.oui.picker.reels.views.c r12 = new com.obric.oui.picker.reels.views.c(r10);
        this.layoutManager = r12;
        b r0 = new b(this);
        this.adapter = r0;
        this.itemHeight = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 50.0f);
        this.visibleRowCount = 5;
        this.wheelTextSizePx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
        this.normalTextSizePx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
        this.selectedTextSizePx = g.b((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f);
        this.lastHapticIndex = -1;
        this.lastCenterIndex = -1;
        this.lastChangedDataIndex = -1;
        this.pendingInitialScrollPosition = -1;
        this.pendingVerifyCenterAdapterPosition = -1;
        this.highlightConorRadiusPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        this.selectedTextColor = androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_accent_6_bg, "color", "oui_accent_6_bg"));
        this.normalTextColor = androidx.core.content.a.c(r10, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_basic_text_1, "color", "oui_basic_text_1"));
        d r2 = new d(this);
        this.scrollListener = r2;
        refreshDimensionCache();
        FrameLayout.inflate(r10, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.layout.o_wheel_view, "layout", "o_wheel_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setTagGap(Integer.valueOf(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2)));
        View r13 = findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.recycler, DbHelper.COL_ID, "recycler"));
        o.c(r13, "findViewById(R.id.recycler)");
        RecyclerView r14 = (RecyclerView) ZeusTransformUtils.preCheckCast(r13, RecyclerView.class, "com.obric.aiagent.plugin");
        this.recyclerView = r14;
        View r3 = findViewById(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.id.tv_tag, DbHelper.COL_ID, "tv_tag"));
        o.c(r3, "findViewById(R.id.tv_tag)");
        this.tvTag = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
        r14.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r12, RecyclerView.h.class, "com.obric.aiagent.plugin"));
        r12.a(halfRows());
        r14.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r0, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        r14.setClipToPadding(false);
        r14.setOverScrollMode(0);
        r14.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(r2, RecyclerView.m.class, "com.obric.aiagent.plugin"));
        r14.getViewTreeObserver().addOnGlobalLayoutListener(new $$Lambda$WheelView$toCAjgMsRAXHyeV5CDigBN6ANes(this));
        initAttrs(r11);
    }

    public final boolean getShowDivider() {
        return this.showDivider;
    }

    public final void setShowDivider(boolean r1) {
        this.showDivider = r1;
    }

    public final int getHighlightConorRadiusPx() {
        return this.highlightConorRadiusPx;
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.highlightConorRadiusPx = r1;
    }

    public final boolean isCyclic() {
        return this.isCyclic;
    }

    public final void setCyclic(boolean r2) {
        this.isCyclic = r2;
        this.layoutManager.a(r2);
        com.obric.oui.picker.reels.views.c r0 = this.layoutManager;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.a(r3);
        requestLayout();
        return;
    L5:
        r3 = halfRows();
        goto L6
    }

    public final CharSequence getWheelTagText() {
        return this.wheelTagText;
    }

    public final void setWheelTagText(CharSequence r3) {
        this.wheelTagText = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final Integer getTagGap() {
        return this.tagGap;
    }

    public final void setTagGap(Integer r1) {
        this.tagGap = r1;
        requestLayout();
    }

    public final int getSelectedTextColor() {
        return this.selectedTextColor;
    }

    public final void setSelectedTextColor(int r2) {
        this.selectedTextColor = r2;
        this.layoutManager.d(r2);
        this.recyclerView.requestLayout();
    }

    public final int getNormalTextColor() {
        return this.normalTextColor;
    }

    public final void setNormalTextColor(int r2) {
        this.normalTextColor = r2;
        this.layoutManager.f(r2);
        this.recyclerView.requestLayout();
    }

    public final com.obric.oui.picker.reels.views.a getOnWheelChangedListener() {
        return this.onWheelChangedListener;
    }

    public final void setOnWheelChangedListener(com.obric.oui.picker.reels.views.a r3) {
        this.onWheelChangedListener = (com.obric.oui.picker.reels.views.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.views.a.class, "com.obric.aiagent.plugin");
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1116_init_$lambda0(WheelView r1) {
        o.e(r1, "this$0");
        r1.updateRecyclerPaddingForCenter();
        r1.applyPendingInitialSelection();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        refreshDimensionCache();
        requestLayout();
    }

    private final void refreshDimensionCache() {
        this.horizontalPaddingPx = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 28);
    }

    private final void initAttrs(AttributeSet r19) {
        TypedArray r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r19, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.OWheelView);
        o.c(r1, "context.obtainStyledAttr…, R.styleable.OWheelView)");
        boolean r3 = r1.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelCyclic, "styleable", "OWheelView_oui_wheelCyclic"), false);
        int r6 = r1.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelStartIndex, "styleable", "OWheelView_oui_wheelStartIndex"), 0);
        int r7 = r1.getInt(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelItemCount, "styleable", "OWheelView_oui_wheelItemCount"), 5);
        int r8 = r1.getDimensionPixelOffset(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelItemHeight, "styleable", "OWheelView_oui_wheelItemHeight"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 50));
        int r9 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelTextSize, "styleable", "OWheelView_oui_wheelTextSize"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f));
        int r10 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelTextSize, "styleable", "OWheelView_oui_wheelTextSize"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 14.0f));
        int r5 = r1.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelTextColor, "styleable", "OWheelView_oui_wheelTextColor"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_basic_text_1, "color", "oui_basic_text_1")));
        int r11 = r1.getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelSelectedTextColor, "styleable", "OWheelView_oui_wheelSelectedTextColor"), androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.oui_accent_6_bg, "color", "oui_accent_6_bg")));
        int r12 = r1.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelSelectedTextSize, "styleable", "OWheelView_oui_wheelSelectedTextSize"), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 22.0f));
        CharSequence[] r4 = r1.getTextArray(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.OWheelView_oui_wheelEntries, "styleable", "OWheelView_oui_wheelEntries"));
        if (r4 != null) goto L5;
        List r2 = null;
    L9:
        r1.recycle();
        setCyclic(r3);
        this.pendingInitialIndex = r6;
        this.visibleRowCount = r7;
        this.itemHeight = r8;
        float r13 = r9;
        this.normalTextSizePx = r13;
        float r14 = r12;
        this.selectedTextSizePx = r14;
        this.wheelTextSizePx = n.a(r14, r13);
        setSelectedTextColor(r11);
        this.tvTag.setTextSize(0, r10);
        this.tvTag.setTextColor(r5);
        if (r2 == null) goto L12;
        setItems$default(this, r2, null, 2, null);
        return;
    L12:
        scheduleInitialSelectionIfNeeded();
        return;
    L5:
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r4.length), Collection.class, "com.obric.aiagent.plugin");
        int r16 = r4.length;
        int r17 = 0;
    L6:
        if (r17 >= r16) goto L8;
        r15.add(r4[r17].toString());
        r17 = r17 + 1;
        r4 = r4;
        goto L6
    L8:
        r2 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin");
        goto L9
    }

    public final int getStartIndex() {
        return this.pendingInitialIndex;
    }

    public final void setStartIndex(int r3) {
        this.pendingInitialIndex = r3;
        if (this.adapter.b().size() <= 0) goto L6;
        setSelectedIndex(n.a(r3, 0, this.adapter.b().size() - 1), false);
        return;
    }

    public final int getItemCount() {
        return this.visibleRowCount;
    }

    public final void setItemCount(int r2) {
        this.visibleRowCount = r2;
        com.obric.oui.picker.reels.views.c r3 = this.layoutManager;
        if (this.isCyclic == false) goto L5;
        int r0 = 0;
    L6:
        r3.a(r0);
        requestLayout();
        return;
    L5:
        r0 = halfRows();
        goto L6
    }

    public final int getItemHeightPx() {
        return this.itemHeight;
    }

    public final void setItemHeightPx(int r1) {
        this.itemHeight = r1;
        this.adapter.g();
        requestLayout();
    }

    public final int getSelectedItemHeightPx() {
        return this.itemHeight;
    }

    public final void setSelectedItemHeightPx(int r1) {
        this.itemHeight = r1;
        this.adapter.g();
        requestLayout();
    }

    public final float getTextSizePx() {
        return this.normalTextSizePx;
    }

    public final void setTextSizePx(float r2) {
        this.normalTextSizePx = r2;
        this.wheelTextSizePx = Math.max(r2, this.selectedTextSizePx);
        this.adapter.g();
        requestLayout();
    }

    public final int getTextColor() {
        return this.normalTextColor;
    }

    public final void setTextColor(int r1) {
        setNormalTextColor(r1);
    }

    public final float getSelectedTextSizePxProp() {
        return this.selectedTextSizePx;
    }

    public final void setSelectedTextSizePxProp(float r2) {
        this.selectedTextSizePx = r2;
        this.wheelTextSizePx = Math.max(this.normalTextSizePx, r2);
        this.adapter.g();
        requestLayout();
    }

    public final int getItemSize() {
        return this.adapter.b().size();
    }

    public final CharSequence getItem(int r3) {
        return (CharSequence) ZeusTransformUtils.preCheckCast(p.d((List) ZeusTransformUtils.preCheckCast(this.adapter.b(), List.class, "com.obric.aiagent.plugin"), r3), CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final int getCurrentIndex() {
        int r0 = findNearestCenterIndex();
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = adapterToDataIndex(r0);
        if (isValidDataIndex(r1) == true) goto L8;
        return 0;
    L8:
        return r1;
    }

    public final void setCurrentIndex(int r2) {
        setCurrentIndex(r2, false);
    }

    public final CharSequence getCurrentItem() {
        return getItem(getCurrentIndex());
    }

    public static /* synthetic */ void setCurrentIndex$default(WheelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        r0.setCurrentIndex(r1, r2);
    }

    public final void setCurrentIndex(int r4, boolean r5) {
        int r0 = getCurrentIndex();
        int r6 = setSelectedIndex(r4, r5);
        int r1 = this.adapter.b().size();
        if (r1 <= 0) goto L18;
        int r7 = n.a(r4, 0, r1 - 1);
        if (r0 == r7) goto L19;
        com.obric.oui.picker.reels.views.a r2 = this.onWheelChangedListener;
        if (r2 == null) goto L10;
        r2.a(r0, r7);
    L10:
        com.obric.oui.picker.reels.views.a r3 = this.onWheelChangedListener;
        if (r3 == null) goto L14;
        r3.a(r7);
    L14:
        this.lastChangedDataIndex = r7;
        if (r6 == (-1)) goto L20;
        this.lastCenterIndex = r6;
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void setEntries(String... r3) {
        o.e(r3, "entries");
        setItems$default(this, i.g(r3), null, 2, null);
    }

    public final void setEntries(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        List r8 = null;
    L10:
        if (r8 != null) goto L12;
        r8 = p.b();
    L12:
        setItems$default(this, r8, null, 2, null);
        return;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r2.add((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        r8 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        goto L10
    }

    public final void setEntries(List<String> r5, int r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        List<? extends CharSequence> r8 = null;
    L10:
        if (r8 != null) goto L12;
        r8 = p.b();
    L12:
        setItems(r8, Integer.valueOf(r6));
        return;
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r9, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        r0.add((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    L9:
        r8 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        goto L10
    }

    public final void setTagText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "tag");
        this.wheelTagText = r4;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        this.tvTag.setVisibility(8);
        return;
    L11:
        this.tvTag.setVisibility(0);
        this.tvTag.setText(this.wheelTagText);
        return;
    L5:
        if (r4.length() == 0) goto L8;
        r5 = false;
        goto L9
    }

    private final void scheduleInitialSelectionIfNeeded() {
        int r0 = this.adapter.b().size();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = n.a(this.pendingInitialIndex, 0, r0 - 1);
        if (this.isCyclic == false) goto L8;
        int r2 = ((r0 * 1000) / 2) + r1;
    L9:
        this.pendingInitialScrollPosition = r2;
        if (this.recyclerView.getChildCount() <= 0) goto L13;
        applyPendingInitialSelection();
        return;
    L13:
        return;
    L8:
        r2 = halfRows() + r1;
        goto L9
    }

    private final void applyPendingInitialSelection() {
        int r0 = this.pendingInitialScrollPosition;
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.adapter.b().size() != 0) goto L9;
        return;
    L9:
        if (this.recyclerView.getChildCount() != 0) goto L11;
        return;
    L11:
        this.pendingInitialScrollPosition = -1;
        centerToPosition(r0, false);
    }

    static /* synthetic */ void setItems$default(WheelView r1, List r2, Integer r3, int r4, Object r5) {
        List<? extends CharSequence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.setItems(r6, r3);
    }

    private final void setItems(List<? extends CharSequence> r8, Integer r9) {
        List<? extends CharSequence> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        this.pendingVerifyCenterAdapterPosition = -1;
        if (r9 != null) goto L5;
        Integer r11 = null;
    L10:
        if (r11 == null) goto L13;
        this.pendingInitialIndex = ((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue();
    L13:
        boolean r2 = !o.a(this.adapter.b(), r10);
        if (r2 == false) goto L16;
        this.recyclerView.stopScroll();
        this.adapter.a(r10);
    L16:
        TextView r3 = new TextView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r3.setTextSize(22.0f);
        TextPaint r4 = r3.getPaint();
        this.maxTextWidth = 0.0f;
        Iterator<? extends CharSequence> r5 = r10.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        float r6 = r4.measureText(((CharSequence) ZeusTransformUtils.preCheckCast(r5.next(), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        if (r6 <= this.maxTextWidth) goto L18;
        this.maxTextWidth = r6;
        goto L18
    L22:
        ViewGroup.LayoutParams r7 = this.tvTag.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L29;
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r13 = (int) (this.maxTextWidth / 2.0f);
        Integer r14 = this.tagGap;
        if (r14 != null) goto L27;
        int r15 = 0;
    L28:
        r12.setMarginStart(r13 + (r15 * 2));
        this.tvTag.setLayoutParams(r7);
        goto L29
    L27:
        r15 = r14.intValue();
    L29:
        if (r11 != null) goto L31;
    L37:
        post(new $$Lambda$WheelView$VS3Xi1CyPKGWLO94txn69VTpgHo(this));
        return;
    L31:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L37;
        if (r2 == false) goto L36;
        this.pendingInitialScrollPosition = dataToAdapterPosition(r11.intValue(), r10.size());
        if (this.recyclerView.getChildCount() <= 0) goto L37;
        applyPendingInitialSelection();
        goto L37
    L36:
        setSelectedIndex(r11.intValue(), false);
        goto L37
    L5:
        int r16 = ((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r10.isEmpty() == true) goto L9;
        r16 = n.a(r16, 0, r10.size() - 1);
    L9:
        r11 = Integer.valueOf(r16);
        goto L10
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m1118setItems$lambda6(WheelView r2) {
        o.e(r2, "this$0");
        r2.requestLayout();
        r2.updateRecyclerPaddingForCenter();
        if (r2.pendingInitialScrollPosition == (-1)) goto L5;
        r2.applyPendingInitialSelection();
        return;
    L5:
        r2.scheduleInitialSelectionIfNeeded();
    }

    public final int setSelectedIndex(int r7, boolean r8) {
        this.pendingInitialScrollPosition = -1;
        this.pendingVerifyCenterAdapterPosition = -1;
        int r1 = this.adapter.b().size();
        if (r1 != 0) goto L6;
        this.pendingInitialIndex = r7;
        return -1;
    L6:
        int r9 = n.a(r7, 0, r1 - 1);
        this.pendingInitialIndex = r9;
        if (this.isCyclic == false) goto L13;
        int r2 = findNearestCenterIndex();
        if (this.recyclerView.getChildCount() <= 0) goto L12;
        if (r2 == (-1)) goto L12;
        int r0 = this.adapter.a();
        int r3 = (r2 - (r2 % r1)) + r9;
        z.d r10 = new z.d();
        r10.f38502a = r3;
        z.d r4 = new z.d();
        r4.f38502a = Math.abs(r3 - r2);
        setSelectedIndex$tryPos(r0, r2, r4, r10, r3 - r1);
        setSelectedIndex$tryPos(r0, r2, r4, r10, r3 + r1);
        int r11 = r10.f38502a;
    L14:
        centerToPosition(r11, r8);
        return r11;
    L12:
        r11 = r9 + ((r1 * 1000) / 2);
        goto L14
    L13:
        r11 = r9 + halfRows();
        goto L14
    }

    private static final void setSelectedIndex$tryPos(int r1, int r2, z.d r3, z.d r4, int r5) {
        boolean r0 = false;
        if (r5 < 0) goto L6;
        if (r5 >= r1) goto L6;
        r0 = true;
    L6:
        if (r0 == false) goto L11;
        int r6 = Math.abs(r5 - r2);
        if (r6 >= r3.f38502a) goto L12;
        r4.f38502a = r5;
        r3.f38502a = r6;
        return;
    L12:
        return;
    }

    private final int dataToAdapterPosition(int r3, int r4) {
        int r5 = n.a(r3, 0, r4 - 1);
        if (this.isCyclic == false) goto L6;
        return ((r4 * 1000) / 2) + r5;
    L6:
        return r5 + halfRows();
    }

    private final void centerToPosition(final int r2, boolean r3) {
        this.recyclerView.stopScroll();
        if (r3 == false) goto L7;
        this.programmaticScrolling = true;
        this.pendingVerifyCenterAdapterPosition = r2;
        int r4 = this.layoutManager.b(r2);
        if (r4 == 0) goto L9;
        animateMove(r4);
        return;
    L9:
        return;
    L7:
        this.programmaticScrolling = true;
        this.recyclerView.scrollToPosition(r2);
        post(new $$Lambda$WheelView$y6wEQn5FkPvsTz7M1m__J20kjNE(this, r2));
    }

    /* JADX INFO: renamed from: centerToPosition$lambda-7, reason: not valid java name */
    private static final void m1117centerToPosition$lambda7(WheelView r2, int r3) {
        o.e(r2, "this$0");
        View r0 = r2.layoutManager.c(r3);
        if (r0 == null) goto L7;
        int r4 = ((r0.getTop() + r0.getBottom()) / 2) - r2.recyclerCenterY();
        if (r4 == 0) goto L9;
        r2.recyclerView.scrollBy(0, r4);
        r2.suppressNextSnapOnce = true;
        return;
    L9:
        return;
    L7:
        r2.pendingInitialScrollPosition = r3;
    }

    private final int halfRows() {
        return n.c((this.visibleRowCount + 2) / 2, 1);
    }

    private final int adapterToDataIndex(int r3) {
        int r0 = this.adapter.b().size();
        if (r0 != 0) goto L7;
        return -1;
    L7:
        if (this.isCyclic == false) goto L12;
        int r4 = r3 % r0;
        if (r4 < 0) goto L14;
        return r4;
    L14:
        return r4 + r0;
    L12:
        return r3 - halfRows();
    }

    private final boolean isValidDataIndex(int r2) {
        if (r2 >= 0) goto L5;
        return false;
    L5:
        if (r2 >= this.adapter.b().size()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r6) {
        View.MeasureSpec.makeMeasureSpec((((int) (((this.itemHeight / ((float) Math.tan(0.5235988f))) * 2.0f) + this.itemHeight)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r0 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        int r2 = Math.max((int) (this.maxTextWidth + this.horizontalPaddingPx), getMinimumWidth());
        if (r0 == Integer.MIN_VALUE) goto L6;
        if (r0 == 1073741824) goto L7;
        r7 = r2;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), r6);
        return;
    L6:
        r7 = Math.min(r2, r7);
        goto L7
    }

    private final boolean snapToNearestCenter() {
        this.recyclerView.stopScroll();
        int r0 = this.layoutManager.b();
        if (r0 == 0) goto L6;
        this.suppressNextSnapOnce = true;
        animateMove(r0);
        return true;
    L6:
        return false;
    }

    private final void animateMove(int r5) {
        if (r5 == 0) goto L5;
        this.programmaticScrolling = true;
        SpringInterpolator r0 = new SpringInterpolator(0.61f);
        this.recyclerView.smoothScrollBy(0, r5, (Interpolator) ZeusTransformUtils.preCheckCast(r0, Interpolator.class, "com.obric.aiagent.plugin"), 400);
        return;
    }

    private final void updateRecyclerPaddingForCenter() {
        if (this.recyclerView.getHeight() > 0) goto L5;
        return;
    L5:
        RecyclerView r0 = this.recyclerView;
        r0.setPadding(r0.getPaddingLeft(), 0, this.recyclerView.getPaddingRight(), 0);
    }

    private final View findCenterChild() {
        int r0 = recyclerCenterY();
        int r1 = this.recyclerView.getChildCount();
        View r2 = null;
        float r3 = Float.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L11;
        r4 = r4 + 1;
        View r5 = this.recyclerView.getChildAt(r4);
        if (r5 == null) goto L3;
        float r6 = Math.abs(((r5.getTop() + r5.getBottom()) / 2.0f) - r0);
        if (r6 >= r3) goto L3;
        r2 = r5;
        r3 = r6;
        goto L3
    L11:
        return r2;
    }

    private final int findNearestCenterIndex() {
        int r0 = this.layoutManager.h();
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        View r1 = findCenterChild();
        if (r1 != null) goto L9;
        return -1;
    L9:
        return this.recyclerView.getChildAdapterPosition(r1);
    }

    private final int recyclerCenterY() {
        return ((this.recyclerView.getPaddingTop() + this.recyclerView.getHeight()) - this.recyclerView.getPaddingBottom()) / 2;
    }
}
