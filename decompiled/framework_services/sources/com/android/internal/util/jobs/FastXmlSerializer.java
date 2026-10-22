package com.android.internal.util.jobs;

import com.android.server.UiModeManagerService;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes.dex */
public class FastXmlSerializer implements XmlSerializer {
    private static final int DEFAULT_BUFFER_LEN = 32768;
    private static final String[] ESCAPE_TABLE = null;
    private static String sSpace;
    private final int mBufferLen;
    private ByteBuffer mBytes;
    private CharsetEncoder mCharset;
    private boolean mInTag;
    private boolean mIndent;
    private boolean mLineStart;
    private int mNesting;
    private OutputStream mOutputStream;
    private int mPos;
    private final char[] mText;
    private Writer mWriter;

    static {
        ESCAPE_TABLE = new String[]{"&#0;", "&#1;", "&#2;", "&#3;", "&#4;", "&#5;", "&#6;", "&#7;", "&#8;", "&#9;", "&#10;", "&#11;", "&#12;", "&#13;", "&#14;", "&#15;", "&#16;", "&#17;", "&#18;", "&#19;", "&#20;", "&#21;", "&#22;", "&#23;", "&#24;", "&#25;", "&#26;", "&#27;", "&#28;", "&#29;", "&#30;", "&#31;", null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
        sSpace = "                                                              ";
    }

    public FastXmlSerializer() {
        this(32768);
    }

    public FastXmlSerializer(int bufferSize) {
        this.mIndent = false;
        this.mNesting = 0;
        this.mLineStart = true;
        if (bufferSize <= 0) goto L5;
        int r0 = bufferSize;
    L6:
        this.mBufferLen = r0;
        this.mText = new char[this.mBufferLen];
        this.mBytes = ByteBuffer.allocate(this.mBufferLen);
        return;
    L5:
        r0 = 32768;
        goto L6
    }

    private void append(char c) throws IOException {
        int pos = this.mPos;
        if (pos < (this.mBufferLen - 1)) goto L5;
        flush();
        pos = this.mPos;
    L5:
        this.mText[pos] = c;
        this.mPos = pos + 1;
    }

    private void append(String str, int i, int length) throws IOException {
        if (length <= this.mBufferLen) goto L12;
        int end = i + length;
    L5:
        if (i >= end) goto L11;
        int next = this.mBufferLen + i;
        if (next >= end) goto L9;
        int r2 = this.mBufferLen;
    L10:
        append(str, i, r2);
        i = next;
        goto L5
    L9:
        r2 = end - i;
        goto L10
    L11:
        return;
    L12:
        int pos = this.mPos;
        if ((pos + length) <= this.mBufferLen) goto L15;
        flush();
        pos = this.mPos;
    L15:
        str.getChars(i, i + length, this.mText, pos);
        this.mPos = pos + length;
    }

    private void append(char[] buf, int i, int length) throws IOException {
        if (length <= this.mBufferLen) goto L12;
        int end = i + length;
    L5:
        if (i >= end) goto L11;
        int next = this.mBufferLen + i;
        if (next >= end) goto L9;
        int r2 = this.mBufferLen;
    L10:
        append(buf, i, r2);
        i = next;
        goto L5
    L9:
        r2 = end - i;
        goto L10
    L11:
        return;
    L12:
        int pos = this.mPos;
        if ((pos + length) <= this.mBufferLen) goto L15;
        flush();
        pos = this.mPos;
    L15:
        System.arraycopy(buf, i, this.mText, pos, length);
        this.mPos = pos + length;
    }

    private void append(String str) throws IOException {
        append(str, 0, str.length());
    }

    private void appendIndent(int indent) throws IOException {
        int indent2 = indent * 4;
        if (indent2 <= sSpace.length()) goto L5;
        indent2 = sSpace.length();
    L5:
        append(sSpace, 0, indent2);
    }

    private void escapeAndAppendString(String string) throws IOException {
        int N = string.length();
        char NE = (char) ESCAPE_TABLE.length;
        String[] escapes = ESCAPE_TABLE;
        int lastPos = 0;
        int pos = 0;
    L3:
        if (pos >= N) goto L14;
        char c = string.charAt(pos);
        if (c >= NE) goto L13;
        String escape = escapes[c];
        if (escape == null) goto L13;
        if (lastPos >= pos) goto L12;
        append(string, lastPos, pos - lastPos);
    L12:
        lastPos = pos + 1;
        append(escape);
    L13:
        pos = pos + 1;
        goto L3
    L14:
        if (lastPos >= pos) goto L21;
        append(string, lastPos, pos - lastPos);
        return;
    }

    private void escapeAndAppendString(char[] buf, int start, int len) throws IOException {
        char NE = (char) ESCAPE_TABLE.length;
        String[] escapes = ESCAPE_TABLE;
        int end = start + len;
        int lastPos = start;
        int pos = start;
    L3:
        if (pos >= end) goto L14;
        char c = buf[pos];
        if (c >= NE) goto L13;
        String escape = escapes[c];
        if (escape == null) goto L13;
        if (lastPos >= pos) goto L12;
        append(buf, lastPos, pos - lastPos);
    L12:
        lastPos = pos + 1;
        append(escape);
    L13:
        pos = pos + 1;
        goto L3
    L14:
        if (lastPos >= pos) goto L21;
        append(buf, lastPos, pos - lastPos);
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String namespace, String name, String value) throws IOException, IllegalArgumentException, IllegalStateException {
        append(' ');
        if (namespace == null) goto L5;
        append(namespace);
        append(':');
    L5:
        append(name);
        append("=\"");
        escapeAndAppendString(value);
        append('\"');
        this.mLineStart = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String namespace, String name) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mNesting--;
        if (this.mInTag == false) goto L6;
        append(" />\n");
    L14:
        this.mLineStart = true;
        this.mInTag = false;
        return this;
    L6:
        if (this.mIndent == true) goto L8;
    L10:
        append("</");
        if (namespace == null) goto L13;
        append(namespace);
        append(':');
    L13:
        append(name);
        append(">\n");
        goto L14
    L8:
        if (this.mLineStart == false) goto L10;
        appendIndent(this.mNesting);
        goto L10
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    private void flushBytes() throws IOException {
        int position = this.mBytes.position();
        if (position <= 0) goto L6;
        this.mBytes.flip();
        this.mOutputStream.write(this.mBytes.array(), 0, position);
        this.mBytes.clear();
        return;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        if (this.mPos > 0) goto L5;
        return;
    L5:
        if (this.mOutputStream == null) goto L15;
        CharBuffer charBuffer = CharBuffer.wrap(this.mText, 0, this.mPos);
        CoderResult result = this.mCharset.encode(charBuffer, this.mBytes, true);
    L8:
        if (result.isError() == true) goto L14;
        if (result.isOverflow() == false) goto L12;
        flushBytes();
        result = this.mCharset.encode(charBuffer, this.mBytes, true);
        goto L8
    L12:
        flushBytes();
        this.mOutputStream.flush();
    L16:
        this.mPos = 0;
        return;
    L14:
        throw new IOException(result.toString());
    L15:
        this.mWriter.write(this.mText, 0, this.mPos);
        this.mWriter.flush();
        goto L16
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String name) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String namespace, boolean generatePrefix) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String name) {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String name, boolean state) throws IllegalArgumentException, IllegalStateException {
        if (name.equals("http://xmlpull.org/v1/doc/features.html#indent-output") == false) goto L7;
        this.mIndent = true;
        return;
    L7:
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream os, String encoding) throws IOException, IllegalArgumentException, IllegalStateException {
        if (os == null) goto L15;
        this.mCharset = Charset.forName(encoding).newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);     // Catch: UnsupportedCharsetException -> L6 IllegalCharsetNameException -> L8
        this.mOutputStream = os;
        return;
    L8:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(encoding).initCause(e));
    L6:
        e = move-exception;
        throw ((UnsupportedEncodingException) new UnsupportedEncodingException(encoding).initCause(e));
    L15:
        throw new IllegalArgumentException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mWriter = writer;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String prefix, String namespace) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String name, Object value) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String encoding, Boolean standalone) throws IOException, IllegalArgumentException, IllegalStateException {
        append("<?xml version='1.0' encoding='utf-8'");
        if (standalone == null) goto L9;
        StringBuilder r0 = new StringBuilder();
        r0.append(" standalone='");
        if (standalone.booleanValue() == false) goto L7;
        String r1 = UiModeManagerService.Shell.NIGHT_MODE_STR_YES;
    L8:
        r0.append(r1);
        r0.append("'");
        append(r0.toString());
        goto L9
    L7:
        r1 = UiModeManagerService.Shell.NIGHT_MODE_STR_NO;
    L9:
        append(" ?>\n");
        this.mLineStart = true;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String namespace, String name) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.mInTag == false) goto L6;
        append(">\n");
    L6:
        if (this.mIndent == false) goto L8;
        appendIndent(this.mNesting);
    L8:
        this.mNesting++;
        append('<');
        if (namespace == null) goto L11;
        append(namespace);
        append(':');
    L11:
        append(name);
        this.mInTag = true;
        this.mLineStart = false;
        return this;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] buf, int start, int len) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean r1 = false;
        if (this.mInTag == false) goto L5;
        append(">");
        this.mInTag = false;
    L5:
        escapeAndAppendString(buf, start, len);
        if (this.mIndent == true) goto L8;
    L11:
        return this;
    L8:
        if (buf[(start + len) - 1] != '\n') goto L10;
        r1 = true;
    L10:
        this.mLineStart = r1;
        goto L11
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String text) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean r1 = false;
        if (this.mInTag == false) goto L5;
        append(">");
        this.mInTag = false;
    L5:
        escapeAndAppendString(text);
        if (this.mIndent == true) goto L8;
    L13:
        return this;
    L8:
        if (text.length() > 0) goto L10;
    L12:
        this.mLineStart = r1;
        goto L13
    L10:
        if (text.charAt(text.length() - 1) != '\n') goto L12;
        r1 = true;
        goto L12
    }
}
