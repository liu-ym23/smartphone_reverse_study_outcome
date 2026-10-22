package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/ORIENTATION;", "", "(Ljava/lang/String;I)V", "PORTRAIT", "LANDSCAPE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ORIENTATION extends Enum<ORIENTATION> {
    private static final /* synthetic */ ORIENTATION[] $VALUES = null;
    public static final ORIENTATION LANDSCAPE = null;
    public static final ORIENTATION PORTRAIT = null;

    static {
        ORIENTATION r100 = new ORIENTATION("PORTRAIT", 0);
        PORTRAIT = r100;
        ORIENTATION r101 = new ORIENTATION("LANDSCAPE", 1);
        LANDSCAPE = r101;
        $VALUES = new ORIENTATION[]{r100, r101};
    }

    public static ORIENTATION valueOf(String r100) {
        return (ORIENTATION) a.a(ORIENTATION.class, r100);
    }

    public static ORIENTATION[] values() {
        return (ORIENTATION[]) $VALUES.clone();
    }

    private ORIENTATION(String r100, int r101) {
        super(r100, r101);
    }
}
