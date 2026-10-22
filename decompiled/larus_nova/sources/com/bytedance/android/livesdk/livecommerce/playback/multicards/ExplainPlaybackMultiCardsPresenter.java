package com.bytedance.android.livesdk.livecommerce.playback.multicards;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.playback.AuthorInfo;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.model.ExplainPlaybackFinalParams;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackMultiCardsPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f149958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public tk.a f149959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f149960h;

    public final ExplainPlaybackViewModel e0() {
        return (ExplainPlaybackViewModel) this.f149960h.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        tk.a r100 = this.f149959g;
        if (r100 == null) goto L5;
        r100.onUnload();
    L5:
        this.f149959g = null;
    }

    public ExplainPlaybackMultiCardsPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149960h = LazyKt.lazy(new ExplainPlaybackMultiCardsPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        FrameLayout r101 = (FrameLayout) Z().b(R.id.fl_multi_card_view_container_layout).f();
        this.f149958f = r101;
        r101.setVisibility(0);
        com.bytedance.android.ec.core.arch.state.c.a(e0(), g.a(Y()), ExplainPlaybackMultiCardsPresenter$onBind$1.INSTANCE, new ExplainPlaybackMultiCardsPresenter$onBind$2(this));
    }

    public final Map<String, String> d0(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        ExplainPlaybackFinalParams r102 = e0().getExplainPlaybackFinalFinalParams();
        if (r102 == null) goto L9;
        Serializable r103 = r102.getUserInfo();
        if (r103 == null) goto L9;
        if ((r103 instanceof AuthorInfo) == false) goto L9;
        r101.put("follow_status", String.valueOf(((AuthorInfo) r103).getFollowStatus()));
    L9:
        if (r100 == null) goto L13;
        JSONObject r104 = com.bytedance.android.livesdk.livecommerce.playback.main.c.c(r100);
        if (r104 == null) goto L13;
        r101.putAll(z1.j(r104));
    L13:
        return r101;
    }
}
