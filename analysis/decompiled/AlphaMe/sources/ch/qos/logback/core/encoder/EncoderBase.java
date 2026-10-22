package ch.qos.logback.core.encoder;

import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class EncoderBase<E> extends ContextAwareBase implements Encoder<E> {
    protected OutputStream outputStream;
    protected boolean started;

    public void init(OutputStream outputStream) throws IOException {
        this.outputStream = outputStream;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    public void start() {
        this.started = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }
}
