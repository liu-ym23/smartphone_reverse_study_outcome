package A8;

import A8.b;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import io.noties.markwon.ext.tables.R$id;

/* loaded from: classes4.dex */
public abstract class c {

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f1270a;

        public a(TextView textView) {
            this.f1270a = textView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            c.c(this.f1270a);
            this.f1270a.removeOnAttachStateChangeListener(this);
            this.f1270a.setTag(R$id.markwon_tables_scheduler, null);
        }
    }

    public class b implements b.e {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f1271a = new a();

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f1272b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TextView textView = b.this.f1272b;
                textView.setText(textView.getText());
            }
        }

        public b(TextView textView) {
            this.f1272b = textView;
        }

        @Override // A8.b.e
        public void invalidate() {
            this.f1272b.removeCallbacks(this.f1271a);
            this.f1272b.post(this.f1271a);
        }
    }

    public static Object[] a(TextView textView) {
        CharSequence text = textView.getText();
        if (TextUtils.isEmpty(text) || !(text instanceof Spanned)) {
            return null;
        }
        return ((Spanned) text).getSpans(0, text.length(), A8.b.class);
    }

    public static void b(TextView textView) {
        Object[] objArrA = a(textView);
        if (objArrA == null || objArrA.length <= 0) {
            return;
        }
        int i10 = R$id.markwon_tables_scheduler;
        if (textView.getTag(i10) == null) {
            a aVar = new a(textView);
            textView.addOnAttachStateChangeListener(aVar);
            textView.setTag(i10, aVar);
        }
        b bVar = new b(textView);
        for (Object obj : objArrA) {
            ((A8.b) obj).f(bVar);
        }
    }

    public static void c(TextView textView) {
        Object[] objArrA = a(textView);
        if (objArrA == null || objArrA.length <= 0) {
            return;
        }
        for (Object obj : objArrA) {
            ((A8.b) obj).f(null);
        }
    }
}
