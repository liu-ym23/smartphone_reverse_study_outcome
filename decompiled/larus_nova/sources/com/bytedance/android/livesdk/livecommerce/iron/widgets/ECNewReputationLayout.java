package com.bytedance.android.livesdk.livecommerce.iron.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.livesdk.livecommerce.event.e2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tB'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0011\u001a\n \b*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0014\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\fR#\u0010\u0017\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/widgets/ECNewReputationLayout;", "Landroid/widget/LinearLayout;", "", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionList$d;", "authorReputation", "", "setReputationInfo", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getDescribeTV", "()Landroid/widget/TextView;", "describeTV", "b", "getScoreGroup", "()Landroid/widget/LinearLayout;", "scoreGroup", "c", "getScoreTV", "scoreTV", "d", "getLevelTV", "levelTV", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewReputationLayout extends LinearLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer[] f149113e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer[] f149114f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer[] f149115g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer[] f149116h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f149117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f149118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f149119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f149120d;

    public static final class a {
    }

    public ECNewReputationLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNewReputationLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getDescribeTV() {
        return (TextView) this.f149117a.getValue();
    }

    private final TextView getLevelTV() {
        return (TextView) this.f149120d.getValue();
    }

    private final LinearLayout getScoreGroup() {
        return (LinearLayout) this.f149118b.getValue();
    }

    private final TextView getScoreTV() {
        return (TextView) this.f149119c.getValue();
    }

    static {
        f149113e = new Integer[]{Integer.valueOf(R.drawable.ec_bg_high_reputation_border), Integer.valueOf(R.drawable.ec_bg_middle_repuation_border), Integer.valueOf(R.drawable.ec_bg_low_repuation_border), Integer.valueOf(R.drawable.ec_bg_no_data_repuation_border)};
        f149114f = new Integer[]{Integer.valueOf(R.color.ec_color_pink_fe2c55), Integer.valueOf(R.color.ec_color_FF7629), Integer.valueOf(R.color.ec_color_35B569), Integer.valueOf(R.color.shopping_color_99161823)};
        f149115g = new Integer[]{Integer.valueOf(R.string.ec_author_reputation_high), Integer.valueOf(R.string.ec_author_reputation_medium), Integer.valueOf(R.string.ec_author_reputation_low), Integer.valueOf(R.string.ec_author_reputation_no_data)};
        f149116h = new Integer[]{Integer.valueOf(R.drawable.bg_author_reputation_level_high), Integer.valueOf(R.drawable.bg_author_reputation_level_middle), Integer.valueOf(R.drawable.bg_author_reputation_level_low_new), Integer.valueOf(R.drawable.bg_author_reputation_level_no_data)};
    }

    public void setReputationInfo(ECPromotionList.d r110) {
        if (r110 == null) goto L20;
        StringBuilder r100 = new StringBuilder();
        getDescribeTV().setText(r110.text);
        r100.append(r110.text);
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;
        int r102 = 0;
        String r103 = String.format(Locale.getDefault(), "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r110.score)}, 1));
        getScoreTV().setText(r103);
        int r104 = r110.level;
        if (1 > r104) goto L10;
        if (3 < r104) goto L10;
        if (r110.score <= 0) goto L10;
        int r105 = r104 - 1;
    L11:
        TextView r111 = getScoreTV();
        if (r105 != 3) goto L14;
        r102 = 8;
    L15:
        r111.setVisibility(r102);
        int r112 = th.a.a(getContext(), f149114f[r105].intValue());
        Typeface r106 = ECFontHelper.f45592e.b("DouyinNumberABC", 500, true);
        if (r106 == null) goto L18;
        getScoreTV().setTypeface(r106);
    L18:
        String r107 = getResources().getString(f149115g[r105].intValue());
        r100.append(r107);
        getLevelTV().setText(r107);
        getScoreGroup().setBackgroundResource(f149116h[r105].intValue());
        getScoreTV().setTextColor(r112);
        getDescribeTV().setTextColor(r112);
        getLevelTV().setTextColor(r112);
        setBackgroundResource(f149113e[r105].intValue());
        setContentDescription(r100.toString());
        new e2().k();
        return;
    L14:
        r100.append(r103);
    L10:
        r105 = 3;
        goto L11
    }

    public ECNewReputationLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f149117a = LazyKt.lazy(new ECNewReputationLayout$describeTV$2(this));
        this.f149118b = LazyKt.lazy(new ECNewReputationLayout$scoreGroup$2(this));
        this.f149119c = LazyKt.lazy(new ECNewReputationLayout$scoreTV$2(this));
        this.f149120d = LazyKt.lazy(new ECNewReputationLayout$levelTV$2(this));
        th.a.c(r100, R.layout.ec_author_reputation_layout, this, true);
    }

    public /* synthetic */ ECNewReputationLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
