package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/UpdateSongSettingType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "AUDIENCE_ADD_SONG", "AUDIENCE_MULTI_CHORUS", "HIDE_LYRICS_SUBTITLE_OPEN", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateSongSettingType extends Enum<UpdateSongSettingType> {
    public static final UpdateSongSettingType AUDIENCE_ADD_SONG = null;
    public static final UpdateSongSettingType AUDIENCE_MULTI_CHORUS = null;
    public static final UpdateSongSettingType HIDE_LYRICS_SUBTITLE_OPEN = null;
    public static final UpdateSongSettingType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateSongSettingType[] f144278a = null;
    private final int value;

    static {
        UpdateSongSettingType r100 = new UpdateSongSettingType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        UpdateSongSettingType r101 = new UpdateSongSettingType("AUDIENCE_ADD_SONG", 1, 1);
        AUDIENCE_ADD_SONG = r101;
        UpdateSongSettingType r102 = new UpdateSongSettingType("AUDIENCE_MULTI_CHORUS", 2, 2);
        AUDIENCE_MULTI_CHORUS = r102;
        UpdateSongSettingType r103 = new UpdateSongSettingType("HIDE_LYRICS_SUBTITLE_OPEN", 3, 3);
        HIDE_LYRICS_SUBTITLE_OPEN = r103;
        f144278a = new UpdateSongSettingType[]{r100, r101, r102, r103};
    }

    public static UpdateSongSettingType valueOf(String r100) {
        return (UpdateSongSettingType) r27.a.a(UpdateSongSettingType.class, r100);
    }

    public static UpdateSongSettingType[] values() {
        return (UpdateSongSettingType[]) f144278a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public UpdateSongSettingType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
