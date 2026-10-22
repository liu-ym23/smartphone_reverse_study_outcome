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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018H\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "target", "Lcom/obric/capabilitykit/common/intent/ContactTarget;", "type", "", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Ljava/lang/String;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhoneCallParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PhoneCallParams> CREATOR = null;

    @Nullable
    private ContactTarget target;

    @Nullable
    private String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneCallParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneCallParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            if (r10.readInt() != 0) goto L5;
            ContactTarget r12 = null;
        L6:
            PhoneCallParams r13 = new PhoneCallParams(r12, r10.readString());
            int r14 = Math.min(r11, 0);
            ClassLoader r15 = Creator.class.getClassLoader();
            int r16 = 1;
        L7:
            if (r16 > r14) goto L9;
            r16 = r16 + 1;
        L9:
            if (r16 > r11) goto L11;
            a.d(r10, r15);
            r16 = r16 + 1;
            goto L9
        L11:
            return r13;
        L5:
            r12 = ContactTarget.CREATOR.createFromParcel(r10);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneCallParams[] newArray(int r10) {
            return new PhoneCallParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneCallParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneCallParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhoneCallParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhoneCallParams copy$default(PhoneCallParams r10, ContactTarget r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.type;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final ContactTarget component1() {
        return this.target;
    }

    @Nullable
    public final String component2() {
        return this.type;
    }

    @NotNull
    public final PhoneCallParams copy(@Nullable ContactTarget r10, @Nullable String r11) {
        return new PhoneCallParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhoneCallParams) == true) goto L8;
        return false;
    L8:
        PhoneCallParams r11 = (PhoneCallParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.type, r11.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        ContactTarget r10 = this.target;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.toString();
    }

    @Nullable
    public final ContactTarget getTarget() {
        return this.target;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        ContactTarget r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.type;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
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
        if ((r10 instanceof PhoneCallParams) == true) goto L5;
        return this;
    L5:
        ContactTarget r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((PhoneCallParams) r10).target;
    L8:
        String r12 = this.type;
        if (r12 != null) goto L12;
        r12 = ((PhoneCallParams) r10).type;
    L12:
        return new PhoneCallParams(r11, r12);
    }

    public final void setTarget(@Nullable ContactTarget r10) {
        this.target = r10;
    }

    public final void setType(@Nullable String r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return "PhoneCallParams(target=" + this.target + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        ContactTarget r12 = this.target;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        r10.writeString(this.type);
        return;
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
        goto L6
    }

    public PhoneCallParams(@Nullable ContactTarget r10, @Nullable String r11) {
        this.target = r10;
        this.type = r11;
    }

    public /* synthetic */ PhoneCallParams(ContactTarget r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
