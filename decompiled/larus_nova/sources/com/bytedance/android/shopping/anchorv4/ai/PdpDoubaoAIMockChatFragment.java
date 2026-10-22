package com.bytedance.android.shopping.anchorv4.ai;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/ai/PdpDoubaoAIMockChatFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpDoubaoAIMockChatFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0 f165636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f165637e;

    public PdpDoubaoAIMockChatFragment() {
        this.f165636d = new t0();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setClipChildren(false);
        r103.setClipToPadding(false);
        View r104 = new View(r100.getContext());
        r104.setVisibility(8);
        r104.setBackgroundColor(1711276032);
        r103.addView(r104, new FrameLayout.LayoutParams(-1, -1));
        Unit r105 = Unit.INSTANCE;
        this.f165637e = r104;
        TextView r106 = new TextView(r100.getContext());
        r106.setText("豆包 AI 输入框 Mock（点击展开）");
        r106.setTextSize(14.0f);
        r106.setTextColor(-1);
        r106.setGravity(17);
        GradientDrawable r107 = new GradientDrawable();
        r107.setColor((int) 3424789026L);
        r107.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(16));
        r106.setBackground(r107);
        r103.addView(r106, new FrameLayout.LayoutParams(-1, com.bytedance.android.shopping.extensions.b.b(64), 80));
        t0 r108 = this.f165636d;
        View r109 = this.f165637e;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "rootView");
        StringBuilder r110 = new StringBuilder("bindFragmentView called, rootView=");
        r110.append(r103.getClass().getSimpleName());
        r110.append(", overlayView=");
        if (r109 == null) goto L5;
        String r111 = r109.getClass().getSimpleName();
    L6:
        r110.append(r111);
        r110.append(", inputView=");
        r110.append(r106.getClass().getSimpleName());
        s0.a(r110.toString());
        r108.f165686c = r103;
        r108.f165687d = r109;
        r108.f165688e = r106;
        if (r109 == null) goto L9;
        r109.setOnClickListener(new v0(r108));
    L9:
        r106.setOnClickListener(new w0(r108));
        r108.g(MockAIChatWindowState.COLLAPSED);
        return r103;
    L5:
        r111 = null;
        goto L6
    }
}
