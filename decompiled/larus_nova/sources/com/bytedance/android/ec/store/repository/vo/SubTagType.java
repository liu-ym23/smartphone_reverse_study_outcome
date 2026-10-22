package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/SubTagType;", "", "", "type", "I", "getType", "()I", CardAdapter.TEXT, "ICON", "DIVIDER", "COUNTDOWN", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SubTagType extends Enum<SubTagType> {
    public static final SubTagType COUNTDOWN = null;
    public static final SubTagType DIVIDER = null;
    public static final SubTagType ICON = null;
    public static final SubTagType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubTagType[] f48448a = null;
    private final int type;

    static {
        SubTagType r100 = new SubTagType(CardAdapter.TEXT, 0, 1);
        TEXT = r100;
        SubTagType r101 = new SubTagType("ICON", 1, 2);
        ICON = r101;
        SubTagType r102 = new SubTagType("DIVIDER", 2, 3);
        DIVIDER = r102;
        SubTagType r103 = new SubTagType("COUNTDOWN", 3, 4);
        COUNTDOWN = r103;
        f48448a = new SubTagType[]{r100, r101, r102, r103};
    }

    public static SubTagType valueOf(String r100) {
        return (SubTagType) r27.a.a(SubTagType.class, r100);
    }

    public static SubTagType[] values() {
        return (SubTagType[]) f48448a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public SubTagType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
