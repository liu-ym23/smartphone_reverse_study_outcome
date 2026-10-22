package com.bytedance.android.livesdkapi.roomplayer;

import java.util.Locale;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/EnterFromMerge;", "", "(Ljava/lang/String;I)V", "lowerName", "", "HOMEPAGE_HOT", "HOMEPAGE_HOT_TASK", "LIVE_CHANNEL", "CONTENT_PLAY_DETAIL", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterFromMerge extends Enum<EnterFromMerge> {
    private static final /* synthetic */ EnterFromMerge[] $VALUES = null;
    public static final EnterFromMerge CONTENT_PLAY_DETAIL = null;
    public static final EnterFromMerge HOMEPAGE_HOT = null;
    public static final EnterFromMerge HOMEPAGE_HOT_TASK = null;
    public static final EnterFromMerge LIVE_CHANNEL = null;

    static {
        EnterFromMerge r100 = new EnterFromMerge("HOMEPAGE_HOT", 0);
        HOMEPAGE_HOT = r100;
        EnterFromMerge r101 = new EnterFromMerge("HOMEPAGE_HOT_TASK", 1);
        HOMEPAGE_HOT_TASK = r101;
        EnterFromMerge r102 = new EnterFromMerge("LIVE_CHANNEL", 2);
        LIVE_CHANNEL = r102;
        EnterFromMerge r103 = new EnterFromMerge("CONTENT_PLAY_DETAIL", 3);
        CONTENT_PLAY_DETAIL = r103;
        $VALUES = new EnterFromMerge[]{r100, r101, r102, r103};
    }

    public static EnterFromMerge valueOf(String r100) {
        return (EnterFromMerge) a.a(EnterFromMerge.class, r100);
    }

    public static EnterFromMerge[] values() {
        return (EnterFromMerge[]) $VALUES.clone();
    }

    public final String lowerName() {
        String r100 = name();
        Locale r101 = Locale.ENGLISH;
        if (r100 == null) goto L7;
        return r100.toLowerCase(r101);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private EnterFromMerge(String r100, int r101) {
        super(r100, r101);
    }
}
