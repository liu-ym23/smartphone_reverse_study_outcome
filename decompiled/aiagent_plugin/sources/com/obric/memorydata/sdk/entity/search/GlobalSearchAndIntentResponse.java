package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GlobalSearchAndIntentResponse implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String origin_query;
    private final List<RewriteQuery> searchAppEntity;
    private final List<RewriteQuery> searchAppEntityContent;
    private final List<RewriteQuery> searchMemoryEntity;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<GlobalSearchAndIntentResponse> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchAndIntentResponse createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GlobalSearchAndIntentResponse[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalSearchAndIntentResponse createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new GlobalSearchAndIntentResponse(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GlobalSearchAndIntentResponse[] newArray(int r1) {
            return new GlobalSearchAndIntentResponse[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ GlobalSearchAndIntentResponse copy$default(GlobalSearchAndIntentResponse r1, String r2, List r3, List r4, List r5, int r6, Object r7) {
        List<RewriteQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<RewriteQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<RewriteQuery> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.origin_query;
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
        return this.origin_query;
    }

    public final List<RewriteQuery> component2() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> component3() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> component4() {
        return this.searchMemoryEntity;
    }

    public final GlobalSearchAndIntentResponse copy(String r2, List<RewriteQuery> r3, List<RewriteQuery> r4, List<RewriteQuery> r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r2, "origin_query");
        return new GlobalSearchAndIntentResponse(r2, r1, r6, r7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GlobalSearchAndIntentResponse.class) == true) goto L8;
        return false;
    L8:
        GlobalSearchAndIntentResponse r6 = (GlobalSearchAndIntentResponse) ZeusTransformUtils.preCheckCast(r5, GlobalSearchAndIntentResponse.class, "com.obric.aiagent.plugin");
        if (o.a(this.origin_query, r6.origin_query) == true) goto L12;
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
        int r0 = this.origin_query.hashCode() * 31;
        List<RewriteQuery> r1 = this.searchAppEntity;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<RewriteQuery> r5 = this.searchAppEntityContent;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        List<RewriteQuery> r8 = this.searchMemoryEntity;
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
        return "GlobalSearchAndIntentResponse(origin_query=" + this.origin_query + ", searchAppEntity=" + this.searchAppEntity + ", searchAppEntityContent=" + this.searchAppEntityContent + ", searchMemoryEntity=" + this.searchMemoryEntity + ')';
    }

    public GlobalSearchAndIntentResponse(String r3, List<RewriteQuery> r4, List<RewriteQuery> r5, List<RewriteQuery> r6) {
        List<RewriteQuery> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List<RewriteQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<RewriteQuery> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "origin_query");
        this.origin_query = r3;
        this.searchAppEntity = r7;
        this.searchAppEntityContent = r8;
        this.searchMemoryEntity = r9;
    }

    public final String getOrigin_query() {
        return this.origin_query;
    }

    public final List<RewriteQuery> getSearchAppEntity() {
        return this.searchAppEntity;
    }

    public final List<RewriteQuery> getSearchAppEntityContent() {
        return this.searchAppEntityContent;
    }

    public final List<RewriteQuery> getSearchMemoryEntity() {
        return this.searchMemoryEntity;
    }

    public GlobalSearchAndIntentResponse(Parcel r7) {
        o.e(r7, "parcel");
        String r0 = r7.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        ArrayList r1 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r1 == null) goto L8;
        List r2 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin");
    L9:
        ArrayList r3 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r3 == null) goto L12;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
    L13:
        ArrayList r8 = r7.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(RewriteQuery.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
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
        r1.writeString(this.origin_query);
        r1.writeTypedList(this.searchAppEntity);
        r1.writeTypedList(this.searchAppEntityContent);
        r1.writeTypedList(this.searchMemoryEntity);
    }
}
