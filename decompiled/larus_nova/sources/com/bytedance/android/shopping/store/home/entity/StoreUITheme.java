package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.ee.bear.bitable.app.model.ThemeType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/StoreUITheme;", "", "DefaultDark", ThemeType.DEFAULT_THEME_SYSTEM_TYPE, "OLD", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StoreUITheme extends Enum<StoreUITheme> {
    public static final StoreUITheme DefaultDark = null;
    public static final StoreUITheme Light = null;
    public static final StoreUITheme OLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StoreUITheme[] f183670a = null;

    static {
        StoreUITheme r100 = new StoreUITheme("DefaultDark", 0);
        DefaultDark = r100;
        StoreUITheme r101 = new StoreUITheme(ThemeType.DEFAULT_THEME_SYSTEM_TYPE, 1);
        Light = r101;
        StoreUITheme r102 = new StoreUITheme("OLD", 2);
        OLD = r102;
        f183670a = new StoreUITheme[]{r100, r101, r102};
    }

    public static StoreUITheme valueOf(String r100) {
        return (StoreUITheme) r27.a.a(StoreUITheme.class, r100);
    }

    public static StoreUITheme[] values() {
        return (StoreUITheme[]) f183670a.clone();
    }

    public StoreUITheme(String r100, int r101) {
        super(r100, r101);
    }
}
