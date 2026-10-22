package com.obric.agent;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.ClockDeleteAlarmParams;
import com.obric.capabilitykit.common.intent.ContactsDeleteParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MemoryDeleteParams;
import com.obric.capabilitykit.common.intent.MessagesDeleteParams;
import com.obric.capabilitykit.common.intent.PhoneDeleteParams;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: EntityDeleteHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EntityDeleteHandler {
    private static final String TAG = "EntityDeleteHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EntityDeleteHandler f14177a = null;

    /* JADX INFO: compiled from: EntityDeleteHandler.kt */
    public static final class RecordingDeleteParams {
        private final boolean deleteAll;
        private final RecordingEntity[] targets;

        public static /* synthetic */ RecordingDeleteParams copy$default(RecordingDeleteParams r0, RecordingEntity[] r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.targets;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.deleteAll;
        L9:
            return r0.copy(r1, r2);
        }

        public final RecordingEntity[] component1() {
            return this.targets;
        }

        public final boolean component2() {
            return this.deleteAll;
        }

        public final RecordingDeleteParams copy(RecordingEntity[] r1, boolean r2) {
            d.h.b.o.e(r1, "targets");
            return new RecordingDeleteParams(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, RecordingDeleteParams.class) == true) goto L8;
            return false;
        L8:
            RecordingDeleteParams r6 = (RecordingDeleteParams) ZeusTransformUtils.preCheckCast(r5, RecordingDeleteParams.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.targets, r6.targets) == true) goto L12;
            return false;
        L12:
            if (this.deleteAll == r6.deleteAll) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.targets) * 31) + Boolean.hashCode(this.deleteAll);
        }

        public String toString() {
            return "RecordingDeleteParams(targets=" + Arrays.toString(this.targets) + ", deleteAll=" + this.deleteAll + ')';
        }

        public RecordingDeleteParams(RecordingEntity[] r2, boolean r3) {
            d.h.b.o.e(r2, "targets");
            this.targets = r2;
            this.deleteAll = r3;
        }

        public final RecordingEntity[] getTargets() {
            return this.targets;
        }

        public final boolean getDeleteAll() {
            return this.deleteAll;
        }
    }

    /* JADX INFO: compiled from: EntityDeleteHandler.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppEntity[] f14179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f14180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f14181d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f14178a, r6.f14178a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f14179b, r6.f14179b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f14180c, r6.f14180c) == true) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f14181d, r6.f14181d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f14178a.hashCode() * 31) + Arrays.hashCode(this.f14179b)) * 31) + this.f14180c.hashCode()) * 31;
            String r2 = this.f14181d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "DeleteRequest(intentName=" + this.f14178a + ", entities=" + Arrays.toString(this.f14179b) + ", params=" + this.f14180c + ", packageName=" + this.f14181d + ')';
        }

        public a(String r2, AppEntity[] r3, Object r4, String r5) {
            d.h.b.o.e(r2, "intentName");
            d.h.b.o.e(r3, "entities");
            d.h.b.o.e(r4, "params");
            this.f14178a = r2;
            this.f14179b = r3;
            this.f14180c = r4;
            this.f14181d = r5;
        }

        public /* synthetic */ a(String r1, AppEntity[] r2, Object r3, String r4, int r5, d.h.b.h r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = null;
        L5:
            this(r1, r2, r3, r4);
        }

        public final String a() {
            return this.f14178a;
        }

        public final AppEntity[] b() {
            return this.f14179b;
        }

        public final Object c() {
            return this.f14180c;
        }

        public final String d() {
            return this.f14181d;
        }
    }

    /* JADX INFO: compiled from: EntityDeleteHandler.kt */
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap<Long, a> f14182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f14183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f14184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap.KeySetView<String, Boolean> f14185d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ConcurrentHashMap<String, AppEntity> f14186e;
        final /* synthetic */ AtomicBoolean f;
        final /* synthetic */ IAppIntentFeedback g;
        final /* synthetic */ d.h.b.z.f<f> h;
        final /* synthetic */ IEntityDeleteCallbackIDL i;

        b(ConcurrentHashMap<Long, a> r3, AtomicBoolean r4, AtomicInteger r5, ConcurrentHashMap.KeySetView<String, Boolean> r6, ConcurrentHashMap<String, AppEntity> r7, AtomicBoolean r8, IAppIntentFeedback r9, d.h.b.z.f<f> r10, IEntityDeleteCallbackIDL r11) {
            IAppIntentFeedback r12 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r9, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            IEntityDeleteCallbackIDL r13 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r11, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
            this.f14182a = r3;
            this.f14183b = r4;
            this.f14184c = r5;
            this.f14185d = r6;
            this.f14186e = r7;
            this.f = r8;
            this.g = r12;
            this.h = r10;
            this.i = r13;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r12, JobResult r13, d.c.d<? super d.x> r14) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            a r16 = (a) ZeusTransformUtils.preCheckCast(this.f14182a.remove(d.c.b.a.b.a(r12.getQuestionId())), a.class, "com.obric.aiagent.plugin");
            if (r16 == null) goto L5;
            IntentExecutionRecord r17 = null;
            if (r13 == null) goto L20;
            List<IntentExecutionRecord> r0 = r13.getExecRecords();
            if (r0 == null) goto L20;
            Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r1.hasNext() == false) goto L16;
            Object r2 = r1.next();
            if (d.h.b.o.a(((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r2, IntentExecutionRecord.class, "com.obric.aiagent.plugin")).getIntentName(), r16.a()) == false) goto L12;
        L17:
            IntentExecutionRecord r3 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r2, IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L20;
            r17 = r3;
        L25:
            if (r17 == null) goto L29;
            IntentResult<?> r18 = r17.getResult();
            if (r18 == null) goto L29;
            int r19 = r18.getRet();
        L30:
            if (r19 != 0) goto L34;
            AppEntity[] r110 = r16.b();
            ConcurrentHashMap.KeySetView<String, Boolean> r111 = this.f14185d;
            ConcurrentHashMap<String, AppEntity> r112 = this.f14186e;
            int r4 = 0;
            int r5 = r110.length;
        L32:
            if (r4 >= r5) goto L35;
            AppEntity r6 = r110[r4];
            r111.add(EntityDeleteHandler.a(EntityDeleteHandler.f14177a, r6));
            r112.putIfAbsent(EntityDeleteHandler.b(EntityDeleteHandler.f14177a, r6), r6);
            r4 = r4 + 1;
        L35:
            this.f14184c.decrementAndGet();
            EntityDeleteHandler.a(this.f14184c, this.f, this.g, this.h, this.f14185d, this.f14183b, this.f14186e, this.i, false, 256, null);
            return d.x.f38692a;
        L34:
            this.f14183b.set(true);
        L29:
            r19 = 1;
            goto L30
        L16:
            r2 = null;
        L20:
            if (r13 == null) goto L25;
            List<IntentExecutionRecord> r113 = r13.getExecRecords();
            if (r113 == null) goto L25;
            r17 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.l(r113), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            goto L25
        L5:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: EntityDeleteHandler.kt */
    @d.c.b.a.f(b = "EntityDeleteHandler.kt", c = {230}, d = "invokeSuspend", e = "com.obric.agent.EntityDeleteHandler$execute$3")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f14188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f14189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f14190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ IAppIntentFeedback f14191e;
        final /* synthetic */ d.h.b.z.f<f> f;
        final /* synthetic */ ConcurrentHashMap.KeySetView<String, Boolean> g;
        final /* synthetic */ ConcurrentHashMap<String, AppEntity> h;
        final /* synthetic */ IEntityDeleteCallbackIDL i;

        c(AtomicBoolean r3, AtomicInteger r4, AtomicBoolean r5, IAppIntentFeedback r6, d.h.b.z.f<f> r7, ConcurrentHashMap.KeySetView<String, Boolean> r8, ConcurrentHashMap<String, AppEntity> r9, IEntityDeleteCallbackIDL r10, d.c.d<? super c> r11) {
            IAppIntentFeedback r12 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r6, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            IEntityDeleteCallbackIDL r13 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r10, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14188b = r3;
            this.f14189c = r4;
            this.f14190d = r5;
            this.f14191e = r12;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r13;
            super(2, r14);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14188b, this.f14189c, this.f14190d, this.f14191e, this.f, this.g, this.h, this.i, r10), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14187a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r13);
        L11:
            this.f14188b.set(true);
            EntityDeleteHandler.a(this.f14189c, this.f14190d, this.f14191e, this.f, this.g, this.f14188b, this.h, this.i, true);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r13);
            d.c.d r14 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14187a = 1;
            if (ax.a(12000, r14) != r0) goto L11;
            return r0;
        }
    }

    static {
        f14177a = new EntityDeleteHandler();
    }

    private EntityDeleteHandler() {
    }

    public static final /* synthetic */ String a(EntityDeleteHandler r0, AppEntity r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ void a(AtomicInteger r11, AtomicBoolean r12, IAppIntentFeedback r13, d.h.b.z.f r14, ConcurrentHashMap.KeySetView r15, AtomicBoolean r16, ConcurrentHashMap r17, IEntityDeleteCallbackIDL r18, boolean r19) {
        b(r11, r12, (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r13, IAppIntentFeedback.class, "com.obric.aiagent.plugin"), r14, r15, r16, r17, (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r18, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin"), r19);
    }

    public static final /* synthetic */ String b(EntityDeleteHandler r0, AppEntity r1) {
        return r0.b(r1);
    }

    public final List<a> a(AppEntity[] r15) {
        d.h.b.o.e(r15, "entities");
        boolean r1 = true;
        if (r15.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        int r2 = r15.length;
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L15;
        if (ZeusTransformUtils.instanceOf(r15[r4], AlarmEntity.class) == false) goto L13;
        r4 = r4 + 1;
        goto L10
    L13:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L22;
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r5 = r15.length;
        int r6 = 0;
    L19:
        if (r6 >= r5) goto L101;
        AppEntity r7 = r15[r6];
        d.h.b.o.a(r7, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
        AlarmEntity r8 = (AlarmEntity) ZeusTransformUtils.preCheckCast(r7, AlarmEntity.class, "com.obric.aiagent.plugin");
        r14.add(new a("Clock_DeleteAlarm", (AppEntity[]) ZeusTransformUtils.preCheckCast(new AlarmEntity[]{r8}, AppEntity[].class, "com.obric.aiagent.plugin"), new ClockDeleteAlarmParams(r8, false), null, 8, null));
        r6 = r6 + 1;
        goto L19
    L101:
        return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
    L22:
        int r9 = r15.length;
        int r10 = 0;
    L23:
        if (r10 >= r9) goto L28;
        if (ZeusTransformUtils.instanceOf(r15[r10], ContactEntity.class) == false) goto L26;
        r10 = r10 + 1;
        goto L23
    L26:
        boolean r11 = false;
    L30:
        if (r11 == false) goto L35;
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r13 = r15.length;
        int r16 = 0;
    L32:
        if (r16 >= r13) goto L34;
        AppEntity r17 = r15[r16];
        d.h.b.o.a(r17, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        r12.add((ContactEntity) ZeusTransformUtils.preCheckCast(r17, ContactEntity.class, "com.obric.aiagent.plugin"));
        r16 = r16 + 1;
        goto L32
    L34:
        ContactEntity[] r18 = (ContactEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new ContactEntity[0]), ContactEntity[].class, "com.obric.aiagent.plugin");
        return d.a.p.a(new a("Contacts_Delete", (AppEntity[]) ZeusTransformUtils.preCheckCast(r18, AppEntity[].class, "com.obric.aiagent.plugin"), new ContactsDeleteParams(r18), a((AppEntity[]) ZeusTransformUtils.preCheckCast(r18, AppEntity[].class, "com.obric.aiagent.plugin"), "com.android.contacts")));
    L35:
        int r19 = r15.length;
        int r20 = 0;
    L36:
        if (r20 >= r19) goto L41;
        if (ZeusTransformUtils.instanceOf(r15[r20], CallHistoryEntity.class) == false) goto L39;
        r20 = r20 + 1;
        goto L36
    L39:
        boolean r21 = false;
    L42:
        if (r21 == false) goto L47;
        Collection r22 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r23 = r15.length;
        int r24 = 0;
    L44:
        if (r24 >= r23) goto L46;
        AppEntity r25 = r15[r24];
        d.h.b.o.a(r25, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CallHistoryEntity");
        r22.add((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r25, CallHistoryEntity.class, "com.obric.aiagent.plugin"));
        r24 = r24 + 1;
        goto L44
    L46:
        CallHistoryEntity[] r110 = (CallHistoryEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r22, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new CallHistoryEntity[0]), CallHistoryEntity[].class, "com.obric.aiagent.plugin");
        return d.a.p.a(new a("Phone_Delete", (AppEntity[]) ZeusTransformUtils.preCheckCast(r110, AppEntity[].class, "com.obric.aiagent.plugin"), new PhoneDeleteParams(r110), a((AppEntity[]) ZeusTransformUtils.preCheckCast(r110, AppEntity[].class, "com.obric.aiagent.plugin"), "com.android.contacts")));
    L47:
        int r26 = r15.length;
        int r27 = 0;
    L48:
        if (r27 >= r26) goto L53;
        if (ZeusTransformUtils.instanceOf(r15[r27], MessageEntity.class) == false) goto L51;
        r27 = r27 + 1;
        goto L48
    L51:
        boolean r28 = false;
    L54:
        if (r28 == false) goto L59;
        Collection r29 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r30 = r15.length;
        int r31 = 0;
    L56:
        if (r31 >= r30) goto L58;
        AppEntity r32 = r15[r31];
        d.h.b.o.a(r32, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MessageEntity");
        r29.add((MessageEntity) ZeusTransformUtils.preCheckCast(r32, MessageEntity.class, "com.obric.aiagent.plugin"));
        r31 = r31 + 1;
        goto L56
    L58:
        MessageEntity[] r111 = (MessageEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r29, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new MessageEntity[0]), MessageEntity[].class, "com.obric.aiagent.plugin");
        return d.a.p.a(new a("Messages_Delete", (AppEntity[]) ZeusTransformUtils.preCheckCast(r111, AppEntity[].class, "com.obric.aiagent.plugin"), new MessagesDeleteParams(r111), a((AppEntity[]) ZeusTransformUtils.preCheckCast(r111, AppEntity[].class, "com.obric.aiagent.plugin"), "com.android.mms")));
    L59:
        int r33 = r15.length;
        int r34 = 0;
    L60:
        if (r34 >= r33) goto L65;
        if (ZeusTransformUtils.instanceOf(r15[r34], RecordingEntity.class) == false) goto L63;
        r34 = r34 + 1;
        goto L60
    L63:
        boolean r35 = false;
    L66:
        if (r35 == false) goto L71;
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r37 = r15.length;
        int r38 = 0;
    L68:
        if (r38 >= r37) goto L70;
        AppEntity r39 = r15[r38];
        d.h.b.o.a(r39, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
        r36.add((RecordingEntity) ZeusTransformUtils.preCheckCast(r39, RecordingEntity.class, "com.obric.aiagent.plugin"));
        r38 = r38 + 1;
        goto L68
    L70:
        RecordingEntity[] r112 = (RecordingEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r36, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new RecordingEntity[0]), RecordingEntity[].class, "com.obric.aiagent.plugin");
        return d.a.p.a(new a("Recorder_Delete", (AppEntity[]) ZeusTransformUtils.preCheckCast(r112, AppEntity[].class, "com.obric.aiagent.plugin"), new RecordingDeleteParams(r112, false), a(r112)));
    L71:
        int r40 = r15.length;
        int r41 = 0;
    L72:
        if (r41 >= r40) goto L77;
        if (ZeusTransformUtils.instanceOf(r15[r41], MemoryEntity.class) == false) goto L75;
        r41 = r41 + 1;
        goto L72
    L75:
        r1 = false;
    L77:
        if (r1 == false) goto L106;
        Collection r42 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r15.length), Collection.class, "com.obric.aiagent.plugin");
        int r43 = r15.length;
        int r44 = 0;
    L79:
        if (r44 >= r43) goto L81;
        AppEntity r45 = r15[r44];
        d.h.b.o.a(r45, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.MemoryEntity");
        r42.add((MemoryEntity) ZeusTransformUtils.preCheckCast(r45, MemoryEntity.class, "com.obric.aiagent.plugin"));
        r44 = r44 + 1;
        goto L79
    L81:
        MemoryEntity[] r113 = (MemoryEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r42, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new MemoryEntity[0]), MemoryEntity[].class, "com.obric.aiagent.plugin");
        return d.a.p.a(new a("Memory_Delete", (AppEntity[]) ZeusTransformUtils.preCheckCast(r113, AppEntity[].class, "com.obric.aiagent.plugin"), new MemoryDeleteParams(a(r113)), null, 8, null));
    L106:
        return null;
    L65:
        r35 = true;
        goto L66
    L53:
        r28 = true;
        goto L54
    L41:
        r21 = true;
        goto L42
    L28:
        r11 = true;
        goto L30
    L15:
        r3 = true;
        goto L17
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.obric.agent.EntityDeleteHandler$b] */
    public final void a(AppEntity[] r30, IEntityDeleteCallbackIDL r31) {
        IEntityDeleteCallbackIDL r1 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r31, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r30, "entities");
        List<a> r13 = a(r30);
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L12;
        a(r1, 103, "unsupported or mixed entity types", new String[0]);
        return;
    L12:
        IAppIntentFeedback r15 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L16;
        a(r1, 1, "app intent feedback is unavailable", new String[0]);
        return;
    L16:
        AtomicBoolean r12 = new AtomicBoolean(false);
        AtomicInteger r11 = new AtomicInteger(r13.size());
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        ConcurrentHashMap.KeySetView r16 = ConcurrentHashMap.newKeySet();
        ConcurrentHashMap r17 = new ConcurrentHashMap();
        AtomicBoolean r9 = new AtomicBoolean(false);
        d.h.b.z.f r8 = new d.h.b.z.f();
        AtomicBoolean r32 = r9;
        r8.f38504a = new b(r10, r9, r11, r16, r17, r12, r15, r8, r1);
        if (r8.f38504a != 0) goto L19;
        d.h.b.o.c("listener");
        f r0 = null;
    L20:
        r15.addLocalActionFinishedListener(r0);
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r5.hasNext() == false) goto L33;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.aiagent.plugin");
        long r7 = f14177a.a();
        ((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.aiagent.plugin")).put(Long.valueOf(r7), r6);
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L26
        com.obric.agent.utils.b.f15994a.a(r6.a(), com.obric.agent.utils.b.f15994a.a(r6.c()), r6.d(), r7, r7, ao.a(d.s.a("o_entity_delete_bridge", "1")));     // Catch: Throwable -> L26
        Object r14 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L26
    L28:
        Throwable r18 = d.n.c(r14);
        if (r18 == null) goto L31;
        r10.remove(Long.valueOf(r7));
        AtomicBoolean r19 = r32;
        r19.set(true);
        r11.decrementAndGet();
        ILogDepend.Companion.e(TAG, "delete dispatch failed intent=" + r6.a(), r18);
    L32:
        r32 = r19;
        goto L22
    L31:
        r19 = r32;
    L26:
        th = move-exception;
        d.n.a r20 = d.n.f38560a;
        r14 = d.n.f(d.o.a(th));
        goto L28
    L33:
        AtomicBoolean r110 = r32;
        a(r11, r12, r15, r8, r16, r110, r17, r1, false, 256, null);
        kotlinx.coroutines.i.a(e.f14435a.a(), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r110, r11, r12, r15, r8, r16, r17, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L19:
        r0 = (f) ZeusTransformUtils.preCheckCast(r8.f38504a, f.class, "com.obric.aiagent.plugin");
        goto L20
    L5:
        if (r3.isEmpty() == true) goto L8;
        r4 = false;
        goto L9
    }

    static /* synthetic */ void a(AtomicInteger r11, AtomicBoolean r12, IAppIntentFeedback r13, d.h.b.z.f r14, ConcurrentHashMap.KeySetView r15, AtomicBoolean r16, ConcurrentHashMap r17, IEntityDeleteCallbackIDL r18, boolean r19, int r20, Object r21) {
        IAppIntentFeedback r4 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r13, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        IEntityDeleteCallbackIDL r9 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r18, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        if ((r20 & 256) == 0) goto L5;
        boolean r10 = false;
    L6:
        b(r11, r12, r4, r14, r15, r16, r17, r9, r10);
        return;
    L5:
        r10 = r19;
        goto L6
    }

    private static final void b(AtomicInteger r3, AtomicBoolean r4, IAppIntentFeedback r5, d.h.b.z.f<f> r6, ConcurrentHashMap.KeySetView<String, Boolean> r7, AtomicBoolean r8, ConcurrentHashMap<String, AppEntity> r9, IEntityDeleteCallbackIDL r10, boolean r11) {
        IAppIntentFeedback r12 = (IAppIntentFeedback) ZeusTransformUtils.wrapperContextForParams(r5, IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        IEntityDeleteCallbackIDL r13 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r10, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        if (r11 == false) goto L5;
    L7:
        boolean r14 = false;
        if (r4.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (r6.f38504a != null) goto L13;
        d.h.b.o.c("listener");
        f r15 = null;
    L14:
        r12.removeActionFinishedListener(r15);
        d.h.b.o.a(r7);
        String[] r16 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        if (r16.length != 0) goto L17;
        boolean r17 = true;
    L19:
        if ((!r17) == false) goto L22;
    L20:
        int r18 = 0;
    L25:
        if (r16.length != 0) goto L28;
        r14 = true;
    L28:
        if ((!r14) == true) goto L30;
    L32:
        if (r18 != 0) goto L34;
        String r19 = "";
    L35:
        ILogDepend.Companion r20 = ILogDepend.Companion;
        StringBuilder r21 = new StringBuilder().append("execute complete code=").append(r18).append(" failed=").append(r8.get()).append(" deletedIds=");
        String r110 = Arrays.toString(r16);
        d.h.b.o.c(r110, "toString(...)");
        r20.i(TAG, r21.append(r110).append(" remaining=").append(r3.get()).toString());
        Collection<AppEntity> r22 = r9.values();
        d.h.b.o.c(r22, "<get-values>(...)");
        List<? extends AppEntity> r23 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.aiagent.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L46;
    L44:
        f14177a.a(r13, r18, r19, r16);
        return;
    L46:
        d.n.a r24 = d.n.f38560a;     // Catch: Throwable -> L39
        com.obric.agent.entitysync.b.f14469a.a(r23);     // Catch: Throwable -> L39
        Object r25 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L39
    L41:
        Throwable r26 = d.n.c(r25);
        if (r26 == null) goto L44;
        ILogDepend.Companion.e(TAG, "persist deleted entity widget state failed, count=" + r23.size(), r26);
    L39:
        th = move-exception;
        d.n.a r27 = d.n.f38560a;
        r25 = d.n.f(d.o.a(th));
        goto L41
    L34:
        r19 = "delete entities failed";
        goto L35
    L30:
        if (r8.get() == false) goto L32;
        r19 = "some entities failed to delete";
        goto L35
    L22:
        if (r8.get() == false) goto L20;
        r18 = 1;
        goto L25
    L17:
        r17 = false;
        goto L19
    L13:
        r15 = (f) ZeusTransformUtils.preCheckCast(r6.f38504a, f.class, "com.obric.aiagent.plugin");
        goto L14
    L5:
        if (r3.get() <= 0) goto L7;
    }

    private final long a() {
        return UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
    }

    private final String a(AppEntity r3) {
        String r2 = r3.getEcaId();
        if (r2 != null) goto L5;
    L9:
        String r4 = r3.getId();
        if (r4 != null) goto L14;
        return "";
    L14:
        return r4;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L9;
        return r2;
    }

    private final String b(AppEntity r4) {
        return r4.getType() + ':' + r4.get_packageName() + ':' + a(r4);
    }

    private final String a(RecordingEntity[] r7) {
        int r0 = r7.length;
        int r1 = 0;
    L3:
        String r3 = null;
        if (r1 >= r0) goto L12;
        String r4 = r7[r1].getSourceAppPackage();
        if (r4 != null) goto L8;
    L10:
        if (r3 != null) goto L12;
        r1 = r1 + 1;
        goto L3
    L8:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L10;
        r3 = r4;
    L12:
        if (r3 == null) goto L15;
        return r3;
    L15:
        return a((AppEntity[]) ZeusTransformUtils.preCheckCast(r7, AppEntity[].class, "com.obric.aiagent.plugin"), "com.obric.recorder");
    }

    private final String a(MemoryEntity[] r7) {
        JSONArray r6 = new JSONArray();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        MemoryEntity r2 = r7[r1];
        r6.put(new JSONObject().put(DbHelper.COL_ID, r2.getId()).put("_packageName", r2.get_packageName()).put("type", r2.getType()));
        r1 = r1 + 1;
        goto L3
    L5:
        String r8 = r6.toString();
        d.h.b.o.c(r8, "toString(...)");
        return r8;
    }

    private final void a(IEntityDeleteCallbackIDL r2, int r3, String r4, String[] r5) {
        IEntityDeleteCallbackIDL r1 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r2, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.onResult(r3, r4, r5);     // Catch: Throwable -> L9
        d.x r7 = d.x.f38692a;     // Catch: Throwable -> L9
    L7:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L9
    L11:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L17;
        ILogDepend.Companion.e(TAG, "delete callback failed code=" + r3, r9);
        return;
    L17:
        return;
    L6:
        r7 = null;
    L9:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L11
    }

    private final String a(AppEntity[] r7, String r8) {
        int r6 = r7.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L16;
        AppEntity r1 = r7[r0];
        String r2 = r1.getPackageName();
        String r5 = null;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r2 = null;
    L8:
        if (r2 != null) goto L9;
        String r3 = r1.get_packageName();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        r5 = r3;
    L13:
        if (r5 != null) goto L14;
        r0 = r0 + 1;
        goto L3
    L14:
        return r5;
    L9:
        return r2;
    L16:
        return r8;
    }
}
