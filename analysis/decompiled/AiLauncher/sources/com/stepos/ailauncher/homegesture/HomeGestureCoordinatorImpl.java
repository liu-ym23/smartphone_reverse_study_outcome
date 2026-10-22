package com.stepos.ailauncher.homegesture;

import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.m0;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import com.stepos.ailauncher.sheet.b0;
import com.stepos.ailauncher.sheet.i0;
import com.stepos.ailauncher.sheet.s0;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ^2\u00020\u0001:\u0001_B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u001f\u0010!\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u001b\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00070#H\u0000¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000fH\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u000fH\u0016¢\u0006\u0004\b3\u0010.J\u001f\u00105\u001a\u00020\u000f2\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000fH\u0016¢\u0006\u0004\b7\u0010.J/\u0010<\u001a\u00020;2\u0006\u0010\f\u001a\u00020\u000b2\b\u00108\u001a\u0004\u0018\u00010\r2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001409H\u0000¢\u0006\u0004\b<\u0010=J1\u0010@\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u00010\r2\b\u0010?\u001a\u0004\u0018\u00010>2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001409H\u0000¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\bB\u0010\u0013J\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\bC\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010JR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010R\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010J\u001a\u0004\bS\u0010T\"\u0004\bU\u00106R\u0018\u0010W\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006`"}, d2 = {"Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "Lcom/stepos/ailauncher/contract/api/homegesture/IHomeGestureCoordinator;", "Lcom/stepos/ailauncher/homegesture/C;", "registry", "Lcom/stepos/ailauncher/homegesture/j;", "claimer", "Lkotlin/Function0;", "", "overlayOpen", "<init>", "(Lcom/stepos/ailauncher/homegesture/C;Lcom/stepos/ailauncher/homegesture/j;Lp9/a;)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "strategy", "LY8/t;", "registerRoot", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;)V", "unregisterRoot", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "handle", "registerPopup", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;)V", "", "layerId", "unregisterPopup", "(Ljava/lang/String;)V", "registerSheet", "unregisterSheet", "reason", "notifyTopologyChanged", "forceBump", "l", "(Ljava/lang/String;Z)V", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/homegesture/b;", "n", "()Lkotlin/Pair;", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "currentSnapshot", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "snapshot", "beginPeek", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "endPeek", "()V", "", "expectedGeneration", "consume", "(J)V", "notifyConsumeStarted", "listener", "setOnConsumeStarted", "(Lp9/a;)V", "dismissPopupsForRecents", Parameters.ROOT, "", "sheets", "Lcom/stepos/ailauncher/homegesture/HomeGroupExitStartResult;", "p", "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;Ljava/util/List;)Lcom/stepos/ailauncher/homegesture/HomeGroupExitStartResult;", "", "rootAction", "u", "(Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;Ljava/lang/Integer;Ljava/util/List;)Lcom/stepos/ailauncher/homegesture/HomeGroupExitStartResult;", "suspendPartition", "resumePartition", "Lcom/stepos/ailauncher/homegesture/C;", "k", "()Lcom/stepos/ailauncher/homegesture/C;", "Lcom/stepos/ailauncher/homegesture/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/homegesture/j;", "Lp9/a;", "Lcom/stepos/ailauncher/homegesture/s;", "dispatcher", "Lcom/stepos/ailauncher/homegesture/s;", "getDispatcher", "()Lcom/stepos/ailauncher/homegesture/s;", "o", "(Lcom/stepos/ailauncher/homegesture/s;)V", "consumeStartedListener", "getConsumeStartedListener", "()Lp9/a;", "setConsumeStartedListener", "Lcom/stepos/ailauncher/homegesture/z;", "activeHomeGroupExit", "Lcom/stepos/ailauncher/homegesture/z;", "Lcom/stepos/ailauncher/homegesture/MinusOneGroupExitTransaction;", "activeMinusOneGroupExit", "Lcom/stepos/ailauncher/homegesture/MinusOneGroupExitTransaction;", "lastPublishedYield", "Z", "Companion", Const.INTENT_KEY_APIKEY, "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeGestureCoordinatorImpl implements IHomeGestureCoordinator {
    public static final String REASON_PRIVACY_NOT_GRANTED = "privacy-not-granted";
    private static final String TAG = "HomeGestureCoord";
    private volatile z activeHomeGroupExit;
    private MinusOneGroupExitTransaction activeMinusOneGroupExit;
    private final C3343j claimer;
    private volatile InterfaceC5063a<Y8.t> consumeStartedListener;
    private volatile C3351s dispatcher;
    private volatile boolean lastPublishedYield;
    private final InterfaceC5063a<Boolean> overlayOpen;
    private final C registry;

    public HomeGestureCoordinatorImpl(C registry, C3343j claimer, InterfaceC5063a<Boolean> overlayOpen) {
        kotlin.jvm.internal.p.i(registry, "registry");
        kotlin.jvm.internal.p.i(claimer, "claimer");
        kotlin.jvm.internal.p.i(overlayOpen, "overlayOpen");
        this.registry = registry;
        this.claimer = claimer;
        this.overlayOpen = overlayOpen;
    }

    public static final boolean i() {
        return m0.INSTANCE.h();
    }

    public static /* synthetic */ void m(HomeGestureCoordinatorImpl homeGestureCoordinatorImpl, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        homeGestureCoordinatorImpl.l(str, z10);
    }

    public static final CharSequence q(HomeGroupExitParticipant it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getParticipantId();
    }

    public static final Y8.t r(HomeGestureCoordinatorImpl homeGestureCoordinatorImpl, HomeRootToken homeRootToken, List list) {
        t(list);
        homeGestureCoordinatorImpl.activeHomeGroupExit = null;
        homeGestureCoordinatorImpl.notifyTopologyChanged("home-group-exit-finished:" + homeRootToken.getWire());
        return Y8.t.f7040a;
    }

    public static final Y8.t s(HomeGestureCoordinatorImpl homeGestureCoordinatorImpl, HomeRootToken homeRootToken, List list) {
        t(list);
        homeGestureCoordinatorImpl.activeHomeGroupExit = null;
        homeGestureCoordinatorImpl.notifyTopologyChanged("home-group-exit-cancelled:" + homeRootToken.getWire());
        return Y8.t.f7040a;
    }

    public static final void t(List<s0> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((s0) it.next()).u();
        }
    }

    public static final b0 v(s0 s0Var, final InterfaceC5074l update, final InterfaceC5063a end) {
        kotlin.jvm.internal.p.i(update, "update");
        kotlin.jvm.internal.p.i(end, "end");
        return s0Var.S(0.0f, 871.0f, i0.INSTANCE.v(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HomeGestureCoordinatorImpl.w(update, ((Float) obj).floatValue());
            }
        }, new p9.p() { // from class: com.stepos.ailauncher.homegesture.l
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return HomeGestureCoordinatorImpl.x(end, ((Boolean) obj).booleanValue(), ((Float) obj2).floatValue());
            }
        });
    }

    public static final Y8.t w(InterfaceC5074l interfaceC5074l, float f10) {
        interfaceC5074l.invoke(Float.valueOf(f10 / 871.0f));
        return Y8.t.f7040a;
    }

    public static final Y8.t x(InterfaceC5063a interfaceC5063a, boolean z10, float f10) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t y(HomeGestureCoordinatorImpl homeGestureCoordinatorImpl) {
        homeGestureCoordinatorImpl.activeMinusOneGroupExit = null;
        homeGestureCoordinatorImpl.notifyTopologyChanged("minus-one-group-exit-finished");
        return Y8.t.f7040a;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void beginPeek(HomeGestureEligibilitySnapshot snapshot) {
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        this.claimer.a(snapshot);
        C4148a.d(TAG, "beginPeek gen=" + snapshot.getGeneration() + " token=" + snapshot.getRootToken().getWire(), false, 4, null);
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void consume(long expectedGeneration) {
        C3351s c3351s = this.dispatcher;
        if (c3351s != null) {
            c3351s.a(expectedGeneration);
        } else {
            C4148a.u(TAG, "consume ignored: dispatcher not ready", false, 4, null);
        }
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public HomeGestureEligibilitySnapshot currentSnapshot() {
        return C3352t.a();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void dismissPopupsForRecents() {
        Iterator<HomeRootToken> it = HomeRootToken.getEntries().iterator();
        while (it.hasNext()) {
            for (HomeLayerHandle homeLayerHandle : Z8.B.U(this.registry.d(it.next()))) {
                if (homeLayerHandle.isShowing()) {
                    homeLayerHandle.dismiss(HomeDismissReason.RECENTS);
                }
            }
        }
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void endPeek() {
        this.claimer.c();
    }

    /* renamed from: j, reason: from getter */
    public final C3343j getClaimer() {
        return this.claimer;
    }

    /* renamed from: k, reason: from getter */
    public final C getRegistry() {
        return this.registry;
    }

    public final void l(String reason, boolean forceBump) {
        kotlin.jvm.internal.p.i(reason, "reason");
        Pair<EligibilityDecision, Boolean> pairN = n();
        EligibilityDecision eligibilityDecisionA = pairN.a();
        boolean zBooleanValue = pairN.b().booleanValue();
        boolean z10 = forceBump || zBooleanValue != this.lastPublishedYield;
        this.lastPublishedYield = zBooleanValue;
        C3352t.d(eligibilityDecisionA, z10);
        C4148a.d(TAG, "topology reason=" + reason + " → " + eligibilityDecisionA.getReason() + " consumable=" + eligibilityDecisionA.getConsumable() + " yield=" + zBooleanValue + " forceBump=" + z10, false, 4, null);
    }

    public final Pair<EligibilityDecision, Boolean> n() {
        if (!com.stepos.ailauncher.common.privacy.b.INSTANCE.b()) {
            return Y8.j.a(EligibilityDecision.INSTANCE.a(REASON_PRIVACY_NOT_GRANTED), Boolean.FALSE);
        }
        boolean zR = J.INSTANCE.r();
        return Y8.j.a(C3336c.INSTANCE.b(this.registry, this.overlayOpen.invoke().booleanValue(), zR), Boolean.valueOf(zR));
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void notifyConsumeStarted() {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.consumeStartedListener;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void notifyTopologyChanged(String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        m(this, reason, false, 2, null);
    }

    public final void o(C3351s c3351s) {
        this.dispatcher = c3351s;
    }

    public final HomeGroupExitStartResult p(final HomeRootToken token, RootStrategy root, List<? extends HomeLayerHandle> sheets) {
        HomeGroupExitParticipant homeGroupExitParticipant;
        kotlin.jvm.internal.p.i(token, "token");
        kotlin.jvm.internal.p.i(sheets, "sheets");
        if (this.activeHomeGroupExit != null) {
            C4148a.k(TAG, "HOME group exit already active token=" + token.getWire(), false, 4, null);
            return HomeGroupExitStartResult.ALREADY_ACTIVE;
        }
        ArrayList arrayList = new ArrayList();
        List<? extends HomeLayerHandle> list = sheets;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((HomeLayerHandle) obj).isShowing()) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            HomeGroupExitParticipant homeGroupExitParticipant2 = ((HomeLayerHandle) it.next()).homeGroupExitParticipant();
            if (homeGroupExitParticipant2 != null && homeGroupExitParticipant2.isShowing()) {
                arrayList.add(homeGroupExitParticipant2);
            }
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        if (root == null || (homeGroupExitParticipant = root.homeGroupExitParticipant(1)) == null) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        if (!homeGroupExitParticipant.isShowing()) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        arrayList.add(homeGroupExitParticipant);
        if (arrayList.size() < 2) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        ArrayList arrayList3 = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((HomeLayerHandle) it2.next()).getRootToken());
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            HomeRootToken visualStackRootToken = ((HomeGroupExitParticipant) it3.next()).getVisualStackRootToken();
            if (visualStackRootToken != null) {
                arrayList4.add(visualStackRootToken);
            }
        }
        List listG0 = Z8.F.g0(Z8.F.S0(arrayList3, arrayList4));
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : listG0) {
            if (((HomeRootToken) obj2) != token) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = new ArrayList(C1174w.x(arrayList5, 10));
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            arrayList6.add(s0.INSTANCE.b(((HomeRootToken) it4.next()).getWire()));
        }
        final ArrayList arrayList7 = new ArrayList();
        for (Object obj3 : arrayList6) {
            if (((s0) obj3).o()) {
                arrayList7.add(obj3);
            }
        }
        z zVar = new z(token, arrayList, new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeGestureCoordinatorImpl.r(this.f27448a, token, arrayList7);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeGestureCoordinatorImpl.s(this.f27451a, token, arrayList7);
            }
        });
        this.activeHomeGroupExit = zVar;
        if (!zVar.d()) {
            t(arrayList7);
            this.activeHomeGroupExit = null;
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        C4148a.k(TAG, "HOME group exit started token=" + token.getWire() + " participants=" + Z8.F.A0(arrayList, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.homegesture.p
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj4) {
                return HomeGestureCoordinatorImpl.q((HomeGroupExitParticipant) obj4);
            }
        }, 31, null), false, 4, null);
        return HomeGroupExitStartResult.STARTED;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void registerPopup(HomeLayerHandle handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        this.registry.e(handle);
        notifyTopologyChanged("register-popup:" + handle.getLayerId());
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void registerRoot(HomeRootToken token, RootStrategy strategy) {
        kotlin.jvm.internal.p.i(token, "token");
        kotlin.jvm.internal.p.i(strategy, "strategy");
        this.registry.f(token, strategy);
        notifyTopologyChanged("register-root:" + token.getWire());
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void registerSheet(HomeLayerHandle handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        this.registry.g(handle);
        notifyTopologyChanged("register-sheet:" + handle.getLayerId());
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void resumePartition(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        Iterator it = Z8.B.U(this.registry.i(token)).iterator();
        while (it.hasNext()) {
            ((HomeLayerHandle) it.next()).resumeAfterPeek();
        }
        s0.INSTANCE.b(token.getWire()).O();
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void setOnConsumeStarted(InterfaceC5063a<Y8.t> listener) {
        this.consumeStartedListener = listener;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void suspendPartition(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        Iterator<T> it = this.registry.i(token).iterator();
        while (it.hasNext()) {
            ((HomeLayerHandle) it.next()).suspendForPeek();
        }
    }

    public final HomeGroupExitStartResult u(RootStrategy root, Integer rootAction, List<? extends HomeLayerHandle> sheets) {
        HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant;
        kotlin.jvm.internal.p.i(sheets, "sheets");
        if (this.activeMinusOneGroupExit != null) {
            return HomeGroupExitStartResult.ALREADY_ACTIVE;
        }
        if ((root != null ? root.getToken() : null) != HomeRootToken.MINUS_ONE || !Z8.F.f0(C1173v.p(3, 4), rootAction)) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<HomeLayerHandle> arrayList2 = new ArrayList();
        for (Object obj : sheets) {
            if (((HomeLayerHandle) obj).isShowing()) {
                arrayList2.add(obj);
            }
        }
        for (HomeLayerHandle homeLayerHandle : arrayList2) {
            if (homeLayerHandle.getRootToken() != HomeRootToken.MINUS_ONE) {
                return HomeGroupExitStartResult.NOT_ELIGIBLE;
            }
            HomeGroupExitParticipant homeGroupExitParticipant = homeLayerHandle.homeGroupExitParticipant();
            HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant2 = homeGroupExitParticipant instanceof HomeSharedOffsetExitParticipant ? (HomeSharedOffsetExitParticipant) homeGroupExitParticipant : null;
            if (homeSharedOffsetExitParticipant2 != null && homeSharedOffsetExitParticipant2.isShowing()) {
                arrayList.add(homeSharedOffsetExitParticipant2);
            }
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        if (arrayList.isEmpty()) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        if (rootAction != null && rootAction.intValue() == 3) {
            HomeGroupExitParticipant homeGroupExitParticipant2 = root.homeGroupExitParticipant(rootAction.intValue());
            HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant3 = homeGroupExitParticipant2 instanceof HomeSharedOffsetExitParticipant ? (HomeSharedOffsetExitParticipant) homeGroupExitParticipant2 : null;
            if (homeSharedOffsetExitParticipant3 == null) {
                return HomeGroupExitStartResult.NOT_ELIGIBLE;
            }
            homeSharedOffsetExitParticipant = homeSharedOffsetExitParticipant3;
        } else {
            homeSharedOffsetExitParticipant = null;
        }
        if (homeSharedOffsetExitParticipant != null) {
            if (!homeSharedOffsetExitParticipant.isShowing()) {
                return HomeGroupExitStartResult.NOT_ELIGIBLE;
            }
            arrayList.add(homeSharedOffsetExitParticipant);
        }
        if (arrayList.size() < 2) {
            return HomeGroupExitStartResult.NOT_ELIGIBLE;
        }
        final s0 s0VarB = s0.INSTANCE.b(HomeRootToken.MINUS_ONE.getWire());
        MinusOneGroupExitTransaction minusOneGroupExitTransaction = new MinusOneGroupExitTransaction(arrayList, homeSharedOffsetExitParticipant, new HomeGestureCoordinatorImpl$tryStartMinusOneGroupExit$transaction$1(s0VarB), new HomeGestureCoordinatorImpl$tryStartMinusOneGroupExit$transaction$2(s0VarB), new p9.p() { // from class: com.stepos.ailauncher.homegesture.q
            @Override // p9.p
            public final Object invoke(Object obj2, Object obj3) {
                return HomeGestureCoordinatorImpl.v(s0VarB, (InterfaceC5074l) obj2, (InterfaceC5063a) obj3);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.r
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return HomeGestureCoordinatorImpl.y(this.f27455a);
            }
        });
        this.activeMinusOneGroupExit = minusOneGroupExitTransaction;
        if (minusOneGroupExitTransaction.p()) {
            return HomeGroupExitStartResult.STARTED;
        }
        this.activeMinusOneGroupExit = null;
        return HomeGroupExitStartResult.NOT_ELIGIBLE;
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void unregisterPopup(String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        this.registry.l(layerId);
        notifyTopologyChanged("unregister-popup:" + layerId);
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void unregisterRoot(HomeRootToken token) {
        kotlin.jvm.internal.p.i(token, "token");
        this.registry.n(token);
        notifyTopologyChanged("unregister-root:" + token.getWire());
    }

    @Override // com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator
    public void unregisterSheet(String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        this.registry.o(layerId);
        notifyTopologyChanged("unregister-sheet:" + layerId);
    }

    public /* synthetic */ HomeGestureCoordinatorImpl(C c10, C3343j c3343j, InterfaceC5063a interfaceC5063a, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? new C() : c10, (i10 & 2) != 0 ? new C3343j() : c3343j, (i10 & 4) != 0 ? new InterfaceC5063a() { // from class: com.stepos.ailauncher.homegesture.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(HomeGestureCoordinatorImpl.i());
            }
        } : interfaceC5063a);
    }
}
