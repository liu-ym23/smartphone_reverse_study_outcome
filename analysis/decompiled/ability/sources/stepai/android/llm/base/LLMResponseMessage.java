package stepai.android.llm.base;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J@\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001c\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0012J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010\u0014R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u0018¨\u0006("}, d2 = {"Lstepai/android/llm/base/LLMResponseMessage;", "Landroid/os/Parcelable;", "", "role", "content", "refusal", "", "annotations", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lstepai/android/llm/base/LLMResponseMessage;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRole", "getContent", "getRefusal", "Ljava/util/List;", "getAnnotations", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMResponseMessage implements Parcelable {
    public static final Parcelable.Creator<LLMResponseMessage> CREATOR = new Creator();
    private final List<String> annotations;
    private final String content;
    private final String refusal;
    private final String role;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMResponseMessage> {
        @Override // android.os.Parcelable.Creator
        public final LLMResponseMessage createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new LLMResponseMessage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        public final LLMResponseMessage[] newArray(int i) {
            return new LLMResponseMessage[i];
        }
    }

    public LLMResponseMessage(String str, String str2, String str3, List list, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? EmptyList.f4893a : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LLMResponseMessage copy$default(LLMResponseMessage lLMResponseMessage, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = lLMResponseMessage.role;
        }
        if ((i & 2) != 0) {
            str2 = lLMResponseMessage.content;
        }
        if ((i & 4) != 0) {
            str3 = lLMResponseMessage.refusal;
        }
        if ((i & 8) != 0) {
            list = lLMResponseMessage.annotations;
        }
        return lLMResponseMessage.copy(str, str2, str3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRefusal() {
        return this.refusal;
    }

    public final List<String> component4() {
        return this.annotations;
    }

    public final LLMResponseMessage copy(String role, String content, String refusal, List<String> annotations) {
        k.f(role, "role");
        k.f(content, "content");
        k.f(annotations, "annotations");
        return new LLMResponseMessage(role, content, refusal, annotations);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMResponseMessage)) {
            return false;
        }
        LLMResponseMessage lLMResponseMessage = (LLMResponseMessage) other;
        return k.b(this.role, lLMResponseMessage.role) && k.b(this.content, lLMResponseMessage.content) && k.b(this.refusal, lLMResponseMessage.refusal) && k.b(this.annotations, lLMResponseMessage.annotations);
    }

    public final List<String> getAnnotations() {
        return this.annotations;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getRefusal() {
        return this.refusal;
    }

    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        int iC = a.c(this.role.hashCode() * 31, 31, this.content);
        String str = this.refusal;
        return this.annotations.hashCode() + ((iC + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        String str = this.role;
        String str2 = this.content;
        String str3 = this.refusal;
        List<String> list = this.annotations;
        StringBuilder sbW = a.w("LLMResponseMessage(role=", str, ", content=", str2, ", refusal=");
        sbW.append(str3);
        sbW.append(", annotations=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.role);
        dest.writeString(this.content);
        dest.writeString(this.refusal);
        dest.writeStringList(this.annotations);
    }

    public LLMResponseMessage(String role, String content, String str, List<String> annotations) {
        k.f(role, "role");
        k.f(content, "content");
        k.f(annotations, "annotations");
        this.role = role;
        this.content = content;
        this.refusal = str;
        this.annotations = annotations;
    }
}
