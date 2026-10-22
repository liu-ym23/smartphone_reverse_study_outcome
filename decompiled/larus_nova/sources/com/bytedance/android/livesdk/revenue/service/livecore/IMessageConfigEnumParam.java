package com.bytedance.android.livesdk.revenue.service.livecore;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/livecore/IMessageConfigEnumParam;", "", "MessageConfigReliableOrdered", "live-kmp-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IMessageConfigEnumParam extends Enum<IMessageConfigEnumParam> {
    public static final IMessageConfigEnumParam MessageConfigReliableOrdered = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IMessageConfigEnumParam[] f157399a = null;

    static {
        IMessageConfigEnumParam r100 = new IMessageConfigEnumParam();
        MessageConfigReliableOrdered = r100;
        f157399a = new IMessageConfigEnumParam[]{r100};
    }

    public static IMessageConfigEnumParam valueOf(String r100) {
        return (IMessageConfigEnumParam) a.a(IMessageConfigEnumParam.class, r100);
    }

    public static IMessageConfigEnumParam[] values() {
        return (IMessageConfigEnumParam[]) f157399a.clone();
    }

    public IMessageConfigEnumParam() {
        super("MessageConfigReliableOrdered", 0);
    }
}
