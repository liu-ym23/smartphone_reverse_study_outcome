package com.bytedance.applet.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes14.dex */
public final class LarusDoubaoBottomSheetDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f191535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SimpleDraweeView f191536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f191537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f191538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UrlSpanTextView f191539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f191540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FrameLayout f191541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NestedScrollView f191542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f191543i;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f191535a;
    }

    public LarusDoubaoBottomSheetDialogBinding(ConstraintLayout r100, SimpleDraweeView r101, TextView r102, LinearLayout r103, UrlSpanTextView r104, View r105, FrameLayout r106, NestedScrollView r107, TextView r108) {
        this.f191535a = r100;
        this.f191536b = r101;
        this.f191537c = r102;
        this.f191538d = r103;
        this.f191539e = r104;
        this.f191540f = r105;
        this.f191541g = r106;
        this.f191542h = r107;
        this.f191543i = r108;
    }
}
