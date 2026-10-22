package com.bytedance.android.live.broadcastgame.api;

import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.i;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.config.fe0;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b@\u00105R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0007R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u000fR!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u000fR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u000fR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R*\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R'\u00106\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b2\u0010\u0005\u0012\u0004\b4\u00105\u001a\u0004\b3\u0010\u0007R!\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007R!\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0005\u001a\u0004\b<\u0010\u000fR!\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0005\u001a\u0004\b?\u0010\u0007¨\u0006B"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/InteractGameContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/live/datacontext/m;", "", "lastSwitchGameTime$delegate", "Lcom/bytedance/live/datacontext/p;", "getLastSwitchGameTime", "()Lcom/bytedance/live/datacontext/m;", "lastSwitchGameTime", "", "isPlayingGame$delegate", "isPlayingGame", "Lcom/bytedance/live/datacontext/n;", "hasOpenGameLaunch$delegate", "getHasOpenGameLaunch", "()Lcom/bytedance/live/datacontext/n;", "hasOpenGameLaunch", "hasDebugFloatBallShow$delegate", "getHasDebugFloatBallShow", "hasDebugFloatBallShow", "Lcom/bytedance/android/live/broadcastgame/api/model/h0$c;", "openGameLaunchResult$delegate", "getOpenGameLaunchResult", "openGameLaunchResult", "Lcom/bytedance/android/live/broadcastgame/api/model/h0$b;", "openGameLaunchProgress$delegate", "getOpenGameLaunchProgress", "openGameLaunchProgress", "Lcom/bytedance/android/live/broadcastgame/api/model/i0;", "currentOpenPlatformAppInfo$delegate", "getCurrentOpenPlatformAppInfo", "currentOpenPlatformAppInfo", "panelShowing$delegate", "getPanelShowing", "panelShowing", "Lkotlin/Function0;", "", "onFullPanelHide", "Lkotlin/jvm/functions/Function0;", "getOnFullPanelHide", "()Lkotlin/jvm/functions/Function0;", "setOnFullPanelHide", "(Lkotlin/jvm/functions/Function0;)V", "value", "gameFullPanelIsShowing", "Z", "getGameFullPanelIsShowing", "()Z", "setGameFullPanelIsShowing", "(Z)V", "xplayRunning$delegate", "getXplayRunning", "getXplayRunning$annotations", "()V", "xplayRunning", "clearScreen$delegate", "getClearScreen", "clearScreen", "Lcom/bytedance/android/live/broadcastgame/api/model/i;", "gameOpenInfo$delegate", "getGameOpenInfo", "gameOpenInfo", "isXPlayGameSessionRunning$delegate", "isXPlayGameSessionRunning", "<init>", "Companion", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class InteractGameContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final String CONTEXT_KEY = "InteractGameContext";
    public static final Companion Companion = null;
    private final p clearScreen$delegate;
    private final p currentOpenPlatformAppInfo$delegate;
    private boolean gameFullPanelIsShowing;
    private final p gameOpenInfo$delegate;
    private final p hasDebugFloatBallShow$delegate;
    private final p hasOpenGameLaunch$delegate;
    private final p isPlayingGame$delegate;
    private final p isXPlayGameSessionRunning$delegate;
    private final p lastSwitchGameTime$delegate;
    private Function0<Unit> onFullPanelHide;
    private final p openGameLaunchProgress$delegate;
    private final p openGameLaunchResult$delegate;
    private final p panelShowing$delegate;
    private final p xplayRunning$delegate;

    public static final class Companion {

        public static final class a<T> implements Predicate {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f59282a = null;

            static {
                f59282a = new a();
            }

            public a() {
            }

            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object r100) {
                Boolean r101 = (Boolean) r100;
                Intrinsics.checkNotNullParameter(r101, "it");
                return !r101.booleanValue();
            }
        }

        public Companion() {
        }

        @JvmStatic
        public final InteractGameContext getContext() {
            return (InteractGameContext) com.bytedance.live.datacontext.d.e(InteractGameContext.CONTEXT_KEY, InteractGameContext.class);
        }

        @JvmStatic
        public final boolean b() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L9;
            m<Boolean> r101 = r100.isPlayingGame();
            if (r101 == null) goto L9;
            Boolean r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.booleanValue();
        L9:
            return false;
        }

        @JvmStatic
        public final boolean c() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L9;
            m<Boolean> r101 = r100.getHasDebugFloatBallShow();
            if (r101 == null) goto L9;
            if (r101.getValue().booleanValue() != true) goto L9;
            return true;
        L9:
            return false;
        }

        @JvmStatic
        public final boolean d() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L23;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L24;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L25;
            String r103 = r102.f59359b;
            if (r103 != null) goto L11;
            return false;
        L11:
            if (r103.length() <= 0) goto L13;
            boolean r104 = true;
        L14:
            if (r104 != true) goto L27;
            i0 r105 = r100.getCurrentOpenPlatformAppInfo().getValue();
            if (r105 == null) goto L18;
            InteractID r106 = r105.f59361d;
        L20:
            if (r106 != InteractID.OpenGame) goto L28;
            return true;
        L28:
            return false;
        L18:
            r106 = null;
            goto L20
        L27:
            return false;
        L13:
            r104 = false;
            goto L14
        L25:
            return false;
        L24:
            return false;
        L23:
            return false;
        }

        @JvmStatic
        public final boolean e() {
            InteractGameContext r100 = getContext();
            if (g() == false) goto L14;
            if (r100 == null) goto L10;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L10;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L10;
            InteractID r103 = r102.f59361d;
        L12:
            if (r103 != InteractID.OpenMicroApp) goto L14;
            return true;
        L10:
            r103 = null;
        L14:
            return false;
        }

        @JvmStatic
        public final boolean f() {
            InteractGameContext r100 = getContext();
            if (g() == false) goto L14;
            if (r100 == null) goto L10;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L10;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L10;
            InteractID r103 = r102.f59361d;
        L12:
            if (r103 != InteractID.OpenMicroGame) goto L14;
            return true;
        L10:
            r103 = null;
        L14:
            return false;
        }

        @JvmStatic
        public final boolean g() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L17;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L18;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L19;
            String r103 = r102.f59359b;
            if (r103 != null) goto L11;
            return false;
        L11:
            if (r103.length() <= 0) goto L13;
            boolean r104 = true;
        L14:
            if (r104 != true) goto L21;
            return true;
        L21:
            return false;
        L13:
            r104 = false;
            goto L14
        L19:
            return false;
        L18:
            return false;
        L17:
            return false;
        }

        @JvmStatic
        public final String i() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L10;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L10;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L10;
            String r103 = r102.f59360c;
            if (r103 == null) goto L10;
            return r103;
        L10:
            return "";
        }

        @JvmStatic
        public final boolean j() {
            InteractGameContext r100 = getContext();
            if (r100 == null) goto L23;
            n<i0> r101 = r100.getCurrentOpenPlatformAppInfo();
            if (r101 == null) goto L24;
            i0 r102 = r101.getValue();
            if (r102 == null) goto L25;
            String r103 = r102.f59359b;
            if (r103 != null) goto L11;
            return false;
        L11:
            if (r103.length() <= 0) goto L13;
            boolean r104 = true;
        L14:
            if (r104 != true) goto L27;
            i0 r105 = r100.getCurrentOpenPlatformAppInfo().getValue();
            if (r105 == null) goto L18;
            InteractID r106 = r105.f59361d;
        L20:
            if (r106 != InteractID.SonicMiniGame) goto L28;
            return true;
        L28:
            return false;
        L18:
            r106 = null;
            goto L20
        L27:
            return false;
        L13:
            r104 = false;
            goto L14
        L25:
            return false;
        L24:
            return false;
        L23:
            return false;
        }

        @JvmStatic
        public final void a(final Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            InteractGameContext r101 = getContext();
            if (r101 == null) goto L9;
            m<Boolean> r102 = r101.isXPlayGameSessionRunning();
            if (r102 == null) goto L9;
            Boolean r103 = r102.getValue();
            if (r103 == null) goto L9;
            boolean r104 = r103.booleanValue();
        L10:
            Observable r105 = Observable.just(Boolean.valueOf(r104));
            InteractGameContext r106 = getContext();
            if (r106 == null) goto L15;
            m<Boolean> r107 = r106.isXPlayGameSessionRunning();
            if (r107 == null) goto L15;
            Observable<Boolean> r108 = r107.a();
        L16:
            RxUtilKt.n(Observable.merge(r105, r108).filter(a.f59282a).take(1), new InteractGameContext$Companion$doAfterXPlayGameSessionStopped$2(r100));
            return;
        L15:
            r108 = null;
        L9:
            r104 = false;
            goto L10
        }

        @JvmStatic
        public final boolean h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            InteractGameContext r101 = getContext();
            if (r101 == null) goto L9;
            n<i0> r102 = r101.getCurrentOpenPlatformAppInfo();
            if (r102 == null) goto L9;
            i0 r103 = r102.getValue();
            if (r103 == null) goto L9;
            String r104 = r103.f59359b;
        L11:
            return Intrinsics.areEqual(r104, r100);
        L9:
            r104 = null;
            goto L11
        }
    }

    @JvmStatic
    public static final void doAfterXPlayGameSessionStopped(Function0<Unit> r100) {
        Companion.a(r100);
    }

    @JvmStatic
    public static final InteractGameContext getContext() {
        return Companion.getContext();
    }

    @Deprecated(message = "Use IXplayGlobalService instead")
    public static /* synthetic */ void getXplayRunning$annotations() {
    }

    @JvmStatic
    public static final boolean isAnchorPlayingGame() {
        return Companion.b();
    }

    @JvmStatic
    public static final boolean isDebugRoom() {
        return Companion.c();
    }

    @JvmStatic
    public static final boolean isRunningLynxPlugin() {
        return Companion.d();
    }

    @JvmStatic
    public static final boolean isRunningMiniApp() {
        return Companion.e();
    }

    @JvmStatic
    public static final boolean isRunningMiniGame() {
        return Companion.f();
    }

    @JvmStatic
    public static final boolean isRunningPlugin() {
        return Companion.g();
    }

    @JvmStatic
    public static final boolean isRunningPlugin(String r100) {
        return Companion.h(r100);
    }

    @JvmStatic
    public static final String isRunningPluginName() {
        return Companion.i();
    }

    @JvmStatic
    public static final boolean isRunningSonicGame() {
        return Companion.j();
    }

    public final m<Boolean> getClearScreen() {
        return (m) this.clearScreen$delegate.a(this, $$delegatedProperties[9]);
    }

    public final n<i0> getCurrentOpenPlatformAppInfo() {
        return (n) this.currentOpenPlatformAppInfo$delegate.a(this, $$delegatedProperties[6]);
    }

    public final n<i> getGameOpenInfo() {
        return (n) this.gameOpenInfo$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> getHasDebugFloatBallShow() {
        return (m) this.hasDebugFloatBallShow$delegate.a(this, $$delegatedProperties[3]);
    }

    public final n<Boolean> getHasOpenGameLaunch() {
        return (n) this.hasOpenGameLaunch$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Long> getLastSwitchGameTime() {
        return (m) this.lastSwitchGameTime$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<h0.b> getOpenGameLaunchProgress() {
        return (n) this.openGameLaunchProgress$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<h0.c> getOpenGameLaunchResult() {
        return (n) this.openGameLaunchResult$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Boolean> getPanelShowing() {
        return (m) this.panelShowing$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Boolean> getXplayRunning() {
        return (m) this.xplayRunning$delegate.a(this, $$delegatedProperties[8]);
    }

    public final m<Boolean> isPlayingGame() {
        return (m) this.isPlayingGame$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isXPlayGameSessionRunning() {
        return (m) this.isXPlayGameSessionRunning$delegate.a(this, $$delegatedProperties[11]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "lastSwitchGameTime", "getLastSwitchGameTime()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "isPlayingGame", "isPlayingGame()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "hasOpenGameLaunch", "getHasOpenGameLaunch()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "hasDebugFloatBallShow", "getHasDebugFloatBallShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "openGameLaunchResult", "getOpenGameLaunchResult()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "openGameLaunchProgress", "getOpenGameLaunchProgress()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "currentOpenPlatformAppInfo", "getCurrentOpenPlatformAppInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "panelShowing", "getPanelShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "xplayRunning", "getXplayRunning()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "clearScreen", "getClearScreen()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "gameOpenInfo", "getGameOpenInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(InteractGameContext.class, "isXPlayGameSessionRunning", "isXPlayGameSessionRunning()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new Companion();
    }

    @JvmStatic
    public static final boolean canPauseStream() {
        Companion r100 = Companion;
        r100.getClass();
        boolean r101 = fe0.f120196a.getValue().a();
        InteractGameContext r102 = r100.getContext();
        if (r102 == null) goto L5;
        boolean r103 = r102.getGameFullPanelIsShowing();
    L6:
        if (r103 == false) goto L8;
        if (r101 == false) goto L8;
        return false;
    L8:
        return true;
    L5:
        r103 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean isGameFullPanelShowing() {
        InteractGameContext r100 = Companion.getContext();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getGameFullPanelIsShowing();
    }

    public InteractGameContext() {
        this.lastSwitchGameTime$delegate = q.d(this, 0L);
        Boolean r100 = Boolean.FALSE;
        this.isPlayingGame$delegate = q.d(this, r100);
        this.hasOpenGameLaunch$delegate = q.c(this);
        this.hasDebugFloatBallShow$delegate = q.d(this, r100);
        this.openGameLaunchResult$delegate = q.c(this);
        this.openGameLaunchProgress$delegate = q.c(this);
        this.currentOpenPlatformAppInfo$delegate = q.c(this);
        this.panelShowing$delegate = q.d(this, r100);
        this.xplayRunning$delegate = q.d(this, r100);
        this.clearScreen$delegate = q.d(this, Boolean.TRUE);
        this.gameOpenInfo$delegate = q.c(this);
        this.isXPlayGameSessionRunning$delegate = q.d(this, r100);
    }

    public final boolean getGameFullPanelIsShowing() {
        return this.gameFullPanelIsShowing;
    }

    public final Function0<Unit> getOnFullPanelHide() {
        return this.onFullPanelHide;
    }

    @JvmStatic
    public static final void callPanelHideOnce(final Function0<Unit> r100) {
        Companion r101 = Companion;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "block");
        final InteractGameContext r102 = r101.getContext();
        if (r102 == null) goto L6;
        r102.setOnFullPanelHide(new InteractGameContext$Companion$callPanelHideOnce$1(r100, r102));
        return;
    }

    public final void setGameFullPanelIsShowing(boolean r100) {
        if (r100 == true) goto L6;
        Function0<Unit> r101 = this.onFullPanelHide;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke();
    L6:
        this.gameFullPanelIsShowing = r100;
    }

    public final void setOnFullPanelHide(Function0<Unit> r100) {
        this.onFullPanelHide = r100;
    }
}
