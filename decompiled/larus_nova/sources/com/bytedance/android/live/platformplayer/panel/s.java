package com.bytedance.android.live.platformplayer.panel;

import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<DataCenter> f85785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<LivePlayerView> f85786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f85787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f85788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f85789e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f85790f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f85791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f85792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f85793i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StreamAutoAdapterStatusController$linkStateObserver$1 f85794j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final r f85795k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final StreamAutoAdapterService f85796l;

    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.android.live.platformplayer.panel.StreamAutoAdapterStatusController$linkStateObserver$1] */
    public s() {
        StreamAutoAdapterService r100 = StreamAutoAdapterService.f85743o;
        Intrinsics.checkNotNullParameter(r100, "adapterService");
        this.f85796l = r100;
        this.f85785a = new WeakReference(null);
        this.f85786b = new WeakReference(null);
        this.f85787c = "link";
        this.f85788d = "banned";
        this.f85789e = "pause";
        this.f85790f = "";
        this.f85791g = "";
        this.f85793i = LazyKt.lazy(StreamAutoAdapterStatusController$streamAutoAdapterStatusOpt$2.INSTANCE);
        this.f85794j = new StreamAutoAdapterStatusController$linkStateObserver$1(this);
        this.f85795k = new r(this);
    }

    public final boolean a(JSONObject r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        return false;
    L5:
        JSONObject r102 = r100.optJSONObject("heart_beat");
        if (r102 == null) goto L8;
        JSONObject r103 = r102.optJSONObject("content");
    L9:
        if (r102 == null) goto L27;
        if (r103 == null) goto L27;
        JSONObject r104 = r103.optJSONObject("anchor_stream_status");
        if (r104 == null) goto L16;
        r101 = r104.optInt("status", 0);
    L16:
        if (Intrinsics.areEqual(this.f85791g, this.f85787c) == false) goto L19;
        if (r101 != 0) goto L19;
        return true;
    L19:
        if (r101 != 1) goto L21;
        String r105 = this.f85789e;
    L25:
        this.f85791g = r105;
        return true;
    L21:
        if (r101 == 2) goto L23;
        r105 = "";
        goto L25
    L23:
        r105 = this.f85788d;
    L27:
        return false;
    L8:
        r103 = null;
        goto L9
    }
}
