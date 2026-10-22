package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0011R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001b\u0010\u0011R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001e\u0010\u0011R'\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010$R'\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b%\u0010!¨\u0006&"}, d2 = {"LK6/L;", "", "", "clientEventId", "type", "timestampMs", "text", "toolCallId", "toolName", "", "arguments", "", "isError", "details", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/util/Map;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", Const.INTENT_KEY_UMID, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", "Ljava/lang/Boolean;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Boolean;", "c", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.L, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TranscriptEvent {
    private final Map<String, Object> arguments;
    private final String clientEventId;
    private final Map<String, Object> details;
    private final Boolean isError;
    private final String text;
    private final String timestampMs;
    private final String toolCallId;
    private final String toolName;
    private final String type;

    public TranscriptEvent(String clientEventId, String type, String str, String str2, String str3, String str4, Map<String, ? extends Object> map, Boolean bool, Map<String, ? extends Object> map2) {
        p.i(clientEventId, "clientEventId");
        p.i(type, "type");
        this.clientEventId = clientEventId;
        this.type = type;
        this.timestampMs = str;
        this.text = str2;
        this.toolCallId = str3;
        this.toolName = str4;
        this.arguments = map;
        this.isError = bool;
        this.details = map2;
    }

    public final Map<String, Object> a() {
        return this.arguments;
    }

    /* renamed from: b, reason: from getter */
    public final String getClientEventId() {
        return this.clientEventId;
    }

    public final Map<String, Object> c() {
        return this.details;
    }

    /* renamed from: d, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: e, reason: from getter */
    public final String getTimestampMs() {
        return this.timestampMs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranscriptEvent)) {
            return false;
        }
        TranscriptEvent transcriptEvent = (TranscriptEvent) other;
        return p.d(this.clientEventId, transcriptEvent.clientEventId) && p.d(this.type, transcriptEvent.type) && p.d(this.timestampMs, transcriptEvent.timestampMs) && p.d(this.text, transcriptEvent.text) && p.d(this.toolCallId, transcriptEvent.toolCallId) && p.d(this.toolName, transcriptEvent.toolName) && p.d(this.arguments, transcriptEvent.arguments) && p.d(this.isError, transcriptEvent.isError) && p.d(this.details, transcriptEvent.details);
    }

    /* renamed from: f, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: g, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: h, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((this.clientEventId.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.timestampMs;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toolCallId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.toolName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, Object> map = this.arguments;
        int iHashCode6 = (iHashCode5 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.isError;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Map<String, Object> map2 = this.details;
        return iHashCode7 + (map2 != null ? map2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Boolean getIsError() {
        return this.isError;
    }

    public String toString() {
        return "TranscriptEvent(clientEventId=" + this.clientEventId + ", type=" + this.type + ", timestampMs=" + this.timestampMs + ", text=" + this.text + ", toolCallId=" + this.toolCallId + ", toolName=" + this.toolName + ", arguments=" + this.arguments + ", isError=" + this.isError + ", details=" + this.details + ")";
    }

    public /* synthetic */ TranscriptEvent(String str, String str2, String str3, String str4, String str5, String str6, Map map, Boolean bool, Map map2, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : map, (i10 & 128) != 0 ? null : bool, (i10 & 256) != 0 ? null : map2);
    }
}
