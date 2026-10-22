package Q0;

import android.os.Handler;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5397a;

    /* renamed from: b, reason: collision with root package name */
    public c.f f5398b;

    public static class a extends c.f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Reference<TextView> f5399a;

        /* renamed from: b, reason: collision with root package name */
        public final Reference<d> f5400b;

        public a(TextView textView, d dVar) {
            this.f5399a = new WeakReference(textView);
            this.f5400b = new WeakReference(dVar);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            Handler handler;
            super.b();
            TextView textView = this.f5399a.get();
            if (textView == null || (handler = textView.getHandler()) == null) {
                return;
            }
            handler.post(this);
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            CharSequence text;
            CharSequence charSequenceP;
            TextView textView = this.f5399a.get();
            if (c(textView, this.f5400b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = androidx.emoji2.text.c.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }
    }

    public d(TextView textView) {
        this.f5397a = textView;
    }

    public static void b(Spannable spannable, int i10, int i11) {
        if (i10 >= 0 && i11 >= 0) {
            Selection.setSelection(spannable, i10, i11);
        } else if (i10 >= 0) {
            Selection.setSelection(spannable, i10);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        }
    }

    public c.f a() {
        if (this.f5398b == null) {
            this.f5398b = new a(this.f5397a, this);
        }
        return this.f5398b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r0 != 3) goto L27;
     */
    @Override // android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence filter(java.lang.CharSequence r3, int r4, int r5, android.text.Spanned r6, int r7, int r8) {
        /*
            r2 = this;
            android.widget.TextView r0 = r2.f5397a
            boolean r0 = r0.isInEditMode()
            if (r0 == 0) goto L9
            goto L4a
        L9:
            androidx.emoji2.text.c r0 = androidx.emoji2.text.c.c()
            int r0 = r0.e()
            if (r0 == 0) goto L4b
            r1 = 1
            if (r0 == r1) goto L1a
            r4 = 3
            if (r0 == r4) goto L4b
            goto L4a
        L1a:
            if (r8 != 0) goto L2d
            if (r7 != 0) goto L2d
            int r6 = r6.length()
            if (r6 != 0) goto L2d
            android.widget.TextView r2 = r2.f5397a
            java.lang.CharSequence r2 = r2.getText()
            if (r3 != r2) goto L2d
            return r3
        L2d:
            if (r3 == 0) goto L4a
            if (r4 != 0) goto L38
            int r2 = r3.length()
            if (r5 != r2) goto L38
            goto L3c
        L38:
            java.lang.CharSequence r3 = r3.subSequence(r4, r5)
        L3c:
            androidx.emoji2.text.c r2 = androidx.emoji2.text.c.c()
            r4 = 0
            int r5 = r3.length()
            java.lang.CharSequence r2 = r2.q(r3, r4, r5)
            return r2
        L4a:
            return r3
        L4b:
            androidx.emoji2.text.c r4 = androidx.emoji2.text.c.c()
            androidx.emoji2.text.c$f r2 = r2.a()
            r4.t(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: Q0.d.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
