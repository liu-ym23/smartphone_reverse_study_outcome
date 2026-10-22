package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected SearchType f8576a;

    public abstract SearchResult a(String str);

    public abstract void a(SearchResult searchResult, Object obj);

    public void a(SearchType searchType) {
        this.f8576a = searchType;
    }

    public SearchType a() {
        return this.f8576a;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0067 A[Catch: JSONException -> 0x0019, TryCatch #0 {JSONException -> 0x0019, blocks: (B:4:0x0003, B:7:0x000b, B:9:0x0012, B:32:0x0046, B:33:0x0049, B:34:0x004e, B:35:0x0053, B:36:0x0058, B:37:0x005d, B:38:0x0062, B:39:0x0067, B:12:0x001b, B:43:0x006e), top: B:47:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r2, com.baidu.mapapi.search.core.SearchResult r3, boolean r4) {
        /*
            r1 = this;
            r1 = 1
            if (r2 == 0) goto L6e
            int r0 = r2.length()     // Catch: org.json.JSONException -> L19
            if (r0 > 0) goto Lb
            goto L6e
        Lb:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L19
            r0.<init>(r2)     // Catch: org.json.JSONException -> L19
            if (r4 == 0) goto L1b
            java.lang.String r2 = "status"
            int r2 = r0.optInt(r2)     // Catch: org.json.JSONException -> L19
            goto L21
        L19:
            r2 = move-exception
            goto L73
        L1b:
            java.lang.String r2 = "status_sp"
            int r2 = r0.optInt(r2)     // Catch: org.json.JSONException -> L19
        L21:
            if (r2 == 0) goto L6c
            r4 = 2
            if (r2 == r4) goto L67
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == r4) goto L62
            r4 = 230(0xe6, float:3.22E-43)
            if (r2 == r4) goto L62
            r4 = 10
            if (r2 == r4) goto L5d
            r4 = 11
            if (r2 == r4) goto L5d
            r4 = 40
            if (r2 == r4) goto L58
            r4 = 41
            if (r2 == r4) goto L53
            r4 = 44
            if (r2 == r4) goto L53
            r4 = 45
            if (r2 == r4) goto L67
            switch(r2) {
                case 104: goto L4e;
                case 105: goto L4e;
                case 106: goto L4e;
                case 107: goto L4e;
                case 108: goto L4e;
                default: goto L49;
            }     // Catch: org.json.JSONException -> L19
        L49:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L4e:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.PERMISSION_UNFINISHED     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L53:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NO_DATA_FOR_LATLNG     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L58:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.INVALID_DISTRICT_ID     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L5d:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.PARAMER_ERROR     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L62:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.KEY_ERROR     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            goto L6b
        L67:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.NO_ADVANCED_PERMISSION     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
        L6b:
            return r1
        L6c:
            r1 = 0
            return r1
        L6e:
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR     // Catch: org.json.JSONException -> L19
            r3.error = r2     // Catch: org.json.JSONException -> L19
            return r1
        L73:
            r2.printStackTrace()
            com.baidu.mapapi.search.core.SearchResult$ERRORNO r2 = com.baidu.mapapi.search.core.SearchResult.ERRORNO.RESULT_NOT_FOUND
            r3.error = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.base.b.a(java.lang.String, com.baidu.mapapi.search.core.SearchResult, boolean):boolean");
    }
}
