package com.bytedance.android.livehostapi.business.depend.share;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/LiveFansContactData;", "", "extra", "", "", "uid", "", "secUid", "cid", "(Ljava/util/Map;JLjava/lang/String;J)V", "getCid", "()J", "getExtra", "()Ljava/util/Map;", "getSecUid", "()Ljava/lang/String;", "getUid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFansContactData {
    private final long cid;
    private final Map<String, Object> extra;
    private final String secUid;
    private final long uid;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveFansContactData copy$default(LiveFansContactData r100, Map r101, long r102, String r103, long r104, int r110, Object r111) {
        if ((r110 & 1) == 0) goto L6;
        r101 = r100.extra;
    L6:
        if ((r110 & 2) == 0) goto L8;
        r102 = r100.uid;
    L8:
        long r105 = r102;
        if ((r110 & 4) == 0) goto L11;
        r103 = r100.secUid;
    L11:
        String r112 = r103;
        if ((r110 & 8) == 0) goto L14;
        r104 = r100.cid;
    L14:
        Map r106 = r101;
        return r100.copy(r106, r105, r112, r104);
    }

    public final Map<String, Object> component1() {
        return this.extra;
    }

    public final long component2() {
        return this.uid;
    }

    public final String component3() {
        return this.secUid;
    }

    public final long component4() {
        return this.cid;
    }

    public final LiveFansContactData copy(Map<String, ? extends Object> r100, long r110, String r111, long r112) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r111, "secUid");
        return new LiveFansContactData(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveFansContactData) == false) goto L14;
        LiveFansContactData r101 = (LiveFansContactData) r100;
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L8;
        return false;
    L8:
        if (this.uid == r101.uid) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.secUid, r101.secUid) == true) goto L12;
        return false;
    L12:
        if (this.cid == r101.cid) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Map<String, Object> r100 = this.extra;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.uid;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.secUid;
        if (r105 == null) goto L9;
        r101 = r105.hashCode();
    L9:
        int r106 = (r104 + r101) * 31;
        long r107 = this.cid;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "LiveFansContactData(extra=" + this.extra + ", uid=" + this.uid + ", secUid=" + this.secUid + ", cid=" + this.cid + ")";
    }

    public final long getCid() {
        return this.cid;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final long getUid() {
        return this.uid;
    }

    public LiveFansContactData(Map<String, ? extends Object> r100, long r101, String r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        this.extra = r100;
        this.uid = r101;
        this.secUid = r102;
        this.cid = r103;
    }
}
