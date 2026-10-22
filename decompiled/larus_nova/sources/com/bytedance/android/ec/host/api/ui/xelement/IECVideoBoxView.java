package com.bytedance.android.ec.host.api.ui.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\r¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\rH&J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H&J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0014H&J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0002H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\rH&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H&J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0014H&J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bH&JN\u0010/\u001a\u00020\u00042D\u0010.\u001a@\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u0004\u0018\u00010'H&J\u0010\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\rH\u0016J,\u00107\u001a\u00020\u00042\"\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,04j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,`5H\u0016J\u0012\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H\u0016J\b\u0010;\u001a\u00020\rH\u0016¨\u0006D"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/IECVideoBoxView;", "Landroid/widget/RelativeLayout;", "", "tag", "", "setTag", "subTag", "setSubTag", "", "loopStartTime", "setLoopStartTime", "loopEndTime", "setLoopEndTime", "", "loopCount", "setLoopCount", "videoData", "setVideoData", "src", "setSrc", "", "muted", "setMuted", "initTime", "setInitTime", "autoPlay", "setAutoPlay", "loop", "setLoop", "poster", "setPoster", "rate", "setRate", "objectFit", "setObjectFit", "deviceChangeAware", "setDeviceChangeAware", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "state", "", "", "data", "reporter", "setStateChangeReporter", "videoWidth", "setVideoWidth", "videoHeight", "setVideoHeight", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "logExtra", "setLogExtra", "", "borderRadius", "setBorderRadius", "getDuration", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IECVideoBoxView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f46192a = 0;

    public static final class a {
    }

    static {
    }

    public IECVideoBoxView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IECVideoBoxView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public int getDuration() {
        return 0;
    }

    public abstract void setAutoPlay(boolean r100);

    public void setBorderRadius(float[] r100) {
    }

    public abstract void setDeviceChangeAware(boolean r100);

    public abstract void setInitTime(int r100);

    public void setLogExtra(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "logExtra");
    }

    public abstract void setLoop(boolean r100);

    public void setLoopCount(int r100) {
    }

    public void setLoopEndTime(float r100) {
    }

    public void setLoopStartTime(float r100) {
    }

    public abstract void setMuted(boolean r100);

    public abstract void setObjectFit(String r100);

    public abstract void setPoster(String r100);

    public abstract void setRate(int r100);

    public abstract void setSrc(String r100);

    public abstract void setStateChangeReporter(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100);

    public void setSubTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
    }

    public void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
    }

    public abstract void setVideoData(String r100);

    public void setVideoHeight(int r100) {
    }

    public void setVideoWidth(int r100) {
    }

    public abstract void setVolume(float r100);

    public IECVideoBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ IECVideoBoxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
