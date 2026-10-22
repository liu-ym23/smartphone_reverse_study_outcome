package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SearchResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<AppEntity> entityList;
    private final AssistantQuResult quResult;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<SearchResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new SearchResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchResult[] newArray(int r1) {
            return new SearchResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ SearchResult copy$default(SearchResult r1, List r2, AssistantQuResult r3, int r4, Object r5) {
        List<AppEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.entityList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.quResult;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<AppEntity> component1() {
        return this.entityList;
    }

    public final AssistantQuResult component2() {
        return this.quResult;
    }

    public final SearchResult copy(List<? extends AppEntity> r2, AssistantQuResult r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "entityList");
        return new SearchResult(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SearchResult.class) == true) goto L8;
        return false;
    L8:
        SearchResult r6 = (SearchResult) ZeusTransformUtils.preCheckCast(r5, SearchResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.entityList, r6.entityList) == true) goto L12;
        return false;
    L12:
        if (o.a(this.quResult, r6.quResult) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.entityList.hashCode() * 31;
        AssistantQuResult r1 = this.quResult;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SearchResult(entityList=" + this.entityList + ", quResult=" + this.quResult + ')';
    }

    public SearchResult(List<? extends AppEntity> r3, AssistantQuResult r4) {
        List<AppEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "entityList");
        this.entityList = r5;
        this.quResult = r4;
    }

    public /* synthetic */ SearchResult(List r2, AssistantQuResult r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        this(r6, r3);
    }

    public final List<AppEntity> getEntityList() {
        return this.entityList;
    }

    public final AssistantQuResult getQuResult() {
        return this.quResult;
    }

    public SearchResult(Parcel r4) {
        o.e(r4, "parcel");
        ArrayList r0 = r4.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(AppEntity.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        if (r0 == null) goto L5;
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L6:
        this(r1, (AssistantQuResult) ZeusTransformUtils.preCheckCast(r4.readParcelable(AssistantQuResult.class.getClassLoader()), AssistantQuResult.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        r1 = p.b();
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeTypedList(this.entityList);
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.quResult, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }
}
