package R;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f4945a;

    /* renamed from: b, reason: collision with root package name */
    private e.f f4946b;

    private static class a extends e.f {

        /* renamed from: a, reason: collision with root package name */
        private final Reference<TextView> f4947a;

        /* renamed from: b, reason: collision with root package name */
        private final Reference<d> f4948b;

        a(TextView textView, d dVar) {
            this.f4947a = new WeakReference(textView);
            this.f4948b = new WeakReference(dVar);
        }

        private boolean c(TextView textView, InputFilter inputFilter) {
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

        @Override // androidx.emoji2.text.e.f
        public void b() {
            CharSequence text;
            CharSequence charSequenceP;
            super.b();
            TextView textView = this.f4947a.get();
            if (c(textView, this.f4948b.get()) && textView.isAttachedToWindow() && text != (charSequenceP = androidx.emoji2.text.e.c().p((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceP);
                int selectionEnd = Selection.getSelectionEnd(charSequenceP);
                textView.setText(charSequenceP);
                if (charSequenceP instanceof Spannable) {
                    d.b((Spannable) charSequenceP, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(TextView textView) {
        this.f4945a = textView;
    }

    private e.f a() {
        if (this.f4946b == null) {
            this.f4946b = new a(this.f4945a, this);
        }
        return this.f4946b;
    }

    static void b(Spannable spannable, int i5, int i6) {
        if (i5 >= 0 && i6 >= 0) {
            Selection.setSelection(spannable, i5, i6);
        } else if (i5 >= 0) {
            Selection.setSelection(spannable, i5);
        } else if (i6 >= 0) {
            Selection.setSelection(spannable, i6);
        }
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
            android.widget.TextView r0 = r2.f4945a
            boolean r0 = r0.isInEditMode()
            if (r0 == 0) goto L9
            goto L4a
        L9:
            androidx.emoji2.text.e r0 = androidx.emoji2.text.e.c()
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
            android.widget.TextView r2 = r2.f4945a
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
            androidx.emoji2.text.e r2 = androidx.emoji2.text.e.c()
            r4 = 0
            int r5 = r3.length()
            java.lang.CharSequence r2 = r2.q(r3, r4, r5)
            return r2
        L4a:
            return r3
        L4b:
            androidx.emoji2.text.e r4 = androidx.emoji2.text.e.c()
            androidx.emoji2.text.e$f r2 = r2.a()
            r4.t(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: R.d.filter(java.lang.CharSequence, int, int, android.text.Spanned, int, int):java.lang.CharSequence");
    }
}
