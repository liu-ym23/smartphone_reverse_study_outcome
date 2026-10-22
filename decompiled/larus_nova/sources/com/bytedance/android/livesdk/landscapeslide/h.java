package com.bytedance.android.livesdk.landscapeslide;

import com.tencent.connect.share.QzonePublish;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f147009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f147010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pair<Integer, Integer> f147011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f147012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f147013e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (this.f147009a == r101.f147009a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f147010b, r101.f147010b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f147011c, r101.f147011c) == true) goto L12;
        return false;
    L12:
        if (this.f147012d == r101.f147012d) goto L14;
        return false;
    L14:
        if (this.f147013e == r101.f147013e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public final int hashCode() {
        long r100 = this.f147009a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f147010b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        Pair<Integer, Integer> r106 = this.f147011c;
        if (r106 == null) goto L9;
        r103 = r106.hashCode();
    L9:
        int r107 = (((r105 + r103) * 31) + this.f147012d) * 31;
        boolean r108 = this.f147013e;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        return r107 + r109;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "RoomInfo(roomId=" + this.f147009a + ", anchorId=" + this.f147010b + ", videoSize=" + this.f147011c + ", screenOrientation=" + this.f147012d + ", enableSwitch=" + this.f147013e + ')';
    }

    public h(long r100, String r101, Pair<Integer, Integer> r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE);
        this.f147009a = r100;
        this.f147010b = r101;
        this.f147011c = r102;
        this.f147012d = r103;
        this.f147013e = r104;
    }
}
