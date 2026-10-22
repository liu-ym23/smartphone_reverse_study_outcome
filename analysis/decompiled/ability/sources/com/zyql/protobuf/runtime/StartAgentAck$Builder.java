package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.p;

/* loaded from: classes2.dex */
public final class StartAgentAck$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ StartAgentAck$Builder(int i) {
        this();
    }

    public StartAgentAck$Builder clearAgentDescription() {
        copyOnWrite();
        p.D((p) this.instance);
        return this;
    }

    public StartAgentAck$Builder clearAgentName() {
        copyOnWrite();
        p.E((p) this.instance);
        return this;
    }

    public StartAgentAck$Builder clearSessionId() {
        copyOnWrite();
        p.F((p) this.instance);
        return this;
    }

    public StartAgentAck$Builder clearTaskId() {
        copyOnWrite();
        p.G((p) this.instance);
        return this;
    }

    public String getAgentDescription() {
        return ((p) this.instance).P();
    }

    public ByteString getAgentDescriptionBytes() {
        return ((p) this.instance).Q();
    }

    public String getAgentName() {
        return ((p) this.instance).R();
    }

    public ByteString getAgentNameBytes() {
        return ((p) this.instance).S();
    }

    public String getSessionId() {
        return ((p) this.instance).U();
    }

    public ByteString getSessionIdBytes() {
        return ((p) this.instance).V();
    }

    public long getTaskId() {
        return ((p) this.instance).W();
    }

    public boolean hasAgentDescription() {
        return ((p) this.instance).X();
    }

    public boolean hasAgentName() {
        return ((p) this.instance).Y();
    }

    public boolean hasTaskId() {
        return ((p) this.instance).Z();
    }

    public StartAgentAck$Builder setAgentDescription(String str) {
        copyOnWrite();
        p.H((p) this.instance, str);
        return this;
    }

    public StartAgentAck$Builder setAgentDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        p.I((p) this.instance, byteString);
        return this;
    }

    public StartAgentAck$Builder setAgentName(String str) {
        copyOnWrite();
        p.J((p) this.instance, str);
        return this;
    }

    public StartAgentAck$Builder setAgentNameBytes(ByteString byteString) {
        copyOnWrite();
        p.K((p) this.instance, byteString);
        return this;
    }

    public StartAgentAck$Builder setSessionId(String str) {
        copyOnWrite();
        p.L((p) this.instance, str);
        return this;
    }

    public StartAgentAck$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        p.M((p) this.instance, byteString);
        return this;
    }

    public StartAgentAck$Builder setTaskId(long j5) {
        copyOnWrite();
        p.N((p) this.instance, j5);
        return this;
    }

    private StartAgentAck$Builder() {
        super(p.DEFAULT_INSTANCE);
    }
}
