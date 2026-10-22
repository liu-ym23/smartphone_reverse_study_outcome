package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/android/llm/base/Tool;", "Landroid/os/Parcelable;", "", "type", "Lstepai/android/llm/base/ToolFunction;", "function", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lstepai/android/llm/base/ToolFunction;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "()Lstepai/android/llm/base/ToolFunction;", "copy", "(Ljava/lang/String;Lstepai/android/llm/base/ToolFunction;)Lstepai/android/llm/base/Tool;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getType", "Lstepai/android/llm/base/ToolFunction;", "getFunction", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Tool implements Parcelable {
    public static final Parcelable.Creator<Tool> CREATOR = new Creator();
    private final ToolFunction function;
    private final String type;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Tool> {
        @Override // android.os.Parcelable.Creator
        public final Tool createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new Tool(parcel.readString(), ToolFunction.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final Tool[] newArray(int i) {
            return new Tool[i];
        }
    }

    public Tool(String type, ToolFunction function) {
        k.f(type, "type");
        k.f(function, "function");
        this.type = type;
        this.function = function;
    }

    public static /* synthetic */ Tool copy$default(Tool tool, String str, ToolFunction toolFunction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tool.type;
        }
        if ((i & 2) != 0) {
            toolFunction = tool.function;
        }
        return tool.copy(str, toolFunction);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final ToolFunction getFunction() {
        return this.function;
    }

    public final Tool copy(String type, ToolFunction function) {
        k.f(type, "type");
        k.f(function, "function");
        return new Tool(type, function);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tool)) {
            return false;
        }
        Tool tool = (Tool) other;
        return k.b(this.type, tool.type) && k.b(this.function, tool.function);
    }

    public final ToolFunction getFunction() {
        return this.function;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.function.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "Tool(type=" + this.type + ", function=" + this.function + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.type);
        this.function.writeToParcel(dest, flags);
    }
}
