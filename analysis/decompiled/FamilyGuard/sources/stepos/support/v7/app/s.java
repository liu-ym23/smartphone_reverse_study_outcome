package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import stepos.support.v7.app.c;

/* loaded from: classes.dex */
public class s extends c {

    public static class a extends c.a {

        /* renamed from: c, reason: collision with root package name */
        private DialogInterface.OnClickListener f21090c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f21091d;

        /* renamed from: stepos.support.v7.app.s$a$a, reason: collision with other inner class name */
        class C0245a implements c.a.b<s> {
            C0245a() {
            }

            @Override // stepos.support.v7.app.c.a.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public s newDialog(Context context, int i5) {
                return new s(context, i5);
            }
        }

        private static class b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            private final DialogInterface.OnClickListener f21093a;

            public b(DialogInterface.OnClickListener onClickListener) {
                this.f21093a = onClickListener;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                DialogInterface.OnClickListener onClickListener = this.f21093a;
                if (onClickListener != null) {
                    onClickListener.onClick(dialogInterface, i5);
                }
                if (dialogInterface != null) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public a(Context context) {
            super(context, X4.k.f6075c);
        }

        @Override // stepos.support.v7.app.c.a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public s c() {
            CharSequence charSequence = this.f21091d;
            if (charSequence == null) {
                o(H1.k.f2345c, new b(this.f21090c));
            } else {
                p(charSequence, new b(this.f21090c));
            }
            return (s) d(new C0245a());
        }

        public a C(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener, boolean z5, ColorStateList[] colorStateListArr) {
            super.l(charSequenceArr, onClickListener, z5, colorStateListArr);
            return this;
        }

        @Override // stepos.support.v7.app.c.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public a o(int i5, DialogInterface.OnClickListener onClickListener) {
            super.o(i5, onClickListener);
            this.f21091d = e().getText(i5);
            this.f21090c = onClickListener;
            return this;
        }

        @Override // stepos.support.v7.app.c.a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public a p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            super.p(charSequence, onClickListener);
            this.f21091d = charSequence;
            this.f21090c = onClickListener;
            return this;
        }

        @Override // stepos.support.v7.app.c.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public a x(int i5) {
            super.x(i5);
            return this;
        }

        @Override // stepos.support.v7.app.c.a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public a y(CharSequence charSequence) {
            super.y(charSequence);
            return this;
        }
    }

    public s(Context context, int i5) {
        super(context, i5);
    }
}
