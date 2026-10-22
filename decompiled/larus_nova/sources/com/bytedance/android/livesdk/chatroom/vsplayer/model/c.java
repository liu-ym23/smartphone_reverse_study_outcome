package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f118399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f118400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f118401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f118402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f118403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NextLiveData<Integer> f118404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PlayerViewControl.KEY f118405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vsplayer.model.a f118406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f118407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PlayerViewControl.Type f118408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PlayerViewControl.Style f118409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f118410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f118411m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f118412n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f118413o;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Integer r100 = this.f118404f.getValue();     // Catch: Exception -> L10
        if (r100 != null) goto L6;
    L8:
        int[] r101 = new int[2];     // Catch: Exception -> L10
        this.f118407i.getLocationOnScreen(r101);     // Catch: Exception -> L10
        int r102 = r101[0];     // Catch: Exception -> L10
        int r103 = r101[1];     // Catch: Exception -> L10
        this.f118400b = r103;     // Catch: Exception -> L10
        this.f118401c = r102;     // Catch: Exception -> L10
        this.f118402d = r102 + this.f118407i.getWidth();     // Catch: Exception -> L10
        this.f118399a = r103 + this.f118407i.getHeight();     // Catch: Exception -> L10
        return;
    L6:
        if (r100.intValue() != 1) goto L8;
        return;
    L10:
        e = move-exception;
        ALogger.e("VSPlayerViewControlItem", "refreshViewPosition:error for" + this.f118405g.name(), e);
    }

    public final PlayerViewControl.Type getType() {
        return this.f118408j;
    }

    public c(PlayerViewControl.KEY r100, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r101, View r102, PlayerViewControl.Type r103, PlayerViewControl.Style r104, float r105, boolean r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, "style");
        this.f118405g = r100;
        this.f118406h = r101;
        this.f118407i = r102;
        this.f118408j = r103;
        this.f118409k = r104;
        this.f118410l = r105;
        this.f118411m = r106;
        this.f118412n = r107;
        this.f118413o = r110;
        NextLiveData<Integer> r108 = new NextLiveData();
        r108.setValue(0);
        Unit r109 = Unit.INSTANCE;
        this.f118404f = r108;
        a();
    }
}
