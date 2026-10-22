package com.bytedance.android.live.openplatform.api.model.shelf;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.data.AuditInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/shelf/AuditInfo;", "Landroid/os/Parcelable;", "", "auditType", "I", "b", "()I", "auditStatus", "getAuditStatus", "", "rejectReason", "Ljava/lang/String;", "getRejectReason", "()Ljava/lang/String;", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuditInfo implements Parcelable, h {
    public static final Parcelable.Creator<AuditInfo> CREATOR = null;

    @SerializedName("audit_status")
    protected int auditStatus;

    @SerializedName("audit_type")
    protected int auditType;

    @SerializedName("reject_reason")
    protected String rejectReason;

    public static class a implements Parcelable.Creator<AuditInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AuditInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new AuditInfo(r100.readInt(), r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AuditInfo[] newArray(int r100) {
            return new AuditInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AuditInfo(int r100, int r101, String r102) {
        this.auditType = r100;
        this.auditStatus = r101;
        this.rejectReason = r102;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuditInfo) == false) goto L12;
        AuditInfo r101 = (AuditInfo) r100;
        if (this.auditType == r101.auditType) goto L8;
        return false;
    L8:
        if (this.auditStatus == r101.auditStatus) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rejectReason, r101.rejectReason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.auditType * 31) + this.auditStatus) * 31;
        String r101 = this.rejectReason;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "AuditInfo(auditType=" + this.auditType + ", auditStatus=" + this.auditStatus + ", rejectReason=" + this.rejectReason + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.auditType);
        r100.writeInt(this.auditStatus);
        r100.writeString(this.rejectReason);
    }

    public AuditInfo() {
        this.auditType = 0;
        this.auditStatus = 0;
        this.rejectReason = null;
    }

    public final int b() {
        return this.auditType;
    }

    public AuditInfo(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.auditType = r100.i();
        r102 = r102 | 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.auditStatus = r100.i();
        r102 = r102 | 2;
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.rejectReason = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L18;
        this.auditType = 0;
    L18:
        if ((r102 & 2) != 0) goto L21;
        this.auditStatus = 0;
    L21:
        if (this.rejectReason != null) goto L36;
        this.rejectReason = null;
        return;
    }

    public static AuditInfo a(AuditInfo r100) {
        return new AuditInfo(r100.auditType, 0, r100.rejectReason);
    }
}
