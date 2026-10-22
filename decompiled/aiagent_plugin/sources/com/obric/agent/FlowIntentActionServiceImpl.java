package com.obric.agent;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.agent.card.weather.QueryType;
import com.obric.agent.intents.music.netease.CMApiManager;
import com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL;
import com.obric.aiagent.assistant.idl.IFlowUiIDL;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.BaseCalendarShowScheduleIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockShowCountdownIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOffAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseClockTurnOnAlarmIntent;
import com.obric.capabilitykit.common.intent.BaseCommonViewEntitiesIntent;
import com.obric.capabilitykit.common.intent.BaseContactsShowContactIntent;
import com.obric.capabilitykit.common.intent.BaseFilesShowFileIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesSendIntent;
import com.obric.capabilitykit.common.intent.BaseMessagesShowMessageIntent;
import com.obric.capabilitykit.common.intent.BaseNotesShowNoteIntent;
import com.obric.capabilitykit.common.intent.BasePhoneCallIntent;
import com.obric.capabilitykit.common.intent.BasePhoneShowCallHistoryIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowAlbumIntent;
import com.obric.capabilitykit.common.intent.BasePhotoShowPhotoIntent;
import com.obric.capabilitykit.common.intent.BaseRecorderShowRecordingIntent;
import com.obric.capabilitykit.common.intent.CalendarShowScheduleParams;
import com.obric.capabilitykit.common.intent.ClockShowAlarmParams;
import com.obric.capabilitykit.common.intent.ClockShowCountdownParams;
import com.obric.capabilitykit.common.intent.ClockTurnOffAlarmParams;
import com.obric.capabilitykit.common.intent.ClockTurnOnAlarmParams;
import com.obric.capabilitykit.common.intent.CommonViewEntitiesParams;
import com.obric.capabilitykit.common.intent.ContactTarget;
import com.obric.capabilitykit.common.intent.ContactsShowContactParams;
import com.obric.capabilitykit.common.intent.FilesShowFileParams;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.MessageContent;
import com.obric.capabilitykit.common.intent.MessagesSendParams;
import com.obric.capabilitykit.common.intent.MessagesShowMessageParams;
import com.obric.capabilitykit.common.intent.NotesShowNoteParams;
import com.obric.capabilitykit.common.intent.PhoneCallParams;
import com.obric.capabilitykit.common.intent.PhoneShowCallHistoryParams;
import com.obric.capabilitykit.common.intent.PhotoShowAlbumParams;
import com.obric.capabilitykit.common.intent.PhotoShowPhotoParams;
import com.obric.capabilitykit.common.intent.RecorderShowRecordingParams;
import com.obric.capabilitykit.common.intent.WeatherShowParams;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.funcall_api.bean.IntentAppAction;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: FlowIntentActionServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FlowIntentActionServiceImpl implements IFlowIntentActionService {
    public static final a Companion = null;
    private static final String FLOW_PACKAGE = "com.larus.nova";
    private static final String LARK_PACKAGE = "com.ss.android.lark";
    private static final String TAG = "FlowIntentActionService";
    private Object lastShowEntity;

    /* JADX INFO: compiled from: FlowIntentActionServiceImpl.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FlowIntentActionServiceImpl.kt */
    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14193b;

        public b(long r1, String r3) {
            this.f14192a = r1;
            this.f14193b = r3;
        }

        @Override // com.obric.agent.f
        public Object a(IntentAppAction r7, JobResult r8, d.c.d<? super d.x> r9) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            if (r7.getQuestionId() != this.f14192a) goto L5;
            boolean r11 = false;
            if (r8 == null) goto L17;
            List<IntentExecutionRecord> r12 = r8.getExecRecords();
            if (r12 == null) goto L17;
            IntentExecutionRecord r13 = (IntentExecutionRecord) ZeusTransformUtils.preCheckCast(d.a.p.l(r12), IntentExecutionRecord.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L17;
            IntentResult<?> r14 = r13.getResult();
            if (r14 == null) goto L17;
            if (r14.getRet() != 200) goto L17;
            r11 = true;
        L17:
            if (r11 == false) goto L23;
            String r15 = this.f14193b;
            if (r15 == null) goto L23;
            IFlowUiIDL r16 = aw.a(aa.b(IFlowUiIDL.class));
            if (r16 == null) goto L23;
            r16.showToast(r15);
        L23:
            IAppIntentFeedback r17 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L27;
            r17.removeActionFinishedListener((f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin"));
        L27:
            return d.x.f38692a;
        L5:
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: FlowIntentActionServiceImpl.kt */
    @d.c.b.a.f(b = "FlowIntentActionServiceImpl.kt", c = {335}, d = "invokeSuspend", e = "com.obric.agent.FlowIntentActionServiceImpl$pauseMusic$1$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14194a;

        c(d.c.d<? super c> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14194a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            com.obric.agent.intents.music.netease.d r6 = com.obric.agent.intents.music.netease.d.f14762a;
            d.c.d<? super Integer> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14194a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FlowIntentActionServiceImpl.kt */
    @d.c.b.a.f(b = "FlowIntentActionServiceImpl.kt", c = {320}, d = "invokeSuspend", e = "com.obric.agent.FlowIntentActionServiceImpl$playMusic$1$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Integer>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MusicEntity[] f14196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MusicEntity f14197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f14198d;

        d(MusicEntity[] r3, MusicEntity r4, String r5, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14196b = r3;
            this.f14197c = r4;
            this.f14198d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Integer> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f14196b, this.f14197c, this.f14198d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Integer> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14195a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L15:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            com.obric.agent.intents.music.netease.d r9 = com.obric.agent.intents.music.netease.d.f14762a;
            MusicEntity[] r2 = this.f14196b;
            if (r2 == null) goto L11;
            List<MusicEntity> r3 = d.a.i.g(r2);
        L12:
            MusicEntity r4 = this.f14197c;
            String r5 = this.f14198d;
            d.c.d<? super Integer> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14195a = 1;
            r8 = r9.a(r3, r4, r5, r6);
            if (r8 != r0) goto L15;
            return r0;
        L11:
            r3 = null;
            goto L12
        }
    }

    static {
        Companion = new a(null);
    }

    public FlowIntentActionServiceImpl() {
    }

    public static final /* synthetic */ long access$nextRequestId(FlowIntentActionServiceImpl r2) {
        return r2.nextRequestId();
    }

    public static final /* synthetic */ void access$setLastShowEntity$p(FlowIntentActionServiceImpl r0, Object r1) {
        r0.lastShowEntity = r1;
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void viewEntities(int r6, List<? extends AppEntity> r7, String r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "entities");
        if (r6 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        executeIntent(new BaseCommonViewEntitiesIntent().getName(), new CommonViewEntitiesParams(Integer.valueOf(r6), (AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.aiagent.plugin")), ((AppEntity) ZeusTransformUtils.preCheckCast(r9.get(r6), AppEntity.class, "com.obric.aiagent.plugin")).get_packageName());
        return;
    L5:
        if (r6 >= ((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).size()) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void callPhone(String r9, ContactEntity r10, String r11, String r12) {
        executeIntent$default(this, new BasePhoneCallIntent().getName(), new PhoneCallParams(new ContactTarget(r9, r10), r11, null, 4, null), null, 4, null);
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void sendSms(String r7, ContactEntity r8, String r9, String r10) {
        executeIntent$default(this, new BaseMessagesSendIntent().getName(), new MessagesSendParams(new ContactTarget(r7, r8), new MessageContent(r9, null, null, null)), null, 4, null);
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void turnOnOffAlarm(AlarmEntity r10, boolean r11, String r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r11 == false) goto L7;
        executeIntent$default(this, new BaseClockTurnOnAlarmIntent().getName(), new ClockTurnOnAlarmParams(new AlarmEntity[]{r10}, false), null, 4, null);
        return;
    L7:
        executeIntent$default(this, new BaseClockTurnOffAlarmIntent().getName(), new ClockTurnOffAlarmParams(new AlarmEntity[]{r10}, false, null, 4, null), null, 4, null);
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void deleteEntities(AppEntity[] r3, IEntityDeleteCallbackIDL r4) {
        IEntityDeleteCallbackIDL r2 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        boolean r5 = true;
        if (r3 != null) goto L5;
    L11:
        if (r5 == false) goto L15;
        if (r2 == null) goto L17;
        r2.onResult(103, "entities is empty", new String[0]);
        return;
    L17:
        return;
    L15:
        EntityDeleteHandler.f14177a.a(r3, r2);
        return;
    L5:
        if (r3.length != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r5 = false;
        goto L11
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showContact(ContactEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_contact_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_contact_deleted_toast"));
        String r4 = new BaseContactsShowContactIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new ContactsShowContactParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showCallHistory(CallHistoryEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_callhistory_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_callhistory_deleted_toast"));
        String r4 = new BasePhoneShowCallHistoryIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new PhoneShowCallHistoryParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showAlarm(AlarmEntity r12) {
        String r2 = new BaseClockShowAlarmIntent().getName();
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r0 = d.a.p.a(r12);
    L20:
        if (r0 == null) goto L40;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r4 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L29;
        List<AppEntity> r3 = r4.checkDeletedEntitie(r0);
        if (r3 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r1 = true;
    L29:
        if (r1 == true) goto L41;
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r2, com.obric.agent.utils.b.f15994a.a(new ClockShowAlarmParams(r12)), null, r9);
        b r11 = new b(r9, null);
        IAppIntentFeedback r13 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L39;
        r13.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin"));
        return;
    L39:
        return;
    L41:
        return;
    L40:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L38;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r7 = r5.length;
        int r8 = 0;
    L8:
        if (r8 >= r7) goto L13;
        Object r10 = r5[r8];
        if (ZeusTransformUtils.instanceOf(r10, AppEntity.class) == false) goto L12;
        r6.add(r10);
    L12:
        r8 = r8 + 1;
        goto L8
    L13:
        r0 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin");
        if (r0.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r14 = true;
    L17:
        if (r14 == true) goto L20;
        r0 = null;
        goto L20
    L16:
        r14 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showCountdown(CountdownEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_timer_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_timer_deleted_toast"));
        String r4 = new BaseClockShowCountdownIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new ClockShowCountdownParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showNote(NoteEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_note_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_note_deleted_toast"));
        String r4 = new BaseNotesShowNoteIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new NotesShowNoteParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showWeather(String r12, String r13) {
        if (r12 == null) goto L34;
        String r14 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r14 == null) goto L35;
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        String r4 = null;
        if (r0 == true) goto L13;
        r14 = null;
    L13:
        if (r14 == null) goto L40;
        if (r13 == null) goto L36;
        String r15 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r15 == null) goto L37;
        Locale r1 = Locale.ROOT;
        d.h.b.o.c(r1, "ROOT");
        String r16 = r15.toUpperCase(r1);
        d.h.b.o.c(r16, "toUpperCase(...)");
        if (r16 == null) goto L38;
        QueryType[] r3 = QueryType.values();
        int r5 = r3.length;
        int r6 = 0;
    L21:
        if (r6 >= r5) goto L26;
        if (d.h.b.o.a(r3[r6].name(), r16) == true) goto L27;
        r6 = r6 + 1;
    L27:
        if (r2 == false) goto L29;
        r4 = r16;
    L29:
        if (r4 == null) goto L39;
        executeIntent$default(this, "Weather_Show", new WeatherShowParams(r14, r4), null, 4, null);
        return;
    L39:
        return;
    L26:
        r2 = false;
        goto L27
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L40:
        return;
    L8:
        r0 = false;
        goto L9
    L35:
        return;
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showAlbum(AlbumEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_album_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_album_deleted_toast"));
        String r4 = new BasePhotoShowAlbumIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new PhotoShowAlbumParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showPhoto(PhotoEntity[] r12, int r13) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_photo_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_photo_deleted_toast"));
        String r4 = new BasePhotoShowPhotoIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new PhotoShowPhotoParams(r12, Integer.valueOf(r13))), null, r9);
        b r14 = new b(r9, r0);
        IAppIntentFeedback r15 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r15 == null) goto L45;
        r15.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r14, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r16 = 0;
    L8:
        if (r16 >= r10) goto L13;
        Object r17 = r7[r16];
        if (ZeusTransformUtils.instanceOf(r17, AppEntity.class) == false) goto L12;
        r8.add(r17);
    L12:
        r16 = r16 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r18 = true;
    L17:
        if (r18 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r18 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showFile(FileEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_file_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_file_deleted_toast"));
        String r4 = new BaseFilesShowFileIntent().getName();
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L46;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r5 = r6.checkDeletedEntitie(r2);
        if (r5 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (r0 == null) goto L42;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L43;
        r11.showToast(r0);
        return;
    L43:
        return;
    L42:
        return;
    L34:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new FilesShowFileParams(r12)), null, r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L45;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L45:
        return;
    L46:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L41;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showRecording(RecordingEntity r14) {
        List<? extends AppEntity> r0 = null;
        if (r14 == null) goto L5;
        String r1 = r14.getExtraData();
    L7:
        if (d.h.b.o.a(r1, "fictitious") == true) goto L51;
        String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_recording_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_recording_deleted_toast"));
        String r5 = new BaseRecorderShowRecordingIntent().getName();
        boolean r4 = false;
        if (ZeusTransformUtils.instanceOf(r14, AppEntity.class) == false) goto L20;
        r0 = d.a.p.a(r14);
    L33:
        if (r0 == null) goto L62;
        access$setLastShowEntity$p(this, r14);
        IEntityManager r3 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L42;
        List<AppEntity> r6 = r3.checkDeletedEntitie(r0);
        if (r6 == null) goto L42;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L42;
        r4 = true;
    L42:
        if (r4 == false) goto L47;
        if (r2 == null) goto L58;
        IFlowUiIDL r13 = aw.a(aa.b(IFlowUiIDL.class));
        if (r13 == null) goto L59;
        r13.showToast(r2);
        return;
    L59:
        return;
    L58:
        return;
    L47:
        long r10 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r5, com.obric.agent.utils.b.f15994a.a(new RecorderShowRecordingParams(r14)), null, r10);
        b r15 = new b(r10, r2);
        IAppIntentFeedback r16 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L61;
        r16.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r15, f.class, "com.obric.aiagent.plugin"));
        return;
    L61:
        return;
    L62:
        return;
    L20:
        if ((r14 instanceof Object[]) == false) goto L57;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r9 = r7.length;
        int r11 = 0;
    L22:
        if (r11 >= r9) goto L27;
        Object r12 = r7[r11];
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L26;
        r8.add(r12);
    L26:
        r11 = r11 + 1;
        goto L22
    L27:
        List<? extends AppEntity> r17 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r17.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.aiagent.plugin")).length) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L33;
        r0 = r17;
        goto L33
    L30:
        r18 = false;
        goto L31
    L57:
        return;
    L51:
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L10
        FlowIntentActionServiceImpl r110 = (FlowIntentActionServiceImpl) ZeusTransformUtils.preCheckCast(this, FlowIntentActionServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Application r111 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Intent r112 = new Intent();     // Catch: Throwable -> L10
        r112.setComponent(new ComponentName("com.obric.recorder", "com.bytedanceos.recorder.office.presentation.OfficeRecorderListActivity"));     // Catch: Throwable -> L10
        r112.addFlags(268435456);     // Catch: Throwable -> L10
        ZeusTransformUtils.startActivity(r111, r112, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
        Object r113 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L10
    L12:
        Throwable r114 = d.n.c(r113);
        if (r114 == null) goto L56;
        ILogDepend.Companion.e(TAG, "launch recorder list failed", r114);
        return;
    L56:
        return;
    L10:
        th = move-exception;
        d.n.a r115 = d.n.f38560a;
        r113 = d.n.f(d.o.a(th));
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showAuditoryRecording(AuditoryRecordingEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_auditory_recording_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_auditory_recording_deleted_toast"));
        String r4 = new BaseCommonViewEntitiesIntent().getName();
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L47;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r3 = r6.checkDeletedEntitie(r2);
        if (r3 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L35;
        if (r0 == null) goto L43;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L44;
        r11.showToast(r0);
        return;
    L44:
        return;
    L43:
        return;
    L35:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new CommonViewEntitiesParams(0, new AppEntity[]{r12})), "com.larus.nova", r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L46;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L46:
        return;
    L29:
        r5 = false;
        goto L30
    L47:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L42;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showMessage(MessageEntity r17) {
        List<? extends AppEntity> r1 = null;
        if (r17 == null) goto L9;
        String r5 = r17.get_packageName();
        if (r5 == null) goto L9;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(LARK_PACKAGE, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L14;
        IFlowUiIDL r7 = aw.a(aa.b(IFlowUiIDL.class));
        if (r7 == null) goto L14;
        r7.handleObricAction("obric_action://chat_page.stash_window?data=%7B%22animation%22%3A%22slide%22%7D&key=aiagent_internal", "aiagent_internal", null);
    L14:
        String r8 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_message_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_message_deleted_toast"));
        if (r6 == false) goto L17;
        String r9 = new BaseCommonViewEntitiesIntent().getName();
    L18:
        String r10 = r9;
        if (r17 == null) goto L21;
        String r11 = r17.get_packageName();
    L22:
        if (r6 == false) goto L24;
        String r12 = r11;
    L26:
        if (ZeusTransformUtils.instanceOf(r17, AppEntity.class) == false) goto L29;
        r1 = d.a.p.a(r17);
    L42:
        if (r1 == null) goto L73;
        access$setLastShowEntity$p(this, r17);
        IEntityManager r13 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r13 == null) goto L51;
        List<AppEntity> r2 = r13.checkDeletedEntitie(r1);
        if (r2 == null) goto L51;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L51;
        boolean r3 = true;
    L52:
        if (r3 == false) goto L57;
        if (r8 == null) goto L69;
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L70;
        r0.showToast(r8);
        return;
    L70:
        return;
    L69:
        return;
    L57:
        long r14 = access$nextRequestId(this);
        com.obric.agent.utils.b r15 = com.obric.agent.utils.b.f15994a;
        com.obric.agent.utils.b r4 = com.obric.agent.utils.b.f15994a;
        if (r6 == false) goto L60;
        IntentParams r16 = (IntentParams) ZeusTransformUtils.preCheckCast(new CommonViewEntitiesParams(0, new AppEntity[]{r17}), IntentParams.class, "com.obric.aiagent.plugin");
    L61:
        r15.a(r10, r4.a(r16), r12, r14);
        b r18 = new b(r14, r8);
        IAppIntentFeedback r19 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r19 == null) goto L72;
        r19.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r18, f.class, "com.obric.aiagent.plugin"));
        return;
    L72:
        return;
    L60:
        r16 = (IntentParams) ZeusTransformUtils.preCheckCast(new MessagesShowMessageParams(r17), IntentParams.class, "com.obric.aiagent.plugin");
    L51:
        r3 = false;
        goto L52
    L73:
        return;
    L29:
        if ((r17 instanceof Object[]) == false) goto L68;
        Object[] r20 = (Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.aiagent.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r110 = r20.length;
        int r111 = 0;
    L31:
        if (r111 >= r110) goto L36;
        Object r112 = r20[r111];
        if (ZeusTransformUtils.instanceOf(r112, AppEntity.class) == false) goto L35;
        r21.add(r112);
    L35:
        r111 = r111 + 1;
        goto L31
    L36:
        List<? extends AppEntity> r22 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.aiagent.plugin");
        if (r22.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.aiagent.plugin")).length) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == false) goto L42;
        r1 = r22;
        goto L42
    L39:
        r23 = false;
        goto L40
    L68:
        return;
    L24:
        r12 = null;
        goto L26
    L21:
        r11 = null;
        goto L22
    L17:
        r9 = new BaseMessagesShowMessageIntent().getName();
    L9:
        r6 = false;
        goto L10
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showSchedule(ScheduleEntity r17) {
        List<? extends AppEntity> r1 = null;
        if (r17 == null) goto L9;
        String r5 = r17.get_packageName();
        if (r5 == null) goto L9;
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(LARK_PACKAGE, CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) != true) goto L9;
        boolean r6 = true;
    L10:
        String r7 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_schedule_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_schedule_deleted_toast"));
        if (r6 == false) goto L13;
        String r8 = new BaseCommonViewEntitiesIntent().getName();
    L14:
        String r9 = r8;
        if (r17 == null) goto L17;
        String r10 = r17.get_packageName();
    L18:
        if (r6 == false) goto L20;
        String r11 = r10;
    L22:
        if (ZeusTransformUtils.instanceOf(r17, AppEntity.class) == false) goto L25;
        r1 = d.a.p.a(r17);
    L38:
        if (r1 == null) goto L69;
        access$setLastShowEntity$p(this, r17);
        IEntityManager r12 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L47;
        List<AppEntity> r2 = r12.checkDeletedEntitie(r1);
        if (r2 == null) goto L47;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L47;
        boolean r3 = true;
    L48:
        if (r3 == false) goto L53;
        if (r7 == null) goto L65;
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L66;
        r0.showToast(r7);
        return;
    L66:
        return;
    L65:
        return;
    L53:
        long r14 = access$nextRequestId(this);
        com.obric.agent.utils.b r13 = com.obric.agent.utils.b.f15994a;
        com.obric.agent.utils.b r4 = com.obric.agent.utils.b.f15994a;
        if (r6 == false) goto L56;
        IntentParams r15 = (IntentParams) ZeusTransformUtils.preCheckCast(new CommonViewEntitiesParams(0, new AppEntity[]{r17}), IntentParams.class, "com.obric.aiagent.plugin");
    L57:
        r13.a(r9, r4.a(r15), r11, r14);
        b r16 = new b(r14, r7);
        IAppIntentFeedback r18 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L68;
        r18.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r16, f.class, "com.obric.aiagent.plugin"));
        return;
    L68:
        return;
    L56:
        r15 = (IntentParams) ZeusTransformUtils.preCheckCast(new CalendarShowScheduleParams(r17), IntentParams.class, "com.obric.aiagent.plugin");
    L47:
        r3 = false;
        goto L48
    L69:
        return;
    L25:
        if ((r17 instanceof Object[]) == false) goto L64;
        Object[] r19 = (Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.aiagent.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r110 = r19.length;
        int r111 = 0;
    L27:
        if (r111 >= r110) goto L32;
        Object r112 = r19[r111];
        if (ZeusTransformUtils.instanceOf(r112, AppEntity.class) == false) goto L31;
        r20.add(r112);
    L31:
        r111 = r111 + 1;
        goto L27
    L32:
        List<? extends AppEntity> r21 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.aiagent.plugin");
        if (r21.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r17, Object[].class, "com.obric.aiagent.plugin")).length) goto L35;
        boolean r22 = true;
    L36:
        if (r22 == false) goto L38;
        r1 = r21;
        goto L38
    L35:
        r22 = false;
        goto L36
    L64:
        return;
    L20:
        r11 = null;
        goto L22
    L17:
        r10 = null;
        goto L18
    L13:
        r8 = new BaseCalendarShowScheduleIntent().getName();
    L9:
        r6 = false;
        goto L10
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showMemory(MemoryEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_memory_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_memory_deleted_toast"));
        String r4 = new BaseCommonViewEntitiesIntent().getName();
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L47;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r3 = r6.checkDeletedEntitie(r2);
        if (r3 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L35;
        if (r0 == null) goto L43;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L44;
        r11.showToast(r0);
        return;
    L44:
        return;
    L43:
        return;
    L35:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new CommonViewEntitiesParams(0, new AppEntity[]{r12})), "com.larus.nova", r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L46;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L46:
        return;
    L29:
        r5 = false;
        goto L30
    L47:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L42;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showProactiveMemory(ProactiveMemoryEntity r12) {
        String r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_memory_deleted_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_memory_deleted_toast"));
        String r4 = new BaseCommonViewEntitiesIntent().getName();
        if (ZeusTransformUtils.instanceOf(r12, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r2 = d.a.p.a(r12);
    L20:
        if (r2 == null) goto L47;
        access$setLastShowEntity$p(this, r12);
        IEntityManager r6 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L29;
        List<AppEntity> r3 = r6.checkDeletedEntitie(r2);
        if (r3 == null) goto L29;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L29;
        boolean r5 = true;
    L30:
        if (r5 == false) goto L35;
        if (r0 == null) goto L43;
        IFlowUiIDL r11 = aw.a(aa.b(IFlowUiIDL.class));
        if (r11 == null) goto L44;
        r11.showToast(r0);
        return;
    L44:
        return;
    L43:
        return;
    L35:
        long r9 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r4, com.obric.agent.utils.b.f15994a.a(new CommonViewEntitiesParams(0, new AppEntity[]{r12})), "com.larus.nova", r9);
        b r13 = new b(r9, r0);
        IAppIntentFeedback r14 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L46;
        r14.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r13, f.class, "com.obric.aiagent.plugin"));
        return;
    L46:
        return;
    L29:
        r5 = false;
        goto L30
    L47:
        return;
    L6:
        if ((r12 instanceof Object[]) == false) goto L42;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r10 = r7.length;
        int r15 = 0;
    L8:
        if (r15 >= r10) goto L13;
        Object r16 = r7[r15];
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L12;
        r8.add(r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L13:
        r2 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
        if (r2.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r2 = null;
        goto L20
    L16:
        r17 = false;
        goto L17
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public int playMusic(String r5, MusicEntity[] r6, MusicEntity r7) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        FlowIntentActionServiceImpl r2 = (FlowIntentActionServiceImpl) ZeusTransformUtils.preCheckCast(this, FlowIntentActionServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r8 = d.n.f(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(e.f14435a.a().a(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r6, r7, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).intValue()));     // Catch: Throwable -> L5
    L7:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L11;
        ILogDepend.Companion.e(TAG, "playMusic error", r9);
        r8 = 1;
    L11:
        showMusicError(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue());
        return ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void showMusicPage() {
        com.obric.agent.intents.music.netease.d.f14762a.a();
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public int pauseMusic() {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L5
        FlowIntentActionServiceImpl r4 = (FlowIntentActionServiceImpl) ZeusTransformUtils.preCheckCast(this, FlowIntentActionServiceImpl.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = d.n.f(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(e.f14435a.a().a(), (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.m.class, "com.obric.aiagent.plugin")), Number.class, "com.obric.aiagent.plugin")).intValue()));     // Catch: Throwable -> L5
    L7:
        Throwable r2 = d.n.c(r5);
        if (r2 == null) goto L12;
        ILogDepend.Companion.e(TAG, "pauseMusic error", r2);
        r5 = 1;
    L12:
        return ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue();
    L5:
        th = move-exception;
        d.n.a r3 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L7
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void registerMusicStateListener(IMusicStateListenerIDL r2) {
        IMusicStateListenerIDL r1 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        CMApiManager.INSTANCE.registerMusicStateListener(r1);
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void unregisterMusicStateListener(IMusicStateListenerIDL r2) {
        IMusicStateListenerIDL r1 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r2, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        CMApiManager.INSTANCE.unregisterMusicStateListener(r1);
    }

    @Override // com.obric.agent.IFlowIntentActionService
    public void retryLastShowEntity() {
        Object r0 = this.lastShowEntity;
        if (ZeusTransformUtils.instanceOf(r0, MessageEntity.class) == false) goto L6;
        showMessage((MessageEntity) ZeusTransformUtils.preCheckCast(r0, MessageEntity.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r0, ContactEntity.class) == false) goto L9;
        showContact((ContactEntity) ZeusTransformUtils.preCheckCast(r0, ContactEntity.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, CallHistoryEntity.class) == false) goto L12;
        showCallHistory((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r0, CallHistoryEntity.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, NoteEntity.class) == false) goto L18;
        showNote((NoteEntity) ZeusTransformUtils.preCheckCast(r0, NoteEntity.class, "com.obric.aiagent.plugin"));
        return;
    }

    static /* synthetic */ void executeIntent$default(FlowIntentActionServiceImpl r0, String r1, Object r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.executeIntent(r1, r2, r3);
    }

    private final void executeIntent(String r7, Object r8, String r9) {
        com.obric.agent.utils.b.f15994a.a(r7, com.obric.agent.utils.b.f15994a.a(r8), r9, nextRequestId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> void executeShowIntent(T r13, boolean r14, String r15, String r16, String r17, d.h.a.b<? super T, ? extends Object> r18) {
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r18, d.h.a.b.class, "com.obric.aiagent.plugin");
        boolean r5 = false;
        if (ZeusTransformUtils.instanceOf(r13, AppEntity.class) == false) goto L6;
        List<? extends AppEntity> r4 = d.a.p.a(r13);
    L20:
        if (r4 != null) goto L22;
        return;
    L22:
        access$setLastShowEntity$p(this, r13);
        if (r14 == false) goto L37;
        IEntityManager r7 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L31;
        List<AppEntity> r6 = r7.checkDeletedEntitie(r4);
        if (r6 == null) goto L31;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L31;
        r5 = true;
    L31:
        if (r5 == false) goto L37;
        if (r15 == null) goto L44;
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L45;
        r0.showToast(r15);
        return;
    L45:
        return;
    L44:
        return;
    L37:
        long r10 = access$nextRequestId(this);
        com.obric.agent.utils.b.f15994a.a(r16, com.obric.agent.utils.b.f15994a.a(r2.invoke(r13)), r17, r10);
        b r1 = new b(r10, r15);
        IAppIntentFeedback r3 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L47;
        r3.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.aiagent.plugin"));
        return;
    L47:
        return;
    L6:
        if ((r13 instanceof Object[]) == false) goto L46;
        Object[] r8 = (Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.aiagent.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r11 = r8.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L13;
        Object r19 = r8[r12];
        if (ZeusTransformUtils.instanceOf(r19, AppEntity.class) == false) goto L12;
        r9.add(r19);
    L12:
        r12 = r12 + 1;
        goto L8
    L13:
        r4 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.aiagent.plugin");
        if (r4.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r13, Object[].class, "com.obric.aiagent.plugin")).length) goto L16;
        boolean r20 = true;
    L17:
        if (r20 == true) goto L20;
        r4 = null;
        goto L20
    L16:
        r20 = false;
        goto L17
    }

    static /* synthetic */ void executeShowIntent$default(FlowIntentActionServiceImpl r15, Object r16, boolean r17, String r18, String r19, String r20, d.h.a.b r21, int r22, Object r23) {
        d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r21, d.h.a.b.class, "com.obric.aiagent.plugin");
        boolean r4 = true;
        if ((r22 & 2) == 0) goto L5;
        boolean r3 = true;
    L6:
        List<? extends AppEntity> r6 = null;
        if ((r22 & 4) == 0) goto L9;
        String r5 = null;
    L11:
        if ((r22 & 16) == 0) goto L13;
        String r11 = null;
    L15:
        if (ZeusTransformUtils.instanceOf(r16, AppEntity.class) == false) goto L18;
        r6 = d.a.p.a(r16);
    L31:
        if (r6 != null) goto L33;
        return;
    L33:
        access$setLastShowEntity$p(r15, r16);
        if (r3 == false) goto L49;
        IEntityManager r7 = (IEntityManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IEntityManager.class), IEntityManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L42;
        List<AppEntity> r8 = r7.checkDeletedEntitie(r6);
        if (r8 == null) goto L42;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) != true) goto L42;
    L43:
        if (r4 == false) goto L49;
        if (r5 == null) goto L56;
        IFlowUiIDL r0 = aw.a(aa.b(IFlowUiIDL.class));
        if (r0 == null) goto L57;
        r0.showToast(r5);
        return;
    L57:
        return;
    L56:
        return;
    L42:
        r4 = false;
    L49:
        long r9 = access$nextRequestId(r15);
        com.obric.agent.utils.b.f15994a.a(r19, com.obric.agent.utils.b.f15994a.a(r1.invoke(r16)), r11, r9);
        b r2 = new b(r9, r5);
        IAppIntentFeedback r10 = (IAppIntentFeedback) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppIntentFeedback.class), IAppIntentFeedback.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L59;
        r10.addLocalActionFinishedListener((f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin"));
        return;
    L59:
        return;
    L18:
        if ((r16 instanceof Object[]) == false) goto L58;
        Object[] r12 = (Object[]) ZeusTransformUtils.preCheckCast(r16, Object[].class, "com.obric.aiagent.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r14 = r12.length;
        int r110 = 0;
    L20:
        if (r110 >= r14) goto L25;
        Object r111 = r12[r110];
        if (ZeusTransformUtils.instanceOf(r111, AppEntity.class) == false) goto L24;
        r13.add(r111);
    L24:
        r110 = r110 + 1;
        goto L20
    L25:
        List<? extends AppEntity> r24 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.aiagent.plugin");
        if (r24.size() != ((Object[]) ZeusTransformUtils.preCheckCast(r16, Object[].class, "com.obric.aiagent.plugin")).length) goto L28;
        boolean r25 = true;
    L29:
        if (r25 == false) goto L31;
        r6 = r24;
        goto L31
    L28:
        r25 = false;
        goto L29
    L58:
        return;
    L13:
        r11 = r20;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L6
    }

    private final void showMusicError(int r4) {
        if (r4 != 0) goto L5;
        return;
    L5:
        if (r4 != 100) goto L7;
        int r3 = ZeusTransformUtils.mapRes(R.string.obric_netease_not_install, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_not_install");
    L17:
        IFlowUiIDL r5 = aw.a(aa.b(IFlowUiIDL.class));
        if (r5 == null) goto L21;
        r5.showToast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(r3));
        return;
    L21:
        return;
    L7:
        if (r4 != 106) goto L9;
        r3 = ZeusTransformUtils.mapRes(R.string.obric_netease_low_version, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_low_version");
        goto L17
    L9:
        if (r4 != 201) goto L11;
        r3 = ZeusTransformUtils.mapRes(R.string.obric_netease_privacy_not_agree, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_privacy_not_agree");
        goto L17
    L11:
        if (r4 == 202) goto L13;
        r3 = ZeusTransformUtils.mapRes(R.string.obric_netease_api_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_api_error");
        goto L17
    L13:
        r3 = ZeusTransformUtils.mapRes(R.string.obric_netease_not_login, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_netease_not_login");
        goto L17
    }

    private final long nextRequestId() {
        return UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
    }
}
