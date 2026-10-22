package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.EdgeTransparentView;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerLoopListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.bytedance.android.livesdkapi.depend.live.player.PlayConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener;
import com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import com.ss.android.ugc.aweme.live.alphaplayer.player.DefaultSystemPlayer;
import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements ITextureViewPlayerController {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Boolean f129467m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LifecycleOwner f129468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IPlayerActionListener f129469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayerController f129470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IPlayerLoopListener f129471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IResultMonitor f129472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f129473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AbsPlayer f129474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f129475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f129476i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f129477j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f129478k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f129479l;

    public static final class a {
    }

    public static final class b implements AlphaPlayerAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f129480a;

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction
        public final void a() {
            IPlayerActionListener r100 = this.f129480a.f129469b;
            if (r100 == null) goto L6;
            r100.onStart();
            return;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction
        public final void b() {
            IPlayerActionListener r100 = this.f129480a.f129469b;
            if (r100 == null) goto L6;
            r100.onEnd();
            return;
        }

        public b(k r100) {
            this.f129480a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.AlphaPlayerAction
        public final void c(int r110, int r111, DataSource.ScaleType r112) {
            IPlayerActionListener r100 = this.f129480a.f129469b;
            if (r100 == null) goto L5;
            r100.onFileLoaded(r110, r111);
        L5:
            k r101 = this.f129480a;
            View r102 = null;
            if (r101.f129475h == false) goto L60;
            PlayerController r103 = r101.f129470c;
            if (r103 == null) goto L11;
            View r104 = r103.getView();
        L12:
            if (r104 == null) goto L60;
            if (r104.getParent() == null) goto L60;
            if ((r104.getParent() instanceof FrameLayout) == false) goto L60;
            ViewParent r105 = r104.getParent();
            if (r105 == null) goto L59;
            FrameLayout r106 = (FrameLayout) r105;
            ViewGroup.LayoutParams r107 = r106.getLayoutParams();
            if (r107 == null) goto L57;
            FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
            int r109 = s1.y();
            int r113 = s1.w();
            float r114 = r111 / r110;
            if (r112 == null) goto L34;
            int r115 = l.f129484a[r112.ordinal()];
            if (r115 == 1) goto L39;
            if (r115 != 2) goto L29;
            r108.width = r109;
            r108.height = r113;
            r108.gravity = 48;
        L45:
            if (((wh6.a) vh6.c.b(wh6.a.class)).getCurrentActivity() != null) goto L47;
        L55:
            r106.setLayoutParams(r108);
            goto L60
        L47:
            if ((r106 instanceof EdgeTransparentView) == false) goto L55;
            if (PadConfigUtils.c() == false) goto L55;
            float r116 = r109;
            if (r109 <= r113) goto L53;
            float r117 = 0.3f;
        L54:
            int r118 = (int) (r116 * r117);
            float r119 = r118;
            ((EdgeTransparentView) r106).a(15, r119 * 0.12f);
            r108.width = r118;
            r108.height = (int) (r114 * r119);
            r108.gravity = 81;
            goto L55
        L53:
            r117 = 0.5f;
            goto L54
        L29:
            if (r115 != 3) goto L31;
            r108.width = r109;
            r108.height = (int) (r109 * r114);
            r108.gravity = 80;
            goto L45
        L31:
            if (r115 != 4) goto L33;
            r108.height = r113;
            r108.width = (int) (r113 / r114);
            r108.gravity = GravityCompat.START;
            goto L45
        L33:
            if (r115 != 5) goto L34;
            r108.height = r113;
            r108.width = (int) (r113 / r114);
            r108.gravity = GravityCompat.END;
            goto L45
        L39:
            float r120 = r113;
            float r121 = r109 * r114;
            if (r120 <= r121) goto L42;
            r108.width = r109;
            r108.height = (int) r121;
        L43:
            r108.gravity = 17;
            goto L45
        L42:
            r108.height = r113;
            r108.width = (int) (r120 / r114);
        L34:
            r108.width = -1;
            r108.height = -1;
            r108.gravity = 17;
            goto L45
        L57:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        L59:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        L11:
            r104 = null;
        L60:
            PlayerController r122 = this.f129480a.f129470c;
            if (r122 == null) goto L63;
            r102 = r122.getView();
        L63:
            k r123 = this.f129480a;
            float r124 = 0.0f;
            if (r102 == null) goto L66;
            float r125 = r102.getMeasuredWidth();
        L67:
            if (r102 == null) goto L69;
            float r126 = r102.getMeasuredHeight();
        L70:
            r123.getClass();
            float r127 = r125 / r126;
            float r128 = r110 / r111;
            if (r112 == DataSource.ScaleType.ScaleAspectFill) goto L85;
            if (r112 == DataSource.ScaleType.TopFill) goto L85;
            if (r112 == DataSource.ScaleType.BottomFill) goto L85;
            if (r112 == DataSource.ScaleType.RightFill) goto L85;
            if (r112 == DataSource.ScaleType.LeftFill) goto L85;
            if (r127 > r128) goto L87;
        L86:
            float r129 = r125 / r128;
            float r130 = r125;
        L88:
            if (r112 != null) goto L91;
        L122:
            float r131 = 0.0f;
        L123:
            float r132 = r130;
            r126 = r129;
        L124:
            r129 = r126;
            r124 = r131;
            float r133 = 0.0f;
            r125 = r132;
        L125:
            IPlayerActionListener r134 = r123.f129469b;
            if (r134 == null) goto L129;
            r134.updateTextEffectPosition(r125, r129, r124, r133);
            return;
        L129:
            return;
        L91:
            switch(l.f129485b[r112.ordinal()]) {
                case 1: goto L121;
                case 2: goto L115;
                case 3: goto L112;
                case 4: goto L109;
                case 5: goto L106;
                case 6: goto L102;
                case 7: goto L98;
                case 8: goto L96;
                case 9: goto L95;
                case 10: goto L94;
                case 11: goto L93;
                default: goto L122;
            };
        L93:
            r132 = r128 * r126;
            r131 = r125 - r132;
            goto L124
        L94:
            r125 = r126 * r128;
            goto L121
        L95:
            r129 = r125 / r128;
            r133 = r126 - r129;
            goto L125
        L96:
            r126 = r125 / r128;
        L121:
            r132 = r125;
            r131 = 0.0f;
            goto L124
        L98:
            if (r127 <= r128) goto L100;
            float r135 = r125 - r130;
        L120:
            r131 = r135 / 2;
            goto L123
        L100:
            r133 = (r126 - r129) / 2;
        L118:
            r125 = r130;
            goto L125
        L102:
            if (r127 > r128) goto L116;
            r131 = -(r130 - r125);
        L116:
            float r136 = (-(r129 - r126)) / 2;
        L117:
            r133 = r136;
            goto L118
        L106:
            if (r127 <= r128) goto L122;
        L109:
            if (r127 <= r128) goto L119;
            r136 = -(r129 - r126);
        L119:
            r135 = -(r130 - r125);
            goto L120
        L112:
            if (r127 <= r128) goto L119;
        L115:
            if (r127 <= r128) goto L119;
        L87:
            r130 = r126 * r128;
            r129 = r126;
        L85:
            if (r127 <= r128) goto L87;
        L69:
            r126 = 0.0f;
            goto L70
        L66:
            r125 = 0.0f;
            goto L67
        }
    }

    public static final class c implements ILoopListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f129481a;

        public c(k r100) {
            this.f129481a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.ILoopListener
        public final boolean needContinueLoop() {
            IPlayerLoopListener r100 = this.f129481a.f129471d;
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.needContinueLoop();
        }
    }

    public static final class d implements IMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f129482a;

        public d(k r100) {
            this.f129482a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
        public final void a(String r100, Exception r101) {
            jy0.b.b("LiveTextureViewPlayerController", "", r101);
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.listener.IMonitor
        public final void monitor(boolean r100, String r110, int r111, int r112, String r113) {
            Object r101 = this.f129482a.f129473f;
            monitor-enter(r101);
            IResultMonitor r102 = this.f129482a.f129472e;     // Catch: Throwable -> L9
            if (r102 == null) goto L7;
            r102.monitor(r100, r110, r111, r112, r113);     // Catch: Throwable -> L9
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r101);
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public final class e implements IPlayerController.OnElementClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f129483a;

        public e(Function1 r100) {
            this.f129483a = r100;
        }

        @Override // com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController.OnElementClickListener
        public final /* synthetic */ void a(List r100) {
            this.f129483a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void removePlayerActionListener() {
        this.f129469b = null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void cancel() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final View getAlphaView() {
        PlayerController r100 = this.f129470c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getView();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final int getDuration() {
        PlayerController r100 = this.f129470c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final boolean isPlaying() {
        PlayerController r100 = this.f129470c;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPlaying();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void pause() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void release() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.f129474g = null;
        this.f129468a = null;
        this.f129479l = null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void removeMonitor() {
        Object r100 = this.f129473f;
        monitor-enter(r100);
        this.f129472e = null;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void resume() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L6;
        r100.resume();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void stop() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L5;
        r100.stop();
    L5:
        IPlayerActionListener r101 = this.f129469b;
        if (r101 == null) goto L9;
        r101.onStop();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void stopWhenSlideSwitch() {
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final boolean getEnableCropView() {
        return this.f129475h;
    }

    public k(Context r100) {
        this.f129479l = r100;
        this.f129473f = new Object();
        this.f129475h = true;
        this.f129476i = new b(this);
        this.f129477j = new d(this);
        this.f129478k = new c(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void attachAlphaView(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        PlayerController r101 = this.f129470c;
        if (r101 == null) goto L6;
        r101.attachAlphaView(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void detachAlphaView(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        PlayerController r101 = this.f129470c;
        if (r101 == null) goto L6;
        r101.detachAlphaView(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void initialize(LifecycleOwner r110) {
        Intrinsics.checkNotNullParameter(r110, "owner");
        this.f129468a = r110;
        LiveTextureViewPlayerController$createPlayerController$isNull$1 r100 = LiveTextureViewPlayerController$createPlayerController$isNull$1.INSTANCE;
        Context r101 = this.f129479l;
        if (r101 != null) goto L5;
        r100.invoke();
        return;
    L5:
        if (r110 != null) goto L7;
        r100.invoke();
        return;
    L7:
        PlayerController r102 = this.f129470c;
        if (r102 == null) goto L10;
        r102.release();
    L10:
        PlayerController r103 = null;
        this.f129474g = null;
        Configuration r104 = new Configuration();
        r104.f451007a = this.f129479l;
        r104.f451008b = r110;
        r104.f451009c = 1;
        Intrinsics.checkNotNullParameter(r104, "configuration");
        Boolean r105 = f129467m;
        if (r105 == null) goto L13;
        boolean r106 = r105.booleanValue();
    L24:
        if (r106 == false) goto L26;
        r104.f451012f = ((Boolean) com.bytedance.android.livesdk.gift.platform.business.effect.a.D.getValue(null, com.bytedance.android.livesdk.gift.platform.business.effect.a.f129044a[28])).booleanValue();
    L26:
        int r107 = com.bytedance.android.livesdk.gift.platform.business.effect.a.g();
        if (r107 != 1) goto L32;
        if (ay1.b.o() == true) goto L32;
        AbsPlayer r111 = new DefaultSystemPlayer();
    L35:
        this.f129474g = r111;
        Intrinsics.checkNotNull(r111);
        PlayerController r108 = new PlayerController(r104, r111);
        this.f129470c = r108;
        r108.f451070h = this.f129476i;
        r108.f451069g = this.f129477j;
        r108.f451085w = this.f129478k;
        if ((r108 instanceof PlayerController) == false) goto L39;
        r103 = r108;
    L39:
        if (r103 == null) goto L46;
        m r112 = new m(this);
        r103.getClass();
        r103.f451075m.setFirstGLFrameListener(r112);
        return;
    L46:
        return;
    L32:
        if (r107 != 4) goto L34;
        r111 = new t(r101);
        goto L35
    L34:
        r111 = new u(r101);
        goto L35
    L13:
        Method[] r109 = Configuration.class.getDeclaredMethods();
        int r113 = r109.length;
        int r114 = 0;
    L14:
        if (r114 >= r113) goto L19;
        Method r115 = r109[r114];
        if (Intrinsics.areEqual(r115.getName(), "setEnableElementEvent") == true) goto L20;
        r114 = r114 + 1;
    L20:
        if (r115 == null) goto L22;
        r106 = true;
    L23:
        f129467m = Boolean.valueOf(r106);
        goto L24
    L22:
        r106 = false;
        goto L23
    L19:
        r115 = null;
        goto L20
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setEnableCropView(boolean r100) {
        this.f129475h = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setMaskSrc(MaskSrc r100) {
        Intrinsics.checkNotNullParameter(r100, "maskSrc");
        PlayerController r101 = this.f129470c;
        if (r101 == null) goto L6;
        com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc r102 = new com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc();
        r102.f451155a = r100.getName();
        r102.f451156b = r100.getType();
        r100.getWidth();
        r100.getHeight();
        r102.f451157c = r100.getText();
        r102.f451158d = r100.getTextColor();
        r102.f451159e = r100.getTextSize();
        r102.f451160f = r100.isBold();
        r102.f451161g = r100.getBitmap();
        r102.f451162h = r100.isUseBitmapSize();
        Unit r103 = Unit.INSTANCE;
        r101.h(r102);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setMonitor(IResultMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        this.f129472e = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setOnElementClickListener(Function1<? super List<String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onclick");
        PlayerController r101 = this.f129470c;
        if (r101 == null) goto L6;
        r101.o(new e(r100));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setPlayerActionListener(IPlayerActionListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f129469b = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void setPlayerLooperListener(IPlayerLoopListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f129471d = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController
    public final void start(String r110, boolean r111, boolean r112, boolean r113, PlayConfig r114) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        PlayerController r100 = this.f129470c;
        if (r100 == null) goto L55;
        jy0.b.a("LiveTextureViewPlayerController", "start() called with: playerController = [" + r100 + ']');
        String r101 = m02.b.b(m02.b.a(r110));
        if (r101 != null) goto L7;
    L48:
        IResultMonitor r102 = this.f129472e;
        if (r102 == null) goto L57;
        r102.monitor(false, "", 0, 0, "configJson is null");
        return;
    L57:
        return;
    L7:
        if (r101.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L48;
        DataSource.DataInfo r104 = null;
        i02.g r105 = (i02.g) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r101, i02.g.class);     // Catch: JsonSyntaxException -> L15
    L17:
        if (r105 != null) goto L22;
        IResultMonitor r106 = this.f129472e;
        if (r106 == null) goto L54;
        r106.monitor(false, "", 0, 0, "Gson convert failed: ".concat(r101));
        return;
    L54:
        return;
    L22:
        DataSource r107 = new DataSource();
        r107.f451127d = r111;
        i02.g.b r108 = r105.portrait;
        if (r108 == null) goto L28;
        DataSource.DataInfo r109 = new DataSource.DataInfo(r110 + File.separator + r108.path);
        r109.d(r108.align);
        r109.f451144j = r108.version;
        r109.f451137c = r108.totalFrame;
        r109.f451140f = r108.videoWidth;
        r109.f451141g = r108.videoHeight;
        r109.f451142h = r108.actualWidth;
        r109.f451143i = r108.actualHeight;
        r109.b(r108.alphaFrame);
        r109.c(r108.rgbFrame);
        r109.f451145k = r108.masks;
        r109.f451146l = r108.a();
        if (PadConfigUtils.c() == false) goto L27;
        r107.b(r109);
    L27:
        Unit r115 = Unit.INSTANCE;
        r107.c(r109);
    L28:
        if (r114 != null) goto L30;
    L38:
        i02.g.b r116 = r105.landscape;
        if (r116 == null) goto L41;
        DataSource.DataInfo r117 = new DataSource.DataInfo(r110 + File.separator + r116.path);
        r117.d(r116.align);
        r117.f451144j = r116.version;
        r117.f451137c = r116.totalFrame;
        r117.f451140f = r116.videoWidth;
        r117.f451141g = r116.videoHeight;
        r117.f451142h = r116.actualWidth;
        r117.f451143i = r116.actualHeight;
        r117.b(r116.alphaFrame);
        r117.c(r116.rgbFrame);
        r117.f451145k = r116.masks;
        r117.f451146l = r116.a();
        r107.b(r117);
    L41:
        AbsPlayer r118 = this.f129474g;
        if ((r118 instanceof t) == false) goto L47;
        if (r118 == null) goto L46;
        ((t) r118).f129502m = r112;
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.platform.business.effect.player.TTEnginePlayerImpl");
    L47:
        r100.f(r107, r113);
        return;
    L30:
        if (r114.getForceUsePortrait() != true) goto L38;
        DataSource.DataInfo r119 = DataSource.DataInfo.a(r107.f451125b);
        if (r119 == null) goto L37;
        Integer r120 = r114.getScaleType();
        if (r120 == null) goto L36;
        r119.d(r120.intValue());
    L36:
        r104 = r119;
    L37:
        r107.b(r104);
    L15:
        e = move-exception;
        jy0.b.b("LiveTextureViewPlayerController", "videoFileModel parse error", e);
        r105 = null;
        goto L17
    L9:
        r103 = false;
        goto L10
    }
}
