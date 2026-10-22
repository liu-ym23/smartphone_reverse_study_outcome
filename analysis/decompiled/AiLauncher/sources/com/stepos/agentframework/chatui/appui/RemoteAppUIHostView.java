package com.stepos.agentframework.chatui.appui;

import Y8.t;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceControlViewHost;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatui.appui.taskrobot.b;
import com.stepos.agentframework.util.G;
import com.stepos.appui.bridge.ISurfaceControlCallback;
import com.stepos.appui.bridge.ISurfaceControlViewHost;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005*\u0001,\u0018\u0000 /2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00060"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/RemoteAppUIHostView;", "Lcom/stepos/agentframework/chatui/appui/k;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "flag", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "LY8/t;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;)V", Const.INTENT_KEY_APIKEY, "()V", "r", "q", "t", "TAG", "Ljava/lang/String;", "REMOTE_SERVICE_ACTION", "Lcom/stepos/appui/bridge/ISurfaceControlViewHost;", "remoteService", "Lcom/stepos/appui/bridge/ISurfaceControlViewHost;", "getRemoteService", "()Lcom/stepos/appui/bridge/ISurfaceControlViewHost;", "setRemoteService", "(Lcom/stepos/appui/bridge/ISurfaceControlViewHost;)V", "", "isServiceBound", "Z", "viewInstanceId", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "surfacePackage", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "getSurfacePackage", "()Landroid/view/SurfaceControlViewHost$SurfacePackage;", "setSurfacePackage", "(Landroid/view/SurfaceControlViewHost$SurfacePackage;)V", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/ServiceConnection;", "com/stepos/agentframework/chatui/appui/RemoteAppUIHostView$callback$1", "callback", "Lcom/stepos/agentframework/chatui/appui/RemoteAppUIHostView$callback$1;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteAppUIHostView extends k {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger liveSurfacePackages = new AtomicInteger(0);
    private String REMOTE_SERVICE_ACTION;
    private String TAG;
    private final RemoteAppUIHostView$callback$1 callback;
    private boolean isServiceBound;
    private ISurfaceControlViewHost remoteService;
    private final ServiceConnection serviceConnection;
    private SurfaceControlViewHost.SurfacePackage surfacePackage;
    private String viewInstanceId;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/RemoteAppUIHostView$a;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicInteger;", "liveSurfacePackages", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/atomic/AtomicInteger;", "getLiveSurfacePackages$annotations", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.RemoteAppUIHostView$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AtomicInteger a() {
            return RemoteAppUIHostView.liveSurfacePackages;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/appui/RemoteAppUIHostView$b", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v10, MotionEvent event) {
            if (event == null) {
                return false;
            }
            try {
                ISurfaceControlViewHost remoteService = RemoteAppUIHostView.this.getRemoteService();
                if (remoteService != null) {
                    return remoteService.onTouch(RemoteAppUIHostView.this.viewInstanceId, event);
                }
                return false;
            } catch (RemoteException e10) {
                C4148a.g(RemoteAppUIHostView.this.TAG, "onTouch remote failed", e10, false, 8, null);
                return false;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/appui/RemoteAppUIHostView$c", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b$b;", "Landroid/view/Surface;", "surface", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Surface;)V", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements b.InterfaceC0251b {
        public c() {
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.b.InterfaceC0251b
        public void a() {
            C4148a.k(RemoteAppUIHostView.this.TAG, "onSurfaceDestroyed", false, 4, null);
        }

        @Override // com.stepos.agentframework.chatui.appui.taskrobot.b.InterfaceC0251b
        public void b(Surface surface) {
            p.i(surface, "surface");
            C4148a.k(RemoteAppUIHostView.this.TAG, "onSurfaceCreated surfacePackage:" + RemoteAppUIHostView.this.getSurfacePackage(), false, 4, null);
            RemoteAppUIHostView.this.q();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/agentframework/chatui/appui/RemoteAppUIHostView$d", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) throws RemoteException {
            C4148a.k(RemoteAppUIHostView.this.TAG, "onServiceConnected", false, 4, null);
            RemoteAppUIHostView.this.setRemoteService(ISurfaceControlViewHost.Stub.asInterface(service));
            ISurfaceControlViewHost remoteService = RemoteAppUIHostView.this.getRemoteService();
            if (remoteService != null) {
                RemoteAppUIHostView remoteAppUIHostView = RemoteAppUIHostView.this;
                remoteService.registerCallback(remoteAppUIHostView.callback);
                try {
                    String str = remoteAppUIHostView.viewInstanceId;
                    AppUIData appUIData = remoteAppUIHostView.getAppUIData();
                    p.f(appUIData);
                    remoteService.onInitData(str, com.stepos.agentframework.adapter.netcore.j.b(appUIData.getStructuredContent()));
                } catch (RemoteException e10) {
                    C4148a.g(remoteAppUIHostView.TAG, "onInitData remote failed", e10, false, 8, null);
                }
                remoteAppUIHostView.r();
                String str2 = remoteAppUIHostView.viewInstanceId;
                com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView = remoteAppUIHostView.getSurfaceView();
                p.f(surfaceView);
                remoteAppUIHostView.setSurfacePackage(remoteService.getSurfacePackage(str2, surfaceView.getHostToken(), remoteAppUIHostView.getWidth(), remoteAppUIHostView.getHeight()));
                SurfaceControlViewHost.SurfacePackage surfacePackage = remoteAppUIHostView.getSurfacePackage();
                if (surfacePackage != null) {
                    RemoteAppUIHostView.INSTANCE.a().incrementAndGet();
                    com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView2 = remoteAppUIHostView.getSurfaceView();
                    p.f(surfaceView2);
                    surfaceView2.setChildSurfacePackage(surfacePackage);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            C4148a.k(RemoteAppUIHostView.this.TAG, "onServiceDisconnected", false, 4, null);
            RemoteAppUIHostView.this.r();
            RemoteAppUIHostView.this.setRemoteService(null);
            RemoteAppUIHostView.this.isServiceBound = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.stepos.agentframework.chatui.appui.RemoteAppUIHostView$callback$1] */
    public RemoteAppUIHostView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.i(context, "context");
        this.TAG = "RemoteAppUIHostView";
        this.REMOTE_SERVICE_ACTION = "com.stepos.remote.service.CUSTOM_APP_UI_SERVICE";
        this.viewInstanceId = "";
        this.serviceConnection = new d();
        this.callback = new ISurfaceControlCallback.Stub() { // from class: com.stepos.agentframework.chatui.appui.RemoteAppUIHostView$callback$1
            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void callTool(String json) {
                C4148a.k(this.this$0.TAG, "callTool: " + json, false, 4, null);
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void onSizeChanged(int width, int height) {
                C4148a.k(this.this$0.TAG, "onSizeChanged: " + width + ", " + height, false, 4, null);
                Function2.b(new RemoteAppUIHostView$callback$1$onSizeChanged$1(this.this$0, width, height, null));
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void openExternal(String json) {
                C4148a.k(this.this$0.TAG, "openExternal: " + json, false, 4, null);
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public String requestDisplayMode() {
                return AppUIGlobal.MODE_FULLSCREEN;
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void sendFollowUpMessage(String json) {
                C4148a.k(this.this$0.TAG, "sendFollowUpMessage: " + json, false, 4, null);
            }

            @Override // com.stepos.appui.bridge.ISurfaceControlCallback
            public void setWidgetState(String json) {
                C4148a.k(this.this$0.TAG, "setWidgetState: " + json, false, 4, null);
            }
        };
    }

    public static final AtomicInteger getLiveSurfacePackages() {
        return INSTANCE.a();
    }

    public static final int s(int i10) {
        if (i10 > 0) {
            return i10 - 1;
        }
        return 0;
    }

    @Override // com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void a() {
        C4148a.d(this.TAG, "destroy", false, 4, null);
        setHostDestroyed(true);
        try {
            ISurfaceControlViewHost iSurfaceControlViewHost = this.remoteService;
            if (iSurfaceControlViewHost != null) {
                iSurfaceControlViewHost.unregisterCallback(this.callback);
            }
            ISurfaceControlViewHost iSurfaceControlViewHost2 = this.remoteService;
            if (iSurfaceControlViewHost2 != null) {
                iSurfaceControlViewHost2.release(this.viewInstanceId);
            }
        } catch (RemoteException e10) {
            C4148a.g(this.TAG, "destroy release failed", e10, false, 8, null);
        }
        r();
        t();
        this.remoteService = null;
    }

    @Override // com.stepos.agentframework.chatui.appui.k, com.stepos.agentframework.chatui.appui.BaseAppUIHostView
    public void e(String flag, AppUIData appUIData) {
        p.i(flag, "flag");
        p.i(appUIData, "appUIData");
        super.e(flag, appUIData);
        f();
        this.viewInstanceId = flag;
        r();
        com.stepos.agentframework.chatui.appui.taskrobot.b bVarG = g();
        Context context = getContext();
        p.h(context, "getContext(...)");
        int iIntValue = G.b(context).e().intValue();
        O6.d dVar = O6.d.INSTANCE;
        Context context2 = getContext();
        p.h(context2, "getContext(...)");
        bVarG.c(iIntValue, dVar.a(context2, 400.0f));
        getAppUIContainer().removeAllViews();
        getAppUIContainer().addView(bVarG);
        bVarG.setSurfaceCallback(new c());
    }

    public final ISurfaceControlViewHost getRemoteService() {
        return this.remoteService;
    }

    public final SurfaceControlViewHost.SurfacePackage getSurfacePackage() {
        return this.surfacePackage;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void q() {
        C4148a.k(this.TAG, "bindRemoteService", false, 4, null);
        t();
        Intent intent = new Intent();
        intent.setAction(this.REMOTE_SERVICE_ACTION);
        AppUIData appUIData = getAppUIData();
        p.f(appUIData);
        intent.setPackage(appUIData.getPackageName());
        AppUIData appUIData2 = getAppUIData();
        p.f(appUIData2);
        intent.putExtra("app_ui_name", appUIData2.getAppUIName());
        AppUIData appUIData3 = getAppUIData();
        p.f(appUIData3);
        intent.putExtra("app_ui_id", appUIData3.getId());
        this.isServiceBound = getContext().bindService(intent, this.serviceConnection, 1);
        com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView = getSurfaceView();
        if (surfaceView != null) {
            surfaceView.setOnTouchListener(new b());
        }
    }

    public final void r() {
        Object objB;
        SurfaceControlViewHost.SurfacePackage surfacePackage = this.surfacePackage;
        if (surfacePackage != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                surfacePackage.release();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(this.TAG, "releaseSurfacePackage failed: " + thE.getMessage(), false, 4, null);
            }
            liveSurfacePackages.updateAndGet(new IntUnaryOperator() { // from class: com.stepos.agentframework.chatui.appui.j
                @Override // java.util.function.IntUnaryOperator
                public final int applyAsInt(int i10) {
                    return RemoteAppUIHostView.s(i10);
                }
            });
        }
        this.surfacePackage = null;
    }

    public final void setRemoteService(ISurfaceControlViewHost iSurfaceControlViewHost) {
        this.remoteService = iSurfaceControlViewHost;
    }

    public final void setSurfacePackage(SurfaceControlViewHost.SurfacePackage surfacePackage) {
        this.surfacePackage = surfacePackage;
    }

    public final void t() {
        Object objB;
        if (this.isServiceBound) {
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().unbindService(this.serviceConnection);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(this.TAG, "unbindService failed: " + thE.getMessage(), false, 4, null);
            }
            this.isServiceBound = false;
        }
    }
}
