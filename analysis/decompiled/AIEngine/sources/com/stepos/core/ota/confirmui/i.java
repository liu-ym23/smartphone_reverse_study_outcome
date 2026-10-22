package com.stepos.core.ota.confirmui;

import com.stepos.aiengine.memory.AiModelPressureHandler;
import com.stepos.core.deepbinder.IOtaDeepBinderService;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.monitor.ActiveDownloadConditionMonitor;
import java.util.ArrayList;
import kotlin.jvm.internal.FunctionReferenceImpl;
import t5.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements ConfirmDecisionBus.DecisionListener, AiModelPressureHandler.a, a.InterfaceC0147a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f7508g;
    public final /* synthetic */ Object h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f7509i;

    public /* synthetic */ i(int i10, Object obj, Object obj2) {
        this.f7508g = i10;
        this.h = obj;
        this.f7509i = obj2;
    }

    @Override // t5.a.InterfaceC0147a
    public boolean a(int i10, String str) {
        ArrayList arrayList = (ArrayList) this.h;
        ArrayList arrayList2 = (ArrayList) this.f7509i;
        String strA = o5.d.a(str);
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            o5.b.a((p5.e) obj, str, strA, arrayList2, i10);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x01b3, code lost:
    
        r0 = r19.size();
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01bd, code lost:
    
        if (r6.isEmpty() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01bf, code lost:
    
        r3 = " inUse=" + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01ce, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01d3, code lost:
    
        if (r7.isEmpty() != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01d5, code lost:
    
        r6 = " pinned=" + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e4, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01e9, code lost:
    
        if (r8.isEmpty() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01eb, code lost:
    
        r7 = " failed=" + r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01fa, code lost:
    
        r7 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01fb, code lost:
    
        if (r4 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01fd, code lost:
    
        r5 = " stoppedEarly=true";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ff, code lost:
    
        r0 = h0.e.d(r10, "[memory] evict done: released=", r0, "/", " reason=");
        r0.append(r20);
        r0.append(r3);
        r0.append(r6);
        r0.append(r7);
        ai.onnxruntime.a.y(r0, r5, "ModelEvictor");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0217, code lost:
    
        return r10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [zb.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(java.util.ArrayList r19, com.stepos.base.model.ReleaseReason r20, f6.a r21) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.confirmui.i.b(java.util.ArrayList, com.stepos.base.model.ReleaseReason, f6.a):int");
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public void onDecision(ConfirmDecisionBus.Decision decision) {
        switch (this.f7508g) {
            case 0:
                ModelConfirmFlow.showNoNetworkGuide$lambda$51((ModelConfirmFlow) this.h, (IOtaDeepBinderService) this.f7509i, decision);
                break;
            default:
                ActiveDownloadConditionMonitor.showConfirm$lambda$23((String) this.h, (zb.l) this.f7509i, decision);
                break;
        }
    }

    public /* synthetic */ i(o5.b bVar, ArrayList arrayList, ArrayList arrayList2) {
        this.f7508g = 3;
        this.h = arrayList;
        this.f7509i = arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ i(zb.l lVar, zb.a aVar) {
        this.f7508g = 2;
        this.h = aVar;
        this.f7509i = (FunctionReferenceImpl) lVar;
    }
}
