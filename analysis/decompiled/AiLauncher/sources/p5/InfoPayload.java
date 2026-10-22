package p5;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lp5/f;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "inputType", "Ljava/lang/String;", "getInputType", "taskName", "getTaskName", "placeholder", "getPlaceholder", "", "timeoutMs", "J", "getTimeoutMs", "()J", "inFullScreen", "Z", "getInFullScreen", "()Z", "", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: p5.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class InfoPayload {
    private final boolean inFullScreen;
    private final String inputType;
    private final List<String> options;
    private final String placeholder;
    private final String taskName;
    private final long timeoutMs;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InfoPayload)) {
            return false;
        }
        InfoPayload infoPayload = (InfoPayload) other;
        return p.d(this.inputType, infoPayload.inputType) && p.d(this.taskName, infoPayload.taskName) && p.d(this.placeholder, infoPayload.placeholder) && this.timeoutMs == infoPayload.timeoutMs && this.inFullScreen == infoPayload.inFullScreen && p.d(this.options, infoPayload.options);
    }

    public int hashCode() {
        int iHashCode = ((this.inputType.hashCode() * 31) + this.taskName.hashCode()) * 31;
        String str = this.placeholder;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timeoutMs)) * 31) + Boolean.hashCode(this.inFullScreen)) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "InfoPayload(inputType=" + this.inputType + ", taskName=" + this.taskName + ", placeholder=" + this.placeholder + ", timeoutMs=" + this.timeoutMs + ", inFullScreen=" + this.inFullScreen + ", options=" + this.options + ")";
    }
}
