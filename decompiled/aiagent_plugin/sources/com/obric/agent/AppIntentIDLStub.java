package com.obric.agent;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.agent.autoaction.IAutoActionService;
import com.obric.agent.complextask.IComplexTaskService;
import com.obric.agent.trace.IIntentTraceService;
import com.obric.aiagent.account.IAccountService;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI;
import com.obric.aiagent.assistant.idl.IEntityDeleteCallbackIDL;
import com.obric.aiagent.assistant.idl.IMusicStateListenerIDL;
import com.obric.aiagent.assistant.idl.IRecordingDeleteCallbackIDL;
import com.obric.aiagent.assistant.idl.IScreenshotCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.dm.api.statemachine.core.DMState;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.obric.assistant.dm.api.statemachine.core.TaskState;
import com.obric.assistant.dm.api.statemachine.manager.IDialogStateManager;
import com.obric.autogui.api.IOAutoStateManager;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemSwitchModeParams;
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
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: AppIntentIDLStub.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppIntentIDLStub implements IAgentAppIntentIDLSPI {
    private final d.f flowIntentService$delegate;
    private final d.f service$delegate;

    /* JADX INFO: compiled from: AppIntentIDLStub.kt */
    @d.c.b.a.f(b = "AppIntentIDLStub.kt", c = {BDAbstractUpload.KeyIsRetryStatesDir}, d = "invokeSuspend", e = "com.obric.agent.AppIntentIDLStub$isWifiEnabled$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppIntentIDLStub f14157b;

        a(AppIntentIDLStub r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14157b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f14157b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14156a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L11:
            IntentResult r12 = (IntentResult) ZeusTransformUtils.preCheckCast(r11, IntentResult.class, "com.obric.aiagent.plugin");
            if (r12 != null) goto L14;
        L16:
            r3 = false;
        L17:
            if (r3 == true) goto L21;
            return d.c.b.a.b.a(false);
        L21:
            return d.c.b.a.b.a(AppIntentIDLStub.access$parseWifiEnabled(this.f14157b, r12.getDetails()));
        L14:
            if (r12.getRet() != 0) goto L16;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            com.obric.agent.utils.b r4 = com.obric.agent.utils.b.f15994a;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14156a = 1;
            r11 = com.obric.agent.utils.b.a(r4, "System_DeviceState", null, r7, 2, null);
            if (r11 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppIntentIDLStub.kt */
    public static final class b implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IScreenshotCallbackIDL f14158a;

        b(IScreenshotCallbackIDL r3) {
            this.f14158a = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.agent.t
        public void a(Uri r4) {
            d.h.b.o.e(r4, "uri");
            ILogDepend.Companion.i(IAgentAppIntentIDLSPI.TAG, "onReceivedScreenshotUri " + r4);
            IScreenshotCallbackIDL r3 = this.f14158a;
            if (r3 == null) goto L6;
            r3.onReceivedScreenshotUri(r4);
            return;
        }

        @Override // com.obric.agent.t
        public void a(String r4) {
            d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
            ILogDepend.Companion.i(IAgentAppIntentIDLSPI.TAG, "onScreenshotError " + r4);
            IScreenshotCallbackIDL r3 = this.f14158a;
            if (r3 == null) goto L6;
            r3.onError(r4);
            return;
        }
    }

    /* JADX INFO: compiled from: AppIntentIDLStub.kt */
    @d.c.b.a.f(b = "AppIntentIDLStub.kt", c = {BDAbstractUpload.KeyIsSDKMaxRetryCount}, d = "invokeSuspend", e = "com.obric.agent.AppIntentIDLStub$setWifiEnabled$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f14160b;

        c(boolean r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14160b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f14160b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14159a;
            boolean r3 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            IntentResult r6 = (IntentResult) ZeusTransformUtils.preCheckCast(r7, IntentResult.class, "com.obric.aiagent.plugin");
            if (r6 != null) goto L14;
        L16:
            r3 = false;
        L18:
            return d.c.b.a.b.a(r3);
        L14:
            if (r6.getRet() != 0) goto L16;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            com.obric.agent.utils.b r8 = com.obric.agent.utils.b.f15994a;
            IntentParams r2 = (IntentParams) ZeusTransformUtils.preCheckCast(new SystemSwitchModeParams("wifi", d.c.b.a.b.a(this.f14160b)), IntentParams.class, "com.obric.aiagent.plugin");
            d.c.d<? super IntentResult<?>> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14159a = 1;
            r7 = r8.a("System_SwitchMode", r2, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AppIntentIDLStub.kt */
    public static final class d implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IScreenshotCallbackIDL f14161a;

        d(IScreenshotCallbackIDL r3) {
            this.f14161a = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.agent.t
        public void a(Uri r4) {
            d.h.b.o.e(r4, "uri");
            ILogDepend.Companion.i(IAgentAppIntentIDLSPI.TAG, "onTakeScreenshotUri " + r4);
            IScreenshotCallbackIDL r3 = this.f14161a;
            if (r3 == null) goto L6;
            r3.onReceivedScreenshotUri(r4);
            return;
        }

        @Override // com.obric.agent.t
        public void a(String r4) {
            d.h.b.o.e(r4, WsConstants.KEY_CONNECTION_ERROR);
            ILogDepend.Companion.i(IAgentAppIntentIDLSPI.TAG, "onTakeScreenshotError " + r4);
            IScreenshotCallbackIDL r3 = this.f14161a;
            if (r3 == null) goto L6;
            r3.onError(r4);
            return;
        }
    }

    /* JADX INFO: renamed from: lambda$-ua1al_P9vWC-VKuUcmcBsS2Yn8, reason: not valid java name */
    public static /* synthetic */ IAgentService m57lambda$ua1al_P9vWCVKuUcmcBsS2Yn8() {
        return service_delegate$lambda$0();
    }

    public static /* synthetic */ IFlowIntentActionService lambda$q7REguFc4qk7qm5xFiKMyGJoZeI() {
        return flowIntentService_delegate$lambda$1();
    }

    public AppIntentIDLStub() {
        this.service$delegate = d.g.a($$Lambda$AppIntentIDLStub$ua1al_P9vWCVKuUcmcBsS2Yn8.INSTANCE);
        this.flowIntentService$delegate = d.g.a($$Lambda$AppIntentIDLStub$q7REguFc4qk7qm5xFiKMyGJoZeI.INSTANCE);
    }

    public static final /* synthetic */ boolean access$parseWifiEnabled(AppIntentIDLStub r0, String r1) {
        return r0.parseWifiEnabled(r1);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return IAgentAppIntentIDLSPI.b.a(this);
    }

    private final IAgentService getService() {
        return (IAgentService) ZeusTransformUtils.preCheckCast(this.service$delegate.b(), IAgentService.class, "com.obric.aiagent.plugin");
    }

    private final IFlowIntentActionService getFlowIntentService() {
        return (IFlowIntentActionService) ZeusTransformUtils.preCheckCast(this.flowIntentService$delegate.b(), IFlowIntentActionService.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyUserAgreePrivacy() {
        IAgentService r0 = getService();
        if (r0 == null) goto L6;
        r0.notifyUserAgreePrivacy();
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void terminateService() {
        IAgentService r0 = getService();
        if (r0 == null) goto L6;
        r0.terminateService();
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCallHistory(CallHistoryEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showCallHistory(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showContact(ContactEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showContact(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlarm(AlarmEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showAlarm(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showNote(NoteEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showNote(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCountdown(CountdownEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showCountdown(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showWeather(String r1, String r2) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showWeather(r1, r2);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlbum(AlbumEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showAlbum(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showPhoto(PhotoEntity[] r1, int r2) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showPhoto(r1, r2);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showFile(FileEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showFile(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showRecording(RecordingEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showRecording(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMessage(MessageEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showMessage(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showSchedule(ScheduleEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showSchedule(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMemory(MemoryEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showMemory(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProactiveMemory(ProactiveMemoryEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showProactiveMemory(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void screenShot(IScreenshotCallbackIDL r3) {
        b r0 = new b((IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin"));
        IAgentService r2 = getService();
        if (r2 == null) goto L6;
        r2.screenShot((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public IntentDebugReport getIntentExecution(String r14) {
        d.h.b.o.e(r14, "messageId");
        IAgentService r13 = getService();
        if (r13 == null) goto L7;
        IntentDebugReport r15 = r13.getIntentExecution(r14);
        if (r15 == null) goto L7;
        return r15;
    L7:
        return new IntentDebugReport(null, null, null, null, null, null, null, null, null, null, DownloadErrorCode.ERROR_IO, null);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isAppIntentActive() {
        IIntentTraceService r2 = (IIntentTraceService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentTraceService.class), IIntentTraceService.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isAppIntentActive();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopComplexTask(String r3) {
        ILogDepend.Companion.i(IAgentAppIntentIDLSPI.TAG, "notifyStopComplexTask " + r3);
        IComplexTaskService r2 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.notifyStopComplexTask(r3, "user_stop_complex_task");
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void replyAskUser(String r5, String r6, String r7, Map<Object, Object> r8) {
        Map<Object, Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r9 = ILogDepend.Companion;
        StringBuilder r1 = new StringBuilder().append("replyAskUser ").append(r5).append(" content: ");
        Object r2 = null;
        if (r7 == null) goto L5;
        Integer r3 = Integer.valueOf(r7.length());
    L6:
        r9.i(IAgentAppIntentIDLSPI.TAG, r1.append(r3).toString());
        IComplexTaskService r10 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L9;
        r10.replyAskUser(r5, r6, r7, r4);
    L9:
        if (r4 == null) goto L12;
        r2 = r4.get("o_complex_task_ask_user_scene");
    L12:
        if (d.h.b.o.a(r2, "auto_gui_clarify") == false) goto L18;
        if (r7 == null) goto L19;
        IAutoActionService r11 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L20;
        r11.replyToAutoAction(r7);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAuditoryRecording(AuditoryRecordingEntity r1) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showAuditoryRecording(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callPhone(String r1, ContactEntity r2, String r3, String r4) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.callPhone(r1, r2, r3, r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void sendSms(String r1, ContactEntity r2, String r3, String r4) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.sendSms(r1, r2, r3, r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopAutoAction(String r3, String r4) {
        d.h.b.o.e(r4, "reason");
        IAutoActionService r2 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.notifyStopAutoAction(r3, r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyCloseAutoGUISwitch() {
        IAutoActionService r2 = (IAutoActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionService.class), IAutoActionService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.notifyCloseAutoGUISwitch();
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getComplexTaskPanelInfoFromPC(int r3) {
        IComplexTaskService r2 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        List<String> r4 = r2.getComplexTaskPanelInfoFromPC(r3);
        if (r4 == null) goto L7;
        return r4;
    L7:
        return d.a.p.b();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void jumpToSystemOtaPage() {
        Intent r3 = new Intent("android.intent.action.MAIN");
        r3.setFlags(805306368);
        r3.setClassName("com.android.settings", "com.android.settings.RouteActivity");
        r3.putExtra("route_target_page", "ota");
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void setDebugReferImg(String r1) {
        IAgentService r0 = getService();
        if (r0 == null) goto L6;
        r0.setDebugReferImg(r1);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void onLoginStateChange(boolean r4) {
        IDialogStateManager r3 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L5;
        r3.setLogin(r4);
    L5:
        ITaskManagerApi r5 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        r5.onLoginStateChange(r4);
    L8:
        IAccountService r6 = (IAccountService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAccountService.class), IAccountService.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        r6.notifyAccountStatusChanged(r4);
    L11:
        if (r4 == true) goto L25;
        IDialogStateManager r7 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L15;
        DMState r8 = r7.getCurrentDMState();
    L16:
        if (r8 == null) goto L31;
        List<State> r9 = r8.getActiveTasks();
        if (r9 == null) goto L32;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L21:
        if (r10.hasNext() == false) goto L33;
        State r11 = (State) ZeusTransformUtils.preCheckCast(r10.next(), State.class, "com.obric.aiagent.plugin");
        IDialogStateManager r0 = (IDialogStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDialogStateManager.class), IDialogStateManager.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L21;
        d.h.b.o.a(r11, "null cannot be cast to non-null type com.obric.assistant.dm.api.statemachine.core.TaskState");
        r0.cancelTask((TaskState) ZeusTransformUtils.preCheckCast(r11, TaskState.class, "com.obric.aiagent.plugin"));
        goto L21
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L15:
        r8 = null;
        goto L16
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProxyCallHistory(String r3) {
        IComplexTaskService r2 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.showProxyCallHistory(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<AppEntity> getAppEntityList(Map<?, ?> r3) {
        Map<String, ? extends List<String>> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        IAgentService r4 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        if (r2 != null) goto L7;
        r2 = null;
    L7:
        return r4.getAppEntityList(r2);
    L8:
        return null;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showLarkUrl(String r3) {
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.showLarkUrl(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyLarkSendStausChanged(String r3, int r4) {
        d.h.b.o.e(r3, "localMsgId");
        IAgentService r2 = (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.notifyLarkSendStatusChanged(r3, r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callShortLink(String r2) {
        d.h.b.o.e(r2, "data");
        IAgentService r1 = getService();
        if (r1 == null) goto L6;
        r1.callShortLink(r2);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void clearAllOmniTask(Map<Object, Object> r6) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L17;
        Iterator r8 = r5.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L17;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        String r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L10;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L11:
        if (r9 == null) goto L6;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L16;
        r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L16:
        r7.put(r9, r4);
        goto L6
    L10:
        r9 = null;
    L17:
        IComplexTaskService r10 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L26;
        r10.clearAllOmniTask(r7);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getOmniJournalPath(String r3) {
        IOAutoStateManager r2 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getOmniJournalPath(r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedback(String r3) {
        IOAutoStateManager r2 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.drainOmniUploadImagesForFeedback(r3);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithInfo(String r10, String r11, List<String> r12, String r13, boolean r14) {
        r r15 = resolveOmniUploadFeedbackPayload((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), null);
        drainOmniUploadImagesForFeedbackInternal(r10, r11, r15.a(), r15.getType(), r15.b(), r15.c(), r13, r14);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithType(String r10, String r11, List<String> r12, String r13) {
        r r14 = resolveOmniUploadFeedbackPayload((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), r13);
        drainOmniUploadImagesForFeedbackInternal(r10, r11, r14.a(), r14.getType(), r14.b(), r14.c(), null, true);
    }

    private final void drainOmniUploadImagesForFeedbackInternal(String r14, String r15, List<String> r16, String r17, String r18, Integer r19, String r20, boolean r21) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
        IOAutoStateManager r3 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r17 != null) goto L7;
    L9:
        String r8 = null;
    L10:
        if (r18 != null) goto L12;
    L14:
        String r9 = null;
    L15:
        if (r20 != null) goto L17;
    L19:
        String r10 = null;
    L20:
        r3.drainOmniUploadImagesForFeedback(r14, new IOAutoStateManager.b(r15, r7, r8, r9, r10, r21, r19));
        return;
    L17:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L19;
        r10 = r20;
        goto L20
    L12:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
        r9 = r18;
        goto L15
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
        r8 = r17;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final r resolveOmniUploadFeedbackPayload(List<String> r10, String r11) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        d.h.b.z.f r12 = new d.h.b.z.f();
        if (r11 == null) goto L7;
        boolean r2 = !d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin"));
        T r13 = r11;
        if (r2 == false) goto L7;
    L8:
        r12.f38504a = r13;
        d.h.b.z.f r14 = new d.h.b.z.f();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.assistant.idl.bean.c.f16269a.b(r9), Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L33;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");
        if (d.o.o.b(r6, "__omni_feedback_type=", false, 2, null) == false) goto L22;
        if (r12.f38504a != 0) goto L20;
        String r7 = d.o.o.a(r6, (CharSequence) ZeusTransformUtils.preCheckCast("__omni_feedback_type=", CharSequence.class, "com.obric.aiagent.plugin"));
        boolean r8 = Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"))).booleanValue();
        T r15 = r7;
        if (r8 == true) goto L19;
        r15 = 0;
    L19:
        r12.f38504a = r15;
    L20:
        r6 = null;
    L30:
        if (r6 == null) goto L10;
        r4.add(r6);
        goto L10
    L22:
        if (d.o.o.b(r6, "__omni_feedback_source=", false, 2, null) == false) goto L30;
        if (r14.f38504a != 0) goto L20;
        String r16 = d.o.o.a(r6, (CharSequence) ZeusTransformUtils.preCheckCast("__omni_feedback_source=", CharSequence.class, "com.obric.aiagent.plugin"));
        boolean r17 = Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.aiagent.plugin"))).booleanValue();
        T r18 = r16;
        if (r17 == true) goto L29;
        r18 = 0;
    L29:
        r14.f38504a = r18;
        goto L20
    L33:
        return new r((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r12.f38504a, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.f38504a, String.class, "com.obric.aiagent.plugin"), com.obric.aiagent.assistant.idl.bean.c.f16269a.a(r9));
    L7:
        r13 = 0;
        goto L8
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public Map<String, Object> getOmniExtraLog(String r3) {
        d.h.b.o.e(r3, "omniTaskId");
        IOAutoStateManager r2 = (IOAutoStateManager) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IOAutoStateManager.class), IOAutoStateManager.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getOmniExtraLog(r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void turnOnOffAlarm(AlarmEntity r2, boolean r3) {
        d.h.b.o.e(r2, "alarmEntity");
        IFlowIntentActionService r1 = getFlowIntentService();
        if (r1 == null) goto L6;
        r1.turnOnOffAlarm(r2, r3, null);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteEntities(AppEntity[] r3, IEntityDeleteCallbackIDL r4) {
        IEntityDeleteCallbackIDL r5 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r4, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        IFlowIntentActionService r2 = getFlowIntentService();
        if (r2 == null) goto L5;
        r2.deleteEntities(r3, r5);
        return;
    L5:
        if (r5 == null) goto L9;
        r5.onResult(1, "flow intent service is unavailable", new String[0]);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int playMusic(String r1, MusicEntity[] r2, MusicEntity r3) {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.playMusic(r1, r2, r3);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMusicPage() {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 == null) goto L6;
        r0.showMusicPage();
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int pauseMusic() {
        IFlowIntentActionService r0 = getFlowIntentService();
        if (r0 != null) goto L7;
        return 1;
    L7:
        return r0.pauseMusic();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void registerMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        IFlowIntentActionService r2 = getFlowIntentService();
        if (r2 == null) goto L6;
        r2.registerMusicStateListener(r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void unregisterMusicStateListener(IMusicStateListenerIDL r3) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r3, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        IFlowIntentActionService r2 = getFlowIntentService();
        if (r2 == null) goto L6;
        r2.unregisterMusicStateListener(r4);
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void takeScreenshot(IScreenshotCallbackIDL r3) {
        d r0 = new d((IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r3, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin"));
        IAgentService r2 = getService();
        if (r2 == null) goto L5;
        r2.takeScreenshotForScreenPerception((t) ZeusTransformUtils.preCheckCast(r0, t.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r0.a("agent service unavailable");
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean setWifiEnabled(boolean r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isWifiEnabled() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private final boolean parseWifiEnabled(String r4) {
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = true;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L23;
        return false;
    L23:
        JsonObject r6 = JsonParser.parseString(r4).getAsJsonObject().getAsJsonObject("wifi");     // Catch: Exception -> L20
        if (r6 == null) goto L18;
        JsonElement r7 = r6.get("enabled");     // Catch: Exception -> L20
        if (r7 == null) goto L18;
        if (r7.getAsBoolean() != true) goto L18;
    L25:
        return r0;
    L18:
        r0 = false;
    L20:
        e = move-exception;
        ILogDepend.Companion.w(IAgentAppIntentIDLSPI.TAG, "parse wifi state failed: " + e.getMessage());
        return false;
    L5:
        if (d.o.o.d(r3) == true) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteRecordings(RecordingEntity[] r7, boolean r8, IRecordingDeleteCallbackIDL r9) {
        final IRecordingDeleteCallbackIDL r10 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r9, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        if (r10 == null) goto L26;
        r10.onResult(103, "entities is empty");
        return;
    L26:
        return;
    L16:
        IFlowIntentActionService r6 = getFlowIntentService();
        if (r6 == null) goto L22;
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r7.length), Collection.class, "com.obric.aiagent.plugin");
        int r3 = r7.length;
        int r4 = 0;
    L19:
        if (r4 >= r3) goto L21;
        RecordingEntity r5 = r7[r4];
        d.h.b.o.a(r5, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppEntity");
        r1.add((AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.aiagent.plugin"));
        r4 = r4 + 1;
        goto L19
    L21:
        r6.deleteEntities((AppEntity[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new AppEntity[0]), AppEntity[].class, "com.obric.aiagent.plugin"), (IEntityDeleteCallbackIDL) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10), IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        if (r10 == null) goto L28;
        r10.onResult(1, "flow intent service is unavailable");
        return;
    L28:
        return;
    L5:
        if (r7.length != 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == true) goto L11;
        r2 = false;
        goto L12
    L7:
        r11 = false;
        goto L8
    }

    private static final IAgentService service_delegate$lambda$0() {
        return (IAgentService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAgentService.class), IAgentService.class, "com.obric.aiagent.plugin");
    }

    private static final IFlowIntentActionService flowIntentService_delegate$lambda$1() {
        return (IFlowIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IFlowIntentActionService.class), IFlowIntentActionService.class, "com.obric.aiagent.plugin");
    }
}
