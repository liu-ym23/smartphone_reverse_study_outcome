package com.stepos.ailauncher.chat.manager;

import Ua.C1060i;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.agent.IAgentMarketService;
import com.stepos.ailauncher.contract.model.StoreInstallActivity;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;", "activity", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/model/StoreInstallActivity;)V", "", "c", "()I", "", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "LXa/k;", "Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;", "_state", "LXa/k;", "LXa/t;", VoiceWakeupReceiver.EXTRA_STATE, "LXa/t;", "e", "()LXa/t;", "seenSucceededCount", "I", "seenInstalledEntryCount", "seenMyAgentCount", "seenTestZoneCount", "", "storeVisible", "Z", "Lkotlinx/coroutines/g;", "collectJob", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooStoreBadgeState {
    private static final String TAG = "AmooStoreBadge";
    private static final Xa.k<State> _state;
    private static kotlinx.coroutines.g collectJob;
    private static int seenInstalledEntryCount;
    private static int seenMyAgentCount;
    private static int seenSucceededCount;
    private static int seenTestZoneCount;
    private static final Xa.t<State> state;
    private static boolean storeVisible;
    public static final AmooStoreBadgeState INSTANCE = new AmooStoreBadgeState();
    private static final Ua.M scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJB\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;", "", "", "installing", "unreadInstalled", "unreadInstalledEntry", "unreadMyAgent", "unreadTestZone", "<init>", "(ZZZZZ)V", Const.INTENT_KEY_APIKEY, "(ZZZZZ)Lcom/stepos/ailauncher/chat/manager/AmooStoreBadgeState$a;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "c", "()Z", Const.INTENT_KEY_UMID, "e", "getUnreadMyAgent", "getUnreadTestZone", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.AmooStoreBadgeState$a, reason: from toString */
    public static final /* data */ class State {
        private final boolean installing;
        private final boolean unreadInstalled;
        private final boolean unreadInstalledEntry;
        private final boolean unreadMyAgent;
        private final boolean unreadTestZone;

        public State() {
            this(false, false, false, false, false, 31, null);
        }

        public static /* synthetic */ State b(State state, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = state.installing;
            }
            if ((i10 & 2) != 0) {
                z11 = state.unreadInstalled;
            }
            if ((i10 & 4) != 0) {
                z12 = state.unreadInstalledEntry;
            }
            if ((i10 & 8) != 0) {
                z13 = state.unreadMyAgent;
            }
            if ((i10 & 16) != 0) {
                z14 = state.unreadTestZone;
            }
            boolean z15 = z14;
            boolean z16 = z12;
            return state.a(z10, z11, z16, z13, z15);
        }

        public final State a(boolean installing, boolean unreadInstalled, boolean unreadInstalledEntry, boolean unreadMyAgent, boolean unreadTestZone) {
            return new State(installing, unreadInstalled, unreadInstalledEntry, unreadMyAgent, unreadTestZone);
        }

        /* renamed from: c, reason: from getter */
        public final boolean getInstalling() {
            return this.installing;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getUnreadInstalled() {
            return this.unreadInstalled;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getUnreadInstalledEntry() {
            return this.unreadInstalledEntry;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.installing == state.installing && this.unreadInstalled == state.unreadInstalled && this.unreadInstalledEntry == state.unreadInstalledEntry && this.unreadMyAgent == state.unreadMyAgent && this.unreadTestZone == state.unreadTestZone;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.installing) * 31) + Boolean.hashCode(this.unreadInstalled)) * 31) + Boolean.hashCode(this.unreadInstalledEntry)) * 31) + Boolean.hashCode(this.unreadMyAgent)) * 31) + Boolean.hashCode(this.unreadTestZone);
        }

        public String toString() {
            return "State(installing=" + this.installing + ", unreadInstalled=" + this.unreadInstalled + ", unreadInstalledEntry=" + this.unreadInstalledEntry + ", unreadMyAgent=" + this.unreadMyAgent + ", unreadTestZone=" + this.unreadTestZone + ")";
        }

        public State(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
            this.installing = z10;
            this.unreadInstalled = z11;
            this.unreadInstalledEntry = z12;
            this.unreadMyAgent = z13;
            this.unreadTestZone = z14;
        }

        public /* synthetic */ State(boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i10, kotlin.jvm.internal.i iVar) {
            this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? false : z11, (i10 & 4) != 0 ? false : z12, (i10 & 8) != 0 ? false : z13, (i10 & 16) != 0 ? false : z14);
        }
    }

    static {
        Xa.k<State> kVarA = Xa.u.a(new State(false, false, false, false, false, 31, null));
        _state = kVarA;
        state = Xa.d.c(kVarA);
    }

    public final void b(StoreInstallActivity activity) {
        boolean z10;
        if (storeVisible) {
            seenSucceededCount = activity.getSucceededCount();
        }
        Xa.k<State> kVar = _state;
        boolean installing = activity.getInstalling();
        boolean z11 = false;
        boolean z12 = activity.getSucceededCount() > seenSucceededCount;
        boolean z13 = activity.getSucceededCount() > seenInstalledEntryCount;
        if (activity.getAgentInstalledCount() > seenMyAgentCount) {
            z10 = false;
            z11 = true;
        } else {
            z10 = false;
        }
        kVar.setValue(new State(installing, z12, z13, z11, activity.getTestingAgentActivityCount() <= seenTestZoneCount ? z10 : true));
    }

    public final int c() {
        Xa.t<StoreInstallActivity> installActivity;
        StoreInstallActivity value;
        IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
        return (iAgentMarketService == null || (installActivity = iAgentMarketService.getInstallActivity()) == null || (value = installActivity.getValue()) == null) ? seenSucceededCount : value.getSucceededCount();
    }

    public final void d() {
        kotlinx.coroutines.g gVar = collectJob;
        if (gVar == null || !gVar.b()) {
            IAgentMarketService iAgentMarketService = (IAgentMarketService) D5.a.INSTANCE.a(IAgentMarketService.class);
            if (iAgentMarketService == null) {
                C4148a.u(TAG, "IAgentMarketService not registered yet, badge stays idle", false, 4, null);
            } else {
                collectJob = C1060i.d(scope, null, null, new AmooStoreBadgeState$ensureStarted$1(iAgentMarketService, null), 3, null);
            }
        }
    }

    public final Xa.t<State> e() {
        return state;
    }

    public final void f() {
        d();
        seenInstalledEntryCount = c();
        Xa.k<State> kVar = _state;
        kVar.setValue(State.b(kVar.getValue(), false, false, false, false, false, 27, null));
    }

    public final void g() {
        storeVisible = false;
    }

    public final void h() {
        storeVisible = true;
        d();
        seenSucceededCount = c();
        Xa.k<State> kVar = _state;
        kVar.setValue(State.b(kVar.getValue(), false, false, false, false, false, 29, null));
    }
}
