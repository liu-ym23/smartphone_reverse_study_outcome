package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    public DefaultHttpRequestWriter(SessionOutputBuffer r10, LineFormatter r11) {
        super(r10, r11);
    }

    @Override // org.apache.http.impl.io.AbstractMessageWriter
    public /* bridge */ /* synthetic */ void writeHeadLine(HttpMessage r10) throws IOException {
        writeHeadLine((HttpRequest) r10);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer r10) {
        this(r10, null);
    }

    public void writeHeadLine(HttpRequest r10) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, r10.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
