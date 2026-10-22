package com.bytedance.android.livesdk.interactivity.zdanmaku.layout.danmakuline;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
public interface IHeatChangeController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/layout/danmakuline/IHeatChangeController$DanmakuHeat;", "", "LOW", "MEDIUM", "HIGH", EffectConstants.NORMAL, "HIGH_MAX", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DanmakuHeat extends Enum<DanmakuHeat> {
        public static final DanmakuHeat HIGH = null;
        public static final DanmakuHeat HIGH_MAX = null;
        public static final DanmakuHeat LOW = null;
        public static final DanmakuHeat MEDIUM = null;
        public static final DanmakuHeat NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DanmakuHeat[] f141663a = null;

        static {
            DanmakuHeat r100 = new DanmakuHeat("LOW", 0);
            LOW = r100;
            DanmakuHeat r101 = new DanmakuHeat("MEDIUM", 1);
            MEDIUM = r101;
            DanmakuHeat r102 = new DanmakuHeat("HIGH", 2);
            HIGH = r102;
            DanmakuHeat r103 = new DanmakuHeat(EffectConstants.NORMAL, 3);
            NORMAL = r103;
            DanmakuHeat r104 = new DanmakuHeat("HIGH_MAX", 4);
            HIGH_MAX = r104;
            f141663a = new DanmakuHeat[]{r100, r101, r102, r103, r104};
        }

        public static DanmakuHeat valueOf(String r100) {
            return (DanmakuHeat) a.a(DanmakuHeat.class, r100);
        }

        public static DanmakuHeat[] values() {
            return (DanmakuHeat[]) f141663a.clone();
        }

        public DanmakuHeat(String r100, int r101) {
            super(r100, r101);
        }
    }

    DanmakuHeat a();
}
