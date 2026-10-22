package com.obric.agent.intents.skill;

import android.os.Parcelable;
import com.obric.agent.intents.skill.a.f;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemSkillIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSkillParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.h;
import d.o.o;

/* JADX INFO: compiled from: SystemSkillIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SystemSkillIntent extends BaseSystemSkillIntent {
    public static final a Companion = null;
    private static final String TAG = "SystemSkillIntent";

    /* JADX INFO: compiled from: SystemSkillIntent.kt */
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

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSkillIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public SystemSkillIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSkillIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((SystemSkillParams) ZeusTransformUtils.preCheckCast(r6, SystemSkillParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemSkillIntent
    public Object doAction(SystemSkillParams r15, DispatchContext r16, d<? super IntentResult<Empty>> r17) {
        d<? super IntentResult<Empty>> r0 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
        String r2 = r15.getActionType();
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        String r4 = r15.getUniqueId();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        String r5 = r15.getActionArgs();
        if (r5 == null) goto L13;
        r3 = r5;
    L13:
        if (IAppContext.Companion.isDebug() == false) goto L15;
        ILogDepend.Companion.i(TAG, "doAction actionType=" + r2 + " uniqueId=" + r4 + " questionId=" + r16.getQuestionId());
    L17:
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L26;
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L26;
        if (o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L26;
        return com.obric.agent.intents.skill.d.a.f15056a.b(new f(r4, r2, r3), r16, r0);
    L26:
        return new IntentResult(-2004, null, null, "required params missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L15:
        ILogDepend.Companion.i(TAG, "doAction received");
        goto L17
    }
}
