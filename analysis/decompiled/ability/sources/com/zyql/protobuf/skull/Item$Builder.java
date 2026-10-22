package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.C2064c;
import v7.f;
import v7.g;
import v7.h;
import v7.i;
import v7.v;

/* loaded from: classes2.dex */
public final class Item$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Item$Builder(int i) {
        this();
    }

    public Item$Builder clearAskInput() {
        copyOnWrite();
        h.D((h) this.instance);
        return this;
    }

    public Item$Builder clearData() {
        copyOnWrite();
        h.E((h) this.instance);
        return this;
    }

    public Item$Builder clearHandoff() {
        copyOnWrite();
        h.F((h) this.instance);
        return this;
    }

    public Item$Builder clearInterrupt() {
        copyOnWrite();
        h.G((h) this.instance);
        return this;
    }

    public Item$Builder clearItemId() {
        copyOnWrite();
        h.H((h) this.instance);
        return this;
    }

    public Item$Builder clearMessage() {
        copyOnWrite();
        h.I((h) this.instance);
        return this;
    }

    public Item$Builder clearStatus() {
        copyOnWrite();
        h.J((h) this.instance);
        return this;
    }

    public Item$Builder clearTaskId() {
        copyOnWrite();
        h.K((h) this.instance);
        return this;
    }

    public Item$Builder clearToolCall() {
        copyOnWrite();
        h.L((h) this.instance);
        return this;
    }

    public Item$Builder clearType() {
        copyOnWrite();
        h.M((h) this.instance);
        return this;
    }

    public C2064c getAskInput() {
        return ((h) this.instance).g0();
    }

    public Item$DataCase getDataCase() {
        return ((h) this.instance).h0();
    }

    public f getHandoff() {
        return ((h) this.instance).j0();
    }

    public g getInterrupt() {
        return ((h) this.instance).k0();
    }

    public String getItemId() {
        return ((h) this.instance).l0();
    }

    public ByteString getItemIdBytes() {
        return ((h) this.instance).m0();
    }

    public i getMessage() {
        return ((h) this.instance).n0();
    }

    public String getStatus() {
        return ((h) this.instance).o0();
    }

    public ByteString getStatusBytes() {
        return ((h) this.instance).p0();
    }

    public String getTaskId() {
        return ((h) this.instance).q0();
    }

    public ByteString getTaskIdBytes() {
        return ((h) this.instance).r0();
    }

    public v getToolCall() {
        return ((h) this.instance).s0();
    }

    public String getType() {
        return ((h) this.instance).t0();
    }

    public ByteString getTypeBytes() {
        return ((h) this.instance).u0();
    }

    public boolean hasAskInput() {
        return ((h) this.instance).v0();
    }

    public boolean hasHandoff() {
        return ((h) this.instance).w0();
    }

    public boolean hasInterrupt() {
        return ((h) this.instance).x0();
    }

    public boolean hasMessage() {
        return ((h) this.instance).y0();
    }

    public boolean hasToolCall() {
        return ((h) this.instance).z0();
    }

    public Item$Builder mergeAskInput(C2064c c2064c) {
        copyOnWrite();
        h.N((h) this.instance, c2064c);
        return this;
    }

    public Item$Builder mergeHandoff(f fVar) {
        copyOnWrite();
        h.O((h) this.instance, fVar);
        return this;
    }

    public Item$Builder mergeInterrupt(g gVar) {
        copyOnWrite();
        h.P((h) this.instance, gVar);
        return this;
    }

    public Item$Builder mergeMessage(i iVar) {
        copyOnWrite();
        h.Q((h) this.instance, iVar);
        return this;
    }

    public Item$Builder mergeToolCall(v vVar) {
        copyOnWrite();
        h.R((h) this.instance, vVar);
        return this;
    }

    public Item$Builder setAskInput(C2064c c2064c) {
        copyOnWrite();
        h.S((h) this.instance, c2064c);
        return this;
    }

    public Item$Builder setHandoff(f fVar) {
        copyOnWrite();
        h.T((h) this.instance, fVar);
        return this;
    }

    public Item$Builder setInterrupt(g gVar) {
        copyOnWrite();
        h.U((h) this.instance, gVar);
        return this;
    }

    public Item$Builder setItemId(String str) {
        copyOnWrite();
        h.V((h) this.instance, str);
        return this;
    }

    public Item$Builder setItemIdBytes(ByteString byteString) {
        copyOnWrite();
        h.W((h) this.instance, byteString);
        return this;
    }

    public Item$Builder setMessage(i iVar) {
        copyOnWrite();
        h.X((h) this.instance, iVar);
        return this;
    }

    public Item$Builder setStatus(String str) {
        copyOnWrite();
        h.Y((h) this.instance, str);
        return this;
    }

    public Item$Builder setStatusBytes(ByteString byteString) {
        copyOnWrite();
        h.Z((h) this.instance, byteString);
        return this;
    }

    public Item$Builder setTaskId(String str) {
        copyOnWrite();
        h.a0((h) this.instance, str);
        return this;
    }

    public Item$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        h.b0((h) this.instance, byteString);
        return this;
    }

    public Item$Builder setToolCall(v vVar) {
        copyOnWrite();
        h.c0((h) this.instance, vVar);
        return this;
    }

    public Item$Builder setType(String str) {
        copyOnWrite();
        h.d0((h) this.instance, str);
        return this;
    }

    public Item$Builder setTypeBytes(ByteString byteString) {
        copyOnWrite();
        h.e0((h) this.instance, byteString);
        return this;
    }

    private Item$Builder() {
        super(h.DEFAULT_INSTANCE);
    }

    public Item$Builder setAskInput(AskInput$Builder askInput$Builder) {
        copyOnWrite();
        h.S((h) this.instance, (C2064c) askInput$Builder.k());
        return this;
    }

    public Item$Builder setHandoff(Handoff$Builder handoff$Builder) {
        copyOnWrite();
        h.T((h) this.instance, (f) handoff$Builder.k());
        return this;
    }

    public Item$Builder setInterrupt(Interrupt$Builder interrupt$Builder) {
        copyOnWrite();
        h.U((h) this.instance, (g) interrupt$Builder.k());
        return this;
    }

    public Item$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        h.X((h) this.instance, (i) message$Builder.k());
        return this;
    }

    public Item$Builder setToolCall(ToolCall$Builder toolCall$Builder) {
        copyOnWrite();
        h.c0((h) this.instance, (v) toolCall$Builder.k());
        return this;
    }
}
