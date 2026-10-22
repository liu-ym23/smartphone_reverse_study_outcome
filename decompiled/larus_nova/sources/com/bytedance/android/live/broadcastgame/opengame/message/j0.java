package com.bytedance.android.live.broadcastgame.opengame.message;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j0 implements com.bytedance.android.live.broadcastgame.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f60237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f60238b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j0) == false) goto L10;
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f60237a, r101.f60237a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f60238b, r101.f60238b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f60237a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f60238b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformPerfFinishMessage(appId=" + this.f60237a + ", taskId=" + this.f60238b + ")";
    }

    public j0(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        this.f60237a = r100;
        this.f60238b = r101;
    }
}
