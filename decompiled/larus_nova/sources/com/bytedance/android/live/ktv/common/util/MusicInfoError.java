package com.bytedance.android.live.ktv.common.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/ktv/common/util/MusicInfoError;", "", "", "errorCode", "I", "getErrorCode", "()I", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "SONG_FILE_MISSING", "LYRICS_FILE_MUSSING", "INVALID_DURATION", "INVALID_ID", "INVALID_TITLE", "INVALID_AUDIO_ID", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicInfoError extends Enum<MusicInfoError> {
    public static final MusicInfoError INVALID_AUDIO_ID = null;
    public static final MusicInfoError INVALID_DURATION = null;
    public static final MusicInfoError INVALID_ID = null;
    public static final MusicInfoError INVALID_TITLE = null;
    public static final MusicInfoError LYRICS_FILE_MUSSING = null;
    public static final MusicInfoError SONG_FILE_MISSING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicInfoError[] f70682a = null;
    private final int errorCode;
    private final String errorMsg;

    static {
        MusicInfoError r100 = new MusicInfoError("SONG_FILE_MISSING", 0, 1, "both full track and accompaniment track are empty");
        SONG_FILE_MISSING = r100;
        MusicInfoError r101 = new MusicInfoError("LYRICS_FILE_MUSSING", 1, 2, "lyrics url list is empty");
        LYRICS_FILE_MUSSING = r101;
        MusicInfoError r102 = new MusicInfoError("INVALID_DURATION", 2, 3, "duration is illegal");
        INVALID_DURATION = r102;
        MusicInfoError r103 = new MusicInfoError("INVALID_ID", 3, 4, "id is illegal");
        INVALID_ID = r103;
        MusicInfoError r104 = new MusicInfoError("INVALID_TITLE", 4, 5, "title is empty");
        INVALID_TITLE = r104;
        MusicInfoError r105 = new MusicInfoError("INVALID_AUDIO_ID", 5, 6, "audio id is illegal");
        INVALID_AUDIO_ID = r105;
        f70682a = new MusicInfoError[]{r100, r101, r102, r103, r104, r105};
    }

    public static MusicInfoError valueOf(String r100) {
        return (MusicInfoError) r27.a.a(MusicInfoError.class, r100);
    }

    public static MusicInfoError[] values() {
        return (MusicInfoError[]) f70682a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public MusicInfoError(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMsg = r103;
    }
}
