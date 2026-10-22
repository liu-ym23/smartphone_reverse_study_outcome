package com.bytedance.android.ec.store.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\b\u0010\u0005\u001a\u00020\u0004H\u0002J)\u0010\r\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J)\u0010\u000f\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\u0006R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/bytedance/android/ec/store/view/ECShopProgressBarView;", "Landroid/widget/LinearLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "", "getSpeedText", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "speed", "", "listener", "setSpeedButtonClickListener", "progress", "setSeekBarChangeListener", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getCurrentTimeView", "()Landroid/widget/TextView;", "setCurrentTimeView", "(Landroid/widget/TextView;)V", "currentTimeView", "b", "getTotalTimeView", "setTotalTimeView", "totalTimeView", "Lcom/bytedance/android/ec/store/view/ECShopVideoPlaySeekBar;", "c", "Lcom/bytedance/android/ec/store/view/ECShopVideoPlaySeekBar;", "getSeekBar", "()Lcom/bytedance/android/ec/store/view/ECShopVideoPlaySeekBar;", "setSeekBar", "(Lcom/bytedance/android/ec/store/view/ECShopVideoPlaySeekBar;)V", "seekBar", "Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "d", "Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "getSpeedButton", "()Lcom/bytedance/android/ui/base/widget/button/CornersButton;", "setSpeedButton", "(Lcom/bytedance/android/ui/base/widget/button/CornersButton;)V", "speedButton", "e", "Ljava/lang/String;", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "videoId", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopProgressBarView extends LinearLayout implements LifecycleObserver, SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f48802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f48803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ECShopVideoPlaySeekBar f48804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CornersButton f48805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f48807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f48808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super Float, Unit> f48809h;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopProgressBarView f48810a;

        public b(ECShopProgressBarView r100) {
            this.f48810a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECShopVideoPlaySeekBar r100 = this.f48810a.getSeekBar();     // Catch: Throwable -> L11
            if (r100 == null) goto L14;
            Object r101 = r100.getParent();     // Catch: Throwable -> L11
            if ((r101 instanceof View) == true) goto L7;
            r101 = null;
        L7:
            View r102 = (View) r101;     // Catch: Throwable -> L11
            if (r102 == null) goto L18;
            r102.setOnTouchListener(new g(r100));     // Catch: Throwable -> L11
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopProgressBarView f48811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f48812b;

        public c(ECShopProgressBarView r100, Function1 r101) {
            this.f48811a = r100;
            this.f48812b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ECShopProgressBarView r101 = this.f48811a;
            float r102 = r101.f48808g;
            float r103 = 1.5f;
            if (r102 != 1.0f) goto L6;
        L9:
            r101.f48808g = r103;
            CornersButton r104 = r101.getSpeedButton();
            if (r104 == null) goto L12;
            r104.setText(ECShopProgressBarView.a(this.f48811a));
        L12:
            this.f48812b.invoke(Float.valueOf(this.f48811a.f48808g));
            return;
        L6:
            if (r102 != 1.5f) goto L8;
            r103 = 2.0f;
            goto L9
        L8:
            r103 = 1.0f;
            goto L9
        }
    }

    static {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
    }

    public final void d() {
        this.f48808g = 1.0f;
        CornersButton r100 = this.f48805d;
        if (r100 == null) goto L6;
        r100.setText(getSpeedText());
        return;
    }

    private final String getSpeedText() {
        return th.a.h(getContext(), R.string.ec_explain_playback_speed, new Object[]{Float.valueOf(this.f48808g)});
    }

    public final TextView getCurrentTimeView() {
        return this.f48802a;
    }

    public final ECShopVideoPlaySeekBar getSeekBar() {
        return this.f48804c;
    }

    public final CornersButton getSpeedButton() {
        return this.f48805d;
    }

    public final TextView getTotalTimeView() {
        return this.f48803b;
    }

    public final String getVideoId() {
        return this.f48806e;
    }

    public ECShopProgressBarView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f48808g = 1.0f;
        LinearLayout.inflate(r100, R.layout.ec_shop_progress_bar, this);
        this.f48804c = (ECShopVideoPlaySeekBar) findViewById(R.id.commerce_playback_video_seekbar);
        this.f48802a = (TextView) findViewById(R.id.commerce_playback_tv_video_curtime);
        this.f48803b = (TextView) findViewById(R.id.commerce_playback_tv_video_duration);
        this.f48805d = (CornersButton) findViewById(R.id.tv_speed);
    }

    public static final /* synthetic */ String a(ECShopProgressBarView r100) {
        return r100.getSpeedText();
    }

    public final void b(com.bytedance.android.shopping.api.video.e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f48806e = r100.f170650a;
        this.f48807f = Long.valueOf(r100.f170651b);
        this.f48808g = 1.0f;
        ECShopVideoPlaySeekBar r101 = this.f48804c;
        if (r101 == null) goto L7;
        r101.setMax((int) r100.f170651b);
    L7:
        TextView r102 = this.f48802a;
        if (r102 == null) goto L10;
        r102.setText(c(getContext(), 0));
    L10:
        TextView r103 = this.f48803b;
        if (r103 == null) goto L13;
        r103.setText(c(getContext(), r100.f170651b));
    L13:
        CornersButton r104 = this.f48805d;
        if (r104 == null) goto L16;
        r104.setText(getSpeedText());
    L16:
        ECShopVideoPlaySeekBar r105 = this.f48804c;
        if (r105 == null) goto L19;
        r105.setOnSeekBarChangeListener(this);
    L19:
        ECShopVideoPlaySeekBar r106 = this.f48804c;
        if (r106 == null) goto L23;
        r106.post(new b(this));
        return;
    }

    public final void setCurrentTimeView(TextView r100) {
        this.f48802a = r100;
    }

    public final void setSeekBar(ECShopVideoPlaySeekBar r100) {
        this.f48804c = r100;
    }

    public final void setSeekBarChangeListener(Function1<? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f48809h = r100;
    }

    public final void setSpeedButton(CornersButton r100) {
        this.f48805d = r100;
    }

    public final void setSpeedButtonClickListener(Function1<? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CornersButton r101 = this.f48805d;
        if (r101 == null) goto L6;
        r101.setOnClickListener(new c(this, r100));
        return;
    }

    public final void setTotalTimeView(TextView r100) {
        this.f48803b = r100;
    }

    public final void setVideoId(String r100) {
        this.f48806e = r100;
    }

    public static String c(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r102 = r101 / ((long) 1000);
        long r103 = 60;
        long r104 = r102 % r103;
        long r105 = (r102 / r103) % r103;
        long r106 = 10;
        if (r104 >= r106) goto L5;
        String r107 = th.a.h(r100, R.string.ec_explain_playback_sec_kill_zero_placeholder, new Object[]{Long.valueOf(r104)});
    L7:
        if (r105 >= r106) goto L9;
        String r108 = th.a.h(r100, R.string.ec_explain_playback_sec_kill_zero_placeholder, new Object[]{Long.valueOf(r105)});
    L14:
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L12
        return String.format(th.a.g(r100, R.string.ec_explain_playback_video_date), Arrays.copyOf(new Object[]{r108, r107}, 2));
    L12:
        return "00:00";
    L9:
        r108 = String.valueOf(r105);
        goto L14
    L5:
        r107 = String.valueOf(r104);
        goto L7
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L14;
        Long r103 = this.f48807f;
        if (r103 == null) goto L15;
        long r104 = r103.longValue();
        TextView r105 = this.f48802a;
        if (r105 == null) goto L8;
        r105.setText(c(getContext(), r101));
    L8:
        if (r100 == null) goto L10;
        r100.setProgress(r101);
    L10:
        Function1<? super Float, Unit> r106 = this.f48809h;
        if (r106 == null) goto L16;
        Unit r107 = r106.invoke(Float.valueOf(r101 / r104));
        return;
    L16:
        return;
    L15:
        return;
    }
}
