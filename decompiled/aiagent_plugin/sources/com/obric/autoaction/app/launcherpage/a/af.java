package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionShortcutFragmentBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class af implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f22726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OPageStatus f22727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22728c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private af(FrameLayout r1, RecyclerView r2, OPageStatus r3) {
        this.f22728c = r1;
        this.f22726a = r2;
        this.f22727b = r3;
    }

    public FrameLayout b() {
        return this.f22728c;
    }

    public static af a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_shortcut_fragment, "layout", "autoaction_shortcut_fragment"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static af a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.list, DbHelper.COL_ID, "list");
        RecyclerView r2 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.sv, DbHelper.COL_ID, "sv");
        OPageStatus r1 = (OPageStatus) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OPageStatus.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new af((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
