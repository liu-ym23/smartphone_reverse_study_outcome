package com.obric.autogui.vdplayer.adapter.platform;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.obric.autoaction.userreport.a;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.vdplayer.api.feedback.IFeedbackApi;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: FeedbackApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FeedbackApiImpl implements IFeedbackApi {
    public static /* synthetic */ x lambda$FtoXwz6RGc1qGnfln5AvcOGtpEM() {
        return openFeedBack$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$wRBwcY-JicN2-sz2kPQemkGX9TY, reason: not valid java name */
    public static /* synthetic */ x m922lambda$wRBwcYJicN2sz2kPQemkGX9TY(a r0) {
        return openFeedBack$lambda$1(r0);
    }

    public FeedbackApiImpl() {
    }

    @Override // com.obric.autogui.vdplayer.api.feedback.IFeedbackApi
    public d.h.a.a<x> openFeedBack(Context r7, IFeedbackApi.a r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r8, DBDefinition.SEGMENT_INFO);
        IAutoActionAgentEventListener.SessionInfo r9 = r8.a();
        boolean r1 = true;
        if (r9 == null) goto L9;
        AutoOperateTask r10 = r9.getTask();
        if (r10 == null) goto L9;
        if (r10.isOmni() != true) goto L9;
    L10:
        if (r1 == false) goto L24;
        IAutoActionAgentEventListener.SessionInfo r11 = r8.a();
        if (r11 == null) goto L15;
        String r12 = r11.getSessionId();
        if (r12 == null) goto L15;
    L16:
        Intent r2 = new Intent().setComponent(new ComponentName("com.larus.nova", "com.obric.assistant.tipoff.ObricTipOffDialogActivity"));
        IAutoActionAgentEventListener.SessionInfo r13 = r8.a();
        if (r13 == null) goto L21;
        AutoOperateTask r14 = r13.getTask();
        if (r14 == null) goto L21;
        Long r15 = r14.doubaoMessageId();
    L22:
        ZeusTransformUtils.startActivity(r6, r2.putExtra("msg_id", String.valueOf(r15)).putExtra("omni_task_id", r12), "com.obric.aiagent.plugin");
        return $$Lambda$FeedbackApiImpl$FtoXwz6RGc1qGnfln5AvcOGtpEM.INSTANCE;
    L21:
        r15 = null;
    L15:
        r12 = r8.b();
        goto L16
    L24:
        final a r16 = new a(r6);
        r16.a(new a.C0604a(r8.b(), r8.c(), r8.d(), r8.e(), r8.f()));
        r16.a();
        return new $$Lambda$FeedbackApiImpl$wRBwcYJicN2sz2kPQemkGX9TY(r16);
    L9:
        r1 = false;
        goto L10
    }

    private static final x openFeedBack$lambda$0() {
        return x.f38692a;
    }

    private static final x openFeedBack$lambda$1(a r0) {
        r0.c();
        return x.f38692a;
    }
}
