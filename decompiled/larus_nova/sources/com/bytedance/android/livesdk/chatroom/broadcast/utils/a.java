package com.bytedance.android.livesdk.chatroom.broadcast.utils;

import android.app.Application;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.broadcast.utils.a$a, reason: collision with other inner class name */
    public static final class C1584a implements IHostPlugin.Callback {
        public C1584a() {
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onCancel(String r100) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            ALogger.d("bmf_plugin", "bmf so plugin install failed!");
        }

        @Override // com.bytedance.android.livehostapi.foundation.IHostPlugin.Callback
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "packageName");
            ALogger.d("bmf_plugin", "bmf so plugin install success!");
        }
    }

    public static final void a() {
        PluginType r100 = PluginType.LiveBMFSo;
        if (r100.isInstalled() == false) goto L5;
        return;
    L5:
        ALogger.d("bmf_plugin", "start install bmf so !");
        IHostPlugin r101 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r101 != null) goto L9;
        ALogger.d("bmf_plugin", "null IHostPlugin");
        return;
    L9:
        Application r102 = jc1.a.b();
        if (r102 != null) goto L13;
        ALogger.d("bmf_plugin", "null context");
        return;
    L13:
        r101.check(r102, r100, "", new C1584a(), false);
    }
}
