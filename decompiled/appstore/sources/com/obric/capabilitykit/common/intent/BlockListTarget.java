package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "Landroid/os/Parcelable;", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "callHistory", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "telephone", "", "(Lcom/obric/capabilitykit/entity/app/ContactEntity;Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;Ljava/lang/String;)V", "getCallHistory", "()Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class BlockListTarget implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<BlockListTarget> CREATOR = null;

    @Nullable
    private final CallHistoryEntity callHistory;

    @Nullable
    private final ContactEntity contact;

    @Nullable
    private final String telephone;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BlockListTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final BlockListTarget createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            BlockListTarget r12 = new BlockListTarget((ContactEntity) r10.readParcelable(BlockListTarget.class.getClassLoader()), (CallHistoryEntity) r10.readParcelable(BlockListTarget.class.getClassLoader()), r10.readString());
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
        public final BlockListTarget[] newArray(int r10) {
            return new BlockListTarget[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BlockListTarget createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BlockListTarget[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public BlockListTarget(@Nullable ContactEntity r10, @Nullable CallHistoryEntity r11, @Nullable String r12) {
        this.contact = r10;
        this.callHistory = r11;
        this.telephone = r12;
    }

    public static /* synthetic */ BlockListTarget copy$default(BlockListTarget r10, ContactEntity r11, CallHistoryEntity r12, String r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.contact;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.callHistory;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.telephone;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final ContactEntity component1() {
        return this.contact;
    }

    @Nullable
    public final CallHistoryEntity component2() {
        return this.callHistory;
    }

    @Nullable
    public final String component3() {
        return this.telephone;
    }

    @NotNull
    public final BlockListTarget copy(@Nullable ContactEntity r10, @Nullable CallHistoryEntity r11, @Nullable String r12) {
        return new BlockListTarget(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof BlockListTarget) == true) goto L8;
        return false;
    L8:
        BlockListTarget r11 = (BlockListTarget) r10;
        if (q.b(this.contact, r11.contact) == true) goto L12;
        return false;
    L12:
        if (q.b(this.callHistory, r11.callHistory) == true) goto L15;
        return false;
    L15:
        if (q.b(this.telephone, r11.telephone) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Nullable
    public final CallHistoryEntity getCallHistory() {
        return this.callHistory;
    }

    @Nullable
    public final ContactEntity getContact() {
        return this.contact;
    }

    @Nullable
    public final String getTelephone() {
        return this.telephone;
    }

    public int hashCode() {
        ContactEntity r10 = this.contact;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        CallHistoryEntity r14 = this.callHistory;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.telephone;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "BlockListTarget(contact=" + this.contact + ", callHistory=" + this.callHistory + ", telephone=" + this.telephone + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.contact, r11);
        r10.writeParcelable(this.callHistory, r11);
        r10.writeString(this.telephone);
    }
}
