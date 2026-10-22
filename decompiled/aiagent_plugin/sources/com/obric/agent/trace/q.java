package com.obric.agent.trace;

import android.app.Application;
import android.os.SystemClock;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.obric.agent.ObricService;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.assistant.idl.bean.OModelConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskInfo;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autoaction.app.launcherpage.knowledge.KnowledgeActivity;
import com.obric.autogui.common.api.presentation.api.IAssistInputHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.ResultCode;
import com.obric.funcall_api.bean.ECAContent;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntentTracer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f15713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<com.obric.agent.trace.h> f15714b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedList<com.obric.agent.trace.i> f15715c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a<String, com.obric.agent.trace.i> f15716d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<com.obric.agent.trace.s> f15717e = null;
    private static final a<String, Long> f = null;
    private static String g;
    private static int h;
    private static final SimpleDateFormat i = null;
    private static a<String, String> j;

    /* JADX INFO: compiled from: IntentTracer.kt */
    private static final class a<K, V> extends LinkedHashMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f15718a;

        public a(int r4) {
            super(16, 0.75f, true);
            this.f15718a = r4;
        }

        public Collection<Object> a() {
            return super.values();
        }

        public int b() {
            return super.size();
        }

        public Set<Map.Entry<Object, Object>> c() {
            return super.entrySet();
        }

        public Set<Object> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return (Set<Map.Entry<K, V>>) c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<K> keySet() {
            return (Set<K>) d();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<V> values() {
            return (Collection<V>) a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= this.f15718a) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {209}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$recordASRDuration$1")
    static final class aa extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15721c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f15723e;

        aa(String r3, String r4, long r5, d.c.d<? super aa> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15721c = r3;
            this.f15722d = r4;
            this.f15723e = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((aa) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), aa.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new aa(this.f15721c, this.f15722d, this.f15723e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15720b;
            boolean r2 = false;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            com.obric.agent.trace.h r3 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(this.f15719a, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
            d.o.a(r13);
        L32:
            com.obric.agent.trace.h r4 = r3;
        L33:
            long r12 = this.f15723e;
            if (1 <= r12) goto L36;
        L38:
            if (r2 == false) goto L40;
            r4.b(r12);
        L40:
            r4.a(true);
            r4.b(q.a(q.f15713a));
            return d.x.f38692a;
        L36:
            if (r12 >= 1000000) goto L38;
            r2 = true;
            goto L38
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f15721c, CharSequence.class, "com.obric.aiagent.plugin");
            if (r14.length() != 0) goto L11;
            boolean r5 = true;
        L13:
            if (r5 == false) goto L15;
            r14 = "not_ready";
        L15:
            String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");
            r4 = q.b(q.f15713a, "not_ready");
            if (d.h.b.o.a(r15, "not_ready") == true) goto L19;
            if (r4 == null) goto L19;
            r4.c(r15);
        L21:
            if (q.a(q.f15713a) == true) goto L33;
            if (d.h.b.o.a(r15, "not_ready") == true) goto L25;
            q r6 = q.f15713a;
            q.e(r15);
        L25:
            r4.c(q.g());
            String r16 = this.f15722d;
            if (r16 == null) goto L28;
            r4.a(r16);
        L28:
            com.obric.agent.trace.o r7 = com.obric.agent.trace.o.f15589c;
            d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15719a = r4;
            this.f15720b = 1;
            if (com.obric.agent.trace.h.a(r4, r7, false, r9, 2, null) != r0) goto L31;
            return r0;
        L31:
            r3 = r4;
        L19:
            r4 = q.a(q.f15713a, r15);
            goto L21
        L11:
            r5 = false;
            goto L13
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$recordAudioInfo$1")
    static final class ab extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15726c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f15728e;

        ab(String r3, String r4, String r5, d.c.d<? super ab> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15725b = r3;
            this.f15726c = r4;
            this.f15727d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ab) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ab.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            ab r0 = new ab(this.f15725b, this.f15726c, this.f15727d, r7);
            r0.f15728e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15724a != 0) goto L19;
            d.o.a(r3);
            am r4 = (am) ZeusTransformUtils.preCheckCast(this.f15728e, am.class, "com.obric.aiagent.plugin");
            String r5 = this.f15725b;
            String r0 = this.f15726c;
            String r2 = this.f15727d;
            d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L14
            q r6 = q.f15713a;     // Catch: Throwable -> L14
            if (r5 != null) goto L8;
            r5 = q.g();     // Catch: Throwable -> L14
        L8:
            com.obric.agent.trace.h r7 = q.a(r6, r5);     // Catch: Throwable -> L14
            JSONObject r8 = new JSONObject(r0);     // Catch: Throwable -> L14
            r8.optString("content");     // Catch: Throwable -> L14
            JSONObject r9 = r8.optJSONObject("extra");     // Catch: Throwable -> L14
            if (r9 == null) goto L11;
            String r10 = r9.optString("log_id");     // Catch: Throwable -> L14
        L12:
            r7.e(r10);     // Catch: Throwable -> L14
            r7.d(r2);     // Catch: Throwable -> L14
            d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
        L17:
            return d.x.f38692a;
        L11:
            r10 = null;
        L14:
            th = move-exception;
            d.n.a r11 = d.n.f38560a;
            d.n.f(d.o.a(th));
            goto L17
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$removeReportListChangedListener$1")
    static final class ac extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.s f15730b;

        ac(com.obric.agent.trace.s r3, d.c.d<? super ac> r4) {
            com.obric.agent.trace.s r5 = (com.obric.agent.trace.s) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.trace.s.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15730b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ac) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ac.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ac(this.f15730b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15729a != 0) goto L7;
            d.o.a(r2);
            q.i().remove(this.f15730b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$setCurrentMsgId$1")
    static final class ad extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15732b;

        ad(String r3, d.c.d<? super ad> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15732b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ad) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ad.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ad(this.f15732b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15731a != 0) goto L10;
            d.o.a(r2);
            com.obric.agent.trace.h r3 = q.b(q.f15713a, q.g());
            if (r3 == null) goto L8;
            r3.d(this.f15732b);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {470}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$setResult$1")
    static final class ae extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.f f15735c;

        ae(String r3, com.obric.agent.trace.f r4, d.c.d<? super ae> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15734b = r3;
            this.f15735c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ae) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ae.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ae(this.f15734b, this.f15735c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15733a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            com.obric.agent.trace.h r6 = q.b(q.f15713a, this.f15734b);
            if (r6 == null) goto L14;
            com.obric.agent.trace.f r2 = this.f15735c;
            q r3 = q.f15713a;
            this.f15733a = 1;
            if (q.a(r3, r6, r2, this) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {475}, d = "setResult", e = "com.obric.agent.trace.IntentTracer")
    static final class af extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f15738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f15739d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15740e;

        af(q r3, d.c.d<? super af> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15739d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15738c = r3;
            this.f15740e |= Integer.MIN_VALUE;
            return q.a(this.f15739d, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$setStateEndTime$1")
    static final class ag extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.o f15743c;

        ag(String r3, com.obric.agent.trace.o r4, d.c.d<? super ag> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15742b = r3;
            this.f15743c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ag) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ag.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ag(this.f15742b, this.f15743c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15741a != 0) goto L10;
            d.o.a(r2);
            com.obric.agent.trace.h r3 = q.b(q.f15713a, this.f15742b);
            if (r3 == null) goto L8;
            r3.b(this.f15743c);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$setStateTimeCost$1")
    static final class ah extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.o f15746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f15747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f15748e;

        ah(String r3, com.obric.agent.trace.o r4, long r5, boolean r7, d.c.d<? super ah> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15745b = r3;
            this.f15746c = r4;
            this.f15747d = r5;
            this.f15748e = r7;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((ah) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ah.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new ah(this.f15745b, this.f15746c, this.f15747d, this.f15748e, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            d.c.a.b.a();
            if (this.f15744a != 0) goto L10;
            d.o.a(r4);
            com.obric.agent.trace.h r5 = q.b(q.f15713a, this.f15745b);
            if (r5 == null) goto L8;
            r5.a(this.f15746c, this.f15747d, this.f15748e);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$uploadReport$2")
    static final class ai extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super IntentDebugReport>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.i f15750b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f15751c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f15752d;

        /* JADX INFO: compiled from: IntentTracer.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15753a = null;

            static {
                int[] r0 = new int[com.obric.agent.trace.o.values().length];
                r0[com.obric.agent.trace.o.r.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[com.obric.agent.trace.o.t.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[com.obric.agent.trace.o.s.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f15753a = r0;
            }
        }

        ai(com.obric.agent.trace.i r3, boolean r4, d.c.d<? super ai> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15750b = r3;
            this.f15751c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super IntentDebugReport> r4) {
            return ((ai) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), ai.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            ai r0 = new ai(this.f15750b, this.f15751c, r6);
            r0.f15752d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentDebugReport> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            d.c.a.b.a();
            if (this.f15749a != 0) goto L180;
            d.o.a(r24);
            String r3 = "com.obric.aiagent.plugin";
            am r0 = (am) ZeusTransformUtils.preCheckCast(this.f15752d, am.class, "com.obric.aiagent.plugin");
            String r2 = "IntentTracer";
            ILogDepend.Companion.i("IntentTracer", "report app intent data");
            Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(this.f15750b.f(), Iterable.class, "com.obric.aiagent.plugin");
            int r5 = 1;
            if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L7;
        L9:
            Iterator r4 = r1.iterator();
        L11:
            if (r4.hasNext() == false) goto L8;
            if (((com.obric.agent.trace.o) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.agent.trace.o.class, "com.obric.aiagent.plugin")) != com.obric.agent.trace.o.r) goto L15;
            boolean r6 = true;
        L16:
            if (r6 == false) goto L11;
            int r7 = 1;
        L18:
            Application r8 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
            if (r7 == 0) goto L21;
            int r9 = ZeusTransformUtils.mapRes(R.string.obric_is_appintent, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_is_appintent");
        L22:
            IntentDebugReport r10 = new IntentDebugReport(r8.getString(r9), null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
            JSONObject r11 = new JSONObject();
            String r12 = "app_intent_cost";
            r11.put("app_intent_cost", this.f15750b.e());
            r11.put("app_intent_is_app_intent", r7);
            r11.put("app_intent_task_type", this.f15750b.m());
            r11.put("app_intent_logId", this.f15750b.j());
            IFlowSettingsIDL r13 = at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
            if (r13 == null) goto L27;
            OModelConfig r14 = r13.getObricModelConfig();
            if (r14 == null) goto L27;
            r11.put("app_intent_model", r14.getIntentModel());
            r11.put("app_intent_pc_model", r14.getPcSearchModel());
        L27:
            com.obric.agent.trace.f r15 = this.f15750b.d();
            if (r15 == null) goto L30;
            r11.put("app_intent_result_code", r15.c());
        L30:
            List<com.obric.agent.trace.u> r16 = this.f15750b.g();
            if (r16 == null) goto L48;
            Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L35;
        L37:
            Iterator r18 = r17.iterator();
        L39:
            if (r18.hasNext() == false) goto L36;
            if (((com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.agent.trace.u.class, "com.obric.aiagent.plugin")).a() != com.obric.agent.trace.o.s) goto L43;
            boolean r19 = true;
        L44:
            if (r19 == false) goto L39;
            boolean r20 = true;
        L46:
            if (r20 != true) goto L48;
            boolean r21 = true;
        L49:
            List<com.obric.agent.trace.u> r22 = this.f15750b.g();
            if (r22 == null) goto L61;
            Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin");
            Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r26 = r23.iterator();
        L53:
            if (r26.hasNext() == false) goto L60;
            Object r110 = r26.next();
            if (((com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r110, com.obric.agent.trace.u.class, "com.obric.aiagent.plugin")).a() != com.obric.agent.trace.o.r) goto L57;
            boolean r111 = true;
        L58:
            if (r111 == false) goto L53;
            r25.add(r110);
            goto L53
        L57:
            r111 = false;
            goto L58
        L60:
            int r27 = ((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.aiagent.plugin")).size();
        L62:
            r11.put("app_intent_intent_count", r27);
            List<com.obric.agent.trace.u> r28 = this.f15750b.g();
            if (r28 == null) goto L173;
            Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.i r30 = this.f15750b;
            boolean r112 = this.f15751c;
            Iterator r113 = r29.iterator();
        L66:
            if (r113.hasNext() == false) goto L173;
            com.obric.agent.trace.u r114 = (com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r113.next(), com.obric.agent.trace.u.class, r3);
            com.obric.agent.trace.o r31 = r114.a();
            if (r31 != null) goto L70;
            int r32 = -1;
        L71:
            Iterator r115 = r113;
            if (r32 == r5) goto L101;
            if (r32 != 2) goto L75;
            r11.put("app_intent_app_cost", r114.b());
            Map<String, Object> r33 = r114.c();
            if (r33 != null) goto L86;
        L76:
            String r210 = r2;
            com.obric.agent.trace.i r116 = r30;
            String r117 = r12;
        L77:
            String r34 = r3;
        L172:
            r3 = r34;
            r113 = r115;
            r30 = r116;
            r12 = r117;
            r2 = r210;
            r5 = 1;
            goto L66
        L86:
            Object r118 = r33.get("error_msg");
            r116 = r30;
            if (r118 == null) goto L89;
            r11.put("app_intent_app_error_msg", r118);
        L89:
            r117 = r12;
            r11.put("app_intent_app_result_code", r33.get(FontsContractCompat.Columns.RESULT_CODE));
            if (r112 == false) goto L100;
            JSONObject r119 = new JSONObject();
            r210 = r2;
            r119.put("app_intent_app_cost", r114.b());
            r119.put("app_intent_app_result_code", r33.get(FontsContractCompat.Columns.RESULT_CODE));
            Object r35 = r33.get("error_msg");
            if (r35 == null) goto L94;
            r119.put("app_intent_app_error_msg", r35);
        L94:
            Object r36 = r33.get(Ext.KEY_INTENT_NAME);
            if (r36 == null) goto L97;
            r119.put("app_intent_intent_name", r36);
        L97:
            IAppLog r37 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, r3);
            if (r37 == null) goto L77;
            r37.reportToFlow("o_app_intent_app_state", r119);
            goto L77
        L100:
            r210 = r2;
            goto L77
        L75:
            if (r32 != 3) goto L76;
            r11.put("app_intent_auth_cost", r114.b());
            Map<String, Object> r38 = r114.c();
            if (r38 == null) goto L83;
            Object r39 = r38.get("auth_status_code");
            if (r39 == null) goto L83;
            r11.put("app_intent_auth_status_code", r39);
        L83:
            r11.put(r12, r30.e() - r114.b());
            r11.put("app_intent_cost_with_authentication", r30.e());
            goto L76
        L101:
            r210 = r2;
            r116 = r30;
            r117 = r12;
            Map<String, Object> r40 = r114.c();
            if (r40 == null) goto L77;
            Object r41 = r114.c().get("action");
            if (r41 == null) goto L154;
            d.n.a r42 = d.n.f38560a;     // Catch: Throwable -> L149
            Gson r43 = ObricService.INSTANCE.getGson();     // Catch: Throwable -> L149
            d.h.b.o.a(r41, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L149
            ECAContent r44 = (ECAContent) ZeusTransformUtils.preCheckCast(r43.fromJson((String) ZeusTransformUtils.preCheckCast(r41, String.class, r3), ECAContent.class), ECAContent.class, r3);     // Catch: Throwable -> L149
            String r45 = null;
            if (r44 == null) goto L108;
            String r46 = r44.getEcaData();     // Catch: Throwable -> L149
        L109:
            com.obric.agent.dm.e r47 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(r46, com.obric.agent.dm.e.class), com.obric.agent.dm.e.class, r3);     // Catch: Throwable -> L149
            if (r47 == null) goto L126;
            List<com.obric.agent.dm.f> r48 = r47.a();     // Catch: Throwable -> L149
            if (r48 == null) goto L126;
            com.obric.agent.dm.f r49 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.d(r48, 0), com.obric.agent.dm.f.class, r3);     // Catch: Throwable -> L149
            if (r49 == null) goto L126;
            List<com.obric.agent.dm.b> r50 = r49.a();     // Catch: Throwable -> L149
            if (r50 == null) goto L126;
            com.obric.agent.dm.b r51 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.d(r50, 0), com.obric.agent.dm.b.class, r3);     // Catch: Throwable -> L149
            if (r51 == null) goto L126;
            String r52 = r51.a();     // Catch: Throwable -> L149
        L127:
            if (r47 == null) goto L141;
            List<com.obric.agent.dm.f> r53 = r47.a();     // Catch: Throwable -> L149
            if (r53 == null) goto L141;
            com.obric.agent.dm.f r54 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(d.a.p.d(r53, 0), com.obric.agent.dm.f.class, r3);     // Catch: Throwable -> L149
            if (r54 == null) goto L141;
            List<com.obric.agent.dm.b> r55 = r54.a();     // Catch: Throwable -> L149
            if (r55 == null) goto L141;
            com.obric.agent.dm.b r56 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(d.a.p.d(r55, 0), com.obric.agent.dm.b.class, r3);     // Catch: Throwable -> L124
            if (r56 == null) goto L141;
            JsonObject r57 = r56.c();     // Catch: Throwable -> L124
        L143:
            if (com.obric.agent.w.a(r52) == false) goto L147;
            if (r52 == null) goto L146;
            r45 = d.o.o.a(r52, "_", null, 2, null);     // Catch: Throwable -> L124
        L146:
            r11.put("app_intent_domain", r45);     // Catch: Throwable -> L124
            r11.put("app_intent_intent_name", r52);     // Catch: Throwable -> L124
            r10.setIntentDomain(r45);     // Catch: Throwable -> L124
            r10.setIntentName(r52);     // Catch: Throwable -> L124
            r10.setIntentParameters(String.valueOf(r57));     // Catch: Throwable -> L124
        L147:
            Object r58 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L124
        L152:
            d.n.g(r58);
        L141:
            r57 = null;
        L124:
            th = th;
        L151:
            d.n.a r59 = d.n.f38560a;
            r58 = d.n.f(d.o.a(th));
        L126:
            r52 = null;
            goto L127
        L108:
            r46 = null;
        L149:
            th = th;
        L154:
            Object r60 = r11.opt("app_intent_engine_cost");
            if (r60 != null) goto L157;
        L159:
            Long r61 = d.c.b.a.b.a(r114.b());
        L161:
            if (r112 == false) goto L168;
            JSONObject r120 = new JSONObject();
            r120.put("app_intent_state", "DISPATCH_INTENT");
            Long r121 = r61;
            r34 = r3;
            r120.put("app_intent_engine_cost", r114.b());
            r120.put("app_intent_engine_result_code", r40.get(FontsContractCompat.Columns.RESULT_CODE));
            Object r62 = r40.get("error_msg");
            if (r62 == null) goto L165;
            r120.put("app_intent_engine_error_msg", r62);
        L165:
            r120.put("app_intent_has_authentication", r21);
            IAppLog r63 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, r34);
            if (r63 == null) goto L169;
            r63.reportToFlow("o_app_intent_engine_state", r120);
        L169:
            r11.put("app_intent_engine_cost", ((Number) ZeusTransformUtils.preCheckCast(r121, Number.class, r34)).longValue());
            r11.put("app_intent_engine_result_code", r40.get(FontsContractCompat.Columns.RESULT_CODE));
            r10.setEngineResultCode(String.valueOf(r40.get(FontsContractCompat.Columns.RESULT_CODE)));
            Object r64 = r40.get("error_msg");
            if (r64 == null) goto L172;
            r11.put("app_intent_engine_error_msg", r64);
            r10.setEngineErrorMsg(r64.toString());
            goto L172
        L168:
            r121 = r61;
            r34 = r3;
            goto L169
        L157:
            if (ZeusTransformUtils.instanceOf(r60, Long.class) == false) goto L159;
            r61 = d.c.b.a.b.a(((Number) ZeusTransformUtils.preCheckCast(r60, Number.class, r3)).longValue() + r114.b());
            goto L161
        L70:
            r32 = a.f15753a[r31.ordinal()];
        L173:
            String r65 = r3;
            ISecureLogDepend.Companion.i(r2, "report data: " + r11);
            if (this.f15751c == false) goto L178;
            IAppLog r66 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, r65);
            if (r66 == null) goto L178;
            r66.reportToFlow("app_intent_end_to_end", r11);
        L178:
            return r10;
        L61:
            r27 = 0;
            goto L62
        L43:
            r19 = false;
        L36:
            r20 = false;
            goto L46
        L35:
            if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L37;
        L48:
            r21 = false;
            goto L49
        L21:
            r9 = ZeusTransformUtils.mapRes(R.string.obric_is_talk, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_is_talk");
            goto L22
        L15:
            r6 = false;
        L8:
            r7 = 0;
            goto L18
        L7:
            if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
        L180:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$addInterruptedState$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f15757d;

        b(String r3, String r4, Map<String, ? extends Object> r5, d.c.d<? super b> r6) {
            Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15755b = r3;
            this.f15756c = r4;
            this.f15757d = r7;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15755b, this.f15756c, this.f15757d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15754a != 0) goto L10;
            d.o.a(r2);
            com.obric.agent.trace.h r3 = q.b(q.f15713a, this.f15755b);
            if (r3 == null) goto L8;
            r3.a(this.f15756c, this.f15757d);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {595}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$addReport$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.i f15759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15760c;

        c(com.obric.agent.trace.i r3, String r4, d.c.d<? super c> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15759b = r3;
            this.f15760c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f15759b, this.f15760c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15758a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L19:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            String r13 = ObricService.INSTANCE.getGson().toJson(q.a(q.f15713a, this.f15759b));
            if (q.e().size() < 50) goto L11;
            q.e().removeFirst();
        L11:
            q.e().add(this.f15759b);
            ((Map) ZeusTransformUtils.preCheckCast(q.f(), Map.class, "com.obric.aiagent.plugin")).put(this.f15760c, this.f15759b);
            Iterator r2 = q.i().iterator();
        L13:
            if (r2.hasNext() == false) goto L15;
            ((com.obric.agent.trace.s) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.agent.trace.s.class, "com.obric.aiagent.plugin")).a(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.l((Iterable) ZeusTransformUtils.preCheckCast(q.e(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")));
            goto L13
        L15:
            q r3 = q.f15713a;
            d.h.b.o.a(r13);
            q.c(r3, r13);
            q.d(q.f15713a, r13);
            q r5 = q.f15713a;
            com.obric.agent.trace.i r6 = this.f15759b;
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15758a = 1;
            if (q.a(r5, r6, false, r8, 2, null) != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$addReportListChangedListener$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.s f15762b;

        d(com.obric.agent.trace.s r3, d.c.d<? super d> r4) {
            com.obric.agent.trace.s r5 = (com.obric.agent.trace.s) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.agent.trace.s.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15762b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f15762b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15761a != 0) goto L7;
            d.o.a(r2);
            q.i().add(this.f15762b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$addStateParams$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f15766d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f15767e;

        e(String r3, String r4, Object r5, int r6, d.c.d<? super e> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15764b = r3;
            this.f15765c = r4;
            this.f15766d = r5;
            this.f15767e = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f15764b, this.f15765c, this.f15766d, this.f15767e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15763a != 0) goto L10;
            d.o.a(r3);
            com.obric.agent.trace.h r4 = q.b(q.f15713a, this.f15764b);
            if (r4 == null) goto L8;
            r4.a(this.f15765c, this.f15766d, this.f15767e);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {262}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$enterState$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.o f15770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15771d;

        f(String r3, com.obric.agent.trace.o r4, boolean r5, d.c.d<? super f> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15769b = r3;
            this.f15770c = r4;
            this.f15771d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f15769b, this.f15770c, this.f15771d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15768a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L22:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.agent.trace.h r8 = q.b(q.f15713a, "not_ready");
            com.obric.agent.trace.h r2 = q.b(q.f15713a, this.f15769b);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.f15769b, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L11;
            boolean r3 = true;
        L12:
            if (r3 == false) goto L16;
            if (r8 == null) goto L16;
            if (r2 != null) goto L16;
            r8.c(this.f15769b);
        L17:
            if (r8 == null) goto L22;
            com.obric.agent.trace.o r4 = this.f15770c;
            boolean r5 = this.f15771d;
            q r6 = q.f15713a;
            this.f15768a = 1;
            if (q.a(r6, r8, r4, r5, this) != r0) goto L22;
            return r0;
        L16:
            r8 = r2;
            goto L17
        L11:
            r3 = false;
            goto L12
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {275}, d = "enterState", e = "com.obric.agent.trace.IntentTracer")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15775d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ q f15776e;
        int f;

        g(q r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15776e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15775d = r3;
            this.f |= Integer.MIN_VALUE;
            return q.a(this.f15776e, null, null, false, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getDmOriginQuery$2$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<String> f15778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15779c;

        h(d.c.d<? super String> r3, String r4, d.c.d<? super h> r5) {
            d.c.d<String> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15778b = r6;
            this.f15779c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f15778b, this.f15779c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15777a != 0) goto L11;
            d.o.a(r2);
            d.c.d<String> r3 = this.f15778b;
            com.obric.agent.trace.h r1 = q.b(q.f15713a, this.f15779c);
            if (r1 == null) goto L7;
            String r4 = r1.c();
        L8:
            d.n.a r0 = d.n.f38560a;
            r3.resumeWith(d.n.f(r4));
            return d.x.f38692a;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {624}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getHistoryReports$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<List<com.obric.agent.trace.i>> f15781b;

        /* JADX INFO: renamed from: com.obric.agent.trace.q$i$1, reason: invalid class name */
        /* JADX INFO: compiled from: IntentTracer.kt */
        @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getHistoryReports$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15782a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d.h.b.z.f<List<com.obric.agent.trace.i>> f15783b;

            AnonymousClass1(d.h.b.z.f<List<com.obric.agent.trace.i>> r3, d.c.d<? super AnonymousClass1> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f15783b = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f15783b, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Type inference failed for: r3v8, types: [T, java.util.List] */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f15782a != 0) goto L7;
                d.o.a(r3);
                d.h.b.z.f<List<com.obric.agent.trace.i>> r2 = this.f15783b;
                r2.f38504a = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.l((Iterable) ZeusTransformUtils.preCheckCast(q.e(), Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        i(d.h.b.z.f<List<com.obric.agent.trace.i>> r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15781b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f15781b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15780a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            ca r12 = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f15781b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            d.c.d<? super d.x> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15780a = 1;
            if (r12.b(r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getLocalMessageIdByMsgId$2$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<String> f15785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15786c;

        j(d.c.d<? super String> r3, String r4, d.c.d<? super j> r5) {
            d.c.d<String> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15785b = r6;
            this.f15786c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f15785b, this.f15786c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15784a != 0) goto L11;
            d.o.a(r2);
            d.c.d<String> r3 = this.f15785b;
            com.obric.agent.trace.h r1 = q.b(q.f15713a, this.f15786c);
            if (r1 == null) goto L7;
            String r4 = r1.e();
        L8:
            d.n.a r0 = d.n.f38560a;
            r3.resumeWith(d.n.f(r4));
            return d.x.f38692a;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getQuery$2$1")
    static final class k extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<String> f15788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15789c;

        k(d.c.d<? super String> r3, String r4, d.c.d<? super k> r5) {
            d.c.d<String> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15788b = r6;
            this.f15789c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f15788b, this.f15789c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15787a != 0) goto L11;
            d.o.a(r2);
            d.c.d<String> r3 = this.f15788b;
            com.obric.agent.trace.h r1 = q.b(q.f15713a, this.f15789c);
            if (r1 == null) goto L7;
            String r4 = r1.a();
        L8:
            d.n.a r0 = d.n.f38560a;
            r3.resumeWith(d.n.f(r4));
            return d.x.f38692a;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getReWriteContent$2$1")
    static final class l extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<String> f15791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15792c;

        l(d.c.d<? super String> r3, String r4, d.c.d<? super l> r5) {
            d.c.d<String> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15791b = r6;
            this.f15792c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((l) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), l.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new l(this.f15791b, this.f15792c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15790a != 0) goto L11;
            d.o.a(r2);
            d.c.d<String> r3 = this.f15791b;
            com.obric.agent.trace.h r1 = q.b(q.f15713a, this.f15792c);
            if (r1 == null) goto L7;
            String r4 = r1.b();
        L8:
            d.n.a r0 = d.n.f38560a;
            r3.resumeWith(d.n.f(r4));
            return d.x.f38692a;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {652}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getReportByMessageId$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super IntentDebugReport>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f15797e;
        final /* synthetic */ String f;

        m(String r3, d.c.d<? super m> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super IntentDebugReport> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super IntentDebugReport> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15797e;
            Integer r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.h.b.z.f r2 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f15796d, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.i r4 = (com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(this.f15795c, com.obric.agent.trace.i.class, "com.obric.aiagent.plugin");
            d.h.b.z.f r5 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f15794b, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            String r9 = (String) ZeusTransformUtils.preCheckCast(this.f15793a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r10);
            T r11 = r10;
        L19:
            r2.f38504a = r11;
            IntentDebugReport r12 = (IntentDebugReport) ZeusTransformUtils.preCheckCast(r5.f38504a, IntentDebugReport.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L30;
            r12.setCostTime(String.valueOf(r4.e()));
            com.obric.agent.trace.f r6 = r4.d();
            if (r6 == null) goto L24;
            String r7 = r6.b();
        L25:
            r12.setActionResult(r7);
            com.obric.agent.trace.f r8 = r4.d();
            if (r8 == null) goto L28;
            r3 = d.c.b.a.b.a(r8.c());
        L28:
            r12.setResultCode(r3);
            r12.setFirstIntentResult(r9);
            goto L30
        L24:
            r7 = null;
        L30:
            return (IntentDebugReport) ZeusTransformUtils.preCheckCast(r5.f38504a, IntentDebugReport.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            r4 = (com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(q.f().get(this.f), com.obric.agent.trace.i.class, "com.obric.aiagent.plugin");
            q r13 = q.f15713a;
            if (r4 == null) goto L12;
            List<com.obric.agent.trace.u> r14 = r4.g();
            if (r14 == null) goto L12;
        L13:
            String r15 = q.a(r13, r14);
            ISecureLogDepend.Companion.i("IntentTracer", "getLatestDebugExecution pcResult " + r15);
            d.h.b.z.f r16 = new d.h.b.z.f();
            if (r4 == null) goto L31;
            q r17 = q.f15713a;
            this.f15793a = r15;
            this.f15794b = r16;
            this.f15795c = r4;
            this.f15796d = r16;
            this.f15797e = 1;
            Object r18 = q.a(r17, r4, false, this);
            if (r18 != r0) goto L18;
            return r0;
        L18:
            r2 = r16;
            r5 = r2;
            r11 = r18;
            r9 = r15;
            goto L19
        L31:
            return null;
        L12:
            r14 = d.a.p.b();
            goto L13
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getRunningAction$2$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<String> f15799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15800c;

        n(d.c.d<? super String> r3, String r4, d.c.d<? super n> r5) {
            d.c.d<String> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15799b = r6;
            this.f15800c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f15799b, this.f15800c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15798a != 0) goto L11;
            d.o.a(r2);
            d.c.d<String> r3 = this.f15799b;
            com.obric.agent.trace.h r1 = q.b(q.f15713a, this.f15800c);
            if (r1 == null) goto L7;
            String r4 = r1.h();
        L8:
            d.n.a r0 = d.n.f38560a;
            r3.resumeWith(d.n.f(r4));
            return d.x.f38692a;
        L7:
            r4 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$getStateTimeCost$2$1")
    static final class o extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<Long> f15802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.agent.trace.o f15804d;

        o(d.c.d<? super Long> r3, String r4, com.obric.agent.trace.o r5, d.c.d<? super o> r6) {
            d.c.d<Long> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15802b = r7;
            this.f15803c = r4;
            this.f15804d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((o) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), o.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new o(this.f15802b, this.f15803c, this.f15804d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15801a != 0) goto L11;
            d.o.a(r3);
            d.c.d<Long> r4 = this.f15802b;
            com.obric.agent.trace.h r0 = q.b(q.f15713a, this.f15803c);
            if (r0 == null) goto L7;
            Long r2 = r0.a(this.f15804d);
        L8:
            d.n.a r1 = d.n.f38560a;
            r4.resumeWith(d.n.f(r2));
            return d.x.f38692a;
        L7:
            r2 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$init$1")
    static final class p extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkedList<com.obric.agent.trace.i> f15806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinkedHashMap<String, com.obric.agent.trace.i> f15807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f15808d;

        /* JADX INFO: renamed from: com.obric.agent.trace.q$p$1, reason: invalid class name */
        /* JADX INFO: compiled from: IntentTracer.kt */
        @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$init$1$2")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15809a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ LinkedList<com.obric.agent.trace.i> f15810b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ LinkedHashMap<String, com.obric.agent.trace.i> f15811c;

            AnonymousClass1(LinkedList<com.obric.agent.trace.i> r3, LinkedHashMap<String, com.obric.agent.trace.i> r4, d.c.d<? super AnonymousClass1> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f15810b = r3;
                this.f15811c = r4;
                super(2, r6);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f15810b, this.f15811c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f15809a != 0) goto L7;
                d.o.a(r4);
                q.e().addAll((Collection) ZeusTransformUtils.preCheckCast(this.f15810b, Collection.class, "com.obric.aiagent.plugin"));
                q.f().putAll((Map) ZeusTransformUtils.preCheckCast(this.f15811c, Map.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        p(LinkedList<com.obric.agent.trace.i> r3, LinkedHashMap<String, com.obric.agent.trace.i> r4, d.c.d<? super p> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15806b = r3;
            this.f15807c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((p) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), p.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            p r0 = new p(this.f15806b, this.f15807c, r6);
            r0.f15808d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f15805a != 0) goto L31;
            d.o.a(r10);
            am r11 = (am) ZeusTransformUtils.preCheckCast(this.f15808d, am.class, "com.obric.aiagent.plugin");
            File r12 = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "intent_log.txt");
            if (r12.exists() == false) goto L28;
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(d.f.k.b(r12, null, 1, null), Iterable.class, "com.obric.aiagent.plugin");
            LinkedList<com.obric.agent.trace.i> r3 = this.f15806b;
            LinkedHashMap<String, com.obric.agent.trace.i> r4 = this.f15807c;
            Iterator r14 = r13.iterator();
        L8:
            if (r14.hasNext() == false) goto L28;
            String r5 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L12;
            boolean r6 = true;
        L13:
            if (r6 == true) goto L32;
            r5 = null;
        L32:
            d.n.a r7 = d.n.f38560a;     // Catch: Throwable -> L18
            Object r8 = d.n.f((com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(r5, com.obric.agent.trace.i.class), com.obric.agent.trace.i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        L21:
            if (d.n.b(r8) == false) goto L23;
            r8 = null;
        L23:
            com.obric.agent.trace.i r9 = (com.obric.agent.trace.i) ZeusTransformUtils.preCheckCast(r8, com.obric.agent.trace.i.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L8;
            r3.add(r9);
            if (r9.l() == null) goto L8;
            ((Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin")).put(r9.l(), r9);
        L18:
            th = move-exception;
            d.n.a r15 = d.n.f38560a;
            r8 = d.n.f(d.o.a(th));
            goto L21
        L12:
            r6 = false;
        L28:
            kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f15806b, this.f15807c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return d.x.f38692a;
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.trace.q$q, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IntentTracer.kt */
    public static final class C0320q implements com.obric.assistant.dm.api.statemachine.core.b {

        /* JADX INFO: renamed from: com.obric.agent.trace.q$q$a */
        /* JADX INFO: compiled from: IntentTracer.kt */
        @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$init$2$onTaskStateChanged$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15812a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f15813b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ State f15814c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DMEvent f15815d;

            a(TaskInfo r3, State r4, DMEvent r5, d.c.d<? super a> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f15813b = r3;
                this.f15814c = r4;
                this.f15815d = r5;
                super(2, r7);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f15813b, this.f15814c, this.f15815d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f15812a != 0) goto L10;
                d.o.a(r3);
                q r4 = q.f15713a;
                String r0 = this.f15813b.getQueryId();
                if (r0 != null) goto L7;
                r0 = "";
            L7:
                q.a(r4, r0).a(this.f15814c, this.f15813b, this.f15815d);
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.agent.trace.q$q$b */
        /* JADX INFO: compiled from: IntentTracer.kt */
        @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$init$2$onTransitionFailed$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f15816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TaskInfo f15817b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ State f15818c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ DMEvent f15819d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Exception f15820e;

            b(TaskInfo r3, State r4, DMEvent r5, Exception r6, d.c.d<? super b> r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f15817b = r3;
                this.f15818c = r4;
                this.f15819d = r5;
                this.f15820e = r6;
                super(2, r8);
            }

            public final Object a(am r3, d.c.d<? super d.x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f15817b, this.f15818c, this.f15819d, this.f15820e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f15816a != 0) goto L10;
                d.o.a(r4);
                q r5 = q.f15713a;
                String r0 = this.f15817b.getQueryId();
                if (r0 != null) goto L7;
                r0 = "";
            L7:
                q.a(r5, r0).a(this.f15817b, this.f15818c, this.f15819d, this.f15820e);
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(DMState r1) {
            d.h.b.o.e(r1, "status");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r1) {
            d.h.b.o.e(r1, "taskInfo");
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void b(TaskInfo r1) {
            d.h.b.o.e(r1, "taskInfo");
        }

        C0320q() {
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r7, State r8, State r9, DMEvent r10) {
            d.h.b.o.e(r7, "taskInfo");
            d.h.b.o.e(r9, "newState");
            if (r8 == null) goto L5;
            String r11 = r8.getStateName();
        L7:
            if (d.h.b.o.a(r11, r9.getStateName()) == true) goto L10;
            kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r7, r9, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return;
        L10:
            return;
        L5:
            r11 = null;
            goto L7
        }

        @Override // com.obric.assistant.dm.api.statemachine.core.b
        public void a(TaskInfo r8, State r9, DMEvent r10, Exception r11) {
            d.h.b.o.e(r8, "taskInfo");
            d.h.b.o.e(r9, "currentState");
            d.h.b.o.e(r11, "exception");
            kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r8, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$isDmSuccess$2$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.c.d<Boolean> f15822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15823c;

        r(d.c.d<? super Boolean> r3, String r4, d.c.d<? super r> r5) {
            d.c.d<Boolean> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15822b = r6;
            this.f15823c = r4;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new r(this.f15822b, this.f15823c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f15821a != 0) goto L17;
            d.o.a(r3);
            d.c.d<Boolean> r4 = this.f15822b;
            com.obric.agent.trace.h r2 = q.b(q.f15713a, this.f15823c);
            if (r2 != null) goto L7;
            Boolean r5 = null;
        L14:
            d.n.a r0 = d.n.f38560a;
            r4.resumeWith(d.n.f(r5));
            return d.x.f38692a;
        L7:
            if (r2.c(com.obric.agent.trace.o.p) == true) goto L9;
        L11:
            boolean r6 = false;
        L12:
            r5 = d.c.b.a.b.a(r6);
            goto L14
        L9:
            if (r2.a(com.obric.agent.trace.o.p, "dm_result") == false) goto L11;
            r6 = true;
            goto L12
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$manageLogFile$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15825b;

        s(String r3, d.c.d<? super s> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15825b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f15825b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15824a != 0) goto L7;
            d.o.a(r2);
            q.e(q.f15713a, this.f15825b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {228, 248}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$markQueryInput$1")
    static final class t extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15829d;

        t(String r3, String r4, d.c.d<? super t> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15828c = r3;
            this.f15829d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((t) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), t.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new t(this.f15828c, this.f15829d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.String] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15827b;
            boolean r3 = false;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.obric.agent.trace.h r14 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(this.f15826a, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L51:
            r14.b(q.a(q.f15713a));
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.h.b.z.f r2 = (d.h.b.z.f) ZeusTransformUtils.preCheckCast(this.f15826a, d.h.b.z.f.class, "com.obric.aiagent.plugin");
            d.o.a(r15);
        L24:
            CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f15828c, CharSequence.class, "com.obric.aiagent.plugin");
            if (r16.length() != 0) goto L27;
            boolean r6 = true;
        L29:
            if (r6 == false) goto L31;
            r16 = "not_ready";
        L31:
            String r17 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.h r7 = q.b(q.f15713a, "not_ready");
            if (d.h.b.o.a(r17, "not_ready") == true) goto L35;
            if (r7 == null) goto L35;
            r7.c(r17);
        L37:
            if (q.a(q.f15713a) == false) goto L39;
        L42:
            r7.a(this.f15829d);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.f38504a, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L45;
            r3 = true;
        L45:
            if (r3 == false) goto L47;
            r7.b((String) ZeusTransformUtils.preCheckCast(r2.f38504a, String.class, "com.obric.aiagent.plugin"));
        L47:
            com.obric.agent.trace.o r9 = com.obric.agent.trace.o.f15589c;
            d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15826a = r7;
            this.f15827b = 2;
            if (com.obric.agent.trace.h.a(r7, r9, false, r11, 2, null) != r0) goto L50;
            return r0;
        L50:
            r14 = r7;
            goto L51
        L39:
            if (d.h.b.o.a(r17, "not_ready") == true) goto L41;
            q r8 = q.f15713a;
            q.e(r17);
        L41:
            r7.c(q.g());
        L35:
            r7 = q.a(q.f15713a, r17);
            goto L37
        L27:
            r6 = false;
            goto L29
        L10:
            d.o.a(r15);
            r2 = new d.h.b.z.f();
            r2.f38504a = "";
            Object r10 = null;
            Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(q.h(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r18.hasNext() == false) goto L19;
            Object r12 = r18.next();
            if (((com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r12, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin")).d() != com.obric.agent.trace.o.o) goto L16;
            boolean r13 = true;
        L17:
            if (r13 == false) goto L12;
            r10 = r12;
            goto L12
        L16:
            r13 = false;
            goto L17
        L19:
            com.obric.agent.trace.h r19 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r10, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
            if (r19 == null) goto L24;
            r19.a(new com.obric.agent.trace.f(com.obric.agent.trace.n.f15582a, null, 0, 6, null));
            r2.f38504a = r19.a();
            q r20 = q.f15713a;
            com.obric.agent.trace.o r21 = com.obric.agent.trace.o.A;
            this.f15826a = r2;
            this.f15827b = 1;
            if (q.a(r20, r19, r21, false, this, 4, null) != r0) goto L24;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {ResultCode.ERROR_MEMORY_SERVICE_DISABLED}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onAuthBegin$1")
    static final class u extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f15832c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15833d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f15834e;

        u(String r3, int r4, d.c.d<? super u> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15833d = r3;
            this.f15834e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((u) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), u.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new u(this.f15833d, this.f15834e, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15832c;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            int r2 = this.f15830a;
            com.obric.agent.trace.h r10 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(this.f15831b, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
            com.obric.agent.trace.h r3 = r10;
        L14:
            com.obric.agent.trace.h.a(r3, "auth_status_code", d.c.b.a.b.a(r2), 0, 4, null);
        L16:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.agent.trace.h r12 = q.b(q.f15713a, this.f15833d);
            if (r12 == null) goto L16;
            int r4 = this.f15834e;
            q r5 = q.f15713a;
            com.obric.agent.trace.o r6 = com.obric.agent.trace.o.s;
            this.f15831b = r12;
            this.f15830a = r4;
            this.f15832c = 1;
            if (q.a(r5, r12, r6, false, this, 4, null) != r0) goto L13;
            return r0;
        L13:
            r3 = r12;
            r2 = r4;
            goto L14
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {315}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onAuthEnd$1")
    static final class v extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15836b;

        v(String r3, d.c.d<? super v> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15836b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((v) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), v.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new v(this.f15836b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15835a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.agent.trace.h r4 = q.b(q.f15713a, this.f15836b);
            if (r4 == null) goto L14;
            q r3 = q.f15713a;
            com.obric.agent.trace.o r5 = com.obric.agent.trace.o.r;
            this.f15835a = 1;
            if (q.a(r3, r4, r5, false, this, 4, null) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {527}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onMessageInterrupt$1")
    static final class w extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15839c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f15840d;

        w(String r3, Map<String, String> r4, d.c.d<? super w> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15838b = r3;
            this.f15839c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((w) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), w.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            w r0 = new w(this.f15838b, this.f15839c, r6);
            r0.f15840d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15837a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L32:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            am r13 = (am) ZeusTransformUtils.preCheckCast(this.f15840d, am.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.h r14 = q.b(q.f15713a, this.f15838b);
            if (r14 == null) goto L32;
            Map<String, String> r2 = this.f15839c;
            r14.a(new com.obric.agent.trace.f(com.obric.agent.trace.n.f15583b, "msg interrupt", 3));
            if (r2 == null) goto L24;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("bot_state"), String.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L24;
            d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L16
            Object r6 = d.n.f((BotState) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(r4, BotState.class), BotState.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        L19:
            if (d.n.b(r6) == false) goto L21;
            r6 = null;
        L21:
            BotState r10 = (BotState) ZeusTransformUtils.preCheckCast(r6, BotState.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L24;
            com.obric.agent.trace.h.a(r14, "agent_id", r10.getAgentId(), 0, 4, null);
            com.obric.agent.trace.h.a(r14, "agent_name", r10.getAgentName(), 0, 4, null);
        L16:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r6 = d.n.f(d.o.a(th));
        L24:
            if (r2 == null) goto L28;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L28;
            r14.e(r3);
        L28:
            q r8 = q.f15713a;
            com.obric.agent.trace.o r9 = com.obric.agent.trace.o.A;
            this.f15837a = 1;
            if (q.a(r8, r14, r9, false, this, 4, null) != r0) goto L32;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onMessageSend$1")
    static final class x extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f15843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f15844d;

        x(String r3, String r4, String r5, d.c.d<? super x> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15842b = r3;
            this.f15843c = r4;
            this.f15844d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((x) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), x.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new x(this.f15842b, this.f15843c, this.f15844d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f15841a != 0) goto L10;
            d.o.a(r2);
            com.obric.agent.trace.h r3 = q.b(q.f15713a, this.f15842b);
            if (r3 == null) goto L8;
            String r0 = this.f15843c;
            String r1 = this.f15844d;
            r3.d(r0);
            r3.f(r1);
        L8:
            return d.x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {501}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onMessageTimeout$1")
    static final class y extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15846b;

        y(String r3, d.c.d<? super y> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15846b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((y) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new y(this.f15846b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f15845a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.agent.trace.h r4 = q.b(q.f15713a, this.f15846b);
            if (r4 == null) goto L14;
            r4.a(new com.obric.agent.trace.f(com.obric.agent.trace.n.f15584c, "time out", 2));
            q r3 = q.f15713a;
            com.obric.agent.trace.o r5 = com.obric.agent.trace.o.A;
            this.f15845a = 1;
            if (q.a(r3, r4, r5, false, this, 4, null) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: IntentTracer.kt */
    @d.c.b.a.f(b = "IntentTracer.kt", c = {725, 730}, d = "invokeSuspend", e = "com.obric.agent.trace.IntentTracer$onServerReply$1")
    static final class z extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map<String, String> f15849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f15850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f15851e;
        private /* synthetic */ Object f;

        z(String r3, Map<String, String> r4, boolean r5, String r6, d.c.d<? super z> r7) {
            Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15848b = r3;
            this.f15849c = r8;
            this.f15850d = r5;
            this.f15851e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((z) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), z.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            z r11 = new z(this.f15848b, this.f15849c, this.f15850d, this.f15851e, r7);
            r11.f = r9;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r11, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r23) {
            Object r8 = d.c.a.b.a();
            int r0 = this.f15847a;
            boolean r2 = false;
            if (r0 == 0) goto L10;
            if (r0 == 1) goto L9;
            if (r0 != 2) goto L8;
            d.o.a(r23);
        L79:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            com.obric.agent.trace.h r1 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(this.f, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
            d.o.a(r23);
        L70:
            if (d.h.b.o.a(r1.g(), IAssistInputHost.TaskType.TASK_TYPE_COMPLEX_TASK) == false) goto L72;
        L73:
            r2 = true;
        L74:
            if (r2 == true) goto L79;
            q r3 = q.f15713a;
            com.obric.agent.trace.o r4 = com.obric.agent.trace.o.A;
            this.f = null;
            this.f15847a = 2;
            if (q.a(r3, r1, r4, false, this, 4, null) != r8) goto L79;
            return r8;
        L72:
            if (d.h.b.o.a(r1.g(), IAssistInputHost.TaskType.TASK_TYPE_AUTO_GUI) == false) goto L74;
        L10:
            d.o.a(r23);
            am r5 = (am) ZeusTransformUtils.preCheckCast(this.f, am.class, "com.obric.aiagent.plugin");
            com.obric.agent.trace.h r7 = q.b(q.f15713a, this.f15848b);
            if (r7 == null) goto L79;
            Map<String, String> r15 = this.f15849c;
            boolean r14 = this.f15850d;
            String r13 = this.f15851e;
            if (r15 == null) goto L27;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r15.get("bot_state"), String.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L27;
            d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L18
            Object r10 = d.n.f((BotState) ZeusTransformUtils.preCheckCast(ObricService.INSTANCE.getGson().fromJson(r6, BotState.class), BotState.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
        L21:
            if (d.n.b(r10) == false) goto L23;
            r10 = null;
        L23:
            BotState r11 = (BotState) ZeusTransformUtils.preCheckCast(r10, BotState.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L27;
            com.obric.agent.trace.h.a(r7, "agent_id", r11.getAgentId(), 0, 4, null);
            com.obric.agent.trace.h.a(r7, "agent_name", r11.getAgentName(), 0, 4, null);
        L18:
            th = move-exception;
            d.n.a r12 = d.n.f38560a;
            r10 = d.n.f(d.o.a(th));
        L27:
            if (r15 == null) goto L31;
            String r16 = (String) ZeusTransformUtils.preCheckCast(r15.get("inner_log_id"), String.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L31;
            r7.e(r16);
        L31:
            if (r15 == null) goto L33;
            String r17 = (String) ZeusTransformUtils.preCheckCast(r15.get("client_meta"), String.class, "com.obric.aiagent.plugin");
        L34:
            CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
            if (r18 != null) goto L37;
        L40:
            boolean r19 = true;
        L42:
            if (r19 == false) goto L80;
            JSONObject r20 = null;
        L53:
            if (r20 != null) goto L55;
        L58:
            if (r14 == false) goto L60;
            r7.a(SystemClock.elapsedRealtime());
            goto L79
        L60:
            com.obric.agent.trace.h.a(r7, "server_reply", r13, 0, 4, null);
            if (r20 != null) goto L63;
        L66:
            q r21 = q.f15713a;
            com.obric.agent.trace.f r22 = new com.obric.agent.trace.f(com.obric.agent.trace.n.f15582a, r13, 0, 4, null);
            this.f = r7;
            this.f15847a = 1;
            if (q.a(r21, r7, r22, this) == r8) goto L68;
        L65:
            r1 = r7;
            goto L70
        L68:
            return r8;
        L63:
            if (r20.optInt("isSilent", 0) == 1) goto L65;
        L55:
            if (d.h.b.o.a(r20.optString("o_msg_middle_flag", ""), "1") == false) goto L58;
            ILogDepend.Companion.i("IntentTracer", "is middle state, need filter.");
            return d.x.f38692a;
        L80:
            d.n.a r24 = d.n.f38560a;     // Catch: Throwable -> L45
            Object r25 = d.n.f(new JSONObject(r17));     // Catch: Throwable -> L45
        L47:
            Throwable r110 = d.n.c(r25);
            if (r110 == null) goto L51;
            ILogDepend.Companion.e("IntentTracer", "Invalid client_meta JSON: " + r17, r110);
            r25 = null;
        L51:
            r20 = (JSONObject) ZeusTransformUtils.preCheckCast(r25, JSONObject.class, "com.obric.aiagent.plugin");
        L45:
            th = move-exception;
            d.n.a r111 = d.n.f38560a;
            r25 = d.n.f(d.o.a(th));
            goto L47
        L37:
            if (d.o.o.d(r18) == true) goto L40;
            r19 = false;
            goto L42
        L33:
            r17 = null;
            goto L34
        }
    }

    private final boolean j() {
        return false;
    }

    public final void b() {
    }

    private q() {
    }

    public static final /* synthetic */ com.obric.agent.trace.h a(q r0, String r1) {
        return r0.g(r1);
    }

    public static final /* synthetic */ Object a(q r2, com.obric.agent.trace.h r3, com.obric.agent.trace.f r4, d.c.d r5) {
        return r2.setResult(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(q r2, com.obric.agent.trace.h r3, com.obric.agent.trace.o r4, boolean r5, d.c.d r6) {
        return r2.a(r3, r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(q r0, com.obric.agent.trace.i r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ Object a(q r2, com.obric.agent.trace.i r3, boolean r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(q r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(q r0) {
        return r0.j();
    }

    public static final /* synthetic */ com.obric.agent.trace.h b(q r0, String r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ void c(q r0, String r1) {
        r0.i(r1);
    }

    public static final /* synthetic */ void d(q r0, String r1) {
        r0.h(r1);
    }

    public static final /* synthetic */ LinkedList e() {
        return f15715c;
    }

    public static final /* synthetic */ void e(q r0, String r1) {
        r0.j(r1);
    }

    public static final /* synthetic */ void e(String r0) {
        g = r0;
    }

    public static final /* synthetic */ a f() {
        return f15716d;
    }

    public static final /* synthetic */ String g() {
        return g;
    }

    public static final /* synthetic */ Set h() {
        return f15714b;
    }

    public static final /* synthetic */ List i() {
        return f15717e;
    }

    static {
        f15713a = new q();
        ConcurrentHashMap.KeySetView r0 = ConcurrentHashMap.newKeySet();
        d.h.b.o.c(r0, "newKeySet(...)");
        f15714b = (Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.aiagent.plugin");
        f15715c = new LinkedList();
        f15716d = new a(50);
        f15717e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f = new a(5);
        g = "";
        h = 600;
        i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        j = new a(5);
    }

    private final long k() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public final void a() {
        LinkedList r9 = new LinkedList();
        LinkedHashMap r0 = new LinkedHashMap();
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new p(r9, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        IFlowSettingsIDL r10 = at.a(d.h.b.aa.b(IFlowSettingsIDL.class));
        if (r10 == null) goto L5;
        int r11 = r10.getObricPowerLockTimeoutInSeconds();
    L6:
        if (r11 == 0) goto L8;
        h = r11;
    L8:
        IDialogStateManager r12 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L12;
        r12.registerDMStateListener((com.obric.assistant.dm.api.statemachine.core.b) ZeusTransformUtils.preCheckCast(new C0320q(), com.obric.assistant.dm.api.statemachine.core.b.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        return;
    L5:
        r11 = 0;
        goto L6
    }

    public final void a(String r7, String r8, String r9) {
        if (j() == true) goto L6;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ab(r7, r9, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void a(String r8, long r9, String r11) {
        d.h.b.o.e(r8, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new aa(r8, r11, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r7, String r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        d.h.b.o.e(r8, DownloadConstants.QUERY_KEY);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new t(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(q r0, String r1, com.obric.agent.trace.o r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.a(r1, r2, r3);
    }

    public final void a(String r7, com.obric.agent.trace.o r8, boolean r9) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        d.h.b.o.e(r8, "state");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r7, r8, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object a(com.obric.agent.trace.h r6, com.obric.agent.trace.o r7, boolean r8, d.c.d<? super d.x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, g.class) == false) goto L7;
        g r0 = (g) ZeusTransformUtils.preCheckCast(r10, g.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f15775d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r7 = (com.obric.agent.trace.o) ZeusTransformUtils.preCheckCast(r0.f15774c, com.obric.agent.trace.o.class, "com.obric.aiagent.plugin");
        r6 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r0.f15773b, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
        q r5 = (q) ZeusTransformUtils.preCheckCast(r0.f15772a, q.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L23:
        if (r7 != com.obric.agent.trace.o.A) goto L29;
        String r12 = r6.f();
        if (r12 == null) goto L27;
        f15713a.a(r12, false);
    L27:
        f15714b.remove(r6);
        g = "";
    L29:
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        if (r7 == com.obric.agent.trace.o.A) goto L17;
    L19:
        r0.f15772a = this;
        r0.f15773b = r6;
        r0.f15774c = r7;
        r0.f = 1;
        if (r6.a(r7, r8, r0) != r2) goto L23;
        return r2;
    L17:
        if (d.h.b.o.a(r6.e(), "not_ready") == false) goto L19;
        r6.c(g);
    L7:
        r0 = new g(this, r10);
        goto L8
    }

    static /* synthetic */ Object a(q r1, com.obric.agent.trace.h r2, com.obric.agent.trace.o r3, boolean r4, d.c.d r5, int r6, Object r7) {
        d.c.d<? super d.x> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        return r1.a(r2, r3, r4, r8);
    }

    public final void a(String r9, com.obric.agent.trace.o r10, long r11, boolean r13) {
        d.h.b.o.e(r9, DbHelper.COL_ID);
        d.h.b.o.e(r10, "state");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ah(r9, r10, r11, r13, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r7, com.obric.agent.trace.o r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        d.h.b.o.e(r8, "state");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ag(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(String r10, com.obric.agent.trace.o r11, d.c.d<? super Long> r12) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r13 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r13, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new o(r1, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r14 = r13.a();
        if (r14 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r14;
    }

    public final void a(String r7, int r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new u(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r7) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new v(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final com.obric.agent.trace.h f(String r8) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r7 = true;
    L6:
        Object r3 = null;
        if (r7 == false) goto L9;
        return null;
    L9:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(f15714b, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r9.hasNext() == false) goto L22;
        Object r4 = r9.next();
        com.obric.agent.trace.h r5 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(r5.e(), r8) == false) goto L15;
    L18:
        boolean r6 = true;
    L19:
        if (r6 == false) goto L11;
        r3 = r4;
        goto L22
    L15:
        if (d.h.b.o.a(r5.f(), r8) == true) goto L18;
        r6 = false;
    L22:
        return (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r3, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
    L5:
        r7 = false;
        goto L6
    }

    private final com.obric.agent.trace.h g(String r2) {
        com.obric.agent.trace.h r3 = f(r2);
        if (r3 != null) goto L6;
        q r1 = (q) ZeusTransformUtils.preCheckCast(this, q.class, "com.obric.aiagent.plugin");
        com.obric.agent.trace.h r4 = new com.obric.agent.trace.h();
        r4.c("not_ready");
        f15714b.add(r4);
        return r4;
    L6:
        return r3;
    }

    public static /* synthetic */ void a(q r0, String r1, String r2, Object r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = 0;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    public final void a(String r8, String r9, Object r10, int r11) {
        d.h.b.o.e(r8, DbHelper.COL_ID);
        d.h.b.o.e(r9, "key");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r8, r9, r10, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r8, String r9, Map<String, ? extends Object> r10) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, DbHelper.COL_ID);
        d.h.b.o.e(r9, "interruptReason");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r8, r9, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r10, Map<String, String> r11) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "reason");
        ILogDepend.Companion.i("IntentTracer", "onProcessDead: reason=" + r10 + ", params=" + r9);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(f15714b, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r4 = r3.next();
        if (((com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r4, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin")).d() == com.obric.agent.trace.o.A) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        r5 = false;
        goto L9
    L11:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r6.hasNext() == false) goto L21;
        com.obric.agent.trace.h r7 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r6.next(), com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        r8.put("reason", r10);
        if (r9 == null) goto L20;
        Iterator r12 = r9.entrySet().iterator();
    L18:
        if (r12.hasNext() == false) goto L20;
        Map.Entry r13 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r8.put((String) ZeusTransformUtils.preCheckCast(r13.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r13.getValue(), String.class, "com.obric.aiagent.plugin"));
    L20:
        r7.a("progress dead", r8);
        ILogDepend.Companion.i("IntentTracer", "onProcessDead: Added progress dead state for id=" + r7.e() + ", msgId=" + r7.f() + ", reason=" + r10);
        r7.g(r10);
        goto L13
    }

    public final Object a(String r10, d.c.d<? super String> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    public final Object b(String r10, d.c.d<? super String> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    public final Object c(String r10, d.c.d<? super String> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    public final Object d(String r10, d.c.d<? super Boolean> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    public final void setResult(String r7, com.obric.agent.trace.f r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        d.h.b.o.e(r8, "result");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ae(r7, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final Object setResult(com.obric.agent.trace.h r10, com.obric.agent.trace.f r11, d.c.d<? super d.x> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, af.class) == false) goto L7;
        af r0 = (af) ZeusTransformUtils.preCheckCast(r13, af.class, "com.obric.aiagent.plugin");
        if ((r0.f15740e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f15740e -= Integer.MIN_VALUE;
    L8:
        af r6 = r0;
        Object r14 = r6.f15738c;
        Object r1 = d.c.a.b.a();
        int r2 = r6.f15740e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r11 = (com.obric.agent.trace.f) ZeusTransformUtils.preCheckCast(r6.f15737b, com.obric.agent.trace.f.class, "com.obric.aiagent.plugin");
        r10 = (com.obric.agent.trace.h) ZeusTransformUtils.preCheckCast(r6.f15736a, com.obric.agent.trace.h.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L17:
        r10.a(r11);
        com.obric.agent.trace.h r3 = r10;
        com.obric.agent.trace.h.a(r3, "result_status", r11.a(), 0, 4, null);
        com.obric.agent.trace.h.a(r3, "msg", r11.b(), 0, 4, null);
        if (r11.c() == 0) goto L21;
        com.obric.agent.trace.h.a(r10, "error_msg", r11.b(), 0, 4, null);
        r10.a("error_code", d.c.b.a.b.a(r11.c()), r11.c());
    L21:
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        com.obric.agent.trace.o r4 = com.obric.agent.trace.o.w;
        r6.f15736a = r10;
        r6.f15737b = r11;
        r6.f15740e = 1;
        if (a(this, r10, r4, false, r6, 4, null) != r1) goto L17;
        return r1;
    L7:
        r0 = new af(this, r13);
        goto L8
    }

    public final void b(String r7) {
        d.h.b.o.e(r7, "localMessageId");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new y(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static /* synthetic */ void a(q r1, String r2, Map r3, int r4, Object r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.b(r2, r6);
    }

    public final void b(String r8, Map<String, String> r9) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "localMessageId");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new w(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object e(String r10, d.c.d<? super String> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    public final void c(String r7) {
        d.h.b.o.e(r7, "msgId");
        if (j() == true) goto L6;
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ad(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    public final void b(String r7, String r8, String r9) {
        d.h.b.o.e(r7, "localMessageId");
        d.h.b.o.e(r8, "msgId");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new x(r7, r8, r9, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r3, com.obric.agent.trace.omni.a r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "queryId");
        d.h.b.o.e(r4, "snapshot");
        com.obric.agent.trace.h r2 = f(r3);
        if (r2 == null) goto L6;
        r2.a(r4);
        r2.a(r6);
        return;
    }

    public final void a(String r7, com.obric.agent.trace.i r8) {
        d.h.b.o.e(r7, "messageId");
        d.h.b.o.e(r8, "report");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r8, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(String r5, com.obric.agent.trace.i r6) {
        d.h.b.o.e(r5, "messageId");
        d.h.b.o.e(r6, "report");
        String r0 = ObricService.INSTANCE.getGson().toJson(a(r6));
        LinkedList<com.obric.agent.trace.i> r1 = f15715c;
        if (r1.size() < 50) goto L5;
        r1.removeFirst();
    L5:
        r1.add(r6);
        ((Map) ZeusTransformUtils.preCheckCast(f15716d, Map.class, "com.obric.aiagent.plugin")).put(r5, r6);
        d.h.b.o.a(r0);
        j(r0);
        h(r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.util.List] */
    public final List<com.obric.agent.trace.i> c() {
        d.h.b.z.f r0 = new d.h.b.z.f();
        r0.f38504a = d.a.p.b();
        kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);     // Catch: Exception -> L5
    L8:
        return (List) ZeusTransformUtils.preCheckCast(r0.f38504a, List.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        ILogDepend.Companion r2 = ILogDepend.Companion;
        StringBuilder r3 = new StringBuilder().append("getHistoryReports failed! ");
        e.printStackTrace();
        r2.e("IntentTracer", r3.append(d.x.f38692a).toString());
        goto L8
    }

    private final String a(List<com.obric.agent.trace.u> r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        Object r6 = r4.next();
        if (((com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r6, com.obric.agent.trace.u.class, "com.obric.aiagent.plugin")).a() != com.obric.agent.trace.o.t) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        com.obric.agent.trace.u r7 = (com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r6, com.obric.agent.trace.u.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L17;
        Map<String, Object> r8 = r7.c();
        if (r8 == null) goto L17;
        Object r9 = r8.get("result");
    L18:
        if (r9 != null) goto L20;
        return null;
    L20:
        return r9.toString();
    L17:
        r9 = null;
        goto L18
    L8:
        r2 = false;
        goto L9
    L11:
        r6 = null;
        goto L12
    }

    public final IntentDebugReport d(String r4) {
        d.h.b.o.e(r4, "messageId");
        return (IntentDebugReport) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), IntentDebugReport.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        ILogDepend.Companion r5 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("getLatestDebugExecution failed! ");
        e.printStackTrace();
        r5.e("IntentTracer", r1.append(d.x.f38692a).toString());
        return null;
    }

    public final void a(com.obric.agent.trace.s r8) {
        com.obric.agent.trace.s r7 = (com.obric.agent.trace.s) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.agent.trace.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(com.obric.agent.trace.s r8) {
        com.obric.agent.trace.s r7 = (com.obric.agent.trace.s) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.agent.trace.s.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "listener");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new ac(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(String r11, String r12, Map<String, String> r13, boolean r14) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, DbHelper.COL_ID);
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new z(r11, r3, r14, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void h(String r9) {
        int r8 = (r9.length() / 1024) + 1;
        int r1 = 0;
        int r2 = 1;
    L4:
        if (r1 >= r9.length()) goto L6;
        int r3 = r1 + 1024;
        int r4 = d.l.n.d(r3, r9.length());
        ISecureLogDepend.Companion r5 = ISecureLogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append("Intent execution report: ").append(r2).append('/').append(r8).append(' ');
        String r7 = r9.substring(r1, r4);
        d.h.b.o.c(r7, "substring(...)");
        r5.i("IntentTracer", r6.append(r7).toString());
        r2 = r2 + 1;
        r1 = r3;
        goto L4
    }

    private final Object a(com.obric.agent.trace.i r18) {
        List<com.obric.agent.trace.u> r0 = r18.g();
        if (r0 == null) goto L9;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        com.obric.agent.trace.u r5 = (com.obric.agent.trace.u) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.agent.trace.u.class, "com.obric.aiagent.plugin");
        r4.add(new com.obric.agent.trace.u(r5.a(), r5.b(), f15713a.a(com.obric.agent.trace.j.f15501a.a(r5.c()))));
        goto L6
    L8:
        List r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L10:
        com.obric.agent.trace.w r6 = r18.h();
        char r10 = 0;
        if (r6 == null) goto L21;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r6.d(), Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L14:
        if (r13.hasNext() == false) goto L20;
        com.obric.agent.trace.v r14 = (com.obric.agent.trace.v) ZeusTransformUtils.preCheckCast(r13.next(), com.obric.agent.trace.v.class, "com.obric.aiagent.plugin");
        d.m[] r15 = new d.m[5];
        r15[r10] = d.s.a("state_name", r14.a());
        q r7 = f15713a;
        Iterator r16 = r13;
        r15[1] = d.s.a("start_time", r7.a(r14.b()));
        Long r17 = r14.c();
        if (r17 == null) goto L18;
        String r19 = r7.a(((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).longValue());
    L19:
        r15[2] = d.s.a("end_time", r19);
        r15[3] = d.s.a("dm_event", r7.a(r14.d()));
        r15[4] = d.s.a("extra_state_info", r14.e());
        r12.add(ao.a(r15));
        r13 = r16;
        r10 = 0;
        goto L14
    L18:
        r19 = null;
        goto L19
    L20:
        Map r8 = ao.a(new d.m[]{d.s.a(KnowledgeActivity.KEY_TASK_ID, r6.a()), d.s.a("message_id", r6.b()), d.s.a("message_text_content", r6.c()), d.s.a("task_state_list", (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin")), d.s.a("omni_report", r6.e())});
    L23:
        return ao.b(new d.m[]{d.s.a(DownloadConstants.QUERY_KEY, r18.a()), d.s.a("rewrite_query", r18.b()), d.s.a("finish_time", r18.c()), d.s.a("result", r18.d()), d.s.a("total_cost", Long.valueOf(r18.e())), d.s.a("states", r18.f()), d.s.a("state_report", r3), d.s.a("task_state_report", r8), d.s.a("query_type", r18.i()), d.s.a("log_id", r18.j()), d.s.a("query_id", r18.k()), d.s.a("msg_id", r18.l()), d.s.a(KnowledgeActivity.KEY_TASK_TYPE, r18.m())});
    L21:
        r8 = null;
        goto L23
    L9:
        r3 = null;
        goto L10
    }

    private final Map<String, Object> a(Map<String, ? extends Object> r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Long r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        Map<String, Object> r8 = ao.e(r7);
        Object r3 = r8.get("endTime");
        if (ZeusTransformUtils.instanceOf(r3, Long.class) == false) goto L8;
        r0 = (Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.aiagent.plugin");
    L8:
        if (r0 == null) goto L10;
        r8.put("endTime", a(r0.longValue()));
    L10:
        return r8;
    }

    private final Map<String, Object> a(com.obric.agent.trace.e r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return ao.a(new d.m[]{d.s.a(DBHelper.COL_TIME, b(r5.a())), d.s.a("eventName", r5.b()), d.s.a("extra", r5.c())});
    }

    private final String a(long r3) {
        return b(k() + r3);
    }

    private final String b(long r2) {
        SimpleDateFormat r1 = i;
        monitor-enter(r1);
        String r3 = r1.format(new Date(r2));     // Catch: Throwable -> L8
        monitor-exit(r1);
        d.h.b.o.c(r3, "synchronized(...)");
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    private final void i(String r7) {
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void j(String r17) {
        File r0 = new File(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getFilesDir(), "intent_log.txt");
        if (r0.exists() == true) goto L5;
        r0.createNewFile();
    L5:
        List r4 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(d.f.k.b(r0, null, 1, null), Collection.class, "com.obric.aiagent.plugin"));
        if (r4.size() < 50) goto L8;
        d.f.k.a(r0, d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.b((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"), (r4.size() - 50) + 1), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, null, 58, null), null, 2, null);
    L8:
        d.f.k.b(r0, r17 + '\n', null, 2, null);
    }

    public final Object f(String r10, d.c.d<? super String> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.i r12 = new d.c.i(d.c.a.b.a(r9));
        d.c.d r1 = (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.b(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new l(r1, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        Object r13 = r12.a();
        if (r13 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r9);
    L5:
        return r13;
    }

    private final Object a(com.obric.agent.trace.i r4, boolean r5, d.c.d<? super IntentDebugReport> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new ai(r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    static /* synthetic */ Object a(q r1, com.obric.agent.trace.i r2, boolean r3, d.c.d r4, int r5, Object r6) {
        d.c.d<? super IntentDebugReport> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = true;
    L6:
        return r1.a(r2, r3, r7);
    }

    public final void a(String r7, boolean r8) {
        d.h.b.o.e(r7, DbHelper.COL_ID);
        ILogDepend.Companion.i("IntentTracer", "updateAppIntentState " + r7 + ", " + r8);
        if (r8 == false) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).put(r7, Long.valueOf(System.currentTimeMillis()));
        com.obric.agent.trace.c.f15437a.a(r7, ((long) h) * 1000);
        IFlowAppIntentIDL r9 = com.obric.aiagent.assistant.idl.r.a(d.h.b.aa.b(IFlowAppIntentIDL.class));
        if (r9 == null) goto L7;
        r9.setAppIntentActive(true);
    L7:
        ILogDepend.Companion.i("IntentTracer", "setAppIntentActive " + r7 + ", true");
    L13:
        if (f.isEmpty() == false) goto L19;
        IFlowAppIntentIDL r10 = com.obric.aiagent.assistant.idl.r.a(d.h.b.aa.b(IFlowAppIntentIDL.class));
        if (r10 == null) goto L17;
        r10.setAppIntentActive(false);
    L17:
        ILogDepend.Companion.i("IntentTracer", "setAppIntentActive " + r7 + ", false");
        return;
    L19:
        return;
    L8:
        a<String, Long> r11 = f;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r11.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        f15713a.a(r7, System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue());
    L11:
        r11.remove(r7);
        com.obric.agent.trace.c.f15437a.a(r7);
        goto L13
    }

    public final boolean d() {
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");
        long r6 = System.currentTimeMillis() - ((Number) ZeusTransformUtils.preCheckCast(r1.getValue(), Number.class, "com.obric.aiagent.plugin")).longValue();
        if (r6 <= (((long) h) * 1000)) goto L4;
        a(r3, r6);
        r0.remove();
        goto L4
    L9:
        return !((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).isEmpty();
    }

    private final void a(String r1, long r2) {
        com.obric.agent.trace.g.f15449a.a(r1, r2);
    }
}
