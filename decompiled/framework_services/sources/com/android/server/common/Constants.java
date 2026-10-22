package com.android.server.common;

import com.zte.game.Feature;

/* JADX INFO: loaded from: classes.dex */
public final class Constants {
    public static boolean ENABLE_GAME_ASSIST;
    public static boolean ENABLE_GAME_SCREEN_SAVER;
    public static String MAGIC_GAME_ASSIST;
    public static String MAGIC_GAME_SCREEN_SAVER;

    public Constants() {
    }

    static {
        MAGIC_GAME_ASSIST = "ZTE_FEATURE_MAGIC_GAME_ASSIST";
        ENABLE_GAME_ASSIST = Feature.getBoolean(MAGIC_GAME_ASSIST, false);
        MAGIC_GAME_SCREEN_SAVER = "ZTE_FEATURE_MAGIC_GAME_SCREEN_SAVER";
        ENABLE_GAME_SCREEN_SAVER = Feature.getBoolean(MAGIC_GAME_SCREEN_SAVER, false);
    }
}
