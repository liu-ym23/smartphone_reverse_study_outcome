package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECUserRightsTagWidget;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/a;", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "tagList", "", "setUserRightsAssuranceTagArea", "", "getCurrentContentDescription", "getType", "()Ljava/lang/String;", "type", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECUserRightsTagWidget extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ECRitTag> f150630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f150631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.card.k f150632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final fj2.b f150633d;

    public static final class a {
    }

    public static final class b implements fj2.a<ECDraweeView> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECUserRightsTagWidget f150634a;

        @Override // fj2.a
        public final String type() {
            return "tag_item_image";
        }

        @Override // fj2.a
        public final ECDraweeView create() {
            ECDraweeView r100 = new ECDraweeView(this.f150634a.getContext(), null, 0, 6, null);
            r100.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            return r100;
        }

        public b(ECUserRightsTagWidget r100) {
            this.f150634a = r100;
        }
    }

    static {
    }

    public ECUserRightsTagWidget(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECUserRightsTagWidget(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "user_right_tag_widget";
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r100 = this.f150631b;
        if (r100 == null) goto L5;
        StringsKt.clear(r100);
    L5:
        List<ECRitTag> r101 = this.f150630a;
        if (r101 == null) goto L17;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        List<String> r103 = ((ECRitTag) r102.next()).getText();
        if (r103 == null) goto L9;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
        if (r104 == null) goto L9;
        StringBuilder r105 = this.f150631b;
        if (r105 == null) goto L9;
        r105.append(r104);
    L17:
        StringBuilder r106 = this.f150631b;
        if (r106 != null) goto L31;
        return "";
    L31:
        return String.valueOf(r106);
    }

    private final void setUserRightsAssuranceTagArea(List<ECRitTag> r110) {
        if ((!Intrinsics.areEqual(this.f150630a, r110)) == false) goto L77;
        this.f150630a = r110;
        removeAllViews();
        Iterator<T> r111 = r110.iterator();
        int r100 = 0;
    L6:
        if (r111.hasNext() == false) goto L67;
        Object r101 = r111.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        ECRitTag r103 = (ECRitTag) r101;
        ECUIConfig r104 = r103.getUiConfig();
        ViewGroup.LayoutParams r105 = null;
        if (r104 != null) goto L13;
    L33:
        if (r104 != null) goto L35;
    L44:
        if (r100 <= 0) goto L46;
        addView(this.f150633d.a(new p(this)));
    L46:
        ECUrlModel r106 = r103.getTextIcon();
        if (r106 == null) goto L52;
        if (r100 == 0) goto L50;
        boolean r107 = true;
    L51:
        addView(b(r106, r107, cg4.a.a(r103.getFirstText())));
        goto L52
    L50:
        r107 = false;
    L52:
        String r108 = r103.getFirstText();
        if (r108 == null) goto L65;
        boolean r109 = cg4.a.a(r103.getFirstIconUrl());
        TextView r112 = (TextView) this.f150633d.a(new r(this));
        r112.setText(r108);
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if ((r113 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r105 = r113;
    L58:
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r105;
        if (r114 == null) goto L64;
        if (r109 == false) goto L62;
        int r115 = 0;
    L63:
        r114.leftMargin = r115;
        goto L64
    L62:
        r115 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L64:
        addView(r112);
    L65:
        r100 = r102;
        goto L6
    L35:
        if (r104.getTextSplitorStyle() != 2) goto L44;
        if (r100 <= 0) goto L38;
        TextView r116 = (TextView) this.f150633d.a(new q(this));
        int r117 = com.bytedance.android.ec.core.utils.s.f45717a;
        r116.setTextColor(com.bytedance.android.ec.core.utils.s.a(r104.getTextColor(), th.a.a(r116.getContext(), R.color.shopping_std_text_black_3)));
        addView(r116);
    L38:
        ECUrlModel r118 = r103.getTextIcon();
        if (r118 == null) goto L41;
        addView(b(r118, false, cg4.a.a(r103.getFirstText())));
    L41:
        String r119 = r103.getFirstText();
        if (r119 == null) goto L65;
        TextView r120 = (TextView) this.f150633d.a(new t(this));
        r120.setText(r119);
        int r121 = com.bytedance.android.ec.core.utils.s.f45717a;
        r120.setTextColor(com.bytedance.android.ec.core.utils.s.a(r104.getTextColor(), th.a.a(r120.getContext(), R.color.shopping_std_text_black_3)));
        addView(r120);
        goto L65
    L13:
        if (r104.getTextSplitorStyle() != 0) goto L33;
        ECUrlModel r122 = r103.getTextIcon();
        if (r122 == null) goto L20;
        if (r100 == 0) goto L18;
        boolean r123 = true;
    L19:
        addView(b(r122, r123, cg4.a.a(r103.getFirstText())));
        goto L20
    L18:
        r123 = false;
    L20:
        String r124 = r103.getFirstText();
        if (r124 == null) goto L65;
        View r125 = this.f150633d.a(new s(this));
        TextView r126 = (TextView) r125;
        r126.setText(r124);
        ViewGroup.LayoutParams r127 = r126.getLayoutParams();
        if ((r127 instanceof LinearLayout.LayoutParams) == false) goto L26;
        r105 = r127;
    L26:
        LinearLayout.LayoutParams r128 = (LinearLayout.LayoutParams) r105;
        if (r128 == null) goto L32;
        if (r100 <= 0) goto L30;
        int r129 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L31:
        r128.leftMargin = r129;
        goto L32
    L30:
        r129 = 0;
    L32:
        int r130 = com.bytedance.android.ec.core.utils.s.f45717a;
        r126.setTextColor(com.bytedance.android.ec.core.utils.s.a(r104.getTextColor(), th.a.a(r126.getContext(), R.color.shopping_std_text_black_3)));
        GradientDrawable r131 = new GradientDrawable();
        r131.setCornerRadius(UtilityKotlinExtentionsKt.c(3));
        r131.setColor(com.bytedance.android.ec.core.utils.s.a(r104.getTextBgColor(), th.a.a(r126.getContext(), R.color.transparent)));
        r131.setStroke(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), com.bytedance.android.ec.core.utils.s.a(r104.getTextBorderColor(), th.a.a(r126.getContext(), R.color.transparent)));
        Unit r132 = Unit.INSTANCE;
        r126.setBackgroundDrawable(r131);
        addView(r125);
        goto L65
    L67:
        if (getChildCount() <= 0) goto L78;
        addView(new Space(getContext()), new LinearLayout.LayoutParams(1, 0));
        return;
    L78:
        return;
    }

    public final void a(List<ECRitTag> r100, com.bytedance.android.livesdk.livecommerce.promotion.card.k r101) {
        Intrinsics.checkNotNullParameter(r100, "tagList");
        Intrinsics.checkNotNullParameter(r101, "uiConfig");
        this.f150631b = new StringBuilder();
        this.f150632c = r101;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L13;
        setUserRightsAssuranceTagArea(r100);
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        RitTagTrack r103 = ((ECRitTag) r102.next()).getTagTrack();
        if (r103 == null) goto L9;
        r103.setVisibile(true);
        goto L9
    L19:
        return;
    }

    public ECUserRightsTagWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150633d = new fj2.b();
        setGravity(8388627);
        setOrientation(0);
    }

    public final View b(ECUrlModel r100, boolean r101, boolean r102) {
        View r103 = this.f150633d.a(new b(this));
        ECDraweeView r104 = (ECDraweeView) r103;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r105 = null;
    L5:
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        if (r106 == null) goto L15;
        int r107 = 0;
        if (r102 == false) goto L10;
        int r108 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L11:
        r106.rightMargin = r108;
        if (r101 == false) goto L14;
        r107 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L14:
        r106.leftMargin = r107;
        goto L15
    L10:
        r108 = 0;
    L15:
        String r109 = r100.getFirstUrl();
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        y.g(r104, r109, UtilityKotlinExtentionsKt.d(Integer.valueOf(r100.getWidth())), UtilityKotlinExtentionsKt.d(Integer.valueOf(r100.getHeight())));
        return r103;
    }

    public /* synthetic */ ECUserRightsTagWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getChildCount() - 1;
    L3:
        if (r105 < 0) goto L19;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() == 8) goto L12;
        if ((r106.getLeft() + r106.getMeasuredWidth()) < getMeasuredWidth()) goto L10;
        r106.layout(r101, r102, r101, r104);
        goto L12
    L10:
        if (Intrinsics.areEqual(r106.getTag(), ItemStyle.ITEM_STYLE_DIVIDER) == false) goto L13;
        r106.layout(r101, r102, r101, r104);
        return;
    L13:
        return;
    L12:
        r105 = r105 - 1;
        goto L3
    }
}
