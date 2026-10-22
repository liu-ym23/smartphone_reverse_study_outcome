package com.stepos.ailauncher.task.space;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.ailauncher.task.R$string;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/task/space/f2;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "<init>", "(Landroid/content/Context;Lp9/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lp9/a;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.f2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class DialogC3618f2 extends Dialog {
    private final InterfaceC5063a<Y8.t> onConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC3618f2(Context context, InterfaceC5063a<Y8.t> onConfirm) {
        super(context, R.style.Theme.Translucent.NoTitleBar);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        this.onConfirm = onConfirm;
    }

    public static final void e(DialogC3618f2 dialogC3618f2, View view) {
        dialogC3618f2.dismiss();
    }

    public static final void f(DialogC3618f2 dialogC3618f2, View view) {
        dialogC3618f2.dismiss();
        dialogC3618f2.onConfirm.invoke();
    }

    public static final void g(DialogC3618f2 dialogC3618f2, View view) {
        dialogC3618f2.dismiss();
    }

    public static final void h(View view) {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_confirm, (ViewGroup) null);
        setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_dialog_title);
        textView.setText(R$string.test_space_uninstall_title);
        textView.setTextColor(-1118482);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.tv_dialog_message);
        textView2.setText(R$string.test_space_uninstall_message);
        textView2.setTextColor(1944841205);
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.btn_negative);
        textView3.setText(R$string.test_space_uninstall_cancel);
        textView3.setTextColor(-15375123);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.b2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC3618f2.e(this.f28928a, view);
            }
        });
        TextView textView4 = (TextView) viewInflate.findViewById(R$id.btn_positive);
        textView4.setText(R$string.test_space_uninstall_confirm);
        textView4.setTextColor(-1638388);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.c2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC3618f2.f(this.f28939a, view);
            }
        });
        viewInflate.findViewById(R$id.fl_overlay).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC3618f2.g(this.f29016a, view);
            }
        });
        viewInflate.findViewById(R$id.ll_card).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.e2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DialogC3618f2.h(view);
            }
        });
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -1);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }
}
