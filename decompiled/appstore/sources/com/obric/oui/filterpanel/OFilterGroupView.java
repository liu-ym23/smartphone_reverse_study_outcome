package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import cd.b;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.filter.OFilter;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0003[\\]B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\n¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0019¢\u0006\u0004\b,\u0010-J'\u00100\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\b\b\u0002\u0010/\u001a\u00020\u0010H\u0002¢\u0006\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00108\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0017\u0010@\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010G\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\b0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\b0H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010JR\u001e\u0010O\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010JR\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010JR\u0018\u0010S\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010U\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010VR\u0016\u0010Y\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010BR\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010F¨\u0006^"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "", "count", "setMaxSelectCount", "(I)V", "getMaxSelectCount", "()I", "", "getSelectedIndexes", "()Ljava/util/List;", "Lcom/obric/oui/filter/OFilter;", "getSelectedFilters", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "listener", "registerFilterSelectedListener", "(Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;)V", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "registerFilterDataChangeListener", "(Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;)V", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "registerFilterClickedListener", "(Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;)V", "", "enableClickWhenSelected", "setEnableClickWhenSelected", "(Z)V", "n", "()V", "filter", "m", "(Lcom/obric/oui/filter/OFilter;)V", Card.KEY_ITEMS, "columnCount", "k", "(Ljava/util/List;I)V", "", "a", "Ljava/lang/String;", "TAG", "b", "Landroid/widget/TextView;", "tvTitle", "c", "tvShowMore", "Landroid/widget/GridLayout;", "d", "Landroid/widget/GridLayout;", "getGridLayout", "()Landroid/widget/GridLayout;", "gridLayout", "e", "I", "maxSelectCount", "f", "g", "Z", "showingMore", "", "h", "Ljava/util/List;", "lessFiltersList", "i", "moreFiltersList", "j", "curFiltersList", "filtersList", "l", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "onFilterDataChangeListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "onFilterSelectedListener", "Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "onFilterClickedListener", "o", "filterStyle", "p", "OnFilterClickedListener", "OnFilterDataChangeListener", "OnFilterSelectedListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterGroupView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f14545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GridLayout f14546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f14550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f14551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f14552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List f14553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public OnFilterDataChangeListener f14554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OnFilterSelectedListener f14555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OnFilterClickedListener f14556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f14558p;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterClickedListener;", "", "onFilterClicked", "", "filter", "Lcom/obric/oui/filter/OFilter;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterClickedListener {
        void onFilterClicked(@NotNull OFilter r10);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterDataChangeListener;", "", "onDataChange", "", Card.KEY_ITEMS, "", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterDataChangeListener {
        void onDataChange(@NotNull List<? extends CharSequence> r10);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterGroupView$OnFilterSelectedListener;", "", "onFilterSelected", "", "filter", "Lcom/obric/oui/filter/OFilter;", "onFilterUnselected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFilterSelectedListener {
        void onFilterSelected(@NotNull OFilter r10);

        void onFilterUnselected(@NotNull OFilter r10);
    }

    public static final class a implements OFilter.OnFilterSelectChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OFilterGroupView f14559a;

        public a(OFilterGroupView r10) {
            this.f14559a = r10;
        }

        @Override // com.obric.oui.filter.OFilter.OnFilterSelectChangeListener
        public void onFilterSelectedChange(OFilter r10, boolean r11) {
            q.g(r10, "filter");
            if (r11 == false) goto L8;
            OnFilterSelectedListener r12 = OFilterGroupView.j(this.f14559a);
            if (r12 == null) goto L14;
            r12.onFilterSelected(r10);
            return;
        L14:
            return;
        L8:
            OnFilterSelectedListener r13 = OFilterGroupView.j(this.f14559a);
            if (r13 == null) goto L15;
            r13.onFilterUnselected(r10);
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OFilterGroupView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void g(OFilterGroupView r10, Context r11, View r12) {
        i(r10, r11, r12);
    }

    public static /* synthetic */ void h(OFilterGroupView r10, OFilter r11, View r12) {
        l(r10, r11, r12);
    }

    public static final void i(OFilterGroupView r10, Context r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$context");
        r10.f14546d.removeAllViews();
        if (r10.f14549g == false) goto L9;
        TextView r13 = r10.f14545c;
        if (r13 == null) goto L8;
        r13.setText(r11.getResources().getString(R$string.oui_show_more));
    L8:
        r10.k(r10.f14550h, r10.f14548f);
        r10.f14549g = false;
        return;
    L9:
        TextView r14 = r10.f14545c;
        if (r14 == null) goto L13;
        r14.setText(r11.getResources().getString(R$string.oui_show_less));
    L13:
        r10.k(r10.f14551i, r10.f14548f);
        r10.f14549g = true;
    }

    public static final /* synthetic */ OnFilterSelectedListener j(OFilterGroupView r10) {
        return r10.f14555m;
    }

    public static final void l(OFilterGroupView r10, OFilter r11, View r12) {
        q.g(r10, "this$0");
        q.g(r11, "$oFilter");
        if (r12.isSelected() == true) goto L5;
    L9:
        r10.m((OFilter) r12);
    L10:
        OnFilterClickedListener r13 = r10.f14556n;
        if (r13 == null) goto L15;
        r13.onFilterClicked(r11);
        return;
    L15:
        return;
    L5:
        if (r10.f14547e == 1) goto L7;
    L8:
        r11.setSelected(false);
        goto L10
    L7:
        if (r10.f14558p == false) goto L9;
        goto L8
    }

    @NotNull
    public final GridLayout getGridLayout() {
        return this.f14546d;
    }

    public final int getMaxSelectCount() {
        return this.f14547e;
    }

    @NotNull
    public final List<OFilter> getSelectedFilters() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f14553k.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        OFilter r12 = (OFilter) r11.next();
        if (r12.isSelected() == false) goto L4;
        r10.add(r12);
        goto L4
    L8:
        return r10;
    }

    @NotNull
    public final List<Integer> getSelectedIndexes() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f14553k.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L12;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L9;
        t.q();
    L9:
        if (((OFilter) r13).isSelected() == false) goto L11;
        r10.add(Integer.valueOf(r12));
    L11:
        r12 = r14;
        goto L4
    L12:
        return r10;
    }

    @NotNull
    public final TextView getTitle() {
        return this.f14544b;
    }

    public final void k(List r14, int r15) {
        this.f14553k.clear();
        this.f14552j = r14;
        Iterator r10 = r14.iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L9;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L8;
        t.q();
    L8:
        GridLayout.LayoutParams r16 = new GridLayout.LayoutParams();
        r16.height = -2;
        r16.width = 0;
        r16.rightMargin = f.r(this, 8);
        r16.topMargin = f.r(this, 5);
        r16.setGravity(17);
        r16.columnSpec = GridLayout.spec(r11 % r15, 1.0f);
        r16.rowSpec = GridLayout.spec(r11 / r15, 1.0f);
        Context r17 = getContext();
        q.f(r17, "context");
        final OFilter r18 = new OFilter(r17, null, 0, true, 6, null);
        r18.setText((CharSequence) r12);
        r18.e(this.f14557o, true);
        r18.setSelectChangeListener(new a(this));
        r18.setOnClickListener(new b(this, r18));
        this.f14553k.add(r18);
        getGridLayout().addView(r18, r16);
        r11 = r13;
        goto L4
    L9:
        OnFilterDataChangeListener r19 = this.f14554l;
        if (r19 == null) goto L17;
        r19.onDataChange(r14);
        return;
    }

    public final void m(OFilter r10) {
        q.g(r10, "filter");
        if (r10.isSelected() == false) goto L5;
        return;
    L5:
        List r11 = this.f14553k;
        int r12 = 0;
        if (r11 != null) goto L8;
    L10:
        Iterator r13 = r11.iterator();
    L12:
        if (r13.hasNext() == false) goto L19;
        if (((OFilter) r13.next()).isSelected() == false) goto L12;
        r12 = r12 + 1;
        if (r12 >= 0) goto L12;
        t.p();
    L19:
        if (r12 < this.f14547e) goto L21;
        n();
    L21:
        r10.setSelected(true);
        return;
    L8:
        if (r11.isEmpty() == false) goto L10;
        goto L10
    }

    public final void n() {
        Log.d(this.f14543a, "unSelectAll() called");
        Iterator r10 = this.f14553k.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        OFilter r11 = (OFilter) r10.next();
        if (r11.isSelected() == false) goto L4;
        r11.setSelected(false);
        goto L4
    }

    public final void registerFilterClickedListener(@NotNull OnFilterClickedListener r10) {
        q.g(r10, "listener");
        this.f14556n = r10;
    }

    public final void registerFilterDataChangeListener(@NotNull OnFilterDataChangeListener r10) {
        q.g(r10, "listener");
        this.f14554l = r10;
        List<? extends CharSequence> r11 = this.f14552j;
        if (r11 == null) goto L7;
        r10.onDataChange(r11);
        return;
    }

    public final void registerFilterSelectedListener(@NotNull OnFilterSelectedListener r10) {
        q.g(r10, "listener");
        this.f14555m = r10;
    }

    public final void setEnableClickWhenSelected(boolean r10) {
        this.f14558p = r10;
    }

    public final void setMaxSelectCount(int r10) {
        this.f14547e = r10;
    }

    public final void setTitle(@Nullable CharSequence r10) {
        this.f14544b.setText(r10);
    }

    public /* synthetic */ OFilterGroupView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OFilterGroupView(@NotNull final Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f14543a = "OFilterPanelView";
        this.f14547e = 1;
        this.f14548f = 3;
        this.f14550h = new ArrayList();
        this.f14551i = new ArrayList();
        this.f14553k = new ArrayList();
        this.f14558p = true;
        ViewGroup.inflate(r10, R$layout.o_layout_filter_group_view, this);
        setPadding(f.r(this, 16), 0, f.r(this, 16), f.r(this, 16));
        View r12 = findViewById(R$id.tv_title);
        q.f(r12, "findViewById(R.id.tv_title)");
        this.f14544b = (TextView) r12;
        TextView r13 = (TextView) findViewById(R$id.tv_show_more);
        this.f14545c = r13;
        View r14 = findViewById(R$id.grid_layout);
        q.f(r14, "findViewById(R.id.grid_layout)");
        this.f14546d = (GridLayout) r14;
        r13.setOnClickListener(new cd.a(this, r10));
    }
}
