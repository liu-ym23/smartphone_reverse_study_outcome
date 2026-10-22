package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0010J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lstepai/android/llm/base/LLMRequestSimpleMessage;", "Landroid/os/Parcelable;", "Lstepai/android/llm/base/Role;", "role", "", "content", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/Role;Ljava/lang/String;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/Role;", "component2", "()Ljava/lang/String;", "copy", "(Lstepai/android/llm/base/Role;Ljava/lang/String;)Lstepai/android/llm/base/LLMRequestSimpleMessage;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/Role;", "getRole", "Ljava/lang/String;", "getContent", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMRequestSimpleMessage implements Parcelable {
    public static final Parcelable.Creator<LLMRequestSimpleMessage> CREATOR = new Creator();

    @SerializedName("content")
    private final String content;

    @SerializedName("role")
    private final Role role;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMRequestSimpleMessage> {
        @Override // android.os.Parcelable.Creator
        public final LLMRequestSimpleMessage createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new LLMRequestSimpleMessage((Role) parcel.readParcelable(LLMRequestSimpleMessage.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final LLMRequestSimpleMessage[] newArray(int i) {
            return new LLMRequestSimpleMessage[i];
        }
    }

    public LLMRequestSimpleMessage(Role role, String content) {
        k.f(role, "role");
        k.f(content, "content");
        this.role = role;
        this.content = content;
    }

    public static /* synthetic */ LLMRequestSimpleMessage copy$default(LLMRequestSimpleMessage lLMRequestSimpleMessage, Role role, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            role = lLMRequestSimpleMessage.role;
        }
        if ((i & 2) != 0) {
            str = lLMRequestSimpleMessage.content;
        }
        return lLMRequestSimpleMessage.copy(role, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final LLMRequestSimpleMessage copy(Role role, String content) {
        k.f(role, "role");
        k.f(content, "content");
        return new LLMRequestSimpleMessage(role, content);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMRequestSimpleMessage)) {
            return false;
        }
        LLMRequestSimpleMessage lLMRequestSimpleMessage = (LLMRequestSimpleMessage) other;
        return k.b(this.role, lLMRequestSimpleMessage.role) && k.b(this.content, lLMRequestSimpleMessage.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final Role getRole() {
        return this.role;
    }

    public int hashCode() {
        return this.content.hashCode() + (this.role.hashCode() * 31);
    }

    public String toString() {
        return "LLMRequestSimpleMessage(role=" + this.role + ", content=" + this.content + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeParcelable(this.role, flags);
        dest.writeString(this.content);
    }
}
