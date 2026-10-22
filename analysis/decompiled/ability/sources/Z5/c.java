package Z5;

import com.stepos.taskrobot.ability.OpenOnDisplayResult;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c implements OpenOnDisplayResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f1596a;
    public final int b;

    public c(String str, int i) {
        this.f1596a = str;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return k.b(this.f1596a, cVar.f1596a) && this.b == cVar.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (this.f1596a.hashCode() * 31);
    }

    public final String toString() {
        return androidx.constraintlayout.core.dsl.a.d(this.b, "Success(taskName=", this.f1596a, ", displayId=", ")");
    }
}
