package com.bytedance.android.ec.hybrid.xelement.ecomlive;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.host.api.ui.xelement.IECLiveBoxView;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007J\b\u0010\u001d\u001a\u00020\u0006H\u0007J\b\u0010\u001e\u001a\u00020\u0006H\u0007J\b\u0010\u001f\u001a\u00020\u0006H\u0007J\b\u0010 \u001a\u00020\u0006H\u0007J\b\u0010!\u001a\u00020\u0006H\u0007¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/hybrid/xelement/ecomlive/ECLynxLiveView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/android/ec/host/api/ui/xelement/IECLiveBoxView;", "Landroidx/lifecycle/LifecycleObserver;", "", "poster", "", "setPoster", "roomID", "setRoomID", "qualities", "setQualities", "", ITTVideoEngineEventSource.KEY_MUTE, "setMute", "(Ljava/lang/Boolean;)V", "", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "objectfit", "setObjectfit", "streamData", "setStreamData", "Lf6a/a;", "liveData", "setLiveData", "Lcom/lynx/react/bridge/ReadableMap;", "params", "enterDetail", "play", "pause", "stop", "onHostPause", "onHostDestroy", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxLiveView extends UISimpleView<IECLiveBoxView> implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f47810a;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f47811a;

        public b(Function0 r100) {
            this.f47811a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f47811a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onHostDestroy() {
        N(new ECLynxLiveView$removeObserver$1(this));
    }

    @LynxUIMethod
    public final void pause() {
        N(new AnonymousClass1(this));
    }

    @LynxUIMethod
    public final void play() {
        N(new C98521(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        IECLiveBoxView r100 = (IECLiveBoxView) getView();
        if (r100 == null) goto L5;
        r100.a();
    L5:
        N(new ECLynxLiveView$removeObserver$1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onHostPause() {
        IECLiveBoxView r100 = (IECLiveBoxView) getView();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @LynxUIMethod
    public final void stop() {
        pause();
    }

    public ECLynxLiveView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(Function0<Unit> r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L7;
        IECLiveBoxView r101 = (IECLiveBoxView) getView();
        if (r101 == null) goto L9;
        r101.post(new b(r100));
        return;
    L9:
        return;
    L7:
        r100.invoke();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f47810a = r100;
        int r101 = com.bytedance.android.ec.hybrid.xelement.b.f47713a;
        N(new ECLynxLiveView$addObserver$1(this));
        Logger.d("ECLynxLiveView", "createView:" + this + ", " + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public final void enterDetail(ReadableMap r100) {
        Logger.d("ECLynxLiveView", "enterDetail:".concat(String.valueOf(r100)));
        if (r100 == null) goto L5;
        HashMap<String, Object> r101 = r100.toHashMap();
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.containsKey("schema") != true) goto L12;
        ((IECLiveBoxView) getView()).b();
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "livedata")
    public final void setLiveData(f6a.a r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        ReadableType r102 = r100.getType();
    L7:
        if (r102 == null) goto L11;
        boolean r103 = true;
        if (com.bytedance.android.ec.hybrid.xelement.ecomlive.a.f47812a[r102.ordinal()] != 1) goto L11;
        Logger.d("ECLynxLiveView", "setVideoData:" + r100.asString());
        if (r100.asString().length() > 0) goto L21;
        r103 = false;
    L21:
        if (r103 == false) goto L25;
        ((IECLiveBoxView) getView()).setLiveData(r100.asString());
        play();
        return;
    L25:
        return;
    L11:
        StringBuilder r104 = new StringBuilder("setLiveData: Not supported LiveData type: ");
        if (r100 == null) goto L16;
        ReadableType r105 = r100.getType();
        if (r105 == null) goto L16;
        r101 = r105.name();
    L16:
        r104.append(r101);
        Logger.e("ECLynxLiveView", r104.toString());
        return;
    L5:
        r102 = null;
        goto L7
    }

    @LynxProp(name = ITTVideoEngineEventSource.KEY_MUTE)
    public final void setMute(final Boolean r100) {
        N(new C98531(this, r100));
    }

    @LynxProp(name = "objectfit")
    public final void setObjectfit(final String r100) {
        if (r100 == null) goto L5;
        N(new ECLynxLiveView$setObjectfit$$inlined$let$lambda$1(this, r100));
        return;
    }

    @LynxProp(name = "poster")
    public final void setPoster(final String r100) {
        if (r100 == null) goto L5;
        N(new ECLynxLiveView$setPoster$$inlined$let$lambda$1(this, r100));
        return;
    }

    @LynxProp(name = "qualities")
    public final void setQualities(final String r100) {
        if (r100 == null) goto L5;
        N(new ECLynxLiveView$setQualities$$inlined$let$lambda$1(this, r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "room-id")
    public final void setRoomID(String r100) {
        if (r100 == null) goto L7;
        IECLiveBoxView r101 = (IECLiveBoxView) getView();
        if (r101 == null) goto L8;
        r101.setRoomID(r100);
        return;
    L8:
        return;
    }

    @LynxProp(name = "streamdata")
    public final void setStreamData(final String r100) {
        if (r100 == null) goto L5;
        N(new ECLynxLiveView$setStreamData$$inlined$let$lambda$1(this, r100));
        return;
    }

    @LynxProp(defaultDouble = AudioStats.AUDIO_AMPLITUDE_NONE, name = ITTVideoEngineEventSource.KEY_VOLUME)
    public final void setVolume(final float r100) {
        N(new C98541(this, r100));
    }

    public static final void M(ECLynxLiveView r100, String r101, Map r102) {
        r100.getClass();
        int r103 = r100.getSign();
        if (r102 != null) goto L5;
        r102 = new LinkedHashMap();
    L5:
        m7a.a r104 = new m7a.a(r103, r101, r102);
        LynxContext r105 = r100.getLynxContext();
        if (r105 == null) goto L11;
        EventEmitter r106 = r105.getEventEmitter();
        if (r106 == null) goto L12;
        r106.sendCustomEvent(r104);
        return;
    L12:
        return;
    }
}
