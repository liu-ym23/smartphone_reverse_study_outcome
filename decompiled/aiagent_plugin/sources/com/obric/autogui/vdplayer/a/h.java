package com.obric.autogui.vdplayer.a;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: VdComponentVirtualDisplaySurfaceBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SurfaceView f31619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SurfaceView f31620b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private h(SurfaceView r1, SurfaceView r2) {
        this.f31620b = r1;
        this.f31619a = r2;
    }

    public SurfaceView b() {
        return this.f31620b;
    }

    public static h a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.vd_component_virtual_display_surface, "layout", "vd_component_virtual_display_surface"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static h a(View r4) {
        Objects.requireNonNull(r4, "rootView");
        SurfaceView r0 = (SurfaceView) ZeusTransformUtils.preCheckCast(r4, SurfaceView.class, "com.obric.aiagent.plugin");
        return new h((SurfaceView) ZeusTransformUtils.preCheckCast(r4, SurfaceView.class, "com.obric.aiagent.plugin"), r0);
    }
}
