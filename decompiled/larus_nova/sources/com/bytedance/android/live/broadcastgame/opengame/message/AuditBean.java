package com.bytedance.android.live.broadcastgame.opengame.message;

import com.baidu.mshield.x6.EngineImpl;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/message/AuditBean;", "", "md5", "", EngineImpl.KEY_OAID, SalesInfoStruct.REPEAT, "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getMd5", "()Ljava/lang/String;", "getOid", "getRepeat", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuditBean {

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    @SerializedName("md5")
    private final String f60181md5;

    @SerializedName(EngineImpl.KEY_OAID)
    private final String oid;

    @SerializedName(SalesInfoStruct.REPEAT)
    private final int repeat;

    public static /* synthetic */ AuditBean copy$default(AuditBean r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f60181md5;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.oid;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.repeat;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.f60181md5;
    }

    public final String component2() {
        return this.oid;
    }

    public final int component3() {
        return this.repeat;
    }

    public final AuditBean copy(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        Intrinsics.checkNotNullParameter(r101, EngineImpl.KEY_OAID);
        return new AuditBean(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuditBean) == false) goto L12;
        AuditBean r101 = (AuditBean) r100;
        if (Intrinsics.areEqual(this.f60181md5, r101.f60181md5) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.oid, r101.oid) == true) goto L10;
        return false;
    L10:
        if (this.repeat == r101.repeat) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.f60181md5;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.oid;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.repeat;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AuditBean(md5=" + this.f60181md5 + ", oid=" + this.oid + ", repeat=" + this.repeat + ")";
    }

    public final String getMd5() {
        return this.f60181md5;
    }

    public final String getOid() {
        return this.oid;
    }

    public final int getRepeat() {
        return this.repeat;
    }

    public AuditBean(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        Intrinsics.checkNotNullParameter(r101, EngineImpl.KEY_OAID);
        this.f60181md5 = r100;
        this.oid = r101;
        this.repeat = r102;
    }
}
