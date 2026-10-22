package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.repository.tab.entity.d0;
import com.bytedance.android.window.shop.repository.tab.entity.e0;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R?\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012Rd\u0010\u001f\u001aD\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012#\u0012!\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR?\u0010$\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006C"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ToolBarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Ldr3/f;", "getHintPopupContentGroup", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowLayoutType;", "getCurrentLayoutType", "layout", "", "setCurrentLayoutType", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "layoutType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/jvm/functions/Function1;", "getLayoutChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setLayoutChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "layoutChangeCallback", "Lkotlin/Function2;", "", "actionName", "", "paramsMap", "b", "Lkotlin/jvm/functions/Function2;", "getDoEventAction", "()Lkotlin/jvm/functions/Function2;", "setDoEventAction", "(Lkotlin/jvm/functions/Function2;)V", "doEventAction", "tartFilterType", "c", "getFilterTypeChangeCB", "setFilterTypeChangeCB", "filterTypeChangeCB", "Landroidx/lifecycle/LifecycleOwner;", "d", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Lio/reactivex/disposables/Disposable;", "e", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "disposable", "Lcom/bytedance/android/window/shop/widget/SortBarView;", "f", "Lcom/bytedance/android/window/shop/widget/SortBarView;", "getSortBarView", "()Lcom/bytedance/android/window/shop/widget/SortBarView;", "setSortBarView", "(Lcom/bytedance/android/window/shop/widget/SortBarView;)V", "sortBarView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolBarView extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f189887l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super WindowLayoutType, Unit> f189888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super String, ? super Map<String, String>, Unit> f189889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super String, Unit> f189890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LifecycleOwner f189891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f189892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SortBarView f189893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintLayout f189894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SimpleDraweeView f189895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f189896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e0 f189897j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f189898k;

    private final dr3.f getHintPopupContentGroup() {
        List r100 = CollectionsKt.listOf(new er3.d.c(3000));
        float r101 = 8;
        fr3.a.c r110 = new fr3.a.c(-2, -2, 11, 0, 0, 7, true, (int) 4281940804L, new fr3.a.C5943a(r101, r101, r101, r101));
        dr3.e[] r102 = new dr3.e[3];
        r102[0] = new dr3.c(new fr3.a.b(12));
        List r103 = CollectionsKt.emptyList();
        fr3.a.C5943a.f478587f.getClass();
        fr3.a.C5943a r111 = fr3.a.C5943a.f478586e;
        e0 r104 = this.f189897j;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L5:
        List<com.bytedance.android.window.shop.repository.tab.entity.d> r105 = r104.f189551l;
        if (r105 == null) goto L10;
        com.bytedance.android.window.shop.repository.tab.entity.d r106 = (com.bytedance.android.window.shop.repository.tab.entity.d) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L10;
        String r107 = r106.f189534d;
    L11:
        r102[1] = new dr3.h(r103, new fr3.a.g(-2, 18, 0, r111, 13, -1, com.bytedance.android.shopping.extensions.k.j(r107), true));
        r102[2] = new dr3.c(new fr3.a.b(12));
        return new dr3.f(r100, r110, CollectionsKt.listOf(r102));
    L10:
        r107 = null;
        goto L11
    }

    public final WindowLayoutType getCurrentLayoutType() {
        e0 r100 = this.f189897j;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L6:
        return r100.f189550k;
    }

    public final SortBarView getSortBarView() {
        SortBarView r100 = this.f189893f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f189892e;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189893f = (SortBarView) findViewById(R.id.window_sort_bar);
        this.f189894g = (ConstraintLayout) findViewById(R.id.window_layout_control_area);
        this.f189895h = (SimpleDraweeView) findViewById(R.id.window_layout_control_icon);
        this.f189896i = (LinearLayout) findViewById(R.id.window_type_filter_area);
        this.f189898k = findViewById(R.id.window_layout_control_split_line);
    }

    public final Disposable getDisposable() {
        return this.f189892e;
    }

    public final Function2<String, Map<String, String>, Unit> getDoEventAction() {
        return this.f189889b;
    }

    public final Function1<String, Unit> getFilterTypeChangeCB() {
        return this.f189890c;
    }

    public final Function1<WindowLayoutType, Unit> getLayoutChangeCallback() {
        return this.f189888a;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.f189891d;
    }

    public static final /* synthetic */ dr3.f R5(ToolBarView r100) {
        return r100.getHintPopupContentGroup();
    }

    public final void S5(e0 r110) {
        this.f189897j = r110;
        final d0 r100 = r110.f189549j;
        if (r100 == null) goto L31;
        SortBarView r101 = this.f189893f;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L8:
        int r102 = r101.getChildCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        SortBarView r104 = this.f189893f;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L13:
        r104.getChildAt(r103).setOnClickListener(null);
        r103 = r103 + 1;
        goto L9
    L14:
        SortBarView r105 = this.f189893f;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L17:
        r105.removeAllViews();
        Iterator r106 = ((ArrayList) r100.f189536j).iterator();
    L19:
        if (r106.hasNext() == false) goto L27;
        d0.b r107 = (d0.b) r106.next();
        SortBarView r111 = this.f189893f;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L23:
        long r108 = r107.f189538a;
        String r112 = r107.f189539b;
        boolean r113 = r107.f189540c;
        boolean r114 = r107.f189541d;
        boolean r109 = r107.f189542e;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "title");
        SortBarView.b r115 = new SortBarView.b(r111, r108, r112, r113, r114, r111.getContext());
        r115.setOnClickListener(new l(r111));
        r115.f189869a.setTextColor(r111.f189865c);
        if (r109 == false) goto L26;
        r115.a(true, false);
    L26:
        r111.addView(r115, new LinearLayout.LayoutParams(-2, -1));
        goto L19
    L27:
        SortBarView r116 = this.f189893f;
        if (r116 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("sortBarView");
    L30:
        r116.a("inner_selection", new ToolBarView$initSortBar$2(r100));
    L31:
        e0 r117 = this.f189897j;
        if (r117 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L34:
        Function2<? super String, ? super Map<String, String>, Unit> r118 = this.f189889b;
        if (r118 == null) goto L41;
        Pair[] r119 = new Pair[1];
        if (r117.f189550k.isSingleColumn() == false) goto L39;
        String r120 = "single_product";
    L40:
        r119[0] = TuplesKt.to("switch_type", r120);
        Unit r121 = r118.invoke("store_product_form_switch_show", MapsKt.mutableMapOf(r119));
        goto L41
    L39:
        r120 = "double_product";
    L41:
        U5(r117.f189550k);
        SimpleDraweeView r122 = this.f189895h;
        if (r122 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L44:
        r122.setOnClickListener(new o(this, r117));
        ConstraintLayout r123 = this.f189894g;
        if (r123 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlArea");
    L47:
        r123.setVisibility(0);
        List<com.bytedance.android.window.shop.repository.tab.entity.d> r124 = r117.f189551l;
        if (r124 == null) goto L65;
        com.bytedance.android.window.shop.repository.tab.entity.d r125 = (com.bytedance.android.window.shop.repository.tab.entity.d) CollectionsKt.firstOrNull(r124);
        if (r125 == null) goto L66;
        Function2<? super String, ? super Map<String, String>, Unit> r126 = this.f189889b;
        if (r126 == null) goto L54;
        Unit r127 = r126.invoke("win_goods_filter_button_show", MapsKt.mapOf(TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, r125.f189532b)));
    L54:
        LinearLayout r128 = this.f189896i;
        if (r128 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("windowTypeFilterArea");
    L57:
        ExtensionsKt.visible(r128);
        T5(r125);
        setOnClickListener(new p(r125, this));
        return;
    L66:
        return;
    }

    public final void T5(com.bytedance.android.window.shop.repository.tab.entity.d r100) {
        ((TextView) findViewById(R.id.window_filter_type_name)).setText(r100.f189532b);
        ECDraweeView r101 = (ECDraweeView) findViewById(R.id.window_filter_type_icon);
        if (r100.f189533c == false) goto L5;
        int r102 = R.drawable.ec_window_arrow_selected;
    L6:
        ECDraweeView.setPlaceholderImage$default(r101, r102, null, 2, null);
        return;
    L5:
        r102 = R.drawable.ec_window_arrow_not_selected;
        goto L6
    }

    public final void U5(WindowLayoutType r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        if (r100.isDoubleColumn() == false) goto L9;
        SimpleDraweeView r101 = this.f189895h;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L7:
        r101.setImageResource(R.drawable.ec_window_double_column_layout_ic);
        return;
    L9:
        if (r100.isSingleColumn() == false) goto L16;
        SimpleDraweeView r102 = this.f189895h;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutControlIcon");
    L13:
        r102.setImageResource(R.drawable.ec_window_single_column_layout_ic);
        return;
    }

    public final void setCurrentLayoutType(WindowLayoutType r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        e0 r101 = this.f189897j;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("toolBarVO");
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f189550k = r100;
    }

    public final void setDisposable(Disposable r100) {
        this.f189892e = r100;
    }

    public final void setDoEventAction(Function2<? super String, ? super Map<String, String>, Unit> r100) {
        this.f189889b = r100;
    }

    public final void setFilterTypeChangeCB(Function1<? super String, Unit> r100) {
        this.f189890c = r100;
    }

    public final void setLayoutChangeCallback(Function1<? super WindowLayoutType, Unit> r100) {
        this.f189888a = r100;
    }

    public final void setLifecycleOwner(LifecycleOwner r100) {
        this.f189891d = r100;
    }

    public final void setSortBarView(SortBarView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f189893f = r100;
    }

    public ToolBarView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
