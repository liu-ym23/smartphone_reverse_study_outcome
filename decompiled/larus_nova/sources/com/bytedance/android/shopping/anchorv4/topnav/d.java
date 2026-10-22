package com.bytedance.android.shopping.anchorv4.topnav;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f167485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f167486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f167487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f167488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SlcContext f167489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f167490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f167491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f167492h;

    public d(SlcContext r100, Map r101, AnchorV4TopNavComponent r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "topNavComponent");
        this.f167489e = r100;
        this.f167490f = r101;
        this.f167491g = r102;
        this.f167492h = r103;
    }
}
