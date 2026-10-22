package com.stepos.core.device.awareness;

import com.stepos.base.awareness.data.SceneType;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.TtsCloudConfig;
import com.stepos.core.ota.download.control.HysteresisStrategy;
import kotlin.jvm.internal.g;
import q6.c;
import r6.a;
import r6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DefaultSchedulePolicy implements c {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SceneType.values().length];
            try {
                SceneType sceneType = SceneType.f6193a;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                SceneType sceneType2 = SceneType.f6193a;
                iArr[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                SceneType sceneType3 = SceneType.f6193a;
                iArr[4] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                SceneType sceneType4 = SceneType.f6193a;
                iArr[6] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                SceneType sceneType5 = SceneType.f6193a;
                iArr[3] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                SceneType sceneType6 = SceneType.f6193a;
                iArr[2] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public int getMaxConcurrentTasks(SceneType scene, b load) {
        g.f(scene, "scene");
        g.f(load, "load");
        if (scene != SceneType.f6194b && load.f11748a <= 70.0f && load.f11749b <= 80.0f && load.f11750c >= 256) {
            return scene == SceneType.f6196d ? 4 : 2;
        }
        return 1;
    }

    public BackendType getRecommendedBackend(SceneType scene, b load) {
        g.f(scene, "scene");
        g.f(load, "load");
        int iOrdinal = scene.ordinal();
        if (iOrdinal == 1) {
            return BackendType.f6254d;
        }
        if (iOrdinal != 4) {
            if (iOrdinal == 5) {
                return BackendType.f6256j;
            }
            if (iOrdinal != 6) {
                return BackendType.f6257k;
            }
        }
        return BackendType.f6256j;
    }

    public int getRecommendedThreadCount(SceneType scene, b load) {
        g.f(scene, "scene");
        g.f(load, "load");
        int i10 = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3 || i10 == 4) ? 1 : 2;
        }
        return 4;
    }

    public long getRecommendedTimeout(SceneType scene) {
        g.f(scene, "scene");
        int i10 = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        return i10 != 1 ? i10 != 5 ? i10 != 6 ? AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS : TtsCloudConfig.DEFAULT_AUDIO_FIRST_FRAME_BUDGET_MS : HysteresisStrategy.DEFAULT_DWELL_MS : TtsCloudConfig.DEFAULT_AUDIO_DONE_IDLE_WATCHDOG_MS;
    }

    @Override // q6.c
    public a makeDecision(SceneType scene, b load) {
        g.f(scene, "scene");
        g.f(load, "load");
        return new a(scene, getRecommendedBackend(scene, load), null, getRecommendedThreadCount(scene, load), getRecommendedTimeout(scene), getMaxConcurrentTasks(scene, load), 0, 4004);
    }
}
