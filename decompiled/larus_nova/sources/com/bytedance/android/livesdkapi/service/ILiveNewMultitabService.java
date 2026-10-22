package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H&Jb\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102&\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/ILiveNewMultitabService;", "", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "getFloatWindowBottomMargin", "", "()Ljava/lang/Integer;", "isLiveMoreEntranceFloatWindowShowing", "", "removeVideoFloatManagerListener", "setFloatWindowBottomMargin", "bottomMargin", "tryShowMultiTabFloatWindow", "activity", "Landroid/app/Activity;", "eventMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraParamsMap", "tryStopMultiTabFloatWindow", "tryStopMultiTabFloatWindowForever", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveNewMultitabService {
    void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    Integer getFloatWindowBottomMargin();

    boolean isLiveMoreEntranceFloatWindowShowing();

    void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r100);

    void setFloatWindowBottomMargin(int r100);

    void tryShowMultiTabFloatWindow(Activity r100, HashMap<String, String> r101, HashMap<String, String> r102);

    void tryStopMultiTabFloatWindow(Activity r100);

    void tryStopMultiTabFloatWindowForever(Activity r100);
}
