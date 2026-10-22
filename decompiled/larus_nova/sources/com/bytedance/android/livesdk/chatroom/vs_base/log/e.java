package com.bytedance.android.livesdk.chatroom.vs_base.log;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118011a = 0;

    static {
    }

    public static void a(boolean r100, DataCenter r101, String r102, String r103) {
        if (r101 == null) goto L9;
        d r104 = d.a(r101);
        Pair[] r105 = new Pair[3];
        if (r100 == false) goto L6;
        String r106 = "1";
    L7:
        r105[0] = TuplesKt.to("success", r106);
        r105[1] = TuplesKt.to("old_resolution", String.valueOf(r102));
        r105[2] = TuplesKt.to("playback_resolution", String.valueOf(r103));
        r104.e("livesdk_replay_switch_resolution", MapsKt.mutableMapOf(r105), new Object[0]);
        return;
    L6:
        r106 = "0";
        goto L7
    }
}
