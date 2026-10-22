package com.stepos.ailauncher.agent.skill.detail;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.a0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/p0;", "Lcom/google/android/material/bottomsheet/a;", "Landroid/content/Context;", "context", "Lu8/e;", "markwon", "", "markdown", "<init>", "(Landroid/content/Context;Lu8/e;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Lu8/e;", "Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p0 extends com.google.android.material.bottomsheet.a {
    private final String markdown;
    private final u8.e markwon;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/agent/skill/detail/p0$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements View.OnAttachStateChangeListener {
        final /* synthetic */ int $gap16$inlined;
        final /* synthetic */ View $this_doOnAttach;
        final /* synthetic */ View $topSpacer$inlined;

        public a(View view, View view2, int i10) {
            this.$this_doOnAttach = view;
            this.$topSpacer$inlined = view2;
            this.$gap16$inlined = i10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            int i10 = rootWindowInsets != null ? androidx.core.view.a0.z(rootWindowInsets, view).f(a0.o.f()).f41978b : 0;
            View view2 = this.$topSpacer$inlined;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = i10 + this.$gap16$inlined;
            view2.setLayoutParams(layoutParams);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(Context context, u8.e markwon, String markdown) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(markwon, "markwon");
        kotlin.jvm.internal.p.i(markdown, "markdown");
        this.markwon = markwon;
        this.markdown = markdown;
    }

    public static final void w(p0 p0Var, View view) {
        p0Var.dismiss();
    }

    public static final void x(p0 p0Var, View view) {
        p0Var.dismiss();
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.k, b.v, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.sheet_skill_readme, (ViewGroup) null);
        setContentView(viewInflate);
        this.markwon.f((TextView) viewInflate.findViewById(R$id.tv_readme_full), this.markdown);
        ((ImageView) viewInflate.findViewById(R$id.btn_readme_close)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p0.w(this.f24388a, view);
            }
        });
        View viewFindViewById = viewInflate.findViewById(R$id.v_readme_top_spacer);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p0.x(this.f24390a, view);
            }
        });
        int i10 = (int) (16 * getContext().getResources().getDisplayMetrics().density);
        kotlin.jvm.internal.p.f(viewInflate);
        if (viewInflate.isAttachedToWindow()) {
            WindowInsets rootWindowInsets = viewInflate.getRootWindowInsets();
            int i11 = rootWindowInsets != null ? androidx.core.view.a0.z(rootWindowInsets, viewInflate).f(a0.o.f()).f41978b : 0;
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            layoutParams.height = i11 + i10;
            viewFindViewById.setLayoutParams(layoutParams);
        } else {
            viewInflate.addOnAttachStateChangeListener(new a(viewInflate, viewFindViewById, i10));
        }
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        ViewParent parent = viewInflate.getParent();
        kotlin.jvm.internal.p.g(parent, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) parent;
        frameLayout.setBackgroundColor(0);
        ViewGroup.LayoutParams layoutParams2 = frameLayout.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams.width = -1;
        marginLayoutParams.height = -1;
        marginLayoutParams.leftMargin = 0;
        marginLayoutParams.rightMargin = 0;
        frameLayout.setLayoutParams(marginLayoutParams);
        frameLayout.setBackground(null);
        BottomSheetBehavior bottomSheetBehaviorO = BottomSheetBehavior.O(frameLayout);
        bottomSheetBehaviorO.x0(3);
        bottomSheetBehaviorO.s0(marginLayoutParams.height);
        bottomSheetBehaviorO.w0(true);
        bottomSheetBehaviorO.j0(true);
    }
}
