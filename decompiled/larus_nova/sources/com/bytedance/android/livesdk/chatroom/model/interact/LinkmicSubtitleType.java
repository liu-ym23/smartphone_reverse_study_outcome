package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/LinkmicSubtitleType;", "", LogFilterName.ROOM, "Enlarged", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkmicSubtitleType extends Enum<LinkmicSubtitleType> {
    public static final LinkmicSubtitleType Enlarged = null;
    public static final LinkmicSubtitleType Room = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkmicSubtitleType[] f106932a = null;

    static {
        LinkmicSubtitleType r100 = new LinkmicSubtitleType(LogFilterName.ROOM, 0);
        Room = r100;
        LinkmicSubtitleType r101 = new LinkmicSubtitleType("Enlarged", 1);
        Enlarged = r101;
        f106932a = new LinkmicSubtitleType[]{r100, r101};
    }

    public static LinkmicSubtitleType valueOf(String r100) {
        return (LinkmicSubtitleType) r27.a.a(LinkmicSubtitleType.class, r100);
    }

    public static LinkmicSubtitleType[] values() {
        return (LinkmicSubtitleType[]) f106932a.clone();
    }

    public LinkmicSubtitleType(String r100, int r101) {
        super(r100, r101);
    }
}
