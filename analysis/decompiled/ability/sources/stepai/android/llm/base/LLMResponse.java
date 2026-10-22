package stepai.android.llm.base;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b%\u0010&J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u001cJ\u0082\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u001cJ\u0010\u0010+\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b+\u0010\u001aJ\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b/\u00100R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u00101\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u00105R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00101\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u00105R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b8\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b:\u0010!R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00101\u001a\u0004\b;\u0010\u001cR\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010<\u001a\u0004\b=\u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\b?\u0010&R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u00101\u001a\u0004\b@\u0010\u001c¨\u0006A"}, d2 = {"Lstepai/android/llm/base/LLMResponse;", "Landroid/os/Parcelable;", "", "code", "message", "id", "item", "", "created", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "Lstepai/android/llm/base/Choice;", "choices", "Lstepai/android/llm/base/Usage;", "usage", "serviceTier", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Lstepai/android/llm/base/Usage;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Ljava/lang/Long;", "component6", "component7", "()Ljava/util/List;", "component8", "()Lstepai/android/llm/base/Usage;", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Lstepai/android/llm/base/Usage;Ljava/lang/String;)Lstepai/android/llm/base/LLMResponse;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCode", "getMessage", "setMessage", "(Ljava/lang/String;)V", "getId", "setId", "getItem", "Ljava/lang/Long;", "getCreated", "getModel", "Ljava/util/List;", "getChoices", "Lstepai/android/llm/base/Usage;", "getUsage", "getServiceTier", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMResponse implements Parcelable {
    public static final Parcelable.Creator<LLMResponse> CREATOR = new Creator();
    private final List<Choice> choices;
    private final String code;
    private final Long created;
    private String id;

    @SerializedName("object")
    private final String item;
    private String message;
    private final String model;

    @SerializedName("service_tier")
    private final String serviceTier;
    private final Usage usage;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMResponse> {
        @Override // android.os.Parcelable.Creator
        public final LLMResponse createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            k.f(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            Long lValueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int i = parcel.readInt();
                arrayList = new ArrayList(i);
                for (int i6 = 0; i6 != i; i6++) {
                    arrayList.add(Choice.CREATOR.createFromParcel(parcel));
                }
            }
            return new LLMResponse(string, string2, string3, string4, lValueOf, string5, arrayList, parcel.readInt() != 0 ? Usage.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LLMResponse[] newArray(int i) {
            return new LLMResponse[i];
        }
    }

    public LLMResponse(String str, String str2, String str3, String str4, Long l, String str5, List<Choice> list, Usage usage, String str6) {
        this.code = str;
        this.message = str2;
        this.id = str3;
        this.item = str4;
        this.created = l;
        this.model = str5;
        this.choices = list;
        this.usage = usage;
        this.serviceTier = str6;
    }

    public static /* synthetic */ LLMResponse copy$default(LLMResponse lLMResponse, String str, String str2, String str3, String str4, Long l, String str5, List list, Usage usage, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lLMResponse.code;
        }
        if ((i & 2) != 0) {
            str2 = lLMResponse.message;
        }
        if ((i & 4) != 0) {
            str3 = lLMResponse.id;
        }
        if ((i & 8) != 0) {
            str4 = lLMResponse.item;
        }
        if ((i & 16) != 0) {
            l = lLMResponse.created;
        }
        if ((i & 32) != 0) {
            str5 = lLMResponse.model;
        }
        if ((i & 64) != 0) {
            list = lLMResponse.choices;
        }
        if ((i & 128) != 0) {
            usage = lLMResponse.usage;
        }
        if ((i & 256) != 0) {
            str6 = lLMResponse.serviceTier;
        }
        Usage usage2 = usage;
        String str7 = str6;
        String str8 = str5;
        List list2 = list;
        Long l5 = l;
        String str9 = str3;
        return lLMResponse.copy(str, str2, str9, str4, l5, str8, list2, usage2, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getItem() {
        return this.item;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getCreated() {
        return this.created;
    }

    /* renamed from: component6, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    public final List<Choice> component7() {
        return this.choices;
    }

    /* renamed from: component8, reason: from getter */
    public final Usage getUsage() {
        return this.usage;
    }

    /* renamed from: component9, reason: from getter */
    public final String getServiceTier() {
        return this.serviceTier;
    }

    public final LLMResponse copy(String code, String message, String id, String item, Long created, String model, List<Choice> choices, Usage usage, String serviceTier) {
        return new LLMResponse(code, message, id, item, created, model, choices, usage, serviceTier);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMResponse)) {
            return false;
        }
        LLMResponse lLMResponse = (LLMResponse) other;
        return k.b(this.code, lLMResponse.code) && k.b(this.message, lLMResponse.message) && k.b(this.id, lLMResponse.id) && k.b(this.item, lLMResponse.item) && k.b(this.created, lLMResponse.created) && k.b(this.model, lLMResponse.model) && k.b(this.choices, lLMResponse.choices) && k.b(this.usage, lLMResponse.usage) && k.b(this.serviceTier, lLMResponse.serviceTier);
    }

    public final List<Choice> getChoices() {
        return this.choices;
    }

    public final String getCode() {
        return this.code;
    }

    public final Long getCreated() {
        return this.created;
    }

    public final String getId() {
        return this.id;
    }

    public final String getItem() {
        return this.item;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getServiceTier() {
        return this.serviceTier;
    }

    public final Usage getUsage() {
        return this.usage;
    }

    public int hashCode() {
        String str = this.code;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.item;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l = this.created;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.model;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<Choice> list = this.choices;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Usage usage = this.usage;
        int iHashCode8 = (iHashCode7 + (usage == null ? 0 : usage.hashCode())) * 31;
        String str6 = this.serviceTier;
        return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        String str = this.code;
        String str2 = this.message;
        String str3 = this.id;
        String str4 = this.item;
        Long l = this.created;
        String str5 = this.model;
        List<Choice> list = this.choices;
        Usage usage = this.usage;
        String str6 = this.serviceTier;
        StringBuilder sbW = a.w("LLMResponse(code=", str, ", message=", str2, ", id=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", item=", str4, ", created=");
        sbW.append(l);
        sbW.append(", model=");
        sbW.append(str5);
        sbW.append(", choices=");
        sbW.append(list);
        sbW.append(", usage=");
        sbW.append(usage);
        sbW.append(", serviceTier=");
        return a.q(sbW, str6, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.code);
        dest.writeString(this.message);
        dest.writeString(this.id);
        dest.writeString(this.item);
        Long l = this.created;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeString(this.model);
        List<Choice> list = this.choices;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<Choice> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        Usage usage = this.usage;
        if (usage == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            usage.writeToParcel(dest, flags);
        }
        dest.writeString(this.serviceTier);
    }
}
