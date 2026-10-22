package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.discovery.view.DiscoveryList;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: AutoactionDiscoverySubPageLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DiscoveryList f22855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DiscoveryList f22856b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private r(DiscoveryList r1, DiscoveryList r2) {
        this.f22856b = r1;
        this.f22855a = r2;
    }

    public DiscoveryList b() {
        return this.f22856b;
    }

    public static r a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_discovery_sub_page_layout, "layout", "autoaction_discovery_sub_page_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static r a(View r4) {
        Objects.requireNonNull(r4, "rootView");
        DiscoveryList r0 = (DiscoveryList) ZeusTransformUtils.preCheckCast(r4, DiscoveryList.class, "com.obric.aiagent.plugin");
        return new r((DiscoveryList) ZeusTransformUtils.preCheckCast(r4, DiscoveryList.class, "com.obric.aiagent.plugin"), r0);
    }
}
