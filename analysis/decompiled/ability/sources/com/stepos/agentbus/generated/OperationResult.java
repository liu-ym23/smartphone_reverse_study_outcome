package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentbus/generated/OperationResult;", "", "success", "", "id", "", "errorCode", "message", "details", "", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getSuccess", "()Z", "getId", "()Ljava/lang/String;", "getErrorCode", "getMessage", "getDetails", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class OperationResult {
    private final Map<String, Object> details;
    private final String errorCode;
    private final String id;
    private final String message;
    private final boolean success;

    public OperationResult(boolean z10, String str, String str2, String str3, Map<String, ? extends Object> details) {
        k.f(details, "details");
        this.success = z10;
        this.id = str;
        this.errorCode = str2;
        this.message = str3;
        this.details = details;
    }

    public static /* synthetic */ OperationResult copy$default(OperationResult operationResult, boolean z10, String str, String str2, String str3, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = operationResult.success;
        }
        if ((i & 2) != 0) {
            str = operationResult.id;
        }
        if ((i & 4) != 0) {
            str2 = operationResult.errorCode;
        }
        if ((i & 8) != 0) {
            str3 = operationResult.message;
        }
        if ((i & 16) != 0) {
            map = operationResult.details;
        }
        Map map2 = map;
        String str4 = str2;
        return operationResult.copy(z10, str, str4, str3, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, Object> component5() {
        return this.details;
    }

    public final OperationResult copy(boolean success, String id, String errorCode, String message, Map<String, ? extends Object> details) {
        k.f(details, "details");
        return new OperationResult(success, id, errorCode, message, details);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationResult)) {
            return false;
        }
        OperationResult operationResult = (OperationResult) other;
        return this.success == operationResult.success && k.b(this.id, operationResult.id) && k.b(this.errorCode, operationResult.errorCode) && k.b(this.message, operationResult.message) && k.b(this.details, operationResult.details);
    }

    public final Map<String, Object> getDetails() {
        return this.details;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.id;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.message;
        return this.details.hashCode() + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public String toString() {
        boolean z10 = this.success;
        String str = this.id;
        String str2 = this.errorCode;
        String str3 = this.message;
        Map<String, Object> map = this.details;
        StringBuilder sb = new StringBuilder("OperationResult(success=");
        sb.append(z10);
        sb.append(", id=");
        sb.append(str);
        sb.append(", errorCode=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", message=", str3, ", details=");
        sb.append(map);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ OperationResult(boolean z10, String str, String str2, String str3, Map map, int i, e eVar) {
        this(z10, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? kotlin.collections.a.M() : map);
    }
}
