package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpResponse;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.LineFormatter;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public DefaultHttpResponseWriter(SessionOutputBuffer r10, LineFormatter r11) {
        super(r10, r11);
    }

    @Override // org.apache.http.impl.io.AbstractMessageWriter
    public /* bridge */ /* synthetic */ void writeHeadLine(HttpMessage r10) throws IOException {
        writeHeadLine((HttpResponse) r10);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer r10) {
        super(r10, null);
    }

    public void writeHeadLine(HttpResponse r10) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, r10.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
