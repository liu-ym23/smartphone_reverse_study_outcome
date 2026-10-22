package stepai.android.llm.base.twoway;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lstepai/android/llm/base/twoway/TTSFlowData;", "", "type", "", "text", "reason", "message", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getText", "getReason", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TTSFlowData {
    private final String message;
    private final String reason;
    private final String text;
    private final String type;

    public TTSFlowData(String type, String text, String reason, String message) {
        k.f(type, "type");
        k.f(text, "text");
        k.f(reason, "reason");
        k.f(message, "message");
        this.type = type;
        this.text = text;
        this.reason = reason;
        this.message = message;
    }

    public static /* synthetic */ TTSFlowData copy$default(TTSFlowData tTSFlowData, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tTSFlowData.type;
        }
        if ((i & 2) != 0) {
            str2 = tTSFlowData.text;
        }
        if ((i & 4) != 0) {
            str3 = tTSFlowData.reason;
        }
        if ((i & 8) != 0) {
            str4 = tTSFlowData.message;
        }
        return tTSFlowData.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final TTSFlowData copy(String type, String text, String reason, String message) {
        k.f(type, "type");
        k.f(text, "text");
        k.f(reason, "reason");
        k.f(message, "message");
        return new TTSFlowData(type, text, reason, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TTSFlowData)) {
            return false;
        }
        TTSFlowData tTSFlowData = (TTSFlowData) other;
        return k.b(this.type, tTSFlowData.type) && k.b(this.text, tTSFlowData.text) && k.b(this.reason, tTSFlowData.reason) && k.b(this.message, tTSFlowData.message);
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.message.hashCode() + a.c(a.c(this.type.hashCode() * 31, 31, this.text), 31, this.reason);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.text;
        return androidx.appfunctions.metadata.a.p(a.w("TTSFlowData(type=", str, ", text=", str2, ", reason="), this.reason, ", message=", this.message, ")");
    }

    public /* synthetic */ TTSFlowData(String str, String str2, String str3, String str4, int i, e eVar) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
