package com.bytedance.android.livesdk.revenue.broadcast.xplay;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/broadcast/xplay/RevLittleWindowStyle;", "", "Large", "Small", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevLittleWindowStyle extends Enum<RevLittleWindowStyle> {
    public static final RevLittleWindowStyle Large = null;
    public static final RevLittleWindowStyle Small = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevLittleWindowStyle[] f157098a = null;

    static {
        RevLittleWindowStyle r100 = new RevLittleWindowStyle("Large", 0);
        Large = r100;
        RevLittleWindowStyle r101 = new RevLittleWindowStyle("Small", 1);
        Small = r101;
        f157098a = new RevLittleWindowStyle[]{r100, r101};
    }

    public static RevLittleWindowStyle valueOf(String r100) {
        return (RevLittleWindowStyle) a.a(RevLittleWindowStyle.class, r100);
    }

    public static RevLittleWindowStyle[] values() {
        return (RevLittleWindowStyle[]) f157098a.clone();
    }

    public RevLittleWindowStyle(String r100, int r101) {
        super(r100, r101);
    }
}
