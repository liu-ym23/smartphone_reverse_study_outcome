package com.bytedance.android.live.broadcastgame.api.xplay;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/XplayGuestType;", "", "", "guestType", "I", "getGuestType", "()I", "DEFAULT", "SILENCE", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum XplayGuestType extends Enum<XplayGuestType> {
    public static final XplayGuestType DEFAULT = null;
    public static final XplayGuestType SILENCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayGuestType[] f59437a = null;
    private final int guestType;

    static {
        XplayGuestType r100 = new XplayGuestType("DEFAULT", 0, 0);
        DEFAULT = r100;
        XplayGuestType r101 = new XplayGuestType("SILENCE", 1, 1);
        SILENCE = r101;
        f59437a = new XplayGuestType[]{r100, r101};
    }

    public static XplayGuestType valueOf(String r100) {
        return (XplayGuestType) r27.a.a(XplayGuestType.class, r100);
    }

    public static XplayGuestType[] values() {
        return (XplayGuestType[]) f59437a.clone();
    }

    public final int getGuestType() {
        return this.guestType;
    }

    public XplayGuestType(String r100, int r101, int r102) {
        super(r100, r101);
        this.guestType = r102;
    }
}
