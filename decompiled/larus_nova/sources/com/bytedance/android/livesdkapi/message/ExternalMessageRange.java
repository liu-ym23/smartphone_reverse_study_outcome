package com.bytedance.android.livesdkapi.message;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/ExternalMessageRange;", "", "()V", "COMMERCE_MAX", "", "COMMERCE_MIN", "END_ROOM_MAX", "END_ROOM_MIN", "FORMAT_LIVE_MAX", "FORMAT_LIVE_MIN", "GAME_PROMOTE_MAX", "GAME_PROMOTE_MIN", "LIVE_INTERACTIVITY_MAX", "LIVE_INTERACTIVITY_MIN", "LIVE_LIFE_MAX", "LIVE_LIFE_MIN", "LIVE_REV_LINK_MAN", "LIVE_REV_LINK_MIN", "LYNX_DYNAMIC_MAX", "LYNX_DYNAMIC_MIN", "SHOPPING_MAX", "SHOPPING_MIN", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExternalMessageRange {
    public static final int COMMERCE_MAX = 3000;
    public static final int COMMERCE_MIN = 2001;
    public static final int END_ROOM_MAX = 9000;
    public static final int END_ROOM_MIN = 8001;
    public static final int FORMAT_LIVE_MAX = 10000;
    public static final int FORMAT_LIVE_MIN = 9001;
    public static final int GAME_PROMOTE_MAX = 7000;
    public static final int GAME_PROMOTE_MIN = 6001;
    public static final ExternalMessageRange INSTANCE = null;
    public static final int LIVE_INTERACTIVITY_MAX = 5000;
    public static final int LIVE_INTERACTIVITY_MIN = 4001;
    public static final int LIVE_LIFE_MAX = 4000;
    public static final int LIVE_LIFE_MIN = 3001;
    public static final int LIVE_REV_LINK_MAN = 6000;
    public static final int LIVE_REV_LINK_MIN = 5001;
    public static final int LYNX_DYNAMIC_MAX = 8000;
    public static final int LYNX_DYNAMIC_MIN = 7001;
    public static final int SHOPPING_MAX = 2000;
    public static final int SHOPPING_MIN = 1001;

    private ExternalMessageRange() {
    }

    static {
        INSTANCE = new ExternalMessageRange();
    }
}
