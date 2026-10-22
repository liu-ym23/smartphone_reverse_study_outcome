package com.obric.aiagent.executionengine.scheduler.impl.b;

import android.app.ActivityOptions;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.AppFunctionCallResult;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionInvoker;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x;
import com.obric.aiagent.executionengine.scheduler.impl.execution.security.IntentExecutePolicyItem;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.m;
import d.n;
import d.o;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: AppFunctionExecutor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements f {
    private static final String TAG = "AppFunctionExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18351a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f18352b = null;

    /* JADX INFO: compiled from: AppFunctionExecutor.kt */
    @d.c.b.a.f(b = "AppFunctionExecutor.kt", c = {83, 105}, d = "execute", e = "com.obric.aiagent.executionengine.scheduler.impl.capability.AppFunctionExecutor")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18357e;
        Object f;
        Object g;
        long h;
        long i;
        /* synthetic */ Object j;
        final /* synthetic */ c k;
        int l;

        a(c r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.k = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.j = r7;
            this.l |= Integer.MIN_VALUE;
            return this.k.a(null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private c() {
    }

    static {
        f18351a = new c();
        f18352b = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16400b;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f18352b;
    }

    @Override // com.obric.aiagent.executionengine.scheduler.impl.b.f
    public Object a(AppAction r34, com.obric.aiagent.executionengine.scheduler.impl.job.c r35, long r36, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r38) {
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r38, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        if ((r4.l & Integer.MIN_VALUE) == 0) goto L7;
        r4.l -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.j;
        Object r13 = d.c.a.b.a();
        int r5 = r4.l;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        long r6 = r4.i;
        long r7 = r4.h;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r4.f18356d, String.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r4.f18355c, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r10 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r4.f18354b, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        c r1 = (c) ZeusTransformUtils.preCheckCast(r4.f18353a, c.class, "com.obric.aiagent.plugin");
        o.a(r3);
    L63:
        AppFunctionCallResult r8 = (AppFunctionCallResult) ZeusTransformUtils.preCheckCast(r3, AppFunctionCallResult.class, "com.obric.aiagent.plugin");
        long r11 = SystemClock.elapsedRealtime() - r6;
        IntentResult<?> r12 = r1.a(r8);
        if (r8.isSuccess() == false) goto L69;
        PendingIntent r14 = r8.getPendingIntent();
        if (r14 == null) goto L69;
        f18351a.a(r14);
    L69:
        if (r12.getRet() != 201) goto L74;
        if (d.h.b.o.a(r0, "Privacy_Observe") == true) goto L74;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.a.a.f18146a.a(r10.d(), r9, r0);
    L74:
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a.a(r12, r7, d.c.b.a.b.a(r11));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r15 = r4.h;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r4.g, String.class, "com.obric.aiagent.plugin");
        IAppFunctionInvoker r17 = (IAppFunctionInvoker) ZeusTransformUtils.preCheckCast(r4.f, IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(r4.f18357e, String.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r4.f18356d, String.class, "com.obric.aiagent.plugin");
        r10 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r4.f18355c, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        AppAction r110 = (AppAction) ZeusTransformUtils.preCheckCast(r4.f18354b, AppAction.class, "com.obric.aiagent.plugin");
        r1 = (c) ZeusTransformUtils.preCheckCast(r4.f18353a, c.class, "com.obric.aiagent.plugin");
        o.a(r3);
        String r111 = r19;
        r9 = r18;
        IAppFunctionInvoker r20 = r17;
        Object r21 = r3;
        String r22 = r16;
        Object r23 = null;
    L52:
        m r24 = (m) ZeusTransformUtils.preCheckCast(r21, m.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L56;
        ILogDepend.Companion.w(TAG, "execute -- security-check prohibits AppFunction `" + r22 + '`');
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.a(com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a, new IntentResult(((Number) ZeusTransformUtils.preCheckCast(r24.a(), Number.class, "com.obric.aiagent.plugin")).intValue(), null, null, (String) ZeusTransformUtils.preCheckCast(r24.b(), String.class, "com.obric.aiagent.plugin"), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), r15, null, 4, null);
    L56:
        long r112 = SystemClock.elapsedRealtime();
        String r25 = r110.getParams();
        if (r25 != null) goto L59;
        r25 = "{}";
    L59:
        String r26 = r1.a(r25, r9, r111, r10, r15, r22);
        r4.f18353a = r1;
        r4.f18354b = r10;
        r4.f18355c = r9;
        r4.f18356d = r22;
        r4.f18357e = r23;
        r4.f = r23;
        r4.g = r23;
        r4.h = r15;
        r4.i = r112;
        r4.l = 2;
        Object r27 = r20.execute(r9, r111, r26, r4);
        if (r27 != r13) goto L62;
        return r13;
    L62:
        r7 = r15;
        r6 = r112;
        String r32 = r22;
        r3 = r27;
        r0 = r32;
        goto L63
    L16:
        o.a(r3);
        String r28 = r34.getImplClassName();
        String r29 = r34.getTargetPkgName();
        if (r29 != null) goto L19;
        r29 = r34.getPackageName();
    L19:
        CharSequence r30 = (CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r31 = false;
        if (r30 != null) goto L22;
    L25:
        boolean r33 = true;
    L26:
        if (r33 == false) goto L28;
    L75:
        ILogDepend.Companion.e(TAG, "missing functionId/pkg: functionId=" + r28 + ", pkg=" + r29);
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.a(com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a, new IntentResult(-2002, null, null, "AppFunction impl ref missing", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), r36, null, 4, null);
    L28:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L30;
        boolean r37 = true;
    L31:
        if (r37 == true) goto L75;
        IAppFunctionInvoker r113 = (IAppFunctionInvoker) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppFunctionInvoker.class), IAppFunctionInvoker.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L36;
        String r39 = r34.getAction();
        if (r39 != null) goto L40;
        r39 = "";
    L40:
        String r114 = r39;
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m r40 = x.f18310a.a(r29, r28);
        if (r40 != null) goto L43;
    L45:
        if (r31 == false) goto L47;
        IntentExecutePolicyItem r115 = com.obric.aiagent.executionengine.scheduler.impl.execution.security.a.f18428a.a();
    L48:
        com.obric.aiagent.executionengine.scheduler.impl.execution.security.a r41 = com.obric.aiagent.executionengine.scheduler.impl.execution.security.a.f18428a;
        String r42 = String.valueOf(r35.d());
        IMAppActionExt r43 = r35.b().getExt();
        r4.f18353a = this;
        r4.f18354b = r34;
        r4.f18355c = r35;
        r4.f18356d = r28;
        r4.f18357e = r29;
        r4.f = r113;
        r4.g = r114;
        r4.h = r36;
        r4.l = 1;
        r23 = null;
        Object r44 = r41.a(r42, r114, null, r43, r29, r115, r4);
        if (r44 != r13) goto L51;
        return r13;
    L51:
        r110 = r34;
        r111 = r28;
        r9 = r29;
        r21 = r44;
        r10 = r35;
        r20 = r113;
        r22 = r114;
        r1 = this;
        r15 = r36;
        goto L52
    L47:
        r115 = null;
        goto L48
    L43:
        if (r40.l() != true) goto L45;
        r31 = true;
        goto L45
    L36:
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.a(com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a, new IntentResult(-2002, null, null, "IAppFunctionInvoker unavailable", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null), r36, null, 4, null);
    L30:
        r37 = false;
        goto L31
    L22:
        if (r30.length() == 0) goto L25;
        r33 = false;
    L7:
        r4 = new a(this, r2);
        goto L8
    }

    private final String a(String r13, String r14, String r15, com.obric.aiagent.executionengine.scheduler.impl.job.c r16, long r17, String r19) {
        com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m r2 = x.f18310a.a(r14, r15);
        Object r3 = null;
        if (r2 == null) goto L5;
        Map<String, String> r4 = r2.h();
    L6:
        if (r4 != null) goto L9;
        r4 = ao.b();
    L9:
        if (r4.isEmpty() == false) goto L34;
        return r13;
    L34:
        n.a r5 = n.f38560a;     // Catch: Throwable -> L17
        c r6 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L14;
        JsonObject r0 = new JsonObject();     // Catch: Throwable -> L17
    L15:
        Object r1 = n.f(r0);     // Catch: Throwable -> L17
    L20:
        if (n.b(r1) == true) goto L23;
        r3 = r1;
    L23:
        JsonObject r7 = (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L26;
        r7 = new JsonObject();
    L26:
        Map<String, String> r8 = com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a.a(r17, r19, r16.e(), r16.c(), r16.b());
        Iterator<Map.Entry<String, String>> r9 = r4.entrySet().iterator();
    L28:
        if (r9.hasNext() == false) goto L32;
        Map.Entry r10 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.getKey(), String.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a((String) ZeusTransformUtils.preCheckCast(r10.getValue(), String.class, "com.obric.aiagent.plugin"), "com.obric.appfunctions.schemas.DispatchContext") == false) goto L28;
        JsonObject r12 = new JsonObject();
        r12.addProperty("questionId", (Number) ZeusTransformUtils.preCheckCast(Long.valueOf(r16.d()), Number.class, "com.obric.aiagent.plugin"));
        r12.addProperty("ext", com.obric.aiagent.executionengine.utils.e.a().toJson(r8));
        d.x r18 = d.x.f38692a;
        r7.add(r11, (JsonElement) ZeusTransformUtils.preCheckCast(r12, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L28
    L32:
        String r20 = r7.toString();
        d.h.b.o.c(r20, "toString(...)");
        return r20;
    L14:
        r0 = (JsonObject) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(r13, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        n.a r21 = n.f38560a;
        r1 = n.f(o.a(th));
        goto L20
    L5:
        r4 = null;
        goto L6
    }

    private final void a(PendingIntent r10) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        c r9 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        ActivityOptions r11 = ActivityOptions.makeBasic();     // Catch: Throwable -> L8
        if (Build.VERSION.SDK_INT < 34) goto L6;
        r11.setPendingIntentBackgroundActivityStartMode(1);     // Catch: Throwable -> L8
    L6:
        r10.send((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 0, null, null, null, null, r11.toBundle());     // Catch: Throwable -> L8
        Object r12 = n.f(d.x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r13 = n.c(r12);
        if (r13 == null) goto L16;
        ILogDepend.Companion.e(TAG, "send pendingIntent failed", r13);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        n.a r14 = n.f38560a;
        r12 = n.f(o.a(th));
        goto L10
    }

    private final IntentResult<Object> a(AppFunctionCallResult r17) {
        int r1 = 0;
        if (r17.isStandardResult() == false) goto L12;
        Integer r2 = r17.getStandardCode();
        if (r2 == null) goto L7;
        r1 = r2.intValue();
    L7:
        IntentResult<Object> r0 = new IntentResult(r1, null, null, r17.getStandardMessage(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        AppEntity[] r3 = r17.getEntities();
        if (r3 == null) goto L10;
        r0.setEntity(r3);
    L10:
        return r0;
    L12:
        if (r17.isSuccess() == false) goto L14;
        int r4 = 0;
    L15:
        String r5 = r17.getReturnJson();
        if (r17.isSuccess() == false) goto L18;
        String r6 = r5;
    L19:
        IntentResult<Object> r15 = new IntentResult(r4, null, null, r6, false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        if (r17.isSuccess() == false) goto L28;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L24;
    L25:
        r1 = 1;
    L26:
        if (r1 != 0) goto L28;
        ConcurrentHashMap<String, String> r8 = new ConcurrentHashMap();
        r8.put("app_function_return_json", r5);
        r15.setExt(r8);
        goto L28
    L24:
        if (r7.length() != 0) goto L26;
    L28:
        return r15;
    L18:
        r6 = r17.getErrorMessage();
        goto L19
    L14:
        r4 = b.f18346a.a(r17.getCode(), r17.getErrorMessage());
        goto L15
    }
}
