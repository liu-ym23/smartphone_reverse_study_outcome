package com.obric.matrix.platform.sdk.ones.ws;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.r;
import d.h.b.h;
import d.h.b.o;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: WsStatusReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public class d extends PluginBroadcastReceiver {
    private static final String TAG = "WsStatusReceiver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33750a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r<Integer, Integer, Integer, Boolean, x> f33751b;

    /* JADX INFO: compiled from: WsStatusReceiver.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f33750a = new a(null);
    }

    public d(r<? super Integer, ? super Integer, ? super Integer, ? super Boolean, x> r3) {
        r<Integer, Integer, Integer, Boolean, x> r4 = (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.f33751b = r4;
    }

    public void onReceive(Context r5, Intent r6) {
        a(TAG, "onReceive() called with: context = " + ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")) + ", intent = " + r6);
        Boolean r0 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r6 == null) goto L8;
        Integer r2 = Integer.valueOf(r6.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r6 == null) goto L11;
        Integer r3 = Integer.valueOf(r6.getIntExtra("ws_connection_state", 0));
    L12:
        if (r6 == null) goto L14;
        r0 = Boolean.valueOf(r6.getBooleanExtra("ws_is_connected", false));
    L14:
        r<Integer, Integer, Integer, Boolean, x> r4 = this.f33751b;
        o.a(r2);
        o.a(r3);
        o.a(r1);
        o.a(r0);
        r4.a(r2, r3, r1, r0);
        return;
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
