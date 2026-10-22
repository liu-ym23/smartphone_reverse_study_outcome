package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f106344a = null;

    static {
        f106344a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return (int) (((GameStickerInfo) r100).getStickerRecordId() - ((GameStickerInfo) r101).getStickerRecordId());
    }
}
