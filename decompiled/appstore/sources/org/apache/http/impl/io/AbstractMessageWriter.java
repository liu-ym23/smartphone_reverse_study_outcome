package org.apache.http.impl.io;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.message.LineFormatter;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    @Deprecated
    public AbstractMessageWriter(SessionOutputBuffer r10, LineFormatter r11, HttpParams r12) {
        Args.notNull(r10, "Session input buffer");
        this.sessionBuffer = r10;
        this.lineBuf = new CharArrayBuffer(128);
        if (r11 != null) goto L6;
        r11 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r11;
    }

    @Override // org.apache.http.io.HttpMessageWriter
    public void write(T r10) throws IOException, HttpException {
        Args.notNull(r10, "HTTP message");
        writeHeadLine(r10);
        HeaderIterator r11 = r10.headerIterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Header r12 = r11.nextHeader();
        this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, r12));
        goto L4
    L6:
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }

    public abstract void writeHeadLine(T r10) throws IOException;

    public AbstractMessageWriter(SessionOutputBuffer r10, LineFormatter r11) {
        this.sessionBuffer = (SessionOutputBuffer) Args.notNull(r10, "Session input buffer");
        if (r11 != null) goto L6;
        r11 = BasicLineFormatter.INSTANCE;
    L6:
        this.lineFormatter = r11;
        this.lineBuf = new CharArrayBuffer(128);
    }
}
