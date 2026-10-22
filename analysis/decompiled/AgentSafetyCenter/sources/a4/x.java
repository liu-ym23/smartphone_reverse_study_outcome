package a4;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x implements TextWatcher, SpanWatcher {

    /* renamed from: c, reason: collision with root package name */
    public Object f212c;

    /* renamed from: f, reason: collision with root package name */
    public AtomicInteger f213f;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f212c).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i3, int i10) {
        ((TextWatcher) this.f212c).beforeTextChanged(charSequence, i, i3, i10);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i, int i3) {
        if (this.f213f.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f212c).onSpanAdded(spannable, obj, i, i3);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i, int i3, int i10, int i11) {
        if (this.f213f.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f212c).onSpanChanged(spannable, obj, i, i3, i10, i11);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i, int i3) {
        if (this.f213f.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f212c).onSpanRemoved(spannable, obj, i, i3);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i3, int i10) {
        ((TextWatcher) this.f212c).onTextChanged(charSequence, i, i3, i10);
    }
}
