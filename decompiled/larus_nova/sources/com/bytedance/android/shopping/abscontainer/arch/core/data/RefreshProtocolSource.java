package com.bytedance.android.shopping.abscontainer.arch.core.data;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/data/RefreshProtocolSource;", "", "ADJUST", "PATCH", ConfirmNextAction.ACTION_TYPE_QUERY, "UPDATE", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RefreshProtocolSource extends Enum<RefreshProtocolSource> {
    public static final RefreshProtocolSource ADJUST = null;
    public static final RefreshProtocolSource PATCH = null;
    public static final RefreshProtocolSource QUERY = null;
    public static final RefreshProtocolSource UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshProtocolSource[] f164132a = null;

    static {
        RefreshProtocolSource r100 = new RefreshProtocolSource("ADJUST", 0);
        ADJUST = r100;
        RefreshProtocolSource r101 = new RefreshProtocolSource("PATCH", 1);
        PATCH = r101;
        RefreshProtocolSource r102 = new RefreshProtocolSource(ConfirmNextAction.ACTION_TYPE_QUERY, 2);
        QUERY = r102;
        RefreshProtocolSource r103 = new RefreshProtocolSource("UPDATE", 3);
        UPDATE = r103;
        f164132a = new RefreshProtocolSource[]{r100, r101, r102, r103};
    }

    public static RefreshProtocolSource valueOf(String r100) {
        return (RefreshProtocolSource) a.a(RefreshProtocolSource.class, r100);
    }

    public static RefreshProtocolSource[] values() {
        return (RefreshProtocolSource[]) f164132a.clone();
    }

    public RefreshProtocolSource(String r100, int r101) {
        super(r100, r101);
    }
}
