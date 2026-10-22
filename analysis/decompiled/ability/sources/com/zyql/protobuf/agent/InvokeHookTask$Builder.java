package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.AgentCompleteHookData$Builder;
import com.zyql.protobuf.common.AgentStartHookData$Builder;
import com.zyql.protobuf.common.HandoffPostHookData$Builder;
import com.zyql.protobuf.common.HandoffPreHookData$Builder;
import com.zyql.protobuf.common.MessagePostHookData$Builder;
import com.zyql.protobuf.common.MessagePreHookData$Builder;
import com.zyql.protobuf.common.ModelCallPostHookData$Builder;
import com.zyql.protobuf.common.ModelCallPreHookData$Builder;
import com.zyql.protobuf.common.SessionEndHookData$Builder;
import com.zyql.protobuf.common.SessionStartHookData$Builder;
import com.zyql.protobuf.common.ToolCallErrorHookData$Builder;
import com.zyql.protobuf.common.ToolCallPostHookData$Builder;
import com.zyql.protobuf.common.ToolCallPreHookData$Builder;
import o7.s;
import q7.B;
import q7.C1804b;
import q7.C1806d;
import q7.C1813k;
import q7.C1815m;
import q7.C1827z;
import q7.D;
import q7.F;
import q7.K;
import q7.M;
import q7.a0;
import q7.c0;
import q7.e0;

