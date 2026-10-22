package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x implements TextWatcher, SpanWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Object f646a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f647b = new AtomicInteger(0);

    public x(Object obj) {
        this.f646a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f646a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        ((TextWatcher) this.f646a).beforeTextChanged(charSequence, i8, i9, i10);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i8, int i9) {
        if (this.f647b.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f646a).onSpanAdded(spannable, obj, i8, i9);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i8, int i9, int i10, int i11) {
        if (this.f647b.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f646a).onSpanChanged(spannable, obj, i8, i9, i10, i11);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i8, int i9) {
        if (this.f647b.get() <= 0 || !(obj instanceof a0)) {
            ((SpanWatcher) this.f646a).onSpanRemoved(spannable, obj, i8, i9);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        ((TextWatcher) this.f646a).onTextChanged(charSequence, i8, i9, i10);
    }
}
