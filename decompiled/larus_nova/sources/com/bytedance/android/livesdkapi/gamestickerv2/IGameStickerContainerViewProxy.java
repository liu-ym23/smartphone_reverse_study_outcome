package com.bytedance.android.livesdkapi.gamestickerv2;

import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerOrientation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J4\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000bH&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH&J(\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020(H&J(\u0010,\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH&J\b\u0010-\u001a\u00020\u0003H&¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerContainerViewProxy;", "", "attachView", "", "containerView", "Landroid/view/ViewGroup;", "bindTask", "task", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerTask;", "detachView", "hasTask", "", "onLayoutFinished", "onOrientationChanged", "orientation", "", "onPageVisibilityChange", "source", "", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "visible", "Lcom/bytedance/android/livesdkapi/depend/model/live/gamesticker/GameStickerOrientation;", "startTimestamp", "", "setFirstFrameState", "hasFirstFrame", "setLayoutStrategy", "layoutStrategy", "Lcom/bytedance/android/livesdkapi/gamestickerv2/IGameStickerLayoutStrategy;", "setMargin", "top", "left", "setRoomStickerType", "hasType", "setSize", "width", "height", "setTranslationAndScale", LiveDegradeFpsAnimator.TRANSLATION_X, "", LiveDegradeFpsAnimator.TRANSLATION_Y, LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y, "setUiParams", "unbindTask", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IGameStickerContainerViewProxy {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void onPageVisibilityChange$default(IGameStickerContainerViewProxy r100, String r101, Room r102, boolean r110, GameStickerOrientation r111, long r112, int r113, Object r114) {
            if (r114 != null) goto L9;
            if ((r113 & 16) == 0) goto L6;
            r112 = -1;
        L6:
            r100.onPageVisibilityChange(r101, r102, r110, r111, r112);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPageVisibilityChange");
        }
    }

    void attachView(ViewGroup r100);

    void bindTask(IGameStickerTask r100);

    void detachView();

    boolean hasTask();

    void onLayoutFinished();

    void onOrientationChanged(int r100);

    void onPageVisibilityChange(String r100, Room r101, boolean r102, GameStickerOrientation r103, long r104);

    void setFirstFrameState(boolean r100);

    void setLayoutStrategy(IGameStickerLayoutStrategy r100);

    void setMargin(int r100, int r101);

    void setRoomStickerType(boolean r100);

    void setSize(int r100, int r101);

    void setTranslationAndScale(float r100, float r101, float r102, float r103);

    void setUiParams(int r100, int r101, int r102, int r103);

    void unbindTask();
}
