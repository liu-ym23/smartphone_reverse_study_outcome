package com.obric.autoaction.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InputWithPrefixEdittextBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EditText f24613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f24614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConstraintLayout f24615c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private g(ConstraintLayout r1, EditText r2, TextView r3) {
        this.f24615c = r1;
        this.f24613a = r2;
        this.f24614b = r3;
    }

    public ConstraintLayout b() {
        return this.f24615c;
    }

    public static g a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.input_with_prefix_edittext, "layout", "input_with_prefix_edittext"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static g a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.edit, DbHelper.COL_ID, "edit");
        EditText r2 = (EditText) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), EditText.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.hint, DbHelper.COL_ID, "hint");
        TextView r1 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), TextView.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new g((ConstraintLayout) ZeusTransformUtils.preCheckCast(r5, ConstraintLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
