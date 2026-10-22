package com.stepos.ailauncher.taskstore.sync;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/a;", "", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/taskstore/sync/a$a;", "Lcom/stepos/ailauncher/taskstore/sync/a$b;", "Lcom/stepos/ailauncher/taskstore/sync/a$c;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface a {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/a$a;", "Lcom/stepos/ailauncher/taskstore/sync/a;", "", "taskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "op", "", "cause", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;Ljava/lang/Throwable;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "getOp", "()Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.sync.a$a, reason: collision with other inner class name and from toString */
    public static final /* data */ class Failure implements a {
        private final Throwable cause;
        private final TaskSyncOp op;
        private final String taskId;

        public Failure(String taskId, TaskSyncOp op, Throwable th) {
            p.i(taskId, "taskId");
            p.i(op, "op");
            this.taskId = taskId;
            this.op = op;
            this.cause = th;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return p.d(this.taskId, failure.taskId) && this.op == failure.op && p.d(this.cause, failure.cause);
        }

        public int hashCode() {
            int iHashCode = ((this.taskId.hashCode() * 31) + this.op.hashCode()) * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Failure(taskId=" + this.taskId + ", op=" + this.op + ", cause=" + this.cause + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/a$b;", "Lcom/stepos/ailauncher/taskstore/sync/a;", "", "taskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "op", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "getOp", "()Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.sync.a$b, reason: from toString */
    public static final /* data */ class Reverted implements a {
        private final TaskSyncOp op;
        private final String taskId;

        public Reverted(String taskId, TaskSyncOp op) {
            p.i(taskId, "taskId");
            p.i(op, "op");
            this.taskId = taskId;
            this.op = op;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Reverted)) {
                return false;
            }
            Reverted reverted = (Reverted) other;
            return p.d(this.taskId, reverted.taskId) && this.op == reverted.op;
        }

        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.op.hashCode();
        }

        public String toString() {
            return "Reverted(taskId=" + this.taskId + ", op=" + this.op + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/a$c;", "Lcom/stepos/ailauncher/taskstore/sync/a;", "", "taskId", "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "op", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.sync.a$c, reason: from toString */
    public static final /* data */ class Success implements a {
        private final TaskSyncOp op;
        private final String taskId;

        public Success(String taskId, TaskSyncOp op) {
            p.i(taskId, "taskId");
            p.i(op, "op");
            this.taskId = taskId;
            this.op = op;
        }

        /* renamed from: a, reason: from getter */
        public TaskSyncOp getOp() {
            return this.op;
        }

        /* renamed from: b, reason: from getter */
        public String getTaskId() {
            return this.taskId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Success)) {
                return false;
            }
            Success success = (Success) other;
            return p.d(this.taskId, success.taskId) && this.op == success.op;
        }

        public int hashCode() {
            return (this.taskId.hashCode() * 31) + this.op.hashCode();
        }

        public String toString() {
            return "Success(taskId=" + this.taskId + ", op=" + this.op + ")";
        }
    }
}
