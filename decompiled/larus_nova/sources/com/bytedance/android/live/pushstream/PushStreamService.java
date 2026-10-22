package com.bytedance.android.live.pushstream;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStatesAndAVResourceUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.pushstream.utils.StreamSignHelper;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import hh1.v0;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uf2.d0;
import uf2.z;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u001fH\u0016J\n\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0016\u0010'\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010#H\u0016J\n\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0014\u0010-\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0016J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00106¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/pushstream/PushStreamService;", "Lcom/bytedance/android/live/pushstream/IPushStreamService;", "", "init", "Lcom/bytedance/android/live/pushstream/u;", "config", "Lcom/bytedance/android/live/pushstream/d;", "createLiveStreamWithConfig", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lfi6/a;", "Lei6/a;", "createGuestClient", "Lhh1/v0;", "createGuestAudioFactory", "Lqv0/a;", "getLiveStreamController", "getRecordLiveStream", "getPushLiveStream", "getLiveRoomStreamCache", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lwv0/a;", "createStreamSignHelper", "releaseRecordLiveStream", "Landroid/view/SurfaceView;", "surfaceView", "liveStream", "Lnv0/a;", "getCameraCaptureInst", "getVoiceRoomCameraCaptureInst", "Lcom/bytedance/android/live/pushstream/report/c;", "statusResultListener", "Lcom/bytedance/android/live/pushstream/report/a;", "getStreamReporter", "Lorg/json/JSONObject;", "getLiveCoreDebugInfo", "", "", "getFpsInfo", "getClientDebugInfo", "Luf2/d0$a;", "getLiveCoreBuilder", "", "getRenderFps", "getLastAudioCaptureLogMap", "getLastVideoCaptureLogMap", "Lcom/bytedance/android/live/pushstream/LiveStream4;", "Lcom/bytedance/android/live/pushstream/LiveStream4;", "Lcom/bytedance/android/live/pushstream/LiveStream4Proxy;", "liveStream4Proxy", "Lcom/bytedance/android/live/pushstream/LiveStream4Proxy;", "Ljava/lang/ref/WeakReference;", "pushLiveStream", "Ljava/lang/ref/WeakReference;", "liveRoomStreamCache", "<init>", "()V", "livepushstream-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PushStreamService implements IPushStreamService {
    private WeakReference<d> liveRoomStreamCache;
    private LiveStream4 liveStream;
    private LiveStream4Proxy liveStream4Proxy;
    private WeakReference<d> pushLiveStream;

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public v0 createGuestAudioFactory(Context r100) {
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public ei6.a createGuestClient(Context r100, fi6.a r101) {
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public void init() {
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public JSONObject getClientDebugInfo() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L7;
        d r101 = r100.get();
        if (r101 == null) goto L7;
        return r101.getClientInfo();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getFpsInfo() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L7;
        d r101 = r100.get();
        if (r101 == null) goto L7;
        return r101.getFpsInfo();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getLastAudioCaptureLogMap() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L9;
        d r101 = r100.get();
        if (r101 == null) goto L9;
        Map<String, String> r102 = r101.getLastAudioCaptureLogMap();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public Map<String, String> getLastVideoCaptureLogMap() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L9;
        d r101 = r100.get();
        if (r101 == null) goto L9;
        Map<String, String> r102 = r101.getLastVideoCaptureLogMap();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return MapsKt.emptyMap();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d0.a getLiveCoreBuilder() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L9;
        d r101 = r100.get();
        if (r101 == null) goto L9;
        d0 r102 = r101.A();
        if (r102 == null) goto L9;
        return r102.getBuilder();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public JSONObject getLiveCoreDebugInfo() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L9;
        d r101 = r100.get();
        if (r101 == null) goto L9;
        d0 r102 = r101.getLiveCore();
        if (r102 == null) goto L9;
        return r102.c();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getLiveRoomStreamCache() {
        WeakReference<d> r100 = this.liveRoomStreamCache;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getPushLiveStream() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public double getRenderFps() {
        WeakReference<d> r100 = this.pushLiveStream;
        if (r100 == null) goto L11;
        d r101 = r100.get();
        if (r101 == null) goto L11;
        d0 r102 = r101.getLiveCore();
        if (r102 == null) goto L11;
        z r103 = r102.C();
        if (r103 == null) goto L11;
        return r103.a();
    L11:
        return -1.0d;
    }

    public PushStreamService() {
        jc1.k.l(IPushStreamService.class, this);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public void releaseRecordLiveStream() {
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L8;
        LiveStream4Proxy r100 = this.liveStream4Proxy;
        if (r100 == null) goto L7;
        r100.release();
    L7:
        this.liveStream4Proxy = null;
    L8:
        LiveStream4 r101 = this.liveStream;
        if (r101 == null) goto L11;
        r101.release();
    L11:
        this.liveStream = null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d createLiveStreamWithConfig(u r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        LiveStream4 r101 = new LiveStream4(r100);
        d0 r102 = null;
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L16;
        LiveStream4Proxy r103 = new LiveStream4Proxy(r101);
        if (LiveRoomStatesAndAVResourceUtils.a() == false) goto L13;
        WeakReference<d> r104 = this.liveRoomStreamCache;
        if (r104 == null) goto L11;
        d r105 = r104.get();
        if (r105 == null) goto L11;
        r102 = r105.getLiveCore();
    L11:
        if (r102 != null) goto L13;
        this.liveRoomStreamCache = new WeakReference(r103);
    L13:
        this.pushLiveStream = new WeakReference(r103);
        return r103;
    L16:
        if (LiveRoomStatesAndAVResourceUtils.a() == false) goto L24;
        WeakReference<d> r106 = this.liveRoomStreamCache;
        if (r106 == null) goto L22;
        d r107 = r106.get();
        if (r107 == null) goto L22;
        r102 = r107.getLiveCore();
    L22:
        if (r102 != null) goto L24;
        this.liveRoomStreamCache = new WeakReference(r101);
    L24:
        this.pushLiveStream = new WeakReference(r101);
        return r101;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public wv0.a createStreamSignHelper(IRoom r100) {
        return new StreamSignHelper(r100);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public qv0.a getLiveStreamController(Context r100) {
        new com.bytedance.android.live.broadcast.live.newstream.c();
        throw null;
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public d getRecordLiveStream(Context r100) {
        if (this.liveStream != null) goto L5;
    L9:
        u.a r101 = new u.a(r100);
        r101.f89503q = s1.B(R.string.ttlive_stream_project_key);
        r101.f89508v = new vv0.c();
        r101.f89502p = new vv0.d();
        r101.f89500n = 0;
        r101.f89509w = new vv0.e();
        int r102 = r101.f89489c;
        if (r102 != 0) goto L12;
        r102 = 500;
    L12:
        r101.f89489c = r102;
        int r103 = r101.f89490d;
        if (r103 != 0) goto L15;
        r103 = 200;
    L15:
        r101.f89490d = r103;
        int r104 = r101.f89491e;
        if (r104 != 0) goto L18;
        r104 = 800;
    L18:
        r101.f89491e = r104;
        int r105 = r101.f89493g;
        if (r105 != 0) goto L21;
        r105 = 360;
    L21:
        r101.f89493g = r105;
        int r106 = r101.f89494h;
        if (r106 != 0) goto L24;
        r106 = 640;
    L24:
        r101.f89494h = r106;
        int r107 = r101.f89492f;
        if (r107 != 0) goto L27;
        r107 = 15;
    L27:
        r101.f89492f = r107;
        int r108 = r101.f89496j;
        if (r108 != 0) goto L30;
        r108 = 9;
    L30:
        r101.f89496j = r108;
        long r109 = r101.f89497k;
        if (r109 != 0) goto L33;
        r109 = 60000;
    L33:
        r101.f89497k = r109;
        int r110 = r101.f89498l;
        if (r110 != 0) goto L36;
        r110 = 44100;
    L36:
        r101.f89498l = r110;
        int r111 = 1;
        int r112 = 2;
        if (r101.f89499m == 2) goto L40;
        r112 = 1;
    L40:
        r101.f89499m = r112;
        String r113 = "";
        if (TextUtils.isEmpty(r101.f89488b) == false) goto L43;
        String r114 = "";
    L44:
        r101.f89488b = r114;
        int r115 = r101.f89495i;
        if (r115 != 0) goto L47;
        int r116 = 1;
    L48:
        r101.f89495i = r116;
        int r117 = r101.f89500n;
        if (r117 != (-1)) goto L51;
        r117 = 4;
    L51:
        r101.f89500n = r117;
        int r118 = r101.f89501o;
        if (r118 != (-1)) goto L54;
        r118 = 1;
    L54:
        r101.f89501o = r118;
        if ("".equals(r101.f89503q) == false) goto L57;
        String r119 = "live-stream-sdk";
    L58:
        r101.f89503q = r119;
        int r120 = r101.f89505s;
        if (r120 == 0) goto L62;
        r111 = r120;
    L62:
        r101.f89505s = r111;
        float r121 = r101.f89504r;
        if (r121 != 0.0f) goto L65;
        r121 = 2.0f;
    L65:
        r101.f89504r = r121;
        String r122 = r101.f89507u;
        if (r122 != null) goto L68;
        r122 = "";
    L68:
        r101.f89507u = r122;
        String r123 = r101.f89506t;
        if (r123 != null) goto L71;
        r123 = "";
    L71:
        r101.f89506t = r123;
        if (TextUtils.isEmpty(r101.f89510x) == true) goto L75;
        r113 = r101.f89510x;
    L75:
        r101.f89510x = r113;
        LiveStream4 r124 = new LiveStream4(new u(r101));
        this.liveStream = r124;
        this.liveStream4Proxy = new LiveStream4Proxy(r124);
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L78;
        d r125 = this.liveStream4Proxy;
    L80:
        return r125;
    L78:
        r125 = this.liveStream;
        goto L80
    L57:
        r119 = r101.f89503q;
        goto L58
    L47:
        r116 = Math.min(r115, 3);
        goto L48
    L43:
        r114 = r101.f89488b;
        goto L44
    L5:
        if (LiveRoomStatesAndAVResourceUtils.b() == false) goto L7;
        d r126 = this.liveStream4Proxy;
    L8:
        if (r126 == null) goto L9;
        return r126;
    L7:
        r126 = this.liveStream;
        goto L8
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public nv0.a getCameraCaptureInst(SurfaceView r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        return new nv0.b(r100, r101, false);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public com.bytedance.android.live.pushstream.report.a getStreamReporter(IRoom r100, com.bytedance.android.live.pushstream.report.c r101) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "statusResultListener");
        return new com.bytedance.android.live.pushstream.report.d(r100, r101);
    }

    @Override // com.bytedance.android.live.pushstream.IPushStreamService
    public nv0.a getVoiceRoomCameraCaptureInst(SurfaceView r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        Intrinsics.checkNotNullParameter(r101, "liveStream");
        return new nv0.b(r100, r101, true);
    }
}
