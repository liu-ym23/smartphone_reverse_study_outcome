package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Content$Builder;
import java.util.Collections;
import java.util.List;
import q7.C1808f;
import u7.f;
import u7.q;

/* loaded from: classes2.dex */
public final class StartAgentRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StartAgentRequest$Builder(int i) {
        this();
    }

    public StartAgentRequest$Builder addAllMessages(Iterable<? extends C1808f> iterable) {
        copyOnWrite();
        q.D((q) this.instance, iterable);
        return this;
    }

    public StartAgentRequest$Builder addMessages(C1808f c1808f) {
        copyOnWrite();
        q.F((q) this.instance, c1808f);
        return this;
    }

    public StartAgentRequest$Builder clearAgentId() {
        copyOnWrite();
        q.G((q) this.instance);
        return this;
    }

    public StartAgentRequest$Builder clearMessages() {
        copyOnWrite();
        q.H((q) this.instance);
        return this;
    }

    public StartAgentRequest$Builder clearMetadata() {
        copyOnWrite();
        q.I((q) this.instance);
        return this;
    }

    public StartAgentRequest$Builder clearOptions() {
        copyOnWrite();
        q.J((q) this.instance);
        return this;
    }

    public StartAgentRequest$Builder clearSessionId() {
        copyOnWrite();
        q.K((q) this.instance);
        return this;
    }

    public StartAgentRequest$Builder clearUserId() {
        copyOnWrite();
        q.L((q) this.instance);
        return this;
    }

    public String getAgentId() {
        return ((q) this.instance).Z();
    }

    public ByteString getAgentIdBytes() {
        return ((q) this.instance).a0();
    }

    public C1808f getMessages(int i) {
        return ((q) this.instance).c0(i);
    }

    public int getMessagesCount() {
        return ((q) this.instance).d0();
    }

    public List<C1808f> getMessagesList() {
        return Collections.unmodifiableList(((q) this.instance).e0());
    }

    public Struct getMetadata() {
        return ((q) this.instance).f0();
    }

    public f getOptions() {
        return ((q) this.instance).g0();
    }

    public String getSessionId() {
        return ((q) this.instance).h0();
    }

    public ByteString getSessionIdBytes() {
        return ((q) this.instance).i0();
    }

    public String getUserId() {
        return ((q) this.instance).j0();
    }

    public ByteString getUserIdBytes() {
        return ((q) this.instance).k0();
    }

    public boolean hasMetadata() {
        return ((q) this.instance).l0();
    }

    public boolean hasOptions() {
        return ((q) this.instance).m0();
    }

    public boolean hasSessionId() {
        return ((q) this.instance).n0();
    }

    public StartAgentRequest$Builder mergeMetadata(Struct struct) {
        copyOnWrite();
        q qVar = (q) this.instance;
        int i = q.AGENT_ID_FIELD_NUMBER;
        qVar.o0(struct);
        return this;
    }

    public StartAgentRequest$Builder mergeOptions(f fVar) {
        copyOnWrite();
        q.M((q) this.instance, fVar);
        return this;
    }

    public StartAgentRequest$Builder removeMessages(int i) {
        copyOnWrite();
        q.N((q) this.instance, i);
        return this;
    }

    public StartAgentRequest$Builder setAgentId(String str) {
        copyOnWrite();
        q.O((q) this.instance, str);
        return this;
    }

    public StartAgentRequest$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        q.P((q) this.instance, byteString);
        return this;
    }

    public StartAgentRequest$Builder setMessages(int i, C1808f c1808f) {
        copyOnWrite();
        q.Q((q) this.instance, i, c1808f);
        return this;
    }

    public StartAgentRequest$Builder setMetadata(Struct struct) {
        copyOnWrite();
        q.R((q) this.instance, struct);
        return this;
    }

    public StartAgentRequest$Builder setOptions(f fVar) {
        copyOnWrite();
        q.S((q) this.instance, fVar);
        return this;
    }

    public StartAgentRequest$Builder setSessionId(String str) {
        copyOnWrite();
        q.T((q) this.instance, str);
        return this;
    }

    public StartAgentRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        q.U((q) this.instance, byteString);
        return this;
    }

    public StartAgentRequest$Builder setUserId(String str) {
        copyOnWrite();
        q.V((q) this.instance, str);
        return this;
    }

    public StartAgentRequest$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        q.W((q) this.instance, byteString);
        return this;
    }

    private StartAgentRequest$Builder() {
        super(q.DEFAULT_INSTANCE);
    }

    public StartAgentRequest$Builder addMessages(int i, C1808f c1808f) {
        copyOnWrite();
        q.E((q) this.instance, i, c1808f);
        return this;
    }

    public StartAgentRequest$Builder setMessages(int i, Content$Builder content$Builder) {
        copyOnWrite();
        q.Q((q) this.instance, i, (C1808f) content$Builder.k());
        return this;
    }

    public StartAgentRequest$Builder setMetadata(C1014y2 c1014y2) {
        copyOnWrite();
        q.R((q) this.instance, (Struct) c1014y2.k());
        return this;
    }

    public StartAgentRequest$Builder setOptions(ExecutionOptions$Builder executionOptions$Builder) {
        copyOnWrite();
        q.S((q) this.instance, (f) executionOptions$Builder.k());
        return this;
    }

    public StartAgentRequest$Builder addMessages(Content$Builder content$Builder) {
        copyOnWrite();
        q.F((q) this.instance, (C1808f) content$Builder.k());
        return this;
    }

    public StartAgentRequest$Builder addMessages(int i, Content$Builder content$Builder) {
        copyOnWrite();
        q.E((q) this.instance, i, (C1808f) content$Builder.k());
        return this;
    }
}
