package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public abstract class d {

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f34280a;

        public a(TextView textView) {
            this.f34280a = textView;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            d.c(this.f34280a);
            view.removeOnAttachStateChangeListener(this);
            view.setTag(io.noties.markwon.R$id.markwon_drawables_scheduler, null);
        }
    }

    public static class b implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f34281a;

        /* renamed from: b, reason: collision with root package name */
        public final InterfaceC0419b f34282b;

        /* renamed from: c, reason: collision with root package name */
        public Rect f34283c;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Drawable f34284a;

            public a(Drawable drawable) {
                this.f34284a = drawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.invalidateDrawable(this.f34284a);
            }
        }

        /* renamed from: io.noties.markwon.image.d$b$b, reason: collision with other inner class name */
        public interface InterfaceC0419b {
            void invalidate();
        }

        public b(TextView textView, InterfaceC0419b interfaceC0419b, Rect rect) {
            this.f34281a = textView;
            this.f34282b = interfaceC0419b;
            this.f34283c = new Rect(rect);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f34281a.post(new a(drawable));
                return;
            }
            Rect bounds = drawable.getBounds();
            if (this.f34283c.equals(bounds)) {
                this.f34281a.postInvalidate();
            } else {
                this.f34282b.invalidate();
                this.f34283c = new Rect(bounds);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            this.f34281a.postDelayed(runnable, j10 - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f34281a.removeCallbacks(runnable);
        }
    }

    public static class c implements b.InterfaceC0419b, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f34286a;

        public c(TextView textView) {
            this.f34286a = textView;
        }

        @Override // io.noties.markwon.image.d.b.InterfaceC0419b
        public void invalidate() {
            this.f34286a.removeCallbacks(this);
            this.f34286a.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = this.f34286a;
            textView.setText(textView.getText());
        }
    }

    public static e[] a(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return null;
        }
        return (e[]) ((Spanned) text).getSpans(0, length, e.class);
    }

    public static void b(TextView textView) {
        int i10 = io.noties.markwon.R$id.markwon_drawables_scheduler_last_text_hashcode;
        Integer num = (Integer) textView.getTag(i10);
        int iHashCode = textView.getText().hashCode();
        if (num == null || num.intValue() != iHashCode) {
            textView.setTag(i10, Integer.valueOf(iHashCode));
            e[] eVarArrA = a(textView);
            if (eVarArrA == null || eVarArrA.length <= 0) {
                return;
            }
            int i11 = io.noties.markwon.R$id.markwon_drawables_scheduler;
            if (textView.getTag(i11) == null) {
                a aVar = new a(textView);
                textView.addOnAttachStateChangeListener(aVar);
                textView.setTag(i11, aVar);
            }
            c cVar = new c(textView);
            for (e eVar : eVarArrA) {
                io.noties.markwon.image.a aVarA = eVar.a();
                aVarA.n(new b(textView, cVar, aVarA.getBounds()));
            }
        }
    }

    public static void c(TextView textView) {
        int i10 = io.noties.markwon.R$id.markwon_drawables_scheduler_last_text_hashcode;
        if (textView.getTag(i10) == null) {
            return;
        }
        textView.setTag(i10, null);
        e[] eVarArrA = a(textView);
        if (eVarArrA == null || eVarArrA.length <= 0) {
            return;
        }
        for (e eVar : eVarArrA) {
            eVar.a().n(null);
        }
    }
}
