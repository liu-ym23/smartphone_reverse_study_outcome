package com.stepos.ailauncher.task.space;

import Ua.C1060i;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.contract.api.homegesture.HomeGroupExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeSharedOffsetExitParticipant;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004*\u0001#\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/task/space/MinusOneHomeRoots;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, "", "expanded", "f", "(Z)V", "", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", UxipConstants.f30680s, "panelExpanded", "Z", "c", "()Z", "Lkotlin/Function0;", "collapseHandler", "Lp9/a;", Const.INTENT_KEY_APIKEY, "()Lp9/a;", "e", "(Lp9/a;)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", "groupExitParticipant", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeSharedOffsetExitParticipant;)V", "com/stepos/ailauncher/task/space/MinusOneHomeRoots$a", "strategy", "Lcom/stepos/ailauncher/task/space/MinusOneHomeRoots$a;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MinusOneHomeRoots {
    private static final String TAG = "MinusOneHomeRoots";
    private static volatile InterfaceC5063a<Y8.t> collapseHandler;
    private static HomeSharedOffsetExitParticipant groupExitParticipant;
    private static volatile boolean panelExpanded;
    public static final MinusOneHomeRoots INSTANCE = new MinusOneHomeRoots();
    private static final Ua.M scope = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
    private static final a strategy = new a();

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00058\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"com/stepos/ailauncher/task/space/MinusOneHomeRoots$a", "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "", "isPresent", "()Z", "", "taskId", "()I", "rootAction", "action", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "homeGroupExitParticipant", "(I)Lcom/stepos/ailauncher/contract/api/homegesture/HomeGroupExitParticipant;", "consumeRoot", "(I)Z", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", M5.b.CREDENTIAL_TOKEN, "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "getToken", "()Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", HomeGestureEligibilityContract.EXTRA_SCENE, "I", "getScene", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements RootStrategy {
        private final HomeRootToken token = HomeRootToken.MINUS_ONE;
        private final int scene = 3;

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean consumeRoot(int action) {
            if (action != 3) {
                C4148a.k(MinusOneHomeRoots.TAG, "consumeRoot NO_OP", false, 4, null);
                return true;
            }
            InterfaceC5063a<Y8.t> interfaceC5063aA = MinusOneHomeRoots.INSTANCE.a();
            if (interfaceC5063aA != null) {
                interfaceC5063aA.invoke();
            }
            C4148a.k(MinusOneHomeRoots.TAG, "consumeRoot COLLAPSE", false, 4, null);
            return true;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int getScene() {
            return this.scene;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeRootToken getToken() {
            return this.token;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public HomeGroupExitParticipant homeGroupExitParticipant(int action) {
            if (action == 3) {
                return MinusOneHomeRoots.INSTANCE.b();
            }
            return null;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public boolean isPresent() {
            com.stepos.ailauncher.container.m0 m0Var = com.stepos.ailauncher.container.m0.INSTANCE;
            return m0Var.h() && m0Var.g() && !com.stepos.ailauncher.homegesture.J.INSTANCE.r();
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int rootAction() {
            return MinusOneHomeRoots.INSTANCE.c() ? 3 : 4;
        }

        @Override // com.stepos.ailauncher.contract.api.homegesture.RootStrategy
        public int taskId() {
            return 0;
        }
    }

    public final InterfaceC5063a<Y8.t> a() {
        return collapseHandler;
    }

    public final HomeSharedOffsetExitParticipant b() {
        return groupExitParticipant;
    }

    public final boolean c() {
        return panelExpanded;
    }

    public final void d() {
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.registerRoot(HomeRootToken.MINUS_ONE, strategy);
        }
        Ua.M m10 = scope;
        C1060i.d(m10, null, null, new MinusOneHomeRoots$install$1(null), 3, null);
        C1060i.d(m10, null, null, new MinusOneHomeRoots$install$2(null), 3, null);
        C4148a.d(TAG, "install minus-one root", false, 4, null);
    }

    public final void e(InterfaceC5063a<Y8.t> interfaceC5063a) {
        collapseHandler = interfaceC5063a;
    }

    public final void f(boolean expanded) {
        if (panelExpanded == expanded) {
            return;
        }
        panelExpanded = expanded;
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.notifyTopologyChanged("minus-one-expanded=" + expanded);
        }
    }

    public final void g(HomeSharedOffsetExitParticipant homeSharedOffsetExitParticipant) {
        groupExitParticipant = homeSharedOffsetExitParticipant;
    }
}
