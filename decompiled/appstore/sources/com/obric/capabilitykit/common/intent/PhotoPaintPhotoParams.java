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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\u0010\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013H\u0016J\t\u0010\u0014\u001a\u00020\rHÖ\u0001J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoPaintPhotoParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "component1", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoPaintPhotoParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoPaintPhotoParams> CREATOR = null;

    @Nullable
    private PhotoEntity photo;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoPaintPhotoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoPaintPhotoParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PhotoPaintPhotoParams r12 = new PhotoPaintPhotoParams((PhotoEntity) r10.readParcelable(PhotoPaintPhotoParams.class.getClassLoader()));
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
        public final PhotoPaintPhotoParams[] newArray(int r10) {
            return new PhotoPaintPhotoParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoPaintPhotoParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoPaintPhotoParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoPaintPhotoParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoPaintPhotoParams copy$default(PhotoPaintPhotoParams r10, PhotoEntity r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.photo;
    L6:
        return r10.copy(r11);
    }

    @Nullable
    public final PhotoEntity component1() {
        return this.photo;
    }

    @NotNull
    public final PhotoPaintPhotoParams copy(@Nullable PhotoEntity r10) {
        return new PhotoPaintPhotoParams(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoPaintPhotoParams) == true) goto L9;
        return false;
    L9:
        if (q.b(this.photo, ((PhotoPaintPhotoParams) r10).photo) == true) goto L11;
        return false;
    L11:
        return true;
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
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
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
        if ((r10 instanceof PhotoPaintPhotoParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r11 = this.photo;
        if (r11 != null) goto L9;
        r11 = ((PhotoPaintPhotoParams) r10).photo;
    L9:
        return new PhotoPaintPhotoParams(r11);
    }

    public final void setPhoto(@Nullable PhotoEntity r10) {
        this.photo = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoPaintPhotoParams(photo=" + this.photo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.photo, r11);
    }

    public PhotoPaintPhotoParams(@Nullable PhotoEntity r10) {
        this.photo = r10;
    }

    public /* synthetic */ PhotoPaintPhotoParams(PhotoEntity r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = null;
    L5:
        this(r10);
    }
}
