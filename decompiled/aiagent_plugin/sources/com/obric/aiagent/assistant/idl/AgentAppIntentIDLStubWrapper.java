package com.obric.aiagent.assistant.idl;

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
class AgentAppIntentIDLStubWrapper extends IAgentAppIntentIDL.Stub {
    boolean log;
    final IAgentAppIntentIDL.Stub origin;

    AgentAppIntentIDLStubWrapper(IAgentAppIntentIDL.Stub r2) {
        this(r2, true);
    }

    AgentAppIntentIDLStubWrapper(IAgentAppIntentIDL.Stub r1, boolean r2) {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyUserAgreePrivacy() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "notifyUserAgreePrivacy()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyUserAgreePrivacy();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "notifyUserAgreePrivacy = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyUserAgreePrivacy", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void terminateService() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "terminateService()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "terminateService() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "terminateService", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "terminateService()");     // Catch: Exception -> L11
    L6:
        this.origin.terminateService();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "terminateService = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "terminateService() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "terminateService", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCallHistory(CallHistoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showCallHistory(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showCallHistory(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showCallHistory", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showCallHistory(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showCallHistory(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showCallHistory = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showCallHistory(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showCallHistory", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showContact(ContactEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showContact(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showContact(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showContact", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showContact(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showContact(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showContact = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showContact(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showContact", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlarm(AlarmEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showAlarm(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAlarm(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAlarm", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showAlarm(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAlarm(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showAlarm = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAlarm(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAlarm", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showNote(NoteEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showNote(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showNote(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showNote", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showNote(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showNote(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showNote = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showNote(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showNote", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showCountdown(CountdownEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showCountdown(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showCountdown(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showCountdown", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showCountdown(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showCountdown(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showCountdown = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showCountdown(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showCountdown", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAlbum(AlbumEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showAlbum(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAlbum(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAlbum", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showAlbum(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAlbum(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showAlbum = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAlbum(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAlbum", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showPhoto(PhotoEntity[] r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showPhoto", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showPhoto(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showPhoto = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showPhoto(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showPhoto", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showFile(FileEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showFile(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showFile(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showFile", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showFile(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showFile(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showFile = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showFile(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showFile", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showRecording(RecordingEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showRecording(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showRecording(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showRecording", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showRecording(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showRecording(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showRecording = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showRecording(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showRecording", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMessage(MessageEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showMessage(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMessage(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMessage", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showMessage(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showMessage(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showMessage = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMessage(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMessage", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showSchedule(ScheduleEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showSchedule(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showSchedule(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showSchedule", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showSchedule(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showSchedule(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showSchedule = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showSchedule(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showSchedule", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMemory(MemoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showMemory(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMemory(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMemory", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showMemory(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showMemory(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showMemory = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMemory(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMemory", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void screenShot(IScreenshotCallbackIDL r21) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "screenShot(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "screenShot(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "screenShot", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "screenShot(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IScreenshotCallbackIDL r7 = r4;
    L19:
        r12.screenShot(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "screenShot = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "screenShot(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "screenShot", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L17;
        r7 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = bf.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public IntentDebugReport getIntentExecution(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "getIntentExecution(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getIntentExecution(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getIntentExecution", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "getIntentExecution(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        IntentDebugReport r11 = this.origin.getIntentExecution(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "getIntentExecution = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getIntentExecution(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getIntentExecution", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isAppIntentActive() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "isAppIntentActive()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "isAppIntentActive() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "isAppIntentActive", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "isAppIntentActive()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isAppIntentActive();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "isAppIntentActive = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "isAppIntentActive() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "isAppIntentActive", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopComplexTask(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyStopComplexTask", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopComplexTask(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "notifyStopComplexTask = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyStopComplexTask(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyStopComplexTask", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void replyAskUser(String r33, String r34, String r35, Map r36) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r36, Map.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = fail", r4, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "replyAskUser", r4, r28, r30);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.replyAskUser(r33, r34, r35, r8);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "replyAskUser = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "replyAskUser(" + r33 + ", " + r34 + ", " + r35 + ", " + r8 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "replyAskUser", r11, r22);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showAuditoryRecording(AuditoryRecordingEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showAuditoryRecording(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAuditoryRecording(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAuditoryRecording", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showAuditoryRecording(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showAuditoryRecording(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showAuditoryRecording = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showAuditoryRecording(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showAuditoryRecording", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callPhone(String r33, ContactEntity r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "callPhone", r5, r28, r30);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.callPhone(r33, r34, r35, r36);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "callPhone = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "callPhone(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "callPhone", r11, r22);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProactiveMemory(ProactiveMemoryEntity r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showProactiveMemory(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showProactiveMemory(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showProactiveMemory", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showProactiveMemory(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showProactiveMemory(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showProactiveMemory = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showProactiveMemory(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showProactiveMemory", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyStopAutoAction(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyStopAutoAction", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyStopAutoAction(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "notifyStopAutoAction = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyStopAutoAction(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyStopAutoAction", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getComplexTaskPanelInfoFromPC(int r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r11 = this.origin.getComplexTaskPanelInfoFromPC(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getComplexTaskPanelInfoFromPC", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void jumpToSystemOtaPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "jumpToSystemOtaPage()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage()");     // Catch: Exception -> L11
    L6:
        this.origin.jumpToSystemOtaPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "jumpToSystemOtaPage = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "jumpToSystemOtaPage", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void setDebugReferImg(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "setDebugReferImg(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "setDebugReferImg(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "setDebugReferImg", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "setDebugReferImg(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setDebugReferImg(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "setDebugReferImg = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "setDebugReferImg(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "setDebugReferImg", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyCloseAutoGUISwitch() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch()");     // Catch: Exception -> L11
    L6:
        this.origin.notifyCloseAutoGUISwitch();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyCloseAutoGUISwitch", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showProxyCallHistory(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showProxyCallHistory(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showProxyCallHistory(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showProxyCallHistory", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showProxyCallHistory(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showProxyCallHistory(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showProxyCallHistory = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showProxyCallHistory(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showProxyCallHistory", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void onLoginStateChange(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "onLoginStateChange(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "onLoginStateChange(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "onLoginStateChange", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "onLoginStateChange(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onLoginStateChange(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "onLoginStateChange = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "onLoginStateChange(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "onLoginStateChange", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<AppEntity> getAppEntityList(Map r21) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "getAppEntityList(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getAppEntityList(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getAppEntityList", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "getAppEntityList(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        List<AppEntity> r11 = this.origin.getAppEntityList(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "getAppEntityList = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getAppEntityList(" + r4 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getAppEntityList", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showLarkUrl(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showLarkUrl(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showLarkUrl(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showLarkUrl", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showLarkUrl(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showLarkUrl(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showLarkUrl = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showLarkUrl(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showLarkUrl", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void notifyLarkSendStausChanged(String r22, int r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyLarkSendStausChanged(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "notifyLarkSendStausChanged = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "notifyLarkSendStausChanged", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void callShortLink(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "callShortLink(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "callShortLink(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "callShortLink", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "callShortLink(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.callShortLink(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "callShortLink = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "callShortLink(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "callShortLink", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void clearAllOmniTask(Map r21) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.aiagent.plugin");
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "clearAllOmniTask(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "clearAllOmniTask(" + r4 + ") = fail", r1, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "clearAllOmniTask", r1, r6, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "clearAllOmniTask(" + r4 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.clearAllOmniTask(r4);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "clearAllOmniTask = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "clearAllOmniTask(" + r4 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "clearAllOmniTask", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public List<String> getOmniJournalPath(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "getOmniJournalPath(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getOmniJournalPath(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getOmniJournalPath", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "getOmniJournalPath(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        List<String> r11 = this.origin.getOmniJournalPath(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "getOmniJournalPath = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getOmniJournalPath(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getOmniJournalPath", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedback(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.drainOmniUploadImagesForFeedback(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback = void");     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback(" + r21 + ") = void", r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedback", r14, r17);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithInfo(String r29, String r30, List<String> r31, String r32, boolean r33) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r5 = 0;
    L19:
        e = e;
        boolean r4 = r33;
        String r20 = ")";
    L21:
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + r20, e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r26 = SystemClock.elapsedRealtimeNanos();
        long r24 = Math.max(r5, r26 - r16) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = fail", r1, r24);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo", r1, r24, r26);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r33 + ")");     // Catch: Exception -> L19
    L6:
        r20 = ")";
        this.origin.drainOmniUploadImagesForFeedbackWithInfo(r29, r30, r15, r32, r33);     // Catch: Exception -> L17
        if (this.log == false) goto L11;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo = void");     // Catch: Exception -> L17
    L11:
        long r27 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L17
        long r0 = Math.max(0, r27 - r16) / 1000;     // Catch: Exception -> L17
        r4 = r33;
        r5 = 0;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo(" + r29 + ", " + r30 + ", " + r15 + ", " + r32 + ", " + r4 + ") = void", r0);     // Catch: Exception -> L15
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithInfo", r0, r27);     // Catch: Exception -> L15
        return;
    L15:
        e = e;
    L17:
        e = e;
        r4 = r33;
        r5 = 0;
        goto L21
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void drainOmniUploadImagesForFeedbackWithType(String r33, String r34, List<String> r35, String r36) {
        List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ") = fail", r4, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType", r4, r28, r30);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.drainOmniUploadImagesForFeedbackWithType(r33, r34, r8, r36);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType(" + r33 + ", " + r34 + ", " + r8 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "drainOmniUploadImagesForFeedbackWithType", r11, r22);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public Map getOmniExtraLog(String r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "getOmniExtraLog(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getOmniExtraLog(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getOmniExtraLog", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "getOmniExtraLog(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        Map r11 = this.origin.getOmniExtraLog(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "getOmniExtraLog = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "getOmniExtraLog(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "getOmniExtraLog", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void turnOnOffAlarm(AlarmEntity r22, boolean r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "turnOnOffAlarm", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.turnOnOffAlarm(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "turnOnOffAlarm = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "turnOnOffAlarm(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "turnOnOffAlarm", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int playMusic(String r33, MusicEntity[] r34, MusicEntity r35) {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ")", e);
        com.obric.aiagent.ipc.utils.g r4 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ") = fail", r4, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "playMusic", r4, r28, r30);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ")");     // Catch: Exception -> L11
    L6:
        int r14 = this.origin.playMusic(r33, r34, r35);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "playMusic = " + r14);     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r10 = Math.max(0, r22 - r8) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "playMusic(" + r33 + ", " + r34 + ", " + r35 + ") = " + r14, r10);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "playMusic", r10, r22);     // Catch: Exception -> L11
        return r14;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showMusicPage() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showMusicPage()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMusicPage() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMusicPage", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showMusicPage()");     // Catch: Exception -> L11
    L6:
        this.origin.showMusicPage();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showMusicPage = void");     // Catch: Exception -> L11
    L9:
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r15 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showMusicPage() = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showMusicPage", r13, r15);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public int pauseMusic() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "pauseMusic()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "pauseMusic() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "pauseMusic", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "pauseMusic()");     // Catch: Exception -> L11
    L6:
        int r9 = this.origin.pauseMusic();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "pauseMusic = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "pauseMusic() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "pauseMusic", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void registerMusicStateListener(IMusicStateListenerIDL r21) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "registerMusicStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "registerMusicStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "registerMusicStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "registerMusicStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IMusicStateListenerIDL r7 = r4;
    L19:
        r12.registerMusicStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "registerMusicStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "registerMusicStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "registerMusicStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L17;
        r7 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = az.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void unregisterMusicStateListener(IMusicStateListenerIDL r21) {
        IMusicStateListenerIDL r4 = (IMusicStateListenerIDL) ZeusTransformUtils.wrapperContextForParams(r21, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "unregisterMusicStateListener", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IMusicStateListenerIDL r7 = r4;
    L19:
        r12.unregisterMusicStateListener(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "unregisterMusicStateListener = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "unregisterMusicStateListener(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "unregisterMusicStateListener", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, MusicStateListenerIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IMusicStateListenerIDL.Stub.class) == false) goto L17;
        r7 = az.a((IMusicStateListenerIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IMusicStateListenerIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = az.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void takeScreenshot(IScreenshotCallbackIDL r21) {
        IScreenshotCallbackIDL r4 = (IScreenshotCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r21, IScreenshotCallbackIDL.class, "com.obric.aiagent.plugin");
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "takeScreenshot(" + r4 + ")", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r5 = Math.max(0, r18 - r6) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "takeScreenshot(" + r4 + ") = fail", r1, r5);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "takeScreenshot", r1, r5, r18);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "takeScreenshot(" + r4 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r12 = this.origin;     // Catch: Exception -> L24
        if (r4 != null) goto L10;
    L18:
        IScreenshotCallbackIDL r7 = r4;
    L19:
        r12.takeScreenshot(r7);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "takeScreenshot = void");     // Catch: Exception -> L24
    L22:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r17 - r6) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "takeScreenshot(" + r4 + ") = void", r14);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "takeScreenshot", r14, r17);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, ScreenshotCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r4, IScreenshotCallbackIDL.Stub.class) == false) goto L17;
        r7 = bf.a((IScreenshotCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r4, IScreenshotCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r7 = bf.a(r4, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean setWifiEnabled(boolean r21) {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "setWifiEnabled(" + r21 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r4 = Math.max(0, r18 - r5) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "setWifiEnabled(" + r21 + ") = fail", r2, r4);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "setWifiEnabled", r2, r4, r18);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "setWifiEnabled(" + r21 + ")");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.setWifiEnabled(r21);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "setWifiEnabled = " + r11);     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r5) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "setWifiEnabled(" + r21 + ") = " + r11, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "setWifiEnabled", r14, r19);     // Catch: Exception -> L11
        return r11;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public boolean isWifiEnabled() {
        long r3 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "isWifiEnabled()", e);
        com.obric.aiagent.ipc.utils.g r1 = new com.obric.aiagent.ipc.utils.g(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r2 = Math.max(0, r16 - r3) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "isWifiEnabled() = fail", r1, r2);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "isWifiEnabled", r1, r2, r16);
        throw r1;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "isWifiEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r9 = this.origin.isWifiEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "isWifiEnabled = " + r9);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r17 - r3) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "isWifiEnabled() = " + r9, r14);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "isWifiEnabled", r14, r17);     // Catch: Exception -> L11
        return r9;
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void sendSms(String r33, ContactEntity r34, String r35, String r36) {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")", e);
        com.obric.aiagent.ipc.utils.g r5 = new com.obric.aiagent.ipc.utils.g(e);
        long r30 = SystemClock.elapsedRealtimeNanos();
        long r28 = Math.max(0, r30 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = fail", r5, r28);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "sendSms", r5, r28, r30);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.sendSms(r33, r34, r35, r36);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "sendSms = void");     // Catch: Exception -> L11
    L9:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "sendSms(" + r33 + ", " + r34 + ", " + r35 + ", " + r36 + ") = void", r11);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "sendSms", r11, r22);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void showWeather(String r22, String r23) {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r6 = Math.max(0, r19 - r7) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ") = fail", r3, r6);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showWeather", r3, r6, r19);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.showWeather(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "showWeather = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r13 = Math.max(0, r110 - r7) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "showWeather(" + r22 + ", " + r23 + ") = void", r13);     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "showWeather", r13, r110);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteRecordings(RecordingEntity[] r26, boolean r27, IRecordingDeleteCallbackIDL r28) {
        IRecordingDeleteCallbackIDL r7 = (IRecordingDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r28, IRecordingDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        long r9 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "deleteRecordings(" + r26 + ", " + r27 + ", " + r7 + ")", e);
        com.obric.aiagent.ipc.utils.g r3 = new com.obric.aiagent.ipc.utils.g(e);
        long r23 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r23 - r9) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "deleteRecordings(" + r26 + ", " + r27 + ", " + r7 + ") = fail", r3, r8);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "deleteRecordings", r3, r8, r23);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "deleteRecordings(" + r26 + ", " + r27 + ", " + r7 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r11 = this.origin;     // Catch: Exception -> L24
        if (r7 != null) goto L10;
    L18:
        IRecordingDeleteCallbackIDL r10 = r7;
    L19:
        r11.deleteRecordings(r26, r27, r10);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "deleteRecordings = void");     // Catch: Exception -> L24
    L22:
        long r22 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r12 = Math.max(0, r22 - r9) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "deleteRecordings(" + r26 + ", " + r27 + ", " + r7 + ") = void", r12);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "deleteRecordings", r12, r22);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, RecordingDeleteCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, IRecordingDeleteCallbackIDL.Stub.class) == false) goto L17;
        r10 = bd.a((IRecordingDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r7, IRecordingDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r10 = bd.a(r7, true);     // Catch: Exception -> L24
        goto L19
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentAppIntentIDL
    public void deleteEntities(AppEntity[] r25, IEntityDeleteCallbackIDL r26) {
        IEntityDeleteCallbackIDL r6 = (IEntityDeleteCallbackIDL) ZeusTransformUtils.wrapperContextForParams(r26, IEntityDeleteCallbackIDL.class, "com.obric.aiagent.plugin");
        long r8 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        com.obric.aiagent.ipc.utils.j.f18676a.a("AgentAppIntentIDLStub", "deleteEntities(" + r25 + ", " + r6 + ")", e);
        com.obric.aiagent.ipc.utils.g r2 = new com.obric.aiagent.ipc.utils.g(e);
        long r22 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r22 - r8) / 1000;
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "deleteEntities(" + r25 + ", " + r6 + ") = fail", r2, r7);
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "deleteEntities", r2, r7, r22);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        com.obric.aiagent.ipc.utils.j.f18676a.b("AgentAppIntentIDLStub", "deleteEntities(" + r25 + ", " + r6 + ")");     // Catch: Exception -> L24
    L6:
        IAgentAppIntentIDL.Stub r14 = this.origin;     // Catch: Exception -> L24
        if (r6 != null) goto L10;
    L18:
        IEntityDeleteCallbackIDL r9 = r6;
    L19:
        r14.deleteEntities(r25, r9);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        com.obric.aiagent.ipc.utils.j.f18676a.c("AgentAppIntentIDLStub", "deleteEntities = void");     // Catch: Exception -> L24
    L22:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r10 = Math.max(0, r21 - r8) / 1000;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.k.f18677a.b("AgentAppIntentIDLStub", "deleteEntities(" + r25 + ", " + r6 + ") = void", r10);     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.d.f18654a.b("AgentAppIntentIDLStub", "deleteEntities", r10, r21);     // Catch: Exception -> L24
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLIpcWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, EntityDeleteCallbackIDLStubWrapper.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r6, IEntityDeleteCallbackIDL.Stub.class) == false) goto L17;
        r9 = q.a((IEntityDeleteCallbackIDL.Stub) ZeusTransformUtils.preCheckCast(r6, IEntityDeleteCallbackIDL.Stub.class, "com.obric.aiagent.plugin"), true);     // Catch: Exception -> L24
        goto L19
    L17:
        r9 = q.a(r6, true);     // Catch: Exception -> L24
        goto L19
    }
}
