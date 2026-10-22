package com.obric.agent.intents.permission;

import android.os.Parcelable;
import com.obric.agent.permission.ICallback;
import com.obric.agent.permission.IPermissionService;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.agent.permission.bean.UpdatePermissionResult;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Permission;
import com.obric.capabilitykit.common.intent.SystemUpdatePermissionsParams;
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

/* JADX INFO: compiled from: UpdatePermissionsIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UpdatePermissionsIntent extends BaseSystemUpdatePermissionsIntent {

    /* JADX INFO: compiled from: UpdatePermissionsIntent.kt */
    @f(b = "UpdatePermissionsIntent.kt", c = {74}, d = "doAction", e = "com.obric.agent.intents.permission.UpdatePermissionsIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14872d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ UpdatePermissionsIntent f14873e;
        int f;

        a(UpdatePermissionsIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14873e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14872d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f14873e.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: UpdatePermissionsIntent.kt */
    public static final class b implements ICallback<UpdatePermissionResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<UpdatePermissionResult> f14874a;

        b(n<? super UpdatePermissionResult> r3) {
            this.f14874a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.agent.permission.ICallback
        public /* synthetic */ void onSuccess(UpdatePermissionResult r3) {
            a((UpdatePermissionResult) ZeusTransformUtils.preCheckCast(r3, UpdatePermissionResult.class, "com.obric.aiagent.plugin"));
        }

        public void a(UpdatePermissionResult r3) {
            o.e(r3, "result");
            ICallback.a.a(this, r3);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14874a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
        }

        @Override // com.obric.agent.permission.ICallback
        public void onFailure(int r2) {
            ICallback.a.a(this, r2);
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14874a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(null));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public UpdatePermissionsIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemUpdatePermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemUpdatePermissionsParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemUpdatePermissionsIntent
    public Object doAction(SystemUpdatePermissionsParams r31, DispatchContext r32, d.c.d<? super IntentResult<Empty>> r33) {
        UpdatePermissionsIntent r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f & Integer.MIN_VALUE) == 0) goto L7;
        r3.f -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14872d;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        IPermissionService r6 = (IPermissionService) ZeusTransformUtils.preCheckCast(r3.f14871c, IPermissionService.class, "com.obric.aiagent.plugin");
        UpdatePermissionReq r7 = (UpdatePermissionReq) ZeusTransformUtils.preCheckCast(r3.f14870b, UpdatePermissionReq.class, "com.obric.aiagent.plugin");
        r0 = (UpdatePermissionsIntent) ZeusTransformUtils.preCheckCast(r3.f14869a, UpdatePermissionsIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
    L30:
        UpdatePermissionResult r8 = (UpdatePermissionResult) ZeusTransformUtils.preCheckCast(r2, UpdatePermissionResult.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, updatePermissions result = " + r8);
        if (r8 != null) goto L35;
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L35:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r2);
        ISecureLogDepend.Companion.i(getName(), "doAction called, params = " + r31);
        Permission[] r9 = r31.getPermissions();
        if (r9 == null) goto L17;
        ISecureLogDepend.Companion.i(getName(), "doAction called, do updatePermissions");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r9.length), Collection.class, "com.obric.aiagent.plugin");
        int r11 = 0;
        int r12 = r9.length;
    L19:
        if (r11 >= r12) goto L21;
        Permission r13 = r9[r11];
        r10.add(new com.obric.agent.permission.bean.Permission(r13.getType(), null, r13.getAppletId(), r13.getConfirmMode(), 2, null));
        r11 = r11 + 1;
        goto L19
    L21:
        UpdatePermissionReq r14 = new UpdatePermissionReq((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin"));
        IPermissionService r15 = IPermissionService.Companion.a();
        if (r15 == null) goto L24;
        r3.f14869a = r0;
        r3.f14870b = r14;
        r3.f14871c = r15;
        r3.f = 1;
        kotlinx.coroutines.o r16 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r16.e();
        r15.updatePermissions(r14, (ICallback) ZeusTransformUtils.preCheckCast(new b((n) ZeusTransformUtils.preCheckCast(r16, n.class, "com.obric.aiagent.plugin")), ICallback.class, "com.obric.aiagent.plugin"));
        r2 = r16.h();
        if (r2 != d.c.a.b.a()) goto L28;
        h.c((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    L28:
        if (r2 != r4) goto L30;
        return r4;
    L24:
        return new IntentResult(0, null, null, "IPermissionService 服务异常", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L17:
        return new IntentResult(0, null, null, "permissions 参数为空", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L7:
        r3 = new a(r0, r1);
        goto L8
    }
}
