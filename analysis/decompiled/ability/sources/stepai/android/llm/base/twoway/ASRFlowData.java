package stepai.android.llm.base.twoway;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lstepai/android/llm/base/twoway/ASRFlowData;", "", "type", "", "finalTranscript", "interimTranscript", "speechEvent", "reason", "message", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getFinalTranscript", "getInterimTranscript", "getSpeechEvent", "getReason", "getMessage", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ASRFlowData {

    @SerializedName("final_transcript")
    private final String finalTranscript;

    @SerializedName("interim_transcript")
    private final String interimTranscript;
    private final String message;
    private final String reason;

    @SerializedName("speech_event")
    private final String speechEvent;
    private final String type;

    public ASRFlowData(String type, String finalTranscript, String interimTranscript, String speechEvent, String reason, String message) {
        k.f(type, "type");
        k.f(finalTranscript, "finalTranscript");
        k.f(interimTranscript, "interimTranscript");
        k.f(speechEvent, "speechEvent");
        k.f(reason, "reason");
        k.f(message, "message");
        this.type = type;
        this.finalTranscript = finalTranscript;
        this.interimTranscript = interimTranscript;
        this.speechEvent = speechEvent;
        this.reason = reason;
        this.message = message;
    }

    public static /* synthetic */ ASRFlowData copy$default(ASRFlowData aSRFlowData, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aSRFlowData.type;
        }
        if ((i & 2) != 0) {
            str2 = aSRFlowData.finalTranscript;
        }
        if ((i & 4) != 0) {
            str3 = aSRFlowData.interimTranscript;
        }
        if ((i & 8) != 0) {
            str4 = aSRFlowData.speechEvent;
        }
        if ((i & 16) != 0) {
            str5 = aSRFlowData.reason;
        }
        if ((i & 32) != 0) {
            str6 = aSRFlowData.message;
        }
        String str7 = str5;
        String str8 = str6;
        return aSRFlowData.copy(str, str2, str3, str4, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFinalTranscript() {
        return this.finalTranscript;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInterimTranscript() {
        return this.interimTranscript;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSpeechEvent() {
        return this.speechEvent;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final ASRFlowData copy(String type, String finalTranscript, String interimTranscript, String speechEvent, String reason, String message) {
        k.f(type, "type");
        k.f(finalTranscript, "finalTranscript");
        k.f(interimTranscript, "interimTranscript");
        k.f(speechEvent, "speechEvent");
        k.f(reason, "reason");
        k.f(message, "message");
        return new ASRFlowData(type, finalTranscript, interimTranscript, speechEvent, reason, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ASRFlowData)) {
            return false;
        }
        ASRFlowData aSRFlowData = (ASRFlowData) other;
        return k.b(this.type, aSRFlowData.type) && k.b(this.finalTranscript, aSRFlowData.finalTranscript) && k.b(this.interimTranscript, aSRFlowData.interimTranscript) && k.b(this.speechEvent, aSRFlowData.speechEvent) && k.b(this.reason, aSRFlowData.reason) && k.b(this.message, aSRFlowData.message);
    }

    public final String getFinalTranscript() {
        return this.finalTranscript;
    }

    public final String getInterimTranscript() {
        return this.interimTranscript;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getSpeechEvent() {
        return this.speechEvent;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.message.hashCode() + a.c(a.c(a.c(a.c(this.type.hashCode() * 31, 31, this.finalTranscript), 31, this.interimTranscript), 31, this.speechEvent), 31, this.reason);
    }

    public String toString() {
        String str = this.type;
        String str2 = this.finalTranscript;
        String str3 = this.interimTranscript;
        String str4 = this.speechEvent;
        String str5 = this.reason;
        String str6 = this.message;
        StringBuilder sbW = a.w("ASRFlowData(type=", str, ", finalTranscript=", str2, ", interimTranscript=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", speechEvent=", str4, ", reason=");
        return androidx.appfunctions.metadata.a.p(sbW, str5, ", message=", str6, ")");
    }
}
