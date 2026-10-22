package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfficeSearchLarkContactInfoByAsrParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\bJ \u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\rJ\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fHÖ\u0001R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeSearchLarkContactInfoByAsrParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "audioFiles", "", "", "([Ljava/lang/String;)V", "getAudioFiles", "()[Ljava/lang/String;", "setAudioFiles", "[Ljava/lang/String;", "component1", "copy", "([Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/OfficeSearchLarkContactInfoByAsrParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OfficeSearchLarkContactInfoByAsrParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> CREATOR = null;
    private String[] audioFiles;

    /* JADX INFO: compiled from: OfficeSearchLarkContactInfoByAsrParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OfficeSearchLarkContactInfoByAsrParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            OfficeSearchLarkContactInfoByAsrParams r1 = new OfficeSearchLarkContactInfoByAsrParams(r5.createStringArray());
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
        public /* bridge */ /* synthetic */ OfficeSearchLarkContactInfoByAsrParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSearchLarkContactInfoByAsrParams[] newArray(int r1) {
            return new OfficeSearchLarkContactInfoByAsrParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSearchLarkContactInfoByAsrParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeSearchLarkContactInfoByAsrParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ OfficeSearchLarkContactInfoByAsrParams copy$default(OfficeSearchLarkContactInfoByAsrParams r0, String[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.audioFiles;
    L6:
        return r0.copy(r1);
    }

    public final String[] component1() {
        return this.audioFiles;
    }

    public final OfficeSearchLarkContactInfoByAsrParams copy(String[] r1) {
        return new OfficeSearchLarkContactInfoByAsrParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof OfficeSearchLarkContactInfoByAsrParams) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.audioFiles, ((OfficeSearchLarkContactInfoByAsrParams) r4).audioFiles) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String[] r0 = this.audioFiles;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "OfficeSearchLarkContactInfoByAsrParams(audioFiles=" + Arrays.toString(this.audioFiles) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeStringArray(this.audioFiles);
    }

    public OfficeSearchLarkContactInfoByAsrParams(String[] r1) {
        this.audioFiles = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ OfficeSearchLarkContactInfoByAsrParams(String[] r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final String[] getAudioFiles() {
        return this.audioFiles;
    }

    public final void setAudioFiles(String[] r1) {
        this.audioFiles = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof OfficeSearchLarkContactInfoByAsrParams) == false) goto L5;
        String[] r1 = this.audioFiles;
        if (r1 != null) goto L10;
        r1 = ((OfficeSearchLarkContactInfoByAsrParams) r2).audioFiles;
    L10:
        return new OfficeSearchLarkContactInfoByAsrParams(r1);
    L5:
        return this;
    }
}
