package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/subdatacontext/PkBaseResult;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "NOT_FINISH", "WIN", "LOSE", "EVEN", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PkBaseResult extends Enum<PkBaseResult> {
    public static final PkBaseResult EVEN = null;
    public static final PkBaseResult LOSE = null;
    public static final PkBaseResult NOT_FINISH = null;
    public static final PkBaseResult WIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkBaseResult[] f92933a = null;
    private final String type;

    static {
        PkBaseResult r100 = new PkBaseResult("NOT_FINISH", 0, "not_finish");
        NOT_FINISH = r100;
        PkBaseResult r101 = new PkBaseResult("WIN", 1, "win");
        WIN = r101;
        PkBaseResult r102 = new PkBaseResult("LOSE", 2, "lose");
        LOSE = r102;
        PkBaseResult r103 = new PkBaseResult("EVEN", 3, "even");
        EVEN = r103;
        f92933a = new PkBaseResult[]{r100, r101, r102, r103};
    }

    public static PkBaseResult valueOf(String r100) {
        return (PkBaseResult) r27.a.a(PkBaseResult.class, r100);
    }

    public static PkBaseResult[] values() {
        return (PkBaseResult[]) f92933a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public PkBaseResult(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
