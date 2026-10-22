package p3;

import android.content.Context;
import android.content.DialogInterface;
import p3.j;
import p3.w;

/* loaded from: classes.dex */
public class w extends j {

    public static class a extends j.a {

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f19607c;

        /* renamed from: d, reason: collision with root package name */
        private DialogInterface.OnClickListener f19608d;

        /* renamed from: p3.w$a$a, reason: collision with other inner class name */
        private static final class DialogInterfaceOnClickListenerC0233a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private final DialogInterface.OnClickListener f19609a;

            public DialogInterfaceOnClickListenerC0233a(DialogInterface.OnClickListener onClickListener) {
                this.f19609a = onClickListener;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                DialogInterface.OnClickListener onClickListener = this.f19609a;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i5);
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context, 0, 2, null);
            j4.k.g(context, "context");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final w l(Context context, int i5) {
            j4.k.g(context, "context");
            return new w(context, i5);
        }

        @Override // p3.j.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public w b() {
            CharSequence text = this.f19607c;
            if (text == null) {
                text = e().getText(l3.k.f18469a);
                j4.k.f(text, "getText(...)");
            }
            super.f(text, new DialogInterfaceOnClickListenerC0233a(this.f19608d));
            return (w) c(new j.a.InterfaceC0232a() { // from class: p3.v
                @Override // p3.j.a.InterfaceC0232a
                public final j newDialog(Context context, int i5) {
                    return w.a.l(context, i5);
                }
            });
        }

        @Override // p3.j.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a h(int i5) {
            super.h(i5);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected w(Context context, int i5) {
        super(context, i5);
        j4.k.g(context, "context");
    }
}
