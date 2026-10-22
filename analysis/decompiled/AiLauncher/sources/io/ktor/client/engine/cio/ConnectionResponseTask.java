package io.ktor.client.engine.cio;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/client/engine/cio/ConnectionResponseTask;", "", "Lio/ktor/util/date/GMTDate;", "requestTime", "Lio/ktor/client/engine/cio/RequestTask;", "task", "<init>", "(Lio/ktor/util/date/GMTDate;Lio/ktor/client/engine/cio/RequestTask;)V", "component1", "()Lio/ktor/util/date/GMTDate;", "component2", "()Lio/ktor/client/engine/cio/RequestTask;", ChatTracker.CLICK_COPY, "(Lio/ktor/util/date/GMTDate;Lio/ktor/client/engine/cio/RequestTask;)Lio/ktor/client/engine/cio/ConnectionResponseTask;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/util/date/GMTDate;", "getRequestTime", "Lio/ktor/client/engine/cio/RequestTask;", "getTask", "ktor-client-cio"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ConnectionResponseTask {
    private final GMTDate requestTime;
    private final RequestTask task;

    public ConnectionResponseTask(GMTDate requestTime, RequestTask task) {
        p.i(requestTime, "requestTime");
        p.i(task, "task");
        this.requestTime = requestTime;
        this.task = task;
    }

    public static /* synthetic */ ConnectionResponseTask copy$default(ConnectionResponseTask connectionResponseTask, GMTDate gMTDate, RequestTask requestTask, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gMTDate = connectionResponseTask.requestTime;
        }
        if ((i10 & 2) != 0) {
            requestTask = connectionResponseTask.task;
        }
        return connectionResponseTask.copy(gMTDate, requestTask);
    }

    /* renamed from: component1, reason: from getter */
    public final GMTDate getRequestTime() {
        return this.requestTime;
    }

    /* renamed from: component2, reason: from getter */
    public final RequestTask getTask() {
        return this.task;
    }

    public final ConnectionResponseTask copy(GMTDate requestTime, RequestTask task) {
        p.i(requestTime, "requestTime");
        p.i(task, "task");
        return new ConnectionResponseTask(requestTime, task);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectionResponseTask)) {
            return false;
        }
        ConnectionResponseTask connectionResponseTask = (ConnectionResponseTask) other;
        return p.d(this.requestTime, connectionResponseTask.requestTime) && p.d(this.task, connectionResponseTask.task);
    }

    public final GMTDate getRequestTime() {
        return this.requestTime;
    }

    public final RequestTask getTask() {
        return this.task;
    }

    public int hashCode() {
        return (this.requestTime.hashCode() * 31) + this.task.hashCode();
    }

    public String toString() {
        return "ConnectionResponseTask(requestTime=" + this.requestTime + ", task=" + this.task + ')';
    }
}
