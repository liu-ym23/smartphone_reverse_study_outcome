package com.bytedance.android.livesdk.chatroom.tetris.vr.viewmodel;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import kotlin.Unit;

/* JADX INFO: loaded from: classes7.dex */
public interface a {
    boolean canShowGestureGuide();

    boolean canShowGestureGuideLandscapeLock();

    void closeVrSensorWhenClickSwitchOrientation();

    void dismissLandscapeControlDialog();

    void dispatchDirectionIndicatorTouchEvent(MotionEvent r100);

    void dispatchPlayerTouchEvent(MotionEvent r100);

    void enterVrMode();

    void exitVrMode();

    k<MotionEvent> getDirectionIndicatorTouchEvent();

    m<Boolean> getShouldShowBreathForReset();

    k<Unit> getShowRecenterGuide();

    boolean isInVrMode();

    m<? extends Boolean> isVrMode();

    m<? extends Boolean> isVrSensorOpen();

    void notifyRecenter();

    void openVrSensor(boolean r100);

    void releaseObservers();

    void setCanShowGestureGuide(boolean r100);

    void setCanShowGestureGuideLandscapeLock(boolean r100);

    void setInCleanMode(boolean r100);

    void showRecenterGuide();

    void showVrControlDialog(Context r100);
}
