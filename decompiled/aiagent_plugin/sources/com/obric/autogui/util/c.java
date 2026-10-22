package com.obric.autogui.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClipboardSystemHintRecorder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "ClipboardSystemHintRecorder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ClipboardManager.OnPrimaryClipChangedListener f31501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f31502c;

    static {
        f31500a = new c();
    }

    private static final String b() {
        return "task stopped, clear oauto clipboard";
    }

    /* JADX INFO: renamed from: lambda$119-N-cIvEA_WwfKnRMJ9mPIVYk, reason: not valid java name */
    public static /* synthetic */ String m917lambda$119NcIvEA_WwfKnRMJ9mPIVYk(Boolean r0) {
        return a(r0);
    }

    public static /* synthetic */ String lambda$NI1HqmJkU_NMhVndommObkQ5Vg0() {
        return b();
    }

    public static /* synthetic */ String lambda$iNDSFLxiHFeZrp2QrFgZr2W06OE() {
        return a();
    }

    public static /* synthetic */ void lambda$iwTNSDab9blz58nimyuCDciueys(Context r0) {
        c(r0);
    }

    /* JADX INFO: renamed from: lambda$vvUeC-G6Xf-9qlz2teaSmHo4FQw, reason: not valid java name */
    public static /* synthetic */ String m918lambda$vvUeCG6Xf9qlz2teaSmHo4FQw(String r0) {
        return a(r0);
    }

    private c() {
    }

    public final void a(Context r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r0 == null) goto L5;
        final Boolean r1 = Boolean.valueOf(r0.getOAutoUseClipboardEnabled());
    L6:
        Loog.INSTANCE.dp(TAG, new $$Lambda$c$119NcIvEA_WwfKnRMJ9mPIVYk(r1));
        if (o.a(r1, true) == true) goto L11;
        b(r6);
        return;
    L11:
        if (f31501b == null) goto L13;
        return;
    L13:
        AOPlatformTools.INSTANCE.special().clearOAutoPrimaryClip(r6);
        ClipboardManager.OnPrimaryClipChangedListener r4 = new $$Lambda$c$iwTNSDab9blz58nimyuCDciueys(r6);
        AOPlatformTools.INSTANCE.special().addOAutoPrimaryClipChangedListener(r6, r4);
        f31501b = r4;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final String a(Boolean r2) {
        return "task started, clipboard enable: " + r2;
    }

    private static final void c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        ClipData r0 = AOPlatformTools.INSTANCE.special().getOAutoPrimaryClip(r5);
        if (r0 == null) goto L11;
        ClipData.Item r1 = r0.getItemAt(0);
        if (r1 == null) goto L11;
        CharSequence r2 = r1.coerceToText(r5);
        if (r2 == null) goto L11;
        String r3 = r2.toString();
        if (r3 == null) goto L11;
        String r6 = r3.substring(0, Math.min(r3.length(), 4096));
        o.c(r6, "substring(...)");
    L12:
        f31502c = r6;
        AOPlatformTools.INSTANCE.special().setOAutoClipdataToUser(r5);
        Loog.INSTANCE.dp(TAG, $$Lambda$c$iNDSFLxiHFeZrp2QrFgZr2W06OE.INSTANCE);
        return;
    L11:
        r6 = null;
        goto L12
    }

    private static final String a() {
        return "oauto sync clipboard to user: " + f31502c;
    }

    public final void b(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        ClipboardManager.OnPrimaryClipChangedListener r3 = f31501b;
        if (r3 == null) goto L5;
        AOPlatformTools.INSTANCE.special().removeOAutoPrimaryClipChangedListener(r1, r3);
    L5:
        f31501b = null;
        f31502c = null;
        AOPlatformTools.INSTANCE.special().clearOAutoPrimaryClip(r1);
        Loog.INSTANCE.dp(TAG, $$Lambda$c$NI1HqmJkU_NMhVndommObkQ5Vg0.INSTANCE);
    }

    public final String a(com.obric.autogui.session.a r21) {
        o.e(r21, SensitiveType.SESSION);
        final String r0 = f31502c;
        f31502c = null;
        if (r0 == null) goto L5;
        String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r21.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_thinking_streaming_access_clipboard, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_thinking_streaming_access_clipboard"));
        o.c(r7, "getString(...)");
        IAutoActionAgentEventListener.AgentStepInfo r2 = new IAutoActionAgentEventListener.AgentStepInfo("", "", "", r7, true, false, "", com.obric.autogui.agents.vlm.models.a.d.b.f.getIdentifier(), false, AOSystemTools.INSTANCE.nowTimeMillis(), AOSystemTools.INSTANCE.nowTimeMillis(), null);
        com.obric.autogui.b.a.f28928a.onAgentStep(r21.d(), r2);
        Loog.INSTANCE.dp(TAG, new $$Lambda$c$vvUeCG6Xf9qlz2teaSmHo4FQw(r0));
        IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r5 = new JSONObject();
        r5.put("session_id", r21.b());
        r5.put("step_id", r21.v());
        r5.put("step_index", r21.s());
        x r1 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "upload_clipboard_data", r5, false, false, null, 28, null);
    L5:
        return r0;
    }

    private static final String a(String r2) {
        return "upload latest unread clip content: " + r2;
    }
}
