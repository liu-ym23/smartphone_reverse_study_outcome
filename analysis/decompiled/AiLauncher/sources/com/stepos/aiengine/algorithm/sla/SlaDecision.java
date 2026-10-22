package com.stepos.aiengine.algorithm.sla;

import Z8.C1173v;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b$\u0010%Jn\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b(\u0010\u001bJ\u0010\u0010)\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b)\u0010\u0019J\u001a\u0010-\u001a\u00020,2\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b-\u0010.R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010/\u001a\u0004\b0\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010/\u001a\u0004\b1\u0010\u001bR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00102\u001a\u0004\b3\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b4\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00105\u001a\u0004\b6\u0010!R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u00107\u001a\u0004\b8\u0010#R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010%¨\u0006;"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "Landroid/os/Parcelable;", "", "function", "text", "", "params", "priority", "", "confidence", "", "Lcom/stepos/aiengine/algorithm/sla/SlaAlternative;", "alternatives", "Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;", "rejectReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;FLjava/util/List;Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "component5", "()F", "component6", "()Ljava/util/List;", "component7", "()Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;FLjava/util/List;Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;)Lcom/stepos/aiengine/algorithm/sla/SlaDecision;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFunction", "getText", "Ljava/util/Map;", "getParams", "getPriority", "F", "getConfidence", "Ljava/util/List;", "getAlternatives", "Lcom/stepos/aiengine/algorithm/sla/SlaRejectReason;", "getRejectReason", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaDecision implements Parcelable {
    public static final Parcelable.Creator<SlaDecision> CREATOR = new Creator();
    private final List<SlaAlternative> alternatives;
    private final float confidence;
    private final String function;
    private final Map<String, String> params;
    private final String priority;
    private final SlaRejectReason rejectReason;
    private final String text;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SlaDecision> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaDecision createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            String string3 = parcel.readString();
            float f10 = parcel.readFloat();
            int i12 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i12);
            for (int i13 = 0; i13 != i12; i13++) {
                arrayList.add(SlaAlternative.CREATOR.createFromParcel(parcel));
            }
            return new SlaDecision(string, string2, linkedHashMap, string3, f10, arrayList, parcel.readInt() == 0 ? null : SlaRejectReason.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaDecision[] newArray(int i10) {
            return new SlaDecision[i10];
        }
    }

    public SlaDecision(String str, String text, Map<String, String> params, String str2, float f10, List<SlaAlternative> alternatives, SlaRejectReason slaRejectReason) {
        p.i(text, "text");
        p.i(params, "params");
        p.i(alternatives, "alternatives");
        this.function = str;
        this.text = text;
        this.params = params;
        this.priority = str2;
        this.confidence = f10;
        this.alternatives = alternatives;
        this.rejectReason = slaRejectReason;
    }

    public static /* synthetic */ SlaDecision copy$default(SlaDecision slaDecision, String str, String str2, Map map, String str3, float f10, List list, SlaRejectReason slaRejectReason, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = slaDecision.function;
        }
        if ((i10 & 2) != 0) {
            str2 = slaDecision.text;
        }
        if ((i10 & 4) != 0) {
            map = slaDecision.params;
        }
        if ((i10 & 8) != 0) {
            str3 = slaDecision.priority;
        }
        if ((i10 & 16) != 0) {
            f10 = slaDecision.confidence;
        }
        if ((i10 & 32) != 0) {
            list = slaDecision.alternatives;
        }
        if ((i10 & 64) != 0) {
            slaRejectReason = slaDecision.rejectReason;
        }
        List list2 = list;
        SlaRejectReason slaRejectReason2 = slaRejectReason;
        float f11 = f10;
        Map map2 = map;
        return slaDecision.copy(str, str2, map2, str3, f11, list2, slaRejectReason2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFunction() {
        return this.function;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final Map<String, String> component3() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    /* renamed from: component5, reason: from getter */
    public final float getConfidence() {
        return this.confidence;
    }

    public final List<SlaAlternative> component6() {
        return this.alternatives;
    }

    /* renamed from: component7, reason: from getter */
    public final SlaRejectReason getRejectReason() {
        return this.rejectReason;
    }

    public final SlaDecision copy(String function, String text, Map<String, String> params, String priority, float confidence, List<SlaAlternative> alternatives, SlaRejectReason rejectReason) {
        p.i(text, "text");
        p.i(params, "params");
        p.i(alternatives, "alternatives");
        return new SlaDecision(function, text, params, priority, confidence, alternatives, rejectReason);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaDecision)) {
            return false;
        }
        SlaDecision slaDecision = (SlaDecision) other;
        return p.d(this.function, slaDecision.function) && p.d(this.text, slaDecision.text) && p.d(this.params, slaDecision.params) && p.d(this.priority, slaDecision.priority) && Float.compare(this.confidence, slaDecision.confidence) == 0 && p.d(this.alternatives, slaDecision.alternatives) && this.rejectReason == slaDecision.rejectReason;
    }

    public final List<SlaAlternative> getAlternatives() {
        return this.alternatives;
    }

    public final float getConfidence() {
        return this.confidence;
    }

    public final String getFunction() {
        return this.function;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final SlaRejectReason getRejectReason() {
        return this.rejectReason;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.function;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31) + this.params.hashCode()) * 31;
        String str2 = this.priority;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Float.hashCode(this.confidence)) * 31) + this.alternatives.hashCode()) * 31;
        SlaRejectReason slaRejectReason = this.rejectReason;
        return iHashCode2 + (slaRejectReason != null ? slaRejectReason.hashCode() : 0);
    }

    public String toString() {
        return "SlaDecision(function=" + this.function + ", text=" + this.text + ", params=" + this.params + ", priority=" + this.priority + ", confidence=" + this.confidence + ", alternatives=" + this.alternatives + ", rejectReason=" + this.rejectReason + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.function);
        dest.writeString(this.text);
        Map<String, String> map = this.params;
        dest.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
        dest.writeString(this.priority);
        dest.writeFloat(this.confidence);
        List<SlaAlternative> list = this.alternatives;
        dest.writeInt(list.size());
        Iterator<SlaAlternative> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        SlaRejectReason slaRejectReason = this.rejectReason;
        if (slaRejectReason == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(slaRejectReason.name());
        }
    }

    public /* synthetic */ SlaDecision(String str, String str2, Map map, String str3, float f10, List list, SlaRejectReason slaRejectReason, int i10, i iVar) {
        this(str, str2, map, str3, f10, (i10 & 32) != 0 ? C1173v.m() : list, (i10 & 64) != 0 ? null : slaRejectReason);
    }
}
