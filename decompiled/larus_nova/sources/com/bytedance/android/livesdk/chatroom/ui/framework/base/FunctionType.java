package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/base/FunctionType;", "", "BASE", "BUSINESS", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FunctionType extends Enum<FunctionType> {
    public static final FunctionType BASE = null;
    public static final FunctionType BUSINESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FunctionType[] f112848a = null;

    static {
        FunctionType r100 = new FunctionType("BASE", 0);
        BASE = r100;
        FunctionType r101 = new FunctionType("BUSINESS", 1);
        BUSINESS = r101;
        f112848a = new FunctionType[]{r100, r101};
    }

    public static FunctionType valueOf(String r100) {
        return (FunctionType) r27.a.a(FunctionType.class, r100);
    }

    public static FunctionType[] values() {
        return (FunctionType[]) f112848a.clone();
    }

    public FunctionType(String r100, int r101) {
        super(r100, r101);
    }
}
