package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PCSearchAppEntityParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\"\u001a\u00020\u001cHÖ\u0001J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010 H\u0016J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001cHÖ\u0001R.\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCSearchAppEntityParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "interactionType", "domains", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getDomains$annotations", "()V", "getDomains", "()[Ljava/lang/String;", "setDomains", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getQuResult", "setQuResult", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCSearchAppEntityParams;", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCSearchAppEntityParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCSearchAppEntityParams> CREATOR = null;
    String[] domains;
    private String interactionType;
    private String quResult;

    /* JADX INFO: compiled from: PCSearchAppEntityParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCSearchAppEntityParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCSearchAppEntityParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            PCSearchAppEntityParams r1 = new PCSearchAppEntityParams(r9.readString(), r9.readString(), null, 4, null);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = ParcelUtils.readValueSafely(r9, r8);
            if (r5 == null) goto L8;
            r1.domains = (String[]) r5;
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            ParcelUtils.skipValueSafely(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCSearchAppEntityParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCSearchAppEntityParams[] newArray(int r1) {
            return new PCSearchAppEntityParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCSearchAppEntityParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCSearchAppEntityParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PCSearchAppEntityParams copy$default(PCSearchAppEntityParams r0, String r1, String r2, String[] r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.quResult;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.interactionType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.domains;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public static /* synthetic */ void getDomains$annotations() {
    }

    public final String component1() {
        return this.quResult;
    }

    public final String component2() {
        return this.interactionType;
    }

    public final String[] component3() {
        return this.domains;
    }

    public final PCSearchAppEntityParams copy(String r1, String r2, String[] r3) {
        return new PCSearchAppEntityParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PCSearchAppEntityParams) == true) goto L8;
        return false;
    L8:
        PCSearchAppEntityParams r6 = (PCSearchAppEntityParams) r5;
        if (Intrinsics.areEqual(this.quResult, r6.quResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interactionType, r6.interactionType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.domains, r6.domains) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.quResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.interactionType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String[] r7 = this.domains;
        if (r7 == null) goto L15;
        r1 = Arrays.hashCode(r7);
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PCSearchAppEntityParams(quResult=" + this.quResult + ", interactionType=" + this.interactionType + ", domains=" + Arrays.toString(this.domains) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.quResult);
        r1.writeString(this.interactionType);
        r1.writeValue(this.domains);
    }

    public PCSearchAppEntityParams(String r1, String r2, String[] r3) {
        this.quResult = r1;
        this.interactionType = r2;
        this.domains = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ PCSearchAppEntityParams(String r2, String r3, String[] r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final String[] getDomains() {
        return this.domains;
    }

    public final void setDomains(String[] r1) {
        this.domains = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof PCSearchAppEntityParams) == false) goto L5;
        String r0 = this.quResult;
        if (r0 != null) goto L9;
        r0 = ((PCSearchAppEntityParams) r3).quResult;
    L9:
        String r1 = this.interactionType;
        if (r1 != null) goto L12;
        r1 = ((PCSearchAppEntityParams) r3).interactionType;
    L12:
        String[] r2 = this.domains;
        if (r2 != null) goto L16;
        r2 = ((PCSearchAppEntityParams) r3).domains;
    L16:
        return new PCSearchAppEntityParams(r0, r1, r2);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String[] r0 = this.domains;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ArraysKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
    }
}
