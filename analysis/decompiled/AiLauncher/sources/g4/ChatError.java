package g4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lg4/a;", "", "Lg4/e;", "last_error", "<init>", "(Lg4/e;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lg4/e;", Const.INTENT_KEY_APIKEY, "()Lg4/e;", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: g4.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChatError {

    @SerializedName("last_error")
    private final Error last_error;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final Error getLast_error() {
        return this.last_error;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChatError) && p.d(this.last_error, ((ChatError) other).last_error);
    }

    public int hashCode() {
        Error error = this.last_error;
        if (error == null) {
            return 0;
        }
        return error.hashCode();
    }

    public String toString() {
        return "ChatError(last_error=" + this.last_error + ")";
    }

    public ChatError(Error error) {
        this.last_error = error;
    }

    public /* synthetic */ ChatError(Error error, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : error);
    }
}
