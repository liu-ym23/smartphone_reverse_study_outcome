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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0012\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H\u0016J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemGetWebUrlParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "setReason", "component1", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemGetWebUrlParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemGetWebUrlParams> CREATOR = null;

    @Nullable
    private String reason;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemGetWebUrlParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemGetWebUrlParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemGetWebUrlParams r12 = new SystemGetWebUrlParams(r10.readString());
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemGetWebUrlParams[] newArray(int r10) {
            return new SystemGetWebUrlParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemGetWebUrlParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemGetWebUrlParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemGetWebUrlParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemGetWebUrlParams copy$default(SystemGetWebUrlParams r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.reason;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final String component1() {
        return this.reason;
    }

    @NotNull
    public final SystemGetWebUrlParams copy(@Nullable String r10) {
        return new SystemGetWebUrlParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemGetWebUrlParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.reason, ((SystemGetWebUrlParams) r10).reason) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.reason;
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
        if ((r10 instanceof SystemGetWebUrlParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.reason;
        if (r11 != null) goto L9;
        r11 = ((SystemGetWebUrlParams) r10).reason;
    L9:
        return new SystemGetWebUrlParams(r11);
    }

    public final void setReason(@Nullable String r10) {
        this.reason = r10;
    }

    @NotNull
    public String toString() {
        return "SystemGetWebUrlParams(reason=" + this.reason + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.reason);
    }

    public SystemGetWebUrlParams(@Nullable String r10) {
        this.reason = r10;
    }

    public /* synthetic */ SystemGetWebUrlParams(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
