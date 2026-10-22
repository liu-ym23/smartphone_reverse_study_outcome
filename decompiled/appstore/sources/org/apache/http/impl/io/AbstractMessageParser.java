package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.MessageConstraintException;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.message.TokenParser;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer r10, LineParser r11, HttpParams r12) {
        Args.notNull(r10, "Session input buffer");
        Args.notNull(r12, "HTTP parameters");
        this.sessionBuffer = r10;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(r12);
        if (r11 != null) goto L6;
        r11 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r11;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer r10, int r11, int r12, LineParser r13) throws HttpException, IOException {
        ArrayList r14 = new ArrayList();
        if (r13 != null) goto L7;
        r13 = BasicLineParser.INSTANCE;
    L7:
        return parseHeaders(r10, r11, r12, r13, r14);
    }

    @Override // org.apache.http.io.HttpMessageParser
    public T parse() throws IOException, HttpException {
        int r10 = this.state;
        if (r10 == 0) goto L15;
        if (r10 != 1) goto L7;
    L10:
        Header[] r11 = parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines);
        this.message.setHeaders(r11);
        T r12 = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return r12;
    L7:
        throw new IllegalStateException("Inconsistent parser state");
    L15:
        this.message = (T) parseHead(this.sessionBuffer);     // Catch: ParseException -> L12
        this.state = 1;
    L12:
        e = move-exception;
        throw new ProtocolException(e.getMessage(), e);
    }

    public abstract T parseHead(SessionInputBuffer r10) throws IOException, HttpException, ParseException;

    public static Header[] parseHeaders(SessionInputBuffer r10, int r11, int r12, LineParser r13, List<CharArrayBuffer> r14) throws HttpException, IOException {
        Args.notNull(r10, "Session input buffer");
        Args.notNull(r13, "Line parser");
        Args.notNull(r14, "Header line list");
        CharArrayBuffer r15 = null;
        CharArrayBuffer r16 = null;
    L3:
        if (r15 != null) goto L5;
        r15 = new CharArrayBuffer(64);
    L6:
        int r17 = 0;
        if (r10.readLine(r15) == (-1)) goto L37;
        if (r15.length() < 1) goto L37;
        if (r15.charAt(0) != ' ') goto L14;
    L15:
        if (r16 != null) goto L17;
    L30:
        r14.add(r15);
        r16 = r15;
        r15 = null;
    L31:
        if (r11 <= 0) goto L3;
        if (r14.size() < r11) goto L3;
        throw new MessageConstraintException("Maximum header count exceeded");
    L17:
        if (r17 >= r15.length()) goto L23;
        char r18 = r15.charAt(r17);
        if (r18 == ' ') goto L22;
        if (r18 != '\t') goto L23;
    L22:
        r17 = r17 + 1;
    L23:
        if (r12 > 0) goto L25;
    L29:
        r16.append(TokenParser.SP);
        r16.append(r15, r17, r15.length() - r17);
        goto L31
    L25:
        if ((((r16.length() + 1) + r15.length()) - r17) <= r12) goto L29;
        throw new MessageConstraintException("Maximum line length limit exceeded");
    L14:
        if (r15.charAt(0) != '\t') goto L30;
    L37:
        Header[] r19 = new Header[r14.size()];
    L39:
        if (r17 >= r14.size()) goto L46;
        r19[r17] = r13.parseHeader(r14.get(r17));     // Catch: ParseException -> L43
        r17 = r17 + 1;
    L43:
        e = move-exception;
        throw new ProtocolException(e.getMessage());
    L46:
        return r19;
    L5:
        r15.clear();
        goto L6
    }

    public AbstractMessageParser(SessionInputBuffer r10, LineParser r11, MessageConstraints r12) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(r10, "Session input buffer");
        if (r11 != null) goto L6;
        r11 = BasicLineParser.INSTANCE;
    L6:
        this.lineParser = r11;
        if (r12 != null) goto L10;
        r12 = MessageConstraints.DEFAULT;
    L10:
        this.messageConstraints = r12;
        this.headerLines = new ArrayList();
        this.state = 0;
    }
}
