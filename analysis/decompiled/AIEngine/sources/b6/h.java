package b6;

import com.stepos.aicgroup.memory.MemorySnapshot;
import com.stepos.aicgroup.memory.PressureLevel;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.performance.data.AicGroupPressureLevel;
import com.stepos.core.performance.signal.SignalHub;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;
import lb.n;
import zb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3068b;

    public /* synthetic */ h(Object obj, int i10) {
        this.f3067a = i10;
        this.f3068b = obj;
    }

    @Override // zb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        AicGroupPressureLevel aicGroupPressureLevel;
        int i10 = this.f3067a;
        Object obj4 = this.f3068b;
        switch (i10) {
            case 0:
                SignalHub signalHub = (SignalHub) obj4;
                PressureLevel sdkLevel = (PressureLevel) obj;
                MemorySnapshot snapshot = (MemorySnapshot) obj2;
                long jLongValue = ((Long) obj3).longValue();
                int i11 = AIEngineApplication.f5748d;
                kotlin.jvm.internal.g.f(sdkLevel, "sdkLevel");
                kotlin.jvm.internal.g.f(snapshot, "snapshot");
                int i12 = AIEngineApplication.a.f5752a[sdkLevel.ordinal()];
                if (i12 == 1) {
                    aicGroupPressureLevel = AicGroupPressureLevel.ULTRA_LOW;
                } else if (i12 == 2) {
                    aicGroupPressureLevel = AicGroupPressureLevel.LOW;
                } else {
                    if (i12 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    aicGroupPressureLevel = AicGroupPressureLevel.NORMAL;
                }
                signalHub.reportAicgroupPressure(aicGroupPressureLevel, snapshot.getAvailableKb(), jLongValue);
                return n.f10413a;
            case 1:
                return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1((MutexImpl) obj4, (SelectInstance) obj, obj2, obj3);
            default:
                return SemaphoreAndMutexImpl.onCancellationRelease$lambda$2((SemaphoreAndMutexImpl) obj4, (Throwable) obj, (n) obj2, (kotlin.coroutines.d) obj3);
        }
    }
}
