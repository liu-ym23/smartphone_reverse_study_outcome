package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.applog.monitor.MonitorSampling;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public final class q2 implements l2, Handler.Callback {
    public Handler a;
    public final m2 b;
    public final e0 c;

    public q2(e0 mEngine) {
        Intrinsics.checkParameterIsNotNull(mEngine, "mEngine");
        this.c = mEngine;
        StringBuilder sbA = a.a("bd_tracker_monitor@");
        d dVar = mEngine.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
        sbA.append(dVar.m);
        HandlerThread handlerThread = new HandlerThread(sbA.toString());
        handlerThread.start();
        this.a = new Handler(handlerThread.getLooper(), this);
        Looper looper = this.a.getLooper();
        Intrinsics.checkExpressionValueIsNotNull(looper, "mHandler.looper");
        d dVar2 = mEngine.d;
        Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
        String str = dVar2.m;
        Intrinsics.checkExpressionValueIsNotNull(str, "mEngine.appLog.appId");
        Context contextB = mEngine.b();
        Intrinsics.checkExpressionValueIsNotNull(contextB, "mEngine.context");
        this.b = new m2(looper, str, contextB);
    }

    public void a(t2 data) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        u1 u1Var = this.c.e;
        Intrinsics.checkExpressionValueIsNotNull(u1Var, "mEngine.config");
        if (u1Var.k()) {
            if (MonitorSampling.INSTANCE.isSampling$agent_pickerChinaRelease()) {
                d dVar = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
                dVar.D.debug(8, "Monitor EventTrace hint trace:{}", data);
                this.b.a(data).track(data.g(), data.d());
                return;
            }
            if ((data instanceof c3) || (data instanceof w2)) {
                this.b.a(data).track(data.g(), data.d());
            }
            d dVar2 = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
            dVar2.D.debug(8, "Monitor EventTrace not hint trace:{}", data);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        int i = msg.what;
        if (i == 1) {
            d dVar = this.c.d;
            Intrinsics.checkExpressionValueIsNotNull(dVar, "mEngine.appLog");
            dVar.D.debug(8, "Monitor trace save:{}", msg.obj);
            k4 k4VarC = this.c.c();
            Object obj = msg.obj;
            if (!TypeIntrinsics.isMutableList(obj)) {
                obj = null;
            }
            k4VarC.c.b((List) obj);
        } else if (i == 2) {
            w1 w1Var = this.c.i;
            if (w1Var == null || w1Var.h() != 0) {
                d dVar2 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar2, "mEngine.appLog");
                dVar2.D.debug(8, "Monitor report...", new Object[0]);
                k4 k4VarC2 = this.c.c();
                d dVar3 = this.c.d;
                Intrinsics.checkExpressionValueIsNotNull(dVar3, "mEngine.appLog");
                String str = dVar3.m;
                w1 w1Var2 = this.c.i;
                Intrinsics.checkExpressionValueIsNotNull(w1Var2, "mEngine.dm");
                k4VarC2.b(str, w1Var2.e());
                e0 e0Var = this.c;
                e0Var.a(e0Var.l);
            } else {
                this.a.sendEmptyMessageDelayed(2, 500L);
            }
        }
        return true;
    }
}
