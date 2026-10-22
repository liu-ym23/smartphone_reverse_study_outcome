package com.stepos.ailauncher.homegesture;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeLayerHandle;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.HomeTopKind;
import com.stepos.ailauncher.contract.api.homegesture.RootStrategy;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013J9\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/homegesture/c;", "", "<init>", "()V", "Lcom/stepos/ailauncher/homegesture/C;", "registry", "", "overlayOpen", "yieldMinusOneToSystem", "Lcom/stepos/ailauncher/homegesture/b;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/homegesture/C;ZZ)Lcom/stepos/ailauncher/homegesture/b;", "", "liveRootAction", "e", "(Ljava/lang/Integer;)Z", "desktopPresent", "desktopRootAction", Const.INTENT_KEY_UMID, "(ZLjava/lang/Integer;)Z", "", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeLayerHandle;", "desktopSheets", "minusOneSheets", "c", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Ljava/util/List;", "Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;", "strategy", "", "reason", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/homegesture/C;Lcom/stepos/ailauncher/contract/api/homegesture/RootStrategy;Ljava/lang/String;)Lcom/stepos/ailauncher/homegesture/b;", "homegesture_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.homegesture.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3336c {
    public static final C3336c INSTANCE = new C3336c();

    public final EligibilityDecision a(C registry, RootStrategy strategy, String reason) {
        HomeRootToken token = strategy.getToken();
        HomeLayerHandle homeLayerHandleJ = registry.j(token);
        if (homeLayerHandleJ != null) {
            return new EligibilityDecision(true, strategy.getScene(), 1, strategy.taskId(), reason + ":popup:" + homeLayerHandleJ.getLayerId(), token, HomeTopKind.POPUP, homeLayerHandleJ.getLayerId());
        }
        int iRootAction = strategy.rootAction();
        if (iRootAction == 2) {
            return new EligibilityDecision(true, strategy.getScene(), 2, strategy.taskId(), reason + ":open-desktop", token, HomeTopKind.ROOT, "root:" + token.getWire());
        }
        HomeLayerHandle homeLayerHandleK = registry.k(token);
        if (homeLayerHandleK != null) {
            return new EligibilityDecision(true, strategy.getScene(), 1, strategy.taskId(), reason + ":sheet:" + homeLayerHandleK.getLayerId(), token, HomeTopKind.SHEET, homeLayerHandleK.getLayerId());
        }
        if (iRootAction == 0) {
            return EligibilityDecision.INSTANCE.a(reason + ":root-none");
        }
        return new EligibilityDecision(true, strategy.getScene(), iRootAction, strategy.taskId(), reason + ":root:" + iRootAction, token, HomeTopKind.ROOT, "root:" + token.getWire());
    }

    public final EligibilityDecision b(C registry, boolean overlayOpen, boolean yieldMinusOneToSystem) {
        kotlin.jvm.internal.p.i(registry, "registry");
        RootStrategy rootStrategyH = registry.h(HomeRootToken.BOARD);
        if (rootStrategyH != null && rootStrategyH.isPresent()) {
            return a(registry, rootStrategyH, "world-board");
        }
        if (yieldMinusOneToSystem) {
            return EligibilityDecision.INSTANCE.a("minus-one-third-party");
        }
        HomeRootToken homeRootToken = HomeRootToken.MINUS_ONE;
        RootStrategy rootStrategyH2 = registry.h(homeRootToken);
        HomeRootToken homeRootToken2 = HomeRootToken.DESKTOP;
        RootStrategy rootStrategyH3 = registry.h(homeRootToken2);
        if (overlayOpen) {
            if (rootStrategyH2 != null && rootStrategyH2.isPresent()) {
                return a(registry, rootStrategyH2, "world-minus-one");
            }
            if (rootStrategyH2 != null && registry.c(homeRootToken)) {
                if (!d(rootStrategyH3 != null && rootStrategyH3.isPresent(), rootStrategyH3 != null ? Integer.valueOf(rootStrategyH3.rootAction()) : null)) {
                    return a(registry, rootStrategyH2, "world-minus-one-sheet");
                }
            }
        }
        return (rootStrategyH3 == null || !rootStrategyH3.isPresent()) ? (rootStrategyH2 == null || !registry.c(homeRootToken)) ? (rootStrategyH3 == null || !registry.c(homeRootToken2) || overlayOpen) ? EligibilityDecision.INSTANCE.a("no-world") : a(registry, rootStrategyH3, "world-desktop-sheet") : a(registry, rootStrategyH2, "world-minus-one-sheet") : a(registry, rootStrategyH3, "world-desktop");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<HomeLayerHandle> c(List<? extends HomeLayerHandle> desktopSheets, List<? extends HomeLayerHandle> minusOneSheets, Integer liveRootAction) {
        kotlin.jvm.internal.p.i(desktopSheets, "desktopSheets");
        kotlin.jvm.internal.p.i(minusOneSheets, "minusOneSheets");
        return (liveRootAction == null || liveRootAction.intValue() != 1 || minusOneSheets.isEmpty()) ? desktopSheets : Z8.F.S0(desktopSheets, minusOneSheets);
    }

    public final boolean d(boolean desktopPresent, Integer desktopRootAction) {
        return desktopPresent && desktopRootAction != null && desktopRootAction.intValue() == 1;
    }

    public final boolean e(Integer liveRootAction) {
        return liveRootAction != null && liveRootAction.intValue() == 2;
    }
}
