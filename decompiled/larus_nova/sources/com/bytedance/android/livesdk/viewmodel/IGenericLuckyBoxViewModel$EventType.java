package com.bytedance.android.livesdk.viewmodel;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/android/livesdk/viewmodel/IGenericLuckyBoxViewModel$EventType", "", "Lcom/bytedance/android/livesdk/viewmodel/IGenericLuckyBoxViewModel$EventType;", "Receive", "Available", "Expire", "Dismiss", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IGenericLuckyBoxViewModel$EventType extends Enum<IGenericLuckyBoxViewModel$EventType> {
    public static final IGenericLuckyBoxViewModel$EventType Available = null;
    public static final IGenericLuckyBoxViewModel$EventType Dismiss = null;
    public static final IGenericLuckyBoxViewModel$EventType Expire = null;
    public static final IGenericLuckyBoxViewModel$EventType Receive = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IGenericLuckyBoxViewModel$EventType[] f159313a = null;

    static {
        IGenericLuckyBoxViewModel$EventType r100 = new IGenericLuckyBoxViewModel$EventType("Receive", 0);
        Receive = r100;
        IGenericLuckyBoxViewModel$EventType r101 = new IGenericLuckyBoxViewModel$EventType("Available", 1);
        Available = r101;
        IGenericLuckyBoxViewModel$EventType r102 = new IGenericLuckyBoxViewModel$EventType("Expire", 2);
        Expire = r102;
        IGenericLuckyBoxViewModel$EventType r103 = new IGenericLuckyBoxViewModel$EventType("Dismiss", 3);
        Dismiss = r103;
        f159313a = new IGenericLuckyBoxViewModel$EventType[]{r100, r101, r102, r103};
    }

    public static IGenericLuckyBoxViewModel$EventType valueOf(String r100) {
        return (IGenericLuckyBoxViewModel$EventType) r27.a.a(IGenericLuckyBoxViewModel$EventType.class, r100);
    }

    public static IGenericLuckyBoxViewModel$EventType[] values() {
        return (IGenericLuckyBoxViewModel$EventType[]) f159313a.clone();
    }

    public IGenericLuckyBoxViewModel$EventType(String r100, int r101) {
        super(r100, r101);
    }
}
