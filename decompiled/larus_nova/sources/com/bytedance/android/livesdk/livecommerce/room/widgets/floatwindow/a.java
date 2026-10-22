package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnLayout;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "废弃，使用 ECFloatWindowPanelViewManager")
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Boolean f152092i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f152093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECNetImageView f152094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECNetImageView f152095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f152096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f152097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c f152098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f152099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECContext f152100h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.a$a, reason: collision with other inner class name */
    public static final class C2341a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152101a;

        public b(a r100) {
            this.f152101a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a.a(this.f152101a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152102a;

        public c(a r100) {
            this.f152102a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a.a(this.f152102a);
        }
    }

    static {
    }

    public static boolean d() {
        Boolean r100 = f152092i;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.booleanValue();
    }

    public final void f() {
        if (d() == false) goto L11;
        ImageButton r100 = this.f152096d;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L7:
        r100.setRotation(180.0f);
        LinearLayout r101 = this.f152097e;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L10:
        r101.setVisibility(0);
    L18:
        View r102 = this.f152093a;
        if (r102 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        View r103 = r102.findViewById(R.id.layout_header);
        if (r103 != null) goto L24;
        return;
    L24:
        if (d() == false) goto L26;
        String r104 = "收起";
    L27:
        r103.setContentDescription("商品信息 ".concat(r104));
        return;
    L26:
        r104 = "展开";
        goto L27
    L11:
        ImageButton r105 = this.f152096d;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L14:
        r105.setRotation(0.0f);
        LinearLayout r106 = this.f152097e;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L17:
        r106.setVisibility(8);
        goto L18
    }

    public final Context getContext() {
        return this.f152099g;
    }

    public static final void a(final a r100) {
        r100.getClass();
        f152092i = Boolean.valueOf(!d());
        r100.f();
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c r101 = r100.f152098f;
        boolean r102 = d();
        if (r101 == null) goto L6;
        oh.a.b("recordSizeInfoClickEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.b(r100, r101, r102));
    L6:
        UtilityKotlinExtentionsKt.i(new FloatWindowPanelViewManager$togglePanel$1(r100));
    }

    public final void e(ECFloatWindowColumnLayout r100) {
        if (this.f152093a == null) goto L5;
        return;
    L5:
        boolean r101 = false;
        View r102 = th.a.c(this.f152099g, R.layout.ec_size_info_layout, null, false);
        this.f152093a = r102;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        this.f152094b = (ECNetImageView) r102.findViewById(R.id.iv_product_cover);
        View r103 = this.f152093a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        this.f152095c = (ECNetImageView) r103.findViewById(R.id.iv_title);
        View r104 = this.f152093a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        this.f152096d = (ImageButton) r104.findViewById(R.id.iv_arrow);
        View r105 = this.f152093a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        this.f152097e = (LinearLayout) r105.findViewById(R.id.layout_content_list);
        View r106 = this.f152093a;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        r106.findViewById(R.id.layout_header).setOnClickListener(new b(this));
        ImageButton r107 = this.f152096d;
        if (r107 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L23:
        r107.setOnClickListener(new c(this));
        if (r100 == null) goto L36;
        View r108 = this.f152093a;
        if (r108 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        int r109 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r100.getLeftMargin()));
        View r110 = this.f152093a;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        int r111 = r110.getPaddingTop();
        int r112 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r100.getRightMargin()));
        View r113 = this.f152093a;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L34:
        r108.setPadding(r109, r111, r112, r113.getPaddingBottom());
    L36:
        if (f152092i != null) goto L48;
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.c r114 = this.f152098f;
        if (r114 == null) goto L44;
        ECFloatWindowInfo r115 = r114.f152106a;
        if (r115 == null) goto L44;
        Integer r116 = r115.getStatus();
        if (r116 == null) goto L44;
        int r117 = r116.intValue();
    L45:
        if (r117 != 1) goto L47;
        r101 = true;
    L47:
        f152092i = Boolean.valueOf(q.f48131a.getBoolean("ecom_live_float_window_panel_open", r101));
    L44:
        r117 = 1;
    L48:
        f();
    }

    public a(Context r100, ECContext r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "ecContext");
        this.f152099g = r100;
        this.f152100h = r101;
    }

    public final View c(String r110, String r111, boolean r112, boolean r113, int r114) {
        FrameLayout r100 = new FrameLayout(this.f152099g);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) UIUtils.dip2Px(r100.getContext(), 20.0f)));
        float r101 = (float) Math.ceil(r110.length() * 11.25f);
        r100.addView(b(r110, r112, false, r113, r101, r114));
        r100.addView(b(r111, r112, true, r113, r101, r114));
        r100.setTag(Boolean.valueOf(r112));
        return r100;
    }

    public final TextView b(String r100, boolean r101, boolean r102, boolean r103, float r104, int r110) {
        TextView r105 = new TextView(this.f152099g);
        if (r101 == false) goto L5;
        r105.setTextColor((int) 3221225471L);
    L6:
        if (r101 == false) goto L8;
        float r106 = 10.0f;
    L9:
        r105.setTextSize(1, r106);
        r105.setText(r100);
        r105.setSingleLine();
        if (r102 == false) goto L12;
        int r107 = 21;
    L13:
        r105.setGravity(r107);
        if (r102 == false) goto L18;
        if (r103 == false) goto L17;
        r104 = (96.0f - r104) - r110;
    L21:
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams((int) UIUtils.dip2Px(r105.getContext(), r104), -1);
        if (r102 == false) goto L24;
        r108.gravity = 5;
    L24:
        Unit r109 = Unit.INSTANCE;
        r105.setLayoutParams(r108);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        return r105;
    L17:
        r104 = 52.0f;
        goto L21
    L18:
        if (r103 == true) goto L21;
        r104 = 34.0f;
        goto L21
    L12:
        r107 = 16;
        goto L13
    L8:
        r106 = 11.0f;
        goto L9
    L5:
        r105.setTextColor(-1);
        goto L6
    }
}
