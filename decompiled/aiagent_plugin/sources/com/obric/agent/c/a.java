package com.obric.agent.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentDebugPanelBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f14251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f14252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f14253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f14254d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private a(ConstraintLayout r1, ImageView r2, RecyclerView r3, RecyclerView r4) {
        this.f14254d = r1;
        this.f14251a = r2;
        this.f14252b = r3;
        this.f14253c = r4;
    }

    public ConstraintLayout b() {
        return this.f14254d;
    }

    public static a a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.intent_debug_panel, "layout", "intent_debug_panel"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static a a(View r6) {
        int r0 = ZeusTransformUtils.mapRes(R.id.close, DbHelper.COL_ID, "close");
        ImageView r2 = (ImageView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), ImageView.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.intent_details, DbHelper.COL_ID, "intent_details");
        RecyclerView r3 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        r0 = ZeusTransformUtils.mapRes(R.id.intent_list, DbHelper.COL_ID, "intent_list");
        RecyclerView r1 = (RecyclerView) ZeusTransformUtils.preCheckCast(r6.findViewById(r0), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        return new a((ConstraintLayout) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r3, r1);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
