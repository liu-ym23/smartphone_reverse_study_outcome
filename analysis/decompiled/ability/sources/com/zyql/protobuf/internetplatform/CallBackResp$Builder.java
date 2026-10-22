package com.zyql.protobuf.internetplatform;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import s7.C1919b;

/* loaded from: classes2.dex */
public final class CallBackResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CallBackResp$Builder(int i) {
        this();
    }

    public CallBackResp$Builder clearState() {
        copyOnWrite();
        C1919b.D((C1919b) this.instance);
        return this;
    }

    public CallState getState() {
        return ((C1919b) this.instance).H();
    }

    public int getStateValue() {
        return ((C1919b) this.instance).I();
    }

    public CallBackResp$Builder setState(CallState callState) {
        copyOnWrite();
        C1919b.E((C1919b) this.instance, callState);
        return this;
    }

    public CallBackResp$Builder setStateValue(int i) {
        copyOnWrite();
        C1919b.F((C1919b) this.instance, i);
        return this;
    }

    private CallBackResp$Builder() {
        super(C1919b.DEFAULT_INSTANCE);
    }
}
