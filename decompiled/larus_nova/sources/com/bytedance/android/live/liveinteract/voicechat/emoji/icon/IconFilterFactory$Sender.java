package com.bytedance.android.live.liveinteract.voicechat.emoji.icon;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Sender", "", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Sender;", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "ADMIN", "GUEST", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconFilterFactory$Sender extends Enum<IconFilterFactory$Sender> {
    public static final IconFilterFactory$Sender ADMIN = null;
    public static final IconFilterFactory$Sender ANCHOR = null;
    public static final IconFilterFactory$Sender GUEST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconFilterFactory$Sender[] f80170a = null;

    static {
        IconFilterFactory$Sender r100 = new IconFilterFactory$Sender(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 0);
        ANCHOR = r100;
        IconFilterFactory$Sender r101 = new IconFilterFactory$Sender("ADMIN", 1);
        ADMIN = r101;
        IconFilterFactory$Sender r102 = new IconFilterFactory$Sender("GUEST", 2);
        GUEST = r102;
        f80170a = new IconFilterFactory$Sender[]{r100, r101, r102};
    }

    public static IconFilterFactory$Sender valueOf(String r100) {
        return (IconFilterFactory$Sender) a.a(IconFilterFactory$Sender.class, r100);
    }

    public static IconFilterFactory$Sender[] values() {
        return (IconFilterFactory$Sender[]) f80170a.clone();
    }

    public IconFilterFactory$Sender(String r100, int r101) {
        super(r100, r101);
    }
}
