package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: NotesSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NotesSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<NotesSearchParams> CREATOR = null;
    private String content;
    private Long endTimestamp;
    private Boolean isFavorite;
    private Integer maxCount;
    private String query;
    private Long startTimestamp;
    private String title;

    /* JADX INFO: compiled from: NotesSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<NotesSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesSearchParams createFromParcel(Parcel r14) {
            int r0 = r14.readInt();
            o.e(r14, "parcel");
            String r3 = r14.readString();
            if (r14.readInt() != 0) goto L5;
            Long r5 = null;
        L7:
            if (r14.readInt() != 0) goto L9;
            Long r6 = null;
        L10:
            int r11 = 1;
            if (r14.readInt() != 0) goto L14;
            Boolean r7 = null;
        L18:
            String r8 = r14.readString();
            String r9 = r14.readString();
            if (r14.readInt() != 0) goto L21;
            Integer r12 = null;
        L22:
            NotesSearchParams r1 = new NotesSearchParams(r3, r5, r6, r7, r8, r9, r12);
            int r2 = Math.min(r0, 0);
            ClassLoader r13 = getClass().getClassLoader();
        L23:
            if (r11 > r2) goto L25;
            r11 = r11 + 1;
        L25:
            if (r11 > r0) goto L27;
            a.a(r14, r13);
            r11 = r11 + 1;
            goto L25
        L27:
            return r1;
        L21:
            r12 = Integer.valueOf(r14.readInt());
            goto L22
        L14:
            if (r14.readInt() == 0) goto L16;
            boolean r4 = true;
        L17:
            r7 = Boolean.valueOf(r4);
            goto L18
        L16:
            r4 = false;
            goto L17
        L9:
            r6 = Long.valueOf(r14.readLong());
            goto L10
        L5:
            r5 = Long.valueOf(r14.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NotesSearchParams[] newArray(int r1) {
            return new NotesSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotesSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public NotesSearchParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ NotesSearchParams copy$default(NotesSearchParams r5, String r6, Long r7, Long r8, Boolean r9, String r10, String r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.query;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.startTimestamp;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.endTimestamp;
    L11:
        Long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.isFavorite;
    L14:
        Boolean r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.title;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.content;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.maxCount;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.query;
    }

    public final Long component2() {
        return this.startTimestamp;
    }

    public final Long component3() {
        return this.endTimestamp;
    }

    public final Boolean component4() {
        return this.isFavorite;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.maxCount;
    }

    public final NotesSearchParams copy(String r9, Long r10, Long r11, Boolean r12, String r13, String r14, Integer r15) {
        return new NotesSearchParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NotesSearchParams.class) == true) goto L8;
        return false;
    L8:
        NotesSearchParams r6 = (NotesSearchParams) ZeusTransformUtils.preCheckCast(r5, NotesSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.startTimestamp, r6.startTimestamp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.endTimestamp, r6.endTimestamp) == true) goto L18;
        return false;
    L18:
        if (o.a(this.isFavorite, r6.isFavorite) == true) goto L21;
        return false;
    L21:
        if (o.a(this.title, r6.title) == true) goto L24;
        return false;
    L24:
        if (o.a(this.content, r6.content) == true) goto L27;
        return false;
    L27:
        if (o.a(this.maxCount, r6.maxCount) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.startTimestamp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.endTimestamp;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.isFavorite;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.title;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.content;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.maxCount;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NotesSearchParams(query=" + this.query + ", startTimestamp=" + this.startTimestamp + ", endTimestamp=" + this.endTimestamp + ", isFavorite=" + this.isFavorite + ", title=" + this.title + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeString(this.query);
        Long r0 = this.startTimestamp;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r1 = this.endTimestamp;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Boolean r2 = this.isFavorite;
        if (r2 != null) goto L13;
        r5.writeInt(0);
    L14:
        r5.writeString(this.title);
        r5.writeString(this.content);
        Integer r4 = this.maxCount;
        if (r4 != null) goto L17;
        r5.writeInt(0);
        return;
    L17:
        r5.writeInt(1);
        r5.writeInt(r4.intValue());
        return;
    L13:
        r5.writeInt(1);
        r5.writeInt(r2.booleanValue() ? 1 : 0);
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeLong(r1.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r0.longValue());
        goto L6
    }

    public NotesSearchParams(String r1, Long r2, Long r3, Boolean r4, String r5, String r6, Integer r7) {
        this.query = r1;
        this.startTimestamp = r2;
        this.endTimestamp = r3;
        this.isFavorite = r4;
        this.title = r5;
        this.content = r6;
        this.maxCount = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ NotesSearchParams(String r2, Long r3, Long r4, Boolean r5, String r6, String r7, Integer r8, int r9, h r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final void setStartTimestamp(Long r1) {
        this.startTimestamp = r1;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final void setEndTimestamp(Long r1) {
        this.endTimestamp = r1;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public final void setFavorite(Boolean r1) {
        this.isFavorite = r1;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r12) {
        if (ZeusTransformUtils.instanceOf(r12, NotesSearchParams.class) == false) goto L5;
        String r1 = this.query;
        if (r1 != null) goto L9;
        r1 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).query;
    L9:
        String r4 = r1;
        Long r2 = this.startTimestamp;
        if (r2 != null) goto L12;
        r2 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).startTimestamp;
    L12:
        Long r5 = r2;
        Long r3 = this.endTimestamp;
        if (r3 != null) goto L15;
        r3 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).endTimestamp;
    L15:
        Long r6 = r3;
        Boolean r7 = this.isFavorite;
        if (r7 != null) goto L18;
        r7 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).isFavorite;
    L18:
        Boolean r8 = r7;
        String r9 = this.title;
        if (r9 != null) goto L21;
        r9 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).title;
    L21:
        String r10 = r9;
        String r11 = this.content;
        if (r11 != null) goto L24;
        r11 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).content;
    L24:
        String r13 = r11;
        Integer r14 = this.maxCount;
        if (r14 != null) goto L28;
        r14 = ((NotesSearchParams) ZeusTransformUtils.preCheckCast(r12, NotesSearchParams.class, "com.obric.aiagent.plugin")).maxCount;
    L28:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new NotesSearchParams(r4, r5, r6, r8, r10, r13, r14), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
