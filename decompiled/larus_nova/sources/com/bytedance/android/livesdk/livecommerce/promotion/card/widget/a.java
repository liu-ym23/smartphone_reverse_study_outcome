package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPingGroup;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.RemoteGroupHeadImageOptView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends FrameLayout implements ij2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECUIPromotion f150446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RelativeLayout f150447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f150448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f150449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f150450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f150451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public StringBuilder f150452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f150453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LivePromotionCardArgs f150454i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotion.card.widget.a$a, reason: collision with other inner class name */
    public static final class C2320a {
    }

    static {
    }

    @Override // ij2.a
    public String getType() {
        return "ping_group_widget";
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f150452g;
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100);
    }

    @Override // ij2.a
    public final void release() {
        this.f150454i.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.b(this.f150453h);
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C6273a.b(this);
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C6273a.a(this);
    }

    private final void setImageOpt(ECUIPingGroup r110) {
        int r100 = (int) ((r110.getJoined() / r110.getGroupSize()) * 100);
        this.f150447b.removeAllViews();
        List<String> r101 = r110.getAvatarList();
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L7:
        if (r102 != 0) goto L13;
        this.f150448c.setVisibility(0);
        this.f150447b.setVisibility(8);
        ViewGroup.LayoutParams r111 = this.f150449d.getLayoutParams();
        if (r111 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r111).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(17.0f));
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        View r112 = null;
        if (r102 > 2) goto L39;
        if (r100 == 100) goto L39;
        this.f150448c.setVisibility(0);
        this.f150447b.setVisibility(0);
        List<String> r113 = r110.getAvatarList();
        if (r113 != null) goto L19;
    L34:
        ViewGroup.LayoutParams r114 = this.f150449d.getLayoutParams();
        if (r114 == null) goto L38;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(27.0f));
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        if ((!r113.isEmpty()) == true) goto L22;
        r113 = null;
    L22:
        if (r113 == null) goto L34;
        this.f150450e = LayoutInflater.from(getContext()).inflate(R.layout.shopping_layout_promotion_card_ping_group_iron_people_item_opt, this, false);
        RelativeLayout.LayoutParams r103 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r104 = this.f150450e;
        if (r104 == null) goto L26;
        r104.setLayoutParams(r103);
    L26:
        View r105 = this.f150450e;
        if (r105 == null) goto L29;
        r105.setTranslationX(UtilityKotlinExtentionsKt.c(Float.valueOf(10.0f)));
    L29:
        this.f150447b.addView(this.f150450e);
        View r106 = this.f150450e;
        if ((r106 instanceof RemoteGroupHeadImageOptView) == false) goto L33;
        r112 = r106;
    L33:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r112, (String) ListProtector.get(r113, 0));
    L39:
        if (r102 >= 2) goto L42;
        if (r102 != 2) goto L89;
        if (r100 >= 100) goto L42;
        return;
    L89:
        return;
    L42:
        this.f150448c.setVisibility(8);
        this.f150447b.setVisibility(0);
        List<String> r107 = r110.getAvatarList();
        if (r107 != null) goto L45;
    L60:
        List<String> r115 = r110.getAvatarList();
        if (r115 != null) goto L63;
    L81:
        ViewGroup.LayoutParams r116 = this.f150449d.getLayoutParams();
        if (r116 == null) goto L86;
        ((ViewGroup.MarginLayoutParams) r116).leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(27.0f));
        return;
    L86:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L63:
        if (r115.size() <= 1) goto L65;
        boolean r108 = true;
    L66:
        if (r108 == true) goto L69;
        r115 = null;
    L69:
        if (r115 == null) goto L81;
        this.f150451f = LayoutInflater.from(getContext()).inflate(R.layout.shopping_layout_promotion_card_ping_group_iron_people_item_opt, this, false);
        RelativeLayout.LayoutParams r109 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r117 = this.f150451f;
        if (r117 == null) goto L73;
        r117.setLayoutParams(r109);
    L73:
        View r118 = this.f150451f;
        if (r118 == null) goto L76;
        r118.setTranslationX(UtilityKotlinExtentionsKt.c(Float.valueOf(10.0f)));
    L76:
        this.f150447b.addView(this.f150451f);
        View r119 = this.f150451f;
        if ((r119 instanceof RemoteGroupHeadImageOptView) == false) goto L80;
        r112 = r119;
    L80:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r112, (String) ListProtector.get(r115, 1));
        goto L81
    L65:
        r108 = false;
        goto L66
    L45:
        if ((!r107.isEmpty()) == true) goto L48;
        r107 = null;
    L48:
        if (r107 == null) goto L60;
        View r120 = LayoutInflater.from(getContext()).inflate(R.layout.shopping_layout_promotion_card_ping_group_iron_people_item_opt, this, false);
        this.f150450e = r120;
        if (r120 == null) goto L59;
        ((RemoteGroupHeadImageOptView) r120).setClip(false);
        RelativeLayout.LayoutParams r121 = new RelativeLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)), UtilityKotlinExtentionsKt.d(Float.valueOf(14.0f)));
        View r122 = this.f150450e;
        if (r122 == null) goto L54;
        r122.setLayoutParams(r121);
    L54:
        this.f150447b.addView(this.f150450e);
        View r123 = this.f150450e;
        if ((r123 instanceof RemoteGroupHeadImageOptView) == true) goto L57;
        r123 = null;
    L57:
        ECLiveImageUtils.j((RemoteGroupHeadImageOptView) r123, (String) ListProtector.get(r107, 0));
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.promotion.card.view.RemoteGroupHeadImageOptView");
    L5:
        r102 = 0;
        goto L7
    }

    private final void setText(ECUIPingGroup r100) {
        int r101 = (int) ((r100.getJoined() / r100.getGroupSize()) * 100);
        String r102 = "";
        boolean r103 = true;
        if (r100.getJoined() > 2) goto L8;
        if (r101 < 100) goto L6;
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_complete);
    L25:
        if (r102.length() > 0) goto L28;
        r103 = false;
    L28:
        if (r103 == false) goto L33;
        this.f150449d.setText(r102);
        StringBuilder r104 = this.f150452g;
        if (r104 == null) goto L34;
        r104.append(r102);
        return;
    L34:
        return;
    L33:
        return;
    L6:
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_num_no, new Object[]{String.valueOf(r100.getGroupSize()), ""});
        goto L25
    L8:
        if (r100.getJoined() <= 2) goto L13;
        if (r101 > 80) goto L13;
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_num_less, new Object[]{String.valueOf(r100.getJoined()), String.valueOf(r100.getGroupSize())});
    L13:
        if (81 > r101) goto L17;
        if (100 <= r101) goto L17;
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_num_close, new Object[]{String.valueOf(r100.getJoined()), String.valueOf(r100.getGroupSize() - r100.getJoined())});
    L17:
        if (r101 < 100) goto L25;
        if (TextUtils.isEmpty(r100.getTime()) == false) goto L21;
    L23:
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_complete);
        goto L25
    L21:
        if (r100.isShowTime() == false) goto L23;
        r102 = getContext().getResources().getString(R.string.ec_iron_ping_people_complete_time, new Object[]{r100.getTime()});
        goto L25
    }

    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f150446a = r100.f42855a;
        this.f150452g = new StringBuilder();
        ECUIPromotion r101 = this.f150446a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r102 = r101.getCampaign();
        if (r102 == null) goto L11;
        ECUIPingGroup r103 = r102.groupData;
        if (r103 == null) goto L12;
        setText(r103);
        setImageOpt(r103);
        this.f150454i.f150038b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.f150309a.a(this.f150453h);
        return;
    L12:
        return;
    }

    public a(Context r100, LivePromotionCardArgs r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "argument");
        super(r100, null, 0);
        this.f150454i = r101;
        this.f150453h = new b(this);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.shopping_layout_promotion_card_ping_group_iron, this, true);
        RelativeLayout r103 = (RelativeLayout) r102.findViewById(R.id.rl_root_view);
        this.f150447b = (RelativeLayout) r102.findViewById(R.id.rl_group_people);
        this.f150448c = (ImageView) r102.findViewById(R.id.iv_tag);
        this.f150449d = (TextView) r102.findViewById(R.id.tv_group_people_time);
    }

    public static final void c(a r110, long r111) {
        ECUIPromotion r100 = r110.f150446a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L5:
        ECUICampaign r101 = r100.getCampaign();
        ECUIPromotion r102 = r110.f150446a;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotion");
    L8:
        ECUICampaign r103 = r102.getCampaign();
        if (r103 == null) goto L11;
        ECUIPingGroup r104 = r103.groupData;
    L12:
        if (r101 == null) goto L32;
        if (r104 == null) goto L33;
        long r105 = r101.endTime - r111;
        if (r105 > 0) goto L17;
        String r112 = "00:00:00";
    L30:
        r104.setTime(r112);
        r110.setText(r104);
        return;
    L17:
        StringBuilder r106 = new StringBuilder();
        long r107 = r105 / 86400000;
        if (r107 <= 0) goto L20;
        r105 = r105 - (86400000 * r107);
        r106.append(r107);
        r106.append("天");
    L20:
        long r108 = r105 / 3600000;
        long r109 = r105 - (3600000 * r108);
        if (r108 > 9) goto L23;
        r106.append(0);
    L23:
        r106.append(r108);
        r106.append(":");
        long r113 = r109 / 60000;
        long r114 = r109 - (60000 * r113);
        if (r113 > 9) goto L26;
        r106.append(0);
    L26:
        r106.append(r113);
        r106.append(":");
        long r115 = r114 / 1000;
        if (r115 > 9) goto L29;
        r106.append(0);
    L29:
        r106.append(r115);
        r112 = r106.toString();
        goto L30
    L33:
        return;
    L32:
        return;
    L11:
        r104 = null;
        goto L12
    }
}
