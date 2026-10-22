package com.bytedance.android.shopping.feed.resourcecard.view.countdownview;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ActivityCountDownTimer;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B%\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b \u0010!J\b\u0010\u0004\u001a\u00020\u0003H&R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001b\u0010\u001a\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/countdownview/BaseCountDownView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "", "getLayout", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvHours", "()Landroid/widget/TextView;", "setTvHours", "(Landroid/widget/TextView;)V", "tvHours", "b", "getTvMins", "setTvMins", "tvMins", "c", "getTvSecs", "setTvSecs", "tvSecs", "Lcom/bytedance/android/ec/core/utils/ActivityCountDownTimer;", "d", "Lkotlin/Lazy;", "getCountDownTimer", "()Lcom/bytedance/android/ec/core/utils/ActivityCountDownTimer;", "countDownTimer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCountDownView extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f175356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f175357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f175358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f175359d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f175360e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a f175361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f175362g;

    public static final class a {
    }

    public static final class b implements l1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseCountDownView f175363a;

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onStart() {
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onFinish() {
            com.bytedance.android.shopping.feed.resourcecard.view.countdownview.a r100 = this.f175363a.f175361f;
            if (r100 == null) goto L6;
            r100.a();
            return;
        }

        public b(BaseCountDownView r100) {
            this.f175363a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.l1.a
        public final void onTick(long r100) {
            this.f175363a.e(r100);
        }
    }

    static {
    }

    public final ActivityCountDownTimer getCountDownTimer() {
        return (ActivityCountDownTimer) this.f175359d.getValue();
    }

    public abstract int getLayout();

    public final void d() {
        Long r100 = this.f175360e;
        if (r100 == null) goto L6;
        long r101 = r100.longValue();
        ActivityCountDownTimer.b(getCountDownTimer(), SystemClock.elapsedRealtime() / 1000, (SystemClock.elapsedRealtime() / 1000) + r101, this.f175362g);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCountDownTimer().c();
    }

    public final TextView getTvHours() {
        return this.f175356a;
    }

    public final TextView getTvMins() {
        return this.f175357b;
    }

    public final TextView getTvSecs() {
        return this.f175358c;
    }

    public void e(long r100) {
        long r101 = r100 / 1000;
        if (r101 <= 0) goto L14;
        TextView r102 = this.f175356a;
        if (r102 == null) goto L7;
        r102.setText(String.valueOf(r101 / ((long) AnnouncementViewModel.HOUR_DURATION)));
    L7:
        TextView r103 = this.f175357b;
        if (r103 == null) goto L10;
        r103.setText(String.valueOf((r101 % ((long) AnnouncementViewModel.HOUR_DURATION)) / ((long) 60)));
    L10:
        TextView r104 = this.f175358c;
        if (r104 == null) goto L15;
        r104.setText(String.valueOf((r101 % ((long) AnnouncementViewModel.HOUR_DURATION)) % ((long) 60)));
        return;
    L15:
        return;
    }

    public final void setTvHours(TextView r100) {
        this.f175356a = r100;
    }

    public final void setTvMins(TextView r100) {
        this.f175357b = r100;
    }

    public final void setTvSecs(TextView r100) {
        this.f175358c = r100;
    }

    public BaseCountDownView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f175359d = LazyKt.lazy(BaseCountDownView$countDownTimer$2.INSTANCE);
        this.f175362g = new b(this);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(getLayout(), this, true);
        this.f175356a = (TextView) findViewById(R.id.tv_hours);
        this.f175357b = (TextView) findViewById(R.id.tv_mins);
        this.f175358c = (TextView) findViewById(R.id.tv_secs);
    }
}
