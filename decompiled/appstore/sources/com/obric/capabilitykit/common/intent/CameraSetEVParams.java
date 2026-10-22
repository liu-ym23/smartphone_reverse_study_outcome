package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetEVParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "ev", "", "valueType", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getEv", "()Ljava/lang/Double;", "setEv", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/CameraSetEVParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CameraSetEVParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<CameraSetEVParams> CREATOR = null;

    @Nullable
    private Double ev;

    @Nullable
    private String valueType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CameraSetEVParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CameraSetEVParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            Double r12 = null;
        L6:
            CameraSetEVParams r13 = new CameraSetEVParams(r12, r10.readString());
            int r14 = Math.min(r11, 0);
            ClassLoader r15 = Creator.class.getClassLoader();
            int r16 = 1;
        L7:
            if (r16 > r14) goto L9;
            r16 = r16 + 1;
        L9:
            if (r16 > r11) goto L11;
            a.d(r10, r15);
            r16 = r16 + 1;
            goto L9
        L11:
            return r13;
        L5:
            r12 = Double.valueOf(r10.readDouble());
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CameraSetEVParams[] newArray(int r10) {
            return new CameraSetEVParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetEVParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetEVParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetEVParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetEVParams copy$default(CameraSetEVParams r10, Double r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.ev;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.valueType;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final Double component1() {
        return this.ev;
    }

    @Nullable
    public final String component2() {
        return this.valueType;
    }

    @NotNull
    public final CameraSetEVParams copy(@Nullable Double r10, @Nullable String r11) {
        return new CameraSetEVParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CameraSetEVParams) == true) goto L8;
        return false;
    L8:
        CameraSetEVParams r11 = (CameraSetEVParams) r10;
        if (q.b(this.ev, r11.ev) == true) goto L12;
        return false;
    L12:
        if (q.b(this.valueType, r11.valueType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Double getEv() {
        return this.ev;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        Double r10 = this.ev;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.valueType;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof CameraSetEVParams) == true) goto L5;
        return this;
    L5:
        Double r11 = this.ev;
        if (r11 != null) goto L8;
        r11 = ((CameraSetEVParams) r10).ev;
    L8:
        String r12 = this.valueType;
        if (r12 != null) goto L12;
        r12 = ((CameraSetEVParams) r10).valueType;
    L12:
        return new CameraSetEVParams(r11, r12);
    }

    public final void setEv(@Nullable Double r10) {
        this.ev = r10;
    }

    public final void setValueType(@Nullable String r10) {
        this.valueType = r10;
    }

    @NotNull
    public String toString() {
        return "CameraSetEVParams(ev=" + this.ev + ", valueType=" + this.valueType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        Double r12 = this.ev;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeString(this.valueType);
        return;
    L5:
        r10.writeInt(1);
        r10.writeDouble(r12.doubleValue());
        goto L6
    }

    public CameraSetEVParams(@Nullable Double r10, @Nullable String r11) {
        this.ev = r10;
        this.valueType = r11;
    }

    public /* synthetic */ CameraSetEVParams(Double r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
