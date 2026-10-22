package x8;

import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<TextView> f43597a;

    public k(TextView textView) {
        this.f43597a = new WeakReference<>(textView);
    }

    public static void a(Spannable spannable, TextView textView) {
        k[] kVarArr = (k[]) spannable.getSpans(0, spannable.length(), k.class);
        if (kVarArr != null) {
            for (k kVar : kVarArr) {
                spannable.removeSpan(kVar);
            }
        }
        spannable.setSpan(new k(textView), 0, spannable.length(), 18);
    }

    public static TextView c(Spanned spanned) {
        k[] kVarArr = (k[]) spanned.getSpans(0, spanned.length(), k.class);
        if (kVarArr == null || kVarArr.length <= 0) {
            return null;
        }
        return kVarArr[0].b();
    }

    public TextView b() {
        return this.f43597a.get();
    }
}
