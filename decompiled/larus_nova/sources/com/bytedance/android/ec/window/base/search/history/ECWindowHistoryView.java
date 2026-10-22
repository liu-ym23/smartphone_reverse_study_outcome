package com.bytedance.android.ec.window.base.search.history;

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

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000e\u001bB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryView;", "Lcom/google/android/material/internal/FlowLayout;", "", "getHistoryChipCount", "Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryChip;", "chip", "", "setupChip", "", "closeable", "setChipsAllClosable", "Landroid/view/View;", "getLastVisibleChild", "Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryView$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryView$a;", "getActionListener", "()Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryView$a;", "setActionListener", "(Lcom/bytedance/android/ec/window/base/search/history/ECWindowHistoryView$a;)V", "actionListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowHistoryView extends FlowLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49535e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49536f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f49537g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f49538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECWindowHistoryChip.WrapCard f49539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f49541d;

    public interface a {
        void a();

        void b();

        void c();

        void d(ECWindowHistoryChip r100, int r101, boolean r102, String r103);

        void e(ECWindowHistoryChip r100, String r101);
    }

    public static final class b {
    }

    public static final class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowHistoryView f49542a;

        public c(ECWindowHistoryView r100) {
            this.f49542a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            this.f49542a.h();
            return true;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowHistoryView f49543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ECWindowHistoryChip f49544b;

        public d(ECWindowHistoryView r100, ECWindowHistoryChip r101) {
            this.f49543a = r100;
            this.f49544b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECWindowHistoryView r101 = this.f49543a;
            if (r101.f49540c == false) goto L19;
            String r102 = String.valueOf(r101.e(this.f49544b));
            ECWindowHistoryView r103 = this.f49543a;
            Object r104 = this.f49544b.getParent();
            if (r104 == null) goto L18;
            r103.removeView((View) r104);
            ECWindowHistoryView r105 = this.f49543a;
            boolean r106 = true;
            if (r105.f49539b != null) goto L9;
            int r107 = 0;
        L11:
            if (r105.getChildCount() > r107) goto L14;
            r106 = false;
        L14:
            r105.i(r106);
            a r108 = this.f49543a.getActionListener();
            if (r108 == null) goto L23;
            r108.d(this.f49544b, ECWindowHistoryView.a(this.f49543a), false, r102);
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
            ECWindowHistoryChip r110 = this.f49544b;
            r109.e(r110, String.valueOf(this.f49543a.e(r110)));
            return;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowHistoryView f49545a;

        public e(ECWindowHistoryView r100) {
            this.f49545a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECWindowHistoryView r100 = this.f49545a;     // Catch: Throwable -> L4
            ECWindowHistoryChip.WrapCard r101 = r100.f49539b;     // Catch: Throwable -> L4
            LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L4
            int r103 = ECWindowHistoryView.f49535e;     // Catch: Throwable -> L4
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

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowHistoryView f49546a;

        public f(ECWindowHistoryView r100) {
            this.f49546a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECWindowHistoryView r101 = this.f49546a;
            int r102 = 3;
            if (r101.f49541d != 3) goto L5;
            r102 = 6;
        L5:
            r101.f49541d = r102;
            r101.requestLayout();
        }
    }

    public final void d() {
        setChipsAllClosable(false);
        i(false);
        requestLayout();
    }

    static {
        f49535e = com.bytedance.android.shopping.extensions.b.b(4);
        f49536f = com.bytedance.android.shopping.extensions.b.b(4);
        f49537g = com.bytedance.android.shopping.extensions.b.b(8);
    }

    public final void h() {
        if (this.f49540c == false) goto L5;
        return;
    L5:
        g(true);
        i(true);
        setChipsAllClosable(true);
    }

    private final int getHistoryChipCount() {
        int r100 = getChildCount();
        if (this.f49539b != null) goto L5;
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
        if ((r101 instanceof ECWindowHistoryChip.WrapCard) == true) goto L8;
        r101 = null;
    L8:
        ECWindowHistoryChip.WrapCard r102 = (ECWindowHistoryChip.WrapCard) r101;
        if (r102 == null) goto L3;
        removeView(r102);
        a r103 = this.f49538a;
        if (r103 == null) goto L3;
        r103.d(r102.getChip(), getHistoryChipCount(), true, null);
        goto L3
    L13:
        requestLayout();
        i(false);
        a r104 = this.f49538a;
        if (r104 == null) goto L24;
        r104.b();
        return;
    }

    public final a getActionListener() {
        return this.f49538a;
    }

    public static final /* synthetic */ int a(ECWindowHistoryView r100) {
        return r100.getHistoryChipCount();
    }

    public static final /* synthetic */ View b(ECWindowHistoryView r100) {
        return r100.getLastVisibleChild();
    }

    private final void setChipsAllClosable(boolean r100) {
        int r101 = getChildCount();
        if (r101 < 0) goto L18;
        int r102 = 0;
    L5:
        View r103 = getChildAt(r102);
        if ((r103 instanceof ECWindowHistoryChip.WrapCard) == true) goto L8;
    L16:
        if (r102 == r101) goto L20;
        r102 = r102 + 1;
        goto L5
    L20:
        return;
    L8:
        if ((!Intrinsics.areEqual(r103, this.f49539b)) == false) goto L16;
        if (r100 == false) goto L13;
        ECWindowHistoryChip.WrapCard r104 = (ECWindowHistoryChip.WrapCard) r103;
        r104.setVisibility(0);
        TextView r105 = r104.getChip().f49529a;
        if (r105 == null) goto L16;
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(r105, 0, 0, R.drawable.shopping_ic_store_v3_history_chip_remove, 0);
        r105.requestLayout();
        goto L16
    L13:
        TextView r106 = ((ECWindowHistoryChip.WrapCard) r103).getChip().f49529a;
        if (r106 == null) goto L16;
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(r106, 0, 0, 0, 0);
        r106.requestLayout();
        goto L16
    }

    private final void setupChip(ECWindowHistoryChip r100) {
        r100.setOnLongClickListener(new c(this));
        r100.setOnClickListener(new d(this, r100));
    }

    public final void c(cp.a r100) {
        Intrinsics.checkNotNullParameter(r100, "history");
        ECWindowHistoryChip r101 = new ECWindowHistoryChip(getContext(), ECWindowHistoryChip.Style.TEXT);
        r101.setHistory(r100);
        setupChip(r101);
        View r102 = new ECWindowHistoryChip.WrapCard(r101.getContext(), r101);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        int r104 = f49535e;
        r103.setMargins(0, 0, r104, r104);
        addView(r102, 0, r103);
    }

    public final int e(ECWindowHistoryChip r100) {
        if (getChildCount() != 0) goto L5;
        return -1;
    L5:
        int r101 = getChildCount();
        if (r101 < 0) goto L24;
        int r102 = 0;
    L8:
        View r103 = getChildAt(r102);
        if ((r103 instanceof ECWindowHistoryChip.WrapCard) == true) goto L11;
    L22:
        if (r102 == r101) goto L24;
        r102 = r102 + 1;
        goto L8
    L11:
        if ((!Intrinsics.areEqual(r103, this.f49539b)) == false) goto L22;
        cp.a r104 = ((ECWindowHistoryChip.WrapCard) r103).getChip().getHistory();
        String r105 = null;
        if (r104 == null) goto L15;
        String r106 = r104.f464594d;
    L16:
        cp.a r107 = r100.getHistory();
        if (r107 == null) goto L20;
        r105 = r107.f464594d;
    L20:
        if (Intrinsics.areEqual(r106, r105) == false) goto L22;
        return r102;
    L15:
        r106 = null;
    L24:
        return -1;
    }

    public final void g(boolean r100) {
        if (this.f49539b != null) goto L8;
        ECWindowHistoryChip r101 = new ECWindowHistoryChip(getContext(), ECWindowHistoryChip.Style.ICON);
        this.f49539b = new ECWindowHistoryChip.WrapCard(r101.getContext(), r101);
        post(new e(this));
        ECWindowHistoryChip.WrapCard r102 = this.f49539b;
        if (r102 == null) goto L8;
        r102.setOnClickListener(new f(this));
    L8:
        if (this.f49540c == true) goto L21;
        if (r100 == false) goto L15;
        ECWindowHistoryChip.WrapCard r103 = this.f49539b;
        if (r103 == null) goto L22;
        ECWindowHistoryChip r104 = r103.getChip();
        if (r104 == null) goto L23;
        r104.b();
        return;
    L23:
        return;
    L22:
        return;
    L15:
        ECWindowHistoryChip.WrapCard r105 = this.f49539b;
        if (r105 == null) goto L25;
        ECWindowHistoryChip r106 = r105.getChip();
        if (r106 == null) goto L26;
        r106.a();
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void i(boolean r100) {
        if (this.f49540c != r100) goto L5;
        return;
    L5:
        if (r100 == false) goto L12;
        ECWindowHistoryChip.WrapCard r101 = this.f49539b;
        if (r101 == null) goto L9;
        r101.setVisibility(4);
    L9:
        a r102 = this.f49538a;
        if (r102 == null) goto L18;
        r102.c();
    L18:
        this.f49540c = r100;
        return;
    L12:
        ECWindowHistoryChip.WrapCard r103 = this.f49539b;
        if (r103 == null) goto L15;
        r103.setVisibility(0);
    L15:
        a r104 = this.f49538a;
        if (r104 == null) goto L18;
        r104.a();
        goto L18
    }

    public final void setActionListener(a r100) {
        this.f49538a = r100;
    }

    public ECWindowHistoryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        setLineSpacing(f49537g);
        setItemSpacing(f49536f);
        this.f49541d = 3;
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
        if (this.f49540c == true) goto L48;
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
        int r123 = this.f49541d;
        if (r123 == 3) goto L99;
    L101:
        boolean r124 = false;
    L103:
        if (r123 == 6) goto L105;
    L107:
        boolean r125 = false;
    L108:
        boolean r126 = this.f49540c;
        if (r126 == true) goto L113;
        if (r125 == true) goto L112;
        if (r124 == false) goto L113;
    L112:
        boolean r127 = true;
    L114:
        if (r127 == false) goto L124;
        if (r114 == null) goto L123;
        r114.setVisibility(8);
        if (this.f49541d != 3) goto L119;
        boolean r128 = true;
    L120:
        g(r128);
        ECWindowHistoryChip.WrapCard r129 = this.f49539b;
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
        if (Intrinsics.areEqual(r115, this.f49539b) == false) goto L143;
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
        if (this.f49541d != 3) goto L137;
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
        ECWindowHistoryChip.WrapCard r137 = this.f49539b;
        if (r137 == null) goto L149;
        r137.setVisibility(8);
        goto L149
    L84:
        if (Intrinsics.areEqual(this.f49539b, getChildAt(getChildCount() - 1)) == false) goto L91;
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
        if (Intrinsics.areEqual(r115, this.f49539b) == false) goto L50;
        r115.setVisibility(8);
        goto L51
    L20:
        if (this.f49541d != 6) goto L41;
        int r138 = getChildCount() - 1;
        if (r138 < r111) goto L39;
    L23:
        View r139 = getChildAt(r138);
        if ((r139 instanceof ECWindowHistoryChip.WrapCard) == true) goto L26;
    L28:
        boolean r140 = false;
    L29:
        if (r140 == true) goto L32;
        r139 = null;
    L32:
        if (r139 == null) goto L37;
        ECWindowHistoryChip.WrapCard r141 = (ECWindowHistoryChip.WrapCard) r139;
        removeView(r141);
        a r142 = this.f49538a;
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
        if ((Intrinsics.areEqual(r139, this.f49539b) ^ r100) == false) goto L28;
        r140 = true;
        goto L29
    L39:
        r102 = r102;
        r106 = r106;
        goto L40
    L41:
        r102 = r102;
        r106 = r106;
        if ((!Intrinsics.areEqual(r115, this.f49539b)) == false) goto L148;
        r115.setVisibility(8);
    L149:
        post(new hp.d(this));
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
