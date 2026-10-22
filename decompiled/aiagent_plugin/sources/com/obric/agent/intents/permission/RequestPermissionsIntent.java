package com.obric.agent.intents.permission;

import android.os.Parcelable;
import com.obric.agent.permission.ICallback;
import com.obric.agent.permission.IPermissionService;
import com.obric.agent.permission.bean.RequestPermissionOption;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.Options;
import com.obric.capabilitykit.common.intent.Permission;
import com.obric.capabilitykit.common.intent.SystemRequestPermissionsParams;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.c.b.a.h;
import d.h.b.o;
import d.k;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: RequestPermissionsIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestPermissionsIntent extends BaseSystemRequestPermissionsIntent {

    /* JADX INFO: compiled from: RequestPermissionsIntent.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14862a = null;

        static {
            int[] r0 = new int[RequestPermissionResult.a.values().length];
            r0[RequestPermissionResult.a.f15408a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RequestPermissionResult.a.f15409b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f14862a = r0;
        }
    }

    /* JADX INFO: compiled from: RequestPermissionsIntent.kt */
    @f(b = "RequestPermissionsIntent.kt", c = {108}, d = "doAction", e = "com.obric.agent.intents.permission.RequestPermissionsIntent")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f14867e;
        final /* synthetic */ RequestPermissionsIntent f;
        int g;

        b(RequestPermissionsIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14867e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: RequestPermissionsIntent.kt */
    public static final class c implements ICallback<RequestPermissionResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<RequestPermissionResult> f14868a;

        c(n<? super RequestPermissionResult> r3) {
            this.f14868a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.agent.permission.ICallback
        public /* synthetic */ void onSuccess(RequestPermissionResult r3) {
            a((RequestPermissionResult) ZeusTransformUtils.preCheckCast(r3, RequestPermissionResult.class, "com.obric.aiagent.plugin"));
        }

        public void a(RequestPermissionResult r3) {
            o.e(r3, "result");
            ICallback.a.a(this, r3);
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14868a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r0 = d.n.f38560a;
            r2.resumeWith(d.n.f(r3));
        }

        @Override // com.obric.agent.permission.ICallback
        public void onFailure(int r2) {
            ICallback.a.a(this, r2);
            d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14868a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r3 = d.n.f38560a;
            r1.resumeWith(d.n.f(null));
        }
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public RequestPermissionsIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((SystemRequestPermissionsParams) ZeusTransformUtils.preCheckCast(r6, SystemRequestPermissionsParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseSystemRequestPermissionsIntent
    public Object doAction(SystemRequestPermissionsParams r24, DispatchContext r25, d.c.d<? super IntentResult<Empty>> r26) {
        RequestPermissionsIntent r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r26, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L7;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f14867e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        IPermissionService r1 = (IPermissionService) ZeusTransformUtils.preCheckCast(r4.f14866d, IPermissionService.class, "com.obric.aiagent.plugin");
        RequestPermissionReq r7 = (RequestPermissionReq) ZeusTransformUtils.preCheckCast(r4.f14865c, RequestPermissionReq.class, "com.obric.aiagent.plugin");
        DispatchContext r8 = (DispatchContext) ZeusTransformUtils.preCheckCast(r4.f14864b, DispatchContext.class, "com.obric.aiagent.plugin");
        r0 = (RequestPermissionsIntent) ZeusTransformUtils.preCheckCast(r4.f14863a, RequestPermissionsIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L53:
        RequestPermissionResult r9 = (RequestPermissionResult) ZeusTransformUtils.preCheckCast(r3, RequestPermissionResult.class, "com.obric.aiagent.plugin");
        ISecureLogDepend.Companion.i(r0.getName(), "doAction called, requestPermissions result = " + r9);
        if (r9 == null) goto L56;
        int r10 = a.f14862a[r9.getState().ordinal()];
        if (r10 != 1) goto L60;
        IntentResult r11 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r11.setDetails("不支持的权限请求");
        return r11;
    L60:
        if (r10 != 2) goto L63;
        IntentResult r12 = new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
        r12.setDetails(r9.getTipsMessage());
        return r12;
    L63:
        throw new k();
    L56:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_IO, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        ISecureLogDepend.Companion.i(getName(), "doAction called, params = " + r24);
        String r13 = r24.getTitle();
        String r14 = r24.getContent();
        Options[] r15 = r24.getOptions();
        Permission[] r16 = r24.getPermissions();
        if (r16 == null) goto L17;
        ISecureLogDepend.Companion.i(getName(), "doAction called, do requestPermissions");
        String r17 = "";
        if (r13 != null) goto L21;
        r13 = "";
    L21:
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        ArrayList r18 = new ArrayList();
        if (r15 == null) goto L41;
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r110 = r15.length;
        int r111 = 0;
    L26:
        if (r111 >= r110) goto L40;
        Options r112 = r15[r111];
        String r113 = r112.getText();
        if (r113 != null) goto L30;
        String r20 = r17;
    L31:
        String r114 = r112.getAction();
        Options[] r115 = r15;
        if (r114 != null) goto L34;
        String r21 = r17;
    L35:
        String r116 = r112.getUiType();
        String r117 = r17;
        if (r116 == null) goto L39;
        r17 = r116;
    L39:
        r19.add(new RequestPermissionOption(r20, r21, r17));
        r111 = r111 + 1;
        r17 = r117;
        r15 = r115;
        goto L26
    L34:
        r21 = r114;
        goto L35
    L30:
        r20 = r113;
        goto L31
    L40:
        r18.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
    L41:
        x r22 = x.f38692a;
        List r23 = (List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.aiagent.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r16.length), Collection.class, "com.obric.aiagent.plugin");
        int r118 = r16.length;
        int r119 = 0;
    L42:
        if (r119 >= r118) goto L44;
        Permission r120 = r16[r119];
        r27.add(new com.obric.agent.permission.bean.Permission(r120.getType(), null, r120.getAppletId(), null, 10, null));
        r119 = r119 + 1;
        r16 = r16;
        goto L42
    L44:
        RequestPermissionReq r28 = new RequestPermissionReq(r13, r14, r23, (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin"));
        IPermissionService r29 = IPermissionService.Companion.a();
        if (r29 == null) goto L47;
        r4.f14863a = r0;
        r4.f14864b = r25;
        r4.f14865c = r28;
        r4.f14866d = r29;
        r4.g = 1;
        kotlinx.coroutines.o r30 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r30.e();
        r29.requestPermissions(r28, r25, (ICallback) ZeusTransformUtils.preCheckCast(new c((n) ZeusTransformUtils.preCheckCast(r30, n.class, "com.obric.aiagent.plugin")), ICallback.class, "com.obric.aiagent.plugin"));
        r3 = r30.h();
        if (r3 != d.c.a.b.a()) goto L51;
        h.c((d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    L51:
        if (r3 != r5) goto L53;
        return r5;
    L47:
        return new IntentResult(0, null, null, "IPermissionService 服务异常", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L17:
        return new IntentResult(0, null, null, "permission 参数为空", false, false, 0, null, null, null, DownloadErrorCode.ERROR_DB_LOCK, null);
    L7:
        r4 = new b(r0, r2);
        goto L8
    }
}
