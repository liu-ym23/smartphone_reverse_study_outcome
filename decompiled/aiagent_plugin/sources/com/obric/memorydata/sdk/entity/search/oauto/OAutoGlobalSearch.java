package com.obric.memorydata.sdk.entity.search.oauto;

import android.content.Context;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.json.JSONObject;

/* JADX INFO: compiled from: OAutoGlobalSearch.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OAutoGlobalSearch {
    public static final OAutoGlobalSearch INSTANCE = null;

    static {
        INSTANCE = new OAutoGlobalSearch();
    }

    private OAutoGlobalSearch() {
    }

    public final OAutoSearchResult searchByQUResult(Context r4, String r5, boolean r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        a r7 = a.f33793a;
        JSONObject r1 = new JSONObject();
        r1.put("quResult", r5);
        if (r6 == false) goto L5;
        String r8 = "VOICE";
    L6:
        r1.put("interactionType", r8);
        MemoryResponse<OAutoSearchResult> r9 = r7.a(r1, r3);
        OAutoSearchResult r10 = (OAutoSearchResult) ZeusTransformUtils.preCheckCast(r9.getData(), OAutoSearchResult.class, "com.obric.aiagent.plugin");
        if (r9.getCode() != 0) goto L11;
        if (r10 == null) goto L11;
        return r10;
    L11:
        return new OAutoSearchResult(r9.getCode(), r9.getMessage(), null);
    L5:
        r8 = "TEXT";
        goto L6
    }
}
