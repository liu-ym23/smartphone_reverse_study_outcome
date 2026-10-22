package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJR\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u0010\u0010 \u001a\u00020\fHÖ\u0001¢\u0006\u0004\b \u0010\u000eJ\u001a\u0010#\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b'\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b(\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b)\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010*\u001a\u0004\b+\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010*\u001a\u0004\b,\u0010\u001b¨\u0006-"}, d2 = {"Lcom/stepos/ability/bean/SlaFunctionDetail;", "Landroid/os/Parcelable;", "", "function", "scope", "groupId", "mode", "", "redline", "allowed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Z", "component6", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/stepos/ability/bean/SlaFunctionDetail;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFunction", "getScope", "getGroupId", "getMode", "Z", "getRedline", "getAllowed", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaFunctionDetail implements Parcelable {
    public static final Parcelable.Creator<SlaFunctionDetail> CREATOR = new a();
    private final boolean allowed;
    private final String function;
    private final String groupId;
    private final String mode;
    private final boolean redline;
    private final String scope;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<SlaFunctionDetail> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SlaFunctionDetail createFromParcel(Parcel parcel) {
            boolean z10;
            p.i(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            boolean z11 = false;
            if (parcel.readInt() != 0) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
            return new SlaFunctionDetail(string, string2, string3, string4, z11, parcel.readInt() == 0 ? z10 : true);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SlaFunctionDetail[] newArray(int i10) {
            return new SlaFunctionDetail[i10];
        }
    }

    public SlaFunctionDetail(String function, String str, String str2, String str3, boolean z10, boolean z11) {
        p.i(function, "function");
        this.function = function;
        this.scope = str;
        this.groupId = str2;
        this.mode = str3;
        this.redline = z10;
        this.allowed = z11;
    }

    public static /* synthetic */ SlaFunctionDetail copy$default(SlaFunctionDetail slaFunctionDetail, String str, String str2, String str3, String str4, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = slaFunctionDetail.function;
        }
        if ((i10 & 2) != 0) {
            str2 = slaFunctionDetail.scope;
        }
        if ((i10 & 4) != 0) {
            str3 = slaFunctionDetail.groupId;
        }
        if ((i10 & 8) != 0) {
            str4 = slaFunctionDetail.mode;
        }
        if ((i10 & 16) != 0) {
            z10 = slaFunctionDetail.redline;
        }
        if ((i10 & 32) != 0) {
            z11 = slaFunctionDetail.allowed;
        }
        boolean z12 = z10;
        boolean z13 = z11;
        return slaFunctionDetail.copy(str, str2, str3, str4, z12, z13);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFunction() {
        return this.function;
    }

    /* renamed from: component2, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRedline() {
        return this.redline;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAllowed() {
        return this.allowed;
    }

    public final SlaFunctionDetail copy(String function, String scope, String groupId, String mode, boolean redline, boolean allowed) {
        p.i(function, "function");
        return new SlaFunctionDetail(function, scope, groupId, mode, redline, allowed);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaFunctionDetail)) {
            return false;
        }
        SlaFunctionDetail slaFunctionDetail = (SlaFunctionDetail) other;
        return p.d(this.function, slaFunctionDetail.function) && p.d(this.scope, slaFunctionDetail.scope) && p.d(this.groupId, slaFunctionDetail.groupId) && p.d(this.mode, slaFunctionDetail.mode) && this.redline == slaFunctionDetail.redline && this.allowed == slaFunctionDetail.allowed;
    }

    public final boolean getAllowed() {
        return this.allowed;
    }

    public final String getFunction() {
        return this.function;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getMode() {
        return this.mode;
    }

    public final boolean getRedline() {
        return this.redline;
    }

    public final String getScope() {
        return this.scope;
    }

    public int hashCode() {
        int iHashCode = this.function.hashCode() * 31;
        String str = this.scope;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mode;
        return ((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Boolean.hashCode(this.redline)) * 31) + Boolean.hashCode(this.allowed);
    }

    public String toString() {
        return "SlaFunctionDetail(function=" + this.function + ", scope=" + this.scope + ", groupId=" + this.groupId + ", mode=" + this.mode + ", redline=" + this.redline + ", allowed=" + this.allowed + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.function);
        dest.writeString(this.scope);
        dest.writeString(this.groupId);
        dest.writeString(this.mode);
        dest.writeInt(this.redline ? 1 : 0);
        dest.writeInt(this.allowed ? 1 : 0);
    }

    public /* synthetic */ SlaFunctionDetail(String str, String str2, String str3, String str4, boolean z10, boolean z11, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }
}
