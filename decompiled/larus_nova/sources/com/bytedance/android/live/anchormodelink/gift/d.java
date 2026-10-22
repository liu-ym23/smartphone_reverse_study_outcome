package com.bytedance.android.live.anchormodelink.gift;

import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<ILinkPlayerInfoBridge> f58640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<iy.i> f58641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kh0.a f58643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f58644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataCenter f58645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oy.a f58646g;

    public d(DataCenter r100, AnchorModeLinkDynamicWidget.e r101) {
        Intrinsics.checkNotNullParameter(r101, "interactCallback");
        this.f58645f = r100;
        this.f58646g = r101;
        this.f58641b = new LinkedHashSet();
        this.f58644e = new a(r100, this);
    }
}
