package com.android.server.display.auto;

import com.android.server.utils.PriorityDump;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface IAutoBrightnessScene {
    public static final int SCENE_GAME = 1;
    public static final int SCENE_NORMAL = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scene {
    }

    static String sceneToString(int scene) {
        switch(scene) {
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        return PriorityDump.PRIORITY_ARG_NORMAL;
    L5:
        return "GAME";
    }
}
