package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/Permission;", "Landroid/os/Parcelable;", "type", "", "granted", "", "appletId", "confirmMode", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppletId", "()Ljava/lang/String;", "getConfirmMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGranted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/Permission;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class Permission implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<Permission> CREATOR = null;

    @Nullable
    private final String appletId;

    @Nullable
    private final Integer confirmMode;

    @Nullable
    private final Boolean granted;

    @Nullable
    private final String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Permission> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Permission createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            Integer r13 = null;
            int r14 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r15 = null;
        L10:
            String r16 = r10.readString();
            if (r10.readInt() == 0) goto L14;
            r13 = Integer.valueOf(r10.readInt());
        L14:
            Permission r17 = new Permission(r12, r15, r16, r13);
            int r18 = Math.min(r11, 0);
            ClassLoader r19 = Creator.class.getClassLoader();
        L15:
            if (r14 > r18) goto L17;
            r14 = r14 + 1;
        L17:
            if (r14 > r11) goto L19;
            a.d(r10, r19);
            r14 = r14 + 1;
            goto L17
        L19:
            return r17;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r20 = true;
        L9:
            r15 = Boolean.valueOf(r20);
            goto L10
        L8:
            r20 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Permission[] newArray(int r10) {
            return new Permission[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Permission createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Permission[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public Permission(@Nullable String r10, @Nullable Boolean r11, @Nullable String r12, @Nullable Integer r13) {
        this.type = r10;
        this.granted = r11;
        this.appletId = r12;
        this.confirmMode = r13;
    }

    public static /* synthetic */ Permission copy$default(Permission r10, String r11, Boolean r12, String r13, Integer r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.type;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.granted;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.appletId;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.confirmMode;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final Boolean component2() {
        return this.granted;
    }

    @Nullable
    public final String component3() {
        return this.appletId;
    }

    @Nullable
    public final Integer component4() {
        return this.confirmMode;
    }

    @NotNull
    public final Permission copy(@Nullable String r10, @Nullable Boolean r11, @Nullable String r12, @Nullable Integer r13) {
        return new Permission(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Permission) == true) goto L8;
        return false;
    L8:
        Permission r11 = (Permission) r10;
        if (q.b(this.type, r11.type) == true) goto L12;
        return false;
    L12:
        if (q.b(this.granted, r11.granted) == true) goto L15;
        return false;
    L15:
        if (q.b(this.appletId, r11.appletId) == true) goto L18;
        return false;
    L18:
        if (q.b(this.confirmMode, r11.confirmMode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final String getAppletId() {
        return this.appletId;
    }

    @Nullable
    public final Integer getConfirmMode() {
        return this.confirmMode;
    }

    @Nullable
    public final Boolean getGranted() {
        return this.granted;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String r10 = this.type;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.granted;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.appletId;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.confirmMode;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "Permission(type=" + this.type + ", granted=" + this.granted + ", appletId=" + this.appletId + ", confirmMode=" + this.confirmMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.type);
        Boolean r12 = this.granted;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeString(this.appletId);
        Integer r13 = this.confirmMode;
        if (r13 != null) goto L9;
        r10.writeInt(0);
        return;
    L9:
        r10.writeInt(1);
        r10.writeInt(r13.intValue());
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
        goto L6
    }
}
