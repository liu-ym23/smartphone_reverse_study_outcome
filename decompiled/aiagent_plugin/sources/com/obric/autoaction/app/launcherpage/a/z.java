package com.obric.autoaction.app.launcherpage.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AutoactionInstructionAddBtnBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OIconButton f22879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f22880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FrameLayout f22881c;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private z(FrameLayout r1, OIconButton r2, OButton r3) {
        this.f22881c = r1;
        this.f22879a = r2;
        this.f22880b = r3;
    }

    public FrameLayout b() {
        return this.f22881c;
    }

    public static z a(LayoutInflater r3, ViewGroup r4, boolean r5) {
        View r6 = ZeusTransformUtils.inflate(r3, ZeusTransformUtils.mapRes(R.layout.autoaction_instruction_add_btn, "layout", "autoaction_instruction_add_btn"), r4, false, "com.obric.aiagent.plugin");
        if (r5 == false) goto L6;
        r4.addView(r6);
    L6:
        return a(r6);
    }

    public static z a(View r5) {
        int r0 = ZeusTransformUtils.mapRes(R.id.btn_add, DbHelper.COL_ID, "btn_add");
        OIconButton r2 = (OIconButton) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OIconButton.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L9;
        r0 = ZeusTransformUtils.mapRes(R.id.btn_added, DbHelper.COL_ID, "btn_added");
        OButton r1 = (OButton) ZeusTransformUtils.preCheckCast(r5.findViewById(r0), OButton.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        return new z((FrameLayout) ZeusTransformUtils.preCheckCast(r5, FrameLayout.class, "com.obric.aiagent.plugin"), r2, r1);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getResourceName(r0)));
    }
}
