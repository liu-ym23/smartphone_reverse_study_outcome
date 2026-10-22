package com.bytedance.android.live.gift.tray;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/gift/tray/RelativeEnterAnimPos;", "", "UP", "DOWN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RelativeEnterAnimPos extends Enum<RelativeEnterAnimPos> {
    public static final RelativeEnterAnimPos DOWN = null;
    public static final RelativeEnterAnimPos UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RelativeEnterAnimPos[] f69007a = null;

    static {
        RelativeEnterAnimPos r100 = new RelativeEnterAnimPos("UP", 0);
        UP = r100;
        RelativeEnterAnimPos r101 = new RelativeEnterAnimPos("DOWN", 1);
        DOWN = r101;
        f69007a = new RelativeEnterAnimPos[]{r100, r101};
    }

    public static RelativeEnterAnimPos valueOf(String r100) {
        return (RelativeEnterAnimPos) a.a(RelativeEnterAnimPos.class, r100);
    }

    public static RelativeEnterAnimPos[] values() {
        return (RelativeEnterAnimPos[]) f69007a.clone();
    }

    public RelativeEnterAnimPos(String r100, int r101) {
        super(r100, r101);
    }
}
