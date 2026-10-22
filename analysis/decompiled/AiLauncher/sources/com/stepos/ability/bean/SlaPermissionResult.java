package com.stepos.ability.bean;

import Z8.C1173v;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001<B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0013J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0013J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b$\u0010%Jl\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b(\u0010\u001fJ\u0010\u0010)\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b)\u0010\u0013J\u001a\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00100\u001a\u0004\b1\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b2\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b5\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b6\u0010\u0013R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00107\u001a\u0004\b8\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u00109\u001a\u0004\b:\u0010%¨\u0006="}, d2 = {"Lcom/stepos/ability/bean/SlaPermissionResult;", "Landroid/os/Parcelable;", "", "verdict", "", "canExecute", "denyReason", "", "deniedFunction", "reason", "errorCode", "", "Lcom/stepos/ability/bean/SlaFunctionDetail;", "details", "Landroid/os/Bundle;", "extra", "<init>", "(IZILjava/lang/String;Ljava/lang/String;ILjava/util/List;Landroid/os/Bundle;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "()Z", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "component7", "()Ljava/util/List;", "component8", "()Landroid/os/Bundle;", ChatTracker.CLICK_COPY, "(IZILjava/lang/String;Ljava/lang/String;ILjava/util/List;Landroid/os/Bundle;)Lcom/stepos/ability/bean/SlaPermissionResult;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getVerdict", "Z", "getCanExecute", "getDenyReason", "Ljava/lang/String;", "getDeniedFunction", "getReason", "getErrorCode", "Ljava/util/List;", "getDetails", "Landroid/os/Bundle;", "getExtra", "Companion", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SlaPermissionResult implements Parcelable {
    private final boolean canExecute;
    private final String deniedFunction;
    private final int denyReason;
    private final List<SlaFunctionDetail> details;
    private final int errorCode;
    private final Bundle extra;
    private final String reason;
    private final int verdict;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<SlaPermissionResult> CREATOR = new b();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ability/bean/SlaPermissionResult$a;", "", "<init>", "()V", "", "reason", "Lcom/stepos/ability/bean/SlaPermissionResult;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ability/bean/SlaPermissionResult;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.bean.SlaPermissionResult$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SlaPermissionResult a(String reason) {
            return new SlaPermissionResult(2, false, 0, null, reason, 280004, null, null, 200, null);
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<SlaPermissionResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SlaPermissionResult createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            int i10 = parcel.readInt();
            boolean z10 = parcel.readInt() != 0;
            int i11 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            int i12 = parcel.readInt();
            int i13 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i13);
            for (int i14 = 0; i14 != i13; i14++) {
                arrayList.add(SlaFunctionDetail.CREATOR.createFromParcel(parcel));
            }
            return new SlaPermissionResult(i10, z10, i11, string, string2, i12, arrayList, parcel.readBundle(SlaPermissionResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SlaPermissionResult[] newArray(int i10) {
            return new SlaPermissionResult[i10];
        }
    }

    public SlaPermissionResult(int i10, boolean z10, int i11, String str, String str2, int i12, List<SlaFunctionDetail> details, Bundle bundle) {
        p.i(details, "details");
        this.verdict = i10;
        this.canExecute = z10;
        this.denyReason = i11;
        this.deniedFunction = str;
        this.reason = str2;
        this.errorCode = i12;
        this.details = details;
        this.extra = bundle;
    }

    public static /* synthetic */ SlaPermissionResult copy$default(SlaPermissionResult slaPermissionResult, int i10, boolean z10, int i11, String str, String str2, int i12, List list, Bundle bundle, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i10 = slaPermissionResult.verdict;
        }
        if ((i13 & 2) != 0) {
            z10 = slaPermissionResult.canExecute;
        }
        if ((i13 & 4) != 0) {
            i11 = slaPermissionResult.denyReason;
        }
        if ((i13 & 8) != 0) {
            str = slaPermissionResult.deniedFunction;
        }
        if ((i13 & 16) != 0) {
            str2 = slaPermissionResult.reason;
        }
        if ((i13 & 32) != 0) {
            i12 = slaPermissionResult.errorCode;
        }
        if ((i13 & 64) != 0) {
            list = slaPermissionResult.details;
        }
        if ((i13 & 128) != 0) {
            bundle = slaPermissionResult.extra;
        }
        List list2 = list;
        Bundle bundle2 = bundle;
        String str3 = str2;
        int i14 = i12;
        return slaPermissionResult.copy(i10, z10, i11, str, str3, i14, list2, bundle2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVerdict() {
        return this.verdict;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanExecute() {
        return this.canExecute;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDenyReason() {
        return this.denyReason;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeniedFunction() {
        return this.deniedFunction;
    }

    /* renamed from: component5, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component6, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    public final List<SlaFunctionDetail> component7() {
        return this.details;
    }

    /* renamed from: component8, reason: from getter */
    public final Bundle getExtra() {
        return this.extra;
    }

    public final SlaPermissionResult copy(int verdict, boolean canExecute, int denyReason, String deniedFunction, String reason, int errorCode, List<SlaFunctionDetail> details, Bundle extra) {
        p.i(details, "details");
        return new SlaPermissionResult(verdict, canExecute, denyReason, deniedFunction, reason, errorCode, details, extra);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SlaPermissionResult)) {
            return false;
        }
        SlaPermissionResult slaPermissionResult = (SlaPermissionResult) other;
        return this.verdict == slaPermissionResult.verdict && this.canExecute == slaPermissionResult.canExecute && this.denyReason == slaPermissionResult.denyReason && p.d(this.deniedFunction, slaPermissionResult.deniedFunction) && p.d(this.reason, slaPermissionResult.reason) && this.errorCode == slaPermissionResult.errorCode && p.d(this.details, slaPermissionResult.details) && p.d(this.extra, slaPermissionResult.extra);
    }

    public final boolean getCanExecute() {
        return this.canExecute;
    }

    public final String getDeniedFunction() {
        return this.deniedFunction;
    }

    public final int getDenyReason() {
        return this.denyReason;
    }

    public final List<SlaFunctionDetail> getDetails() {
        return this.details;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final Bundle getExtra() {
        return this.extra;
    }

    public final String getReason() {
        return this.reason;
    }

    public final int getVerdict() {
        return this.verdict;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.verdict) * 31) + Boolean.hashCode(this.canExecute)) * 31) + Integer.hashCode(this.denyReason)) * 31;
        String str = this.deniedFunction;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.reason;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.errorCode)) * 31) + this.details.hashCode()) * 31;
        Bundle bundle = this.extra;
        return iHashCode3 + (bundle != null ? bundle.hashCode() : 0);
    }

    public String toString() {
        return "SlaPermissionResult(verdict=" + this.verdict + ", canExecute=" + this.canExecute + ", denyReason=" + this.denyReason + ", deniedFunction=" + this.deniedFunction + ", reason=" + this.reason + ", errorCode=" + this.errorCode + ", details=" + this.details + ", extra=" + this.extra + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeInt(this.verdict);
        dest.writeInt(this.canExecute ? 1 : 0);
        dest.writeInt(this.denyReason);
        dest.writeString(this.deniedFunction);
        dest.writeString(this.reason);
        dest.writeInt(this.errorCode);
        List<SlaFunctionDetail> list = this.details;
        dest.writeInt(list.size());
        Iterator<SlaFunctionDetail> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(dest, flags);
        }
        dest.writeBundle(this.extra);
    }

    public /* synthetic */ SlaPermissionResult(int i10, boolean z10, int i11, String str, String str2, int i12, List list, Bundle bundle, int i13, i iVar) {
        this(i10, z10, i11, (i13 & 8) != 0 ? null : str, (i13 & 16) != 0 ? null : str2, (i13 & 32) != 0 ? 0 : i12, (i13 & 64) != 0 ? C1173v.m() : list, (i13 & 128) != 0 ? null : bundle);
    }
}
