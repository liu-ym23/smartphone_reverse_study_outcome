package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import com.tmall.wireless.tangram.structure.card.SlideCard;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", SlideCard.KEY_INDEX, "", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoShowPhotoParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoShowPhotoParams> CREATOR = null;

    @Nullable
    private Integer index;

    @Nullable
    private PhotoEntity[] targets;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoShowPhotoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoShowPhotoParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            Integer r12 = null;
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r13 = null;
        L9:
            if (r10.readInt() == 0) goto L12;
            r12 = Integer.valueOf(r10.readInt());
        L12:
            PhotoShowPhotoParams r14 = new PhotoShowPhotoParams(r13, r12);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L13:
            if (r17 > r15) goto L15;
            r17 = r17 + 1;
        L15:
            if (r17 > r11) goto L17;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L15
        L17:
            return r14;
        L5:
            int r18 = r10.readInt();
            r13 = new PhotoEntity[r18];
            int r19 = 0;
        L6:
            if (r19 == r18) goto L9;
            r13[r19] = (PhotoEntity) r10.readParcelable(PhotoShowPhotoParams.class.getClassLoader());
            r19 = r19 + 1;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoShowPhotoParams[] newArray(int r10) {
            return new PhotoShowPhotoParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoShowPhotoParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoShowPhotoParams copy$default(PhotoShowPhotoParams r10, PhotoEntity[] r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.targets;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.index;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final PhotoEntity[] component1() {
        return this.targets;
    }

    @Nullable
    public final Integer component2() {
        return this.index;
    }

    @NotNull
    public final PhotoShowPhotoParams copy(@Nullable PhotoEntity[] r10, @Nullable Integer r11) {
        return new PhotoShowPhotoParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoShowPhotoParams) == true) goto L8;
        return false;
    L8:
        PhotoShowPhotoParams r11 = (PhotoShowPhotoParams) r10;
        if (q.b(this.targets, r11.targets) == true) goto L12;
        return false;
    L12:
        if (q.b(this.index, r11.index) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final PhotoEntity[] getTargets() {
        return this.targets;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.targets);
    }

    public int hashCode() {
        PhotoEntity[] r10 = this.targets;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Integer r14 = this.index;
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
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhotoShowPhotoParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity[] r11 = this.targets;
        if (r11 != null) goto L8;
        r11 = ((PhotoShowPhotoParams) r10).targets;
    L8:
        Integer r12 = this.index;
        if (r12 != null) goto L12;
        r12 = ((PhotoShowPhotoParams) r10).index;
    L12:
        return new PhotoShowPhotoParams(r11, r12);
    }

    public final void setIndex(@Nullable Integer r10) {
        this.index = r10;
    }

    public final void setTargets(@Nullable PhotoEntity[] r10) {
        this.targets = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoShowPhotoParams(targets=" + Arrays.toString(this.targets) + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        PhotoEntity[] r12 = this.targets;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L8:
        Integer r13 = this.index;
        if (r13 != null) goto L11;
        r10.writeInt(0);
        return;
    L11:
        r10.writeInt(1);
        r10.writeInt(r13.intValue());
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

    public PhotoShowPhotoParams(@Nullable PhotoEntity[] r10, @Nullable Integer r11) {
        this.targets = r10;
        this.index = r11;
    }

    public /* synthetic */ PhotoShowPhotoParams(PhotoEntity[] r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
