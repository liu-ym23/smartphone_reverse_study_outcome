package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.l1;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/CouponCountDownView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CouponCountDownView extends LinearLayoutCompat {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f175203g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f175204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f175205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f175206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActivityCountDownTimer f175207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f175208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f175209f;

    public static final class a {
    }

    public static final class b implements l1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CouponCountDownView f175210a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            CouponCountDownView r100 = this.f175210a;
            int r101 = CouponCountDownView.f175203g;
            r100.d(0);
            Function0<Unit> r102 = this.f175210a.f175209f;
            if (r102 == null) goto L6;
            Unit r103 = r102.invoke();
            return;
        }

        public b(CouponCountDownView r100) {
            this.f175210a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r100) {
            CouponCountDownView r101 = this.f175210a;
            int r102 = CouponCountDownView.f175203g;
            r101.d(r100);
        }
    }

    static {
    }

    public CouponCountDownView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CouponCountDownView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void d(long r100) {
        double r101 = r100;
        if (r101 <= 0) goto L5;
        int r102 = (int) (r101 / ((double) BaseConstants.Time.HOUR));
        double r103 = r101 - ((double) (BaseConstants.Time.HOUR * r102));
        int r104 = (int) (r103 / ((double) 60000));
        int r105 = (int) ((r103 - ((double) (60000 * r104))) / ((double) 1000));
    L6:
        TextView r106 = this.f175204a;
        if (r106 == null) goto L9;
        r106.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r102)}));
    L9:
        TextView r107 = this.f175205b;
        if (r107 == null) goto L12;
        r107.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r104)}));
    L12:
        TextView r108 = this.f175206c;
        if (r108 == null) goto L16;
        r108.setText(getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r105)}));
        return;
    L16:
        return;
    L5:
        r105 = 0;
        r102 = 0;
        r104 = 0;
        goto L6
    }

    public CouponCountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_count_down_view, this, true);
        this.f175204a = (TextView) findViewById(R.id.tv_hours);
        this.f175205b = (TextView) findViewById(R.id.tv_mins);
        this.f175206c = (TextView) findViewById(R.id.tv_secs);
        this.f175208e = new b(this);
    }

    public /* synthetic */ CouponCountDownView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
