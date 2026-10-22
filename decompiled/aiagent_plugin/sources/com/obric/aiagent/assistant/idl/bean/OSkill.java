package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OSkill.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OSkill implements Parcelable {
    public static final Parcelable.Creator<OSkill> CREATOR = null;
    private final boolean available;
    private final String coverUrl;
    private final Long createdAt;
    private final String displayName;
    private final boolean enabled;
    private final Long lastUpdatedAt;
    private final Long lastUsedAt;
    private final String slug;

    /* JADX INFO: compiled from: OSkill.kt */
    public static final class Creator implements Parcelable.Creator<OSkill> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OSkill createFromParcel(Parcel r12) {
            o.e(r12, "parcel");
            String r1 = r12.readString();
            String r2 = r12.readString();
            String r3 = r12.readString();
            boolean r5 = false;
            if (r12.readInt() == 0) goto L5;
            boolean r6 = true;
        L7:
            if (r12.readInt() == 0) goto L10;
            r5 = true;
        L10:
            if (r12.readInt() != 0) goto L12;
            Long r7 = null;
        L14:
            if (r12.readInt() != 0) goto L16;
            Long r8 = null;
        L18:
            if (r12.readInt() != 0) goto L20;
            Long r13 = null;
        L22:
            return new OSkill(r1, r2, r3, r6, r5, r7, r8, r13);
        L20:
            r13 = Long.valueOf(r12.readLong());
            goto L22
        L16:
            r8 = Long.valueOf(r12.readLong());
            goto L18
        L12:
            r7 = Long.valueOf(r12.readLong());
            goto L14
        L5:
            r6 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OSkill createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OSkill[] newArray(int r1) {
            return new OSkill[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OSkill[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public OSkill() {
        this(null, null, null, false, false, null, null, null, 255, null);
    }

    public static /* synthetic */ OSkill copy$default(OSkill r9, String r10, String r11, String r12, boolean r13, boolean r14, Long r15, Long r16, Long r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.slug;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.displayName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.coverUrl;
    L15:
        if ((r18 & 8) == 0) goto L17;
        boolean r5 = r9.enabled;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = r9.available;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Long r7 = r9.createdAt;
    L27:
        if ((r18 & 64) == 0) goto L29;
        Long r8 = r9.lastUsedAt;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Long r1 = r9.lastUpdatedAt;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.slug;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.coverUrl;
    }

    public final boolean component4() {
        return this.enabled;
    }

    public final boolean component5() {
        return this.available;
    }

    public final Long component6() {
        return this.createdAt;
    }

    public final Long component7() {
        return this.lastUsedAt;
    }

    public final Long component8() {
        return this.lastUpdatedAt;
    }

    public final OSkill copy(String r11, String r12, String r13, boolean r14, boolean r15, Long r16, Long r17, Long r18) {
        o.e(r11, "slug");
        o.e(r12, "displayName");
        o.e(r13, "coverUrl");
        return new OSkill(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OSkill.class) == true) goto L8;
        return false;
    L8:
        OSkill r6 = (OSkill) ZeusTransformUtils.preCheckCast(r5, OSkill.class, "com.obric.aiagent.plugin");
        if (o.a(this.slug, r6.slug) == true) goto L12;
        return false;
    L12:
        if (o.a(this.displayName, r6.displayName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.coverUrl, r6.coverUrl) == true) goto L18;
        return false;
    L18:
        if (this.enabled == r6.enabled) goto L21;
        return false;
    L21:
        if (this.available == r6.available) goto L24;
        return false;
    L24:
        if (o.a(this.createdAt, r6.createdAt) == true) goto L27;
        return false;
    L27:
        if (o.a(this.lastUsedAt, r6.lastUsedAt) == true) goto L30;
        return false;
    L30:
        if (o.a(this.lastUpdatedAt, r6.lastUpdatedAt) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.slug.hashCode() * 31) + this.displayName.hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + Boolean.hashCode(this.enabled)) * 31) + Boolean.hashCode(this.available)) * 31;
        Long r1 = this.createdAt;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.lastUsedAt;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.lastUpdatedAt;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "OSkill(slug=" + this.slug + ", displayName=" + this.displayName + ", coverUrl=" + this.coverUrl + ", enabled=" + this.enabled + ", available=" + this.available + ", createdAt=" + this.createdAt + ", lastUsedAt=" + this.lastUsedAt + ", lastUpdatedAt=" + this.lastUpdatedAt + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r6) {
        o.e(r5, "dest");
        r5.writeString(this.slug);
        r5.writeString(this.displayName);
        r5.writeString(this.coverUrl);
        r5.writeInt(this.enabled ? 1 : 0);
        r5.writeInt(this.available ? 1 : 0);
        Long r7 = this.createdAt;
        if (r7 != null) goto L5;
        r5.writeInt(0);
    L6:
        Long r8 = this.lastUsedAt;
        if (r8 != null) goto L9;
        r5.writeInt(0);
    L10:
        Long r4 = this.lastUpdatedAt;
        if (r4 != null) goto L13;
        r5.writeInt(0);
        return;
    L13:
        r5.writeInt(1);
        r5.writeLong(r4.longValue());
        return;
    L9:
        r5.writeInt(1);
        r5.writeLong(r8.longValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeLong(r7.longValue());
        goto L6
    }

    public OSkill(String r2, String r3, String r4, boolean r5, boolean r6, Long r7, Long r8, Long r9) {
        o.e(r2, "slug");
        o.e(r3, "displayName");
        o.e(r4, "coverUrl");
        this.slug = r2;
        this.displayName = r3;
        this.coverUrl = r4;
        this.enabled = r5;
        this.available = r6;
        this.createdAt = r7;
        this.lastUsedAt = r8;
        this.lastUpdatedAt = r9;
    }

    public /* synthetic */ OSkill(String r2, String r3, String r4, boolean r5, boolean r6, Long r7, Long r8, Long r9, int r10, h r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = false;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = false;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public final String getSlug() {
        return this.slug;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final Long getCreatedAt() {
        return this.createdAt;
    }

    public final Long getLastUsedAt() {
        return this.lastUsedAt;
    }

    public final Long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }
}
