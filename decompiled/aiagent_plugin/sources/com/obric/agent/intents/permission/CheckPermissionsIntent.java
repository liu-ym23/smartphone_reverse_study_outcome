package com.obric.agent.intents.permission;

import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.agent.permission.ICallback;
import com.obric.agent.permission.IPermissionService;
import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.CheckPermissionResult;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Permission;
import com.obric.capabilitykit.common.intent.SystemCheckPermissionsParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: CheckPermissionsIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckPermissionsIntent extends BaseSystemCheckPermissionsIntent {

    /* JADX INFO: compiled from: CheckPermissionsIntent.kt */
    @f(b = "CheckPermissionsIntent.kt", c = {78}, d = "doAction", e = "com.obric.agent.intents.permission.CheckPermissionsIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14848a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14849b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14850c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14851d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ CheckPermissionsIntent f14852e;
        int f;

        a(CheckPermissionsIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14852e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14851d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f14852e.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CheckPermissionsIntent.kt */
    public static final class b implements ICallback<CheckPermissionResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<CheckPermissionResult> f14853a;

        b(n<? super CheckPermissionResult> r3) {
            this.f14853a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.agent.permission.ICallback
        public /* synthetic */ void onSuccess(CheckPermissionResult r3) {
            a((CheckPermissionResult) ZeusTransformUtils.preCheckCast(r3, CheckPermissionResult.class, "com.obric.aiagent.plugin"));
        }

        public void a(CheckPermissionResult r3) {
            o.e(r3, "result");
            ICallback.a.a(this, r3);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14853a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
        }

        @Override // com.obric.agent.permission.ICallback
        public void onFailure(int r2) {
            ICallback.a.a(this, r2);
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14853a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(null));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public CheckPermissionsIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemCheckPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemCheckPermissionsParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemCheckPermissionsIntent
    public Object doAction(SystemCheckPermissionsParams r21, DispatchContext r22, d.c.d<? super IntentResult<Empty>> r23) {
        CheckPermissionsIntent r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14851d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        IPermissionService r6 = (IPermissionService) ZeusTransformUtils.preCheckCast(r3.f14850c, IPermissionService.class, "com.obric.aiagent.plugin");
        CheckPermissionReq r7 = (CheckPermissionReq) ZeusTransformUtils.preCheckCast(r3.f14849b, CheckPermissionReq.class, "com.obric.aiagent.plugin");
        r0 = (CheckPermissionsIntent) ZeusTransformUtils.preCheckCast(r3.f14848a, CheckPermissionsIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L32:
        CheckPermissionResult r8 = (CheckPermissionResult) ZeusTransformUtils.preCheckCast(r2, CheckPermissionResult.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, checkPermissions result = " + r8);
        if (r8 == null) goto L35;
        String r9 = new Gson().newBuilder().setPrettyPrinting().create().toJson(r8);
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, return details = " + r9);
        IntentResult r10 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r10.setDetails(r9);
        return r10;
    L35:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        ISecureLogDepend.Companion.i(getName(), "doAction called, params = " + r21);
        String r11 = r21.getAppletId();
        Permission[] r12 = r21.getPermissions();
        if (r12 == null) goto L17;
        if (r11 != null) goto L20;
        r11 = "";
    L20:
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r12.length), Collection.class, "com.obric.aiagent.plugin");
        int r14 = 0;
        int r15 = r12.length;
    L21:
        if (r14 >= r15) goto L23;
        r13.add(new com.obric.agent.permission.bean.Permission(r12[r14].getType(), null, null, null, 14, null));
        r14 = r14 + 1;
        goto L21
    L23:
        CheckPermissionReq r16 = new CheckPermissionReq(r11, (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin"));
        IPermissionService r17 = IPermissionService.Companion.a();
        if (r17 == null) goto L26;
        r3.f14848a = r0;
        r3.f14849b = r16;
        r3.f14850c = r17;
        r3.f = 1;
        kotlinx.coroutines.o r18 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r18.e();
        r17.checkPermissions(r16, (ICallback) ZeusTransformUtils.preCheckCast(new b((n) ZeusTransformUtils.preCheckCast(r18, n.class, "com.obric.aiagent.plugin")), ICallback.class, "com.obric.aiagent.plugin"));
        r2 = r18.h();
        if (r2 != d.c.a.b.a()) goto L30;
        h.c((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    L30:
        if (r2 != r4) goto L32;
        return r4;
    L26:
        return new IntentResult(0, null, null, "IPermissionService 服务异常", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L17:
        return new IntentResult(0, null, null, "permission 参数为空", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L7:
        r3 = new a(r0, r1);
        goto L8
    }
}
