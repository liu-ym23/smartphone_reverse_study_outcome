package ch.qos.logback.core.encoder;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.Layout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class LayoutWrappingEncoder<E> extends EncoderBase<E> {
    private Charset charset;
    private boolean immediateFlush = true;
    protected Layout<E> layout;

    private void appendIfNotNull(StringBuilder sb, String str) {
        if (str != null) {
            sb.append(str);
        }
    }

    private byte[] convertToBytes(String str) {
        Charset charset = this.charset;
        if (charset == null) {
            return str.getBytes();
        }
        try {
            return str.getBytes(charset.name());
        } catch (UnsupportedEncodingException unused) {
            throw new IllegalStateException("An existing charset cannot possibly be unsupported.");
        }
    }

    @Override // ch.qos.logback.core.encoder.Encoder
    public void close() throws IOException {
        writeFooter();
    }

    @Override // ch.qos.logback.core.encoder.Encoder
    public void doEncode(E e4) throws IOException {
        this.outputStream.write(convertToBytes(this.layout.doLayout(e4)));
        if (this.immediateFlush) {
            this.outputStream.flush();
        }
    }

    public Charset getCharset() {
        return this.charset;
    }

    public Layout<E> getLayout() {
        return this.layout;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.encoder.Encoder
    public void init(OutputStream outputStream) throws IOException {
        super.init(outputStream);
        writeHeader();
    }

    public boolean isImmediateFlush() {
        return this.immediateFlush;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return false;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public void setImmediateFlush(boolean z4) {
        this.immediateFlush = z4;
    }

    public void setLayout(Layout<E> layout) {
        this.layout = layout;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() throws IOException {
        this.started = false;
        OutputStream outputStream = this.outputStream;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException unused) {
            }
        }
    }

    public void writeFooter() throws IOException {
        if (this.layout == null || this.outputStream == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendIfNotNull(sb, this.layout.getPresentationFooter());
        appendIfNotNull(sb, this.layout.getFileFooter());
        if (sb.length() > 0) {
            this.outputStream.write(convertToBytes(sb.toString()));
            this.outputStream.flush();
        }
    }

    public void writeHeader() throws IOException {
        if (this.layout == null || this.outputStream == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        appendIfNotNull(sb, this.layout.getFileHeader());
        appendIfNotNull(sb, this.layout.getPresentationHeader());
        if (sb.length() > 0) {
            sb.append(CoreConstants.LINE_SEPARATOR);
            this.outputStream.write(convertToBytes(sb.toString()));
            this.outputStream.flush();
        }
    }
}
