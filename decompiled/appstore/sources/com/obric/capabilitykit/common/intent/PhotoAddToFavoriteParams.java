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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\tJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0016HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoAddToFavoriteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "isAdd", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "setAdd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Boolean;)Lcom/obric/capabilitykit/common/intent/PhotoAddToFavoriteParams;", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoAddToFavoriteParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoAddToFavoriteParams> CREATOR = null;

    @Nullable
    private Boolean isAdd;

    @Nullable
    private PhotoEntity photo;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoAddToFavoriteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoAddToFavoriteParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PhotoEntity r12 = (PhotoEntity) r10.readParcelable(PhotoAddToFavoriteParams.class.getClassLoader());
            int r13 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r14 = null;
        L10:
            PhotoAddToFavoriteParams r15 = new PhotoAddToFavoriteParams(r12, r14);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
        L11:
            if (r13 > r16) goto L13;
            r13 = r13 + 1;
        L13:
            if (r13 > r11) goto L15;
            a.d(r10, r17);
            r13 = r13 + 1;
            goto L13
        L15:
            return r15;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r18 = true;
        L9:
            r14 = Boolean.valueOf(r18);
            goto L10
        L8:
            r18 = false;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoAddToFavoriteParams[] newArray(int r10) {
            return new PhotoAddToFavoriteParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoAddToFavoriteParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoAddToFavoriteParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoAddToFavoriteParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoAddToFavoriteParams copy$default(PhotoAddToFavoriteParams r10, PhotoEntity r11, Boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.photo;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.isAdd;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final PhotoEntity component1() {
        return this.photo;
    }

    @Nullable
    public final Boolean component2() {
        return this.isAdd;
    }

    @NotNull
    public final PhotoAddToFavoriteParams copy(@Nullable PhotoEntity r10, @Nullable Boolean r11) {
        return new PhotoAddToFavoriteParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoAddToFavoriteParams) == true) goto L8;
        return false;
    L8:
        PhotoAddToFavoriteParams r11 = (PhotoAddToFavoriteParams) r10;
        if (q.b(this.photo, r11.photo) == true) goto L12;
        return false;
    L12:
        if (q.b(this.isAdd, r11.isAdd) == true) goto L14;
        return false;
    L14:
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
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhotoAddToFavoriteParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r11 = this.photo;
        if (r11 != null) goto L8;
        r11 = ((PhotoAddToFavoriteParams) r10).photo;
    L8:
        Boolean r12 = this.isAdd;
        if (r12 != null) goto L12;
        r12 = ((PhotoAddToFavoriteParams) r10).isAdd;
    L12:
        return new PhotoAddToFavoriteParams(r11, r12);
    }

    public final void setAdd(@Nullable Boolean r10) {
        this.isAdd = r10;
    }

    public final void setPhoto(@Nullable PhotoEntity r10) {
        this.photo = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoAddToFavoriteParams(photo=" + this.photo + ", isAdd=" + this.isAdd + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.photo, r11);
        Boolean r12 = this.isAdd;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.booleanValue() ? 1 : 0);
    }

    public PhotoAddToFavoriteParams(@Nullable PhotoEntity r10, @Nullable Boolean r11) {
        this.photo = r10;
        this.isAdd = r11;
    }

    public /* synthetic */ PhotoAddToFavoriteParams(PhotoEntity r10, Boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
