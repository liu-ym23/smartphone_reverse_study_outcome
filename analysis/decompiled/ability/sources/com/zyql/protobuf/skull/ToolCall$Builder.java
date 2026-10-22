package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.u;
import v7.v;
import v7.w;
import v7.x;

/* loaded from: classes2.dex */
public final class ToolCall$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCall$Builder(int i) {
        this();
    }

    public ToolCall$Builder clearCallId() {
        copyOnWrite();
        v.D((v) this.instance);
        return this;
    }

    public ToolCall$Builder clearParams() {
        copyOnWrite();
        v.E((v) this.instance);
        return this;
    }

    public ToolCall$Builder clearResult() {
        copyOnWrite();
        v.F((v) this.instance);
        return this;
    }

    public ToolCall$Builder clearTool() {
        copyOnWrite();
        v.G((v) this.instance);
        return this;
    }

    public String getCallId() {
        return ((v) this.instance).Q();
    }

    public ByteString getCallIdBytes() {
        return ((v) this.instance).R();
    }

    public w getParams() {
        return ((v) this.instance).T();
    }

    public x getResult() {
        return ((v) this.instance).U();
    }

    public u getTool() {
        return ((v) this.instance).V();
    }

    public boolean hasParams() {
        return ((v) this.instance).W();
    }

    public boolean hasResult() {
        return ((v) this.instance).X();
    }

    public boolean hasTool() {
        return ((v) this.instance).Y();
    }

    public ToolCall$Builder mergeParams(w wVar) {
        copyOnWrite();
        v.H((v) this.instance, wVar);
        return this;
    }

    public ToolCall$Builder mergeResult(x xVar) {
        copyOnWrite();
        v.I((v) this.instance, xVar);
        return this;
    }

    public ToolCall$Builder mergeTool(u uVar) {
        copyOnWrite();
        v.J((v) this.instance, uVar);
        return this;
    }

    public ToolCall$Builder setCallId(String str) {
        copyOnWrite();
        v.K(str, (v) this.instance);
        return this;
    }

    public ToolCall$Builder setCallIdBytes(ByteString byteString) {
        copyOnWrite();
        v.L((v) this.instance, byteString);
        return this;
    }

    public ToolCall$Builder setParams(w wVar) {
        copyOnWrite();
        v.M((v) this.instance, wVar);
        return this;
    }

    public ToolCall$Builder setResult(x xVar) {
        copyOnWrite();
        v.N((v) this.instance, xVar);
        return this;
    }

    public ToolCall$Builder setTool(u uVar) {
        copyOnWrite();
        v.O((v) this.instance, uVar);
        return this;
    }

    private ToolCall$Builder() {
        super(v.DEFAULT_INSTANCE);
    }

    public ToolCall$Builder setParams(ToolCallParams$Builder toolCallParams$Builder) {
        copyOnWrite();
        v.M((v) this.instance, (w) toolCallParams$Builder.k());
        return this;
    }

    public ToolCall$Builder setResult(ToolCallResult$Builder toolCallResult$Builder) {
        copyOnWrite();
        v.N((v) this.instance, (x) toolCallResult$Builder.k());
        return this;
    }

    public ToolCall$Builder setTool(Tool$Builder tool$Builder) {
        copyOnWrite();
        v.O((v) this.instance, (u) tool$Builder.k());
        return this;
    }
}
