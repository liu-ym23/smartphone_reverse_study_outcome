package com.stepos.aicgroup.internal;

import a6.f;
import android.app.Application;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.aicgroup.AiDispatchers;
import com.stepos.aicgroup.TrackedCoroutineDispatcher;
import com.stepos.aicgroup.internal.CGroupAdjuster;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import lb.n;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {
    @Override // zb.l
    public final Object invoke(Object obj) {
        AtomicInteger atomicInteger;
        TrackedCoroutineDispatcher.TaskEvent event = (TrackedCoroutineDispatcher.TaskEvent) obj;
        CGroupAdjuster cGroupAdjuster = CGroupAdjuster.INSTANCE;
        g.f(event, "event");
        CGroupAdjuster.INSTANCE.getClass();
        AiDispatchers.DispatcherPriority dispatcherPriority = CGroupAdjuster.f5711m.get(event.getDispatcherName());
        if (dispatcherPriority == null) {
            a0.a.A("未知的调度器: ", event.getDispatcherName(), "CGroupAdjuster");
        } else {
            int i10 = CGroupAdjuster.WhenMappings.$EnumSwitchMapping$0[dispatcherPriority.ordinal()];
            int i11 = 4;
            if (i10 == 1) {
                atomicInteger = CGroupAdjuster.f5700a;
            } else if (i10 == 2) {
                atomicInteger = CGroupAdjuster.f5701b;
            } else if (i10 == 3) {
                atomicInteger = CGroupAdjuster.f5702c;
            } else {
                if (i10 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                atomicInteger = CGroupAdjuster.f5703d;
            }
            if (event.isStart()) {
                int iIncrementAndGet = atomicInteger.incrementAndGet();
                StringBuilder sbS = ai.onnxruntime.a.s("任务开始: ", event.getDispatcherName(), ", 优先级: ", dispatcherPriority.name(), ", 当前计数: ");
                sbS.append(iIncrementAndGet);
                Log.d("CGroupAdjuster", sbS.toString());
            } else {
                int iDecrementAndGet = atomicInteger.decrementAndGet();
                String dispatcherName = event.getDispatcherName();
                String strName = dispatcherPriority.name();
                Long duration = event.getDuration();
                StringBuilder sbS2 = ai.onnxruntime.a.s("任务结束: ", dispatcherName, ", 优先级: ", strName, ", 当前计数: ");
                sbS2.append(iDecrementAndGet);
                sbS2.append(", 耗时: ");
                sbS2.append(duration);
                sbS2.append("ms");
                Log.d("CGroupAdjuster", sbS2.toString());
            }
            CGroupAdjuster.ProcessGroupState processGroupState = CGroupAdjuster.f5700a.get() > 0 ? CGroupAdjuster.ProcessGroupState.REALTIME : CGroupAdjuster.f5701b.get() > 0 ? CGroupAdjuster.ProcessGroupState.IMPORTANT : CGroupAdjuster.f5702c.get() > 0 ? CGroupAdjuster.ProcessGroupState.NORMAL : CGroupAdjuster.ProcessGroupState.BACKGROUND;
            if (processGroupState != CGroupAdjuster.f5705f) {
                CGroupAdjuster.ProcessGroupState processGroupState2 = CGroupAdjuster.f5705f;
                CGroupAdjuster.f5705f = processGroupState;
                Log.i("CGroupAdjuster", "进程组状态变化: " + processGroupState2.name() + " -> " + processGroupState.name());
                p<? super CGroupAdjuster.ProcessGroupState, ? super CGroupAdjuster.ProcessGroupState, n> pVar = CGroupAdjuster.f5704e;
                if (pVar != null) {
                    pVar.invoke(processGroupState2, processGroupState);
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long j10 = jUptimeMillis - CGroupAdjuster.f5707i;
                if (j10 >= 2000) {
                    Application applicationA = CGroupAdjuster.a("throttle-immediate");
                    if (applicationA != null) {
                        CGroupAdjuster.b(applicationA, processGroupState2, processGroupState);
                        CGroupAdjuster.f5707i = jUptimeMillis;
                        Log.d("CGroupAdjuster", "立即发送广播: " + processGroupState2.name() + " -> " + processGroupState.name());
                    }
                } else {
                    CGroupAdjuster.f5709k.set(new Pair<>(processGroupState2, processGroupState));
                    if (CGroupAdjuster.f5708j.compareAndSet(false, true)) {
                        long j11 = 2000 - j10;
                        f fVar = CGroupAdjuster.f5710l;
                        if (fVar != null) {
                            CGroupAdjuster.h.removeCallbacks(fVar);
                        }
                        f fVar2 = new f(i11);
                        CGroupAdjuster.f5710l = fVar2;
                        CGroupAdjuster.h.postDelayed(fVar2, j11);
                        Log.d("CGroupAdjuster", "广播已排队，将在 " + j11 + "ms 后发送");
                    } else {
                        Log.d("CGroupAdjuster", "更新待发送状态: " + processGroupState2.name() + " -> " + processGroupState.name());
                    }
                }
            }
        }
        return n.f10413a;
    }
}
