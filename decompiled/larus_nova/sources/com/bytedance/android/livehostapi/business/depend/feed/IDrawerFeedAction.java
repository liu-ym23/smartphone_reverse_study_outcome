package com.bytedance.android.livehostapi.business.depend.feed;

import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes7.dex */
public interface IDrawerFeedAction {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setDrawerLockMode(IDrawerFeedAction r100, int r101) {
        }
    }

    void closeDrawerDialog();

    void disableDrawerSlide();

    void enterHistory();

    void enterSearch();

    void feedEnd();

    ViewModel getDataCenter();

    IDrawerUIManager getDrawerUIManager();

    void historyShow(int r100);

    void scrollToTop(boolean r100);

    void setBackgroundByTabType(int r100);

    void setDrawerLockMode(int r100);

    void setInterceptor(ILiveDrawerLayoutInterceptor r100);
}
