package com.bytedance.android.livesdkapi.depend.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/IPreviewController;", "", "clear", "", "getCurrentItem", "", "hideInteractionFragment", "isPreview", "", "isUserVisible", "onBackPress", "onExitCurrentPage", "setPreviewState", "setUserVisible", "visible", "showInteractionFragment", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPreviewController {
    void clear();

    int getCurrentItem();

    void hideInteractionFragment();

    boolean isPreview();

    boolean isUserVisible();

    void onBackPress();

    void onExitCurrentPage();

    void setPreviewState(boolean r100);

    void setUserVisible(boolean r100);

    void showInteractionFragment();
}
