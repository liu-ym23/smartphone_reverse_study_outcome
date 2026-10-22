package com.android.server.wm;

import android.app.AppCompatTaskInfo;
import android.content.Context;
import android.graphics.Rect;
import com.android.server.ZteGameServiceFactory;
import com.zte.game.Feature;

/* JADX INFO: loaded from: classes3.dex */
public class IGameRatioStub {
    public static final boolean ZTE_FEATURE_GAMEASSIST_PLUGIN_GAME_RATIO = false;

    public IGameRatioStub() {
    }

    static {
        ZTE_FEATURE_GAMEASSIST_PLUGIN_GAME_RATIO = Feature.getBoolean("ZTE_FEATURE_GAMEASSIST_PLUGIN_GAME_RATIO", false);
    }

    public static IGameRatioStub create(Context context) {
        return ZteGameServiceFactory.getInstance().makeIGameRatioStub(context);
    }

    public boolean isGameRatioEnable() {
        return false;
    }

    public boolean isGameSpaceListApp(String pkgName) {
        return false;
    }

    public int checkGameOrientation(String packageName, int orientation) {
        return orientation;
    }

    public void fillAppCompatTaskInfo(AppCompatTaskInfo appCompatTaskInfo) {
    }

    public int updateWallpaperForLetterbox(int letterboxBackgroundType) {
        return letterboxBackgroundType;
    }

    public float applyAspectRatio(String packageName, float maxAspectRatio, float desiredAspectRatio) {
        return desiredAspectRatio;
    }

    public int updateResolvedBoundsPositionX(Rect parentBounds, Rect screenResolvedBounds, Rect parentAppBounds, int offsetX) {
        return offsetX;
    }

    public int updateResolvedBoundsPositionY(Rect parentBounds, Rect screenResolvedBounds, Rect parentAppBounds, int appHeight, int offsetY) {
        return offsetY;
    }
}
