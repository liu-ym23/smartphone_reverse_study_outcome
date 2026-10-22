package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.a;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppSearchRequest implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private final boolean enableSemanticRanking;
    private String filterConditions;
    private int firstPageLimit;
    private String interactionType;
    private final int maxEntityCount;
    private final int maxSemanticResultCount;
    private double minImageSemanticsDistance;
    private int otherPagesLimit;
    private String packageName;
    private String presetQUResult;
    private final String query;
    private final boolean useSemantic;

    public static final class CREATOR implements Parcelable.Creator<InAppSearchRequest> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchRequest createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            Object r1 = a.a().fromJson(r2.readString(), InAppSearchRequest.class);
            o.c(r1, "gson.fromJson(parcel.rea…earchRequest::class.java)");
            return (InAppSearchRequest) ZeusTransformUtils.preCheckCast(r1, InAppSearchRequest.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchRequest[] newArray(int r1) {
            return new InAppSearchRequest[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchRequest(String r2, int r3, boolean r4, boolean r5, int r6) {
        o.e(r2, DownloadConstants.QUERY_KEY);
        this.query = r2;
        this.maxEntityCount = r3;
        this.useSemantic = r4;
        this.enableSemanticRanking = r5;
        this.maxSemanticResultCount = r6;
        this.packageName = "";
        this.minImageSemanticsDistance = 0.39d;
        this.firstPageLimit = -1;
        this.interactionType = "";
        this.filterConditions = "";
    }

    public /* synthetic */ InAppSearchRequest(String r8, int r9, boolean r10, boolean r11, int r12, int r13, h r14) {
        if ((r13 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 4) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r5 = true;
    L15:
        if ((r13 & 16) == 0) goto L17;
        int r6 = 0;
    L18:
        this(r8, r3, r4, r5, r6);
        return;
    L17:
        r6 = r12;
        goto L18
    L13:
        r5 = r11;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public static /* synthetic */ InAppSearchRequest copy$default(InAppSearchRequest r3, String r4, int r5, boolean r6, boolean r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.query;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.maxEntityCount;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.useSemantic;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.enableSemanticRanking;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.maxSemanticResultCount;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.query;
    }

    public final int component2() {
        return this.maxEntityCount;
    }

    public final boolean component3() {
        return this.useSemantic;
    }

    public final boolean component4() {
        return this.enableSemanticRanking;
    }

    public final int component5() {
        return this.maxSemanticResultCount;
    }

    public final InAppSearchRequest copy(String r7, int r8, boolean r9, boolean r10, int r11) {
        o.e(r7, DownloadConstants.QUERY_KEY);
        return new InAppSearchRequest(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, InAppSearchRequest.class) == true) goto L8;
        return false;
    L8:
        InAppSearchRequest r6 = (InAppSearchRequest) ZeusTransformUtils.preCheckCast(r5, InAppSearchRequest.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (this.maxEntityCount == r6.maxEntityCount) goto L15;
        return false;
    L15:
        if (this.useSemantic == r6.useSemantic) goto L18;
        return false;
    L18:
        if (this.enableSemanticRanking == r6.enableSemanticRanking) goto L21;
        return false;
    L21:
        if (this.maxSemanticResultCount == r6.maxSemanticResultCount) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getEnableSemanticRanking() {
        return this.enableSemanticRanking;
    }

    public final String getFilterConditions() {
        return this.filterConditions;
    }

    public final int getFirstPageLimit() {
        return this.firstPageLimit;
    }

    public final String getInteractionType() {
        return this.interactionType;
    }

    public final int getMaxEntityCount() {
        return this.maxEntityCount;
    }

    public final int getMaxSemanticResultCount() {
        return this.maxSemanticResultCount;
    }

    public final double getMinImageSemanticsDistance() {
        return this.minImageSemanticsDistance;
    }

    public final int getOtherPagesLimit() {
        return this.otherPagesLimit;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPresetQUResult() {
        return this.presetQUResult;
    }

    public final String getQuery() {
        return this.query;
    }

    public final boolean getUseSemantic() {
        return this.useSemantic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((this.query.hashCode() * 31) + Integer.hashCode(this.maxEntityCount)) * 31;
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

    public final void setFilterConditions(String r2) {
        o.e(r2, "<set-?>");
        this.filterConditions = r2;
    }

    public final void setFirstPageLimit(int r1) {
        this.firstPageLimit = r1;
    }

    public final void setInteractionType(String r2) {
        o.e(r2, "<set-?>");
        this.interactionType = r2;
    }

    public final void setMinImageSemanticsDistance(double r1) {
        this.minImageSemanticsDistance = r1;
    }

    public final void setOtherPagesLimit(int r1) {
        this.otherPagesLimit = r1;
    }

    public final void setPackageName(String r2) {
        o.e(r2, "<set-?>");
        this.packageName = r2;
    }

    public final void setPresetQUResult(String r1) {
        this.presetQUResult = r1;
    }

    public String toString() {
        return "InAppSearchRequest(query=" + this.query + ", maxEntityCount=" + this.maxEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(a.a().toJson(this));
    }
}
