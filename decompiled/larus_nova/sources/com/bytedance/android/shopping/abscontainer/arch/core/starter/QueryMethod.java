package com.bytedance.android.shopping.abscontainer.arch.core.starter;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/starter/QueryMethod;", "", "POST", "GET", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum QueryMethod extends Enum<QueryMethod> {
    public static final QueryMethod GET = null;
    public static final QueryMethod POST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ QueryMethod[] f164151a = null;

    static {
        QueryMethod r100 = new QueryMethod("POST", 0);
        POST = r100;
        QueryMethod r101 = new QueryMethod("GET", 1);
        GET = r101;
        f164151a = new QueryMethod[]{r100, r101};
    }

    public static QueryMethod valueOf(String r100) {
        return (QueryMethod) r27.a.a(QueryMethod.class, r100);
    }

    public static QueryMethod[] values() {
        return (QueryMethod[]) f164151a.clone();
    }

    public QueryMethod(String r100, int r101) {
        super(r100, r101);
    }
}