/* loaded from: classes2.dex */
public final class InvokeHookTask$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ InvokeHookTask$Builder(int i) {
        this();
    }

    public InvokeHookTask$Builder clearAgentComplete() {
        copyOnWrite();
        s.D((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearAgentStart() {
        copyOnWrite();
        s.E((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearHandoffPost() {
        copyOnWrite();
        s.F((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearHandoffPre() {
        copyOnWrite();
        s.G((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearHookData() {
        copyOnWrite();
        s.H((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearMessagePost() {
        copyOnWrite();
        s.I((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearMessagePre() {
        copyOnWrite();
        s.J((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearModelCallPost() {
        copyOnWrite();
        s.K((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearModelCallPre() {
        copyOnWrite();
        s.L((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearSessionEnd() {
        copyOnWrite();
        s.M((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearSessionStart() {
        copyOnWrite();
        s.N((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearTaskId() {
        copyOnWrite();
        s.O((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearToolCallError() {
        copyOnWrite();
        s.P((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearToolCallPost() {
        copyOnWrite();
        s.Q((s) this.instance);
        return this;
    }

    public InvokeHookTask$Builder clearToolCallPre() {
        copyOnWrite();
        s.R((s) this.instance);
        return this;
    }

    public C1804b getAgentComplete() {
        return ((s) this.instance).v0();
    }

    public C1806d getAgentStart() {
        return ((s) this.instance).w0();
    }

    public C1813k getHandoffPost() {
        return ((s) this.instance).y0();
    }

    public C1815m getHandoffPre() {
        return ((s) this.instance).z0();
    }

    public InvokeHookTask$HookDataCase getHookDataCase() {
        return ((s) this.instance).A0();
    }

    public C1827z getMessagePost() {
        return ((s) this.instance).B0();
    }

    public B getMessagePre() {
        return ((s) this.instance).C0();
    }

    public D getModelCallPost() {
        return ((s) this.instance).D0();
    }

    public F getModelCallPre() {
        return ((s) this.instance).E0();
    }

    public K getSessionEnd() {
        return ((s) this.instance).F0();
    }

    public M getSessionStart() {
        return ((s) this.instance).G0();
    }

    public String getTaskId() {
        return ((s) this.instance).H0();
    }

    public ByteString getTaskIdBytes() {
        return ((s) this.instance).I0();
    }

    public a0 getToolCallError() {
        return ((s) this.instance).J0();
    }

    public c0 getToolCallPost() {
        return ((s) this.instance).K0();
    }

    public e0 getToolCallPre() {
        return ((s) this.instance).L0();
    }

    public boolean hasAgentComplete() {
        return ((s) this.instance).M0();
    }

    public boolean hasAgentStart() {
        return ((s) this.instance).N0();
    }

    public boolean hasHandoffPost() {
        return ((s) this.instance).O0();
    }

    public boolean hasHandoffPre() {
        return ((s) this.instance).P0();
    }

    public boolean hasMessagePost() {
        return ((s) this.instance).Q0();
    }

    public boolean hasMessagePre() {
        return ((s) this.instance).R0();
    }

    public boolean hasModelCallPost() {
        return ((s) this.instance).S0();
    }

    public boolean hasModelCallPre() {
        return ((s) this.instance).T0();
    }

    public boolean hasSessionEnd() {
        return ((s) this.instance).U0();
    }

    public boolean hasSessionStart() {
        return ((s) this.instance).V0();
    }

    public boolean hasToolCallError() {
        return ((s) this.instance).W0();
    }

    public boolean hasToolCallPost() {
        return ((s) this.instance).X0();
    }

    public boolean hasToolCallPre() {
        return ((s) this.instance).Y0();
    }

    public InvokeHookTask$Builder mergeAgentComplete(C1804b c1804b) {
        copyOnWrite();
        s.S((s) this.instance, c1804b);
        return this;
    }

    public InvokeHookTask$Builder mergeAgentStart(C1806d c1806d) {
        copyOnWrite();
        s.T((s) this.instance, c1806d);
        return this;
    }

    public InvokeHookTask$Builder mergeHandoffPost(C1813k c1813k) {
        copyOnWrite();
        s.U((s) this.instance, c1813k);
        return this;
    }

    public InvokeHookTask$Builder mergeHandoffPre(C1815m c1815m) {
        copyOnWrite();
        s.V((s) this.instance, c1815m);
        return this;
    }

    public InvokeHookTask$Builder mergeMessagePost(C1827z c1827z) {
        copyOnWrite();
        s.W((s) this.instance, c1827z);
        return this;
    }

    public InvokeHookTask$Builder mergeMessagePre(B b) {
        copyOnWrite();
        s.X((s) this.instance, b);
        return this;
    }

    public InvokeHookTask$Builder mergeModelCallPost(D d) {
        copyOnWrite();
        s.Y((s) this.instance, d);
        return this;
    }

    public InvokeHookTask$Builder mergeModelCallPre(F f) {
        copyOnWrite();
        s.Z((s) this.instance, f);
        return this;
    }

    public InvokeHookTask$Builder mergeSessionEnd(K k) {
        copyOnWrite();
        s.a0((s) this.instance, k);
        return this;
    }

    public InvokeHookTask$Builder mergeSessionStart(M m) {
        copyOnWrite();
        s.b0((s) this.instance, m);
        return this;
    }

    public InvokeHookTask$Builder mergeToolCallError(a0 a0Var) {
        copyOnWrite();
        s.c0((s) this.instance, a0Var);
        return this;
    }

    public InvokeHookTask$Builder mergeToolCallPost(c0 c0Var) {
        copyOnWrite();
        s.d0((s) this.instance, c0Var);
        return this;
    }

    public InvokeHookTask$Builder mergeToolCallPre(e0 e0Var) {
        copyOnWrite();
        s.e0((s) this.instance, e0Var);
        return this;
    }

    public InvokeHookTask$Builder setAgentComplete(C1804b c1804b) {
        copyOnWrite();
        s.f0((s) this.instance, c1804b);
        return this;
    }

    public InvokeHookTask$Builder setAgentStart(C1806d c1806d) {
        copyOnWrite();
        s.g0((s) this.instance, c1806d);
        return this;
    }

    public InvokeHookTask$Builder setHandoffPost(C1813k c1813k) {
        copyOnWrite();
        s.h0((s) this.instance, c1813k);
        return this;
    }

    public InvokeHookTask$Builder setHandoffPre(C1815m c1815m) {
        copyOnWrite();
        s.i0((s) this.instance, c1815m);
        return this;
    }

    public InvokeHookTask$Builder setMessagePost(C1827z c1827z) {
        copyOnWrite();
        s.j0((s) this.instance, c1827z);
        return this;
    }

    public InvokeHookTask$Builder setMessagePre(B b) {
        copyOnWrite();
        s.k0((s) this.instance, b);
        return this;
    }

    public InvokeHookTask$Builder setModelCallPost(D d) {
        copyOnWrite();
        s.l0((s) this.instance, d);
        return this;
    }

    public InvokeHookTask$Builder setModelCallPre(F f) {
        copyOnWrite();
        s.m0((s) this.instance, f);
        return this;
    }

    public InvokeHookTask$Builder setSessionEnd(K k) {
        copyOnWrite();
        s.n0((s) this.instance, k);
        return this;
    }

    public InvokeHookTask$Builder setSessionStart(M m) {
        copyOnWrite();
        s.o0((s) this.instance, m);
        return this;
    }

    public InvokeHookTask$Builder setTaskId(String str) {
        copyOnWrite();
        s.p0((s) this.instance, str);
        return this;
    }

    public InvokeHookTask$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        s.q0((s) this.instance, byteString);
        return this;
    }

    public InvokeHookTask$Builder setToolCallError(a0 a0Var) {
        copyOnWrite();
        s.r0((s) this.instance, a0Var);
        return this;
    }

    public InvokeHookTask$Builder setToolCallPost(c0 c0Var) {
        copyOnWrite();
        s.s0((s) this.instance, c0Var);
        return this;
    }

    public InvokeHookTask$Builder setToolCallPre(e0 e0Var) {
        copyOnWrite();
        s.t0((s) this.instance, e0Var);
        return this;
    }

    private InvokeHookTask$Builder() {
        super(s.DEFAULT_INSTANCE);
    }

    public InvokeHookTask$Builder setAgentComplete(AgentCompleteHookData$Builder agentCompleteHookData$Builder) {
        copyOnWrite();
        s.f0((s) this.instance, (C1804b) agentCompleteHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setAgentStart(AgentStartHookData$Builder agentStartHookData$Builder) {
        copyOnWrite();
        s.g0((s) this.instance, (C1806d) agentStartHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setHandoffPost(HandoffPostHookData$Builder handoffPostHookData$Builder) {
        copyOnWrite();
        s.h0((s) this.instance, (C1813k) handoffPostHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setHandoffPre(HandoffPreHookData$Builder handoffPreHookData$Builder) {
        copyOnWrite();
        s.i0((s) this.instance, (C1815m) handoffPreHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setMessagePost(MessagePostHookData$Builder messagePostHookData$Builder) {
        copyOnWrite();
        s.j0((s) this.instance, (C1827z) messagePostHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setMessagePre(MessagePreHookData$Builder messagePreHookData$Builder) {
        copyOnWrite();
        s.k0((s) this.instance, (B) messagePreHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setModelCallPost(ModelCallPostHookData$Builder modelCallPostHookData$Builder) {
        copyOnWrite();
        s.l0((s) this.instance, (D) modelCallPostHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setModelCallPre(ModelCallPreHookData$Builder modelCallPreHookData$Builder) {
        copyOnWrite();
        s.m0((s) this.instance, (F) modelCallPreHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setSessionEnd(SessionEndHookData$Builder sessionEndHookData$Builder) {
        copyOnWrite();
        s.n0((s) this.instance, (K) sessionEndHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setSessionStart(SessionStartHookData$Builder sessionStartHookData$Builder) {
        copyOnWrite();
        s.o0((s) this.instance, (M) sessionStartHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setToolCallError(ToolCallErrorHookData$Builder toolCallErrorHookData$Builder) {
        copyOnWrite();
        s.r0((s) this.instance, (a0) toolCallErrorHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setToolCallPost(ToolCallPostHookData$Builder toolCallPostHookData$Builder) {
        copyOnWrite();
        s.s0((s) this.instance, (c0) toolCallPostHookData$Builder.k());
        return this;
    }

    public InvokeHookTask$Builder setToolCallPre(ToolCallPreHookData$Builder toolCallPreHookData$Builder) {
        copyOnWrite();
        s.t0((s) this.instance, (e0) toolCallPreHookData$Builder.k());
        return this;
    }
}
