package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.UtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\b\u0010\"\u001a\u00020\u0006H\u0016J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "Landroid/os/Parcelable;", "query", "", "searchEntityTypes", "", "", "defaultEntityCount", "useSemantic", "", "enableSemanticRanking", "maxSemanticResultCount", "(Ljava/lang/String;Ljava/util/List;IZZI)V", "getDefaultEntityCount", "()I", "getEnableSemanticRanking", "()Z", "getMaxSemanticResultCount", "packageName", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "getQuery", "getSearchEntityTypes", "()Ljava/util/List;", "getUseSemantic", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchRequest implements Parcelable {
    public static final a CREATOR = null;
    private final int defaultEntityCount;
    private final boolean enableSemanticRanking;
    private final int maxSemanticResultCount;
    private String packageName;
    private final String query;
    private final List<Integer> searchEntityTypes;
    private final boolean useSemantic;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<GlobalSearchRequest> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public GlobalSearchRequest a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r1 = UtilsKt.getGson().fromJson(r2.readString(), GlobalSearchRequest.class);
            Intrinsics.checkNotNullExpressionValue(r1, "gson.fromJson(parcel.rea…earchRequest::class.java)");
            return (GlobalSearchRequest) r1;
        }

        public GlobalSearchRequest[] a(int r1) {
            return new GlobalSearchRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchRequest createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchRequest[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchRequest(String r2, List<Integer> r3, int r4, boolean r5, boolean r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r3, "searchEntityTypes");
        this.query = r2;
        this.searchEntityTypes = r3;
        this.defaultEntityCount = r4;
        this.useSemantic = r5;
        this.enableSemanticRanking = r6;
        this.maxSemanticResultCount = r7;
        this.packageName = "";
    }

    public /* synthetic */ GlobalSearchRequest(String r8, List r9, int r10, boolean r11, boolean r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = CollectionsKt.emptyList();
    L5:
        List r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r14 & 8) == 0) goto L12;
        boolean r4 = true;
    L14:
        if ((r14 & 16) == 0) goto L16;
        boolean r5 = true;
    L18:
        if ((r14 & 32) == 0) goto L20;
        int r6 = 0;
    L21:
        this(r8, r2, r3, r4, r5, r6);
        return;
    L20:
        r6 = r13;
        goto L21
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchRequest copy$default(GlobalSearchRequest r4, String r5, List r6, int r7, boolean r8, boolean r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.query;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.searchEntityTypes;
    L8:
        List r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.defaultEntityCount;
    L11:
        int r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.useSemantic;
    L14:
        boolean r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.enableSemanticRanking;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.maxSemanticResultCount;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.query;
    }

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

    public final GlobalSearchRequest copy(String r8, List<Integer> r9, int r10, boolean r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r8, "query");
        Intrinsics.checkNotNullParameter(r9, "searchEntityTypes");
        return new GlobalSearchRequest(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GlobalSearchRequest) == true) goto L8;
        return false;
    L8:
        GlobalSearchRequest r6 = (GlobalSearchRequest) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchEntityTypes, r6.searchEntityTypes) == true) goto L15;
        return false;
    L15:
        if (this.defaultEntityCount == r6.defaultEntityCount) goto L18;
        return false;
    L18:
        if (this.useSemantic == r6.useSemantic) goto L21;
        return false;
    L21:
        if (this.enableSemanticRanking == r6.enableSemanticRanking) goto L24;
        return false;
    L24:
        if (this.maxSemanticResultCount == r6.maxSemanticResultCount) goto L26;
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

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getQuery() {
        return this.query;
    }

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
        int r0 = ((((this.query.hashCode() * 31) + this.searchEntityTypes.hashCode()) * 31) + Integer.hashCode(this.defaultEntityCount)) * 31;
        boolean r1 = this.useSemantic;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.enableSemanticRanking;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return ((r4 + r2) * 31) + Integer.hashCode(this.maxSemanticResultCount);
    }

    public final void setPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.packageName = r2;
    }

    public String toString() {
        return "GlobalSearchRequest(query=" + this.query + ", searchEntityTypes=" + this.searchEntityTypes + ", defaultEntityCount=" + this.defaultEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(UtilsKt.getGson().toJson(this));
    }
}
