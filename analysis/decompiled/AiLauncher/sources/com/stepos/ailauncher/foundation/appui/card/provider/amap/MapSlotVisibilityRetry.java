package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.amap.route.C2411w;
import com.stepos.ailauncher.amap.route.C2414z;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import h8.C4148a;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u00019\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002=>BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u000eJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u001c\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00104R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry;", "", "Landroid/widget/FrameLayout;", "slot", "Lkotlin/Function0;", "", "shouldRetry", "LY8/t;", "retry", "onVisible", "onHidden", "<init>", "(Landroid/widget/FrameLayout;Lp9/a;Lp9/a;Lp9/a;Lp9/a;)V", "v", "()V", "w", "x", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$VisState;", "s", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$VisState;", VoiceWakeupReceiver.EXTRA_STATE, "q", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$VisState;)V", "l", "k", "m", "y", "Landroid/widget/FrameLayout;", "Lp9/a;", "watching", "Z", "", "lastRetryElapsed", "J", "lastState", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$VisState;", "Landroid/view/ViewTreeObserver;", "registeredObserver", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "hideDebounceRunnable", "Ljava/lang/Runnable;", "foregroundRecheckRunnable", "Lkotlin/Function1;", "foregroundListener", "Lp9/l;", "com/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$b", "attachListener", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$b;", "Companion", "VisState", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MapSlotVisibilityRetry {
    private static final a Companion = new a(null);

    @Deprecated
    public static final long FOREGROUND_RECHECK_MS = 350;

    @Deprecated
    public static final long HIDE_DEBOUNCE_MS = 280;

    @Deprecated
    public static final String JANK_TAG = "MapScrollJank";

    @Deprecated
    public static final long RETRY_DEBOUNCE_MS = 400;

    @Deprecated
    public static final String TAG = "MapSlotVisibilityRetry";
    private final b attachListener;
    private final InterfaceC5074l<Boolean, Y8.t> foregroundListener;
    private Runnable foregroundRecheckRunnable;
    private Runnable hideDebounceRunnable;
    private long lastRetryElapsed;
    private VisState lastState;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private final Handler mainHandler;
    private final InterfaceC5063a<Y8.t> onHidden;
    private final InterfaceC5063a<Y8.t> onVisible;
    private ViewTreeObserver registeredObserver;
    private final InterfaceC5063a<Y8.t> retry;
    private ViewTreeObserver.OnScrollChangedListener scrollListener;
    private final InterfaceC5063a<Boolean> shouldRetry;
    private final FrameLayout slot;
    private boolean watching;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$VisState;", "", "<init>", "(Ljava/lang/String;I)V", "OUT", "WARM", "CAPTURE_READY", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class VisState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ VisState[] $VALUES;
        public static final VisState OUT = new VisState("OUT", 0);
        public static final VisState WARM = new VisState("WARM", 1);
        public static final VisState CAPTURE_READY = new VisState("CAPTURE_READY", 2);

        private static final /* synthetic */ VisState[] $values() {
            return new VisState[]{OUT, WARM, CAPTURE_READY};
        }

        static {
            VisState[] visStateArr$values = $values();
            $VALUES = visStateArr$values;
            $ENTRIES = kotlin.enums.a.a(visStateArr$values);
        }

        private VisState(String str, int i10) {
        }

        public static InterfaceC4149a<VisState> getEntries() {
            return $ENTRIES;
        }

        public static VisState valueOf(String str) {
            return (VisState) Enum.valueOf(VisState.class, str);
        }

        public static VisState[] values() {
            return (VisState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$a;", "", "<init>", "()V", "", "RETRY_DEBOUNCE_MS", "J", "HIDE_DEBOUNCE_MS", "FOREGROUND_RECHECK_MS", "", "TAG", "Ljava/lang/String;", "JANK_TAG", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/amap/MapSlotVisibilityRetry$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            MapSlotVisibilityRetry.this.m();
            MapSlotVisibilityRetry.this.x();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            MapSlotVisibilityRetry.this.y();
            MapSlotVisibilityRetry.this.k();
            MapSlotVisibilityRetry.this.q(VisState.OUT);
        }
    }

    public MapSlotVisibilityRetry(FrameLayout slot, InterfaceC5063a<Boolean> shouldRetry, InterfaceC5063a<Y8.t> retry, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC5063a<Y8.t> interfaceC5063a2) {
        kotlin.jvm.internal.p.i(slot, "slot");
        kotlin.jvm.internal.p.i(shouldRetry, "shouldRetry");
        kotlin.jvm.internal.p.i(retry, "retry");
        this.slot = slot;
        this.shouldRetry = shouldRetry;
        this.retry = retry;
        this.onVisible = interfaceC5063a;
        this.onHidden = interfaceC5063a2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.foregroundListener = new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.I
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return MapSlotVisibilityRetry.p(this.f27211a, ((Boolean) obj).booleanValue());
            }
        };
        this.attachListener = new b();
    }

    public static final void n(MapSlotVisibilityRetry mapSlotVisibilityRetry) {
        mapSlotVisibilityRetry.x();
    }

    public static final void o(MapSlotVisibilityRetry mapSlotVisibilityRetry) {
        mapSlotVisibilityRetry.x();
    }

    public static final Y8.t p(MapSlotVisibilityRetry mapSlotVisibilityRetry, boolean z10) {
        if (z10) {
            mapSlotVisibilityRetry.x();
            mapSlotVisibilityRetry.t();
        } else {
            mapSlotVisibilityRetry.k();
            mapSlotVisibilityRetry.j();
            mapSlotVisibilityRetry.l(VisState.OUT);
        }
        return Y8.t.f7040a;
    }

    public static final void r(MapSlotVisibilityRetry mapSlotVisibilityRetry) {
        mapSlotVisibilityRetry.hideDebounceRunnable = null;
        if (mapSlotVisibilityRetry.watching) {
            mapSlotVisibilityRetry.l(mapSlotVisibilityRetry.s());
        }
    }

    public static final void u(MapSlotVisibilityRetry mapSlotVisibilityRetry) {
        mapSlotVisibilityRetry.foregroundRecheckRunnable = null;
        if (mapSlotVisibilityRetry.watching) {
            mapSlotVisibilityRetry.x();
        }
    }

    public final void j() {
        Runnable runnable = this.foregroundRecheckRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.foregroundRecheckRunnable = null;
    }

    public final void k() {
        Runnable runnable = this.hideDebounceRunnable;
        if (runnable != null) {
            this.mainHandler.removeCallbacks(runnable);
        }
        this.hideDebounceRunnable = null;
    }

    public final void l(VisState state) {
        VisState visState = VisState.OUT;
        VisState visState2 = state;
        if (visState2 == visState) {
            C2414z c2414z = C2414z.INSTANCE;
            if (c2414z.f(this.slot)) {
                visState2 = c2414z.d(this.slot) ? VisState.CAPTURE_READY : VisState.WARM;
            }
        }
        VisState visState3 = this.lastState;
        if (visState3 == visState2) {
            return;
        }
        boolean z10 = (visState3 == null || visState3 == visState) ? false : true;
        boolean z11 = visState2 != visState;
        this.lastState = visState2;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z11 && !z10) {
            C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " VIS_ON prev=" + visState3 + " state=" + visState2 + " slot=" + this.slot.getWidth() + "x" + this.slot.getHeight() + " attached=" + this.slot.isAttachedToWindow() + " " + C2414z.INSTANCE.b(this.slot), false, 4, null);
            InterfaceC5063a<Y8.t> interfaceC5063a = this.onVisible;
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
                return;
            }
            return;
        }
        if (z11 || !z10) {
            C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " VIS_LEVEL " + visState3 + "->" + visState2, false, 4, null);
            return;
        }
        C4148a.k("MapScrollJank", "t=" + jElapsedRealtime + " VIS_OFF prev=" + visState3 + " slot=" + this.slot.getWidth() + "x" + this.slot.getHeight() + " attached=" + this.slot.isAttachedToWindow() + " " + C2414z.INSTANCE.b(this.slot), false, 4, null);
        InterfaceC5063a<Y8.t> interfaceC5063a2 = this.onHidden;
        if (interfaceC5063a2 != null) {
            interfaceC5063a2.invoke();
        }
    }

    public final void m() {
        if (this.watching && this.slot.isAttachedToWindow()) {
            ViewTreeObserver viewTreeObserver = this.slot.getViewTreeObserver();
            if (viewTreeObserver.isAlive() && this.registeredObserver != viewTreeObserver) {
                y();
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.F
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public final void onScrollChanged() {
                        MapSlotVisibilityRetry.n(this.f27207a);
                    }
                };
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.G
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        MapSlotVisibilityRetry.o(this.f27209a);
                    }
                };
                this.scrollListener = onScrollChangedListener;
                this.layoutListener = onGlobalLayoutListener;
                this.registeredObserver = viewTreeObserver;
                viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public final void q(VisState state) {
        VisState visState = VisState.OUT;
        if (state != visState) {
            k();
            l(state);
        } else if (this.lastState != visState && this.hideDebounceRunnable == null) {
            Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.H
                @Override // java.lang.Runnable
                public final void run() {
                    MapSlotVisibilityRetry.r(this.f27210a);
                }
            };
            this.hideDebounceRunnable = runnable;
            this.mainHandler.postDelayed(runnable, 280L);
        }
    }

    public final VisState s() {
        if (!this.slot.isAttachedToWindow()) {
            return VisState.OUT;
        }
        C2414z c2414z = C2414z.INSTANCE;
        return c2414z.d(this.slot) ? VisState.CAPTURE_READY : c2414z.f(this.slot) ? VisState.WARM : VisState.OUT;
    }

    public final void t() {
        j();
        Runnable runnable = new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.amap.J
            @Override // java.lang.Runnable
            public final void run() {
                MapSlotVisibilityRetry.u(this.f27212a);
            }
        };
        this.foregroundRecheckRunnable = runnable;
        this.mainHandler.postDelayed(runnable, 350L);
    }

    public final void v() {
        if (this.watching) {
            m();
            x();
            return;
        }
        this.watching = true;
        this.slot.addOnAttachStateChangeListener(this.attachListener);
        Context applicationContext = this.slot.getContext().getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            C2411w.INSTANCE.f(application);
        }
        C2411w.INSTANCE.d(this.foregroundListener);
        m();
        x();
    }

    public final void w() {
        if (this.watching) {
            this.watching = false;
            this.lastState = null;
            k();
            j();
            C2411w.INSTANCE.g(this.foregroundListener);
            this.slot.removeOnAttachStateChangeListener(this.attachListener);
            y();
        }
    }

    public final void x() {
        if (this.watching) {
            if (!this.slot.isAttachedToWindow()) {
                k();
                l(VisState.OUT);
                return;
            }
            VisState visStateS = s();
            q(visStateS);
            if (visStateS == VisState.CAPTURE_READY && this.shouldRetry.invoke().booleanValue()) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jElapsedRealtime - this.lastRetryElapsed < 400) {
                    return;
                }
                this.lastRetryElapsed = jElapsedRealtime;
                C4148a.k(TAG, "retry fire " + C2414z.INSTANCE.b(this.slot), false, 4, null);
                this.retry.invoke();
            }
        }
    }

    public final void y() {
        ViewTreeObserver viewTreeObserver = this.registeredObserver;
        this.registeredObserver = null;
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.scrollListener;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.layoutListener;
        this.scrollListener = null;
        this.layoutListener = null;
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        if (onScrollChangedListener != null) {
            viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
        }
        if (onGlobalLayoutListener != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }
}
