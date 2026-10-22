package androidx.appcompat.widget;

import android.content.Context;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.common.picker.WheelPicker;
import com.stepos.core.common.atomic.AtomicSdkClientReal;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.runtime.EngineRuntimeConfig;
import com.stepos.deepbinder.service.DeepBinderProvider;
import com.stepos.policy.sdk.widget.PolicySDKLoadDataView;
import com.tencent.mmkv.MMKV;
import com.tonyodev.fetch2core.Reason;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f953b;

    public /* synthetic */ y0(cb.i iVar, boolean z, boolean z3) {
        this.f952a = 3;
        this.f953b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        boolean z3;
        Object objA;
        AtomicLong atomicLongPutIfAbsent;
        switch (this.f952a) {
            case 0:
                Toolbar.f fVar = ((Toolbar) this.f953b).O;
                androidx.appcompat.view.menu.h hVar = fVar != null ? fVar.f730b : null;
                if (hVar != null) {
                    hVar.collapseActionView();
                    return;
                }
                return;
            case 1:
                b.n.a((b.n) this.f953b);
                return;
            case 2:
                AIEngineApplication aIEngineApplication = (AIEngineApplication) this.f953b;
                int i10 = AIEngineApplication.f5748d;
                EngineRuntimeConfig engineRuntimeConfig = EngineRuntimeConfig.INSTANCE;
                Context applicationContext = aIEngineApplication.getApplicationContext();
                kotlin.jvm.internal.g.e(applicationContext, "getApplicationContext(...)");
                engineRuntimeConfig.init(applicationContext);
                return;
            case 3:
                cb.i iVar = (cb.i) this.f953b;
                synchronized (iVar.f3343i) {
                    z = iVar.f3344j;
                }
                if (!z) {
                    Iterator it = iVar.f3345k.iterator();
                    if (it.hasNext()) {
                        ((gb.a) it.next()).getClass();
                        Reason reason = Reason.f8218a;
                        throw null;
                    }
                }
                synchronized (iVar.f3343i) {
                    z3 = iVar.f3344j;
                }
                if (z3) {
                    return;
                }
                iVar.f3338c.c(iVar.f3337b.f14193o, iVar.f3346l);
                return;
            case 4:
                return;
            case 5:
                MaterialButton.a((MaterialButton) this.f953b);
                return;
            case 6:
                h1.f fVar2 = (h1.f) this.f953b;
                if (fVar2 != null) {
                    fVar2.h();
                    return;
                }
                return;
            case 7:
                WheelPicker wheelPicker = (WheelPicker) this.f953b;
                int i11 = WheelPicker.D;
                wheelPicker.d();
                return;
            case 8:
                DeepBinderProvider.connect$lambda$4((DeepBinderProvider) this.f953b);
                return;
            case 9:
                PolicySDKLoadDataView.mProgressShowRunnable$lambda$0((PolicySDKLoadDataView) this.f953b);
                return;
            case 10:
                ModelManagerFragment.displayReadyRefresh$lambda$3((ModelManagerFragment) this.f953b);
                return;
            case 11:
                k2.d.c((k2.d) this.f953b);
                return;
            case 12:
                com.stepos.aiengine.preheat.a aVar = (com.stepos.aiengine.preheat.a) this.f953b;
                synchronized (aVar.f5921j) {
                    aVar.f5923l = null;
                    aVar.f5924m = 0L;
                    lb.n nVar = lb.n.f10413a;
                }
                if (aVar.f5918f.isEmpty()) {
                    return;
                }
                int iC = aVar.c() + 1;
                int iF0 = mb.l.f0(com.stepos.aiengine.preheat.a.f5911p);
                if (iC > iF0) {
                    iC = iF0;
                }
                try {
                    MMKV mmkv = (MMKV) aVar.f5925n.getValue();
                    if (mmkv != null) {
                        mmkv.putInt("preheat_backoff_level", iC);
                    }
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                ConcurrentHashMap<String, AtomicLong> concurrentHashMap = aVar.f5920i;
                AtomicLong atomicLong = concurrentHashMap.get("timer_fired");
                if (atomicLong == null && (atomicLongPutIfAbsent = concurrentHashMap.putIfAbsent("timer_fired", (atomicLong = new AtomicLong()))) != null) {
                    atomicLong = atomicLongPutIfAbsent;
                }
                atomicLong.incrementAndGet();
                AIEngineLogger.i(LogModule.SERVICE, "PreheatGateController", "backoff retry fired, pending=" + aVar.f5918f + " level=" + aVar.c());
                try {
                    objA = aVar.f5916d.invoke();
                } catch (Throwable th2) {
                    objA = kotlin.c.a(th2);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.SERVICE, "PreheatGateController", "retryRunner threw: " + thB);
                    return;
                }
                return;
            case 13:
                try {
                    ((m7.a) this.f953b).c();
                    return;
                } catch (Throwable th3) {
                    kotlin.c.a(th3);
                    return;
                }
            default:
                AtomicSdkClientReal.scheduleLateArrivalCleanup$lambda$7((String) this.f953b);
                return;
        }
    }

    public /* synthetic */ y0(Object obj, int i10) {
        this.f952a = i10;
        this.f953b = obj;
    }

    private final void a() {
    }
}
