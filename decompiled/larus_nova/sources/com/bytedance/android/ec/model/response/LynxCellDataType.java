package com.bytedance.android.ec.model.response;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/model/response/LynxCellDataType;", "", "", "type", "I", "getType", "()I", "TYPE_INVALID", "TYPE_AI", "TYPE_NPS", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum LynxCellDataType extends Enum<LynxCellDataType> {
    public static final LynxCellDataType TYPE_AI = null;
    public static final LynxCellDataType TYPE_INVALID = null;
    public static final LynxCellDataType TYPE_NPS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxCellDataType[] f47912a = null;
    private final int type;

    static {
        LynxCellDataType r100 = new LynxCellDataType("TYPE_INVALID", 0, 0);
        TYPE_INVALID = r100;
        LynxCellDataType r101 = new LynxCellDataType("TYPE_AI", 1, 1);
        TYPE_AI = r101;
        LynxCellDataType r102 = new LynxCellDataType("TYPE_NPS", 2, 2);
        TYPE_NPS = r102;
        f47912a = new LynxCellDataType[]{r100, r101, r102};
    }

    public static LynxCellDataType valueOf(String r100) {
        return (LynxCellDataType) r27.a.a(LynxCellDataType.class, r100);
    }

    public static LynxCellDataType[] values() {
        return (LynxCellDataType[]) f47912a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LynxCellDataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
