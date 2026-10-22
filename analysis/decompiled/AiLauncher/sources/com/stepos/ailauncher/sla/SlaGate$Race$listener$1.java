package com.stepos.ailauncher.sla;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.algorithm.sla.SlaDecision;
import com.stepos.aiengine.algorithm.sla.SlaExecutability;
import com.stepos.aiengine.algorithm.sla.SlaExecution;
import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.v;
import com.stepos.ailauncher.sla.x;
import com.stepos.net.exception.ApiErrorCode;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"com/stepos/ailauncher/sla/SlaGate$Race$listener$1", "Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;", "executability", "LY8/t;", "onDecision", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;)V", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "result", "onResult", "(Lcom/stepos/aiengine/algorithm/sla/SlaResult;)V", "", "errorCode", "", "message", "onError", "(ILjava/lang/String;)V", "onCancelled", "()V", "output", "onSlaOutput", "(Ljava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "sla_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SlaGate$Race$listener$1 implements SlaListener {
    final /* synthetic */ SlaGate.Race this$0;
    final /* synthetic */ SlaGate this$1;

    public SlaGate$Race$listener$1(SlaGate.Race race, SlaGate slaGate) {
        this.this$0 = race;
        this.this$1 = slaGate;
    }

    public static final Y8.t d(SlaGate slaGate, SlaGate.Race race, SlaDecision slaDecision) {
        SlaGate.d dVar = slaGate.callbacks;
        String str = race.traceId;
        String str2 = race.query;
        if (str2 == null) {
            str2 = "";
        }
        dVar.h(str, str2, slaDecision);
        return Y8.t.f7040a;
    }

    public static final CharSequence e(x.Parsed it) {
        kotlin.jvm.internal.p.i(it, "it");
        String function = it.getFunction();
        return function == null ? "" : function;
    }

    public static final CharSequence f(x.Parsed it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.c().toString();
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onCancelled() {
        this.this$0.b0("onCancelled");
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onCancelled -> fallback/route", false, 4, null);
        E5.a.a("[SLA][traceId=" + this.this$0.traceId + "] sdkCancelled");
        this.this$0.m0(ApiErrorCode.PARSE_ERROR);
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onDecision(SlaDecision decision, SlaExecutability executability) {
        SlaDecision slaDecision;
        kotlin.jvm.internal.p.i(decision, "decision");
        kotlin.jvm.internal.p.i(executability, "executability");
        if (this.this$0.localDispatch) {
            C4148a.d(SlaGate.TAG, "[#" + this.this$0.id + "] onDecision ignored (request uses localDispatch)", false, 4, null);
            return;
        }
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onDecision canExecute=" + executability.getCanExecute() + " function=" + decision.getFunction() + " conf=" + decision.getConfidence() + " errCode=" + executability.getErrorCode() + " errCode=" + executability.getReason(), false, 4, null);
        E5.a.a("[SLA][traceId=" + this.this$0.traceId + "] decision canExecute=" + executability.getCanExecute() + " function=" + decision.getFunction() + " code=" + executability.getErrorCode());
        if (executability.getCanExecute()) {
            slaDecision = decision;
            SlaGate.Race.r0(this.this$0, slaDecision, 0, false, 6, null);
        } else {
            slaDecision = decision;
            this.this$0.S(executability.getErrorCode());
        }
        G.e(G.INSTANCE, this.this$0.Z(), executability.getCanExecute() ? G.JUDGE_HIT : G.JUDGE_FALLBACK_OPENCLAW, slaDecision.getFunction(), null, Long.valueOf(SystemClock.elapsedRealtime() - this.this$0.startedAtMs), SlaRouter.INSTANCE.x(), 8, null);
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onError(int errorCode, String message) {
        kotlin.jvm.internal.p.i(message, "message");
        this.this$0.b0("onError");
        C4148a.u(SlaGate.TAG, "[#" + this.this$0.id + "] onError code=" + errorCode + " msg=" + message + " -> fallback/route", false, 4, null);
        E5.a.b("[SLA][traceId=" + this.this$0.traceId + "] error code=" + errorCode + " message=" + message);
        this.this$0.m0(errorCode);
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onResult(SlaResult result) {
        kotlin.jvm.internal.p.i(result, "result");
        this.this$0.b0("onResult");
        if (this.this$0.localDispatch) {
            C4148a.d(SlaGate.TAG, "[#" + this.this$0.id + "] onResult ignored (request uses localDispatch)", false, 4, null);
            return;
        }
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onResult status=" + result.getExecution().getStatus() + " errCode=" + result.getExecution().getErrorCode() + " errMsg=" + result.getExecution().getErrorMsg() + " totalMs=" + result.getTotalElapsedMs() + " resultJson=" + result.getExecution().getResultJson(), false, 4, null);
        E5.a.a("[SLA][traceId=" + this.this$0.traceId + "] result status=" + result.getExecution().getStatus() + " code=" + result.getExecution().getErrorCode() + " totalMs=" + result.getTotalElapsedMs() + " asrBound=" + (this.this$0.query != null));
        if (this.this$0.winner.get() == SlaGate.Winner.SLA) {
            this.this$0.R(result);
        }
        boolean z10 = result.getExecution().getStatus() == SlaExecution.Status.SUCCESS;
        G.INSTANCE.a(this.this$0.Z(), z10 ? "success" : "fail", z10 ? null : result.getExecution().getErrorMsg(), Long.valueOf(result.getExecution().getElapsedMs()));
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onRoutingDecision(String executionLocation, String reason) {
        kotlin.jvm.internal.p.i(executionLocation, "executionLocation");
        kotlin.jvm.internal.p.i(reason, "reason");
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onRoutingDecision executionLocation=" + executionLocation + " reason=" + reason, false, 4, null);
    }

    @Override // com.stepos.aiengine.algorithm.sla.SlaListener
    public void onSlaOutput(String output) {
        ArrayList arrayList;
        String strA0;
        ArrayList arrayList2;
        kotlin.jvm.internal.p.i(output, "output");
        if (!this.this$0.localDispatch) {
            C4148a.d(SlaGate.TAG, "[#" + this.this$0.id + "] onSlaOutput ignored (request uses AIEngine dispatch) len=" + output.length(), false, 4, null);
            return;
        }
        this.this$0.b0("onSlaOutput");
        if (!this.this$0.localOutputHandled.compareAndSet(false, true)) {
            C4148a.u(SlaGate.TAG, "[#" + this.this$0.id + "] duplicate onSlaOutput ignored", false, 4, null);
            return;
        }
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onSlaOutput len=" + output.length() + " raw=\"" + output + "\"", false, 4, null);
        List<x.Parsed> listB = x.INSTANCE.b(output);
        boolean zB = v.INSTANCE.b(this.this$1.context);
        ArrayList arrayList3 = new ArrayList(listB.size());
        ArrayList arrayList4 = new ArrayList(listB.size());
        final SlaGate.Race race = this.this$0;
        SlaGate slaGate = this.this$1;
        Iterator it = listB.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            x.Parsed parsed = (x.Parsed) next;
            int i12 = race.id;
            String str = race.traceId;
            int size = listB.size();
            String function = parsed.getFunction();
            List<x.Parsed> list = listB;
            String str2 = function == null ? "" : function;
            Map<String, String> mapC = parsed.c();
            Iterator it2 = it;
            boolean fallback = parsed.getFallback();
            final SlaGate slaGate2 = slaGate;
            String rejectReason = parsed.getRejectReason();
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList5 = arrayList4;
            sb2.append("[LOCAL][ABILITY_PARSE] raceId=");
            sb2.append(i12);
            sb2.append(" traceId=");
            sb2.append(str);
            sb2.append(" index=");
            sb2.append(i10);
            sb2.append("/");
            sb2.append(size);
            sb2.append(" ability=");
            sb2.append(str2);
            sb2.append(" params=");
            sb2.append(mapC);
            sb2.append(" fallback=");
            sb2.append(fallback);
            sb2.append(" rejectReason=");
            sb2.append(rejectReason);
            C4148a.k(SlaGate.TAG, sb2.toString(), false, 4, null);
            v.Verdict verdictA = v.INSTANCE.a(parsed.getFunction(), parsed.getFallback(), zB);
            if (verdictA.getCanExecute()) {
                arrayList3.add(parsed);
                slaGate = slaGate2;
                arrayList2 = arrayList5;
            } else {
                if (verdictA.getErrorCode() == 280002 && parsed.getFunction() != null) {
                    final SlaDecision slaDecision = new SlaDecision(parsed.getFunction(), parsed.getText(), parsed.c(), null, 1.0f, C1173v.m(), null);
                    G g10 = G.INSTANCE;
                    String strZ = race.Z();
                    String function2 = parsed.getFunction();
                    Map<String, String> mapC2 = parsed.c();
                    if (mapC2.isEmpty()) {
                        mapC2 = null;
                    }
                    g10.d(strZ, G.JUDGE_HIT, function2, mapC2 != null ? mapC2.toString() : null, Long.valueOf(SystemClock.elapsedRealtime() - race.startedAtMs), SlaRouter.INSTANCE.x());
                    if (!race.winner.compareAndSet(SlaGate.Winner.PENDING, SlaGate.Winner.SLA)) {
                        C4148a.u(SlaGate.TAG, "[#" + race.id + "] SLA_SCREEN_LOCKED 但 winner=" + race.winner.get() + " 已终态 -> 不缓存", false, 4, null);
                        return;
                    }
                    kotlinx.coroutines.g gVar = race.timerJob;
                    if (gVar != null) {
                        kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                    }
                    race.Q("lock decision already terminal");
                    String str3 = race.traceId;
                    String strZ2 = race.Z();
                    String str4 = race.query;
                    slaGate2.E(slaDecision, str3, strZ2, str4 != null ? str4 : "", race.proceed);
                    C4148a.k(SlaGate.TAG, "[#" + race.id + "] onSlaOutput SLA_SCREEN_LOCKED -> 缓存 decision 等待解锁重放 function=" + parsed.getFunction(), false, 4, null);
                    E5.a.a("[SLA][traceId=" + race.traceId + "] lockMiss function=" + parsed.getFunction() + " -> cached for unlock replay");
                    race.c0(new InterfaceC5063a() { // from class: com.stepos.ailauncher.sla.q
                        @Override // p9.InterfaceC5063a
                        public final Object invoke() {
                            return SlaGate$Race$listener$1.d(slaGate2, race, slaDecision);
                        }
                    });
                    return;
                }
                slaGate = slaGate2;
                arrayList2 = arrayList5;
                arrayList2.add(verdictA);
                int i13 = race.id;
                int errorCode = verdictA.getErrorCode();
                String reason = verdictA.getReason();
                String function3 = parsed.getFunction();
                if (function3 == null) {
                    function3 = "";
                }
                C4148a.k(SlaGate.TAG, "[#" + i13 + "] action[" + i10 + "] 不可执行 code=" + errorCode + " reason=" + reason + " ability=" + function3 + " -> 丢弃", false, 4, null);
                G g11 = G.INSTANCE;
                String strZ3 = race.Z();
                String function4 = parsed.getFunction();
                Map<String, String> mapC3 = parsed.c();
                if (mapC3.isEmpty()) {
                    mapC3 = null;
                }
                g11.d(strZ3, G.JUDGE_FALLBACK_OPENCLAW, function4, mapC3 != null ? mapC3.toString() : null, Long.valueOf(SystemClock.elapsedRealtime() - race.startedAtMs), SlaRouter.INSTANCE.x());
            }
            arrayList4 = arrayList2;
            it = it2;
            i10 = i11;
            listB = list;
        }
        ArrayList arrayList6 = arrayList4;
        if (arrayList3.isEmpty()) {
            v.Verdict verdict = (v.Verdict) Z8.F.s0(arrayList6);
            int errorCode2 = verdict != null ? verdict.getErrorCode() : 280001;
            C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onSlaOutput 无可执行动作 code=" + errorCode2 + " -> fallback", false, 4, null);
            this.this$0.S(errorCode2);
            return;
        }
        G g12 = G.INSTANCE;
        String strZ4 = this.this$0.Z();
        String strA02 = Z8.F.A0(arrayList3, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sla.r
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SlaGate$Race$listener$1.e((x.Parsed) obj);
            }
        }, 30, null);
        if (arrayList3.size() == 1) {
            Map<String, String> mapC4 = ((x.Parsed) arrayList3.get(0)).c();
            if (mapC4.isEmpty()) {
                mapC4 = null;
            }
            if (mapC4 != null) {
                strA0 = mapC4.toString();
                arrayList = arrayList3;
            } else {
                arrayList = arrayList3;
                strA0 = null;
            }
        } else {
            arrayList = arrayList3;
            strA0 = Z8.F.A0(arrayList3, Const.STR_MART_COMMA, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.sla.s
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return SlaGate$Race$listener$1.f((x.Parsed) obj);
                }
            }, 30, null);
        }
        g12.d(strZ4, G.JUDGE_HIT, strA02, strA0, Long.valueOf(SystemClock.elapsedRealtime() - this.this$0.startedAtMs), SlaRouter.INSTANCE.x());
        ArrayList arrayList7 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList7.add(SlaGate.INSTANCE.e((x.Parsed) it3.next()));
        }
        ArrayList arrayList8 = new ArrayList();
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            String function5 = ((x.Parsed) it4.next()).getFunction();
            if (function5 != null) {
                arrayList8.add(function5);
            }
        }
        this.this$0.q0((SlaDecision) Z8.F.q0(arrayList7), arrayList7.size(), true);
        if (this.this$0.winner.get() == SlaGate.Winner.SLA) {
            C1060i.d(this.this$1.scope, null, null, new SlaGate$Race$listener$1$onSlaOutput$5(this.this$1, arrayList8, this.this$0, arrayList, output, 0L, arrayList7, null), 3, null);
            return;
        }
        C4148a.k(SlaGate.TAG, "[#" + this.this$0.id + "] onSlaOutput 但原通路已胜出 -> 跳过派发", false, 4, null);
    }
}
