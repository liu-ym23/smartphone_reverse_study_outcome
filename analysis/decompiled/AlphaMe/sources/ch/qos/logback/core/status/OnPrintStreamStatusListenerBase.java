package ch.qos.logback.core.status;

import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.util.StatusPrinter;
import java.io.PrintStream;

/* loaded from: classes.dex */
abstract class OnPrintStreamStatusListenerBase extends ContextAwareBase implements StatusListener, LifeCycle {
    static final long DEFAULT_RETROSPECTIVE = 300;
    boolean isStarted = false;
    long retrospective = DEFAULT_RETROSPECTIVE;

    private void print(Status status) {
        StringBuilder sb = new StringBuilder();
        StatusPrinter.buildStr(sb, "", status);
        getPrintStream().print(sb);
    }

    private void retrospectivePrint() {
        if (this.context == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Status status : this.context.getStatusManager().getCopyOfStatusList()) {
            if (jCurrentTimeMillis - status.getDate().longValue() < this.retrospective) {
                print(status);
            }
        }
    }

    public void addStatusEvent(Status status) {
        if (this.isStarted) {
            print(status);
        }
    }

    public abstract PrintStream getPrintStream();

    public long getRetrospective() {
        return this.retrospective;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void setRetrospective(long j4) {
        this.retrospective = j4;
    }

    public void start() {
        this.isStarted = true;
        if (this.retrospective > 0) {
            retrospectivePrint();
        }
    }

    public void stop() {
        this.isStarted = false;
    }
}
