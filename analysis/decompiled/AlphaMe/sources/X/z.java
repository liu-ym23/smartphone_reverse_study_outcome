package X;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class z implements TextWatcher, SpanWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2105a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f2106b = new AtomicInteger(0);

    public z(Object obj) {
        this.f2105a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f2105a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        ((TextWatcher) this.f2105a).beforeTextChanged(charSequence, i4, i5, i6);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i4, int i5) {
        if (this.f2106b.get() <= 0 || !(obj instanceof C)) {
            ((SpanWatcher) this.f2105a).onSpanAdded(spannable, obj, i4, i5);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i4, int i5, int i6, int i7) {
        if (this.f2106b.get() <= 0 || !(obj instanceof C)) {
            ((SpanWatcher) this.f2105a).onSpanChanged(spannable, obj, i4, i5, i6, i7);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i4, int i5) {
        if (this.f2106b.get() <= 0 || !(obj instanceof C)) {
            ((SpanWatcher) this.f2105a).onSpanRemoved(spannable, obj, i4, i5);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        ((TextWatcher) this.f2105a).onTextChanged(charSequence, i4, i5, i6);
    }
}
