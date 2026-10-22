package C0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f1622a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1623b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1624c;

    public a(int i10, c cVar, int i11) {
        this.f1622a = i10;
        this.f1623b = cVar;
        this.f1624c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1622a);
        this.f1623b.d0(this.f1624c, bundle);
    }
}
