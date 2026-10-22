package E;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f1218a;

    /* renamed from: b, reason: collision with root package name */
    private final c f1219b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1220c;

    public a(int i5, c cVar, int i6) {
        this.f1218a = i5;
        this.f1219b = cVar;
        this.f1220c = i6;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1218a);
        this.f1219b.V(this.f1220c, bundle);
    }
}
