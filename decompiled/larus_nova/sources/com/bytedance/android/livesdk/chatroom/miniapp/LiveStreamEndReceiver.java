package com.bytedance.android.livesdk.chatroom.miniapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mh1.o;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/miniapp/LiveStreamEndReceiver;", "Landroid/content/BroadcastReceiver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStreamEndReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f106863a;

    public static final class a {
    }

    static {
    }

    public LiveStreamEndReceiver(o r100) {
        Intrinsics.checkNotNullParameter(r100, "liveWindow");
        this.f106863a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        ILivePlayerClient r102 = this.f106863a.f513892j;
        if (r102 == null) goto L5;
        r102.stop();
    L5:
        this.f106863a.showEndView();
    }
}
