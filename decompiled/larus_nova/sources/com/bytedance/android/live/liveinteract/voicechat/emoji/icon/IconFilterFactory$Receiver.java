package com.bytedance.android.live.liveinteract.voicechat.emoji.icon;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"com/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Receiver", "", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/icon/IconFilterFactory$Receiver;", EffectConstants.NORMAL, "MYSTERY", "ANONYMOUS", FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, "AI_GUEST", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IconFilterFactory$Receiver extends Enum<IconFilterFactory$Receiver> {
    public static final IconFilterFactory$Receiver AI_GUEST = null;
    public static final IconFilterFactory$Receiver ANCHOR = null;
    public static final IconFilterFactory$Receiver ANONYMOUS = null;
    public static final IconFilterFactory$Receiver MYSTERY = null;
    public static final IconFilterFactory$Receiver NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconFilterFactory$Receiver[] f80168a = null;

    static {
        IconFilterFactory$Receiver r100 = new IconFilterFactory$Receiver(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        IconFilterFactory$Receiver r101 = new IconFilterFactory$Receiver("MYSTERY", 1);
        MYSTERY = r101;
        IconFilterFactory$Receiver r102 = new IconFilterFactory$Receiver("ANONYMOUS", 2);
        ANONYMOUS = r102;
        IconFilterFactory$Receiver r103 = new IconFilterFactory$Receiver(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID, 3);
        ANCHOR = r103;
        IconFilterFactory$Receiver r104 = new IconFilterFactory$Receiver("AI_GUEST", 4);
        AI_GUEST = r104;
        f80168a = new IconFilterFactory$Receiver[]{r100, r101, r102, r103, r104};
    }

    public static IconFilterFactory$Receiver valueOf(String r100) {
        return (IconFilterFactory$Receiver) a.a(IconFilterFactory$Receiver.class, r100);
    }

    public static IconFilterFactory$Receiver[] values() {
        return (IconFilterFactory$Receiver[]) f80168a.clone();
    }

    public IconFilterFactory$Receiver(String r100, int r101) {
        super(r100, r101);
    }
}
