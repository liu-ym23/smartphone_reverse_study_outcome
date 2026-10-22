package com.bytedance.android.livesdkapi.xlive;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u000fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001`\u0010H&J\b\u0010\u0011\u001a\u00020\tH&J\b\u0010\u0012\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\tH&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0007H&J\b\u0010\u001b\u001a\u00020\tH&J\b\u0010\u001c\u001a\u00020\tH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&J/\u0010\u001e\u001a\u00020\t2%\b\u0002\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\t\u0018\u00010 H&J$\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010'H&J\b\u0010(\u001a\u00020\tH&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/xlive/IXLivePlayerView;", "", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "config", "Lcom/bytedance/android/livesdkapi/xlive/XLivePlayerViewConfig;", "createPlayerView", "Landroid/view/View;", MapMonitorConst.EVENT_DESTROY, "", "invokeAction", "", "methodName", "", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onAttach", "onDetach", "onListCellAppear", "itemKey", "onListCellDisAppear", "onListCellPrepareForReuse", "onPropsUpdated", "onViewAttachedToWindow", BaseSwitches.V, "onViewDetachedFromWindow", "pause", "play", "playerView", "resumePlay", "eventListener", "Lkotlin/Function1;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/ParameterName;", "name", "lifecycleOwner", "sendCustomEvents", "type", "", "stop", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IXLivePlayerView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void resumePlay$default(IXLivePlayerView r100, Function1 r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.resumePlay(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumePlay");
        }
    }

    ILivePlayerClient client();

    XLivePlayerViewConfig config();

    View createPlayerView();

    void destroy();

    boolean invokeAction(String r100, HashMap<String, Object> r101);

    void onAttach();

    void onDetach();

    void onListCellAppear(String r100);

    void onListCellDisAppear(String r100);

    void onListCellPrepareForReuse(String r100);

    void onPropsUpdated();

    void onViewAttachedToWindow(View r100);

    void onViewDetachedFromWindow(View r100);

    void pause();

    void play();

    View playerView();

    void resumePlay(Function1<? super LifecycleOwner, Unit> r100);

    void sendCustomEvents(String r100, Map<String, ? extends Object> r101);

    void stop();
}
