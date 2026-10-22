package com.bytedance.applet.audio.background;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import aw3.g0;
import com.larus.utils.logger.FLogger;
import com.vivo.push.PushClientConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements ServiceConnection {
    public a() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        g0.f16424c = null;
        g0.f16426e = false;
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session service disconnected");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "service");
        AppletBackgroundAudioMediaSessionService r102 = null;
        if ((r101 instanceof AppletBackgroundAudioMediaSessionService.b) == false) goto L5;
        AppletBackgroundAudioMediaSessionService.b r103 = (AppletBackgroundAudioMediaSessionService.b) r101;
    L6:
        if (r103 == null) goto L8;
        r102 = r103.f191440a;
    L8:
        g0.f16424c = r102;
        g0.f16426e = false;
        if (r102 != null) goto L12;
        g0.f16422a.clear();
        FLogger.f375446a.e("AppletBackgroundAudioMediaSessionController", "media session service bind failed. reason: binder type mismatch");
        return;
    L12:
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r104 = g0.f16422a;
        if (r104.isEmpty() == false) goto L16;
        g0.d();
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session service released. reason: no pending action");
        return;
    L16:
        Iterator r105 = new CopyOnWriteArrayList(r104).iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        ((Function1) r105.next()).invoke(r102);
        goto L18
    L20:
        g0.f16422a.clear();
        FLogger.f375446a.i("AppletBackgroundAudioMediaSessionController", "media session service connected");
        return;
    L5:
        r103 = null;
        goto L6
    }
}
