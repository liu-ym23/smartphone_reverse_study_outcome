package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.applet.block.permissionapplycard.view.PermissionApplyCardView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundTextView;

/* JADX INFO: loaded from: classes14.dex */
public final class LarusPermissionApplyCardViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f191556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundTextView f191557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoundTextView f191558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f191559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDraweeView f191560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ProgressBar f191561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProgressBar f191562g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f191563h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f191564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f191565j;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f191556a;
    }

    public LarusPermissionApplyCardViewBinding(PermissionApplyCardView r100, RoundTextView r101, RoundTextView r102, View r103, SimpleDraweeView r104, ProgressBar r105, ProgressBar r106, TextView r107, TextView r108, TextView r110) {
        this.f191556a = r100;
        this.f191557b = r101;
        this.f191558c = r102;
        this.f191559d = r103;
        this.f191560e = r104;
        this.f191561f = r105;
        this.f191562g = r106;
        this.f191563h = r107;
        this.f191564i = r108;
        this.f191565j = r110;
    }
}
