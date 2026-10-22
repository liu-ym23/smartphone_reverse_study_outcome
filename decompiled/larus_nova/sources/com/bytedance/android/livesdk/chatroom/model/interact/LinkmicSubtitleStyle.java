package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkmicSubtitleStyle;", "", "UNKNOWN", "LONG", "SHORT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicSubtitleStyle extends Enum<LinkmicSubtitleStyle> {
    public static final LinkmicSubtitleStyle LONG = null;
    public static final LinkmicSubtitleStyle SHORT = null;
    public static final LinkmicSubtitleStyle UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicSubtitleStyle[] f106931a = null;

    static {
        LinkmicSubtitleStyle r100 = new LinkmicSubtitleStyle("UNKNOWN", 0);
        UNKNOWN = r100;
        LinkmicSubtitleStyle r101 = new LinkmicSubtitleStyle("LONG", 1);
        LONG = r101;
        LinkmicSubtitleStyle r102 = new LinkmicSubtitleStyle("SHORT", 2);
        SHORT = r102;
        f106931a = new LinkmicSubtitleStyle[]{r100, r101, r102};
    }

    public static LinkmicSubtitleStyle valueOf(String r100) {
        return (LinkmicSubtitleStyle) r27.a.a(LinkmicSubtitleStyle.class, r100);
    }

    public static LinkmicSubtitleStyle[] values() {
        return (LinkmicSubtitleStyle[]) f106931a.clone();
    }

    public LinkmicSubtitleStyle(String r100, int r101) {
        super(r100, r101);
    }
}
