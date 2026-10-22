package com.bytedance.android.livesdkapi.view;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/view/ILiveWindow;", "", "dismissLiveWindow", "", "isCloseLiveWindowByUserClick", "", "isShowing", "play", "showEndView", "showLiveWindow", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveWindow {
    void dismissLiveWindow();

    boolean isCloseLiveWindowByUserClick();

    boolean isShowing();

    void play();

    void showEndView();

    void showLiveWindow();
}
