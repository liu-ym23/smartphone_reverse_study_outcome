package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactListTarget;", "Landroid/os/Parcelable;", "telephone", "", "", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "([Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getTelephone", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "copy", "([Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/ContactEntity;)Lcom/obric/capabilitykit/common/intent/ContactListTarget;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactListTarget implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContactListTarget> CREATOR = null;

    @Nullable
    private final ContactEntity[] contact;

    @Nullable
    private final String[] telephone;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactListTarget> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactListTarget createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String[] r12 = r10.createStringArray();
            if (r10.readInt() != 0) goto L5;
            ContactEntity[] r13 = null;
        L9:
            ContactListTarget r14 = new ContactListTarget(r12, r13);
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
            ContactEntity[] r19 = new ContactEntity[r18];
            int r20 = 0;
        L6:
            if (r20 == r18) goto L8;
            r19[r20] = (ContactEntity) r10.readParcelable(ContactListTarget.class.getClassLoader());
            r20 = r20 + 1;
            goto L6
        L8:
            r13 = r19;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactListTarget[] newArray(int r10) {
            return new ContactListTarget[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactListTarget createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactListTarget[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactListTarget(@Nullable String[] r10, @Nullable ContactEntity[] r11) {
        this.telephone = r10;
        this.contact = r11;
    }

    public static /* synthetic */ ContactListTarget copy$default(ContactListTarget r10, String[] r11, ContactEntity[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.telephone;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.contact;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String[] component1() {
        return this.telephone;
    }

    @Nullable
    public final ContactEntity[] component2() {
        return this.contact;
    }

    @NotNull
    public final ContactListTarget copy(@Nullable String[] r10, @Nullable ContactEntity[] r11) {
        return new ContactListTarget(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactListTarget) == true) goto L8;
        return false;
    L8:
        ContactListTarget r11 = (ContactListTarget) r10;
        if (q.b(this.telephone, r11.telephone) == true) goto L12;
        return false;
    L12:
        if (q.b(this.contact, r11.contact) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final ContactEntity[] getContact() {
        return this.contact;
    }

    @Nullable
    public final String[] getTelephone() {
        return this.telephone;
    }

    public int hashCode() {
        String[] r10 = this.telephone;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        ContactEntity[] r14 = this.contact;
        if (r14 == null) goto L11;
        r11 = Arrays.hashCode(r14);
    L11:
        return r13 + r11;
    L5:
        r12 = Arrays.hashCode(r10);
        goto L6
    }

    @NotNull
    public String toString() {
        return "ContactListTarget(telephone=" + Arrays.toString(this.telephone) + ", contact=" + Arrays.toString(this.contact) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeStringArray(this.telephone);
        ContactEntity[] r13 = this.contact;
        if (r13 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L10;
        r10.writeParcelable(r13[r12], r11);
        r12 = r12 + 1;
        goto L6
    }
}
