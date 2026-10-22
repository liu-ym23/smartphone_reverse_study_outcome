package com.android.ttcjpaysdk.kmp.common.ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/ui/CJToastOptions;", "", "duration", "", "location", "", "<init>", "(ILjava/lang/String;)V", "getDuration$annotations", "()V", "getDuration", "()I", "getLocation$annotations", "getLocation", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJToastOptions {
    public static final int $stable = 0;
    private final int duration;
    private final String location;

    /* JADX WARN: Multi-variable type inference failed */
    public CJToastOptions() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CJToastOptions copy$default(CJToastOptions r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.duration;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.location;
    L9:
        return r100.copy(r101, r102);
    }

    public static /* synthetic */ void getDuration$annotations() {
    }

    public static /* synthetic */ void getLocation$annotations() {
    }

    public final int component1() {
        return this.duration;
    }

    public final String component2() {
        return this.location;
    }

    public final CJToastOptions copy(int r100, @ToastLocation(values = {"top", "center", "bottom"}) String r101) {
        Intrinsics.checkNotNullParameter(r101, "location");
        return new CJToastOptions(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJToastOptions) == true) goto L8;
        return false;
    L8:
        CJToastOptions r101 = (CJToastOptions) r100;
        if (this.duration == r101.duration) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.location, r101.location) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.duration * 31) + this.location.hashCode();
    }

    public String toString() {
        return "CJToastOptions(duration=" + this.duration + ", location=" + this.location + ')';
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getLocation() {
        return this.location;
    }

    public CJToastOptions(int r100, @ToastLocation(values = {"top", "center", "bottom"}) String r101) {
        Intrinsics.checkNotNullParameter(r101, "location");
        this.duration = r100;
        this.location = r101;
    }

    public /* synthetic */ CJToastOptions(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 2000;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "bottom";
    L8:
        this(r100, r101);
    }
}
