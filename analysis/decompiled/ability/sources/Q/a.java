package Q;

import A2.f;
import A6.g;
import A6.n;
import B1.b;
import F9.P;
import android.animation.ValueAnimator;
import android.view.ContextThemeWrapper;
import android.view.Window;
import android.widget.TextView;
import com.stepos.ability.R;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Supplier;
import kotlin.jvm.internal.k;
import qa.InterfaceC1859k;
import stepos.support.v7.app.C;
import u3.i;

/* loaded from: classes2.dex */
public final class a implements f, InterfaceC1859k, C {
    public static volatile a c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1094a;
    public Object b;

    public /* synthetic */ a(int i) {
        this.f1094a = i;
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                try {
                    if (c == null) {
                        a aVar = new a(0);
                        b bVar = new b(4, (byte) 0);
                        bVar.c = new LinkedList();
                        bVar.b = 20;
                        aVar.b = bVar;
                        c = aVar;
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void b(String str, String str2) {
        if (str.isEmpty() || str2 == null) {
            return;
        }
        ((HashMap) this.b).put(str, str2);
    }

    public g c() {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        n nVar = (n) this.b;
        ContextThemeWrapper contextThemeWrapper = nVar.f153a;
        boolean z10 = nVar.f154j;
        g gVar = new g(contextThemeWrapper);
        A6.f controller = gVar.f146a;
        k.f(controller, "controller");
        Window window = controller.c;
        int i = nVar.c;
        if (i <= 0) {
            throw new IllegalArgumentException(B7.a.h(i, "titleMaxLines must be > 0 but was ").toString());
        }
        if (controller.f119G != i) {
            controller.f119G = i;
            TextView textView = controller.p;
            if (textView != null) {
                textView.setMaxLines(i);
            }
        }
        int i6 = nVar.e;
        if (i6 <= 0) {
            throw new IllegalArgumentException(B7.a.h(i6, "messageMaxLines must be > 0 but was ").toString());
        }
        if (controller.f120H != i6) {
            controller.f120H = i6;
            TextView textView2 = controller.f138q;
            if (textView2 != null) {
                textView2.setMaxLines(i6);
            }
        }
        CharSequence charSequence = nVar.b;
        if (charSequence != null) {
            controller.k = charSequence;
            TextView textView3 = controller.p;
            if (textView3 != null) {
                textView3.setText(charSequence);
            }
            controller.e();
        }
        controller.e();
        CharSequence charSequence2 = nVar.d;
        if (charSequence2 != null) {
            controller.l = charSequence2;
            controller.e();
        }
        CharSequence charSequence3 = nVar.f;
        if (charSequence3 != null) {
            controller.h(-1, charSequence3, nVar.g);
        }
        CharSequence charSequence4 = nVar.h;
        if (charSequence4 != null) {
            controller.h(-2, charSequence4, nVar.i);
        }
        int i10 = nVar.n;
        if (i10 < 0 || i10 >= 3) {
            throw new IllegalArgumentException(B7.a.h(i10, "buttonLayout must be AUTO, HORIZONTAL or VERTICAL but was ").toString());
        }
        controller.f121I = i10;
        controller.d();
        boolean z11 = nVar.o;
        controller.f122J = z11;
        StepOSAlertDialogLayout stepOSAlertDialogLayout2 = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel);
        if (stepOSAlertDialogLayout2 != null) {
            stepOSAlertDialogLayout2.setGlassEnabled(z11);
        }
        controller.f116C = 0;
        if (controller.n && (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) window.findViewById(R.id.stepos_dialog_parent_panel)) != null) {
            stepOSAlertDialogLayout.setMaxHeight(controller.b());
        }
        int i11 = nVar.k;
        int i12 = nVar.l;
        if (i11 != 0 && i11 != -1 && i11 != -2 && i11 != -3) {
            throw new IllegalArgumentException(B7.a.h(i11, "whichButton must be 0 or one of DialogInterface.BUTTON_* but was ").toString());
        }
        if (i12 < 0 || i12 >= 4) {
            throw new IllegalArgumentException(B7.a.h(i12, "color must be one of StepOSAlertDialog.COLOR_NORMAL / COLOR_BLUE / COLOR_RED / COLOR_POLESTAR but was ").toString());
        }
        controller.f117D = i11;
        controller.E = i12;
        controller.d();
        controller.f118F = nVar.m;
        gVar.setCancelable(z10);
        if (z10) {
            gVar.setCanceledOnTouchOutside(true);
        }
        gVar.setOnCancelListener(null);
        gVar.setOnDismissListener(null);
        return gVar;
    }

    @Override // qa.InterfaceC1859k
    public Object convert(Object obj) {
        return Optional.ofNullable(((InterfaceC1859k) this.b).convert((P) obj));
    }

    public i d() {
        return (i) ((Supplier) this.b).get();
    }

    @Override // A2.f
    public n2.a e(int i, n2.a aVar) {
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x027e A[Catch: all -> 0x032a, TRY_LEAVE, TryCatch #7 {all -> 0x032a, blocks: (B:73:0x01ab, B:93:0x0278, B:95:0x027e), top: B:123:0x0017 }] */
    @Override // A2.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n2.a f(int r17, n2.a r18) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.a.f(int, n2.a):n2.a");
    }

    public String toString() {
        switch (this.f1094a) {
            case 5:
                return "PreSignedPolicyJson{conditions=" + ((ArrayList) this.b) + '}';
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, int i) {
        this.f1094a = i;
        this.b = obj;
    }

    public a() {
        this.f1094a = 12;
        this.b = new ValueAnimator();
    }

    public a(ContextThemeWrapper contextThemeWrapper) {
        this.f1094a = 1;
        int i = g.b;
        this.b = new n(new ContextThemeWrapper(contextThemeWrapper, R.style.Theme_VoiceWakeup_Dialog_Confirmation));
    }
}
