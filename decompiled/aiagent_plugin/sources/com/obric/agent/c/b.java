package com.obric.agent.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IntentListItemBinding.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f14255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstraintLayout f14257c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private b(ConstraintLayout r1, ConstraintLayout r2, TextView r3) {
        this.f14257c = r1;
        this.f14255a = r2;
        this.f14256b = r3;
    }

    public ConstraintLayout b() {
        return this.f14257c;
    }

    public static b a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.intent_list_item, "layout", "intent_list_item"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static b a(View r5) {
        ConstraintLayout r0 = (ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.aiagent.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.text, DbHelper.COL_ID, "text");
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r2), TextView.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        return new b((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.aiagent.plugin"), r0, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r2)));
    }
}
