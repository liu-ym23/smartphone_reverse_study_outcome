package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.event.e2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECFlagShipReputationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "authorReputation", "", "setReputationInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFlagShipReputationView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECDraweeView f149108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECDraweeView f149109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f149110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f149111d;

    public static final class a {
    }

    public static final class b extends MetricAffectingSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f149112a;

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Typeface r101 = ECFontHelper.f45592e.b("DouyinNumberABC", 500, true);
            if (r101 != null) goto L5;
            r101 = Typeface.DEFAULT;
        L5:
            this.f149112a = r101;
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            if (r100 == null) goto L5;
            r100.setTypeface(this.f149112a);
            return;
        }

        @Override // android.text.style.MetricAffectingSpan
        public final void updateMeasureState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "textPaint");
            r100.setTypeface(this.f149112a);
        }
    }

    static {
    }

    public ECFlagShipReputationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECFlagShipReputationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public void setReputationInfo(final ECPromotionList.d r110) {
        if (r110 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        ECRitTag r100 = r110.shopTag;
        Long r101 = null;
        if (r100 == null) goto L16;
        ECUrlModel r102 = r100.getIconUrlModel();
        h0.d(this.f149108a, r102, null, null, null, null, null, 120);
        if (r102 == null) goto L11;
        Integer r103 = Integer.valueOf(r102.getWidth());
    L12:
        if (r102 == null) goto L14;
        Integer r104 = Integer.valueOf(r102.getHeight());
    L15:
        R5(r103, r104, new ECFlagShipReputationView$setReputationInfo$$inlined$let$lambda$1(this, r110));
    L17:
        ECPromotionList.e r105 = r110.scoreContent;
        if (r105 == null) goto L52;
        h0.d(this.f149109b, r105.background, null, null, null, null, null, 120);
        ECUrlModel r106 = r105.background;
        if (r106 == null) goto L22;
        Integer r107 = Integer.valueOf(r106.getWidth());
    L23:
        ECUrlModel r108 = r105.background;
        if (r108 == null) goto L26;
        Integer r109 = Integer.valueOf(r108.getHeight());
    L27:
        R5(r107, r109, new ECFlagShipReputationView$setReputationInfo$$inlined$let$lambda$2(this, r110));
        TextView r111 = this.f149110c;
        int r112 = s.f45717a;
        Integer r113 = s.b(r105.textColor);
        if (r113 == null) goto L30;
        int r114 = r113.intValue();
    L31:
        Long r115 = Long.valueOf(r105.fontSize);
        if (r115.longValue() <= 0) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L37;
        r101 = r115;
    L37:
        if (r101 == null) goto L39;
        float r117 = r101.longValue();
    L41:
        if (r110.score <= 0) goto L46;
        String r118 = r105.text;
        if (r118 != null) goto L45;
        r118 = "";
    L45:
        SpannableStringBuilder r119 = new SpannableStringBuilder();
        b r120 = new b(getContext());
        AbsoluteSizeSpan r121 = new AbsoluteSizeSpan(UtilityKotlinExtentionsKt.d(Float.valueOf(r117)));
        ForegroundColorSpan r122 = new ForegroundColorSpan(r114);
        r119.append(r118);
        r119.setSpan(r121, 0, r119.length(), 18);
        r119.setSpan(r120, 0, r119.length(), 18);
        r119.setSpan(r122, 0, r119.length(), 18);
        this.f149111d.setColorFilter(r114);
        r111.setText(r119);
        this.f149111d.setVisibility(0);
    L51:
        setContentDescription(r105.text);
        goto L52
    L46:
        r111.setText(r105.text);
        r111.setTextSize(r117);
        r111.setTextColor(r114);
        if (r105.isBold == false) goto L49;
        Typeface r123 = Typeface.DEFAULT_BOLD;
    L50:
        r111.setTypeface(r123);
        this.f149111d.setVisibility(8);
        goto L51
    L49:
        r123 = Typeface.DEFAULT;
        goto L50
    L39:
        r117 = 10.0f;
        goto L41
    L34:
        r116 = false;
        goto L35
    L30:
        int r124 = g1.f45599a;
        r114 = g1.a.a(r111.getContext(), R.color.commerce_color_80161823);
        goto L31
    L26:
        r109 = null;
        goto L27
    L22:
        r107 = null;
    L52:
        new e2().k();
        return;
    L14:
        r104 = null;
        goto L15
    L11:
        r103 = null;
        goto L12
    L16:
        this.f149108a.setVisibility(8);
        goto L17
    }

    public ECFlagShipReputationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        th.a.c(r100, R.layout.ec_flagship_reputation_layout, this, true);
        this.f149108a = (ECDraweeView) findViewById(R.id.iv_shop_tag);
        this.f149109b = (ECDraweeView) findViewById(R.id.iv_score_bg);
        this.f149110c = (TextView) findViewById(R.id.tv_reputation_score);
        this.f149111d = (ImageView) findViewById(R.id.iv_fen_character);
    }

    public static void R5(Integer r100, Integer r101, Function2 r102) {
        int r103 = 0;
        if (r101 != null) goto L5;
    L16:
        r102.invoke(0, 0);
        return;
    L5:
        if (r101.intValue() == 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L16;
        float r105 = 16.0f / r101.intValue();
        if (r100 == null) goto L15;
        r103 = r100.intValue();
    L15:
        r102.invoke(Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(r105 * r103))), Integer.valueOf(UtilityKotlinExtentionsKt.d(Float.valueOf(16.0f))));
        return;
    L7:
        r104 = false;
        goto L8
    }

    public /* synthetic */ ECFlagShipReputationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
