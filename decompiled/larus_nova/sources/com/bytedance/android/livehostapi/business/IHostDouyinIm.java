package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostDouyinIm extends IService {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostDouyinIm$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$hasImInitFinishedWithoutAuth(IHostDouyinIm r100) {
            return false;
        }

        public static boolean $default$isImSaasPluginInited(IHostDouyinIm r100) {
            return false;
        }
    }

    public interface IDouyinImEventListener {
        void onGetUnreadCount(int r100);
    }

    public interface IDouyinImLoadingListener {
        void onLoadFinish();

        void onLoading();
    }

    void bindDouyinImEventListener(IDouyinImEventListener r100);

    void cancelDouyinImHomePageToUser();

    long getUnreadCount();

    boolean hasImInitFinishedWithoutAuth();

    boolean isAuthSuccess();

    boolean isImSaasPluginInited();

    void openDouyinImHomePage(Context r100, Map<String, String> r101);

    void openDouyinImHomePageToUser(Context r100, String r101, Map<String, String> r102, IDouyinImLoadingListener r103);
}
