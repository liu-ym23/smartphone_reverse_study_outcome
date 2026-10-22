package com.bytedance.android.livesdk.player.extrarender;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ExtraRenderShadowInteractView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerExtraRenderController.ClickListener f155213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f155215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RenderDescInfo f155216d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtraRenderShadowInteractView f155217a;

        public a(ExtraRenderShadowInteractView r100) {
            this.f155217a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ILivePlayerExtraRenderController.ClickListener r101 = this.f155217a.getOuterClickListener();
            if (r101 == null) goto L6;
            r101.onDescViewClick(this.f155217a.f155216d);
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExtraRenderShadowInteractView f155218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExtraRenderController f155219b;

        public b(ExtraRenderShadowInteractView r100, ExtraRenderController r101) {
            this.f155218a = r100;
            this.f155219b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f155219b.f155184d.getExtraAreaIsGame() == false) goto L8;
            ILivePlayerExtraRenderController.ClickListener r101 = this.f155218a.getOuterClickListener();
            if (r101 == null) goto L9;
            r101.onExtraRenderViewClick(this.f155218a.f155216d);
            return;
        L9:
            return;
        }
    }

    public final View getDescView() {
        return (View) this.f155214b.getValue();
    }

    public final FrameLayout getRenderView() {
        return (FrameLayout) this.f155215c.getValue();
    }

    public final ILivePlayerExtraRenderController.ClickListener getOuterClickListener() {
        return this.f155213a;
    }

    public final void setDescInfo(RenderDescInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f155216d = r100;
    }

    public final void setOuterClickListener(ILivePlayerExtraRenderController.ClickListener r100) {
        this.f155213a = r100;
    }

    public ExtraRenderShadowInteractView(final Context r100, ExtraRenderController r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "renderController");
        super(r100);
        this.f155214b = LazyKt.lazy(new ExtraRenderShadowInteractView$descView$2(r100));
        this.f155215c = LazyKt.lazy(new ExtraRenderShadowInteractView$renderView$2(r100));
        setId(R.id.ttlive_player_shadow_interact_view);
        setBackground(new ColorDrawable(ColorProtector.parseColor("#06000000")));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        getDescView().setOnClickListener(new a(this));
        getRenderView().setOnClickListener(new b(this, r101));
    }
}
