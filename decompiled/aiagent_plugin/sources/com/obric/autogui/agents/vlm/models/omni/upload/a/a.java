package com.obric.autogui.agents.vlm.models.omni.upload.a;

import android.app.assist.AssistStructure;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.autogui.agents.vlm.models.omni.upload.v;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.obric.autogui.common.api.platform.input.InjectEventContext;
import com.obric.autogui.common.api.platform.system.viewhierarchy.VHNode;
import com.obric.autogui.common.api.platform.system.viewhierarchy.ViewHierarchyDump;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.n;
import d.o;
import d.x;
import java.io.Closeable;

/* JADX INFO: compiled from: OmniUploadReactViewTreeCallback.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.obric.framework.inputmethod.api.a {
    private static final String TAG = "OmniReactViewTreeCb";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0712a f28534a = null;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.omni.upload.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OmniUploadReactViewTreeCallback.kt */
    public static final class C0712a {
        public /* synthetic */ C0712a(d.h.b.h r1) {
            this();
        }

        private C0712a() {
        }
    }

    static {
        f28534a = new C0712a(null);
    }

    public a() {
    }

    @Override // com.obric.framework.inputmethod.api.a
    public void a(int r3, Bundle r4) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).b(r3, r4);     // Catch: Throwable -> L4
        Object r2 = n.f(x.f38692a);     // Catch: Throwable -> L4
    L6:
        Throwable r5 = n.c(r2);
        if (r5 == null) goto L12;
        OmniDataFeedbackLog.INSTANCE.e(TAG, "onResultData handling failed, requestId=" + r3, r5);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        n.a r6 = n.f38560a;
        r2 = n.f(o.a(th));
        goto L6
    }

    private final void b(int r25, Bundle r26) {
        if (com.obric.autogui.common.a.h.f28984a.b() == true) goto L6;
        return;
    L6:
        if (r26 == null) goto L8;
        int r5 = r26.getInt("event_id", Integer.MIN_VALUE);
        if (r5 != Integer.MIN_VALUE) goto L18;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L85;
        Loog.INSTANCE.w(TAG, "onResultData skip, requestId=" + r25 + ", missing event_id, keys=" + r26.keySet());
        return;
    L85:
        return;
    L18:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L20;
        Loog.INSTANCE.i(TAG, "onResultData received, requestId=" + r25 + ", eventId=" + r5 + ", keys=" + r26.keySet());
    L20:
        InjectEventContext.Context r3 = InjectEventContext.INSTANCE.resolve(r5);
        if (r3 != null) goto L27;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L86;
        Loog.INSTANCE.w(TAG, "onResultData drop, requestId=" + r25 + ", resolve miss, eventId=" + r5);
        return;
    L86:
        return;
    L27:
        if (com.obric.autogui.common.a.h.f28984a.a(r3.getOmniActionType()) == false) goto L29;
        Closeable r8 = v.f28855a.e(r3.getSessionId());
        if (r8 == null) goto L35;
        boolean r9 = true;
        VHNode r2 = a(r26);     // Catch: Throwable -> L76
        if (r2 == null) goto L42;
    L44:
        com.obric.autogui.session.a r10 = com.obric.autogui.session.c.f30777a.b();     // Catch: Throwable -> L76
        if (r10 != null) goto L47;
    L53:
        Integer r7 = r3.getStepIndex();     // Catch: Throwable -> L76
        if (r7 == null) goto L56;
        int r0 = r7.intValue();     // Catch: Throwable -> L76
    L65:
        String r11 = r3.getToolId();     // Catch: Throwable -> L76
        e.f28548a.a(r3.getSessionId(), r3.isOmniSession(), r3.getStepJournalDirPath(), r2, r3.getStepId(), r0, r11, r3.getOmniActionType(), Integer.valueOf(r5), r3.getMultiStepIndex(), r3.getMultiStepCount(), r8);     // Catch: Throwable -> L76
    L74:
        th = th;
    L78:
        if (r9 == true) goto L80;
        r8.close();
    L80:
        throw th;
    L67:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L89;
        Loog r12 = Loog.INSTANCE;     // Catch: Throwable -> L74
        StringBuilder r1 = new StringBuilder().append("onResultData enqueue react_view_tree save, requestId=").append(r25).append(", eventId=").append(r5).append(", sessionId=").append(r3.getSessionId()).append(", stepId=").append(r3.getStepId()).append(", stepNum=").append(r0).append(", toolId=").append(r11).append(", actionType=").append(r3.getOmniActionType()).append(", multiStepIndex=").append(r3.getMultiStepIndex()).append(", multiStepCount=").append(r3.getMultiStepCount()).append(", hasNode=");     // Catch: Throwable -> L74
        if (r2 == null) goto L71;
        boolean r4 = true;
    L72:
        r12.i(TAG, r1.append(r4).toString());     // Catch: Throwable -> L74
        return;
    L71:
        r4 = false;
        goto L72
    L89:
        return;
    L56:
        Integer r6 = a(r3.getStepId());     // Catch: Throwable -> L76
        if (r6 == null) goto L59;
    L58:
        r0 = r6.intValue();     // Catch: Throwable -> L76
        goto L65
    L59:
        if (r10 == null) goto L61;
        r6 = Integer.valueOf(r10.s());     // Catch: Throwable -> L76
    L62:
        if (r6 != null) goto L58;
        r0 = 0;
        goto L65
    L61:
        r6 = null;
        goto L62
    L47:
        if (d.h.b.o.a(r10.b(), r3.getSessionId()) == true) goto L53;
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L51;
        Loog.INSTANCE.w(TAG, "onResultData drop, requestId=" + r25 + ", ongoing session mismatch, resolvedSessionId=" + r3.getSessionId() + ", ongoingSessionId=" + r10.b() + ", eventId=" + r5);     // Catch: Throwable -> L76
    L51:
        r8.close();
        return;
    L42:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L44;
        Loog.INSTANCE.w(TAG, "onResultData parsed node is null, requestId=" + r25 + ", eventId=" + r5 + ", " + r3.logFields());     // Catch: Throwable -> L76
    L76:
        th = th;
        r9 = false;
        goto L78
    L35:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L88;
        Loog.INSTANCE.i(TAG, "onResultData drop after producer barrier closed, requestId=" + r25 + ", eventId=" + r5);
        return;
    L88:
        return;
    L29:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L87;
        Loog.INSTANCE.w(TAG, "onResultData drop, requestId=" + r25 + ", unsupported actionType=" + r3.getOmniActionType() + ", eventId=" + r5);
        return;
    L87:
        return;
    L8:
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L84;
        Loog.INSTANCE.w(TAG, "onResultData skip, requestId=" + r25 + ", resultData is null");
        return;
    }

    private final VHNode a(Bundle r5) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L13
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT < 33) goto L7;
        AssistStructure r6 = (AssistStructure) ZeusTransformUtils.preCheckCast(r5.getParcelable("assist_structure", AssistStructure.class), AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L11:
        Object r7 = n.f(r6);     // Catch: Throwable -> L13
    L16:
        if (n.b(r7) == false) goto L18;
        r7 = null;
    L18:
        AssistStructure r8 = (AssistStructure) ZeusTransformUtils.preCheckCast(r7, AssistStructure.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L21;
        return null;
    L21:
        ViewHierarchyDump r9 = (ViewHierarchyDump) ZeusTransformUtils.preCheckCast(p.l(com.obric.autogui.platforms.tools.internal.viewhierarchy.b.f30401a.a(r8, false)), ViewHierarchyDump.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L24;
        return null;
    L24:
        return r9.getRootNode();
    L7:
        Parcelable r10 = r5.getParcelable("assist_structure");     // Catch: Throwable -> L13
        if (ZeusTransformUtils.instanceOf(r10, AssistStructure.class) == false) goto L10;
        r6 = (AssistStructure) ZeusTransformUtils.preCheckCast(r10, AssistStructure.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        goto L11
    L10:
        r6 = null;
    L13:
        th = move-exception;
        n.a r11 = n.f38560a;
        r7 = n.f(o.a(th));
        goto L16
    }

    private final Integer a(String r2) {
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return null;
    L7:
        return d.o.o.d(d.o.o.a(r2, '_', ""));
    }
}
