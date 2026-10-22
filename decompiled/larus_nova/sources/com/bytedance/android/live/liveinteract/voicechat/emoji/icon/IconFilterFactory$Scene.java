package com.bytedance.android.live.liveinteract.voicechat.emoji.icon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Scene", "", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Scene;", "ROOM", "CROSS_ROOM", "KTV", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconFilterFactory$Scene extends Enum<IconFilterFactory$Scene> {
    public static final IconFilterFactory$Scene CROSS_ROOM = null;
    public static final IconFilterFactory$Scene KTV = null;
    public static final IconFilterFactory$Scene ROOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconFilterFactory$Scene[] f80169a = null;

    static {
        IconFilterFactory$Scene r100 = new IconFilterFactory$Scene("ROOM", 0);
        ROOM = r100;
        IconFilterFactory$Scene r101 = new IconFilterFactory$Scene("CROSS_ROOM", 1);
        CROSS_ROOM = r101;
        IconFilterFactory$Scene r102 = new IconFilterFactory$Scene("KTV", 2);
        KTV = r102;
        f80169a = new IconFilterFactory$Scene[]{r100, r101, r102};
    }

    public static IconFilterFactory$Scene valueOf(String r100) {
        return (IconFilterFactory$Scene) a.a(IconFilterFactory$Scene.class, r100);
    }

    public static IconFilterFactory$Scene[] values() {
        return (IconFilterFactory$Scene[]) f80169a.clone();
    }

    public IconFilterFactory$Scene(String r100, int r101) {
        super(r100, r101);
    }
}
