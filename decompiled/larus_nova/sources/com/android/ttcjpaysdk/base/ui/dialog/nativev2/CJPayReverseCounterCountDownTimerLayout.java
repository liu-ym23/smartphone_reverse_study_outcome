package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayFontUtils;
import com.android.ttcjpaysdk.base.utils.CJPayCountDownTimeUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayReverseCounterCountDownTimerLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "countDownKeyPrefix", "", "currentKey", "millisText", "Landroid/widget/TextView;", "getMillisText", "()Landroid/widget/TextView;", "minuteText", "getMinuteText", "secondText", "getSecondText", "release", "", "startCountDown", "countDown", "", "onFinished", "Lkotlin/Function0;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayReverseCounterCountDownTimerLayout extends RelativeLayout {
    private final String countDownKeyPrefix;
    private String currentKey;
    private final TextView millisText;
    private final TextView minuteText;
    private final TextView secondText;

    public final void release() {
        CJPayCountDownTimeUtil.getInstance().cancel(this.currentKey);
    }

    public final TextView getMillisText() {
        return this.millisText;
    }

    public final TextView getMinuteText() {
        return this.minuteText;
    }

    public final TextView getSecondText() {
        return this.secondText;
    }

    public CJPayReverseCounterCountDownTimerLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_reverse_counter_count_down_timer, this, true);
        TextView r102 = (TextView) findViewById(R.id.count_down_minutes);
        CJPayFontUtils.setDouYinMediumTypeface(r100, r102);
        this.minuteText = r102;
        TextView r103 = (TextView) findViewById(R.id.count_down_second);
        CJPayFontUtils.setDouYinMediumTypeface(r100, r103);
        this.secondText = r103;
        TextView r104 = (TextView) findViewById(R.id.count_down_mills);
        CJPayFontUtils.setDouYinMediumTypeface(r100, r104);
        this.millisText = r104;
        this.countDownKeyPrefix = "cj_pay_reverse_counter_count_down";
        this.currentKey = "";
    }

    public final void startCountDown(int r100, final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "onFinished");
        CJPayCountDownTimeUtil.OnTickListener r101 = new CJPayReverseCounterCountDownTimerLayout$startCountDown$onTickListener$1(this, r110);
        this.currentKey = this.countDownKeyPrefix + '_' + System.currentTimeMillis();
        CJPayCountDownTimeUtil.getInstance().putCountDownTimer(this.currentKey, ((long) r100) * ((long) 1000), 10, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startCountDown$default(CJPayReverseCounterCountDownTimerLayout r100, int r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 60;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = AnonymousClass1.INSTANCE;
    L8:
        r100.startCountDown(r101, r102);
    }
}
