package com.bytedance.android.livesdk.revenue.vs;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Style", "", "Lcom/bytedance/android/livesdk/revenue/vs/RevPlayViewControl$Style;", "HIDE", "ATTACH", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPlayViewControl$Style extends Enum<RevPlayViewControl$Style> {
    public static final RevPlayViewControl$Style ATTACH = null;
    public static final RevPlayViewControl$Style HIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPlayViewControl$Style[] f157547a = null;

    static {
        RevPlayViewControl$Style r100 = new RevPlayViewControl$Style("HIDE", 0);
        HIDE = r100;
        RevPlayViewControl$Style r101 = new RevPlayViewControl$Style("ATTACH", 1);
        ATTACH = r101;
        f157547a = new RevPlayViewControl$Style[]{r100, r101};
    }

    public static RevPlayViewControl$Style valueOf(String r100) {
        return (RevPlayViewControl$Style) a.a(RevPlayViewControl$Style.class, r100);
    }

    public static RevPlayViewControl$Style[] values() {
        return (RevPlayViewControl$Style[]) f157547a.clone();
    }

    public RevPlayViewControl$Style(String r100, int r101) {
        super(r100, r101);
    }
}
