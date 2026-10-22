package af6;

import com.bytedance.lbs.trace.contract.TraceLevel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TraceLevel f3178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f3179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f3180d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f3177a, r101.f3177a) == true) goto L12;
        return false;
    L12:
        if (this.f3178b == r101.f3178b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f3179c, r101.f3179c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3180d, r101.f3180d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f3177a.hashCode() * 31) + this.f3178b.hashCode()) * 31;
        Long r101 = this.f3179c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f3180d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TraceEvent(eventName=" + this.f3177a + ", level=" + this.f3178b + ", durationMs=" + this.f3179c + ", customParams=" + this.f3180d + ')';
    }

    public b(String r100, TraceLevel r101, Long r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r103, "customParams");
        this.f3177a = r100;
        this.f3178b = r101;
        this.f3179c = r102;
        this.f3180d = r103;
    }
}
