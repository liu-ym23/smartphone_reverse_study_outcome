package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactTarget;", "Landroid/os/Parcelable;", "telephone", "", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactTarget implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContactTarget> CREATOR = null;

    @Nullable
    private final ContactEntity contact;

    @Nullable
    private final String telephone;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactTarget createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            ContactTarget r12 = new ContactTarget(r10.readString(), (ContactEntity) r10.readParcelable(ContactTarget.class.getClassLoader()));
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
        public final ContactTarget[] newArray(int r10) {
            return new ContactTarget[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactTarget createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactTarget[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactTarget(@Nullable String r10, @Nullable ContactEntity r11) {
        this.telephone = r10;
        this.contact = r11;
    }

    public static /* synthetic */ ContactTarget copy$default(ContactTarget r10, String r11, ContactEntity r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.telephone;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.contact;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.telephone;
    }

    @Nullable
    public final ContactEntity component2() {
        return this.contact;
    }

    @NotNull
    public final ContactTarget copy(@Nullable String r10, @Nullable ContactEntity r11) {
        return new ContactTarget(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactTarget) == true) goto L8;
        return false;
    L8:
        ContactTarget r11 = (ContactTarget) r10;
        if (q.b(this.telephone, r11.telephone) == true) goto L12;
        return false;
    L12:
        if (q.b(this.contact, r11.contact) == true) goto L14;
        return false;
    L14:
        return true;
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
        String r10 = this.telephone;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        ContactEntity r14 = this.contact;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "ContactTarget(telephone=" + this.telephone + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.telephone);
        r10.writeParcelable(this.contact, r11);
    }
}
