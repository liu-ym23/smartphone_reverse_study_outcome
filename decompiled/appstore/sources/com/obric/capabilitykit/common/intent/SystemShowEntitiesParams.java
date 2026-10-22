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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001f\u001a\u00020\u0004HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemShowEntitiesParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "message", "", "entities", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "getEntities", "()[Ljava/lang/String;", "setEntities", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/SystemShowEntitiesParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class SystemShowEntitiesParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<SystemShowEntitiesParams> CREATOR = null;

    @Nullable
    private String[] entities;

    @Nullable
    private String message;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemShowEntitiesParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SystemShowEntitiesParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            SystemShowEntitiesParams r12 = new SystemShowEntitiesParams(r10.readString(), r10.createStringArray());
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
        public final SystemShowEntitiesParams[] newArray(int r10) {
            return new SystemShowEntitiesParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemShowEntitiesParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemShowEntitiesParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemShowEntitiesParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SystemShowEntitiesParams copy$default(SystemShowEntitiesParams r10, String r11, String[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.message;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.entities;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @Nullable
    public final String[] component2() {
        return this.entities;
    }

    @NotNull
    public final SystemShowEntitiesParams copy(@Nullable String r10, @Nullable String[] r11) {
        return new SystemShowEntitiesParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof SystemShowEntitiesParams) == true) goto L8;
        return false;
    L8:
        SystemShowEntitiesParams r11 = (SystemShowEntitiesParams) r10;
        if (q.b(this.message, r11.message) == true) goto L12;
        return false;
    L12:
        if (q.b(this.entities, r11.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final String[] getEntities() {
        return this.entities;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.message;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String[] r14 = this.entities;
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
        if (this.message == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof SystemShowEntitiesParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.message;
        if (r11 != null) goto L8;
        r11 = ((SystemShowEntitiesParams) r10).message;
    L8:
        String[] r12 = this.entities;
        if (r12 != null) goto L12;
        r12 = ((SystemShowEntitiesParams) r10).entities;
    L12:
        return new SystemShowEntitiesParams(r11, r12);
    }

    public final void setEntities(@Nullable String[] r10) {
        this.entities = r10;
    }

    public final void setMessage(@Nullable String r10) {
        this.message = r10;
    }

    @NotNull
    public String toString() {
        return "SystemShowEntitiesParams(message=" + this.message + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.message);
        r10.writeStringArray(this.entities);
    }

    public SystemShowEntitiesParams(@Nullable String r10, @Nullable String[] r11) {
        this.message = r10;
        this.entities = r11;
    }

    public /* synthetic */ SystemShowEntitiesParams(String r10, String[] r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
