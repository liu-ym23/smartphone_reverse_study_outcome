package com.obric.autoaction.b;

import android.view.View;
import android.widget.EditText;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OIconButton;
import com.obric.oui.layout.OUIConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EdittextWithSendButtonBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements androidx.viewbinding.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OUIConstraintLayout f24594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f24595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OIconButton f24596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final OUIConstraintLayout f24597d;

    @Override // androidx.viewbinding.a
    public /* synthetic */ View a() {
        return b();
    }

    private c(OUIConstraintLayout r1, OUIConstraintLayout r2, EditText r3, OIconButton r4) {
        this.f24597d = r1;
        this.f24594a = r2;
        this.f24595b = r3;
        this.f24596c = r4;
    }

    public OUIConstraintLayout b() {
        return this.f24597d;
    }

    public static c a(View r6) {
        OUIConstraintLayout r0 = (OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r6, OUIConstraintLayout.class, "com.obric.aiagent.plugin");
        int r2 = ZeusTransformUtils.mapRes(R.id.input_text, DbHelper.COL_ID, "input_text");
        EditText r4 = (EditText) ZeusTransformUtils.preCheckCast(r6.findViewById(r2), EditText.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L9;
        r2 = ZeusTransformUtils.mapRes(R.id.send_button, DbHelper.COL_ID, "send_button");
        OIconButton r3 = (OIconButton) ZeusTransformUtils.preCheckCast(r6.findViewById(r2), OIconButton.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        return new c((OUIConstraintLayout) ZeusTransformUtils.preCheckCast(r6, OUIConstraintLayout.class, "com.obric.aiagent.plugin"), r0, r4, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getResourceName(r2)));
    }
}
