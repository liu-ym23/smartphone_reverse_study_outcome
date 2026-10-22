package N8;

import android.text.Spannable;
import android.text.SpannableString;

/* loaded from: classes4.dex */
public class d extends Spannable.Factory {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f4890a = new d();
    }

    public static d a() {
        return a.f4890a;
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        return charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
    }
}
