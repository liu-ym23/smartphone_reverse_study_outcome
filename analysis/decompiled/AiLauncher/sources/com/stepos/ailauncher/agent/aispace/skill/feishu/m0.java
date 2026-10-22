package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import kotlin.Metadata;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/m0;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class m0 extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(Context context) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void b(m0 m0Var, View view) {
        m0Var.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Y4.o oVarC = Y4.o.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(oVarC, "inflate(...)");
        setContentView(oVarC.b());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            float f10 = window.getContext().getResources().getDisplayMetrics().density;
            int iB = C5227b.b(20.0f * f10);
            int iB2 = C5227b.b(f10 * 356.0f);
            WindowManager windowManager = (WindowManager) window.getContext().getSystemService(WindowManager.class);
            Integer num = null;
            if (windowManager != null && (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) != null && (bounds = currentWindowMetrics.getBounds()) != null) {
                Integer numValueOf = Integer.valueOf(bounds.width());
                if (numValueOf.intValue() > 0) {
                    num = numValueOf;
                }
            }
            window.setLayout(Math.min(iB2, C5685n.f((num != null ? num.intValue() : window.getContext().getResources().getDisplayMetrics().widthPixels) - (iB * 2), 0)), -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1792);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        oVarC.btnLater.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m0.b(this.f24267a, view);
            }
        });
    }
}
