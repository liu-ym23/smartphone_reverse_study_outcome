package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1824w;

/* loaded from: classes2.dex */
public final class LogMessage$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ LogMessage$Builder(int i) {
        this();
    }

    public LogMessage$Builder clearContent() {
        copyOnWrite();
        C1824w.D((C1824w) this.instance);
        return this;
    }

    public LogMessage$Builder clearLevel() {
        copyOnWrite();
        C1824w.E((C1824w) this.instance);
        return this;
    }

    public LogMessage$Builder clearSender() {
        copyOnWrite();
        C1824w.F((C1824w) this.instance);
        return this;
    }

    public LogMessage$Builder clearTimestamp() {
        copyOnWrite();
        C1824w.G((C1824w) this.instance);
        return this;
    }

    public String getContent() {
        return ((C1824w) this.instance).P();
    }

    public ByteString getContentBytes() {
        return ((C1824w) this.instance).Q();
    }

    public LogLevel getLevel() {
        return ((C1824w) this.instance).S();
    }

    public int getLevelValue() {
        return ((C1824w) this.instance).T();
    }

    public LogSender getSender() {
        return ((C1824w) this.instance).U();
    }

    public int getSenderValue() {
        return ((C1824w) this.instance).V();
    }

    public long getTimestamp() {
        return ((C1824w) this.instance).W();
    }

    public LogMessage$Builder setContent(String str) {
        copyOnWrite();
        C1824w.H((C1824w) this.instance, str);
        return this;
    }

    public LogMessage$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        C1824w.I((C1824w) this.instance, byteString);
        return this;
    }

    public LogMessage$Builder setLevel(LogLevel logLevel) {
        copyOnWrite();
        C1824w.J((C1824w) this.instance, logLevel);
        return this;
    }

    public LogMessage$Builder setLevelValue(int i) {
        copyOnWrite();
        C1824w.K((C1824w) this.instance, i);
        return this;
    }

    public LogMessage$Builder setSender(LogSender logSender) {
        copyOnWrite();
        C1824w.L((C1824w) this.instance, logSender);
        return this;
    }

    public LogMessage$Builder setSenderValue(int i) {
        copyOnWrite();
        C1824w.M((C1824w) this.instance, i);
        return this;
    }

    public LogMessage$Builder setTimestamp(long j5) {
        copyOnWrite();
        C1824w.N((C1824w) this.instance, j5);
        return this;
    }

    private LogMessage$Builder() {
        super(C1824w.DEFAULT_INSTANCE);
    }
}
