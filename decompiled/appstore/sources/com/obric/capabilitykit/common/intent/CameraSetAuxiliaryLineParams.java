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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetAuxiliaryLineParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "enable", "", "mode", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/CameraSetAuxiliaryLineParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CameraSetAuxiliaryLineParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<CameraSetAuxiliaryLineParams> CREATOR = null;

    @Nullable
    private Boolean enable;

    @Nullable
    private String mode;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CameraSetAuxiliaryLineParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CameraSetAuxiliaryLineParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            int r12 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r13 = null;
        L10:
            CameraSetAuxiliaryLineParams r14 = new CameraSetAuxiliaryLineParams(r13, r10.readString());
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
        L11:
            if (r12 > r15) goto L13;
            r12 = r12 + 1;
        L13:
            if (r12 > r11) goto L15;
            a.d(r10, r16);
            r12 = r12 + 1;
            goto L13
        L15:
            return r14;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r17 = true;
        L9:
            r13 = Boolean.valueOf(r17);
            goto L10
        L8:
            r17 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CameraSetAuxiliaryLineParams[] newArray(int r10) {
            return new CameraSetAuxiliaryLineParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetAuxiliaryLineParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetAuxiliaryLineParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetAuxiliaryLineParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetAuxiliaryLineParams copy$default(CameraSetAuxiliaryLineParams r10, Boolean r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.enable;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.mode;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final Boolean component1() {
        return this.enable;
    }

    @Nullable
    public final String component2() {
        return this.mode;
    }

    @NotNull
    public final CameraSetAuxiliaryLineParams copy(@Nullable Boolean r10, @Nullable String r11) {
        return new CameraSetAuxiliaryLineParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CameraSetAuxiliaryLineParams) == true) goto L8;
        return false;
    L8:
        CameraSetAuxiliaryLineParams r11 = (CameraSetAuxiliaryLineParams) r10;
        if (q.b(this.enable, r11.enable) == true) goto L12;
        return false;
    L12:
        if (q.b(this.mode, r11.mode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Boolean getEnable() {
        return this.enable;
    }

    @Nullable
    public final String getMode() {
        return this.mode;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        Boolean r10 = this.enable;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.mode;
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
        if ((r10 instanceof CameraSetAuxiliaryLineParams) == true) goto L5;
        return this;
    L5:
        Boolean r11 = this.enable;
        if (r11 != null) goto L8;
        r11 = ((CameraSetAuxiliaryLineParams) r10).enable;
    L8:
        String r12 = this.mode;
        if (r12 != null) goto L12;
        r12 = ((CameraSetAuxiliaryLineParams) r10).mode;
    L12:
        return new CameraSetAuxiliaryLineParams(r11, r12);
    }

    public final void setEnable(@Nullable Boolean r10) {
        this.enable = r10;
    }

    public final void setMode(@Nullable String r10) {
        this.mode = r10;
    }

    @NotNull
    public String toString() {
        return "CameraSetAuxiliaryLineParams(enable=" + this.enable + ", mode=" + this.mode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        ?? r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        Boolean r13 = this.enable;
        if (r13 != null) goto L5;
    L4:
        r10.writeInt(r12);
        r10.writeString(this.mode);
        return;
    L5:
        r10.writeInt(1);
        r12 = r13.booleanValue();
        goto L4
    }

    public CameraSetAuxiliaryLineParams(@Nullable Boolean r10, @Nullable String r11) {
        this.enable = r10;
        this.mode = r11;
    }

    public /* synthetic */ CameraSetAuxiliaryLineParams(Boolean r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
