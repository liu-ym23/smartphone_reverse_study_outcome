package com.bytedance.android.livesdk.player.extrarender;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.share.QzonePublish;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ExtraRenderView extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f155220d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f155221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ILivePlayerExtraRenderController f155223c;

    private final TextureRenderView getRenderView() {
        return (TextureRenderView) this.f155221a.getValue();
    }

    public final FrameLayout getRenderViewWrapper() {
        return (FrameLayout) this.f155222b.getValue();
    }

    public final void a() {
        if (Intrinsics.areEqual(getRenderView().getParent(), getRenderViewWrapper()) == false) goto L5;
        return;
    L5:
        getRenderViewWrapper().addView(getRenderView());
    }

    public final ILivePlayerExtraRenderController getRenderController() {
        return this.f155223c;
    }

    public final void setScaleType(int r100) {
        getRenderView().setScaleType(r100);
    }

    public final void setVideoSize(Pair<Integer, Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        getRenderView().setVideoSize(r100.getFirst().intValue(), r100.getSecond().intValue());
    }

    public ExtraRenderView(final Context r100, ILivePlayerExtraRenderController r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "renderController");
        super(r100);
        this.f155223c = r101;
        this.f155221a = LazyKt.lazy(new ExtraRenderView$renderView$2(this));
        this.f155222b = LazyKt.lazy(new ExtraRenderView$renderViewWrapper$2(r100));
        setId(R.id.ttlive_player_extra_render_view);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -1);
        r102.gravity = 85;
        Unit r103 = Unit.INSTANCE;
        setLayoutParams(r102);
        setOrientation(!r101.isGameRoom() ? 1 : 0);
        addView(getRenderViewWrapper());
        getRenderViewWrapper().addView(getRenderView());
        FrameLayout r104 = getRenderViewWrapper();
        r104.setOutlineProvider(new c(this));
        r104.setClipToOutline(true);
    }
}
