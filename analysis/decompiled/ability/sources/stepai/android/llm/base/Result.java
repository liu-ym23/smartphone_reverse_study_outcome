package stepai.android.llm.base;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ@\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u0010\u0010\u001e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b(\u0010\u0017R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010\u001a¨\u0006+"}, d2 = {"Lstepai/android/llm/base/Result;", "Landroid/os/Parcelable;", "Lstepai/android/llm/base/LLMResponse;", "extra", "", "content", "tools", "", NotificationCompat.CATEGORY_ERROR, AppAgent.CONSTRUCT, "(Lstepai/android/llm/base/LLMResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Landroid/os/Parcel;", "dest", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Lstepai/android/llm/base/LLMResponse;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/lang/Throwable;", "copy", "(Lstepai/android/llm/base/LLMResponse;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)Lstepai/android/llm/base/Result;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lstepai/android/llm/base/LLMResponse;", "getExtra", "Ljava/lang/String;", "getContent", "getTools", "Ljava/lang/Throwable;", "getErr", "llmbase_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new Creator();
    private final String content;
    private final Throwable err;
    private final LLMResponse extra;
    private final String tools;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Result> {
        @Override // android.os.Parcelable.Creator
        public final Result createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new Result(parcel.readInt() == 0 ? null : LLMResponse.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), (Throwable) parcel.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final Result[] newArray(int i) {
            return new Result[i];
        }
    }

    public Result() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Result copy$default(Result result, LLMResponse lLMResponse, String str, String str2, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            lLMResponse = result.extra;
        }
        if ((i & 2) != 0) {
            str = result.content;
        }
        if ((i & 4) != 0) {
            str2 = result.tools;
        }
        if ((i & 8) != 0) {
            th = result.err;
        }
        return result.copy(lLMResponse, str, str2, th);
    }

    /* renamed from: component1, reason: from getter */
    public final LLMResponse getExtra() {
        return this.extra;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTools() {
        return this.tools;
    }

    /* renamed from: component4, reason: from getter */
    public final Throwable getErr() {
        return this.err;
    }

    public final Result copy(LLMResponse extra, String content, String tools, Throwable err) {
        return new Result(extra, content, tools, err);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Result)) {
            return false;
        }
        Result result = (Result) other;
        return k.b(this.extra, result.extra) && k.b(this.content, result.content) && k.b(this.tools, result.tools) && k.b(this.err, result.err);
    }

    public final String getContent() {
        return this.content;
    }

    public final Throwable getErr() {
        return this.err;
    }

    public final LLMResponse getExtra() {
        return this.extra;
    }

    public final String getTools() {
        return this.tools;
    }

    public int hashCode() {
        LLMResponse lLMResponse = this.extra;
        int iHashCode = (lLMResponse == null ? 0 : lLMResponse.hashCode()) * 31;
        String str = this.content;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.tools;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Throwable th = this.err;
        return iHashCode3 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "Result(extra=" + this.extra + ", content=" + this.content + ", tools=" + this.tools + ", err=" + this.err + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        LLMResponse lLMResponse = this.extra;
        if (lLMResponse == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            lLMResponse.writeToParcel(dest, flags);
        }
        dest.writeString(this.content);
        dest.writeString(this.tools);
        dest.writeSerializable(this.err);
    }

    public Result(LLMResponse lLMResponse, String str, String str2, Throwable th) {
        this.extra = lLMResponse;
        this.content = str;
        this.tools = str2;
        this.err = th;
    }

    public /* synthetic */ Result(LLMResponse lLMResponse, String str, String str2, Throwable th, int i, e eVar) {
        this((i & 1) != 0 ? null : lLMResponse, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : th);
    }
}
