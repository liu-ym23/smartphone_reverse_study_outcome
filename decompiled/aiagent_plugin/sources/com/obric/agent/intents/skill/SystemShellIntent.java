package com.obric.agent.intents.skill;

import android.os.Parcelable;
import com.obric.agent.intents.skill.a.f;
import com.obric.agent.intents.skill.c.c;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemShellIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemShellParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.b;
import d.c.d;
import d.h.b.h;
import d.o.o;

/* JADX INFO: compiled from: SystemShellIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemShellIntent extends BaseSystemShellIntent {
    public static final a Companion = null;
    private static final String TAG = "SystemShellIntent";

    /* JADX INFO: compiled from: SystemShellIntent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemShellIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public SystemShellIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemShellIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemShellParams) ZeusTransformUtils.preCheckCast(r6, SystemShellParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemShellIntent
    public Object doAction(SystemShellParams r27, DispatchContext r28, d<? super IntentResult<Empty>> r29) {
        d<? super IntentResult<Empty>> r0 = (d) ZeusTransformUtils.wrapperContextForParams(r29, d.class, "com.obric.aiagent.plugin");
        String r2 = r27.getActionType();
        String r3 = "";
        if (r2 != null) goto L5;
        String r6 = "";
    L6:
        String r4 = r27.getUniqueId();
        if (r4 != null) goto L9;
        String r5 = "";
    L10:
        String r7 = r27.getActionArgs();
        if (r7 == null) goto L15;
        r3 = r7;
    L15:
        if (IAppContext.Companion.isDebug() == false) goto L17;
        ILogDepend.Companion.i(TAG, "doAction actionType=" + r6 + " uniqueId=" + r5 + " questionId=" + r28.getQuestionId());
    L19:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L21;
    L27:
        com.obric.agent.intents.skill.e.a.a(com.obric.agent.intents.skill.e.a.f15181a, r5, r6, null, b.a(-2004), null, c.f14909a.a(r6, r3), 20, null);
        return new IntentResult(-2004, null, null, "required params missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L21:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L27;
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L27;
        return com.obric.agent.intents.skill.c.b.f14901a.b(new f(r5, r6, r3), r28, r0);
    L17:
        ILogDepend.Companion.i(TAG, "doAction received");
        goto L19
    L9:
        r5 = r4;
        goto L10
    L5:
        r6 = r2;
        goto L6
    }
}
