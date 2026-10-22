package com.bytedance.android.live.revlink.impl.behavior;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/IvPkId;", "", AccountType.MAIN, "BAK", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IvPkId extends Enum<IvPkId> {
    public static final IvPkId BAK = null;
    public static final IvPkId MAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IvPkId[] f92085a = null;

    static {
        IvPkId r100 = new IvPkId(AccountType.MAIN, 0);
        MAIN = r100;
        IvPkId r101 = new IvPkId("BAK", 1);
        BAK = r101;
        f92085a = new IvPkId[]{r100, r101};
    }

    public static IvPkId valueOf(String r100) {
        return (IvPkId) r27.a.a(IvPkId.class, r100);
    }

    public static IvPkId[] values() {
        return (IvPkId[]) f92085a.clone();
    }

    public IvPkId(String r100, int r101) {
        super(r100, r101);
    }
}
