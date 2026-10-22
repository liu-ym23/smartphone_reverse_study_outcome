package com.stepos.ailauncher.agent.skill.detail;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$id;
import com.stepos.ailauncher.agent.R$layout;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/agent/skill/detail/B0;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "skillDisplayName", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lp9/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", "Ljava/lang/String;", "Lp9/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B0 extends Dialog {
    private final InterfaceC5063a<Y8.t> onConfirm;
    private final String skillDisplayName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B0(Context context, String skillDisplayName, InterfaceC5063a<Y8.t> onConfirm) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(skillDisplayName, "skillDisplayName");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        this.skillDisplayName = skillDisplayName;
        this.onConfirm = onConfirm;
    }

    public static final void c(B0 b02, View view) {
        b02.dismiss();
    }

    public static final void d(B0 b02, View view) {
        b02.dismiss();
        b02.onConfirm.invoke();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_skill_uninstall, (ViewGroup) null);
        setContentView(viewInflate);
        String string = getContext().getString(R$string.installed_skill_uninstall_confirm_message_with_name, this.skillDisplayName);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        ((TextView) viewInflate.findViewById(R$id.tv_dialog_message)).setText(string);
        ((TextView) viewInflate.findViewById(R$id.btn_dialog_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                B0.c(this.f24412a, view);
            }
        });
        ((TextView) viewInflate.findViewById(R$id.btn_dialog_confirm)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.skill.detail.A0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                B0.d(this.f24337a, view);
            }
        });
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCanceledOnTouchOutside(true);
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
