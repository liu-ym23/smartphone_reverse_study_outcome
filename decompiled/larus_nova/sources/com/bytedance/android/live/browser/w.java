package com.bytedance.android.live.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.LynxViewBuilder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface w extends IService {
    void addHybridDebugTool(Context r100, ViewGroup r101, String r102, boolean r103);

    com.bytedance.android.live.lynx.api.c create(Activity r100, Integer r101, String r102, LynxThreadStrategy r103, String r104, d0 r105);

    com.bytedance.android.live.lynx.api.d create(Context r100, Integer r101, LynxThreadStrategy r102, d0 r103, String r104);

    com.bytedance.android.live.lynx.api.c createAndLoad(ILiveHybridContainer r100, String r101, Integer r102, LynxThreadStrategy r103, String r104, d0 r105);

    Fragment createLynxFragment(Context r100, Bundle r101, d0 r102);

    <T extends LiveRecyclableWidget> Class<T> createTestWidgetClass();

    d8a.b getAbsTemplateProvider();

    List<com.lynx.tasm.behavior.a> getBehaviorList();

    k7a.a getDynamicComponentFetcher();

    n30.a getHybridMonitor();

    List<com.lynx.tasm.behavior.a> getLiveExportedXElements();

    LynxGroup getLynxGroup(String r100, String[] r101, boolean r102, boolean r103, boolean r104, int r105);

    boolean isEnableDevtoolDebug();

    Object map2TemplateData(Map<String, ? extends Object> r100, String r101);

    void monitorCachePropsInject(String r100, JSONObject r101);

    void monitorLynxListFps(LynxView r100, String r101, String r102, double r103, boolean r104);

    void prepareRemoteDebug(String r100);

    List<com.lynx.tasm.behavior.a> provideLynxLiveBehaviors();

    void reportLynxFallback(String r100, int r101, String r102);

    void reportLynxFetchJsbError(View r100, String r101, String r102, int r103, String r104);

    void setEnableDevtoolDebug(boolean r100);

    void setEnableJSRuntime(LynxViewBuilder r100, boolean r101);

    void setEnableUserCodeCache(LynxViewBuilder r100, boolean r101, String r102);

    long startLynxCast(LynxView r100, String r101, Surface r102, int r103, int r104);

    void stopLynxCast(LynxView r100, String r101, long r102);

    void tryInitEnvIfNeeded(Context r100);

    void updateData(View r100, Object r101, boolean r102);
}
