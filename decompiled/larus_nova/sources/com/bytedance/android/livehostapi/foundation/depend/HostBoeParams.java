package com.bytedance.android.livehostapi.foundation.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/HostBoeParams;", "", "boeEnable", "", "ppeEnable", "boeLane", "", "ppeLane", "(ZZLjava/lang/String;Ljava/lang/String;)V", "getBoeEnable", "()Z", "setBoeEnable", "(Z)V", "getBoeLane", "()Ljava/lang/String;", "setBoeLane", "(Ljava/lang/String;)V", "getPpeEnable", "setPpeEnable", "getPpeLane", "setPpeLane", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HostBoeParams {
    private boolean boeEnable;
    private String boeLane;
    private boolean ppeEnable;
    private String ppeLane;

    public HostBoeParams() {
        this(false, false, null, null, 15, null);
    }

    public HostBoeParams(boolean r100) {
        this(r100, false, null, null, 14, null);
    }

    public HostBoeParams(boolean r100, boolean r101) {
        this(r100, r101, null, null, 12, null);
    }

    public HostBoeParams(boolean r100, boolean r101, String r110) {
        this(r100, r101, r110, null, 8, null);
    }

    public final boolean getBoeEnable() {
        return this.boeEnable;
    }

    public final String getBoeLane() {
        return this.boeLane;
    }

    public final boolean getPpeEnable() {
        return this.ppeEnable;
    }

    public final String getPpeLane() {
        return this.ppeLane;
    }

    public final void setBoeEnable(boolean r100) {
        this.boeEnable = r100;
    }

    public final void setBoeLane(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.boeLane = r100;
    }

    public final void setPpeEnable(boolean r100) {
        this.ppeEnable = r100;
    }

    public final void setPpeLane(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ppeLane = r100;
    }

    public HostBoeParams(boolean r100, boolean r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "boeLane");
        Intrinsics.checkNotNullParameter(r103, "ppeLane");
        this.boeEnable = r100;
        this.ppeEnable = r101;
        this.boeLane = r102;
        this.ppeLane = r103;
    }

    public /* synthetic */ HostBoeParams(boolean r100, boolean r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "prod";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "prod";
    L14:
        this(r100, r101, r102, r103);
    }
}
