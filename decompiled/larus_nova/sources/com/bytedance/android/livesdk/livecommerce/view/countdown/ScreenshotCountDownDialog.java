package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.utils.ObservableInterval;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ScreenshotCountDownDialog extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f153206f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f153207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f153208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f153209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f153210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f153211e;

    public static final class a {
    }

    static {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f153208b;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public ScreenshotCountDownDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, R.style.ec_countdown_dialog);
        this.f153210d = ScreenshotCountDownDialog$countDownListener$1.INSTANCE;
        this.f153211e = 3;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-2, -2);
    L5:
        setCancelable(false);
        setContentView(R.layout.ec_countdown_dialog_layout);
        TextView r102 = (TextView) findViewById(R.id.countdown_text);
        this.f153207a = r102;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L8:
        r102.setText(String.valueOf(this.f153211e));
        Disposable r103 = this.f153208b;
        if (r103 == null) goto L11;
        r103.dispose();
    L11:
        this.f153209c = this.f153211e;
        TextView r104 = this.f153207a;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L14:
        r104.setText(String.valueOf(this.f153209c));
        Animation r105 = AnimationUtils.loadAnimation(getContext(), R.anim.ec_count_down);
        this.f153208b = RxJavaPlugins.onAssembly(new ObservableInterval(500, 1000, TimeUnit.MILLISECONDS, Schedulers.io())).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.view.countdown.a(this, r105), b.f153214a);
    }
}
