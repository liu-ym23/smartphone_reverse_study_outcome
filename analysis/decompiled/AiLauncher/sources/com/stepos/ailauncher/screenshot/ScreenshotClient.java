package com.stepos.ailauncher.screenshot;

import Y8.j;
import Y8.t;
import Z8.Q;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import com.stepos.picker.screenperception.IScreenshotCallback;
import com.stepos.picker.screenperception.IScreenshotService;
import com.stepos.picker.screenperception.ScreenRegion;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001'\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\u000e2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0019\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u000e0\u00110\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/screenshot/ScreenshotClient;", "", "Landroid/content/Context;", "appCtx", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/picker/screenperception/ScreenRegion;", WeatherCardProvider.KEY_REGION, "LXa/b;", "Lcom/stepos/ailauncher/screenshot/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/picker/screenperception/ScreenRegion;)LXa/b;", "f", "()LXa/b;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "Lkotlin/Function1;", "Lcom/stepos/picker/screenperception/IScreenshotService;", "callback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lp9/l;)V", "", "event", "paramsJson", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "remote", "Lcom/stepos/picker/screenperception/IScreenshotService;", "", "pendingBindCallbacks", "Ljava/util/List;", "", "isBound", "Z", "Lcom/stepos/picker/screenperception/IScreenshotCallback$Stub;", "activeCb", "Lcom/stepos/picker/screenperception/IScreenshotCallback$Stub;", "com/stepos/ailauncher/screenshot/ScreenshotClient$b", "connection", "Lcom/stepos/ailauncher/screenshot/ScreenshotClient$b;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenshotClient {
    private static final String PICKER_PACKAGE = "com.stepos.picker";
    private static final String SERVICE_ACTION = "com.stepos.picker.screenperception.action.WAKE_UP_SERVICE";
    private static final String TAG = "ScreenshotClient";
    private volatile IScreenshotCallback.Stub activeCb;
    private final Context appCtx;
    private final b connection;
    private boolean isBound;
    private final List<InterfaceC5074l<IScreenshotService, t>> pendingBindCallbacks;
    private IScreenshotService remote;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/screenshot/ScreenshotClient$b", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "LY8/t;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            p.i(name, "name");
            p.i(service, "service");
            y yVar = y.f34840a;
            String str = String.format("onServiceConnected: component=%s", Arrays.copyOf(new Object[]{name}, 1));
            p.h(str, "format(...)");
            C4148a.d(ScreenshotClient.TAG, str, false, 4, null);
            IScreenshotService iScreenshotServiceAsInterface = IScreenshotService.Stub.asInterface(service);
            ScreenshotClient.this.remote = iScreenshotServiceAsInterface;
            String str2 = String.format("service proxy ready, draining %d pending callbacks", Arrays.copyOf(new Object[]{Integer.valueOf(ScreenshotClient.this.pendingBindCallbacks.size())}, 1));
            p.h(str2, "format(...)");
            C4148a.d(ScreenshotClient.TAG, str2, false, 4, null);
            Iterator it = ScreenshotClient.this.pendingBindCallbacks.iterator();
            while (it.hasNext()) {
                ((InterfaceC5074l) it.next()).invoke(iScreenshotServiceAsInterface);
            }
            ScreenshotClient.this.pendingBindCallbacks.clear();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            p.i(name, "name");
            y yVar = y.f34840a;
            String str = String.format("onServiceDisconnected: component=%s, remote cleared", Arrays.copyOf(new Object[]{name}, 1));
            p.h(str, "format(...)");
            C4148a.u(ScreenshotClient.TAG, str, false, 4, null);
            ScreenshotClient.this.remote = null;
        }
    }

    public ScreenshotClient(Context appCtx) {
        p.i(appCtx, "appCtx");
        this.appCtx = appCtx;
        this.pendingBindCallbacks = new ArrayList();
        this.connection = new b();
    }

    public final Xa.b<a> f() {
        return Xa.d.f(new ScreenshotClient$captureFullScreen$1(this, null));
    }

    public final Xa.b<a> g(ScreenRegion region) {
        p.i(region, "region");
        return Xa.d.f(new ScreenshotClient$captureRegion$1(region, this, null));
    }

    public final void h(InterfaceC5074l<? super IScreenshotService, t> callback) {
        boolean zBindService;
        IScreenshotService iScreenshotService = this.remote;
        if (iScreenshotService != null) {
            C4148a.d(TAG, "ensureBound: already connected, reusing remote", false, 4, null);
            callback.invoke(iScreenshotService);
            return;
        }
        this.pendingBindCallbacks.add(callback);
        if (this.isBound) {
            y yVar = y.f34840a;
            String str = String.format("ensureBound: bind already in progress, queued callback (pending=%d)", Arrays.copyOf(new Object[]{Integer.valueOf(this.pendingBindCallbacks.size())}, 1));
            p.h(str, "format(...)");
            C4148a.d(TAG, str, false, 4, null);
            return;
        }
        y yVar2 = y.f34840a;
        String str2 = String.format("ensureBound: not bound, attempting bindService action=%s pkg=%s", Arrays.copyOf(new Object[]{SERVICE_ACTION, PICKER_PACKAGE}, 2));
        p.h(str2, "format(...)");
        C4148a.d(TAG, str2, false, 4, null);
        Intent intent = new Intent(SERVICE_ACTION);
        intent.setPackage(PICKER_PACKAGE);
        try {
            zBindService = this.appCtx.bindService(intent, this.connection, 1);
        } catch (Exception e10) {
            C4148a.g(TAG, "ensureBound: bindService threw exception", e10, false, 8, null);
            zBindService = false;
        }
        this.isBound = zBindService;
        if (zBindService) {
            C4148a.d(TAG, "ensureBound: bindService returned true, waiting for onServiceConnected", false, 4, null);
            return;
        }
        C4148a.h(TAG, "ensureBound: bindService returned false — service not found or permission denied", false, 4, null);
        this.pendingBindCallbacks.remove(callback);
        callback.invoke(null);
    }

    public final void i() {
        y yVar = y.f34840a;
        String str = String.format("release: isBound=%b, remote=%s, pending=%d", Arrays.copyOf(new Object[]{Boolean.valueOf(this.isBound), Boolean.valueOf(this.remote != null), Integer.valueOf(this.pendingBindCallbacks.size())}, 3));
        p.h(str, "format(...)");
        C4148a.d(TAG, str, false, 4, null);
        if (this.isBound) {
            try {
                Result.Companion companion = Result.INSTANCE;
                this.appCtx.unbindService(this.connection);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            this.isBound = false;
        }
        this.remote = null;
        this.pendingBindCallbacks.clear();
    }

    public final void j(String event, String paramsJson) {
        Map mapF;
        Object objB;
        if (event == null) {
            return;
        }
        if (paramsJson == null || paramsJson.length() == 0) {
            mapF = null;
        } else {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b((Map) new Gson().fromJson(paramsJson, new TypeToken<Map<String, ? extends String>>() { // from class: com.stepos.ailauncher.screenshot.ScreenshotClient$reportTrackEvent$properties$1$1
                }.getType()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = null;
            }
            mapF = (Map) objB;
            if (mapF == null) {
                mapF = Q.f(j.a("params", paramsJson));
            }
        }
        N.a(event, null, mapF);
    }
}
