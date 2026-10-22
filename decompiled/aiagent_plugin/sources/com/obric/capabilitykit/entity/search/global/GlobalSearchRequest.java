package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalSearchRequest implements Parcelable {
    public static final a CREATOR = null;
    private final int defaultEntityCount;
    private final boolean enableSemanticRanking;
    private final int maxSemanticResultCount;
    private String packageName;
    private final String query;
    private final List<Integer> searchEntityTypes;
    private final boolean useSemantic;

    public static final class a implements Parcelable.Creator<GlobalSearchRequest> {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public GlobalSearchRequest a(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = com.obric.capabilitykit.common.a.a().fromJson(r2.readString(), GlobalSearchRequest.class);
            o.c(r1, "gson.fromJson(parcel.rea…earchRequest::class.java)");
            return (GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r1, GlobalSearchRequest.class, "com.obric.aiagent.plugin");
        }

        public GlobalSearchRequest[] a(int r1) {
            return new GlobalSearchRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchRequest createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ GlobalSearchRequest[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public GlobalSearchRequest(String r3, List<Integer> r4, int r5, boolean r6, boolean r7, int r8) {
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DownloadConstants.QUERY_KEY);
        o.e(r9, "searchEntityTypes");
        this.query = r3;
        this.searchEntityTypes = r9;
        this.defaultEntityCount = r5;
        this.useSemantic = r6;
        this.enableSemanticRanking = r7;
        this.maxSemanticResultCount = r8;
        this.packageName = "";
    }

    public /* synthetic */ GlobalSearchRequest(String r8, List r9, int r10, boolean r11, boolean r12, int r13, int r14, h r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 2) == 0) goto L5;
        r16 = p.b();
    L5:
        List r2 = r16;
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

    public static /* synthetic */ GlobalSearchRequest copy$default(GlobalSearchRequest r7, String r8, List r9, int r10, boolean r11, boolean r12, int r13, int r14, Object r15) {
        List<Integer> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        if ((r14 & 1) == 0) goto L5;
        r8 = r7.query;
    L5:
        String r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r16 = r7.searchEntityTypes;
    L8:
        List<Integer> r2 = r16;
        if ((r14 & 4) == 0) goto L11;
        r10 = r7.defaultEntityCount;
    L11:
        int r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = r7.useSemantic;
    L14:
        boolean r4 = r11;
        if ((r14 & 16) == 0) goto L17;
        r12 = r7.enableSemanticRanking;
    L17:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L21;
        r13 = r7.maxSemanticResultCount;
    L21:
        return r7.copy(r1, r2, r3, r4, r5, r13);
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
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        o.e(r8, DownloadConstants.QUERY_KEY);
        o.e(r2, "searchEntityTypes");
        return new GlobalSearchRequest(r8, r2, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchRequest.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchRequest r6 = (GlobalSearchRequest) ZeusTransformUtils.preCheckCast(r5, GlobalSearchRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.searchEntityTypes, r6.searchEntityTypes) == true) goto L15;
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
        o.e(r2, "<set-?>");
        this.packageName = r2;
    }

    public String toString() {
        return "GlobalSearchRequest(query=" + this.query + ", searchEntityTypes=" + this.searchEntityTypes + ", defaultEntityCount=" + this.defaultEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(com.obric.capabilitykit.common.a.a().toJson(this));
    }
}
