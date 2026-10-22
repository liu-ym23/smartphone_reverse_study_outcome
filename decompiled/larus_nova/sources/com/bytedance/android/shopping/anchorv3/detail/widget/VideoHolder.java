package com.bytedance.android.shopping.anchorv3.detail.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityUtil;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class VideoHolder extends l implements o, ee3.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f164874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f164875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f164876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ProgressBar f164877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayerBlock f164878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fj.d f164879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ECUrlModel f164880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f164881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f164882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super Float, Unit> f164883l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f164884m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l53.b f164885n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f164886o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c63.d f164887p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f164888q;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f164889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoHolder f164890b;

        public a(View r100, VideoHolder r101) {
            this.f164889a = r100;
            this.f164890b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoHolder r100 = this.f164890b;     // Catch: Throwable -> L4
            ((FrameLayout) this.f164889a).getHeight();     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void W(boolean r100) {
    }

    @Override // ee3.c
    public final void onTransitionBegin(int r100) {
    }

    @Override // ee3.c
    public final void onTransitionChanged(int r100, float r101) {
    }

    public final void g() {
        PlayerBlock r100 = this.f164878g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.t() == false) goto L8;
        return;
    L8:
        if (y0.a() == false) goto L25;
        gj.b r101 = r100.f164941f;
        if (r101 != null) goto L13;
    L15:
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L22;
        com.bytedance.android.ec.adapter.api.j r104 = r103.getLiveWindowService();
        if (r104 == null) goto L23;
        r104.toggleLiveAudio(false);
        return;
    L23:
        return;
    L22:
        return;
    L13:
        if (r101.isPlaying() != true) goto L15;
        return;
    }

    public final Context getContext() {
        return this.f164884m;
    }

    @Override // ee3.c
    public final PlayerBlock getPlayer() {
        return this.f164878g;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void Q(float r100) {
        float r101 = (float) Math.floor(r100);
        ProgressBar r102 = this.f164877f;
        if (r102 == null) goto L5;
        r102.setProgress((int) r101);
    L5:
        Function1<? super Float, Unit> r103 = this.f164883l;
        if (r103 == null) goto L9;
        Unit r104 = r103.invoke(Float.valueOf(r100));
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void R(boolean r100) {
        h(r100);
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o
    public final void V(boolean r100) {
        ImageView r101 = this.f164875d;
        if (r101 == null) goto L6;
        r101.setSelected(!r100);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv3.detail.widget.l
    public final View c(LayoutInflater r110) {
        Intrinsics.checkNotNullParameter(r110, "layoutInflater");
        ShoppingAsyncInflater.a r111 = ShoppingAsyncInflater.f45268e;
        Context r100 = this.f164884m;
        r111.getClass();
        boolean r101 = false;
        View r112 = ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_anchor_v3_video_host_layout, null, false);
        this.f164875d = (ImageView) r112.findViewById(R.id.iv_audio_status);
        this.f164876e = r112.findViewById(R.id.iv_audio_status_holder);
        this.f164877f = (ProgressBar) r112.findViewById(R.id.pb_media_progress);
        PlayerBlock r102 = (PlayerBlock) r112.findViewById(R.id.player_block);
        this.f164878g = r102;
        if (r102 == null) goto L5;
        boolean r103 = this.f164888q;
        int r104 = PlayerBlock.T;
        r102.q(r103, null, null);
    L5:
        PlayerBlock r105 = this.f164878g;
        if (r105 == null) goto L8;
        r105.setForbidPlay(this.f164886o);
    L8:
        PlayerBlock r106 = this.f164878g;
        if (r106 == null) goto L11;
        r106.setCollisionNegotiator(this.f164885n);
    L11:
        this.f164874c = (FrameLayout) r112;
        PlayerBlock r107 = this.f164878g;
        if (r107 == null) goto L14;
        r107.setPlayBlockClickListener(this.f164882k);
    L14:
        PlayerBlock r108 = this.f164878g;
        if (r108 == null) goto L17;
        z73.a<String, gj.b> r109 = PlayAbilityUtil.f164933a;
        PlayerBlock.m(r108, PlayAbilityUtil.b(this.f164879h, null, null, 14), this.f164880i, false, null, null, null, 60);
    L17:
        PlayerBlock r113 = this.f164878g;
        if (r113 == null) goto L20;
        r113.i(this);
    L20:
        ImageView r114 = this.f164875d;
        if (r114 == null) goto L28;
        PlayerBlock r115 = this.f164878g;
        if (r115 != null) goto L25;
    L26:
        r101 = true;
    L27:
        r114.setSelected(r101);
        goto L28
    L25:
        if (r115.f164950o == true) goto L27;
    L28:
        ImageView r116 = this.f164875d;
        if (r116 == null) goto L32;
        r116.setOnClickListener(new m(this));
    L32:
        if (this.f164888q == false) goto L40;
        ImageView r117 = this.f164875d;
        if (r117 == null) goto L37;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        r118.width = com.bytedance.android.shopping.extensions.b.b(36);
        r118.height = com.bytedance.android.shopping.extensions.b.b(24);
        Unit r119 = Unit.INSTANCE;
        r117.setLayoutParams(r118);
    L37:
        ImageView r120 = this.f164875d;
        if (r120 == null) goto L40;
        r120.setImageResource(R.drawable.commerce_anchor_v4_audio_status);
    L40:
        PlayerBlock r121 = this.f164878g;
        if (r121 == null) goto L43;
        r121.f164944i = new VideoHolder$getView$$inlined$apply$lambda$1(this);
    L43:
        PlayerBlock r122 = this.f164878g;
        if (r122 == null) goto L46;
        r122.post(new a(r112, this));
    L46:
        PlayerBlock r123 = this.f164878g;
        if (r123 == null) goto L49;
        r123.setLogAction(this.f164887p);
    L49:
        return r112;
    }

    public final void h(boolean r100) {
        View r101 = this.f164876e;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        goto L8
    L6:
        r102 = 8;
    L8:
        c63.d r103 = this.f164887p;
        if (r103 == null) goto L12;
        r103.d();
        return;
    }

    public final void f(fj.d r100, ECUrlModel r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "videoModel");
        Intrinsics.checkNotNullParameter(r102, "clickCB");
        this.f164879h = r100;
        this.f164880i = r101;
        this.f164881j = r102;
    }

    public VideoHolder(Context r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 16) == 0) goto L8;
        r102 = false;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f164884m = r100;
        this.f164885n = null;
        this.f164886o = r101;
        this.f164887p = null;
        this.f164888q = r102;
    }
}
