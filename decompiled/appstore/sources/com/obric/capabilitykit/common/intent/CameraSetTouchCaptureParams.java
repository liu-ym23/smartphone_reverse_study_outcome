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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetTouchCaptureParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "touchMode", "", "(Ljava/lang/Boolean;)V", "getTouchMode", "()Ljava/lang/Boolean;", "setTouchMode", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/CameraSetTouchCaptureParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CameraSetTouchCaptureParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<CameraSetTouchCaptureParams> CREATOR = null;

    @Nullable
    private Boolean touchMode;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CameraSetTouchCaptureParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CameraSetTouchCaptureParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            int r12 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r13 = null;
        L10:
            CameraSetTouchCaptureParams r14 = new CameraSetTouchCaptureParams(r13);
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
        public final CameraSetTouchCaptureParams[] newArray(int r10) {
            return new CameraSetTouchCaptureParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetTouchCaptureParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CameraSetTouchCaptureParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetTouchCaptureParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetTouchCaptureParams copy$default(CameraSetTouchCaptureParams r10, Boolean r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.touchMode;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final Boolean component1() {
        return this.touchMode;
    }

    @NotNull
    public final CameraSetTouchCaptureParams copy(@Nullable Boolean r10) {
        return new CameraSetTouchCaptureParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CameraSetTouchCaptureParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.touchMode, ((CameraSetTouchCaptureParams) r10).touchMode) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final Boolean getTouchMode() {
        return this.touchMode;
    }

    public int hashCode() {
        Boolean r10 = this.touchMode;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof CameraSetTouchCaptureParams) == true) goto L5;
        return this;
    L5:
        Boolean r11 = this.touchMode;
        if (r11 != null) goto L9;
        r11 = ((CameraSetTouchCaptureParams) r10).touchMode;
    L9:
        return new CameraSetTouchCaptureParams(r11);
    }

    public final void setTouchMode(@Nullable Boolean r10) {
        this.touchMode = r10;
    }

    @NotNull
    public String toString() {
        return "CameraSetTouchCaptureParams(touchMode=" + this.touchMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        Boolean r12 = this.touchMode;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
    }

    public CameraSetTouchCaptureParams(@Nullable Boolean r10) {
        this.touchMode = r10;
    }

    public /* synthetic */ CameraSetTouchCaptureParams(Boolean r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
