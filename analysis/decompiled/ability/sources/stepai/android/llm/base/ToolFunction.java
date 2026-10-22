package stepai.android.llm.base;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0016¨\u0006%"}, d2 = {"Lstepai/android/llm/base/ToolFunction;", "Landroid/os/Parcelable;", "", HintConstants.AUTOFILL_HINT_NAME, "description", "Lstepai/android/llm/base/ToolParameters;", "parameters", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Lstepai/android/llm/base/ToolParameters;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lstepai/android/llm/base/ToolParameters;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lstepai/android/llm/base/ToolParameters;)Lstepai/android/llm/base/ToolFunction;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getDescription", "Lstepai/android/llm/base/ToolParameters;", "getParameters", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ToolFunction implements Parcelable {
    public static final Parcelable.Creator<ToolFunction> CREATOR = new Creator();
    private final String description;
    private final String name;
    private final ToolParameters parameters;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ToolFunction> {
        @Override // android.os.Parcelable.Creator
        public final ToolFunction createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new ToolFunction(parcel.readString(), parcel.readString(), ToolParameters.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final ToolFunction[] newArray(int i) {
            return new ToolFunction[i];
        }
    }

    public ToolFunction(String name, String description, ToolParameters parameters) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(parameters, "parameters");
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public static /* synthetic */ ToolFunction copy$default(ToolFunction toolFunction, String str, String str2, ToolParameters toolParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolFunction.name;
        }
        if ((i & 2) != 0) {
            str2 = toolFunction.description;
        }
        if ((i & 4) != 0) {
            toolParameters = toolFunction.parameters;
        }
        return toolFunction.copy(str, str2, toolParameters);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final ToolParameters getParameters() {
        return this.parameters;
    }

    public final ToolFunction copy(String name, String description, ToolParameters parameters) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(parameters, "parameters");
        return new ToolFunction(name, description, parameters);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolFunction)) {
            return false;
        }
        ToolFunction toolFunction = (ToolFunction) other;
        return k.b(this.name, toolFunction.name) && k.b(this.description, toolFunction.description) && k.b(this.parameters, toolFunction.parameters);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final ToolParameters getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return this.parameters.hashCode() + a.c(this.name.hashCode() * 31, 31, this.description);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.description;
        ToolParameters toolParameters = this.parameters;
        StringBuilder sbW = a.w("ToolFunction(name=", str, ", description=", str2, ", parameters=");
        sbW.append(toolParameters);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.description);
        this.parameters.writeToParcel(dest, flags);
    }
}
