package com.bytedance.android.shopping.pre_purchase.arch.launch;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/pre_purchase/arch/launch/BizHandlerName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PDP_ASYNC_INFLATE", "PDP_SCHEMA_PARSE_BIZ", "PDP_LOGIN_CHECK_BIZ", "PDP_OPEN_PAGE_BIZ", "PDP_PRELOAD_HEAD_IMG", "PDP_PRELOAD_PACK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BizHandlerName extends Enum<BizHandlerName> {
    public static final BizHandlerName PDP_ASYNC_INFLATE = null;
    public static final BizHandlerName PDP_LOGIN_CHECK_BIZ = null;
    public static final BizHandlerName PDP_OPEN_PAGE_BIZ = null;
    public static final BizHandlerName PDP_PRELOAD_HEAD_IMG = null;
    public static final BizHandlerName PDP_PRELOAD_PACK = null;
    public static final BizHandlerName PDP_SCHEMA_PARSE_BIZ = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizHandlerName[] f180634a = null;
    private final String value;

    static {
        BizHandlerName r100 = new BizHandlerName("PDP_ASYNC_INFLATE", 0, "pdp_async_inflate");
        PDP_ASYNC_INFLATE = r100;
        BizHandlerName r101 = new BizHandlerName("PDP_SCHEMA_PARSE_BIZ", 1, "pdp_schema_parse_biz");
        PDP_SCHEMA_PARSE_BIZ = r101;
        BizHandlerName r102 = new BizHandlerName("PDP_LOGIN_CHECK_BIZ", 2, "pdp_login_check_biz");
        PDP_LOGIN_CHECK_BIZ = r102;
        BizHandlerName r103 = new BizHandlerName("PDP_OPEN_PAGE_BIZ", 3, "pdp_open_page_biz");
        PDP_OPEN_PAGE_BIZ = r103;
        BizHandlerName r104 = new BizHandlerName("PDP_PRELOAD_HEAD_IMG", 4, "pdp_preload_head_img");
        PDP_PRELOAD_HEAD_IMG = r104;
        BizHandlerName r105 = new BizHandlerName("PDP_PRELOAD_PACK", 5, "pdp_preload_pack");
        PDP_PRELOAD_PACK = r105;
        f180634a = new BizHandlerName[]{r100, r101, r102, r103, r104, r105};
    }

    public static BizHandlerName valueOf(String r100) {
        return (BizHandlerName) r27.a.a(BizHandlerName.class, r100);
    }

    public static BizHandlerName[] values() {
        return (BizHandlerName[]) f180634a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public BizHandlerName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
