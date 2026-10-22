package com.bytedance.android.live.link.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/link/data/RevPkResult;", "", "UNFINISHED", "LEFT_WON", "RIGHT_WON", "EVEN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPkResult extends Enum<RevPkResult> {
    public static final RevPkResult EVEN = null;
    public static final RevPkResult LEFT_WON = null;
    public static final RevPkResult RIGHT_WON = null;
    public static final RevPkResult UNFINISHED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPkResult[] f70865a = null;

    static {
        RevPkResult r100 = new RevPkResult("UNFINISHED", 0);
        UNFINISHED = r100;
        RevPkResult r101 = new RevPkResult("LEFT_WON", 1);
        LEFT_WON = r101;
        RevPkResult r102 = new RevPkResult("RIGHT_WON", 2);
        RIGHT_WON = r102;
        RevPkResult r103 = new RevPkResult("EVEN", 3);
        EVEN = r103;
        f70865a = new RevPkResult[]{r100, r101, r102, r103};
    }

    public static RevPkResult valueOf(String r100) {
        return (RevPkResult) a.a(RevPkResult.class, r100);
    }

    public static RevPkResult[] values() {
        return (RevPkResult[]) f70865a.clone();
    }

    public RevPkResult(String r100, int r101) {
        super(r100, r101);
    }
}
