package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogNotification$Builder;
import q7.C1825x;
import u7.C2042a;
import u7.i;
import u7.j;
import u7.r;
import u7.s;

/* loaded from: classes2.dex */
public final class Task$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Task$Builder(int i) {
        this();
    }

    public Task$Builder clearAgentTaskState() {
        copyOnWrite();
        r.D((r) this.instance);
        return this;
    }

    public Task$Builder clearId() {
        copyOnWrite();
        r.E((r) this.instance);
        return this;
    }

    public Task$Builder clearInputMessageState() {
        copyOnWrite();
        r.F((r) this.instance);
        return this;
    }

    public Task$Builder clearLlmResponse() {
        copyOnWrite();
        r.G((r) this.instance);
        return this;
    }

    public Task$Builder clearLogNotification() {
        copyOnWrite();
        r.H((r) this.instance);
        return this;
    }

    public Task$Builder clearOutput() {
        copyOnWrite();
        r.I((r) this.instance);
        return this;
    }

    public Task$Builder clearTaskError() {
        copyOnWrite();
        r.J((r) this.instance);
        return this;
    }

    public Task$Builder clearTimestamp() {
        copyOnWrite();
        r.K((r) this.instance);
        return this;
    }

    public C2042a getAgentTaskState() {
        return ((r) this.instance).Z();
    }

    public String getId() {
        return ((r) this.instance).b0();
    }

    public ByteString getIdBytes() {
        return ((r) this.instance).c0();
    }

    public i getInputMessageState() {
        return ((r) this.instance).d0();
    }

    public j getLlmResponse() {
        return ((r) this.instance).e0();
    }

    public C1825x getLogNotification() {
        return ((r) this.instance).f0();
    }

    public Task$OutputCase getOutputCase() {
        return ((r) this.instance).g0();
    }

    public s getTaskError() {
        return ((r) this.instance).h0();
    }

    public long getTimestamp() {
        return ((r) this.instance).i0();
    }

    public boolean hasAgentTaskState() {
        return ((r) this.instance).j0();
    }

    public boolean hasInputMessageState() {
        return ((r) this.instance).k0();
    }

    public boolean hasLlmResponse() {
        return ((r) this.instance).l0();
    }

    public boolean hasLogNotification() {
        return ((r) this.instance).m0();
    }

    public boolean hasTaskError() {
        return ((r) this.instance).n0();
    }

    public Task$Builder mergeAgentTaskState(C2042a c2042a) {
        copyOnWrite();
        r.L((r) this.instance, c2042a);
        return this;
    }

    public Task$Builder mergeInputMessageState(i iVar) {
        copyOnWrite();
        r.M((r) this.instance, iVar);
        return this;
    }

    public Task$Builder mergeLlmResponse(j jVar) {
        copyOnWrite();
        r.N((r) this.instance, jVar);
        return this;
    }

    public Task$Builder mergeLogNotification(C1825x c1825x) {
        copyOnWrite();
        r.O((r) this.instance, c1825x);
        return this;
    }

    public Task$Builder mergeTaskError(s sVar) {
        copyOnWrite();
        r.P((r) this.instance, sVar);
        return this;
    }

    public Task$Builder setAgentTaskState(C2042a c2042a) {
        copyOnWrite();
        r.Q((r) this.instance, c2042a);
        return this;
    }

    public Task$Builder setId(String str) {
        copyOnWrite();
        r.R((r) this.instance, str);
        return this;
    }

    public Task$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        r.S((r) this.instance, byteString);
        return this;
    }

    public Task$Builder setInputMessageState(i iVar) {
        copyOnWrite();
        r.T((r) this.instance, iVar);
        return this;
    }

    public Task$Builder setLlmResponse(j jVar) {
        copyOnWrite();
        r.U((r) this.instance, jVar);
        return this;
    }

    public Task$Builder setLogNotification(C1825x c1825x) {
        copyOnWrite();
        r.V((r) this.instance, c1825x);
        return this;
    }

    public Task$Builder setTaskError(s sVar) {
        copyOnWrite();
        r.W((r) this.instance, sVar);
        return this;
    }

    public Task$Builder setTimestamp(long j5) {
        copyOnWrite();
        r.X((r) this.instance, j5);
        return this;
    }

    private Task$Builder() {
        super(r.DEFAULT_INSTANCE);
    }

    public Task$Builder setAgentTaskState(AgentTaskStateNotification$Builder agentTaskStateNotification$Builder) {
        copyOnWrite();
        r.Q((r) this.instance, (C2042a) agentTaskStateNotification$Builder.k());
        return this;
    }

    public Task$Builder setInputMessageState(InputMessageStateNotification$Builder inputMessageStateNotification$Builder) {
        copyOnWrite();
        r.T((r) this.instance, (i) inputMessageStateNotification$Builder.k());
        return this;
    }

    public Task$Builder setLlmResponse(LLMResponse$Builder lLMResponse$Builder) {
        copyOnWrite();
        r.U((r) this.instance, (j) lLMResponse$Builder.k());
        return this;
    }

    public Task$Builder setLogNotification(LogNotification$Builder logNotification$Builder) {
        copyOnWrite();
        r.V((r) this.instance, (C1825x) logNotification$Builder.k());
        return this;
    }

    public Task$Builder setTaskError(TaskError$Builder taskError$Builder) {
        copyOnWrite();
        r.W((r) this.instance, (s) taskError$Builder.k());
        return this;
    }
}
