package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/OverLengthStrategy;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "I", "getStrategy", "()I", "DEFAULT", "SCALE", "HIDE", "SCALE_LOWEST_PRIORITY", "TRUNCATE", "ALLHIDE", "ALL_SHOW", "FIXED_WIDTH_ALL_SHOW", "HIDE_SORT_BY_PRIORITY", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OverLengthStrategy extends Enum<OverLengthStrategy> {
    public static final OverLengthStrategy ALLHIDE = null;
    public static final OverLengthStrategy ALL_SHOW = null;
    public static final OverLengthStrategy DEFAULT = null;
    public static final OverLengthStrategy FIXED_WIDTH_ALL_SHOW = null;
    public static final OverLengthStrategy HIDE = null;
    public static final OverLengthStrategy HIDE_SORT_BY_PRIORITY = null;
    public static final OverLengthStrategy SCALE = null;
    public static final OverLengthStrategy SCALE_LOWEST_PRIORITY = null;
    public static final OverLengthStrategy TRUNCATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OverLengthStrategy[] f48399a = null;
    private final int strategy;

    public static OverLengthStrategy valueOf(String r100) {
        return (OverLengthStrategy) r27.a.a(OverLengthStrategy.class, r100);
    }

    public static OverLengthStrategy[] values() {
        return (OverLengthStrategy[]) f48399a.clone();
    }

    static {
        OverLengthStrategy r100 = new OverLengthStrategy("DEFAULT", 0, 0);
        DEFAULT = r100;
        OverLengthStrategy r101 = new OverLengthStrategy("SCALE", 1, 1);
        SCALE = r101;
        OverLengthStrategy r102 = new OverLengthStrategy("HIDE", 2, 2);
        HIDE = r102;
        OverLengthStrategy r103 = new OverLengthStrategy("SCALE_LOWEST_PRIORITY", 3, 3);
        SCALE_LOWEST_PRIORITY = r103;
        OverLengthStrategy r104 = new OverLengthStrategy("TRUNCATE", 4, 4);
        TRUNCATE = r104;
        OverLengthStrategy r105 = new OverLengthStrategy("ALLHIDE", 5, 5);
        ALLHIDE = r105;
        OverLengthStrategy r106 = new OverLengthStrategy("ALL_SHOW", 6, 6);
        ALL_SHOW = r106;
        OverLengthStrategy r107 = new OverLengthStrategy("FIXED_WIDTH_ALL_SHOW", 7, 7);
        FIXED_WIDTH_ALL_SHOW = r107;
        OverLengthStrategy r108 = new OverLengthStrategy("HIDE_SORT_BY_PRIORITY", 8, 8);
        HIDE_SORT_BY_PRIORITY = r108;
        f48399a = new OverLengthStrategy[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public OverLengthStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.strategy = r102;
    }
}
