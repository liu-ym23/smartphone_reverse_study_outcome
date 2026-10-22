package com.bytedance.android.ec.store.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ActionType;", "", "", "type", "I", "getType", "()I", "OPEN_SCHEMA", "TOAST", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType OPEN_SCHEMA = null;
    public static final ActionType TOAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f48394a = null;
    private final int type;

    static {
        ActionType r100 = new ActionType("OPEN_SCHEMA", 0, 1);
        OPEN_SCHEMA = r100;
        ActionType r101 = new ActionType("TOAST", 1, 2);
        TOAST = r101;
        f48394a = new ActionType[]{r100, r101};
    }

    public static ActionType valueOf(String r100) {
        return (ActionType) r27.a.a(ActionType.class, r100);
    }

    public static ActionType[] values() {
        return (ActionType[]) f48394a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public ActionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
