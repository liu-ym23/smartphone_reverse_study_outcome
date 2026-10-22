package com.bytedance.android.livesdk.interactivity.barrage.carnival;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.ChatCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ShowFinishType;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui.ChatCarnivalView;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.crash.Npth;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import f52.j;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r52.g0;

/* JADX INFO: loaded from: classes9.dex */
public final class DanmakuCarnivalManager implements o22.d, f52.e {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f133884y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f133885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.b f133886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f133887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f133888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f133889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f133890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f133891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.barrage.model.a f133892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f133893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f52.b f133894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f133895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Handler f133896l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o22.c f133897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Disposable f133898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Disposable f133899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f133900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f133901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f133902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f133903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f133904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f133905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final StateMachine<State, Event, SideEffect> f133906v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f133907w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DataCenter f133908x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0005\u0006\u0007\b\t\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0007\f\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "", "()V", "toString", "", "Carnival", "Countdown", "End", "Start", "StartEnd", "Stop", "WarmUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Carnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$End;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$StartEnd;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Stop;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$WarmUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class Event {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Carnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Carnival extends Event {
            public static final Carnival INSTANCE = null;

            private Carnival() {
                super(null);
            }

            static {
                INSTANCE = new Carnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "directIn", "", "(Z)V", "getDirectIn", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Countdown extends Event {
            private final boolean directIn;

            public static /* synthetic */ Countdown copy$default(Countdown r100, boolean r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.directIn;
            L6:
                return r100.copy(r101);
            }

            public final boolean component1() {
                return this.directIn;
            }

            public final Countdown copy(boolean r100) {
                return new Countdown(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Countdown) == true) goto L6;
                return false;
            L6:
                if (this.directIn == ((Countdown) r100).directIn) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                boolean r100 = this.directIn;
                if (r100 == false) goto L6;
                return 1;
            L6:
                return r100 ? 1 : 0;
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.Event
            public String toString() {
                return "Countdown(directIn=" + this.directIn + ")";
            }

            public final boolean getDirectIn() {
                return this.directIn;
            }

            public Countdown(boolean r100) {
                super(null);
                this.directIn = r100;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$End;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class End extends Event {
            public static final End INSTANCE = null;

            private End() {
                super(null);
            }

            static {
                INSTANCE = new End();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "component1", "msg", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "getMsg", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Start extends Event {
            private final com.bytedance.android.livesdk.interactivity.api.barrage.model.a msg;

            public static /* synthetic */ Start copy$default(Start r100, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.msg;
            L6:
                return r100.copy(r101);
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a component1() {
                return this.msg;
            }

            public final Start copy(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                return new Start(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Start) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.msg, ((Start) r100).msg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100 = this.msg;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.Event
            public String toString() {
                return "Start(msg=" + this.msg + ")";
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getMsg() {
                return this.msg;
            }

            public Start(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                super(null);
                this.msg = r100;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$StartEnd;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StartEnd extends Event {
            public static final StartEnd INSTANCE = null;

            private StartEnd() {
                super(null);
            }

            static {
                INSTANCE = new StartEnd();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$Stop;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Stop extends Event {
            public static final Stop INSTANCE = null;

            private Stop() {
                super(null);
            }

            static {
                INSTANCE = new Stop();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event$WarmUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$Event;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmUp extends Event {
            public static final WarmUp INSTANCE = null;

            private WarmUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmUp();
            }
        }

        private Event() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ Event(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "", "()V", "toString", "", "EndingCarnival", "InCarnival", "StartCountdown", "Started", "StopCarnival", "WarmingUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$EndingCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StartCountdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$Started;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StopCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$WarmingUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class SideEffect {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$EndingCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class EndingCarnival extends SideEffect {
            public static final EndingCarnival INSTANCE = null;

            private EndingCarnival() {
                super(null);
            }

            static {
                INSTANCE = new EndingCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class InCarnival extends SideEffect {
            public static final InCarnival INSTANCE = null;

            private InCarnival() {
                super(null);
            }

            static {
                INSTANCE = new InCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StartCountdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "directIn", "", "(Z)V", "getDirectIn", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StartCountdown extends SideEffect {
            private final boolean directIn;

            public static /* synthetic */ StartCountdown copy$default(StartCountdown r100, boolean r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.directIn;
            L6:
                return r100.copy(r101);
            }

            public final boolean component1() {
                return this.directIn;
            }

            public final StartCountdown copy(boolean r100) {
                return new StartCountdown(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof StartCountdown) == true) goto L6;
                return false;
            L6:
                if (this.directIn == ((StartCountdown) r100).directIn) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                boolean r100 = this.directIn;
                if (r100 == false) goto L6;
                return 1;
            L6:
                return r100 ? 1 : 0;
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.SideEffect
            public String toString() {
                return "StartCountdown(directIn=" + this.directIn + ")";
            }

            public final boolean getDirectIn() {
                return this.directIn;
            }

            public StartCountdown(boolean r100) {
                super(null);
                this.directIn = r100;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$Started;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "component1", "msg", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "getMsg", "()Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "<init>", "(Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Started extends SideEffect {
            private final com.bytedance.android.livesdk.interactivity.api.barrage.model.a msg;

            public static /* synthetic */ Started copy$default(Started r100, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r101, int r102, Object r103) {
                if ((r102 & 1) == 0) goto L6;
                r101 = r100.msg;
            L6:
                return r100.copy(r101);
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a component1() {
                return this.msg;
            }

            public final Started copy(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                return new Started(r100);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof Started) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.msg, ((Started) r100).msg) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public int hashCode() {
                com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100 = this.msg;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            @Override // com.bytedance.android.livesdk.interactivity.barrage.carnival.DanmakuCarnivalManager.SideEffect
            public String toString() {
                return "Started(msg=" + this.msg + ")";
            }

            public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getMsg() {
                return this.msg;
            }

            public Started(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
                Intrinsics.checkNotNullParameter(r100, "msg");
                super(null);
                this.msg = r100;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$StopCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class StopCarnival extends SideEffect {
            public static final StopCarnival INSTANCE = null;

            private StopCarnival() {
                super(null);
            }

            static {
                INSTANCE = new StopCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect$WarmingUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$SideEffect;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmingUp extends SideEffect {
            public static final WarmingUp INSTANCE = null;

            private WarmingUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmingUp();
            }
        }

        private SideEffect() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ SideEffect(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "", "()V", "toString", "", "Countdown", "Ending", "Idle", "InCarnival", "Start", "WarmUp", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Ending;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Idle;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$WarmUp;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Countdown;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Countdown extends State {
            public static final Countdown INSTANCE = null;

            private Countdown() {
                super(null);
            }

            static {
                INSTANCE = new Countdown();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Ending;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Ending extends State {
            public static final Ending INSTANCE = null;

            private Ending() {
                super(null);
            }

            static {
                INSTANCE = new Ending();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Idle;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Idle extends State {
            public static final Idle INSTANCE = null;

            private Idle() {
                super(null);
            }

            static {
                INSTANCE = new Idle();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$InCarnival;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class InCarnival extends State {
            public static final InCarnival INSTANCE = null;

            private InCarnival() {
                super(null);
            }

            static {
                INSTANCE = new InCarnival();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$Start;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Start extends State {
            public static final Start INSTANCE = null;

            private Start() {
                super(null);
            }

            static {
                INSTANCE = new Start();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State$WarmUp;", "Lcom/bytedance/android/livesdk/interactivity/barrage/carnival/DanmakuCarnivalManager$State;", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class WarmUp extends State {
            public static final WarmUp INSTANCE = null;

            private WarmUp() {
                super(null);
            }

            static {
                INSTANCE = new WarmUp();
            }
        }

        private State() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }

        public /* synthetic */ State(DefaultConstructorMarker r100) {
            this();
        }
    }

    public final class a extends j<com.bytedance.android.livesdk.interactivity.api.barrage.model.a> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ DanmakuCarnivalManager f133909n;

        @Override // f52.c
        public final void a(DiscardReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            DanmakuCarnivalManager r101 = this.f133909n;
            String r102 = ((com.bytedance.android.livesdk.interactivity.api.barrage.model.a) this.f475631m).getMessageId() + " is discard. reason=" + r100;
            int r103 = DanmakuCarnivalManager.f133884y;
            r101.l(r102);
        }

        @Override // f52.c
        public final void h(f52.b r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            DanmakuCarnivalManager r101 = this.f133909n;
            r101.f133895k = this;
            StateMachine<State, Event, SideEffect> r102 = r101.f133906v;
            Event.Start r103 = new Event.Start((com.bytedance.android.livesdk.interactivity.api.barrage.model.a) this.f475631m);
            StateMachine.a r104 = StateMachine.f66079c;
            r102.d(r103, null);
        }

        @Override // f52.c
        public final CleanStrategy i(f52.b r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            DanmakuCarnivalManager r101 = this.f133909n;
            int r102 = DanmakuCarnivalManager.f133884y;
            r101.l("onShowFinish");
            return CleanStrategy.NONE;
        }

        public a(DanmakuCarnivalManager r110, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r111) {
            Intrinsics.checkNotNullParameter(r111, "msg");
            this.f133909n = r110;
            String r100 = "carnival_" + r111.getMessageId();
            NativePSTopViewType r101 = NativePSTopViewType.ChatCarnival;
            ConflictStrategy r112 = ConflictStrategy.DISCARD;
            super(r100, r101, 0, 0, 0, 0, 0, r112, r112, ConflictStrategy.INTERRUPT, false, r111.getHighlightAreaPriorityConfig(), r111, 1024);
        }

        @Override // f52.c
        public final CleanStrategy b(f52.b r100, f52.c r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            DanmakuCarnivalManager r102 = this.f133909n;
            int r103 = DanmakuCarnivalManager.f133884y;
            r102.l("onInterrupt");
            DanmakuCarnivalManager r104 = this.f133909n;
            r104.f133895k = null;
            r104.reset();
            return CleanStrategy.NONE;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DanmakuCarnivalManager f133910a;

        public c(DanmakuCarnivalManager r100) {
            this.f133910a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r100 = this.f133910a.f133906v;     // Catch: Throwable -> L4
            Event.Countdown r101 = new Event.Countdown(false);     // Catch: Throwable -> L4
            StateMachine.a r102 = StateMachine.f66079c;     // Catch: Throwable -> L4
            r100.d(r101, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DanmakuCarnivalManager f133911a;

        public d(DanmakuCarnivalManager r100) {
            this.f133911a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r100 = this.f133911a.f133906v;     // Catch: Throwable -> L4
            Event.StartEnd r101 = Event.StartEnd.INSTANCE;     // Catch: Throwable -> L4
            StateMachine.a r102 = StateMachine.f66079c;     // Catch: Throwable -> L4
            r100.d(r101, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DanmakuCarnivalManager f133912a;

        public e(DanmakuCarnivalManager r100) {
            this.f133912a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            StateMachine<State, Event, SideEffect> r100 = this.f133912a.f133906v;     // Catch: Throwable -> L4
            Event.Carnival r101 = Event.Carnival.INSTANCE;     // Catch: Throwable -> L4
            StateMachine.a r102 = StateMachine.f66079c;     // Catch: Throwable -> L4
            r100.d(r101, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DanmakuCarnivalManager f133913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.data.d f133914b;

        public f(DanmakuCarnivalManager r100, com.bytedance.android.livesdk.interactivity.api.barrage.data.d r101) {
            this.f133913a = r100;
            this.f133914b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f133913a.k().addFirst(this.f133914b);     // Catch: Throwable -> L4
            this.f133913a.o();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final LimitQueue<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> k() {
        return (LimitQueue) this.f133893i.getValue();
    }

    @Override // f52.d
    public final void onUnload() {
        this.f133894j = null;
        l("onUnload");
    }

    @Override // o22.d
    public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a c() {
        if (this.f133889e == false) goto L11;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100 = this.f133892h;
        if (r100 == null) goto L7;
        long r101 = r100.getMessageId();
    L9:
        if (r101 <= 0) goto L11;
        return this.f133892h;
    L7:
        r101 = 0;
    L11:
        return null;
    }

    @Override // o22.d
    public final void init() {
        if (this.f133887c == false) goto L5;
        return;
    L5:
        if (this.f133888d == true) goto L33;
        l("init");
        boolean r100 = true;
        this.f133888d = true;
        if (a0.l(this.f133908x, true) == false) goto L10;
    L19:
        r100 = false;
    L20:
        this.f133890f = r100;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r101 = this.f133886b;
        if (r101 == null) goto L25;
        com.bytedance.live.datacontext.j<ChatCarnivalDataSyncModel> r102 = r101.getChatCarnivalSyncModel();
        if (r102 == null) goto L25;
        r102.c(new AnonymousClass1(this));
    L25:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r103 = this.f133886b;
        if (r103 == null) goto L30;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r104 = r103.getGeneralCarnivalSyncModel();
        if (r104 == null) goto L30;
        r104.c(new AnonymousClass2(this));
    L30:
        this.f133902r = g0.f536182a.getValue().booleanValue();
        q(null);
        return;
    L10:
        if (rf2.a.a() == true) goto L19;
        int r105 = a1.f133760a;
        if (a1.a.a().d() == false) goto L19;
        BarrageSetting r106 = l42.a.f507317d.getValue();
        if (r106 == null) goto L19;
        if (r106.isCarnivalBarrageOpen() == true) goto L19;
    }

    public final boolean m() {
        o r100 = this.f133885a;
        if (r100 == null) goto L5;
        Boolean r101 = r100.isPortraitInteraction();
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == true) goto L9;
    L21:
        return false;
    L9:
        if (this.f133885a.isVSFirstShow() == false) goto L21;
        IVSPlayerService r102 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r102 == null) goto L21;
        IPlayerProgressService r103 = r102.provideVSProgressService(this.f133908x);
        if (r103 == null) goto L21;
        PlayerProgressServiceContext r104 = r103.provideContext(this.f133908x);
        if (r104 == null) goto L21;
        m<Boolean> r105 = r104.getAtLatest();
        if (r105 == null) goto L21;
        if (r105.getValue().booleanValue() == true) goto L21;
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final void o() {
        if (this.f133897m != null) goto L5;
        l("processNextMsg release=" + this.f133887c + " disabled=" + this.f133890f + " running=" + this.f133889e + " msgNum=" + k().size() + " listener not set");
    L7:
        if (this.f133887c == false) goto L9;
        return;
    L9:
        if (this.f133890f == true) goto L18;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r100 = k().poll();
        if (r100 != null) goto L13;
        return;
    L13:
        if (this.f133889e == false) goto L15;
        l("carnival is running. discard msg. id=" + r100.getMessageId());
        return;
    L15:
        n(r100);
        return;
    L18:
        return;
    L5:
        l("processNextMsg release=" + this.f133887c + " disabled=" + this.f133890f + " running=" + this.f133889e + " msgNum=" + k().size() + " listener set");
        goto L7
    }

    @Override // o22.d
    public final void release() {
        if (this.f133887c == false) goto L5;
        return;
    L5:
        l("release");
        this.f133887c = true;
        this.f133888d = false;
        this.f133897m = null;
        Disposable r100 = this.f133898n;
        if (r100 == null) goto L8;
        r100.dispose();
    L8:
        Disposable r101 = this.f133899o;
        if (r101 == null) goto L11;
        r101.dispose();
    L11:
        k().clear();
        this.f133896l.removeCallbacksAndMessages(null);
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r102 = this.f133886b;
        if (r102 == null) goto L14;
        r(r102, C100481.INSTANCE);
    L14:
        this.f133889e = false;
        this.f133900p = -1;
        this.f133895k = null;
        this.f133894j = null;
        q(null);
    }

    @Override // o22.d
    public final void reset() {
        if (this.f133887c == false) goto L5;
        return;
    L5:
        if (this.f133888d == false) goto L16;
        l(BasicTestActionHandler.TEST_ACTION_RESET);
        Disposable r100 = this.f133898n;
        if (r100 == null) goto L10;
        r100.dispose();
    L10:
        Disposable r101 = this.f133899o;
        if (r101 == null) goto L13;
        r101.dispose();
    L13:
        k().clear();
        this.f133896l.removeCallbacksAndMessages(null);
        StateMachine<State, Event, SideEffect> r102 = this.f133906v;
        Event.Stop r103 = Event.Stop.INSTANCE;
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
        this.f133888d = false;
        return;
    }

    @Override // o22.d
    public final boolean a() {
        return c() instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
    }

    @Override // o22.d
    public final boolean i() {
        return c() instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.d;
    }

    @Override // o22.d
    public final long e() {
        return this.f133900p;
    }

    @Override // f52.d
    public final String getId() {
        return this.f133907w;
    }

    public DanmakuCarnivalManager(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f133908x = r100;
        IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r101 == null) goto L5;
        o r102 = IRoomContextService.a.a(r101, r100, 0, 2);
    L6:
        this.f133885a = r102;
        this.f133886b = q.b();
        this.f133893i = LazyKt.lazy(DanmakuCarnivalManager$msgQueue$2.INSTANCE);
        this.f133896l = new Handler(Looper.getMainLooper());
        this.f133900p = -1;
        this.f133903s = new e(this);
        this.f133904t = new d(this);
        this.f133905u = new c(this);
        StateMachine.a r103 = StateMachine.f66079c;
        Function1<StateMachine.GraphBuilder<State, Event, SideEffect>, Unit> r104 = new DanmakuCarnivalManager$stateMachine$1(this);
        r103.getClass();
        this.f133906v = StateMachine.a.a(r104);
        this.f133907w = "DanmakuCarnivalManager";
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // o22.d
    public final void b(boolean r100) {
        if (this.f133887c == false) goto L5;
        return;
    L5:
        if (r100 != this.f133890f) goto L7;
        return;
    L7:
        if (a0.l(this.f133908x, true) == true) goto L40;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r101 = null;
        if (r100 == false) goto L19;
        this.f133890f = true;
        if (this.f133889e == false) goto L18;
        StringBuilder r102 = new StringBuilder("disable carnival danmaku and force stop carnival. msgId=");
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r103 = this.f133892h;
        if (r103 == null) goto L16;
        Long r104 = Long.valueOf(r103.getMessageId());
    L17:
        r102.append(r104);
        l(r102.toString());
        StateMachine<State, Event, SideEffect> r105 = this.f133906v;
        Event.Stop r106 = Event.Stop.INSTANCE;
        StateMachine.a r107 = StateMachine.f66079c;
        r105.d(r106, null);
        return;
    L16:
        r104 = null;
        goto L17
    L18:
        l("disable carnival danmaku");
        return;
    L19:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r108 = this.f133886b;
        if (r108 == null) goto L24;
        n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r109 = r108.getChatCarnivalMessage();
        if (r109 == null) goto L24;
        r101 = r109.getValue();
    L24:
        this.f133890f = false;
        if (r101 != null) goto L27;
    L33:
        l("enable carnival");
        o();
        return;
    L27:
        if (r101.getMessageId() <= 0) goto L33;
        if (r101.x() != 0) goto L31;
    L32:
        l("enable and resume carnival. msgId=" + r101.getMessageId());
        n(r101);
        return;
    L31:
        if (r101.n() <= 10000) goto L33;
    }

    @Override // o22.d
    public final void f(o22.c r100) {
        if (r100 == null) goto L4;
        l("setListener");
    L6:
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L11:
        this.f133897m = r100;
        if (r101 == true) goto L14;
        return;
    L14:
        if (this.f133888d == true) goto L16;
        return;
    L16:
        if ((!Intrinsics.areEqual(this.f133906v.b(), State.Idle.INSTANCE)) == false) goto L34;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r102 = this.f133892h;
        if (r102 == null) goto L38;
        o22.c r103 = this.f133897m;
        if (r103 == null) goto L35;
        l("syncListenerState to " + this.f133906v.b());
        State r104 = this.f133906v.b();
        if (Intrinsics.areEqual(r104, State.WarmUp.INSTANCE) == false) goto L26;
        r103.g(this, r102, true);
        r103.f(this, r102);
        return;
    L26:
        if (Intrinsics.areEqual(r104, State.InCarnival.INSTANCE) == false) goto L37;
        r103.g(this, r102, this.f133891g);
        if (this.f133891g == false) goto L30;
        r103.f(this, r102);
    L30:
        r103.d(this, r102);
        return;
    L37:
        return;
    L35:
        return;
    L38:
        return;
    L34:
        return;
    L8:
        if ((!Intrinsics.areEqual(this.f133897m, r100)) == false) goto L10;
        r101 = true;
        goto L11
    L4:
        l("setListener null");
        goto L6
    }

    @Override // f52.e
    public final void g(f52.c r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getType().getPriority() <= NativePSTopViewType.ChatCarnival.getPriority()) goto L6;
        reset();
        return;
    }

    @Override // f52.d
    public final void j(f52.b r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        l(WidgetCostModule.TYPE_ON_LOAD);
        this.f133894j = r100;
        r100.f(this);
    }

    public final void l(String r100) {
        ALogger.i("DanmakuCarnivalManager", r100);
    }

    public final void n(com.bytedance.android.livesdk.interactivity.api.barrage.data.d r110) {
        if (m() == false) goto L5;
        return;
    L5:
        o r100 = this.f133885a;
        if (r100 == null) goto L50;
        m<IRoom> r101 = r100.getRoom();
        if (r101 == null) goto L50;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L50;
        IRoomAuthStatus r103 = r102.getRoomAuthStatus();
        if (r103 == null) goto L50;
        if (r103.isEnableLandscapeChat() != true) goto L50;
        if (this.f133887c == false) goto L19;
        return;
    L19:
        if ((r110 instanceof com.bytedance.android.livesdk.interactivity.api.barrage.data.d) == true) goto L22;
        return;
    L22:
        if (r110.A(a0.l(this.f133908x, true)) == true) goto L30;
        if (a0.l(this.f133908x, true) == false) goto L26;
        String r104 = "portrait";
    L27:
        ALogger.e("DanmakuCarnivalManager", "on carnival message. not support in " + r104 + ". supportShowType=" + r110.w());
        return;
    L26:
        r104 = "landscape";
        goto L27
    L30:
        if (r110.x() == 0) goto L36;
        if (r110.n() > 10000) goto L36;
        l("on carnival message, real duration <= 10s, return");
        return;
    L36:
        if (Intrinsics.areEqual(this.f133906v.b(), State.Idle.INSTANCE) == true) goto L39;
        l("is in carnival current now. discard msg. id=" + r110.getMessageId());
        return;
    L39:
        long r105 = (r110.x() * ((long) 1000)) - (com.bytedance.android.livesdk.utils.ntp.a.f159087a + System.currentTimeMillis());
        if (r105 <= 0) goto L43;
        this.f133896l.postDelayed(new f(this, r110), r105);
        l("dispatch carnival message, delay to add to msg queue timediff = " + r105);
        return;
    L43:
        if (this.f133890f == false) goto L45;
        k().add(r110);
        l("dispatch carnival message. isCarnivalRunning=" + this.f133889e + " disabled=" + this.f133890f);
        return;
    L45:
        if (r110.n() <= 10000) goto L47;
        p(r110);
        l("dispatch carnival message. userStartTimestamp = " + r110.x() + ". start");
        return;
    L47:
        l("dispatch carnival message. message timeout. realDuration=" + r110.n());
        return;
    L50:
        l("landscape_chat is close, intercept carnival message");
    }

    public final void p(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
        f52.b r101 = this.f133894j;
        if (r101 == null) goto L5;
        r101.a(new a(this, r100));
        return;
    L5:
        StateMachine<State, Event, SideEffect> r102 = this.f133906v;
        Event.Start r103 = new Event.Start(r100);
        StateMachine.a r104 = StateMachine.f66079c;
        r102.d(r103, null);
    }

    public final void q(String r100) {
        if (this.f133902r == true) goto L10;
        return;
    L10:
        Npth.addTags(MapsKt.mapOf(TuplesKt.to("live_comment_activity", r100)));     // Catch: Exception -> L7
        l("update monitor tag " + r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        SafetyGuard.a("carnival add monitor tag failed", e, null);
        ALogger.e("DanmakuCarnivalManager", "update monitor tag " + r100 + " failed", e);
    }

    public static void r(com.bytedance.android.livesdk.interactivity.api.publicscreen.b r100, Function1 r101) {
        if (r100.hasCleared() == true) goto L6;
        r101.invoke(r100);
        return;
    }

    @Override // f52.e
    public final void d(f52.c r100, ShowFinishType r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r101 != ShowFinishType.DESTROY) goto L5;
        return;
    L5:
        if (r101 != ShowFinishType.INTERRUPT) goto L7;
        return;
    L7:
        if (r100.getType().getPriority() <= NativePSTopViewType.ChatCarnival.getPriority()) goto L12;
        init();
        return;
    }

    @Override // o22.d
    public final void h(ChatCarnivalView r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        a r102 = this.f133895k;
        if (r102 == null) goto L8;
        f52.b r103 = this.f133894j;
        if (r103 == null) goto L9;
        r103.b(r102, r100, r101);
        return;
    L9:
        return;
    }
}
