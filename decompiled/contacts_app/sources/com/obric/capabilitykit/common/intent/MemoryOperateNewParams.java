package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MemoryOperateNewParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemoryOperateNewParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "toolParams", "", "sources", "extras", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtras", "()Ljava/lang/String;", "setExtras", "(Ljava/lang/String;)V", "getSources", "setSources", "getToolParams", "setToolParams", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryOperateNewParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MemoryOperateNewParams> CREATOR = null;
    private String extras;
    private String sources;
    private String toolParams;

    /* JADX INFO: compiled from: MemoryOperateNewParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MemoryOperateNewParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryOperateNewParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            MemoryOperateNewParams r1 = new MemoryOperateNewParams(r6.readString(), r6.readString(), r6.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryOperateNewParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MemoryOperateNewParams[] newArray(int r1) {
            return new MemoryOperateNewParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryOperateNewParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MemoryOperateNewParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MemoryOperateNewParams copy$default(MemoryOperateNewParams r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.toolParams;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.sources;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.extras;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.toolParams;
    }

    public final String component2() {
        return this.sources;
    }

    public final String component3() {
        return this.extras;
    }

    public final MemoryOperateNewParams copy(String r1, String r2, String r3) {
        return new MemoryOperateNewParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MemoryOperateNewParams) == true) goto L8;
        return false;
    L8:
        MemoryOperateNewParams r6 = (MemoryOperateNewParams) r5;
        if (Intrinsics.areEqual(this.toolParams, r6.toolParams) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sources, r6.sources) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extras, r6.extras) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.toolParams;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sources;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extras;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
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
        return "MemoryOperateNewParams(toolParams=" + this.toolParams + ", sources=" + this.sources + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.toolParams);
        r1.writeString(this.sources);
        r1.writeString(this.extras);
    }

    public MemoryOperateNewParams(String r1, String r2, String r3) {
        this.toolParams = r1;
        this.sources = r2;
        this.extras = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ MemoryOperateNewParams(String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
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

    public final String getToolParams() {
        return this.toolParams;
    }

    public final void setToolParams(String r1) {
        this.toolParams = r1;
    }

    public final String getSources() {
        return this.sources;
    }

    public final void setSources(String r1) {
        this.sources = r1;
    }

    public final String getExtras() {
        return this.extras;
    }

    public final void setExtras(String r1) {
        this.extras = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.toolParams != null) goto L5;
    L7:
        return false;
    L5:
        if (this.sources == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof MemoryOperateNewParams) == false) goto L5;
        String r0 = this.toolParams;
        if (r0 != null) goto L9;
        r0 = ((MemoryOperateNewParams) r3).toolParams;
    L9:
        String r1 = this.sources;
        if (r1 != null) goto L12;
        r1 = ((MemoryOperateNewParams) r3).sources;
    L12:
        String r2 = this.extras;
        if (r2 != null) goto L16;
        r2 = ((MemoryOperateNewParams) r3).extras;
    L16:
        return new MemoryOperateNewParams(r0, r1, r2);
    L5:
        return this;
    }
}
