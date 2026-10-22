package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveBroadcastMusicEffectInfo;", "", "effectId", "", "songId", "musicRequestInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEffectId", "()Ljava/lang/String;", "getMusicRequestInfo", "getSongId", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBroadcastMusicEffectInfo {
    private final String effectId;
    private final String musicRequestInfo;
    private final String songId;

    public LiveBroadcastMusicEffectInfo() {
        this(null, null, null, 7, null);
    }

    public final String getEffectId() {
        return this.effectId;
    }

    public final String getMusicRequestInfo() {
        return this.musicRequestInfo;
    }

    public final String getSongId() {
        return this.songId;
    }

    public LiveBroadcastMusicEffectInfo(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "effectId");
        Intrinsics.checkNotNullParameter(r101, "songId");
        Intrinsics.checkNotNullParameter(r102, "musicRequestInfo");
        this.effectId = r100;
        this.songId = r101;
        this.musicRequestInfo = r102;
    }

    public /* synthetic */ LiveBroadcastMusicEffectInfo(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
