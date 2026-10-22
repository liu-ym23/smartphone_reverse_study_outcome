package com.obric.agent.dm;

import android.os.Parcelable;
import com.obric.agent.IAgentService;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemUserConfirmParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o;

/* JADX INFO: compiled from: UserConfirmIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserConfirmIntent extends BaseSystemUserConfirmIntent {

    /* JADX INFO: compiled from: UserConfirmIntent.kt */
    @d.c.b.a.f(b = "UserConfirmIntent.kt", c = {20}, d = "doAction", e = "com.obric.agent.dm.UserConfirmIntent")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f14418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UserConfirmIntent f14419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14420c;

        a(UserConfirmIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14419b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14418a = r3;
            this.f14420c |= Integer.MIN_VALUE;
            return this.f14419b.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public UserConfirmIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<AppEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<AppEntity[]>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemUserConfirmParams) ZeusTransformUtils.preCheckCast(r6, SystemUserConfirmParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserConfirmIntent
    public Object doAction(SystemUserConfirmParams r20, DispatchContext r21, d.c.d<? super IntentResult<AppEntity[]>> r22) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r22, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f14420c & Integer.MIN_VALUE) == 0) goto L7;
        r2.f14420c -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.f14418a;
        Object r3 = d.c.a.b.a();
        int r4 = r2.f14420c;
        IntentResult r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        o.a(r1);
    L23:
        r5 = (IntentResult) ZeusTransformUtils.preCheckCast(r1, IntentResult.class, "com.obric.aiagent.plugin");
    L24:
        if (r5 == null) goto L26;
        return r5;
    L26:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        String r6 = r20.getConfirmIntent();
        if (r6 == null) goto L26;
        String[] r7 = r20.getCandidates();
        if (r7 == null) goto L24;
        IAgentService r8 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        r2.f14420c = 1;
        r1 = r8.onUserConfirm(r7, r6, r21, r2);
        if (r1 != r3) goto L23;
        return r3;
    L7:
        r2 = new a(this, r0);
        goto L8
    }
}
