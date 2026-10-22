package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.livesdk.link.model.bridge.w;
import com.bytedance.android.livesdk.link.model.bridge.x;
import com.bytedance.android.livesdk.link.model.bridge.y;
import com.bytedance.android.livesdk.link.model.i2;
import com.bytedance.android.livesdk.link.model.k2;
import com.bytedance.android.livesdk.link.model.l2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001FB9\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u00106\u001a\u0004\u0018\u000105¢\u0006\u0004\bD\u0010EJ\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u0018\u0010\u0014\u001a\u00060\u0012j\u0002`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR'\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001dj\b\u0012\u0004\u0012\u00020\r`\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R'\u0010$\u001a\u0012\u0012\u0004\u0012\u00020#0\u001dj\b\u0012\u0004\u0012\u00020#`\u001e8\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R'\u0010'\u001a\u0012\u0012\u0004\u0012\u00020&0\u001dj\b\u0012\u0004\u0012\u00020&`\u001e8\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0016\u0010*\u001a\u0004\u0018\u00010)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010-\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0004\u0018\u0001058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0004\u0018\u0001088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/revlink/impl/pk/service/g;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "_message", "", "onMessage", "", "judgeCanStartInvite", "isBroadcastPaused", "handleInviteAvailable", "Landroidx/lifecycle/LiveData;", "Lcom/bytedance/android/live/revlink/impl/pk/vm/linkout/PkReserveBattleDataContext$b;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/LiveData;", "getBattleReserveState", "state", "setBattleReserveState", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdk/revenue/room/a;", "roomContext", "Lcom/bytedance/android/livesdk/revenue/room/a;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/MutableLiveData;", "reserveBattleState", "Landroidx/lifecycle/MutableLiveData;", "getReserveBattleState", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/link/model/l2;", "showReserveSettleDialog", "getShowReserveSettleDialog", "Lcom/bytedance/android/livesdk/link/model/i2;", "showReserveInviteDialog", "getShowReserveInviteDialog", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "roomService", "Lcom/bytedance/android/livesdk/revenue/service/room/c;", "Lyz0/f;", "messageService", "Lyz0/f;", "Lld/a;", "linkDataSet", "Lld/a;", "Llr2/a;", "paidLiveService", "Llr2/a;", "Lcom/bytedance/android/live/revlink/impl/global/c;", "linkFakeGlobalService", "Lcom/bytedance/android/live/revlink/impl/global/c;", "Lox0/a;", "getModeMerge", "()Lox0/a;", "modeMerge", "Lw31/c;", "getPkLinkUtils", "()Lw31/c;", "pkLinkUtils", "Li41/a;", "getAutoMatchManager", "()Li41/a;", "autoMatchManager", "<init>", "(Lcom/bytedance/android/livesdk/revenue/service/room/c;Lyz0/f;Lld/a;Llr2/a;Lcom/bytedance/android/live/revlink/impl/global/c;)V", "b", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkReserveBattleDataContext extends DataContext implements com.bytedance.android.live.revlink.impl.pk.service.g {

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f97218cd;
    private final ld.a linkDataSet;
    private final com.bytedance.android.live.revlink.impl.global.c linkFakeGlobalService;
    private final yz0.f messageService;
    private final lr2.a paidLiveService;
    private final MutableLiveData<b> reserveBattleState;
    private IRoom room;
    private final com.bytedance.android.livesdk.revenue.room.a roomContext;
    private final com.bytedance.android.livesdk.revenue.service.room.c roomService;
    private final MutableLiveData<i2> showReserveInviteDialog;
    private final MutableLiveData<l2> showReserveSettleDialog;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass2(PkReserveBattleDataContext r100) {
            super(1, r100, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(yh6.c r100) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) this.receiver, r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass3(PkReserveBattleDataContext r100) {
            super(1, r100, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(yh6.c r100) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) this.receiver, r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
        public AnonymousClass4(PkReserveBattleDataContext r100) {
            super(1, r100, PkReserveBattleDataContext.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(yh6.c r100) {
            PkReserveBattleDataContext.access$onMessage((PkReserveBattleDataContext) this.receiver, r100);
        }
    }

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PkReserveBattleDataContext f97219a;

        public a(PkReserveBattleDataContext r100) {
            this.f97219a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            PkReserveBattleDataContext.access$getCd$p(this.f97219a).dispose();
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f97220a = null;

            static {
                f97220a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkReserveBattleDataContext$b$b, reason: collision with other inner class name */
        public static final class C1492b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1492b f97221a = null;

            static {
                f97221a = new C1492b();
            }

            public C1492b() {
            }
        }

        public b() {
        }
    }

    private final i41.a getAutoMatchManager() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.linkFakeGlobalService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAutoMatchManager();
    }

    private final ox0.a getModeMerge() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.linkFakeGlobalService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getModeMerge();
    }

    private final w31.c getPkLinkUtils() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.linkFakeGlobalService;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPkLinkUtils();
    }

    private final boolean handleInviteAvailable() {
        com.bytedance.android.live.revlink.impl.global.c r100 = this.linkFakeGlobalService;
        if (r100 == null) goto L9;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r101 = r100.Ig();
        if (r101 == null) goto L9;
        LiveData<PkBaseStateMachine.c> r102 = r101.getPkBaseState();
        if (r102 == null) goto L9;
        PkBaseStateMachine.c r103 = r102.getValue();
    L11:
        if (r103 != null) goto L13;
    L16:
        return true;
    L13:
        if ((r103 instanceof PkBaseStateMachine.c.C1444c) != true) goto L16;
        return false;
    L9:
        r103 = null;
        goto L11
    }

    private final boolean isBroadcastPaused() {
        ld.a r100 = this.linkDataSet;
        if (r100 == null) goto L7;
        NextLiveData<Integer> r101 = r100.Dc();
        if (r101 == null) goto L7;
        Integer r102 = r101.getValue();
    L9:
        if (r102 != null) goto L12;
    L13:
        if (r102 != null) goto L16;
    L18:
        return false;
    L16:
        if (r102.intValue() != 2) goto L18;
        return true;
    L12:
        if (r102.intValue() != 1) goto L13;
        return true;
    L7:
        r102 = null;
        goto L9
    }

    private final boolean judgeCanStartInvite() {
        if (isBroadcastPaused() == false) goto L5;
        return false;
    L5:
        lr2.a r100 = this.paidLiveService;
        if (r100 == null) goto L11;
        if (r100.isPaidLive() != true) goto L11;
        return false;
    L11:
        if (d51.c.A0.l() == true) goto L13;
        return false;
    L13:
        IRoom r101 = this.room;
        if (r101 == null) goto L21;
        if (r101 == null) goto L21;
        IRoomLinkExt r102 = (IRoomLinkExt) r101.castTo(IRoomLinkExt.class);
        if (r102 == null) goto L21;
        if (r102.getMosaicStatus() != 1) goto L21;
        return false;
    L21:
        w31.c r103 = getPkLinkUtils();
        if (r103 == null) goto L38;
        IPKLinkBizDataService r104 = r103.g();
        if (r104 == null) goto L27;
        q11.c r105 = r104.mo8199getPkLinkState();
        if (r105 == null) goto L27;
    L29:
        if ((r105 instanceof q11.c.C7266c) == false) goto L31;
    L34:
        boolean r106 = true;
    L35:
        if (r106 != true) goto L38;
        return false;
    L31:
        if ((r105 instanceof q11.c.a) == true) goto L34;
        r106 = false;
    L27:
        r105 = q11.c.b.f531278b;
    L38:
        if (Intrinsics.areEqual(this.reserveBattleState.getValue(), b.C1492b.f97221a) == false) goto L40;
        return false;
    L40:
        i41.a r107 = getAutoMatchManager();
        if (r107 != null) goto L43;
    L45:
        return true;
    L43:
        if (r107.f488160f != true) goto L45;
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.pk.service.g
    public LiveData<b> getBattleReserveState() {
        return this.reserveBattleState;
    }

    public final MutableLiveData<b> getReserveBattleState() {
        return this.reserveBattleState;
    }

    public final MutableLiveData<i2> getShowReserveInviteDialog() {
        return this.showReserveInviteDialog;
    }

    public final MutableLiveData<l2> getShowReserveSettleDialog() {
        return this.showReserveSettleDialog;
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(PkReserveBattleDataContext r100) {
        return r100.f97218cd;
    }

    private final void onMessage(yh6.c r100) {
        if ((r100 instanceof x) == false) goto L6;
        k2 r101 = (k2) ((vh7.c) r100).castTo(k2.class);
        int r102 = ToastUtil.f90810a;
        ToastUtil.b(r101.getToast(), 0);
        return;
    L6:
        if ((r100 instanceof y) == false) goto L12;
        if (judgeCanStartInvite() == true) goto L10;
        return;
    L10:
        l2 r103 = (l2) ((vh7.c) r100).castTo(l2.class);
        this.reserveBattleState.setValue(b.C1492b.f97221a);
        this.showReserveSettleDialog.setValue(r103);
        return;
    L12:
        if ((r100 instanceof w) == true) goto L14;
        return;
    L14:
        if (judgeCanStartInvite() == true) goto L17;
        return;
    L17:
        if (handleInviteAvailable() == true) goto L19;
        return;
    L19:
        i2 r104 = (i2) ((vh7.c) r100).castTo(i2.class);
        this.reserveBattleState.setValue(b.C1492b.f97221a);
        this.showReserveInviteDialog.setValue(r104);
    }

    public void setBattleReserveState(b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.reserveBattleState.setValue(r100);
    }

    public static final /* synthetic */ void access$onMessage(PkReserveBattleDataContext r100, yh6.c r101) {
        r100.onMessage(r101);
    }

    public PkReserveBattleDataContext(com.bytedance.android.livesdk.revenue.service.room.c r100, yz0.f r101, ld.a r102, lr2.a r103, com.bytedance.android.live.revlink.impl.global.c r104) {
        this.roomService = r100;
        this.messageService = r101;
        this.linkDataSet = r102;
        this.paidLiveService = r103;
        this.linkFakeGlobalService = r104;
        CompositeDisposable r105 = new CompositeDisposable();
        this.f97218cd = r105;
        IRoomBase r106 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r107 = r100.getRoomContext();
    L6:
        this.roomContext = r107;
        MutableLiveData<b> r108 = new MutableLiveData();
        this.reserveBattleState = r108;
        this.showReserveSettleDialog = new MutableLiveData();
        this.showReserveInviteDialog = new MutableLiveData();
        com.bytedance.revenue.platform.api.core.rx.f.a(getOnCleared().subscribe(new a(this)), r105);
        if (r107 == null) goto L9;
        r106 = r107.getCommonRoom();
    L9:
        this.room = (IRoom) r106;
        if (r101 == null) goto L16;
        com.bytedance.android.live.revenue.common.message.a r109 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r110 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r109, "$this$LINK_BATTLE_RESERVE_SETTLE");
        Observable r111 = yz0.h.a.a(r101, (yh6.b) CommonMessageTypeKt.K.getValue(), false, 6);
        if (r111 == null) goto L16;
        final AnonymousClass2 r112 = new AnonymousClass2(this);
        Disposable r113 = r111.subscribe(new c(r112));
        if (r113 == null) goto L16;
        com.bytedance.revenue.platform.api.core.rx.f.a(r113, r105);
    L16:
        if (r101 == null) goto L22;
        com.bytedance.android.live.revenue.common.message.a r114 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r115 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r114, "$this$LINK_BATTLE_RESERVE_INVITE");
        Observable r116 = yz0.h.a.a(r101, (yh6.b) CommonMessageTypeKt.L.getValue(), false, 6);
        if (r116 == null) goto L22;
        final AnonymousClass3 r117 = new AnonymousClass3(this);
        Disposable r118 = r116.subscribe(new c(r117));
        if (r118 == null) goto L22;
        com.bytedance.revenue.platform.api.core.rx.f.a(r118, r105);
    L22:
        if (r101 == null) goto L28;
        com.bytedance.android.live.revenue.common.message.a r119 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r120 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r119, "$this$BATTLE_RESERVE_REPLY_MESSAGE");
        Observable r121 = yz0.h.a.a(r101, (yh6.b) CommonMessageTypeKt.f90850J.getValue(), false, 6);
        if (r121 == null) goto L28;
        final AnonymousClass4 r122 = new AnonymousClass4(this);
        Disposable r123 = r121.subscribe(new c(r122));
        if (r123 == null) goto L28;
        com.bytedance.revenue.platform.api.core.rx.f.a(r123, r105);
    L28:
        r108.setValue(b.a.f97220a);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
