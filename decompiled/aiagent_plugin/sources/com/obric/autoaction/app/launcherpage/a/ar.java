package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.aiagent.plugin.R;
import com.obric.oui.lisitem.OCardListItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: DonationTaskItemLayoutBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ar implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCardListItem f22771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OCardListItem f22772b;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private ar(OCardListItem r1, OCardListItem r2) {
        this.f22772b = r1;
        this.f22771a = r2;
    }

    public OCardListItem b() {
        return this.f22772b;
    }

    public static ar a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.donation_task_item_layout, "layout", "donation_task_item_layout"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static ar a(View r4) {
        Objects.requireNonNull(r4, "rootView");
        OCardListItem r0 = (OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.aiagent.plugin");
        return new ar((OCardListItem) ZeusTransformUtils.preCheckCast(r4, OCardListItem.class, "com.obric.aiagent.plugin"), r0);
    }
}
