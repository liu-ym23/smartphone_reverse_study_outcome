package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b%\u0010\u001cJ\u0012\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b(\u0010'J\u0012\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b)\u0010'J\u0012\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b*\u0010'J\u008e\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b-\u0010\u001eJ\u0010\u0010.\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b.\u0010\u001cJ\u001a\u00101\u001a\u00020\n2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u001eR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b5\u0010\u001eR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u00106\u001a\u0004\b7\u0010!R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b8\u0010!R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\b:\u0010$R\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010;\u001a\u0004\b<\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010=\u001a\u0004\b>\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010=\u001a\u0004\b?\u0010'R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010=\u001a\u0004\b@\u0010'R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010=\u001a\u0004\bA\u0010'¨\u0006B"}, d2 = {"Lstepai/android/llm/base/LLMRequest;", "Landroid/os/Parcelable;", "", AgentBusWakeContract.EXTRA_TRACE_ID, AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "Lstepai/android/llm/base/LLMRequestMessage;", "messages", "Lstepai/android/llm/base/Tool;", "tools", "", "stream", "", "maxTokens", "", LlmRuntimeArgsBundle.KEY_TEMPERATURE, "topP", "frequencyPenalty", "presencePenalty", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/List;", "component4", "component5", "()Z", "component6", "component7", "()Ljava/lang/Float;", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZILjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)Lstepai/android/llm/base/LLMRequest;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTraceId", "getModel", "Ljava/util/List;", "getMessages", "getTools", "Z", "getStream", "I", "getMaxTokens", "Ljava/lang/Float;", "getTemperature", "getTopP", "getFrequencyPenalty", "getPresencePenalty", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMRequest implements Parcelable {
    public static final Parcelable.Creator<LLMRequest> CREATOR = new Creator();

    @SerializedName("frequency_penalty")
    private final Float frequencyPenalty;

    @SerializedName(HighlightCallback.ARG_MAX_TOKENS)
    private final int maxTokens;
    private final List<LLMRequestMessage> messages;
    private final String model;

    @SerializedName("presence_penalty")
    private final Float presencePenalty;
    private final boolean stream;
    private final Float temperature;
    private final List<Tool> tools;

    @SerializedName("top_p")
    private final Float topP;
    private final String traceId;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMRequest> {
        @Override // android.os.Parcelable.Creator
        public final LLMRequest createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(i);
            for (int i6 = 0; i6 != i; i6++) {
                arrayList2.add(LLMRequestMessage.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i10 = parcel.readInt();
                arrayList = new ArrayList(i10);
                for (int i11 = 0; i11 != i10; i11++) {
                    arrayList.add(Tool.CREATOR.createFromParcel(parcel));
                }
            }
            return new LLMRequest(string, string2, arrayList2, arrayList, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() != 0 ? Float.valueOf(parcel.readFloat()) : null);
        }

        @Override // android.os.Parcelable.Creator
        public final LLMRequest[] newArray(int i) {
            return new LLMRequest[i];
        }
    }

    public LLMRequest(String str, String str2, List<LLMRequestMessage> messages, List<Tool> list, boolean z10, int i, Float f, Float f7, Float f9, Float f10) {
        k.f(messages, "messages");
        this.traceId = str;
        this.model = str2;
        this.messages = messages;
        this.tools = list;
        this.stream = z10;
        this.maxTokens = i;
        this.temperature = f;
        this.topP = f7;
        this.frequencyPenalty = f9;
        this.presencePenalty = f10;
    }

    public static /* synthetic */ LLMRequest copy$default(LLMRequest lLMRequest, String str, String str2, List list, List list2, boolean z10, int i, Float f, Float f7, Float f9, Float f10, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = lLMRequest.traceId;
        }
        if ((i6 & 2) != 0) {
            str2 = lLMRequest.model;
        }
        if ((i6 & 4) != 0) {
            list = lLMRequest.messages;
        }
        if ((i6 & 8) != 0) {
            list2 = lLMRequest.tools;
        }
        if ((i6 & 16) != 0) {
            z10 = lLMRequest.stream;
        }
        if ((i6 & 32) != 0) {
            i = lLMRequest.maxTokens;
        }
        if ((i6 & 64) != 0) {
            f = lLMRequest.temperature;
        }
        if ((i6 & 128) != 0) {
            f7 = lLMRequest.topP;
        }
        if ((i6 & 256) != 0) {
            f9 = lLMRequest.frequencyPenalty;
        }
        if ((i6 & 512) != 0) {
            f10 = lLMRequest.presencePenalty;
        }
        Float f11 = f9;
        Float f12 = f10;
        Float f13 = f;
        Float f14 = f7;
        boolean z11 = z10;
        int i10 = i;
        return lLMRequest.copy(str, str2, list, list2, z11, i10, f13, f14, f11, f12);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component10, reason: from getter */
    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final List<LLMRequestMessage> component3() {
        return this.messages;
    }

    public final List<Tool> component4() {
        return this.tools;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    /* renamed from: component6, reason: from getter */
    public final int getMaxTokens() {
        return this.maxTokens;
    }

    /* renamed from: component7, reason: from getter */
    public final Float getTemperature() {
        return this.temperature;
    }

    /* renamed from: component8, reason: from getter */
    public final Float getTopP() {
        return this.topP;
    }

    /* renamed from: component9, reason: from getter */
    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    public final LLMRequest copy(String traceId, String model, List<LLMRequestMessage> messages, List<Tool> tools, boolean stream, int maxTokens, Float temperature, Float topP, Float frequencyPenalty, Float presencePenalty) {
        k.f(messages, "messages");
        return new LLMRequest(traceId, model, messages, tools, stream, maxTokens, temperature, topP, frequencyPenalty, presencePenalty);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMRequest)) {
            return false;
        }
        LLMRequest lLMRequest = (LLMRequest) other;
        return k.b(this.traceId, lLMRequest.traceId) && k.b(this.model, lLMRequest.model) && k.b(this.messages, lLMRequest.messages) && k.b(this.tools, lLMRequest.tools) && this.stream == lLMRequest.stream && this.maxTokens == lLMRequest.maxTokens && k.b(this.temperature, lLMRequest.temperature) && k.b(this.topP, lLMRequest.topP) && k.b(this.frequencyPenalty, lLMRequest.frequencyPenalty) && k.b(this.presencePenalty, lLMRequest.presencePenalty);
    }

    public final Float getFrequencyPenalty() {
        return this.frequencyPenalty;
    }

    public final int getMaxTokens() {
        return this.maxTokens;
    }

    public final List<LLMRequestMessage> getMessages() {
        return this.messages;
    }

    public final String getModel() {
        return this.model;
    }

    public final Float getPresencePenalty() {
        return this.presencePenalty;
    }

    public final boolean getStream() {
        return this.stream;
    }

    public final Float getTemperature() {
        return this.temperature;
    }

    public final List<Tool> getTools() {
        return this.tools;
    }

    public final Float getTopP() {
        return this.topP;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        String str = this.traceId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.model;
        int iE = a.e(this.messages, (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31);
        List<Tool> list = this.tools;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.maxTokens, a.d((iE + (list == null ? 0 : list.hashCode())) * 31, 31, this.stream), 31);
        Float f = this.temperature;
        int iHashCode2 = (iA + (f == null ? 0 : f.hashCode())) * 31;
        Float f7 = this.topP;
        int iHashCode3 = (iHashCode2 + (f7 == null ? 0 : f7.hashCode())) * 31;
        Float f9 = this.frequencyPenalty;
        int iHashCode4 = (iHashCode3 + (f9 == null ? 0 : f9.hashCode())) * 31;
        Float f10 = this.presencePenalty;
        return iHashCode4 + (f10 != null ? f10.hashCode() : 0);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.model;
        List<LLMRequestMessage> list = this.messages;
        List<Tool> list2 = this.tools;
        boolean z10 = this.stream;
        int i = this.maxTokens;
        Float f = this.temperature;
        Float f7 = this.topP;
        Float f9 = this.frequencyPenalty;
        Float f10 = this.presencePenalty;
        StringBuilder sbW = B7.a.w("LLMRequest(traceId=", str, ", model=", str2, ", messages=");
        sbW.append(list);
        sbW.append(", tools=");
        sbW.append(list2);
        sbW.append(", stream=");
        sbW.append(z10);
        sbW.append(", maxTokens=");
        sbW.append(i);
        sbW.append(", temperature=");
        sbW.append(f);
        sbW.append(", topP=");
        sbW.append(f7);
        sbW.append(", frequencyPenalty=");
        sbW.append(f9);
        sbW.append(", presencePenalty=");
        sbW.append(f10);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.traceId);
        dest.writeString(this.model);
        List<LLMRequestMessage> list = this.messages;
        dest.writeInt(list.size());
        Iterator<LLMRequestMessage> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        List<Tool> list2 = this.tools;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<Tool> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        dest.writeInt(this.stream ? 1 : 0);
        dest.writeInt(this.maxTokens);
        Float f = this.temperature;
        if (f == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f.floatValue());
        }
        Float f7 = this.topP;
        if (f7 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f7.floatValue());
        }
        Float f9 = this.frequencyPenalty;
        if (f9 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f9.floatValue());
        }
        Float f10 = this.presencePenalty;
        if (f10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeFloat(f10.floatValue());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LLMRequest(String str, String str2, List list, List list2, boolean z10, int i, Float f, Float f7, Float f9, Float f10, int i6, e eVar) {
        Float fValueOf = Float.valueOf(0.0f);
        this((i6 & 1) != 0 ? null : str, str2, list, (i6 & 8) != 0 ? null : list2, (i6 & 16) != 0 ? false : z10, i, (i6 & 64) != 0 ? fValueOf : f, (i6 & 128) != 0 ? Float.valueOf(1.0f) : f7, (i6 & 256) != 0 ? fValueOf : f9, (i6 & 512) != 0 ? fValueOf : f10);
    }
}
