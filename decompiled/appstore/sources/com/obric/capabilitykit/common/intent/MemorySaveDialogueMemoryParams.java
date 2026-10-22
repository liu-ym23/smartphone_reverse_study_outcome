package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/common/intent/MemorySaveDialogueMemoryParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "type", "", ServerElements.INFO, "(Ljava/lang/String;Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "setInfo", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MemorySaveDialogueMemoryParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<MemorySaveDialogueMemoryParams> CREATOR = null;

    @Nullable
    private String info;

    @Nullable
    private String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MemorySaveDialogueMemoryParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MemorySaveDialogueMemoryParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            MemorySaveDialogueMemoryParams r12 = new MemorySaveDialogueMemoryParams(r10.readString(), r10.readString());
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
        public final MemorySaveDialogueMemoryParams[] newArray(int r10) {
            return new MemorySaveDialogueMemoryParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemorySaveDialogueMemoryParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemorySaveDialogueMemoryParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MemorySaveDialogueMemoryParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MemorySaveDialogueMemoryParams copy$default(MemorySaveDialogueMemoryParams r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.type;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.info;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.info;
    }

    @NotNull
    public final MemorySaveDialogueMemoryParams copy(@Nullable String r10, @Nullable String r11) {
        return new MemorySaveDialogueMemoryParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MemorySaveDialogueMemoryParams) == true) goto L8;
        return false;
    L8:
        MemorySaveDialogueMemoryParams r11 = (MemorySaveDialogueMemoryParams) r10;
        if (q.b(this.type, r11.type) == true) goto L12;
        return false;
    L12:
        if (q.b(this.info, r11.info) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String getInfo() {
        return this.info;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
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
        String r14 = this.info;
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
        if (this.type != null) goto L5;
    L7:
        return false;
    L5:
        if (this.info == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof MemorySaveDialogueMemoryParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.type;
        if (r11 != null) goto L8;
        r11 = ((MemorySaveDialogueMemoryParams) r10).type;
    L8:
        String r12 = this.info;
        if (r12 != null) goto L12;
        r12 = ((MemorySaveDialogueMemoryParams) r10).info;
    L12:
        return new MemorySaveDialogueMemoryParams(r11, r12);
    }

    public final void setInfo(@Nullable String r10) {
        this.info = r10;
    }

    public final void setType(@Nullable String r10) {
        this.type = r10;
    }

    @NotNull
    public String toString() {
        return "MemorySaveDialogueMemoryParams(type=" + this.type + ", info=" + this.info + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.type);
        r10.writeString(this.info);
    }

    public MemorySaveDialogueMemoryParams(@Nullable String r10, @Nullable String r11) {
        this.type = r10;
        this.info = r11;
    }

    public /* synthetic */ MemorySaveDialogueMemoryParams(String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
