package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/TalkRoomOperate;", "", "", "operate", "Ljava/lang/String;", "getOperate", "()Ljava/lang/String;", "INVITE", "PERMIT", "SILENCE", "UNSILENCE", "DISCONNECT", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum TalkRoomOperate extends Enum<TalkRoomOperate> {
    public static final TalkRoomOperate DISCONNECT = null;
    public static final TalkRoomOperate INVITE = null;
    public static final TalkRoomOperate PERMIT = null;
    public static final TalkRoomOperate SILENCE = null;
    public static final TalkRoomOperate UNSILENCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TalkRoomOperate[] f77459a = null;
    private final String operate;

    static {
        TalkRoomOperate r100 = new TalkRoomOperate("INVITE", 0, "invite");
        INVITE = r100;
        TalkRoomOperate r101 = new TalkRoomOperate("PERMIT", 1, "permit");
        PERMIT = r101;
        TalkRoomOperate r102 = new TalkRoomOperate("SILENCE", 2, LiveCommonConstants.REASON_SILENCE);
        SILENCE = r102;
        TalkRoomOperate r103 = new TalkRoomOperate("UNSILENCE", 3, LiveCommonConstants.REASON_UNSILENCE);
        UNSILENCE = r103;
        TalkRoomOperate r104 = new TalkRoomOperate("DISCONNECT", 4, "disconnect");
        DISCONNECT = r104;
        f77459a = new TalkRoomOperate[]{r100, r101, r102, r103, r104};
    }

    public static TalkRoomOperate valueOf(String r100) {
        return (TalkRoomOperate) r27.a.a(TalkRoomOperate.class, r100);
    }

    public static TalkRoomOperate[] values() {
        return (TalkRoomOperate[]) f77459a.clone();
    }

    public final String getOperate() {
        return this.operate;
    }

    public TalkRoomOperate(String r100, int r101, String r102) {
        super(r100, r101);
        this.operate = r102;
    }
}
