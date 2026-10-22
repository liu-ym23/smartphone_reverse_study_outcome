package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IntentDebugReport;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class AgentAppIntentIDLIpcWrapper implements IAgentAppIntentIDL {
    boolean log;
    final IAgentAppIntentIDL origin;

    AgentAppIntentIDLIpcWrapper(IAgentAppIntentIDL r3) {
        this((IAgentAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentAppIntentIDL.class, "com.obric.aiagent.plugin"), true);
    }

    AgentAppIntentIDLIpcWrapper(IAgentAppIntentIDL r3, boolean r4) {
        this.origin = (IAgentAppIntentIDL) ZeusTransformUtils.wrapperContextForParams(r3, IAgentAppIntentIDL.class, "com.obric.aiagent.plugin");
        this.log = r4;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyUserAgreePrivacy() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyUserAgreePrivacy();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyUserAgreePrivacy", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void terminateService() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "terminateService()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "terminateService() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "terminateService", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "terminateService()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "terminateService()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.terminateService();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "terminateService = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "terminateService() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "terminateService", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCallHistory(CallHistoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showCallHistory", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showCallHistory(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showCallHistory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showCallHistory(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showCallHistory", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showContact(ContactEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showContact(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showContact(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showContact", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showContact(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showContact(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showContact(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showContact = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showContact(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showContact", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlarm(AlarmEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlarm(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAlarm(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAlarm", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlarm(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlarm(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAlarm(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showAlarm = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAlarm(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAlarm", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showNote(NoteEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showNote(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showNote(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showNote", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showNote(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showNote(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showNote(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showNote = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showNote(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showNote", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCountdown(CountdownEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCountdown(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showCountdown(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showCountdown", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCountdown(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showCountdown(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showCountdown(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showCountdown = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showCountdown(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showCountdown", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlbum(AlbumEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlbum(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAlbum(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAlbum", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlbum(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAlbum(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAlbum(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showAlbum = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAlbum(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAlbum", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showPhoto(PhotoEntity[] r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showPhoto(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showPhoto(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showPhoto", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showPhoto(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showPhoto(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showPhoto(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showPhoto = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showPhoto(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showPhoto", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showFile(FileEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showFile(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showFile(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showFile", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showFile(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showFile(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showFile(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showFile = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showFile(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showFile", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showRecording(RecordingEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showRecording(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showRecording(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showRecording", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showRecording(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showRecording(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showRecording(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showRecording = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showRecording(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showRecording", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMessage(MessageEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMessage(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMessage(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMessage", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMessage(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMessage(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMessage(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showMessage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMessage(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMessage", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showSchedule(ScheduleEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showSchedule(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showSchedule(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showSchedule", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showSchedule(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showSchedule(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showSchedule(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showSchedule = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showSchedule(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showSchedule", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMemory(MemoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMemory(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMemory(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMemory", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMemory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMemory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMemory(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showMemory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMemory(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMemory", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void screenShot(IScreenshotCallbackIDL r21) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "screenShot(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "screenShot(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "screenShot", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "screenShot(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("screenShot(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IScreenshotCallbackIDL r15 = r4;
    L21:
        r12.a("IAgentAppIntentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L19;
        r15 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = bf.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IScreenshotCallbackIDL r7 = r4;
    L35:
        r13.screenShot(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "screenShot = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "screenShot(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "screenShot", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L33;
        r7 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = bf.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public IntentDebugReport getIntentExecution(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        IntentDebugReport r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getIntentExecution", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getIntentExecution(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "getIntentExecution = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getIntentExecution(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getIntentExecution", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isAppIntentActive() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isAppIntentActive()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "isAppIntentActive() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "isAppIntentActive", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isAppIntentActive()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isAppIntentActive()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isAppIntentActive();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "isAppIntentActive = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "isAppIntentActive() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "isAppIntentActive", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopComplexTask(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopComplexTask(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "notifyStopComplexTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyStopComplexTask", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void replyAskUser(String r33, String r34, String r35, Map r36) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = fail", r4, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "replyAskUser", r4, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.replyAskUser(r33, r34, r35, r8);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "replyAskUser = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "replyAskUser", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAuditoryRecording(AuditoryRecordingEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showAuditoryRecording(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showAuditoryRecording = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showAuditoryRecording", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callPhone(String r33, ContactEntity r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "callPhone", r5, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.callPhone(r33, r34, r35, r36);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "callPhone = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "callPhone", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProactiveMemory(ProactiveMemoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showProactiveMemory", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showProactiveMemory(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showProactiveMemory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showProactiveMemory(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showProactiveMemory", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopAutoAction(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyStopAutoAction(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "notifyStopAutoAction = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyStopAutoAction", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getComplexTaskPanelInfoFromPC(int r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        List<String> r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getComplexTaskPanelInfoFromPC(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getComplexTaskPanelInfoFromPC", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void jumpToSystemOtaPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.jumpToSystemOtaPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "jumpToSystemOtaPage", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void setDebugReferImg(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "setDebugReferImg", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.setDebugReferImg(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "setDebugReferImg = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "setDebugReferImg(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "setDebugReferImg", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyCloseAutoGUISwitch() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyCloseAutoGUISwitch();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyCloseAutoGUISwitch", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProxyCallHistory(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showProxyCallHistory(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showProxyCallHistory = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showProxyCallHistory", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void onLoginStateChange(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "onLoginStateChange", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onLoginStateChange(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "onLoginStateChange = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "onLoginStateChange(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "onLoginStateChange", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<AppEntity> getAppEntityList(Map r22) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
        List<AppEntity> r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getAppEntityList", r1, r6, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getAppEntityList(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "getAppEntityList = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getAppEntityList(" + r4 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getAppEntityList", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showLarkUrl(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showLarkUrl", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showLarkUrl(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showLarkUrl = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showLarkUrl(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showLarkUrl", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyLarkSendStausChanged(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.notifyLarkSendStausChanged(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "notifyLarkSendStausChanged", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callShortLink(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callShortLink(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "callShortLink(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "callShortLink", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callShortLink(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "callShortLink(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.callShortLink(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "callShortLink = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "callShortLink(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "callShortLink", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void clearAllOmniTask(Map r21) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r4 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r4 + ") = fail", r1, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask", r1, r6, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r4 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.clearAllOmniTask(r4);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "clearAllOmniTask = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask(" + r4 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "clearAllOmniTask", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getOmniJournalPath(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        List<String> r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getOmniJournalPath(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "getOmniJournalPath = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getOmniJournalPath", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedback(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r21 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r18 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r21 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback", r2, r4, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r21 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.drainOmniUploadImagesForFeedback(r21);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback(" + r21 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedback", r14, r17);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithInfo(String r29, String r30, List<String> r31, String r32, boolean r33) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L22:
        e = e;
        boolean r4 = r33;
        String r20 = ")";
    L24:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + r20, e);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L26
        long r26 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L26
        long r24 = Math.max(r5, r26 - r16) / 1000;     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = fail", r1, r24);     // Catch: Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo", r1, r24, r26);     // Catch: Throwable -> L26
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L22 Throwable -> L26
    L9:
        r20 = ")";
        this.origin.drainOmniUploadImagesForFeedbackWithInfo(r29, r30, r15, r32, r33);     // Catch: Exception -> L20 Throwable -> L26
        if (this.log == false) goto L14;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo = void");     // Catch: Exception -> L20 Throwable -> L26
    L14:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L20 Throwable -> L26
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L20 Throwable -> L26
        r4 = r33;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L18 Throwable -> L26
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithInfo", r0, r27);     // Catch: Exception -> L18 Throwable -> L26
        return;
    L18:
        e = e;
    L20:
        e = e;
        r4 = r33;
        r5 = 0;
        goto L24
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithType(String r33, String r34, List<String> r35, String r36) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ") = fail", r4, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType", r4, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.drainOmniUploadImagesForFeedbackWithType(r33, r34, r8, r36);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "drainOmniUploadImagesForFeedbackWithType", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public Map getOmniExtraLog(String r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        Map r11 = null;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.getOmniExtraLog(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "getOmniExtraLog = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "getOmniExtraLog", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void turnOnOffAlarm(AlarmEntity r22, boolean r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.turnOnOffAlarm(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "turnOnOffAlarm = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "turnOnOffAlarm", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0160: RETURN (r14 I:int) A[SYNTHETIC], block:B:28:? */
    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int playMusic(String r33, MusicEntity[] r34, MusicEntity r35) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L18:
        e = e;
        int r14 = 0;
    L20:
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ")", e);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L22
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L22
        long r28 = Math.max(0, r30 - r8) / 1000;     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ") = fail", r4, r28);     // Catch: Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "playMusic", r4, r28, r30);     // Catch: Throwable -> L22
        return r14;
    L17:
        return 0;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Throwable -> L17 Exception -> L18
    L9:
        r14 = this.origin.playMusic(r33, r34, r35);     // Catch: Throwable -> L17 Exception -> L18
    L15:
        e = e;
        goto L20
    L11:
        if (this.log == false) goto L13;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "playMusic = " + r14);     // Catch: Exception -> L15 Throwable -> L22
    L13:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L15 Throwable -> L22
        long r10 = Math.max(0, r22 - r8) / 1000;     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ") = " + r14, r10);     // Catch: Exception -> L15 Throwable -> L22
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "playMusic", r10, r22);     // Catch: Exception -> L15 Throwable -> L22
        return r14;
    L28:
        return r14;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMusicPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMusicPage()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r16 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMusicPage() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMusicPage", r1, r2, r16);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMusicPage()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showMusicPage()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showMusicPage();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showMusicPage = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showMusicPage() = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showMusicPage", r13, r15);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int pauseMusic() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        int r9 = 0;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "pauseMusic()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "pauseMusic() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "pauseMusic", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "pauseMusic()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "pauseMusic()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.pauseMusic();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "pauseMusic = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "pauseMusic() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "pauseMusic", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void registerMusicStateListener(IMusicStateListenerIDL r21) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("registerMusicStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IMusicStateListenerIDL r15 = r4;
    L21:
        r12.a("IAgentAppIntentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L19;
        r15 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = az.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IMusicStateListenerIDL r7 = r4;
    L35:
        r13.registerMusicStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "registerMusicStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "registerMusicStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L33;
        r7 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = az.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void unregisterMusicStateListener(IMusicStateListenerIDL r21) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("unregisterMusicStateListener(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IMusicStateListenerIDL r15 = r4;
    L21:
        r12.a("IAgentAppIntentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L19;
        r15 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = az.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IMusicStateListenerIDL r7 = r4;
    L35:
        r13.unregisterMusicStateListener(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "unregisterMusicStateListener = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "unregisterMusicStateListener", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L33;
        r7 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = az.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void takeScreenshot(IScreenshotCallbackIDL r21) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r4 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r5 = Math.max(0, r18 - r6) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r4 + ") = fail", r1, r5);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "takeScreenshot", r1, r5, r18);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r4 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r12 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r14 = new StringBuilder().append("takeScreenshot(");     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L12;
    L20:
        IScreenshotCallbackIDL r15 = r4;
    L21:
        r12.a("IAgentAppIntentIDLIPC", r14.append(r15).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L19;
        r15 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r15 = bf.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r13 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r4 != null) goto L26;
    L34:
        IScreenshotCallbackIDL r7 = r4;
    L35:
        r13.takeScreenshot(r7);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "takeScreenshot = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r16 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "takeScreenshot(" + r4 + ") = void", r16);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "takeScreenshot", r16, r17);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L33;
        r7 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r7 = bf.a(r4, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean setWifiEnabled(boolean r22) {
        long r5 = SystemClock.elapsedRealtimeNanos();
        boolean r11 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r22 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r4 = Math.max(0, r19 - r5) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r22 + ") = fail", r2, r4);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "setWifiEnabled", r2, r4, r19);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r22 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r11 = this.origin.setWifiEnabled(r22);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "setWifiEnabled = " + r11);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "setWifiEnabled(" + r22 + ") = " + r11, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "setWifiEnabled", r14, r18);     // Catch: Exception -> L14 Throwable -> L17
        return r11;
    L16:
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isWifiEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
        boolean r9 = false;
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isWifiEnabled()", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r2 = Math.max(0, r17 - r3) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "isWifiEnabled() = fail", r1, r2);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "isWifiEnabled", r1, r2, r17);     // Catch: Throwable -> L17
        goto L16
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isWifiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "isWifiEnabled()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        r9 = this.origin.isWifiEnabled();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "isWifiEnabled = " + r9);     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r3) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "isWifiEnabled() = " + r9, r14);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "isWifiEnabled", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return r9;
    L16:
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void sendSms(String r33, ContactEntity r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r30 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r28 = Math.max(0, r30 - r9) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "sendSms", r5, r28, r30);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.sendSms(r33, r34, r35, r36);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "sendSms = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "sendSms", r11, r22);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showWeather(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showWeather(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r6 = Math.max(0, r19 - r7) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showWeather(" + r22 + ", " + r23 + ") = fail", r3, r6);     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showWeather", r3, r6, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showWeather(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "showWeather(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.showWeather(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "showWeather = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "showWeather(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "showWeather", r13, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteRecordings(RecordingEntity[] r25, boolean r26, IRecordingDeleteCallbackIDL r27) {
        IRecordingDeleteCallbackIDL r7 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r27, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r25 + ", " + r26 + ", " + r7 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r8 = Math.max(0, r22 - r9) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r25 + ", " + r26 + ", " + r7 + ") = fail", r3, r8);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "deleteRecordings", r3, r8, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r25 + ", " + r26 + ", " + r7 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r11 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r15 = new StringBuilder().append("deleteRecordings(").append(r25).append(", ").append(r26).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L12;
    L20:
        IRecordingDeleteCallbackIDL r13 = r7;
    L21:
        r11.a("IAgentAppIntentIDLIPC", r15.append(r13).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, IRecordingDeleteCallbackIDL.Stub.class) == false) goto L19;
        r13 = bd.a((IRecordingDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRecordingDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r13 = bd.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r7 != null) goto L26;
    L34:
        IRecordingDeleteCallbackIDL r10 = r7;
    L35:
        r12.deleteRecordings(r25, r26, r10);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "deleteRecordings = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r14 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "deleteRecordings(" + r25 + ", " + r26 + ", " + r7 + ") = void", r14);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "deleteRecordings", r14, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L47
    L26:
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r7, IRecordingDeleteCallbackIDL.Stub.class) == false) goto L33;
        r10 = bd.a((IRecordingDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRecordingDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r10 = bd.a(r7, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteEntities(AppEntity[] r25, IEntityDeleteCallbackIDL r26) {
        IEntityDeleteCallbackIDL r6 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L40:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r25 + ", " + r6 + ")", e);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);     // Catch: Throwable -> L43
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L43
        long r7 = Math.max(0, r22 - r8) / 1000;     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r25 + ", " + r6 + ") = fail", r2, r7);     // Catch: Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "deleteEntities", r2, r7, r22);     // Catch: Throwable -> L43
        return;
    L4:
        if (this.log == false) goto L7;
        com.obric.aiagent.ipc.utils.j.f18676a.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L40 Throwable -> L43
    L7:
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j r14 = com.obric.aiagent.ipc.utils.j.f18676a;     // Catch: Exception -> L40 Throwable -> L43
        StringBuilder r10 = new StringBuilder().append("deleteEntities(").append(r25).append(", ");     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L12;
    L20:
        IEntityDeleteCallbackIDL r11 = r6;
    L21:
        r14.a("IAgentAppIntentIDLIPC", r10.append(r11).append(")").toString());     // Catch: Exception -> L40 Throwable -> L43
        goto L22
    L12:
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLIpcWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLStubWrapper.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r6, IEntityDeleteCallbackIDL.Stub.class) == false) goto L19;
        r11 = q.a((IEntityDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IEntityDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L21
    L19:
        r11 = q.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    L22:
        IAgentAppIntentIDL r12 = this.origin;     // Catch: Exception -> L40 Throwable -> L43
        if (r6 != null) goto L26;
    L34:
        IEntityDeleteCallbackIDL r9 = r6;
    L35:
        r12.deleteEntities(r25, r9);     // Catch: Exception -> L40 Throwable -> L43
        if (this.log == false) goto L38;
        com.obric.aiagent.ipc.utils.j.f18676a.c("IAgentAppIntentIDLIPC", "deleteEntities = void");     // Catch: Exception -> L40 Throwable -> L43
    L38:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L40 Throwable -> L43
        long r13 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.k.f18677a.a("IAgentAppIntentIDLIPC", "deleteEntities(" + r25 + ", " + r6 + ") = void", r13);     // Catch: Exception -> L40 Throwable -> L43
        com.obric.aiagent.ipc.utils.d.f18654a.a("IAgentAppIntentIDLIPC", "deleteEntities", r13, r21);     // Catch: Exception -> L40 Throwable -> L43
        return;
        goto L46
    L26:
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLIpcWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLStubWrapper.class) == true) goto L34;
        if (ZeusTransformUtils.instanceOf(r6, IEntityDeleteCallbackIDL.Stub.class) == false) goto L33;
        r9 = q.a((IEntityDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IEntityDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L40 Throwable -> L43
        goto L35
    L33:
        r9 = q.a(r6, true);     // Catch: Exception -> L40 Throwable -> L43
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }
}
