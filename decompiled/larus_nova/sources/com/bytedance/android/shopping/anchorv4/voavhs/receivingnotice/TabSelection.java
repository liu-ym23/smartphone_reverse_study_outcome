package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/TabSelection;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "SELECTED", "UNSELECTED", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TabSelection extends Enum<TabSelection> {
    public static final TabSelection SELECTED = null;
    public static final TabSelection UNSELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TabSelection[] f170049a = null;
    private final String value;

    static {
        TabSelection r100 = new TabSelection("SELECTED", 0, "selected");
        SELECTED = r100;
        TabSelection r101 = new TabSelection("UNSELECTED", 1, "unselected");
        UNSELECTED = r101;
        f170049a = new TabSelection[]{r100, r101};
    }

    public static TabSelection valueOf(String r100) {
        return (TabSelection) r27.a.a(TabSelection.class, r100);
    }

    public static TabSelection[] values() {
        return (TabSelection[]) f170049a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public TabSelection(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
