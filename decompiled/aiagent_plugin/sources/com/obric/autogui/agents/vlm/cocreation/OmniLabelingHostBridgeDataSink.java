package com.obric.autogui.agents.vlm.cocreation;

import com.obric.aiagent.assistant.idl.IFlowCocreationReviewIDL;
import com.obric.aiagent.assistant.idl.x;
import com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink;
import com.obric.autogui.common.api.cocreation.OmniLabelingStepRecord;
import com.obric.autogui.common.api.cocreation.OmniLabelingUserStopRecord;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.n;
import d.o.o;

/* JADX INFO: compiled from: OmniLabelingHostBridgeDataSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingHostBridgeDataSink implements IOmniLabelingDataSink {
    private static final a Companion = null;
    private static final String TAG = "OmniLabelingHostBridge";

    /* JADX INFO: compiled from: OmniLabelingHostBridgeDataSink.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        static /* synthetic */ String a(a r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r2 = 96;
        L6:
            return r0.a(r1, r2);
        }

        private final String a(String r7, int r8) {
            String r6 = o.a(r7, "\n", "\\n", false, 4, null);
            if (r6.length() > r8) goto L6;
            return r6;
        L6:
            return o.e(r6, r8) + "...";
        }
    }

    static {
        Companion = new a(null);
    }

    public OmniLabelingHostBridgeDataSink() {
    }

    @Override // com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink
    public void onStepLogged(OmniLabelingStepRecord r20) {
        d.h.b.o.e(r20, "record");
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20.getRecordId(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L20:
        Loog.INSTANCE.w(TAG, "skip invalid recordId=" + r20.getRecordId() + ", queryLength=" + r20.getUserQuery().length());
        return;
    L5:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20.getUserQuery(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L20;
        Loog r0 = Loog.INSTANCE;
        StringBuilder r4 = new StringBuilder().append("forward step recordId=").append(r20.getRecordId()).append(", stepIndex=").append(r20.getStepIndex()).append(", createdAt=").append(r20.getCreatedAt()).append(", finishAt=").append(r20.getFinishTimeMillis()).append(", last=").append(r20.isLastStep()).append(", success=").append(r20.isSuccess()).append(", taskTriggerType=").append(r20.getTaskTriggerType()).append(", query=");
        a r6 = Companion;
        r0.i(TAG, r4.append(a.a(r6, r20.getUserQuery(), 0, 1, null)).append(", desc=").append(a.a(r6, r20.getStepDescription(), 0, 1, null)).append(", reply=").append(a.a(r6, r20.getModelReply(), 0, 1, null)).toString());
        n.a r1 = n.f38560a;     // Catch: Throwable -> L14
        OmniLabelingHostBridgeDataSink r2 = (OmniLabelingHostBridgeDataSink) ZeusTransformUtils.preCheckCast(this, OmniLabelingHostBridgeDataSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        IFlowCocreationReviewIDL r7 = x.a(aa.b(IFlowCocreationReviewIDL.class));     // Catch: Throwable -> L14
        if (r7 != null) goto L12;
        Loog.INSTANCE.w(TAG, "flow cocreation review ipc missing, recordId=" + r20.getRecordId());     // Catch: Throwable -> L14
        return;
    L12:
        r7.logOmniStep(r20.getRecordId(), r20.getCreatedAt(), r20.getUserQuery(), r20.getStepIndex(), r20.getStepDescription(), r20.getModelReply(), r20.isLastStep(), r20.isSuccess(), r20.getFinishTimeMillis(), r20.getTaskTriggerType());     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "forward dispatched recordId=" + r20.getRecordId() + ", stepIndex=" + r20.getStepIndex());     // Catch: Throwable -> L14
        Object r3 = n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r5 = n.c(r3);
        if (r5 == null) goto L23;
        Loog.INSTANCE.w(TAG, "forward failed recordId=" + r20.getRecordId() + ", error=" + r5.getMessage());
        return;
    L23:
        return;
    L14:
        th = move-exception;
        n.a r8 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L16
    }

    @Override // com.obric.autogui.common.api.cocreation.IOmniLabelingDataSink
    public void onUserStopped(OmniLabelingUserStopRecord r12) {
        d.h.b.o.e(r12, "record");
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.getRecordId(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
    L20:
        Loog.INSTANCE.w(TAG, "skip invalid user stop recordId=" + r12.getRecordId() + ", queryLength=" + r12.getUserQuery().length());
        return;
    L5:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12.getUserQuery(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L20;
        Loog.INSTANCE.i(TAG, "forward user stop recordId=" + r12.getRecordId() + ", createdAt=" + r12.getCreatedAt() + ", finishAt=" + r12.getFinishTimeMillis() + ", reason=" + r12.getReason() + ", taskTriggerType=" + r12.getTaskTriggerType() + ", query=" + a.a(Companion, r12.getUserQuery(), 0, 1, null));
        n.a r0 = n.f38560a;     // Catch: Throwable -> L14
        OmniLabelingHostBridgeDataSink r11 = (OmniLabelingHostBridgeDataSink) ZeusTransformUtils.preCheckCast(this, OmniLabelingHostBridgeDataSink.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        IFlowCocreationReviewIDL r2 = x.a(aa.b(IFlowCocreationReviewIDL.class));     // Catch: Throwable -> L14
        if (r2 != null) goto L12;
        Loog.INSTANCE.w(TAG, "flow cocreation review ipc missing for user stop, recordId=" + r12.getRecordId());     // Catch: Throwable -> L14
        return;
    L12:
        r2.logOmniUserStop(r12.getRecordId(), r12.getCreatedAt(), r12.getUserQuery(), r12.getFinishTimeMillis(), r12.getReason(), r12.getTaskTriggerType());     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "forward user stop dispatched recordId=" + r12.getRecordId());     // Catch: Throwable -> L14
        Object r13 = n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L16:
        Throwable r14 = n.c(r13);
        if (r14 == null) goto L23;
        Loog.INSTANCE.w(TAG, "forward user stop failed recordId=" + r12.getRecordId() + ", error=" + r14.getMessage());
        return;
    L23:
        return;
    L14:
        th = move-exception;
        n.a r1 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L16
    }
}
