package com.bytedance.android.livesdk.livecommerce.playback.bottom;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.widget.VideoPlaybackSeekBar;
import com.bytedance.android.ui.base.widget.button.CornersButton;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import ej2.b;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackBottomPresenter extends QFragmentPresenter implements SeekBar.OnSeekBarChangeListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExplainPlaybackVideoViewModel f149793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f149794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f149795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f149796i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlaybackSeekBar f149797a;

        public a(VideoPlaybackSeekBar r100) {
            this.f149797a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoPlaybackSeekBar r100 = this.f149797a;     // Catch: Throwable -> L9
            Object r101 = r100.getParent();     // Catch: Throwable -> L9
            if ((r101 instanceof View) == true) goto L5;
            r101 = null;
        L5:
            View r102 = (View) r101;     // Catch: Throwable -> L9
            if (r102 == null) goto L12;
            r102.setOnTouchListener(new b(r100));     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public ExplainPlaybackBottomPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149795h = LazyKt.lazy(new ExplainPlaybackBottomPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f149793f = (ExplainPlaybackVideoViewModel) Y().g(ExplainPlaybackVideoViewModel.class);
        final VideoPlaybackSeekBar r101 = (VideoPlaybackSeekBar) Z().b(R.id.commerce_playback_video_seekbar).f();
        ExplainPlaybackVideoViewModel r102 = this.f149793f;
        if (r102 == null) goto L5;
        c.a(r102, g.a(Y()), ExplainPlaybackBottomPresenter$onBind$1.INSTANCE, new ExplainPlaybackBottomPresenter$onBind$2(this, r101));
    L5:
        ExplainPlaybackVideoViewModel r103 = this.f149793f;
        if (r103 == null) goto L8;
        c.a(r103, g.a(Y()), ExplainPlaybackBottomPresenter$onBind$3.INSTANCE, new ExplainPlaybackBottomPresenter$onBind$4(this, r101));
    L8:
        r101.setOnSeekBarChangeListener(this);
        r101.post(new a(r101));
        final CornersButton r104 = (CornersButton) Z().b(R.id.tv_speed).f();
        f.c(r104, 500L, null, new ExplainPlaybackBottomPresenter$bindSpeedView$1(this), 2);
        ExplainPlaybackVideoViewModel r105 = this.f149793f;
        if (r105 != null) goto L11;
    L13:
        r104.setVisibility(8);
    L14:
        ExplainPlaybackVideoViewModel r106 = this.f149793f;
        if (r106 == null) goto L17;
        c.a(r106, g.a(Y()), ExplainPlaybackBottomPresenter$bindSpeedView$2.INSTANCE, new ExplainPlaybackBottomPresenter$bindSpeedView$3(this, r104));
    L17:
        c.a((ExplainPlaybackViewModel) this.f149795h.getValue(), g.a(Y()), ExplainPlaybackBottomPresenter$bindBottomEnterLiveView$1.INSTANCE, new ExplainPlaybackBottomPresenter$bindBottomEnterLiveView$2(this));
        return;
    L11:
        if (r105.isSpeedEnableAB() != true) goto L13;
        r104.setVisibility(0);
        goto L14
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar r100) {
        this.f149794g = true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar r100) {
        ExplainPlaybackVideoViewModel r101 = this.f149793f;
        if (r101 == null) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(r101, com.bytedance.android.livesdk.livecommerce.playback.video.a.e.f150004a);
    L5:
        ExplainPlaybackVideoViewModel r102 = this.f149793f;
        if (r102 != null) goto L8;
    L12:
        cj2.c r103 = cj2.a.f23945a;
        HashMap r104 = new HashMap();
        r104.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD);
        cj2.a.a("livesdk_explain_replay_schedule_use", r104, null, null);
        this.f149794g = false;
        return;
    L8:
        if (r100 == null) goto L10;
        float r105 = r100.getProgress();
    L11:
        com.bytedance.android.ec.core.arch.event.c.d(r102, new com.bytedance.android.livesdk.livecommerce.playback.video.a.f(r105));
        goto L12
    L10:
        r105 = 0.0f;
        goto L11
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L11;
        ExplainPlaybackVideoViewModel r103 = this.f149793f;
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.livecommerce.playback.video.b r104 = r103.getState();
        if (r104 == null) goto L13;
        Integer r105 = r104.f150007b;
        if (r105 == null) goto L14;
        r105.intValue();
        TextView r106 = (TextView) Z().b(R.id.commerce_playback_tv_video_curtime).f();
        int r107 = ExplainPlaybackUtils.f149977a;
        r106.setText(ExplainPlaybackUtils.c(Y().c(), r101));
        ((VideoPlaybackSeekBar) Z().b(R.id.commerce_playback_video_seekbar).f()).setProgress(r101);
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}
