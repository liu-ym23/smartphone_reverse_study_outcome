package com.bytedance.android.livesdk.wgamex.gameinvite;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.message.model.z4;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 I2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\f\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\bJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u001a\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0016\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0011J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J(\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00190\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0011JJ\u0010\"\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00042:\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00110\u001eJ\b\u0010#\u001a\u00020\u0011H\u0014R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010%\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00107\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000e8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010=\u001a\u0010\u0012\f\u0012\n <*\u0004\u0018\u00010\u000e0\u000e0;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/wgamex/gameinvite/AnchorInviteViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/livesdk/message/model/z4$a;", "inviteItem", "", "getCheckStatusDelay", "roomId", "userId", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/j;", "queryProfileInviteStatus", "Lio/reactivex/disposables/Disposable;", "", "bindViewModel", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/i;", "stateChanged", "state", "", BasicTestActionHandler.TEST_ACTION_RESET, "Lcom/bytedance/android/livesdk/message/model/z4$b;", "switch", "updateState", "cancel", "inviteAll", "observeProfileInviteState", "Lkotlin/Pair;", "", "observeProfileInviteStateSimply", "profileInvite", "checkStatus", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "enterRoom", "onCleared", "gameId", "J", "getGameId", "()J", "setGameId", "(J)V", "getRoomId", "setRoomId", "playKind", "getPlayKind", "setPlayKind", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/l;", "gameConfig", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/l;", "getGameConfig", "()Lcom/bytedance/android/livesdk/wgamex/gameinvite/l;", "setGameConfig", "(Lcom/bytedance/android/livesdk/wgamex/gameinvite/l;)V", "value", "_state", "Lcom/bytedance/android/livesdk/wgamex/gameinvite/i;", "set_state", "(Lcom/bytedance/android/livesdk/wgamex/gameinvite/i;)V", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "_stateChange", "Lio/reactivex/subjects/BehaviorSubject;", "countDownCheckDisposable", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/CompositeDisposable;", "viewModelTasks$delegate", "Lkotlin/Lazy;", "getViewModelTasks", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModelTasks", "<init>", "()V", "Companion", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInviteViewModel extends ViewModel {
    public static final b Companion = null;
    public static final String TAG = "AnchorInviteViewModel";
    private com.bytedance.android.livesdk.wgamex.gameinvite.i _state;
    private final BehaviorSubject<com.bytedance.android.livesdk.wgamex.gameinvite.i> _stateChange;
    private Disposable countDownCheckDisposable;
    private l gameConfig;
    private long gameId;
    private long playKind;
    private long roomId;
    private final Lazy viewModelTasks$delegate;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160673a;

        public a(AnchorInviteViewModel r100) {
            this.f160673a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Pair r111 = (Pair) r110;
            com.bytedance.android.livesdk.wgamex.gameinvite.i r100 = (com.bytedance.android.livesdk.wgamex.gameinvite.i) r111.component1();
            com.bytedance.android.livesdk.wgamex.gameinvite.i r112 = (com.bytedance.android.livesdk.wgamex.gameinvite.i) r111.component2();
            Disposable r101 = AnchorInviteViewModel.access$getCountDownCheckDisposable$p(this.f160673a);
            if (r101 == null) goto L6;
            r101.dispose();
        L6:
            if ((r112 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == false) goto L17;
            if ((r100 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == true) goto L12;
            com.bytedance.android.livesdk.wgamex.gameinvite.i.d r102 = (com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r112;
            if (r102.f160737b.c() != 3) goto L12;
            int r103 = iv2.a.f495927a;
            iv2.a.b(r102.f160736a.c(), r102.f160736a.f(), r102.f160736a.h(), r102.f160737b.b(), true, 2);
        L12:
            long r104 = AnchorInviteViewModel.access$getCheckStatusDelay(this.f160673a, ((com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r112).f160737b);
            if (r104 < 1) goto L25;
            AnchorInviteViewModel.access$setCountDownCheckDisposable$p(this.f160673a, Observable.timer(r104, TimeUnit.SECONDS).subscribe(new com.bytedance.android.livesdk.wgamex.gameinvite.c(this)));
            return;
        L25:
            return;
        L17:
            if ((r112 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.a) == false) goto L24;
            long r105 = AnchorInviteViewModel.access$getCheckStatusDelay(this.f160673a, ((com.bytedance.android.livesdk.wgamex.gameinvite.i.a) r112).f160734b);
            if (r105 < 1) goto L26;
            AnchorInviteViewModel.access$setCountDownCheckDisposable$p(this.f160673a, Observable.timer(r105, TimeUnit.SECONDS).subscribe(new com.bytedance.android.livesdk.wgamex.gameinvite.d(this)));
            return;
        L26:
            return;
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static com.bytedance.android.livesdk.wgamex.gameinvite.i b(z4.a r100, z4.b r101) {
            if (r101 == null) goto L4;
            Integer r102 = Integer.valueOf(r101.g());
        L6:
            if (r102 != null) goto L9;
        L20:
            if (r102 != null) goto L23;
        L25:
            if (r102 != null) goto L28;
        L31:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.i.c();
        L28:
            if (r102.intValue() != 2) goto L31;
        L29:
            new com.bytedance.android.livesdk.wgamex.gameinvite.i.c();
            goto L31
        L23:
            if (r102.intValue() != 0) goto L25;
        L9:
            if (r102.intValue() != 1) goto L20;
            if (r100 == null) goto L19;
            int r103 = r100.f();
            if (r103 == 1) goto L16;
            if (r103 != 2) goto L32;
            com.bytedance.android.livesdk.wgamex.gameinvite.i r104 = new com.bytedance.android.livesdk.wgamex.gameinvite.i.d(r101, r100);
        L33:
            return r104;
        L32:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.i.b(r101);
        L16:
            r104 = new com.bytedance.android.livesdk.wgamex.gameinvite.i.a(r101, r100);
            goto L33
        L19:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.i.b(r101);
        L4:
            r102 = null;
            goto L6
        }

        public static final com.bytedance.android.livesdk.wgamex.gameinvite.j a(b r100, com.bytedance.android.livesdk.wgamex.gameinvite.i r101, long r102, int r103) {
            r100.getClass();
            if ((r101 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == false) goto L11;
            if (r103 != 1) goto L7;
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 2);
        L7:
            if (((com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r101).f160737b.c() != 2) goto L25;
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 1);
        L25:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 3);
        L11:
            if ((r101 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.a) == false) goto L19;
            if (r103 != 1) goto L15;
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 2);
        L15:
            if (((com.bytedance.android.livesdk.wgamex.gameinvite.i.a) r101).f160734b.c() != 2) goto L28;
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 1);
        L28:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 3);
        L19:
            if ((r101 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.b) == false) goto L22;
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 1);
        L22:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(r102, 0);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160674a;

        public c(AnchorInviteViewModel r100) {
            this.f160674a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Response r100 = (Response) r110;
            if (r100 == null) goto L16;
            com.bytedance.android.livesdk.wgamex.gameinvite.f r101 = (com.bytedance.android.livesdk.wgamex.gameinvite.f) r100.data;
            if (r101 == null) goto L17;
            this.f160674a.updateState(r101.inviteItem, r101.f86switch);
            int r102 = n.f160743a;
            z4.b r103 = r101.f86switch;
            if (r103 == null) goto L9;
            long r104 = r103.h();
        L10:
            z4.a r105 = r101.inviteItem;
            if (r105 == null) goto L13;
            long r106 = r105.b();
        L14:
            n.a(true, 101, r104, r106, this.f160674a.getRoomId(), this.f160674a.getGameId(), this.f160674a.getPlayKind());
            return;
        L13:
            r106 = 0;
            goto L14
        L9:
            r104 = 0;
            goto L10
        L17:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160675a;

        public d(AnchorInviteViewModel r100) {
            this.f160675a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L8;
            com.bytedance.android.livesdk.wgamex.gameinvite.g r102 = (com.bytedance.android.livesdk.wgamex.gameinvite.g) r101.data;
            if (r102 == null) goto L9;
            this.f160675a.updateState(r102.inviteItem, r102.f87switch);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f160676a;

        public e(Function2 r100) {
            this.f160676a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            if (r101 == null) goto L8;
            com.bytedance.android.livesdk.wgamex.gameinvite.g r102 = (com.bytedance.android.livesdk.wgamex.gameinvite.g) r101.data;
            if (r102 == null) goto L9;
            this.f160676a.invoke(r102.inviteItem, r102.f87switch);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160677a;

        public f(AnchorInviteViewModel r100) {
            this.f160677a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r210) {
            Response r100 = (Response) r210;
            long r101 = 0;
            if (r100 == null) goto L15;
            com.bytedance.android.livesdk.wgamex.gameinvite.f r102 = (com.bytedance.android.livesdk.wgamex.gameinvite.f) r100.data;
            if (r102 == null) goto L15;
            com.bytedance.android.livesdk.wgamex.gameinvite.i r103 = this.f160677a.updateState(r102.inviteItem, r102.f86switch);
            z4.b r104 = r102.f86switch;
            if (r104 == null) goto L9;
            long r105 = r104.h();
        L11:
            if ((r103 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == false) goto L13;
            r101 = ((com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r103).f160737b.b();
            boolean r110 = true;
        L14:
            int r106 = iv2.a.f495927a;
            iv2.a.b(this.f160677a.getGameId(), (int) this.f160677a.getPlayKind(), r105, r101, r110, 1);
            int r107 = n.f160743a;
            n.a(false, 100, r105, r101, this.f160677a.getRoomId(), this.f160677a.getGameId(), this.f160677a.getPlayKind());
            return;
        L13:
            r110 = false;
            goto L14
        L9:
            r105 = 0;
        L15:
            AnchorInviteViewModel r108 = this.f160677a;
            com.bytedance.android.livesdk.wgamex.gameinvite.i r109 = r108.state();
            if ((r109 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.b) == false) goto L18;
            r101 = ((com.bytedance.android.livesdk.wgamex.gameinvite.i.b) r109).f160735a.h();
        L18:
            long r111 = r101;
            int r112 = iv2.a.f495927a;
            iv2.a.b(r108.getGameId(), (int) r108.getPlayKind(), r111, 0, false, 1);
            Unit r113 = Unit.INSTANCE;
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160678a;

        public g(AnchorInviteViewModel r100) {
            this.f160678a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            Throwable r111 = (Throwable) r110;
            com.bytedance.android.livesdk.wgamex.gameinvite.i r100 = this.f160678a.state();
            if ((r100 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.b) == false) goto L5;
            long r101 = ((com.bytedance.android.livesdk.wgamex.gameinvite.i.b) r100).f160735a.h();
        L6:
            long r102 = r101;
            int r103 = iv2.a.f495927a;
            iv2.a.b(this.f160678a.getGameId(), (int) this.f160678a.getPlayKind(), r102, 0, false, 1);
            if ((r111 instanceof CustomApiServerException) == false) goto L12;
            CustomApiServerException r112 = (CustomApiServerException) r111;
            if (TextUtils.isEmpty(r112.getPrompt()) == true) goto L13;
            f2.c(r112.getPrompt(), 0);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r101 = 0;
            goto L6
        }
    }

    public static final class h<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160679a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f160680b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f160681c;

        public h(AnchorInviteViewModel r100, long r101, long r102) {
            this.f160679a = r100;
            this.f160680b = r101;
            this.f160681c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.android.livesdk.wgamex.gameinvite.i r101 = (com.bytedance.android.livesdk.wgamex.gameinvite.i) r100;
            Intrinsics.checkNotNullParameter(r101, "state");
            if ((r101 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == false) goto L11;
            Long r102 = ((com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r101).f160738c;
            if (r102 == null) goto L16;
            long r103 = r102.longValue();
            long r104 = this.f160680b;
            if (r103 != r104) goto L16;
            return Observable.just(b.a(AnchorInviteViewModel.Companion, r101, r104, 1));
        L16:
            return AnchorInviteViewModel.access$queryProfileInviteStatus(this.f160679a, this.f160681c, this.f160680b);
        L11:
            if ((r101 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.c) == false) goto L14;
            return Observable.just(new com.bytedance.android.livesdk.wgamex.gameinvite.j(this.f160680b, 0));
        L14:
            return AnchorInviteViewModel.access$queryProfileInviteStatus(this.f160679a, this.f160681c, this.f160680b);
        }
    }

    public static final class i<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f160682a = null;

        static {
            f160682a = new i();
        }

        public i() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            com.bytedance.android.livesdk.wgamex.gameinvite.j r101 = (com.bytedance.android.livesdk.wgamex.gameinvite.j) r100;
            Intrinsics.checkNotNullParameter(r101, "t");
            return new Pair(Long.valueOf(r101.f160739a), Integer.valueOf(r101.f160740b));
        }
    }

    public static final class j<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorInviteViewModel f160683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f160684b;

        public j(AnchorInviteViewModel r100, long r101) {
            this.f160683a = r100;
            this.f160684b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Function
        public final Object apply(Object r210) {
            Response r100 = (Response) r210;
            Intrinsics.checkNotNullParameter(r100, "response");
            com.bytedance.android.livesdk.wgamex.gameinvite.f r101 = (com.bytedance.android.livesdk.wgamex.gameinvite.f) r100.data;
            long r102 = 0;
            if (r101 == null) goto L14;
            b r103 = AnchorInviteViewModel.Companion;
            z4.a r104 = r101.inviteItem;
            z4.b r105 = r101.f86switch;
            r103.getClass();
            com.bytedance.android.livesdk.wgamex.gameinvite.i r106 = b.b(r104, r105);
            z4.b r107 = r101.f86switch;
            if (r107 == null) goto L7;
            long r108 = r107.h();
        L9:
            if ((r106 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.d) == false) goto L11;
            com.bytedance.android.livesdk.wgamex.gameinvite.i.d r109 = (com.bytedance.android.livesdk.wgamex.gameinvite.i.d) r106;
            r109.f160738c = Long.valueOf(this.f160684b);
            r102 = r109.f160737b.b();
            int r110 = 1;
        L12:
            AnchorInviteViewModel.access$set_state$p(this.f160683a, r106);
            int r111 = iv2.a.f495927a;
            iv2.a.b(this.f160683a.getGameId(), (int) this.f160683a.getPlayKind(), r108, r102, r110, 3);
            int r112 = n.f160743a;
            n.a(true, 100, r108, r102, this.f160683a.getRoomId(), this.f160683a.getGameId(), this.f160683a.getPlayKind());
            return b.a(r103, r106, this.f160684b, r110);
        L11:
            r110 = 0;
            goto L12
        L7:
            r108 = 0;
            goto L9
        L14:
            com.bytedance.android.livesdk.wgamex.gameinvite.i r113 = this.f160683a.state();
            if ((r113 instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.b) == false) goto L17;
            r102 = ((com.bytedance.android.livesdk.wgamex.gameinvite.i.b) r113).f160735a.h();
        L17:
            int r114 = iv2.a.f495927a;
            iv2.a.b(this.f160683a.getGameId(), (int) this.f160683a.getPlayKind(), r102, 0, false, 3);
            throw new IllegalStateException();
        }
    }

    public static final class k<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f160685a;

        public k(long r100) {
            this.f160685a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            com.bytedance.android.livesdk.wgamex.gameinvite.h r102 = (com.bytedance.android.livesdk.wgamex.gameinvite.h) r101.data;
            if (r102 == null) goto L5;
            com.bytedance.android.livesdk.wgamex.gameinvite.e r103 = r102.candidate;
        L6:
            int r104 = 0;
            if (r103 == null) goto L13;
            b r105 = AnchorInviteViewModel.Companion;
            z4.a r106 = r102.inviteItem;
            z4.b r107 = r102.f88switch;
            r105.getClass();
            com.bytedance.android.livesdk.wgamex.gameinvite.i r108 = b.b(r106, r107);
            long r109 = this.f160685a;
            com.bytedance.android.livesdk.wgamex.gameinvite.e r110 = r102.candidate;
            if (r110 == null) goto L14;
            r104 = r110.status;
        L14:
            return b.a(r105, r108, r109, r104);
        L13:
            return new com.bytedance.android.livesdk.wgamex.gameinvite.j(this.f160685a, 0);
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        Companion = new b();
    }

    private final CompositeDisposable getViewModelTasks() {
        return (CompositeDisposable) this.viewModelTasks$delegate.getValue();
    }

    @JvmStatic
    public static final com.bytedance.android.livesdk.wgamex.gameinvite.i transformAnchorState(z4.a r100, z4.b r101) {
        Companion.getClass();
        return b.b(r100, r101);
    }

    public final void reset() {
        if ((this._state instanceof com.bytedance.android.livesdk.wgamex.gameinvite.i.c) == true) goto L5;
        set_state(new com.bytedance.android.livesdk.wgamex.gameinvite.i.c());
    L5:
        this.gameConfig = null;
        this.gameId = 0;
        this.playKind = 0;
    }

    public AnchorInviteViewModel() {
        com.bytedance.android.livesdk.wgamex.gameinvite.i.c r100 = new com.bytedance.android.livesdk.wgamex.gameinvite.i.c();
        this._state = r100;
        this._stateChange = BehaviorSubject.createDefault(r100);
        this.viewModelTasks$delegate = LazyKt.lazy(AnchorInviteViewModel$viewModelTasks$2.INSTANCE);
        bindViewModel(RxUtilKt.e(stateChanged()).observeOn(Schedulers.io()).subscribe(new a(this)));
    }

    public final void cancel() {
        bindViewModel(((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).cancel(this.roomId).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this), RxUtil.getNoOpThrowable()));
    }

    public final void checkStatus() {
        bindViewModel(((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).status(this.roomId, 0, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), RxUtil.getNoOpThrowable()));
    }

    public final void inviteAll() {
        bindViewModel(((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).invite(this.roomId, 1, this.gameId).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this), new g(this)));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable r100 = this.countDownCheckDisposable;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        getViewModelTasks().clear();
    }

    public final l getGameConfig() {
        return this.gameConfig;
    }

    public final long getGameId() {
        return this.gameId;
    }

    public final long getPlayKind() {
        return this.playKind;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final com.bytedance.android.livesdk.wgamex.gameinvite.i state() {
        return this._state;
    }

    public final Observable<com.bytedance.android.livesdk.wgamex.gameinvite.i> stateChanged() {
        return this._stateChange;
    }

    public static final /* synthetic */ Disposable access$getCountDownCheckDisposable$p(AnchorInviteViewModel r100) {
        return r100.countDownCheckDisposable;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.wgamex.gameinvite.i access$get_state$p(AnchorInviteViewModel r100) {
        return r100._state;
    }

    private final boolean bindViewModel(Disposable r100) {
        return getViewModelTasks().add(r100);
    }

    private final long getCheckStatusDelay(z4.a r100) {
        long r101 = r100.a() - r100.d();
        if (r101 <= 60) goto L6;
        return 60;
    L6:
        return r101;
    }

    private final void set_state(com.bytedance.android.livesdk.wgamex.gameinvite.i r100) {
        this._state = r100;
        this._stateChange.onNext(r100);
    }

    public final Observable<com.bytedance.android.livesdk.wgamex.gameinvite.j> profileInvite(long r110) {
        return ((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).invite(this.roomId, 2, r110, this.gameId).compose(RxUtil.rxSchedulerHelper()).map(new j(this, r110));
    }

    public final void setGameConfig(l r100) {
        this.gameConfig = r100;
    }

    public final void setGameId(long r100) {
        this.gameId = r100;
    }

    public final void setPlayKind(long r100) {
        this.playKind = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public static final /* synthetic */ long access$getCheckStatusDelay(AnchorInviteViewModel r100, z4.a r101) {
        return r100.getCheckStatusDelay(r101);
    }

    public static final /* synthetic */ void access$setCountDownCheckDisposable$p(AnchorInviteViewModel r100, Disposable r101) {
        r100.countDownCheckDisposable = r101;
    }

    public static final /* synthetic */ void access$set_state$p(AnchorInviteViewModel r100, com.bytedance.android.livesdk.wgamex.gameinvite.i r101) {
        r100.set_state(r101);
    }

    private final Observable<com.bytedance.android.livesdk.wgamex.gameinvite.j> queryProfileInviteStatus(long r100, long r101) {
        return ((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).userStatus(r100, r101).subscribeOn(Schedulers.io()).map(new k(r101));
    }

    public final void enterRoom(long r100, Function2<? super z4.a, ? super z4.b, Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        bindViewModel(((GameInviteRetrofitApi) com.bytedance.android.live.network.c.b().e(GameInviteRetrofitApi.class)).status(r100, 0, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r110), RxUtil.getNoOpThrowable()));
    }

    public final Observable<com.bytedance.android.livesdk.wgamex.gameinvite.j> observeProfileInviteState(long r100, long r110) {
        return stateChanged().flatMap(new h(this, r110, r100));
    }

    public final Observable<Pair<Long, Integer>> observeProfileInviteStateSimply(long r100, long r101) {
        return observeProfileInviteState(r100, r101).map(i.f160682a);
    }

    public final com.bytedance.android.livesdk.wgamex.gameinvite.i updateState(z4.a r100, z4.b r101) {
        Companion.getClass();
        set_state(b.b(r100, r101));
        return this._state;
    }

    public static final /* synthetic */ Observable access$queryProfileInviteStatus(AnchorInviteViewModel r100, long r101, long r102) {
        return r100.queryProfileInviteStatus(r101, r102);
    }
}
