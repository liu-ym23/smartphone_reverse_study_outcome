package com.stepos.core.device.awareness;

import com.stepos.base.awareness.data.SceneType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;
import q6.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DefaultSceneEvaluator implements b {

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
                iArr[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                SceneType sceneType3 = SceneType.f6193a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                SceneType sceneType4 = SceneType.f6193a;
                iArr[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                SceneType sceneType5 = SceneType.f6193a;
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                SceneType sceneType6 = SceneType.f6193a;
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                SceneType sceneType7 = SceneType.f6193a;
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // q6.b
    public SceneType evaluateScene(r6.b load) {
        g.f(load, "load");
        return load.f11754g ? SceneType.h : (load.f11751d >= 20 || load.f11752e) ? load.f11748a > 70.0f ? SceneType.f6196d : SceneType.f6193a : SceneType.f6197e;
    }

    public int getScenePriority(SceneType scene) {
        g.f(scene, "scene");
        switch (WhenMappings.$EnumSwitchMapping$0[scene.ordinal()]) {
            case 1:
                return 100;
            case 2:
                return 60;
            case 3:
                return 40;
            case 4:
                return 30;
            case 5:
                return 20;
            case 6:
            case 7:
                return 10;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public boolean isHighPriorityScene(SceneType scene) {
        g.f(scene, "scene");
        return WhenMappings.$EnumSwitchMapping$0[scene.ordinal()] == 1;
    }
}
