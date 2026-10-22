package com.stepos.aiengine.algorithm.sla;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaListener;", "", "Lcom/stepos/aiengine/algorithm/sla/SlaResult;", "result", "LY8/t;", "onResult", "(Lcom/stepos/aiengine/algorithm/sla/SlaResult;)V", "", "errorCode", "", "message", "onError", "(ILjava/lang/String;)V", "onCancelled", "()V", "Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "decision", "Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;", "executability", "onDecision", "(Lcom/stepos/aiengine/algorithm/sla/SlaDecision;Lcom/stepos/aiengine/algorithm/sla/SlaExecutability;)V", "output", "onSlaOutput", "(Ljava/lang/String;)V", "executionLocation", "reason", "onRoutingDecision", "(Ljava/lang/String;Ljava/lang/String;)V", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SlaListener {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onCancelled(SlaListener slaListener) {
        }

        public static void onDecision(SlaListener slaListener, SlaDecision decision, SlaExecutability executability) {
            p.i(decision, "decision");
            p.i(executability, "executability");
        }

        public static void onRoutingDecision(SlaListener slaListener, String executionLocation, String reason) {
            p.i(executionLocation, "executionLocation");
            p.i(reason, "reason");
        }

        public static void onSlaOutput(SlaListener slaListener, String output) {
            p.i(output, "output");
        }
    }

    void onCancelled();

    void onDecision(SlaDecision decision, SlaExecutability executability);

    void onError(int errorCode, String message);

    void onResult(SlaResult result);

    void onRoutingDecision(String executionLocation, String reason);

    void onSlaOutput(String output);
}
