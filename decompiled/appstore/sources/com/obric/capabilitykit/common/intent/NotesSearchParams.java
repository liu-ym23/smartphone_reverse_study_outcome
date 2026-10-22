package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
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
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\rHÖ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020\rHÖ\u0001J\u0012\u00105\u001a\u00020\u00012\b\u00106\u001a\u0004\u0018\u000103H\u0016J\t\u00107\u001a\u00020\u0004HÖ\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\rHÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\b\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006="}, d2 = {"Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "startTimestamp", "", "endTimestamp", "isFavorite", "", "title", ServerElements.CONTENT, "maxCount", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setFavorite", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getStartTimestamp", "setStartTimestamp", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/NotesSearchParams;", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class NotesSearchParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<NotesSearchParams> CREATOR = null;

    @Nullable
    private String content;

    @Nullable
    private Long endTimestamp;

    @Nullable
    private Boolean isFavorite;

    @Nullable
    private Integer maxCount;

    @Nullable
    private String query;

    @Nullable
    private Long startTimestamp;

    @Nullable
    private String title;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NotesSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotesSearchParams createFromParcel(@NotNull Parcel r13) {
            int r12 = r13.readInt();
            q.g(r13, "parcel");
            String r10 = r13.readString();
            if (r13.readInt() != 0) goto L5;
            Long r11 = null;
        L7:
            if (r13.readInt() != 0) goto L9;
            Long r14 = null;
        L10:
            int r15 = 1;
            if (r13.readInt() != 0) goto L14;
            Boolean r16 = null;
        L18:
            String r17 = r13.readString();
            String r18 = r13.readString();
            if (r13.readInt() != 0) goto L21;
            Integer r19 = null;
        L22:
            NotesSearchParams r20 = new NotesSearchParams(r10, r11, r14, r16, r17, r18, r19);
            int r21 = Math.min(r12, 0);
            ClassLoader r22 = Creator.class.getClassLoader();
        L23:
            if (r15 > r21) goto L25;
            r15 = r15 + 1;
        L25:
            if (r15 > r12) goto L27;
            a.d(r13, r22);
            r15 = r15 + 1;
            goto L25
        L27:
            return r20;
        L21:
            r19 = Integer.valueOf(r13.readInt());
            goto L22
        L14:
            if (r13.readInt() == 0) goto L16;
            boolean r23 = true;
        L17:
            r16 = Boolean.valueOf(r23);
            goto L18
        L16:
            r23 = false;
            goto L17
        L9:
            r14 = Long.valueOf(r13.readLong());
            goto L10
        L5:
            r11 = Long.valueOf(r13.readLong());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotesSearchParams[] newArray(int r10) {
            return new NotesSearchParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesSearchParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesSearchParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public NotesSearchParams() {
        String r10 = null;
        Long r11 = null;
        Long r12 = null;
        Boolean r13 = null;
        String r14 = null;
        String r15 = null;
        Integer r16 = null;
        this(r10, r11, r12, r13, r14, r15, r16, 127, null);
    }

    public static /* synthetic */ NotesSearchParams copy$default(NotesSearchParams r10, String r11, Long r12, Long r13, Boolean r14, String r15, String r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r18 & 2) == 0) goto L8;
        r12 = r10.startTimestamp;
    L8:
        Long r110 = r12;
        if ((r18 & 4) == 0) goto L11;
        r13 = r10.endTimestamp;
    L11:
        Long r20 = r13;
        if ((r18 & 8) == 0) goto L14;
        r14 = r10.isFavorite;
    L14:
        Boolean r21 = r14;
        if ((r18 & 16) == 0) goto L17;
        r15 = r10.title;
    L17:
        String r22 = r15;
        if ((r18 & 32) == 0) goto L20;
        r16 = r10.content;
    L20:
        String r23 = r16;
        if ((r18 & 64) == 0) goto L23;
        r17 = r10.maxCount;
    L23:
        String r24 = r11;
        return r10.copy(r24, r110, r20, r21, r22, r23, r17);
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
    public final Boolean component4() {
        return this.isFavorite;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @Nullable
    public final String component6() {
        return this.content;
    }

    @Nullable
    public final Integer component7() {
        return this.maxCount;
    }

    @NotNull
    public final NotesSearchParams copy(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable Boolean r13, @Nullable String r14, @Nullable String r15, @Nullable Integer r16) {
        return new NotesSearchParams(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NotesSearchParams) == true) goto L8;
        return false;
    L8:
        NotesSearchParams r11 = (NotesSearchParams) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.startTimestamp, r11.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (q.b(this.endTimestamp, r11.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (q.b(this.isFavorite, r11.isFavorite) == true) goto L21;
        return false;
    L21:
        if (q.b(this.title, r11.title) == true) goto L24;
        return false;
    L24:
        if (q.b(this.content, r11.content) == true) goto L27;
        return false;
    L27:
        if (q.b(this.maxCount, r11.maxCount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Nullable
    public final String getContent() {
        return this.content;
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

    @Nullable
    public final String getTitle() {
        return this.title;
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
        Boolean r20 = this.isFavorite;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.title;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.content;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        Integer r29 = this.maxCount;
        if (r29 == null) goto L31;
        r11 = r29.hashCode();
    L31:
        return r28 + r11;
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
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

    @Nullable
    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof NotesSearchParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.query;
        if (r11 != null) goto L8;
        r11 = ((NotesSearchParams) r10).query;
    L8:
        String r12 = r11;
        Long r13 = this.startTimestamp;
        if (r13 != null) goto L11;
        r13 = ((NotesSearchParams) r10).startTimestamp;
    L11:
        Long r14 = r13;
        Long r15 = this.endTimestamp;
        if (r15 != null) goto L14;
        r15 = ((NotesSearchParams) r10).endTimestamp;
    L14:
        Long r16 = r15;
        Boolean r17 = this.isFavorite;
        if (r17 != null) goto L17;
        r17 = ((NotesSearchParams) r10).isFavorite;
    L17:
        Boolean r18 = r17;
        String r19 = this.title;
        if (r19 != null) goto L20;
        r19 = ((NotesSearchParams) r10).title;
    L20:
        String r20 = r19;
        String r21 = this.content;
        if (r21 != null) goto L23;
        r21 = ((NotesSearchParams) r10).content;
    L23:
        String r22 = r21;
        Integer r23 = this.maxCount;
        if (r23 != null) goto L27;
        r23 = ((NotesSearchParams) r10).maxCount;
    L27:
        return new NotesSearchParams(r12, r14, r16, r18, r20, r22, r23);
    }

    public final void setContent(@Nullable String r10) {
        this.content = r10;
    }

    public final void setEndTimestamp(@Nullable Long r10) {
        this.endTimestamp = r10;
    }

    public final void setFavorite(@Nullable Boolean r10) {
        this.isFavorite = r10;
    }

    public final void setMaxCount(@Nullable Integer r10) {
        this.maxCount = r10;
    }

    public final void setQuery(@Nullable String r10) {
        this.query = r10;
    }

    public final void setStartTimestamp(@Nullable Long r10) {
        this.startTimestamp = r10;
    }

    public final void setTitle(@Nullable String r10) {
        this.title = r10;
    }

    @NotNull
    public String toString() {
        return "NotesSearchParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", isFavorite=" + this.isFavorite + ", title=" + this.title + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
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
        Boolean r14 = this.isFavorite;
        if (r14 != null) goto L13;
        r10.writeInt(0);
    L14:
        r10.writeString(this.title);
        r10.writeString(this.content);
        Integer r15 = this.maxCount;
        if (r15 != null) goto L17;
        r10.writeInt(0);
        return;
    L17:
        r10.writeInt(1);
        r10.writeInt(r15.intValue());
        return;
    L13:
        r10.writeInt(1);
        r10.writeInt(r14.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r10.writeInt(1);
        r10.writeLong(r13.longValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeLong(r12.longValue());
        goto L6
    }

    public NotesSearchParams(@Nullable String r10, @Nullable Long r11, @Nullable Long r12, @Nullable Boolean r13, @Nullable String r14, @Nullable String r15, @Nullable Integer r16) {
        this.query = r10;
        this.startTimestamp = r11;
        this.endTimestamp = r12;
        this.isFavorite = r13;
        this.title = r14;
        this.content = r15;
        this.maxCount = r16;
    }

    public /* synthetic */ NotesSearchParams(String r10, Long r11, Long r12, Boolean r13, String r14, String r15, Integer r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r17 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r17 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r17 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r17 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r17 & 32) == 0) goto L21;
        r15 = null;
    L21:
        if ((r17 & 64) == 0) goto L23;
        r16 = null;
    L23:
        this(r10, r11, r12, r13, r14, r15, r16);
    }
}
