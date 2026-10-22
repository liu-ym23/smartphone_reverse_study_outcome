package com.bytedance.android.livesdk.antiaddiction.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0003)\u000bB'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\n¢\u0006\u0004\b'\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getCountdownFormat", "()Ljava/lang/String;", "setCountdownFormat", "(Ljava/lang/String;)V", "countdownFormat", "", "b", "I", "getCountdownStrategy", "()I", "setCountdownStrategy", "(I)V", "getCountdownStrategy$annotations", "()V", "countdownStrategy", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "d", "Lkotlin/Lazy;", "getTimerObserver", "()Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "timerObserver", "Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView$b;", "countdownTimer", "Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView$b;", "getCountdownTimer", "()Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView$b;", "setCountdownTimer", "(Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView$b;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CountdownStrategy", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CountdownTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f103690e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f103691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f103692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f103693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f103694d;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/antiaddiction/view/CountdownTextView$CountdownStrategy;", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public @interface CountdownStrategy {
    }

    public static final class a {
    }

    public static final class b extends CountDownTimer {
    }

    static {
    }

    public CountdownTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CountdownTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @CountdownStrategy
    public static /* synthetic */ void getCountdownStrategy$annotations() {
    }

    private final Observer<Long> getTimerObserver() {
        return (Observer) this.f103694d.getValue();
    }

    public final b getCountdownTimer() {
        return null;
    }

    public final void setCountdownTimer(b r100) {
    }

    public final void x() {
        int r100 = this.f103692b;
        Context r101 = null;
        if (r100 != 0) goto L5;
        Context r102 = getContext();
        if ((r102 instanceof FragmentActivity) == false) goto L12;
        r101 = r102;
    L12:
        FragmentActivity r103 = (FragmentActivity) r101;
        return;
    L5:
        if (r100 != 1) goto L15;
        this.f103693c = null;
        return;
    }

    public final String getCountdownFormat() {
        return this.f103691a;
    }

    public final int getCountdownStrategy() {
        return this.f103692b;
    }

    public final void setCountdownFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f103691a = r100;
    }

    public final void setCountdownStrategy(int r100) {
        this.f103692b = r100;
    }

    public CountdownTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f103691a = "%1$02d:%2$02d:%3$02d";
        this.f103694d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new CountdownTextView$timerObserver$2(this));
    }

    public /* synthetic */ CountdownTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
