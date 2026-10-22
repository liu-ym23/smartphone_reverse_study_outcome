package com.bytedance.android.live.soloktv.karaokestation.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/soloktv/karaokestation/model/AddSongSourceType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "SCHEME", "RANK_LIST", "KARAOKE_STATION", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AddSongSourceType extends Enum<AddSongSourceType> {
    public static final AddSongSourceType KARAOKE_STATION = null;
    public static final AddSongSourceType RANK_LIST = null;
    public static final AddSongSourceType SCHEME = null;
    public static final AddSongSourceType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AddSongSourceType[] f101235a = null;
    private final int value;

    static {
        AddSongSourceType r100 = new AddSongSourceType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AddSongSourceType r101 = new AddSongSourceType("SCHEME", 1, 1);
        SCHEME = r101;
        AddSongSourceType r102 = new AddSongSourceType("RANK_LIST", 2, 2);
        RANK_LIST = r102;
        AddSongSourceType r103 = new AddSongSourceType("KARAOKE_STATION", 3, 3);
        KARAOKE_STATION = r103;
        f101235a = new AddSongSourceType[]{r100, r101, r102, r103};
    }

    public static AddSongSourceType valueOf(String r100) {
        return (AddSongSourceType) a.a(AddSongSourceType.class, r100);
    }

    public static AddSongSourceType[] values() {
        return (AddSongSourceType[]) f101235a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AddSongSourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
