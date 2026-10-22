package com.obric.oui.filterpanel;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.filter.OFilter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OFilterPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OFilterGroupView extends ConstraintLayout {
    private final String TAG;
    private int columnCount;
    private List<? extends CharSequence> curFiltersList;
    private boolean enableClickWhenSelected;
    private int filterStyle;
    private final List<OFilter> filtersList;
    private final GridLayout gridLayout;
    private final List<CharSequence> lessFiltersList;
    private int maxSelectCount;
    private final List<CharSequence> moreFiltersList;
    private b onFilterClickedListener;
    private c onFilterDataChangeListener;
    private d onFilterSelectedListener;
    private boolean showingMore;
    private final TextView tvShowMore;
    private final TextView tvTitle;

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f35246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f35247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f35248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f35250e;
        private List<String> f;
        private d g;
        private int h;
        private boolean i;

        public a() {
            this(null, null, null, 0, null, null, null, 0, false, 511, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f35246a, r6.f35246a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f35247b, r6.f35247b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f35248c, r6.f35248c) == true) goto L18;
            return false;
        L18:
            if (this.f35249d == r6.f35249d) goto L21;
            return false;
        L21:
            if (o.a(this.f35250e, r6.f35250e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (o.a(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L35;
            return false;
        L35:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        public int hashCode() {
            String r0 = this.f35246a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.f35247b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Integer r7 = this.f35248c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + Integer.hashCode(this.f35249d)) * 31;
            Integer r10 = this.f35250e;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            List<String> r13 = this.f;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            d r16 = this.g;
            if (r16 == null) goto L26;
            r1 = r16.hashCode();
        L26:
            int r17 = (((r15 + r1) * 31) + Integer.hashCode(this.h)) * 31;
            boolean r18 = this.i;
            ?? r19 = r18;
            if (r18 == false) goto L30;
            r19 = 1;
        L30:
            return r17 + r19;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Config(title=" + this.f35246a + ", filterStyle=" + this.f35247b + ", maxSelectCount=" + this.f35248c + ", columnCount=" + this.f35249d + ", defaultSelectIndex=" + this.f35250e + ", filterItems=" + this.f + ", onFilterSelectListener=" + this.g + ", initRowCount=" + this.h + ", enableClickWhenSelected=" + this.i + ')';
        }

        public a(String r3, Integer r4, Integer r5, int r6, Integer r7, List<String> r8, d r9, int r10, boolean r11) {
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            this.f35246a = r3;
            this.f35247b = r4;
            this.f35248c = r5;
            this.f35249d = r6;
            this.f35250e = r7;
            this.f = r12;
            this.g = r13;
            this.h = r10;
            this.i = r11;
        }

        public /* synthetic */ a(String r11, Integer r12, Integer r13, int r14, Integer r15, List r16, d r17, int r18, boolean r19, int r20, h r21) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            d r2 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
            d r4 = null;
            if ((r20 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r20 & 2) == 0) goto L9;
            Integer r5 = null;
        L11:
            if ((r20 & 4) == 0) goto L13;
            Integer r6 = null;
        L15:
            if ((r20 & 8) == 0) goto L17;
            int r7 = 3;
        L19:
            if ((r20 & 16) == 0) goto L21;
            Integer r8 = null;
        L23:
            if ((r20 & 32) == 0) goto L26;
            r1 = null;
        L26:
            if ((r20 & 64) != 0) goto L30;
            r4 = r2;
        L30:
            if ((r20 & 128) == 0) goto L32;
            int r9 = Integer.MAX_VALUE;
        L34:
            if ((r20 & 256) == 0) goto L36;
            boolean r0 = true;
        L37:
            this(r3, r5, r6, r7, r8, r1, r4, r9, r0);
            return;
        L36:
            r0 = r19;
            goto L37
        L32:
            r9 = r18;
            goto L34
        L21:
            r8 = r15;
            goto L23
        L17:
            r7 = r14;
            goto L19
        L13:
            r6 = r13;
            goto L15
        L9:
            r5 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }

        public final String a() {
            return this.f35246a;
        }

        public final Integer b() {
            return this.f35247b;
        }

        public final Integer c() {
            return this.f35248c;
        }

        public final int d() {
            return this.f35249d;
        }

        public final Integer e() {
            return this.f35250e;
        }

        public final List<String> f() {
            return this.f;
        }

        public final int g() {
            return this.h;
        }

        public final boolean h() {
            return this.i;
        }
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    public interface b {
        void a(OFilter r1);
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    public interface c {
        void a(List<? extends CharSequence> r1);
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    public interface d {
        void a(OFilter r1);

        void b(OFilter r1);
    }

    /* JADX INFO: compiled from: OFilterPanelView.kt */
    public static final class e implements OFilter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFilterGroupView f35251a;

        e(OFilterGroupView r1) {
            this.f35251a = r1;
        }

        @Override // com.obric.oui.filter.OFilter.b
        public void a(OFilter r2, boolean r3) {
            o.e(r2, "filter");
            if (r3 == false) goto L8;
            d r1 = OFilterGroupView.access$getOnFilterSelectedListener$p(this.f35251a);
            if (r1 == null) goto L14;
            r1.a(r2);
            return;
        L14:
            return;
        L8:
            d r4 = OFilterGroupView.access$getOnFilterSelectedListener$p(this.f35251a);
            if (r4 == null) goto L15;
            r4.b(r2);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterGroupView(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        this(r4, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ void lambda$Pk_iy4cmMZ89IHEc2Ov4kEgWjq0(OFilterGroupView r0, OFilter r1, View r2) {
        m1061addFilterItems$lambda2$lambda1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$aeWq4a7NdxVN2l4VD0d-DHvTeFo, reason: not valid java name */
    public static /* synthetic */ void m1062lambda$aeWq4a7NdxVN2l4VD0dDHvTeFo(OFilterGroupView r0, Context r1, View r2) {
        m1060_init_$lambda0(r0, r1, r2);
    }

    public /* synthetic */ OFilterGroupView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = null;
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ d access$getOnFilterSelectedListener$p(OFilterGroupView r0) {
        return r0.onFilterSelectedListener;
    }

    public OFilterGroupView(Context r5, AttributeSet r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8);
        this.TAG = "OFilterPanelView";
        this.maxSelectCount = 1;
        this.columnCount = 3;
        this.lessFiltersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.moreFiltersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.filtersList = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.enableClickWhenSelected = true;
        ConstraintLayout.inflate(r7, ZeusTransformUtils.mapRes(R.layout.o_layout_filter_group_view, "layout", "o_layout_filter_group_view"), (ViewGroup) ZeusTransformUtils.preCheckCast(this, ViewGroup.class, "com.obric.aiagent.plugin"));
        setPadding(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), 0, g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16), g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 16));
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, DbHelper.COL_ID, "tv_title"));
        o.c(r9, "findViewById(R.id.tv_title)");
        this.tvTitle = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.aiagent.plugin");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_show_more, DbHelper.COL_ID, "tv_show_more")), TextView.class, "com.obric.aiagent.plugin");
        this.tvShowMore = r10;
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.grid_layout, DbHelper.COL_ID, "grid_layout"));
        o.c(r0, "findViewById(R.id.grid_layout)");
        this.gridLayout = (GridLayout) ZeusTransformUtils.preCheckCast(r0, GridLayout.class, "com.obric.aiagent.plugin");
        r10.setOnClickListener(new $$Lambda$OFilterGroupView$aeWq4a7NdxVN2l4VD0dDHvTeFo(this, r7));
    }

    public final GridLayout getGridLayout() {
        return this.gridLayout;
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final void m1060_init_$lambda0(OFilterGroupView r4, Context r5, View r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "this$0");
        o.e(r7, "$context");
        r4.gridLayout.removeAllViews();
        if (r4.showingMore == false) goto L9;
        TextView r8 = r4.tvShowMore;
        if (r8 == null) goto L8;
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_show_more, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_show_more")), CharSequence.class, "com.obric.aiagent.plugin"));
    L8:
        r4.addFilterItems(r4.lessFiltersList, r4.columnCount);
        r4.showingMore = false;
        return;
    L9:
        TextView r9 = r4.tvShowMore;
        if (r9 == null) goto L13;
        r9.setText((CharSequence) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.getResources(r7, "com.obric.aiagent.plugin").getString(ZeusTransformUtils.mapRes(R.string.oui_show_less, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_show_less")), CharSequence.class, "com.obric.aiagent.plugin"));
    L13:
        r4.addFilterItems(r4.moreFiltersList, r4.columnCount);
        r4.showingMore = true;
    }

    public final void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        this.tvTitle.setText(r4);
    }

    public final TextView getTitle() {
        return this.tvTitle;
    }

    public static /* synthetic */ void setFilterItems$default(OFilterGroupView r1, List r2, int r3, int r4, int r5, Object r6) {
        List<? extends CharSequence> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = 3;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = Integer.MAX_VALUE;
    L8:
        r1.setFilterItems(r7, r3, r4);
    }

    public final void setFilterItems(List<? extends CharSequence> r5, int r6, int r7) {
        List<? extends CharSequence> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "items");
        this.columnCount = r6;
        this.gridLayout.setAlignmentMode(0);
        this.gridLayout.setColumnCount(r6);
        this.gridLayout.setRowCount(((r8.size() + r6) - 1) / r6);
        if ((((r8.size() - 1) / r6) + 1) <= r7) goto L8;
        this.moreFiltersList.addAll((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin"));
        List<? extends CharSequence> r9 = r8.subList(0, r7 * r6);
        this.lessFiltersList.addAll((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin"));
        addFilterItems(r9, r6);
        TextView r4 = this.tvShowMore;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        return;
    L11:
        return;
    L8:
        addFilterItems(r8, r6);
    }

    static /* synthetic */ void addFilterItems$default(OFilterGroupView r1, List r2, int r3, int r4, Object r5) {
        List<? extends CharSequence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = 3;
    L5:
        r1.addFilterItems(r6, r3);
    }

    private final void addFilterItems(List<? extends CharSequence> r22, int r23) {
        List<? extends CharSequence> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        this.filtersList.clear();
        this.curFiltersList = r1;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r5 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r6 = r3.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L8;
        p.c();
    L8:
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        GridLayout.LayoutParams r9 = new GridLayout.LayoutParams();
        r9.height = -2;
        r9.width = 0;
        r9.rightMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 8);
        r9.topMargin = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 5);
        r9.setGravity(17);
        int r10 = r5 % r23;
        int r11 = r5 / r23;
        if (Build.VERSION.SDK_INT < 21) goto L11;
        r9.columnSpec = GridLayout.spec(r10, 1.0f);
        r9.rowSpec = GridLayout.spec(r11, 1.0f);
    L12:
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r15, "context");
        final OFilter r12 = new OFilter(r15, null, 0, true, 6, null);
        r12.setText(r8);
        r12.setStyle(this.filterStyle, true);
        r12.setSelectChangeListener((OFilter.b) ZeusTransformUtils.preCheckCast(new e(this), OFilter.b.class, "com.obric.aiagent.plugin"));
        r12.setOnClickListener(new $$Lambda$OFilterGroupView$Pk_iy4cmMZ89IHEc2Ov4kEgWjq0(this, r12));
        this.filtersList.add(r12);
        getGridLayout().addView((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r5 = r7;
        goto L4
    L11:
        r9.columnSpec = GridLayout.spec(r10);
        r9.rowSpec = GridLayout.spec(r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r13, "context");
        r9.width = (g.a(r13) - (g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 5) * 2)) / 3;
        goto L12
    L13:
        c r0 = this.onFilterDataChangeListener;
        if (r0 == null) goto L21;
        r0.a(r1);
        return;
    }

    /* JADX INFO: renamed from: addFilterItems$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1061addFilterItems$lambda2$lambda1(OFilterGroupView r2, OFilter r3, View r4) {
        o.e(r2, "this$0");
        o.e(r3, "$oFilter");
        if (r4.isSelected() == true) goto L5;
    L9:
        Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.filter.OFilter");
        r2.select((OFilter) ZeusTransformUtils.preCheckCast(r4, OFilter.class, "com.obric.aiagent.plugin"));
    L10:
        b r5 = r2.onFilterClickedListener;
        if (r5 == null) goto L15;
        r5.a(r3);
        return;
    L15:
        return;
    L5:
        if (r2.maxSelectCount == 1) goto L7;
    L8:
        r3.setSelected(false);
        goto L10
    L7:
        if (r2.enableClickWhenSelected == false) goto L9;
        goto L8
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final List<Integer> getSelectedIndexes() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r3 = r6.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L9;
        p.c();
    L9:
        if (((OFilter) ZeusTransformUtils.preCheckCast(r3, OFilter.class, "com.obric.aiagent.plugin")).isSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r4;
        goto L4
    L12:
        return r0;
    }

    public final List<OFilter> getSelectedFilters() {
        List<OFilter> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        OFilter r1 = (OFilter) ZeusTransformUtils.preCheckCast(r4.next(), OFilter.class, "com.obric.aiagent.plugin");
        if (r1.isSelected() == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        return r0;
    }

    public final void registerFilterSelectedListener(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.onFilterSelectedListener = r4;
    }

    public final void registerFilterDataChangeListener(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.onFilterDataChangeListener = r4;
        List<? extends CharSequence> r2 = this.curFiltersList;
        if (r2 == null) goto L7;
        r4.a(r2);
        return;
    }

    public final void registerFilterClickedListener(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.onFilterClickedListener = r4;
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterGroupView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final void setFilterStyle(int r4, boolean r5) {
        this.filterStyle = r4;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((OFilter) ZeusTransformUtils.preCheckCast(r3.next(), OFilter.class, "com.obric.aiagent.plugin")).setStyle(r4, r5);
        goto L4
    }

    public final void setEnableClickWhenSelected(boolean r1) {
        this.enableClickWhenSelected = r1;
    }

    public final boolean select(int r4) {
        if (r4 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L12;
    L10:
        return false;
    L12:
        ((OFilter) ZeusTransformUtils.preCheckCast(this.filtersList.get(r4), OFilter.class, "com.obric.aiagent.plugin")).setSelected(true);     // Catch: IndexOutOfBoundsException -> L11
        goto L10
    L5:
        if (r4 >= this.filtersList.size()) goto L7;
        r2 = true;
        goto L8
    }

    public final void unSelectAll() {
        INVOKESTATIC_com_obric_oui_filterpanel_OFilterGroupView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(this.TAG, "unSelectAll() called");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        OFilter r0 = (OFilter) ZeusTransformUtils.preCheckCast(r3.next(), OFilter.class, "com.obric.aiagent.plugin");
        if (r0.isSelected() == false) goto L4;
        r0.setSelected(false);
        goto L4
    }

    public final void select(OFilter r6) {
        o.e(r6, "filter");
        if (r6.isSelected() == false) goto L5;
        return;
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.filtersList, Iterable.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L8;
    L10:
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        if (((OFilter) ZeusTransformUtils.preCheckCast(r1.next(), OFilter.class, "com.obric.aiagent.plugin")).isSelected() == false) goto L12;
        r3 = r3 + 1;
        if (r3 >= 0) goto L12;
        p.d();
    L19:
        if (r3 < this.maxSelectCount) goto L21;
        unSelectAll();
    L21:
        r6.setSelected(true);
        return;
    L8:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
        goto L10
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_filterpanel_OFilterGroupView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
