package ci9;

import com.larus.lbs.trace.api.model.LbsTraceLevel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LbsTraceLevel f23899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f23901d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f23898a, r101.f23898a) == true) goto L12;
        return false;
    L12:
        if (this.f23899b == r101.f23899b) goto L15;
        return false;
    L15:
        if (this.f23900c == r101.f23900c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23901d, r101.f23901d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f23898a.hashCode() * 31) + this.f23899b.hashCode()) * 31;
        long r101 = this.f23900c;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f23901d.hashCode();
    }

    public final String toString() {
        return "LbsTraceEventParam(eventName=" + this.f23898a + ", level=" + this.f23899b + ", durationMs=" + this.f23900c + ", customParams=" + this.f23901d + ')';
    }

    public b(String r100, LbsTraceLevel r101, long r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r103, "customParams");
        this.f23898a = r100;
        this.f23899b = r101;
        this.f23900c = r102;
        this.f23901d = r103;
    }
}
