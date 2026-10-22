package com.bytedance.android.livesdk.link.model.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/livesdk/link/model/api/IBaseLogPb$LogIdType", "", "Lcom/bytedance/android/livesdk/link/model/api/IBaseLogPb$LogIdType;", "TYPE_UNDEFINED", "TYPE_FOLLOWED", "TYPE_RECOMMEND", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IBaseLogPb$LogIdType extends Enum<IBaseLogPb$LogIdType> {
    public static final IBaseLogPb$LogIdType TYPE_FOLLOWED = null;
    public static final IBaseLogPb$LogIdType TYPE_RECOMMEND = null;
    public static final IBaseLogPb$LogIdType TYPE_UNDEFINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IBaseLogPb$LogIdType[] f147082a = null;

    static {
        IBaseLogPb$LogIdType r100 = new IBaseLogPb$LogIdType("TYPE_UNDEFINED", 0);
        TYPE_UNDEFINED = r100;
        IBaseLogPb$LogIdType r101 = new IBaseLogPb$LogIdType("TYPE_FOLLOWED", 1);
        TYPE_FOLLOWED = r101;
        IBaseLogPb$LogIdType r102 = new IBaseLogPb$LogIdType("TYPE_RECOMMEND", 2);
        TYPE_RECOMMEND = r102;
        f147082a = new IBaseLogPb$LogIdType[]{r100, r101, r102};
    }

    public static IBaseLogPb$LogIdType valueOf(String r100) {
        return (IBaseLogPb$LogIdType) a.a(IBaseLogPb$LogIdType.class, r100);
    }

    public static IBaseLogPb$LogIdType[] values() {
        return (IBaseLogPb$LogIdType[]) f147082a.clone();
    }

    public IBaseLogPb$LogIdType(String r100, int r101) {
        super(r100, r101);
    }
}
