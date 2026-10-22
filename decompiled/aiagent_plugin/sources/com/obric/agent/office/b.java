package com.obric.agent.office;

import android.app.Application;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.agent.IAgentService;
import com.obric.agent.IAppIntentFeedback;
import com.obric.agent.IEntityManager;
import com.obric.agent.utils.r;
import com.obric.agent.utils.u;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.cae.libs.wifi.basicInfo.ChannelsEnvironment;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByAsrIntent;
import com.obric.capabilitykit.common.intent.BaseOfficeSearchLarkContactInfoByNameIntent;
import com.obric.capabilitykit.common.intent.OfficeBookMeetingParams;
import com.obric.capabilitykit.common.intent.OfficeSearchLarkContactInfoByAsrParams;
import com.obric.capabilitykit.common.intent.OfficeSearchLarkContactInfoByNameParams;
import com.obric.capabilitykit.common.intent.OfficeSearchMeetingParams;
import com.obric.capabilitykit.common.intent.OfficeSendMessageParams;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.obric.capabilitykit.entity.lark.LarkContactSearchResult;
import com.obric.capabilitykit.entity.lark.LarkContacts;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.a.q;
import d.h.b.aa;
import d.h.b.o;
import d.h.b.z;
import d.m;
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
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: OfficeIntentHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "OfficeIntentHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f15285a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f15286b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedHashMap<String, String> f15287c = null;

    /* JADX INFO: compiled from: OfficeIntentHandler.kt */
    public static final class a implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f15288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<String> f15289b;

        a(long r3, n<? super String> r5) {
            n<String> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
            this.f15288a = r3;
            this.f15289b = r6;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f15288a) goto L21;
            ILogDepend.Companion.d(b.TAG, "checkLarkTarget local action finished");
            boolean r11 = true;
            if (r8 == null) goto L11;
            List<IntentExecutionRecord> r2 = r8.getExecRecords();
            if (r2 == null) goto L11;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L11;
        L12:
            if (r11 == false) goto L17;
            ILogDepend.Companion.d(b.TAG, "checkLarkTarget: " + ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getRet());
            d.c.d r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f15289b, d.c.d.class, "com.obric.aiagent.plugin");
            String r13 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getDetails();
            if (r13 != null) goto L16;
            r13 = "";
        L16:
            d.n.a r14 = d.n.f38560a;
            r12.resumeWith(d.n.f(r13));
        L17:
            IAppIntentFeedback r15 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r15 == null) goto L21;
            r15.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        L11:
            r11 = false;
        L21:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.office.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OfficeIntentHandler.kt */
    @d.c.b.a.f(b = "OfficeIntentHandler.kt", c = {109, ChannelsEnvironment.BAND_5_GHZ_LAST_CH_NUM}, d = "handleOfficeIntent", e = "com.obric.agent.office.OfficeIntentHandler")
    static final class C0313b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f15293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f15294e;
        int f;

        C0313b(b r3, d.c.d<? super C0313b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f15294e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15293d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f15294e.a(null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeIntentHandler.kt */
    public static final class c extends LinkedHashMap<String, String> {
        c() {
            super(10, 0.75f, true);
        }

        public String a(String r1, String r2) {
            return (String) ZeusTransformUtils.preCheckCast(super.getOrDefault(r1, r2), String.class, "com.obric.aiagent.plugin");
        }

        public Collection<String> a() {
            return super.values();
        }

        public boolean a(String r1) {
            return super.containsValue(r1);
        }

        public int b() {
            return super.size();
        }

        public String b(String r2) {
            return (String) ZeusTransformUtils.preCheckCast(super.get(r2), String.class, "com.obric.aiagent.plugin");
        }

        public boolean b(String r1, String r2) {
            return super.remove(r1, r2);
        }

        public Set<Map.Entry<String, String>> c() {
            return super.entrySet();
        }

        public boolean c(String r1) {
            return super.containsKey(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return false;
        L7:
            return c((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsValue(Object r3) {
            if (r3 != null) goto L4;
            boolean r0 = true;
        L5:
            if (r0 == true) goto L9;
            return false;
        L9:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        L4:
            r0 = ZeusTransformUtils.instanceOf(r3, String.class);
            goto L5
        }

        public String d(String r2) {
            return (String) ZeusTransformUtils.preCheckCast(super.remove(r2), String.class, "com.obric.aiagent.plugin");
        }

        public Set<String> d() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Set<Map.Entry<String, String>> entrySet() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* synthetic */ Object get(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L7;
            return null;
        L7:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* synthetic */ Object getOrDefault(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L6;
            return r4;
        L6:
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
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
            return d((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }

        @Override // java.util.HashMap, java.util.Map
        public final boolean remove(Object r3, Object r4) {
            if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L5;
            return false;
        L5:
            if (r4 != null) goto L7;
            boolean r0 = true;
        L8:
            if (r0 == true) goto L11;
            return false;
        L11:
            return b((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
        L7:
            r0 = ZeusTransformUtils.instanceOf(r4, String.class);
            goto L8
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final int size() {
            return b();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final Collection<String> values() {
            return a();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, String> r3) {
            Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
            if (size() <= 10) goto L5;
            return true;
        L5:
            return false;
        }
    }

    /* JADX INFO: compiled from: OfficeIntentHandler.kt */
    @d.c.b.a.f(b = "OfficeIntentHandler.kt", c = {481}, d = "searchLarkContactInfoByAsr", e = "com.obric.agent.office.OfficeIntentHandler")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f15295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f15296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f15297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f15298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f15299e;
        final /* synthetic */ b f;
        int g;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f15299e = r3;
            this.g |= Integer.MIN_VALUE;
            return b.a(this.f, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OfficeIntentHandler.kt */
    public static final class e implements com.obric.agent.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f15300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<m<String, Integer>> f15301b;

        e(long r3, n<? super m<String, Integer>> r5) {
            n<m<String, Integer>> r6 = (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.aiagent.plugin");
            this.f15300a = r3;
            this.f15301b = r6;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f15300a) goto L21;
            ILogDepend.Companion.d(b.TAG, "searchLarkContactInfoByAsr");
            boolean r11 = true;
            if (r8 == null) goto L11;
            List<IntentExecutionRecord> r2 = r8.getExecRecords();
            if (r2 == null) goto L11;
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L11;
        L12:
            if (r11 == false) goto L17;
            int r12 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getRet();
            ILogDepend.Companion.d(b.TAG, "searchLarkContactInfoByAsr: " + r12);
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f15301b, d.c.d.class, "com.obric.aiagent.plugin");
            String r14 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r8.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getResult().getDetails();
            if (r14 != null) goto L16;
            r14 = "";
        L16:
            m r3 = new m(r14, d.c.b.a.b.a(r12));
            d.n.a r15 = d.n.f38560a;
            r13.resumeWith(d.n.f(r3));
        L17:
            IAppIntentFeedback r16 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L21;
            r16.removeActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(this, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
        L11:
            r11 = false;
        L21:
            return x.f38692a;
        }
    }

    /* JADX INFO: renamed from: lambda$JC4s89H-AM_8jOtNHq6i4sJjeQM, reason: not valid java name */
    public static /* synthetic */ x m99lambda$JC4s89HAM_8jOtNHq6i4sJjeQM(OfficeSendMessageParams r0, n r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$n6_s8KOY-P-9k_RiU7T1iYfx5gI, reason: not valid java name */
    public static /* synthetic */ x m100lambda$n6_s8KOYP9k_RiU7T1iYfx5gI(Uri r0, n r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Gson lambda$pGyejBRHkmAUOostx7t7herJHsg() {
        return b();
    }

    private b() {
    }

    public static final /* synthetic */ Object a(b r2, List r3, d.c.d r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f15285a = new b();
        f15286b = g.a($$Lambda$b$pGyejBRHkmAUOostx7t7herJHsg.INSTANCE);
        f15287c = (LinkedHashMap) ZeusTransformUtils.preCheckCast(new c(), LinkedHashMap.class, "com.obric.aiagent.plugin");
    }

    private final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f15286b.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson b() {
        return new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(Uri.class, Type.class, "com.obric.aiagent.plugin"), new UriTypeAdapter()).create();
    }

    public final boolean a(String r5) {
        if (r5 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L13;
        if (o.a(r5, com.obric.agent.d.f14409a.h()) == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (d.o.o.b(r5, "Office_", false, 2, null) != true) goto L7;
        r1 = true;
        goto L8
    }

    public final Object a(IntentAppAction r32, String r33, q<? super IntentAppAction, ? super String, ? super String, x> r34, d.c.d<? super Boolean> r35) {
        q r4 = (q) ZeusTransformUtils.wrapperContextForParams(r34, q.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r35, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, C0313b.class) == false) goto L7;
        C0313b r7 = (C0313b) ZeusTransformUtils.preCheckCast(r6, C0313b.class, "com.obric.aiagent.plugin");
        if ((r7.f & Integer.MIN_VALUE) == 0) goto L7;
        r7.f -= Integer.MIN_VALUE;
    L8:
        Object r8 = r7.f15293d;
        Object r9 = d.c.a.b.a();
        int r10 = r7.f;
        if (r10 == 0) goto L16;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L14;
        d.o.a(r8);
    L55:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L104;
        return d.c.b.a.b.a(true);
    L104:
        return d.c.b.a.b.a(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r4 = (q) ZeusTransformUtils.preCheckCast(r7.f15292c, q.class, "com.obric.aiagent.plugin");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.f15291b, String.class, "com.obric.aiagent.plugin");
        IntentAppAction r1 = (IntentAppAction) ZeusTransformUtils.preCheckCast(r7.f15290a, IntentAppAction.class, "com.obric.aiagent.plugin");
        d.o.a(r8);
        IntentAppAction r16 = r1;
    L72:
        m r2 = (m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin");
        IntentAppAction r11 = IntentAppAction.copy$default(r16, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(((Number) ZeusTransformUtils.preCheckCast(r2.d(), Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r2.c(), String.class, "com.obric.aiagent.plugin"), null, 0, null, null, 60, null)), null, 0, 0, null, 247, null);
        r4.invoke(r11, r0, null);
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, r11, false, false, false, 12, null);
        return d.c.b.a.b.a(true);
    L16:
        d.o.a(r8);
        ILogDepend.Companion.d(TAG, "intentName = " + r33);
        IEntityManager r12 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L21;
        String r13 = r12.replaceECAIdToEntity(r32.getContent(), r32.getQuestionId());
        if (r13 == null) goto L21;
    L22:
        r32.setContent(r13);
        switch(r33.hashCode()) {
            case 38146083: goto L92;
            case 186993456: goto L85;
            case 1389009003: goto L77;
            case 1639397908: goto L60;
            case 1641252444: goto L33;
            case 1948911119: goto L26;
            default: goto L104;
        };
    L26:
        if (r33.equals("Office_BookMeeting") == false) goto L104;
        String r18 = a(a(r32), r33);
        if (r18 == null) goto L31;
        u r17 = u.f16076a;
        Gson r3 = f15285a.a();
        o.c(r3, "<get-gson>(...)");
        OfficeBookMeetingParams r5 = (OfficeBookMeetingParams) ZeusTransformUtils.preCheckCast(r17.a(r3, r18, OfficeBookMeetingParams.class, new OfficeBookMeetingParams(null, null, null, null, null, null, d.c.b.a.b.a(1), 63, null), "dispatchIMAction_Office_BookMeeting"), OfficeBookMeetingParams.class, "com.obric.aiagent.plugin");
        r5.setVersion(d.c.b.a.b.a(1));
        r32.setContent(com.obric.agent.utils.b.f15994a.a("Office_BookMeeting", com.obric.agent.utils.b.f15994a.a(r5), null));
        goto L104
    L31:
        b r14 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        r32.setContent(com.obric.agent.utils.b.f15994a.a("Office_BookMeeting", com.obric.agent.utils.b.f15994a.a(new OfficeBookMeetingParams(null, null, null, null, null, null, d.c.b.a.b.a(1), 63, null)), null));
        goto L104
    L33:
        if (r33.equals("Office_SendMessage") == false) goto L104;
        String r19 = a(a(r32), r33);
        if (r19 == null) goto L39;
        u r110 = u.f16076a;
        Gson r15 = f15285a.a();
        o.c(r15, "<get-gson>(...)");
        OfficeSendMessageParams r20 = (OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r110.a(r15, r19, OfficeSendMessageParams.class, new OfficeSendMessageParams(null, null, null, null, d.c.b.a.b.a(1), 15, null), "dispatchIMAction_Office_SendMessage"), OfficeSendMessageParams.class, "com.obric.aiagent.plugin");
        if (r20 == null) goto L39;
    L40:
        r20.setVersion(d.c.b.a.b.a(1));
        CharSequence r21 = (CharSequence) ZeusTransformUtils.preCheckCast(r20.getTargetType(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r21 != null) goto L43;
    L46:
        boolean r22 = true;
    L47:
        if (r22 == false) goto L49;
        r20.setTargetType("PEOPLE");
    L49:
        r32.setContent(com.obric.agent.utils.b.f15994a.a("Office_SendMessage", com.obric.agent.utils.b.f15994a.a(r20), null));
        if (com.obric.agent.office.a.f15240a.b(r33, r32) == false) goto L104;
        com.obric.agent.office.a r23 = com.obric.agent.office.a.f15240a;
        r7.f = 2;
        r8 = r23.a(r32, r20, r7);
        if (r8 != r9) goto L55;
        return r9;
    L43:
        if (r21.length() == 0) goto L46;
        r22 = false;
    L39:
        r20 = new OfficeSendMessageParams(null, null, null, null, d.c.b.a.b.a(1), 15, null);
        goto L40
    L60:
        if (r33.equals("Office_SearchLarkContactInfoByAsr") == false) goto L104;
        IAgentService r24 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r24 == null) goto L65;
        List<? extends Uri> r25 = r24.getAudioFileForQuery(String.valueOf(r32.getQuestionId()));
    L66:
        ILogDepend.Companion.d(TAG, "audioFile = " + r25);
        if (r25 == null) goto L74;
        r7.f15290a = r32;
        r7.f15291b = r33;
        r7.f15292c = r4;
        r7.f = 1;
        r8 = a(r25, r7);
        if (r8 != r9) goto L71;
        return r9;
    L71:
        r16 = r32;
        r0 = r33;
        goto L72
    L74:
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r32, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(1, "Audio file is null", null, 0, null, null, 60, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return d.c.b.a.b.a(true);
    L65:
        r25 = null;
        goto L66
    L77:
        if (r33.equals("Office_KnowledgeAIAuth") == false) goto L104;
        IFlowSettingsIDL r26 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r26 == null) goto L82;
        r26.setLarkKnowledgeAuthorizationEnabled(true);
    L82:
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r32, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(0, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return d.c.b.a.b.a(true);
    L85:
        if (r33.equals("Office_SearchMeeting") == false) goto L104;
        String r111 = a(a(r32), r33);
        if (r111 == null) goto L90;
        u r112 = u.f16076a;
        Gson r27 = f15285a.a();
        o.c(r27, "<get-gson>(...)");
        OfficeSearchMeetingParams r28 = (OfficeSearchMeetingParams) ZeusTransformUtils.preCheckCast(r112.a(r27, r111, OfficeSearchMeetingParams.class, new OfficeSearchMeetingParams(null, null, null, null, null, null, null, d.c.b.a.b.a(1), 127, null), "dispatchIMAction_Office_SearchMeeting"), OfficeSearchMeetingParams.class, "com.obric.aiagent.plugin");
        r28.setVersion(d.c.b.a.b.a(1));
        r32.setContent(com.obric.agent.utils.b.f15994a.a("Office_SearchMeeting", com.obric.agent.utils.b.f15994a.a(r28), null));
        goto L104
    L90:
        b r29 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        r32.setContent(com.obric.agent.utils.b.f15994a.a("Office_SearchMeeting", com.obric.agent.utils.b.f15994a.a(new OfficeSearchMeetingParams(null, null, null, null, null, null, null, d.c.b.a.b.a(1), 127, null)), null));
        goto L104
    L92:
        if (r33.equals("Office_KnowledgeAI") == false) goto L104;
        IFlowSettingsIDL r30 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r30 != null) goto L97;
    L99:
        boolean r31 = false;
    L100:
        if (r31 == true) goto L104;
        com.obric.agent.network.a.a(com.obric.agent.network.a.f15206a, IntentAppAction.copy$default(r32, 0, 0, 0, new Gson().toJson(new com.obric.agent.b.a(ErrorCode.Office.KNOWLEDGE_NOT_AUTHORIZE, null, null, 0, null, null, 62, null)), null, 0, 0, null, 247, null), false, false, false, 12, null);
        return d.c.b.a.b.a(true);
    L97:
        if (r30.isLarkKnowledgeAuthorizationEnable() != true) goto L99;
        r31 = true;
    L21:
        r13 = r32.getContent();
    L7:
        r7 = new C0313b(this, r6);
        goto L8
    }

    private final String a(IntentAppAction r6) {
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L11
        b r3 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        JsonElement r7 = JsonParser.parseString(r6.getContent());     // Catch: Throwable -> L11
        if (r7.isJsonObject() == false) goto L8;
        JsonElement r8 = r7.getAsJsonObject().get("Content");     // Catch: Throwable -> L11
        if (r8 == null) goto L8;
        String r9 = r8.getAsString();     // Catch: Throwable -> L11
    L9:
        Object r10 = d.n.f(r9);     // Catch: Throwable -> L11
    L13:
        Throwable r4 = d.n.c(r10);
        if (r4 == null) goto L17;
        ILogDepend.Companion.e(TAG, "destructInputParams: invalid request.content", r4);
        r10 = null;
    L17:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        u r5 = u.f16076a;
        Gson r12 = a();
        o.c(r12, "<get-gson>(...)");
        com.obric.agent.dm.e r13 = (com.obric.agent.dm.e) ZeusTransformUtils.preCheckCast(r5.a(r12, r11, com.obric.agent.dm.e.class, "destructInputParams"), com.obric.agent.dm.e.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L26;
        List<com.obric.agent.dm.f> r14 = r13.a();
        if (r14 == null) goto L26;
        com.obric.agent.dm.f r15 = (com.obric.agent.dm.f) ZeusTransformUtils.preCheckCast(p.l(r14), com.obric.agent.dm.f.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L26;
        List<com.obric.agent.dm.b> r16 = r15.a();
        if (r16 == null) goto L26;
        com.obric.agent.dm.b r17 = (com.obric.agent.dm.b) ZeusTransformUtils.preCheckCast(p.n(r16), com.obric.agent.dm.b.class, "com.obric.aiagent.plugin");
    L27:
        if (r17 == null) goto L31;
        JsonObject r18 = r17.c();
        if (r18 == null) goto L31;
        JsonObject r19 = r18.getAsJsonObject();
    L32:
        if (r19 == null) goto L52;
        JsonObject r20 = r19.deepCopy();
        Iterator<String> r1 = r19.keySet().iterator();
    L35:
        if (r1.hasNext() == false) goto L42;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        JsonElement r22 = r19.get(r21);
        if (r22.isJsonObject() == false) goto L35;
        JsonElement r23 = r22.getAsJsonObject().get("value");
        if (r23 == null) goto L35;
        r20.add(r21, r23);
        goto L35
    L42:
        return r20.toString();
    L52:
        return null;
    L31:
        r19 = null;
    L26:
        r17 = null;
    L8:
        r9 = null;
    L11:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r10 = d.n.f(d.o.a(th));
        goto L13
    }

    private final String a(String r13, String r14) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L64;
        return r13;
    L64:
        JsonObject r5 = JsonParser.parseString(r13).getAsJsonObject();     // Catch: Exception -> L61
        int r6 = r14.hashCode();     // Catch: Exception -> L61
        JsonElement r9 = null;
        if (r6 == 186993456) goto L38;
        if (r6 == 1641252444) goto L23;
        if (r6 == 1948911119) goto L20;
    L59:
        return r5.toString();
    L20:
        if (r14.equals("Office_BookMeeting") == false) goto L59;
    L40:
        JsonElement r12 = r5.get("participants");     // Catch: Exception -> L61
        if (r12 == null) goto L59;
        if (r12.isJsonArray() == false) goto L45;
        r9 = r12;
    L45:
        if (r9 == null) goto L59;
        JsonArray r15 = r9.getAsJsonArray();     // Catch: Exception -> L61
        if (r15 == null) goto L59;
        JsonArray r16 = new JsonArray();     // Catch: Exception -> L61
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L61
    L50:
        if (r17.hasNext() == false) goto L58;
        String r7 = ((JsonElement) ZeusTransformUtils.preCheckCast(r17.next(), JsonElement.class, "com.obric.aiagent.plugin")).getAsString();     // Catch: Exception -> L61
        r r8 = r.f16062a;     // Catch: Exception -> L61
        o.a(r7);     // Catch: Exception -> L61
        String r10 = r8.a(r7);     // Catch: Exception -> L61
        ISecureLogDepend.Companion.i(TAG, "convertLarkPinyin participant: " + r7 + " -> " + r10);     // Catch: Exception -> L61
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L54;
        boolean r11 = true;
    L55:
        if (r11 == false) goto L57;
        r7 = r10;
    L57:
        r16.add(r7);     // Catch: Exception -> L61
        goto L50
    L54:
        r11 = false;
        goto L55
    L58:
        r5.add("participants", (JsonElement) ZeusTransformUtils.preCheckCast(r16, JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L61
        goto L59
    L23:
        if (r14.equals("Office_SendMessage") == false) goto L59;
        JsonElement r18 = r5.get("target");     // Catch: Exception -> L61
        if (r18 == null) goto L59;
        if (r18.isJsonPrimitive() == false) goto L29;
        r9 = r18;
    L29:
        if (r9 == null) goto L59;
        String r19 = r9.getAsString();     // Catch: Exception -> L61
        if (r19 == null) goto L59;
        String r0 = r.f16062a.a(r19);     // Catch: Exception -> L61
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L35;
        r4 = true;
    L35:
        if (r4 == false) goto L59;
        ISecureLogDepend.Companion.i(TAG, "convertLarkPinyin target: " + r19 + " -> " + r0);     // Catch: Exception -> L61
        r5.addProperty("target", r0);     // Catch: Exception -> L61
        goto L59
    L38:
        if (r14.equals("Office_SearchMeeting") == true) goto L40;
    L61:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "convertLarkPersonNamesToPinyin error: " + e.getMessage());
        return r13;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final Object a(final OfficeSendMessageParams r7, d.c.d<? super String> r8) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.agent.utils.b.f15994a.a(20000, "", new $$Lambda$b$JC4s89HAM_8jOtNHq6i4sJjeQM(r7), r5);
    }

    private static final x a(OfficeSendMessageParams r10, n r11) {
        n r12 = (n) ZeusTransformUtils.wrapperContextForParams(r11, n.class, "com.obric.aiagent.plugin");
        o.e(r12, "continuation");
        long r8 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        com.obric.agent.utils.b r0 = com.obric.agent.utils.b.f15994a;
        String r2 = r10.getTarget();
        if (r2 == null) goto L5;
        String[] r3 = {r2};
    L6:
        com.obric.agent.utils.b.f15994a.a(new BaseOfficeSearchLarkContactInfoByNameIntent().getName(), r0.a(new OfficeSearchLarkContactInfoByNameParams(r3, r10.getTargetType())), null, r8);
        a r13 = new a(r8, r12);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L10;
        r14.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r13, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
    L10:
        return x.f38692a;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [T, com.obric.capabilitykit.entity.lark.LarkContactSearchResult] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0118 -> B:12:0x007a). Please report as a decompilation issue!!! */
    private final Object a(List<? extends Uri> r18, d.c.d<? super m<String, Integer>> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, d.class) == false) goto L7;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2, d.class, "com.obric.aiagent.plugin");
        if ((r3.g & Integer.MIN_VALUE) == 0) goto L7;
        r3.g -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.f15299e;
        Object r5 = d.c.a.b.a();
        int r6 = r3.g;
        if (r6 == 0) goto L15;
        if (r6 != 1) goto L14;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r3.f15298d, Iterator.class, "com.obric.aiagent.plugin");
        z.d r7 = (z.d) ZeusTransformUtils.preCheckCast(r3.f15297c, z.d.class, "com.obric.aiagent.plugin");
        z.f r8 = (z.f) ZeusTransformUtils.preCheckCast(r3.f15296b, z.f.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.preCheckCast(r3.f15295a, List.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        List r15 = r9;
        z.d r10 = r7;
        Object r11 = r5;
        d r12 = r3;
        z.f r13 = r8;
        Object r14 = r4;
    L12:
        Iterator r16 = r1;
        m r17 = (m) ZeusTransformUtils.preCheckCast(r14, m.class, "com.obric.aiagent.plugin");
        r10.f38502a = ((Number) ZeusTransformUtils.preCheckCast(r17.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r10.f38502a != 0) goto L25;
        LarkContactSearchResult r110 = (LarkContactSearchResult) ZeusTransformUtils.preCheckCast(EntityExtKt.a().fromJson((String) ZeusTransformUtils.preCheckCast(r17.a(), String.class, "com.obric.aiagent.plugin"), LarkContactSearchResult.class), LarkContactSearchResult.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34
        List<LarkContacts> r20 = r110.getLarkContactsResults();     // Catch: Exception -> L34
        if (r20 == null) goto L29;
        d.c.b.a.b.a(r15.addAll((Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L34
    L29:
        List r21 = r15;
        r13.f38504a = LarkContactSearchResult.copy$default(r110, null, null, r15, null, 11, null);     // Catch: Exception -> L32
    L37:
        r1 = r16;
        z.f r22 = r13;
        r3 = r12;
        r5 = r11;
        List r111 = r21;
        z.d r23 = r10;
    L17:
        if (r1.hasNext() == false) goto L38;
        final Uri r24 = (Uri) ZeusTransformUtils.preCheckCast(r1.next(), Uri.class, "com.obric.aiagent.plugin");
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).grantUriPermission("com.ss.android.lark", r24, 1);
        ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).grantUriPermission("com.ss.android.lark.debug", r24, 1);
        com.obric.agent.utils.b r25 = com.obric.agent.utils.b.f15994a;
        m r112 = new m("", d.c.b.a.b.a(1));
        d.h.a.b r113 = new $$Lambda$b$n6_s8KOYP9k_RiU7T1iYfx5gI(r24);
        r3.f15295a = r111;
        r3.f15296b = r22;
        r3.f15297c = r23;
        r3.f15298d = r1;
        r3.g = 1;
        r14 = r25.a(20000, r112, r113, r3);
        if (r14 != r5) goto L21;
        return r5;
    L21:
        r10 = r23;
        r15 = r111;
        r11 = r5;
        r12 = r3;
        r13 = r22;
        goto L12
    L38:
        ILogDepend.Companion.d(TAG, "searchLarkContactInfoByAsr lastErrorCode=" + r23.f38502a);
        return new m(EntityExtKt.a().toJson(r22.f38504a), d.c.b.a.b.a(r23.f38502a));
    L32:
        e = e;
    L36:
        ILogDepend.Companion.e(TAG, "parse LarkContactSearchResult failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r10.f38502a = 1;
    L34:
        e = e;
        r21 = r15;
        goto L36
    L25:
        return new m(r17.a(), d.c.b.a.b.a(r10.f38502a));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r4);
        List r26 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        z.f r27 = new z.f();
        z.d r28 = new z.d();
        r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        r111 = r26;
        r22 = r27;
        r23 = r28;
    L7:
        r3 = new d(this, r2);
        goto L8
    }

    private static final x a(Uri r10, n r11) {
        n r12 = (n) ZeusTransformUtils.wrapperContextForParams(r11, n.class, "com.obric.aiagent.plugin");
        o.e(r12, "continuation");
        long r8 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        com.obric.agent.utils.b.f15994a.a(new BaseOfficeSearchLarkContactInfoByAsrIntent().getName(), com.obric.agent.utils.b.f15994a.a(new OfficeSearchLarkContactInfoByAsrParams(new String[]{r10.toString()})), null, r8);
        e r13 = new e(r8, r12);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L6;
        r14.addLocalActionFinishedListener((com.obric.agent.f) ZeusTransformUtils.preCheckCast(r13, com.obric.agent.f.class, "com.obric.aiagent.plugin"));
    L6:
        return x.f38692a;
    }
}
