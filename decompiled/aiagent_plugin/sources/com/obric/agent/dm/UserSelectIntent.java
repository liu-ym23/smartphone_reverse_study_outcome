package com.obric.agent.dm;

import android.os.Parcelable;
import com.obric.agent.IAgentService;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemUserSelectParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.o;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: UserSelectIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserSelectIntent extends BaseSystemUserSelectIntent {

    /* JADX INFO: compiled from: UserSelectIntent.kt */
    @d.c.b.a.f(b = "UserSelectIntent.kt", c = {21}, d = "doAction", e = "com.obric.agent.dm.UserSelectIntent")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ UserSelectIntent f14423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14424d;

        a(UserSelectIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14423c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14422b = r3;
            this.f14424d |= Integer.MIN_VALUE;
            return this.f14423c.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public UserSelectIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<AppEntity[]>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<AppEntity[]>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r6, SystemUserSelectParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUserSelectIntent
    public Object doAction(SystemUserSelectParams r17, DispatchContext r18, d.c.d<? super IntentResult<AppEntity[]>> r19) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L7;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.aiagent.plugin");
        if ((r2.f14424d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f14424d -= Integer.MIN_VALUE;
    L8:
        a r8 = r2;
        Object r1 = r8.f14422b;
        Object r3 = d.c.a.b.a();
        int r4 = r8.f14424d;
        IntentResult r5 = null;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        SystemUserSelectParams r6 = (SystemUserSelectParams) ZeusTransformUtils.preCheckCast(r8.f14421a, SystemUserSelectParams.class, "com.obric.aiagent.plugin");
        o.a(r1);
    L24:
        r5 = (IntentResult) ZeusTransformUtils.preCheckCast(r1, IntentResult.class, "com.obric.aiagent.plugin");
    L26:
        if (r5 == null) goto L29;
    L30:
        ConcurrentHashMap<String, String> r7 = r5.getExt();
        if (r7 != null) goto L33;
        r7 = new ConcurrentHashMap();
    L33:
        String r9 = r6.getSourceIntent();
        if (r9 != null) goto L36;
        r9 = "";
    L36:
        r7.put("USER_SELECT_SOURCE_INTENT", r9);
        r5.setExt(r7);
        return r5;
    L29:
        r5 = new IntentResult(1, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r1);
        String[] r10 = r17.getCandidate();
        if (r10 == null) goto L28;
        String r11 = r17.getType();
        if (r11 == null) goto L25;
        IAgentService r12 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L25;
        List<String> r13 = i.g(r10);
        String r14 = getName();
        r8.f14421a = r17;
        r8.f14424d = 1;
        r1 = r12.onUserSelect(r13, r11, r14, r18, r8);
        if (r1 != r3) goto L23;
        return r3;
    L23:
        r6 = r17;
    L25:
        r6 = r17;
        goto L26
    L28:
        r6 = r17;
    L7:
        r2 = new a(this, r0);
        goto L8
    }
}
