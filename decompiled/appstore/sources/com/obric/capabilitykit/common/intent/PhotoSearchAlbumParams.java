package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020\nHÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\nHÖ\u0001J\u0012\u0010+\u001a\u00020\u00012\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\t\u0010-\u001a\u00020\u0004HÖ\u0001J\u0019\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\nHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u00063"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSearchAlbumParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "name", "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSearchAlbumParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoSearchAlbumParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<PhotoSearchAlbumParams> CREATOR = null;

    @Nullable
    private Long endTimestamp;

    @Nullable
    private Integer maxCount;

    @Nullable
    private String name;

    @Nullable
    private String query;

    @Nullable
    private Long startTimestamp;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoSearchAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSearchAlbumParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Long r13 = null;
        L7:
            if (r10.readInt() != 0) goto L9;
            Long r14 = null;
        L10:
            String r15 = r10.readString();
            if (r10.readInt() != 0) goto L13;
            Integer r16 = null;
        L14:
            PhotoSearchAlbumParams r17 = new PhotoSearchAlbumParams(r12, r13, r14, r15, r16);
            int r18 = Math.min(r11, 0);
            ClassLoader r19 = Creator.class.getClassLoader();
            int r20 = 1;
        L15:
            if (r20 > r18) goto L17;
            r20 = r20 + 1;
        L17:
            if (r20 > r11) goto L19;
            a.d(r10, r19);
            r20 = r20 + 1;
            goto L17
        L19:
            return r17;
        L13:
            r16 = Integer.valueOf(r10.readInt());
            goto L14
        L9:
            r14 = Long.valueOf(r10.readLong());
            goto L10
        L5:
            r13 = Long.valueOf(r10.readLong());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoSearchAlbumParams[] newArray(int r10) {
            return new PhotoSearchAlbumParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSearchAlbumParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSearchAlbumParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhotoSearchAlbumParams() {
        String r10 = null;
        Long r11 = null;
        Long r12 = null;
        String r13 = null;
        Integer r14 = null;
        this(r10, r11, r12, r13, r14, 31, null);
    }

    public static /* synthetic */ PhotoSearchAlbumParams copy$default(PhotoSearchAlbumParams r10, String r11, Long r12, Long r13, String r14, Integer r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.startTimestamp;
    L8:
        Long r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.endTimestamp;
    L11:
        Long r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.name;
    L14:
        String r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.maxCount;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @Nullable
    public final String component1() {
        return this.query;
    }

    @Nullable
    public final Long component2() {
        return this.startTimestamp;
    }

    @Nullable
    public final Long component3() {
        return this.endTimestamp;
    }

    @Nullable
    public final String component4() {
        return this.name;
    }

    @Nullable
    public final Integer component5() {
        return this.maxCount;
    }

    @NotNull
    public final PhotoSearchAlbumParams copy(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13, @Nullable Integer r14) {
        return new PhotoSearchAlbumParams(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoSearchAlbumParams) == true) goto L8;
        return false;
    L8:
        PhotoSearchAlbumParams r11 = (PhotoSearchAlbumParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.startTimestamp, r11.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (q.b(this.endTimestamp, r11.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (q.b(this.name, r11.name) == true) goto L21;
        return false;
    L21:
        if (q.b(this.maxCount, r11.maxCount) == true) goto L23;
        return false;
    L23:
        return true;
    }

    @Nullable
    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    @Nullable
    public final Integer getMaxCount() {
        return this.maxCount;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getQuery() {
        return this.query;
    }

    @Nullable
    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.query;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        Long r14 = this.startTimestamp;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Long r17 = this.endTimestamp;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.name;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Integer r23 = this.maxCount;
        if (r23 == null) goto L23;
        r11 = r23.hashCode();
    L23:
        return r22 + r11;
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhotoSearchAlbumParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.query;
        if (r11 != null) goto L8;
        r11 = ((PhotoSearchAlbumParams) r10).query;
    L8:
        String r12 = r11;
        Long r13 = this.startTimestamp;
        if (r13 != null) goto L11;
        r13 = ((PhotoSearchAlbumParams) r10).startTimestamp;
    L11:
        Long r14 = r13;
        Long r15 = this.endTimestamp;
        if (r15 != null) goto L14;
        r15 = ((PhotoSearchAlbumParams) r10).endTimestamp;
    L14:
        Long r16 = r15;
        String r17 = this.name;
        if (r17 != null) goto L17;
        r17 = ((PhotoSearchAlbumParams) r10).name;
    L17:
        String r18 = r17;
        Integer r19 = this.maxCount;
        if (r19 != null) goto L21;
        r19 = ((PhotoSearchAlbumParams) r10).maxCount;
    L21:
        return new PhotoSearchAlbumParams(r12, r14, r16, r18, r19);
    }

    public final void setEndTimestamp(@Nullable Long r10) {
        this.endTimestamp = r10;
    }

    public final void setMaxCount(@Nullable Integer r10) {
        this.maxCount = r10;
    }

    public final void setName(@Nullable String r10) {
        this.name = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setStartTimestamp(@Nullable Long r10) {
        this.startTimestamp = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoSearchAlbumParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", name=" + this.name + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.query);
        Long r12 = this.startTimestamp;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Long r13 = this.endTimestamp;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        r10.writeString(this.name);
        Integer r14 = this.maxCount;
        if (r14 != null) goto L13;
        r10.writeInt(0);
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.intValue());
        return;
    L9:
        r10.writeInt(1);
        r10.writeLong(r13.longValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeLong(r12.longValue());
        goto L6
    }

    public PhotoSearchAlbumParams(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable String r13, @Nullable Integer r14) {
        this.query = r10;
        this.startTimestamp = r11;
        this.endTimestamp = r12;
        this.name = r13;
        this.maxCount = r14;
    }

    public /* synthetic */ PhotoSearchAlbumParams(String r10, Long r11, Long r12, String r13, Integer r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r15 & 16) == 0) goto L17;
        r14 = null;
    L17:
        this(r10, r11, r12, r13, r14);
    }
}
