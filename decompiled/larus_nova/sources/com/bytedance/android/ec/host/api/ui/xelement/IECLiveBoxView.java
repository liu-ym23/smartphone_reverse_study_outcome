package com.bytedance.android.ec.host.api.ui.xelement;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H&R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/host/api/ui/xelement/IECLiveBoxView;", "Landroid/widget/FrameLayout;", "", ITTVideoEngineEventSource.KEY_MUTE, "", "setMute", "", "poster", "setPoster", "", ITTVideoEngineEventSource.KEY_VOLUME, "setVolume", "roomID", "setRoomID", "liveData", "setLiveData", "streamData", "setStreamData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getSharePlayer", "()Z", "setSharePlayer", "(Z)V", "sharePlayer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class IECLiveBoxView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f46190b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f46191a;

    public IECLiveBoxView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IECLiveBoxView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void setLiveData(String r100);

    public abstract void setMute(boolean r100);

    public abstract void setPoster(String r100);

    public abstract void setRoomID(String r100);

    public abstract void setStreamData(String r100);

    public abstract void setVolume(float r100);

    public final boolean getSharePlayer() {
        return this.f46191a;
    }

    public final void setSharePlayer(boolean r100) {
        this.f46191a = r100;
    }

    public IECLiveBoxView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ IECLiveBoxView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
