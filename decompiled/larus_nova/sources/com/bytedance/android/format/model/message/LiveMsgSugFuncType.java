package com.bytedance.android.format.model.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgSugFuncType;", "", "", "type", "I", "getType", "()I", "SugFuncType_Simple", "SugFunType_Bullet", "SugFuncType_Schema", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveMsgSugFuncType extends Enum<LiveMsgSugFuncType> {
    public static final LiveMsgSugFuncType SugFunType_Bullet = null;
    public static final LiveMsgSugFuncType SugFuncType_Schema = null;
    public static final LiveMsgSugFuncType SugFuncType_Simple = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveMsgSugFuncType[] f51354a = null;
    private final int type;

    static {
        LiveMsgSugFuncType r100 = new LiveMsgSugFuncType("SugFuncType_Simple", 0, 0);
        SugFuncType_Simple = r100;
        LiveMsgSugFuncType r101 = new LiveMsgSugFuncType("SugFunType_Bullet", 1, 1);
        SugFunType_Bullet = r101;
        LiveMsgSugFuncType r102 = new LiveMsgSugFuncType("SugFuncType_Schema", 2, 2);
        SugFuncType_Schema = r102;
        f51354a = new LiveMsgSugFuncType[]{r100, r101, r102};
    }

    public static LiveMsgSugFuncType valueOf(String r100) {
        return (LiveMsgSugFuncType) a.a(LiveMsgSugFuncType.class, r100);
    }

    public static LiveMsgSugFuncType[] values() {
        return (LiveMsgSugFuncType[]) f51354a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LiveMsgSugFuncType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
