package com.bytedance.android.livesdk.revenue.toolbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/toolbar/RevToolbarConstants;", "", "Gift", "FastGift", "BackUpBorder", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevToolbarConstants extends Enum<RevToolbarConstants> {
    public static final RevToolbarConstants BackUpBorder = null;
    public static final RevToolbarConstants FastGift = null;
    public static final RevToolbarConstants Gift = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevToolbarConstants[] f157523a = null;

    static {
        RevToolbarConstants r100 = new RevToolbarConstants("Gift", 0);
        Gift = r100;
        RevToolbarConstants r101 = new RevToolbarConstants("FastGift", 1);
        FastGift = r101;
        RevToolbarConstants r102 = new RevToolbarConstants("BackUpBorder", 2);
        BackUpBorder = r102;
        f157523a = new RevToolbarConstants[]{r100, r101, r102};
    }

    public static RevToolbarConstants valueOf(String r100) {
        return (RevToolbarConstants) a.a(RevToolbarConstants.class, r100);
    }

    public static RevToolbarConstants[] values() {
        return (RevToolbarConstants[]) f157523a.clone();
    }

    public RevToolbarConstants(String r100, int r101) {
        super(r100, r101);
    }
}
