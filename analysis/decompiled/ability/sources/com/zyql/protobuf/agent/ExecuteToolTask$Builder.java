package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1774j;

/* loaded from: classes2.dex */
public final class ExecuteToolTask$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ExecuteToolTask$Builder(int i) {
        this();
    }

    public ExecuteToolTask$Builder clearArgumentsJson() {
        copyOnWrite();
        C1774j.D((C1774j) this.instance);
        return this;
    }

    public ExecuteToolTask$Builder clearTaskId() {
        copyOnWrite();
        C1774j.E((C1774j) this.instance);
        return this;
    }

    public ExecuteToolTask$Builder clearTimeoutSeconds() {
        copyOnWrite();
        C1774j.F((C1774j) this.instance);
        return this;
    }

    public ExecuteToolTask$Builder clearToolCallId() {
        copyOnWrite();
        C1774j.G((C1774j) this.instance);
        return this;
    }

    public ExecuteToolTask$Builder clearToolName() {
        copyOnWrite();
        C1774j.H((C1774j) this.instance);
        return this;
    }

    public String getArgumentsJson() {
        return ((C1774j) this.instance).S();
    }

    public ByteString getArgumentsJsonBytes() {
        return ((C1774j) this.instance).T();
    }

    public String getTaskId() {
        return ((C1774j) this.instance).V();
    }

    public ByteString getTaskIdBytes() {
        return ((C1774j) this.instance).W();
    }

    public int getTimeoutSeconds() {
        return ((C1774j) this.instance).X();
    }

    public String getToolCallId() {
        return ((C1774j) this.instance).Y();
    }

    public ByteString getToolCallIdBytes() {
        return ((C1774j) this.instance).Z();
    }

    public String getToolName() {
        return ((C1774j) this.instance).a0();
    }

    public ByteString getToolNameBytes() {
        return ((C1774j) this.instance).b0();
    }

    public ExecuteToolTask$Builder setArgumentsJson(String str) {
        copyOnWrite();
        C1774j.I((C1774j) this.instance, str);
        return this;
    }

    public ExecuteToolTask$Builder setArgumentsJsonBytes(ByteString byteString) {
        copyOnWrite();
        C1774j.J((C1774j) this.instance, byteString);
        return this;
    }

    public ExecuteToolTask$Builder setTaskId(String str) {
        copyOnWrite();
        C1774j.K((C1774j) this.instance, str);
        return this;
    }

    public ExecuteToolTask$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C1774j.L((C1774j) this.instance, byteString);
        return this;
    }

    public ExecuteToolTask$Builder setTimeoutSeconds(int i) {
        copyOnWrite();
        C1774j.M((C1774j) this.instance, i);
        return this;
    }

    public ExecuteToolTask$Builder setToolCallId(String str) {
        copyOnWrite();
        C1774j.N((C1774j) this.instance, str);
        return this;
    }

    public ExecuteToolTask$Builder setToolCallIdBytes(ByteString byteString) {
        copyOnWrite();
        C1774j.O((C1774j) this.instance, byteString);
        return this;
    }

    public ExecuteToolTask$Builder setToolName(String str) {
        copyOnWrite();
        C1774j.P((C1774j) this.instance, str);
        return this;
    }

    public ExecuteToolTask$Builder setToolNameBytes(ByteString byteString) {
        copyOnWrite();
        C1774j.Q((C1774j) this.instance, byteString);
        return this;
    }

    private ExecuteToolTask$Builder() {
        super(C1774j.DEFAULT_INSTANCE);
    }
}
