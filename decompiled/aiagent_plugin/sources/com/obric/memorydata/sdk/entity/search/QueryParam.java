package com.obric.memorydata.sdk.entity.search;

import com.google.gson.annotations.SerializedName;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.meta.MetaValue;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: QueryParam.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class QueryParam {

    @SerializedName("Intent")
    private final String intent;

    @SerializedName("Query")
    private final List<SLMQuery> query;

    @SerializedName("QueryId")
    private final String queryId;

    @SerializedName("ReferenceAppEntity")
    private final List<AppEntity> referenceAppEntity;

    @SerializedName("ReferenceMetaValue")
    private final List<MetaValue> referenceMetaValue;

    public static /* synthetic */ QueryParam copy$default(QueryParam r6, List r7, String r8, List r9, List r10, String r11, int r12, Object r13) {
        List<SLMQuery> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        List<MetaValue> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r14 = r6.query;
    L5:
        List<SLMQuery> r1 = r14;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.intent;
    L8:
        String r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r15 = r6.referenceAppEntity;
    L11:
        List<AppEntity> r3 = r15;
        if ((r12 & 8) == 0) goto L14;
        r16 = r6.referenceMetaValue;
    L14:
        List<MetaValue> r4 = r16;
        if ((r12 & 16) == 0) goto L18;
        r11 = r6.queryId;
    L18:
        return r6.copy(r1, r2, r3, r4, r11);
    }

    public final List<SLMQuery> component1() {
        return this.query;
    }

    public final String component2() {
        return this.intent;
    }

    public final List<AppEntity> component3() {
        return this.referenceAppEntity;
    }

    public final List<MetaValue> component4() {
        return this.referenceMetaValue;
    }

    public final String component5() {
        return this.queryId;
    }

    public final QueryParam copy(List<SLMQuery> r8, String r9, List<? extends AppEntity> r10, List<? extends MetaValue> r11, String r12) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        o.e(r2, DownloadConstants.QUERY_KEY);
        o.e(r4, "referenceAppEntity");
        o.e(r5, "referenceMetaValue");
        o.e(r12, "queryId");
        return new QueryParam(r2, r9, r4, r5, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, QueryParam.class) == true) goto L8;
        return false;
    L8:
        QueryParam r6 = (QueryParam) ZeusTransformUtils.preCheckCast(r5, QueryParam.class, "com.obric.aiagent.plugin");
        if (o.a(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (o.a(this.intent, r6.intent) == true) goto L15;
        return false;
    L15:
        if (o.a(this.referenceAppEntity, r6.referenceAppEntity) == true) goto L18;
        return false;
    L18:
        if (o.a(this.referenceMetaValue, r6.referenceMetaValue) == true) goto L21;
        return false;
    L21:
        if (o.a(this.queryId, r6.queryId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.query.hashCode() * 31;
        String r1 = this.intent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.referenceAppEntity.hashCode()) * 31) + this.referenceMetaValue.hashCode()) * 31) + this.queryId.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "QueryParam(query=" + this.query + ", intent=" + this.intent + ", referenceAppEntity=" + this.referenceAppEntity + ", referenceMetaValue=" + this.referenceMetaValue + ", queryId=" + this.queryId + ')';
    }

    public QueryParam(List<SLMQuery> r3, String r4, List<? extends AppEntity> r5, List<? extends MetaValue> r6, String r7) {
        List<SLMQuery> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<AppEntity> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List<MetaValue> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r8, DownloadConstants.QUERY_KEY);
        o.e(r9, "referenceAppEntity");
        o.e(r10, "referenceMetaValue");
        o.e(r7, "queryId");
        this.query = r8;
        this.intent = r4;
        this.referenceAppEntity = r9;
        this.referenceMetaValue = r10;
        this.queryId = r7;
    }

    public /* synthetic */ QueryParam(List r8, String r9, List r10, List r11, String r12, int r13, h r14) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if ((r13 & 16) == 0) goto L5;
        r12 = "";
    L5:
        this(r2, r9, r4, r5, r12);
    }

    public final List<SLMQuery> getQuery() {
        return this.query;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final List<AppEntity> getReferenceAppEntity() {
        return this.referenceAppEntity;
    }

    public final List<MetaValue> getReferenceMetaValue() {
        return this.referenceMetaValue;
    }

    public final String getQueryId() {
        return this.queryId;
    }
}
