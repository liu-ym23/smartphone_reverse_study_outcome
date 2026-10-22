package com.bytedance.android.live.profit.dress.config;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/MvpEffectScene;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Unknown", "LinkMic", "AudioChat", "VideoChat", "GridVideoChat", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MvpEffectScene extends Enum<MvpEffectScene> {
    public static final MvpEffectScene AudioChat = null;
    public static final a Companion = null;
    public static final MvpEffectScene GridVideoChat = null;
    public static final MvpEffectScene LinkMic = null;
    public static final MvpEffectScene Unknown = null;
    public static final MvpEffectScene VideoChat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MvpEffectScene[] f87090a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.profit.dress.config.MvpEffectScene$a] */
    static {
        MvpEffectScene r100 = new MvpEffectScene("Unknown", 0, 0);
        Unknown = r100;
        MvpEffectScene r101 = new MvpEffectScene("LinkMic", 1, 1);
        LinkMic = r101;
        MvpEffectScene r102 = new MvpEffectScene("AudioChat", 2, 2);
        AudioChat = r102;
        MvpEffectScene r103 = new MvpEffectScene("VideoChat", 3, 3);
        VideoChat = r103;
        MvpEffectScene r104 = new MvpEffectScene("GridVideoChat", 4, 4);
        GridVideoChat = r104;
        f87090a = new MvpEffectScene[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static MvpEffectScene valueOf(String r100) {
        return (MvpEffectScene) r27.a.a(MvpEffectScene.class, r100);
    }

    public static MvpEffectScene[] values() {
        return (MvpEffectScene[]) f87090a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MvpEffectScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
