package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.AddField;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0014\u001a\u00020\u000eHÖ\u0001J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eHÖ\u0001R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemUserAuthorizeParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "scene", "", "(Ljava/lang/String;)V", "getScene$annotations", "()V", "getScene", "()Ljava/lang/String;", "setScene", "component1", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemUserAuthorizeParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemUserAuthorizeParams> CREATOR = null;

    @AddField
    @Nullable
    String scene;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemUserAuthorizeParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemUserAuthorizeParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemUserAuthorizeParams r12 = new SystemUserAuthorizeParams(null, 1, 0 == true ? 1 : 0);
            int r13 = Math.min(r11, 1);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L9;
            if (r15 != 1) goto L8;
            Object r16 = a.c(r10, r14);
            if (r16 == null) goto L8;
            r12.scene = (String) r16;
        L8:
            r15 = r15 + 1;
        L9:
            if (r15 > r11) goto L11;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L9
        L11:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemUserAuthorizeParams[] newArray(int r10) {
            return new SystemUserAuthorizeParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemUserAuthorizeParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemUserAuthorizeParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemUserAuthorizeParams copy$default(SystemUserAuthorizeParams r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.scene;
    L6:
        return r10.copy(r11);
    }

    public static /* synthetic */ void getScene$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.scene;
    }

    @NotNull
    public final SystemUserAuthorizeParams copy(@Nullable String r10) {
        return new SystemUserAuthorizeParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemUserAuthorizeParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.scene, ((SystemUserAuthorizeParams) r10).scene) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Nullable
    public final String getScene() {
        return this.scene;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        String r10 = this.scene;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    public int hashCode() {
        String r10 = this.scene;
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
        if ((r10 instanceof SystemUserAuthorizeParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.scene;
        if (r11 != null) goto L9;
        r11 = ((SystemUserAuthorizeParams) r10).scene;
    L9:
        return new SystemUserAuthorizeParams(r11);
    }

    public final void setScene(@Nullable String r10) {
        this.scene = r10;
    }

    @NotNull
    public String toString() {
        return "SystemUserAuthorizeParams(scene=" + this.scene + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(1);
        q.g(r10, "out");
        r10.writeValue(this.scene);
    }

    public SystemUserAuthorizeParams(@Nullable String r10) {
        this.scene = r10;
    }

    public /* synthetic */ SystemUserAuthorizeParams(String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
