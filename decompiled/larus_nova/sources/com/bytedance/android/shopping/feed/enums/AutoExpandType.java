package com.bytedance.android.shopping.feed.enums;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/feed/enums/AutoExpandType;", "", "", "type", "I", "getType", "()I", "DEFAULT", "NEW_USER_AUTO_EXPAND", "OTHER_USER_AUTO_EXPAND", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AutoExpandType extends Enum<AutoExpandType> {
    public static final AutoExpandType DEFAULT = null;
    public static final AutoExpandType NEW_USER_AUTO_EXPAND = null;
    public static final AutoExpandType OTHER_USER_AUTO_EXPAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoExpandType[] f174439a = null;
    private final int type;

    static {
        AutoExpandType r100 = new AutoExpandType("DEFAULT", 0, 0);
        DEFAULT = r100;
        AutoExpandType r101 = new AutoExpandType("NEW_USER_AUTO_EXPAND", 1, 1);
        NEW_USER_AUTO_EXPAND = r101;
        AutoExpandType r102 = new AutoExpandType("OTHER_USER_AUTO_EXPAND", 2, 2);
        OTHER_USER_AUTO_EXPAND = r102;
        f174439a = new AutoExpandType[]{r100, r101, r102};
    }

    public static AutoExpandType valueOf(String r100) {
        return (AutoExpandType) a.a(AutoExpandType.class, r100);
    }

    public static AutoExpandType[] values() {
        return (AutoExpandType[]) f174439a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public AutoExpandType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
