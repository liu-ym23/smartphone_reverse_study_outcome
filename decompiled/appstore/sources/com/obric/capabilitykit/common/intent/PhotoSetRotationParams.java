package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.VersionedParcelable;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "angle", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getAngle", "()Ljava/lang/Integer;", "setAngle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoSetRotationParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoSetRotationParams> CREATOR = null;

    @Nullable
    private Integer angle;

    @Nullable
    private PhotoEntity photo;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoSetRotationParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSetRotationParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PhotoEntity r12 = (PhotoEntity) r10.readParcelable(PhotoSetRotationParams.class.getClassLoader());
            if (r10.readInt() != 0) goto L5;
            Integer r13 = null;
        L6:
            PhotoSetRotationParams r14 = new PhotoSetRotationParams(r12, r13);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L7:
            if (r17 > r15) goto L9;
            r17 = r17 + 1;
        L9:
            if (r17 > r11) goto L11;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L9
        L11:
            return r14;
        L5:
            r13 = Integer.valueOf(r10.readInt());
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSetRotationParams[] newArray(int r10) {
            return new PhotoSetRotationParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetRotationParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetRotationParams copy$default(PhotoSetRotationParams r10, PhotoEntity r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.photo;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.angle;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final PhotoEntity component1() {
        return this.photo;
    }

    @Nullable
    public final Integer component2() {
        return this.angle;
    }

    @NotNull
    public final PhotoSetRotationParams copy(@Nullable PhotoEntity r10, @Nullable Integer r11) {
        return new PhotoSetRotationParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoSetRotationParams) == true) goto L8;
        return false;
    L8:
        PhotoSetRotationParams r11 = (PhotoSetRotationParams) r10;
        if (q.b(this.photo, r11.photo) == true) goto L12;
        return false;
    L12:
        if (q.b(this.angle, r11.angle) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final Integer getAngle() {
        return this.angle;
    }

    @Nullable
    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.photo);
    }

    public int hashCode() {
        PhotoEntity r10 = this.photo;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Integer r14 = this.angle;
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
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhotoSetRotationParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r11 = this.photo;
        if (r11 != null) goto L8;
        r11 = ((PhotoSetRotationParams) r10).photo;
    L8:
        Integer r12 = this.angle;
        if (r12 != null) goto L12;
        r12 = ((PhotoSetRotationParams) r10).angle;
    L12:
        return new PhotoSetRotationParams(r11, r12);
    }

    public final void setAngle(@Nullable Integer r10) {
        this.angle = r10;
    }

    public final void setPhoto(@Nullable PhotoEntity r10) {
        this.photo = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoSetRotationParams(photo=" + this.photo + ", angle=" + this.angle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.photo, r11);
        Integer r12 = this.angle;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
    }

    public PhotoSetRotationParams(@Nullable PhotoEntity r10, @Nullable Integer r11) {
        this.photo = r10;
        this.angle = r11;
    }

    public /* synthetic */ PhotoSetRotationParams(PhotoEntity r10, Integer r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
