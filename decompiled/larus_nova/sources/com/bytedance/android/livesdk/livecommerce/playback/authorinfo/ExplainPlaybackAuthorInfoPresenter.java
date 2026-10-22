package com.bytedance.android.livesdk.livecommerce.playback.authorinfo;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackAuthorInfoPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149785f;

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f149785f.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "onUnBind");
    }

    public ExplainPlaybackAuthorInfoPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149785f = LazyKt.lazy(new ExplainPlaybackAuthorInfoPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "onBind");
        com.bytedance.android.livesdk.livecommerce.playback.main.b r101 = d0().getExplainPlaybackOriginParams();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L7;
        LogExtraData r103 = r101.f149932d;
        if (r103 == null) goto L7;
        String r104 = r103.getEnterScene();
    L9:
        if (ExplainPlaybackUtils.d() == true) goto L11;
    L14:
        final FrameLayout r105 = (FrameLayout) Z().b(R.id.commerce_video_playback_author_info_layout).f();
        if (ExplainPlaybackUtils.e(r104) == true) goto L24;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == false) goto L21;
        r102 = r106;
    L21:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r102;
        if (r107 == null) goto L24;
        r107.width = -1;
        r107.topMargin = (int) UtilityKotlinExtentionsKt.c(8);
        r105.setLayoutParams(r107);
    L24:
        com.bytedance.android.ec.core.arch.state.c.a(d0(), g.a(Y()), ExplainPlaybackAuthorInfoPresenter$onBind$1.INSTANCE, new ExplainPlaybackAuthorInfoPresenter$onBind$2(this, r105));
        if (ExplainPlaybackUtils.e(r104) == true) goto L28;
        com.bytedance.android.ec.core.arch.state.c.a(d0(), g.a(Y()), ExplainPlaybackAuthorInfoPresenter$onBind$3.INSTANCE, new ExplainPlaybackAuthorInfoPresenter$onBind$4(this, r105));
        return;
    L28:
        return;
    L11:
        if (ExplainPlaybackUtils.e(r104) == true) goto L14;
        bj2.a.b("ExplainPlaybackAuthorInfoPresenter", "IsExpireZero or equals search");
        return;
    L7:
        r104 = null;
        goto L9
    }
}
