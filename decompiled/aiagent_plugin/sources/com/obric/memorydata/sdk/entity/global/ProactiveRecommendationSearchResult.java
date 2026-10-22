package com.obric.memorydata.sdk.entity.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveRecommendationSearchResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final List<ProactiveMemoryEntity> entityList;
    private final List<String> events;

    /* JADX INFO: compiled from: GlobalAssistantSearchResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<ProactiveRecommendationSearchResult> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProactiveRecommendationSearchResult createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProactiveRecommendationSearchResult[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProactiveRecommendationSearchResult createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new ProactiveRecommendationSearchResult(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProactiveRecommendationSearchResult[] newArray(int r1) {
            return new ProactiveRecommendationSearchResult[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ ProactiveRecommendationSearchResult copy$default(ProactiveRecommendationSearchResult r1, List r2, List r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List<ProactiveMemoryEntity> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.events;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.entityList;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<String> component1() {
        return this.events;
    }

    public final List<ProactiveMemoryEntity> component2() {
        return this.entityList;
    }

    public final ProactiveRecommendationSearchResult copy(List<String> r2, List<ProactiveMemoryEntity> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "events");
        o.e(r4, "entityList");
        return new ProactiveRecommendationSearchResult(r1, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProactiveRecommendationSearchResult.class) == true) goto L8;
        return false;
    L8:
        ProactiveRecommendationSearchResult r6 = (ProactiveRecommendationSearchResult) ZeusTransformUtils.preCheckCast(r5, ProactiveRecommendationSearchResult.class, "com.obric.aiagent.plugin");
        if (o.a(this.events, r6.events) == true) goto L12;
        return false;
    L12:
        if (o.a(this.entityList, r6.entityList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.events.hashCode() * 31) + this.entityList.hashCode();
    }

    public String toString() {
        return "ProactiveRecommendationSearchResult(events=" + this.events + ", entityList=" + this.entityList + ')';
    }

    public ProactiveRecommendationSearchResult(List<String> r3, List<ProactiveMemoryEntity> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<ProactiveMemoryEntity> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r5, "events");
        o.e(r6, "entityList");
        this.events = r5;
        this.entityList = r6;
    }

    public final List<String> getEvents() {
        return this.events;
    }

    public final List<ProactiveMemoryEntity> getEntityList() {
        return this.entityList;
    }

    public ProactiveRecommendationSearchResult(Parcel r5) {
        o.e(r5, "parcel");
        ArrayList<String> r0 = r5.createStringArrayList();
        o.a(r0);
        List r1 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        ArrayList r6 = r5.createTypedArrayList((Parcelable.Creator) ZeusTransformUtils.preCheckCast(ProactiveMemoryEntity.CREATOR, Parcelable.Creator.class, "com.obric.aiagent.plugin"));
        o.a(r6);
        this(r1, (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeStringList(this.events);
        r1.writeTypedList(this.entityList);
    }
}
