package com.obric.memorydata.sdk.entity.search;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BertQUAction {
    private final String actionName;
    private final Map<String, ParamItem> inputParams;
    private boolean isStandardQuery;
    private final String query;

    public static /* synthetic */ BertQUAction copy$default(BertQUAction r1, String r2, String r3, Map r4, boolean r5, int r6, Object r7) {
        Map<String, ParamItem> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.actionName;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.query;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.inputParams;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.isStandardQuery;
    L15:
        return r1.copy(r2, r3, r8, r5);
    }

    public final String component1() {
        return this.actionName;
    }

    public final String component2() {
        return this.query;
    }

    public final Map<String, ParamItem> component3() {
        return this.inputParams;
    }

    public final boolean component4() {
        return this.isStandardQuery;
    }

    public final BertQUAction copy(String r2, String r3, Map<String, ParamItem> r4, boolean r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "actionName");
        o.e(r3, DownloadConstants.QUERY_KEY);
        return new BertQUAction(r2, r3, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, BertQUAction.class) == true) goto L8;
        return false;
    L8:
        BertQUAction r6 = (BertQUAction) ZeusTransformUtils.preCheckCast(r5, BertQUAction.class, "com.obric.aiagent.plugin");
        if (o.a(this.actionName, r6.actionName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.query, r6.query) == true) goto L15;
        return false;
    L15:
        if (o.a(this.inputParams, r6.inputParams) == true) goto L18;
        return false;
    L18:
        if (this.isStandardQuery == r6.isStandardQuery) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.actionName.hashCode() * 31) + this.query.hashCode()) * 31;
        Map<String, ParamItem> r1 = this.inputParams;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Boolean.hashCode(this.isStandardQuery);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "BertQUAction(actionName=" + this.actionName + ", query=" + this.query + ", inputParams=" + this.inputParams + ", isStandardQuery=" + this.isStandardQuery + ')';
    }

    public BertQUAction(String r3, String r4, Map<String, ParamItem> r5, boolean r6) {
        Map<String, ParamItem> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "actionName");
        o.e(r4, DownloadConstants.QUERY_KEY);
        this.actionName = r3;
        this.query = r4;
        this.inputParams = r7;
        this.isStandardQuery = r6;
    }

    public final String getActionName() {
        return this.actionName;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Map<String, ParamItem> getInputParams() {
        return this.inputParams;
    }

    public final boolean isStandardQuery() {
        return this.isStandardQuery;
    }

    public final void setStandardQuery(boolean r1) {
        this.isStandardQuery = r1;
    }
}
