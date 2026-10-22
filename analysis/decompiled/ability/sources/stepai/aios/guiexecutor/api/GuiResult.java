package stepai.aios.guiexecutor.api;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\fHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J_\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015¨\u0006+"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiResult;", "", "commandId", "", "success", "", "executionTime", "", "result", "error", "Lstepai/aios/guiexecutor/api/GuiError;", "metadata", "", "timestamp", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZJLjava/lang/Object;Lstepai/aios/guiexecutor/api/GuiError;Ljava/util/Map;J)V", "getCommandId", "()Ljava/lang/String;", "getSuccess", "()Z", "getExecutionTime", "()J", "getResult", "()Ljava/lang/Object;", "getError", "()Lstepai/aios/guiexecutor/api/GuiError;", "getMetadata", "()Ljava/util/Map;", "getTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class GuiResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String commandId;
    private final GuiError error;
    private final long executionTime;
    private final Map<String, Object> metadata;
    private final Object result;
    private final boolean success;
    private final long timestamp;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fJ6\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fJ4\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¨\u0006\u0015"}, d2 = {"Lstepai/aios/guiexecutor/api/GuiResult$Companion;", "", AppAgent.CONSTRUCT, "()V", "success", "Lstepai/aios/guiexecutor/api/GuiResult;", "commandId", "", "executionTime", "", "result", "metadata", "", "failure", "error", "Lstepai/aios/guiexecutor/api/GuiError;", "errorCode", "Lstepai/aios/guiexecutor/api/ErrorCode;", "message", "cause", "", "guiagent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ GuiResult failure$default(Companion companion, String str, GuiError guiError, long j5, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                j5 = 0;
            }
            long j6 = j5;
            if ((i & 8) != 0) {
                map = a.M();
            }
            return companion.failure(str, guiError, j6, map);
        }

        public static /* synthetic */ GuiResult success$default(Companion companion, String str, long j5, Object obj, Map map, int i, Object obj2) {
            if ((i & 2) != 0) {
                j5 = 0;
            }
            long j6 = j5;
            if ((i & 4) != 0) {
                obj = null;
            }
            Object obj3 = obj;
            if ((i & 8) != 0) {
                map = a.M();
            }
            return companion.success(str, j6, obj3, map);
        }

        public final GuiResult failure(String commandId, GuiError error, long executionTime, Map<String, ? extends Object> metadata) {
            k.f(commandId, "commandId");
            k.f(error, "error");
            k.f(metadata, "metadata");
            return new GuiResult(commandId, false, executionTime, null, error, metadata, 0L, 72, null);
        }

        public final GuiResult success(String commandId, long executionTime, Object result, Map<String, ? extends Object> metadata) {
            k.f(commandId, "commandId");
            k.f(metadata, "metadata");
            return new GuiResult(commandId, true, executionTime, result, null, metadata, 0L, 80, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final GuiResult failure(String commandId, ErrorCode errorCode, String message, long executionTime, Throwable cause) {
            k.f(commandId, "commandId");
            k.f(errorCode, "errorCode");
            k.f(message, "message");
            boolean z10 = false;
            Map map = null;
            long j5 = 0;
            return new GuiResult(commandId, false, executionTime, map, new GuiError(errorCode, message, cause, z10, map, 24, null), 0 == true ? 1 : 0, j5, LocationRequestCompat.QUALITY_LOW_POWER, null);
        }

        public static /* synthetic */ GuiResult failure$default(Companion companion, String str, ErrorCode errorCode, String str2, long j5, Throwable th, int i, Object obj) {
            if ((i & 8) != 0) {
                j5 = 0;
            }
            long j6 = j5;
            if ((i & 16) != 0) {
                th = null;
            }
            return companion.failure(str, errorCode, str2, j6, th);
        }
    }

    public GuiResult(String commandId, boolean z10, long j5, Object obj, GuiError guiError, Map<String, ? extends Object> metadata, long j6) {
        k.f(commandId, "commandId");
        k.f(metadata, "metadata");
        this.commandId = commandId;
        this.success = z10;
        this.executionTime = j5;
        this.result = obj;
        this.error = guiError;
        this.metadata = metadata;
        this.timestamp = j6;
    }

    public static /* synthetic */ GuiResult copy$default(GuiResult guiResult, String str, boolean z10, long j5, Object obj, GuiError guiError, Map map, long j6, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = guiResult.commandId;
        }
        if ((i & 2) != 0) {
            z10 = guiResult.success;
        }
        if ((i & 4) != 0) {
            j5 = guiResult.executionTime;
        }
        if ((i & 8) != 0) {
            obj = guiResult.result;
        }
        if ((i & 16) != 0) {
            guiError = guiResult.error;
        }
        if ((i & 32) != 0) {
            map = guiResult.metadata;
        }
        if ((i & 64) != 0) {
            j6 = guiResult.timestamp;
        }
        Map map2 = map;
        Object obj3 = obj;
        long j10 = j5;
        return guiResult.copy(str, z10, j10, obj3, guiError, map2, j6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCommandId() {
        return this.commandId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final long getExecutionTime() {
        return this.executionTime;
    }

    /* renamed from: component4, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    /* renamed from: component5, reason: from getter */
    public final GuiError getError() {
        return this.error;
    }

    public final Map<String, Object> component6() {
        return this.metadata;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final GuiResult copy(String commandId, boolean success, long executionTime, Object result, GuiError error, Map<String, ? extends Object> metadata, long timestamp) {
        k.f(commandId, "commandId");
        k.f(metadata, "metadata");
        return new GuiResult(commandId, success, executionTime, result, error, metadata, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiResult)) {
            return false;
        }
        GuiResult guiResult = (GuiResult) other;
        return k.b(this.commandId, guiResult.commandId) && this.success == guiResult.success && this.executionTime == guiResult.executionTime && k.b(this.result, guiResult.result) && k.b(this.error, guiResult.error) && k.b(this.metadata, guiResult.metadata) && this.timestamp == guiResult.timestamp;
    }

    public final String getCommandId() {
        return this.commandId;
    }

    public final GuiError getError() {
        return this.error;
    }

    public final long getExecutionTime() {
        return this.executionTime;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final Object getResult() {
        return this.result;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.d(this.commandId.hashCode() * 31, 31, this.success), 31, this.executionTime);
        Object obj = this.result;
        int iHashCode = (iC + (obj == null ? 0 : obj.hashCode())) * 31;
        GuiError guiError = this.error;
        return Long.hashCode(this.timestamp) + androidx.appfunctions.metadata.a.f(this.metadata, (iHashCode + (guiError != null ? guiError.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        String str = this.commandId;
        boolean z10 = this.success;
        long j5 = this.executionTime;
        Object obj = this.result;
        GuiError guiError = this.error;
        Map<String, Object> map = this.metadata;
        long j6 = this.timestamp;
        StringBuilder sbL = androidx.constraintlayout.core.dsl.a.l("GuiResult(commandId=", str, ", success=", ", executionTime=", z10);
        sbL.append(j5);
        sbL.append(", result=");
        sbL.append(obj);
        sbL.append(", error=");
        sbL.append(guiError);
        sbL.append(", metadata=");
        sbL.append(map);
        sbL.append(", timestamp=");
        sbL.append(j6);
        sbL.append(")");
        return sbL.toString();
    }

    public /* synthetic */ GuiResult(String str, boolean z10, long j5, Object obj, GuiError guiError, Map map, long j6, int i, e eVar) {
        this(str, z10, j5, (i & 8) != 0 ? null : obj, (i & 16) != 0 ? null : guiError, (i & 32) != 0 ? a.M() : map, (i & 64) != 0 ? System.currentTimeMillis() : j6);
    }
}
