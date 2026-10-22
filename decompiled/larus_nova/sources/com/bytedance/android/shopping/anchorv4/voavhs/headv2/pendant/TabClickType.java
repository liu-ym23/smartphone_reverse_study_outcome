package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/pendant/TabClickType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "TYPE_DRAW", "TYPE_CLICK", "TYPE_EXPAND", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabClickType extends Enum<TabClickType> {
    public static final TabClickType TYPE_CLICK = null;
    public static final TabClickType TYPE_DRAW = null;
    public static final TabClickType TYPE_EXPAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabClickType[] f169845a = null;
    private final String type;

    static {
        TabClickType r100 = new TabClickType("TYPE_DRAW", 0, "draw");
        TYPE_DRAW = r100;
        TabClickType r101 = new TabClickType("TYPE_CLICK", 1, "click");
        TYPE_CLICK = r101;
        TabClickType r102 = new TabClickType("TYPE_EXPAND", 2, BitableAnalytic.LinkSceneClickType.EXPAND);
        TYPE_EXPAND = r102;
        f169845a = new TabClickType[]{r100, r101, r102};
    }

    public static TabClickType valueOf(String r100) {
        return (TabClickType) r27.a.a(TabClickType.class, r100);
    }

    public static TabClickType[] values() {
        return (TabClickType[]) f169845a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public TabClickType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
