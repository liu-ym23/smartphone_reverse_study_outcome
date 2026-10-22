package com.bytedance.android.gamecp.live_impl.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class l extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f58009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f58010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ToolbarContext f58011c;

    public static final class a {
    }

    static {
    }

    public l(Context r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "uniqueKey");
        Intrinsics.checkNotNullParameter(r103, "source");
        xr.c r104 = null;
        super(r100, null, 0);
        View r105 = LayoutInflater.from(r100).inflate(R.layout.gamecp_layout_preload_toolbar_view, this, true);
        this.f58009a = r105;
        this.f58010b = new CompositeDisposable();
        ToolbarContext.Companion.getClass();
        this.f58011c = ToolbarContext.a.a(r101, r102, r103);
        xr.f r106 = (xr.f) s.a(xr.f.class);
        if (r106 == null) goto L7;
        xr.p r107 = r106.getTrackService();
        if (r107 == null) goto L7;
        r104 = xr.p.a.a(r107);
    L7:
        if (r104 == null) goto L9;
        com.bytedance.android.gamecp.common.track.monitor.a r108 = (com.bytedance.android.gamecp.common.track.monitor.a) r104;
        r108.attachViewAppearObserver(r105, new AudiencePreloadToolbarView$1(this));
    L9:
        setOnClickListener(new k(this));
    }
}
