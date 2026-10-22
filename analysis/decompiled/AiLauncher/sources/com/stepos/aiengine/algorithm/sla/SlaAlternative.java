package com.stepos.aiengine.algorithm.sla;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0015R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u001a¨\u0006+"}, d2 = {"Lcom/stepos/aiengine/algorithm/sla/SlaAlternative;", "Landroid/os/Parcelable;", "", "function", "text", "", "params", "", "confidence", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;F)V", "Landroid/os/Parcel;", "dest", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "component4", "()F", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;F)Lcom/stepos/aiengine/algorithm/sla/SlaAlternative;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFunction", "getText", "Ljava/util/Map;", "getParams", "F", "getConfidence", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaAlternative implements Parcelable {
    public static final Parcelable.Creator<SlaAlternative> CREATOR = new Creator();
    private final float confidence;
    private final String function;
    private final Map<String, String> params;
    private final String text;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SlaAlternative> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaAlternative createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i10 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new SlaAlternative(string, string2, linkedHashMap, parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SlaAlternative[] newArray(int i10) {
            return new SlaAlternative[i10];
        }
    }

    public SlaAlternative(String function, String text, Map<String, String> params, float f10) {
        p.i(function, "function");
        p.i(text, "text");
        p.i(params, "params");
        this.function = function;
        this.text = text;
        this.params = params;
        this.confidence = f10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SlaAlternative copy$default(SlaAlternative slaAlternative, String str, String str2, Map map, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = slaAlternative.function;
        }
        if ((i10 & 2) != 0) {
            str2 = slaAlternative.text;
        }
        if ((i10 & 4) != 0) {
            map = slaAlternative.params;
        }
        if ((i10 & 8) != 0) {
            f10 = slaAlternative.confidence;
        }
        return slaAlternative.copy(str, str2, map, f10);
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
    public final float getConfidence() {
        return this.confidence;
    }

    public final SlaAlternative copy(String function, String text, Map<String, String> params, float confidence) {
        p.i(function, "function");
        p.i(text, "text");
        p.i(params, "params");
        return new SlaAlternative(function, text, params, confidence);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaAlternative)) {
            return false;
        }
        SlaAlternative slaAlternative = (SlaAlternative) other;
        return p.d(this.function, slaAlternative.function) && p.d(this.text, slaAlternative.text) && p.d(this.params, slaAlternative.params) && Float.compare(this.confidence, slaAlternative.confidence) == 0;
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

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((((this.function.hashCode() * 31) + this.text.hashCode()) * 31) + this.params.hashCode()) * 31) + Float.hashCode(this.confidence);
    }

    public String toString() {
        return "SlaAlternative(function=" + this.function + ", text=" + this.text + ", params=" + this.params + ", confidence=" + this.confidence + ")";
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
        dest.writeFloat(this.confidence);
    }
}
