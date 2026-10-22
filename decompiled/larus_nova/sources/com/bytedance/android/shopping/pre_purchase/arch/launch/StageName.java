package com.bytedance.android.shopping.pre_purchase.arch.launch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/pre_purchase/arch/launch/StageName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PDP_SCHEMA_PARSE", "PDP_LOGIN_CHECK", "PDP_OPEN_PAGE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StageName extends Enum<StageName> {
    public static final StageName PDP_LOGIN_CHECK = null;
    public static final StageName PDP_OPEN_PAGE = null;
    public static final StageName PDP_SCHEMA_PARSE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StageName[] f180650a = null;
    private final String value;

    static {
        StageName r100 = new StageName("PDP_SCHEMA_PARSE", 0, "pdp_schema_parse");
        PDP_SCHEMA_PARSE = r100;
        StageName r101 = new StageName("PDP_LOGIN_CHECK", 1, "pdp_login_check");
        PDP_LOGIN_CHECK = r101;
        StageName r102 = new StageName("PDP_OPEN_PAGE", 2, "pdp_open_page");
        PDP_OPEN_PAGE = r102;
        f180650a = new StageName[]{r100, r101, r102};
    }

    public static StageName valueOf(String r100) {
        return (StageName) r27.a.a(StageName.class, r100);
    }

    public static StageName[] values() {
        return (StageName[]) f180650a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public StageName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
