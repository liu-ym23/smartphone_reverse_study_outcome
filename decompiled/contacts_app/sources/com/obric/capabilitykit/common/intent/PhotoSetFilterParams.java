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

/* JADX INFO: compiled from: PhotoSetFilterParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetFilterParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", BlackListQueryHandler.KEY_PHOTO, "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "filter", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;)V", "getFilter", "()Ljava/lang/String;", "setFilter", "(Ljava/lang/String;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoSetFilterParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetFilterParams> CREATOR = null;
    private String filter;
    private PhotoEntity photo;

    /* JADX INFO: compiled from: PhotoSetFilterParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoSetFilterParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams createFromParcel(Parcel r5) {
            int r0 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            PhotoSetFilterParams r1 = new PhotoSetFilterParams((PhotoEntity) r5.readParcelable(PhotoSetFilterParams.class.getClassLoader()), r5.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r4 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r5, r4);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetFilterParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams[] newArray(int r1) {
            return new PhotoSetFilterParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetFilterParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetFilterParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetFilterParams copy$default(PhotoSetFilterParams r0, PhotoEntity r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.filter;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.filter;
    }

    public final PhotoSetFilterParams copy(PhotoEntity r1, String r2) {
        return new PhotoSetFilterParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoSetFilterParams) == true) goto L8;
        return false;
    L8:
        PhotoSetFilterParams r6 = (PhotoSetFilterParams) r5;
        if (Intrinsics.areEqual(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filter, r6.filter) == true) goto L14;
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
        String r4 = this.filter;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetFilterParams(photo=" + this.photo + ", filter=" + this.filter + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeParcelable(this.photo, r3);
        r2.writeString(this.filter);
    }

    public PhotoSetFilterParams(PhotoEntity r1, String r2) {
        this.photo = r1;
        this.filter = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ PhotoSetFilterParams(PhotoEntity r2, String r3, int r4, DefaultConstructorMarker r5) {
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

    public final String getFilter() {
        return this.filter;
    }

    public final void setFilter(String r1) {
        this.filter = r1;
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
        if ((r2 instanceof PhotoSetFilterParams) == false) goto L5;
        PhotoEntity r0 = this.photo;
        if (r0 != null) goto L9;
        r0 = ((PhotoSetFilterParams) r2).photo;
    L9:
        String r1 = this.filter;
        if (r1 != null) goto L13;
        r1 = ((PhotoSetFilterParams) r2).filter;
    L13:
        return new PhotoSetFilterParams(r0, r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.photo);
    }
}
