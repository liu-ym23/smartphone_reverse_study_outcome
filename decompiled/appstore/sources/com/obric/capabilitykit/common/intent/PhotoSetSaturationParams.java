package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedance.apm.constant.CommonKey;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\u0010\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#H\u0016J\t\u0010$\u001a\u00020\tHÖ\u0001J\b\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010!H\u0016J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetSaturationParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "valueType", "", CommonKey.KEY_VALUE, "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetSaturationParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoSetSaturationParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoSetSaturationParams> CREATOR = null;

    @Nullable
    private PhotoEntity photo;

    @Nullable
    private Integer value;

    @Nullable
    private String valueType;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoSetSaturationParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSetSaturationParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            PhotoEntity r12 = (PhotoEntity) r10.readParcelable(PhotoSetSaturationParams.class.getClassLoader());
            String r13 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Integer r14 = null;
        L6:
            PhotoSetSaturationParams r15 = new PhotoSetSaturationParams(r12, r13, r14);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L7:
            if (r18 > r16) goto L9;
            r18 = r18 + 1;
        L9:
            if (r18 > r11) goto L11;
            a.d(r10, r17);
            r18 = r18 + 1;
            goto L9
        L11:
            return r15;
        L5:
            r14 = Integer.valueOf(r10.readInt());
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSetSaturationParams[] newArray(int r10) {
            return new PhotoSetSaturationParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetSaturationParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetSaturationParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhotoSetSaturationParams() {
        PhotoEntity r10 = null;
        String r11 = null;
        Integer r12 = null;
        this(r10, r11, r12, 7, null);
    }

    public static /* synthetic */ PhotoSetSaturationParams copy$default(PhotoSetSaturationParams r10, PhotoEntity r11, String r12, Integer r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = r10.photo;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = r10.valueType;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.value;
    L12:
        return r10.copy(r11, r12, r13);
    }

    @Nullable
    public final PhotoEntity component1() {
        return this.photo;
    }

    @Nullable
    public final String component2() {
        return this.valueType;
    }

    @Nullable
    public final Integer component3() {
        return this.value;
    }

    @NotNull
    public final PhotoSetSaturationParams copy(@Nullable PhotoEntity r10, @Nullable String r11, @Nullable Integer r12) {
        return new PhotoSetSaturationParams(r10, r11, r12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoSetSaturationParams) == true) goto L8;
        return false;
    L8:
        PhotoSetSaturationParams r11 = (PhotoSetSaturationParams) r10;
        if (q.b(this.photo, r11.photo) == true) goto L12;
        return false;
    L12:
        if (q.b(this.valueType, r11.valueType) == true) goto L15;
        return false;
    L15:
        if (q.b(this.value, r11.value) == true) goto L17;
        return false;
    L17:
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

    @Nullable
    public final Integer getValue() {
        return this.value;
    }

    @Nullable
    public final String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        PhotoEntity r10 = this.photo;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.valueType;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.value;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return r16 + r11;
    L9:
        r15 = r14.hashCode();
        goto L10
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
        if ((r10 instanceof PhotoSetSaturationParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r11 = this.photo;
        if (r11 != null) goto L8;
        r11 = ((PhotoSetSaturationParams) r10).photo;
    L8:
        String r12 = this.valueType;
        if (r12 != null) goto L11;
        r12 = ((PhotoSetSaturationParams) r10).valueType;
    L11:
        Integer r13 = this.value;
        if (r13 != null) goto L15;
        r13 = ((PhotoSetSaturationParams) r10).value;
    L15:
        return new PhotoSetSaturationParams(r11, r12, r13);
    }

    public final void setPhoto(@Nullable PhotoEntity r10) {
        this.photo = r10;
    }

    public final void setValue(@Nullable Integer r10) {
        this.value = r10;
    }

    public final void setValueType(@Nullable String r10) {
        this.valueType = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoSetSaturationParams(photo=" + this.photo + ", valueType=" + this.valueType + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.photo, r11);
        r10.writeString(this.valueType);
        Integer r12 = this.value;
        if (r12 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r12.intValue());
    }

    public PhotoSetSaturationParams(@Nullable PhotoEntity r10, @Nullable String r11, @Nullable Integer r12) {
        this.photo = r10;
        this.valueType = r11;
        this.value = r12;
    }

    public /* synthetic */ PhotoSetSaturationParams(PhotoEntity r10, String r11, Integer r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
