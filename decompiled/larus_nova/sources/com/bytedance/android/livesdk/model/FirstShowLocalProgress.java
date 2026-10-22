package com.bytedance.android.livesdk.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/model/FirstShowLocalProgress;", "", "duration", "", "clickLatest", "", "ts", "(JZJ)V", "getClickLatest", "()Z", "getDuration", "()J", "getTs", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstShowLocalProgress {
    private final boolean clickLatest;
    private final long duration;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    private final long f153915ts;

    public static /* synthetic */ FirstShowLocalProgress copy$default(FirstShowLocalProgress r100, long r101, boolean r102, long r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.duration;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.clickLatest;
    L8:
        boolean r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.f153915ts;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.duration;
    }

    public final boolean component2() {
        return this.clickLatest;
    }

    public final long component3() {
        return this.f153915ts;
    }

    public final FirstShowLocalProgress copy(long r100, boolean r110, long r111) {
        return new FirstShowLocalProgress(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FirstShowLocalProgress) == false) goto L12;
        FirstShowLocalProgress r101 = (FirstShowLocalProgress) r100;
        if (this.duration == r101.duration) goto L8;
        return false;
    L8:
        if (this.clickLatest == r101.clickLatest) goto L10;
        return false;
    L10:
        if (this.f153915ts == r101.f153915ts) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public int hashCode() {
        long r100 = this.duration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.clickLatest;
        ?? r103 = r102;
        if (r102 == false) goto L5;
        r103 = 1;
    L5:
        long r104 = this.f153915ts;
        return ((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    }

    public String toString() {
        return "FirstShowLocalProgress(duration=" + this.duration + ", clickLatest=" + this.clickLatest + ", ts=" + this.f153915ts + ")";
    }

    public final boolean getClickLatest() {
        return this.clickLatest;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getTs() {
        return this.f153915ts;
    }

    public FirstShowLocalProgress(long r100, boolean r101, long r102) {
        this.duration = r100;
        this.clickLatest = r101;
        this.f153915ts = r102;
    }
}
