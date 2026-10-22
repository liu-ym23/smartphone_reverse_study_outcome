package com.bytedance.android.livesdkapi.roomplayer;

import java.util.Locale;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EnterMethod;", "", "(Ljava/lang/String;I)V", "lowerName", "", "LIVE_CELL", "LIVE_DOUBLE_WINDOW", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterMethod extends Enum<EnterMethod> {
    private static final /* synthetic */ EnterMethod[] $VALUES = null;
    public static final EnterMethod LIVE_CELL = null;
    public static final EnterMethod LIVE_DOUBLE_WINDOW = null;

    static {
        EnterMethod r100 = new EnterMethod("LIVE_CELL", 0);
        LIVE_CELL = r100;
        EnterMethod r101 = new EnterMethod("LIVE_DOUBLE_WINDOW", 1);
        LIVE_DOUBLE_WINDOW = r101;
        $VALUES = new EnterMethod[]{r100, r101};
    }

    public static EnterMethod valueOf(String r100) {
        return (EnterMethod) a.a(EnterMethod.class, r100);
    }

    public static EnterMethod[] values() {
        return (EnterMethod[]) $VALUES.clone();
    }

    public final String lowerName() {
        String r100 = name();
        Locale r101 = Locale.ENGLISH;
        if (r100 == null) goto L7;
        return r100.toLowerCase(r101);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private EnterMethod(String r100, int r101) {
        super(r100, r101);
    }
}
