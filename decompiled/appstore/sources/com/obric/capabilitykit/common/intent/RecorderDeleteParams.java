package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.RecordingEntity;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0019HÖ\u0001J\u0012\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "deleteAll", "", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)V", "getDeleteAll", "()Ljava/lang/Boolean;", "setDeleteAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;)V", "[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/RecordingEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/RecorderDeleteParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class RecorderDeleteParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<RecorderDeleteParams> CREATOR = null;

    @Nullable
    private Boolean deleteAll;

    @Nullable
    private RecordingEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<RecorderDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecorderDeleteParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Boolean r12 = null;
            if (r10.readInt() != 0) goto L5;
            RecordingEntity[] r13 = null;
        L8:
            int r14 = 1;
            if (r10.readInt() != 0) goto L12;
        L16:
            RecorderDeleteParams r15 = new RecorderDeleteParams(r13, r12);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
        L17:
            if (r14 > r16) goto L19;
            r14 = r14 + 1;
        L19:
            if (r14 > r11) goto L21;
            a.d(r10, r17);
            r14 = r14 + 1;
            goto L19
        L21:
            return r15;
        L12:
            if (r10.readInt() == 0) goto L14;
            boolean r18 = true;
        L15:
            r12 = Boolean.valueOf(r18);
            goto L16
        L14:
            r18 = false;
            goto L15
        L5:
            int r19 = r10.readInt();
            r13 = new RecordingEntity[r19];
            int r20 = 0;
        L6:
            if (r20 == r19) goto L8;
            r13[r20] = (RecordingEntity) r10.readParcelable(RecorderDeleteParams.class.getClassLoader());
            r20 = r20 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RecorderDeleteParams[] newArray(int r10) {
            return new RecorderDeleteParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecorderDeleteParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecorderDeleteParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RecorderDeleteParams copy$default(RecorderDeleteParams r10, RecordingEntity[] r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.targets;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.deleteAll;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final RecordingEntity[] component1() {
        return this.targets;
    }

    @Nullable
    public final Boolean component2() {
        return this.deleteAll;
    }

    @NotNull
    public final RecorderDeleteParams copy(@Nullable RecordingEntity[] r10, @Nullable Boolean r11) {
        return new RecorderDeleteParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof RecorderDeleteParams) == true) goto L8;
        return false;
    L8:
        RecorderDeleteParams r11 = (RecorderDeleteParams) r10;
        if (q.b(this.targets, r11.targets) == true) goto L12;
        return false;
    L12:
        if (q.b(this.deleteAll, r11.deleteAll) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Boolean getDeleteAll() {
        return this.deleteAll;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final RecordingEntity[] getTargets() {
        return this.targets;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.targets);
    }

    public int hashCode() {
        RecordingEntity[] r10 = this.targets;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Boolean r14 = this.deleteAll;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = Arrays.hashCode(r10);
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof RecorderDeleteParams) == true) goto L5;
        return this;
    L5:
        RecordingEntity[] r11 = this.targets;
        if (r11 != null) goto L8;
        r11 = ((RecorderDeleteParams) r10).targets;
    L8:
        Boolean r12 = this.deleteAll;
        if (r12 != null) goto L12;
        r12 = ((RecorderDeleteParams) r10).deleteAll;
    L12:
        return new RecorderDeleteParams(r11, r12);
    }

    public final void setDeleteAll(@Nullable Boolean r10) {
        this.deleteAll = r10;
    }

    public final void setTargets(@Nullable RecordingEntity[] r10) {
        this.targets = r10;
    }

    @NotNull
    public String toString() {
        return "RecorderDeleteParams(targets=" + Arrays.toString(this.targets) + ", deleteAll=" + this.deleteAll + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        RecordingEntity[] r12 = this.targets;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L8:
        Boolean r13 = this.deleteAll;
        if (r13 != null) goto L11;
        r10.writeInt(0);
        return;
    L11:
        r10.writeInt(1);
        r10.writeInt(r13.booleanValue() ? 1 : 0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r12.length;
        r10.writeInt(r14);
        int r15 = 0;
    L6:
        if (r15 == r14) goto L8;
        r10.writeParcelable(r12[r15], r11);
        r15 = r15 + 1;
        goto L6
    }

    public RecorderDeleteParams(@Nullable RecordingEntity[] r10, @Nullable Boolean r11) {
        this.targets = r10;
        this.deleteAll = r11;
    }

    public /* synthetic */ RecorderDeleteParams(RecordingEntity[] r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
