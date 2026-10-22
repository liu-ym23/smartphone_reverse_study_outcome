package com.bytedance.android.shopping.model.abscontainer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/model/abscontainer/PrePerformancePointType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PAGE_INIT", "SKU_CHECK_START", "SKU_CHECK_END", "CREATE_SCHEMA_START", "CREATE_SCHEMA_END", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PrePerformancePointType extends Enum<PrePerformancePointType> {
    public static final PrePerformancePointType CREATE_SCHEMA_END = null;
    public static final PrePerformancePointType CREATE_SCHEMA_START = null;
    public static final PrePerformancePointType PAGE_INIT = null;
    public static final PrePerformancePointType SKU_CHECK_END = null;
    public static final PrePerformancePointType SKU_CHECK_START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrePerformancePointType[] f178654a = null;
    private final String value;

    static {
        PrePerformancePointType r100 = new PrePerformancePointType("PAGE_INIT", 0, "C_PAGE_INIT");
        PAGE_INIT = r100;
        PrePerformancePointType r101 = new PrePerformancePointType("SKU_CHECK_START", 1, "C_SKU_CHECK_START");
        SKU_CHECK_START = r101;
        PrePerformancePointType r102 = new PrePerformancePointType("SKU_CHECK_END", 2, "C_SKU_CHECK_END");
        SKU_CHECK_END = r102;
        PrePerformancePointType r103 = new PrePerformancePointType("CREATE_SCHEMA_START", 3, "C_SCHEMA_CREATE_START");
        CREATE_SCHEMA_START = r103;
        PrePerformancePointType r104 = new PrePerformancePointType("CREATE_SCHEMA_END", 4, "C_SCHEMA_CREATE_END");
        CREATE_SCHEMA_END = r104;
        f178654a = new PrePerformancePointType[]{r100, r101, r102, r103, r104};
    }

    public static PrePerformancePointType valueOf(String r100) {
        return (PrePerformancePointType) a.a(PrePerformancePointType.class, r100);
    }

    public static PrePerformancePointType[] values() {
        return (PrePerformancePointType[]) f178654a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public PrePerformancePointType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
