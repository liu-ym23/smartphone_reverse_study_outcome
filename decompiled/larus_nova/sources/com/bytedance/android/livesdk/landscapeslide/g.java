package com.bytedance.android.livesdk.landscapeslide;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f147008a;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f147008a, ((g) r100).f147008a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f147008a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LiveRoomOrientation(value=" + this.f147008a + ")";
    }

    public g(int r100) {
        this.f147008a = null;
    }
}
