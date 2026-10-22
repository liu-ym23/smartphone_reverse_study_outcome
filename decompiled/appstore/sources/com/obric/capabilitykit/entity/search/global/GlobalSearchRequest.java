package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "Landroid/os/Parcelable;", "query", "", "searchEntityTypes", "", "", "defaultEntityCount", "useSemantic", "", "enableSemanticRanking", "maxSemanticResultCount", "(Ljava/lang/String;Ljava/util/List;IZZI)V", "getDefaultEntityCount", "()I", "getEnableSemanticRanking", "()Z", "getMaxSemanticResultCount", "packageName", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getQuery", "getSearchEntityTypes", "()Ljava/util/List;", "getUseSemantic", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchRequest implements Parcelable {

    @NotNull
    public static final a CREATOR = null;
    private final int defaultEntityCount;
    private final boolean enableSemanticRanking;
    private final int maxSemanticResultCount;

    @NotNull
    private String packageName;

    @NotNull
    private final String query;

    @NotNull
    private final List<Integer> searchEntityTypes;
    private final boolean useSemantic;

    public static final class a implements Parcelable.Creator {
        public a() {
        }

        public GlobalSearchRequest a(Parcel r10) {
            q.g(r10, "parcel");
            Object r11 = UtilsKt.getGson().fromJson(r10.readString(), GlobalSearchRequest.class);
            q.f(r11, "gson.fromJson(parcel.rea…earchRequest::class.java)");
            return (GlobalSearchRequest) r11;
        }

        public GlobalSearchRequest[] b(int r10) {
            return new GlobalSearchRequest[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchRequest(@NotNull String r10, @NotNull List<Integer> r11, int r12, boolean r13, boolean r14, int r15) {
        q.g(r10, "query");
        q.g(r11, "searchEntityTypes");
        this.query = r10;
        this.searchEntityTypes = r11;
        this.defaultEntityCount = r12;
        this.useSemantic = r13;
        this.enableSemanticRanking = r14;
        this.maxSemanticResultCount = r15;
        this.packageName = "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchRequest copy$default(GlobalSearchRequest r10, String r11, List r12, int r13, boolean r14, boolean r15, int r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.searchEntityTypes;
    L8:
        List r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.defaultEntityCount;
    L11:
        int r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.useSemantic;
    L14:
        boolean r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.enableSemanticRanking;
    L17:
        boolean r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.maxSemanticResultCount;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @NotNull
    public final String component1() {
        return this.query;
    }

    @NotNull
    public final List<Integer> component2() {
        return this.searchEntityTypes;
    }

    public final int component3() {
        return this.defaultEntityCount;
    }

    public final boolean component4() {
        return this.useSemantic;
    }

    public final boolean component5() {
        return this.enableSemanticRanking;
    }

    public final int component6() {
        return this.maxSemanticResultCount;
    }

    @NotNull
    public final GlobalSearchRequest copy(@NotNull String r10, @NotNull List<Integer> r11, int r12, boolean r13, boolean r14, int r15) {
        q.g(r10, "query");
        q.g(r11, "searchEntityTypes");
        return new GlobalSearchRequest(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof GlobalSearchRequest) == true) goto L8;
        return false;
    L8:
        GlobalSearchRequest r11 = (GlobalSearchRequest) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (q.b(this.searchEntityTypes, r11.searchEntityTypes) == true) goto L15;
        return false;
    L15:
        if (this.defaultEntityCount == r11.defaultEntityCount) goto L18;
        return false;
    L18:
        if (this.useSemantic == r11.useSemantic) goto L21;
        return false;
    L21:
        if (this.enableSemanticRanking == r11.enableSemanticRanking) goto L24;
        return false;
    L24:
        if (this.maxSemanticResultCount == r11.maxSemanticResultCount) goto L26;
        return false;
    L26:
        return true;
    }

    public final int getDefaultEntityCount() {
        return this.defaultEntityCount;
    }

    public final boolean getEnableSemanticRanking() {
        return this.enableSemanticRanking;
    }

    public final int getMaxSemanticResultCount() {
        return this.maxSemanticResultCount;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    public final String getQuery() {
        return this.query;
    }

    @NotNull
    public final List<Integer> getSearchEntityTypes() {
        return this.searchEntityTypes;
    }

    public final boolean getUseSemantic() {
        return this.useSemantic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r10 = ((((this.query.hashCode() * 31) + this.searchEntityTypes.hashCode()) * 31) + Integer.hashCode(this.defaultEntityCount)) * 31;
        boolean r11 = this.useSemantic;
        ?? r12 = 1;
        ?? r13 = r11;
        if (r11 == false) goto L5;
        r13 = 1;
    L5:
        int r14 = (r10 + r13) * 31;
        boolean r15 = this.enableSemanticRanking;
        if (r15 == true) goto L10;
        r12 = r15;
    L10:
        return ((r14 + r12) * 31) + Integer.hashCode(this.maxSemanticResultCount);
    }

    public final void setPackageName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.packageName = r10;
    }

    @NotNull
    public String toString() {
        return "GlobalSearchRequest(query=" + this.query + ", searchEntityTypes=" + this.searchEntityTypes + ", defaultEntityCount=" + this.defaultEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(UtilsKt.getGson().toJson(this));
    }

    public /* synthetic */ GlobalSearchRequest(String r10, List r11, int r12, boolean r13, boolean r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = t.i();
    L5:
        List r18 = r11;
        if ((r16 & 4) == 0) goto L8;
        int r19 = 0;
    L10:
        if ((r16 & 8) == 0) goto L12;
        boolean r20 = true;
    L14:
        if ((r16 & 16) == 0) goto L16;
        boolean r21 = true;
    L18:
        if ((r16 & 32) == 0) goto L20;
        int r22 = 0;
    L21:
        this(r10, r18, r19, r20, r21, r22);
        return;
    L20:
        r22 = r15;
        goto L21
    L16:
        r21 = r14;
        goto L18
    L12:
        r20 = r13;
        goto L14
    L8:
        r19 = r12;
        goto L10
    }
}
