package com.obric.aiagent.executionengine.scheduler.impl.job;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.aiagent.executionengine.capabilitymanager.api.matcher.IActionMatcherApi;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.VersionInfo;
import com.obric.capabilitykit.common.intent.MatchException;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JobsParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final String TAG = "JobsParser";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f18533a = null;

    /* JADX INFO: compiled from: JobsParser.kt */
    public static class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18534a;

        public a(String r2) {
            o.e(r2, "errorMsg");
            this.f18534a = r2;
        }

        public final String a() {
            return this.f18534a;
        }
    }

    /* JADX INFO: compiled from: JobsParser.kt */
    public static final class b extends a {
        public b(String r2) {
            o.e(r2, "errorMsg");
            super(r2);
        }
    }

    /* JADX INFO: compiled from: JobsParser.kt */
    @d.c.b.a.f(b = "JobsParser.kt", c = {99}, d = "parse", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobsParser")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f18537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18538d;

        c(e r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18537c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18536b = r3;
            this.f18538d |= Integer.MIN_VALUE;
            return this.f18537c.a(null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JobsParser.kt */
    @d.c.b.a.f(b = "JobsParser.kt", c = {403, 408}, d = "parseActionsAndOutputOwnerMap", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobsParser")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18542d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f18543e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        boolean l;
        int m;
        /* synthetic */ Object n;
        final /* synthetic */ e o;
        int p;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.o = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.n = r9;
            this.p |= Integer.MIN_VALUE;
            return e.a(this.o, null, null, null, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.job.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JobsParser.kt */
    @d.c.b.a.f(b = "JobsParser.kt", c = {264}, d = "parseEcaJob", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobsParser")
    static final class C0385e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f18546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18547d;

        C0385e(e r3, d.c.d<? super C0385e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18546c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18545b = r3;
            this.f18547d |= Integer.MIN_VALUE;
            return e.b(this.f18546c, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: JobsParser.kt */
    @d.c.b.a.f(b = "JobsParser.kt", c = {136}, d = "parseEcaJobs", e = "com.obric.aiagent.executionengine.scheduler.impl.job.JobsParser")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18549b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18550c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18551d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f18552e;
        /* synthetic */ Object f;
        final /* synthetic */ e g;
        int h;

        f(e r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return e.a(this.g, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f18533a = new e();
    }

    private e() {
    }

    public static final /* synthetic */ Object a(e r8, JsonArray r9, JsonArray r10, JsonArray r11, androidx.b.a r12, IMAppAction r13, boolean r14, d.c.d r15) {
        return r8.a(r9, r10, r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(e r2, JsonObject r3, IMAppAction r4, boolean r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object b(e r2, JsonObject r3, IMAppAction r4, boolean r5, d.c.d r6) {
        return r2.b(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Object a(IMAppAction r6, boolean r7, d.c.d<? super List<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
        if ((r0.f18538d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18538d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f18536b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f18538d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (IMAppAction) ZeusTransformUtils.preCheckCast(r0.f18535a, IMAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Exception -> L32
    L40:
        return r10;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        d.o.a(r10);
        int r11 = r6.getVersion();
        if (r11 == 1) goto L39;
        if (r11 != 2) goto L21;
    L24:
        JsonObject r12 = JsonParserExt.INSTANCE.parseString(r6.getContent()).getAsJsonObject();     // Catch: Exception -> L32
        o.a(r12);     // Catch: Exception -> L32
        if (r7 == false) goto L27;
        boolean r13 = true;
    L28:
        r0.f18535a = r6;     // Catch: Exception -> L32
        r0.f18538d = 1;     // Catch: Exception -> L32
        r10 = a(r12, r6, r13, r0);     // Catch: Exception -> L32
        if (r10 != r2) goto L40;
        return r2;
    L27:
        r13 = false;
        goto L28
    L21:
        if (r11 == 3) goto L24;
        return null;
    L39:
        return a(r6, r7);
    L32:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parse error: format of eca is not correct (" + r6.getContent() + ')');
        if (ZeusTransformUtils.instanceOf(e, b.class) == false) goto L36;
        throw e;
    L36:
        String r14 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_something_went_wrong"));
        o.c(r14, "getString(...)");
        throw new a(r14);
    L7:
        r0 = new c(this, r9);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00d9 -> B:25:0x00dc). Please report as a decompilation issue!!! */
    private final Object a(JsonObject r8, IMAppAction r9, boolean r10, d.c.d<? super List<com.obric.aiagent.executionengine.scheduler.impl.job.c>> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, f.class) == false) goto L7;
        f r1 = (f) ZeusTransformUtils.preCheckCast(r12, f.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f;
        Object r3 = d.c.a.b.a();
        int r4 = r1.h;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        boolean r7 = r1.f18552e;
        Iterator<JsonElement> r14 = (Iterator) ZeusTransformUtils.preCheckCast(r1.f18551d, Iterator.class, "com.obric.aiagent.plugin");
        ArrayList r15 = (ArrayList) ZeusTransformUtils.preCheckCast(r1.f18550c, ArrayList.class, "com.obric.aiagent.plugin");
        IMAppAction r16 = (IMAppAction) ZeusTransformUtils.preCheckCast(r1.f18549b, IMAppAction.class, "com.obric.aiagent.plugin");
        e r0 = (e) ZeusTransformUtils.preCheckCast(r1.f18548a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
        boolean r2 = r7;
        e this = r0;
    L25:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r17 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L30;
        if (r15 != null) goto L29;
        r15 = new ArrayList();
    L29:
        r15.add(r17);
    L30:
        boolean r18 = r2;
    L20:
        if (r14.hasNext() == false) goto L31;
        JsonObject r5 = ((JsonElement) ZeusTransformUtils.preCheckCast(r14.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();
        o.c(r5, "getAsJsonObject(...)");
        r1.f18548a = this;
        r1.f18549b = r16;
        r1.f18550c = r15;
        r1.f18551d = r14;
        r1.f18552e = r18;
        r1.h = 1;
        Object r6 = this.b(r5, r16, r18, r1);
        if (r6 != r3) goto L24;
        return r3;
    L24:
        r2 = r18;
        r13 = r6;
        goto L25
    L31:
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r13);
        JsonArray r19 = r8.get("jobs").getAsJsonArray();     // Catch: Exception -> L17
    L18:
        r14 = r19.iterator();
        o.c(r14, "iterator(...)");
        r16 = r9;
        r15 = null;
        r18 = r10;
    L17:
        r19 = JsonParserExt.INSTANCE.parseString(r8.get("Content").getAsString()).getAsJsonObject().get("jobs").getAsJsonArray();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parseEcaJobs error: jobsJson=" + r8, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        String r20 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_something_went_wrong"));
        o.c(r20, "getString(...)");
        throw new a(r20);
    L7:
        r1 = new f(this, r12);
        goto L8
    }

    private final Object b(JsonObject r17, IMAppAction r18, boolean r19, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c> r20) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C0385e.class) == false) goto L7;
        C0385e r2 = (C0385e) ZeusTransformUtils.preCheckCast(r1, C0385e.class, "com.obric.aiagent.plugin");
        if ((r2.f18547d & Integer.MIN_VALUE) == 0) goto L7;
        r2.f18547d -= Integer.MIN_VALUE;
    L8:
        C0385e r7 = r2;
        Object r3 = r7.f18545b;
        Object r10 = d.c.a.b.a();
        int r4 = r7.f18547d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r7.f18544a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r3);
    L54:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r5 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        r0.a(r5);
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r3);
        if (r17.has("actions") == true) goto L22;
        if (r17.has("events") == true) goto L22;
        ILogDepend.Companion.e(TAG, "parseEcaJob: jobJson not contains: actions / events. jobJson=" + r17);
        String r6 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_something_went_wrong"));
        o.c(r6, "getString(...)");
        throw new a(r6);
    L22:
        if (r17.has("events") == false) goto L24;
        JsonArray r8 = r17.get("events").getAsJsonArray();
    L25:
        if (r8 == null) goto L38;
        Iterator<JsonElement> r9 = r8.iterator();
        o.c(r9, "iterator(...)");
        JsonArray r12 = null;
        JsonArray r14 = null;
    L28:
        if (r9.hasNext() == false) goto L37;
        JsonObject r13 = ((JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();
        if (r13.has("actions") == true) goto L31;
        if (r13.has("eventName") == false) goto L28;
        if (r12 != null) goto L36;
        r12 = new JsonArray();
    L36:
        r12.add((JsonElement) ZeusTransformUtils.preCheckCast(r13, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L28
    L31:
        r14 = r13.get("actions").getAsJsonArray();
        goto L28
    L37:
        JsonArray r11 = r12;
    L56:
        JsonArray r15 = r17.get("actions").getAsJsonArray();     // Catch: Exception -> L41
    L42:
        if (r11 == null) goto L44;
        JsonArray r16 = r15;
        r15 = r14;
    L45:
        if (r15 != null) goto L50;
        if (r11 != null) goto L50;
        ILogDepend.Companion.e(TAG, "parseEcaJob error, can't find the executable actions: jobJson=" + r17);
        String r21 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_something_went_wrong"));
        o.c(r21, "getString(...)");
        throw new a(r21);
    L50:
        androidx.b.a<String, JsonObject> r22 = new androidx.b.a();
        r7.f18544a = this;
        r7.f18547d = 1;
        r3 = a(r15, r11, r16, r22, r18, r19, r7);
        if (r3 != r10) goto L53;
        return r10;
    L53:
        r0 = this;
        goto L54
    L44:
        r16 = null;
    L41:
        r15 = null;
        goto L42
    L38:
        r11 = null;
        r14 = null;
        goto L56
    L24:
        r8 = null;
    L7:
        r2 = new C0385e(this, r1);
        goto L8
    }

    private final Object a(JsonArray r50, JsonArray r51, JsonArray r52, androidx.b.a<String, JsonObject> r53, IMAppAction r54, boolean r55, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c> r56) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r56, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin");
        if ((r3.p & Integer.MIN_VALUE) == 0) goto L7;
        r3.p -= Integer.MIN_VALUE;
        e r4 = this;
    L8:
        Object r2 = r3.n;
        Object r5 = d.c.a.b.a();
        int r6 = r3.p;
        String r7 = "obric_something_went_wrong";
        String r8 = "getString(...)";
        String r9 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        String r13 = TAG;
        if (r6 != 0) goto L188;
        d.o.a(r2);
        JsonArray r0 = new JsonArray();
        if (r50 == null) goto L32;
        Iterator<JsonElement> r10 = r50.iterator();
        o.c(r10, "iterator(...)");
    L30:
        if (r10.hasNext() == false) goto L32;
        r0.add((JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.aiagent.plugin"));
    L32:
        if (r51 == null) goto L37;
        Iterator<JsonElement> r11 = r51.iterator();
        o.c(r11, "iterator(...)");
    L35:
        if (r11.hasNext() == false) goto L37;
        r0.add((JsonElement) ZeusTransformUtils.preCheckCast(r11.next(), JsonElement.class, "com.obric.aiagent.plugin"));
    L37:
        Iterator<JsonElement> r12 = r0.iterator();
        o.c(r12, "iterator(...)");
        androidx.b.a<String, JsonObject> r14 = r53;
        Iterator<JsonElement> r15 = r12;
        d r16 = r3;
        Object r17 = r5;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r18 = null;
        JsonArray r19 = r52;
        IMAppAction r20 = r54;
        boolean r21 = r55;
    L39:
        if (r15.hasNext() == false) goto L171;
        JsonObject r110 = ((JsonElement) ZeusTransformUtils.preCheckCast(r15.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsJsonObject();
        String r29 = r8;
        boolean r22 = r110.has("actionName");
        if (r22 == false) goto L43;
        String r111 = r110.get("actionName").getAsString();
    L44:
        o.a(r111);
        String r43 = r7;
        String r44 = r9;
        String r23 = "";
        if (r110.has("packageName") == false) goto L47;
        String r24 = r110.get("packageName").getAsString();
        o.c(r24, "getAsString(...)");
    L48:
        Iterator<JsonElement> r57 = r15;
        JsonArray r58 = r19;
        ILogDepend.Companion.d(r13, "parseOutputOwnerMap: packageName=" + r24 + ", isAction=" + r22 + ", actionOrEventName=" + r111);
        boolean r25 = r110.has("impls");
        JsonObject r112 = new JsonObject();
        JsonObject r113 = new JsonObject();
        d r59 = r16;
        e r510 = r4;
        if (r110.has("inputParams") == false) goto L68;
        JsonObject r26 = r110.get("inputParams").getAsJsonObject();
        Iterator<String> r114 = r26.keySet().iterator();
    L52:
        if (r114.hasNext() == false) goto L68;
        r24 = r24;
        r23 = r23;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r114.next(), String.class, "com.obric.aiagent.plugin");
        JsonObject r28 = r26.get(r27).getAsJsonObject();
        r26 = r26;
        if (r28.has("value") == true) goto L55;
        r23 = r23;
        r26 = r26;
        r18 = r18;
        goto L52
    L55:
        boolean r45 = r21;
        IMAppAction r46 = r20;
        if (ZeusTransformUtils.instanceOf(r28.get("value"), JsonPrimitive.class) == true) goto L59;
        r112.add(r27, r28.get("value"));
    L58:
        r21 = r45;
        r20 = r46;
        goto L52
    L59:
        String r30 = r28.get("value").getAsString();
        o.a(r30);
        com.obric.aiagent.executionengine.scheduler.impl.job.c r210 = r18;
        String r115 = r13;
        String r511 = r111;
        if (d.o.o.b(r30, "$", false, 2, null) == true) goto L62;
    L64:
        if (r25 == true) goto L66;
        r112.add(r27, r28.get("value"));
    L66:
        r111 = r511;
        r13 = r115;
        r18 = r210;
        goto L58
    L62:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r30, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("outputParams", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L64;
        r113.add(r27, r28.get("value"));
    L68:
        IMAppAction r47 = r20;
        boolean r48 = r21;
        String r211 = r24;
        String r512 = r23;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r212 = r18;
        String r116 = r13;
        String r513 = r111;
        int r117 = 0;
        if (r22 == true) goto L71;
    L77:
        String r31 = r513;
    L78:
        String r32 = r116;
        ISecureLogDepend.Companion.i(r32, "parseOutputOwnerMap, inputParamsWants=" + r112 + ", inputParamsWantsDependsOnOthers=" + r113 + ", outputOwnerMap=" + r14);
        if (r212 != null) goto L81;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r33 = new com.obric.aiagent.executionengine.scheduler.impl.job.c(r47, r48, (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r47.getVersion(), null, 16, null);
    L82:
        String r34 = r211;
        if (o.a(r34, r512) == false) goto L85;
        e r35 = r510;
        r34 = r35.a(r31, r22);
    L86:
        if (r22 == true) goto L87;
        r33.a((com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.executionengine.scheduler.impl.a.i(new AppAction(r34, r31, "", null, 0, null, null, null, null, null, DownloadErrorCode.ERROR_DB_READONLY, null), r112, r113, r14, r33, r58, r33.i(), 0, 128, null), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin"));
        r4 = r35;
        r9 = r44;
        r16 = r59;
        r15 = r57;
        r17 = r17;
        r7 = r43;
        r21 = r48;
        r18 = r33;
        r19 = r58;
        r8 = r29;
        r13 = r32;
        r20 = r47;
        goto L39
    L87:
        ISecureLogDepend.Companion.i(r32, "the query version = " + r47.getVersion() + "; info is " + r110);
        if (r47.getVersion() < 3) goto L90;
        r117 = 1;
    L90:
        if (r117 != 0) goto L182;
    L107:
        JsonArray r36 = r58;
        e r514 = r35;
        IMAppAction r118 = r47;
        Object r119 = r17;
        String r49 = r32;
        r3 = r59;
        JsonObject r37 = r112;
        boolean r38 = r48;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r39 = r33;
        String r120 = r31;
        int r40 = r117;
        Iterator<JsonElement> r121 = r57;
        e r41 = r514;
        JsonObject r122 = r110;
        com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a r123 = null;
    L108:
        if (r40 == 0) goto L113;
        if (r123 == null) goto L111;
        AppAction r42 = r123.a();     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
    L112:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r410 = r39;
        JsonObject r60 = r37;
        com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a r61 = r123;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r124 = r410;
    L129:
        if (r40 != 0) goto L131;
        com.obric.aiagent.executionengine.capabilitymanager.api.a.a r62 = null;
    L180:
        String r125 = r49;
        ISecureLogDepend.Companion.i(r125, "queried appAction=" + r42 + ", capabilityType=" + r62);     // Catch: Throwable -> L154 MatchException.NoImplException -> L156 MatchException.NoDefineIntentException -> L158
        if (r42 == null) goto L146;
        JsonObject r63 = JsonParserExt.INSTANCE.parseString(r42.getParams()).getAsJsonObject();     // Catch: Throwable -> L154 MatchException.NoImplException -> L156 MatchException.NoDefineIntentException -> L158
        Iterator<String> r64 = r63.keySet().iterator();     // Catch: Throwable -> L154 MatchException.NoImplException -> L156 MatchException.NoDefineIntentException -> L158
    L141:
        if (r64.hasNext() == false) goto L143;
        JsonArray r515 = r36;
        String r65 = (String) ZeusTransformUtils.preCheckCast(r64.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L154 MatchException.NoImplException -> L156 MatchException.NoDefineIntentException -> L158
        r60.add(r65, r63.get(r65));     // Catch: Throwable -> L154 MatchException.NoImplException -> L156 MatchException.NoDefineIntentException -> L158
        r36 = r515;
        goto L141
    L143:
        JsonArray r516 = r36;
        IMAppAction r517 = r118;
        String r66 = r125;
        boolean r518 = r38;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r126 = r124;
        r126.a(new com.obric.aiagent.executionengine.scheduler.impl.a.e(r42, r60, r113, (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r124, r124.i(), r62));     // Catch: Throwable -> L148 MatchException.NoImplException -> L150 MatchException.NoDefineIntentException -> L152
        r19 = r516;
        r21 = r518;
        r18 = r126;
        r16 = r3;
        r17 = r119;
        r15 = r121;
        r4 = r41;
        r8 = r29;
        r7 = r43;
        r9 = r44;
        r13 = r66;
        r20 = r517;
        goto L39
    L152:
        e = e;
    L106:
        String r127 = r29;
        String r67 = r43;
        String r68 = r44;
    L168:
        ILogDepend.Companion.e(r66, "queryIntent: NoDefineIntentException (" + e + ')');
        String r69 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, r68, r67));
        o.c(r69, r127);
        throw new a(r69);
    L150:
        e = e;
    L103:
        String r128 = r29;
        String r70 = r44;
    L166:
        ILogDepend.Companion.e(r66, "queryIntent: NoImplException (" + e + ')');
        String r71 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_intent_exec_failed_no_impl_found, r70, "obric_intent_exec_failed_no_impl_found"));
        o.c(r71, r128);
        throw new b(r71);
    L148:
        th = th;
    L164:
        ILogDepend.Companion.e(r66, "queryIntent: general Throwable (" + th + ')', th);
        String r72 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, r44, r43));
        o.c(r72, r29);
        throw new a(r72);
    L146:
        JsonArray r519 = r36;
        IMAppAction r520 = r118;
        boolean r521 = r38;
        com.obric.aiagent.executionengine.scheduler.impl.job.c r129 = r124;
        r129.a(new com.obric.aiagent.executionengine.scheduler.impl.a.e(new AppAction(r34, r120, "", null, 0, null, null, null, null, null, DownloadErrorCode.ERROR_DB_READONLY, null), r60, r113, (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin"), r129, r129.i(), r62));     // Catch: Throwable -> L148 MatchException.NoImplException -> L150 MatchException.NoDefineIntentException -> L152
        r19 = r519;
        r21 = r521;
        r18 = r129;
        r16 = r3;
        r17 = r119;
        r15 = r121;
        r4 = r41;
        r8 = r29;
        r7 = r43;
        r9 = r44;
        r13 = r125;
        r20 = r520;
        goto L39
    L158:
        e = e;
        r66 = r125;
    L156:
        e = e;
        r66 = r125;
    L154:
        th = th;
        r66 = r125;
        goto L164
    L162:
        e = e;
        r66 = r49;
    L160:
        e = e;
        r66 = r49;
        goto L103
    L131:
        if (r61 == null) goto L134;
        r62 = r61.getType();     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        if (r62 != null) goto L180;
    L134:
        r62 = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16401c;     // Catch: Throwable -> L122 MatchException.NoImplException -> L160 MatchException.NoDefineIntentException -> L162
        goto L180
    L111:
        r42 = null;
        goto L112
    L113:
        int r411 = r40;
        boolean r130 = r38;
        IActionMatcherApi r73 = (IActionMatcherApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IActionMatcherApi.class), IActionMatcherApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L122 MatchException.NoImplException -> L160 MatchException.NoDefineIntentException -> L162
        if (r73 == null) goto L128;
        o.a(r122);     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f18539a = r41;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f18540b = r36;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f18541c = r14;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f18542d = r118;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f18543e = r39;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.f = r34;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.g = r120;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.h = r121;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.i = r37;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.j = r113;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.k = r123;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r3.l = r130;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        e r131 = r41;
        r3.m = r411;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        JsonObject r213 = r37;
        r3.p = 2;     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        Object r74 = r73.queryExecutableAppAction(r122, r3);     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r119 = r119;
        if (r74 != r119) goto L120;
        return r119;
    L120:
        r121 = r121;
        boolean r132 = r130;
        androidx.b.a<String, JsonObject> r75 = r14;
        r2 = r74;
        r40 = r411;
        e r76 = r131;
    L178:
        r41 = r76;
        r36 = r36;
        r34 = r34;
        r120 = r120;
        r61 = r123;
        r113 = r113;
        r3 = r3;
        r124 = r39;
        r118 = r118;
        r60 = r213;
        r38 = r132;
        androidx.b.a<String, JsonObject> r412 = r75;
        r42 = (AppAction) ZeusTransformUtils.preCheckCast(r2, AppAction.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L122 MatchException.NoImplException -> L124 MatchException.NoDefineIntentException -> L126
        r14 = r412;
    L122:
        th = th;
        r66 = r49;
    L126:
        e = e;
        r127 = r29;
        r67 = r43;
        r68 = r44;
        r66 = r49;
    L124:
        e = e;
        r128 = r29;
        r70 = r44;
        r66 = r49;
        goto L166
    L128:
        JsonObject r214 = r37;
        r119 = r119;
        r41 = r41;
        r40 = r411;
        r36 = r36;
        r34 = r34;
        r120 = r120;
        r121 = r121;
        r61 = r123;
        r113 = r113;
        r3 = r3;
        r124 = r39;
        r118 = r118;
        r60 = r214;
        r38 = r130;
        r42 = null;
        goto L129
    L182:
        IActionMatcherApi r77 = (IActionMatcherApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IActionMatcherApi.class), IActionMatcherApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        if (r77 == null) goto L107;
        o.a(r110);     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.f18539a = r35;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r36 = r58;
        r59.f18540b = r36;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.f18541c = r14;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r118 = r47;
        r59.f18542d = r118;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.f18543e = r33;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.f = r34;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.g = r31;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.h = r57;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.i = r110;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.j = r112;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.k = r113;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        e r522 = r35;
        r59.l = r48;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r59.m = r117;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        boolean r413 = r48;
        r59.p = 1;     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        Object r78 = r77.queryExecutableIntent(r110, r59);     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        Object r79 = r17;
        if (r78 != r79) goto L96;
        return r79;
    L96:
        e r414 = r522;
        Iterator<JsonElement> r133 = r57;
        r122 = r110;
        JsonObject r134 = r112;
        r120 = r31;
        r40 = r117;
        Object r135 = r79;
        r3 = r59;
        r39 = r33;
        androidx.b.a<String, JsonObject> r80 = r14;
        r2 = r78;
    L97:
        com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a r81 = (com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a) ZeusTransformUtils.preCheckCast(r2, com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L99 MatchException.NoImplException -> L101 MatchException.NoDefineIntentException -> L104
        r49 = r32;
        r14 = r80;
        r37 = r134;
        r38 = r413;
        r123 = r81;
        r41 = r414;
        Iterator<JsonElement> r415 = r133;
        r119 = r135;
        r121 = r415;
        goto L108
    L104:
        e = e;
        r66 = r32;
    L101:
        e = e;
        r66 = r32;
    L99:
        th = th;
        r66 = r32;
        goto L164
    L85:
        r35 = r510;
        goto L86
    L81:
        r33 = r212;
        goto L82
    L71:
        if (r110.has("outputParams") == false) goto L77;
        JsonObject r82 = r110.get("outputParams").getAsJsonObject();
        JsonObject r83 = new JsonObject();
        Iterator<String> r84 = r82.keySet().iterator();
    L74:
        if (r84.hasNext() == false) goto L76;
        r83.add((String) ZeusTransformUtils.preCheckCast(r84.next(), String.class, "com.obric.aiagent.plugin"), (JsonElement) ZeusTransformUtils.preCheckCast(JsonNull.INSTANCE, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L74
    L76:
        r31 = r513;
        ((Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.aiagent.plugin")).put(r31, r83);
        goto L78
    L47:
        r24 = "";
        goto L48
    L43:
        r111 = r110.get("eventName").getAsString();
        goto L44
    L171:
        com.obric.aiagent.executionengine.scheduler.impl.job.c r215 = r18;
        if (r215 == null) goto L177;
        if (r215.j().isEmpty() == false) goto L177;
        return null;
    L177:
        return r215;
    L188:
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L16;
        int r85 = r3.m;
        boolean r86 = r3.l;
        com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a r136 = (com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a) ZeusTransformUtils.preCheckCast(r3.k, com.obric.aiagent.executionengine.capabilitymanager.api.matcher.a.class, "com.obric.aiagent.plugin");
        JsonObject r137 = (JsonObject) ZeusTransformUtils.preCheckCast(r3.j, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r138 = (JsonObject) ZeusTransformUtils.preCheckCast(r3.i, JsonObject.class, "com.obric.aiagent.plugin");
        Iterator<JsonElement> r139 = (Iterator) ZeusTransformUtils.preCheckCast(r3.h, Iterator.class, "com.obric.aiagent.plugin");
        String r87 = (String) ZeusTransformUtils.preCheckCast(r3.g, String.class, "com.obric.aiagent.plugin");
        String r88 = (String) ZeusTransformUtils.preCheckCast(r3.f, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r89 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r3.f18543e, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        IMAppAction r90 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f18542d, IMAppAction.class, "com.obric.aiagent.plugin");
        androidx.b.a<String, JsonObject> r91 = (androidx.b.a) ZeusTransformUtils.preCheckCast(r3.f18541c, androidx.b.a.class, "com.obric.aiagent.plugin");
        JsonArray r92 = (JsonArray) ZeusTransformUtils.preCheckCast(r3.f18540b, JsonArray.class, "com.obric.aiagent.plugin");
        r76 = (e) ZeusTransformUtils.preCheckCast(r3.f18539a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L20 MatchException.NoImplException -> L22 MatchException.NoDefineIntentException -> L24
        r119 = r5;
        r43 = "obric_something_went_wrong";
        r29 = "getString(...)";
        r44 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r213 = r138;
        r49 = TAG;
        r121 = r139;
        r34 = r88;
        r39 = r89;
        r118 = r90;
        r36 = r92;
        r123 = r136;
        r113 = r137;
        r40 = r85;
        r120 = r87;
        r132 = r86;
        r75 = r91;
        goto L178
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r93 = r3.m;
        boolean r94 = r3.l;
        JsonObject r140 = (JsonObject) ZeusTransformUtils.preCheckCast(r3.k, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r141 = (JsonObject) ZeusTransformUtils.preCheckCast(r3.j, JsonObject.class, "com.obric.aiagent.plugin");
        JsonObject r142 = (JsonObject) ZeusTransformUtils.preCheckCast(r3.i, JsonObject.class, "com.obric.aiagent.plugin");
        Iterator<JsonElement> r143 = (Iterator) ZeusTransformUtils.preCheckCast(r3.h, Iterator.class, "com.obric.aiagent.plugin");
        String r95 = (String) ZeusTransformUtils.preCheckCast(r3.g, String.class, "com.obric.aiagent.plugin");
        String r96 = (String) ZeusTransformUtils.preCheckCast(r3.f, String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.scheduler.impl.job.c r97 = (com.obric.aiagent.executionengine.scheduler.impl.job.c) ZeusTransformUtils.preCheckCast(r3.f18543e, com.obric.aiagent.executionengine.scheduler.impl.job.c.class, "com.obric.aiagent.plugin");
        IMAppAction r98 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3.f18542d, IMAppAction.class, "com.obric.aiagent.plugin");
        androidx.b.a<String, JsonObject> r99 = (androidx.b.a) ZeusTransformUtils.preCheckCast(r3.f18541c, androidx.b.a.class, "com.obric.aiagent.plugin");
        JsonArray r100 = (JsonArray) ZeusTransformUtils.preCheckCast(r3.f18540b, JsonArray.class, "com.obric.aiagent.plugin");
        e r101 = (e) ZeusTransformUtils.preCheckCast(r3.f18539a, e.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L20 MatchException.NoImplException -> L22 MatchException.NoDefineIntentException -> L24
        r413 = r94;
        r43 = "obric_something_went_wrong";
        r29 = "getString(...)";
        r44 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r122 = r142;
        r133 = r143;
        r34 = r96;
        r39 = r97;
        r80 = r99;
        r36 = r100;
        r113 = r140;
        r134 = r141;
        r40 = r93;
        r120 = r95;
        r414 = r101;
        r135 = r5;
        r32 = TAG;
        r118 = r98;
    L24:
        e = e;
        r67 = "obric_something_went_wrong";
        r127 = "getString(...)";
        r68 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r66 = TAG;
    L22:
        e = e;
        r128 = "getString(...)";
        r70 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r66 = TAG;
    L20:
        th = th;
        r43 = "obric_something_went_wrong";
        r29 = "getString(...)";
        r44 = WsChannelMultiProcessSharedProvider.STRING_TYPE;
        r66 = TAG;
    L7:
        r4 = this;
        r3 = new d(r4, r1);
        goto L8
    }

    private final String a(String r1, boolean r2) {
        return com.obric.aiagent.executionengine.scheduler.impl.a.a.f18027a.a(r1);
    }

    private final void a(com.obric.aiagent.executionengine.scheduler.impl.job.c r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        Iterator<com.obric.aiagent.executionengine.scheduler.impl.a.e> r0 = r13.j().values().iterator();
    L6:
        if (r0.hasNext() == false) goto L17;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r1 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        JsonObject r2 = r1.b();
        if (r2 == null) goto L6;
        Iterator<String> r4 = r2.keySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L6;
        String r5 = r2.get((String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.aiagent.plugin")).getAsString();
        o.c(r5, "getAsString(...)");
        String r6 = d.o.o.a((String) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null).get(0), String.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("$", CharSequence.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.executionengine.scheduler.impl.a.e r7 = a(r6, r13.i());
        if (r7 == null) goto L15;
        ILogDepend.Companion.e(TAG, "addEdge curAction=" + r1 + ", incomingAction=" + r7);
        o.a(r1);
        r13.a(r1, r7);
        goto L11
    L15:
        ILogDepend.Companion.e(TAG, "can't find the depended action(" + r6 + ") for " + r1);
        String r14 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_something_went_wrong, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_something_went_wrong"));
        o.c(r14, "getString(...)");
        throw new a(r14);
    }

    private final com.obric.aiagent.executionengine.scheduler.impl.a.e a(String r3, com.obric.aiagent.executionengine.scheduler.impl.a.c<com.obric.aiagent.executionengine.scheduler.impl.a.e> r4) {
        Iterator<com.obric.aiagent.executionengine.scheduler.impl.a.e> r2 = r4.a().keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.obric.aiagent.executionengine.scheduler.impl.a.e r5 = r2.next();
        o.c(r5, "next(...)");
        com.obric.aiagent.executionengine.scheduler.impl.a.e r6 = (com.obric.aiagent.executionengine.scheduler.impl.a.e) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.executionengine.scheduler.impl.a.e.class, "com.obric.aiagent.plugin");
        if (o.a(r3, r6.e()) == false) goto L4;
        return r6;
    L8:
        return null;
    }

    private final List<com.obric.aiagent.executionengine.scheduler.impl.job.c> a(IMAppAction r16, boolean r17) {
        VersionInfo r0 = r16.getVersionInfo();
        if (r0.getVersion() < 2) goto L10;
        ILogDepend.Companion.e(TAG, "this may not happen, we parse a eca job in old way");
        return null;
    L10:
        JsonObject r5 = JsonParserExt.INSTANCE.parseString(r16.getAction().getParams()).getAsJsonObject();     // Catch: Exception -> L9
        ArrayList r1 = new ArrayList();
        com.obric.aiagent.executionengine.scheduler.impl.job.c r2 = new com.obric.aiagent.executionengine.scheduler.impl.job.c(r16, r17, (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin"), r0.getVersion(), null, 16, null);
        r2.a(new com.obric.aiagent.executionengine.scheduler.impl.a.e(r16.getAction(), r5, null, null, r2, r2.i(), null, 64, null));
        r1.add(r2);
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L9:
        return null;
    }
}
