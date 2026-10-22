package com.bytedance.android.livesdk.livecommerce.promotion.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R#\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/card/view/CountDownView;", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getHoursTextView", "()Landroid/widget/TextView;", "hoursTextView", "b", "getMinsTextView", "minsTextView", "c", "getSecTextView", "secTextView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountDownView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f150385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f150386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f150387c;

    public CountDownView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountDownView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getHoursTextView() {
        return (TextView) this.f150385a.getValue();
    }

    private final TextView getMinsTextView() {
        return (TextView) this.f150386b.getValue();
    }

    private final TextView getSecTextView() {
        return (TextView) this.f150387c.getValue();
    }

    public final void a(long r100) {
        double r101 = r100;
        if (r101 <= 0) goto L5;
        int r102 = (int) (r101 / ((double) BaseConstants.Time.HOUR));
        double r103 = r101 - ((double) (BaseConstants.Time.HOUR * r102));
        int r104 = (int) (r103 / ((double) 60000));
        int r105 = (int) ((r103 - ((double) (60000 * r104))) / ((double) 1000));
    L6:
        getHoursTextView().setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r102)}));
        getMinsTextView().setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r104)}));
        getSecTextView().setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r105)}));
        return;
    L5:
        r105 = 0;
        r102 = 0;
        r104 = 0;
        goto L6
    }

    public final void b(k r100) {
        Intrinsics.checkNotNullParameter(r100, "vO");
        int r101 = s.f45717a;
        int r102 = s.a(r100.e(), -1);
        getHoursTextView().setTextColor(r102);
        getMinsTextView().setTextColor(r102);
        getSecTextView().setTextColor(r102);
        TextView r103 = (TextView) findViewById(R.id.tv_colon_1);
        if (r103 == null) goto L5;
        r103.setTextColor(r102);
    L5:
        TextView r104 = (TextView) findViewById(R.id.tv_colon_2);
        if (r104 == null) goto L9;
        r104.setTextColor(r102);
        return;
    }

    public final void c(IPromotionUIConfig.b r100) {
        int r101 = UIConfigHelper.f150297a;
        UIConfigHelper.c(getHoursTextView(), r100);
        UIConfigHelper.c(getMinsTextView(), r100);
        UIConfigHelper.c(getSecTextView(), r100);
    }

    public CountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150385a = LazyKt.lazy(new CountDownView$hoursTextView$2(this));
        this.f150386b = LazyKt.lazy(new CountDownView$minsTextView$2(this));
        this.f150387c = LazyKt.lazy(new CountDownView$secTextView$2(this));
        LinearLayout.inflate(r100, R.layout.ec_countdown_layout, this);
        setGravity(16);
    }

    public /* synthetic */ CountDownView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
