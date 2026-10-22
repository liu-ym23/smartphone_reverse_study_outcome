package com.obric.agent;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.obric.agent.auth.IAgentAuthService;
import com.obric.agent.autoaction.IAutoActionService;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.agent.trace.IIntentMetricsService;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.agent.trace.IOmniReportService;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.UiType;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BaseClockDeleteAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseSystemAutoActionIntent;
import com.obric.capabilitykit.common.intent.BlockListTarget;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.funcall_api.bean.AppAction;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.ax;
import d.h.b.aa;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CapabilityActionResultBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CapabilityActionResultBinder extends ICapabilityFeedbackReceiver.Stub {
    public static final a Companion = null;
    private static final String EXT_IS_OBRIC_CONTINUOUS_TALK = "is_obric_continuous_talk";
    private static final String EXT_O_COMPLEX_TASK = "o_complex_task";
    private static final String EXT_TO_SERVER = "to_server";
    public static final String TAG = "CapabilityActionResultBinder";
    private final d.f gson$delegate;
    private final Set<String> intentsWithCard;
    private final d.f keyguardManager$delegate;
    private final o<Long, List<IntentAppAction>> requestIntentRecordMap;
    private final Object requestLock;
    private final am scope;

    /* JADX INFO: compiled from: CapabilityActionResultBinder.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: CapabilityActionResultBinder.kt */
    @d.c.b.a.f(b = "CapabilityActionResultBinder.kt", c = {452, 536}, d = "invokeSuspend", e = "com.obric.agent.CapabilityActionResultBinder$onJobResultRecv$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f14165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f14166e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        Object k;
        Object l;
        Object m;
        int n;
        int o;
        int p;
        int q;
        int r;
        boolean s;
        int t;
        final /* synthetic */ CapabilityActionResultBinder u;
        final /* synthetic */ String v;
        final /* synthetic */ String w;
        final /* synthetic */ JobResult x;
        final /* synthetic */ boolean y;
        private /* synthetic */ Object z;

        /* JADX INFO: renamed from: com.obric.agent.CapabilityActionResultBinder$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: CapabilityActionResultBinder.kt */
        @d.c.b.a.f(b = "CapabilityActionResultBinder.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.CapabilityActionResultBinder$onJobResultRecv$1$5")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f14167a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CapabilityActionResultBinder f14168b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ IntentExecutionRecord f14169c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ IntentAppAction f14170d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ IntentAppAction f14171e;

            AnonymousClass1(CapabilityActionResultBinder r3, IntentExecutionRecord r4, IntentAppAction r5, IntentAppAction r6, d.c.d<? super AnonymousClass1> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f14168b = r3;
                this.f14169c = r4;
                this.f14170d = r5;
                this.f14171e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14168b, this.f14169c, this.f14170d, this.f14171e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f14167a != 0) goto L7;
                d.o.a(r3);
                CapabilityActionResultBinder r4 = this.f14168b;
                IntentExecutionRecord r0 = this.f14169c;
                IntentAppAction r1 = this.f14170d;
                d.h.b.o.a(r1);
                IntentAppAction r2 = this.f14171e;
                d.h.b.o.a(r2);
                CapabilityActionResultBinder.access$handleIntentMessageCard(r4, r0, r1, r2);
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        b(CapabilityActionResultBinder r3, String r4, String r5, JobResult r6, boolean r7, d.c.d<? super b> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.u = r3;
            this.v = r4;
            this.w = r5;
            this.x = r6;
            this.y = r7;
            super(2, r9);
        }

        public static /* synthetic */ String lambda$nK3KoWflkNyavBe_5LiHC8lDOSU(CapabilityActionResultBinder r0, IntentAppAction r1, IntentExecutionRecord r2) {
            return a(r0, r1, r2);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            b r12 = new b(this.u, this.v, this.w, this.x, this.y, r8);
            r12.z = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r18v12 */
        /* JADX WARN: Type inference failed for: r18v28 */
        /* JADX WARN: Type inference failed for: r18v9 */
        /* JADX WARN: Type inference failed for: r3v170 */
        /* JADX WARN: Type inference failed for: r3v90 */
        /* JADX WARN: Type inference failed for: r3v91, types: [T] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:145:0x0722 -> B:146:0x0732). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r46) {
            b r1 = this;
            Object r2 = d.c.a.b.a();
            int r3 = r1.t;
            if (r3 == 0) goto L14;
            if (r3 == 1) goto L11;
            if (r3 != 2) goto L10;
            boolean r4 = r1.s;
            int r8 = r1.q;
            int r9 = r1.p;
            int r10 = r1.o;
            int r11 = r1.n;
            IntentExecutionRecord r12 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r1.m, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            Iterator<IntentExecutionRecord> r13 = (Iterator) ZeusTransformUtils.preCheckCast(r1.l, Iterator.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r5 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.k, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            String r6 = (String) ZeusTransformUtils.preCheckCast(r1.j, String.class, "com.obric.aiagent.plugin");
            String r7 = (String) ZeusTransformUtils.preCheckCast(r1.i, String.class, "com.obric.aiagent.plugin");
            String r14 = (String) ZeusTransformUtils.preCheckCast(r1.h, String.class, "com.obric.aiagent.plugin");
            String r19 = (String) ZeusTransformUtils.preCheckCast(r1.g, String.class, "com.obric.aiagent.plugin");
            String r20 = (String) ZeusTransformUtils.preCheckCast(r1.f, String.class, "com.obric.aiagent.plugin");
            d.h.b.z.e r15 = (d.h.b.z.e) ZeusTransformUtils.preCheckCast(r1.f14166e, d.h.b.z.e.class, "com.obric.aiagent.plugin");
            String r16 = (String) ZeusTransformUtils.preCheckCast(r1.f14165d, String.class, "com.obric.aiagent.plugin");
            IIntentTraceService r23 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(r1.f14164c, IIntentTraceService.class, "com.obric.aiagent.plugin");
            IntentAppAction r17 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.f14163b, IntentAppAction.class, "com.obric.aiagent.plugin");
            IntentAppAction r18 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.f14162a, IntentAppAction.class, "com.obric.aiagent.plugin");
            am r21 = (am) ZeusTransformUtils.preCheckCast(r1.z, am.class, "com.obric.aiagent.plugin");
            d.o.a(r46);     // Catch: JsonSyntaxException -> L313
            b r45 = r1;
            int r32 = r8;
            boolean r110 = r4;
            IntentAppAction r111 = r17;
            final IntentAppAction r112 = r18;
            am r113 = r21;
            String r22 = r6;
            d.h.b.z.e r24 = r15;
            Object r25 = r2;
            int r26 = r10;
            Object r27 = r46;
            d.h.b.z.f r114 = r5;
            String r28 = r16;
        L146:
            Boolean r29 = (Boolean) ZeusTransformUtils.preCheckCast(r27, Boolean.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            r1 = r45;
            Object r30 = r25;
            int r31 = r11;
            Iterator<IntentExecutionRecord> r210 = r13;
            String r115 = r20;
            String r116 = r7;
            int r33 = r9;
            IntentExecutionRecord r34 = r12;
            String r117 = r19;
        L150:
            d.x r118 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
            Object r47 = r30;
            String r119 = r116;
            int r211 = r32;
            boolean r120 = r110;
        L151:
            IntentExecutionRecord r44 = r34;
            String r35 = r22;
            String r48 = r28;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L159;
            boolean r36 = true;
        L161:
            if (r36 == false) goto L163;
            r115 = r115 + '\n';     // Catch: JsonSyntaxException -> L313
        L163:
            r115 = r115 + r44.getImplClassName();     // Catch: JsonSyntaxException -> L313
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L166;
            boolean r37 = true;
        L167:
            if (r37 == false) goto L169;
            r117 = r117 + '\n';     // Catch: JsonSyntaxException -> L313
        L169:
            String r121 = r117 + r44.getResult();     // Catch: JsonSyntaxException -> L313
            ConcurrentHashMap<String, String> r38 = r111.getExt();     // Catch: JsonSyntaxException -> L313
            if (r38 == null) goto L184;
            int r212 = r33;
            String r39 = (String) ZeusTransformUtils.preCheckCast(r38.get("app_cost"), String.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r39 != null) goto L321;
        L185:
            boolean r40 = r120;
            String r41 = r121;
        L187:
            if (r44.getResult().getRet() >= 0) goto L189;
            int r42 = 1;
        L190:
            int r43 = r31 | r42;     // Catch: JsonSyntaxException -> L313
            if (r44.getResult().getRet() == 0) goto L193;
            String r49 = r14 + r44.getResult().getDetails() + ' ';     // Catch: JsonSyntaxException -> L313
            r26 = r44.getResult().getRet();     // Catch: JsonSyntaxException -> L313
            r14 = r49;
        L193:
            Object r50 = r44.getResult().getEntity();     // Catch: JsonSyntaxException -> L313
            if (ZeusTransformUtils.instanceOf(r50, Bitmap.class) == false) goto L196;
            ?? r51 = (Bitmap) ZeusTransformUtils.preCheckCast(r50, Bitmap.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
        L197:
            if (r51 == 0) goto L199;
            r114.f38504a = r51;     // Catch: JsonSyntaxException -> L313
            d.x r52 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L199:
            boolean r53 = r44.getResult().isFinal();     // Catch: JsonSyntaxException -> L313
            ILogDepend.Companion r54 = ILogDepend.Companion;     // Catch: JsonSyntaxException -> L313
            StringBuilder r55 = new StringBuilder().append("onJobResultRecv, isFinal ");     // Catch: JsonSyntaxException -> L313
            if (r53 == false) goto L202;
            boolean r122 = true;
        L203:
            r54.i(CapabilityActionResultBinder.TAG, r55.append(r122).toString());     // Catch: JsonSyntaxException -> L313
            if (r53 == false) goto L216;
            Object r56 = CapabilityActionResultBinder.access$getRequestLock$p(r1.u);     // Catch: JsonSyntaxException -> L313
            CapabilityActionResultBinder r57 = r1.u;     // Catch: JsonSyntaxException -> L313
            monitor-enter(r56);     // Catch: JsonSyntaxException -> L313
            List r58 = (List) ZeusTransformUtils.preCheckCast(CapabilityActionResultBinder.access$getRequestIntentRecordMap$p(r57).get(d.c.b.a.b.a(r112.getQuestionId())), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L212
            if (r58 == null) goto L210;
            d.c.b.a.b.a(r58.remove(r112));     // Catch: Throwable -> L212
        L210:
            monitor-exit(r56);     // Catch: JsonSyntaxException -> L313
        L217:
            r110 = r40;
            r117 = r41;
            String r59 = r35;
            d.h.b.z.f r60 = r114;
            am r123 = r113;
            String r124 = r119;
            int r61 = r212;
            int r62 = r43;
            r28 = r48;
            boolean r125 = r53;
            int r410 = r26;
            IIntentTraceService r63 = r23;
        L88:
            if (r210.hasNext() == false) goto L218;
            int r213 = r61;
            String r214 = r14;
            String r215 = r59;
            final IntentExecutionRecord r64 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r210.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            CapabilityActionResultBinder.access$normalizeEntityOrderIfNeeded(r1.u, r64.getResult());     // Catch: JsonSyntaxException -> L313
            if (d.h.b.o.a(r64.getIntentName(), "Recorder_Operate") == false) goto L95;
            v r310 = v.f16080a;     // Catch: JsonSyntaxException -> L313
            m r65 = m.f15194a;     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r112);     // Catch: JsonSyntaxException -> L313
            if (v.a(r310, r64, r65.a(r112, r64.getIntentName()), null, 4, null) == false) goto L95;
            ILogDepend.Companion.i(CapabilityActionResultBinder.TAG, "onJobResultRecv, enrich Recorder_Operate entity before upload");     // Catch: JsonSyntaxException -> L313
        L95:
            am r311 = r123;
            ILogDepend.Companion.i(CapabilityActionResultBinder.TAG, "onJobResultRecv, IntentExecutionRecord " + r64.getIntentName());     // Catch: JsonSyntaxException -> L313
            String r126 = r64.getIntentName();     // Catch: JsonSyntaxException -> L313
            if (r211 == 0) goto L98;
        L101:
            int r66 = 1;
        L102:
            com.obric.agent.card.weather.g r127 = com.obric.agent.card.weather.g.f14293a;     // Catch: JsonSyntaxException -> L313
            r32 = r66;
            Context r128 = (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            Gson r67 = r1.u.getGson();     // Catch: JsonSyntaxException -> L313
            d.h.b.o.c(r67, "<get-gson>(...)");     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r111);     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r112);     // Catch: JsonSyntaxException -> L313
            IntentResult<?> r216 = r64.getResult();     // Catch: JsonSyntaxException -> L313
            String r217 = r64.getIntentName();     // Catch: JsonSyntaxException -> L313
            final CapabilityActionResultBinder r68 = r1.u;     // Catch: JsonSyntaxException -> L313
            r127.a(r128, r67, r111, r112, r216, r217, new $$Lambda$CapabilityActionResultBinder$b$nK3KoWflkNyavBe_5LiHC8lDOSU(r68, r112, r64));     // Catch: JsonSyntaxException -> L313
            if ((r64.getResult().getUiType() & UiType.FLAG_REMOTE_CARD) == 0) goto L106;
            r64.getResult().getView();     // Catch: JsonSyntaxException -> L313
        L106:
            if (r64.getResult().getIntent() != null) goto L108;
        L118:
            CapabilityActionResultBinder.access$notifySuccessfulEntityDelete(r1.u, r64, r112);     // Catch: JsonSyntaxException -> L313
            if (r110 == true) goto L123;
            kotlinx.coroutines.i.a(CapabilityActionResultBinder.access$getScope$p(r1.u), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r1.u, r64, r111, r112, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: JsonSyntaxException -> L313
        L123:
            if (r64.getResult().getRet() == 201) goto L125;
            r26 = r410;
            b r218 = r1;
            r113 = r311;
            r34 = r64;
            Iterator<IntentExecutionRecord> r69 = r210;
            r22 = r215;
            r114 = r60;
            Object r70 = r47;
            r23 = r63;
            IAgentAuthService r71 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r71 == null) goto L155;
            r71.popWindowIfNeed(String.valueOf(r112.getQuestionId()), r126, r34.getResult().getRet());     // Catch: JsonSyntaxException -> L313
            d.x r72 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L155:
            r210 = r69;
            r14 = r214;
            r47 = r70;
            r1 = r218;
            r31 = r62;
            r211 = r32;
            r120 = r110;
            r119 = r126;
            r33 = r213;
            goto L151
        L327:
            r210 = r69;
            r14 = r214;
            r47 = r70;
            r1 = r218;
            r31 = r62;
            r211 = r32;
            r120 = r110;
            r119 = r126;
            r33 = r213;
            goto L151
        L125:
            if (CapabilityActionResultBinder.access$getKeyguardManager(r1.u).isDeviceLocked() == false) goto L131;
            IFlowUiIDL r73 = aw.a(aa.b(IFlowUiIDL.class));     // Catch: JsonSyntaxException -> L313
            if (r73 == null) goto L131;
            r73.handleObricAction("obric_action://chat_page.stash_window?data=%7B%22animation%22%3A%22slide%22%7D&key=aiagent_internal", "aiagent_internal", null);     // Catch: JsonSyntaxException -> L313
            d.x r74 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L131:
            if (d.h.b.o.a(r64.getIntentName(), "Messages_Delete") == false) goto L148;
            IAgentAuthService r75 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r75 == null) goto L138;
            if (r75.isKeyguardReallyLocked() != true) goto L138;
            boolean r76 = true;
        L139:
            if (r76 == false) goto L148;
            IAgentAuthService r219 = (IAgentAuthService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentAuthService.class), IAgentAuthService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r219 == null) goto L147;
            String r220 = r64.getIntentName();     // Catch: JsonSyntaxException -> L313
            String r312 = String.valueOf(r112.getQuestionId());     // Catch: JsonSyntaxException -> L313
            d.c.d r313 = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            r1.z = r311;     // Catch: JsonSyntaxException -> L313
            r1.f14162a = r112;     // Catch: JsonSyntaxException -> L313
            r1.f14163b = r111;     // Catch: JsonSyntaxException -> L313
            r1.f14164c = r63;     // Catch: JsonSyntaxException -> L313
            r1.f14165d = r28;     // Catch: JsonSyntaxException -> L313
            r1.f14166e = r24;     // Catch: JsonSyntaxException -> L313
            r1.f = r115;     // Catch: JsonSyntaxException -> L313
            r1.g = r117;     // Catch: JsonSyntaxException -> L313
            r1.h = r214;     // Catch: JsonSyntaxException -> L313
            r7 = r126;
            r1.i = r7;     // Catch: JsonSyntaxException -> L313
            r22 = r215;
            r1.j = r22;     // Catch: JsonSyntaxException -> L313
            r114 = r60;
            r1.k = r114;     // Catch: JsonSyntaxException -> L313
            Iterator<IntentExecutionRecord> r77 = r210;
            r1.l = r77;     // Catch: JsonSyntaxException -> L313
            r1.m = r64;     // Catch: JsonSyntaxException -> L313
            r113 = r311;
            int r78 = r62;
            r1.n = r78;     // Catch: JsonSyntaxException -> L313
            int r79 = r410;
            r1.o = r79;     // Catch: JsonSyntaxException -> L313
            r26 = r79;
            r1.p = r213;     // Catch: JsonSyntaxException -> L313
            r1.q = r32;     // Catch: JsonSyntaxException -> L313
            r32 = r32;
            boolean r80 = r110;
            r1.s = r80;     // Catch: JsonSyntaxException -> L313
            r110 = r80;
            r1.t = 2;     // Catch: JsonSyntaxException -> L313
            r27 = IAgentAuthService.b.a(r219, r220, r312, false, null, r313, 12, null);     // Catch: JsonSyntaxException -> L313
            b r221 = r1;
            Object r81 = r47;
            if (r27 != r81) goto L145;
            return r81;
        L145:
            r23 = r63;
            r19 = r117;
            r20 = r115;
            r45 = r221;
            r25 = r81;
            r13 = r77;
            r12 = r64;
            r14 = r214;
            r11 = r78;
            r9 = r213;
            goto L146
        L147:
            r26 = r410;
            r113 = r311;
            r34 = r64;
            r22 = r215;
            r114 = r60;
            r23 = r63;
            r14 = r214;
            r31 = r62;
            r30 = r47;
            r116 = r126;
            r1 = r1;
            r33 = r213;
        L138:
            r76 = false;
        L148:
            r26 = r410;
            r113 = r311;
            r34 = r64;
            r22 = r215;
            r114 = r60;
            r23 = r63;
            r210 = r210;
            r14 = r214;
            r31 = r62;
            r30 = r47;
            r116 = r126;
            r1 = r1;
            r33 = r213;
            goto L150
        L108:
            if (r64.getResult().getFloatingIntentParams() != null) goto L112;
            if (d.h.b.o.a(r64.getIntentName(), "System_DownloadApp") == false) goto L118;
        L112:
            if (d.h.b.o.a(r64.getIntentName(), "Office_SearchMeeting") == false) goto L115;
            if (r110 == false) goto L115;
            boolean r82 = true;
        L116:
            if (r82 == true) goto L118;
            Intent r83 = r64.getResult().getIntent();     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r83);     // Catch: JsonSyntaxException -> L313
            r83.addFlags(268435456);     // Catch: JsonSyntaxException -> L313
            Application r84 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            Intent r85 = r64.getResult().getIntent();     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r85);     // Catch: JsonSyntaxException -> L313
            ZeusTransformUtils.startActivity(r84, r85, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
        L115:
            r82 = false;
            goto L116
        L98:
            if (CapabilityActionResultBinder.access$getIntentsWithCard$p(r1.u).contains(r64.getIntentName()) == true) goto L101;
            r66 = 0;
            goto L102
        L218:
            int r222 = r62;
            d.h.b.z.f r129 = r60;
            String r86 = r115;
            int r130 = r211;
            d.h.b.z.e r131 = r24;
            String r223 = r59;
            IntentAppAction r87 = r111;
            int r88 = r410;
            String r132 = r117;
            d.h.b.z.f r133 = r129;
            String r134 = r14;
            String r135 = r124;
            ?? r136 = r125;
            int r137 = r61;
        L221:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r86, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L223;
            boolean r89 = true;
        L224:
            if (r89 == false) goto L228;
            if (r63 == null) goto L228;
            IIntentTraceService.a.a(r63, r28, "impl_result", r86, 0, 8, null);     // Catch: JsonSyntaxException -> L313
            d.x r90 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L228:
            String r138 = r134;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r138, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L231;
            boolean r91 = true;
        L232:
            if (r91 == false) goto L236;
            if (r222 == 0) goto L236;
            if (r63 == null) goto L236;
            r63.addStateParams(r28, "error_msg", r138, r88);     // Catch: JsonSyntaxException -> L313
            d.x r92 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L236:
            if (r63 == null) goto L243;
            long r93 = r131.f38503a;     // Catch: JsonSyntaxException -> L313
            if (r136 == 0) goto L240;
            boolean r139 = true;
        L241:
            r63.enterAppActionStage(r28, r93, r135, r139);     // Catch: JsonSyntaxException -> L313
            d.x r94 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
            goto L243
        L240:
            r139 = false;
        L243:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r132, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L245;
            boolean r95 = true;
        L246:
            if (r95 == false) goto L251;
            if (r63 == null) goto L251;
            IIntentTraceService.a.a(r63, r28, "result", r132, 0, 8, null);     // Catch: JsonSyntaxException -> L313
            d.x r96 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L251:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r138, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L253;
            boolean r97 = true;
        L254:
            if (r97 == false) goto L258;
            if (r222 != 0) goto L258;
            if (r63 == null) goto L258;
            r63.addStateParams(r28, "error_msg", r138, r88);     // Catch: JsonSyntaxException -> L313
            d.x r98 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L258:
            Bitmap r99 = (Bitmap) ZeusTransformUtils.preCheckCast(r133.f38504a, Bitmap.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r99 == null) goto L261;
            r87.setScreenshot(r99);     // Catch: JsonSyntaxException -> L313
            d.x r100 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L261:
            if (r222 != 0) goto L263;
            com.obric.agent.trace.n r101 = com.obric.agent.trace.n.f15582a;     // Catch: JsonSyntaxException -> L313
        L264:
            com.obric.agent.trace.n r102 = r101;
            if (r63 == null) goto L271;
            JobResult r103 = r1.x;     // Catch: JsonSyntaxException -> L313
            if (r103 == null) goto L269;
            String r104 = r103.getMessage();     // Catch: JsonSyntaxException -> L313
        L270:
            r63.onResultReceived(r28, new com.obric.agent.trace.f(r102, r104, 0, 4, null));     // Catch: JsonSyntaxException -> L313
            d.x r105 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
            goto L271
        L269:
            r104 = null;
        L271:
            ObricService r106 = ObricService.INSTANCE;     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r112);     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r87);     // Catch: JsonSyntaxException -> L313
            boolean r107 = r1.y;     // Catch: JsonSyntaxException -> L313
            JobResult r108 = r1.x;     // Catch: JsonSyntaxException -> L313
            if (r222 == 0) goto L274;
            boolean r109 = true;
        L275:
            if (r137 == 0) goto L277;
            boolean r140 = true;
        L279:
            if (r136 == 0) goto L281;
            boolean r141 = true;
        L282:
            ObricService.finishIMAction$default(r106, r112, r87, r107, r108, r109, r140, false, r141, 64, null);     // Catch: JsonSyntaxException -> L313
            if (r136 == 0) goto L316;
            JobResult r142 = r1.x;     // Catch: JsonSyntaxException -> L313
            if (r142 == null) goto L293;
            List<IntentExecutionRecord> r143 = r142.getExecRecords();     // Catch: JsonSyntaxException -> L313
            if (r143 == null) goto L293;
            int r144 = 0;
            IntentExecutionRecord r145 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.d(r143, 0), IntentExecutionRecord.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r145 == null) goto L294;
            IntentResult<?> r146 = r145.getResult();     // Catch: JsonSyntaxException -> L313
            if (r146 == null) goto L294;
            int r147 = r146.getRet();     // Catch: JsonSyntaxException -> L313
        L295:
            IOmniReportService r148 = (IOmniReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniReportService.class), IOmniReportService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r148 == null) goto L298;
            IntentAppAction r149 = r112;
            r148.recordDispatchIntentEnd(String.valueOf(r112.getQuestionId()), r135, r149, String.valueOf(r147));     // Catch: JsonSyntaxException -> L313
            d.x r150 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L299:
            if (r130 != 0) goto L316;
            if (r223 == null) goto L316;
            IIntentMetricsService r151 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r151 == null) goto L316;
            r151.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(String.valueOf(r149.getQuestionId()), r223, "call_finish", false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));     // Catch: JsonSyntaxException -> L313
            d.x r152 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
            goto L316
        L298:
            r149 = r112;
        L294:
            r147 = r144;
        L293:
            r144 = 0;
        L316:
            return d.x.f38692a;
        L281:
            r141 = false;
            goto L282
        L277:
            r140 = false;
            goto L279
        L274:
            r109 = false;
            goto L275
        L263:
            r101 = com.obric.agent.trace.n.f15585d;     // Catch: JsonSyntaxException -> L313
            goto L264
        L253:
            r97 = false;
            goto L254
        L245:
            r95 = false;
            goto L246
        L231:
            r91 = false;
            goto L232
        L223:
            r89 = false;
        L212:
            th = move-exception;
            throw th;     // Catch: JsonSyntaxException -> L313
        L216:
            com.obric.agent.utils.b r153 = com.obric.agent.utils.b.f15994a;     // Catch: JsonSyntaxException -> L313
            d.h.b.o.a(r111);     // Catch: JsonSyntaxException -> L313
            r153.a(r111);     // Catch: JsonSyntaxException -> L313
            d.x r154 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
            goto L217
        L202:
            r122 = false;
            goto L203
        L196:
            r51 = 0;
            goto L197
        L189:
            r42 = 0;
            goto L190
        L321:
            d.n.a r155 = d.n.f38560a;     // Catch: Throwable -> L179
            r40 = r120;
            r41 = r121;
            r24.f38503a += Long.parseLong(r39);     // Catch: Throwable -> L177
            Object r156 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L177
        L183:
            d.n.g(r156);     // Catch: JsonSyntaxException -> L313
        L177:
            th = th;
        L181:
            Throwable r157 = th;
            d.n.a r158 = d.n.f38560a;     // Catch: JsonSyntaxException -> L313
            r156 = d.n.f(d.o.a(r157));     // Catch: JsonSyntaxException -> L313
        L179:
            th = th;
            r40 = r120;
            r41 = r121;
            goto L181
        L184:
            r212 = r33;
            goto L185
        L166:
            r37 = false;
            goto L167
        L159:
            r36 = false;
            goto L161
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            boolean r159 = r1.s;
            int r160 = r1.r;
            int r161 = r1.q;
            int r162 = r1.p;
            int r163 = r1.o;
            int r164 = r1.n;
            d.h.b.z.f r165 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(r1.j, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            String r166 = (String) ZeusTransformUtils.preCheckCast(r1.i, String.class, "com.obric.aiagent.plugin");
            String r167 = (String) ZeusTransformUtils.preCheckCast(r1.h, String.class, "com.obric.aiagent.plugin");
            String r168 = (String) ZeusTransformUtils.preCheckCast(r1.g, String.class, "com.obric.aiagent.plugin");
            String r169 = (String) ZeusTransformUtils.preCheckCast(r1.f, String.class, "com.obric.aiagent.plugin");
            d.h.b.z.e r170 = (d.h.b.z.e) ZeusTransformUtils.preCheckCast(r1.f14166e, d.h.b.z.e.class, "com.obric.aiagent.plugin");
            String r171 = (String) ZeusTransformUtils.preCheckCast(r1.f14165d, String.class, "com.obric.aiagent.plugin");
            IIntentTraceService r172 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(r1.f14164c, IIntentTraceService.class, "com.obric.aiagent.plugin");
            IntentAppAction r173 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.f14163b, IntentAppAction.class, "com.obric.aiagent.plugin");
            IntentAppAction r174 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.f14162a, IntentAppAction.class, "com.obric.aiagent.plugin");
            am r175 = (am) ZeusTransformUtils.preCheckCast(r1.z, am.class, "com.obric.aiagent.plugin");
            d.o.a(r46);     // Catch: JsonSyntaxException -> L313
            String r176 = r166;
            boolean r177 = r159;
            int r178 = r162;
            String r179 = r167;
            IIntentTraceService r180 = r172;
            int r181 = r163;
            r117 = r168;
            am r182 = r175;
            int r183 = r164;
            r211 = r160;
            IntentAppAction r184 = r174;
            Object r224 = r2;
            Object r185 = r46;
            int r186 = r161;
            IntentAppAction r187 = r173;
            String r225 = r169;
            d.h.b.z.f r188 = r165;
        L32:
            r184 = r184;
            if (((Boolean) ZeusTransformUtils.preCheckCast(r185, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() != true) goto L35;
            boolean r226 = true;
        L36:
            r137 = r178;
            String r189 = r176;
            int r190 = r181;
            String r191 = r179;
            int r192 = r186;
            r60 = r188;
            r115 = r225;
        L38:
            if (r226 == true) goto L304;
            boolean r411 = r177;
            am r227 = r182;
            IntentAppAction r228 = r187;
            IAgentService r193 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r193 != null) goto L42;
        L44:
            boolean r194 = false;
        L45:
            if (r194 == true) goto L304;
            if (r1.x == null) goto L219;
            boolean r195 = CapabilityActionResultBinder.access$isLocalIntent(r1.u, r184);     // Catch: JsonSyntaxException -> L313
            String r229 = r171;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r1.x.getExecRecords(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L67;
            Iterable r196 = (Iterable) ZeusTransformUtils.preCheckCast(r1.x.getExecRecords(), Iterable.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            CapabilityActionResultBinder r197 = r1.u;     // Catch: JsonSyntaxException -> L313
            if (ZeusTransformUtils.instanceOf(r196, Collection.class) == false) goto L56;
            d.h.b.z.e r230 = r170;
            if (((Collection) ZeusTransformUtils.preCheckCast(r196, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == true) goto L64;
        L57:
            Iterator r198 = r196.iterator();     // Catch: JsonSyntaxException -> L313
        L59:
            if (r198.hasNext() == false) goto L64;
            Iterator r199 = r198;
            if (CapabilityActionResultBinder.access$isPolicyNoReplyIntent(r197, ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r198.next(), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getIntentName()) == false) goto L62;
            r198 = r199;
            goto L59
        L62:
            boolean r200 = false;
        L65:
            if (r200 == false) goto L68;
            int r201 = 1;
        L69:
            IntentExecutionRecord r202 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.p(r1.x.getExecRecords()), IntentExecutionRecord.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r202 == null) goto L77;
            CapabilityActionResultBinder r203 = r1.u;     // Catch: JsonSyntaxException -> L313
            String r204 = r202.getIntentName();     // Catch: JsonSyntaxException -> L313
            if (r195 == false) goto L74;
            boolean r205 = true;
        L75:
            String r206 = CapabilityActionResultBinder.access$noReplyTerminalReason(r203, r204, r205);     // Catch: JsonSyntaxException -> L313
            if (r206 == null) goto L77;
        L86:
            r210 = r1.x.getExecRecords().iterator();     // Catch: JsonSyntaxException -> L313
            r59 = r206;
            r14 = r191;
            r62 = r183;
            r125 = r192 == true ? 1 : 0;
            r47 = r224;
            r24 = r230;
            r110 = r411;
            r112 = r184;
            r124 = r189;
            r410 = r190;
            r123 = r227;
            r111 = r228;
            r28 = r229;
            IIntentTraceService r412 = r180;
            r61 = r201;
            r63 = r412;
            goto L88
        L74:
            r205 = false;
        L77:
            r206 = "no_reply_expected";
            if (r195 == true) goto L82;
            if (r201 != 0) goto L82;
            boolean r207 = false;
        L83:
            if (r207 == true) goto L86;
            r206 = null;
        L82:
            r207 = true;
        L68:
            r201 = 0;
        L64:
            r200 = true;
            goto L65
        L56:
            r230 = r170;
            goto L57
        L67:
            r230 = r170;
            goto L68
        L219:
            d.h.b.z.e r231 = r170;
            r63 = r180;
            r88 = r190;
            r130 = r211;
            r87 = r228;
            r223 = null;
            r132 = r117;
            r133 = r60;
            r86 = r115;
            r131 = r231;
            r222 = r183;
            r112 = r184;
            r28 = r171;
            String r413 = r191;
            r135 = r189;
            r134 = r413;
            r136 = r192;
            goto L221
        L42:
            if (r193.isQueryTimeout(String.valueOf(r184.getQuestionId())) != true) goto L44;
            r194 = true;
        L304:
            ILogDepend.Companion.e(CapabilityActionResultBinder.TAG, r184.getQuestionId() + " query interrupted, abort job result");     // Catch: JsonSyntaxException -> L313
            if (r180 == null) goto L308;
            r180.onMessageInterrupt(String.valueOf(r184.getQuestionId()));     // Catch: JsonSyntaxException -> L313
            d.x r208 = d.x.f38692a;     // Catch: JsonSyntaxException -> L313
        L308:
            return d.x.f38692a;
        L35:
            r226 = false;
            goto L36
        L14:
            d.o.a(r46);
            r182 = (am) ZeusTransformUtils.preCheckCast(r1.z, am.class, "com.obric.aiagent.plugin");
            r184 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.u.getGson().fromJson(r1.v, IntentAppAction.class), IntentAppAction.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            Object r209 = CapabilityActionResultBinder.access$getRequestLock$p(r1.u);     // Catch: JsonSyntaxException -> L313
            CapabilityActionResultBinder r232 = r1.u;     // Catch: JsonSyntaxException -> L313
            monitor-enter(r209);     // Catch: JsonSyntaxException -> L313
            Map r233 = (Map) ZeusTransformUtils.preCheckCast(CapabilityActionResultBinder.access$getRequestIntentRecordMap$p(r232), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L309
            Long r234 = d.c.b.a.b.a(r184.getQuestionId());     // Catch: Throwable -> L309
            Object r235 = r233.get(r234);     // Catch: Throwable -> L309
            if (r235 != null) goto L20;
            r235 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L309
            r233.put(r234, r235);     // Catch: Throwable -> L309
        L20:
            List r236 = (List) ZeusTransformUtils.preCheckCast(r235, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L309
            d.h.b.o.a(r184);     // Catch: Throwable -> L309
            r236.add(r184);     // Catch: Throwable -> L309
            monitor-exit(r209);     // Catch: JsonSyntaxException -> L313
            r187 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r1.u.getGson().fromJson(r1.w, IntentAppAction.class), IntentAppAction.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            r187.setId(r184.getId());     // Catch: JsonSyntaxException -> L313
            r180 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            r171 = String.valueOf(r184.getQuestionId());     // Catch: JsonSyntaxException -> L313
            r170 = new d.h.b.z.e();     // Catch: JsonSyntaxException -> L313
            r115 = "";
            r117 = "";
            r191 = "";
            r189 = "";
            r60 = new d.h.b.z.f();     // Catch: JsonSyntaxException -> L313
            ConcurrentHashMap<String, String> r1100 = r184.getExt();     // Catch: JsonSyntaxException -> L313
            if (r1100 == null) goto L25;
            String r237 = (String) ZeusTransformUtils.preCheckCast(r1100.get("o_task_type"), String.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
        L26:
            boolean r238 = d.h.b.o.a(r237, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);     // Catch: JsonSyntaxException -> L313
            IAgentService r239 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            if (r239 == null) goto L37;
            String r1101 = String.valueOf(r184.getQuestionId());     // Catch: JsonSyntaxException -> L313
            d.c.d<? super Boolean> r240 = (d.c.d) ZeusTransformUtils.preCheckCast(r1, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: JsonSyntaxException -> L313
            r1.z = r182;     // Catch: JsonSyntaxException -> L313
            r1.f14162a = r184;     // Catch: JsonSyntaxException -> L313
            r1.f14163b = r187;     // Catch: JsonSyntaxException -> L313
            r1.f14164c = r180;     // Catch: JsonSyntaxException -> L313
            r1.f14165d = r171;     // Catch: JsonSyntaxException -> L313
            r1.f14166e = r170;     // Catch: JsonSyntaxException -> L313
            r1.f = "";     // Catch: JsonSyntaxException -> L313
            r1.g = "";     // Catch: JsonSyntaxException -> L313
            r1.h = "";     // Catch: JsonSyntaxException -> L313
            r1.i = "";     // Catch: JsonSyntaxException -> L313
            r1.j = r60;     // Catch: JsonSyntaxException -> L313
            r1.n = 0;     // Catch: JsonSyntaxException -> L313
            r1.o = 0;     // Catch: JsonSyntaxException -> L313
            r1.p = 0;     // Catch: JsonSyntaxException -> L313
            r1.q = 0;     // Catch: JsonSyntaxException -> L313
            r1.r = 0;     // Catch: JsonSyntaxException -> L313
            r177 = r238;
            r1.s = r177;     // Catch: JsonSyntaxException -> L313
            r1.t = 1;     // Catch: JsonSyntaxException -> L313
            r185 = r239.isQueryInterrupt(r1101, r240);     // Catch: JsonSyntaxException -> L313
            if (r185 != r2) goto L31;
            return r2;
        L31:
            r224 = r2;
            r171 = r171;
            r170 = r170;
            r176 = "";
            r179 = "";
            r117 = "";
            r225 = "";
            r211 = 0;
            r178 = 0;
            r181 = 0;
            r183 = 0;
            r182 = r182;
            r188 = r60;
            r186 = 0;
            goto L32
        L37:
            r224 = r2;
            r177 = r238;
            r190 = 0;
            r183 = 0;
            r192 = 0;
            r137 = 0;
            r211 = 0;
            r226 = false;
            goto L38
        L25:
            r237 = null;
            goto L26
        L309:
            th = move-exception;
            throw th;     // Catch: JsonSyntaxException -> L313
        L313:
            e = move-exception;
            ILogDepend.Companion.e(CapabilityActionResultBinder.TAG, "onActionResultRecv fromJson failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L316
        }

        private static final String a(CapabilityActionResultBinder r1, IntentAppAction r2, IntentExecutionRecord r3) {
            d.h.b.o.a(r2);
            return CapabilityActionResultBinder.access$createActionResultLite(r1, r2, r3.getResult(), r3.getIntentName());
        }
    }

    /* JADX INFO: compiled from: CapabilityActionResultBinder.kt */
    @d.c.b.a.f(b = "CapabilityActionResultBinder.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.CapabilityActionResultBinder$onUpdateIntentResultWithRequest$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CapabilityActionResultBinder f14173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f14174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IntentResult<?> f14175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f14176e;
        final /* synthetic */ Map<?, ?> f;

        c(CapabilityActionResultBinder r3, String r4, IntentResult<?> r5, boolean r6, Map<?, ?> r7, d.c.d<? super c> r8) {
            Map<?, ?> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14173b = r3;
            this.f14174c = r4;
            this.f14175d = r5;
            this.f14176e = r6;
            this.f = r9;
            super(2, r10);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14173b, this.f14174c, this.f14175d, this.f14176e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r28) {
            d.c.a.b.a();
            if (this.f14172a != 0) goto L131;
            d.o.a(r28);
            Long r2 = null;
            IntentAppAction r0 = (IntentAppAction) ZeusTransformUtils.preCheckCast(this.f14173b.getGson().fromJson(this.f14174c, IntentAppAction.class), IntentAppAction.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L117 Exception -> L119
            Long r10 = com.obric.agent.trace.toolmetrics.c.f15872a.a(r0, this.f14175d);     // Catch: Throwable -> L117 Exception -> L119
            CapabilityActionResultBinder.access$normalizeEntityOrderIfNeeded(this.f14173b, this.f14175d);     // Catch: Exception -> L115 Throwable -> L125
            ILogDepend.Companion.i(CapabilityActionResultBinder.TAG, "onUpdateIntentResultWithRequest, isFinal=" + this.f14175d.isFinal());     // Catch: Exception -> L115 Throwable -> L125
            IAgentService r3 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            if (r3 == null) goto L9;
            boolean r4 = r3.handleUpdateIntentResult(r0.getQuestionId(), this.f14175d, this.f14176e, this.f, r0);     // Catch: Exception -> L115 Throwable -> L125
        L10:
            if (r4 == false) goto L14;
            d.x r1 = d.x.f38692a;     // Catch: Exception -> L115 Throwable -> L125
            com.obric.agent.trace.toolmetrics.c.f15872a.a(r10, this.f14175d, null);
            return r1;
        L14:
            Map<?, ?> r5 = this.f;     // Catch: Exception -> L115 Throwable -> L125
            if (r5 == null) goto L17;
            Object r6 = r5.get(Ext.KEY_INTENT_NAME);     // Catch: Exception -> L115 Throwable -> L125
        L19:
            if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L21;
            String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
        L23:
            if (this.f14175d.isFinal() == false) goto L137;
            if (r7 == null) goto L137;
            ConcurrentHashMap<String, String> r8 = r0.getExt();     // Catch: Throwable -> L91 Exception -> L115
            if (r8 == null) goto L29;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get(CapabilityActionResultBinder.EXT_TO_SERVER), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
        L30:
            boolean r11 = d.h.b.o.a(r9, "false");     // Catch: Throwable -> L91 Exception -> L115
            com.obric.agent.trace.l r12 = com.obric.agent.trace.l.f15525a;     // Catch: Throwable -> L91 Exception -> L115
            if (r11 == false) goto L33;
            boolean r13 = true;
        L34:
            String r24 = r12.a(r7, r13);     // Catch: Throwable -> L91 Exception -> L115
            com.obric.agent.trace.l r14 = com.obric.agent.trace.l.f15525a;     // Catch: Throwable -> L91 Exception -> L115
            if (r11 == false) goto L37;
            boolean r15 = true;
        L38:
            boolean r16 = r14.b(r7, r15);     // Catch: Throwable -> L91 Exception -> L115
            IIntentMetricsService r17 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L91 Exception -> L115
            if (r17 == null) goto L81;
            String r18 = String.valueOf(r0.getQuestionId());     // Catch: Throwable -> L91 Exception -> L115
            Map<?, ?> r19 = this.f;     // Catch: Throwable -> L91 Exception -> L115
            if (r19 == null) goto L44;
            Object r20 = r19.get(Ext.KEY_JOB_ID);     // Catch: Exception -> L115 Throwable -> L125
        L46:
            if (ZeusTransformUtils.instanceOf(r20, String.class) == true) goto L48;
            String r110 = null;
        L50:
            Map<?, ?> r21 = this.f;     // Catch: Throwable -> L91 Exception -> L115
            if (r21 == null) goto L54;
            Object r22 = r21.get(Ext.KEY_ACTION_ID);     // Catch: Exception -> L115 Throwable -> L125
        L56:
            if (ZeusTransformUtils.instanceOf(r22, String.class) == true) goto L58;
            String r111 = null;
        L60:
            CapabilityActionResultBinder r23 = this.f14173b;     // Catch: Throwable -> L91 Exception -> L115
            ConcurrentHashMap<String, String> r112 = this.f14175d.getExt();     // Catch: Throwable -> L91 Exception -> L115
            if (r112 == null) goto L64;
            String r25 = (String) ZeusTransformUtils.preCheckCast(r112.get("package_name"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            if (r25 == null) goto L64;
        L69:
            String r113 = CapabilityActionResultBinder.access$resolveAppName(r23, r25);     // Catch: Throwable -> L91 Exception -> L115
            Integer r114 = d.c.b.a.b.a(this.f14175d.getRet());     // Catch: Throwable -> L91 Exception -> L115
            ConcurrentHashMap<String, String> r26 = this.f14175d.getExt();     // Catch: Throwable -> L91 Exception -> L115
            if (r26 == null) goto L75;
            String r27 = (String) ZeusTransformUtils.preCheckCast(r26.get("app_cost"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            if (r27 == null) goto L75;
            Long r29 = d.o.o.e(r27);     // Catch: Exception -> L115 Throwable -> L125
        L76:
            boolean r210 = CapabilityActionResultBinder.access$isOmniTask(this.f14173b, this.f, (Map) ZeusTransformUtils.preCheckCast(r0.getExt(), Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(this.f14175d.getExt(), Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L91 Exception -> L115
            boolean r211 = CapabilityActionResultBinder.access$isContinuousTalk(this.f14173b, this.f, (Map) ZeusTransformUtils.preCheckCast(r0.getExt(), Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L91 Exception -> L115
            if (r16 == false) goto L79;
            boolean r212 = true;
        L80:
            r17.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.b(r18, r7, r110, r111, r113, r114, true, null, r29, r210, r211, r24, r11, r212), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L91 Exception -> L115
            goto L81
        L79:
            r212 = false;
        L75:
            r29 = null;
        L64:
            ConcurrentHashMap<String, String> r30 = r0.getExt();     // Catch: Throwable -> L91 Exception -> L115
            if (r30 == null) goto L68;
            r25 = (String) ZeusTransformUtils.preCheckCast(r30.get("package_name"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            goto L69
        L68:
            r25 = null;
            goto L69
        L58:
            r111 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            goto L60
        L54:
            r22 = null;
            goto L56
        L48:
            r110 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L115 Throwable -> L125
            goto L50
        L44:
            r20 = null;
        L81:
            CapabilityActionResultBinder r31 = this.f14173b;     // Catch: Throwable -> L91 Exception -> L115
            if (r11 == false) goto L84;
            boolean r115 = true;
        L85:
            String r116 = CapabilityActionResultBinder.access$noReplyTerminalReason(r31, r7, r115);     // Catch: Throwable -> L91 Exception -> L115
            if (r116 == null) goto L137;
            IIntentMetricsService r32 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L91 Exception -> L115
            if (r32 == null) goto L137;
            r32.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(String.valueOf(r0.getQuestionId()), r116, "call_finish", false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L91 Exception -> L115
            goto L137
        L84:
            r115 = false;
            goto L85
        L37:
            r15 = false;
            goto L38
        L33:
            r13 = false;
            goto L34
        L29:
            r9 = null;
        L91:
            th = th;
            r2 = r10;
            Exception r33 = null;
        L128:
            com.obric.agent.trace.toolmetrics.c.f15872a.a(r2, this.f14175d, r33);
            throw th;
        L137:
        L113:
            th = th;
            r33 = null;
        L127:
            r2 = r10;
            goto L128
        L94:
            if (CapabilityActionResultBinder.access$reportOAutoStepToComplexTaskServer(this.f14173b, r0, this.f14175d, String.valueOf(r7)) == false) goto L99;
            d.x r34 = d.x.f38692a;     // Catch: Throwable -> L91 Exception -> L115
            com.obric.agent.trace.toolmetrics.c.f15872a.a(r10, this.f14175d, null);
            return r34;
        L99:
            if (w.a(this.f14175d.getDetails()) == false) goto L101;
        L102:
            Object r35 = CapabilityActionResultBinder.access$getRequestLock$p(this.f14173b);     // Catch: Throwable -> L113 Exception -> L115
            CapabilityActionResultBinder r36 = this.f14173b;     // Catch: Throwable -> L113 Exception -> L115
            IntentResult<?> r37 = this.f14175d;     // Catch: Throwable -> L113 Exception -> L115
            Map<?, ?> r38 = this.f;     // Catch: Throwable -> L113 Exception -> L115
            monitor-enter(r35);     // Catch: Throwable -> L113 Exception -> L115
            CapabilityActionResultBinder.access$processSendToServer(r36, r0, r37, String.valueOf(r7), r38, CapabilityActionResultBinder.access$isPolicyNoReplyIntent(r36, String.valueOf(r7)));     // Catch: Throwable -> L107
            d.x r39 = d.x.f38692a;     // Catch: Throwable -> L107
            monitor-exit(r35);     // Catch: Throwable -> L113 Exception -> L115
        L106:
            com.obric.agent.trace.toolmetrics.c.f15872a.a(r10, this.f14175d, null);
        L124:
            return d.x.f38692a;
        L107:
            th = move-exception;
            r33 = null;
        L111:
            th = th;
            goto L127
        L110:
            throw th;     // Catch: Throwable -> L111 Exception -> L115
        L101:
            if (d.h.b.o.a(r7, "Phone_ProxyCall") == false) goto L106;
        L21:
            r7 = null;
            goto L23
        L17:
            r6 = null;
            goto L19
        L9:
            r4 = false;
        L115:
            e = move-exception;
            Exception r40 = e;
        L121:
            ILogDepend.Companion r41 = ILogDepend.Companion;     // Catch: Throwable -> L125
            StringBuilder r42 = new StringBuilder().append("onUpdateIntentResultWithRequest ").append(r40).append(' ');     // Catch: Throwable -> L125
            r40.printStackTrace();     // Catch: Throwable -> L125
            r41.e(CapabilityActionResultBinder.TAG, r42.append(d.x.f38692a).toString());     // Catch: Throwable -> L125
            com.obric.agent.trace.toolmetrics.c.f15872a.a(r10, this.f14175d, r40);
            goto L124
        L125:
            th = th;
            r33 = null;
        L119:
            e = move-exception;
            r40 = e;
            r10 = null;
        L117:
            th = th;
            r33 = null;
            goto L128
        L131:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ KeyguardManager lambda$2lAtVWJ0UQ1su5gBJp0CtBml8vA() {
        return keyguardManager_delegate$lambda$1();
    }

    public static /* synthetic */ Thread lambda$7VPEk0HQhsUPIehBPmJzrP1GHuk(Runnable r0) {
        return scope$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$8Uu7Odv-OhhsVBziLkZQfLpg_YA, reason: not valid java name */
    public static /* synthetic */ Comparable m58lambda$8Uu7OdvOhhsVBziLkZQfLpg_YA(AlarmEntity r0) {
        return normalizeEntityOrderIfNeeded$lambda$16(r0);
    }

    /* JADX INFO: renamed from: lambda$TW-AcmWA_bzjtFmXD6CauHR3xm4, reason: not valid java name */
    public static /* synthetic */ Comparable m59lambda$TWAcmWA_bzjtFmXD6CauHR3xm4(AlarmEntity r0) {
        return normalizeEntityOrderIfNeeded$lambda$15(r0);
    }

    /* JADX INFO: renamed from: lambda$eOylzBxFxuo8bLKjI7f-GeGmbC8, reason: not valid java name */
    public static /* synthetic */ Gson m60lambda$eOylzBxFxuo8bLKjI7fGeGmbC8() {
        return gson_delegate$lambda$0();
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public boolean isCardViewVisible(long r1) {
        return false;
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onFinishFloatingActivity(long r1) {
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onHideIntentResultCard(long r1) {
    }

    public CapabilityActionResultBinder() {
        this.gson$delegate = d.g.a($$Lambda$CapabilityActionResultBinder$eOylzBxFxuo8bLKjI7fGeGmbC8.INSTANCE);
        this.requestIntentRecordMap = new o(10, false, 2, null);
        this.requestLock = new Object();
        this.keyguardManager$delegate = d.g.a($$Lambda$CapabilityActionResultBinder$2lAtVWJ0UQ1su5gBJp0CtBml8vA.INSTANCE);
        this.intentsWithCard = loadSearchIntentsFromXml((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$CapabilityActionResultBinder$7VPEk0HQhsUPIehBPmJzrP1GHuk.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        this.scope = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$createActionResultLite(CapabilityActionResultBinder r0, IntentAppAction r1, IntentResult r2, String r3) {
        return r0.createActionResultLite(r1, r2, r3);
    }

    public static final /* synthetic */ Set access$getIntentsWithCard$p(CapabilityActionResultBinder r0) {
        return r0.intentsWithCard;
    }

    public static final /* synthetic */ KeyguardManager access$getKeyguardManager(CapabilityActionResultBinder r0) {
        return r0.getKeyguardManager();
    }

    public static final /* synthetic */ o access$getRequestIntentRecordMap$p(CapabilityActionResultBinder r0) {
        return r0.requestIntentRecordMap;
    }

    public static final /* synthetic */ Object access$getRequestLock$p(CapabilityActionResultBinder r0) {
        return r0.requestLock;
    }

    public static final /* synthetic */ am access$getScope$p(CapabilityActionResultBinder r0) {
        return r0.scope;
    }

    public static final /* synthetic */ void access$handleIntentMessageCard(CapabilityActionResultBinder r0, IntentExecutionRecord r1, IntentAppAction r2, IntentAppAction r3) {
        r0.handleIntentMessageCard(r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$isContinuousTalk(CapabilityActionResultBinder r2, Map r3, Map r4) {
        return r2.isContinuousTalk((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$isLocalIntent(CapabilityActionResultBinder r0, IntentAppAction r1) {
        return r0.isLocalIntent(r1);
    }

    public static final /* synthetic */ boolean access$isOmniTask(CapabilityActionResultBinder r2, Map r3, Map r4, Map r5) {
        return r2.isOmniTask((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean access$isPolicyNoReplyIntent(CapabilityActionResultBinder r0, String r1) {
        return r0.isPolicyNoReplyIntent(r1);
    }

    public static final /* synthetic */ String access$noReplyTerminalReason(CapabilityActionResultBinder r0, String r1, boolean r2) {
        return r0.noReplyTerminalReason(r1, r2);
    }

    public static final /* synthetic */ void access$normalizeEntityOrderIfNeeded(CapabilityActionResultBinder r0, IntentResult r1) {
        r0.normalizeEntityOrderIfNeeded(r1);
    }

    public static final /* synthetic */ void access$notifySuccessfulEntityDelete(CapabilityActionResultBinder r0, IntentExecutionRecord r1, IntentAppAction r2) {
        r0.notifySuccessfulEntityDelete(r1, r2);
    }

    public static final /* synthetic */ void access$processSendToServer(CapabilityActionResultBinder r6, IntentAppAction r7, IntentResult r8, String r9, Map r10, boolean r11) {
        r6.processSendToServer(r7, r8, r9, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin"), r11);
    }

    public static final /* synthetic */ boolean access$reportOAutoStepToComplexTaskServer(CapabilityActionResultBinder r0, IntentAppAction r1, IntentResult r2, String r3) {
        return r0.reportOAutoStepToComplexTaskServer(r1, r2, r3);
    }

    public static final /* synthetic */ String access$resolveAppName(CapabilityActionResultBinder r0, String r1) {
        return r0.resolveAppName(r1);
    }

    public final Gson getGson() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.gson$delegate.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(this.keyguardManager$delegate.b(), KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$1() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        d.h.b.o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final Thread scope$lambda$2(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "feedback-dispatcher");
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onActionResultRecv(String r1, String r2, boolean r3) {
        ILogDepend.Companion.i(TAG, "onActionResultRecv");
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onUpdateIntentResultWithRequest(String r15, IntentResult<?> r16, boolean r17, Map<?, ?> r18) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "intentResult");
        kotlinx.coroutines.i.a(this.scope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r15, r16, r17, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x02ed: MOVE (r10 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:125:0x02eb */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onUpdateIntentResult(long r29, IntentResult<?> r31, boolean r32, Map<?, ?> r33) {
        Map<?, ?> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r33, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r31, "intentResult");
        Long r10 = null;
        Exception r11 = null;
        ISecureLogDepend.Companion.i(TAG, "onUpdateIntentResult " + r9);     // Catch: Throwable -> L116 Exception -> L118
        normalizeEntityOrderIfNeeded(r31);     // Catch: Throwable -> L116 Exception -> L118
        if (r9 == null) goto L6;
        Object r1 = r9.get(Ext.KEY_REQUEST);     // Catch: Throwable -> L116 Exception -> L118
    L8:
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L116 Exception -> L118
    L11:
        if (r2 == null) goto L13;
        IntentAppAction r3 = (IntentAppAction) ZeusTransformUtils.preCheckCast(getGson().fromJson(r2, IntentAppAction.class), IntentAppAction.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L116 Exception -> L118
    L14:
        if (r3 != null) goto L27;
        Object r4 = this.requestLock;     // Catch: Throwable -> L116 Exception -> L118
        monitor-enter(r4);     // Catch: Throwable -> L116 Exception -> L118
        List r5 = (List) ZeusTransformUtils.preCheckCast(this.requestIntentRecordMap.get(Long.valueOf(r29)), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r5 == null) goto L21;
        IntentAppAction r6 = (IntentAppAction) ZeusTransformUtils.preCheckCast(d.a.p.l(r5), IntentAppAction.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L22:
        monitor-exit(r4);     // Catch: Throwable -> L116 Exception -> L118
        IntentAppAction r12 = r6;
    L28:
        Long r13 = com.obric.agent.trace.toolmetrics.c.f15872a.a(r12, r31);     // Catch: Throwable -> L116 Exception -> L118
        IAgentService r7 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
        if (r7 == null) goto L33;
        boolean r8 = r7.handleUpdateIntentResult(r29, r31, r32, r9, r12);     // Catch: Exception -> L114 Throwable -> L124
    L34:
        if (r8 == false) goto L37;
    L35:
        com.obric.agent.trace.toolmetrics.c.f15872a.a(r13, r31, null);
        return;
    L37:
        if (r9 == null) goto L39;
        Object r14 = r9.get(Ext.KEY_INTENT_NAME);     // Catch: Exception -> L114 Throwable -> L124
    L41:
        if (ZeusTransformUtils.instanceOf(r14, String.class) == false) goto L43;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
    L45:
        if (r31.isFinal() == false) goto L97;
        if (r15 == null) goto L97;
        if (r12 == null) goto L51;
        ConcurrentHashMap<String, String> r16 = r12.getExt();     // Catch: Exception -> L114 Throwable -> L124
        if (r16 == null) goto L51;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r16.get(EXT_TO_SERVER), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
    L52:
        boolean r18 = d.h.b.o.a(r17, "false");     // Catch: Exception -> L114 Throwable -> L124
        String r25 = com.obric.agent.trace.l.f15525a.a(r15, r18);     // Catch: Exception -> L114 Throwable -> L124
        boolean r27 = com.obric.agent.trace.l.f15525a.b(r15, r18);     // Catch: Exception -> L114 Throwable -> L124
        IIntentMetricsService r19 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
        if (r19 == null) goto L92;
        String r110 = String.valueOf(r29);     // Catch: Exception -> L114 Throwable -> L124
        if (r9 == null) goto L57;
        Object r20 = r9.get(Ext.KEY_JOB_ID);     // Catch: Exception -> L114 Throwable -> L124
    L59:
        if (ZeusTransformUtils.instanceOf(r20, String.class) == false) goto L61;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r20, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
    L62:
        if (r9 == null) goto L64;
        Object r21 = r9.get(Ext.KEY_ACTION_ID);     // Catch: Exception -> L114 Throwable -> L124
    L66:
        if (ZeusTransformUtils.instanceOf(r21, String.class) == false) goto L68;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
    L69:
        ConcurrentHashMap<String, String> r22 = r31.getExt();     // Catch: Exception -> L114 Throwable -> L124
        if (r22 == null) goto L73;
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.get("package_name"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
        if (r23 == null) goto L73;
    L78:
        String r113 = resolveAppName(r23);     // Catch: Exception -> L114 Throwable -> L124
        Integer r114 = Integer.valueOf(r31.getRet());     // Catch: Exception -> L114 Throwable -> L124
        ConcurrentHashMap<String, String> r24 = r31.getExt();     // Catch: Exception -> L114 Throwable -> L124
        if (r24 == null) goto L83;
        String r26 = (String) ZeusTransformUtils.preCheckCast(r24.get("app_cost"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
        if (r26 == null) goto L83;
        Long r28 = d.o.o.e(r26);     // Catch: Exception -> L114 Throwable -> L124
    L84:
        if (r12 == null) goto L86;
        ConcurrentHashMap<String, String> r30 = r12.getExt();     // Catch: Exception -> L114 Throwable -> L124
    L87:
        boolean r210 = isOmniTask(r9, (Map) ZeusTransformUtils.preCheckCast(r30, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r31.getExt(), Map.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L114 Throwable -> L124
        if (r12 == null) goto L90;
        ConcurrentHashMap<String, String> r34 = r12.getExt();     // Catch: Exception -> L114 Throwable -> L124
    L91:
        r19.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.b(r110, r15, r111, r112, r113, r114, true, null, r28, r210, isContinuousTalk(r9, (Map) ZeusTransformUtils.preCheckCast(r34, Map.class, "com.obric.aiagent.plugin")), r25, r18, r27), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L114 Throwable -> L124
        goto L92
    L90:
        r34 = null;
        goto L91
    L86:
        r30 = null;
    L83:
        r28 = null;
    L73:
        if (r12 == null) goto L77;
        ConcurrentHashMap<String, String> r35 = r12.getExt();     // Catch: Exception -> L114 Throwable -> L124
        if (r35 == null) goto L77;
        r23 = (String) ZeusTransformUtils.preCheckCast(r35.get("package_name"), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
    L77:
        r23 = null;
        goto L78
    L68:
        r112 = null;
        goto L69
    L64:
        r21 = null;
        goto L66
    L61:
        r111 = null;
        goto L62
    L57:
        r20 = null;
    L92:
        String r115 = noReplyTerminalReason(r15, r18);     // Catch: Exception -> L114 Throwable -> L124
        if (r115 == null) goto L97;
        IIntentMetricsService r36 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L114 Throwable -> L124
        if (r36 == null) goto L97;
        r36.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(String.valueOf(r29), r115, "call_finish", false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L114 Throwable -> L124
    L51:
        r17 = null;
    L97:
        Object r37 = this.requestLock;     // Catch: Exception -> L114 Throwable -> L124
        monitor-enter(r37);     // Catch: Exception -> L114 Throwable -> L124
    L111:
        th = move-exception;
        throw th;     // Catch: Exception -> L114 Throwable -> L124
    L100:
        if (reportOAutoStepToComplexTaskServer(r12, r31, String.valueOf(r15)) == false) goto L104;
        monitor-exit(r37);     // Catch: Exception -> L114 Throwable -> L124
        goto L35
    L104:
        if (w.a(r31.getDetails()) == false) goto L106;
    L107:
        processSendToServer(r12, r31, String.valueOf(r15), r9, isPolicyNoReplyIntent(String.valueOf(r15)));     // Catch: Throwable -> L111
    L108:
        d.x r0 = d.x.f38692a;     // Catch: Throwable -> L111
        monitor-exit(r37);     // Catch: Exception -> L114 Throwable -> L124
    L122:
        com.obric.agent.trace.toolmetrics.c.f15872a.a(r13, r31, r11);
        return;
    L106:
        if (d.h.b.o.a(r15, "Phone_ProxyCall") == false) goto L108;
    L43:
        r15 = null;
        goto L45
    L39:
        r14 = null;
        goto L41
    L33:
        r8 = false;
    L114:
        e = e;
    L120:
        r11 = e;
        ILogDepend.Companion r38 = ILogDepend.Companion;     // Catch: Throwable -> L124
        StringBuilder r39 = new StringBuilder().append("onUpdateIntentResult ").append(r11).append(' ');     // Catch: Throwable -> L124
        r11.printStackTrace();     // Catch: Throwable -> L124
        r38.e(TAG, r39.append(d.x.f38692a).toString());     // Catch: Throwable -> L124
        goto L122
    L21:
        r6 = null;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L116 Exception -> L118
    L27:
        r12 = r3;
        goto L28
    L13:
        r3 = null;
        goto L14
    L10:
        r2 = null;
        goto L11
    L6:
        r1 = null;
    L124:
        th = move-exception;
        Throwable r40 = th;
        r10 = r12;
    L126:
        com.obric.agent.trace.toolmetrics.c.f15872a.a(r10, r31, null);
        throw r40;
    L118:
        e = e;
        r13 = null;
    L116:
        th = move-exception;
        r40 = th;
        goto L126
    }

    private final boolean reportOAutoStepToComplexTaskServer(IntentAppAction r5, IntentResult<?> r6, String r7) {
        if (r5 == null) goto L19;
        ConcurrentHashMap<String, String> r0 = r5.getExt();
        String r1 = null;
        if (r0 == null) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L8:
        if (d.h.b.o.a(r2, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L22;
        ConcurrentHashMap<String, String> r3 = r6.getExt();
        if (r3 == null) goto L13;
        r1 = (String) ZeusTransformUtils.preCheckCast(r3.get("obric_report_execution_step"), String.class, "com.obric.aiagent.plugin");
    L13:
        if (d.h.b.o.a(r1, "1") == false) goto L23;
        IntentAppAction r4 = createResultIntentAppAction(r5, r6, r7);
        IComplexTaskService r8 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L21;
        r8.reportExecutionStep(r4);
        return true;
    L21:
        return true;
    L23:
        return false;
    L22:
        return false;
    L6:
        r2 = null;
        goto L8
    L19:
        return false;
    }

    static /* synthetic */ void processSendToServer$default(CapabilityActionResultBinder r6, IntentAppAction r7, IntentResult r8, String r9, Map r10, boolean r11, int r12, Object r13) {
        Map<?, ?> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 16) == 0) goto L5;
        r11 = false;
    L5:
        r6.processSendToServer(r7, r8, r9, r4, r11);
    }

    private final void processSendToServer(IntentAppAction r14, IntentResult<?> r15, String r16, Map<?, ?> r17, boolean r18) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.aiagent.plugin");
        if (r15.isFinal() == false) goto L21;
        if (r14 == null) goto L26;
        IIntentTraceService r2 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        r2.setAppStateEndTime(String.valueOf(r14.getQuestionId()));
    L8:
        IntentAppAction r3 = createResultIntentAppAction(r14, r15, r16);
        ObricService.finishIMAction$default(ObricService.INSTANCE, r14, r3, true, null, false, r18, true, true, 16, null);
        Object r4 = this.requestLock;
        monitor-enter(r4);
        List r0 = (List) ZeusTransformUtils.preCheckCast(this.requestIntentRecordMap.get(Long.valueOf(r14.getQuestionId())), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r0 == null) goto L13;
        Boolean.valueOf(r0.remove(r14));     // Catch: Throwable -> L17
    L13:
        monitor-exit(r4);
        IOmniReportService r5 = (IOmniReportService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOmniReportService.class), IOmniReportService.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L27;
        r5.recordDispatchIntentEnd(String.valueOf(r14.getQuestionId()), r16, r14, String.valueOf(r15.getRet()));
        return;
    L27:
        return;
    L17:
        th = move-exception;
        throw th;
    L26:
        return;
    L21:
        if (r14 == null) goto L29;
        IntentAppAction r6 = createResultIntentAppAction(r14, r15, r16);
        ObricService.finishIMAction$default(ObricService.INSTANCE, r14, r6, true, null, false, r18, true, false, 16, null);
        return;
    }

    private final String resolveAppName(String r6) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r4 = null;
        if (r1 == false) goto L31;
        return null;
    L31:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
        CapabilityActionResultBinder r5 = (CapabilityActionResultBinder) ZeusTransformUtils.preCheckCast(this, CapabilityActionResultBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        ApplicationInfo r7 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationInfo(r6, 0);     // Catch: Throwable -> L18
        d.h.b.o.c(r7, "getApplicationInfo(...)");     // Catch: Throwable -> L18
        CharSequence r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationLabel(r7);     // Catch: Throwable -> L18
        if (r8 == null) goto L15;
        String r9 = r8.toString();     // Catch: Throwable -> L18
    L16:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L18
    L21:
        if (d.n.b(r10) == false) goto L23;
        r10 = null;
    L23:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L26;
        return r6;
    L26:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L28;
        r4 = r11;
    L28:
        if (r4 != null) goto L30;
        return r6;
    L30:
        return r4;
    L15:
        r9 = null;
    L18:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L21
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final boolean isContinuousTalk(Map<?, ?> r4, Map<String, String> r5) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r1 = null;
        if (r3 == null) goto L5;
        Object r7 = r3.get(EXT_IS_OBRIC_CONTINUOUS_TALK);
    L7:
        if (d.h.b.o.a(r7, "1") == true) goto L14;
        if (r6 == null) goto L11;
        r1 = (String) ZeusTransformUtils.preCheckCast(r6.get(EXT_IS_OBRIC_CONTINUOUS_TALK), String.class, "com.obric.aiagent.plugin");
    L11:
        if (d.h.b.o.a(r1, "1") == true) goto L14;
        return false;
    L14:
        return true;
    L5:
        r7 = null;
        goto L7
    }

    private final boolean isOmniTask(Map<?, ?> r7, Map<String, String> r8, Map<String, String> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        String r2 = null;
        if (r10 == null) goto L5;
        Object r3 = r10.get("o_task_type");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L10:
        if (r4 != null) goto L19;
        if (r11 == null) goto L13;
        r4 = (String) ZeusTransformUtils.preCheckCast(r11.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L14:
        if (r4 != null) goto L19;
        if (r12 == null) goto L17;
        r4 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
        goto L19
    L17:
        r4 = null;
        goto L19
    L13:
        r4 = null;
    L19:
        if (r10 == null) goto L21;
        Object r5 = r10.get("o_omni_task_id");
    L23:
        if (asUsefulString(r5) != null) goto L55;
        if (r11 == null) goto L26;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r11.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L28:
        if (asUsefulString(r6) != null) goto L55;
        if (r12 == null) goto L31;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.get("o_omni_task_id"), String.class, "com.obric.aiagent.plugin");
    L33:
        if (asUsefulString(r0) != null) goto L55;
        if (d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == true) goto L55;
        if (d.h.b.o.a(r4, IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == true) goto L55;
        if (r10 == null) goto L41;
        Object r13 = r10.get(EXT_O_COMPLEX_TASK);
    L43:
        if (d.h.b.o.a(r13, "1") == true) goto L55;
        if (r11 == null) goto L46;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r11.get(EXT_O_COMPLEX_TASK), String.class, "com.obric.aiagent.plugin");
    L48:
        if (d.h.b.o.a(r14, "1") == true) goto L55;
        if (r12 == null) goto L52;
        r2 = (String) ZeusTransformUtils.preCheckCast(r12.get(EXT_O_COMPLEX_TASK), String.class, "com.obric.aiagent.plugin");
    L52:
        if (d.h.b.o.a(r2, "1") == true) goto L55;
        return false;
    L46:
        r14 = null;
        goto L48
    L41:
        r13 = null;
        goto L43
    L31:
        r0 = null;
        goto L33
    L26:
        r6 = null;
    L55:
        return true;
    L21:
        r5 = null;
        goto L23
    L9:
        r4 = null;
        goto L10
    L5:
        r3 = null;
        goto L7
    }

    private final String asUsefulString(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L5;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return null;
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        return null;
    L10:
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    private final IntentAppAction createResultIntentAppAction(IntentAppAction r17, IntentResult<?> r18, String r19) {
        long r1 = r17.getMessageId();
        long r3 = r17.getQuestionId();
        long r10 = r17.getId();
        IntentAppAction r15 = new IntentAppAction(r1, r3, System.currentTimeMillis(), createActionResultLite(r17, r18, r19), null, 0, r10, r18.getExt(), 48, null);
        Object r0 = r18.getEntity();
        if (ZeusTransformUtils.instanceOf(r0, Bitmap.class) == false) goto L5;
        Bitmap r2 = (Bitmap) ZeusTransformUtils.preCheckCast(r0, Bitmap.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 == null) goto L9;
        r15.setScreenshot(r2);
    L9:
        if (r18.isFinal() == true) goto L12;
        com.obric.agent.utils.b.f15994a.a(r15);
    L12:
        if (d.h.b.o.a(r19, new BaseSystemAutoActionIntent().getName()) == false) goto L16;
        IAutoActionService r4 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L16;
        r4.addExtForOAuto(r17, r18, r15);
    L16:
        return r15;
    L5:
        r2 = null;
        goto L6
    }

    private final void normalizeEntityOrderIfNeeded(IntentResult<?> r10) {
        Object r9 = r10.getEntity();
        if ((r9 instanceof Object[]) == false) goto L5;
        Object[] r11 = (Object[]) ZeusTransformUtils.preCheckCast(r9, Object[].class, "com.obric.aiagent.plugin");
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.length < 2) goto L33;
        int r0 = r11.length;
        int r4 = 0;
    L12:
        if (r4 >= r0) goto L17;
        if ((!ZeusTransformUtils.instanceOf(r11[r4], AlarmEntity.class)) == true) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L34;
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r5 = r11.length;
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L26;
        Object r7 = r11[r6];
        if (ZeusTransformUtils.instanceOf(r7, AlarmEntity.class) == false) goto L25;
        r2.add(r7);
    L25:
        r6 = r6 + 1;
        goto L21
    L26:
        List r12 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r10, "null cannot be cast to non-null type com.obric.capabilitykit.common.intent.IntentResult<kotlin.Any?>");
        r10.setEntity(((Collection) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin"), d.b.a.a(new d.h.a.b[]{$$Lambda$CapabilityActionResultBinder$TWAcmWA_bzjtFmXD6CauHR3xm4.INSTANCE, $$Lambda$CapabilityActionResultBinder$8Uu7OdvOhhsVBziLkZQfLpg_YA.INSTANCE})), Collection.class, "com.obric.aiagent.plugin")).toArray(new AlarmEntity[0]));
        return;
    L34:
        return;
    L17:
        r1 = false;
        goto L18
    L33:
        return;
    L5:
        r11 = null;
        goto L6
    }

    private static final Comparable normalizeEntityOrderIfNeeded$lambda$15(AlarmEntity r2) {
        d.h.b.o.e(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.getStartTime(), Comparable.class, "com.obric.aiagent.plugin");
    }

    private static final Comparable normalizeEntityOrderIfNeeded$lambda$16(AlarmEntity r2) {
        d.h.b.o.e(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2.getCreateTime()), Comparable.class, "com.obric.aiagent.plugin");
    }

    private final String createActionResultLite(IntentAppAction r10, IntentResult<?> r11, String r12) {
        Gson r9 = getGson();
        int r1 = r11.getRet();
        String r2 = r11.getDetails();
        int r4 = r11.getUiType();
        String r13 = r9.toJson(new com.obric.agent.b.a(r1, r2, String.valueOf(r10.getMessageId()), r4, null, com.obric.agent.card.weather.g.f14293a.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r10, r11, r12), 16, null));
        d.h.b.o.c(r13, "toJson(...)");
        return r13;
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public void onJobResultRecv(String r12, String r13, boolean r14, JobResult r15) {
        ILogDepend.Companion.i(TAG, "onJobResultRecv");
        kotlinx.coroutines.i.a(this.scope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r12, r13, r15, r14, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    @Override // com.obric.capabilitykit.common.ICapabilityFeedbackReceiver
    public boolean isKeyguardReallyLocked() {
        Object r2 = ServiceManager.get().getService(IAgentAuthService.class);
        d.h.b.o.a(r2);
        return ((IAgentAuthService) ZeusTransformUtils.preCheckCast(r2, IAgentAuthService.class, "com.obric.aiagent.plugin")).isKeyguardReallyLocked();
    }

    static /* synthetic */ String getContentType$default(CapabilityActionResultBinder r0, String r1, Object r2, IntentAppAction r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.getContentType(r1, r2, r3);
    }

    private final String getContentType(String r8, Object r9, IntentAppAction r10) {
        if (d.h.b.o.a(r8, "Messages_Send") == false) goto L5;
    L49:
        return OAppIntentBizContentType.MSG_DISPLAY_CARD;
    L5:
        if (d.h.b.o.a(r8, "Office_SendMessage") == true) goto L49;
        if (d.h.b.o.a(r8, "Contacts_AddToBlocklist") == false) goto L15;
        if (ZeusTransformUtils.instanceOf(r9, BlockListTarget.class) == false) goto L15;
        if (((BlockListTarget) ZeusTransformUtils.preCheckCast(r9, BlockListTarget.class, "com.obric.aiagent.plugin")).getContact() == null) goto L15;
    L51:
        return OAppIntentBizContentType.CONTACT_CARD;
    L15:
        if (d.h.b.o.a(r8, "Contacts_AddToBlocklist") == false) goto L22;
        if (ZeusTransformUtils.instanceOf(r9, BlockListTarget.class) == false) goto L22;
        if (((BlockListTarget) ZeusTransformUtils.preCheckCast(r9, BlockListTarget.class, "com.obric.aiagent.plugin")).getCallHistory() == null) goto L22;
        return OAppIntentBizContentType.PHONE_CARD;
    L22:
        if (d.o.o.b(r8, "Contacts", false, 2, null) == true) goto L51;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Alarm", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L28;
        return OAppIntentBizContentType.CLOCK_CARD;
    L28:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("Countdown", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L31;
        return OAppIntentBizContentType.COUNTDOWN_CARD;
    L31:
        if (d.o.o.b(r8, "Notes", false, 2, null) == false) goto L34;
        return OAppIntentBizContentType.NOTE_CARD;
    L34:
        if (d.o.o.b(r8, "Phone", false, 2, null) == false) goto L37;
        return OAppIntentBizContentType.PHONE_CARD;
    L37:
        if (d.h.b.o.a(r8, "Office_SearchMeeting") == false) goto L39;
    L48:
        return OAppIntentBizContentType.SCHEDULE_CARD;
    L39:
        if (d.h.b.o.a(r8, "Office_BookMeeting") == true) goto L48;
        if (d.o.o.b(r8, "Recorder", false, 2, null) == false) goto L45;
        return OAppIntentBizContentType.RECORDER_CARD;
    L45:
        if (d.h.b.o.a(r8, "System_DownloadApp") == false) goto L57;
        return OAppIntentBizContentType.DOWNLOAD_APP_CARD;
    L57:
        return getContentTypeFromEntity(r9);
    }

    private final String getContentTypeFromEntity(Object r4) {
        if ((r4 instanceof Object[]) == false) goto L44;
        Object r3 = d.a.i.c((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"));
        if (r3 != null) goto L7;
        return null;
    L7:
        ILogDepend.Companion.i(TAG, "getContentTypeFromEntity called, firstElement is not null");
        if (ZeusTransformUtils.instanceOf(r3, ContactEntity.class) == false) goto L11;
        return OAppIntentBizContentType.CONTACT_CARD;
    L11:
        if (ZeusTransformUtils.instanceOf(r3, AlarmEntity.class) == false) goto L14;
        return OAppIntentBizContentType.CLOCK_CARD;
    L14:
        if (ZeusTransformUtils.instanceOf(r3, CountdownEntity.class) == false) goto L17;
        return OAppIntentBizContentType.COUNTDOWN_CARD;
    L17:
        if (ZeusTransformUtils.instanceOf(r3, NoteEntity.class) == false) goto L20;
        return OAppIntentBizContentType.NOTE_CARD;
    L20:
        if (ZeusTransformUtils.instanceOf(r3, CallHistoryEntity.class) == false) goto L23;
        return OAppIntentBizContentType.PHONE_CARD;
    L23:
        if (ZeusTransformUtils.instanceOf(r3, MemoryEntity.class) == false) goto L25;
    L42:
        return OAppIntentBizContentType.MEMORY_CARD;
    L25:
        if (ZeusTransformUtils.instanceOf(r3, AuditoryRecordingEntity.class) == true) goto L42;
        if (ZeusTransformUtils.instanceOf(r3, ProactiveMemoryEntity.class) == true) goto L42;
        if (ZeusTransformUtils.instanceOf(r3, MessageEntity.class) == false) goto L33;
        return OAppIntentBizContentType.SMS_CARD;
    L33:
        if (ZeusTransformUtils.instanceOf(r3, RecordingEntity.class) == false) goto L36;
        return OAppIntentBizContentType.RECORDER_CARD;
    L36:
        if (ZeusTransformUtils.instanceOf(r3, PhotoEntity.class) == false) goto L39;
        return OAppIntentBizContentType.SEARCH_RESULT_CARD;
    L39:
        if (ZeusTransformUtils.instanceOf(r3, AppInfoEntity.class) == false) goto L41;
        return OAppIntentBizContentType.DOWNLOAD_APP_CARD;
    L41:
        ILogDepend.Companion.i(TAG, "getContentTypeFromEntity called, firstElement is not define");
        return null;
    L44:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void handleIntentMessageCard(IntentExecutionRecord r37, IntentAppAction r38, IntentAppAction r39) {
        Set<String> r1 = this.intentsWithCard;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, intent name " + r37.getIntentName());
        if (n.f15202a.a((Map) ZeusTransformUtils.preCheckCast(r39.getExt(), Map.class, "com.obric.aiagent.plugin")) == false) goto L7;
        ILogDepend.Companion.i(TAG, "skip local intent card because model decode card is enabled");
        return;
    L7:
        if (r1.contains(r37.getIntentName()) == true) goto L10;
        ILogDepend.Companion.e(TAG, "handleIntentMessageCard, intent name " + r37.getIntentName() + " not in cardIntentList");
        return;
    L10:
        String r10 = null;
        if (d.h.b.o.a(r37.getIntentName(), "Memory_Operate") == true) goto L13;
    L30:
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L33;
        r2.handleRemoteCard(r39, r37.getResult(), r37.getIntentName(), r38.getQuestionId());
        d.x r3 = d.x.f38692a;
    L33:
        Object r4 = r37.getResult().getEntity();
        String r13 = getContentType(r37.getIntentName(), r4, r39);
        d.a.p.b();
        if (r13 != null) goto L37;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, contentType is null");
        return;
    L37:
        int r5 = 0;
        if (d.h.b.o.a(r37.getIntentName(), "Office_SearchMeeting") == true) goto L40;
    L44:
        boolean r6 = false;
    L45:
        if (r6 == false) goto L48;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, needJumpToLark true");
        return;
    L48:
        String r7 = "";
        if (d.h.b.o.a(r37.getIntentName(), "System_UserConfirm") == false) goto L59;
        ConcurrentHashMap<String, String> r8 = r37.getResult().getExt();
        if (r8 == null) goto L53;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.get("KEY_CONFIRM_RESPONSE"), String.class, "com.obric.aiagent.plugin");
    L54:
        String r11 = String.valueOf(r9);
        ConcurrentHashMap<String, String> r12 = r37.getResult().getExt();
        if (r12 == null) goto L57;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r12.get("KEY_CANCEL_RESPONSE"), String.class, "com.obric.aiagent.plugin");
    L58:
        String r18 = r11;
        boolean r22 = true;
        String r19 = String.valueOf(r14);
    L61:
        switch(r13.hashCode()) {
            case -1849462795: goto L269;
            case -1649381628: goto L241;
            case -961001071: goto L214;
            case -38059041: goto L177;
            case 406933063: goto L149;
            case 1787939047: goto L122;
            case 1866992267: goto L88;
            case 1896988887: goto L64;
            default: goto L303;
        };
    L64:
        if (r13.equals(OAppIntentBizContentType.NOTE_CARD) == false) goto L303;
        if ((r4 instanceof Object[]) == false) goto L79;
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r16 = r0.length;
    L69:
        if (r5 >= r16) goto L77;
        Object r17 = r0[r5];
        if (ZeusTransformUtils.instanceOf(r17, NoteEntity.class) == true) goto L73;
        r17 = null;
    L73:
        NoteEntity r20 = (NoteEntity) ZeusTransformUtils.preCheckCast(r17, NoteEntity.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L76;
        r15.add(r20);
    L76:
        r5 = r5 + 1;
        goto L69
    L77:
        ArrayList r21 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L82:
        List<RecordingEntity> r23 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
        Gson r24 = EntityExtKt.a();
        DataSource r25 = new DataSource("Notes", r37.getIntentName(), null, 4, null);
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r27 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r26, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r28 = r26.iterator();
    L84:
        if (r28.hasNext() == false) goto L86;
        r27.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((NoteEntity) ZeusTransformUtils.preCheckCast(r28.next(), NoteEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L84
    L86:
        String r29 = r24.toJson(new AppIntentMessage(r25, true, r22, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.aiagent.plugin"), null, 760, null));
    L323:
        String r110 = r29;
    L325:
        if (r23.isEmpty() == false) goto L328;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, entityList is empty");
        return;
    L328:
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, final entityList.size=" + r23.size() + ", contentType=" + r13 + ", intentName=" + r37.getIntentName());
        ILogDepend.Companion.i(TAG, "onJobResultRecv, add local intent card, intentName=" + r37.getIntentName() + ", contentType=" + r13);
        IAgentService r111 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r111 == null) goto L331;
        d.h.b.o.a(r110);
        IAgentService.a.a(r111, r110, r13, String.valueOf(r38.getQuestionId()), 0, null, 24, null);
        d.x r30 = d.x.f38692a;
    L331:
        IIntentMetricsService r31 = (IIntentMetricsService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentMetricsService.class), IIntentMetricsService.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L371;
        r31.record((com.obric.agent.trace.k) ZeusTransformUtils.preCheckCast(new com.obric.agent.trace.k.f(String.valueOf(r38.getQuestionId()), "local_card_done", "call_finish", false, null, null, 48, null), com.obric.agent.trace.k.class, "com.obric.aiagent.plugin"));
        d.x r32 = d.x.f38692a;
        return;
    L371:
        return;
    L79:
        if (ZeusTransformUtils.instanceOf(r4, NoteEntity.class) == false) goto L81;
        r21 = d.a.p.d(new NoteEntity[]{r4});
        goto L82
    L81:
        r21 = new ArrayList();
        goto L82
    L88:
        if (r13.equals(OAppIntentBizContentType.RECORDER_CARD) == false) goto L303;
        String r33 = m.f15194a.a(r39, r37.getIntentName());
        if ((r4 instanceof Object[]) == false) goto L103;
        Object[] r34 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r35 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r36 = r34.length;
    L93:
        if (r5 >= r36) goto L101;
        Object r40 = r34[r5];
        if (ZeusTransformUtils.instanceOf(r40, RecordingEntity.class) == true) goto L97;
        r40 = null;
    L97:
        RecordingEntity r41 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r40, RecordingEntity.class, "com.obric.aiagent.plugin");
        if (r41 == null) goto L100;
        r35.add(r41);
    L100:
        r5 = r5 + 1;
        goto L93
    L101:
        ArrayList r42 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r35, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L106:
        List<RecordingEntity> r43 = v.f16080a.a(r37.getIntentName(), r37.getResult().getRet(), (List) ZeusTransformUtils.preCheckCast(r42, List.class, "com.obric.aiagent.plugin"), r33);
        if (d.h.b.o.a(r37.getIntentName(), "Recorder_Operate") == true) goto L109;
    L115:
        r23 = r43;
    L116:
        v r44 = v.f16080a;
        d.h.b.o.a(r23, "null cannot be cast to non-null type kotlin.collections.List<com.obric.capabilitykit.entity.app.RecordingEntity>");
        r44.a(r23);
        Gson r45 = EntityExtKt.a();
        DataSource r112 = new DataSource("Recorder", r37.getIntentName(), null, 4, null);
        boolean r113 = !d.h.b.o.a(r37.getIntentName(), "Recorder_Delete");
        Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r47 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r46, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r48 = r46.iterator();
    L118:
        if (r48.hasNext() == false) goto L120;
        r47.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((RecordingEntity) ZeusTransformUtils.preCheckCast(r48.next(), RecordingEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L118
    L120:
        r29 = r45.toJson(new AppIntentMessage(r112, r113, r22, r18, r19, false, false, null, (List) ZeusTransformUtils.preCheckCast(r47, List.class, "com.obric.aiagent.plugin"), null, 736, null));
        goto L323
    L109:
        if (r37.getResult().getRet() != 0) goto L115;
        if (r43.isEmpty() == false) goto L115;
        if (v.f16080a.b(r33) == true) goto L115;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, Recorder_Operate empty entity, fetch via RCSearch");
        r23 = v.f16080a.a();
        goto L116
    L103:
        if (ZeusTransformUtils.instanceOf(r4, RecordingEntity.class) == false) goto L105;
        r42 = d.a.p.d(new RecordingEntity[]{r4});
        goto L106
    L105:
        r42 = new ArrayList();
        goto L106
    L122:
        if (r13.equals(OAppIntentBizContentType.PHONE_CARD) == false) goto L303;
        if (ZeusTransformUtils.instanceOf(r4, BlockListTarget.class) == false) goto L128;
        r4 = ((BlockListTarget) ZeusTransformUtils.preCheckCast(r4, BlockListTarget.class, "com.obric.aiagent.plugin")).getCallHistory();
    L128:
        if ((r4 instanceof Object[]) == false) goto L140;
        Object[] r49 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r50 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r51 = r49.length;
    L130:
        if (r5 >= r51) goto L138;
        Object r52 = r49[r5];
        if (ZeusTransformUtils.instanceOf(r52, CallHistoryEntity.class) == true) goto L134;
        r52 = null;
    L134:
        CallHistoryEntity r53 = (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r52, CallHistoryEntity.class, "com.obric.aiagent.plugin");
        if (r53 == null) goto L137;
        r50.add(r53);
    L137:
        r5 = r5 + 1;
        goto L130
    L138:
        ArrayList r54 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r50, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L143:
        r23 = (List) ZeusTransformUtils.preCheckCast(r54, List.class, "com.obric.aiagent.plugin");
        Gson r55 = EntityExtKt.a();
        DataSource r114 = new DataSource("Phone", r37.getIntentName(), null, 4, null);
        Iterable r56 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r57 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r56, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r58 = r56.iterator();
    L145:
        if (r58.hasNext() == false) goto L147;
        r57.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r58.next(), CallHistoryEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L145
    L147:
        r29 = r55.toJson(new AppIntentMessage(r114, true, r22, r18, r19, false, false, null, (List) ZeusTransformUtils.preCheckCast(r57, List.class, "com.obric.aiagent.plugin"), null, 736, null));
        goto L323
    L140:
        if (ZeusTransformUtils.instanceOf(r4, CallHistoryEntity.class) == false) goto L142;
        r54 = d.a.p.d(new CallHistoryEntity[]{r4});
        goto L143
    L142:
        r54 = new ArrayList();
        goto L143
    L149:
        if (r13.equals(OAppIntentBizContentType.CLOCK_CARD) == false) goto L303;
        if ((r4 instanceof Object[]) == false) goto L164;
        Object[] r59 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r60 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r61 = r59.length;
    L154:
        if (r5 >= r61) goto L162;
        Object r62 = r59[r5];
        if (ZeusTransformUtils.instanceOf(r62, AlarmEntity.class) == true) goto L158;
        r62 = null;
    L158:
        AlarmEntity r63 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r62, AlarmEntity.class, "com.obric.aiagent.plugin");
        if (r63 == null) goto L161;
        r60.add(r63);
    L161:
        r5 = r5 + 1;
        goto L154
    L162:
        ArrayList r64 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r60, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L167:
        r23 = (List) ZeusTransformUtils.preCheckCast(r64, List.class, "com.obric.aiagent.plugin");
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r23, ArrayList.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L171;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, AlarmEntity is empty");
        return;
    L171:
        Gson r65 = EntityExtKt.a();
        DataSource r210 = new DataSource("Clock", r37.getIntentName(), null, 4, null);
        Iterable r66 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r67 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r66, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r68 = r66.iterator();
    L173:
        if (r68.hasNext() == false) goto L175;
        r67.add(AppIntentCardData.copy$default(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((AlarmEntity) ZeusTransformUtils.preCheckCast(r68.next(), AlarmEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")), 0, null, null, d.h.b.o.a(r37.getIntentName(), new BaseClockDeleteAlarmIntent().getName()), false, 23, null));
        goto L173
    L175:
        r29 = r65.toJson(new AppIntentMessage(r210, true, r22, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(r67, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r39.getExt(), Map.class, "com.obric.aiagent.plugin"), 248, null));
        goto L323
    L164:
        if (ZeusTransformUtils.instanceOf(r4, AlarmEntity.class) == false) goto L166;
        r64 = d.a.p.d(new AlarmEntity[]{r4});
        goto L167
    L166:
        r64 = new ArrayList();
        goto L167
    L177:
        if (r13.equals(OAppIntentBizContentType.DOWNLOAD_APP_CARD) == false) goto L303;
        if ((r4 instanceof Object[]) == false) goto L192;
        Object[] r69 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r70 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r71 = r69.length;
    L182:
        if (r5 >= r71) goto L190;
        Object r72 = r69[r5];
        if (ZeusTransformUtils.instanceOf(r72, AppInfoEntity.class) == true) goto L186;
        r72 = null;
    L186:
        AppInfoEntity r73 = (AppInfoEntity) ZeusTransformUtils.preCheckCast(r72, AppInfoEntity.class, "com.obric.aiagent.plugin");
        if (r73 == null) goto L189;
        r70.add(r73);
    L189:
        r5 = r5 + 1;
        goto L182
    L190:
        ArrayList r74 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r70, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L195:
        List<RecordingEntity> r75 = (List) ZeusTransformUtils.preCheckCast(r74, List.class, "com.obric.aiagent.plugin");
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r75, ArrayList.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L199;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, AppInfoEntity is empty");
        return;
    L199:
        Integer r76 = parseOperateType(r39);
        HashMap r77 = new HashMap();
        ConcurrentHashMap<String, String> r78 = r39.getExt();
        if (r78 == null) goto L202;
        r77.putAll((Map) ZeusTransformUtils.preCheckCast(r78, Map.class, "com.obric.aiagent.plugin"));
        d.x r79 = d.x.f38692a;
        d.x r80 = d.x.f38692a;
    L202:
        if (r76 == null) goto L204;
        r77.put("operate_type", r76.toString());
    L204:
        DataSource r211 = new DataSource("System", r37.getIntentName(), null, 4, null);
        Iterable r81 = (Iterable) ZeusTransformUtils.preCheckCast(r75, Iterable.class, "com.obric.aiagent.plugin");
        Collection r82 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r81, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r83 = r81.iterator();
    L206:
        if (r83.hasNext() == false) goto L208;
        r82.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((AppInfoEntity) ZeusTransformUtils.preCheckCast(r83.next(), AppInfoEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L206
    L208:
        AppIntentMessage r84 = new AppIntentMessage(r211, true, r22, null, null, false, false, null, (List) ZeusTransformUtils.preCheckCast(r82, List.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(r77, Map.class, "com.obric.aiagent.plugin"), 248, null);
        if (com.obric.agent.d.a.f14414a.c(r84) == true) goto L212;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, DOWNLOAD_APP_CARD skip due to no visible entity, operateType=" + r76 + ", size=" + ((ArrayList) ZeusTransformUtils.preCheckCast(r75, ArrayList.class, "com.obric.aiagent.plugin")).size());
        return;
    L212:
        String r85 = EntityExtKt.a().toJson(r84);
    L237:
        r110 = r85;
        r23 = r75;
        goto L325
    L192:
        if (ZeusTransformUtils.instanceOf(r4, AppInfoEntity.class) == false) goto L194;
        r74 = d.a.p.d(new AppInfoEntity[]{r4});
        goto L195
    L194:
        r74 = new ArrayList();
        goto L195
    L214:
        if (r13.equals(OAppIntentBizContentType.MSG_DISPLAY_CARD) == false) goto L303;
        int r86 = r37.getResult().getRet();
        if (r86 != 103) goto L219;
    L238:
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, MSG_DISPLAY_CARD skip due to ret=" + r86);
        return;
    L219:
        if (r86 == 201) goto L238;
        if (r86 == 9001) goto L238;
        if (r86 == 9002) goto L238;
        String r87 = com.obric.agent.office.a.f15240a.a(r39, r37.getIntentName());
        MessageEntity r88 = com.obric.agent.office.a.f15240a.a(r39, r37.getIntentName(), r4);
        if (r88 != null) goto L228;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, MSG_DISPLAY_CARD build entity failed");
        return;
    L228:
        r75 = d.a.p.a(r88);
        Gson r89 = EntityExtKt.a();
        DataSource r90 = new DataSource(d.o.o.a(r37.getIntentName(), "_", null, 2, null), r37.getIntentName(), null, 4, null);
        Iterable r115 = (Iterable) ZeusTransformUtils.preCheckCast(r75, Iterable.class, "com.obric.aiagent.plugin");
        Collection r91 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r115, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r116 = r115.iterator();
    L230:
        if (r116.hasNext() == false) goto L232;
        r91.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((MessageEntity) ZeusTransformUtils.preCheckCast(r116.next(), MessageEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L230
    L232:
        List r212 = (List) ZeusTransformUtils.preCheckCast(r91, List.class, "com.obric.aiagent.plugin");
        d.m[] r92 = new d.m[2];
        r92[0] = d.s.a("msg_send_status", "display");
        if (r87 == null) goto L236;
        r7 = r87;
    L236:
        r92[1] = d.s.a("package_name", r7);
        r85 = r89.toJson(new AppIntentMessage(r90, true, false, null, null, false, false, null, r212, ao.a(r92), 248, null));
        goto L237
    L241:
        if (r13.equals(OAppIntentBizContentType.COUNTDOWN_CARD) == false) goto L303;
        if ((r4 instanceof Object[]) == false) goto L256;
        Object[] r93 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r94 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r95 = r93.length;
    L246:
        if (r5 >= r95) goto L254;
        Object r96 = r93[r5];
        if (ZeusTransformUtils.instanceOf(r96, CountdownEntity.class) == true) goto L250;
        r96 = null;
    L250:
        CountdownEntity r97 = (CountdownEntity) ZeusTransformUtils.preCheckCast(r96, CountdownEntity.class, "com.obric.aiagent.plugin");
        if (r97 == null) goto L253;
        r94.add(r97);
    L253:
        r5 = r5 + 1;
        goto L246
    L254:
        ArrayList r98 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r94, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L259:
        r23 = (List) ZeusTransformUtils.preCheckCast(r98, List.class, "com.obric.aiagent.plugin");
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r23, ArrayList.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L263;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, CountdownEntity is empty");
        return;
    L263:
        Gson r99 = EntityExtKt.a();
        DataSource r213 = new DataSource("Clock", r37.getIntentName(), null, 4, null);
        boolean r214 = !d.h.b.o.a(r37.getIntentName(), "Clock_DeleteCountdown");
        boolean r215 = d.h.b.o.a(r37.getIntentName(), "Clock_PauseCountdown");
        Iterable r100 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r101 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r100, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r102 = r100.iterator();
    L265:
        if (r102.hasNext() == false) goto L267;
        r101.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((CountdownEntity) ZeusTransformUtils.preCheckCast(r102.next(), CountdownEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L265
    L267:
        r29 = r99.toJson(new AppIntentMessage(r213, r214, r22, null, null, r215, false, null, (List) ZeusTransformUtils.preCheckCast(r101, List.class, "com.obric.aiagent.plugin"), null, 728, null));
        goto L323
    L256:
        if (ZeusTransformUtils.instanceOf(r4, CountdownEntity.class) == false) goto L258;
        r98 = d.a.p.d(new CountdownEntity[]{r4});
        goto L259
    L258:
        r98 = new ArrayList();
        goto L259
    L269:
        if (r13.equals(OAppIntentBizContentType.CONTACT_CARD) == false) goto L303;
        if (ZeusTransformUtils.instanceOf(r4, BlockListTarget.class) == false) goto L275;
        r4 = ((BlockListTarget) ZeusTransformUtils.preCheckCast(r4, BlockListTarget.class, "com.obric.aiagent.plugin")).getContact();
    L275:
        if ((r4 instanceof Object[]) == false) goto L287;
        Object[] r103 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r104 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r105 = r103.length;
    L277:
        if (r5 >= r105) goto L285;
        Object r106 = r103[r5];
        if (ZeusTransformUtils.instanceOf(r106, ContactEntity.class) == true) goto L281;
        r106 = null;
    L281:
        ContactEntity r107 = (ContactEntity) ZeusTransformUtils.preCheckCast(r106, ContactEntity.class, "com.obric.aiagent.plugin");
        if (r107 == null) goto L284;
        r104.add(r107);
    L284:
        r5 = r5 + 1;
        goto L277
    L285:
        ArrayList r108 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r104, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L290:
        r23 = (List) ZeusTransformUtils.preCheckCast(r108, List.class, "com.obric.aiagent.plugin");
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r23, ArrayList.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L294;
        ILogDepend.Companion.i(TAG, "handleIntentMessageCard, ContactEntity is empty");
        return;
    L294:
        ConcurrentHashMap<String, String> r109 = r37.getResult().getExt();
        if (r109 == null) goto L297;
        r10 = (String) ZeusTransformUtils.preCheckCast(r109.get("USER_SELECT_SOURCE_INTENT"), String.class, "com.obric.aiagent.plugin");
    L297:
        Gson r117 = EntityExtKt.a();
        DataSource r118 = new DataSource("Contacts", r37.getIntentName(), r10);
        boolean r216 = d.h.b.o.a(r10, "Phone_Call");
        Iterable r119 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r120 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r119, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r121 = r119.iterator();
    L299:
        if (r121.hasNext() == false) goto L301;
        r120.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((ContactEntity) ZeusTransformUtils.preCheckCast(r121.next(), ContactEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L299
    L301:
        r29 = r117.toJson(new AppIntentMessage(r118, true, r22, r18, r19, false, r216, null, (List) ZeusTransformUtils.preCheckCast(r120, List.class, "com.obric.aiagent.plugin"), null, 672, null));
        goto L323
    L287:
        if (ZeusTransformUtils.instanceOf(r4, ContactEntity.class) == false) goto L289;
        r108 = d.a.p.d(new ContactEntity[]{r4});
        goto L290
    L289:
        r108 = new ArrayList();
    L303:
        if ((r4 instanceof Object[]) == false) goto L315;
        Object[] r122 = (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin");
        Collection r123 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r124 = r122.length;
        int r125 = 0;
    L305:
        if (r125 >= r124) goto L313;
        Object r126 = r122[r125];
        if (ZeusTransformUtils.instanceOf(r126, AppEntity.class) == true) goto L309;
        r126 = null;
    L309:
        AppEntity r127 = (AppEntity) ZeusTransformUtils.preCheckCast(r126, AppEntity.class, "com.obric.aiagent.plugin");
        if (r127 == null) goto L312;
        r123.add(r127);
    L312:
        r125 = r125 + 1;
        goto L305
    L313:
        ArrayList r128 = (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r123, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L318:
        r23 = (List) ZeusTransformUtils.preCheckCast(r128, List.class, "com.obric.aiagent.plugin");
        Gson r129 = EntityExtKt.a();
        String r130 = r37.getIntentName().substring(0, d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r37.getIntentName(), CharSequence.class, "com.obric.aiagent.plugin"), '_', 0, false, 6, null));
        d.h.b.o.c(r130, "substring(...)");
        DataSource r131 = new DataSource(r130, r37.getIntentName(), null, 4, null);
        Iterable r132 = (Iterable) ZeusTransformUtils.preCheckCast(r23, Iterable.class, "com.obric.aiagent.plugin");
        Collection r133 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r132, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r134 = r132.iterator();
    L320:
        if (r134.hasNext() == false) goto L322;
        r133.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast(r134.next(), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L320
    L322:
        r29 = r129.toJson(new AppIntentMessage(r131, true, r22, r18, r19, false, false, null, (List) ZeusTransformUtils.preCheckCast(r133, List.class, "com.obric.aiagent.plugin"), null, 736, null));
        goto L323
    L315:
        if (ZeusTransformUtils.instanceOf(r4, AppEntity.class) == false) goto L317;
        r128 = d.a.p.d(new AppEntity[]{r4});
        goto L318
    L317:
        r128 = new ArrayList();
        goto L318
    L57:
        r14 = null;
        goto L58
    L53:
        r9 = null;
        goto L54
    L59:
        r22 = false;
        r18 = "";
        r19 = r18;
        goto L61
    L40:
        if (r37.getResult().getIntent() == null) goto L44;
        if (d.h.b.o.a(r37.getImplPackage(), "com.ss.android.lark") == false) goto L44;
        r6 = true;
        goto L45
    L13:
        if (r37.getResult().getRet() == 0) goto L15;
        return;
    L15:
        String r135 = r37.getResult().getDetails();
        if (r135 != null) goto L335;
        return;
    L335:
        Object r136 = new JSONObject(r135).opt("result");     // Catch: JSONException -> L21
        if (ZeusTransformUtils.instanceOf(r136, String.class) == false) goto L22;
        String r137 = (String) ZeusTransformUtils.preCheckCast(r136, String.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L21
    L23:
        if (r137 != null) goto L26;
        return;
    L26:
        if (ax.a(new String[]{"insert", "update"}).contains(r137) == true) goto L28;
        return;
    L28:
        ISecureLogDepend.Companion.i(TAG, "handleIntentMessageCard called, Memory_Operate intent result:" + r137);
    L22:
        r137 = null;
    L21:
        ILogDepend.Companion.e(TAG, "handleIntentMessageCard called, Memory_Operate intent parse JSON throw JSONException, origin details:" + r135);
        goto L22
    }

    private final /* synthetic */ <T> ArrayList<T> convertEntitiesToList(Object r7) {
        int r0 = 0;
        if ((r7 instanceof Object[]) == false) goto L11;
        Object[] r6 = (Object[]) ZeusTransformUtils.preCheckCast(r7, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r3 = r6.length;
    L5:
        if (r0 >= r3) goto L19;
        Object r4 = r6[r0];
        d.h.b.o.a(2, "T");
        Object r5 = ZeusTransformUtils.preCheckCast(r4, Object.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L9;
        r8.add(r5);
    L9:
        r0 = r0 + 1;
        goto L5
    L19:
        return (ArrayList) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin")), ArrayList.class, "com.obric.aiagent.plugin");
    L11:
        d.h.b.o.a(3, "T");
        if (ZeusTransformUtils.instanceOf(r7, Object.class) == false) goto L15;
        d.h.b.o.a(0, "T");
        return d.a.p.d(new Object[]{r7});
    L15:
        return new ArrayList();
    }

    private final void notifySuccessfulEntityDelete(IntentExecutionRecord r7, IntentAppAction r8) {
        if (r7.getResult().getRet() == 0) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, String> r6 = r8.getExt();
        String r1 = null;
        if (r6 == null) goto L8;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r6.get("o_entity_delete_bridge"), String.class, "com.obric.aiagent.plugin");
    L10:
        if (d.h.b.o.a(r9, "1") == false) goto L13;
        return;
    L13:
        if (x.f16082a.a(r7.getIntentName()) == true) goto L15;
        return;
    L15:
        x r10 = x.f16082a;
        String r2 = r7.getIntentName();
        Object r3 = r7.getResult().getEntity();
        String r4 = m.f15194a.a(r8, r7.getIntentName());
        ConcurrentHashMap<String, String> r11 = r8.getExt();
        if (r11 == null) goto L18;
        r1 = (String) ZeusTransformUtils.preCheckCast(r11.get("o_devliver_entity_list"), String.class, "com.obric.aiagent.plugin");
    L18:
        List<AppEntity> r12 = r10.a(r2, r3, r4, r1);
        if (r12.isEmpty() == false) goto L21;
        return;
    L21:
        ILogDepend.Companion.i(TAG, "notify deleted entity widgets, intent=" + r7.getIntentName() + ", count=" + r12.size());
        com.obric.agent.entitysync.b.f14469a.b(r12);
        return;
    L8:
        r9 = null;
        goto L10
    }

    private final Integer parseOperateType(IntentAppAction r2) {
        Integer r0 = parseOperateTypeFromParams(r2);
        if (r0 == null) goto L7;
        return Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L7:
        return parseOperateTypeFromEcaContent(r2);
    }

    private final Integer parseOperateTypeFromParams(IntentAppAction r6) {
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L9
        CapabilityActionResultBinder r5 = (CapabilityActionResultBinder) ZeusTransformUtils.preCheckCast(this, CapabilityActionResultBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        AppAction r7 = r6.getAction();     // Catch: Throwable -> L9
        if (r7 == null) goto L6;
        String r8 = r7.getParams();     // Catch: Throwable -> L9
    L7:
        Object r9 = d.n.f(r8);     // Catch: Throwable -> L9
    L12:
        if (d.n.b(r9) == false) goto L14;
        r9 = null;
    L14:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L17;
    L20:
        boolean r12 = true;
    L21:
        if (r12 == false) goto L32;
        return null;
    L32:
        JSONObject r13 = new JSONObject(r10);     // Catch: JSONException -> L27
        if (r13.has("operateType") == false) goto L34;
        return Integer.valueOf(r13.optInt("operateType"));
    L34:
        return null;
    L27:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parseOperateTypeFromParams failed: " + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L17:
        if (r11.length() == 0) goto L20;
        r12 = false;
        goto L21
    L6:
        r8 = null;
    L9:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r9 = d.n.f(d.o.a(th));
        goto L12
    }

    private final Integer parseOperateTypeFromEcaContent(IntentAppAction r7) {
        String r6 = r7.getContent();
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r1 = true;
        if (r8 != null) goto L5;
    L8:
        boolean r9 = true;
    L10:
        if (r9 == false) goto L38;
        return null;
    L38:
        JSONArray r10 = new JSONObject(new JSONObject(r6).optString("Content")).optJSONArray("jobs");     // Catch: JSONException -> L35
        if (r10 == null) goto L21;
        JSONObject r11 = r10.optJSONObject(0);     // Catch: JSONException -> L35
        if (r11 == null) goto L21;
        JSONArray r12 = r11.optJSONArray("actions");     // Catch: JSONException -> L35
        if (r12 == null) goto L21;
        JSONObject r13 = r12.optJSONObject(0);     // Catch: JSONException -> L35
        if (r13 == null) goto L21;
        JSONObject r14 = r13.optJSONObject("inputParams");     // Catch: JSONException -> L35
    L22:
        if (r14 == null) goto L24;
        String r15 = r14.optString("operateType");     // Catch: JSONException -> L35
    L25:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: JSONException -> L35
        if (r4 != null) goto L28;
    L31:
        if (r1 == false) goto L33;
        return null;
    L33:
        String r16 = new JSONObject(r15).optString("value");     // Catch: JSONException -> L35
        d.h.b.o.c(r16, "optString(...)");     // Catch: JSONException -> L35
        return d.o.o.d(r16);
    L28:
        if (r4.length() == 0) goto L31;
        r1 = false;
        goto L31
    L24:
        r15 = null;
    L21:
        r14 = null;
    L35:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "parseOperateTypeFromEcaContent failed: " + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L5:
        if (r8.length() == 0) goto L8;
        r9 = false;
        goto L10
    }

    private final Set<String> loadSearchIntentsFromXml(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
        XmlResourceParser r7 = ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getXml(ZeusTransformUtils.mapRes(R.xml.intents_card, "xml", "intents_card"));
        d.h.b.o.c(r7, "getXml(...)");
        int r1 = r7.getEventType();     // Catch: Exception -> L20
    L4:
        boolean r2 = true;
        if (r1 == 1) goto L22;
        if (r1 != 2) goto L18;
        if (d.h.b.o.a(r7.getName(), MemorySourceLinkType.INTENT) == false) goto L18;
        String r3 = r7.getAttributeValue(null, "name");     // Catch: Exception -> L20
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20
        if (r8 != null) goto L13;
    L16:
        if (r2 == true) goto L18;
        r6.add(r3);     // Catch: Exception -> L20
        goto L18
    L13:
        if (r8.length() == 0) goto L16;
        r2 = false;
    L18:
        r1 = r7.next();     // Catch: Exception -> L20
    L22:
        return r6;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Failed to parse intents_card.xml", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L22
    }

    private final boolean isLocalIntent(IntentAppAction r2) {
        if (r2 == null) goto L6;
        ConcurrentHashMap<String, String> r1 = r2.getExt();
        if (r1 == null) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get(EXT_TO_SERVER), String.class, "com.obric.aiagent.plugin");
    L8:
        return d.h.b.o.a(r3, "false");
    L6:
        r3 = null;
        goto L8
    }

    private final String noReplyTerminalReason(String r1, boolean r2) {
        String r0 = com.obric.agent.trace.l.f15525a.a(r1);
        if (r0 != null) goto L8;
        if (r2 == false) goto L6;
        return "no_reply_expected";
    L6:
        return null;
    L8:
        return r0;
    }

    private final boolean isPolicyNoReplyIntent(String r1) {
        if (com.obric.agent.trace.l.f15525a.a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
