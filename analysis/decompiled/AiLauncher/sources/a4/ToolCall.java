package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.ToolStatus;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0010R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"R'\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b\u001b\u0010\u0010R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001d\u0010\u0010R'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b$\u0010\u001f¨\u0006%"}, d2 = {"La4/E;", "", "", "id", "name", "", "arguments", "Lcom/stepos/agentbus/generated/ToolStatus;", "status", "result", "errorCode", "errorMessage", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/stepos/agentbus/generated/ToolStatus;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "e", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "Lcom/stepos/agentbus/generated/ToolStatus;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/agentbus/generated/ToolStatus;", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.E, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ToolCall {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> arguments;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ToolStatus status;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> result;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorCode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorMessage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> update;

    public ToolCall(String id, String name, Map<String, ? extends Object> arguments, ToolStatus status, Map<String, ? extends Object> map, String str, String str2, Map<String, ? extends Object> map2) {
        kotlin.jvm.internal.p.i(id, "id");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(arguments, "arguments");
        kotlin.jvm.internal.p.i(status, "status");
        this.id = id;
        this.name = name;
        this.arguments = arguments;
        this.status = status;
        this.result = map;
        this.errorCode = str;
        this.errorMessage = str2;
        this.update = map2;
    }

    public final Map<String, Object> a() {
        return this.arguments;
    }

    /* renamed from: b, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: d, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCall)) {
            return false;
        }
        ToolCall toolCall = (ToolCall) other;
        return kotlin.jvm.internal.p.d(this.id, toolCall.id) && kotlin.jvm.internal.p.d(this.name, toolCall.name) && kotlin.jvm.internal.p.d(this.arguments, toolCall.arguments) && this.status == toolCall.status && kotlin.jvm.internal.p.d(this.result, toolCall.result) && kotlin.jvm.internal.p.d(this.errorCode, toolCall.errorCode) && kotlin.jvm.internal.p.d(this.errorMessage, toolCall.errorMessage) && kotlin.jvm.internal.p.d(this.update, toolCall.update);
    }

    public final Map<String, Object> f() {
        return this.result;
    }

    /* renamed from: g, reason: from getter */
    public final ToolStatus getStatus() {
        return this.status;
    }

    public final Map<String, Object> h() {
        return this.update;
    }

    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.arguments.hashCode()) * 31) + this.status.hashCode()) * 31;
        Map<String, Object> map = this.result;
        int iHashCode2 = (iHashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.errorCode;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.errorMessage;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map2 = this.update;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "ToolCall(id=" + this.id + ", name=" + this.name + ", arguments=" + this.arguments + ", status=" + this.status + ", result=" + this.result + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", update=" + this.update + ")";
    }
}
