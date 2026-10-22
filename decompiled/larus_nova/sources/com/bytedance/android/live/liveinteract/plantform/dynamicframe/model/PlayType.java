package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/PlayType;", "", "UNKNOWN", "PLAY_TYPE_NONE", "PLAY_TYPE_SEAT", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayType extends Enum<PlayType> {
    public static final PlayType PLAY_TYPE_NONE = null;
    public static final PlayType PLAY_TYPE_SEAT = null;
    public static final PlayType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayType[] f77078a = null;

    static {
        PlayType r100 = new PlayType("UNKNOWN", 0);
        UNKNOWN = r100;
        PlayType r101 = new PlayType("PLAY_TYPE_NONE", 1);
        PLAY_TYPE_NONE = r101;
        PlayType r102 = new PlayType("PLAY_TYPE_SEAT", 2);
        PLAY_TYPE_SEAT = r102;
        f77078a = new PlayType[]{r100, r101, r102};
    }

    public static PlayType valueOf(String r100) {
        return (PlayType) a.a(PlayType.class, r100);
    }

    public static PlayType[] values() {
        return (PlayType[]) f77078a.clone();
    }

    public PlayType(String r100, int r101) {
        super(r100, r101);
    }
}
