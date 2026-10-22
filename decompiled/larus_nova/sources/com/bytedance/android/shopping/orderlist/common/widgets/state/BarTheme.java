package com.bytedance.android.shopping.orderlist.common.widgets.state;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/state/BarTheme;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "DARK", "LIGHT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BarTheme extends Enum<BarTheme> {
    public static final BarTheme DARK = null;
    public static final BarTheme LIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarTheme[] f180050a = null;
    private final String value;

    static {
        BarTheme r100 = new BarTheme("DARK", 0, "dark");
        DARK = r100;
        BarTheme r101 = new BarTheme("LIGHT", 1, "light");
        LIGHT = r101;
        f180050a = new BarTheme[]{r100, r101};
    }

    public static BarTheme valueOf(String r100) {
        return (BarTheme) r27.a.a(BarTheme.class, r100);
    }

    public static BarTheme[] values() {
        return (BarTheme[]) f180050a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public BarTheme(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
