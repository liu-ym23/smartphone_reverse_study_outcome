package Z5;

import com.mdisdk.Task;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Task f1594a;
    public long b;

    public a(Task task) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f1594a = task;
        this.b = jCurrentTimeMillis;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.b(this.f1594a, aVar.f1594a) && this.b == aVar.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.f1594a.hashCode() * 31);
    }

    public final String toString() {
        return "TaskEntry(task=" + this.f1594a + ", lastUsedMs=" + this.b + ")";
    }
}
