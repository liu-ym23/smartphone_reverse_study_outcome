package ch.qos.logback.core;

import B0.g;
import ch.qos.logback.core.joran.spi.ConsoleTarget;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.EnvUtil;
import ch.qos.logback.core.util.OptionHelper;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ConsoleAppender<E> extends OutputStreamAppender<E> {
    private static final String WindowsAnsiOutputStream_CLASS_NAME = "org.fusesource.jansi.WindowsAnsiOutputStream";
    protected ConsoleTarget target = ConsoleTarget.SystemOut;
    protected boolean withJansi = false;

    private OutputStream getTargetStreamForWindows(OutputStream outputStream) {
        try {
            addInfo("Enabling JANSI WindowsAnsiOutputStream for the console.");
            return (OutputStream) OptionHelper.instantiateByClassNameAndParameter(WindowsAnsiOutputStream_CLASS_NAME, (Class<?>) Object.class, this.context, (Class<?>) OutputStream.class, outputStream);
        } catch (Exception e4) {
            addWarn("Failed to create WindowsAnsiOutputStream. Falling back on the default stream.", e4);
            return outputStream;
        }
    }

    private void targetWarn(String str) {
        StringBuilder sbW = g.w("[", str, "] should be one of ");
        sbW.append(Arrays.toString(ConsoleTarget.values()));
        WarnStatus warnStatus = new WarnStatus(sbW.toString(), this);
        warnStatus.add(new WarnStatus("Using previously set target, System.out by default.", this));
        addStatus(warnStatus);
    }

    public String getTarget() {
        return this.target.getName();
    }

    public boolean isWithJansi() {
        return this.withJansi;
    }

    public void setTarget(String str) {
        ConsoleTarget consoleTargetFindByName = ConsoleTarget.findByName(str.trim());
        if (consoleTargetFindByName == null) {
            targetWarn(str);
        } else {
            this.target = consoleTargetFindByName;
        }
    }

    public void setWithJansi(boolean z4) {
        this.withJansi = z4;
    }

    @Override // ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        OutputStream stream = this.target.getStream();
        if (EnvUtil.isWindows() && this.withJansi) {
            stream = getTargetStreamForWindows(stream);
        }
        setOutputStream(stream);
        super.start();
    }
}
