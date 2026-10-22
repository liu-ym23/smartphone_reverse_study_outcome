package com.obric.autogui.operator.a.b.a.b.b;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: UserInterruptAvoidingPreCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {
    private static final String TAG = "PreChk/UserInter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29486c;

    /* JADX INFO: compiled from: UserInterruptAvoidingPreCheck.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29484a = new a(null);
    }

    public d(String r1, String r2) {
        this.f29485b = r1;
        this.f29486c = r2;
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b.b
    public com.obric.autogui.operator.a.b.a.c a(Context r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r14, "context");
        String r7 = this.f29485b;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
    L39:
        return null;
    L12:
        if (o.a(r7, AOSystemTools.INSTANCE.getHostAppPackage()) == false) goto L25;
        IAutoActionPresentationApi r2 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L16;
        IAutoActionPresentationApi.PlayerVisibility r3 = r2.getPlayerVisibility(r14);
    L18:
        if (r3 != IAutoActionPresentationApi.PlayerVisibility.Visible) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L25;
        Loog.INSTANCE.d(TAG, " - [OpenApp] candidate package `" + r7 + "` showing + PlayerVisible.");
        return null;
    L20:
        r4 = false;
        goto L21
    L16:
        r3 = null;
    L25:
        if (AutoActionVirtualDisplay.INSTANCE.isAppVisibleInMd(r7) == false) goto L39;
        Loog.INSTANCE.d(TAG, " - [OpenApp] candidate package `" + r7 + "` showing = true (UserInterrupt)");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f29486c, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L29;
    L32:
        boolean r6 = true;
    L34:
        if (r6 == false) goto L36;
        String r15 = r14.getString(ZeusTransformUtils.mapRes(R.string.agent_task_user_interrupt_open_app_general, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_interrupt_open_app_general"));
    L37:
        String r8 = r15;
        o.a(r8);
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.f29448d, r8, "appName=" + this.f29486c + ",p=" + r7, com.obric.autogui.common.a.b.f28964b, r7, false, null, 96, null);
    L36:
        r15 = r14.getString(ZeusTransformUtils.mapRes(R.string.agent_task_user_interrupt_open_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_user_interrupt_open_app"), new Object[]{this.f29486c});
        goto L37
    L29:
        if (d.o.o.d(r5) == true) goto L32;
        r6 = false;
        goto L34
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L10
    }
}
