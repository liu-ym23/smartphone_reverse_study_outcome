package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.m0;
import com.stepos.ailauncher.contract.api.homegesture.HomeDismissReason;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilitySnapshot;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import com.stepos.ailauncher.homegesture.AbstractC3334a;
import h8.C4148a;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/homegesture/s;", "", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "coordinator", "<init>", "(Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;)V", "", "expectedGeneration", "LY8/t;", Const.INTENT_KEY_APIKEY, "(J)V", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;", "snapshot", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "Lcom/stepos/ailauncher/homegesture/a$a;", "accepted", "c", "(Lcom/stepos/ailauncher/homegesture/a$a;Lcom/stepos/ailauncher/contract/api/homegesture/HomeGestureEligibilitySnapshot;)V", "Lcom/stepos/ailauncher/homegesture/HomeGestureCoordinatorImpl;", "Companion", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3351s {
    private static final String TAG = "HomeGestureDispatch";
    private final HomeGestureCoordinatorImpl coordinator;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.homegesture.s$b */
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HomeGroupExitStartResult.values().length];
            try {
                iArr[HomeGroupExitStartResult.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeGroupExitStartResult.ALREADY_ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeGroupExitStartResult.NOT_ELIGIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public C3351s(HomeGestureCoordinatorImpl coordinator) {
        kotlin.jvm.internal.p.i(coordinator, "coordinator");
        this.coordinator = coordinator;
    }

    public final void a(long expectedGeneration) {
        PeekEpoch peekEpochD;
        HomeGestureEligibilitySnapshot snapshot;
        HomeGestureEligibilitySnapshot homeGestureEligibilitySnapshotCurrentSnapshot = this.coordinator.currentSnapshot();
        AbstractC3334a abstractC3334aB = this.coordinator.getClaimer().b(expectedGeneration, homeGestureEligibilitySnapshotCurrentSnapshot.getGeneration(), homeGestureEligibilitySnapshotCurrentSnapshot.getConsumable(), homeGestureEligibilitySnapshotCurrentSnapshot.getRootToken(), homeGestureEligibilitySnapshotCurrentSnapshot.fingerprint());
        if (abstractC3334aB instanceof AbstractC3334a.Rejected) {
            C4148a.u(TAG, "CONSUME rejected " + ((AbstractC3334a.Rejected) abstractC3334aB).getReason(), false, 4, null);
            return;
        }
        if (!(abstractC3334aB instanceof AbstractC3334a.Accepted)) {
            throw new NoWhenBranchMatchedException();
        }
        AbstractC3334a.Accepted accepted = (AbstractC3334a.Accepted) abstractC3334aB;
        C4148a.k(TAG, "CONSUME claimed gen=" + accepted.getClaimedGeneration() + " peek=" + accepted.getUsedPeekEpoch() + " snapGen=" + homeGestureEligibilitySnapshotCurrentSnapshot.getGeneration() + " action=" + homeGestureEligibilitySnapshotCurrentSnapshot.getAction() + " token=" + homeGestureEligibilitySnapshotCurrentSnapshot.getRootToken().getWire(), false, 4, null);
        this.coordinator.notifyConsumeStarted();
        if (accepted.getUsedPeekEpoch() && (peekEpochD = this.coordinator.getClaimer().d()) != null && (snapshot = peekEpochD.getSnapshot()) != null) {
            homeGestureEligibilitySnapshotCurrentSnapshot = snapshot;
        }
        c(accepted, homeGestureEligibilitySnapshotCurrentSnapshot);
        if (!homeGestureEligibilitySnapshotCurrentSnapshot.getConsumable()) {
            C4148a.u(TAG, "CONSUME snapshot not consumable → no-op", false, 4, null);
            this.coordinator.endPeek();
            return;
        }
        int action = homeGestureEligibilitySnapshotCurrentSnapshot.getAction();
        if (action == 2 || action == 4) {
            RootStrategy rootStrategyH = this.coordinator.getRegistry().h(homeGestureEligibilitySnapshotCurrentSnapshot.getRootToken());
            if (rootStrategyH != null) {
                rootStrategyH.consumeRoot(homeGestureEligibilitySnapshotCurrentSnapshot.getAction());
            }
        } else {
            b(homeGestureEligibilitySnapshotCurrentSnapshot);
        }
        this.coordinator.endPeek();
        this.coordinator.l("after-consume", true);
    }

    public final void b(HomeGestureEligibilitySnapshot snapshot) {
        HomeRootToken rootToken = snapshot.getRootToken();
        HomeLayerHandle homeLayerHandleJ = this.coordinator.getRegistry().j(rootToken);
        if (homeLayerHandleJ != null) {
            boolean zDismiss = homeLayerHandleJ.dismiss(HomeDismissReason.HOME);
            C4148a.k(TAG, "consume popup id=" + homeLayerHandleJ.getLayerId() + " ok=" + zDismiss, false, 4, null);
            return;
        }
        RootStrategy rootStrategyH = this.coordinator.getRegistry().h(rootToken);
        Integer numValueOf = rootStrategyH != null ? Integer.valueOf(rootStrategyH.rootAction()) : null;
        List<HomeLayerHandle> listU = Z8.B.U(this.coordinator.getRegistry().i(rootToken));
        if (rootToken == HomeRootToken.DESKTOP) {
            listU = C3336c.INSTANCE.c(listU, Z8.B.U(this.coordinator.getRegistry().i(HomeRootToken.MINUS_ONE)), numValueOf);
        }
        Integer numValueOf2 = !listU.isEmpty() ? numValueOf : Integer.valueOf(snapshot.getAction());
        if (C3336c.INSTANCE.e(numValueOf)) {
            C4148a.k(TAG, "consume stacked sheets skipped → OPEN_DESKTOP token=" + rootToken.getWire(), false, 4, null);
            if (rootStrategyH != null) {
                rootStrategyH.consumeRoot(2);
                return;
            }
            return;
        }
        if (rootToken == HomeRootToken.MINUS_ONE) {
            int i10 = b.$EnumSwitchMapping$0[this.coordinator.u(rootStrategyH, numValueOf2, listU).ordinal()];
            if (i10 == 1 || i10 == 2) {
                return;
            }
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (numValueOf2 != null && numValueOf2.intValue() == 1) {
            int i11 = b.$EnumSwitchMapping$0[this.coordinator.p(rootToken, rootStrategyH, listU).ordinal()];
            if (i11 == 1 || i11 == 2) {
                return;
            }
            if (i11 != 3) {
                throw new NoWhenBranchMatchedException();
            }
        }
        for (HomeLayerHandle homeLayerHandle : listU) {
            if (homeLayerHandle.isShowing()) {
                boolean zDismiss2 = homeLayerHandle.dismiss(HomeDismissReason.HOME);
                C4148a.k(TAG, "consume sheet id=" + homeLayerHandle.getLayerId() + " ok=" + zDismiss2, false, 4, null);
            }
        }
        if (rootStrategyH != null) {
            rootStrategyH.consumeRoot(numValueOf2 != null ? numValueOf2.intValue() : snapshot.getAction());
            return;
        }
        C4148a.u(TAG, "consume root missing token=" + rootToken.getWire(), false, 4, null);
    }

    public final void c(AbstractC3334a.Accepted accepted, HomeGestureEligibilitySnapshot snapshot) {
        if (accepted.getUsedPeekEpoch()) {
            return;
        }
        m0 m0Var = m0.INSTANCE;
        if (m0Var.h() && snapshot.getRootToken() == HomeRootToken.MINUS_ONE && snapshot.getAction() == 4) {
            C4148a.k(TAG, "CONSUME hide IME keep-focus token=minus-one action=NO_OP", false, 4, null);
            m0Var.f();
        }
    }
}
