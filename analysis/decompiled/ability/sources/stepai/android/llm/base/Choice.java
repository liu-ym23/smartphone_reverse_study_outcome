package stepai.android.llm.base;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJD\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001cJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0014J\u001a\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b)\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010\u001aR\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010\u001c¨\u0006."}, d2 = {"Lstepai/android/llm/base/Choice;", "Landroid/os/Parcelable;", "", "index", "Lstepai/android/llm/base/LLMResponseMessage;", "message", "delta", "", "logrobs", "", "finishReason", AppAgent.CONSTRUCT, "(ILstepai/android/llm/base/LLMResponseMessage;Lstepai/android/llm/base/LLMResponseMessage;Ljava/lang/Boolean;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "component2", "()Lstepai/android/llm/base/LLMResponseMessage;", "component3", "component4", "()Ljava/lang/Boolean;", "component5", "()Ljava/lang/String;", "copy", "(ILstepai/android/llm/base/LLMResponseMessage;Lstepai/android/llm/base/LLMResponseMessage;Ljava/lang/Boolean;Ljava/lang/String;)Lstepai/android/llm/base/Choice;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getIndex", "Lstepai/android/llm/base/LLMResponseMessage;", "getMessage", "getDelta", "Ljava/lang/Boolean;", "getLogrobs", "Ljava/lang/String;", "getFinishReason", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Choice implements Parcelable {
    public static final Parcelable.Creator<Choice> CREATOR = new Creator();
    private final LLMResponseMessage delta;

    @SerializedName("finish_reason")
    private final String finishReason;
    private final int index;
    private final Boolean logrobs;
    private final LLMResponseMessage message;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Choice> {
        @Override // android.os.Parcelable.Creator
        public final Choice createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            k.f(parcel, "parcel");
            int i = parcel.readInt();
            Parcelable.Creator<LLMResponseMessage> creator = LLMResponseMessage.CREATOR;
            LLMResponseMessage lLMResponseMessageCreateFromParcel = creator.createFromParcel(parcel);
            LLMResponseMessage lLMResponseMessageCreateFromParcel2 = creator.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new Choice(i, lLMResponseMessageCreateFromParcel, lLMResponseMessageCreateFromParcel2, boolValueOf, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Choice[] newArray(int i) {
            return new Choice[i];
        }
    }

    public Choice(int i, LLMResponseMessage message, LLMResponseMessage delta, Boolean bool, String finishReason) {
        k.f(message, "message");
        k.f(delta, "delta");
        k.f(finishReason, "finishReason");
        this.index = i;
        this.message = message;
        this.delta = delta;
        this.logrobs = bool;
        this.finishReason = finishReason;
    }

    public static /* synthetic */ Choice copy$default(Choice choice, int i, LLMResponseMessage lLMResponseMessage, LLMResponseMessage lLMResponseMessage2, Boolean bool, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = choice.index;
        }
        if ((i6 & 2) != 0) {
            lLMResponseMessage = choice.message;
        }
        if ((i6 & 4) != 0) {
            lLMResponseMessage2 = choice.delta;
        }
        if ((i6 & 8) != 0) {
            bool = choice.logrobs;
        }
        if ((i6 & 16) != 0) {
            str = choice.finishReason;
        }
        String str2 = str;
        LLMResponseMessage lLMResponseMessage3 = lLMResponseMessage2;
        return choice.copy(i, lLMResponseMessage, lLMResponseMessage3, bool, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component2, reason: from getter */
    public final LLMResponseMessage getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final LLMResponseMessage getDelta() {
        return this.delta;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getLogrobs() {
        return this.logrobs;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFinishReason() {
        return this.finishReason;
    }

    public final Choice copy(int index, LLMResponseMessage message, LLMResponseMessage delta, Boolean logrobs, String finishReason) {
        k.f(message, "message");
        k.f(delta, "delta");
        k.f(finishReason, "finishReason");
        return new Choice(index, message, delta, logrobs, finishReason);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Choice)) {
            return false;
        }
        Choice choice = (Choice) other;
        return this.index == choice.index && k.b(this.message, choice.message) && k.b(this.delta, choice.delta) && k.b(this.logrobs, choice.logrobs) && k.b(this.finishReason, choice.finishReason);
    }

    public final LLMResponseMessage getDelta() {
        return this.delta;
    }

    public final String getFinishReason() {
        return this.finishReason;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Boolean getLogrobs() {
        return this.logrobs;
    }

    public final LLMResponseMessage getMessage() {
        return this.message;
    }

    public int hashCode() {
        int iHashCode = (this.delta.hashCode() + ((this.message.hashCode() + (Integer.hashCode(this.index) * 31)) * 31)) * 31;
        Boolean bool = this.logrobs;
        return this.finishReason.hashCode() + ((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31);
    }

    public String toString() {
        int i = this.index;
        LLMResponseMessage lLMResponseMessage = this.message;
        LLMResponseMessage lLMResponseMessage2 = this.delta;
        Boolean bool = this.logrobs;
        String str = this.finishReason;
        StringBuilder sb = new StringBuilder("Choice(index=");
        sb.append(i);
        sb.append(", message=");
        sb.append(lLMResponseMessage);
        sb.append(", delta=");
        sb.append(lLMResponseMessage2);
        sb.append(", logrobs=");
        sb.append(bool);
        sb.append(", finishReason=");
        return a.q(sb, str, ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        int iBooleanValue;
        k.f(dest, "dest");
        dest.writeInt(this.index);
        this.message.writeToParcel(dest, flags);
        this.delta.writeToParcel(dest, flags);
        Boolean bool = this.logrobs;
        if (bool == null) {
            iBooleanValue = 0;
        } else {
            dest.writeInt(1);
            iBooleanValue = bool.booleanValue();
        }
        dest.writeInt(iBooleanValue);
        dest.writeString(this.finishReason);
    }

    public /* synthetic */ Choice(int i, LLMResponseMessage lLMResponseMessage, LLMResponseMessage lLMResponseMessage2, Boolean bool, String str, int i6, e eVar) {
        this(i, lLMResponseMessage, lLMResponseMessage2, (i6 & 8) != 0 ? null : bool, str);
    }
}
