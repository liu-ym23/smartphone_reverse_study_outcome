package com.bytedance.android.livesdk.revenue.room;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/room/RevPadOrientation;", "", "PORTRAIT", "LANDSCAPE", "revenue-host-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RevPadOrientation extends Enum<RevPadOrientation> {
    public static final RevPadOrientation LANDSCAPE = null;
    public static final RevPadOrientation PORTRAIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RevPadOrientation[] f157277a = null;

    static {
        RevPadOrientation r100 = new RevPadOrientation("PORTRAIT", 0);
        PORTRAIT = r100;
        RevPadOrientation r101 = new RevPadOrientation("LANDSCAPE", 1);
        LANDSCAPE = r101;
        f157277a = new RevPadOrientation[]{r100, r101};
    }

    public static RevPadOrientation valueOf(String r100) {
        return (RevPadOrientation) r27.a.a(RevPadOrientation.class, r100);
    }

    public static RevPadOrientation[] values() {
        return (RevPadOrientation[]) f157277a.clone();
    }

    public RevPadOrientation(String r100, int r101) {
        super(r100, r101);
    }
}
