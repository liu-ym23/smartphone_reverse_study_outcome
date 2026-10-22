package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J;\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\b\u00103\u001a\u00020\u0005H\u0016J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0005HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\u001a\u0010%\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000f\"\u0004\b'\u0010\u0011R\u001c\u0010(\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\f¨\u0006?"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "Landroid/os/Parcelable;", "query", "", "maxEntityCount", "", "useSemantic", "", "enableSemanticRanking", "maxSemanticResultCount", "(Ljava/lang/String;IZZI)V", "getEnableSemanticRanking", "()Z", "filterConditions", "getFilterConditions", "()Ljava/lang/String;", "setFilterConditions", "(Ljava/lang/String;)V", "firstPageLimit", "getFirstPageLimit", "()I", "setFirstPageLimit", "(I)V", "interactionType", "getInteractionType", "setInteractionType", "getMaxEntityCount", "getMaxSemanticResultCount", "minImageSemanticsDistance", "", "getMinImageSemanticsDistance", "()D", "setMinImageSemanticsDistance", "(D)V", "otherPagesLimit", "getOtherPagesLimit", "setOtherPagesLimit", "packageName", "getPackageName", "setPackageName", "presetQUResult", "getPresetQUResult", "setPresetQUResult", "getQuery", "getUseSemantic", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchRequest implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;

    @NotNull
    private static final String VERSION = "1";
    private final boolean enableSemanticRanking;

    @NotNull
    private String filterConditions;
    private int firstPageLimit;

    @NotNull
    private String interactionType;
    private final int maxEntityCount;
    private final int maxSemanticResultCount;
    private double minImageSemanticsDistance;
    private int otherPagesLimit;

    @NotNull
    private String packageName;

    @Nullable
    private String presetQUResult;

    @NotNull
    private final String query;
    private final boolean useSemantic;

    @Keep
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchRequest;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchRequest> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchRequest createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            Object r11 = UtilsKt.getGson().fromJson(r10.readString(), InAppSearchRequest.class);
            q.f(r11, "gson.fromJson(parcel.rea…earchRequest::class.java)");
            return (InAppSearchRequest) r11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public InAppSearchRequest[] newArray(int r10) {
            return new InAppSearchRequest[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchRequest[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchRequest(@NotNull String r10, int r11, boolean r12, boolean r13, int r14) {
        q.g(r10, "query");
        this.query = r10;
        this.maxEntityCount = r11;
        this.useSemantic = r12;
        this.enableSemanticRanking = r13;
        this.maxSemanticResultCount = r14;
        this.packageName = "";
        this.minImageSemanticsDistance = 0.39d;
        this.firstPageLimit = -1;
        this.interactionType = "";
        this.filterConditions = "";
    }

    public static /* synthetic */ InAppSearchRequest copy$default(InAppSearchRequest r10, String r11, int r12, boolean r13, boolean r14, int r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.query;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.maxEntityCount;
    L8:
        int r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.useSemantic;
    L11:
        boolean r19 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.enableSemanticRanking;
    L14:
        boolean r20 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.maxSemanticResultCount;
    L17:
        String r21 = r11;
        return r10.copy(r21, r18, r19, r20, r15);
    }

    @NotNull
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

    @NotNull
    public final InAppSearchRequest copy(@NotNull String r10, int r11, boolean r12, boolean r13, int r14) {
        q.g(r10, "query");
        return new InAppSearchRequest(r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof InAppSearchRequest) == true) goto L8;
        return false;
    L8:
        InAppSearchRequest r11 = (InAppSearchRequest) r10;
        if (q.b(this.query, r11.query) == true) goto L12;
        return false;
    L12:
        if (this.maxEntityCount == r11.maxEntityCount) goto L15;
        return false;
    L15:
        if (this.useSemantic == r11.useSemantic) goto L18;
        return false;
    L18:
        if (this.enableSemanticRanking == r11.enableSemanticRanking) goto L21;
        return false;
    L21:
        if (this.maxSemanticResultCount == r11.maxSemanticResultCount) goto L23;
        return false;
    L23:
        return true;
    }

    public final boolean getEnableSemanticRanking() {
        return this.enableSemanticRanking;
    }

    @NotNull
    public final String getFilterConditions() {
        return this.filterConditions;
    }

    public final int getFirstPageLimit() {
        return this.firstPageLimit;
    }

    @NotNull
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

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final String getPresetQUResult() {
        return this.presetQUResult;
    }

    @NotNull
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
        int r10 = ((this.query.hashCode() * 31) + Integer.hashCode(this.maxEntityCount)) * 31;
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

    public final void setFilterConditions(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.filterConditions = r10;
    }

    public final void setFirstPageLimit(int r10) {
        this.firstPageLimit = r10;
    }

    public final void setInteractionType(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.interactionType = r10;
    }

    public final void setMinImageSemanticsDistance(double r10) {
        this.minImageSemanticsDistance = r10;
    }

    public final void setOtherPagesLimit(int r10) {
        this.otherPagesLimit = r10;
    }

    public final void setPackageName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.packageName = r10;
    }

    public final void setPresetQUResult(@Nullable String r10) {
        this.presetQUResult = r10;
    }

    @NotNull
    public String toString() {
        return "InAppSearchRequest(query=" + this.query + ", maxEntityCount=" + this.maxEntityCount + ", useSemantic=" + this.useSemantic + ", enableSemanticRanking=" + this.enableSemanticRanking + ", maxSemanticResultCount=" + this.maxSemanticResultCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(UtilsKt.getGson().toJson(this));
    }

    public /* synthetic */ InAppSearchRequest(String r10, int r11, boolean r12, boolean r13, int r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 2) == 0) goto L5;
        int r17 = 0;
    L7:
        if ((r15 & 4) == 0) goto L9;
        boolean r18 = true;
    L11:
        if ((r15 & 8) == 0) goto L13;
        boolean r19 = true;
    L15:
        if ((r15 & 16) == 0) goto L17;
        int r20 = 0;
    L18:
        this(r10, r17, r18, r19, r20);
        return;
    L17:
        r20 = r14;
        goto L18
    L13:
        r19 = r13;
        goto L15
    L9:
        r18 = r12;
        goto L11
    L5:
        r17 = r11;
        goto L7
    }
}
