package com.stepos.ailauncher.agent.aispace.skill.feishu;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/l;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "title", "description", "cancelText", "confirmText", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Ljava/lang/String;", "Lp9/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class DialogC2316l extends Dialog {
    private final String cancelText;
    private final String confirmText;
    private final String description;
    private final InterfaceC5063a<Y8.t> onConfirm;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2316l(Context context, String title, String description, String cancelText, String confirmText, InterfaceC5063a<Y8.t> onConfirm) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(description, "description");
        kotlin.jvm.internal.p.i(cancelText, "cancelText");
        kotlin.jvm.internal.p.i(confirmText, "confirmText");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        this.title = title;
        this.description = description;
        this.cancelText = cancelText;
        this.confirmText = confirmText;
        this.onConfirm = onConfirm;
    }

    public static final void e(DialogC2316l dialogC2316l, View view) {
        dialogC2316l.dismiss();
    }

    public static final void f(View view) {
    }

    public static final void g(DialogC2316l dialogC2316l, View view) {
        dialogC2316l.dismiss();
    }

    public static final void h(DialogC2316l dialogC2316l, View view) {
        dialogC2316l.dismiss();
        dialogC2316l.onConfirm.invoke();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Y4.n nVarC = Y4.n.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(nVarC, "inflate(...)");
        setContentView(nVarC.b());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        nVarC.tvTitle.setText(this.title);
        nVarC.tvDesc.setText(this.description);
        nVarC.btnLater.setText(this.cancelText);
        nVarC.btnTryNow.setText(this.confirmText);
        nVarC.flOverlay.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC2316l.e(this.f24262a, view);
            }
        });
        nVarC.llCard.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC2316l.f(view);
            }
        });
        nVarC.btnLater.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC2316l.g(this.f24263a, view);
            }
        });
        nVarC.btnTryNow.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.skill.feishu.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC2316l.h(this.f24265a, view);
            }
        });
    }
}
