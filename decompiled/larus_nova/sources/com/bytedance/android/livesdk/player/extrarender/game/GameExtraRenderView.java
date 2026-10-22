package com.bytedance.android.livesdk.player.extrarender.game;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.player.extrarender.ExtraRenderController;
import com.bytedance.android.livesdk.player.utils.h;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderConfig;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.android.livesdkapi.view.IExtraRenderView;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.android.livesdkapi.view.SurfaceRenderView;
import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class GameExtraRenderView extends FrameLayout implements IExtraRenderView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f155267i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f155268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f155269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f155270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IRenderView f155271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f155272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f155273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f155274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ExtraRenderController f155275h;

    public static final class a implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameExtraRenderView f155276a;

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
        }

        public a(GameExtraRenderView r100) {
            this.f155276a = r100;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
            Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
            ExtraRenderController r101 = this.f155276a.getRenderController();
            StringBuilder r102 = new StringBuilder("remove extra surface@");
            Surface r103 = this.f155276a.f155270c;
            if (r103 == null) goto L5;
            Integer r104 = Integer.valueOf(r103.hashCode());
        L6:
            r102.append(r104);
            r102.append(" onSurfaceTextureDestroyed");
            r101.log(r102.toString(), true);
            this.f155276a.getRenderController().f155191k.N.removeExtraSurface(this.f155276a.f155270c, 1);
            this.f155276a.f155270c = null;
            return true;
        L5:
            r104 = null;
            goto L6
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, Segment.JsonKey.START);
            GameExtraRenderView r103 = this.f155276a;
            r103.f155270c = new Surface(r100);
            ExtraRenderController r104 = this.f155276a.getRenderController();
            StringBuilder r105 = new StringBuilder("set extra surface@");
            Surface r106 = this.f155276a.f155270c;
            if (r106 == null) goto L5;
            Integer r107 = Integer.valueOf(r106.hashCode());
        L6:
            r105.append(r107);
            r105.append(" onSurfaceTextureAvailable");
            r104.log(r105.toString(), true);
            this.f155276a.getRenderController().f155191k.N.setExtraSurface(this.f155276a.f155270c, 1);
            return;
        L5:
            r107 = null;
            goto L6
        }
    }

    private final GameExtraRenderView$surfaceHolderListener$2.a getSurfaceHolderListener() {
        return (GameExtraRenderView$surfaceHolderListener$2.a) this.f155274g.getValue();
    }

    public final FrameLayout getRenderViewWrapper() {
        return (FrameLayout) this.f155268a.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.view.IExtraRenderView
    public final View selfView() {
        return this;
    }

    private final boolean getEnableSurface() {
        return ((PlayerExtraRenderConfig) this.f155275h.f155181a.getValue()).getSurfaceEnable();
    }

    private final Rect getSurfaceViewPos() {
        View r100 = this.f155271d.getSelfView();
        if (isSurfaceView() == true) goto L21;
        return null;
    L21:
        Class<? super Object> r101 = r100.getClass().getSuperclass();     // Catch: Exception -> L20
        if (r101 == null) goto L8;
        Field r102 = r101.getDeclaredField("mRTLastReportedPosition");     // Catch: Exception -> L20
    L9:
        if (r102 == null) goto L11;
        r102.setAccessible(true);     // Catch: Exception -> L20
    L11:
        if (r102 == null) goto L13;
        Object r103 = r102.get(r100);     // Catch: Exception -> L20
    L15:
        if ((r103 instanceof Rect) == true) goto L17;
        r103 = null;
    L17:
        return (Rect) r103;
    L13:
        r103 = null;
        goto L15
    L8:
        r102 = null;
    L23:
        return null;
    }

    public final SurfaceRenderView c() {
        SurfaceRenderView r100 = new SurfaceRenderView(getContext());
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = 17;
        Unit r102 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        r100.getHolder().removeCallback(getSurfaceHolderListener());
        r100.getHolder().addCallback(getSurfaceHolderListener());
        return r100;
    }

    public final TextureRenderView d() {
        TextureRenderView r100 = new TextureRenderView(getContext());
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r101.gravity = 17;
        Unit r102 = Unit.INSTANCE;
        r100.setLayoutParams(r101);
        r100.setSurfaceTextureListener(new a(this));
        return r100;
    }

    @Override // com.bytedance.android.livesdkapi.view.IExtraRenderView
    public final boolean isSurfaceView() {
        return this.f155271d.getSelfView() instanceof SurfaceView;
    }

    public final void a() {
        if (getVisibility() == 0) goto L5;
        return;
    L5:
        Rect r100 = getSurfaceViewPos();
        int r101 = h.e();
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.centerX() >= r101) goto L12;
        ILivePlayerExtraRenderController.DefaultImpls.log$default(this.f155275h, "abnormal case, unselected SurfaceView still on screen, try set gone/visible," + r100, false, 2, null);
        this.f155271d.setVisibility(8);
        this.f155271d.setVisibility(0);
        return;
    }

    public final FrameLayout getBackgroundView() {
        return this.f155269b;
    }

    public final ExtraRenderController getRenderController() {
        return this.f155275h;
    }

    public final void setBackgroundView(FrameLayout r100) {
        this.f155269b = r100;
    }

    public final void setRenderController(ExtraRenderController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f155275h = r100;
    }

    public final void setScaleType(int r100) {
        this.f155271d.setScaleType(r100);
    }

    @Override // android.view.View, com.bytedance.android.livesdkapi.view.IExtraRenderView
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (isSurfaceView() == false) goto L6;
        this.f155271d.setVisibility(r100);
        return;
    }

    public GameExtraRenderView(final Context r100, ExtraRenderController r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "renderController");
        super(r100);
        this.f155275h = r101;
        this.f155268a = LazyKt.lazy(new GameExtraRenderView$renderViewWrapper$2(r100));
        this.f155274g = LazyKt.lazy(new GameExtraRenderView$surfaceHolderListener$2(this));
        setId(R.id.ttlive_player_extra_render_view);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        if (this.f155275h.getGameLayoutType() > 2) goto L5;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r102.setVisibility(8);
        addView(r102);
        Unit r103 = Unit.INSTANCE;
        this.f155269b = r102;
    L5:
        boolean r104 = this.f155275h.f155184d.isLandStyle();
        int r105 = this.f155275h.f155184d.getExtraViewInfo().getVideoWidth();
        int r106 = this.f155275h.f155184d.getExtraViewInfo().getVideoHeight();
        if (r104 == false) goto L8;
    L10:
        IRenderView r107 = d();
    L11:
        this.f155271d = r107;
        e(r105, r106, true);
        if (r104 == false) goto L14;
        setScaleType(2);
    L15:
        getRenderViewWrapper().addView(this.f155271d.getSelfView());
        addView(getRenderViewWrapper());
        setVisibility(8);
        this.f155275h.log("create and init extraRenderView@" + hashCode() + " useSurface: " + (this.f155271d instanceof SurfaceRenderView), true);
        return;
    L14:
        setScaleType(3);
        goto L15
    L8:
        if (getEnableSurface() == false) goto L10;
        r107 = c();
        goto L11
    }

    public final void b(boolean r100, Rect r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r102, "restoreRect");
        int r103 = this.f155275h.f155184d.getExtraViewInfo().getVideoWidth();
        int r104 = this.f155275h.f155184d.getExtraViewInfo().getVideoHeight();
        if (r100 == true) goto L5;
    L10:
        if (r100 == false) goto L12;
        return;
    L12:
        if (isSurfaceView() == false) goto L14;
        return;
    L14:
        if (getEnableSurface() == false) goto L20;
        ILivePlayerExtraRenderController.DefaultImpls.log$default(this.f155275h, "reset textureView to surfaceView for smooth show!", false, 2, null);
        getRenderViewWrapper().removeView(this.f155271d.getSelfView());
        this.f155271d = c();
        e(r103, r104, true);
        getRenderViewWrapper().addView(this.f155271d.getSelfView());
        return;
    L20:
        return;
    L5:
        if (isSurfaceView() == false) goto L10;
        if (r101 == null) goto L10;
        if (r101.isEmpty() == true) goto L10;
        ILivePlayerExtraRenderController.DefaultImpls.log$default(this.f155275h, "reset surfaceView to textureView for crop!", false, 2, null);
        getRenderViewWrapper().removeView(this.f155271d.getSelfView());
        this.f155271d = d();
        e(r103, r104, true);
        getRenderViewWrapper().addView(this.f155271d.getSelfView());
    }

    public final void e(int r100, int r101, boolean r102) {
        if (this.f155272e == r100) goto L5;
    L7:
        this.f155272e = r100;
        this.f155273f = r101;
        this.f155271d.setVideoSize(r100, r101);
        return;
    L5:
        if (this.f155273f != r101) goto L7;
        if (r102 == true) goto L7;
    }
}
