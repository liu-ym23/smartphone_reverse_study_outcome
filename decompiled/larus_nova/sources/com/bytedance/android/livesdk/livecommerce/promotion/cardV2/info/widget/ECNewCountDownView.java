package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextPaint;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0006\u0010\b\u001a\u00020\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0019\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/widget/ECNewCountDownView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lq83/a;", "Lkotlin/Function0;", "", "finishAction", "setOnCountFinishCallback", "", "getViewWidth", "Lcom/bytedance/android/ec/model/response/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/ec/model/response/k;", "getCountDown", "()Lcom/bytedance/android/ec/model/response/k;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/k;)V", "countDown", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "b", "Ljava/lang/StringBuilder;", "getStringBuilder", "()Ljava/lang/StringBuilder;", "setStringBuilder", "(Ljava/lang/StringBuilder;)V", "stringBuilder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNewCountDownView extends AppCompatTextView implements q83.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.ec.model.response.k f150608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f150609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f150610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f150611d;

    public final float getViewWidth() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        TextPaint r101 = getPaint();     // Catch: Throwable -> L9
        CharSequence r102 = getText();     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        String r103 = r102.toString();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
    L7:
        Object r104 = Result.m9449constructorimpl(Float.valueOf(r101.measureText(r103)));     // Catch: Throwable -> L9
    L11:
        Float r105 = Float.valueOf(0.0f);
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        r104 = r105;
    L15:
        return ((Number) r104).floatValue();
    L6:
        r103 = "";
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final com.bytedance.android.ec.model.response.k getCountDown() {
        return this.f150608a;
    }

    public final StringBuilder getStringBuilder() {
        return this.f150609b;
    }

    @Override // q83.a
    public final boolean onTick(long r110) {
        com.bytedance.android.ec.model.response.k r100 = this.f150608a;
        if (r100 == null) goto L25;
        long r101 = this.f150611d;
        if (r110 >= r101) goto L22;
        long r102 = r101 - r110;
        String r111 = r100.b();
        String r112 = "";
        if (r111 != null) goto L9;
        r111 = "";
    L9:
        String r103 = r100.d();
        if (r103 == null) goto L13;
        r112 = r103;
    L13:
        StringBuilder r104 = this.f150609b;
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "suffix");
        double r105 = r102;
        if (r105 <= 0) goto L16;
        int r106 = (int) (r105 / ((double) BaseConstants.Time.HOUR));
        double r107 = r105 - ((double) (BaseConstants.Time.HOUR * r106));
        int r108 = (int) (r107 / ((double) 60000));
        int r109 = (int) ((r107 - ((double) (60000 * r108))) / ((double) 1000));
    L17:
        String r113 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r106)});
        String r114 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r108)});
        String r115 = getContext().getString(R.string.ec_promotion_list_time_format, new Object[]{Integer.valueOf(r109)});
        if (r104 == null) goto L20;
        r104.append(r106 + " 小时，" + r108 + " 分钟，" + r109 + " 秒");
    L20:
        setText(r111 + r113 + ':' + r114 + ':' + r115 + r112);
        return true;
    L16:
        r109 = 0;
        r106 = 0;
        r108 = 0;
        goto L17
    L22:
        Function0<Unit> r116 = this.f150610c;
        if (r116 == null) goto L25;
        Unit r117 = r116.invoke();
    L25:
        return false;
    }

    public final void setCountDown(com.bytedance.android.ec.model.response.k r100) {
        this.f150608a = r100;
    }

    public final void setOnCountFinishCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "finishAction");
        this.f150610c = r100;
    }

    public final void setStringBuilder(StringBuilder r100) {
        this.f150609b = r100;
    }

    public ECNewCountDownView(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f150611d = r101;
    }
}
