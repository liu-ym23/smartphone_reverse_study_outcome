package com.bytedance.android.live.ktv.common.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/ktv/common/util/RemoveSongSource;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "DownloadSongFail", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RemoveSongSource extends Enum<RemoveSongSource> {
    public static final RemoveSongSource DownloadSongFail = null;
    public static final RemoveSongSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RemoveSongSource[] f70683a = null;
    private final int value;

    static {
        RemoveSongSource r100 = new RemoveSongSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        RemoveSongSource r101 = new RemoveSongSource("DownloadSongFail", 1, 1);
        DownloadSongFail = r101;
        f70683a = new RemoveSongSource[]{r100, r101};
    }

    public static RemoveSongSource valueOf(String r100) {
        return (RemoveSongSource) r27.a.a(RemoveSongSource.class, r100);
    }

    public static RemoveSongSource[] values() {
        return (RemoveSongSource[]) f70683a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public RemoveSongSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
