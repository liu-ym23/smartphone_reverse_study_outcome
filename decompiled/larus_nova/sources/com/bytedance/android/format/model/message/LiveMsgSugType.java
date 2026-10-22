package com.bytedance.android.format.model.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgSugType;", "", "", "type", "I", "getType", "()I", "SugType_Invalid", "SugType_Branch", "SugType_NoBranch", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveMsgSugType extends Enum<LiveMsgSugType> {
    public static final LiveMsgSugType SugType_Branch = null;
    public static final LiveMsgSugType SugType_Invalid = null;
    public static final LiveMsgSugType SugType_NoBranch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveMsgSugType[] f51355a = null;
    private final int type;

    static {
        LiveMsgSugType r100 = new LiveMsgSugType("SugType_Invalid", 0, 0);
        SugType_Invalid = r100;
        LiveMsgSugType r101 = new LiveMsgSugType("SugType_Branch", 1, 1);
        SugType_Branch = r101;
        LiveMsgSugType r102 = new LiveMsgSugType("SugType_NoBranch", 2, 2);
        SugType_NoBranch = r102;
        f51355a = new LiveMsgSugType[]{r100, r101, r102};
    }

    public static LiveMsgSugType valueOf(String r100) {
        return (LiveMsgSugType) a.a(LiveMsgSugType.class, r100);
    }

    public static LiveMsgSugType[] values() {
        return (LiveMsgSugType[]) f51355a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LiveMsgSugType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
