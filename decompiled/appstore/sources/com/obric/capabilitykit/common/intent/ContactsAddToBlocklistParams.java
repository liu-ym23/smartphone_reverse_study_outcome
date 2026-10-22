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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015HÖ\u0001R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "isAdd", "", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTarget", "()Lcom/obric/capabilitykit/common/intent/BlockListTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/common/intent/BlockListTarget;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/ContactsAddToBlocklistParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class ContactsAddToBlocklistParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<ContactsAddToBlocklistParams> CREATOR = null;

    @Nullable
    private Boolean isAdd;

    @Nullable
    private BlockListTarget target;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsAddToBlocklistParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsAddToBlocklistParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Boolean r12 = null;
            if (r10.readInt() != 0) goto L5;
            BlockListTarget r13 = null;
        L6:
            BlockListTarget r14 = r13;
            int r15 = 1;
            if (r10.readInt() != 0) goto L10;
        L14:
            ContactsAddToBlocklistParams r16 = new ContactsAddToBlocklistParams(r14, r12);
            int r17 = Math.min(r11, 0);
            ClassLoader r18 = Creator.class.getClassLoader();
        L15:
            if (r15 > r17) goto L17;
            r15 = r15 + 1;
        L17:
            if (r15 > r11) goto L19;
            a.d(r10, r18);
            r15 = r15 + 1;
            goto L17
        L19:
            return r16;
        L10:
            if (r10.readInt() == 0) goto L12;
            boolean r19 = true;
        L13:
            r12 = Boolean.valueOf(r19);
            goto L14
        L12:
            r19 = false;
            goto L13
        L5:
            r13 = BlockListTarget.CREATOR.createFromParcel(r10);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ContactsAddToBlocklistParams[] newArray(int r10) {
            return new ContactsAddToBlocklistParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToBlocklistParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsAddToBlocklistParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContactsAddToBlocklistParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ContactsAddToBlocklistParams copy$default(ContactsAddToBlocklistParams r10, BlockListTarget r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.isAdd;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final BlockListTarget component1() {
        return this.target;
    }

    @Nullable
    public final Boolean component2() {
        return this.isAdd;
    }

    @NotNull
    public final ContactsAddToBlocklistParams copy(@Nullable BlockListTarget r10, @Nullable Boolean r11) {
        return new ContactsAddToBlocklistParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ContactsAddToBlocklistParams) == true) goto L8;
        return false;
    L8:
        ContactsAddToBlocklistParams r11 = (ContactsAddToBlocklistParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.isAdd, r11.isAdd) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final BlockListTarget getTarget() {
        return this.target;
    }

    public int hashCode() {
        BlockListTarget r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.isAdd;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Nullable
    public final Boolean isAdd() {
        return this.isAdd;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.target == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof ContactsAddToBlocklistParams) == true) goto L5;
        return this;
    L5:
        BlockListTarget r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((ContactsAddToBlocklistParams) r10).target;
    L8:
        Boolean r12 = this.isAdd;
        if (r12 != null) goto L12;
        r12 = ((ContactsAddToBlocklistParams) r10).isAdd;
    L12:
        return new ContactsAddToBlocklistParams(r11, r12);
    }

    public final void setAdd(@Nullable Boolean r10) {
        this.isAdd = r10;
    }

    public final void setTarget(@Nullable BlockListTarget r10) {
        this.target = r10;
    }

    @NotNull
    public String toString() {
        return "ContactsAddToBlocklistParams(target=" + this.target + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        BlockListTarget r12 = this.target;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Boolean r13 = this.isAdd;
        if (r13 != null) goto L9;
        r10.writeInt(0);
        return;
    L9:
        r10.writeInt(1);
        r10.writeInt(r13.booleanValue() ? 1 : 0);
        return;
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
        goto L6
    }

    public ContactsAddToBlocklistParams(@Nullable BlockListTarget r10, @Nullable Boolean r11) {
        this.target = r10;
        this.isAdd = r11;
    }

    public /* synthetic */ ContactsAddToBlocklistParams(BlockListTarget r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
