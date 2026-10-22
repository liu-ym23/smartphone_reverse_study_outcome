package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PCGlobalSearchIntentParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003JJ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010)J\t\u0010*\u001a\u00020\bHÖ\u0001J\u0013\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\bHÖ\u0001J\u0012\u0010/\u001a\u00020\u00012\b\u00100\u001a\u0004\u0018\u00010-H\u0016J\t\u00101\u001a\u00020\u0004HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\bHÖ\u0001R&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0017\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010 \u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "quResult", "", "needDeepSearch", "", "limitCount", "", "interactionType", "meta", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getInteractionType$annotations", "()V", "getInteractionType", "()Ljava/lang/String;", "setInteractionType", "(Ljava/lang/String;)V", "getLimitCount$annotations", "getLimitCount", "()Ljava/lang/Integer;", "setLimitCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMeta$annotations", "getMeta", "setMeta", "getNeedDeepSearch$annotations", "getNeedDeepSearch", "()Ljava/lang/Boolean;", "setNeedDeepSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuResult", "setQuResult", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PCGlobalSearchIntentParams;", "describeContents", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCGlobalSearchIntentParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PCGlobalSearchIntentParams> CREATOR = null;
    String interactionType;
    Integer limitCount;
    String meta;
    Boolean needDeepSearch;
    private String quResult;

    /* JADX INFO: compiled from: PCGlobalSearchIntentParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PCGlobalSearchIntentParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCGlobalSearchIntentParams createFromParcel(Parcel r11) {
            int r0 = r11.readInt();
            Intrinsics.checkNotNullParameter(r11, "parcel");
            PCGlobalSearchIntentParams r1 = new PCGlobalSearchIntentParams(r11.readString(), null, null, null, null, 30, null);
            int r3 = Math.min(r0, 4);
            ClassLoader r10 = getClass().getClassLoader();
            int r5 = 1;
        L3:
            if (r5 > r3) goto L23;
            if (r5 != 1) goto L9;
            Object r6 = ParcelUtils.readValueSafely(r11, r10);
            if (r6 == null) goto L22;
            r1.needDeepSearch = (Boolean) r6;
        L22:
            r5 = r5 + 1;
            goto L3
        L9:
            if (r5 != 2) goto L14;
            Object r7 = ParcelUtils.readValueSafely(r11, r10);
            if (r7 == null) goto L22;
            r1.limitCount = (Integer) r7;
            goto L22
        L14:
            if (r5 != 3) goto L18;
            Object r8 = ParcelUtils.readValueSafely(r11, r10);
            if (r8 == null) goto L22;
            r1.interactionType = (String) r8;
            goto L22
        L18:
            if (r5 != 4) goto L22;
            Object r9 = ParcelUtils.readValueSafely(r11, r10);
            if (r9 == null) goto L22;
            r1.meta = (String) r9;
        L23:
            if (r5 > r0) goto L25;
            ParcelUtils.skipValueSafely(r11, r10);
            r5 = r5 + 1;
            goto L23
        L25:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCGlobalSearchIntentParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PCGlobalSearchIntentParams[] newArray(int r1) {
            return new PCGlobalSearchIntentParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PCGlobalSearchIntentParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PCGlobalSearchIntentParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PCGlobalSearchIntentParams copy$default(PCGlobalSearchIntentParams r3, String r4, Boolean r5, Integer r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.quResult;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.needDeepSearch;
    L8:
        Boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.limitCount;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.interactionType;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.meta;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getInteractionType$annotations() {
    }

    public static /* synthetic */ void getLimitCount$annotations() {
    }

    public static /* synthetic */ void getMeta$annotations() {
    }

    public static /* synthetic */ void getNeedDeepSearch$annotations() {
    }

    public final String component1() {
        return this.quResult;
    }

    public final Boolean component2() {
        return this.needDeepSearch;
    }

    public final Integer component3() {
        return this.limitCount;
    }

    public final String component4() {
        return this.interactionType;
    }

    public final String component5() {
        return this.meta;
    }

    public final PCGlobalSearchIntentParams copy(String r7, Boolean r8, Integer r9, String r10, String r11) {
        return new PCGlobalSearchIntentParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PCGlobalSearchIntentParams) == true) goto L8;
        return false;
    L8:
        PCGlobalSearchIntentParams r6 = (PCGlobalSearchIntentParams) r5;
        if (Intrinsics.areEqual(this.quResult, r6.quResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.needDeepSearch, r6.needDeepSearch) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.limitCount, r6.limitCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.interactionType, r6.interactionType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.meta, r6.meta) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.quResult;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.needDeepSearch;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.limitCount;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.interactionType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.meta;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PCGlobalSearchIntentParams(quResult=" + this.quResult + ", needDeepSearch=" + this.needDeepSearch + ", limitCount=" + this.limitCount + ", interactionType=" + this.interactionType + ", meta=" + this.meta + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(4);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.quResult);
        r1.writeValue(this.needDeepSearch);
        r1.writeValue(this.limitCount);
        r1.writeValue(this.interactionType);
        r1.writeValue(this.meta);
    }

    public PCGlobalSearchIntentParams(String r1, Boolean r2, Integer r3, String r4, String r5) {
        this.quResult = r1;
        this.needDeepSearch = r2;
        this.limitCount = r3;
        this.interactionType = r4;
        this.meta = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ PCGlobalSearchIntentParams(String r2, Boolean r3, Integer r4, String r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getQuResult() {
        return this.quResult;
    }

    public final void setQuResult(String r1) {
        this.quResult = r1;
    }

    public final Boolean getNeedDeepSearch() {
        return this.needDeepSearch;
    }

    public final void setNeedDeepSearch(Boolean r1) {
        this.needDeepSearch = r1;
    }

    public final Integer getLimitCount() {
        return this.limitCount;
    }

    public final void setLimitCount(Integer r1) {
        this.limitCount = r1;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final void setInteractionType(String r1) {
        this.interactionType = r1;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final void setMeta(String r1) {
        this.meta = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r8) {
        if ((r8 instanceof PCGlobalSearchIntentParams) == false) goto L5;
        String r0 = this.quResult;
        if (r0 != null) goto L9;
        r0 = ((PCGlobalSearchIntentParams) r8).quResult;
    L9:
        String r2 = r0;
        Boolean r1 = this.needDeepSearch;
        if (r1 != null) goto L12;
        r1 = ((PCGlobalSearchIntentParams) r8).needDeepSearch;
    L12:
        Boolean r3 = r1;
        Integer r4 = this.limitCount;
        if (r4 != null) goto L15;
        r4 = ((PCGlobalSearchIntentParams) r8).limitCount;
    L15:
        Integer r5 = r4;
        String r6 = this.interactionType;
        if (r6 != null) goto L18;
        r6 = ((PCGlobalSearchIntentParams) r8).interactionType;
    L18:
        String r7 = r6;
        String r9 = this.meta;
        if (r9 != null) goto L22;
        r9 = ((PCGlobalSearchIntentParams) r8).meta;
    L22:
        return new PCGlobalSearchIntentParams(r2, r3, r5, r7, r9);
    L5:
        return this;
    }
}
