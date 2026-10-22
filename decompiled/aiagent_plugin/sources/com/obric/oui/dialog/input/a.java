package com.obric.oui.dialog.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InputBodyController.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f35106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppCompatImageView f35107b;

    public final AppCompatImageView a() {
        return this.f35107b;
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(Context r4, FrameLayout r5) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), "context");
        o.e(r5, "parent");
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(-1, -2);
        ViewParent r0 = this.f35106a.getParent();
        if (ZeusTransformUtils.instanceOf(r0, ViewGroup.class) == false) goto L5;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.f35106a);
    L5:
        r5.addView(this.f35106a, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.alert.d
    public void a(OAlertDialog r1) {
        o.e(r1, "dialog");
        r1.setAutoDismiss(false);
    }
}
