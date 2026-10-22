package com.bytedance.android.livehostapi.platform.flavor.xt;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostAction;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostActionForXT extends IService, IBaseHostAction {
    public static final String BUNDLE_HIDE_MORE = "hide_more";
    public static final String BUNDLE_HIDE_NAV_BAR = "hide_nav_bar";
    public static final String BUNDLE_HIDE_STATUS_BAR = "hide_status_bar";
    public static final String BUNDLE_ROTATE = "bundle_rotate";
    public static final String BUNDLE_SHOW_PROGRESS = "show_progress";
    public static final String BUNDLE_TITLE = "title";
    public static final String BUNDLE_URL = "url";

    boolean handleSchema(Context r100, String r101, Bundle r102);

    void initLynxEnv();

    void installHook();

    void openFeedBack(String r100, Context r101);

    void openLiveBrowser(String r100, Bundle r101, Context r102);

    void openLiveLynx(String r100, Bundle r101, Context r102);

    void openUserProfilePage(long r100, Map<String, String> r101);

    void startLive(Context r100, long r101, Bundle r102);

    void switchToLiveTab(int r100, String r101);
}
