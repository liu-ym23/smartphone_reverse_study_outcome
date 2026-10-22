package com.bytedance.android.livesdk.chatroom.model.interact;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/UpdateSubtitleType;", "", "UNKNOWN", "STYLE", "COORDINATE", "TYPE", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UpdateSubtitleType extends Enum<UpdateSubtitleType> {
    public static final UpdateSubtitleType COORDINATE = null;
    public static final UpdateSubtitleType STYLE = null;
    public static final UpdateSubtitleType TYPE = null;
    public static final UpdateSubtitleType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateSubtitleType[] f106947a = null;

    static {
        UpdateSubtitleType r100 = new UpdateSubtitleType("UNKNOWN", 0);
        UNKNOWN = r100;
        UpdateSubtitleType r101 = new UpdateSubtitleType("STYLE", 1);
        STYLE = r101;
        UpdateSubtitleType r102 = new UpdateSubtitleType("COORDINATE", 2);
        COORDINATE = r102;
        UpdateSubtitleType r103 = new UpdateSubtitleType("TYPE", 3);
        TYPE = r103;
        f106947a = new UpdateSubtitleType[]{r100, r101, r102, r103};
    }

    public static UpdateSubtitleType valueOf(String r100) {
        return (UpdateSubtitleType) r27.a.a(UpdateSubtitleType.class, r100);
    }

    public static UpdateSubtitleType[] values() {
        return (UpdateSubtitleType[]) f106947a.clone();
    }

    public UpdateSubtitleType(String r100, int r101) {
        super(r100, r101);
    }
}
