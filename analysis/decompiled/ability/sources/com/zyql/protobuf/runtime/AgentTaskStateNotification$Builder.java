package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.C2042a;

/* loaded from: classes2.dex */
public final class AgentTaskStateNotification$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentTaskStateNotification$Builder(int i) {
        this();
    }

    public AgentTaskStateNotification$Builder clearDetails() {
        copyOnWrite();
        C2042a.D((C2042a) this.instance);
        return this;
    }

    public AgentTaskStateNotification$Builder clearState() {
        copyOnWrite();
        C2042a.E((C2042a) this.instance);
        return this;
    }

    public String getDetails() {
        return ((C2042a) this.instance).L();
    }

    public ByteString getDetailsBytes() {
        return ((C2042a) this.instance).M();
    }

    public AgentTaskStateNotification$State getState() {
        return ((C2042a) this.instance).N();
    }

    public int getStateValue() {
        return ((C2042a) this.instance).O();
    }

    public boolean hasDetails() {
        return ((C2042a) this.instance).P();
    }

    public AgentTaskStateNotification$Builder setDetails(String str) {
        copyOnWrite();
        C2042a.F((C2042a) this.instance, str);
        return this;
    }

    public AgentTaskStateNotification$Builder setDetailsBytes(ByteString byteString) {
        copyOnWrite();
        C2042a.G((C2042a) this.instance, byteString);
        return this;
    }

    public AgentTaskStateNotification$Builder setState(AgentTaskStateNotification$State agentTaskStateNotification$State) {
        copyOnWrite();
        C2042a.H((C2042a) this.instance, agentTaskStateNotification$State);
        return this;
    }

    public AgentTaskStateNotification$Builder setStateValue(int i) {
        copyOnWrite();
        C2042a.I((C2042a) this.instance, i);
        return this;
    }

    private AgentTaskStateNotification$Builder() {
        super(C2042a.DEFAULT_INSTANCE);
    }
}
