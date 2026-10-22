package com.mdisdk.capability.request;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f2\u00020\u0001:\u0004\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult;", "", AppAgent.CONSTRUCT, "()V", "isSuccess", "", "isFailure", "getSnapshotOrNull", "Lcom/mdisdk/capability/request/UiSnapshot;", "Success", "Error", "Timeout", "Companion", "Lcom/mdisdk/capability/request/ApexResult$Error;", "Lcom/mdisdk/capability/request/ApexResult$Success;", "Lcom/mdisdk/capability/request/ApexResult$Timeout;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ApexResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Companion;", "", AppAgent.CONSTRUCT, "()V", RequestInfo.FUNCTION_SNAPSHOT, "Lcom/mdisdk/capability/request/ApexResult$Success$Snapshot;", SettingsConfig.KEY_DATA, "Lcom/mdisdk/capability/request/UiSnapshot;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Lcom/mdisdk/capability/request/ApexResult$Success$Action;", "function", "", "message", "error", "Lcom/mdisdk/capability/request/ApexResult$Error;", "cause", "", InjectExperienceResult.REASON_TIMEOUT, "Lcom/mdisdk/capability/request/ApexResult$Timeout;", "timeoutMs", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ Success.Action action$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.action(str, str2);
        }

        public static /* synthetic */ Error error$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            return companion.error(str, th);
        }

        public final Success.Action action(String function, String message) {
            k.f(function, "function");
            return new Success.Action(function, message);
        }

        public final Error error(String message, Throwable cause) {
            k.f(message, "message");
            return new Error(message, cause);
        }

        public final Success.Snapshot snapshot(UiSnapshot data) {
            k.f(data, "data");
            return new Success.Snapshot(data);
        }

        public final Timeout timeout(long timeoutMs) {
            return new Timeout(timeoutMs);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Error;", "Lcom/mdisdk/capability/request/ApexResult;", "message", "", "cause", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Error extends ApexResult {
        private final Throwable cause;
        private final String message;

        public /* synthetic */ Error(String str, Throwable th, int i, e eVar) {
            this(str, (i & 2) != 0 ? null : th);
        }

        public static /* synthetic */ Error copy$default(Error error, String str, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                th = error.cause;
            }
            return error.copy(str, th);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final Throwable getCause() {
            return this.cause;
        }

        public final Error copy(String message, Throwable cause) {
            k.f(message, "message");
            return new Error(message, cause);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return k.b(this.message, error.message) && k.b(this.cause, error.cause);
        }

        public final Throwable getCause() {
            return this.cause;
        }

        public final String getMessage() {
            return this.message;
        }

        public int hashCode() {
            int iHashCode = this.message.hashCode() * 31;
            Throwable th = this.cause;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public String toString() {
            return "Error(message=" + this.message + ", cause=" + this.cause + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message, Throwable th) {
            super(null);
            k.f(message, "message");
            this.message = message;
            this.cause = th;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Success;", "Lcom/mdisdk/capability/request/ApexResult;", AppAgent.CONSTRUCT, "()V", "Snapshot", "Action", "Lcom/mdisdk/capability/request/ApexResult$Success$Action;", "Lcom/mdisdk/capability/request/ApexResult$Success$Snapshot;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Success extends ApexResult {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Success$Action;", "Lcom/mdisdk/capability/request/ApexResult$Success;", "function", "", "message", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;)V", "getFunction", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Action extends Success {
            private final String function;
            private final String message;

            public /* synthetic */ Action(String str, String str2, int i, e eVar) {
                this(str, (i & 2) != 0 ? null : str2);
            }

            public static /* synthetic */ Action copy$default(Action action, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = action.function;
                }
                if ((i & 2) != 0) {
                    str2 = action.message;
                }
                return action.copy(str, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getFunction() {
                return this.function;
            }

            /* renamed from: component2, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final Action copy(String function, String message) {
                k.f(function, "function");
                return new Action(function, message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Action)) {
                    return false;
                }
                Action action = (Action) other;
                return k.b(this.function, action.function) && k.b(this.message, action.message);
            }

            public final String getFunction() {
                return this.function;
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                int iHashCode = this.function.hashCode() * 31;
                String str = this.message;
                return iHashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Action(function=");
                sb.append(this.function);
                sb.append(", message=");
                return a.g(')', this.message, sb);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Action(String function, String str) {
                super(null);
                k.f(function, "function");
                this.function = function;
                this.message = str;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Success$Snapshot;", "Lcom/mdisdk/capability/request/ApexResult$Success;", SettingsConfig.KEY_DATA, "Lcom/mdisdk/capability/request/UiSnapshot;", AppAgent.CONSTRUCT, "(Lcom/mdisdk/capability/request/UiSnapshot;)V", "getData", "()Lcom/mdisdk/capability/request/UiSnapshot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Snapshot extends Success {
            private final UiSnapshot data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Snapshot(UiSnapshot data) {
                super(null);
                k.f(data, "data");
                this.data = data;
            }

            public static /* synthetic */ Snapshot copy$default(Snapshot snapshot, UiSnapshot uiSnapshot, int i, Object obj) {
                if ((i & 1) != 0) {
                    uiSnapshot = snapshot.data;
                }
                return snapshot.copy(uiSnapshot);
            }

            /* renamed from: component1, reason: from getter */
            public final UiSnapshot getData() {
                return this.data;
            }

            public final Snapshot copy(UiSnapshot data) {
                k.f(data, "data");
                return new Snapshot(data);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Snapshot) && k.b(this.data, ((Snapshot) other).data);
            }

            public final UiSnapshot getData() {
                return this.data;
            }

            public int hashCode() {
                return this.data.hashCode();
            }

            public String toString() {
                return "Snapshot(data=" + this.data + ')';
            }
        }

        public /* synthetic */ Success(e eVar) {
            this();
        }

        private Success() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/mdisdk/capability/request/ApexResult$Timeout;", "Lcom/mdisdk/capability/request/ApexResult;", "timeoutMs", "", AppAgent.CONSTRUCT, "(J)V", "getTimeoutMs", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Timeout extends ApexResult {
        private final long timeoutMs;

        public Timeout(long j5) {
            super(null);
            this.timeoutMs = j5;
        }

        public static /* synthetic */ Timeout copy$default(Timeout timeout, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                j5 = timeout.timeoutMs;
            }
            return timeout.copy(j5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public final Timeout copy(long timeoutMs) {
            return new Timeout(timeoutMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Timeout) && this.timeoutMs == ((Timeout) other).timeoutMs;
        }

        public final long getTimeoutMs() {
            return this.timeoutMs;
        }

        public int hashCode() {
            return Long.hashCode(this.timeoutMs);
        }

        public String toString() {
            return a.p(new StringBuilder("Timeout(timeoutMs="), this.timeoutMs, ')');
        }
    }

    public /* synthetic */ ApexResult(e eVar) {
        this();
    }

    public final UiSnapshot getSnapshotOrNull() {
        if (this instanceof Success.Snapshot) {
            return ((Success.Snapshot) this).getData();
        }
        return null;
    }

    public final boolean isFailure() {
        return (this instanceof Error) || (this instanceof Timeout);
    }

    public final boolean isSuccess() {
        return this instanceof Success;
    }

    private ApexResult() {
    }
}
