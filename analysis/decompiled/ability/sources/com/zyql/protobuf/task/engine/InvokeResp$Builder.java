package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.C2106b;

/* loaded from: classes2.dex */
public final class InvokeResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ InvokeResp$Builder(int i) {
        this();
    }

    public InvokeResp$Builder clearState() {
        copyOnWrite();
        C2106b.D((C2106b) this.instance);
        return this;
    }

    public InvokeResp$Builder clearTaskId() {
        copyOnWrite();
        C2106b.E((C2106b) this.instance);
        return this;
    }

    public InvokeState getState() {
        return ((C2106b) this.instance).K();
    }

    public int getStateValue() {
        return ((C2106b) this.instance).L();
    }

    public String getTaskId() {
        return ((C2106b) this.instance).M();
    }

    public ByteString getTaskIdBytes() {
        return ((C2106b) this.instance).N();
    }

    public InvokeResp$Builder setState(InvokeState invokeState) {
        copyOnWrite();
        C2106b.F((C2106b) this.instance, invokeState);
        return this;
    }

    public InvokeResp$Builder setStateValue(int i) {
        copyOnWrite();
        C2106b.G((C2106b) this.instance, i);
        return this;
    }

    public InvokeResp$Builder setTaskId(String str) {
        copyOnWrite();
        C2106b.H((C2106b) this.instance, str);
        return this;
    }

    public InvokeResp$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C2106b.I((C2106b) this.instance, byteString);
        return this;
    }

    private InvokeResp$Builder() {
        super(C2106b.DEFAULT_INSTANCE);
    }
}
