package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/WindowSubTagType;", "", "", "type", "I", "getType", "()I", CardAdapter.TEXT, "ICON", "DIVIDER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowSubTagType extends Enum<WindowSubTagType> {
    public static final WindowSubTagType DIVIDER = null;
    public static final WindowSubTagType ICON = null;
    public static final WindowSubTagType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowSubTagType[] f49460a = null;
    private final int type;

    static {
        WindowSubTagType r100 = new WindowSubTagType(CardAdapter.TEXT, 0, 1);
        TEXT = r100;
        WindowSubTagType r101 = new WindowSubTagType("ICON", 1, 2);
        ICON = r101;
        WindowSubTagType r102 = new WindowSubTagType("DIVIDER", 2, 3);
        DIVIDER = r102;
        f49460a = new WindowSubTagType[]{r100, r101, r102};
    }

    public static WindowSubTagType valueOf(String r100) {
        return (WindowSubTagType) r27.a.a(WindowSubTagType.class, r100);
    }

    public static WindowSubTagType[] values() {
        return (WindowSubTagType[]) f49460a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowSubTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
