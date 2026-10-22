package ch.qos.logback.core.recovery;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class ResilientSyslogOutputStream extends ResilientOutputStreamBase {
    int port;
    String syslogHost;

    public ResilientSyslogOutputStream(String str, int i4) throws SocketException, UnknownHostException {
        this.syslogHost = str;
        this.port = i4;
        this.os = new SyslogOutputStream(str, i4);
        this.presumedClean = true;
    }

    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public String getDescription() {
        StringBuilder sb = new StringBuilder("syslog [");
        sb.append(this.syslogHost);
        sb.append(AwarenessDataItem.USERID_SPLITTER);
        return AbstractC0831a.d(sb, this.port, "]");
    }

    @Override // ch.qos.logback.core.recovery.ResilientOutputStreamBase
    public OutputStream openNewOutputStream() throws IOException {
        return new SyslogOutputStream(this.syslogHost, this.port);
    }

    public String toString() {
        return "c.q.l.c.recovery.ResilientSyslogOutputStream@" + System.identityHashCode(this);
    }
}
