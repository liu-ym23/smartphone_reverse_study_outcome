package b37;

import com.bytedance.navigation.kmp.data.NavigationTraceLevel;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NavigationTraceLevel f17271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f17272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f17273d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f17270a, r101.f17270a) == true) goto L12;
        return false;
    L12:
        if (this.f17271b == r101.f17271b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17272c, r101.f17272c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17273d, r101.f17273d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f17270a.hashCode() * 31) + this.f17271b.hashCode()) * 31;
        Long r101 = this.f17272c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f17273d.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "NavigationTraceEvent(eventName=" + this.f17270a + ", level=" + this.f17271b + ", durationMs=" + this.f17272c + ", customParams=" + this.f17273d + ")";
    }

    public k(String r100, NavigationTraceLevel r101, Long r102, Map<String, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "level");
        Intrinsics.checkNotNullParameter(r103, "customParams");
        this.f17270a = r100;
        this.f17271b = r101;
        this.f17272c = r102;
        this.f17273d = r103;
    }

    public /* synthetic */ k(String r100, NavigationTraceLevel r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = NavigationTraceLevel.INFO;
    L6:
        if ((r103 & 8) == 0) goto L8;
        r102 = MapsKt.emptyMap();
    L8:
        this(r100, r101, null, r102);
    }
}
