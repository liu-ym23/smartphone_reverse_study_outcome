package com.obric.agent.office;

import android.app.Application;
import android.net.Uri;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.agent.IAgentService;
import com.obric.agent.IAppIntentFeedback;
import com.obric.agent.IEntityManager;
import com.obric.agent.n;
import com.obric.agent.utils.u;
import com.obric.agent.w;
import com.obric.aiagent.assistant.idl.IFlowMessageIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.aiagent.assistant.idl.bean.DataSource;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.assistant.idl.bean.OAppIntentBizContentType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.ContactTarget;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MessageContent;
import com.obric.capabilitykit.common.intent.MessagesSendParams;
import com.obric.capabilitykit.common.intent.OfficeMessageContent;
import com.obric.capabilitykit.common.intent.OfficeSendMessageParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.lark.LarkParticipants;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.z;
import d.s;
import d.x;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "MessageSendConfirmHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f15241b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final i f15242c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f15243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<String, Boolean> f15244e = null;
    private static final ConcurrentHashMap.KeySetView<String, Boolean> f = null;

    /* JADX INFO: renamed from: com.obric.agent.office.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    private static final class C0312a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f15246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JsonObject f15247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f15248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15249e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0312a.class) == true) goto L8;
            return false;
        L8:
            C0312a r10 = (C0312a) ZeusTransformUtils.preCheckCast(r9, C0312a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15245a, r10.f15245a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15246b, r10.f15246b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15247c, r10.f15247c) == true) goto L18;
            return false;
        L18:
            if (this.f15248d == r10.f15248d) goto L21;
            return false;
        L21:
            if (o.a(this.f15249e, r10.f15249e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15245a.hashCode() * 31;
            String r1 = this.f15246b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            JsonObject r5 = this.f15247c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + Long.hashCode(this.f15248d)) * 31) + this.f15249e.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "PendingIntent(intentName=" + this.f15245a + ", packageName=" + this.f15246b + ", params=" + this.f15247c + ", questionId=" + this.f15248d + ", originContent=" + this.f15249e + ')';
        }

        public C0312a(String r2, String r3, JsonObject r4, long r5, String r7) {
            o.e(r2, "intentName");
            o.e(r7, "originContent");
            this.f15245a = r2;
            this.f15246b = r3;
            this.f15247c = r4;
            this.f15248d = r5;
            this.f15249e = r7;
        }

        public final String a() {
            return this.f15245a;
        }

        public final String b() {
            return this.f15246b;
        }

        public final JsonObject c() {
            return this.f15247c;
        }

        public final String d() {
            return this.f15249e;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f15250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final JsonObject f15251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f15252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f15253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f15254e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f15250a, r6.f15250a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f15251b, r6.f15251b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f15252c, r6.f15252c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f15253d, r6.f15253d) == true) goto L21;
            return false;
        L21:
            if (o.a(this.f15254e, r6.f15254e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.f15250a.hashCode() * 31;
            JsonObject r1 = this.f15251b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f15252c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f15253d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.f15254e;
            if (r11 == null) goto L19;
            r2 = r11.hashCode();
        L19:
            return r10 + r2;
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StatelessSendPayload(intentName=" + this.f15250a + ", params=" + this.f15251b + ", packageName=" + this.f15252c + ", entityEcaId=" + this.f15253d + ", widgetMessageId=" + this.f15254e + ')';
        }

        public b(String r2, JsonObject r3, String r4, String r5, String r6) {
            o.e(r2, "intentName");
            this.f15250a = r2;
            this.f15251b = r3;
            this.f15252c = r4;
            this.f15253d = r5;
            this.f15254e = r6;
        }

        public final String a() {
            return this.f15250a;
        }

        public final JsonObject b() {
            return this.f15251b;
        }

        public final String c() {
            return this.f15252c;
        }

        public final String d() {
            return this.f15253d;
        }

        public final String e() {
            return this.f15254e;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    @d.c.b.a.f(b = "MessageSendConfirmHandler.kt", c = {DownloadErrorCode.ERROR_EOF}, d = "createOfficeMessageEntity", e = "com.obric.agent.office.MessageSendConfirmHandler")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f15258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15259e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15258d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15257c = r3;
            this.f15259e |= Integer.MIN_VALUE;
            return a.a(this.f15258d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    @d.c.b.a.f(b = "MessageSendConfirmHandler.kt", c = {197}, d = "handleOfficeSendMessage", e = "com.obric.agent.office.MessageSendConfirmHandler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f15264e;
        final /* synthetic */ a f;
        int g;

        d(a r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15264e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    public static final class e implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f15265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<ca> f15267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f15269e;
        final /* synthetic */ C0312a f;

        e(long r3, AtomicBoolean r5, z.f<ca> r6, String r7, IAppIntentFeedback r8, C0312a r9) {
            IAppIntentFeedback r10 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r8, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            this.f15265a = r3;
            this.f15266b = r5;
            this.f15267c = r6;
            this.f15268d = r7;
            this.f15269e = r10;
            this.f = r9;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r6, JobResult r7, d.c.d<? super x> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (r6.getQuestionId() != this.f15265a) goto L5;
            int r0 = 1;
            if (this.f15266b.compareAndSet(false, true) == false) goto L9;
            ca r10 = (ca) ZeusTransformUtils.preCheckCast(this.f15267c.f38504a, ca.class, "com.obric.aiagent.plugin");
            IntentExecutionRecord r11 = null;
            if (r10 == null) goto L13;
            ca.a.a(r10, null, 1, null);
        L13:
            if (r7 == null) goto L26;
            List<IntentExecutionRecord> r12 = r7.getExecRecords();
            if (r12 == null) goto L26;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            C0312a r1 = this.f;
            Iterator r14 = r13.iterator();
        L18:
            if (r14.hasNext() == false) goto L22;
            Object r2 = r14.next();
            if (o.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r2, IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getIntentName(), r1.a()) == false) goto L18;
        L23:
            IntentExecutionRecord r15 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r2, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L26;
            r11 = r15;
        L30:
            if (r11 == null) goto L34;
            IntentResult<?> r16 = r11.getResult();
            if (r16 == null) goto L34;
            r0 = r16.getRet();
        L34:
            ILogDepend.Companion.i(a.TAG, "onUserClickSend finished ret=" + r0);
            if (r0 != 0) goto L37;
            String r17 = "executed";
        L38:
            a.a(a.f15240a, this.f15268d, r17);
            i r18 = a.a();
            String r19 = this.f15268d;
            monitor-enter(r18);
            C0312a r20 = (C0312a) ZeusTransformUtils.preCheckCast(a.a().remove(r19), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
            monitor-exit(r18);
            a.b().remove(this.f15268d);
            this.f15269e.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L44:
            th = move-exception;
            throw th;
        L37:
            a.a(a.f15240a, r0);
            r17 = "failed";
            goto L38
        L22:
            r2 = null;
        L26:
            if (r7 == null) goto L30;
            List<IntentExecutionRecord> r21 = r7.getExecRecords();
            if (r21 == null) goto L30;
            r11 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(p.l(r21), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            goto L30
        L9:
            return x.f38692a;
        L5:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    @d.c.b.a.f(b = "MessageSendConfirmHandler.kt", c = {604}, d = "invokeSuspend", e = "com.obric.agent.office.MessageSendConfirmHandler$onUserClickSend$3")
    static final class f extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f15273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.f<com.obric.agent.f> f15274e;
        final /* synthetic */ C0312a f;
        final /* synthetic */ long g;

        f(AtomicBoolean r3, String r4, IAppIntentFeedback r5, z.f<com.obric.agent.f> r6, C0312a r7, long r8, d.c.d<? super f> r10) {
            IAppIntentFeedback r9 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r5, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15271b = r3;
            this.f15272c = r4;
            this.f15273d = r9;
            this.f15274e = r6;
            this.f = r7;
            this.g = r8;
            super(2, r11);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15271b, this.f15272c, this.f15273d, this.f15274e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15270a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (this.f15271b.compareAndSet(false, true) == false) goto L14;
            a.a(a.f15240a, this.f15272c, "failed");
            i r7 = a.a();
            String r2 = this.f15272c;
            monitor-enter(r7);
            C0312a r3 = (C0312a) ZeusTransformUtils.preCheckCast(a.a().remove(r2), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
            monitor-exit(r7);
            a.b().remove(this.f15272c);
            IAppIntentFeedback r8 = this.f15273d;
            if (this.f15274e.f38504a != null) goto L22;
            o.c("listener");
            com.obric.agent.f r4 = null;
        L23:
            r8.removeActionFinishedListener(r4);
            ILogDepend.Companion.e(a.TAG, "onUserClickSend timeout, localMsgId=" + this.f15272c + ", intent=" + this.f.a() + ", reqId=" + this.g);
            return x.f38692a;
        L22:
            r4 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(this.f15274e.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
        L25:
            th = move-exception;
            throw th;
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15270a = 1;
            if (ax.a(35000, r9) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    public static final class g implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f15275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ z.f<ca> f15277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f15278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15279e;
        final /* synthetic */ String f;
        final /* synthetic */ IAppIntentFeedback g;

        g(long r3, AtomicBoolean r5, z.f<ca> r6, b r7, String r8, String r9, IAppIntentFeedback r10) {
            IAppIntentFeedback r11 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r10, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            this.f15275a = r3;
            this.f15276b = r5;
            this.f15277c = r6;
            this.f15278d = r7;
            this.f15279e = r8;
            this.f = r9;
            this.g = r11;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f15275a) goto L5;
            int r0 = 1;
            if (this.f15276b.compareAndSet(false, true) == false) goto L9;
            ca r11 = (ca) ZeusTransformUtils.preCheckCast(this.f15277c.f38504a, ca.class, "com.obric.aiagent.plugin");
            IntentExecutionRecord r12 = null;
            if (r11 == null) goto L13;
            ca.a.a(r11, null, 1, null);
        L13:
            if (r8 == null) goto L26;
            List<IntentExecutionRecord> r13 = r8.getExecRecords();
            if (r13 == null) goto L26;
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin");
            b r2 = this.f15278d;
            Iterator r15 = r14.iterator();
        L18:
            if (r15.hasNext() == false) goto L22;
            Object r3 = r15.next();
            if (o.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r3, IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getIntentName(), r2.a()) == false) goto L18;
        L23:
            IntentExecutionRecord r16 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r3, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L26;
            r12 = r16;
        L30:
            if (r12 == null) goto L34;
            IntentResult<?> r17 = r12.getResult();
            if (r17 == null) goto L34;
            r0 = r17.getRet();
        L34:
            if (r0 != 0) goto L36;
            String r18 = "success";
        L37:
            ILogDepend.Companion.i(a.TAG, "onUserClickSendStateless finished intent=" + this.f15278d.a() + ", entityId=" + this.f15279e + ", ecaId=" + this.f + ", ret=" + r0 + ", state=" + r18);
            com.obric.agent.entitysync.b.f14469a.a(this.f15279e, r18, this.f15278d.e());
            a.c().remove(this.f15279e);
            this.g.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        L36:
            a.a(a.f15240a, r0);
            r18 = "failed";
            goto L37
        L22:
            r3 = null;
        L26:
            if (r8 == null) goto L30;
            List<IntentExecutionRecord> r19 = r8.getExecRecords();
            if (r19 == null) goto L30;
            r12 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(p.l(r19), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            goto L30
        L9:
            return x.f38692a;
        L5:
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    @d.c.b.a.f(b = "MessageSendConfirmHandler.kt", c = {959}, d = "invokeSuspend", e = "com.obric.agent.office.MessageSendConfirmHandler$onUserClickSendStateless$3")
    static final class h extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f15281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f15283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f15284e;
        final /* synthetic */ z.f<com.obric.agent.f> f;
        final /* synthetic */ String g;
        final /* synthetic */ long h;

        h(AtomicBoolean r3, String r4, b r5, IAppIntentFeedback r6, z.f<com.obric.agent.f> r7, String r8, long r9, d.c.d<? super h> r11) {
            IAppIntentFeedback r10 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r6, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15281b = r3;
            this.f15282c = r4;
            this.f15283d = r5;
            this.f15284e = r10;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            super(2, r12);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15281b, this.f15282c, this.f15283d, this.f15284e, this.f, this.g, this.h, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15280a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            if (this.f15281b.compareAndSet(false, true) == false) goto L14;
            com.obric.agent.entitysync.b.f14469a.a(this.f15282c, "failed", this.f15283d.e());
            a.c().remove(this.f15282c);
            IAppIntentFeedback r8 = this.f15284e;
            if (this.f.f38504a != null) goto L18;
            o.c("listener");
            com.obric.agent.f r2 = null;
        L19:
            r8.removeActionFinishedListener(r2);
            ILogDepend.Companion.e(a.TAG, "onUserClickSendStateless timeout, intent=" + this.f15283d.a() + ", entityId=" + this.f15282c + ", ecaId=" + this.g + ", reqId=" + this.h);
            return x.f38692a;
        L18:
            r2 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(this.f.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
            goto L19
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15280a = 1;
            if (ax.a(35000, r9) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    public static final class i extends LinkedHashMap<String, C0312a> {
        i() {
            super(10, 0.75f, true);
        }

        public C0312a a(String r2) {
            return (C0312a) ZeusTransformUtils.preCheckCast(super.get(r2), C0312a.class, "com.obric.aiagent.plugin");
        }

        public C0312a a(String r1, C0312a r2) {
            return (C0312a) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), C0312a.class, "com.obric.aiagent.plugin");
        }

        public Collection<C0312a> a() {
            return super.values();
        }

        public boolean a(C0312a r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public boolean b(String r1) {
            return super.containsKey(r1);
        }

        public boolean b(String r1, C0312a r2) {
            return super.remove(r1, r2);
        }

        public C0312a c(String r2) {
            return (C0312a) ZeusTransformUtils.preCheckCast(super.remove(r2), C0312a.class, "com.obric.aiagent.plugin");
        }

        public Set<Map.Entry<String, C0312a>> c() {
            return super.entrySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, C0312a.class) == true) goto L7;
            return false;
        L7:
            return a((C0312a) ZeusTransformUtils.preCheckCast(r3, C0312a.class, "com.obric.aiagent.plugin"));
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, C0312a>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (C0312a) ZeusTransformUtils.preCheckCast(r4, C0312a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<String> keySet() {
            return d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object remove(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, C0312a.class) == true) goto L9;
            return false;
        L9:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (C0312a) ZeusTransformUtils.preCheckCast(r4, C0312a.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<C0312a> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, C0312a> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 10) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: MessageSendConfirmHandler.kt */
    public static final class j implements com.obric.agent.p {
        j() {
        }

        @Override // com.obric.agent.p
        public Object a(String r2, int r3, d.c.d<? super x> r4) {
            d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            if (r3 != 10) goto L5;
            b r5 = a.a(a.f15240a, r2);
            if (r5 == null) goto L10;
            a.a(a.f15240a, r5);
            return x.f38692a;
        L10:
            i r6 = a.a();
            monitor-enter(r6);
            C0312a r7 = (C0312a) ZeusTransformUtils.preCheckCast(a.a().get(r2), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
            monitor-exit(r6);
            if (r7 == null) goto L16;
            a.a(a.f15240a, r2, r7);
            return x.f38692a;
        L16:
            return x.f38692a;
        L19:
            th = move-exception;
            throw th;
        L5:
            return x.f38692a;
        }
    }

    public static /* synthetic */ Gson lambda$DtPHEUIo5P7R5slgIiaCi0s0c3w() {
        return e();
    }

    public static /* synthetic */ ContactEntity lambda$pumXuLcfYVcWmVOt1HxA4HPYN0Q(String r0) {
        return d(r0);
    }

    private a() {
    }

    public static final /* synthetic */ b a(a r0, String r1) {
        return r0.c(r1);
    }

    public static final /* synthetic */ i a() {
        return f15242c;
    }

    public static final /* synthetic */ Object a(a r2, IntentAppAction r3, OfficeSendMessageParams r4, d.c.d r5) {
        return r2.b(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(a r0, int r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, b r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(a r0, String r1, C0312a r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView b() {
        return f15244e;
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView c() {
        return f;
    }

    static {
        f15240a = new a();
        f15241b = d.g.a($$Lambda$a$DtPHEUIo5P7R5slgIiaCi0s0c3w.INSTANCE);
        f15242c = new i();
        f15244e = ConcurrentHashMap.newKeySet();
        f = ConcurrentHashMap.newKeySet();
    }

    private final Gson d() {
        return (Gson) ZeusTransformUtils.preCheckCast(f15241b.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson e() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    public final void a(IAgentService r3) {
        IAgentService r4 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r3, IAgentService.class, "com.obric.aiagent.plugin");
        o.e(r4, "agentService");
        b(r4);
    }

    public final boolean a(IntentAppAction r22) {
        o.e(r22, "action");
        IEntityManager r0 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        String r1 = r0.replaceECAIdToEntity(r22.getContent(), r22.getQuestionId());
        if (r1 == null) goto L7;
    L8:
        r22.setContent(r1);
        String r10 = a(r22, "Messages_Send");
        ContactEntity r12 = a(this, r22, null, 2, null);
        String r13 = b(r22, "Messages_Send");
        MessageEntity r4 = a(r12, r13, r10, r22, c("Messages_Send", r22));
        if (r4 != null) goto L12;
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.w(TAG, "handleMessagesSend: build MessageEntity failed, fallback");
        return false;
    L12:
        String r15 = c(r22);
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L21;
        u r6 = u.f16076a;
        Gson r14 = d();
        o.c(r14, "<get-gson>(...)");
        MessagesSendParams r7 = (MessagesSendParams) ZeusTransformUtils.preCheckCast(r6.a(r14, r15, MessagesSendParams.class, new MessagesSendParams(new ContactTarget(null, r12), new MessageContent(r13, null, null, null)), "MessageSendConfirm_handleMessagesSend"), MessagesSendParams.class, "com.obric.aiagent.plugin");
    L22:
        ContactTarget r8 = r7.getTarget();
        if (r8 == null) goto L25;
        String r9 = r8.getTelephone();
    L26:
        ConcurrentHashMap<String, String> r11 = r22.getExt();
        if (r11 == null) goto L29;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r11.get("contract_entity"), String.class, "com.obric.aiagent.plugin");
    L30:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin");
        if (r17 != null) goto L33;
    L36:
        boolean r18 = true;
    L37:
        boolean r19 = !r18;
        ContactTarget r20 = r7.getTarget();
        if (r20 == null) goto L43;
        ContactEntity r21 = r20.getContact();
        if (r21 == null) goto L43;
        r12 = r21;
    L43:
        CharSequence r23 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");
        if (r23 != null) goto L46;
    L49:
        boolean r24 = true;
    L50:
        if (r24 == false) goto L55;
        if (r19 == true) goto L55;
        if (r12 != null) goto L55;
        ILogDepend.Companion.w(TAG, "handleMessagesSend: contact ECAId not resolved, return CONTACT_NOT_EXIST_ERROR to server");
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r22, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(ErrorCode.Message.MESSAGE_TARGET_NOT_FOUND, "联系人不存在。", null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return true;
    L55:
        JsonObject r25 = com.obric.agent.utils.b.f15994a.a(r7);
        r22.setContent(com.obric.agent.utils.b.f15994a.a("Messages_Send", r25, null));
        return a(r22, "Messages_Send", r10, r4, r25);
    L46:
        if (r23.length() == 0) goto L49;
        r24 = false;
        goto L50
    L33:
        if (r17.length() == 0) goto L36;
        r18 = false;
        goto L37
    L29:
        r16 = null;
        goto L30
    L25:
        r9 = null;
        goto L26
    L21:
        r7 = new MessagesSendParams(new ContactTarget(null, r12), new MessageContent(r13, null, null, null));
        goto L22
    L15:
        if (r3.length() == 0) goto L18;
        r5 = false;
    L7:
        r1 = r22.getContent();
        goto L8
    }

    public final Object a(IntentAppAction r26, OfficeSendMessageParams r27, d.c.d<? super Boolean> r28) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r28, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        if ((r5.g & Integer.MIN_VALUE) == 0) goto L7;
        r5.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.f15264e;
        Object r6 = d.c.a.b.a();
        int r7 = r5.g;
        boolean r9 = true;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r5.f15263d, String.class, "com.obric.aiagent.plugin");
        OfficeSendMessageParams r1 = (OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r5.f15262c, OfficeSendMessageParams.class, "com.obric.aiagent.plugin");
        IntentAppAction r2 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r5.f15261b, IntentAppAction.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.preCheckCast(r5.f15260a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r13 = r0;
        IntentAppAction r11 = r2;
        a r10 = r8;
    L24:
        MessageEntity r12 = (MessageEntity) ZeusTransformUtils.preCheckCast(r4, MessageEntity.class, "com.obric.aiagent.plugin");
        String r14 = "";
        if (r12 != null) goto L49;
        String r15 = r10.c("Office_SendMessage", r11);
        List r20 = p.b();
        OfficeMessageContent r16 = r1.getContent();
        if (r16 == null) goto L29;
        String r17 = r16.getText();
    L30:
        if (r17 != null) goto L32;
        r17 = "";
    L32:
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
        if (r18.length() != 0) goto L35;
        boolean r19 = true;
    L36:
        if (r19 == false) goto L44;
        OfficeMessageContent r21 = r1.getContent();
        if (r21 == null) goto L40;
        CloudDocumentEntity r22 = r21.getDoc();
    L41:
        if (r22 == null) goto L43;
        r18 = "飞书文档";
        goto L44
    L43:
        r18 = "文件";
        goto L44
    L40:
        r22 = null;
    L44:
        r12 = new MessageEntity(r15, 0, 1, r20, (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin"), null, 32, null);
        if (r13 != null) goto L47;
        String r23 = "";
    L48:
        r12.set_packageName(r23);
        goto L49
    L47:
        r23 = r13;
        goto L48
    L35:
        r19 = false;
        goto L36
    L29:
        r17 = null;
    L49:
        MessageEntity r110 = r12;
        CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r110.get_packageName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r24 != null) goto L52;
    L55:
        if (r9 == false) goto L60;
        if (r13 != null) goto L58;
        String r25 = "";
    L59:
        r110.set_packageName(r25);
        goto L60
    L58:
        r25 = r13;
    L60:
        com.obric.agent.utils.b r29 = com.obric.agent.utils.b.f15994a;
        if (r1.getContent() != null) goto L68;
        String r30 = r110.getText();
        if (r30 == null) goto L66;
        r14 = r30;
    L66:
        r1.setContent(new OfficeMessageContent(r14, null, null));
    L68:
        return d.c.b.a.b.a(r10.a(r11, "Office_SendMessage", r13, r110, r29.a(r1)));
    L52:
        if (r24.length() == 0) goto L55;
        r9 = false;
        goto L55
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        IEntityManager r31 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r31 == null) goto L19;
        String r32 = r31.replaceECAIdToEntity(r26.getContent(), r26.getQuestionId());
        if (r32 == null) goto L19;
    L20:
        r26.setContent(r32);
        String r33 = a(r26, "Office_SendMessage");
        r5.f15260a = this;
        r5.f15261b = r26;
        r5.f15262c = r27;
        r5.f15263d = r33;
        r5.g = 1;
        Object r34 = b(r26, r27, r5);
        if (r34 != r6) goto L23;
        return r6;
    L23:
        r10 = this;
        r11 = r26;
        r1 = r27;
        r13 = r33;
        r4 = r34;
    L19:
        r32 = r26.getContent();
    L7:
        r5 = new d(this, r3);
        goto L8
    }

    private final boolean a(IntentAppAction r32, String r33, String r34, MessageEntity r35, JsonObject r36) {
        List<? extends AppEntity> r1 = p.a(r35);
        IEntityManager r2 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L5;
        r2.addEntities(r1);
    L5:
        String r8 = d().toJson(r1);
        if (n.f15202a.a((Map) ZeusTransformUtils.preCheckCast(r32.getExt(), Map.class, "com.obric.aiagent.plugin")) == false) goto L9;
        ILogDepend.Companion.i(TAG, "skip local intent card because model decode card is enabled");
        a(this, null, 1, null);
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r32, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, r8, null, 46, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return true;
    L9:
        Gson r3 = EntityExtKt.a();
        DataSource r4 = new DataSource(d.o.o.a(r33, "_", null, 2, null), r33, null, 4, null);
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(p.a(r35), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r5, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        r6.add(AppIntentCardData.Companion.a((AppEntity) ZeusTransformUtils.preCheckCast((MessageEntity) ZeusTransformUtils.preCheckCast(r7.next(), MessageEntity.class, "com.obric.aiagent.plugin"), AppEntity.class, "com.obric.aiagent.plugin")));
        goto L11
    L13:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        d.m[] r10 = new d.m[2];
        boolean r23 = false;
        r10[0] = s.a("msg_send_status", "confirm");
        if (r34 != null) goto L16;
        String r11 = "";
    L17:
        r10[1] = s.a("package_name", r11);
        String r15 = r3.toJson(new AppIntentMessage(r4, false, false, null, null, false, false, null, r9, ao.a(r10), 254, null));
        IAgentService r24 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L20;
        o.a(r15);
        IMMessage r12 = IAgentService.a.a(r24, r15, OAppIntentBizContentType.MSG_CONFIRM_CARD, String.valueOf(r32.getQuestionId()), 0, 8, null);
    L21:
        if (r12 == null) goto L23;
        String r13 = r12.getLocalMessageId();
    L24:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L27;
    L28:
        r23 = true;
    L29:
        if (r23 == false) goto L32;
        ILogDepend.Companion.w(TAG, "showConfirmCard: addMutableMessageForLark localMessageId empty");
        return true;
    L32:
        i r16 = f15242c;
        monitor-enter(r16);
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r16, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L38
        long r18 = r32.getQuestionId();     // Catch: Throwable -> L38
        o.a(r15);     // Catch: Throwable -> L38
        r17.put(r13, new C0312a(r33, r34, r36, r18, r15));     // Catch: Throwable -> L38
        x r19 = x.f38692a;     // Catch: Throwable -> L38
        monitor-exit(r16);
        a(this, null, 1, null);
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r32, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, r8, null, 46, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return true;
    L38:
        th = move-exception;
        throw th;
    L27:
        if (r14.length() != 0) goto L29;
    L23:
        r13 = null;
        goto L24
    L20:
        r12 = null;
        goto L21
    L16:
        r11 = r34;
        goto L17
    }

    public final MessageEntity a(IntentAppAction r3, String r4, Object r5) {
        o.e(r3, "action");
        o.e(r4, "intentName");
        String r0 = a(r3, r4);
        if (o.a(r4, "Office_SendMessage") == false) goto L6;
        return a(r5, r0);
    L6:
        if (o.a(r4, "Messages_Send") == true) goto L11;
        return null;
    L11:
        return a(r3, r4, r0);
    }

    private final MessageEntity a(Object r3, String r4) {
        MessageEntity r2 = a(r3);
        if (r2 != null) goto L6;
        ILogDepend.Companion.w(TAG, "buildOfficeDisplayEntity: no MessageEntity in executed result");
        return null;
    L6:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r2.get_packageName(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == false) goto L17;
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r2.set_packageName(r4);
    L17:
        return r2;
    L9:
        if (r5.length() == 0) goto L12;
        r6 = false;
        goto L13
    }

    private final MessageEntity a(IntentAppAction r11, String r12, String r13) {
        return a(this, a(this, r11, null, 2, null), b(r11, r12), r13, r11, null, 16, null);
    }

    private final MessageEntity a(Object r6) {
        if (ZeusTransformUtils.instanceOf(r6, MessageEntity.class) == false) goto L6;
        return (MessageEntity) ZeusTransformUtils.preCheckCast(r6, MessageEntity.class, "com.obric.aiagent.plugin");
    L6:
        if ((r6 instanceof Object[]) == false) goto L17;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin");
        int r7 = 0;
        int r2 = r5.length;
    L8:
        if (r7 >= r2) goto L38;
        Object r3 = r5[r7];
        if (ZeusTransformUtils.instanceOf(r3, MessageEntity.class) == false) goto L12;
        MessageEntity r4 = (MessageEntity) ZeusTransformUtils.preCheckCast(r3, MessageEntity.class, "com.obric.aiagent.plugin");
    L13:
        if (r4 != null) goto L36;
        r7 = r7 + 1;
        goto L8
    L36:
        return r4;
    L12:
        r4 = null;
        goto L13
    L38:
        return null;
    L17:
        if (ZeusTransformUtils.instanceOf(r6, Iterable.class) == false) goto L37;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r8.hasNext() == false) goto L39;
        Object r9 = r8.next();
        if (ZeusTransformUtils.instanceOf(r9, MessageEntity.class) == false) goto L24;
        MessageEntity r10 = (MessageEntity) ZeusTransformUtils.preCheckCast(r9, MessageEntity.class, "com.obric.aiagent.plugin");
    L25:
        if (r10 == null) goto L20;
        return r10;
    L24:
        r10 = null;
        goto L25
    L39:
        return null;
    L37:
        return null;
    }

    public final String a(IntentAppAction r3, String r4) {
        o.e(r3, "action");
        o.e(r4, "intentName");
        ConcurrentHashMap<String, String> r2 = r3.getExt();
        if (r2 == null) goto L16;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("package_name"), String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r5 = null;
    L13:
        if (r5 == null) goto L16;
        return r5;
    L9:
        r0 = false;
    L16:
        if (o.a(r4, "Office_SendMessage") == false) goto L19;
        return "com.ss.android.lark";
    L19:
        if (o.a(r4, "Messages_Send") == false) goto L23;
        return "com.android.mms";
    L23:
        return null;
    }

    static /* synthetic */ MessageEntity a(a r6, ContactEntity r7, String r8, String r9, IntentAppAction r10, String r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L6;
        r11 = "msg_send";
    L6:
        return r6.a(r7, r8, r9, r10, r11);
    }

    private final MessageEntity a(ContactEntity r11, String r12, String r13, IntentAppAction r14, String r15) {
        List r0 = null;
        if (r11 == null) goto L24;
        List<MetaTelephone> r10 = r11.getTelephones();
        if (r10 == null) goto L23;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r18 = r16.iterator();
    L7:
        boolean r3 = true;
        if (r18.hasNext() == false) goto L18;
        String r2 = ((MetaTelephone) ZeusTransformUtils.preCheckCast(r18.next(), MetaTelephone.class, "com.obric.aiagent.plugin")).getTelephone();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L13;
        r3 = false;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L7;
        r17.add(r2);
        goto L7
    L18:
        List<String> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.aiagent.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L22;
        r19 = null;
    L22:
        if (r19 == null) goto L23;
    L25:
        List<String> r7 = r19;
        if (r11 == null) goto L28;
        r0 = p.a(r11);
    L28:
        MessageEntity r110 = new MessageEntity(r15, 0, 1, r7, r12, r0);
        if (r13 != null) goto L31;
        r13 = "";
    L31:
        r110.set_packageName(r13);
        return r110;
    L23:
        r19 = p.b();
        goto L25
    L24:
        r19 = b(r14);
        goto L25
    }

    private final List<String> b(IntentAppAction r4) {
        String r5 = c(r4);
        if (r5 == null) goto L5;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L37
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        JsonElement r6 = JsonParser.parseString(r5).getAsJsonObject().get("target");     // Catch: Throwable -> L37
        if (r6 == null) goto L34;
        String r2 = null;
        if (r6.isJsonObject() == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L34;
        JsonObject r7 = r6.getAsJsonObject();     // Catch: Throwable -> L37
        if (r7 == null) goto L34;
        JsonElement r8 = r7.get(SensitiveType.TELEPHONE);     // Catch: Throwable -> L37
        if (r8 != null) goto L19;
    L31:
        if (r2 == null) goto L33;
        List r9 = p.a(r2);     // Catch: Throwable -> L37
    L35:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L37
    L39:
        Throwable r11 = d.n.c(r10);
        if (r11 == null) goto L44;
        ILogDepend.Companion.w(TAG, "parseTargetTelephones failed: " + r11.getMessage());
        r10 = p.b();
    L44:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
    L33:
        r9 = p.b();     // Catch: Throwable -> L37
        goto L35
    L19:
        if (r8.isJsonPrimitive() == true) goto L22;
        r8 = null;
    L22:
        if (r8 == null) goto L31;
        String r12 = r8.getAsString();     // Catch: Throwable -> L37
        if (r12 == null) goto L31;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L31;
        r2 = r12;
        goto L31
    L28:
        r13 = false;
    L34:
        r9 = p.b();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.n.a r14 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L39
    L5:
        return p.b();
    }

    private final ContactEntity a(String r4) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        ContactEntity r2 = b(r4);
        if (r2 == null) goto L29;
        return r2;
    L29:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L17
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        JsonObject r6 = JsonParser.parseString(r4).getAsJsonObject();     // Catch: Throwable -> L17
        r6.remove("extras");     // Catch: Throwable -> L17
        Object r7 = d.n.f(r6);     // Catch: Throwable -> L17
    L20:
        if (d.n.b(r7) == false) goto L22;
        r7 = null;
    L22:
        JsonObject r8 = (JsonObject) ZeusTransformUtils.preCheckCast(r7, JsonObject.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L25;
        return null;
    L25:
        String r9 = r8.toString();
        o.c(r9, "toString(...)");
        ContactEntity r10 = b(r9);
        if (r10 != null) goto L28;
        ILogDepend.Companion.w(TAG, "parseContractEntity failed for canonical and legacy formats");
    L28:
        return r10;
    L17:
        th = move-exception;
        d.n.a r11 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L20
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    private final ContactEntity b(String r3) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = d.n.f((ContactEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r3, ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L8:
        if (d.n.c(r4) == null) goto L15;
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L12
        r4 = d.n.f((ContactEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.c().fromJson(r3, ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
    L15:
        if (d.n.b(r4) == false) goto L18;
        r4 = null;
    L18:
        return (ContactEntity) ZeusTransformUtils.preCheckCast(r4, ContactEntity.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r7 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L8
    }

    public static /* synthetic */ ContactEntity a(a r1, IntentAppAction r2, d.h.a.b r3, int r4, Object r5) {
        d.h.a.b<? super String, ContactEntity> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L6;
        r6 = $$Lambda$a$pumXuLcfYVcWmVOt1HxA4HPYN0Q.INSTANCE;
    L6:
        return r1.a(r2, r6);
    }

    private static final ContactEntity d(String r3) {
        o.e(r3, "ecaId");
        IEntityManager r0 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        List<AppEntity> r4 = r0.getEntityByEcaId(r3);
        if (r4 == null) goto L7;
        AppEntity r5 = (AppEntity) ZeusTransformUtils.preCheckCast(p.l(r4), AppEntity.class, "com.obric.aiagent.plugin");
    L9:
        if (ZeusTransformUtils.instanceOf(r5, ContactEntity.class) == true) goto L11;
        return null;
    L11:
        return (ContactEntity) ZeusTransformUtils.preCheckCast(r5, ContactEntity.class, "com.obric.aiagent.plugin");
    L7:
        r5 = null;
        goto L9
    }

    public final ContactEntity a(IntentAppAction r4, d.h.a.b<? super String, ContactEntity> r5) {
        d.h.a.b<? super String, ContactEntity> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "action");
        o.e(r6, "resolveByEcaId");
        ConcurrentHashMap<String, String> r0 = r4.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("contract_entity"), String.class, "com.obric.aiagent.plugin");
    L6:
        ContactEntity r2 = a(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        return b(r4, r6);
    L5:
        r1 = null;
        goto L6
    }

    private final ContactEntity b(IntentAppAction r5, d.h.a.b<? super String, ContactEntity> r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        String r8 = c(r5);
        Object r0 = null;
        if (r8 != null) goto L48;
        return null;
    L48:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L37
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        JsonElement r9 = JsonParser.parseString(r8).getAsJsonObject().get("target");     // Catch: Throwable -> L37
        if (r9 != null) goto L8;
    L34:
        ContactEntity r10 = null;
    L35:
        Object r11 = d.n.f(r10);     // Catch: Throwable -> L37
    L39:
        Throwable r12 = d.n.c(r11);
        if (r12 == null) goto L43;
        ILogDepend.Companion.w(TAG, "resolveContactByEcaIdFromAction failed: " + r12.getMessage());
    L43:
        if (d.n.b(r11) == true) goto L47;
        r0 = r11;
    L47:
        return (ContactEntity) ZeusTransformUtils.preCheckCast(r0, ContactEntity.class, "com.obric.aiagent.plugin");
    L8:
        if (r9.isJsonObject() == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L34;
        JsonObject r13 = r9.getAsJsonObject();     // Catch: Throwable -> L37
        if (r13 == null) goto L34;
        JsonElement r14 = r13.get("contact");     // Catch: Throwable -> L37
        if (r14 == null) goto L34;
        if (r14.isJsonPrimitive() == true) goto L21;
    L23:
        String r15 = null;
    L24:
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        if (r16 != null) goto L27;
    L30:
        boolean r17 = true;
    L31:
        if (r17 == true) goto L34;
        r10 = (ContactEntity) ZeusTransformUtils.preCheckCast(r7.invoke(r15), ContactEntity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        goto L35
    L27:
        if (r16.length() == 0) goto L30;
        r17 = false;
        goto L31
    L21:
        if (r14.getAsJsonPrimitive().isString() == false) goto L23;
        r15 = r14.getAsString();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        d.n.a r18 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L39
    }

    private final String b(IntentAppAction r6, String r7) {
        String r8 = c(r6);
        Object r1 = "";
        if (r8 != null) goto L54;
        return "";
    L54:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L46
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        JsonElement r9 = JsonParser.parseString(r8).getAsJsonObject().get("content");     // Catch: Throwable -> L46
        if (r9 == null) goto L43;
        JsonElement r3 = null;
        if (r9.isJsonObject() == true) goto L11;
        r9 = null;
    L11:
        if (r9 == null) goto L43;
        JsonObject r10 = r9.getAsJsonObject();     // Catch: Throwable -> L46
        if (r10 == null) goto L43;
        JsonElement r11 = r10.get("text");     // Catch: Throwable -> L46
        if (r11 != null) goto L18;
    L23:
        String r12 = null;
    L24:
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L46
        if (r4 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == true) goto L34;
    L44:
        Object r14 = d.n.f(r12);     // Catch: Throwable -> L46
    L48:
        Throwable r15 = d.n.c(r14);
        if (r15 != null) goto L51;
        r1 = r14;
    L53:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L51:
        ILogDepend.Companion.w(TAG, "parseMessageText failed: " + r15.getMessage());
        goto L53
    L34:
        if (o.a(r7, "Office_SendMessage") == false) goto L42;
        JsonElement r16 = r10.get("doc");     // Catch: Throwable -> L46
        if (r16 != null) goto L38;
    L40:
        if (r3 == null) goto L42;
        r12 = "飞书文档";
        goto L44
    L38:
        if ((!r16.isJsonNull()) == false) goto L40;
        r3 = r16;
    L42:
        r12 = "[图片]";
        goto L44
    L27:
        if (r4.length() == 0) goto L30;
        r13 = false;
        goto L31
    L18:
        if (r11.isJsonPrimitive() == true) goto L21;
        r11 = null;
    L21:
        if (r11 == null) goto L23;
        r12 = r11.getAsString();     // Catch: Throwable -> L46
    L43:
        r12 = "";
    L46:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r14 = d.n.f(d.o.a(th));
        goto L48
    }

    private final String c(IntentAppAction r6) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        JsonElement r7 = JsonParser.parseString(r6.getContent());     // Catch: Throwable -> L11
        if (r7.isJsonObject() == false) goto L8;
        JsonElement r8 = r7.getAsJsonObject().get("Content");     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        String r9 = r8.getAsString();     // Catch: Throwable -> L11
    L9:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L11
    L14:
        if (d.n.b(r10) == false) goto L16;
        r10 = null;
    L16:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L19;
        return null;
    L19:
        u r4 = u.f16076a;
        Gson r5 = d();
        o.c(r5, "<get-gson>(...)");
        com.obric.agent.dm.e r12 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(r4.a(r5, r11, com.obric.agent.dm.e.class, "MsgSend_destructInputParams"), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L28;
        List<com.obric.agent.dm.f> r13 = r12.a();
        if (r13 == null) goto L28;
        com.obric.agent.dm.f r14 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(p.l(r13), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L28;
        List<com.obric.agent.dm.b> r15 = r14.a();
        if (r15 == null) goto L28;
        com.obric.agent.dm.b r16 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(p.n(r15), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
    L29:
        if (r16 == null) goto L45;
        JsonObject r17 = r16.c();
        if (r17 == null) goto L45;
        JsonObject r18 = r17.getAsJsonObject();
        if (r18 == null) goto L45;
        JsonObject r19 = r18.deepCopy();
        Iterator<String> r1 = r18.keySet().iterator();
    L37:
        if (r1.hasNext() == false) goto L44;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r21 = r18.get(r20);
        if (r21.isJsonObject() == false) goto L37;
        JsonElement r22 = r21.getAsJsonObject().get("value");
        if (r22 == null) goto L37;
        r19.add(r20, r22);
        goto L37
    L44:
        return r19.toString();
    L45:
        return null;
    L28:
        r16 = null;
    L8:
        r9 = null;
    L11:
        th = move-exception;
        d.n.a r23 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L14
    }

    static /* synthetic */ void a(a r1, IAgentService r2, int r3, Object r4) {
        IAgentService r5 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r2, IAgentService.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        r1.b(r5);
    }

    private final void b(IAgentService r4) {
        IAgentService r5 = (IAgentService) ZeusTransformUtils.wrapperContextForParams(r4, IAgentService.class, "com.obric.aiagent.plugin");
        if (f15243d == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (f15243d == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        j r0 = new j();     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        r5 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r5 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        r5.addLarkSendCardListener((com.obric.agent.p) ZeusTransformUtils.preCheckCast(r0, com.obric.agent.p.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        f15243d = true;     // Catch: Throwable -> L19
        x r6 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [T, kotlinx.coroutines.ca] */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, com.obric.agent.office.a$e] */
    private final void a(String r24, C0312a r25) {
        ConcurrentHashMap.KeySetView<String, Boolean> r1 = f15244e;
        if (r1.add(r24) == true) goto L6;
        ILogDepend.Companion.w(TAG, "onUserClickSend ignored: send already in flight, localMsgId=" + r24);
        return;
    L6:
        long r11 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        IAppIntentFeedback r13 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L17;
        r1.remove(r24);
        a(r24, "failed");
        i r2 = f15242c;
        monitor-enter(r2);
        C0312a r0 = (C0312a) ZeusTransformUtils.preCheckCast(r2.remove(r24), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        monitor-exit(r2);
        ILogDepend.Companion.e(TAG, "onUserClickSend failed: feedback service unavailable");
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        AtomicBoolean r14 = new AtomicBoolean(false);
        z.f r9 = new z.f();
        z.f r8 = new z.f();
        r8.f38504a = new e(r11, r14, r9, r24, r13, r25);
        if (r8.f38504a != 0) goto L20;
        o.c("listener");
        com.obric.agent.f r3 = null;
    L21:
        r13.addLocalActionFinishedListener(r3);
        r9.f38504a = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new f(r14, r24, r13, r8, r25, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        ILogDepend.Companion.i(TAG, "onUserClickSend localMsgId=" + r24 + " intent=" + r25.a() + " reqId=" + r11);
        d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L24
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        com.obric.agent.utils.b.f15994a.a(r25.a(), r25.c(), r25.b(), r11);     // Catch: Throwable -> L24
        Object r6 = d.n.f(x.f38692a);     // Catch: Throwable -> L24
    L26:
        Throwable r7 = d.n.c(r6);
        if (r7 != null) goto L29;
        return;
    L29:
        if (r14.compareAndSet(false, true) == false) goto L45;
        ca r10 = (ca) ZeusTransformUtils.preCheckCast(r9.f38504a, ca.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L33;
        ca.a.a(r10, null, 1, null);
    L33:
        f15240a.a(r24, "failed");
        i r12 = f15242c;
        monitor-enter(r12);
        C0312a r15 = (C0312a) ZeusTransformUtils.preCheckCast(r12.remove(r24), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L42
        monitor-exit(r12);
        f15244e.remove(r24);
        if (r8.f38504a != 0) goto L40;
        o.c("listener");
        com.obric.agent.f r16 = null;
    L41:
        r13.removeActionFinishedListener(r16);
        goto L45
    L40:
        r16 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(r8.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
    L42:
        th = move-exception;
        throw th;
    L45:
        ILogDepend.Companion.e(TAG, "onUserClickSend dispatch failed", r7);
        return;
    L24:
        th = move-exception;
        d.n.a r17 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L26
    L20:
        r3 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(r8.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
        goto L21
    }

    private final b c(String r12) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        Object r4 = null;
        if (r1 == false) goto L109;
        return null;
    L109:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L98
        a r11 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L98
        JsonElement r13 = JsonParser.parseString(r12);     // Catch: Throwable -> L98
        if (r13.isJsonObject() == true) goto L15;
        return null;
    L15:
        JsonObject r14 = r13.getAsJsonObject();     // Catch: Throwable -> L98
        JsonElement r15 = r14.get("o_stateless_send");     // Catch: Throwable -> L98
        if (r15 != null) goto L18;
    L25:
        boolean r16 = false;
    L26:
        if (r16 == true) goto L28;
        return null;
    L28:
        JsonElement r17 = r14.get(Ext.KEY_INTENT_NAME);     // Catch: Throwable -> L98
        if (r17 != null) goto L31;
    L97:
        return null;
    L31:
        if (r17.isJsonPrimitive() == true) goto L34;
        r17 = null;
    L34:
        if (r17 == null) goto L97;
        String r18 = r17.getAsString();     // Catch: Throwable -> L98
        if (r18 == null) goto L97;
        if (d.a.ax.a(new String[]{"Messages_Send", "Office_SendMessage"}).contains(r18) == false) goto L40;
        String r6 = r18;
    L41:
        if (r6 == null) goto L97;
        JsonElement r19 = r14.get("package_name");     // Catch: Throwable -> L98
        if (r19 != null) goto L45;
    L50:
        String r8 = null;
    L51:
        JsonElement r110 = r14.get("entity_eca_id");     // Catch: Throwable -> L98
        if (r110 != null) goto L54;
    L68:
        String r9 = null;
    L69:
        JsonElement r111 = r14.get("widget_message_id");     // Catch: Throwable -> L98
        if (r111 != null) goto L72;
    L85:
        String r10 = null;
    L86:
        JsonElement r112 = r14.get("params");     // Catch: Throwable -> L98
        if (r112 != null) goto L89;
    L94:
        JsonObject r7 = null;
    L95:
        Object r113 = d.n.f(new b(r6, r7, r8, r9, r10));     // Catch: Throwable -> L98
    L100:
        Throwable r114 = d.n.c(r113);
        if (r114 == null) goto L104;
        ILogDepend.Companion.w(TAG, "parseStatelessSendPayload failed: " + r114.getMessage());
    L104:
        if (d.n.b(r113) == true) goto L108;
        r4 = r113;
    L108:
        return (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin");
    L89:
        if (r112.isJsonObject() == true) goto L92;
        r112 = null;
    L92:
        if (r112 == null) goto L94;
        r7 = r112.getAsJsonObject();     // Catch: Throwable -> L98
        goto L95
    L72:
        if (r111.isJsonPrimitive() == true) goto L75;
        r111 = null;
    L75:
        if (r111 == null) goto L85;
        String r115 = r111.getAsString();     // Catch: Throwable -> L98
        if (r115 == null) goto L85;
        String r116 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L98
        if (r116 == null) goto L85;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r116, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L83;
        r2 = true;
    L83:
        if (r2 == false) goto L85;
        r10 = r116;
        goto L86
    L54:
        if (r110.isJsonPrimitive() == true) goto L57;
        r110 = null;
    L57:
        if (r110 == null) goto L68;
        String r117 = r110.getAsString();     // Catch: Throwable -> L98
        if (r117 == null) goto L68;
        String r118 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L98
        if (r118 == null) goto L68;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L65;
        boolean r5 = true;
    L66:
        if (r5 == false) goto L68;
        r9 = r118;
        goto L69
    L65:
        r5 = false;
        goto L66
    L45:
        if (r19.isJsonPrimitive() == true) goto L48;
        r19 = null;
    L48:
        if (r19 == null) goto L50;
        r8 = r19.getAsString();     // Catch: Throwable -> L98
        goto L51
    L40:
        r6 = null;
        goto L41
    L18:
        if (r15.isJsonPrimitive() == true) goto L21;
        r15 = null;
    L21:
        if (r15 == null) goto L25;
        if (r15.getAsBoolean() != true) goto L25;
        r16 = true;
    L98:
        th = move-exception;
        d.n.a r119 = d.n.f38560a;
        r113 = d.n.f(d.o.a(th));
        goto L100
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final JsonObject a(JsonObject r7) {
        JsonObject r6 = new JsonObject();
        Iterator<String> r0 = r7.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r2 = r7.get(r1);
        if (r2.isJsonObject() == false) goto L10;
        if (r2.getAsJsonObject().has("value") == false) goto L10;
        r6.add(r1, r2);
    L10:
        JsonObject r4 = new JsonObject();
        r4.add("value", r2);
        x r3 = x.f38692a;
        r6.add(r1, (JsonElement) ZeusTransformUtils.preCheckCast(r4, JsonElement.class, "com.obric.aiagent.plugin"));
        goto L4
    L11:
        return r6;
    }

    public final JsonObject a(String r12, JsonObject r13, MessageEntity r14) {
        o.e(r12, "intentName");
        o.e(r14, "messageEntity");
        if (r13 == null) goto L166;
        JsonObject r15 = c(r13);
        if (r15 == null) goto L166;
        boolean r3 = false;
        if (o.a(r12, "Messages_Send") == false) goto L101;
        JsonElement r16 = r15.get("target");
        if (r16 != null) goto L12;
    L21:
        JsonObject r17 = new JsonObject();
    L22:
        JsonElement r6 = r17.get(SensitiveType.TELEPHONE);
        if (r6 != null) goto L25;
    L39:
        String r7 = null;
    L40:
        JsonElement r8 = r17.get("contact");
        if (r8 != null) goto L43;
    L50:
        ContactEntity r9 = null;
    L51:
        if (r7 == null) goto L55;
        if (r9 == null) goto L54;
        r17.add("contact", EntityExtKt.c().toJsonTree(r9));
    L74:
        JsonElement r10 = r17.get("contact");
        if (r10 != null) goto L77;
    L79:
        boolean r11 = false;
    L80:
        if (r11 == true) goto L95;
        JsonElement r1 = r17.get(SensitiveType.TELEPHONE);
        if (r1 != null) goto L84;
    L93:
        boolean r2 = false;
    L94:
        if (r2 == true) goto L95;
    L96:
        if (r3 == true) goto L99;
        ILogDepend.Companion.e(TAG, "resolveStatelessExecParams failed: SMS target is empty, entityId=" + r14.getId());
        return null;
    L99:
        r15.add("target", (JsonElement) ZeusTransformUtils.preCheckCast(r17, JsonElement.class, "com.obric.aiagent.plugin"));
    L165:
        return a(r15);
    L84:
        if (r1.isJsonPrimitive() == true) goto L87;
        r1 = null;
    L87:
        if (r1 == null) goto L93;
        String r4 = r1.getAsString();
        if (r4 == null) goto L93;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L93;
        r2 = true;
    L95:
        r3 = true;
        goto L96
    L77:
        if (r10.isJsonObject() != true) goto L79;
        r11 = true;
        goto L80
    L54:
        r17.remove("contact");
        goto L74
    L55:
        if (r9 != null) goto L60;
        List<ContactEntity> r18 = r14.getContacts();
        if (r18 == null) goto L59;
        r9 = (ContactEntity) ZeusTransformUtils.preCheckCast(p.l(r18), ContactEntity.class, "com.obric.aiagent.plugin");
        goto L60
    L59:
        r9 = null;
    L60:
        if (r9 == null) goto L62;
        r17.add("contact", EntityExtKt.c().toJsonTree(r9));
        goto L74
    L62:
        r17.remove("contact");
        List<String> r19 = r14.getTelephones();
        if (r19 == null) goto L74;
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L66:
        if (r20.hasNext() == false) goto L70;
        Object r21 = r20.next();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L66;
    L71:
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.aiagent.plugin");
        if (r22 == null) goto L74;
        r17.addProperty(SensitiveType.TELEPHONE, r22);
        goto L74
    L70:
        r21 = null;
        goto L71
    L43:
        if (r8.isJsonObject() == true) goto L46;
        r8 = null;
    L46:
        if (r8 == null) goto L50;
        JsonObject r23 = r8.getAsJsonObject();
        if (r23 == null) goto L50;
        r9 = b(r23);
        goto L51
    L25:
        if (r6.isJsonPrimitive() == true) goto L28;
        r6 = null;
    L28:
        if (r6 == null) goto L39;
        String r24 = r6.getAsString();
        if (r24 == null) goto L39;
        r7 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r7 == null) goto L39;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L36;
        boolean r25 = true;
    L37:
        if (r25 == false) goto L39;
    L36:
        r25 = false;
        goto L37
    L12:
        if (r16.isJsonObject() == true) goto L15;
        r16 = null;
    L15:
        if (r16 == null) goto L21;
        JsonObject r110 = r16.getAsJsonObject();
        if (r110 == null) goto L21;
        r17 = r110.deepCopy();
        if (r17 == null) goto L21;
    L101:
        if (o.a(r12, "Office_SendMessage") == false) goto L165;
        GroupChatEntity r111 = r14.getGroupChat();
        List<ContactEntity> r112 = r14.getContacts();
        if (r112 == null) goto L105;
        ContactEntity r113 = (ContactEntity) ZeusTransformUtils.preCheckCast(p.l(r112), ContactEntity.class, "com.obric.aiagent.plugin");
    L107:
        if (r111 != null) goto L109;
    L111:
        if (r113 != null) goto L113;
    L115:
        JsonElement r114 = r15.get("targetId");
        if (r114 != null) goto L118;
    L132:
        String r115 = null;
    L133:
        JsonElement r116 = r15.get("target");
        if (r116 != null) goto L136;
    L150:
        String r117 = null;
    L151:
        if (r115 != null) goto L153;
    L155:
        if (r3 == true) goto L163;
        if (r115 != null) goto L159;
        if (r117 == null) goto L163;
    L159:
        x r118 = x.f38692a;
    L161:
        if (r15.has("version") == true) goto L165;
        r15.addProperty("version", (Number) ZeusTransformUtils.preCheckCast(1, Number.class, "com.obric.aiagent.plugin"));
    L163:
        return null;
    L153:
        if (d.o.o.b(r115, "$E_", false, 2, null) != true) goto L155;
        r3 = true;
        goto L155
    L136:
        if (r116.isJsonPrimitive() == true) goto L139;
        r116 = null;
    L139:
        if (r116 == null) goto L150;
        String r119 = r116.getAsString();
        if (r119 == null) goto L150;
        r117 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r119, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r117 == null) goto L150;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r117, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L147;
        boolean r5 = true;
    L148:
        if (r5 == false) goto L150;
    L147:
        r5 = false;
        goto L148
    L118:
        if (r114.isJsonPrimitive() == true) goto L121;
        r114 = null;
    L121:
        if (r114 == null) goto L132;
        String r120 = r114.getAsString();
        if (r120 == null) goto L132;
        r115 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r120, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r115 == null) goto L132;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L129;
        boolean r121 = true;
    L130:
        if (r121 == false) goto L132;
    L129:
        r121 = false;
        goto L130
    L113:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r113.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L115;
        r15.addProperty("targetId", r113.getId());
        r15.addProperty("targetType", "PEOPLE");
        r15.remove("target");
        goto L161
    L109:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r111.getId(), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L111;
        r15.addProperty("targetId", r111.getId());
        r15.addProperty("targetType", "GROUP");
        r15.remove("target");
        goto L161
    L105:
        r113 = null;
    L166:
        return null;
    }

    private final ContactEntity b(JsonObject r5) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r6 = d.n.f((ContactEntity) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((JsonElement) ZeusTransformUtils.preCheckCast(r5, JsonElement.class, "com.obric.aiagent.plugin"), ContactEntity.class), ContactEntity.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = d.n.c(r6);
        if (r7 == null) goto L11;
        ILogDepend.Companion.w(TAG, "normalizeContactForExecution failed: " + r7.getMessage());
    L11:
        if (d.n.b(r6) == false) goto L14;
        r6 = null;
    L14:
        return (ContactEntity) ZeusTransformUtils.preCheckCast(r6, ContactEntity.class, "com.obric.aiagent.plugin");
    L5:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r6 = d.n.f(d.o.a(th));
        goto L7
    }

    private final JsonObject c(JsonObject r6) {
        JsonObject r5 = new JsonObject();
        Set<Map.Entry<String, JsonElement>> r7 = r6.entrySet();
        o.c(r7, "entrySet(...)");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        o.a(r0);
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        JsonElement r1 = (JsonElement) ZeusTransformUtils.preCheckCast(r0.getValue(), JsonElement.class, "com.obric.aiagent.plugin");
        if (r1.isJsonObject() == false) goto L8;
        JsonElement r3 = r1;
    L9:
        if (r3 == null) goto L15;
        JsonObject r4 = r3.getAsJsonObject();
        if (r4 == null) goto L15;
        JsonElement r9 = r4.get("value");
        if (r9 == null) goto L15;
        r1 = r9;
    L15:
        r5.add(r2, r1.deepCopy());
        goto L4
    L8:
        r3 = null;
        goto L9
    L16:
        return r5;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, com.obric.agent.office.a$g] */
    /* JADX WARN: Type inference failed for: r1v30, types: [T, kotlinx.coroutines.ca] */
    private final void a(b r33) {
        String r11 = r33.d();
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        JsonObject r10 = null;
        if (r2 == false) goto L16;
        long r5 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        ILogDepend.Companion.w(TAG, "onUserClickSendStateless legacy payload without ecaId, intent=" + r33.a() + ", reqId=" + r5);
        com.obric.agent.utils.b r3 = com.obric.agent.utils.b.f15994a;
        String r4 = r33.a();
        JsonObject r0 = r33.b();
        if (r0 == null) goto L14;
        r10 = f15240a.a(r0);
    L14:
        r3.a(r4, r10, r33.c(), r5);
        return;
    L16:
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L21;
        List<AppEntity> r7 = r6.getEntityByEcaId(r11);
        if (r7 == null) goto L21;
        AppEntity r8 = (AppEntity) ZeusTransformUtils.preCheckCast(p.l(r7), AppEntity.class, "com.obric.aiagent.plugin");
    L23:
        if (ZeusTransformUtils.instanceOf(r8, MessageEntity.class) == false) goto L25;
        MessageEntity r9 = (MessageEntity) ZeusTransformUtils.preCheckCast(r8, MessageEntity.class, "com.obric.aiagent.plugin");
    L26:
        if (r9 != null) goto L30;
        ILogDepend.Companion.e(TAG, "onUserClickSendStateless ignored: message entity not found, ecaId=" + r11);
        return;
    L30:
        if (o.a(r33.a(), "Office_SendMessage") == false) goto L32;
        String r12 = "lark_send_";
    L34:
        if (d.o.o.b(r9.getId(), r12, false, 2, null) == true) goto L37;
        ILogDepend.Companion.e(TAG, "onUserClickSendStateless ignored: entity does not match intent, intent=" + r33.a() + ", entityId=" + r9.getId());
        return;
    L37:
        String r13 = r9.getId();
        JsonObject r18 = a(r33.a(), r33.b(), r9);
        if (r18 != null) goto L41;
        com.obric.agent.entitysync.b.f14469a.a(r13, "failed", r33.e());
        ILogDepend.Companion.e(TAG, "onUserClickSendStateless ignored: invalid params, intent=" + r33.a() + ", entityId=" + r13);
        return;
    L41:
        ConcurrentHashMap.KeySetView<String, Boolean> r14 = f;
        if (r14.add(r13) == true) goto L45;
        ILogDepend.Companion.w(TAG, "onUserClickSendStateless ignored: send already in flight, entityId=" + r13);
        return;
    L45:
        long r15 = Integer.MAX_VALUE & UUID.randomUUID().toString().hashCode();
        IAppIntentFeedback r16 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L49;
        r14.remove(r13);
        com.obric.agent.entitysync.b.f14469a.a(r13, "failed", r33.e());
        ILogDepend.Companion.e(TAG, "onUserClickSendStateless failed: feedback service unavailable");
        return;
    L49:
        AtomicBoolean r17 = new AtomicBoolean(false);
        z.f r19 = new z.f();
        z.f r20 = new z.f();
        MessageEntity r110 = r9;
        r20.f38504a = new g(r15, r17, r19, r33, r13, r11, r16);
        if (r20.f38504a != 0) goto L52;
        o.c("listener");
        com.obric.agent.f r21 = null;
    L53:
        r24.addLocalActionFinishedListener(r21);
        r19.f38504a = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new h(r17, r13, r33, r24, r20, r11, r15, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        ILogDepend.Companion.i(TAG, "onUserClickSendStateless intent=" + r33.a() + " entityId=" + r13 + " ecaId=" + r11 + " reqId=" + r15);
        d.n.a r22 = d.n.f38560a;     // Catch: Throwable -> L63
        a r23 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L63
        com.obric.agent.utils.b r111 = com.obric.agent.utils.b.f15994a;     // Catch: Throwable -> L63
        String r24 = r33.a();     // Catch: Throwable -> L63
        String r112 = r110.get_packageName();     // Catch: Throwable -> L63
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L58;
        r112 = null;
    L58:
        if (r112 != null) goto L60;
        String r113 = r33.c();     // Catch: Throwable -> L63
    L61:
        r111.a(r24, r18, r113, r15);     // Catch: Throwable -> L63
        Object r25 = d.n.f(x.f38692a);     // Catch: Throwable -> L63
    L65:
        Throwable r26 = d.n.c(r25);
        if (r26 != null) goto L68;
        return;
    L68:
        if (r17.compareAndSet(false, true) == false) goto L77;
        ca r27 = (ca) ZeusTransformUtils.preCheckCast(r19.f38504a, ca.class, "com.obric.aiagent.plugin");
        if (r27 == null) goto L73;
        ca.a.a(r27, null, 1, null);
    L73:
        if (r20.f38504a != 0) goto L75;
        o.c("listener");
        com.obric.agent.f r114 = null;
    L76:
        r16.removeActionFinishedListener(r114);
        f.remove(r13);
        com.obric.agent.entitysync.b.f14469a.a(r13, "failed", r33.e());
        goto L77
    L75:
        r114 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(r20.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
    L77:
        ILogDepend.Companion.e(TAG, "onUserClickSendStateless dispatch failed", r26);
        return;
    L60:
        r113 = r112;
    L63:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;
        r25 = d.n.f(d.o.a(th));
        goto L65
    L52:
        r21 = (com.obric.agent.f) ZeusTransformUtils.preCheckCast(r20.f38504a, com.obric.agent.f.class, "com.obric.aiagent.plugin");
        goto L53
    L32:
        r12 = "msg_send_";
        goto L34
    L25:
        r9 = null;
    L21:
        r8 = null;
        goto L23
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private final void a(int r3) {
        if (r3 != 9001) goto L5;
        String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_msg_send_no_sim, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_msg_send_no_sim"));
    L9:
        if (r2 == null) goto L14;
        IFlowUiIDL r4 = aw.a(aa.b(IFlowUiIDL.class));
        if (r4 == null) goto L15;
        r4.showToast(r2);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (r3 == 9002) goto L7;
        r2 = null;
        goto L9
    L7:
        r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_msg_send_no_network, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_msg_send_no_network"));
        goto L9
    }

    private final void a(String r14, String r15) {
        i r0 = f15242c;
        monitor-enter(r0);
        C0312a r1 = (C0312a) ZeusTransformUtils.preCheckCast(r0.get(r14), C0312a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        monitor-exit(r0);
        if (r1 != null) goto L34;
        return;
    L34:
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L17
        a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        AppIntentMessage r3 = (AppIntentMessage) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson(r1.d(), AppIntentMessage.class), AppIntentMessage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Map<String, String> r16 = r3.getExt();     // Catch: Throwable -> L17
        if (r16 == null) goto L14;
        Map r17 = ao.e(r16);     // Catch: Throwable -> L17
        if (r17 == null) goto L14;
    L13:
        Map r10 = r17;
        r10.put("msg_send_status", r15);     // Catch: Throwable -> L17
        Object r18 = d.n.f(EntityExtKt.a().toJson(AppIntentMessage.copy$default(r3, null, false, false, null, null, false, false, null, null, r10, 511, null)));     // Catch: Throwable -> L17
    L20:
        if (d.n.b(r18) == false) goto L22;
        r18 = null;
    L22:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin");
        if (r19 != null) goto L25;
        return;
    L25:
        IFlowMessageIDL r110 = ak.a(aa.b(IFlowMessageIDL.class));
        if (r110 == null) goto L36;
        r110.updateMutableMessageContent(r14, r19);
        return;
    L36:
        return;
    L14:
        r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        d.n.a r111 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
    L29:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r2, IntentAppAction r3) {
        o.e(r3, MemorySourceLinkType.INTENT);
        if (d(r3) == false) goto L5;
    L13:
        return false;
    L5:
        if (o.a(r2, "Messages_Send") == false) goto L13;
        ConcurrentHashMap<String, String> r1 = r3.getExt();
        if (r1 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.get("need_user_confirm"), String.class, "com.obric.aiagent.plugin");
    L11:
        if (o.a(r4, "true") == false) goto L13;
        return true;
    L9:
        r4 = null;
        goto L11
    }

    public final boolean b(String r2, IntentAppAction r3) {
        o.e(r3, MemorySourceLinkType.INTENT);
        if (d(r3) == false) goto L5;
    L13:
        return false;
    L5:
        if (o.a(r2, "Office_SendMessage") == false) goto L13;
        ConcurrentHashMap<String, String> r1 = r3.getExt();
        if (r1 == null) goto L9;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r1.get("need_user_confirm"), String.class, "com.obric.aiagent.plugin");
    L11:
        if (o.a(r4, "true") == false) goto L13;
        return true;
    L9:
        r4 = null;
        goto L11
    }

    private final boolean d(IntentAppAction r2) {
        ConcurrentHashMap<String, String> r1 = r2.getExt();
        if (r1 == null) goto L5;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.get("o_task_type"), String.class, "com.obric.aiagent.plugin");
    L7:
        return o.a(r3, IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK);
    L5:
        r3 = null;
        goto L7
    }

    private final Object b(IntentAppAction r21, OfficeSendMessageParams r22, d.c.d<? super MessageEntity> r23) {
        OfficeSendMessageParams r2 = r22;
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L7;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if ((r4.f15259e & Integer.MIN_VALUE) == 0) goto L7;
        r4.f15259e -= Integer.MIN_VALUE;
    L8:
        Object r1 = r4.f15257c;
        Object r5 = d.c.a.b.a();
        int r6 = r4.f15259e;
        Integer r8 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r4.f15256b, String.class, "com.obric.aiagent.plugin");
        r2 = (OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r4.f15255a, OfficeSendMessageParams.class, "com.obric.aiagent.plugin");
        d.o.a(r1);
    L91:
        LarkParticipants r7 = (LarkParticipants) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), LarkParticipants.class), LarkParticipants.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50
        List<GroupChatEntity> r9 = r7.getGroups();     // Catch: Exception -> L50
        if (r9 == null) goto L44;
        GroupChatEntity r10 = (GroupChatEntity) ZeusTransformUtils.preCheckCast(p.l(r9), GroupChatEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50
        if (r10 == null) goto L44;
        AppEntity r11 = (AppEntity) ZeusTransformUtils.preCheckCast(r10, AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50
    L51:
        String r12 = r3;
    L52:
        if (r11 == null) goto L54;
        r2.setTargetId(r11.getId());
        r2.setTarget(null);
    L54:
        OfficeMessageContent r13 = r2.getContent();
        if (r13 == null) goto L57;
        String r14 = r13.getText();
    L59:
        if (w.a(r14) == false) goto L66;
        OfficeMessageContent r15 = r2.getContent();
        if (r15 == null) goto L64;
        String r16 = r15.getText();
        if (r16 == null) goto L64;
    L65:
        String r17 = r16;
        if (r11 == null) goto L76;
        r8 = d.c.b.a.b.a(r11.getType());
    L76:
        if (r8 == null) goto L82;
        if (r8.intValue() != 201) goto L82;
        r2.setTargetType("PEOPLE");
        List r18 = p.b();
        o.a(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        MessageEntity r19 = new MessageEntity(r12, 0, 1, r18, r17, p.a((ContactEntity) ZeusTransformUtils.preCheckCast(r11, ContactEntity.class, "com.obric.aiagent.plugin")));
        r19.set_packageName(((ContactEntity) ZeusTransformUtils.preCheckCast(r11, ContactEntity.class, "com.obric.aiagent.plugin")).get_packageName());
        return r19;
    L82:
        if (r8 == null) goto L88;
        if (r8.intValue() != 203) goto L88;
        r2.setTargetType("GROUP");
        MessageEntity r20 = new MessageEntity(r12, 0, 1, p.b(), r17, null, 32, null);
        r20.setGroupChat((GroupChatEntity) ZeusTransformUtils.preCheckCast(r11, GroupChatEntity.class, "com.obric.aiagent.plugin"));
        r20.set_packageName(((GroupChatEntity) ZeusTransformUtils.preCheckCast(r11, GroupChatEntity.class, "com.obric.aiagent.plugin")).get_packageName());
        return r20;
    L88:
        return new MessageEntity(r12, 0, 1, p.b(), r17, null, 32, null);
    L64:
        r16 = "";
        goto L65
    L66:
        OfficeMessageContent r24 = r2.getContent();
        if (r24 == null) goto L69;
        CloudDocumentEntity r25 = r24.getDoc();
    L70:
        if (r25 == null) goto L72;
        r16 = "飞书文档";
        goto L65
    L72:
        r16 = "文件";
        goto L65
    L69:
        r25 = null;
        goto L70
    L57:
        r14 = null;
    L44:
        List<ContactEntity> r26 = r7.getContacts();     // Catch: Exception -> L50
        if (r26 == null) goto L47;
        ContactEntity r27 = (ContactEntity) ZeusTransformUtils.preCheckCast(p.l(r26), ContactEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50
    L48:
        r11 = (AppEntity) ZeusTransformUtils.preCheckCast(r27, AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L50
        goto L51
    L47:
        r27 = null;
    L50:
        r11 = null;
        goto L51
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r1);
        String r28 = c("Office_SendMessage", r21);
        ConcurrentHashMap<String, String> r29 = r21.getExt();
        if (r29 == null) goto L34;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.get("o_lark_asr_eca_ids"), String.class, "com.obric.aiagent.plugin");
        if (r30 == null) goto L34;
        JsonElement r31 = JsonParser.parseString(r30);     // Catch: Exception -> L28
        if (r31.isJsonArray() == false) goto L30;
        JsonArray r32 = r31.getAsJsonArray();     // Catch: Exception -> L28
        if (r32.size() <= 0) goto L30;
        IEntityManager r33 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
        if (r33 == null) goto L30;
        String r34 = r32.get(0).getAsString();     // Catch: Exception -> L28
        o.c(r34, "getAsString(...)");     // Catch: Exception -> L28
        List<AppEntity> r35 = r33.getEntityByEcaId(r34);     // Catch: Exception -> L28
        if (r35 == null) goto L30;
        r11 = (AppEntity) ZeusTransformUtils.preCheckCast(p.l(r35), AppEntity.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L28
    L31:
        if (r11 == null) goto L34;
        r12 = r28;
    L30:
        r11 = null;
    L28:
        e = move-exception;
        e.printStackTrace();
    L34:
        a r36 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        com.obric.agent.office.b r37 = com.obric.agent.office.b.f15285a;
        r4.f15255a = r2;
        r4.f15256b = r28;
        r4.f15259e = 1;
        r1 = r37.a(r2, r4);
        if (r1 != r5) goto L37;
        return r5;
    L37:
        r3 = r28;
    L7:
        r4 = new c(this, r0);
        goto L8
    }

    private final String c(String r4, IntentAppAction r5) {
        String r0 = "msg_send";
        if (n.f15202a.a((Map) ZeusTransformUtils.preCheckCast(r5.getExt(), Map.class, "com.obric.aiagent.plugin")) == true) goto L9;
        if (o.a(r4, "Office_SendMessage") == false) goto L13;
        return "lark";
    L13:
        return "msg_send";
    L9:
        if (o.a(r4, "Office_SendMessage") == false) goto L12;
        r0 = "lark_send";
    L12:
        return r0 + '_' + r5.getMessageId() + '_' + r5.getQuestionId();
    }
}
