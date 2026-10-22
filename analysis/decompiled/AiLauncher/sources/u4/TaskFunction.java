package u4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0011"}, d2 = {"Lu4/n;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "arguments", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "name", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.n, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskFunction {
    private final String arguments;
    private final String name;

    /* renamed from: a, reason: from getter */
    public final String getArguments() {
        return this.arguments;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskFunction)) {
            return false;
        }
        TaskFunction taskFunction = (TaskFunction) other;
        return p.d(this.arguments, taskFunction.arguments) && p.d(this.name, taskFunction.name);
    }

    public int hashCode() {
        return (this.arguments.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "TaskFunction(arguments=" + this.arguments + ", name=" + this.name + ")";
    }
}
