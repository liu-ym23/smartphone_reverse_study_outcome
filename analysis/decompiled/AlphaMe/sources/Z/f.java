package Z;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class f implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2134a;

    /* renamed from: b, reason: collision with root package name */
    public e f2135b;

    public f(TextView textView) {
        this.f2134a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i4, int i5, Spanned spanned, int i6, int i7) {
        TextView textView = this.f2134a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = X.j.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i7 == 0 && i6 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i4 != 0 || i5 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i4, i5);
                }
                return X.j.a().f(0, charSequence.length(), charSequence);
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        X.j jVarA = X.j.a();
        if (this.f2135b == null) {
            this.f2135b = new e(textView, this);
        }
        jVarA.g(this.f2135b);
        return charSequence;
    }
}
