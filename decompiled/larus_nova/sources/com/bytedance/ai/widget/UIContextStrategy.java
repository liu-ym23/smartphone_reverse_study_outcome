package com.bytedance.ai.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/widget/UIContextStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ALWAYS", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UIContextStrategy extends Enum<UIContextStrategy> {
    public static final UIContextStrategy ALWAYS = null;
    public static final UIContextStrategy DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UIContextStrategy[] f37915a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37916b = null;

    public static EnumEntries<UIContextStrategy> getEntries() {
        return f37916b;
    }

    static {
        UIContextStrategy r100 = new UIContextStrategy("DEFAULT", 0);
        DEFAULT = r100;
        UIContextStrategy r101 = new UIContextStrategy("ALWAYS", 1);
        ALWAYS = r101;
        UIContextStrategy[] r102 = {r100, r101};
        f37915a = r102;
        f37916b = EnumEntriesKt.enumEntries(r102);
    }

    public static UIContextStrategy[] values() {
        return (UIContextStrategy[]) f37915a.clone();
    }

    public static UIContextStrategy valueOf(String r100) {
        return (UIContextStrategy) r27.a.a(UIContextStrategy.class, r100);
    }

    public UIContextStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
