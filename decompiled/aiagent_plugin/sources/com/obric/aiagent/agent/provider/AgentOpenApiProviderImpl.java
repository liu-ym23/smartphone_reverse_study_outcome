package com.obric.aiagent.agent.provider;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.obric.agent.e;
import com.obric.aiagent.assistant.idl.IFlowAppStateIDL;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.provider.PluginContentProvider;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.h;
import d.o;
import d.s;
import d.x;
import java.util.Iterator;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: AgentOpenApiProviderImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AgentOpenApiProviderImpl extends PluginContentProvider {
    public static final a Companion = null;
    private static final String TAG = "AgentOpenApiProviderImpl";

    /* JADX INFO: compiled from: AgentOpenApiProviderImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentOpenApiProviderImpl.kt */
    @f(b = "AgentOpenApiProviderImpl.kt", c = {118}, d = "invokeSuspend", e = "com.obric.aiagent.agent.provider.AgentOpenApiProviderImpl$handleTrySendOmniQueryMethod$2")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16103b;

        b(String r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f16103b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f16103b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16102a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            IFlowUiIDL r7 = aw.a(aa.b(IFlowUiIDL.class));
            if (r7 == null) goto L19;
            if (d.h.b.o.a(this.f16103b, "half") == false) goto L16;
            int r5 = com.obric.agent.h.f14566c.ordinal();
        L17:
            r7.openChatActivity(r5);
            goto L19
        L16:
            r5 = com.obric.agent.h.f14567d.ordinal();
        L19:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f16102a = 1;
            if (ax.a(100, r8) != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public int delete(Uri r1, String r2, String[] r3) {
        d.h.b.o.e(r1, "uri");
        return 0;
    }

    public String getType(Uri r1) {
        d.h.b.o.e(r1, "uri");
        return null;
    }

    public Uri insert(Uri r1, ContentValues r2) {
        d.h.b.o.e(r1, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        d.h.b.o.e(r1, "uri");
        return null;
    }

    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        d.h.b.o.e(r1, "uri");
        return 0;
    }

    public AgentOpenApiProviderImpl() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r9v9 */
    public Bundle call(String r10, String r11, Bundle r12) {
        d.h.b.o.e(r10, "method");
        ISecureLogDepend.Companion.i(TAG, "call called, package=" + com.obric.aiagent.executionengine.utils.b.f18566a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) + ", method=" + r10 + ", arg=" + r11 + ", extras=" + r12);
        String r0 = com.obric.aiagent.executionengine.utils.b.f18566a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ISecureLogDepend.Companion.i(TAG, "calling package: " + r0);
        if (r0 == null) goto L5;
        boolean r5 = true;
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().checkSignatures(r0, IAppContext.Companion.getPackageName()) != 0) goto L9;
        boolean r3 = true;
    L11:
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().checkSignatures(r0, "android") == 0) goto L14;
        r5 = false;
    L14:
        if (r3 == true) goto L18;
        if (r5 == true) goto L18;
        ILogDepend.Companion.i(TAG, "checkPermission: illegal package");
        return errorResult(1001, "illegal package");
    L18:
        if (r12 == null) goto L20;
    L26:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "provider call failed, method=" + r10, th);
        String r13 = th.getMessage();
        if (r13 != null) goto L35;
        r13 = "internal error";
    L35:
        return this.errorResult(1004, r13);
    L22:
        if (d.h.b.o.a(r10, "try_send_omni_query") == false) goto L24;
        AgentOpenApiProviderImpl this = handleTrySendOmniQueryMethod(r11, r12);     // Catch: Throwable -> L26
    L32:
        return this;
    L24:
        this = errorResult(1002, "unsupported method: " + r10);     // Catch: Throwable -> L26
        goto L32
    L20:
        return errorResult(1003, "extras is null");
    L9:
        r3 = false;
        goto L11
    L5:
        return errorResult(1000, "illegal package");
    }

    private final Bundle handleTrySendOmniQueryMethod(String r19, Bundle r20) {
        ISecureLogDepend.Companion.i(TAG, "handleTrySendOmniQueryMethod called, arg=" + r19 + ", extras=" + r20);
        String r5 = r20.getString(DownloadConstants.QUERY_KEY);
        if (r5 == null) goto L5;
        String r4 = r20.getString("o_omni_instruction_type");
        if (r4 == null) goto L9;
        String r7 = r20.getString("o_instruction_entry");
        if (r7 == null) goto L13;
        String r2 = r20.getString("expand_state");
        if (r2 != null) goto L17;
        r2 = "half";
    L17:
        String r1 = r20.getString("extra");
        if (r1 != null) goto L20;
        r1 = "{}";
    L20:
        JSONObject r8 = new JSONObject(r1);
        IFlowMessageIDL r3 = ak.a(aa.b(IFlowMessageIDL.class));
        boolean r10 = false;
        if (r3 == null) goto L32;
        Map r13 = ao.b(new d.m[]{s.a("o_task_type", IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK), s.a("o_omni_instruction_type", r4), s.a("o_instruction_entry", r7)});
        Iterator<String> r6 = r8.keys();
    L24:
        if (r6.hasNext() == false) goto L31;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r9);
        Object r11 = r8.opt(r9);
        if (r11 == null) goto L29;
        String r12 = r11.toString();
        if (r12 == null) goto L29;
    L30:
        r13.put(r9, r12);
    L29:
        r12 = "";
        goto L30
    L31:
        x r14 = x.f38692a;
        r3.sendMessageWithExtra(null, r5, "obric_content_provider_task", "obric_content_provider_task", r13);
    L32:
        IFlowAppStateIDL r15 = com.obric.aiagent.assistant.idl.s.a(aa.b(IFlowAppStateIDL.class));
        if (r15 == null) goto L38;
        if (r15.isAppBackground() != true) goto L38;
        r10 = true;
    L38:
        if (r10 == false) goto L41;
        i.a(e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r2, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    L41:
        return successResult$default(this, null, 1, null);
    L13:
        return errorResult(1003, "instruction_entry is null");
    L9:
        return errorResult(1003, "instruction_type is null");
    L5:
        return errorResult(1003, "query is null");
    }

    static /* synthetic */ Bundle successResult$default(AgentOpenApiProviderImpl r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "done";
    L6:
        return r0.successResult(r1);
    }

    private final Bundle successResult(String r3) {
        ISecureLogDepend.Companion.i(TAG, "successResult called, message=" + r3);
        Bundle r2 = new Bundle();
        r2.putInt(MonitorConstants.CODE, 0);
        r2.putString("message", r3);
        return r2;
    }

    private final Bundle errorResult(int r3, String r4) {
        ILogDepend.Companion.e(TAG, "errorResult called, code=" + r3 + ", message=" + r4);
        Bundle r2 = new Bundle();
        r2.putInt(MonitorConstants.CODE, r3);
        r2.putString("message", r4);
        return r2;
    }

    private final Bundle runCall(String r4, d.h.a.a<Bundle> r5) {
        return (Bundle) ZeusTransformUtils.preCheckCast(((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin")).invoke(), Bundle.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "provider call failed, method=" + r4, th);
        String r6 = th.getMessage();
        if (r6 != null) goto L10;
        r6 = "internal error";
    L10:
        return errorResult(1004, r6);
    }
}
