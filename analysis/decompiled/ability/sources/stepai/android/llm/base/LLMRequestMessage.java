package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0011J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0013R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010\u0015¨\u0006%"}, d2 = {"Lstepai/android/llm/base/LLMRequestMessage;", "Landroid/os/Parcelable;", "Lstepai/android/llm/base/Role;", "role", "", "Lstepai/android/llm/base/LLMRequestContent;", "contentList", AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/Role;Ljava/util/List;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/Role;", "component2", "()Ljava/util/List;", "copy", "(Lstepai/android/llm/base/Role;Ljava/util/List;)Lstepai/android/llm/base/LLMRequestMessage;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/Role;", "getRole", "Ljava/util/List;", "getContentList", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LLMRequestMessage implements Parcelable {
    public static final Parcelable.Creator<LLMRequestMessage> CREATOR = new Creator();

    @SerializedName("content")
    private final List<LLMRequestContent> contentList;

    @SerializedName("role")
    private final Role role;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LLMRequestMessage> {
        @Override // android.os.Parcelable.Creator
        public final LLMRequestMessage createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            Role role = (Role) parcel.readParcelable(LLMRequestMessage.class.getClassLoader());
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i6 = 0; i6 != i; i6++) {
                arrayList.add(parcel.readParcelable(LLMRequestMessage.class.getClassLoader()));
            }
            return new LLMRequestMessage(role, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final LLMRequestMessage[] newArray(int i) {
            return new LLMRequestMessage[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LLMRequestMessage(Role role, List<? extends LLMRequestContent> contentList) {
        k.f(role, "role");
        k.f(contentList, "contentList");
        this.role = role;
        this.contentList = contentList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LLMRequestMessage copy$default(LLMRequestMessage lLMRequestMessage, Role role, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            role = lLMRequestMessage.role;
        }
        if ((i & 2) != 0) {
            list = lLMRequestMessage.contentList;
        }
        return lLMRequestMessage.copy(role, list);
    }

    /* renamed from: component1, reason: from getter */
    public final Role getRole() {
        return this.role;
    }

    public final List<LLMRequestContent> component2() {
        return this.contentList;
    }

    public final LLMRequestMessage copy(Role role, List<? extends LLMRequestContent> contentList) {
        k.f(role, "role");
        k.f(contentList, "contentList");
        return new LLMRequestMessage(role, contentList);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LLMRequestMessage)) {
            return false;
        }
        LLMRequestMessage lLMRequestMessage = (LLMRequestMessage) other;
        return k.b(this.role, lLMRequestMessage.role) && k.b(this.contentList, lLMRequestMessage.contentList);
    }

    public final List<LLMRequestContent> getContentList() {
        return this.contentList;
    }

    public final Role getRole() {
        return this.role;
    }

    public int hashCode() {
        return this.contentList.hashCode() + (this.role.hashCode() * 31);
    }

    public String toString() {
        return "LLMRequestMessage(role=" + this.role + ", contentList=" + this.contentList + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeParcelable(this.role, flags);
        List<LLMRequestContent> list = this.contentList;
        dest.writeInt(list.size());
        Iterator<LLMRequestContent> it = list.iterator();
        while (it.hasNext()) {
            dest.writeParcelable(it.next(), flags);
        }
    }
}
