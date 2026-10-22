package com.bytedance.android.live.soloktv.model;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/soloktv/model/EnterRtChorusRoomSource;", "", "Lkotlin/Pair;", "", "pair", "Lkotlin/Pair;", "getPair", "()Lkotlin/Pair;", "CHORUS_PAGE", "SOLO_KTV_PAGE", "ANCHOR_KSONG", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum EnterRtChorusRoomSource extends Enum<EnterRtChorusRoomSource> {
    public static final EnterRtChorusRoomSource ANCHOR_KSONG = null;
    public static final EnterRtChorusRoomSource CHORUS_PAGE = null;
    public static final EnterRtChorusRoomSource SOLO_KTV_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterRtChorusRoomSource[] f101375a = null;
    private final Pair<String, String> pair;

    static {
        EnterRtChorusRoomSource r100 = new EnterRtChorusRoomSource("CHORUS_PAGE", 0, new Pair("chorus_page", "chorus_room_list"));
        CHORUS_PAGE = r100;
        EnterRtChorusRoomSource r101 = new EnterRtChorusRoomSource("SOLO_KTV_PAGE", 1, new Pair("solo_ktv_page", "single_song"));
        SOLO_KTV_PAGE = r101;
        EnterRtChorusRoomSource r102 = new EnterRtChorusRoomSource("ANCHOR_KSONG", 2, new Pair("anchor_ksong", "ksong_request_song"));
        ANCHOR_KSONG = r102;
        f101375a = new EnterRtChorusRoomSource[]{r100, r101, r102};
    }

    public static EnterRtChorusRoomSource valueOf(String r100) {
        return (EnterRtChorusRoomSource) r27.a.a(EnterRtChorusRoomSource.class, r100);
    }

    public static EnterRtChorusRoomSource[] values() {
        return (EnterRtChorusRoomSource[]) f101375a.clone();
    }

    public final Pair<String, String> getPair() {
        return this.pair;
    }

    public EnterRtChorusRoomSource(String r100, int r101, Pair r102) {
        super(r100, r101);
        this.pair = r102;
    }
}
