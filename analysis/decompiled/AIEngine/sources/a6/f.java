package a6;

import android.app.Application;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.aicgroup.AiThermalManager;
import com.stepos.aicgroup.internal.CGroupAdjuster;
import com.stepos.aicgroup.resource.ResourcePressureSceneManager;
import com.stepos.thermal.StepOSThermalManager;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f50a;

    public /* synthetic */ f(int i10) {
        this.f50a = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.f50a) {
            case 0:
                ResourcePressureSceneManager.release$lambda$3();
                return;
            case 1:
                AiThermalManager.INSTANCE.getClass();
                Object obj2 = AiThermalManager.f5637b;
                if (obj2 == null || (obj = AiThermalManager.f5638c) == null) {
                    return;
                }
                try {
                    obj2.getClass().getMethod("unregisterListener", StepOSThermalManager.OnThermalChangedListener.class).invoke(obj2, obj);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            case 2:
                AiThermalManager.INSTANCE.getClass();
                AiThermalManager.a();
                return;
            case 3:
                AiThermalManager.INSTANCE.getClass();
                AiThermalManager.a();
                return;
            default:
                Pair<CGroupAdjuster.ProcessGroupState, CGroupAdjuster.ProcessGroupState> andSet = CGroupAdjuster.f5709k.getAndSet(null);
                if (andSet != null) {
                    CGroupAdjuster.INSTANCE.getClass();
                    Application applicationA = CGroupAdjuster.a("throttle-delayed");
                    if (applicationA != null) {
                        CGroupAdjuster.b(applicationA, andSet.f9985a, andSet.f9986b);
                        CGroupAdjuster.f5707i = SystemClock.uptimeMillis();
                        Log.d("CGroupAdjuster", "延迟发送广播: " + andSet.f9985a.name() + " -> " + andSet.f9986b.name());
                    }
                }
                CGroupAdjuster.f5708j.set(false);
                return;
        }
    }
}
