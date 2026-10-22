package com.bytedance.android.livesdk.room;

import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends ts2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HorizontalPlayEvent f157648a;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f157648a, ((g) r100).f157648a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        HorizontalPlayEvent r100 = this.f157648a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "OnHorizontalPlayEventData(horizontalPlayEvent=" + this.f157648a + ")";
    }

    public g(HorizontalPlayEvent r100) {
        this.f157648a = r100;
    }
}
