package com.bytedance.android.shopping.deepfeed.ui.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/ui/view/DeepFeedTypewriterTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedTypewriterTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f173922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f173923b;

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        if (this.f173923b.length() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        setText(this.f173923b);     // Catch: Throwable -> L14
    L9:
        Job r102 = this.f173922a;     // Catch: Throwable -> L14
        Unit r103 = null;
        if (r102 == null) goto L12;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);     // Catch: Throwable -> L14
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L14
        return;
    L6:
        r101 = false;
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public DeepFeedTypewriterTextView(Context r100) {
        this(r100, null);
    }

    public DeepFeedTypewriterTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f173923b = "";
    }

    public static void y(DeepFeedTypewriterTextView r110, String r111, String r112, String r210, Function0 r211) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "prefix");
        Intrinsics.checkNotNullParameter(r112, "boldContent");
        Intrinsics.checkNotNullParameter(r210, "suffix");
        Intrinsics.checkNotNullParameter(HiAnalyticsConstant.REPORT_VAL_SEPARATOR, EffectConfiguration.KEY_CURSOR);
        Job r100 = r110.f173922a;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        r110.setText("");
        String r101 = r111 + r112 + r210;
        r110.f173923b = r101;
        r110.f173922a = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DeepFeedTypewriterTextView$startTypewriter$1(r110, r101, r111.length(), r111.length() + r112.length(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, 60, r211, null), 3, null);
    }

    public static final SpannableStringBuilder x(DeepFeedTypewriterTextView r100, String r101, int r102, int r103, String r104, boolean r105) {
        r100.getClass();
        SpannableStringBuilder r106 = new SpannableStringBuilder(r101);
        int r107 = RangesKt.coerceAtMost(r102, r101.length());
        int r108 = RangesKt.coerceAtMost(r103, r101.length());
        if (r108 <= r107) goto L5;
        r106.setSpan(new z6a.j(-1), r107, r108, 33);
    L5:
        if (r105 == false) goto L7;
        int r109 = r106.length();
        r106.append(r104);
        r106.setSpan(new z6a.j(-1), r109, r106.length(), 33);
    L7:
        return r106;
    }
}
