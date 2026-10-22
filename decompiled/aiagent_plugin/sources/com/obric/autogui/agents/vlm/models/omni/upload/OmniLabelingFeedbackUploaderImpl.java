package com.obric.autogui.agents.vlm.models.omni.upload;

import com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader;
import com.obric.autogui.common.api.cocreation.OmniLabelingFeedbackUploadRequest;
import com.obric.autogui.common.api.cocreation.OmniLabelingFeedbackUploadResult;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniLabelingFeedbackUploaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniLabelingFeedbackUploaderImpl implements IOmniLabelingFeedbackUploader {
    public static final a Companion = null;
    private static final String TAG = "OmniLabelingFeedbackUploader";

    /* JADX INFO: compiled from: OmniLabelingFeedbackUploaderImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OmniLabelingFeedbackUploaderImpl() {
    }

    @Override // com.obric.autogui.common.api.cocreation.IOmniLabelingFeedbackUploader
    public OmniLabelingFeedbackUploadResult uploadAnnotationFeedback(OmniLabelingFeedbackUploadRequest r18) {
        d.h.b.o.e(r18, Ext.KEY_REQUEST);
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18.getTaskId(), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        String r0 = r18.getContent();
        if (r0 != null) goto L9;
    L11:
        String r8 = null;
    L12:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r18.getTags(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r6.add(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString());
        goto L14
    L16:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L22;
        Object r9 = r5.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L18;
        r7.add(r9);
        goto L18
    L22:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.omni.a.j r11 = com.obric.autogui.agents.vlm.models.omni.a.j.f28179b;
        String r12 = r18.getType();
        if (r12 != null) goto L25;
    L27:
        String r13 = null;
    L28:
        com.obric.autogui.agents.vlm.models.omni.a.e r14 = new com.obric.autogui.agents.vlm.models.omni.a.e(r8, r10, r11, r13, null, false, null, 112, null);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L65;
        Loog r15 = Loog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("uploadAnnotationFeedback start, taskId=").append(r2).append(", recordId=").append(r18.getRecordId()).append(", type=");
        String r17 = r14.getType();
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        StringBuilder r19 = r16.append(r17).append(", tags=").append(r14.b()).append(", contentLength=");
        String r110 = r14.a();
        if (r110 == null) goto L36;
        int r111 = r110.length();
    L37:
        r15.i(TAG, r19.append(r111).toString());
        goto L65
    L36:
        r111 = 0;
    L65:
        d.n.a r20 = d.n.f38560a;     // Catch: Throwable -> L40
        OmniLabelingFeedbackUploaderImpl r21 = (OmniLabelingFeedbackUploaderImpl) ZeusTransformUtils.preCheckCast(this, OmniLabelingFeedbackUploaderImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        Object r22 = d.n.f(e.f28643a.b(r2, r14));     // Catch: Throwable -> L40
    L42:
        Throwable r23 = d.n.c(r22);
        if (r23 != null) goto L60;
        com.obric.autogui.agents.vlm.models.omni.a.d r24 = (com.obric.autogui.agents.vlm.models.omni.a.d) ZeusTransformUtils.preCheckCast(r22, com.obric.autogui.agents.vlm.models.omni.a.d.class, "com.obric.aiagent.plugin");
        if (r24.e() == 0) goto L47;
    L51:
        boolean r112 = false;
    L52:
        if (r112 == false) goto L54;
        String r25 = "upload success";
    L55:
        String r113 = r25;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L59;
        Loog.INSTANCE.i(TAG, "uploadAnnotationFeedback finished, taskId=" + r2 + ", recordId=" + r18.getRecordId() + ", success=" + r112 + ", summary=" + r24);
    L59:
        return new OmniLabelingFeedbackUploadResult(r112, r113, r24.d(), r24.e(), r24.f());
    L54:
        r25 = "upload interrupted, failed=" + r24.e() + ", stoppedByOmni=" + r24.g() + ", blocked=" + r24.h();
        goto L55
    L47:
        if (r24.g() == true) goto L51;
        if (r24.h() == true) goto L51;
        r112 = true;
        goto L52
    L60:
        OmniDataFeedbackLog.INSTANCE.e(TAG, "uploadAnnotationFeedback failed, taskId=" + r2, r23);
        String r26 = r23.getMessage();
        if (r26 != null) goto L64;
        r26 = "upload failed";
    L64:
        return new OmniLabelingFeedbackUploadResult(false, r26, 0, 0, 0, 28, null);
    L40:
        th = move-exception;
        d.n.a r27 = d.n.f38560a;
        r22 = d.n.f(d.o.a(th));
        goto L42
    L25:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L27;
        r13 = r12;
        goto L28
    L9:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L11;
        r8 = r0;
        goto L12
    L5:
        return new OmniLabelingFeedbackUploadResult(false, "taskId is blank", 0, 0, 0, 28, null);
    }
}
