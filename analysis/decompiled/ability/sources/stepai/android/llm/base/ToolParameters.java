package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0015J\u0010\u0010\u001d\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0013J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0015R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0017R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u0019¨\u0006)"}, d2 = {"Lstepai/android/llm/base/ToolParameters;", "Landroid/os/Parcelable;", "", "type", "", "Lstepai/android/llm/base/ToolProperty;", "properties", "", "required", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/Map;", "component3", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)Lstepai/android/llm/base/ToolParameters;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Ljava/util/Map;", "getProperties", "Ljava/util/List;", "getRequired", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolParameters implements Parcelable {
    public static final Parcelable.Creator<ToolParameters> CREATOR = new Creator();
    private final Map<String, ToolProperty> properties;
    private final List<String> required;
    private final String type;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ToolParameters> {
        @Override // android.os.Parcelable.Creator
        public final ToolParameters createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i);
            for (int i6 = 0; i6 != i; i6++) {
                linkedHashMap.put(parcel.readString(), ToolProperty.CREATOR.createFromParcel(parcel));
            }
            return new ToolParameters(string, linkedHashMap, parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final ToolParameters[] newArray(int i) {
            return new ToolParameters[i];
        }
    }

    public ToolParameters(String type, Map<String, ToolProperty> properties, List<String> required) {
        k.f(type, "type");
        k.f(properties, "properties");
        k.f(required, "required");
        this.type = type;
        this.properties = properties;
        this.required = required;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ToolParameters copy$default(ToolParameters toolParameters, String str, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolParameters.type;
        }
        if ((i & 2) != 0) {
            map = toolParameters.properties;
        }
        if ((i & 4) != 0) {
            list = toolParameters.required;
        }
        return toolParameters.copy(str, map, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final Map<String, ToolProperty> component2() {
        return this.properties;
    }

    public final List<String> component3() {
        return this.required;
    }

    public final ToolParameters copy(String type, Map<String, ToolProperty> properties, List<String> required) {
        k.f(type, "type");
        k.f(properties, "properties");
        k.f(required, "required");
        return new ToolParameters(type, properties, required);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolParameters)) {
            return false;
        }
        ToolParameters toolParameters = (ToolParameters) other;
        return k.b(this.type, toolParameters.type) && k.b(this.properties, toolParameters.properties) && k.b(this.required, toolParameters.required);
    }

    public final Map<String, ToolProperty> getProperties() {
        return this.properties;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.required.hashCode() + a.f(this.properties, this.type.hashCode() * 31, 31);
    }

    public String toString() {
        String str = this.type;
        Map<String, ToolProperty> map = this.properties;
        List<String> list = this.required;
        StringBuilder sb = new StringBuilder("ToolParameters(type=");
        sb.append(str);
        sb.append(", properties=");
        sb.append(map);
        sb.append(", required=");
        return a.q(sb, list, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.type);
        Map<String, ToolProperty> map = this.properties;
        dest.writeInt(map.size());
        for (Map.Entry<String, ToolProperty> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            entry.getValue().writeToParcel(dest, flags);
        }
        dest.writeStringList(this.required);
    }
}
