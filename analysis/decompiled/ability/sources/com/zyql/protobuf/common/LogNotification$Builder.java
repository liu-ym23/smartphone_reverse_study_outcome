package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1824w;
import q7.C1825x;

/* loaded from: classes2.dex */
public final class LogNotification$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ LogNotification$Builder(int i) {
        this();
    }

    public LogNotification$Builder clearLog() {
        copyOnWrite();
        C1825x.D((C1825x) this.instance);
        return this;
    }

    public LogNotification$Builder clearSessionId() {
        copyOnWrite();
        C1825x.E((C1825x) this.instance);
        return this;
    }

    public C1824w getLog() {
        return ((C1825x) this.instance).L();
    }

    public String getSessionId() {
        return ((C1825x) this.instance).M();
    }

    public ByteString getSessionIdBytes() {
        return ((C1825x) this.instance).N();
    }

    public boolean hasLog() {
        return ((C1825x) this.instance).O();
    }

    public LogNotification$Builder mergeLog(C1824w c1824w) {
        copyOnWrite();
        C1825x.F((C1825x) this.instance, c1824w);
        return this;
    }

    public LogNotification$Builder setLog(C1824w c1824w) {
        copyOnWrite();
        C1825x.G((C1825x) this.instance, c1824w);
        return this;
    }

    public LogNotification$Builder setSessionId(String str) {
        copyOnWrite();
        C1825x.H((C1825x) this.instance, str);
        return this;
    }

    public LogNotification$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1825x.I((C1825x) this.instance, byteString);
        return this;
    }

    private LogNotification$Builder() {
        super(C1825x.DEFAULT_INSTANCE);
    }

    public LogNotification$Builder setLog(LogMessage$Builder logMessage$Builder) {
        copyOnWrite();
        C1825x.G((C1825x) this.instance, (C1824w) logMessage$Builder.k());
        return this;
    }
}
