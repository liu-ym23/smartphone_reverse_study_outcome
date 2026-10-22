package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ \u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\u0012\u0010\u0019\u001a\u00020\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010HÖ\u0001R$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "setTargets", "[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "component1", "copy", "([Lcom/obric/capabilitykit/entity/app/ContactEntity;)Lcom/obric/capabilitykit/common/intent/ContactsDeleteParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactsDeleteParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<ContactsDeleteParams> CREATOR = null;

    @Nullable
    private ContactEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsDeleteParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            ContactEntity[] r12 = null;
        L9:
            ContactsDeleteParams r13 = new ContactsDeleteParams(r12);
            int r14 = Math.min(r11, 0);
            ClassLoader r15 = Creator.class.getClassLoader();
            int r16 = 1;
        L10:
            if (r16 > r14) goto L12;
            r16 = r16 + 1;
        L12:
            if (r16 > r11) goto L14;
            a.d(r10, r15);
            r16 = r16 + 1;
            goto L12
        L14:
            return r13;
        L5:
            int r17 = r10.readInt();
            ContactEntity[] r18 = new ContactEntity[r17];
            int r19 = 0;
        L6:
            if (r19 == r17) goto L8;
            r18[r19] = (ContactEntity) r10.readParcelable(ContactsDeleteParams.class.getClassLoader());
            r19 = r19 + 1;
            goto L6
        L8:
            r12 = r18;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsDeleteParams[] newArray(int r10) {
            return new ContactsDeleteParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsDeleteParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsDeleteParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsDeleteParams copy$default(ContactsDeleteParams r10, ContactEntity[] r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.targets;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final ContactEntity[] component1() {
        return this.targets;
    }

    @NotNull
    public final ContactsDeleteParams copy(@Nullable ContactEntity[] r10) {
        return new ContactsDeleteParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactsDeleteParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.targets, ((ContactsDeleteParams) r10).targets) == true) goto L11;
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
    public final ContactEntity[] getTargets() {
        return this.targets;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.targets);
    }

    public int hashCode() {
        ContactEntity[] r10 = this.targets;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r10);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof ContactsDeleteParams) == true) goto L5;
        return this;
    L5:
        ContactEntity[] r11 = this.targets;
        if (r11 != null) goto L9;
        r11 = ((ContactsDeleteParams) r10).targets;
    L9:
        return new ContactsDeleteParams(r11);
    }

    public final void setTargets(@Nullable ContactEntity[] r10) {
        this.targets = r10;
    }

    @NotNull
    public String toString() {
        return "ContactsDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        ContactEntity[] r13 = this.targets;
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

    public ContactsDeleteParams(@Nullable ContactEntity[] r10) {
        this.targets = r10;
    }

    public /* synthetic */ ContactsDeleteParams(ContactEntity[] r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
