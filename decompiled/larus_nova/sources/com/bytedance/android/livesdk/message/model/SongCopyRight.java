package com.bytedance.android.livesdk.message.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/SongCopyRight;", "", "", "value", "I", "getValue", "()I", "UNKNOWN_COPYRIGHT", "SHORTVIDEO_KARAOKE", "WEBCAST_KARAOKE", "PERSONAL_KARAOKE_STRICT", "PERSONAL_KARAOKE_LOOSE", "PERSONAL_KARAOKE_HIGHRISK", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SongCopyRight extends Enum<SongCopyRight> {
    public static final SongCopyRight PERSONAL_KARAOKE_HIGHRISK = null;
    public static final SongCopyRight PERSONAL_KARAOKE_LOOSE = null;
    public static final SongCopyRight PERSONAL_KARAOKE_STRICT = null;
    public static final SongCopyRight SHORTVIDEO_KARAOKE = null;
    public static final SongCopyRight UNKNOWN_COPYRIGHT = null;
    public static final SongCopyRight WEBCAST_KARAOKE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SongCopyRight[] f153614a = null;
    private final int value;

    static {
        SongCopyRight r100 = new SongCopyRight("UNKNOWN_COPYRIGHT", 0, 0);
        UNKNOWN_COPYRIGHT = r100;
        SongCopyRight r101 = new SongCopyRight("SHORTVIDEO_KARAOKE", 1, 1);
        SHORTVIDEO_KARAOKE = r101;
        SongCopyRight r102 = new SongCopyRight("WEBCAST_KARAOKE", 2, 2);
        WEBCAST_KARAOKE = r102;
        SongCopyRight r103 = new SongCopyRight("PERSONAL_KARAOKE_STRICT", 3, 3);
        PERSONAL_KARAOKE_STRICT = r103;
        SongCopyRight r104 = new SongCopyRight("PERSONAL_KARAOKE_LOOSE", 4, 4);
        PERSONAL_KARAOKE_LOOSE = r104;
        SongCopyRight r105 = new SongCopyRight("PERSONAL_KARAOKE_HIGHRISK", 5, 5);
        PERSONAL_KARAOKE_HIGHRISK = r105;
        f153614a = new SongCopyRight[]{r100, r101, r102, r103, r104, r105};
    }

    public static SongCopyRight valueOf(String r100) {
        return (SongCopyRight) r27.a.a(SongCopyRight.class, r100);
    }

    public static SongCopyRight[] values() {
        return (SongCopyRight[]) f153614a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SongCopyRight(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
