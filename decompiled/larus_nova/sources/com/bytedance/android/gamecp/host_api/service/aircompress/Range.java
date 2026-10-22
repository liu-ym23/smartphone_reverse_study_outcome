package com.bytedance.android.gamecp.host_api.service.aircompress;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/service/aircompress/Range;", "", "offset", "", "length", "(JJ)V", "getLength", "()J", "getOffset", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Range {
    private final long length;
    private final long offset;

    public Range() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ Range copy$default(Range r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.offset;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.length;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.offset;
    }

    public final long component2() {
        return this.length;
    }

    public final Range copy(long r100, long r101) {
        return new Range(r100, r101);
    }

    public String toString() {
        return "Range(offset=" + this.offset + ", length=" + this.length + ")";
    }

    public int hashCode() {
        long r100 = this.offset;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.length;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final long getLength() {
        return this.length;
    }

    public final long getOffset() {
        return this.offset;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(Range.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        Range r102 = (Range) r100;
        if (this.offset == r102.offset) goto L17;
        return false;
    L17:
        if (this.length == r102.length) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.gamecp.host_api.service.aircompress.Range");
    L8:
        r101 = null;
        goto L10
    }

    public Range(long r100, long r101) {
        this.offset = r100;
        this.length = r101;
    }

    public /* synthetic */ Range(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
