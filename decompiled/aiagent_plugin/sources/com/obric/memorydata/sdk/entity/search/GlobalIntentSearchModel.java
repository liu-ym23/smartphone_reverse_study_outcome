package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GlobalIntentSearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalIntentSearchModel implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("originQuery")
    private final String originQuery;

    @SerializedName("searchAppEntity")
    private final List<SearchDomainQuery> searchAppEntity;

    @SerializedName("searchAppEntityContent")
    private final List<SearchDomainQuery> searchAppEntityContent;

    @SerializedName("searchMemoryEntity")
    private final List<SearchDomainQuery> searchMemoryEntity;

    /* JADX INFO: compiled from: GlobalIntentSearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalIntentSearchModel> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalIntentSearchModel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalIntentSearchModel[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalIntentSearchModel createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalIntentSearchModel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalIntentSearchModel[] newArray(int r1) {
            return new GlobalIntentSearchModel[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public GlobalIntentSearchModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ GlobalIntentSearchModel copy$default(GlobalIntentSearchModel r1, String r2, List r3, List r4, List r5, int r6, Object r7) {
        List<SearchDomainQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<SearchDomainQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<SearchDomainQuery> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.originQuery;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = r1.searchAppEntity;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = r1.searchAppEntityContent;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r10 = r1.searchMemoryEntity;
    L15:
        return r1.copy(r2, r8, r9, r10);
    }

    public final String component1() {
        return this.originQuery;
    }

    public final List<SearchDomainQuery> component2() {
        return this.searchAppEntity;
    }

    public final List<SearchDomainQuery> component3() {
        return this.searchAppEntityContent;
    }

    public final List<SearchDomainQuery> component4() {
        return this.searchMemoryEntity;
    }

    public final GlobalIntentSearchModel copy(String r2, List<SearchDomainQuery> r3, List<SearchDomainQuery> r4, List<SearchDomainQuery> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "originQuery");
        o.e(r1, "searchAppEntity");
        o.e(r6, "searchAppEntityContent");
        o.e(r7, "searchMemoryEntity");
        return new GlobalIntentSearchModel(r2, r1, r6, r7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalIntentSearchModel.class) == true) goto L8;
        return false;
    L8:
        GlobalIntentSearchModel r6 = (GlobalIntentSearchModel) ZeusTransformUtils.preCheckCast(r5, GlobalIntentSearchModel.class, "com.obric.aiagent.plugin");
        if (o.a(this.originQuery, r6.originQuery) == true) goto L12;
        return false;
    L12:
        if (o.a(this.searchAppEntity, r6.searchAppEntity) == true) goto L15;
        return false;
    L15:
        if (o.a(this.searchAppEntityContent, r6.searchAppEntityContent) == true) goto L18;
        return false;
    L18:
        if (o.a(this.searchMemoryEntity, r6.searchMemoryEntity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.originQuery.hashCode() * 31) + this.searchAppEntity.hashCode()) * 31) + this.searchAppEntityContent.hashCode()) * 31) + this.searchMemoryEntity.hashCode();
    }

    public String toString() {
        return "GlobalIntentSearchModel(originQuery=" + this.originQuery + ", searchAppEntity=" + this.searchAppEntity + ", searchAppEntityContent=" + this.searchAppEntityContent + ", searchMemoryEntity=" + this.searchMemoryEntity + ')';
    }

    public GlobalIntentSearchModel(String r3, List<SearchDomainQuery> r4, List<SearchDomainQuery> r5, List<SearchDomainQuery> r6) {
        List<SearchDomainQuery> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<SearchDomainQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<SearchDomainQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "originQuery");
        o.e(r7, "searchAppEntity");
        o.e(r8, "searchAppEntityContent");
        o.e(r9, "searchMemoryEntity");
        this.originQuery = r3;
        this.searchAppEntity = r7;
        this.searchAppEntityContent = r8;
        this.searchMemoryEntity = r9;
    }

    public final String getOriginQuery() {
        return this.originQuery;
    }

    public final List<SearchDomainQuery> getSearchAppEntity() {
        return this.searchAppEntity;
    }

    public /* synthetic */ GlobalIntentSearchModel(String r2, List r3, List r4, List r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r8 = p.b();
    L9:
        if ((r6 & 4) == 0) goto L12;
        r9 = p.b();
    L12:
        if ((r6 & 8) == 0) goto L14;
        r10 = p.b();
    L14:
        this(r2, r8, r9, r10);
    }

    public final List<SearchDomainQuery> getSearchAppEntityContent() {
        return this.searchAppEntityContent;
    }

    public final List<SearchDomainQuery> getSearchMemoryEntity() {
        return this.searchMemoryEntity;
    }

    public GlobalIntentSearchModel(Parcel r7) {
        o.e(r7, "parcel");
        String r0 = r7.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ArrayList r1 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(SearchDomainQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L8;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L9:
        ArrayList r3 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(SearchDomainQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L12;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L13:
        ArrayList r8 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(SearchDomainQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r8 == null) goto L16;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L17:
        this(r0, r2, r4, r9);
        return;
    L16:
        r9 = p.b();
        goto L17
    L12:
        r4 = p.b();
        goto L13
    L8:
        r2 = p.b();
        goto L9
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.originQuery);
        r1.writeTypedList(this.searchAppEntity);
        r1.writeTypedList(this.searchAppEntityContent);
        r1.writeTypedList(this.searchMemoryEntity);
    }
}
