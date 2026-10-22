package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchEntityParam implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private String field;
    private String fieldArrayUniqueKey;
    private final boolean isSemantic;
    private final String keyword;
    private SearchScoreParam score;
    private final String value;

    public static final class CREATOR implements Parcelable.Creator<InAppSearchEntityParam> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new InAppSearchEntityParam(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam[] newArray(int r1) {
            return new InAppSearchEntityParam[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchEntityParam(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), EntityExtKt.a(r12), r12.readString(), EntityExtKt.b(r12), (SearchScoreParam) ZeusTransformUtils.preCheckCast(r12.readParcelable(SearchScoreParam.class.getClassLoader()), SearchScoreParam.class, "com.obric.aiagent.plugin"), null, 32, null);
        int r0 = r12.dataPosition();
        String r1 = r12.readString();
        int r2 = 0;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r12.setDataPosition(r0);
    L12:
        int r3 = Integer.parseInt(VERSION);
        if (r2 > r3) goto L16;
        r3 = r2;
    L16:
        ClassLoader r5 = InAppSearchEntityParam.class.getClassLoader();
        int r6 = 1;
    L17:
        if (r6 > r3) goto L21;
        if (r6 != 1) goto L20;
        this.fieldArrayUniqueKey = (String) ZeusTransformUtils.preCheckCast(r12.readValue(r5), String.class, "com.obric.aiagent.plugin");
    L20:
        r6 = r6 + 1;
    L21:
        if (r6 > r2) goto L23;
        ParcelUtils.INSTANCE.skipValueSafely(r12, r5);
        r6 = r6 + 1;
        goto L21
    L23:
        return;
    L11:
        r2 = Integer.parseInt(r1);
        goto L12
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public InAppSearchEntityParam(String r2, String r3, String r4, boolean r5, SearchScoreParam r6, String r7) {
        o.e(r2, "keyword");
        o.e(r3, "field");
        this.keyword = r2;
        this.field = r3;
        this.value = r4;
        this.isSemantic = r5;
        this.score = r6;
        this.fieldArrayUniqueKey = r7;
    }

    public /* synthetic */ InAppSearchEntityParam(String r10, String r11, String r12, boolean r13, SearchScoreParam r14, String r15, int r16, h r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        boolean r6 = false;
    L11:
        if ((r16 & 16) == 0) goto L13;
        SearchScoreParam r7 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        String r8 = null;
    L18:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public static /* synthetic */ InAppSearchEntityParam copy$default(InAppSearchEntityParam r4, String r5, String r6, String r7, boolean r8, SearchScoreParam r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.keyword;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.field;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.value;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.isSemantic;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.score;
    L17:
        SearchScoreParam r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.fieldArrayUniqueKey;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.keyword;
    }

    public final String component2() {
        return this.field;
    }

    public final String component3() {
        return this.value;
    }

    public final boolean component4() {
        return this.isSemantic;
    }

    public final SearchScoreParam component5() {
        return this.score;
    }

    public final String component6() {
        return this.fieldArrayUniqueKey;
    }

    public final InAppSearchEntityParam copy(String r8, String r9, String r10, boolean r11, SearchScoreParam r12, String r13) {
        o.e(r8, "keyword");
        o.e(r9, "field");
        return new InAppSearchEntityParam(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InAppSearchEntityParam.class) == true) goto L8;
        return false;
    L8:
        InAppSearchEntityParam r6 = (InAppSearchEntityParam) ZeusTransformUtils.preCheckCast(r5, InAppSearchEntityParam.class, "com.obric.aiagent.plugin");
        if (o.a(this.keyword, r6.keyword) == true) goto L12;
        return false;
    L12:
        if (o.a(this.field, r6.field) == true) goto L15;
        return false;
    L15:
        if (o.a(this.value, r6.value) == true) goto L18;
        return false;
    L18:
        if (this.isSemantic == r6.isSemantic) goto L21;
        return false;
    L21:
        if (o.a(this.score, r6.score) == true) goto L24;
        return false;
    L24:
        if (o.a(this.fieldArrayUniqueKey, r6.fieldArrayUniqueKey) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getField() {
        return this.field;
    }

    public final String getFieldArrayUniqueKey() {
        return this.fieldArrayUniqueKey;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final SearchScoreParam getScore() {
        return this.score;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int r0 = ((this.keyword.hashCode() * 31) + this.field.hashCode()) * 31;
        String r1 = this.value;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.isSemantic;
        ?? r6 = r5;
        if (r5 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (r4 + r6) * 31;
        SearchScoreParam r8 = this.score;
        if (r8 != null) goto L12;
        int r9 = 0;
    L13:
        int r10 = (r7 + r9) * 31;
        String r11 = this.fieldArrayUniqueKey;
        if (r11 == null) goto L18;
        r2 = r11.hashCode();
    L18:
        return r10 + r2;
    L12:
        r9 = r8.hashCode();
        goto L13
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final void setField(String r2) {
        o.e(r2, "<set-?>");
        this.field = r2;
    }

    public final void setFieldArrayUniqueKey(String r1) {
        this.fieldArrayUniqueKey = r1;
    }

    public final void setScore(SearchScoreParam r1) {
        this.score = r1;
    }

    public String toString() {
        return "InAppSearchEntityParam(keyword=" + this.keyword + ", field=" + this.field + ", value=" + this.value + ", isSemantic=" + this.isSemantic + ", score=" + this.score + ", fieldArrayUniqueKey=" + this.fieldArrayUniqueKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        r2.writeString(this.keyword);
        r2.writeString(this.field);
        r2.writeString(this.value);
        EntityExtKt.a(r2, this.isSemantic);
        r2.writeParcelable(this.score, r3);
        r2.writeString(VERSION);
        r2.writeValue(this.fieldArrayUniqueKey);
    }
}
