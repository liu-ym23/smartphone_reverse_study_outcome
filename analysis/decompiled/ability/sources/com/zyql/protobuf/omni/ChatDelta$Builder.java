package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Message$Builder;
import t7.C2020c;
import t7.C2023f;
import t7.i;
import t7.j;

/* loaded from: classes2.dex */
public final class ChatDelta$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatDelta$Builder(int i) {
        this();
    }

    public ChatDelta$Builder clearAudio() {
        copyOnWrite();
        C2023f.D((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearChatId() {
        copyOnWrite();
        C2023f.E((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearError() {
        copyOnWrite();
        C2023f.F((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearEventId() {
        copyOnWrite();
        C2023f.G((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearMessage() {
        copyOnWrite();
        C2023f.H((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearMessageDelta() {
        copyOnWrite();
        C2023f.I((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearMessageId() {
        copyOnWrite();
        C2023f.J((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearStatus() {
        copyOnWrite();
        C2023f.K((C2023f) this.instance);
        return this;
    }

    public ChatDelta$Builder clearTaskId() {
        copyOnWrite();
        C2023f.L((C2023f) this.instance);
        return this;
    }

    public C2020c getAudio() {
        return ((C2023f) this.instance).f0();
    }

    public String getChatId() {
        return ((C2023f) this.instance).g0();
    }

    public ByteString getChatIdBytes() {
        return ((C2023f) this.instance).h0();
    }

    public i getError() {
        return ((C2023f) this.instance).i0();
    }

    public String getEventId() {
        return ((C2023f) this.instance).j0();
    }

    public ByteString getEventIdBytes() {
        return ((C2023f) this.instance).k0();
    }

    public v7.i getMessage() {
        return ((C2023f) this.instance).l0();
    }

    public j getMessageDelta() {
        return ((C2023f) this.instance).m0();
    }

    public String getMessageId() {
        return ((C2023f) this.instance).n0();
    }

    public ByteString getMessageIdBytes() {
        return ((C2023f) this.instance).o0();
    }

    public TaskStatus getStatus() {
        return ((C2023f) this.instance).p0();
    }

    public int getStatusValue() {
        return ((C2023f) this.instance).q0();
    }

    public String getTaskId() {
        return ((C2023f) this.instance).r0();
    }

    public ByteString getTaskIdBytes() {
        return ((C2023f) this.instance).s0();
    }

    public boolean hasAudio() {
        return ((C2023f) this.instance).t0();
    }

    public boolean hasError() {
        return ((C2023f) this.instance).u0();
    }

    public boolean hasMessage() {
        return ((C2023f) this.instance).v0();
    }

    public boolean hasMessageDelta() {
        return ((C2023f) this.instance).w0();
    }

    public ChatDelta$Builder mergeAudio(C2020c c2020c) {
        copyOnWrite();
        C2023f.M((C2023f) this.instance, c2020c);
        return this;
    }

    public ChatDelta$Builder mergeError(i iVar) {
        copyOnWrite();
        C2023f.N((C2023f) this.instance, iVar);
        return this;
    }

    public ChatDelta$Builder mergeMessage(v7.i iVar) {
        copyOnWrite();
        C2023f.O((C2023f) this.instance, iVar);
        return this;
    }

    public ChatDelta$Builder mergeMessageDelta(j jVar) {
        copyOnWrite();
        C2023f.P((C2023f) this.instance, jVar);
        return this;
    }

    public ChatDelta$Builder setAudio(C2020c c2020c) {
        copyOnWrite();
        C2023f.Q((C2023f) this.instance, c2020c);
        return this;
    }

    public ChatDelta$Builder setChatId(String str) {
        copyOnWrite();
        C2023f.R((C2023f) this.instance, str);
        return this;
    }

    public ChatDelta$Builder setChatIdBytes(ByteString byteString) {
        copyOnWrite();
        C2023f.S((C2023f) this.instance, byteString);
        return this;
    }

    public ChatDelta$Builder setError(i iVar) {
        copyOnWrite();
        C2023f.T((C2023f) this.instance, iVar);
        return this;
    }

    public ChatDelta$Builder setEventId(String str) {
        copyOnWrite();
        C2023f.U((C2023f) this.instance, str);
        return this;
    }

    public ChatDelta$Builder setEventIdBytes(ByteString byteString) {
        copyOnWrite();
        C2023f.V((C2023f) this.instance, byteString);
        return this;
    }

    public ChatDelta$Builder setMessage(v7.i iVar) {
        copyOnWrite();
        C2023f.W((C2023f) this.instance, iVar);
        return this;
    }

    public ChatDelta$Builder setMessageDelta(j jVar) {
        copyOnWrite();
        C2023f.X((C2023f) this.instance, jVar);
        return this;
    }

    public ChatDelta$Builder setMessageId(String str) {
        copyOnWrite();
        C2023f.Y((C2023f) this.instance, str);
        return this;
    }

    public ChatDelta$Builder setMessageIdBytes(ByteString byteString) {
        copyOnWrite();
        C2023f.Z((C2023f) this.instance, byteString);
        return this;
    }

    public ChatDelta$Builder setStatus(TaskStatus taskStatus) {
        copyOnWrite();
        C2023f.a0((C2023f) this.instance, taskStatus);
        return this;
    }

    public ChatDelta$Builder setStatusValue(int i) {
        copyOnWrite();
        C2023f.b0((C2023f) this.instance, i);
        return this;
    }

    public ChatDelta$Builder setTaskId(String str) {
        copyOnWrite();
        C2023f.c0((C2023f) this.instance, str);
        return this;
    }

    public ChatDelta$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C2023f.d0((C2023f) this.instance, byteString);
        return this;
    }

    private ChatDelta$Builder() {
        super(C2023f.DEFAULT_INSTANCE);
    }

    public ChatDelta$Builder setAudio(Audio$Builder audio$Builder) {
        copyOnWrite();
        C2023f.Q((C2023f) this.instance, (C2020c) audio$Builder.k());
        return this;
    }

    public ChatDelta$Builder setError(Error$Builder error$Builder) {
        copyOnWrite();
        C2023f.T((C2023f) this.instance, (i) error$Builder.k());
        return this;
    }

    public ChatDelta$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        C2023f.W((C2023f) this.instance, (v7.i) message$Builder.k());
        return this;
    }

    public ChatDelta$Builder setMessageDelta(MessageDelta$Builder messageDelta$Builder) {
        copyOnWrite();
        C2023f.X((C2023f) this.instance, (j) messageDelta$Builder.k());
        return this;
    }
}
