package b40;

import com.bytedance.android.live.cloudgrouplive.event.EventType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventType f17458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17459b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f17458a, r101.f17458a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f17459b, r101.f17459b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        EventType r100 = this.f17458a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17459b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CloudGroupLiveEvent(eventType=" + this.f17458a + ", eventInfo=" + this.f17459b + ")";
    }

    public a(EventType r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        this.f17458a = r100;
        this.f17459b = r101;
    }
}
