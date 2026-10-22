package com.bytedance.android.livesdkapi.service.gamecp;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H&JZ\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0081\u0001\u0010 \u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`#2&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`#H&¢\u0006\u0002\u0010%J\u0087\u0001\u0010 \u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2&\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`#2&\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\"j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`#H&¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\tH&¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/gamecp/ILiveFloatViewService;", "", "addFloatViewStatusObserver", "", "observer", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "getCurResolution", "", "isFloatViewShowing", "", "markFullPanel", "isOpen", "pauseLiveStream", "pullAudioStream", "forcePullStream", "removeFloatViewStatusObserver", "setResolution", "resolution", "showFloatView", "ctx", "Landroid/content/Context;", "requestPage", "finishOnClick", "enterRoomId", "", "useLowResolution", "forceNotSharedLiveClient", "inBackGround", ITTVideoEngineEventSource.KEY_MUTE, "skipCheckResume", "layoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "showFloatViewNow", "trackParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "(Landroid/content/Context;Ljava/lang/Long;ZZLjava/util/HashMap;Ljava/util/HashMap;)V", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/DialogFragment;", "rootView", "Landroid/widget/FrameLayout;", "(Landroidx/fragment/app/DialogFragment;Landroid/widget/FrameLayout;Ljava/lang/Long;ZZLjava/util/HashMap;Ljava/util/HashMap;)V", "stopFloatView", "stopLiveStream", "toggleLiveAudio", "open", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveFloatViewService {
    void addFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r100);

    String getCurResolution();

    boolean isFloatViewShowing();

    void markFullPanel(boolean r100);

    void pauseLiveStream();

    void pullAudioStream(boolean r100);

    void removeFloatViewStatusObserver(IVideoFloatManager.VideoFloatManagerListener r100);

    void setResolution(String r100);

    void showFloatView(Context r100, String r101, boolean r102, long r103, boolean r104, boolean r105, boolean r106, boolean r107, boolean r110, RelativeLayout.LayoutParams r111);

    void showFloatViewNow(Context r100, Long r101, boolean r102, boolean r103, HashMap<String, String> r104, HashMap<String, String> r105);

    void showFloatViewNow(DialogFragment r100, FrameLayout r101, Long r102, boolean r103, boolean r104, HashMap<String, String> r105, HashMap<String, String> r106);

    void stopFloatView();

    void stopLiveStream();

    void toggleLiveAudio(boolean r100);
}
