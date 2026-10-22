package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/CleanDataSource;", "", "", "source", "I", "getSource", "()I", "DEFAULT", AccountType.LOCAL, "NET", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CleanDataSource extends Enum<CleanDataSource> {
    public static final CleanDataSource DEFAULT = null;
    public static final CleanDataSource LOCAL = null;
    public static final CleanDataSource NET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CleanDataSource[] f129074a = null;
    private final int source;

    static {
        CleanDataSource r100 = new CleanDataSource("DEFAULT", 0, 0);
        DEFAULT = r100;
        CleanDataSource r101 = new CleanDataSource(AccountType.LOCAL, 1, 1);
        LOCAL = r101;
        CleanDataSource r102 = new CleanDataSource("NET", 2, 2);
        NET = r102;
        f129074a = new CleanDataSource[]{r100, r101, r102};
    }

    public static CleanDataSource valueOf(String r100) {
        return (CleanDataSource) r27.a.a(CleanDataSource.class, r100);
    }

    public static CleanDataSource[] values() {
        return (CleanDataSource[]) f129074a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public CleanDataSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.source = r102;
    }
}
