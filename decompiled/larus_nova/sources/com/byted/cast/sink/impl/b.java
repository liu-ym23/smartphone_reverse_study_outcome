package com.byted.cast.sink.impl;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.DeviceInfoManager;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.MD5;
import com.byted.cast.common.api.IAudioDataListener;
import com.byted.cast.common.api.ILibraryLoader;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.api.ISinkDataListener;
import com.byted.cast.common.bean.SinkDeviceInfo;
import com.byted.cast.common.bean.SourceDeviceInfo;
import com.byted.cast.common.bean.chromecast.MessageBean;
import com.byted.cast.common.sink.ISourceDeviceInfoListener;
import com.byted.cast.common.utils.GsonUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.sdk.IRTCEngineEventListener;
import com.byted.cast.sdk.RTCEngine;
import com.byted.cast.sdk.RTCSetting;
import com.byted.cast.sdk.RTCStatistics;
import com.byted.cast.sdk.utils.Utils;
import com.byted.cast.sdk.view.IRenderView;
import com.byted.cast.sdk.view.SurfaceRenderView;
import com.byted.cast.sdk.view.VideoGLSurfaceView;
import com.byted.cast.sink.api.CastInfo;
import com.byted.cast.sink.api.ClientInfo;
import com.byted.cast.sink.api.IOnLogMonitor;
import com.byted.cast.sink.api.IPreemptListener;
import com.byted.cast.sink.api.IServerListener;
import com.byted.cast.sink.api.ServerInfo;
import com.byted.cast.sink.api.multiple.IMultipleActiveControl;
import com.byted.cast.sink.api.multiple.IMultipleLoader;
import com.byted.cast.sink.api.multiple.IMultipleReverseControl;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class b {
    private String A;
    private String B;
    private boolean C;
    private boolean D;
    private ContextManager.CastContext E;
    private CastLogger F;
    private String G;
    private ISourceDeviceInfoListener H;
    private IMultipleLoader I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private IMultipleActiveControl f33837J;
    private IRTCEngineEventListener K;
    private IRenderView.IRenderCallback L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f33838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f33839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Point f33841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RTCEngine f33842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RTCSetting f33843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IServerListener f33844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private IMultipleReverseControl f33845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IOnLogMonitor f33846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private IPreemptListener f33847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f33848k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f33849l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f33850m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f33851n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f33852o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private ConcurrentSkipListMap<String, ClientInfo> f33853p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, CastInfo> f33854q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<String, IRenderView> f33855r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map<String, ViewGroup> f33856s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f33857t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Handler f33858u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f33859v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f33860w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f33861x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f33862y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f33863z;

    public class a implements IMultipleLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33864a;

        public a(b r100) {
            this.f33864a = r100;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadAudio(String r100, Context r101, FrameLayout r102) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadMirror(String r100, Context r101, FrameLayout r110) {
            b.a(this.f33864a).i("ByteLinkSinkImpl", "loadMirror " + r100 + ", gitInfo:1.c8f9ae2");
            Iterator r102 = b.b(this.f33864a).keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            String r103 = (String) r102.next();
            CastInfo r104 = (CastInfo) b.b(this.f33864a).get(r103);
            b.a(this.f33864a).i("ByteLinkSinkImpl", "mUserCastMap " + r104.clientID);
            if (r104.clientID != r100) goto L4;
            b.l(this.f33864a).put(r100, r110);
            b.a(this.f33864a, r101, r103, r110);
            goto L4
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadPhoto(String r100, Context r101, FrameLayout r102) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleLoader
        public void loadVideo(String r100, Context r101, FrameLayout r102) {
        }
    }

    /* JADX INFO: renamed from: com.byted.cast.sink.impl.b$b, reason: collision with other inner class name */
    public class C0676b implements IMultipleActiveControl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33865a;

        public C0676b(b r100) {
            this.f33865a = r100;
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleActiveControl
        public float getPlayerVolume(String r100) {
            return 0.0f;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void pause(String r100) {
        }

        @Override // com.byted.cast.sink.api.multiple.IMultipleActiveControl
        public void setPlayerVolume(String r100, float r101) {
            b.b(this.f33865a).size();
            Iterator r102 = b.b(this.f33865a).entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L12;
            Map.Entry r103 = (Map.Entry) r102.next();
            String r104 = ((CastInfo) r103.getValue()).clientID;
            if (((CastInfo) r103.getValue()).clientID.equals(r100) == false) goto L4;
            String r105 = (String) r103.getKey();
            b.r(this.f33865a).setPlayerVolume(r105, r101);
            return;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void start(String r100) {
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void stop(String r100, boolean r101) {
            b.a(this.f33865a).i("ByteLinkSinkImpl", "stop from user, clientId:" + r100 + ", paramBoolean:" + r101);
            Iterator r102 = b.q(this.f33865a).keySet().iterator();
            ClientInfo r103 = null;
        L4:
            if (r102.hasNext() == false) goto L7;
            r103 = (ClientInfo) b.q(this.f33865a).get((String) r102.next());
            if (r103.clientID != r100) goto L4;
        L7:
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.clientID != r100) goto L17;
            b.a(this.f33865a, r103, true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
            return;
        }

        @Override // com.byted.cast.sink.api.IActiveControl
        public void updateVolume(String r100) {
        }
    }

    public class c implements IRTCEngineEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33866a;

        public c(b r100) {
            this.f33866a = r100;
        }

        private /* synthetic */ void a() {
            b.k(this.f33866a).onSuccess(DeviceInfoManager.getInstance().getSourceDeviceInfo());
        }

        private static /* synthetic */ void a(IRenderView r100, int r101, int r102) {
            r100.setVideoSize(r101, r102);
        }

        private /* synthetic */ void a(CastInfo r100) {
            if (b.s(this.f33866a) == null) goto L6;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCast start, castInfo:" + r100);
            CastInfo r101 = new CastInfo(r100);
            r101.infoType = 100;
            b.s(this.f33866a).onCast(3, r101);
            CastInfo r102 = new CastInfo(r100);
            r102.infoType = 101;
            b.s(this.f33866a).onCast(3, r102);
            return;
        }

        private /* synthetic */ void a(ClientInfo r100, String r101) {
            ViewGroup r102 = (ViewGroup) b.l(this.f33866a).get(r100.clientID);
            if (r102 == null) goto L6;
            ((IRenderView) b.n(this.f33866a).get(r101)).removeRenderCallback(b.o(this.f33866a));
            b.n(this.f33866a).remove(r101);
            r102.removeAllViews();
            b.l(this.f33866a).remove(r100.clientID);
            r102.setKeepScreenOn(false);
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onIntoBackground, container.removeAllViews");
            return;
        }

        public static /* synthetic */ void a(c r100) {
            r100.a();
        }

        private /* synthetic */ void b(CastInfo r100) {
            if (b.s(this.f33866a) == null) goto L6;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCast pause, castInfo:" + r100);
            CastInfo r101 = new CastInfo(r100);
            r101.infoType = 104;
            b.s(this.f33866a).onCast(3, r101);
            return;
        }

        public static /* synthetic */ void b(c r100, ClientInfo r101, String r102) {
            r100.a(r101, r102);
        }

        private /* synthetic */ void c(CastInfo r100) {
            if (b.s(this.f33866a) == null) goto L6;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCast resume, castInfo:" + r100);
            CastInfo r101 = new CastInfo(r100);
            r101.infoType = 105;
            b.s(this.f33866a).onCast(3, r101);
            return;
        }

        public static /* synthetic */ void c(c r100, CastInfo r101) {
            r100.b(r101);
        }

        public static /* synthetic */ void d(c r100, CastInfo r101) {
            r100.c(r101);
        }

        public static /* synthetic */ void e(IRenderView r100, int r101, int r102) {
            a(r100, r101, r102);
        }

        public static /* synthetic */ void f(c r100, CastInfo r101) {
            r100.a(r101);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void OnVideoSizeChanged(String r100, final int r101, final int r102, int r103) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "OnVideoSizeChanged: userId=" + r100 + " width=" + r101 + " height" + r102 + " rotation=" + r103);
            final IRenderView r104 = (IRenderView) b.n(this.f33866a).get(r100);
            if (r104 == null) goto L5;
            b.u(this.f33866a).post(new f(r104, r101, r102));
        L7:
            if (b.s(this.f33866a) == null) goto L13;
            CastInfo r105 = (CastInfo) b.b(this.f33866a).get(r100);
            if (r105 == null) goto L11;
            r105.infoType = 103;
            CastInfo.SizeInfo r106 = new CastInfo.SizeInfo();
            r105.sizeInfo = r106;
            r106.width = r101;
            r106.height = r102;
            r105.rotation = r103;
            b.s(this.f33866a).onCast(3, r105);
            return;
        L11:
            b.a(this.f33866a).e("ByteLinkSinkImpl", "OnVideoSizeChanged");
            return;
        L13:
            return;
        L5:
            b.a(this.f33866a).e("ByteLinkSinkImpl", "OnVideoSizeChanged: error");
            goto L7
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onAudioSetVolume(String r100, float r101, float r102) {
            if (b.m(this.f33866a) == null) goto L6;
            ClientInfo r103 = (ClientInfo) b.q(this.f33866a).get(r100);
            b.m(this.f33866a).setVolume(r103.clientID, (int) (r101 * 100.0f));
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onAudioSetVolume");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCancelRequest(String r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCancelRequest " + r100 + ", gitInfo:1.c8f9ae2");
            ClientInfo r101 = (ClientInfo) b.q(this.f33866a).get(r100);
            if (r101 != null) goto L6;
            b.a(this.f33866a).e("ByteLinkSinkImpl", "onCancelRequest " + r100 + " has been already disconnected?");
            return;
        L6:
            b.a(this.f33866a, r101, false, RTCEngine.ExitReason.REASON_DISCONNECT, false);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCancelSuccess() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastControl(int r100, int r101) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastPortSet(int r100, int r101, int r102, int r103) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCastPortSet: videoChan=" + r100 + " videoPort=" + r101 + " audioChan=" + r102 + " audioPort=" + r103);
            if (b.s(this.f33866a) != null) goto L5;
            return;
        L5:
            b r104 = this.f33866a;
            b.a(r104, CastInfo.INFO_CAST_PORT_SET, r101, b.a(r104, r100, r101, r102, r103));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastPortUnSet(int r100, int r101, int r102, int r103) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCastPortUnSet: videoChan=" + r100 + " videoPort=" + r101 + " audioChan=" + r102 + " audioPort=" + r103);
            if (b.s(this.f33866a) != null) goto L5;
            return;
        L5:
            b r104 = this.f33866a;
            b.a(r104, CastInfo.INFO_CAST_PORT_UNSET, r101, b.a(r104, r100, r101, r102, r103));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public boolean onCastRequest(String r100, String r101) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onCastRequest " + r100 + ", gitInfo:1.c8f9ae2");
            ClientInfo r102 = (ClientInfo) b.q(this.f33866a).get(r100);
            if (r102 != null) goto L8;
            CastLogger r103 = b.a(this.f33866a);
            StringBuilder r104 = new StringBuilder();
            r104.append(r100);
            String r105 = " has not been connected?";
        L5:
            r104.append(r105);
            r103.e("ByteLinkSinkImpl", r104.toString());
            return false;
        L8:
            if (b.b(this.f33866a).get(r100) == null) goto L10;
            r103 = b.a(this.f33866a);
            r104 = new StringBuilder();
            r104.append(r100);
            r105 = " has already casted";
            goto L5
        L10:
            final CastInfo r106 = new CastInfo();
            r106.clientID = r102.clientID;
            r106.token = r101;
            r106.castType = 2;
            r106.audioSessionId = b.r(this.f33866a).getAudioSessionId(r100);
            r106.rotation = 1;
            r106.mimeType = 102;
            b.b(this.f33866a).put(r100, r106);
            b.u(this.f33866a).postDelayed(new i(this, r106), 200);
            return true;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onCastSuccess() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnect(String r100, String r101) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onConnect " + r100 + ", gitInfo:1.c8f9ae2");
            if (b.q(this.f33866a).get(r100) == null) goto L6;
            b.a(this.f33866a).e("ByteLinkSinkImpl", r100 + " has been already connected?");
            return;
        L6:
            ClientInfo r102 = new ClientInfo();
            r102.f33826ip = r100;
            r102.name = r101;
            r102.clientID = b.a(this.f33866a, r100);
            b.q(this.f33866a).put(r100, r102);
            if (b.s(this.f33866a) == null) goto L12;
            b.s(this.f33866a).onConnect(3, r102);
            if (b.i(this.f33866a) == null) goto L12;
            b.i(this.f33866a).onPreempt(r102);
        L12:
            if (TextUtils.equals("bytelink-remote-mirror", r100) == false) goto L14;
            return;
        L14:
            if (b.d(this.f33866a) == false) goto L18;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onConnect: leave RTC room when bytelink connection established");
            b.j(this.f33866a);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnectStateChanged(RTCEngine.ConnectState r100) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onConnectSuccess(int r100, int r101, int r102) {
            if (b.s(this.f33866a) == null) goto L6;
            ClientInfo r103 = new ClientInfo();
            r103.name = "ReverseConnection";
            r103.clientID = "ReverseConnection";
            r103.f33826ip = "ReverseConnection";
            r103.sourceType = 101;
            b.s(this.f33866a).onConnect(3, r103);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onDisconnect(RTCEngine.ExitReason r100, String r101) {
            if (b.s(this.f33866a) == null) goto L6;
            ClientInfo r102 = new ClientInfo();
            r102.name = "ReverseConnection";
            r102.clientID = "ReverseConnection";
            r102.f33826ip = "ReverseConnection";
            r102.sourceType = 101;
            b.s(this.f33866a).onDisconnect(3, r102);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onDisconnect(String r100, RTCEngine.ExitReason r101, String r102) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onDisconnect " + r100 + ", reason:" + r101 + ", message:" + r102 + ", gitInfo:1.c8f9ae2");
            ClientInfo r103 = (ClientInfo) b.q(this.f33866a).get(r100);
            if (r103 == null) goto L5;
            b.a(this.f33866a, r103, false, r101, true);
            if (b.d(this.f33866a) == true) goto L14;
            return;
        L14:
            if (r101 == RTCEngine.ExitReason.REASON_DISCONNECT) goto L20;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onDisconnect: join RTC room when bytelink connection lost");
            b.r(this.f33866a).sinkInitAndJoinRoom(b.e(this.f33866a), b.f(this.f33866a), b.g(this.f33866a), b.h(this.f33866a));
            return;
        L20:
            return;
        L5:
            if (TextUtils.equals("bytelink-remote-mirror", r100) == false) goto L9;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onDisconnect: fail to join rtc room");
            ClientInfo r104 = new ClientInfo();
            r104.f33826ip = r100;
            r104.name = r100;
            r104.clientID = b.a(this.f33866a, r100);
            if (b.s(this.f33866a) == null) goto L17;
            b.s(this.f33866a).onDisconnect(3, r104);
            return;
        L17:
            return;
        L9:
            b.a(this.f33866a).e("ByteLinkSinkImpl", r100 + " has been already disconnected?");
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onError(int r100, String r101) {
            b.a(this.f33866a).e("ByteLinkSinkImpl", "onError: code=" + r100 + ", description=" + r101);
            if (b.s(this.f33866a) == null) goto L6;
            b.s(this.f33866a).onError(3, 1000, r100, r101);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onFirstVideoFrame(String r100) {
            if (b.s(this.f33866a) == null) goto L5;
            b.s(this.f33866a).onFirstVideoFrame(r100);
        L5:
            CastInfo r101 = (CastInfo) b.b(this.f33866a).get(r100);
            if (r101 == null) goto L11;
            r101.infoType = 108;
            if (b.s(this.f33866a) == null) goto L12;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onFirstVideoFrame, onCastSuccess:" + r101);
            b.s(this.f33866a).onCast(3, r101);
            return;
        L12:
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onInfo(int r100, int r101, String r102) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onInfo: what=" + r100 + " arg1=" + r101 + " arg2=" + r102);
            if (b.s(this.f33866a) != null) goto L6;
            return;
        L6:
            if (r100 != 400003) goto L10;
            b r103 = this.f33866a;
            int r104 = CastInfo.INFO_SET_BITRATE_KPS;
            if (r102 == null) goto L12;
        L13:
            b.a(r103, r104, r101, r102);
            return;
        L12:
            r102 = "";
            goto L13
        L10:
            r104 = r100;
            r103 = this.f33866a;
            if (r102 != null) goto L13;
            goto L12
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onIntoBackground(final String r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onIntoBackground, userId:" + r100);
            final ClientInfo r101 = (ClientInfo) b.q(this.f33866a).get(r100);
            if (r101 != null) goto L6;
            b.a(this.f33866a).e("ByteLinkSinkImpl", r100 + " has not been connected?");
            return;
        L6:
            CastInfo r102 = (CastInfo) b.b(this.f33866a).get(r100);
            final CastInfo r103 = new CastInfo();
            r103.clientID = r101.clientID;
            if (r102 == null) goto L9;
            r103.token = r102.token;
        L9:
            r103.castType = 2;
            r103.audioSessionId = b.r(this.f33866a).getAudioSessionId(r100);
            r103.rotation = 1;
            r103.mimeType = 102;
            b.u(this.f33866a).post(new g(this, r103));
            b.u(this.f33866a).post(new h(this, r101, r100));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onIntoForeground(String r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onIntoForeground, userId:" + r100);
            ClientInfo r101 = (ClientInfo) b.q(this.f33866a).get(r100);
            if (r101 != null) goto L6;
            b.a(this.f33866a).e("ByteLinkSinkImpl", r100 + " has not been connected?");
            return;
        L6:
            CastInfo r102 = (CastInfo) b.b(this.f33866a).get(r100);
            final CastInfo r103 = new CastInfo();
            r103.clientID = r101.clientID;
            if (r102 == null) goto L9;
            r103.token = r102.token;
        L9:
            r103.castType = 2;
            r103.audioSessionId = b.r(this.f33866a).getAudioSessionId(r100);
            r103.rotation = 1;
            r103.mimeType = 102;
            b.u(this.f33866a).post(new j(this, r103));
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onKilled() {
            b.a(this.f33866a).w("ByteLinkSinkImpl", "sink mirror is killed");
            b.t(this.f33866a);
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onLogMonitor(String r100, String[][] r101) {
            if (b.c(this.f33866a) == null) goto L6;
            b.c(this.f33866a).onLogMonitor(r100, r101);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onMonitorEvent(String r100, String r101) {
            if (b.s(this.f33866a) == null) goto L6;
            b.s(this.f33866a).onMonitorEvent(r100, r101);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onPaused() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onRecvMetaData(String r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onRecvMetaData, json:" + r100);
            if (b.s(this.f33866a) == null) goto L6;
            ClientInfo r101 = new ClientInfo();
            r101.name = "ReverseConnection";
            r101.clientID = "ReverseConnection";
            r101.f33826ip = "ReverseConnection";
            r101.sourceType = 102;
            b.s(this.f33866a).onRecvMetaData(1, r101, r100);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onRecvMetaData(String r100, String r110) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onRecvMetaData, userId:" + r100 + ", json:" + r110);
            MessageBean r101 = (MessageBean) GsonUtils.fromJsonIgnoreException(r110, MessageBean.class);
            if (r101 == null) goto L22;
            int r102 = r101.type;
            if (r102 == 1) goto L8;
            if (r102 != 2) goto L22;
        L8:
            SourceDeviceInfo r103 = (SourceDeviceInfo) GsonUtils.fromJsonIgnoreException(r101.content, SourceDeviceInfo.class);
            Iterator r104 = b.q(this.f33866a).keySet().iterator();
        L10:
            if (r104.hasNext() == false) goto L16;
            String r105 = (String) r104.next();
            if (TextUtils.isEmpty(r105) == true) goto L10;
            if (r105.contains(r100) == false) goto L10;
            b.a(this.f33866a).i("ByteLinkSinkImpl", "saveSourceDeviceInfo key:".concat(r105));
            DeviceInfoManager.getInstance().saveSourceDeviceInfo(r105, r103);
        L16:
            this.f33866a.a(r100, GsonUtils.toJsonIgnoreException(new MessageBean(r101.type, r101.f33709id, GsonUtils.toJsonIgnoreException((SinkDeviceInfo) DeviceInfoManager.getInstance().getLocalDeviceInfo()))));
            if (r101.type != 2) goto L22;
            if (b.k(this.f33866a) == null) goto L22;
            Dispatcher.getInstance().runOnMainThread(new e(this));
        L22:
            if (b.s(this.f33866a) == null) goto L26;
            ClientInfo r106 = (ClientInfo) b.q(this.f33866a).get(r100);
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onRecvMetaData: " + r106);
            if (r106 == null) goto L34;
            b.s(this.f33866a).onRecvMetaData(1, r106, r110);
            return;
        L34:
            return;
        L26:
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onRecvMetaData: No mServerListener");
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onResumed() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onServerStart(int r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onServerStart: port=" + r100);
            if (b.s(this.f33866a) == null) goto L6;
            b.a(this.f33866a, CastInfo.INFO_SERVER_START, r100, "");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onServerStop(int r100) {
            b.a(this.f33866a).i("ByteLinkSinkImpl", "onServerStop: port=" + r100);
            if (b.s(this.f33866a) == null) goto L6;
            b.a(this.f33866a, CastInfo.INFO_SERVER_STOP, r100, "");
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onSinkLatencyStat(String r100, String r101) {
            if (b.s(this.f33866a) == null) goto L6;
            b.s(this.f33866a).onSinkLatencyStat(3, r100, r101);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onSinkStuckStat(String r100, String r101) {
            if (b.s(this.f33866a) == null) goto L6;
            b.s(this.f33866a).onSinkStuckStat(3, r100, r101);
            return;
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStat(String r100) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStopped() {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onStuckStat(String r100) {
        }

        @Override // com.byted.cast.sdk.IRTCEngineEventListener
        public void onVideoEncoder(String r100, int r101, int r102, int r103, int r104, boolean r105, int r106) {
        }
    }

    public class d implements IRenderView.IRenderCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f33867a;

        public d(b r100) {
            this.f33867a = r100;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceChanged(IRenderView.ISurfaceHolder r100, int r101, int r102, int r103) {
            b.a(this.f33867a).i("ByteLinkSinkImpl", "onSurfaceChanged: w=" + r102 + " h=" + r103);
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceCreated(IRenderView.ISurfaceHolder r100, int r101, int r102) {
            b.a(this.f33867a).i("ByteLinkSinkImpl", "onSurfaceCreated");
            Iterator r103 = b.n(this.f33867a).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L20;
            Map.Entry r104 = (Map.Entry) r103.next();
            IRenderView r105 = (IRenderView) r104.getValue();
            String r106 = (String) r104.getKey();
            if (r105 == null) goto L4;
            if (r100.getRenderView() != r105) goto L4;
            if (r100.getSurfaceHolder() == null) goto L19;
            Surface r107 = r100.getSurfaceHolder().getSurface();
            b.r(this.f33867a).setVideoSurface(r106, r107);
            return;
        L19:
            return;
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceDestroyed(IRenderView.ISurfaceHolder r100) {
            b.a(this.f33867a).i("ByteLinkSinkImpl", "onSurfaceDestroyed");
        }

        @Override // com.byted.cast.sdk.view.IRenderView.IRenderCallback
        public void onSurfaceTextureCreated(IRenderView r100, Surface r101) {
            Iterator r102 = b.n(this.f33867a).keySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L20;
            String r103 = (String) r102.next();
            IRenderView r104 = (IRenderView) b.n(this.f33867a).get(r103);
            if (r104 == null) goto L4;
            if (r100 != r104) goto L4;
            if (b.p(this.f33867a).getAVSyncType() != RTCSetting.AVSYNC_TYPE.SYNC_NORMAL) goto L11;
            CastLogger r105 = b.a(this.f33867a);
            String r106 = "setSurface: SYNC_NORMAL";
        L12:
            r105.i("ByteLinkSinkImpl", r106);
            b.r(this.f33867a).setVideoSurface(r103, r101);
            return;
        L11:
            r105 = b.a(this.f33867a);
            r106 = "setSurface: SYNC_LOW_LATENCY";
            goto L12
        }
    }

    public b(ContextManager.CastContext r100) {
        this.f33841d = new Point();
        this.f33852o = false;
        this.f33853p = new ConcurrentSkipListMap();
        this.f33854q = new HashMap();
        this.f33855r = new HashMap();
        this.f33856s = new HashMap();
        this.f33857t = 0;
        this.f33859v = 5001;
        this.f33860w = false;
        this.f33861x = 0;
        this.D = false;
        this.I = new a(this);
        this.f33837J = new C0676b(this);
        this.K = new c(this);
        this.L = new d(this);
        this.E = r100;
        this.F = ContextManager.getLogger(r100);
        g();
    }

    public static /* synthetic */ CastLogger a(b r100) {
        return r100.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.byted.cast.sink.impl.b] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, com.byted.cast.sdk.view.IRenderView] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.widget.FrameLayout, java.lang.Object] */
    private IRenderView a(Context r100, String r101, FrameLayout r102) {
        this.F.i("ByteLinkSinkImpl", "createRenderView: userId=" + r101 + " container=" + r102);
        int r103 = this.f33857t;
        if (r103 == 0) goto L7;
        if (r103 == 1) goto L6;
        ?? r104 = 0;
    L9:
        a(r101, r104);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, -1);
        r105.gravity = 17;
        r102.addView(r104, r105);
        r102.setKeepScreenOn(true);
        return r104;
    L6:
        SurfaceView r106 = new VideoGLSurfaceView(r100);
    L8:
        r104 = r106;
        goto L9
    L7:
        this.F.i("ByteLinkSinkImpl", "new SurfaceRenderView:");
        r106 = new SurfaceRenderView(r100, this.E);
        goto L8
    }

    public static /* synthetic */ IRenderView a(b r100, Context r101, String r102, FrameLayout r103) {
        return r100.a(r101, r102, r103);
    }

    private String a(int r100, int r101, int r102, int r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L4
        r104.put("videoChan", r100);     // Catch: JSONException -> L4
        r104.put("videoPort", r101);     // Catch: JSONException -> L4
        r104.put("audioChan", r102);     // Catch: JSONException -> L4
        r104.put("audioPort", r103);     // Catch: JSONException -> L4
        return r104.toString();
    L4:
        e = move-exception;
        this.F.w("ByteLinkSinkImpl", "buildPortJson, json error:" + e);
        return "";
    }

    public static /* synthetic */ String a(b r100, int r101, int r102, int r103, int r104) {
        return r100.a(r101, r102, r103, r104);
    }

    public static /* synthetic */ String a(b r100, String r101) {
        return r100.a(r101);
    }

    private String a(String r100) {
        return r100 + "_" + MD5.hexdigest(r100 + System.currentTimeMillis());
    }

    private void a(int r100, int r101, String r102) {
        CastInfo r103 = new CastInfo();
        r103.infoType = 109;
        r103.infoData = new CastInfo.InfoData(r100, r101, r102);
        CastInfo r104 = b();
        String r105 = "";
        if (r104 == null) goto L7;
        String r106 = r104.clientID;
        if (r106 == null) goto L7;
    L8:
        r103.clientID = r106;
        if (r104 == null) goto L13;
        String r107 = r104.token;
        if (r107 == null) goto L13;
        r105 = r107;
    L13:
        r103.token = r105;
        this.F.i("ByteLinkSinkImpl", "dispatchInfoCast: " + r103.infoData + " clientID=" + r103.clientID);
        this.f33844g.onCast(3, r103);
        return;
    L7:
        r106 = "";
        goto L8
    }

    private /* synthetic */ void a(CastInfo r100, String r101) {
        ViewGroup r102 = this.f33856s.get(r100.clientID);
        if (r102 == null) goto L6;
        this.f33855r.get(r101).removeRenderCallback(this.L);
        this.f33855r.remove(r101);
        r102.removeView((SurfaceView) this.f33855r.get(r101));
        this.f33856s.remove(r100.clientID);
        r102.setKeepScreenOn(false);
        this.F.i("ByteLinkSinkImpl", "kickOutSource, container.removeAllViews");
        return;
    }

    private /* synthetic */ void a(ClientInfo r100, String r101) {
        ViewGroup r102 = this.f33856s.get(r100.clientID);
        if (r102 == null) goto L6;
        this.f33855r.get(r101).removeRenderCallback(this.L);
        this.f33855r.remove(r101);
        this.f33856s.remove(r100.clientID);
        r102.setKeepScreenOn(false);
        return;
    }

    private void a(ClientInfo r100, boolean r110, RTCEngine.ExitReason r111, boolean r112) {
        this.F.i("ByteLinkSinkImpl", "kickOutSource, active:" + r110 + ", reason:" + r111 + ", disconnect:" + r112 + "," + r100);
        if (r100 == null) goto L34;
        String r101 = r100.f33826ip;
        if (r101 == null) goto L37;
        final String r102 = r101.replace(HTTP.URL_DEFAULT, "");
        final CastInfo r103 = this.f33854q.get(r102);
        if (r103 == null) goto L27;
        r103.infoType = 102;
        if (r110 == false) goto L16;
        r103.stopInfo = new CastInfo.StopInfo(1, 101);
        if (this.f33844g == null) goto L26;
        CastLogger r113 = this.F;
        StringBuilder r104 = new StringBuilder("kickOutSource, onCast stop:");
    L14:
        r104.append(r103);
        r113.i("ByteLinkSinkImpl", r104.toString());
        this.f33844g.onCast(3, r103);
    L26:
        this.f33858u.post(new com.byted.cast.sink.impl.c(this, r103, r102));
        this.f33854q.remove(r102);
        goto L27
    L16:
        if (r111 != RTCEngine.ExitReason.REASON_DISCONNECT) goto L18;
    L22:
        if (r112 == true) goto L26;
        r103.stopInfo = new CastInfo.StopInfo(1, 102);
        if (this.f33844g == null) goto L26;
        r113 = this.F;
        r104 = new StringBuilder("kickOutSource, onCast stop:");
        goto L14
    L18:
        if (r111 == RTCEngine.ExitReason.REASON_KICK_OUT) goto L22;
        r103.stopInfo = new CastInfo.StopInfo(3, 104);
        if (this.f33844g == null) goto L26;
        r113 = this.F;
        r104 = new StringBuilder("kickOutSource, onCast stop:");
    L27:
        if (r110 == false) goto L29;
        this.f33842e.kickOutSource(r102);
    L29:
        if (r112 == false) goto L35;
        this.f33853p.remove(r102);
        IServerListener r114 = this.f33844g;
        if (r114 == null) goto L36;
        r114.onDisconnect(3, r100);
        return;
    L36:
        return;
    L35:
        return;
    L37:
        return;
    }

    public static /* synthetic */ void a(b r100, int r101, int r102, String r103) {
        r100.a(r101, r102, r103);
    }

    public static /* synthetic */ void a(b r100, ClientInfo r101, String r102) {
        r100.a(r101, r102);
    }

    public static /* synthetic */ void a(b r100, ClientInfo r101, boolean r102, RTCEngine.ExitReason r103, boolean r104) {
        r100.a(r101, r102, r103, r104);
    }

    private void a(String r100, Surface r101) {
        Objects.toString(r101);
        this.f33854q.size();
        Iterator<Map.Entry<String, CastInfo>> r102 = this.f33854q.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, CastInfo> r103 = r102.next();
        String r104 = r103.getValue().clientID;
        if (r103.getValue().clientID.equals(r100) == false) goto L4;
        String r105 = r103.getKey();
        this.f33842e.setVideoSurface(r105, r101);
        return;
    }

    private void a(String r100, IRenderView r101) {
        this.F.i("ByteLinkSinkImpl", "setRenderView: userId=" + r100 + " renderView=" + r101);
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f33855r.get(r100) == null) goto L8;
        this.f33855r.get(r100).removeRenderCallback(this.L);
    L8:
        this.f33855r.put(r100, r101);
        this.F.i("ByteLinkSinkImpl", "addRenderCallback:" + this.L);
        this.f33855r.get(r100).addRenderCallback(this.L);
    }

    private CastInfo b() {
        if (this.f33854q.isEmpty() == false) goto L5;
        return null;
    L5:
        Iterator<CastInfo> r100 = this.f33854q.values().iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        CastInfo r101 = r100.next();
        if (r101 == null) goto L7;
        return r101;
    L11:
        return null;
    }

    public static /* synthetic */ Map b(b r100) {
        return r100.f33854q;
    }

    public static /* synthetic */ void b(b r100, CastInfo r101, String r102) {
        r100.a(r101, r102);
    }

    public static /* synthetic */ IOnLogMonitor c(b r100) {
        return r100.f33846i;
    }

    public static /* synthetic */ boolean d(b r100) {
        return r100.C;
    }

    public static /* synthetic */ String e(b r100) {
        return r100.A;
    }

    private boolean e(int r100) {
        RTCSetting r101 = this.f33843f;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 == 7) goto L19;
        if (r100 == 0) goto L18;
        if (r100 != 1) goto L10;
        RTCSetting.TRANS_TYPE r102 = RTCSetting.TRANS_TYPE.TCP;
    L20:
        r101.setVideoTransType(r102);
        return true;
    L10:
        if (r100 != 2) goto L12;
        r102 = RTCSetting.TRANS_TYPE.DART;
        goto L20
    L12:
        if (r100 != 3) goto L14;
        r102 = RTCSetting.TRANS_TYPE.LLAMA;
        goto L20
    L14:
        return false;
    L18:
        r102 = RTCSetting.TRANS_TYPE.UDP;
        goto L20
    L19:
        r102 = RTCSetting.TRANS_TYPE.MOQ;
        goto L20
    }

    public static /* synthetic */ String f(b r100) {
        return r100.B;
    }

    public static /* synthetic */ String g(b r100) {
        return r100.f33862y;
    }

    private void g() {
        RTCSetting r100 = new RTCSetting(this.E);
        this.f33843f = r100;
        r100.setDecodeType(RTCSetting.DECODE_TYPE.DECODE_TYPE_HW);
        this.f33843f.setAVSyncType(RTCSetting.AVSYNC_TYPE.SYNC_LOW_LATENCY);
        this.f33843f.setPort(this.f33859v);
        int r101 = Utils.getArch();
        float r102 = Utils.getOSVersionF();
        this.F.i("ByteLinkSinkImpl", "initConfig, cpuarch:" + r101 + ", osVersionF:" + r102);
        this.F.i("ByteLinkSinkImpl", "initConfig, disable native video decoder!");
        this.f33843f.setEnableVideoNativeDecode(false);
    }

    public static /* synthetic */ String h(b r100) {
        return r100.f33863z;
    }

    private void h() {
        Iterator<Map.Entry<String, ClientInfo>> r100 = this.f33853p.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        Map.Entry<String, ClientInfo> r101 = r100.next();
        if ("bytelink-remote-mirror".equals(r101.getKey()) == true) goto L4;
        a(r101.getValue(), true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
        goto L4
    }

    public static /* synthetic */ IPreemptListener i(b r100) {
        return r100.f33847j;
    }

    private void j() {
        Iterator<String> r100 = this.f33853p.keySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L16;
        final String r101 = r100.next();
        this.F.i("ByteLinkSinkImpl", "stopRemoteMirror cur userId=" + r101);
        if ("bytelink-remote-mirror".equals(r101) == false) goto L4;
        final ClientInfo r102 = this.f33853p.get(r101);
        CastInfo r103 = this.f33854q.get(r101);
        if (r103 == null) goto L13;
        r103.infoType = 102;
        r103.stopInfo = new CastInfo.StopInfo(1, 101);
        if (this.f33844g == null) goto L13;
        this.F.i("ByteLinkSinkImpl", "kickOutSources, onCast stop:" + r103);
        this.f33844g.onCast(3, r103);
    L13:
        this.f33842e.kickOutSource(r101);
        this.f33853p.remove(r101);
        this.f33854q.remove(r101);
        this.f33858u.post(new com.byted.cast.sink.impl.d(this, r102, r101));
        IServerListener r104 = this.f33844g;
        if (r104 == null) goto L4;
        r104.onDisconnect(3, r102);
        goto L4
    }

    public static /* synthetic */ void j(b r100) {
        r100.j();
    }

    public static /* synthetic */ ISourceDeviceInfoListener k(b r100) {
        return r100.H;
    }

    public static /* synthetic */ Map l(b r100) {
        return r100.f33856s;
    }

    public static /* synthetic */ IMultipleReverseControl m(b r100) {
        return r100.f33845h;
    }

    public static /* synthetic */ Map n(b r100) {
        return r100.f33855r;
    }

    public static /* synthetic */ IRenderView.IRenderCallback o(b r100) {
        return r100.L;
    }

    public static /* synthetic */ RTCSetting p(b r100) {
        return r100.f33843f;
    }

    public static /* synthetic */ ConcurrentSkipListMap q(b r100) {
        return r100.f33853p;
    }

    public static /* synthetic */ RTCEngine r(b r100) {
        return r100.f33842e;
    }

    public static /* synthetic */ IServerListener s(b r100) {
        return r100.f33844g;
    }

    public static /* synthetic */ void t(b r100) {
        r100.h();
    }

    public static /* synthetic */ Handler u(b r100) {
        return r100.f33858u;
    }

    public Object a(int r100, Object... r101) {
        if (r100 == 32) goto L6;
        return null;
    L6:
        return "7.30.1.12";
    }

    public void a() {
        k();
        h();
        RTCEngine r100 = this.f33842e;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        RTCEngine.deinit(this.E);
        Handler r101 = this.f33858u;
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);
        this.f33858u = null;
    L8:
        this.f33838a = null;
    }

    public void a(int r100) {
        if (r100 != 0) goto L4;
        RTCSetting r101 = this.f33843f;
        RTCSetting.AVSYNC_TYPE r102 = RTCSetting.AVSYNC_TYPE.SYNC_LOW_LATENCY;
    L8:
        r101.setAVSyncType(r102);
        return;
    L4:
        if (r100 != 1) goto L10;
        r101 = this.f33843f;
        r102 = RTCSetting.AVSYNC_TYPE.SYNC_NORMAL;
        goto L8
    }

    public void a(int r100, int r101) {
        RTCEngine r102 = this.f33842e;
        if (r102 == null) goto L6;
        r102.dumpMediaData(r100, r101);
        return;
    }

    public void a(Application r100) {
        RTCEngine r101 = this.f33842e;
        if (r101 == null) goto L6;
        r101.setApplication(r100);
        return;
    }

    public void a(Context r100, String r101) {
        a(r100, r101, true);
    }

    public void a(Context r110, String r210, boolean r211) {
        this.f33838a = r110;
        this.G = r210;
        Point r100 = Utils.getScreenSize(r110);
        this.f33858u = new Handler(Looper.getMainLooper());
        this.F.i("ByteLinkSinkImpl", "initialize, orig display, x:" + r100.x + ", y:" + r100.y + " useUdpPath:" + r211);
        if (this.f33852o == false) goto L5;
        this.f33850m = 30;
    L6:
        String r101 = Utils.getProperty("ro.build.product", "", this.E);
        if (r101.equals("KKHi3751V900") == false) goto L9;
    L29:
        int r102 = r100.x;
        if (r102 <= 1920) goto L35;
        int r103 = r100.y;
        if (r103 <= 1080) goto L35;
    L33:
        int r104 = r102 / 2;
        int r105 = r103 / 2;
    L34:
        r100.set(r104, r105);
    L35:
        this.f33850m = 30;
    L36:
        this.F.i("ByteLinkSinkImpl", "change display, x:" + r100.x + ", y:" + r100.y);
        this.f33848k = r100.x;
        this.f33849l = r100.y;
        if (this.f33860w == false) goto L39;
        this.f33859v = com.byted.cast.sink.a.a.a(this.E, this.f33838a);
        this.F.i("ByteLinkSinkImpl", "init, enable random port:" + this.f33859v);
    L39:
        this.f33843f.setPort(this.f33859v);
        this.F.i("ByteLinkSinkImpl", "init, mRandomPortEnabled=" + this.f33860w);
        RTCEngine.init(this.f33838a, this.E, RTCEngine.RuntimeEnv.ONLINE, Constants.ROLE_SINK, this.f33859v, this.f33848k, this.f33849l, this.f33850m, false, r211, this.f33860w);
        this.f33843f.getScreenProfile().setResolution(this.f33848k, this.f33849l);
        this.f33843f.getScreenProfile().setmFps(this.f33850m);
        this.f33843f.setbEnableAudioMixer(false);
        this.f33843f.setbEnableAudioCallback(true);
        RTCEngine r106 = this.f33842e;
        if (r106 != null) goto L42;
        this.f33842e = RTCEngine.create(r110, this.E, this.f33843f, this.K, false);
    L43:
        this.f33851n = true;
        return;
    L42:
        r106.reinit(r110, this.f33843f, null, this.K, false);
        goto L43
    L9:
        if (r101.equals("ab30a5") == true) goto L29;
        if (r101.equals("kkm7642") == false) goto L36;
        if (this.f33852o == false) goto L24;
        r102 = r100.x;
        if (r102 <= 1920) goto L20;
        r103 = r100.y;
        if (r103 > 1080) goto L33;
    L20:
        if (r102 != 1920) goto L35;
        if (r100.y != 1080) goto L35;
        r104 = 1280;
        r105 = 720;
        goto L34
    L24:
        r102 = r100.x;
        if (r102 <= 1920) goto L35;
        r103 = r100.y;
        if (r103 <= 1080) goto L35;
    L5:
        this.f33850m = 60;
        goto L6
    }

    public void a(ILibraryLoader r100) {
        RTCEngine.setLibraryLoader(this.E, r100);
    }

    public void a(ILogger r100) {
        RTCEngine.setLogger(this.E, r100);
    }

    public void a(ISourceDeviceInfoListener r100) {
        this.H = r100;
    }

    public void a(IOnLogMonitor r100) {
        this.f33846i = r100;
    }

    public void a(IPreemptListener r100) {
        this.f33847j = r100;
    }

    public void a(IServerListener r100) {
        this.f33844g = r100;
    }

    public void a(IMultipleReverseControl r100) {
        this.f33845h = r100;
    }

    public void a(String r100, String r101) {
        boolean r102 = false;
        if (this.f33842e == null) goto L12;
        this.F.d("ByteLinkSinkImpl", "sendMetaData: id=" + r100 + " meta=" + r101);
        Iterator<String> r103 = this.f33853p.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        String r104 = r103.next();
        ClientInfo r105 = this.f33853p.get(r104);
        if (r105 == null) goto L6;
        if (r105.clientID.startsWith(r100) == false) goto L6;
        this.f33842e.sendMetaData(r104, r101);
        r102 = true;
    L12:
        if (r102 == true) goto L22;
        this.F.e("ByteLinkSinkImpl", "sendMetaData: id=" + r100 + " NOT found!!!");
        return;
    }

    public void a(boolean r100) {
        RTCEngine.setFileLogEnabled(this.E, r100);
    }

    public boolean a(String r100, int r101) {
        this.f33842e.connect(r100, r101, "", "");
        return true;
    }

    public boolean a(boolean r100, ClientInfo r101) {
        this.F.i("ByteLinkSinkImpl", "notifyPreempt: allow=" + r100 + " clientInfo=" + r101);
        this.f33851n = r100;
        if (r100 == true) goto L6;
    L4:
        a(r101, true, RTCEngine.ExitReason.REASON_DISCONNECT, true);
        return false;
    L6:
        if (this.f33853p.size() <= 0) goto L37;
        int r102 = this.f33861x;
        if (r102 != 1) goto L18;
        Map.Entry<String, ClientInfo> r103 = this.f33853p.firstEntry();
        if (r103 == null) goto L26;
        ClientInfo r104 = r103.getValue();
        if (r104.f33826ip.equals(r101.f33826ip) == false) goto L16;
        Map.Entry<String, ClientInfo> r105 = this.f33853p.higherEntry(r104.f33826ip);
        if (r105 == null) goto L16;
    L25:
        r101 = r105.getValue();
    L33:
        if (r101 != null) goto L4;
        return false;
    L16:
        r101 = r104;
    L26:
        r101 = null;
        goto L33
    L18:
        if (r102 != 2) goto L28;
        Map.Entry<String, ClientInfo> r106 = this.f33853p.lastEntry();
        if (r106 == null) goto L26;
        r104 = r106.getValue();
        if (r104.f33826ip.equals(r101.f33826ip) == false) goto L16;
        r105 = this.f33853p.lowerEntry(r104.f33826ip);
        if (r105 == null) goto L16;
    L28:
        if (r102 != 3) goto L26;
        if (this.f33853p.size() == 1) goto L26;
        this.F.i("ByteLinkSinkImpl", "notifyPreempt: oneSessionMode toKickClient=" + r101);
        goto L33
    L37:
        return false;
    }

    public void b(int r100) {
        RTCEngine r101 = this.f33842e;
        if (r101 == null) goto L6;
        r101.setAudioMaxDelayByMs(r100);
        return;
    }

    public void b(int r100, int r101) {
        RTCEngine r102 = this.f33842e;
        if (r102 == null) goto L6;
        r102.setAudioDropPolicyByMs(r100, r101);
        return;
    }

    public void b(int r100, Object... r101) {
        if (r100 != 2) goto L5;
        Object r102 = r101[0];
        if ((r102 instanceof String) == false) goto L187;
        String[] r103 = ((String) r102).split("\\*");
        if (r103.length == 2) goto L123;
        return;
    L123:
        this.f33848k = CastIntegerProtector.parseInt(r103[0]);
        this.f33849l = CastIntegerProtector.parseInt(r103[1]);
        RTCSetting r104 = this.f33843f;
        if (r104 != null) goto L126;
        return;
    L126:
        if (this.f33842e == null) goto L189;
        r104.getScreenProfile().setResolution(this.f33848k, this.f33849l);
        this.f33842e.setScreenProfile(this.f33843f.getScreenProfile());
        return;
    L189:
        return;
    L187:
        return;
    L5:
        if (r100 != 25) goto L7;
        this.f33843f.setbEnableAudioMixer(false);
        this.f33843f.setbEnableAudioCallback(true);
        this.f33852o = true;
        return;
    L7:
        if (r100 != 10066) goto L9;
        Object r105 = r101[0];
        if ((r105 instanceof Integer) == false) goto L184;
        this.f33843f.setLatencyMs(((Integer) r105).intValue());
        return;
    L184:
        return;
    L9:
        if (r100 != 10091) goto L11;
        Object r106 = r101[0];
        if ((r106 instanceof Boolean) == false) goto L183;
        this.D = ((Boolean) r106).booleanValue();
        CastLogger r107 = this.F;
        StringBuilder r108 = new StringBuilder("OPTION_ENABLE_BYTELINK_BROWSE:");
        r108.append(this.D);
    L29:
        r107.i("ByteLinkSinkImpl", r108.toString());
        return;
    L183:
        return;
    L11:
        if (r100 != 10021) goto L13;
        Objects.toString(r101[0]);
        Object r109 = r101[0];
        if ((r109 instanceof String) == false) goto L180;
        Object r110 = r101[1];
        if ((r110 instanceof Surface) == false) goto L181;
        a((String) r109, (Surface) r110);
        return;
    L181:
        return;
    L180:
        return;
    L13:
        if (r100 == 10022) goto L103;
        switch(r100) {
            case 10026: goto L96;
            case 10027: goto L90;
            case 10028: goto L81;
            case 10029: goto L76;
            case 10030: goto L71;
            case 10031: goto L66;
            case 10032: goto L59;
            default: goto L16;
        };
    L59:
        Object r111 = r101[0];
        if ((r111 instanceof Boolean) == false) goto L152;
        this.f33843f.setEnableVideoNativeDecode(((Boolean) r111).booleanValue());
        Boolean r112 = (Boolean) r101[0];
        int r113 = Utils.getArch();
        float r114 = Utils.getOSVersionF();
        if (r113 == 32) goto L64;
        return;
    L64:
        if (r114 >= 5.0f) goto L154;
        this.f33843f.setEnableVideoNativeDecode(false);
        return;
    L154:
        return;
    L152:
        return;
    L66:
        Object r115 = r101[0];
        if ((r115 instanceof String) == false) goto L156;
        Object r116 = r101[1];
        if ((r116 instanceof Long) == false) goto L157;
        RTCEngine r117 = this.f33842e;
        r117.render((String) r115, ((Long) r116).longValue());
        return;
    L157:
        return;
    L156:
        return;
    L71:
        Object r118 = r101[0];
        if ((r118 instanceof String) == false) goto L159;
        Object r119 = r101[1];
        if ((r119 instanceof Long) == false) goto L160;
        RTCEngine r120 = this.f33842e;
        r120.decodeOutput((String) r118, ((Long) r119).longValue());
        return;
    L160:
        return;
    L159:
        return;
    L76:
        Object r121 = r101[0];
        if ((r121 instanceof String) == false) goto L162;
        Object r122 = r101[1];
        if ((r122 instanceof Long) == false) goto L163;
        RTCEngine r123 = this.f33842e;
        r123.decodeInput((String) r121, ((Long) r122).longValue());
        return;
    L163:
        return;
    L162:
        return;
    L81:
        Object r124 = r101[0];
        if ((r124 instanceof Boolean) == false) goto L165;
        Object r125 = r101[1];
        if ((r125 instanceof Boolean) == false) goto L166;
        Object r126 = r101[2];
        if ((r126 instanceof ISinkDataListener) == false) goto L167;
        Boolean r127 = (Boolean) r124;
        Boolean r128 = (Boolean) r125;
        ISinkDataListener r129 = (ISinkDataListener) r126;
        if (this.f33842e == null) goto L168;
        Objects.toString(r129);
        this.f33842e.setSinkDataListener(r127, r128, r129);
        return;
    L168:
        return;
    L167:
        return;
    L166:
        return;
    L165:
        return;
    L90:
        if (r101 != null) goto L92;
        return;
    L92:
        if (r101.length <= 0) goto L171;
        Object r130 = r101[0];
        if ((r130 instanceof Integer) == false) goto L172;
        e(((Integer) r130).intValue());
        return;
    L172:
        return;
    L171:
        return;
    L96:
        Object r131 = r101[0];
        if ((r131 instanceof Boolean) == false) goto L174;
        Object r132 = r101[1];
        if ((r132 instanceof IAudioDataListener) == false) goto L175;
        Boolean r133 = (Boolean) r131;
        IAudioDataListener r134 = (IAudioDataListener) r132;
        if (this.f33842e == null) goto L176;
        Objects.toString(r134);
        this.f33842e.setAudioDataListener(r133, r134);
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L16:
        switch(r100) {
            case 10069: goto L50;
            case 10070: goto L49;
            case 10071: goto L38;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 10075: goto L35;
            case 10076: goto L30;
            case 10077: goto L26;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case 100041: goto L23;
            case 100042: goto L20;
            default: goto L190;
        };
    L20:
        Object r135 = r101[0];
        if ((r135 instanceof ILogger) == false) goto L129;
        ILogger r136 = (ILogger) r135;
        Objects.toString(r136);
        a(r136);
        return;
    L129:
        return;
    L23:
        Object r137 = r101[0];
        if ((r137 instanceof ILibraryLoader) == false) goto L131;
        ILibraryLoader r138 = (ILibraryLoader) r137;
        Objects.toString(r138);
        a(r138);
        return;
    L131:
        return;
    L190:
        return;
    L26:
        Object r139 = r101[0];
        if ((r139 instanceof Integer) == false) goto L133;
        this.f33861x = ((Integer) r139).intValue();
        r107 = this.F;
        r108 = new StringBuilder("OPTION_SET_PREEMPT_POLICY:");
        r108.append(this.f33861x);
        goto L29
    L133:
        return;
    L30:
        Object r140 = r101[0];
        if ((r140 instanceof Boolean) == false) goto L135;
        boolean r141 = ((Boolean) r140).booleanValue();
        this.f33860w = r141;
        RTCEngine r142 = this.f33842e;
        if (r142 == null) goto L136;
        r142.setRandomPortEnabled(r141);
        return;
    L136:
        return;
    L135:
        return;
    L35:
        Object r143 = r101[0];
        if ((r143 instanceof Boolean) == false) goto L138;
        this.f33843f.setDecodedByUser(((Boolean) r143).booleanValue());
        return;
    L138:
        return;
    L38:
        Object r144 = r101[0];
        if ((r144 instanceof String) == false) goto L140;
        Object r145 = r101[1];
        if ((r145 instanceof String) == false) goto L141;
        Object r146 = r101[2];
        if ((r146 instanceof String) == false) goto L142;
        Object r147 = r101[3];
        if ((r147 instanceof String) == false) goto L143;
        Object r148 = r101[4];
        if ((r148 instanceof Boolean) == false) goto L144;
        String r149 = (String) r144;
        String r150 = (String) r145;
        String r151 = (String) r146;
        String r152 = (String) r147;
        Boolean r153 = (Boolean) r148;
        this.f33862y = (String) r144;
        this.f33863z = (String) r145;
        this.A = (String) r146;
        this.B = (String) r147;
        this.C = ((Boolean) r148).booleanValue();
        return;
    L144:
        return;
    L143:
        return;
    L142:
        return;
    L141:
        return;
    L140:
        return;
    L49:
        j();
        return;
    L50:
        Object r154 = r101[0];
        if ((r154 instanceof String) == false) goto L147;
        Object r155 = r101[1];
        if ((r155 instanceof String) == false) goto L148;
        Object r156 = r101[2];
        if ((r156 instanceof String) == false) goto L149;
        Object r157 = r101[3];
        if ((r157 instanceof String) == false) goto L150;
        String r158 = (String) r154;
        String r159 = (String) r155;
        String r160 = (String) r156;
        String r161 = (String) r157;
        String r162 = (String) r154;
        this.f33862y = r162;
        String r163 = (String) r155;
        this.f33863z = r163;
        String r164 = (String) r156;
        this.A = r164;
        String r165 = (String) r157;
        this.B = r165;
        this.f33842e.sinkInitAndJoinRoom(r164, r165, r162, r163);
        return;
    L150:
        return;
    L149:
        return;
    L148:
        return;
    L147:
        return;
    L103:
        Object r166 = r101[0];
        if ((r166 instanceof Boolean) == false) goto L178;
        Objects.toString(r166);
        a(((Boolean) r101[0]).booleanValue());
        return;
    }

    public void b(String r100) {
        if (this.f33842e == null) goto L10;
        this.F.i("ByteLinkSinkImpl", "requestIdrFromSource, sessionId:" + r100);
        Iterator<String> r101 = this.f33853p.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        ClientInfo r103 = this.f33853p.get(r102);
        this.F.i("ByteLinkSinkImpl", "requestIdrFromSource, clientId:" + r103.clientID);
        if (r103.clientID != r100) goto L6;
        this.f33842e.requestIdrFromSource(r102);
        goto L6
    L16:
        return;
    }

    public IMultipleActiveControl c() {
        return this.f33837J;
    }

    public void c(int r100) {
        RTCEngine.setLogLevel(this.E, r100);
    }

    public boolean c(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("cmd", "invite");     // Catch: JSONException -> L7
        r101.put("port", this.f33859v);     // Catch: JSONException -> L7
        r101.put("msg", r100);     // Catch: JSONException -> L7
        this.f33842e.sendMetaData(r101.toString());     // Catch: JSONException -> L7
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public IMultipleLoader d() {
        return this.I;
    }

    public void d(int r100) {
        this.f33857t = r100;
    }

    public void d(String r100) {
        this.F.i("ByteLinkSinkImpl", "startServer serviceName: " + r100 + ", gitInfo:1.c8f9ae2");
        Context r101 = this.f33838a;
        if (r101 != null) goto L6;
        this.F.e("ByteLinkSinkImpl", "context is null, you should init with context first!");
        return;
    L6:
        this.f33839b = r100;
        ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRealSize(this.f33841d);
        if (this.f33852o == false) goto L9;
        int r102 = 30;
    L10:
        this.f33840c = r102;
        if (this.f33844g == null) goto L13;
        ServerInfo r103 = new ServerInfo();
        r103.deviceName = r100;
        r103.serverPort = this.f33859v;
        this.f33844g.onStart(3, r103);
    L13:
        this.F.i("ByteLinkSinkImpl", "startServer out");
        return;
    L9:
        r102 = 60;
        goto L10
    }

    public ServerInfo e() {
        this.F.i("ByteLinkSinkImpl", "getServerInfo, mServerPort:" + this.f33859v);
        ServerInfo r100 = new ServerInfo();
        r100.deviceName = this.f33839b;
        r100.serverPort = this.f33859v;
        r100.width = this.f33848k;
        r100.height = this.f33849l;
        r100.fps = this.f33840c;
        r100.features = 1;
        r100.deviceID = this.G;
        return r100;
    }

    public RTCStatistics f() {
        RTCStatistics r100 = this.f33842e.getStatistics();
        Iterator<RTCStatistics.NetworkStatistics> r101 = r100.f33735nx.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        RTCStatistics.NetworkStatistics r102 = r101.next();
        ClientInfo r103 = this.f33853p.get(r102.userId);
        if (r103 == null) goto L4;
        r102.userId = r103.clientID;
        goto L4
    L8:
        return r100;
    }

    public boolean i() {
        this.f33842e.disconnect();
        return true;
    }

    public void k() {
        this.F.i("ByteLinkSinkImpl", "stopServer, gitInfo:1.c8f9ae2");
        if (this.f33844g == null) goto L6;
        this.F.w("ByteLinkSinkImpl", "stopServer, onStop, serviceId:3");
        this.f33844g.onStop(3);
        return;
    }
}
