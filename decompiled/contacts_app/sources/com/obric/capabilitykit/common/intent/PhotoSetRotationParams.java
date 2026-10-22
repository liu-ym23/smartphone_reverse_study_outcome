package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.util.BlackListQueryHandler;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhotoSetRotationParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", BlackListQueryHandler.KEY_PHOTO, "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "angle", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getAngle", "()Ljava/lang/Integer;", "setAngle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoSetRotationParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetRotationParams> CREATOR = null;
    private Integer angle;
    private PhotoEntity photo;

    /* JADX INFO: compiled from: PhotoSetRotationParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoSetRotationParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            PhotoEntity r2 = (PhotoEntity) r5.readParcelable(PhotoSetRotationParams.class.getClassLoader());
            if (r5.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            PhotoSetRotationParams r1 = new PhotoSetRotationParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            ParcelUtils.skipValueSafely(r5, r6);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r5.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams[] newArray(int r1) {
            return new PhotoSetRotationParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetRotationParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetRotationParams copy$default(PhotoSetRotationParams r0, PhotoEntity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.angle;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final Integer component2() {
        return this.angle;
    }

    public final PhotoSetRotationParams copy(PhotoEntity r1, Integer r2) {
        return new PhotoSetRotationParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoSetRotationParams) == true) goto L8;
        return false;
    L8:
        PhotoSetRotationParams r6 = (PhotoSetRotationParams) r5;
        if (Intrinsics.areEqual(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.angle, r6.angle) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PhotoEntity r0 = this.photo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.angle;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetRotationParams(photo=" + this.photo + ", angle=" + this.angle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeParcelable(this.photo, r4);
        Integer r2 = this.angle;
        if (r2 != null) goto L5;
        r3.writeInt(0);
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r2.intValue());
    }

    public PhotoSetRotationParams(PhotoEntity r1, Integer r2) {
        this.photo = r1;
        this.angle = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ PhotoSetRotationParams(PhotoEntity r2, Integer r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final void setPhoto(PhotoEntity r1) {
        this.photo = r1;
    }

    public final Integer getAngle() {
        return this.angle;
    }

    public final void setAngle(Integer r1) {
        this.angle = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof PhotoSetRotationParams) == false) goto L5;
        PhotoEntity r0 = this.photo;
        if (r0 != null) goto L9;
        r0 = ((PhotoSetRotationParams) r2).photo;
    L9:
        Integer r1 = this.angle;
        if (r1 != null) goto L13;
        r1 = ((PhotoSetRotationParams) r2).angle;
    L13:
        return new PhotoSetRotationParams(r0, r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.photo);
    }
}
