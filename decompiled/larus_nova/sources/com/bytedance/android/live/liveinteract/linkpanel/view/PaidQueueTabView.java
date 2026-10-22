package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.viewbinder.ApplyTitlePanelType;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007J\u001c\u0010\u000b\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/view/PaidQueueTabView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "tab", "", "setCurrentTab", "getSortValueAb", "Lkotlin/Function1;", "tabOnClickListener", "setTabOnClickListener", "listener", "setSortOnClickListener", "setDefaultTab", "Lcom/bytedance/android/live/liveinteract/linkpanel/viewbinder/ApplyTitlePanelType;", "panelType", "setPanelType", "Lkotlin/Pair;", "pair", "setApplyUserCount", "", "visible", "setQueueSortTypeVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PaidQueueTabView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c90.a f75073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f75074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f75075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f75076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f75077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f75078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f75079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Integer, Unit> f75080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super Integer, Unit> f75081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f75082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f75083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ApplyTitlePanelType f75084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f75085m;

    public static final class a {
    }

    static {
    }

    public PaidQueueTabView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PaidQueueTabView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final int getSortValueAb() {
        return R.string.gift_value;
    }

    private final void setCurrentTab(int r100) {
        String r101 = "#FF161823";
        if (r100 != 2) goto L5;
        String r102 = "#FF161823";
    L7:
        if (r100 == 1) goto L10;
        r101 = "#7F161823";
    L10:
        TextView r103 = this.f75074b;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L13:
        r103.setTextColor(ColorProtector.parseColor(r102));
        TextView r104 = this.f75075c;
        if (r104 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L16:
        r104.setTextColor(ColorProtector.parseColor(r101));
        if (r100 != 2) goto L19;
        int r105 = R.string.ttlive_paid_queue_amount;
    L20:
        TextView r106 = this.f75076d;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mSortType");
    L23:
        r106.setText(s1.B(r105));
        String r107 = s1.C(R.string.ttlive_paid_common_queue_text, new Object[]{Integer.valueOf(this.f75083k)});
        String r108 = s1.C(R.string.ttlive_paid_queue_text, new Object[]{Integer.valueOf(this.f75082j)});
        if (2 != r100) goto L32;
        TextView r109 = this.f75074b;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L28:
        r3.a(r109, s1.B(R.string.ttlive_content_description_selected) + r108);
        TextView r110 = this.f75075c;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L31:
        r3.a(r110, r107);
        return;
    L32:
        TextView r111 = this.f75074b;
        if (r111 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L35:
        r3.a(r111, r108);
        TextView r112 = this.f75075c;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L38:
        r3.a(r112, s1.B(R.string.ttlive_content_description_selected) + r107);
        return;
    L19:
        r105 = T5(b6.B.getValue().intValue());
        goto L20
    L5:
        r102 = "#7F161823";
        goto L7
    }

    public final int T5(int r100) {
        switch(r100) {
            case 40: goto L11;
            case 41: goto L10;
            case 42: goto L6;
            default: goto L11;
        };
    L11:
        return R.string.order_by_waiting_time_v2;
    L6:
        if (this.f75084l != ApplyTitlePanelType.GUEST_APPLY) goto L8;
        return R.string.order_by_recommend_guest;
    L8:
        return R.string.order_by_recommend;
    L10:
        return getSortValueAb();
    }

    public final void setApplyUserCount(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "pair");
        this.f75083k = r100.getFirst().intValue();
        this.f75082j = r100.getSecond().intValue();
        TextView r101 = this.f75075c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L5:
        r101.setText(s1.C(R.string.ttlive_paid_common_queue_text, new Object[]{r100.getFirst()}));
        TextView r102 = this.f75074b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L8:
        r102.setText(s1.C(R.string.ttlive_paid_queue_text, new Object[]{r100.getSecond()}));
    }

    public final void setDefaultTab(int r100) {
        setCurrentTab(r100);
    }

    public final void setPanelType(ApplyTitlePanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        this.f75084l = r100;
    }

    public final void setQueueSortTypeVisibility(boolean r100) {
        this.f75085m = b6.B.getValue();
        TextView r101 = this.f75076d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mSortType");
    L6:
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        ImageView r103 = this.f75079g;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSortRuleIv");
    L12:
        r103.setVisibility(8);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    public final void setSortOnClickListener(Function1<? super Integer, Unit> r100) {
        this.f75081i = r100;
    }

    public final void setTabOnClickListener(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "tabOnClickListener");
        this.f75080h = r100;
    }

    public static final /* synthetic */ void R5(PaidQueueTabView r100, int r101) {
        r100.setCurrentTab(r101);
    }

    public final void U5(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateBubbleSelectUi");
        if (r101 == false) goto L5;
        r100.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ttlive_ic_interact_sort_selected, 0);
        return;
    L5:
        r100.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    public PaidQueueTabView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f75084l = ApplyTitlePanelType.UNKNOWN;
        this.f75085m = b6.B.getValue();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_anchor_apply_list_tab_layout, this, true);
        TextView r103 = (TextView) findViewById(R.id.paid_queue_btn);
        this.f75074b = r103;
        TextView r104 = (TextView) findViewById(R.id.common_queue_btn);
        this.f75075c = r104;
        this.f75076d = (TextView) findViewById(R.id.apply_sort_type);
        View r105 = findViewById(R.id.switch_sort_layout);
        this.f75077e = r105;
        this.f75078f = (TextView) findViewById(R.id.tv_sort_type);
        this.f75079g = (ImageView) findViewById(R.id.iv_rule);
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPaidTab");
    L5:
        r103.setOnClickListener(x0.a(new AnonymousClass1(this)));
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mCommonTab");
    L8:
        r104.setOnClickListener(x0.a(new AnonymousClass2(this)));
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSortContainer");
    L11:
        r105.setOnClickListener(x0.a(new AnonymousClass3(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [T, android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v19, types: [T, android.view.View, android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, android.view.View, android.widget.TextView] */
    public static final c90.a S5(PaidQueueTabView r110, View r210, int r211) {
        c90.a r100 = r110.f75073a;
        if (r100 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L5:
        int r111 = s1.f(10.0f);
        Ref.ObjectRef r112 = new Ref.ObjectRef();
        r112.element = null;
        Context r101 = r110.getContext();
        if (r101 == null) goto L20;
        c90.a.C0416a r113 = new c90.a.C0416a((Activity) r101);
        r113.f22797f = false;
        r113.f22809r = true;
        r113.f22796e = -1;
        r113.f22793b = false;
        r113.f22810s = true;
        r113.f22795d = -s1.f(10.0f);
        r113.f22794c = -s1.f(10.0f);
        r113.f22808q = 0.1f;
        r113.f22807p = false;
        r113.f22799h = s1.f(110.0f) + ((int) UIUtils.dip2Px(r113.f22815x, 14.0f));
        r113.f22792a = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
        um2.a r114 = new um2.a(r110.getContext());
        r114.setOrientation(1);
        r114.setPadding(0, r111, 0, 0);
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        Ref.ObjectRef r103 = new Ref.ObjectRef();
        r103.element = null;
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = null;
        PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r105 = new PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1(r103, r102, r104, r110, r111, r112, r211);
        r114.setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(110), -2));
        if (o.k() == false) goto L10;
        ?? r106 = new TextView(r114.getContext());
        r104.element = r106;
        r112.element = r106;
        r106.setText(R.string.order_by_recommend);
        r106.setGravity(GravityCompat.START);
        r106.setTextSize(1, 14.0f);
        r106.setTextColor(ColorProtector.parseColor("#161823"));
        ViewGroup.LayoutParams r115 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r106.setGravity(GravityCompat.START);
        r106.setPadding(r111, r111, r111, r111);
        Unit r116 = Unit.INSTANCE;
        r106.setLayoutParams(r115);
        r106.setLines(1);
        r106.setCompoundDrawablePadding(s1.f(5.0f));
        PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 r107 = r105;
        r107.invoke(r211);
        r106.setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.view.a(r107, r110));
        r114.addView(r106);
        View r108 = new View(r114.getContext());
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(1)));
        r108.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r114.addView(r108);
    L11:
        ?? r109 = new TextView(r114.getContext());
        r109.setText(r110.getSortValueAb());
        r102.element = r109;
        if (((View) r112.element) != null) goto L14;
        r112.element = r109;
    L14:
        r109.setGravity(GravityCompat.START);
        r109.setTextColor(ColorProtector.parseColor("#161823"));
        r109.setTextSize(1, 14.0f);
        r109.setCompoundDrawablePadding(s1.f(5.0f));
        r107.invoke(r211);
        ViewGroup.LayoutParams r117 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r109.setGravity(GravityCompat.START);
        r109.setPadding(r111, r111, r111, r111);
        Unit r118 = Unit.INSTANCE;
        r109.setLayoutParams(r117);
        r109.setLines(1);
        r109.setOnClickListener(new b(r107, r110));
        r114.addView(r109);
        View r119 = (View) r112.element;
        if (r119 == null) goto L17;
        r119.postDelayed(new c(r112), 500);
    L17:
        View r120 = new View(r114.getContext());
        r120.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(1)));
        r120.setBackgroundColor(ColorProtector.parseColor("#E3E3E5"));
        r114.addView(r120);
        ?? r121 = new TextView(r114.getContext());
        r103.element = r121;
        r121.setText(R.string.order_by_waiting_time_v2);
        r121.setGravity(GravityCompat.START);
        r121.setTextSize(1, 14.0f);
        r121.setTextColor(ColorProtector.parseColor("#161823"));
        ViewGroup.LayoutParams r122 = new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.i(100), -2);
        r121.setGravity(GravityCompat.START);
        r121.setPadding(r111, r111, r111, r111);
        r121.setLayoutParams(r122);
        r121.setLines(1);
        r121.setCompoundDrawablePadding(s1.f(5.0f));
        r107.invoke(r110.f75085m.intValue());
        r121.setOnClickListener(new d(r107, r110));
        r114.addView(r121);
        Intrinsics.checkNotNullParameter(r114, "view");
        r113.f22798g = r114;
        c90.a r123 = new c90.a(r113);
        r123.f156287b = 10;
        r123.i(r210, 80, true);
        return r123;
    L10:
        r107 = r105;
        goto L11
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public /* synthetic */ PaidQueueTabView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
