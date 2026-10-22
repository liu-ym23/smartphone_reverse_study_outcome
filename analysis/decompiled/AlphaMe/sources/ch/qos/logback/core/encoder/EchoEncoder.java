package ch.qos.logback.core.encoder;

import ch.qos.logback.core.CoreConstants;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class EchoEncoder<E> extends EncoderBase<E> {
    String fileFooter;
    String fileHeader;

    @Override // ch.qos.logback.core.encoder.Encoder
    public void close() throws IOException {
        String str = this.fileFooter;
        if (str == null) {
            return;
        }
        this.outputStream.write(str.getBytes());
    }

    @Override // ch.qos.logback.core.encoder.Encoder
    public void doEncode(E e4) throws IOException {
        this.outputStream.write((e4 + CoreConstants.LINE_SEPARATOR).getBytes());
        this.outputStream.flush();
    }

    @Override // ch.qos.logback.core.encoder.EncoderBase, ch.qos.logback.core.encoder.Encoder
    public void init(OutputStream outputStream) throws IOException {
        super.init(outputStream);
        String str = this.fileHeader;
        if (str == null) {
            return;
        }
        this.outputStream.write(str.getBytes());
    }
}
