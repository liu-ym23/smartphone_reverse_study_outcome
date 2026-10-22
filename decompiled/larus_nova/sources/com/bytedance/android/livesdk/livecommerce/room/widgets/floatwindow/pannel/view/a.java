package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnInfo;
import com.bytedance.android.ec.model.response.ECFloatWindowColumnLayout;
import com.bytedance.android.ec.model.response.ECFloatWindowDetailInfo;
import com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils.ECFloatPanelExpandedUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f152174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ECNetImageView f152175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECNetImageView f152176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageButton f152177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayout f152178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public lk2.b f152179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f152180g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveRoomParams f152181h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f152182i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC2342a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152183a;

        public ViewOnClickListenerC2342a(a r100) {
            this.f152183a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a.a(this.f152183a);
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f152184a;

        public b(a r100) {
            this.f152184a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            a.a(this.f152184a);
        }
    }

    public final void e() {
        if (this.f152174a == null) goto L5;
        return;
    L5:
        View r100 = th.a.c(this.f152180g, R.layout.ec_size_info_layout, null, false);
        this.f152174a = r100;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r100.setBackground(null);
        View r101 = this.f152174a;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r102 = this.f152174a;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        this.f152175b = (ECNetImageView) r102.findViewById(R.id.iv_product_cover);
        View r103 = this.f152174a;
        if (r103 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        this.f152176c = (ECNetImageView) r103.findViewById(R.id.iv_title);
        View r104 = this.f152174a;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        this.f152177d = (ImageButton) r104.findViewById(R.id.iv_arrow);
        View r105 = this.f152174a;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L23:
        this.f152178e = (LinearLayout) r105.findViewById(R.id.layout_content_list);
        View r106 = this.f152174a;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r106.findViewById(R.id.layout_header).setOnClickListener(new ViewOnClickListenerC2342a(this));
        ImageButton r107 = this.f152177d;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L29:
        r107.setOnClickListener(new b(this));
    }

    public final Context getContext() {
        return this.f152180g;
    }

    public static final void a(a r100) {
        if (r100.f152182i.invoke().booleanValue() == false) goto L14;
        ECFloatPanelExpandedUtils.b(!ECFloatPanelExpandedUtils.a());
        lk2.b r101 = r100.f152179f;
        if (r101 == null) goto L8;
        ECFloatWindowDetailInfo r102 = r101.f509556b;
    L9:
        r100.f(r102);
        lk2.b r103 = r100.f152179f;
        boolean r104 = ECFloatPanelExpandedUtils.a();
        if (r103 == null) goto L15;
        oh.a.b("recordSizeInfoClickEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.view.b(r100, r103, r104));
        return;
    L15:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void b(lk2.b r110) {
        boolean r100 = !Intrinsics.areEqual(r110, this.f152179f);
        this.f152179f = r110;
        if (r110 == null) goto L97;
        ECFloatWindowDetailInfo r101 = r110.f509556b;
        if (r101 == null) goto L98;
        e();
        if (r100 == false) goto L21;
        ECFloatWindowColumnLayout r102 = r101.getLayout();
        if (r102 == null) goto L21;
        View r103 = this.f152174a;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L14:
        int r104 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r102.getLeftMargin()));
        View r105 = this.f152174a;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L17:
        int r106 = r105.getPaddingTop();
        int r107 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r102.getRightMargin()));
        View r108 = this.f152174a;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        r103.setPadding(r104, r106, r107, r108.getPaddingBottom());
    L21:
        ECNetImageView r109 = this.f152175b;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("ivProductCover");
    L24:
        ECLiveImageUtils.ECNetImageInfo r111 = new ECLiveImageUtils.ECNetImageInfo();
        String r112 = r101.getImage();
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        r111.url = r112;
        r111.height = -3;
        r111.width = (int) UIUtils.dip2Px(this.f152180g, 24.0f);
        r111.autoScaleOneSide = true;
        r111.disableFade = true;
        r111.disablePlaceholder = true;
        r111.roundDp = 2;
        Unit r113 = Unit.INSTANCE;
        ECLiveImageUtils.b(r109, r111);
        ECNetImageView r114 = this.f152176c;
        if (r114 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("ivTitle");
    L30:
        ECLiveImageUtils.ECNetImageInfo r115 = new ECLiveImageUtils.ECNetImageInfo();
        ECUrlModel r116 = r101.getTitleImage();
        String r117 = null;
        if (r116 == null) goto L33;
        String r118 = r116.getFirstUrl();
    L34:
        if (r118 != null) goto L36;
        r118 = "";
    L36:
        r115.url = r118;
        r115.height = -3;
        r115.width = (int) UIUtils.dip2Px(this.f152180g, 52.0f);
        r115.autoScaleOneSide = true;
        r115.disableFade = true;
        r115.disablePlaceholder = true;
        ECLiveImageUtils.b(r114, r115);
        final ECFloatWindowDetailInfo r119 = r110.f509556b;
        if (r119 == null) goto L92;
        Integer r120 = r110.getType();
        int r121 = 0;
        if (r120 != null) goto L43;
    L45:
        final boolean r122 = false;
    L46:
        LinearLayout r123 = this.f152178e;
        if (r123 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L49:
        r123.removeAllViewsInLayout();
        final StringBuilder r124 = new StringBuilder();
        List<ECFloatWindowColumnInfo> r125 = r119.getColumnInfos();
        if (r125 == null) goto L54;
        ECFloatWindowColumnInfo r126 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r125);
        if (r126 == null) goto L54;
        String r127 = r126.getTitle();
    L55:
        if (r127 != null) goto L57;
        String r128 = "";
    L58:
        List<ECFloatWindowColumnInfo> r129 = r119.getColumnInfos();
        if (r129 == null) goto L63;
        ECFloatWindowColumnInfo r130 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r129);
        if (r130 == null) goto L63;
        r117 = r130.getTitle();
    L63:
        if (r117 != null) goto L65;
        r117 = "";
    L65:
        LinearLayout r131 = this.f152178e;
        if (r131 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L68:
        r131.addView(d(r128, r117, true, r122, r119.getLayout().getCenterMargin()));
        r124.append(r128);
        r124.append(",");
        r124.append(r117);
        List<ECFloatWindowColumnInfo> r132 = r119.getColumnInfos();
        if (r132 == null) goto L74;
        ECFloatWindowColumnInfo r133 = (ECFloatWindowColumnInfo) CollectionsKt.firstOrNull(r132);
        if (r133 == null) goto L74;
        List<String> r134 = r133.getElements();
        if (r134 == null) goto L74;
    L75:
        List<ECFloatWindowColumnInfo> r135 = r119.getColumnInfos();
        if (r135 == null) goto L81;
        ECFloatWindowColumnInfo r136 = (ECFloatWindowColumnInfo) CollectionsKt.lastOrNull(r135);
        if (r136 == null) goto L81;
        List<String> r137 = r136.getElements();
        if (r137 == null) goto L81;
    L82:
        int r138 = r134.size();
    L83:
        if (r121 >= r138) goto L88;
        if (r121 >= r137.size()) goto L87;
        UtilityKotlinExtentionsKt.f(CollectionsKt.getOrNull(r134, r121), CollectionsKt.getOrNull(r137, r121), new ECFloatWindowPanelViewManager$bindContent$1(this, r122, r119, r124));
    L87:
        r121 = r121 + 1;
        goto L83
    L88:
        LinearLayout r139 = this.f152178e;
        if (r139 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L91:
        r139.setContentDescription(r124);
    L81:
        r137 = CollectionsKt.emptyList();
    L74:
        r134 = CollectionsKt.emptyList();
        goto L75
    L57:
        r128 = r127;
    L54:
        r127 = null;
        goto L55
    L43:
        if (r120.intValue() != 2) goto L45;
        r122 = true;
    L92:
        f(r101);
        return;
    L33:
        r118 = null;
        goto L34
    L98:
        return;
    }

    public final void f(ECFloatWindowDetailInfo r100) {
        if (ECFloatPanelExpandedUtils.a() == false) goto L11;
        ImageButton r101 = this.f152177d;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L7:
        r101.setRotation(180.0f);
        LinearLayout r102 = this.f152178e;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L10:
        r102.setVisibility(0);
    L18:
        View r103 = this.f152174a;
        if (r103 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L21:
        View r104 = r103.findViewById(R.id.layout_header);
        if (r104 == null) goto L34;
        StringBuilder r105 = new StringBuilder();
        if (r100 == null) goto L27;
        String r106 = r100.getTitle();
        if (r106 == null) goto L27;
    L28:
        r105.append(r106);
        r105.append(' ');
        if (ECFloatPanelExpandedUtils.a() == false) goto L31;
        String r107 = "收起";
    L32:
        r105.append(r107);
        r104.setContentDescription(r105.toString());
        return;
    L31:
        r107 = "展开";
    L27:
        r106 = "商品信息";
        goto L28
    L34:
        return;
    L11:
        ImageButton r108 = this.f152177d;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivArrow");
    L14:
        r108.setRotation(0.0f);
        LinearLayout r109 = this.f152178e;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("layoutContent");
    L17:
        r109.setVisibility(8);
        goto L18
    }

    public a(Context r100, LiveRoomParams r101, Function0<Boolean> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "canToggle");
        this.f152180g = r100;
        this.f152181h = r101;
        this.f152182i = r102;
    }

    public final View d(String r110, String r111, boolean r112, boolean r113, int r114) {
        FrameLayout r100 = new FrameLayout(this.f152180g);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) UIUtils.dip2Px(r100.getContext(), 20.0f)));
        float r101 = (float) Math.ceil(r110.length() * 11.25f);
        r100.addView(c(r110, r112, false, r113, r101, r114));
        r100.addView(c(r111, r112, true, r113, r101, r114));
        r100.setTag(Boolean.valueOf(r112));
        return r100;
    }

    public final TextView c(String r100, boolean r101, boolean r102, boolean r103, float r104, int r110) {
        TextView r105 = new TextView(this.f152180g);
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
