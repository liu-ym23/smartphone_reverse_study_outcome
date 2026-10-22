package com.obric.aiagent.executionengine.scheduler.impl.a;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.executionengine.capabilitymanager.api.intention.IIntentionDataManagerApi;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.AppAction;
import com.obric.capabilitykit.common.FeedbackResult;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.IMAppActionExt;
import com.obric.capabilitykit.corecommon.JsonParserExt;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.z;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AtomicAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final String TAG = "AtomicAction";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f18059a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppAction f18060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JsonObject f18061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonObject f18062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, JsonObject> f18063e;
    private final com.obric.aiagent.executionengine.scheduler.impl.job.c f;
    private final com.obric.aiagent.executionengine.scheduler.impl.a.c<e> g;
    private final com.obric.aiagent.executionengine.capabilitymanager.api.a.a h;
    private final long i;
    private a j;
    private final String k;
    private final String l;
    private boolean m;
    private final ArrayList<b> n;
    private IMAppAction o;
    private boolean p;

    /* JADX INFO: compiled from: AtomicAction.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18064a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f18065b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f18066c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f18067d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f18068e = null;
        private static final /* synthetic */ a[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f18064a, f18065b, f18066c, f18067d, f18068e};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f18064a = new a("INIT", 0);
            f18065b = new a("SCHEDULED", 1);
            f18066c = new a("RUNNING", 2);
            f18067d = new a("FINISHED", 3);
            f18068e = new a("ABORTED", 4);
            a[] r0 = a();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AtomicAction.kt */
    public interface b {
        void a(e r1, a r2);
    }

    /* JADX INFO: compiled from: AtomicAction.kt */
    public static final class c {
        public /* synthetic */ c(d.h.b.h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: AtomicAction.kt */
    @d.c.b.a.f(b = "AtomicAction.kt", c = {ApWakeEvent.ACCELERATING_END, ApWakeEvent.OTHER_START}, d = "doAction", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicAction")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f18071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f18072d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f18073e;
        final /* synthetic */ e f;
        int g;

        d(e r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18073e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.scheduler.impl.a.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AtomicAction.kt */
    @d.c.b.a.f(b = "AtomicAction.kt", c = {226}, d = "doCapabilityInternal$suspendImpl", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicAction")
    static final class C0373e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f18076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18077d;

        C0373e(e r3, d.c.d<? super C0373e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18076c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18075b = r3;
            this.f18077d |= Integer.MIN_VALUE;
            return e.a(this.f18076c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AtomicAction.kt */
    @d.c.b.a.f(b = "AtomicAction.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.scheduler.impl.action.AtomicAction$setState$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f18079b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18080c;

        f(e r3, a r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18079b = r3;
            this.f18080c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f18079b, this.f18080c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f18078a != 0) goto L13;
            o.a(r4);
            a r5 = e.a(this.f18079b);
            a r0 = this.f18080c;
            if (r5 == r0) goto L11;
            e.a(this.f18079b, r0);
            ILogDepend.Companion.d(e.TAG, "set as " + e.a(this.f18079b) + ", operationId=" + this.f18079b.e());
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(e.b(this.f18079b), Iterable.class, "com.obric.aiagent.plugin");
            e r3 = this.f18079b;
            Iterator r7 = r6.iterator();
        L8:
            if (r7.hasNext() == false) goto L11;
            ((b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.aiagent.plugin")).a(r3, e.a(r3));
        L11:
            return x.f38692a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f18059a = new c(null);
    }

    public Object a(AppAction r3, com.obric.aiagent.executionengine.capabilitymanager.api.a.a r4, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r5) {
        return a(this, r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public Object a(AppAction r3, d.c.d<? super IMAppAction> r4) {
        return a(this, r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public e(AppAction r3, JsonObject r4, JsonObject r5, Map<String, JsonObject> r6, com.obric.aiagent.executionengine.scheduler.impl.job.c r7, com.obric.aiagent.executionengine.scheduler.impl.a.c<e> r8, com.obric.aiagent.executionengine.capabilitymanager.api.a.a r9) {
        Map<String, JsonObject> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "appAction");
        d.h.b.o.e(r7, "job");
        d.h.b.o.e(r8, "dag");
        this.f18060b = r3;
        this.f18061c = r4;
        this.f18062d = r5;
        this.f18063e = r10;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r7.b().getActionId();
        this.j = a.f18064a;
        this.k = r3.getPackageName();
        this.l = r3.getAction();
        this.n = new ArrayList();
    }

    public /* synthetic */ e(AppAction r10, JsonObject r11, JsonObject r12, Map r13, com.obric.aiagent.executionengine.scheduler.impl.job.c r14, com.obric.aiagent.executionengine.scheduler.impl.a.c r15, com.obric.aiagent.executionengine.capabilitymanager.api.a.a r16, int r17, d.h.b.h r18) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        if ((r17 & 64) == 0) goto L5;
        com.obric.aiagent.executionengine.capabilitymanager.api.a.a r8 = null;
    L6:
        this(r10, r11, r12, r5, r14, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public static final /* synthetic */ a a(e r0) {
        return r0.j;
    }

    public static final /* synthetic */ void a(e r0, a r1) {
        r0.j = r1;
    }

    public static final /* synthetic */ ArrayList b(e r0) {
        return r0.n;
    }

    public final JsonObject a() {
        return this.f18061c;
    }

    public final void a(JsonObject r1) {
        this.f18061c = r1;
    }

    public final JsonObject b() {
        return this.f18062d;
    }

    public final boolean c() {
        if (this.h == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String d() {
        return this.k;
    }

    public final String e() {
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, com.obric.capabilitykit.common.IMAppAction] */
    /* JADX WARN: Type inference failed for: r4v10, types: [T, com.obric.capabilitykit.common.IMAppAction] */
    /* JADX WARN: Type inference failed for: r4v14, types: [T, com.obric.capabilitykit.common.IMAppAction] */
    /* JADX WARN: Type inference failed for: r4v18, types: [T, com.obric.capabilitykit.common.IMAppAction] */
    public final Object a(d.c.d<? super IMAppAction> r33) {
        e r0 = this;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r33, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r3 = r4.f18073e;
        Object r5 = d.c.a.b.a();
        int r6 = r4.g;
        int r7 = 0;
        int r9 = 2;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        z.f r1 = (z.f) ZeusTransformUtils.preCheckCast(r4.f18072d, z.f.class, "com.obric.aiagent.plugin");
        AppAction r8 = (AppAction) ZeusTransformUtils.preCheckCast(r4.f18071c, AppAction.class, "com.obric.aiagent.plugin");
        z.f r10 = (z.f) ZeusTransformUtils.preCheckCast(r4.f18070b, z.f.class, "com.obric.aiagent.plugin");
        e r11 = (e) ZeusTransformUtils.preCheckCast(r4.f18069a, e.class, "com.obric.aiagent.plugin");
        o.a(r3);
        z.f r12 = r1;
        r0 = r11;
    L51:
        T r13 = (IMAppAction) ZeusTransformUtils.preCheckCast(r3, IMAppAction.class, "com.obric.aiagent.plugin");
    L52:
        r12.f38504a = r13;
        FeedbackResult r14 = (FeedbackResult) ZeusTransformUtils.preCheckCast(com.obric.aiagent.executionengine.utils.e.a().fromJson(((IMAppAction) ZeusTransformUtils.preCheckCast(r10.f38504a, IMAppAction.class, "com.obric.aiagent.plugin")).getContent(), FeedbackResult.class), FeedbackResult.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L55;
        r14 = new FeedbackResult(0, null, null, 0, null, false, 63, null);
    L55:
        int r15 = r14.getCode();
        String r16 = r14.getMsg();
        JsonObject r17 = null;
        if (ZeusTransformUtils.instanceOf(r0, j.class) == false) goto L60;
        if (r15 != 0) goto L59;
        String r18 = ((j) ZeusTransformUtils.preCheckCast(r0, j.class, "com.obric.aiagent.plugin")).a((IMAppAction) ZeusTransformUtils.preCheckCast(r10.f38504a, IMAppAction.class, "com.obric.aiagent.plugin"));
    L61:
        if (r18 == null) goto L66;
        IMAppActionExt r19 = ((IMAppAction) ZeusTransformUtils.preCheckCast(r10.f38504a, IMAppAction.class, "com.obric.aiagent.plugin")).getExt();
        if (r19 == null) goto L66;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r19.put("_action_customized_result_string", r18), String.class, "com.obric.aiagent.plugin");
    L66:
        if (r0.m == true) goto L84;
        Map<String, JsonObject> r21 = r0.f18063e;
        if (r21 == null) goto L70;
        JsonObject r22 = (JsonObject) ZeusTransformUtils.preCheckCast(r21.get(r0.l), JsonObject.class, "com.obric.aiagent.plugin");
    L71:
        if (r22 == null) goto L84;
        if (r15 == 0) goto L75;
        r22.addProperty("success", d.c.b.a.b.a(false));
        ILogDepend.Companion.d(TAG, "doAction failed at " + r0.k + '_' + r0.l + ", details=" + r16);
        goto L84
    L75:
        r22.addProperty("success", d.c.b.a.b.a(true));
        r17 = JsonParserExt.INSTANCE.parseString(r16).getAsJsonObject();     // Catch: Exception -> L100
    L77:
        if (r17 == null) goto L84;
        Iterator<String> r23 = r17.keySet().iterator();
    L80:
        if (r23.hasNext() == false) goto L84;
        String r110 = (String) ZeusTransformUtils.preCheckCast(r23.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r111 = r17.get(r110);
        if (r22.has(r110) == false) goto L80;
        r22.add(r110, r111);
        goto L80
    L70:
        r22 = null;
    L84:
        r0.o = (IMAppAction) ZeusTransformUtils.preCheckCast(r10.f38504a, IMAppAction.class, "com.obric.aiagent.plugin");
        if (r15 == 0) goto L87;
        a r24 = a.f18068e;
    L88:
        r0.a(r24);
        ISecureLogDepend.Companion.i(TAG, "do action done，operationId=" + r0.l + ",ret=" + r15 + ", outputValueStr=" + r16 + ",outputOwnerMap=" + r0.f18063e + " interface=" + r8.getInterfaceName());
        if (r15 != 0) goto L99;
        if (r8.getInterfaceName() == null) goto L99;
        IIntentionDataManagerApi r25 = (IIntentionDataManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentionDataManagerApi.class), IIntentionDataManagerApi.class, "com.obric.aiagent.plugin");
        if (r25 == null) goto L99;
        String r26 = r8.getInterfaceName();
        d.h.b.o.a(r26);
        String r27 = r8.getTargetPkgName();
        if (r27 != null) goto L97;
        r27 = r8.getPackageName();
    L97:
        IIntentionDataManagerApi.a.a(r25, r26, r27, null, null, 12, null);
    L99:
        return r10.f38504a;
    L87:
        r24 = a.f18067d;
        goto L88
    L59:
        r18 = ((j) ZeusTransformUtils.preCheckCast(r0, j.class, "com.obric.aiagent.plugin")).b((IMAppAction) ZeusTransformUtils.preCheckCast(r10.f38504a, IMAppAction.class, "com.obric.aiagent.plugin"));
        goto L61
    L60:
        r18 = null;
        goto L61
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        z.f r28 = (z.f) ZeusTransformUtils.preCheckCast(r4.f18072d, z.f.class, "com.obric.aiagent.plugin");
        r8 = (AppAction) ZeusTransformUtils.preCheckCast(r4.f18071c, AppAction.class, "com.obric.aiagent.plugin");
        r10 = (z.f) ZeusTransformUtils.preCheckCast(r4.f18070b, z.f.class, "com.obric.aiagent.plugin");
        e r29 = (e) ZeusTransformUtils.preCheckCast(r4.f18069a, e.class, "com.obric.aiagent.plugin");
        o.a(r3);
        r12 = r28;
        r0 = r29;
    L46:
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r30 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        r0.f.a().add(new com.obric.aiagent.executionengine.scheduler.impl.job.c.b(r0.f18060b, r30));
        r13 = r30.b();
        goto L52
    L16:
        o.a(r3);
        ISecureLogDepend.Companion.i(TAG, "do action start: packageName=" + r0.k + ", operationId=" + r0.l + ", inputParams=" + r0.f18061c + ", isEvent=" + r0.m + "inputParamsWantsDependsOnOthers=" + r0.f18062d + ", outputOwnerMap=" + r0.f18063e);
        r0.a(a.f18066c);
        r12 = new z.f();
        r12.f38504a = new IMAppAction(0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);
        JsonObject r31 = r0.f18062d;
        if (r31 == null) goto L40;
        Iterator<String> r32 = r31.keySet().iterator();
    L20:
        if (r32.hasNext() == false) goto L40;
        String r34 = (String) ZeusTransformUtils.preCheckCast(r32.next(), String.class, "com.obric.aiagent.plugin");
        String r112 = r0.f18062d.get(r34).getAsString();
        d.h.b.o.c(r112, "getAsString(...)");
        List r113 = d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{"."}, false, 0, 6, null);
        String r114 = d.o.o.a((String) ZeusTransformUtils.preCheckCast(r113.get(r7), String.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("$", CharSequence.class, "com.obric.aiagent.plugin"));
        String r115 = (String) ZeusTransformUtils.preCheckCast(r113.get(r9), String.class, "com.obric.aiagent.plugin");
        Map<String, JsonObject> r116 = r0.f18063e;
        if (r116 == null) goto L38;
        JsonObject r117 = (JsonObject) ZeusTransformUtils.preCheckCast(r116.get(r114), JsonObject.class, "com.obric.aiagent.plugin");
        if (r117 == null) goto L38;
        if (r117.has(r115) == false) goto L28;
        JsonElement r118 = r117.get(r115);
        if (r118.isJsonNull() == true) goto L32;
        JsonObject r35 = r0.f18061c;
        if (r35 == null) goto L37;
        r35.add(r34, r118);
    L37:
        r7 = 0;
        r9 = 2;
        goto L20
    L32:
        com.obric.aiagent.executionengine.scheduler.impl.a.d r36 = com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a;
        String r37 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r37, "getString(...)");
        r12.f38504a = r36.a(r37, r0.i, -2003);
        r0.o = (IMAppAction) ZeusTransformUtils.preCheckCast(r12.f38504a, IMAppAction.class, "com.obric.aiagent.plugin");
        r0.a("missing the value of param(" + r115 + ")!");
        return r12.f38504a;
    L28:
        com.obric.aiagent.executionengine.scheduler.impl.a.d r38 = com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a;
        String r39 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r39, "getString(...)");
        r12.f38504a = r38.a(r39, r0.i, -2003);
        r0.o = (IMAppAction) ZeusTransformUtils.preCheckCast(r12.f38504a, IMAppAction.class, "com.obric.aiagent.plugin");
        r0.a("can't find the wanted param(" + r115 + ")!");
        return r12.f38504a;
    L38:
        com.obric.aiagent.executionengine.scheduler.impl.a.d r40 = com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a;
        String r41 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_action_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_action_failed"));
        d.h.b.o.c(r41, "getString(...)");
        r12.f38504a = r40.a(r41, r0.i, -2003);
        r0.o = (IMAppAction) ZeusTransformUtils.preCheckCast(r12.f38504a, IMAppAction.class, "com.obric.aiagent.plugin");
        r0.a("outputOwner(actionName=" + r114 + ") is null!");
        return r12.f38504a;
    L40:
        AppAction r42 = AppAction.copy$default(r0.f18060b, null, null, String.valueOf(r0.f18061c), null, 0, null, null, null, null, null, DownloadErrorCode.ERROR_CANNOT_ACCESS_NETWORK, null);
        com.obric.aiagent.executionengine.capabilitymanager.api.a.a r43 = r0.h;
        if (r43 == null) goto L47;
        r4.f18069a = r0;
        r4.f18070b = r12;
        r4.f18071c = r42;
        r4.f18072d = r12;
        r4.g = 1;
        Object r44 = r0.a(r42, r43, r4);
        if (r44 != r5) goto L45;
        return r5;
    L45:
        r10 = r12;
        r8 = r42;
        r3 = r44;
        goto L46
    L47:
        r4.f18069a = r0;
        r4.f18070b = r12;
        r4.f18071c = r42;
        r4.f18072d = r12;
        r4.g = 2;
        Object r45 = r0.a(r42, r4);
        if (r45 != r5) goto L50;
        return r5;
    L50:
        r10 = r12;
        r8 = r42;
        r3 = r45;
    L7:
        r4 = new d(r0, r2);
        goto L8
    }

    static /* synthetic */ Object a(e r11, AppAction r12, d.c.d<? super IMAppAction> r13) {
        d.c.d<? super IMAppAction> r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.d(TAG, "doActionInternal -- execActionSync: paramsAppAction=" + r12);
        return com.obric.aiagent.executionengine.scheduler.impl.a.d.f18035a.a(r12, r11.f.d(), r11.f.c(), r11.f.e(), r11.i, r10);
    }

    static /* synthetic */ Object a(e r8, AppAction r9, com.obric.aiagent.executionengine.capabilitymanager.api.a.a r10, d.c.d<? super com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, C0373e.class) == false) goto L7;
        C0373e r0 = (C0373e) ZeusTransformUtils.preCheckCast(r12, C0373e.class, "com.obric.aiagent.plugin");
        if ((r0.f18077d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18077d -= Integer.MIN_VALUE;
    L8:
        C0373e r7 = r0;
        Object r13 = r7.f18075b;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f18077d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r8 = (e) ZeusTransformUtils.preCheckCast(r7.f18074a, e.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L17:
        com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c r14 = (com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.executionengine.scheduler.impl.job.c.C0383c.class, "com.obric.aiagent.plugin");
        m.f18144a.b(r8.f.c(), r14);
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r13);
        ISecureLogDepend.Companion.i(TAG, "doCapabilityInternal -- type=" + r10 + ", paramsAppAction=" + r9 + ", actionId=" + r8.i);
        m.f18144a.a(r9, r8.f);
        com.obric.aiagent.executionengine.scheduler.impl.b.f r3 = com.obric.aiagent.executionengine.scheduler.impl.b.e.f18360a.a(r10);
        com.obric.aiagent.executionengine.scheduler.impl.job.c r4 = r8.f;
        long r5 = r8.i;
        r7.f18074a = r8;
        r7.f18077d = 1;
        r13 = r3.a(r9, r4, r5, r7);
        if (r13 != r1) goto L17;
        return r1;
    L7:
        r0 = new C0373e(r8, r12);
        goto L8
    }

    public final void f() {
        this.m = true;
    }

    private final void a(String r3) {
        ILogDepend.Companion.e(TAG, r3);
        a(a.f18068e);
    }

    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    public String toString() {
        return getClass().getSimpleName() + "(packageName=" + this.k + ", operationId=" + this.l + ", inputParams=" + this.f18061c + ", isEvent=" + this.m + ", inputParamsWantsDependsOnOthers=" + this.f18062d + ", isIntent=" + c() + ", state=" + this.j + ')';
    }

    private final void a(a r8) {
        kotlinx.coroutines.i.a(com.obric.aiagent.executionengine.scheduler.impl.job.d.f18489a.c(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final a g() {
        return this.j;
    }

    public final void h() {
        a(a.f18068e);
    }

    public final void i() {
        a(a.f18065b);
    }

    public final void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        this.n.add(r4);
    }

    public final void b(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "callback");
        this.n.remove(r4);
    }

    public final com.obric.aiagent.executionengine.scheduler.impl.a.c<e> j() {
        return this.g;
    }

    public final long k() {
        return this.i;
    }

    public final IMAppAction l() {
        return this.o;
    }

    public final boolean m() {
        return this.p;
    }
}
