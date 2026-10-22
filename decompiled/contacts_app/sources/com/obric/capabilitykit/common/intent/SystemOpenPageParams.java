package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemOpenPageParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0012\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemOpenPageParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "pageType", "", "uri", "(Ljava/lang/String;Ljava/lang/String;)V", "getPageType", "()Ljava/lang/String;", "setPageType", "(Ljava/lang/String;)V", "getUri", "setUri", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemOpenPageParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<SystemOpenPageParams> CREATOR = null;
    private String pageType;
    private String uri;

    /* JADX INFO: compiled from: SystemOpenPageParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemOpenPageParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenPageParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            SystemOpenPageParams r1 = new SystemOpenPageParams(r5.readString(), r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenPageParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenPageParams[] newArray(int r1) {
            return new SystemOpenPageParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenPageParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenPageParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemOpenPageParams copy$default(SystemOpenPageParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.pageType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.uri;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.pageType;
    }

    public final String component2() {
        return this.uri;
    }

    public final SystemOpenPageParams copy(String r1, String r2) {
        return new SystemOpenPageParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SystemOpenPageParams) == true) goto L8;
        return false;
    L8:
        SystemOpenPageParams r6 = (SystemOpenPageParams) r5;
        if (Intrinsics.areEqual(this.pageType, r6.pageType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.pageType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.uri;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "SystemOpenPageParams(pageType=" + this.pageType + ", uri=" + this.uri + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.pageType);
        r1.writeString(this.uri);
    }

    public SystemOpenPageParams(String r1, String r2) {
        this.pageType = r1;
        this.uri = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ SystemOpenPageParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final String getPageType() {
        return this.pageType;
    }

    public final void setPageType(String r1) {
        this.pageType = r1;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String r1) {
        this.uri = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof SystemOpenPageParams) == false) goto L5;
        String r0 = this.pageType;
        if (r0 != null) goto L9;
        r0 = ((SystemOpenPageParams) r2).pageType;
    L9:
        String r1 = this.uri;
        if (r1 != null) goto L13;
        r1 = ((SystemOpenPageParams) r2).uri;
    L13:
        return new SystemOpenPageParams(r0, r1);
    L5:
        return this;
    }
}
