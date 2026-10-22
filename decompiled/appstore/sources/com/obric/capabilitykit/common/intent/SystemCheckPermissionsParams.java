package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ,\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appletId", "", "permissions", "", "Lcom/obric/capabilitykit/common/intent/Permission;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)V", "getAppletId", "()Ljava/lang/String;", "setAppletId", "(Ljava/lang/String;)V", "getPermissions", "()[Lcom/obric/capabilitykit/common/intent/Permission;", "setPermissions", "([Lcom/obric/capabilitykit/common/intent/Permission;)V", "[Lcom/obric/capabilitykit/common/intent/Permission;", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/common/intent/Permission;)Lcom/obric/capabilitykit/common/intent/SystemCheckPermissionsParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemCheckPermissionsParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemCheckPermissionsParams> CREATOR = null;

    @Nullable
    private String appletId;

    @Nullable
    private Permission[] permissions;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemCheckPermissionsParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemCheckPermissionsParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Permission[] r13 = null;
        L9:
            SystemCheckPermissionsParams r14 = new SystemCheckPermissionsParams(r12, r13);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L10:
            if (r17 > r15) goto L12;
            r17 = r17 + 1;
        L12:
            if (r17 > r11) goto L14;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L12
        L14:
            return r14;
        L5:
            int r18 = r10.readInt();
            Permission[] r19 = new Permission[r18];
            int r20 = 0;
        L6:
            if (r20 == r18) goto L8;
            r19[r20] = Permission.CREATOR.createFromParcel(r10);
            r20 = r20 + 1;
            goto L6
        L8:
            r13 = r19;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemCheckPermissionsParams[] newArray(int r10) {
            return new SystemCheckPermissionsParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemCheckPermissionsParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemCheckPermissionsParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemCheckPermissionsParams copy$default(SystemCheckPermissionsParams r10, String r11, Permission[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.appletId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.permissions;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.appletId;
    }

    @Nullable
    public final Permission[] component2() {
        return this.permissions;
    }

    @NotNull
    public final SystemCheckPermissionsParams copy(@Nullable String r10, @Nullable Permission[] r11) {
        return new SystemCheckPermissionsParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemCheckPermissionsParams) == true) goto L8;
        return false;
    L8:
        SystemCheckPermissionsParams r11 = (SystemCheckPermissionsParams) r10;
        if (q.b(this.appletId, r11.appletId) == true) goto L12;
        return false;
    L12:
        if (q.b(this.permissions, r11.permissions) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getAppletId() {
        return this.appletId;
    }

    @Nullable
    public final Permission[] getPermissions() {
        return this.permissions;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.appletId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Permission[] r14 = this.permissions;
        if (r14 == null) goto L11;
        r11 = Arrays.hashCode(r14);
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
        if ((r10 instanceof SystemCheckPermissionsParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.appletId;
        if (r11 != null) goto L8;
        r11 = ((SystemCheckPermissionsParams) r10).appletId;
    L8:
        Permission[] r12 = this.permissions;
        if (r12 != null) goto L12;
        r12 = ((SystemCheckPermissionsParams) r10).permissions;
    L12:
        return new SystemCheckPermissionsParams(r11, r12);
    }

    public final void setAppletId(@Nullable String r10) {
        this.appletId = r10;
    }

    public final void setPermissions(@Nullable Permission[] r10) {
        this.permissions = r10;
    }

    @NotNull
    public String toString() {
        return "SystemCheckPermissionsParams(appletId=" + this.appletId + ", permissions=" + Arrays.toString(this.permissions) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.appletId);
        Permission[] r13 = this.permissions;
        if (r13 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L10;
        r13[r12].writeToParcel(r10, r11);
        r12 = r12 + 1;
        goto L6
    }

    public SystemCheckPermissionsParams(@Nullable String r10, @Nullable Permission[] r11) {
        this.appletId = r10;
        this.permissions = r11;
    }

    public /* synthetic */ SystemCheckPermissionsParams(String r10, Permission[] r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
