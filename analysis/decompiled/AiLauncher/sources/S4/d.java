package S4;

import Y8.t;
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
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0015R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016¨\u0006\u0017"}, d2 = {"LS4/d;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "", "title", "message", "cancelText", "confirmText", "Lkotlin/Function0;", "LY8/t;", "onCancel", "onConfirm", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lp9/a;Lp9/a;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", UxipConstants.f30640D, "()V", "Ljava/lang/String;", "Lp9/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends Dialog {
    private final String cancelText;
    private final String confirmText;
    private final String message;
    private final InterfaceC5063a<t> onCancel;
    private final InterfaceC5063a<t> onConfirm;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String title, String message, String cancelText, String confirmText, InterfaceC5063a<t> onCancel, InterfaceC5063a<t> onConfirm) {
        super(context);
        p.i(context, "context");
        p.i(title, "title");
        p.i(message, "message");
        p.i(cancelText, "cancelText");
        p.i(confirmText, "confirmText");
        p.i(onCancel, "onCancel");
        p.i(onConfirm, "onConfirm");
        this.title = title;
        this.message = message;
        this.cancelText = cancelText;
        this.confirmText = confirmText;
        this.onCancel = onCancel;
        this.onConfirm = onConfirm;
    }

    public static final t d() {
        return t.f7040a;
    }

    public static final void e(d dVar, View view) {
        dVar.dismiss();
        dVar.onCancel.invoke();
    }

    public static final void f(d dVar, View view) {
        dVar.dismiss();
        dVar.onConfirm.invoke();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.dialog_skill_uninstall, (ViewGroup) null);
        setContentView(viewInflate);
        ((TextView) viewInflate.findViewById(R$id.tv_dialog_title)).setText(this.title);
        ((TextView) viewInflate.findViewById(R$id.tv_dialog_message)).setText(this.message);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_dialog_cancel);
        textView.setText(this.cancelText);
        textView.setOnClickListener(new View.OnClickListener() { // from class: S4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.e(this.f5642a, view);
            }
        });
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_dialog_confirm);
        textView2.setText(this.confirmText);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: S4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.f(this.f5643a, view);
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
        if (attributes != null) {
            attributes.y = i10;
        } else {
            attributes = null;
        }
        window.setAttributes(attributes);
    }

    public /* synthetic */ d(Context context, String str, String str2, String str3, String str4, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i10, i iVar) {
        this(context, str, str2, str3, str4, (i10 & 32) != 0 ? new InterfaceC5063a() { // from class: S4.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return d.d();
            }
        } : interfaceC5063a, interfaceC5063a2);
    }
}
