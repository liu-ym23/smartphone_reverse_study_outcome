package com.bytedance.android.ec.store.search.history;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.internal.FlowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sj3.h;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0003\u000e#$B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/bytedance/android/ec/store/search/history/HistoryView;", "Lcom/google/android/material/internal/FlowLayout;", "", "getHistoryChipCount", "Lcom/bytedance/android/ec/store/search/history/HistoryChip;", "chip", "", "setupChip", "", "closeable", "setChipsAllClosable", "Landroid/view/View;", "getLastVisibleChild", "Lcom/bytedance/android/ec/store/search/history/HistoryView$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/store/search/history/HistoryView$a;", "getActionListener", "()Lcom/bytedance/android/ec/store/search/history/HistoryView$a;", "setActionListener", "(Lcom/bytedance/android/ec/store/search/history/HistoryView$a;)V", "actionListener", "Lcom/bytedance/android/ec/store/search/history/HistoryView$c;", "e", "Lcom/bytedance/android/ec/store/search/history/HistoryView$c;", "getHistoryChipInitializer", "()Lcom/bytedance/android/ec/store/search/history/HistoryView$c;", "setHistoryChipInitializer", "(Lcom/bytedance/android/ec/store/search/history/HistoryView$c;)V", "historyChipInitializer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistoryView extends FlowLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f48543f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f48544g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48545h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f48546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HistoryChip.WrapCard f48547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f48550e;

    public interface a {
        void a();

        void b();

        void c();

        void d(HistoryChip r100, int r101, boolean r102, String r103);

        void e(HistoryChip r100, String r101);
    }

    public static final class b {
    }

    public interface c {
        HistoryChip.WrapCard a(HistoryChip r100);
    }

    public static final class d implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryView f48551a;

        public d(HistoryView r100) {
            this.f48551a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            this.f48551a.h();
            return true;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryView f48552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HistoryChip f48553b;

        public e(HistoryView r100, HistoryChip r101) {
            this.f48552a = r100;
            this.f48553b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HistoryView r101 = this.f48552a;
            if (r101.f48548c == false) goto L19;
            String r102 = String.valueOf(r101.e(this.f48553b));
            HistoryView r103 = this.f48552a;
            Object r104 = this.f48553b.getParent();
            if (r104 == null) goto L18;
            r103.removeView((View) r104);
            HistoryView r105 = this.f48552a;
            boolean r106 = true;
            if (r105.f48547b != null) goto L9;
            int r107 = 0;
        L11:
            if (r105.getChildCount() > r107) goto L14;
            r106 = false;
        L14:
            r105.i(r106);
            a r108 = this.f48552a.getActionListener();
            if (r108 == null) goto L23;
            r108.d(this.f48553b, HistoryView.a(this.f48552a), false, r102);
            return;
        L23:
            return;
        L9:
            r107 = 1;
            goto L11
        L18:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L19:
            a r109 = r101.getActionListener();
            if (r109 == null) goto L25;
            HistoryChip r110 = this.f48553b;
            r109.e(r110, String.valueOf(this.f48552a.e(r110)));
            return;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryView f48554a;

        public f(HistoryView r100) {
            this.f48554a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HistoryView r100 = this.f48554a;     // Catch: Throwable -> L4
            HistoryChip.WrapCard r101 = r100.f48547b;     // Catch: Throwable -> L4
            LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L4
            int r103 = HistoryView.f48543f;     // Catch: Throwable -> L4
            r102.setMargins(0, 0, r103, r103);     // Catch: Throwable -> L4
            r100.addView(r101, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HistoryView f48555a;

        public g(HistoryView r100) {
            this.f48555a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            HistoryView r101 = this.f48555a;
            int r102 = 3;
            if (r101.f48549d != 3) goto L5;
            r102 = 6;
        L5:
            r101.f48549d = r102;
            r101.requestLayout();
        }
    }

    public final void d() {
        setChipsAllClosable(false);
        i(false);
        requestLayout();
    }

    static {
        f48543f = com.bytedance.android.shopping.extensions.b.b(4);
        f48544g = com.bytedance.android.shopping.extensions.b.b(4);
        f48545h = com.bytedance.android.shopping.extensions.b.b(8);
    }

    public final void h() {
        if (this.f48548c == false) goto L5;
        return;
    L5:
        g(true);
        i(true);
        setChipsAllClosable(true);
    }

    private final int getHistoryChipCount() {
        int r100 = getChildCount();
        if (this.f48547b != null) goto L5;
        int r101 = 0;
    L7:
        return r100 - r101;
    L5:
        r101 = 1;
        goto L7
    }

    private final View getLastVisibleChild() {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r100 = getChildCount();
    L6:
        if (r100 < 0) goto L13;
        View r101 = getChildAt(r100);
        if (r101 == null) goto L12;
        if (r101.getVisibility() == 8) goto L12;
        return r101;
    L12:
        r100 = r100 - 1;
        goto L6
    L13:
        return null;
    }

    public final void f() {
        int r100 = getChildCount();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L13;
        View r101 = getChildAt(r100);
        if ((r101 instanceof HistoryChip.WrapCard) == true) goto L8;
        r101 = null;
    L8:
        HistoryChip.WrapCard r102 = (HistoryChip.WrapCard) r101;
        if (r102 == null) goto L3;
        removeView(r102);
        a r103 = this.f48546a;
        if (r103 == null) goto L3;
        r103.d(r102.getChip(), getHistoryChipCount(), true, null);
        goto L3
    L13:
        requestLayout();
        i(false);
        a r104 = this.f48546a;
        if (r104 == null) goto L24;
        r104.b();
        return;
    }

    public final a getActionListener() {
        return this.f48546a;
    }

    public final c getHistoryChipInitializer() {
        return this.f48550e;
    }

    public static final /* synthetic */ int a(HistoryView r100) {
        return r100.getHistoryChipCount();
    }

    public static final /* synthetic */ View b(HistoryView r100) {
        return r100.getLastVisibleChild();
    }

    private final void setChipsAllClosable(boolean r100) {
        int r101 = getChildCount();
        if (r101 < 0) goto L18;
        int r102 = 0;
    L5:
        View r103 = getChildAt(r102);
        if ((r103 instanceof HistoryChip.WrapCard) == true) goto L8;
    L16:
        if (r102 == r101) goto L20;
        r102 = r102 + 1;
        goto L5
    L20:
        return;
    L8:
        if ((!Intrinsics.areEqual(r103, this.f48547b)) == false) goto L16;
        if (r100 == false) goto L13;
        HistoryChip.WrapCard r104 = (HistoryChip.WrapCard) r103;
        r104.setVisibility(0);
        TextView r105 = r104.getChip().f48537a;
        if (r105 == null) goto L16;
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(r105, 0, 0, R.drawable.shopping_ic_store_v3_history_chip_remove, 0);
        r105.requestLayout();
        goto L16
    L13:
        TextView r106 = ((HistoryChip.WrapCard) r103).getChip().f48537a;
        if (r106 == null) goto L16;
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(r106, 0, 0, 0, 0);
        r106.requestLayout();
        goto L16
    }

    private final void setupChip(HistoryChip r100) {
        r100.setOnLongClickListener(new d(this));
        r100.setOnClickListener(new e(this, r100));
    }

    public final void c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "history");
        HistoryChip r101 = new HistoryChip(getContext(), HistoryChip.Style.TEXT);
        r101.setHistory(r100);
        setupChip(r101);
        c r102 = this.f48550e;
        if (r102 == null) goto L6;
        View r103 = r102.a(r101);
        if (r103 == null) goto L6;
    L7:
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        int r105 = f48543f;
        r104.setMargins(0, 0, r105, r105);
        addView(r103, 0, r104);
        return;
    L6:
        r103 = HistoryChip.c(r101);
        goto L7
    }

    public final int e(HistoryChip r100) {
        if (getChildCount() != 0) goto L5;
        return -1;
    L5:
        int r101 = getChildCount();
        if (r101 < 0) goto L24;
        int r102 = 0;
    L8:
        View r103 = getChildAt(r102);
        if ((r103 instanceof HistoryChip.WrapCard) == true) goto L11;
    L22:
        if (r102 == r101) goto L24;
        r102 = r102 + 1;
        goto L8
    L11:
        if ((!Intrinsics.areEqual(r103, this.f48547b)) == false) goto L22;
        h r104 = ((HistoryChip.WrapCard) r103).getChip().getHistory();
        String r105 = null;
        if (r104 == null) goto L15;
        String r106 = r104.f542282d;
    L16:
        h r107 = r100.getHistory();
        if (r107 == null) goto L20;
        r105 = r107.f542282d;
    L20:
        if (Intrinsics.areEqual(r106, r105) == false) goto L22;
        return r102;
    L15:
        r106 = null;
    L24:
        return -1;
    }

    public final void g(boolean r100) {
        if (this.f48547b != null) goto L13;
        HistoryChip r101 = new HistoryChip(getContext(), HistoryChip.Style.ICON);
        c r102 = this.f48550e;
        if (r102 == null) goto L8;
        HistoryChip.WrapCard r103 = r102.a(r101);
        if (r103 == null) goto L8;
    L9:
        this.f48547b = r103;
        post(new f(this));
        HistoryChip.WrapCard r104 = this.f48547b;
        if (r104 == null) goto L13;
        r104.setOnClickListener(new g(this));
    L8:
        r103 = HistoryChip.c(r101);
    L13:
        if (this.f48548c == true) goto L26;
        if (r100 == false) goto L20;
        HistoryChip.WrapCard r105 = this.f48547b;
        if (r105 == null) goto L27;
        HistoryChip r106 = r105.getChip();
        if (r106 == null) goto L28;
        r106.b();
        return;
    L28:
        return;
    L27:
        return;
    L20:
        HistoryChip.WrapCard r107 = this.f48547b;
        if (r107 == null) goto L30;
        HistoryChip r108 = r107.getChip();
        if (r108 == null) goto L31;
        r108.a();
        return;
    L31:
        return;
    L30:
        return;
    }

    public final void i(boolean r100) {
        if (this.f48548c != r100) goto L5;
        return;
    L5:
        if (r100 == false) goto L12;
        HistoryChip.WrapCard r101 = this.f48547b;
        if (r101 == null) goto L9;
        r101.setVisibility(4);
    L9:
        a r102 = this.f48546a;
        if (r102 == null) goto L18;
        r102.c();
    L18:
        this.f48548c = r100;
        return;
    L12:
        HistoryChip.WrapCard r103 = this.f48547b;
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        a r104 = this.f48546a;
        if (r104 == null) goto L18;
        r104.a();
        goto L18
    }

    public final void setActionListener(a r100) {
        this.f48546a = r100;
    }

    public final void setHistoryChipInitializer(c r100) {
        this.f48550e = r100;
    }

    public HistoryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        setLineSpacing(f48545h);
        setItemSpacing(f48544g);
        this.f48549d = 3;
    }

    @Override // com.google.android.material.internal.FlowLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r210, int r211, int r212, int r213, int r214) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        boolean r100 = true;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        int r102 = getPaddingRight();
    L12:
        if (r101 == false) goto L14;
        int r103 = getPaddingLeft();
    L15:
        int r104 = getPaddingTop();
        int r105 = (r213 - r211) - r103;
        int r106 = getChildCount();
        int r110 = r102;
        int r107 = r104;
        int r111 = 0;
        boolean r112 = false;
        int r113 = 1;
        View r114 = null;
    L16:
        if (r111 >= r106) goto L149;
        View r115 = getChildAt(r111);
        if (r112 == true) goto L20;
        r102 = r102;
        r106 = r106;
        if (this.f48548c == true) goto L48;
    L50:
        r115.setVisibility(0);
    L51:
        if (r115 == null) goto L53;
        ViewGroup.LayoutParams r108 = r115.getLayoutParams();
    L55:
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L61;
        ViewGroup.LayoutParams r109 = r115.getLayoutParams();
        if (r109 == null) goto L60;
        int r116 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r109);
    L62:
        if (r115 == null) goto L64;
        ViewGroup.LayoutParams r117 = r115.getLayoutParams();
    L66:
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L72;
        ViewGroup.LayoutParams r118 = r115.getLayoutParams();
        if (r118 == null) goto L71;
        int r119 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r118);
    L73:
        int r120 = (r110 + r116) + r115.getMeasuredWidth();
        if (isSingleLine() == true) goto L78;
        if (r120 <= r105) goto L78;
        if (r110 <= 0) goto L78;
        boolean r121 = true;
    L79:
        if (r121 == false) goto L82;
        r107 = getLineSpacing() + r104;
        r113 = r113 + 1;
        r110 = r102;
    L82:
        if (r111 == (getChildCount() - 1)) goto L84;
    L91:
        boolean r122 = false;
    L92:
        if (r122 == true) goto L93;
        int r123 = this.f48549d;
        if (r123 == 3) goto L99;
    L101:
        boolean r124 = false;
    L103:
        if (r123 == 6) goto L105;
    L107:
        boolean r125 = false;
    L108:
        boolean r126 = this.f48548c;
        if (r126 == true) goto L113;
        if (r125 == true) goto L112;
        if (r124 == false) goto L113;
    L112:
        boolean r127 = true;
    L114:
        if (r127 == false) goto L124;
        if (r114 == null) goto L123;
        r114.setVisibility(8);
        if (this.f48549d != 3) goto L119;
        boolean r128 = true;
    L120:
        g(r128);
        HistoryChip.WrapCard r129 = this.f48547b;
        if (r129 == null) goto L123;
        r129.layout(r114.getLeft(), r114.getTop(), (r114.getBottom() - r114.getTop()) + r114.getLeft(), r114.getBottom());
        goto L123
    L119:
        r128 = false;
    L123:
        r115.setVisibility(8);
        r104 = r104;
        r112 = true;
    L148:
        r111 = r111 + 1;
        r106 = r106;
        r102 = r102;
        r100 = true;
        goto L16
    L124:
        if (r126 == false) goto L126;
    L132:
        boolean r130 = false;
    L133:
        if (r130 == true) goto L135;
    L139:
        int r131 = r115.getMeasuredWidth();
        int r132 = r115.getMeasuredHeight();
        if (Intrinsics.areEqual(r115, this.f48547b) == false) goto L143;
        if (r114 == null) goto L143;
        r131 = r114.getBottom() - r114.getTop();
        r132 = r131;
    L143:
        int r133 = r110 + r116;
        int r134 = r131 + r133;
        int r135 = r132 + r107;
        if (r101 == false) goto L146;
        r115.layout(r105 - r134, r107, (r105 - r110) - r116, r135);
    L147:
        r110 = r110 + (((r116 + r119) + r115.getMeasuredWidth()) + getItemSpacing());
        r104 = r135;
        r114 = r115;
        goto L148
    L146:
        r115.layout(r133, r107, r134, r135);
        goto L147
    L135:
        if (this.f48549d != 3) goto L137;
        boolean r136 = true;
    L138:
        g(r136);
        goto L139
    L137:
        r136 = false;
        goto L138
    L126:
        if (r113 <= 3) goto L132;
        if (r123 != 6) goto L132;
        if (r111 != (getChildCount() - 2)) goto L132;
        r130 = true;
    L113:
        r127 = false;
        goto L114
    L105:
        if (r113 != 7) goto L107;
        r125 = true;
        goto L108
    L99:
        if (r113 != 4) goto L101;
        r124 = true;
        goto L103
    L93:
        HistoryChip.WrapCard r137 = this.f48547b;
        if (r137 == null) goto L149;
        r137.setVisibility(8);
        goto L149
    L84:
        if (Intrinsics.areEqual(this.f48547b, getChildAt(getChildCount() - 1)) == false) goto L91;
        if (r113 > 3) goto L88;
    L90:
        r122 = true;
        goto L92
    L88:
        if (r113 != 4) goto L91;
        if (r121 == false) goto L91;
    L78:
        r121 = false;
        goto L79
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L72:
        r119 = 0;
        goto L73
    L64:
        r117 = null;
        goto L66
    L60:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L61:
        r116 = 0;
        goto L62
    L53:
        r108 = null;
        goto L55
    L48:
        if (Intrinsics.areEqual(r115, this.f48547b) == false) goto L50;
        r115.setVisibility(8);
        goto L51
    L20:
        if (this.f48549d != 6) goto L41;
        int r138 = getChildCount() - 1;
        if (r138 < r111) goto L39;
    L23:
        View r139 = getChildAt(r138);
        if ((r139 instanceof HistoryChip.WrapCard) == true) goto L26;
    L28:
        boolean r140 = false;
    L29:
        if (r140 == true) goto L32;
        r139 = null;
    L32:
        if (r139 == null) goto L37;
        HistoryChip.WrapCard r141 = (HistoryChip.WrapCard) r139;
        removeView(r141);
        a r142 = this.f48546a;
        if (r142 == null) goto L37;
        r142.d(r141.getChip(), getHistoryChipCount(), false, String.valueOf(e(r141.getChip())));
    L37:
        if (r138 == r111) goto L40;
        r138 = r138 - 1;
        r106 = r106;
        r102 = r102;
        r100 = true;
    L40:
        requestLayout();
        goto L148
    L26:
        if ((Intrinsics.areEqual(r139, this.f48547b) ^ r100) == false) goto L28;
        r140 = true;
        goto L29
    L39:
        r102 = r102;
        r106 = r106;
        goto L40
    L41:
        r102 = r102;
        r106 = r106;
        if ((!Intrinsics.areEqual(r115, this.f48547b)) == false) goto L148;
        r115.setVisibility(8);
    L149:
        post(new cn.h(this));
        return;
    L14:
        r103 = getPaddingRight();
        goto L15
    L11:
        r102 = getPaddingLeft();
        goto L12
    L8:
        r101 = false;
        goto L9
    }
}
