package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/model/PlaylistTabType;", "", "", "value", "I", "getValue", "()I", "TAB_TYPE_SONG_LIST", "TAB_TYPE_DRESS_LIST", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlaylistTabType extends Enum<PlaylistTabType> {
    public static final PlaylistTabType TAB_TYPE_DRESS_LIST = null;
    public static final PlaylistTabType TAB_TYPE_SONG_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlaylistTabType[] f69492a = null;
    private final int value;

    static {
        PlaylistTabType r100 = new PlaylistTabType("TAB_TYPE_SONG_LIST", 0, 0);
        TAB_TYPE_SONG_LIST = r100;
        PlaylistTabType r101 = new PlaylistTabType("TAB_TYPE_DRESS_LIST", 1, 1);
        TAB_TYPE_DRESS_LIST = r101;
        f69492a = new PlaylistTabType[]{r100, r101};
    }

    public static PlaylistTabType valueOf(String r100) {
        return (PlaylistTabType) r27.a.a(PlaylistTabType.class, r100);
    }

    public static PlaylistTabType[] values() {
        return (PlaylistTabType[]) f69492a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public PlaylistTabType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
