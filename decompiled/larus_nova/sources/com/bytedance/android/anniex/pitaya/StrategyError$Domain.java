package com.bytedance.android.anniex.pitaya;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/android/anniex/pitaya/StrategyError$Domain", "", "Lcom/bytedance/android/anniex/pitaya/StrategyError$Domain;", "", "domain", "Ljava/lang/String;", "getDomain", "()Ljava/lang/String;", "BDP", HTTP.SERVER, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum StrategyError$Domain extends Enum<StrategyError$Domain> {
    public static final StrategyError$Domain BDP = null;
    public static final StrategyError$Domain SERVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrategyError$Domain[] f41032a = null;
    private final String domain;

    public static StrategyError$Domain valueOf(String r100) {
        return (StrategyError$Domain) a.a(StrategyError$Domain.class, r100);
    }

    public static StrategyError$Domain[] values() {
        return (StrategyError$Domain[]) f41032a.clone();
    }

    static {
        StrategyError$Domain r100 = new StrategyError$Domain("BDP", 0, "bdp");
        BDP = r100;
        StrategyError$Domain r101 = new StrategyError$Domain(HTTP.SERVER, 1, BenefitStore.FROM_SERVER);
        SERVER = r101;
        f41032a = new StrategyError$Domain[]{r100, r101};
    }

    public final String getDomain() {
        return this.domain;
    }

    public StrategyError$Domain(String r100, int r101, String r102) {
        super(r100, r101);
        this.domain = r102;
    }
}
