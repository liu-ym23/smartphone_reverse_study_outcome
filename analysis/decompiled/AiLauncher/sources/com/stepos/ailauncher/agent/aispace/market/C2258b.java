package com.stepos.ailauncher.agent.aispace.market;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.R$color;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "checked", "Lkotlin/Function1;", "LY8/t;", "onToggle", "Landroid/view/View;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;ZLp9/l;)Landroid/view/View;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2258b {
    public static final C2258b INSTANCE = new C2258b();

    public static final void c(InterfaceC5074l interfaceC5074l, boolean z10, View view) {
        interfaceC5074l.invoke(Boolean.valueOf(!z10));
    }

    public final View b(Context context, final boolean checked, final InterfaceC5074l<? super Boolean, Y8.t> onToggle) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onToggle, "onToggle");
        float f10 = context.getResources().getDisplayMetrics().density;
        int i10 = (int) (40 * f10);
        int i11 = (int) (22 * f10);
        int i12 = (int) (14 * f10);
        int i13 = (int) (4 * f10);
        int iC = androidx.core.content.a.c(context, R$color.skill_switch_track_off_value);
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i11);
        layoutParams.gravity = 8388629;
        frameLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i11 / 2.0f);
        if (checked) {
            iC = -1480402;
        }
        gradientDrawable.setColor(iC);
        frameLayout.setBackground(gradientDrawable);
        frameLayout.setClickable(true);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2258b.c(onToggle, checked, view);
            }
        });
        View view = new View(context);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(-1);
        view.setBackground(gradientDrawable2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i12, i12);
        layoutParams2.gravity = (checked ? 8388613 : 8388611) | 16;
        layoutParams2.setMarginStart(i13);
        layoutParams2.setMarginEnd(i13);
        Y8.t tVar = Y8.t.f7040a;
        frameLayout.addView(view, layoutParams2);
        return frameLayout;
    }
}
