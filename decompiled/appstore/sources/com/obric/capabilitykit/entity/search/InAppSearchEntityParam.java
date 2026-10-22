package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010#\u001a\u00020$H\u0016J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "keyword", "", "field", CommonKey.KEY_VALUE, "isSemantic", "", "score", "Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "fieldArrayUniqueKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/obric/capabilitykit/entity/search/SearchScoreParam;Ljava/lang/String;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldArrayUniqueKey", "setFieldArrayUniqueKey", "()Z", "getKeyword", "getScore", "()Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "setScore", "(Lcom/obric/capabilitykit/entity/search/SearchScoreParam;)V", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchEntityParam implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;

    @NotNull
    private static final String VERSION = "1";

    @NotNull
    private String field;

    @Nullable
    private String fieldArrayUniqueKey;
    private final boolean isSemantic;

    @NotNull
    private final String keyword;

    @Nullable
    private SearchScoreParam score;

    @Nullable
    private final String value;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchEntityParam> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchEntityParam createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new InAppSearchEntityParam(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchEntityParam[] newArray(int r10) {
            return new InAppSearchEntityParam[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchEntityParam(@NotNull Parcel r11) {
        q.g(r11, "parcel");
        this(EntityExtKt.f(r11), EntityExtKt.f(r11), r11.readString(), EntityExtKt.e(r11), (SearchScoreParam) r11.readParcelable(SearchScoreParam.class.getClassLoader()), null, 32, null);
        int r10 = r11.dataPosition();
        String r12 = r11.readString();
        if (r12 != null) goto L5;
    L8:
        r11.setDataPosition(r10);
        int r13 = 0;
    L9:
        int r14 = Integer.parseInt("1");
        if (r13 > r14) goto L13;
        r14 = r13;
    L13:
        ClassLoader r15 = InAppSearchEntityParam.class.getClassLoader();
        int r16 = 1;
    L14:
        if (r16 > r14) goto L18;
        if (r16 != 1) goto L17;
        this.fieldArrayUniqueKey = (String) r11.readValue(r15);
    L17:
        r16 = r16 + 1;
    L18:
        if (r16 > r13) goto L20;
        ParcelUtils.INSTANCE.skipValueSafely(r11, r15);
        r16 = r16 + 1;
        goto L18
    L20:
        return;
    L5:
        if (r12.length() == 0) goto L8;
        r13 = Integer.parseInt(r12);
        goto L9
    }

    public static /* synthetic */ InAppSearchEntityParam copy$default(InAppSearchEntityParam r10, String r11, String r12, String r13, boolean r14, SearchScoreParam r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.keyword;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.field;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.value;
    L11:
        String r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.isSemantic;
    L14:
        boolean r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.score;
    L17:
        SearchScoreParam r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.fieldArrayUniqueKey;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @NotNull
    public final String component1() {
        return this.keyword;
    }

    @NotNull
    public final String component2() {
        return this.field;
    }

    @Nullable
    public final String component3() {
        return this.value;
    }

    public final boolean component4() {
        return this.isSemantic;
    }

    @Nullable
    public final SearchScoreParam component5() {
        return this.score;
    }

    @Nullable
    public final String component6() {
        return this.fieldArrayUniqueKey;
    }

    @NotNull
    public final InAppSearchEntityParam copy(@NotNull String r10, @NotNull String r11, @Nullable String r12, boolean r13, @Nullable SearchScoreParam r14, @Nullable String r15) {
        q.g(r10, "keyword");
        q.g(r11, "field");
        return new InAppSearchEntityParam(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof InAppSearchEntityParam) == true) goto L8;
        return false;
    L8:
        InAppSearchEntityParam r11 = (InAppSearchEntityParam) r10;
        if (q.b(this.keyword, r11.keyword) == true) goto L12;
        return false;
    L12:
        if (q.b(this.field, r11.field) == true) goto L15;
        return false;
    L15:
        if (q.b(this.value, r11.value) == true) goto L18;
        return false;
    L18:
        if (this.isSemantic == r11.isSemantic) goto L21;
        return false;
    L21:
        if (q.b(this.score, r11.score) == true) goto L24;
        return false;
    L24:
        if (q.b(this.fieldArrayUniqueKey, r11.fieldArrayUniqueKey) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @NotNull
    public final String getField() {
        return this.field;
    }

    @Nullable
    public final String getFieldArrayUniqueKey() {
        return this.fieldArrayUniqueKey;
    }

    @NotNull
    public final String getKeyword() {
        return this.keyword;
    }

    @Nullable
    public final SearchScoreParam getScore() {
        return this.score;
    }

    @Nullable
    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int r10 = ((this.keyword.hashCode() * 31) + this.field.hashCode()) * 31;
        String r11 = this.value;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.isSemantic;
        ?? r16 = r15;
        if (r15 == false) goto L9;
        r16 = 1;
    L9:
        int r17 = (r14 + r16) * 31;
        SearchScoreParam r18 = this.score;
        if (r18 != null) goto L12;
        int r19 = 0;
    L13:
        int r20 = (r17 + r19) * 31;
        String r21 = this.fieldArrayUniqueKey;
        if (r21 == null) goto L18;
        r12 = r21.hashCode();
    L18:
        return r20 + r12;
    L12:
        r19 = r18.hashCode();
        goto L13
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final void setField(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.field = r10;
    }

    public final void setFieldArrayUniqueKey(@Nullable String r10) {
        this.fieldArrayUniqueKey = r10;
    }

    public final void setScore(@Nullable SearchScoreParam r10) {
        this.score = r10;
    }

    @NotNull
    public String toString() {
        return "InAppSearchEntityParam(keyword=" + this.keyword + ", field=" + this.field + ", value=" + this.value + ", isSemantic=" + this.isSemantic + ", score=" + this.score + ", fieldArrayUniqueKey=" + this.fieldArrayUniqueKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.keyword);
        r10.writeString(this.field);
        r10.writeString(this.value);
        EntityExtKt.g(r10, this.isSemantic);
        r10.writeParcelable(this.score, r11);
        r10.writeString("1");
        r10.writeValue(this.fieldArrayUniqueKey);
    }

    public InAppSearchEntityParam(@NotNull String r10, @NotNull String r11, @Nullable String r12, boolean r13, @Nullable SearchScoreParam r14, @Nullable String r15) {
        q.g(r10, "keyword");
        q.g(r11, "field");
        this.keyword = r10;
        this.field = r11;
        this.value = r12;
        this.isSemantic = r13;
        this.score = r14;
        this.fieldArrayUniqueKey = r15;
    }

    public /* synthetic */ InAppSearchEntityParam(String r10, String r11, String r12, boolean r13, SearchScoreParam r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 4) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        boolean r19 = false;
    L11:
        if ((r16 & 16) == 0) goto L13;
        SearchScoreParam r20 = null;
    L15:
        if ((r16 & 32) == 0) goto L17;
        String r21 = null;
    L18:
        this(r10, r11, r18, r19, r20, r21);
        return;
    L17:
        r21 = r15;
        goto L18
    L13:
        r20 = r14;
        goto L15
    L9:
        r19 = r13;
        goto L11
    L5:
        r18 = r12;
        goto L7
    }
}
