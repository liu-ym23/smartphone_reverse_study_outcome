package com.stepos.ailauncher.agent.aispace.skill.wecom;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/Y;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Y extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Y(Context context) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void b(Y y10, View view) {
        y10.dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Y4.r rVarC = Y4.r.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(rVarC, "inflate(...)");
        setContentView(rVarC.b());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.addFlags(2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        rVarC.btnOk.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.wecom.X
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Y.b(this.f24304a, view);
            }
        });
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window == null) {
            return;
        }
        int i10 = (int) (18 * getContext().getResources().getDisplayMetrics().density);
        window.setGravity(81);
        window.setLayout(getContext().getResources().getDisplayMetrics().widthPixels - (i10 * 2), -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = i10;
        window.setAttributes(attributes);
    }
}
