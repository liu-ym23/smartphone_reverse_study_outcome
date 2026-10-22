package com.bytedance.android.livesdkapi.depend.live.player;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.IDependency;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerLoopListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\tH&J\b\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\tH&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 H&J1\u0010!\u001a\u00020\t2'\u0010\"\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020%0$¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\t0#H&J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\t2\u0006\u0010*\u001a\u00020-H&J8\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u000104H&J\b\u00105\u001a\u00020\tH&J\b\u00106\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u00067"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/player/ITextureViewPlayerController;", "Lcom/bytedance/android/livesdkapi/depend/IDependency;", "enableCropView", "", "getEnableCropView", "()Z", "setEnableCropView", "(Z)V", "attachAlphaView", "", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "cancel", "detachAlphaView", "getAlphaView", "Landroid/view/View;", "getDuration", "", "initialize", "owner", "Landroidx/lifecycle/LifecycleOwner;", "isPlaying", "pause", "release", "removeMonitor", "removePlayerActionListener", "resume", "setMaskSrc", "maskSrc", "Lcom/bytedance/android/livesdkapi/depend/live/player/MaskSrc;", "setMonitor", "monitor", "Lcom/bytedance/android/livesdkapi/depend/live/gift/IResultMonitor;", "setOnElementClickListener", "onclick", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", SlcElement.KEY_ELEMENTS, "setPlayerActionListener", "listener", "Lcom/bytedance/android/livesdkapi/depend/live/gift/IPlayerActionListener;", "setPlayerLooperListener", "Lcom/bytedance/android/livesdkapi/depend/live/gift/IPlayerLoopListener;", "start", "filePath", "loop", "enablePlayAudio", "keepLastFrame", "config", "Lcom/bytedance/android/livesdkapi/depend/live/player/PlayConfig;", "stop", "stopWhenSlideSwitch", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ITextureViewPlayerController extends IDependency {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void start$default(ITextureViewPlayerController r100, String r101, boolean r102, boolean r103, boolean r110, PlayConfig r111, int r112, Object r113) {
            if (r113 != null) goto L17;
            if ((r112 & 4) == 0) goto L6;
            boolean r104 = true;
        L8:
            if ((r112 & 8) == 0) goto L10;
            boolean r105 = false;
        L12:
            if ((r112 & 16) == 0) goto L14;
            r111 = null;
        L14:
            r100.start(r101, r102, r104, r105, r111);
            return;
        L10:
            r105 = r110;
            goto L12
        L6:
            r104 = r103;
            goto L8
        L17:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
        }
    }

    void attachAlphaView(ViewGroup r100);

    void cancel();

    void detachAlphaView(ViewGroup r100);

    View getAlphaView();

    int getDuration();

    boolean getEnableCropView();

    void initialize(LifecycleOwner r100);

    boolean isPlaying();

    void pause();

    void release();

    void removeMonitor();

    void removePlayerActionListener();

    void resume();

    void setEnableCropView(boolean r100);

    void setMaskSrc(MaskSrc r100);

    void setMonitor(IResultMonitor r100);

    void setOnElementClickListener(Function1<? super List<String>, Unit> r100);

    void setPlayerActionListener(IPlayerActionListener r100);

    void setPlayerLooperListener(IPlayerLoopListener r100);

    void start(String r100, boolean r101, boolean r102, boolean r103, PlayConfig r104);

    void stop();

    void stopWhenSlideSwitch();
}
