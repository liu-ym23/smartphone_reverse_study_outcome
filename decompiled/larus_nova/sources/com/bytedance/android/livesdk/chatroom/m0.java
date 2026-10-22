package com.bytedance.android.livesdk.chatroom;

import android.os.Bundle;
import androidx.core.app.BundleCompat;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m0 {
    public static final Bundle a(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getEnterLiveExtra");
        return yt2.a.b(r100, "live.intent.extra.ENTER_LIVE_EXTRA");
    }

    public static final StreamUrl b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPullOriginStreamUrl");
        Serializable r101 = yt2.a.c(r100);
        if ((r101 instanceof StreamUrl) == true) goto L6;
        r101 = null;
    L6:
        return (StreamUrl) r101;
    }

    public static final String c(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPullShareStreamUrl");
        return yt2.a.e(r100, ILiveRoomPlayFragmentConstant.EXTRA_PULL_SHARE_URL);
    }

    public static final String d(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getPullStreamData");
        return yt2.a.e(r100, ILiveRoomPlayFragmentConstant.EXTRA_PULL_STREAM_DATA);
    }

    public static final void e(Bundle r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putEnterLiveExtra");
        Intrinsics.checkNotNullParameter(r101, "bundle");
        Boolean r102 = yt2.a.f569043a;
        Intrinsics.checkNotNullParameter("live.intent.extra.ENTER_LIVE_EXTRA", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (r100 != null) goto L6;
        return;
    L6:
        if (yt2.a.a() == false) goto L8;
        BundleCompat.putBinder(r100, "live.intent.extra.ENTER_LIVE_EXTRA", new jc1.g(r101));
        return;
    L8:
        r100.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r101);
    }
}
