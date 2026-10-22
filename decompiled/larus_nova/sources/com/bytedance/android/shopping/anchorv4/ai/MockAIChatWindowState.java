package com.bytedance.android.shopping.anchorv4.ai;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/ai/MockAIChatWindowState;", "", "COLLAPSED", "EXPANDED", "THINKING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
final enum MockAIChatWindowState extends Enum<MockAIChatWindowState> {
    public static final MockAIChatWindowState COLLAPSED = null;
    public static final MockAIChatWindowState EXPANDED = null;
    public static final MockAIChatWindowState THINKING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MockAIChatWindowState[] f165613a = null;

    static {
        MockAIChatWindowState r100 = new MockAIChatWindowState("COLLAPSED", 0);
        COLLAPSED = r100;
        MockAIChatWindowState r101 = new MockAIChatWindowState("EXPANDED", 1);
        EXPANDED = r101;
        MockAIChatWindowState r102 = new MockAIChatWindowState("THINKING", 2);
        THINKING = r102;
        f165613a = new MockAIChatWindowState[]{r100, r101, r102};
    }

    public static MockAIChatWindowState valueOf(String r100) {
        return (MockAIChatWindowState) r27.a.a(MockAIChatWindowState.class, r100);
    }

    public static MockAIChatWindowState[] values() {
        return (MockAIChatWindowState[]) f165613a.clone();
    }

    public MockAIChatWindowState(String r100, int r101) {
        super(r100, r101);
    }
}
