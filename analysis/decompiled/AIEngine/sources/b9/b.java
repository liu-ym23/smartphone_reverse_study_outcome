package b9;

import androidx.compose.runtime.g;
import com.stepos.aicgroup.internal.strategy.CGroupStrategyManager;
import com.stepos.core.ability.AbilityManager;
import com.stepos.core.ability.e;
import com.stepos.core.common.telemetry.ModelCallSessionTracker;
import com.stepos.core.common.telemetry.d;
import com.stepos.core.model.concurrency.ThreadPoolManagerImpl;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import java.util.function.Predicate;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3139a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3140b;

    public /* synthetic */ b(l lVar, int i10) {
        this.f3139a = i10;
        this.f3140b = lVar;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i10 = this.f3139a;
        l lVar = this.f3140b;
        switch (i10) {
            case 0:
                return InteractiveSessionRegistry.sweepExpired$lambda$1((a) lVar, obj);
            case 1:
                CGroupStrategyManager.Companion companion = CGroupStrategyManager.Companion;
                return ((Boolean) ((com.stepos.aicgroup.internal.strategy.a) lVar).invoke(obj)).booleanValue();
            case 2:
                return AbilityManager.releaseAbility$lambda$38((e) lVar, obj);
            case 3:
                return ModelCallSessionTracker.reportTerminalOnce$lambda$5((d) lVar, obj);
            case 4:
                return ModelCallSessionTracker.bind$lambda$1((g) lVar, obj);
            case 5:
                return ModelCallSessionTracker.clear$lambda$10((e) lVar, obj);
            case 6:
                return ThreadPoolManagerImpl.hasForegroundTaskInWindow$lambda$14((a) lVar, obj);
            case 7:
                return ((Boolean) ((g) lVar).invoke(obj)).booleanValue();
            case 8:
                return ((Boolean) ((n9.a) lVar).invoke(obj)).booleanValue();
            default:
                return ((Boolean) ((e) lVar).invoke(obj)).booleanValue();
        }
    }
}
