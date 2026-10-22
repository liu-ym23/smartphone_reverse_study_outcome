package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/SongType;", "", "", "value", "I", "getValue", "()I", "SONG_TYPE_NORMAL", "SONG_TYPE_CHORUS", "SONG_TYPE_PRIOR", "SONG_TYPE_FRAGMENT", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SongType extends Enum<SongType> {
    public static final SongType SONG_TYPE_CHORUS = null;
    public static final SongType SONG_TYPE_FRAGMENT = null;
    public static final SongType SONG_TYPE_NORMAL = null;
    public static final SongType SONG_TYPE_PRIOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SongType[] f153615a = null;
    private final int value;

    static {
        SongType r100 = new SongType("SONG_TYPE_NORMAL", 0, 0);
        SONG_TYPE_NORMAL = r100;
        SongType r101 = new SongType("SONG_TYPE_CHORUS", 1, 1);
        SONG_TYPE_CHORUS = r101;
        SongType r102 = new SongType("SONG_TYPE_PRIOR", 2, 3);
        SONG_TYPE_PRIOR = r102;
        SongType r103 = new SongType("SONG_TYPE_FRAGMENT", 3, 4);
        SONG_TYPE_FRAGMENT = r103;
        f153615a = new SongType[]{r100, r101, r102, r103};
    }

    public static SongType valueOf(String r100) {
        return (SongType) r27.a.a(SongType.class, r100);
    }

    public static SongType[] values() {
        return (SongType[]) f153615a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SongType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
